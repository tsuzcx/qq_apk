import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity;

public class hba
  implements Animation.AnimationListener
{
  public hba(SpecailCareListActivity paramSpecailCareListActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    SpecailCareListActivity.f(this.a).clearAnimation();
    this.a.a.clearAnimation();
    SpecailCareListActivity.g(this.a).setVisibility(0);
    this.a.a.setVisibility(0);
    SpecailCareListActivity.h(this.a).setClickable(true);
    SpecailCareListActivity.i(this.a).setText("管理");
    SpecailCareListActivity.j(this.a).setContentDescription("管理 按钮");
    this.a.c = false;
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     hba
 * JD-Core Version:    0.7.0.1
 */