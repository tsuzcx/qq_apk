package com.tencent.mm.plugin.expt.hellhound.core.stack;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public class HomeKeyMonitor$MonitorReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(73372);
    if (!this.lZT.lZS)
    {
      AppMethodBeat.o(73372);
      return;
    }
    this.lZT.lZS = false;
    if ("android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(paramIntent.getAction()))
    {
      paramContext = paramIntent.getStringExtra("reason");
      if (paramContext != null)
      {
        if (paramContext.equals("homekey"))
        {
          ab.i("HomeKeyMonitor", "habbyge-homeKey ------------------ " + Process.myPid());
          AppMethodBeat.o(73372);
          return;
        }
        if (paramContext.equals("recentapps")) {
          ab.i("HomeKeyMonitor", "habbyge-multiTaskKey ------------------ " + Process.myPid());
        }
      }
    }
    AppMethodBeat.o(73372);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.stack.HomeKeyMonitor.MonitorReceiver
 * JD-Core Version:    0.7.0.1
 */