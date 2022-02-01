import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.PreviewingOfflineFileViewBase;
import com.tencent.mobileqq.filemanager.util.FilePreviewAnimQueue;
import com.tencent.qphone.base.util.QLog;

public class izv
  implements Runnable
{
  public izv(PreviewingOfflineFileViewBase paramPreviewingOfflineFileViewBase) {}
  
  public void run()
  {
    if (PreviewingOfflineFileViewBase.a(this.a) == null) {
      PreviewingOfflineFileViewBase.a(this.a, (LinearLayout)PreviewingOfflineFileViewBase.a(this.a).findViewById(2131299556));
    }
    PreviewingOfflineFileViewBase.a(this.a, PreviewingOfflineFileViewBase.b(this.a));
    if (PreviewingOfflineFileViewBase.b(this.a) == null) {
      PreviewingOfflineFileViewBase.b(this.a, new FilePreviewAnimQueue(PreviewingOfflineFileViewBase.a(this.a)));
    }
    ((ProgressBar)PreviewingOfflineFileViewBase.a(this.a).findViewById(2131299557)).setVisibility(0);
    ((TextView)PreviewingOfflineFileViewBase.a(this.a).findViewById(2131299558)).setText(2131367606);
    PreviewingOfflineFileViewBase.a(this.a).setVisibility(0);
    if (QLog.isColorLevel()) {
      QLog.i("PreviewingOfflineFileViewBase<FileAssistant>", 2, "showGetmore(1000)");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     izv
 * JD-Core Version:    0.7.0.1
 */