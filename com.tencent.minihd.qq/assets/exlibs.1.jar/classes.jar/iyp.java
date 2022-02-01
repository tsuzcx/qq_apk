import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalVideoFileView;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewMusicService;

public class iyp
  implements SurfaceHolder.Callback
{
  public iyp(LocalVideoFileView paramLocalVideoFileView) {}
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    try
    {
      LocalVideoFileView.d(this.a);
      if (LocalVideoFileView.a(this.a) != 0) {
        LocalVideoFileView.a(this.a).a(LocalVideoFileView.a(this.a));
      }
      return;
    }
    catch (Exception paramSurfaceHolder) {}
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     iyp
 * JD-Core Version:    0.7.0.1
 */