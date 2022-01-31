package com.tencent.mm.plugin.appbrand.app;

import android.os.SystemClock;
import com.tencent.mm.plugin.appbrand.task.AppBrandPreloadProfiler;
import com.tencent.mm.plugin.appbrand.task.f;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;

public final class b
{
  private static volatile boolean fAJ = false;
  
  public static void a(f paramf, AppBrandPreloadProfiler paramAppBrandPreloadProfiler)
  {
    if ((paramf == null) || (paramf == f.hbW))
    {
      y.i("MicroMsg.AppBrandProcessProfileInit[applaunch]", "dl: AppBrandProcessPreloader said I can not preload [nil] type.");
      return;
    }
    AppBrandPreloadProfiler localAppBrandPreloadProfiler = paramAppBrandPreloadProfiler;
    if (paramAppBrandPreloadProfiler == null) {
      localAppBrandPreloadProfiler = new AppBrandPreloadProfiler();
    }
    localAppBrandPreloadProfiler.hbe = SystemClock.elapsedRealtime();
    ai.d(new b.1(paramf, localAppBrandPreloadProfiler));
  }
  
  public static void aaJ()
  {
    y.i("MicroMsg.AppBrandProcessProfileInit[applaunch]", "setSkipMiscPreload %b", new Object[] { Boolean.valueOf(true) });
    fAJ = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.b
 * JD-Core Version:    0.7.0.1
 */