import cooperation.plugin.PluginInstaller;
import java.io.File;
import java.io.FilenameFilter;

public class lxo
  implements FilenameFilter
{
  public lxo(PluginInstaller paramPluginInstaller, String paramString) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    return paramString.endsWith(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     lxo
 * JD-Core Version:    0.7.0.1
 */