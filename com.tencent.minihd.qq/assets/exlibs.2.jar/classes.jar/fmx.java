import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.tencent.mobileqq.activity.UserguideFaceMaskActivity;

public class fmx
  implements View.OnClickListener
{
  public fmx(UserguideFaceMaskActivity paramUserguideFaceMaskActivity) {}
  
  public void onClick(View paramView)
  {
    if (!UserguideFaceMaskActivity.b(this.a)) {
      return;
    }
    UserguideFaceMaskActivity.a(this.a, true);
    this.a.a(this.a.findViewById(2131298287));
    this.a.a(this.a.findViewById(2131298290));
    ((TextView)this.a.findViewById(2131300649)).setText("QQ视频");
    this.a.findViewById(2131298286).setContentDescription("已经进行美颜");
    UserguideFaceMaskActivity.a(this.a).setBackgroundColor(-1);
    paramView = AnimationUtils.loadAnimation(this.a, 2130968713);
    paramView.setAnimationListener(new fmy(this));
    UserguideFaceMaskActivity.a(this.a).startAnimation(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fmx
 * JD-Core Version:    0.7.0.1
 */