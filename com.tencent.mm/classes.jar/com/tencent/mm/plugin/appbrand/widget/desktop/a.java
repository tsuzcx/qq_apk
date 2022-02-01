package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appusage.ag;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
{
  private static int omD;
  public static float omE;
  public static int omF;
  public static float omG;
  public static int omH;
  public static final int omI;
  private static float omJ;
  private static int omK;
  private static int omL;
  private static int omM;
  
  static
  {
    AppMethodBeat.i(49439);
    omD = 1;
    omE = 4.5F;
    omF = 4;
    omG = 3.5F;
    omH = 3;
    omI = AppBrandGlobalSystemConfig.bzP().lcW;
    omJ = omE;
    omK = omF;
    omL = 3;
    omM = 0;
    AppMethodBeat.o(49439);
  }
  
  public static int byo()
  {
    AppMethodBeat.i(49434);
    if (omM == 0) {
      omM = ((ag)g.af(ag.class)).bxH();
    }
    int i = omM;
    AppMethodBeat.o(49434);
    return i;
  }
  
  public static boolean cak()
  {
    return omD == 2;
  }
  
  public static int cal()
  {
    return omL;
  }
  
  public static int getCompletelyCountPerPage()
  {
    return omK;
  }
  
  public static float getShowCountPerPage()
  {
    return omJ;
  }
  
  public static void init(Context paramContext)
  {
    AppMethodBeat.i(49437);
    Log.i("MicroMsg.AppBrandDesktopConfig", "alvinluo DesktopConfig init mCurrentType: %d", new Object[] { Integer.valueOf(omD) });
    if (omD == 1)
    {
      omE = 4.0F;
      omF = 4;
      omG = 3.0F;
      omH = 3;
      omJ = omE;
      omK = omF;
    }
    int j = b.c(paramContext, omJ);
    int i = j;
    if (omD == 1) {
      i = (int)(j + paramContext.getResources().getDimensionPixelSize(2131165586) * 2 * b.ez(paramContext));
    }
    if (i <= com.tencent.mm.cb.a.fromDPToPix(paramContext, 10)) {
      omJ = omG;
    }
    for (omK = omH;; omK = omF)
    {
      omL = 3;
      i = Math.max(3, 1);
      omL = i;
      omL = Math.min(i, 4);
      Log.i("MicroMsg.AppBrandDesktopConfig", "alvinluo DesktopConfig init showCountPerPage: %f, completelyShowCountPerPage: %d, mRecentAppBrandMaxShowLines: %d", new Object[] { Float.valueOf(omJ), Integer.valueOf(omK), Integer.valueOf(omL) });
      AppMethodBeat.o(49437);
      return;
      omJ = omE;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.a
 * JD-Core Version:    0.7.0.1
 */