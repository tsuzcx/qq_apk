import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.servlet.QZonePreDownloadManagerImp;
import com.tencent.qphone.base.util.QLog;

public class jvl
  implements Runnable
{
  public jvl(QZonePreDownloadManagerImp paramQZonePreDownloadManagerImp, Context paramContext, Intent paramIntent) {}
  
  public void run()
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqServletQZonePreDownloadManagerImp.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentIntent);
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QZonePreDownload", 2, "ansycOnReceive fail " + localThrowable.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jvl
 * JD-Core Version:    0.7.0.1
 */