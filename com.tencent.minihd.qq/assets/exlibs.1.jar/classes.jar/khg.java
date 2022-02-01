import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.troop.activity.TroopCreateActivity;

public class khg
  extends BroadcastReceiver
{
  public khg(TroopCreateActivity paramTroopCreateActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    TroopCreateActivity.a(this.a, paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     khg
 * JD-Core Version:    0.7.0.1
 */