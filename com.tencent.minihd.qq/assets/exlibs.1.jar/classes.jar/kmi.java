import java.io.File;
import java.io.FilenameFilter;

class kmi
  implements FilenameFilter
{
  kmi(kmh paramkmh) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return paramString.startsWith("[Thumb]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kmi
 * JD-Core Version:    0.7.0.1
 */