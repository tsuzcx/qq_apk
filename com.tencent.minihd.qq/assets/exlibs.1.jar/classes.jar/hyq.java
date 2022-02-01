import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.mobileqq.customviews.CircleMenu;

public class hyq
  extends AnimatorListenerAdapter
{
  public hyq(CircleMenu paramCircleMenu) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.b = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     hyq
 * JD-Core Version:    0.7.0.1
 */