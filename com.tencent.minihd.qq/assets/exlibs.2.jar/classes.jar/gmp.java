import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import com.tencent.mobileqq.activity.flaotaio.FloatMsgBar;

public class gmp
  implements ValueAnimator.AnimatorUpdateListener
{
  public gmp(FloatMsgBar paramFloatMsgBar, int paramInt, View paramView, DecelerateInterpolator paramDecelerateInterpolator) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if ((((Float)paramValueAnimator.getAnimatedValue()).floatValue() / this.jdField_a_of_type_Int <= 0.4F) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 4))
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      int i = (int)(FloatMsgBar.a(this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatMsgBar).getDisplayMetrics().density * 306.0F);
      paramValueAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewView, "translationX", new float[] { i, 0.0F });
      paramValueAnimator.setInterpolator(this.jdField_a_of_type_AndroidViewAnimationDecelerateInterpolator);
      paramValueAnimator.setDuration(300L);
      paramValueAnimator.start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gmp
 * JD-Core Version:    0.7.0.1
 */