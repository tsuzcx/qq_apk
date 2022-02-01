import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;

public class gbx
  implements Runnable
{
  public gbx(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  public void run()
  {
    PublicAccountChatPie.a(this.a).removeView(PublicAccountChatPie.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gbx
 * JD-Core Version:    0.7.0.1
 */