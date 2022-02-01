import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.profile.view.ProfileHeaderView;
import com.tencent.mobileqq.widget.Rotate3dAnimation;

public class jnv
  implements Animation.AnimationListener
{
  public jnv(ProfileHeaderView paramProfileHeaderView, View paramView1, View paramView2, Rotate3dAnimation paramRotate3dAnimation) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.b.setVisibility(0);
    this.b.startAnimation(this.jdField_a_of_type_ComTencentMobileqqWidgetRotate3dAnimation);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jnv
 * JD-Core Version:    0.7.0.1
 */