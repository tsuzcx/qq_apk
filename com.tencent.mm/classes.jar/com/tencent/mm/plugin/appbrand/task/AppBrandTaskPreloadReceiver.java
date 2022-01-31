package com.tencent.mm.plugin.appbrand.task;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.c;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public class AppBrandTaskPreloadReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(132873);
    boolean bool = bo.nullAsNil(paramIntent.getStringExtra("EXTRA_KEY_UI_CLASS")).endsWith(AppBrandPluginUI.class.getSimpleName());
    long l = SystemClock.elapsedRealtime();
    paramIntent.setExtrasClassLoader(AppBrandPreloadProfiler.class.getClassLoader());
    paramContext = (AppBrandPreloadProfiler)paramIntent.getParcelableExtra("preloadProfiler");
    c.a(g.H(paramIntent), paramContext, bool);
    ab.i("MicroMsg.AppBrandTaskPreloadReceiver", "[PreloadProfile] Receiver cost [%d]ms, at [%d]", new Object[] { Long.valueOf(SystemClock.elapsedRealtime() - l), Long.valueOf(l) });
    AppMethodBeat.o(132873);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.AppBrandTaskPreloadReceiver
 * JD-Core Version:    0.7.0.1
 */