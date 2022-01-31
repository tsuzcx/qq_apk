package com.tencent.mm.plugin.h;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;

final class b$2
  extends BroadcastReceiver
{
  b$2(b paramb) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
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
      if ((!b.j(this.ijs)) || (b.k(this.ijs))) {
        break label259;
      }
      y.i("MicroMsg.CalcWxService", "it is charging and screen off, 5 min to calc");
      if (b.l(this.ijs) == null)
      {
        b.b(this.ijs, new b.2.1(this));
        au.DS().k(b.l(this.ijs), 300000L);
      }
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
      b.b(this.ijs, true);
      continue;
      b.b(this.ijs, false);
      continue;
      b.c(this.ijs, true);
      continue;
      b.c(this.ijs, false);
    }
    label259:
    if (b.l(this.ijs) != null)
    {
      au.DS();
      ai.S(b.l(this.ijs));
      b.b(this.ijs, null);
    }
    b.m(this.ijs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.h.b.2
 * JD-Core Version:    0.7.0.1
 */