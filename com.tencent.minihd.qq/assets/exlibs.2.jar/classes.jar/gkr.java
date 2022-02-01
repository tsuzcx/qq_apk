import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.FrameLayout;
import com.tencent.mobileqq.activity.flaotaio.BaseFloatChatPie;

public class gkr
  extends AnimatorListenerAdapter
{
  public gkr(BaseFloatChatPie paramBaseFloatChatPie) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    BaseFloatChatPie.b(this.a, false);
    this.a.b.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gkr
 * JD-Core Version:    0.7.0.1
 */