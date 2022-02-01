package c.t.m.g;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;

final class m
  extends BroadcastReceiver
{
  m(j paramj) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    ax.a("AccessSchedulerTrigger", "onAccessSchedulerTriggered by timer, curTime:" + SystemClock.elapsedRealtime());
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     c.t.m.g.m
 * JD-Core Version:    0.7.0.1
 */