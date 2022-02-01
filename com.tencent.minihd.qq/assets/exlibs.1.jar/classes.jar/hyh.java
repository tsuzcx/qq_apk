import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mobileqq.customviews.CircleMenu;

public class hyh
  implements ValueAnimator.AnimatorUpdateListener
{
  public hyh(CircleMenu paramCircleMenu) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    CircleMenu.a(this.a).setRotation(45.0F * (1.0F - f));
    int i = 0;
    while (i < CircleMenu.a(this.a).getChildCount())
    {
      CircleMenu.a(this.a).getChildAt(i).setAlpha(1.0F - f);
      CircleMenu.a(this.a).setAlpha(1.0F - f);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     hyh
 * JD-Core Version:    0.7.0.1
 */