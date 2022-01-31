package com.tencent.mm.plugin.dbbackup;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import java.text.SimpleDateFormat;
import java.util.Date;

final class d$9
  extends BroadcastReceiver
{
  d$9(d paramd) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    int i = -1;
    switch (paramContext.hashCode())
    {
    default: 
      switch (i)
      {
      default: 
        label84:
        y.v("MicroMsg.SubCoreDBBackup", "Action received: %s, interactive: %s, charging: %s", new Object[] { paramContext, Boolean.valueOf(d.i(this.iNn)), Boolean.valueOf(d.j(this.iNn)) });
        if ((d.h(this.iNn)) && (d.k(this.iNn) == null) && (d.j(this.iNn)) && (!d.i(this.iNn))) {
          if (System.currentTimeMillis() - d.l(this.iNn) < 86400000L) {
            y.d("MicroMsg.SubCoreDBBackup", "Last backup time not matched.");
          }
        }
        break;
      }
      break;
    }
    do
    {
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
      d.b(this.iNn, true);
      break label84;
      d.b(this.iNn, false);
      break label84;
      d.c(this.iNn, true);
      break label84;
      d.c(this.iNn, false);
      break label84;
      if (d.m(this.iNn) < 10) {}
      for (boolean bool = true;; bool = false)
      {
        paramContext = new d.9.1(this, bool);
        d.a(this.iNn, new d.9.2(this, bool, paramContext));
        au.DS().k(d.k(this.iNn), d.g(this.iNn));
        y.i("MicroMsg.SubCoreDBBackup", "Auto database backup scheduled.");
        h.nFQ.f(11098, new Object[] { Integer.valueOf(10009), this.iNn.iMX.format(new Date()) });
        return;
      }
      if (d.k(this.iNn) != null)
      {
        au.DS().crf().removeCallbacks(d.k(this.iNn));
        d.a(this.iNn, null);
        y.i("MicroMsg.SubCoreDBBackup", "Auto database backup canceled.");
        h.nFQ.f(11098, new Object[] { Integer.valueOf(10010), this.iNn.iMX.format(new Date()) });
        return;
      }
    } while (!d.o(this.iNn));
    this.iNn.aFw();
    d.d(this.iNn, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.dbbackup.d.9
 * JD-Core Version:    0.7.0.1
 */