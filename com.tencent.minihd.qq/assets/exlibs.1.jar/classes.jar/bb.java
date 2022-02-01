import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.dataline.activities.LiteActivity;

public class bb
  implements ValueAnimator.AnimatorUpdateListener
{
  public bb(LiteActivity paramLiteActivity, View paramView, boolean paramBoolean, int paramInt) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    paramValueAnimator = this.jdField_a_of_type_AndroidViewView;
    if (this.jdField_a_of_type_Boolean) {}
    for (float f = this.jdField_a_of_type_Int - i;; f = i)
    {
      paramValueAnimator.setTranslationY(f);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bb
 * JD-Core Version:    0.7.0.1
 */