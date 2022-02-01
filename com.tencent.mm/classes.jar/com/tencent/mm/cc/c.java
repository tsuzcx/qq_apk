package com.tencent.mm.cc;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;

public final class c
{
  private static boolean vUN = false;
  
  public static void a(Configuration paramConfiguration, Resources paramResources)
  {
    AppMethodBeat.i(162180);
    boolean bool = ao.f(paramResources);
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
      Log.i("MicroMsg.MMUIModeManager", "updateNightMode, isDarkMode:%s, uiMode:%s, resourcesMode:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(j), Integer.valueOf(i) });
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
  
  public static void gvC()
  {
    AppMethodBeat.i(162182);
    if (!vUN)
    {
      Log.i("MicroMsg.MMUIModeManager", "dark mode used: %s", new Object[] { Boolean.TRUE });
      MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).putBoolean("dark_mode_used", true);
      vUN = true;
    }
    AppMethodBeat.o(162182);
  }
  
  public static boolean gvD()
  {
    AppMethodBeat.i(205092);
    String str = Build.BRAND;
    if (!Util.isNullOrNil(str))
    {
      str = str.toLowerCase();
      if (((str.contains("meizu")) || (str.contains("smartisan"))) && (Build.VERSION.SDK_INT <= 25))
      {
        AppMethodBeat.o(205092);
        return true;
      }
      if ((ao.gJN()) && (ao.gJH()))
      {
        AppMethodBeat.o(205092);
        return true;
      }
    }
    AppMethodBeat.o(205092);
    return false;
  }
  
  public static boolean gvE()
  {
    return false;
  }
  
  public static boolean h(Configuration paramConfiguration)
  {
    AppMethodBeat.i(162181);
    int i = MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).getInt("uimode_change", 0);
    int j = paramConfiguration.uiMode;
    if (i == 0) {
      MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).putInt("uimode_change", j);
    }
    Log.i("MicroMsg.MMUIModeManager", "dancy test uimode change, mUimode:%s,mCurrentUimode:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    if ((i != 0) && (i != j))
    {
      Log.i("MicroMsg.MMUIModeManager", "uiModeChange true !! reStart!!!");
      MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).putInt("uimode_change", j);
      if ((!BuildInfo.IS_FLAVOR_RED) && (!BuildInfo.IS_FLAVOR_PURPLE) && (!BuildInfo.DEBUG) && (!ao.awN())) {
        break label268;
      }
      if (ao.awS()) {
        i = 1;
      }
    }
    for (;;)
    {
      h localh = h.CyF;
      if (ao.i(paramConfiguration))
      {
        j = 1;
        label140:
        if (!ao.awN()) {
          break label256;
        }
      }
      label256:
      for (int k = 1;; k = 0)
      {
        localh.a(18893, new Object[] { Integer.valueOf(2), Integer.valueOf(j), Integer.valueOf(2), Integer.valueOf(i), Integer.valueOf(k) });
        Log.i("MicroMsg.MMUIModeManager", "dark mode change kvReport logID:%s , action: %s, isDark:%s, mode:%s", new Object[] { Integer.valueOf(18893), Integer.valueOf(2), Boolean.valueOf(ao.i(paramConfiguration)), Integer.valueOf(i) });
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