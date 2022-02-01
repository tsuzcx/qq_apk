import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.struct.NearbyPushBanner;
import com.tencent.mobileqq.utils.JumpAction;

public class ely
  implements View.OnClickListener
{
  public ely(NearbyActivity paramNearbyActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = (NearbyPushBanner)paramView.getTag();
    if ((paramView != null) && (paramView.a != null)) {
      paramView.a.a();
    }
    this.a.b("0X8004C1B");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ely
 * JD-Core Version:    0.7.0.1
 */