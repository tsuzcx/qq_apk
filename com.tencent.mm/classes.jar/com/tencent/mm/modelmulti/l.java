package com.tencent.mm.modelmulti;

import android.content.Context;
import android.content.IntentFilter;
import android.os.PowerManager;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.reflect.Method;

public final class l
{
  Boolean ety = null;
  
  public l(Context paramContext, l.a parama, boolean paramBoolean)
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.SCREEN_ON");
    localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
    paramContext.registerReceiver(new l.1(this, parama, paramBoolean), localIntentFilter);
  }
  
  private Boolean bA(Context paramContext)
  {
    try
    {
      paramContext = (Boolean)PowerManager.class.getMethod("isScreenOn", new Class[0]).invoke((PowerManager)paramContext.getSystemService("power"), new Object[0]);
      y.i("MicroMsg.ScreenState", "reflectScreenOn: byReflect:%s isScreenOn:%s", new Object[] { paramContext, this.ety });
      return paramContext;
    }
    catch (Exception paramContext)
    {
      h.nFQ.a(99L, 154L, 1L, false);
      y.e("MicroMsg.ScreenState", "reflectScreenOn invoke ERROR use isScreenOn:%s e:%s", new Object[] { this.ety, bk.j(paramContext) });
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelmulti.l
 * JD-Core Version:    0.7.0.1
 */