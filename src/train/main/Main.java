package train.main;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * 在 main 方法中输出 FreeMarker 合成后的 HTML 页面
 */
public class Main {

	/**
	 * 初始化实例
	 */
	private Configuration cfg = null;
	
	/**
	 * Configuration实例的职责：
	 * 1，加载模板的路径
	 * 2，生产模板的实例
	 * 
	 * @throws IOException
	 */
	private void init() throws IOException {
		cfg = new Configuration();
		
		// 设置模板加载的目录
		cfg.setDirectoryForTemplateLoading(new File("/root/Desktop"));
	}
	
	/**
	 * 设置数据模型，一般是 Map对象
	 * 
	 * @throws TemplateException
	 * @throws IOException
	 */
	private void process() throws IOException, TemplateException {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "FreeMarker模板");
		map.put("time", new Date());
		
		// 使用Configuration实例加载指定的模板文件
		Template template = cfg.getTemplate("test.ftl");
		
		// 输出到控制台
		template.process(map, new OutputStreamWriter(System.out));
	}
	
	// Main 方法
	public static void main(String[] args) throws IOException, TemplateException {
		Main m = new Main();
		m.init();
		m.process();
	}
	
}
