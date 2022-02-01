package com.tencent.mm.cc;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.ui.al;

public final class c
{
  private static boolean sVK = false;
  
  public static void a(Configuration paramConfiguration, Resources paramResources)
  {
    AppMethodBeat.i(162180);
    boolean bool = al.j(paramResources);
    paramConfiguration.uiMode &= 0xFFFFFFCF;
    int j = paramConfiguration.uiMode;
    if (bool)
    {
      i = 32;
      paramConfiguration.uiMode = (i | j);
      j = paramConfiguration.uiMode;
      if (paramResources != null) {
        break label98;
      }
    }
    label98:
    for (int i = 0;; i = paramResources.getConfiguration().uiMode)
    {
      ae.i("MicroMsg.MMUIModeManager", "updateNightMode, isDarkMode:%s, uiMode:%s, resourcesMode:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(j), Integer.valueOf(i) });
      AppMethodBeat.o(162180);
      return;
      i = 16;
      break;
    }
  }
  
  public static void a(Configuration paramConfiguration, boolean paramBoolean)
  {
    paramConfiguration.uiMode &= 0xFFFFFFCF;
    int j = paramConfiguration.uiMode;
    if (paramBoolean) {}
    for (int i = 32;; i = 16)
    {
      paramConfiguration.uiMode = (i | j);
      return;
    }
  }
  
  public static void flQ()
  {
    AppMethodBeat.i(162182);
    if (!sVK)
    {
      ae.i("MicroMsg.MMUIModeManager", "dark mode used: %s", new Object[] { Boolean.TRUE });
      ay.aRW(ak.fow()).putBoolean("dark_mode_used", true);
      sVK = true;
    }
    AppMethodBeat.o(162182);
  }
  
  public static boolean flR()
  {
    AppMethodBeat.i(193684);
    String str = Build.BRAND;
    if (!bu.isNullOrNil(str))
    {
      str = str.toLowerCase();
      if (((str.contains("meizu")) || (str.contains("smartisan"))) && (Build.VERSION.SDK_INT <= 25))
      {
        AppMethodBeat.o(193684);
        return true;
      }
    }
    AppMethodBeat.o(193684);
    return false;
  }
  
  public static boolean flS()
  {
    return false;
  }
  
  public static boolean h(Configuration paramConfiguration)
  {
    AppMethodBeat.i(162181);
    int i = ay.aRW(ak.fow()).getInt("uimode_change", 0);
    int j = paramConfiguration.uiMode;
    if (i == 0) {
      ay.aRW(ak.fow()).putInt("uimode_change", j);
    }
    ae.i("MicroMsg.MMUIModeManager", "dancy test uimode change, mUimode:%s,mCurrentUimode:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    if ((i != 0) && (i != j))
    {
      ae.i("MicroMsg.MMUIModeManager", "uiModeChange true !! reStart!!!");
      ay.aRW(ak.fow()).putInt("uimode_change", j);
      if ((!j.IS_FLAVOR_RED) && (!j.IS_FLAVOR_PURPLE) && (!j.DEBUG) && (!al.fBV())) {
        break label268;
      }
      if (al.fCb()) {
        i = 1;
      }
    }
    for (;;)
    {
      g localg = g.yxI;
      if (al.i(paramConfiguration))
      {
        j = 1;
        label140:
        if (!al.fBV()) {
          break label256;
        }
      }
      label256:
      for (int k = 1;; k = 0)
      {
        localg.f(18893, new Object[] { Integer.valueOf(2), Integer.valueOf(j), Integer.valueOf(2), Integer.valueOf(i), Integer.valueOf(k) });
        ae.i("MicroMsg.MMUIModeManager", "dark mode change kvReport logID:%s , action: %s, isDark:%s, mode:%s", new Object[] { Integer.valueOf(18893), Integer.valueOf(2), Boolean.valueOf(al.i(paramConfiguration)), Integer.valueOf(i) });
        AppMethodBeat.o(162181);
        return true;
        i = 2;
        break;
        j = 0;
        break label140;
      }
      AppMethodBeat.o(162181);
      return false;
      label268:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.cc.c
 * JD-Core Version:    0.7.0.1
 */