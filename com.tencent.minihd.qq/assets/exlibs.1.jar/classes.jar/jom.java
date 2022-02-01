import android.graphics.PointF;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.view.ProfileTagView;
import com.tencent.mobileqq.profile.view.VipTagView;
import com.tencent.mobileqq.widget.RatioLayout.LayoutParams;
import java.util.List;

public class jom
  implements Animation.AnimationListener
{
  public jom(ProfileTagView paramProfileTagView, View paramView, PointF paramPointF) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    ProfileTagView.b(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView);
    paramAnimation = (RatioLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    if (paramAnimation != null)
    {
      if (this.jdField_a_of_type_AndroidViewView.getAnimation() != null) {
        this.jdField_a_of_type_AndroidViewView.clearAnimation();
      }
      if ((paramAnimation.a != this.jdField_a_of_type_AndroidGraphicsPointF.x) || (paramAnimation.b != this.jdField_a_of_type_AndroidGraphicsPointF.y))
      {
        paramAnimation.a = this.jdField_a_of_type_AndroidGraphicsPointF.x;
        paramAnimation.b = this.jdField_a_of_type_AndroidGraphicsPointF.y;
        this.jdField_a_of_type_AndroidViewView.setLayoutParams(paramAnimation);
        if ((this.jdField_a_of_type_AndroidViewView instanceof VipTagView)) {
          ((VipTagView)this.jdField_a_of_type_AndroidViewView).setShakingState(true);
        }
      }
      ProfileTagView.b(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView, false);
      if (ProfileTagView.c(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView) == 0) {
        if (!ProfileTagView.c(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView))
        {
          paramAnimation = this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView.a.a.getLabelList();
          if (paramAnimation != null)
          {
            if ((ProfileTagView.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView)[(ProfileTagView.a().length - 1)] == null) || (paramAnimation.size() != 0)) {
              break label238;
            }
            ProfileTagView.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView).setVisibility(0);
          }
        }
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView.b)
      {
        this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView.d(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView.a);
        this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView.b = false;
      }
      return;
      label238:
      ProfileTagView.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView).setVisibility(4);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jom
 * JD-Core Version:    0.7.0.1
 */