package com.tencent.mm.plugin.appbrand.widget.recent;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.ba.d;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;

public final class d
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
    AppMethodBeat.i(324067);
    uzq = 1;
    uzr = 4.5F;
    uzs = 4;
    uzt = 3.5F;
    uzu = 3;
    uzv = AppBrandGlobalSystemConfig.ckD().qWV;
    uzw = uzr;
    uzx = uzs;
    uzy = 1;
    uzz = 0;
    AppMethodBeat.o(324067);
  }
  
  public static boolean cPg()
  {
    return uzq == 2;
  }
  
  public static boolean cSN()
  {
    return true;
  }
  
  public static int getCompletelyCountPerPage()
  {
    return uzx;
  }
  
  public static void init(Context paramContext)
  {
    AppMethodBeat.i(324055);
    Log.i("MicroMsg.AppBrandRecentConfig", "alvinluo DesktopConfig init mCurrentType: %d", new Object[] { Integer.valueOf(uzq) });
    if (uzq == 1)
    {
      uzr = 4.0F;
      uzs = 4;
      uzt = 3.0F;
      uzu = 3;
      uzw = uzr;
      uzx = uzs;
    }
    int j = f.c(paramContext, uzw);
    int i = j;
    if (uzq == 1) {
      i = (int)(j + paramContext.getResources().getDimensionPixelSize(ba.d.SmallPadding) * 2 * f.getScaleSize(paramContext));
    }
    if (i <= a.fromDPToPix(paramContext, 10)) {
      uzw = uzt;
    }
    for (uzx = uzu;; uzx = uzs)
    {
      i = ((c)h.ax(c.class)).a(c.a.zki, 1);
      uzy = i;
      i = Math.max(i, 1);
      uzy = i;
      uzy = Math.min(i, 4);
      Log.i("MicroMsg.AppBrandRecentConfig", "alvinluo DesktopConfig init showCountPerPage: %f, completelyShowCountPerPage: %d, mRecentAppBrandMaxShowLines: %d", new Object[] { Float.valueOf(uzw), Integer.valueOf(uzx), Integer.valueOf(uzy) });
      AppMethodBeat.o(324055);
      return;
      uzw = uzr;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recent.d
 * JD-Core Version:    0.7.0.1
 */