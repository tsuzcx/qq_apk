import com.etrump.mixlayout.FontManager;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;

public class el
  implements FilenameFilter
{
  public el(FontManager paramFontManager, ArrayList paramArrayList) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    paramFile = new File(paramFile.getAbsolutePath() + File.separatorChar + paramString);
    if (paramFile.isDirectory()) {
      paramFile.listFiles(new em(this));
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     el
 * JD-Core Version:    0.7.0.1
 */