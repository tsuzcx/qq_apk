import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendGrid;
import com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity;

public class hbi
  implements Animation.AnimationListener
{
  public hbi(SpecailCareListActivity paramSpecailCareListActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.c.clearAnimation();
    ((FrameLayout)this.a.getWindow().getDecorView()).removeView(this.a.c);
    this.a.c = null;
    if (this.a.a != null)
    {
      this.a.a.a();
      this.a.a = null;
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     hbi
 * JD-Core Version:    0.7.0.1
 */