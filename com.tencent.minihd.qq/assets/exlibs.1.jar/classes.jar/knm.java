import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.troop.widget.MediaControllerX;
import com.tencent.mobileqq.troop.widget.MediaControllerX.MediaPlayerControlX;

public class knm
  extends Handler
{
  public knm(MediaControllerX paramMediaControllerX) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    int i;
    do
    {
      return;
      this.a.c();
      return;
      i = MediaControllerX.a(this.a);
    } while ((MediaControllerX.b(this.a)) || (!MediaControllerX.a(this.a)) || (!MediaControllerX.a(this.a).a()));
    sendMessageDelayed(obtainMessage(2), 1000 - i % 1000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     knm
 * JD-Core Version:    0.7.0.1
 */