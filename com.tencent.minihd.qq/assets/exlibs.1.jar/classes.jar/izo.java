import android.os.Handler;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.PreviewingOfflineFileViewBase;
import com.tencent.qphone.base.util.QLog;

class izo
  implements Runnable
{
  izo(izm paramizm) {}
  
  public void run()
  {
    PreviewingOfflineFileViewBase.a(this.a.a).removeCallbacksAndMessages(null);
    try
    {
      String str = (String)PreviewingOfflineFileViewBase.a(this.a.a).getText();
      if ((str == null) || (str.length() == 0)) {
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PreviewingOfflineFileViewBase<FileAssistant>", 1, localException.toString());
        }
        Object localObject = null;
      }
      PreviewingOfflineFileViewBase.a(this.a.a).clearAnimation();
      PreviewingOfflineFileViewBase.a(this.a.a).setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     izo
 * JD-Core Version:    0.7.0.1
 */