import android.hardware.SensorManager;
import com.tencent.mobileqq.activity.ChatHistoryForC2C;
import com.tencent.mobileqq.activity.ChatHistoryForC2C.PlayingPttHistoryInfo;
import com.tencent.mobileqq.activity.aio.AudioPlayer;
import com.tencent.mobileqq.activity.aio.AudioPlayer.AudioPlayerListener;

public class dnx
  implements AudioPlayer.AudioPlayerListener
{
  public dnx(ChatHistoryForC2C paramChatHistoryForC2C) {}
  
  public void a(AudioPlayer paramAudioPlayer)
  {
    this.a.q();
    if (this.a.a != null) {
      this.a.a.b();
    }
    this.a.setVolumeControlStream(3);
    ChatHistoryForC2C.a(this.a).unregisterListener(this.a);
  }
  
  public void a(AudioPlayer paramAudioPlayer, int paramInt)
  {
    this.a.a(2131366519);
    this.a.setVolumeControlStream(3);
    ChatHistoryForC2C.a(this.a).unregisterListener(this.a);
  }
  
  public void b(AudioPlayer paramAudioPlayer, int paramInt)
  {
    this.a.setVolumeControlStream(paramInt);
  }
  
  public void c(AudioPlayer paramAudioPlayer, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dnx
 * JD-Core Version:    0.7.0.1
 */