import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.qav.bussiness.RingtoneHelper;
import com.tencent.qav.log.AVLog;

public final class ljb
  implements MediaPlayer.OnCompletionListener
{
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    AVLog.e("RingtoneHelper", "onCompletion");
    RingtoneHelper.a();
    if (RingtoneHelper.b() > 0) {
      RingtoneHelper.a().start();
    }
    while (RingtoneHelper.a() == null) {
      return;
    }
    RingtoneHelper.b();
    RingtoneHelper.a().onCompletion(RingtoneHelper.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ljb
 * JD-Core Version:    0.7.0.1
 */