import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.EditText;
import com.tencent.mobileqq.activity.SoftInputActivity;

public class faz
  extends BroadcastReceiver
{
  public faz(SoftInputActivity paramSoftInputActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    Log.i("app2", "soft-->action=" + paramContext);
    if ("clear_text".equals(paramContext)) {
      SoftInputActivity.a(this.a).setText("");
    }
    while (!"hide_soft_panel".equals(paramContext)) {
      return;
    }
    SoftInputActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     faz
 * JD-Core Version:    0.7.0.1
 */