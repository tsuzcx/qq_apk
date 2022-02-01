package com.tencent.mm.plugin.expt.hellhound.core.stack;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;

@Deprecated
public final class HomeKeyMonitor
{
  boolean qjn;
  
  public class MonitorReceiver
    extends BroadcastReceiver
  {
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(121898);
      if (!this.qjo.qjn)
      {
        AppMethodBeat.o(121898);
        return;
      }
      this.qjo.qjn = false;
      if ("android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(paramIntent.getAction()))
      {
        paramContext = paramIntent.getStringExtra("reason");
        if (paramContext != null)
        {
          if (paramContext.equals("homekey"))
          {
            ac.i("HomeKeyMonitor", "habbyge-homeKey ------------------ %d", new Object[] { Integer.valueOf(Process.myPid()) });
            AppMethodBeat.o(121898);
            return;
          }
          if (paramContext.equals("recentapps")) {
            ac.i("HomeKeyMonitor", "habbyge-multiTaskKey ------------------ %d", new Object[] { Integer.valueOf(Process.myPid()) });
          }
        }
      }
      AppMethodBeat.o(121898);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.stack.HomeKeyMonitor
 * JD-Core Version:    0.7.0.1
 */