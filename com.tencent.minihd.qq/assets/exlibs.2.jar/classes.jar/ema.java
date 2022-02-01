import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.NearPeopleFilterActivity;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.dating.DatingBaseActivity;
import com.tencent.mobileqq.nearby.NearbyUserBehaviorReport;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;

public class ema
  implements View.OnClickListener
{
  public ema(NearbyActivity paramNearbyActivity) {}
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag()).intValue();
    NearbyActivity.d(this.a, false);
    switch (i)
    {
    }
    do
    {
      do
      {
        for (;;)
        {
          return;
          if (NearbyActivity.a(this.a)) {
            this.a.a(0, this.a.getString(2131369570));
          }
          while (this.a.a != null)
          {
            this.a.a.b(4);
            return;
            NearPeopleFilterActivity.a(this.a, NearbyActivity.a(this.a), NearbyActivity.c);
            this.a.b("0X8004441");
          }
        }
        paramView = new ProfileActivity.AllInOne(this.a.app.a(), 0);
        Intent localIntent = new Intent(this.a, NearbyPeopleProfileActivity.class);
        localIntent.putExtra("param_mode", 2);
        localIntent.putExtra("AllInOne", paramView);
        this.a.startActivityForResult(localIntent, 1000);
        DatingBaseActivity.a(this.a.app, "0X800482F");
      } while (this.a.a == null);
      this.a.a.b(0);
      return;
      this.a.a(new emb(this));
    } while (this.a.a == null);
    this.a.a.b(5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ema
 * JD-Core Version:    0.7.0.1
 */