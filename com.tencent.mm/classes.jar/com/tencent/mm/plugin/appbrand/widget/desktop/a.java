package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ba.d;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
{
  private static int uzq;
  public static float uzr;
  public static int uzs;
  public static float uzt;
  public static int uzu;
  public static final int uzv;
  private static float uzw;
  private static int uzx;
  private static int uzy;
  private static int uzz;
  
  static
  {
    AppMethodBeat.i(49439);
    uzq = 1;
    uzr = 4.5F;
    uzs = 4;
    uzt = 3.5F;
    uzu = 3;
    uzv = AppBrandGlobalSystemConfig.ckD().qWV;
    uzw = uzr;
    uzx = uzs;
    uzy = 3;
    uzz = 0;
    AppMethodBeat.o(49439);
  }
  
  public static boolean cPg()
  {
    return uzq == 2;
  }
  
  public static void init(Context paramContext)
  {
    AppMethodBeat.i(49437);
    Log.i("MicroMsg.AppBrandDesktopConfig", "alvinluo DesktopConfig init mCurrentType: %d", new Object[] { Integer.valueOf(uzq) });
    if (uzq == 1)
    {
      uzr = 4.0F;
      uzs = 4;
      uzt = 3.0F;
      uzu = 3;
      uzw = uzr;
      uzx = uzs;
    }
    int j = b.c(paramContext, uzw);
    int i = j;
    if (uzq == 1) {
      i = (int)(j + paramContext.getResources().getDimensionPixelSize(ba.d.SmallPadding) * 2 * b.getScaleSize(paramContext));
    }
    if (i <= com.tencent.mm.cd.a.fromDPToPix(paramContext, 10)) {
      uzw = uzt;
    }
    for (uzx = uzu;; uzx = uzs)
    {
      uzy = 3;
      i = Math.max(3, 1);
      uzy = i;
      uzy = Math.min(i, 4);
      Log.i("MicroMsg.AppBrandDesktopConfig", "alvinluo DesktopConfig init showCountPerPage: %f, completelyShowCountPerPage: %d, mRecentAppBrandMaxShowLines: %d", new Object[] { Float.valueOf(uzw), Integer.valueOf(uzx), Integer.valueOf(uzy) });
      AppMethodBeat.o(49437);
      return;
      uzw = uzr;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.a
 * JD-Core Version:    0.7.0.1
 */