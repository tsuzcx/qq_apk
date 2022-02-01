import android.view.SurfaceView;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalVideoFileView;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewMusicService;

public class iyq
  implements Runnable
{
  public iyq(LocalVideoFileView paramLocalVideoFileView) {}
  
  public void run()
  {
    boolean bool2 = false;
    LocalVideoFileView.a(this.a).setVisibility(0);
    boolean bool1 = bool2;
    if (LocalVideoFileView.a(this.a).b(LocalVideoFileView.a(this.a)))
    {
      bool1 = bool2;
      if (LocalVideoFileView.a(this.a).a()) {
        bool1 = true;
      }
    }
    LocalVideoFileView.a(this.a, bool1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     iyq
 * JD-Core Version:    0.7.0.1
 */