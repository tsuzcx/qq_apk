import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.PreviewingOfflineFileViewBase;

public class izu
  implements Runnable
{
  public izu(PreviewingOfflineFileViewBase paramPreviewingOfflineFileViewBase) {}
  
  public void run()
  {
    ((ProgressBar)PreviewingOfflineFileViewBase.a(this.a).findViewById(2131299557)).setVisibility(8);
    TextView localTextView = (TextView)PreviewingOfflineFileViewBase.a(this.a).findViewById(2131299558);
    localTextView.setText(2131367610);
    localTextView.setVisibility(0);
    if (PreviewingOfflineFileViewBase.a(this.a) == null) {
      PreviewingOfflineFileViewBase.a(this.a, (LinearLayout)PreviewingOfflineFileViewBase.a(this.a).findViewById(2131299556));
    }
    PreviewingOfflineFileViewBase.a(this.a).setVisibility(0);
    PreviewingOfflineFileViewBase.a(this.a).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     izu
 * JD-Core Version:    0.7.0.1
 */