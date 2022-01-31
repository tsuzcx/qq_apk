package com.tencent.mm.plugin.appbrand.app;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.task.AppBrandPreloadProfiler;
import com.tencent.mm.plugin.appbrand.task.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

public final class c
{
  private static volatile boolean gSv = false;
  private static volatile boolean gSw = false;
  
  public static void a(g paramg, AppBrandPreloadProfiler paramAppBrandPreloadProfiler, boolean paramBoolean)
  {
    AppMethodBeat.i(143059);
    gSw = true;
    if ((paramg == null) || (paramg == g.iKU))
    {
      ab.i("MicroMsg.AppBrandProcessProfileInit[applaunch]", "dl: AppBrandProcessPreloader said I can not preload [nil] type.");
      AppMethodBeat.o(143059);
      return;
    }
    AppBrandPreloadProfiler localAppBrandPreloadProfiler = paramAppBrandPreloadProfiler;
    if (paramAppBrandPreloadProfiler == null) {
      localAppBrandPreloadProfiler = new AppBrandPreloadProfiler();
    }
    localAppBrandPreloadProfiler.iJX = SystemClock.elapsedRealtime();
    al.d(new c.1(paramg, paramBoolean, localAppBrandPreloadProfiler));
    AppMethodBeat.o(143059);
  }
  
  public static boolean auv()
  {
    return gSw;
  }
  
  public static void auw()
  {
    AppMethodBeat.i(129195);
    ab.i("MicroMsg.AppBrandProcessProfileInit[applaunch]", "setSkipMiscPreload %b", new Object[] { Boolean.TRUE });
    gSv = true;
    AppMethodBeat.o(129195);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.c
 * JD-Core Version:    0.7.0.1
 */