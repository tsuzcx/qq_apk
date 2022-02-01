import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.mobileqq.troop.activity.VideoRecordActivity;
import com.tencent.mobileqq.widget.QQToast;

public class kin
  implements MediaPlayer.OnErrorListener
{
  public kin(VideoRecordActivity paramVideoRecordActivity) {}
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    QQToast.a(this.a, 1, 2131364101, 1).a();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kin
 * JD-Core Version:    0.7.0.1
 */