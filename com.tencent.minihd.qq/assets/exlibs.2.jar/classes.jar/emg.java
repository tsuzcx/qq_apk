import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.NearPeopleFilterActivity;
import com.tencent.mobileqq.activity.NearbyActivity;

public class emg
  implements View.OnClickListener
{
  public emg(NearbyActivity paramNearbyActivity) {}
  
  public void onClick(View paramView)
  {
    if (NearbyActivity.a(this.a))
    {
      this.a.a(0, this.a.getString(2131369570));
      return;
    }
    NearPeopleFilterActivity.a(this.a, NearbyActivity.a(this.a), NearbyActivity.c);
    this.a.b("0X8004441");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     emg
 * JD-Core Version:    0.7.0.1
 */