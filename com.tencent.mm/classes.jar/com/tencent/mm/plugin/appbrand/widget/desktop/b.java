package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appusage.ah;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.widget.desktop.a.c;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;

public final class b
{
  private static int naN;
  public static float naO;
  public static int naP;
  public static float naQ;
  public static int naR;
  public static final int naS;
  private static float naT;
  private static int naU;
  private static int naV;
  private static int naW;
  private static boolean naX;
  
  static
  {
    AppMethodBeat.i(49439);
    naN = 1;
    naO = 4.5F;
    naP = 4;
    naQ = 3.5F;
    naR = 3;
    naS = AppBrandGlobalSystemConfig.bez().jZT;
    naT = naO;
    naU = naP;
    naV = 1;
    naW = 0;
    naX = true;
    AppMethodBeat.o(49439);
  }
  
  public static boolean adU()
  {
    AppMethodBeat.i(49435);
    ae.d("MicroMsg.AppBrandDesktopConfig", "alvinluo isEnableNativeDynamicBackground %b, thread: %d", new Object[] { Boolean.valueOf(naX), Long.valueOf(Thread.currentThread().getId()) });
    boolean bool = naX;
    AppMethodBeat.o(49435);
    return bool;
  }
  
  public static boolean bDA()
  {
    return true;
  }
  
  public static void bDB()
  {
    AppMethodBeat.i(49438);
    SharedPreferences localSharedPreferences = ak.fox();
    if (localSharedPreferences == null)
    {
      AppMethodBeat.o(49438);
      return;
    }
    boolean bool1 = localSharedPreferences.getBoolean("enable_dynamic_background_for_test", false);
    if (bool1)
    {
      ae.i("MicroMsg.AppBrandDesktopConfig", "alvinluo initEnableNativeDynamicBackground enableForTest: %b", new Object[] { Boolean.valueOf(bool1) });
      naX = true;
      hZ(true);
      c.bEf();
      AppMethodBeat.o(49438);
      return;
    }
    naX = localSharedPreferences.getBoolean("enable_dynamic_background", true);
    boolean bool2 = c.bEe();
    bool1 = bool2;
    if (bool2)
    {
      int i = localSharedPreferences.getInt("dynamic_background_version", -1);
      ae.i("MicroMsg.AppBrandDesktopConfig", "alvinluo localVersion %d, currentVersion: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(1) });
      if (i == 1) {
        break label216;
      }
      ae.i("MicroMsg.AppBrandDesktopConfig", "alvinluo ignore crash because of new version", new Object[] { Integer.valueOf(i), Integer.valueOf(1) });
      localSharedPreferences.edit().putInt("dynamic_background_version", 1).apply();
      c.bEf();
      hZ(true);
    }
    for (bool1 = false;; bool1 = bool2)
    {
      ae.i("MicroMsg.AppBrandDesktopConfig", "alvinluo AppBrandDesktopConfig initEnableNativeDynamicBackground: %b, willCrash: %b", new Object[] { Boolean.valueOf(naX), Boolean.valueOf(bool1) });
      AppMethodBeat.o(49438);
      return;
      label216:
      ae.i("MicroMsg.AppBrandDesktopConfig", "alvinluo disable dynamicBackground because of crash");
      hZ(false);
    }
  }
  
  public static int bDC()
  {
    return naV;
  }
  
  public static boolean bDz()
  {
    return naN == 2;
  }
  
  public static int bcZ()
  {
    AppMethodBeat.i(49434);
    if (naW == 0) {
      naW = ((ah)g.ab(ah.class)).bcs();
    }
    int i = naW;
    AppMethodBeat.o(49434);
    return i;
  }
  
  public static int getCompletelyCountPerPage()
  {
    return naU;
  }
  
  public static float getShowCountPerPage()
  {
    return naT;
  }
  
  public static void hZ(boolean paramBoolean)
  {
    AppMethodBeat.i(49436);
    ae.i("MicroMsg.AppBrandDesktopConfig", "alvinluo setEnableNativeDynamicBackground enable: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (naX != paramBoolean)
    {
      SharedPreferences localSharedPreferences = ak.fox();
      if (localSharedPreferences != null) {
        localSharedPreferences.edit().putBoolean("enable_dynamic_background", paramBoolean).apply();
      }
    }
    naX = paramBoolean;
    AppMethodBeat.o(49436);
  }
  
  public static void init(Context paramContext)
  {
    AppMethodBeat.i(49437);
    ae.i("MicroMsg.AppBrandDesktopConfig", "alvinluo DesktopConfig init mCurrentType: %d", new Object[] { Integer.valueOf(naN) });
    if (naN == 1)
    {
      naO = 4.0F;
      naP = 4;
      naQ = 3.0F;
      naR = 3;
      naT = naO;
      naU = naP;
    }
    int j = d.c(paramContext, naT);
    int i = j;
    if (naN == 1) {
      i = (int)(j + paramContext.getResources().getDimensionPixelSize(2131165568) * 2 * d.ef(paramContext));
    }
    if (i <= a.fromDPToPix(paramContext, 10)) {
      naT = naQ;
    }
    for (naU = naR;; naU = naP)
    {
      i = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qLn, 1);
      naV = i;
      i = Math.max(i, 1);
      naV = i;
      naV = Math.min(i, 4);
      ae.i("MicroMsg.AppBrandDesktopConfig", "alvinluo DesktopConfig init showCountPerPage: %f, completelyShowCountPerPage: %d, mRecentAppBrandMaxShowLines: %d", new Object[] { Float.valueOf(naT), Integer.valueOf(naU), Integer.valueOf(naV) });
      AppMethodBeat.o(49437);
      return;
      naT = naO;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.b
 * JD-Core Version:    0.7.0.1
 */