import android.app.Dialog;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.ForwardFriendListActivity;

public class dxw
  implements Animation.AnimationListener
{
  public dxw(ForwardFriendListActivity paramForwardFriendListActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.findViewById(2131300437).setVisibility(8);
    ForwardFriendListActivity.a(this.a).show();
    this.a.jdField_a_of_type_AndroidWidgetLinearLayout.setAnimation(null);
    this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dxw
 * JD-Core Version:    0.7.0.1
 */