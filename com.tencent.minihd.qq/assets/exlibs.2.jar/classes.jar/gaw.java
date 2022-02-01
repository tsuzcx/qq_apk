import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;

public class gaw
  implements Animation.AnimationListener
{
  public gaw(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    PublicAccountChatPie.c(this.a, false);
    PublicAccountChatPie.b(this.a, 0);
    PublicAccountChatPie.e(this.a, false);
    PublicAccountChatPie.f(this.a, false);
    PublicAccountChatPie.d(this.a, false);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.a.a(PublicAccountChatPie.a(this.a), PublicAccountChatPie.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gaw
 * JD-Core Version:    0.7.0.1
 */