import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.ControlerCallback;
import com.tencent.mobileqq.filemanager.core.QfavFilePreviewController;
import com.tencent.qphone.base.util.QLog;

public class iug
  implements Runnable
{
  public iug(QfavFilePreviewController paramQfavFilePreviewController) {}
  
  public void run()
  {
    if (3 != QfavFilePreviewController.b(this.a))
    {
      this.a.a.a(false, QfavFilePreviewController.a(this.a), String.valueOf(QfavFilePreviewController.a(this.a)), QfavFilePreviewController.a(this.a), null, QfavFilePreviewController.b(this.a), null, QfavFilePreviewController.c(this.a));
      QfavFilePreviewController.b(this.a, 3);
      if (QLog.isColorLevel()) {
        QLog.i("QfavFilePreviewController", 2, "QfavFilePreviewController.run:wait for remote command timeout(5min).");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     iug
 * JD-Core Version:    0.7.0.1
 */