package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appusage.ah;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.widget.desktop.a.c;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;

public final class b
{
  private static int mva;
  public static float mvb;
  public static int mvc;
  public static float mvd;
  public static int mve;
  public static final int mvf;
  private static float mvg;
  private static int mvh;
  private static int mvi;
  private static int mvj;
  private static boolean mvk;
  
  static
  {
    AppMethodBeat.i(49439);
    mva = 1;
    mvb = 4.5F;
    mvc = 4;
    mvd = 3.5F;
    mve = 3;
    mvf = AppBrandGlobalSystemConfig.bat().jCI;
    mvg = mvb;
    mvh = mvc;
    mvi = 1;
    mvj = 0;
    mvk = true;
    AppMethodBeat.o(49439);
  }
  
  public static int aYW()
  {
    AppMethodBeat.i(49434);
    if (mvj == 0) {
      mvj = ((ah)g.ab(ah.class)).aYq();
    }
    int i = mvj;
    AppMethodBeat.o(49434);
    return i;
  }
  
  public static boolean abe()
  {
    AppMethodBeat.i(49435);
    ac.d("MicroMsg.AppBrandDesktopConfig", "alvinluo isEnableNativeDynamicBackground %b, thread: %d", new Object[] { Boolean.valueOf(mvk), Long.valueOf(Thread.currentThread().getId()) });
    boolean bool = mvk;
    AppMethodBeat.o(49435);
    return bool;
  }
  
  public static boolean byC()
  {
    return mva == 2;
  }
  
  public static boolean byD()
  {
    return true;
  }
  
  public static void byE()
  {
    AppMethodBeat.i(49438);
    SharedPreferences localSharedPreferences = ai.eUY();
    if (localSharedPreferences == null)
    {
      AppMethodBeat.o(49438);
      return;
    }
    boolean bool1 = localSharedPreferences.getBoolean("enable_dynamic_background_for_test", false);
    if (bool1)
    {
      ac.i("MicroMsg.AppBrandDesktopConfig", "alvinluo initEnableNativeDynamicBackground enableForTest: %b", new Object[] { Boolean.valueOf(bool1) });
      mvk = true;
      hR(true);
      c.bzj();
      AppMethodBeat.o(49438);
      return;
    }
    mvk = localSharedPreferences.getBoolean("enable_dynamic_background", true);
    boolean bool2 = c.bzi();
    bool1 = bool2;
    if (bool2)
    {
      int i = localSharedPreferences.getInt("dynamic_background_version", -1);
      ac.i("MicroMsg.AppBrandDesktopConfig", "alvinluo localVersion %d, currentVersion: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(1) });
      if (i == 1) {
        break label216;
      }
      ac.i("MicroMsg.AppBrandDesktopConfig", "alvinluo ignore crash because of new version", new Object[] { Integer.valueOf(i), Integer.valueOf(1) });
      localSharedPreferences.edit().putInt("dynamic_background_version", 1).apply();
      c.bzj();
      hR(true);
    }
    for (bool1 = false;; bool1 = bool2)
    {
      ac.i("MicroMsg.AppBrandDesktopConfig", "alvinluo AppBrandDesktopConfig initEnableNativeDynamicBackground: %b, willCrash: %b", new Object[] { Boolean.valueOf(mvk), Boolean.valueOf(bool1) });
      AppMethodBeat.o(49438);
      return;
      label216:
      ac.i("MicroMsg.AppBrandDesktopConfig", "alvinluo disable dynamicBackground because of crash");
      hR(false);
    }
  }
  
  public static int byF()
  {
    return mvi;
  }
  
  public static int getCompletelyCountPerPage()
  {
    return mvh;
  }
  
  public static float getShowCountPerPage()
  {
    return mvg;
  }
  
  public static void hR(boolean paramBoolean)
  {
    AppMethodBeat.i(49436);
    ac.i("MicroMsg.AppBrandDesktopConfig", "alvinluo setEnableNativeDynamicBackground enable: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (mvk != paramBoolean)
    {
      SharedPreferences localSharedPreferences = ai.eUY();
      if (localSharedPreferences != null) {
        localSharedPreferences.edit().putBoolean("enable_dynamic_background", paramBoolean).apply();
      }
    }
    mvk = paramBoolean;
    AppMethodBeat.o(49436);
  }
  
  public static void init(Context paramContext)
  {
    AppMethodBeat.i(49437);
    ac.i("MicroMsg.AppBrandDesktopConfig", "alvinluo DesktopConfig init mCurrentType: %d", new Object[] { Integer.valueOf(mva) });
    if (mva == 1)
    {
      mvb = 4.0F;
      mvc = 4;
      mvd = 3.0F;
      mve = 3;
      mvg = mvb;
      mvh = mvc;
    }
    int j = d.c(paramContext, mvg);
    int i = j;
    if (mva == 1) {
      i = (int)(j + paramContext.getResources().getDimensionPixelSize(2131165568) * 2 * d.eb(paramContext));
    }
    if (i <= a.fromDPToPix(paramContext, 10)) {
      mvg = mvd;
    }
    for (mvh = mve;; mvh = mvc)
    {
      i = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pYx, 1);
      mvi = i;
      i = Math.max(i, 1);
      mvi = i;
      mvi = Math.min(i, 4);
      ac.i("MicroMsg.AppBrandDesktopConfig", "alvinluo DesktopConfig init showCountPerPage: %f, completelyShowCountPerPage: %d, mRecentAppBrandMaxShowLines: %d", new Object[] { Float.valueOf(mvg), Integer.valueOf(mvh), Integer.valueOf(mvi) });
      AppMethodBeat.o(49437);
      return;
      mvg = mvb;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.b
 * JD-Core Version:    0.7.0.1
 */