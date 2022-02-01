import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.flaotaio.FloatAioPage;

public class gls
  implements ValueAnimator.AnimatorUpdateListener
{
  public gls(FloatAioPage paramFloatAioPage, int paramInt1, int paramInt2, View paramView1, int paramInt3, int paramInt4, int paramInt5, TextView paramTextView1, int paramInt6, View paramView2, View paramView3, int paramInt7, int paramInt8, int paramInt9, TextView paramTextView2, TextView paramTextView3, View paramView4, ImageView paramImageView, int paramInt10, int paramInt11, View paramView5, int paramInt12, View paramView6) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f2 = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    int m = this.jdField_a_of_type_Int;
    int n = (int)((this.jdField_b_of_type_Int - this.jdField_a_of_type_Int) * f2);
    this.jdField_a_of_type_AndroidViewView.layout(this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, this.jdField_e_of_type_Int, m + n);
    this.jdField_a_of_type_AndroidWidgetTextView.setTranslationY(-this.jdField_f_of_type_Int * (1.0F - f2));
    this.jdField_b_of_type_AndroidViewView.setAlpha(f2);
    this.jdField_c_of_type_AndroidViewView.setTranslationY(this.g * f2);
    this.jdField_c_of_type_AndroidViewView.setTranslationX(this.h * f2);
    if (this.i > 0)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setTranslationX(this.i * (1.0F - f2));
      paramValueAnimator = this.jdField_c_of_type_AndroidWidgetTextView;
      if (f2 <= 0.7F) {
        break label321;
      }
    }
    label321:
    for (float f1 = 0.0F;; f1 = 1.0F - f2)
    {
      paramValueAnimator.setAlpha(f1);
      this.jdField_c_of_type_AndroidWidgetTextView.setTranslationY(this.g * f2);
      this.jdField_c_of_type_AndroidWidgetTextView.setTranslationX(this.h * f2);
      this.jdField_d_of_type_AndroidViewView.setAlpha(f2);
      this.jdField_d_of_type_AndroidViewView.setTranslationY(this.g * f2);
      this.jdField_d_of_type_AndroidViewView.setTranslationX(this.h * f2);
      this.jdField_a_of_type_AndroidWidgetImageView.setAlpha(0.2F + 0.8F * f2);
      this.jdField_a_of_type_AndroidWidgetImageView.setTranslationY(this.j * f2);
      this.jdField_a_of_type_AndroidWidgetImageView.setTranslationX(-this.k * (1.0F - f2));
      this.jdField_e_of_type_AndroidViewView.setTranslationY(-this.l * (1.0F - f2));
      this.jdField_e_of_type_AndroidViewView.setScaleX(f2);
      this.jdField_e_of_type_AndroidViewView.setScaleY(f2);
      this.jdField_f_of_type_AndroidViewView.setTranslationY(-this.l * (1.0F - f2));
      this.jdField_f_of_type_AndroidViewView.setAlpha(1.0F - f2);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gls
 * JD-Core Version:    0.7.0.1
 */