import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.qav.bussiness.QavBussinessCtrl;
import com.tencent.qav.session.QavSession;

public class lix
  implements MediaPlayer.OnCompletionListener
{
  public lix(QavBussinessCtrl paramQavBussinessCtrl) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    paramMediaPlayer = this.a.a();
    if (paramMediaPlayer != null) {
      QavBussinessCtrl.a(this.a, String.valueOf(paramMediaPlayer.a), paramMediaPlayer.e);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     lix
 * JD-Core Version:    0.7.0.1
 */