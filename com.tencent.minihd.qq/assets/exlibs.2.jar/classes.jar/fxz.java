import android.app.Activity;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class fxz
  extends BroadcastReceiver
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private boolean jdField_a_of_type_Boolean = true;
  
  public fxz(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public boolean a(Context paramContext)
  {
    return ((KeyguardManager)paramContext.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    boolean bool = true;
    paramIntent = paramIntent.getAction();
    if ("android.intent.action.SCREEN_ON".equals(paramIntent)) {
      if (!a(paramContext)) {
        this.jdField_a_of_type_Boolean = bool;
      }
    }
    for (;;)
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidAppActivity.unregisterReceiver(this);
        this.jdField_a_of_type_AndroidAppActivity.finish();
      }
      return;
      bool = false;
      break;
      if ("android.intent.action.SCREEN_OFF".equals(paramIntent)) {
        this.jdField_a_of_type_Boolean = false;
      } else if ("android.intent.action.USER_PRESENT".equals(paramIntent)) {
        this.jdField_a_of_type_Boolean = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fxz
 * JD-Core Version:    0.7.0.1
 */