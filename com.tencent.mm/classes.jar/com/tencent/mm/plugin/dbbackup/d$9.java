package com.tencent.mm.plugin.dbbackup;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import java.text.SimpleDateFormat;
import java.util.Date;

final class d$9
  extends BroadcastReceiver
{
  d$9(d paramd) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(18981);
    paramContext = paramIntent.getAction();
    int i = -1;
    switch (paramContext.hashCode())
    {
    default: 
      switch (i)
      {
      }
      break;
    }
    for (;;)
    {
      ab.v("MicroMsg.SubCoreDBBackup", "Action received: %s, interactive: %s, charging: %s", new Object[] { paramContext, Boolean.valueOf(d.i(this.kUn)), Boolean.valueOf(d.j(this.kUn)) });
      if ((!d.h(this.kUn)) || (d.k(this.kUn) != null) || (!d.j(this.kUn)) || (d.i(this.kUn))) {
        break label437;
      }
      if (System.currentTimeMillis() - d.l(this.kUn) >= 86400000L) {
        break label309;
      }
      ab.d("MicroMsg.SubCoreDBBackup", "Last backup time not matched.");
      AppMethodBeat.o(18981);
      return;
      if (!paramContext.equals("android.intent.action.SCREEN_ON")) {
        break;
      }
      i = 0;
      break;
      if (!paramContext.equals("android.intent.action.SCREEN_OFF")) {
        break;
      }
      i = 1;
      break;
      if (!paramContext.equals("android.intent.action.ACTION_POWER_CONNECTED")) {
        break;
      }
      i = 2;
      break;
      if (!paramContext.equals("android.intent.action.ACTION_POWER_DISCONNECTED")) {
        break;
      }
      i = 3;
      break;
      d.b(this.kUn, true);
      continue;
      d.b(this.kUn, false);
      continue;
      d.c(this.kUn, true);
      continue;
      d.c(this.kUn, false);
    }
    label309:
    if (d.m(this.kUn) < 10) {}
    for (boolean bool = true;; bool = false)
    {
      paramContext = new d.9.1(this, bool);
      d.a(this.kUn, new d.9.2(this, bool, paramContext));
      aw.RO().o(d.k(this.kUn), d.g(this.kUn));
      ab.i("MicroMsg.SubCoreDBBackup", "Auto database backup scheduled.");
      h.qsU.e(11098, new Object[] { Integer.valueOf(10009), this.kUn.kTX.format(new Date()) });
      AppMethodBeat.o(18981);
      return;
    }
    label437:
    if (d.k(this.kUn) != null)
    {
      aw.RO().caB().removeCallbacks(d.k(this.kUn));
      d.a(this.kUn, null);
      ab.i("MicroMsg.SubCoreDBBackup", "Auto database backup canceled.");
      h.qsU.e(11098, new Object[] { Integer.valueOf(10010), this.kUn.kTX.format(new Date()) });
      AppMethodBeat.o(18981);
      return;
    }
    if (d.o(this.kUn))
    {
      this.kUn.biP();
      d.d(this.kUn, false);
    }
    AppMethodBeat.o(18981);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.dbbackup.d.9
 * JD-Core Version:    0.7.0.1
 */