import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class jik
  implements View.OnClickListener
{
  public jik(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity) {}
  
  public void onClick(View paramView)
  {
    if ((NearbyPeopleProfileActivity.a(this.a) != null) && (!this.a.isFinishing()))
    {
      NearbyPeopleProfileActivity.a(this.a).dismiss();
      NearbyPeopleProfileActivity.a(this.a, null);
    }
    this.a.c();
    ReportController.b(this.a.app, "CliOper", "", "", "0X8004824", "0X8004824", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jik
 * JD-Core Version:    0.7.0.1
 */