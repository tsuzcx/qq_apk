import android.app.Activity;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.PreviewingOfflineFileViewBase;
import java.util.TimerTask;

public class izp
  extends TimerTask
{
  public izp(PreviewingOfflineFileViewBase paramPreviewingOfflineFileViewBase) {}
  
  public void run()
  {
    PreviewingOfflineFileViewBase.c(this.a).runOnUiThread(new izq(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     izp
 * JD-Core Version:    0.7.0.1
 */