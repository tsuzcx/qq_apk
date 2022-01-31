package com.tencent.mm.plugin.f;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

final class b$4
  extends BroadcastReceiver
{
  b$4(b paramb) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(18580);
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
      if ((!b.j(this.kks)) || (b.k(this.kks))) {
        break label273;
      }
      ab.i("MicroMsg.CalcWxService", "it is charging and screen off, 5 min to calc");
      if (b.l(this.kks) != null) {
        break label313;
      }
      b.b(this.kks, new b.4.1(this));
      aw.RO().o(b.l(this.kks), 300000L);
      AppMethodBeat.o(18580);
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
      b.b(this.kks, true);
      continue;
      b.b(this.kks, false);
      continue;
      b.c(this.kks, true);
      continue;
      b.c(this.kks, false);
    }
    label273:
    if (b.l(this.kks) != null)
    {
      aw.RO();
      al.ae(b.l(this.kks));
      b.b(this.kks, null);
    }
    b.m(this.kks);
    label313:
    AppMethodBeat.o(18580);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.f.b.4
 * JD-Core Version:    0.7.0.1
 */