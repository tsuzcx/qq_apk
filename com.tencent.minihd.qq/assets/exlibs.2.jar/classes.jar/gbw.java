import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;

public class gbw
  implements ValueAnimator.AnimatorUpdateListener
{
  public gbw(PublicAccountChatPie paramPublicAccountChatPie, View paramView, int paramInt1, int paramInt2) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f1 = ((Integer)paramValueAnimator.getAnimatedValue()).intValue() / 100.0F;
    paramValueAnimator = this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    float f2 = this.jdField_a_of_type_Int;
    paramValueAnimator.height = ((int)(f1 * (this.b - this.jdField_a_of_type_Int) + f2));
    this.jdField_a_of_type_AndroidViewView.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gbw
 * JD-Core Version:    0.7.0.1
 */