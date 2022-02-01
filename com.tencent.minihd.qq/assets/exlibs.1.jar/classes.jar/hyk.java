import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.FrameLayout;
import com.tencent.mobileqq.customviews.CircleMenu;

public class hyk
  extends AnimatorListenerAdapter
{
  public hyk(CircleMenu paramCircleMenu) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    CircleMenu.a(this.a).post(new hyl(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     hyk
 * JD-Core Version:    0.7.0.1
 */