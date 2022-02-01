import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.mobileqq.customviews.CircleMenu;

public class hyg
  extends AnimatorListenerAdapter
{
  public hyg(CircleMenu paramCircleMenu) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    CircleMenu.a(this.a, false);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    CircleMenu.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     hyg
 * JD-Core Version:    0.7.0.1
 */