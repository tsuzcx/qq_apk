package com.tencent.mm.modelstat;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.ms;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

final class n$a
  extends BroadcastReceiver
{
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(151115);
    try
    {
      if (h.aHE().aGM())
      {
        h.aHE();
        if (!b.aGE()) {}
      }
      else
      {
        bool = h.aHE().aGM();
        h.aHE();
        Log.e("MicroMsg.NetTypeReporter", "onReceive acc not ready .%b %b", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(b.aGE()) });
        AppMethodBeat.o(151115);
        return;
      }
      if ((paramIntent == null) || (Util.isNullOrNil(paramIntent.getAction())))
      {
        if (paramIntent == null) {}
        for (paramContext = "intent is null";; paramContext = "action is null")
        {
          Log.e("MicroMsg.NetTypeReporter", "onReceive %s  ", new Object[] { paramContext });
          AppMethodBeat.o(151115);
          return;
        }
      }
      paramContext = paramIntent.getAction();
      Log.i("MicroMsg.NetTypeReporter", "onReceive action:%s foreground:%b", new Object[] { paramContext, Boolean.valueOf(CrashReportFactory.foreground) });
      boolean bool = CrashReportFactory.foreground;
      if (!bool)
      {
        AppMethodBeat.o(151115);
        return;
      }
      if (paramContext.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
        EventCenter.instance.publish(new ms());
      }
      AppMethodBeat.o(151115);
      return;
    }
    catch (Throwable paramContext)
    {
      Log.e("MicroMsg.NetTypeReporter", "onReceive : %s", new Object[] { Util.stackTraceToString(paramContext) });
      AppMethodBeat.o(151115);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelstat.n.a
 * JD-Core Version:    0.7.0.1
 */