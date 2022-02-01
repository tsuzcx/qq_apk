import cooperation.plugin.PluginDownloader;
import java.io.File;
import java.io.FilenameFilter;

public class lxl
  implements FilenameFilter
{
  public lxl(PluginDownloader paramPluginDownloader, String paramString) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    return paramString.endsWith(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     lxl
 * JD-Core Version:    0.7.0.1
 */