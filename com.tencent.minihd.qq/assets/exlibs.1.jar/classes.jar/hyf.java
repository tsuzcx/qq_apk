import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.customviews.CircleMenu;

public class hyf
  implements ValueAnimator.AnimatorUpdateListener
{
  public hyf(CircleMenu paramCircleMenu) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    CircleMenu.a(this.a).setRotation(45.0F * f);
    CircleMenu.a(this.a).setAlpha(f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     hyf
 * JD-Core Version:    0.7.0.1
 */