import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel;
import com.tencent.widget.CustomImgView;

class jjy
  implements Animation.AnimationListener
{
  jjy(jjw paramjjw, View paramView, CustomImgView paramCustomImgView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    NearbyProfileEditPanel.a(this.jdField_a_of_type_Jjw.a).post(new jjz(this));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jjy
 * JD-Core Version:    0.7.0.1
 */