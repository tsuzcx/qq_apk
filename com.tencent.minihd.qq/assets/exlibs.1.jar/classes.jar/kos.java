import android.media.MediaPlayer;
import com.tencent.mobileqq.troop.widget.MediaControllerX;
import com.tencent.mobileqq.troop.widget.VideoViewX;
import com.tencent.mobileqq.troop.widget.VideoViewX.OnPlayListener;

public class kos
  implements Runnable
{
  public kos(VideoViewX paramVideoViewX) {}
  
  public void run()
  {
    if (VideoViewX.a(this.a) != null)
    {
      if (VideoViewX.a(this.a).getCurrentPosition() > 0)
      {
        if (this.a.a)
        {
          this.a.a = false;
          if (VideoViewX.a(this.a) != null) {
            VideoViewX.a(this.a).b();
          }
        }
        if (VideoViewX.a(this.a) != null) {
          VideoViewX.a(this.a).a(VideoViewX.a(this.a));
        }
        VideoViewX.c(this.a, false);
      }
    }
    else {
      return;
    }
    this.a.postDelayed(VideoViewX.a(this.a), 300L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kos
 * JD-Core Version:    0.7.0.1
 */