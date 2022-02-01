import com.tencent.mobileqq.testassister.ShareAppLogHelper.LogFile;
import java.util.Comparator;

public final class mdd
  implements Comparator
{
  public int a(ShareAppLogHelper.LogFile paramLogFile1, ShareAppLogHelper.LogFile paramLogFile2)
  {
    return (int)(paramLogFile1.lastModified() - paramLogFile2.lastModified()) / 1000;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     mdd
 * JD-Core Version:    0.7.0.1
 */