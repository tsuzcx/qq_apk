import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.mobileqq.activity.flaotaio.FloatImagePreview;
import com.tencent.widget.Gallery;

public class gml
  implements ValueAnimator.AnimatorUpdateListener
{
  public gml(FloatImagePreview paramFloatImagePreview, View paramView, float paramFloat1, Gallery paramGallery, float paramFloat2, float paramFloat3) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f1 = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.jdField_a_of_type_AndroidViewView.setAlpha(f1);
    float f2 = this.jdField_a_of_type_Float + (1.0F - this.jdField_a_of_type_Float) * f1;
    this.jdField_a_of_type_ComTencentWidgetGallery.setScaleX(f2);
    this.jdField_a_of_type_ComTencentWidgetGallery.setScaleY(f2);
    this.jdField_a_of_type_ComTencentWidgetGallery.setAlpha(f1);
    this.jdField_a_of_type_ComTencentWidgetGallery.setTranslationX(this.b * (1.0F - f1));
    this.jdField_a_of_type_ComTencentWidgetGallery.setTranslationY((1.0F - f1) * this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gml
 * JD-Core Version:    0.7.0.1
 */