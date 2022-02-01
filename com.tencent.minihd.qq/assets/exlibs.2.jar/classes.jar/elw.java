import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.dating.CarrierHelper;

public class elw
  implements View.OnClickListener
{
  public elw(NearbyActivity paramNearbyActivity) {}
  
  public void onClick(View paramView)
  {
    if (NearbyActivity.a(this.a) != null) {
      NearbyActivity.a(this.a).a(0, Boolean.valueOf(true));
    }
    NearbyActivity.f(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     elw
 * JD-Core Version:    0.7.0.1
 */