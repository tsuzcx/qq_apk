import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.mobileqq.customviews.CircleMenu;

public class hyt
  implements ValueAnimator.AnimatorUpdateListener
{
  public hyt(CircleMenu paramCircleMenu, View paramView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.jdField_a_of_type_AndroidViewView.setTranslationY(this.jdField_a_of_type_ComTencentMobileqqCustomviewsCircleMenu.a(20) * (1.0F - f));
    this.jdField_a_of_type_AndroidViewView.setAlpha(f);
    paramValueAnimator = this.jdField_a_of_type_AndroidViewView.findViewById(2131297216);
    paramValueAnimator.setScaleX(f);
    paramValueAnimator.setScaleY(f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     hyt
 * JD-Core Version:    0.7.0.1
 */