package com.tencent.mm.plugin.appbrand.task;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.tencent.mm.plugin.appbrand.app.b;
import com.tencent.mm.sdk.platformtools.y;

public class AppBrandTaskPreloadReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    long l = SystemClock.elapsedRealtime();
    paramIntent.setExtrasClassLoader(AppBrandPreloadProfiler.class.getClassLoader());
    paramContext = (AppBrandPreloadProfiler)paramIntent.getParcelableExtra("preloadProfiler");
    b.a(f.q(paramIntent), paramContext);
    y.i("MicroMsg.AppBrandTaskPreloadReceiver", "[PreloadProfile] Receiver cost [%d]ms, at [%d]", new Object[] { Long.valueOf(SystemClock.elapsedRealtime() - l), Long.valueOf(l) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.AppBrandTaskPreloadReceiver
 * JD-Core Version:    0.7.0.1
 */