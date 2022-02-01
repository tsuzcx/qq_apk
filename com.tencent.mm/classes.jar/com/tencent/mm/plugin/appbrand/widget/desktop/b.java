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
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;

public final class b
{
  private static int mVH;
  public static float mVI;
  public static int mVJ;
  public static float mVK;
  public static int mVL;
  public static final int mVM;
  private static float mVN;
  private static int mVO;
  private static int mVP;
  private static int mVQ;
  private static boolean mVR;
  
  static
  {
    AppMethodBeat.i(49439);
    mVH = 1;
    mVI = 4.5F;
    mVJ = 4;
    mVK = 3.5F;
    mVL = 3;
    mVM = AppBrandGlobalSystemConfig.bdT().jWE;
    mVN = mVI;
    mVO = mVJ;
    mVP = 1;
    mVQ = 0;
    mVR = true;
    AppMethodBeat.o(49439);
  }
  
  public static boolean adI()
  {
    AppMethodBeat.i(49435);
    ad.d("MicroMsg.AppBrandDesktopConfig", "alvinluo isEnableNativeDynamicBackground %b, thread: %d", new Object[] { Boolean.valueOf(mVR), Long.valueOf(Thread.currentThread().getId()) });
    boolean bool = mVR;
    AppMethodBeat.o(49435);
    return bool;
  }
  
  public static boolean bCH()
  {
    return mVH == 2;
  }
  
  public static boolean bCI()
  {
    return true;
  }
  
  public static void bCJ()
  {
    AppMethodBeat.i(49438);
    SharedPreferences localSharedPreferences = aj.fkD();
    if (localSharedPreferences == null)
    {
      AppMethodBeat.o(49438);
      return;
    }
    boolean bool1 = localSharedPreferences.getBoolean("enable_dynamic_background_for_test", false);
    if (bool1)
    {
      ad.i("MicroMsg.AppBrandDesktopConfig", "alvinluo initEnableNativeDynamicBackground enableForTest: %b", new Object[] { Boolean.valueOf(bool1) });
      mVR = true;
      ib(true);
      c.bDn();
      AppMethodBeat.o(49438);
      return;
    }
    mVR = localSharedPreferences.getBoolean("enable_dynamic_background", true);
    boolean bool2 = c.bDm();
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
      c.bDn();
      ib(true);
    }
    for (bool1 = false;; bool1 = bool2)
    {
      ad.i("MicroMsg.AppBrandDesktopConfig", "alvinluo AppBrandDesktopConfig initEnableNativeDynamicBackground: %b, willCrash: %b", new Object[] { Boolean.valueOf(mVR), Boolean.valueOf(bool1) });
      AppMethodBeat.o(49438);
      return;
      label216:
      ad.i("MicroMsg.AppBrandDesktopConfig", "alvinluo disable dynamicBackground because of crash");
      ib(false);
    }
  }
  
  public static int bCK()
  {
    return mVP;
  }
  
  public static int bcu()
  {
    AppMethodBeat.i(49434);
    if (mVQ == 0) {
      mVQ = ((ah)g.ab(ah.class)).bbO();
    }
    int i = mVQ;
    AppMethodBeat.o(49434);
    return i;
  }
  
  public static int getCompletelyCountPerPage()
  {
    return mVO;
  }
  
  public static float getShowCountPerPage()
  {
    return mVN;
  }
  
  public static void ib(boolean paramBoolean)
  {
    AppMethodBeat.i(49436);
    ad.i("MicroMsg.AppBrandDesktopConfig", "alvinluo setEnableNativeDynamicBackground enable: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (mVR != paramBoolean)
    {
      SharedPreferences localSharedPreferences = aj.fkD();
      if (localSharedPreferences != null) {
        localSharedPreferences.edit().putBoolean("enable_dynamic_background", paramBoolean).apply();
      }
    }
    mVR = paramBoolean;
    AppMethodBeat.o(49436);
  }
  
  public static void init(Context paramContext)
  {
    AppMethodBeat.i(49437);
    ad.i("MicroMsg.AppBrandDesktopConfig", "alvinluo DesktopConfig init mCurrentType: %d", new Object[] { Integer.valueOf(mVH) });
    if (mVH == 1)
    {
      mVI = 4.0F;
      mVJ = 4;
      mVK = 3.0F;
      mVL = 3;
      mVN = mVI;
      mVO = mVJ;
    }
    int j = d.c(paramContext, mVN);
    int i = j;
    if (mVH == 1) {
      i = (int)(j + paramContext.getResources().getDimensionPixelSize(2131165568) * 2 * d.eb(paramContext));
    }
    if (i <= a.fromDPToPix(paramContext, 10)) {
      mVN = mVK;
    }
    for (mVO = mVL;; mVO = mVJ)
    {
      i = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qDI, 1);
      mVP = i;
      i = Math.max(i, 1);
      mVP = i;
      mVP = Math.min(i, 4);
      ad.i("MicroMsg.AppBrandDesktopConfig", "alvinluo DesktopConfig init showCountPerPage: %f, completelyShowCountPerPage: %d, mRecentAppBrandMaxShowLines: %d", new Object[] { Float.valueOf(mVN), Integer.valueOf(mVO), Integer.valueOf(mVP) });
      AppMethodBeat.o(49437);
      return;
      mVN = mVI;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.b
 * JD-Core Version:    0.7.0.1
 */