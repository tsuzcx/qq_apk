import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.qav.bussiness.QavBussinessCtrl;
import com.tencent.qav.bussiness.RingtoneHelper;

public class liw
  implements MediaPlayer.OnCompletionListener
{
  public liw(QavBussinessCtrl paramQavBussinessCtrl) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    RingtoneHelper.a(this.a.a, 2131165192, 1, QavBussinessCtrl.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     liw
 * JD-Core Version:    0.7.0.1
 */