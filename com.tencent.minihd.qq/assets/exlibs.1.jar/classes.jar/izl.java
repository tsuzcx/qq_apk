import com.tencent.mobileqq.filemanager.fileviewer.FileView.PreviewingOfflineFileViewBase;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.PreviewingOfflineFileViewBase.IControllProxyInterface;
import com.tencent.mobileqq.filemanager.widget.FileWebView;
import com.tencent.qphone.base.util.QLog;

class izl
  implements Runnable
{
  izl(izk paramizk) {}
  
  public void run()
  {
    if (PreviewingOfflineFileViewBase.a(this.a.a) == null) {}
    do
    {
      do
      {
        return;
        if (QLog.isDevelopLevel()) {
          QLog.i("PreviewStep_3", 4, "onPageFinished");
        }
      } while (PreviewingOfflineFileViewBase.a(this.a.a));
      PreviewingOfflineFileViewBase.a(this.a.a, true);
      String str = this.a.a.a().e();
      PreviewingOfflineFileViewBase.a(this.a.a).loadUrl(str);
      if (QLog.isDevelopLevel()) {
        QLog.i("PreviewStep_4", 4, "call js init");
      }
      str = this.a.a.a().f();
      PreviewingOfflineFileViewBase.a(this.a.a).loadUrl(str);
    } while (!QLog.isDevelopLevel());
    QLog.i("PreviewStep_5", 4, "call js first addmore");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     izl
 * JD-Core Version:    0.7.0.1
 */