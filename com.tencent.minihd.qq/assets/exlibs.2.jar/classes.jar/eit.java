import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.AutoCompleteTextView;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.widget.CustomSafeEditText;
import com.tencent.widget.HorizontalListView;

public class eit
  implements Animation.AnimationListener
{
  public eit(LoginActivity paramLoginActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    LoginActivity.a(this.a).clearAnimation();
    paramAnimation = (ViewGroup.MarginLayoutParams)LoginActivity.a(this.a).getLayoutParams();
    paramAnimation.topMargin -= LoginActivity.a(this.a);
    LoginActivity.a(this.a).requestLayout();
    LoginActivity.a(this.a).setVisibility(4);
    LoginActivity.a(this.a).setEnabled(true);
    LoginActivity.a(this.a).setEnabled(true);
    LoginActivity.a(this.a).notifyDataSetChanged();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    LoginActivity.a(this.a).setVisibility(0);
    LoginActivity.a(this.a).setEnabled(false);
    LoginActivity.a(this.a).setEnabled(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     eit
 * JD-Core Version:    0.7.0.1
 */