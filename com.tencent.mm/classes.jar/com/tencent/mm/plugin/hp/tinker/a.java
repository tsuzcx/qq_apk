package com.tencent.mm.plugin.hp.tinker;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import java.lang.reflect.Method;

public final class a
{
  Handler handler;
  
  public a(Context paramContext, final a parama)
  {
    AppMethodBeat.i(117454);
    this.handler = new Handler(Looper.getMainLooper());
    Boolean localBoolean = dc(paramContext);
    ShareTinkerLog.v("Tinker.ScreenOffRetryPatch", "try post ScreenOffRetryPatch delay time: %d, screen: %b", new Object[] { Long.valueOf(6000L), localBoolean });
    IntentFilter localIntentFilter = new IntentFilter();
    parama = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(117452);
        if (parama != null)
        {
          ShareTinkerLog.v("Tinker.ScreenOffRetryPatch", "ScreenOffRetryPatch runnable try to start", new Object[0]);
          parama.dZg();
        }
        AppMethodBeat.o(117452);
      }
    };
    if ((localBoolean != null) && (!localBoolean.booleanValue()))
    {
      ShareTinkerLog.v("Tinker.ScreenOffRetryPatch", "screen is just off now, we can send message directly", new Object[0]);
      localIntentFilter.addAction("android.intent.action.SCREEN_ON");
      this.handler.postDelayed(parama, 6000L);
    }
    for (;;)
    {
      paramContext.registerReceiver(new BroadcastReceiver()
      {
        public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
        {
          AppMethodBeat.i(117453);
          if (paramAnonymousIntent == null) {}
          for (paramAnonymousIntent = ""; "android.intent.action.SCREEN_OFF".equals(paramAnonymousIntent); paramAnonymousIntent = paramAnonymousIntent.getAction())
          {
            ShareTinkerLog.v("Tinker.ScreenOffRetryPatch", "ScreenOffRetryPatch screen off now, send message now", new Object[0]);
            a.this.handler.postDelayed(parama, this.ynh);
            AppMethodBeat.o(117453);
            return;
          }
          ShareTinkerLog.v("Tinker.ScreenOffRetryPatch", "ScreenOffRetryPatch screen on, remove pending runnable and receive", new Object[0]);
          a.this.handler.removeCallbacks(parama);
          paramAnonymousContext.unregisterReceiver(this);
          AppMethodBeat.o(117453);
        }
      }, localIntentFilter);
      AppMethodBeat.o(117454);
      return;
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      localIntentFilter.addAction("android.intent.action.SCREEN_ON");
    }
  }
  
  private static Boolean dc(Context paramContext)
  {
    AppMethodBeat.i(117455);
    try
    {
      paramContext = (Boolean)PowerManager.class.getMethod("isScreenOn", new Class[0]).invoke((PowerManager)paramContext.getSystemService("power"), new Object[0]);
      AppMethodBeat.o(117455);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(117455);
    }
    return null;
  }
  
  public static abstract interface a
  {
    public abstract void dZg();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.tinker.a
 * JD-Core Version:    0.7.0.1
 */