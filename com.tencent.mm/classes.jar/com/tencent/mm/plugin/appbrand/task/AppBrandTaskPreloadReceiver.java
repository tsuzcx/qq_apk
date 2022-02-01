package com.tencent.mm.plugin.appbrand.task;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.sdk.platformtools.Log;

public class AppBrandTaskPreloadReceiver
  extends BroadcastReceiver
{
  public static void c(String paramString, Intent paramIntent)
  {
    AppMethodBeat.i(48473);
    if (paramIntent == null)
    {
      Log.e("MicroMsg.AppBrandTaskPreloadReceiver", "[PreloadProfile][%s] Receiver get NULL intent", new Object[] { paramString });
      AppMethodBeat.o(48473);
      return;
    }
    paramIntent.setExtrasClassLoader(AppBrandPreloadProfiler.class.getClassLoader());
    int i = paramIntent.getIntExtra("EXTRA_KEY_LEVEL", 2);
    long l1 = SystemClock.elapsedRealtime();
    long l2 = paramIntent.getLongExtra("EXTRA_KEY_TRIGGER_TIME", -1L);
    AppBrandPreloadProfiler localAppBrandPreloadProfiler = (AppBrandPreloadProfiler)paramIntent.getParcelableExtra("preloadProfiler");
    e.a(g.L(paramIntent), localAppBrandPreloadProfiler, paramIntent.getBooleanExtra("EXTRA_KEY_AGGRESSIVE", false), i);
    Log.i("MicroMsg.AppBrandTaskPreloadReceiver", "[PreloadProfile][%s] Trigger cost [%d]ms Receiver cost [%d]ms, at [%d], level [%d]", new Object[] { paramString, Long.valueOf(SystemClock.elapsedRealtime() - l2), Long.valueOf(SystemClock.elapsedRealtime() - l1), Long.valueOf(l1), Integer.valueOf(i) });
    AppMethodBeat.o(48473);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(48472);
    c("", paramIntent);
    AppMethodBeat.o(48472);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.AppBrandTaskPreloadReceiver
 * JD-Core Version:    0.7.0.1
 */