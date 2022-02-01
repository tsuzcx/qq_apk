import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.NearbyActivity;

class elq
  implements Animation.AnimationListener
{
  elq(elp paramelp) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.a.jdField_a_of_type_AndroidViewView);
    this.a.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.getWindow().setBackgroundDrawable(null);
    NearbyActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity).setVisibility(0);
    NearbyActivity.e(this.a.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     elq
 * JD-Core Version:    0.7.0.1
 */