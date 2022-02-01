package c.t.m.g;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

final class k
  extends BroadcastReceiver
{
  k(j paramj) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    try
    {
      ax.a("AccessSchedulerTrigger", "Network changed");
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext == null)
      {
        j.a(this.a, -1);
        ax.a("AccessSchedulerTrigger", "no active network now");
        aw.a(false);
        return;
      }
      if ((paramContext.isAvailable()) && (paramContext.isConnected()))
      {
        aw.b();
        aw.a(true);
        aw.f();
        if ((System.currentTimeMillis() - j.a(this.a) > 5000L) && (paramContext.getType() != j.b(this.a)))
        {
          ax.a("AccessSchedulerTrigger", "onAccessSchedulerTriggered by network change");
          this.a.b();
          j.a(this.a, System.currentTimeMillis());
        }
        j.a(this.a, paramContext.getType());
        return;
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      return;
    }
    j.a(this.a, -1);
    ax.a("AccessSchedulerTrigger", "network not available or not connected");
    aw.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     c.t.m.g.k
 * JD-Core Version:    0.7.0.1
 */