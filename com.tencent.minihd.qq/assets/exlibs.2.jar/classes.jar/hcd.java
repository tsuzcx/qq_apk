import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.widget.doyen.DoyenEarthLayout;

public class hcd
  extends Handler
{
  public hcd(DoyenEarthLayout paramDoyenEarthLayout) {}
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if (paramMessage.what == 546) {
      DoyenEarthLayout.a(this.a).startAnimation(DoyenEarthLayout.a(this.a));
    }
    do
    {
      return;
      if (paramMessage.what == 819)
      {
        DoyenEarthLayout.b(this.a).startAnimation(DoyenEarthLayout.b(this.a));
        return;
      }
      if (paramMessage.what == 1092)
      {
        DoyenEarthLayout.c(this.a).startAnimation(DoyenEarthLayout.c(this.a));
        return;
      }
    } while (paramMessage.what != 1365);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     hcd
 * JD-Core Version:    0.7.0.1
 */