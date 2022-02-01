import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;
import com.tencent.mobileqq.customviews.CircleMenu;
import com.tencent.mobileqq.customviews.CircleMenu.MenuParams;

public class hyi
  extends AnimatorListenerAdapter
{
  public hyi(CircleMenu paramCircleMenu) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    CircleMenu.a(this.a, false);
    CircleMenu.a(this.a).a.removeView(CircleMenu.b(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     hyi
 * JD-Core Version:    0.7.0.1
 */