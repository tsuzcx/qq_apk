package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appusage.ah;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.widget.desktop.a.c;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;

public final class b
{
  private static int lSY;
  public static float lSZ;
  public static int lTa;
  public static float lTb;
  public static int lTc;
  public static final int lTd;
  private static float lTe;
  private static int lTf;
  private static int lTg;
  private static int lTh;
  private static boolean lTi;
  
  static
  {
    AppMethodBeat.i(49439);
    lSY = 1;
    lSZ = 4.5F;
    lTa = 4;
    lTb = 3.5F;
    lTc = 3;
    lTd = AppBrandGlobalSystemConfig.aTv().jcv;
    lTe = lSZ;
    lTf = lTa;
    lTg = 1;
    lTh = 0;
    lTi = true;
    AppMethodBeat.o(49439);
  }
  
  public static int aSb()
  {
    AppMethodBeat.i(49434);
    if (lTh == 0) {
      lTh = ((ah)g.ab(ah.class)).aRv();
    }
    int i = lTh;
    AppMethodBeat.o(49434);
    return i;
  }
  
  public static boolean aaf()
  {
    AppMethodBeat.i(49435);
    ad.d("MicroMsg.AppBrandDesktopConfig", "alvinluo isEnableNativeDynamicBackground %b, thread: %d", new Object[] { Boolean.valueOf(lTi), Long.valueOf(Thread.currentThread().getId()) });
    boolean bool = lTi;
    AppMethodBeat.o(49435);
    return bool;
  }
  
  public static boolean brC()
  {
    return lSY == 2;
  }
  
  public static boolean brD()
  {
    return true;
  }
  
  public static void brE()
  {
    AppMethodBeat.i(49438);
    SharedPreferences localSharedPreferences = aj.eFE();
    if (localSharedPreferences == null)
    {
      AppMethodBeat.o(49438);
      return;
    }
    boolean bool1 = localSharedPreferences.getBoolean("enable_dynamic_background_for_test", false);
    if (bool1)
    {
      ad.i("MicroMsg.AppBrandDesktopConfig", "alvinluo initEnableNativeDynamicBackground enableForTest: %b", new Object[] { Boolean.valueOf(bool1) });
      lTi = true;
      ht(true);
      c.bsj();
      AppMethodBeat.o(49438);
      return;
    }
    lTi = localSharedPreferences.getBoolean("enable_dynamic_background", true);
    boolean bool2 = c.bsi();
    bool1 = bool2;
    if (bool2)
    {
      int i = localSharedPreferences.getInt("dynamic_background_version", -1);
      ad.i("MicroMsg.AppBrandDesktopConfig", "alvinluo localVersion %d, currentVersion: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(1) });
      if (i == 1) {
        break label216;
      }
      ad.i("MicroMsg.AppBrandDesktopConfig", "alvinluo ignore crash because of new version", new Object[] { Integer.valueOf(i), Integer.valueOf(1) });
      localSharedPreferences.edit().putInt("dynamic_background_version", 1).apply();
      c.bsj();
      ht(true);
    }
    for (bool1 = false;; bool1 = bool2)
    {
      ad.i("MicroMsg.AppBrandDesktopConfig", "alvinluo AppBrandDesktopConfig initEnableNativeDynamicBackground: %b, willCrash: %b", new Object[] { Boolean.valueOf(lTi), Boolean.valueOf(bool1) });
      AppMethodBeat.o(49438);
      return;
      label216:
      ad.i("MicroMsg.AppBrandDesktopConfig", "alvinluo disable dynamicBackground because of crash");
      ht(false);
    }
  }
  
  public static int brF()
  {
    return lTg;
  }
  
  public static int getCompletelyCountPerPage()
  {
    return lTf;
  }
  
  public static float getShowCountPerPage()
  {
    return lTe;
  }
  
  public static void ht(boolean paramBoolean)
  {
    AppMethodBeat.i(49436);
    ad.i("MicroMsg.AppBrandDesktopConfig", "alvinluo setEnableNativeDynamicBackground enable: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (lTi != paramBoolean)
    {
      SharedPreferences localSharedPreferences = aj.eFE();
      if (localSharedPreferences != null) {
        localSharedPreferences.edit().putBoolean("enable_dynamic_background", paramBoolean).apply();
      }
    }
    lTi = paramBoolean;
    AppMethodBeat.o(49436);
  }
  
  public static void init(Context paramContext)
  {
    AppMethodBeat.i(49437);
    ad.i("MicroMsg.AppBrandDesktopConfig", "alvinluo DesktopConfig init mCurrentType: %d", new Object[] { Integer.valueOf(lSY) });
    if (lSY == 1)
    {
      lSZ = 4.0F;
      lTa = 4;
      lTb = 3.0F;
      lTc = 3;
      lTe = lSZ;
      lTf = lTa;
    }
    int j = d.c(paramContext, lTe);
    int i = j;
    if (lSY == 1) {
      i = (int)(j + paramContext.getResources().getDimensionPixelSize(2131165568) * 2 * d.dT(paramContext));
    }
    if (i <= a.fromDPToPix(paramContext, 10)) {
      lTe = lTb;
    }
    for (lTf = lTc;; lTf = lTa)
    {
      i = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.puj, 1);
      lTg = i;
      i = Math.max(i, 1);
      lTg = i;
      lTg = Math.min(i, 4);
      ad.i("MicroMsg.AppBrandDesktopConfig", "alvinluo DesktopConfig init showCountPerPage: %f, completelyShowCountPerPage: %d, mRecentAppBrandMaxShowLines: %d", new Object[] { Float.valueOf(lTe), Integer.valueOf(lTf), Integer.valueOf(lTg) });
      AppMethodBeat.o(49437);
      return;
      lTe = lSZ;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.b
 * JD-Core Version:    0.7.0.1
 */