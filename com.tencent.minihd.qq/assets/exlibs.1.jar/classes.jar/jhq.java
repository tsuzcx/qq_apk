import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel;

public class jhq
  implements Animation.AnimationListener
{
  public jhq(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.a.setVisibility(0);
    if (NearbyPeopleProfileActivity.a(this.a) == null) {
      NearbyPeopleProfileActivity.a(this.a, new NearbyProfileDisplayPanel(this.a, this.a.a));
    }
    NearbyPeopleProfileActivity.a(this.a).a(NearbyPeopleProfileActivity.a(this.a), false);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jhq
 * JD-Core Version:    0.7.0.1
 */