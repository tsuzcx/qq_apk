import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.UncommonlyUsedContactsActivity;

public class flr
  implements Animation.AnimationListener
{
  public flr(UncommonlyUsedContactsActivity paramUncommonlyUsedContactsActivity, int paramInt) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity.a.setAnimation(null);
    this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity.a.offsetTopAndBottom(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity.a.requestLayout();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     flr
 * JD-Core Version:    0.7.0.1
 */