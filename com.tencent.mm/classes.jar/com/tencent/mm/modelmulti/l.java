package com.tencent.mm.modelmulti;

import android.content.Context;
import android.content.IntentFilter;
import android.os.PowerManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.reflect.Method;

public final class l
{
  Boolean fJl;
  
  public l(Context paramContext, l.a parama)
  {
    AppMethodBeat.i(78415);
    this.fJl = null;
    this.fJl = cf(paramContext);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.SCREEN_ON");
    localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
    paramContext.registerReceiver(new l.1(this, parama), localIntentFilter);
    AppMethodBeat.o(78415);
  }
  
  private Boolean cf(Context paramContext)
  {
    AppMethodBeat.i(78416);
    try
    {
      paramContext = (Boolean)PowerManager.class.getMethod("isScreenOn", new Class[0]).invoke((PowerManager)paramContext.getSystemService("power"), new Object[0]);
      ab.i("MicroMsg.ScreenState", "reflectScreenOn: byReflect:%s isScreenOn:%s", new Object[] { paramContext, this.fJl });
      AppMethodBeat.o(78416);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      h.qsU.idkeyStat(99L, 154L, 1L, false);
      ab.e("MicroMsg.ScreenState", "reflectScreenOn invoke ERROR use isScreenOn:%s e:%s", new Object[] { this.fJl, bo.l(paramContext) });
      AppMethodBeat.o(78416);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelmulti.l
 * JD-Core Version:    0.7.0.1
 */