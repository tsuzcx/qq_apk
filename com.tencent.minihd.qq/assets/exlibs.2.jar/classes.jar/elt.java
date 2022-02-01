import android.app.Dialog;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;

public class elt
  implements View.OnClickListener
{
  public elt(NearbyActivity paramNearbyActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new ProfileActivity.AllInOne(this.a.app.a(), 0);
    Intent localIntent = new Intent(this.a, NearbyPeopleProfileActivity.class);
    localIntent.putExtra("param_mode", 1);
    localIntent.putExtra("AllInOne", paramView);
    this.a.startActivity(localIntent);
    NearbyActivity.b(this.a).dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     elt
 * JD-Core Version:    0.7.0.1
 */