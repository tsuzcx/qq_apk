package c.t.m.g;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.SystemClock;

final class j
{
  private static j c = null;
  private long a = -1L;
  private int b = -1;
  private n d;
  private BroadcastReceiver e = new k(this);
  private BroadcastReceiver f = new m(this);
  
  public static j a()
  {
    try
    {
      if (c == null) {
        c = new j();
      }
      j localj = c;
      return localj;
    }
    finally {}
  }
  
  public final void a(n paramn)
  {
    this.d = paramn;
    paramn = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
    o.a().registerReceiver(this.e, paramn);
    ax.b("AccessSchedulerTrigger", "startListenNetworkChange...");
    ax.b("AccessSchedulerTrigger", "try startAccessSchedulerTimer...");
    paramn = new IntentFilter("action.scheduler.access.trigger.timer");
    o.a().registerReceiver(this.f, paramn);
    paramn = (AlarmManager)o.a().getSystemService("alarm");
    if (paramn != null)
    {
      long l = SystemClock.elapsedRealtime();
      Intent localIntent = new Intent("action.scheduler.access.trigger.timer");
      paramn.setRepeating(3, l + 1800000L, 1800000L, PendingIntent.getBroadcast(o.a(), 0, localIntent, 0));
      ax.a("AccessSchedulerTrigger", "startAccessSchedulerTimer timer start...");
    }
  }
  
  public final void b()
  {
    if (this.d != null)
    {
      this.d.b();
      return;
    }
    ax.c("AccessSchedulerTrigger", "onAccessSchedulerTriggered not call for triggerlistener is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     c.t.m.g.j
 * JD-Core Version:    0.7.0.1
 */