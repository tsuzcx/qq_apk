import android.app.Activity;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.PreviewingOfflineFileViewBase;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;

class izs
  implements Runnable
{
  izs(izr paramizr) {}
  
  public void run()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("PreviewingOfflineFileViewBase<FileAssistant>", 4, "TimeoutTimer run in ui thread");
    }
    if (!NetworkUtil.f(PreviewingOfflineFileViewBase.d(this.a.a))) {}
    for (String str = PreviewingOfflineFileViewBase.e(this.a.a).getString(2131363364);; str = PreviewingOfflineFileViewBase.f(this.a.a).getString(2131367610))
    {
      this.a.a.b(9037L, "Time out", str);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     izs
 * JD-Core Version:    0.7.0.1
 */