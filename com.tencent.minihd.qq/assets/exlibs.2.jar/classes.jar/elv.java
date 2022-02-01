import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class elv
  implements DialogInterface.OnDismissListener
{
  public elv(NearbyActivity paramNearbyActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.app.getPreferences().edit().putBoolean("nearby_people_portrait_guide_ok", true).commit();
    NearbyActivity.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     elv
 * JD-Core Version:    0.7.0.1
 */