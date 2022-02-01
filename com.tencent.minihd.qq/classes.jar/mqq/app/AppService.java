package mqq.app;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;

public class AppService
  extends Service
{
  protected static final int CONFIG_NEED_RUNTIME = 0;
  protected static final int CONFIG_NO_NEED_RUNTIME = 1;
  BroadcastReceiver accountReceiver;
  protected AppRuntime app;
  
  private void initReceiver()
  {
    if (this.accountReceiver == null)
    {
      this.accountReceiver = new BroadcastReceiver()
      {
        public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
        {
          if ((paramAnonymousIntent == null) || (paramAnonymousIntent.getAction() == null)) {}
          while (!paramAnonymousIntent.getAction().equals("mqq.intent.action.ACCOUNT_CHANGED")) {
            return;
          }
          AppService.this.app = MobileQQ.getMobileQQ().waitAppRuntime(null);
        }
      };
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("mqq.intent.action.ACCOUNT_CHANGED");
      registerReceiver(this.accountReceiver, localIntentFilter);
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  protected int onConfigRuntime()
  {
    return 0;
  }
  
  public void onCreate()
  {
    super.onCreate();
    MobileQQ.sMobileQQ.onActivityCreate(this, null);
    if (onConfigRuntime() == 0) {
      this.app = MobileQQ.getMobileQQ().waitAppRuntime(null);
    }
    try
    {
      initReceiver();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.accountReceiver != null)
    {
      unregisterReceiver(this.accountReceiver);
      this.accountReceiver = null;
    }
    this.app = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     mqq.app.AppService
 * JD-Core Version:    0.7.0.1
 */