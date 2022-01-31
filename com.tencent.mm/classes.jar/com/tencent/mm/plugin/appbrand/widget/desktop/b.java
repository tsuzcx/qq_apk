package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appusage.af;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public final class b
{
  private static int jde;
  public static float jdf;
  public static int jdg;
  public static float jdh;
  public static int jdi;
  public static final int jdj;
  private static float jdk;
  private static int jdl;
  private static int jdm;
  private static boolean jdn;
  
  static
  {
    AppMethodBeat.i(133712);
    jde = 1;
    jdf = 4.5F;
    jdg = 4;
    jdh = 3.5F;
    jdi = 3;
    jdj = AppBrandGlobalSystemConfig.ayt().hhM;
    jdk = jdf;
    jdl = jdg;
    jdm = 0;
    jdn = true;
    AppMethodBeat.o(133712);
  }
  
  public static boolean aPf()
  {
    return jde == 2;
  }
  
  public static boolean aPg()
  {
    AppMethodBeat.i(133708);
    ab.d("MicroMsg.AppBrandDesktopConfig", "alvinluo isEnableNativeDynamicBackground %b, thread: %d", new Object[] { Boolean.valueOf(jdn), Long.valueOf(Thread.currentThread().getId()) });
    boolean bool = jdn;
    AppMethodBeat.o(133708);
    return bool;
  }
  
  public static boolean aPh()
  {
    return true;
  }
  
  public static void aPi()
  {
    AppMethodBeat.i(133711);
    SharedPreferences localSharedPreferences = ah.dsQ();
    if (localSharedPreferences == null)
    {
      AppMethodBeat.o(133711);
      return;
    }
    boolean bool1 = localSharedPreferences.getBoolean("enable_dynamic_background_for_test", false);
    if (bool1)
    {
      ab.i("MicroMsg.AppBrandDesktopConfig", "alvinluo initEnableNativeDynamicBackground enableForTest: %b", new Object[] { Boolean.valueOf(bool1) });
      jdn = true;
      ff(true);
      com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.d.aPR();
      AppMethodBeat.o(133711);
      return;
    }
    jdn = localSharedPreferences.getBoolean("enable_dynamic_background", true);
    boolean bool2 = com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.d.aPQ();
    bool1 = bool2;
    if (bool2)
    {
      int i = localSharedPreferences.getInt("dynamic_background_version", -1);
      ab.i("MicroMsg.AppBrandDesktopConfig", "alvinluo localVersion %d, currentVersion: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(1) });
      if (i == 1) {
        break label216;
      }
      ab.i("MicroMsg.AppBrandDesktopConfig", "alvinluo ignore crash because of new version", new Object[] { Integer.valueOf(i), Integer.valueOf(1) });
      localSharedPreferences.edit().putInt("dynamic_background_version", 1).apply();
      com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.d.aPR();
      ff(true);
    }
    for (bool1 = false;; bool1 = bool2)
    {
      ab.i("MicroMsg.AppBrandDesktopConfig", "alvinluo AppBrandDesktopConfig initEnableNativeDynamicBackground: %b, willCrash: %b", new Object[] { Boolean.valueOf(jdn), Boolean.valueOf(bool1) });
      AppMethodBeat.o(133711);
      return;
      label216:
      ab.i("MicroMsg.AppBrandDesktopConfig", "alvinluo disable dynamicBackground because of crash");
      ff(false);
    }
  }
  
  public static int axA()
  {
    AppMethodBeat.i(133707);
    if (jdm == 0) {
      jdm = ((af)g.E(af.class)).awR();
    }
    int i = jdm;
    AppMethodBeat.o(133707);
    return i;
  }
  
  public static void ff(boolean paramBoolean)
  {
    AppMethodBeat.i(133709);
    ab.i("MicroMsg.AppBrandDesktopConfig", "alvinluo setEnableNativeDynamicBackground enable: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (jdn != paramBoolean)
    {
      SharedPreferences localSharedPreferences = ah.dsQ();
      if (localSharedPreferences != null) {
        localSharedPreferences.edit().putBoolean("enable_dynamic_background", paramBoolean).apply();
      }
    }
    jdn = paramBoolean;
    AppMethodBeat.o(133709);
  }
  
  public static int getCompletelyCountPerPage()
  {
    return jdl;
  }
  
  public static float getShowCountPerPage()
  {
    return jdk;
  }
  
  public static void init(Context paramContext)
  {
    AppMethodBeat.i(133710);
    ab.i("MicroMsg.AppBrandDesktopConfig", "alvinluo DesktopConfig init mCurrentType: %d", new Object[] { Integer.valueOf(jde) });
    if (jde == 1)
    {
      jdf = 4.0F;
      jdg = 4;
      jdh = 3.0F;
      jdi = 3;
      jdk = jdf;
      jdl = jdg;
    }
    int j = d.d(paramContext, jdk);
    int i = j;
    if (jde == 1) {
      i = (int)(j + paramContext.getResources().getDimensionPixelSize(2131427854) * 2 * d.dr(paramContext));
    }
    if (i <= a.fromDPToPix(paramContext, 10)) {
      jdk = jdh;
    }
    for (jdl = jdi;; jdl = jdg)
    {
      ab.i("MicroMsg.AppBrandDesktopConfig", "alvinluo DesktopConfig init showCountPerPage: %f, completelyShowCountPerPage: %d", new Object[] { Float.valueOf(jdk), Integer.valueOf(jdl), Boolean.valueOf(jdn) });
      AppMethodBeat.o(133710);
      return;
      jdk = jdf;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.b
 * JD-Core Version:    0.7.0.1
 */