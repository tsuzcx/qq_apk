import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import com.tencent.mobileqq.vipav.VipFunCallMediaListener;

public final class kwa
  implements MediaPlayer.OnPreparedListener
{
  public kwa(VipFunCallMediaListener paramVipFunCallMediaListener) {}
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    paramMediaPlayer.start();
    paramMediaPlayer.setLooping(true);
    if (this.a != null) {
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kwa
 * JD-Core Version:    0.7.0.1
 */