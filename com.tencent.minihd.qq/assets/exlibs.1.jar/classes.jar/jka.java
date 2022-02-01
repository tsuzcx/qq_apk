import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity.PicInfo;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel;
import com.tencent.widget.CustomImgView;

class jka
  implements Animation.AnimationListener
{
  jka(jjw paramjjw, NearbyPeopleProfileActivity.PicInfo paramPicInfo, CustomImgView paramCustomImgView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    NearbyProfileEditPanel.a(this.jdField_a_of_type_Jjw.a).post(new jkb(this));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jka
 * JD-Core Version:    0.7.0.1
 */