import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.FrameLayout;
import com.tencent.mobileqq.customviews.CircleMenu;

public class hyr
  extends AnimatorListenerAdapter
{
  public hyr(CircleMenu paramCircleMenu) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    CircleMenu.a(this.a).setVisibility(4);
    this.a.a = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     hyr
 * JD-Core Version:    0.7.0.1
 */