import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class elp
  implements View.OnClickListener
{
  public elp(NearbyActivity paramNearbyActivity, RelativeLayout paramRelativeLayout, View paramView) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.app.getPreferences().edit().putBoolean("nearby_people_disclaimer_ok", true).commit();
    paramView = new AlphaAnimation(1.0F, 0.0F);
    paramView.setDuration(500L);
    paramView.setAnimationListener(new elq(this));
    this.jdField_a_of_type_AndroidViewView.startAnimation(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     elp
 * JD-Core Version:    0.7.0.1
 */