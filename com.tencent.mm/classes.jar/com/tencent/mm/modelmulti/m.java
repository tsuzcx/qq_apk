package com.tencent.mm.modelmulti;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.lang.reflect.Method;

public final class m
{
  Boolean ifL;
  
  public m(Context paramContext, final a parama)
  {
    AppMethodBeat.i(150782);
    this.ifL = null;
    this.ifL = cE(paramContext);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.SCREEN_ON");
    localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
    paramContext.registerReceiver(new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(150781);
        if (paramAnonymousIntent == null)
        {
          paramAnonymousIntent = "";
          ad.i("MicroMsg.ScreenState", "ScreenReceiver action [%s] ", new Object[] { paramAnonymousIntent });
          if (!"android.intent.action.SCREEN_OFF".equals(paramAnonymousIntent)) {
            break label98;
          }
        }
        label98:
        for (m.this.ifL = Boolean.FALSE;; m.this.ifL = Boolean.TRUE)
        {
          if (parama != null) {
            parama.ch(m.this.ifL.booleanValue());
          }
          if (this.ifN) {
            paramAnonymousContext.unregisterReceiver(this);
          }
          AppMethodBeat.o(150781);
          return;
          paramAnonymousIntent = paramAnonymousIntent.getAction();
          break;
        }
      }
    }, localIntentFilter);
    AppMethodBeat.o(150782);
  }
  
  private Boolean cE(Context paramContext)
  {
    AppMethodBeat.i(150783);
    try
    {
      paramContext = (Boolean)PowerManager.class.getMethod("isScreenOn", new Class[0]).invoke((PowerManager)paramContext.getSystemService("power"), new Object[0]);
      ad.i("MicroMsg.ScreenState", "reflectScreenOn: byReflect:%s isScreenOn:%s", new Object[] { paramContext, this.ifL });
      AppMethodBeat.o(150783);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      g.yhR.idkeyStat(99L, 154L, 1L, false);
      ad.e("MicroMsg.ScreenState", "reflectScreenOn invoke ERROR use isScreenOn:%s e:%s", new Object[] { this.ifL, bt.n(paramContext) });
      AppMethodBeat.o(150783);
    }
    return null;
  }
  
  public static abstract interface a
  {
    public abstract void ch(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelmulti.m
 * JD-Core Version:    0.7.0.1
 */