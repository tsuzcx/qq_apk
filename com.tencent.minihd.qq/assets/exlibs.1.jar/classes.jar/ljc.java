import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.qav.log.AVLog;

public final class ljc
  implements MediaPlayer.OnErrorListener
{
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    AVLog.e("RingtoneHelper", String.format("onError what=%s extra=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ljc
 * JD-Core Version:    0.7.0.1
 */