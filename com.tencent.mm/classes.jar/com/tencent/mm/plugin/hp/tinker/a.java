package com.tencent.mm.plugin.hp.tinker;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import java.lang.reflect.Method;

public final class a
{
  Handler handler = new Handler(Looper.getMainLooper());
  
  public a(Context paramContext, a.a parama)
  {
    Boolean localBoolean = bA(paramContext);
    com.tencent.tinker.lib.f.a.i("Tinker.ScreenOffRetryPatch", "try post ScreenOffRetryPatch delay time: %d, screen: %b", new Object[] { Long.valueOf(6000L), localBoolean });
    IntentFilter localIntentFilter = new IntentFilter();
    parama = new a.1(this, parama);
    if ((localBoolean != null) && (!localBoolean.booleanValue()))
    {
      com.tencent.tinker.lib.f.a.i("Tinker.ScreenOffRetryPatch", "screen is just off now, we can send message directly", new Object[0]);
      localIntentFilter.addAction("android.intent.action.SCREEN_ON");
      this.handler.postDelayed(parama, 6000L);
    }
    for (;;)
    {
      paramContext.registerReceiver(new a.2(this, parama), localIntentFilter);
      return;
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      localIntentFilter.addAction("android.intent.action.SCREEN_ON");
    }
  }
  
  private static Boolean bA(Context paramContext)
  {
    try
    {
      paramContext = (Boolean)PowerManager.class.getMethod("isScreenOn", new Class[0]).invoke((PowerManager)paramContext.getSystemService("power"), new Object[0]);
      return paramContext;
    }
    catch (Exception paramContext) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.tinker.a
 * JD-Core Version:    0.7.0.1
 */