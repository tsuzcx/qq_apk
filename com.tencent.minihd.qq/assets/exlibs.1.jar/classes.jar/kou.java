import android.media.MediaPlayer;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.view.SurfaceHolder;
import com.tencent.mobileqq.troop.widget.VideoViewX;

public class kou
  implements MediaPlayer.OnVideoSizeChangedListener
{
  public kou(VideoViewX paramVideoViewX) {}
  
  public void onVideoSizeChanged(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    VideoViewX.a(this.a, paramMediaPlayer.getVideoWidth());
    VideoViewX.b(this.a, paramMediaPlayer.getVideoHeight());
    if ((VideoViewX.b(this.a) != 0) && (VideoViewX.c(this.a) != 0))
    {
      this.a.getHolder().setFixedSize(VideoViewX.b(this.a), VideoViewX.c(this.a));
      this.a.requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kou
 * JD-Core Version:    0.7.0.1
 */