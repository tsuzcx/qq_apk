import android.app.Activity;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalMusicFileView;
import java.util.TimerTask;

public class iyc
  extends TimerTask
{
  public iyc(LocalMusicFileView paramLocalMusicFileView) {}
  
  public void run()
  {
    LocalMusicFileView.a(this.a).runOnUiThread(new iyd(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     iyc
 * JD-Core Version:    0.7.0.1
 */