import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.widget.XPanelContainer;

public class ltk
  implements ValueAnimator.AnimatorUpdateListener
{
  public ltk(XPanelContainer paramXPanelContainer, int paramInt) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    XPanelContainer.a(this.jdField_a_of_type_ComTencentWidgetXPanelContainer, this.jdField_a_of_type_Int - i);
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ltk
 * JD-Core Version:    0.7.0.1
 */