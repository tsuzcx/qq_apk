import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.HongbaoShowerActivity;

public class edz
  implements Animation.AnimationListener
{
  public edz(HongbaoShowerActivity paramHongbaoShowerActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    HongbaoShowerActivity.a(this.a);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     edz
 * JD-Core Version:    0.7.0.1
 */