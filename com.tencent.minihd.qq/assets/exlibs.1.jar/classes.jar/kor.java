import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import com.tencent.mobileqq.troop.widget.MediaControllerX;
import com.tencent.mobileqq.troop.widget.VideoViewX;

public class kor
  implements SurfaceHolder.Callback
{
  public kor(VideoViewX paramVideoViewX) {}
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 1;
    VideoViewX.f(this.a, paramInt2);
    VideoViewX.g(this.a, paramInt3);
    if (VideoViewX.g(this.a) == 3)
    {
      paramInt1 = 1;
      if ((VideoViewX.b(this.a) != paramInt2) || (VideoViewX.c(this.a) != paramInt3)) {
        break label116;
      }
    }
    label116:
    for (paramInt2 = i;; paramInt2 = 0)
    {
      if ((VideoViewX.a(this.a) != null) && (paramInt1 != 0) && (paramInt2 != 0))
      {
        if (VideoViewX.d(this.a) != 0) {
          this.a.a(VideoViewX.d(this.a));
        }
        this.a.a();
      }
      return;
      paramInt1 = 0;
      break;
    }
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    VideoViewX.a(this.a, paramSurfaceHolder);
    VideoViewX.c(this.a);
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    VideoViewX.a(this.a, null);
    if (VideoViewX.a(this.a) != null) {
      VideoViewX.a(this.a).c();
    }
    VideoViewX.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kor
 * JD-Core Version:    0.7.0.1
 */