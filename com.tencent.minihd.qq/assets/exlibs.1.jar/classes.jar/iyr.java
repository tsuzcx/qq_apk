import android.app.Activity;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalVideoFileView;
import java.util.TimerTask;

public class iyr
  extends TimerTask
{
  public iyr(LocalVideoFileView paramLocalVideoFileView) {}
  
  public void run()
  {
    LocalVideoFileView.f(this.a).runOnUiThread(new iys(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     iyr
 * JD-Core Version:    0.7.0.1
 */