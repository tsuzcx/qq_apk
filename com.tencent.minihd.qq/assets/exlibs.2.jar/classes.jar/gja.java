import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.contact.troop.BaseTroopView;

public class gja
  implements Animation.AnimationListener
{
  public gja(BaseTroopView paramBaseTroopView, int paramInt) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView.c.setAnimation(null);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView.c.offsetTopAndBottom(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView.c.requestLayout();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gja
 * JD-Core Version:    0.7.0.1
 */