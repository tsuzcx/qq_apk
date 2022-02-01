import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FilenameFilter;

public final class mdc
  implements FilenameFilter
{
  public mdc(long paramLong1, long paramLong2) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    if (!paramString.endsWith(".trace")) {}
    long l;
    do
    {
      File localFile;
      do
      {
        return false;
        localFile = new File(paramFile + File.separator + paramString);
      } while ((localFile == null) || (!localFile.exists()));
      l = localFile.lastModified();
      if (QLog.isDevelopLevel())
      {
        QLog.d("QZoneAppCtrlUploadFileLogic", 4, "file dir: " + paramFile.getName());
        QLog.d("QZoneAppCtrlUploadFileLogic", 4, "file name: " + paramString + " mStartTime: " + this.a + " mEndTime: " + this.b + " lastModifiedTime: " + l);
      }
    } while ((l < this.a) || (l > this.b));
    if (QLog.isDevelopLevel()) {
      QLog.d("QZoneAppCtrlUploadFileLogic", 4, "find file name: " + paramString);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     mdc
 * JD-Core Version:    0.7.0.1
 */