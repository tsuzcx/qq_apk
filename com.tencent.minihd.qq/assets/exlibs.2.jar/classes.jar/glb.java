import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.mobileqq.activity.flaotaio.BaseFloatChatPie;

public class glb
  extends AnimatorListenerAdapter
{
  public glb(BaseFloatChatPie paramBaseFloatChatPie) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    BaseFloatChatPie.b(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     glb
 * JD-Core Version:    0.7.0.1
 */