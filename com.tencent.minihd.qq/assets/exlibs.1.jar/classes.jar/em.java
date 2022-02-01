import com.etrump.mixlayout.FontInfo;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;

class em
  implements FilenameFilter
{
  em(el paramel) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    FontInfo localFontInfo;
    if (paramString.endsWith(".ttf"))
    {
      paramString = paramFile.getAbsolutePath() + File.separatorChar + paramString;
      localFontInfo = new FontInfo();
      if (localFontInfo == null) {}
    }
    try
    {
      paramFile = paramFile.getAbsolutePath().split(File.separator);
      localFontInfo.jdField_a_of_type_Int = Integer.parseInt(paramFile[(paramFile.length - 1)]);
      localFontInfo.jdField_a_of_type_JavaLangString = paramString;
      this.a.a.add(localFontInfo);
      label90:
      return false;
    }
    catch (Exception paramFile)
    {
      break label90;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     em
 * JD-Core Version:    0.7.0.1
 */