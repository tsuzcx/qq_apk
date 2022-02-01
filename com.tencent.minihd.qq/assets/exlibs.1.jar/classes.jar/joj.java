import android.graphics.PointF;
import android.view.animation.Transformation;
import com.tencent.mobileqq.profile.view.ProfileTagView;
import com.tencent.mobileqq.profile.view.VipTagView;
import com.tencent.mobileqq.utils.ValueAnimation;
import com.tencent.mobileqq.utils.ValueAnimation.AnimationUpdateListener;
import com.tencent.mobileqq.widget.RatioLayout;

public class joj
  implements ValueAnimation.AnimationUpdateListener
{
  public joj(ProfileTagView paramProfileTagView, VipTagView paramVipTagView) {}
  
  public void a(ValueAnimation paramValueAnimation, float paramFloat, PointF paramPointF, Transformation paramTransformation)
  {
    ProfileTagView.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView).a(this.jdField_a_of_type_ComTencentMobileqqProfileViewVipTagView, paramPointF.x, paramPointF.y);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     joj
 * JD-Core Version:    0.7.0.1
 */