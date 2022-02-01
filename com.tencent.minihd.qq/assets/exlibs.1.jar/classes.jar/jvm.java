import com.tencent.mobileqq.servlet.QZonePreDownloadManagerImp;
import com.tencent.qphone.base.util.QLog;

public class jvm
  implements Runnable
{
  public jvm(QZonePreDownloadManagerImp paramQZonePreDownloadManagerImp) {}
  
  public void run()
  {
    try
    {
      QZonePreDownloadManagerImp.d(this.a);
      QZonePreDownloadManagerImp.b(this.a);
      QZonePreDownloadManagerImp.c(this.a);
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QZonePreDownload", 2, "init font engine fail " + localThrowable.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jvm
 * JD-Core Version:    0.7.0.1
 */