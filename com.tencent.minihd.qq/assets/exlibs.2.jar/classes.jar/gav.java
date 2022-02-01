import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;

public class gav
  implements Animation.AnimationListener
{
  public gav(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    PublicAccountChatPie.c(this.a, false);
    PublicAccountChatPie.d(this.a, false);
    this.a.a(PublicAccountChatPie.a(this.a));
    PublicAccountChatPie.b(this.a, 1);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gav
 * JD-Core Version:    0.7.0.1
 */