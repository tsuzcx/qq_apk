import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.FrameLayout;
import com.tencent.mobileqq.customviews.CircleMenu;

public class hyp
  implements ValueAnimator.AnimatorUpdateListener
{
  public hyp(CircleMenu paramCircleMenu) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    CircleMenu.a(this.a).setAlpha(f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     hyp
 * JD-Core Version:    0.7.0.1
 */