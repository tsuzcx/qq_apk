import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.troop.activity.NearbyTroopsActivity;

public class kde
  implements Animation.AnimationListener
{
  public kde(NearbyTroopsActivity paramNearbyTroopsActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.e.setVisibility(8);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kde
 * JD-Core Version:    0.7.0.1
 */