package com.tencent.mm.ce;

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
import com.tencent.mm.ui.aw;

public final class e
{
  private static boolean GfH = false;
  
  public static void a(Configuration paramConfiguration, Resources paramResources)
  {
    AppMethodBeat.i(162180);
    boolean bool = aw.f(paramResources);
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
  
  public static boolean i(Configuration paramConfiguration)
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
      if ((!BuildInfo.IS_FLAVOR_RED) && (!BuildInfo.IS_FLAVOR_PURPLE) && (!BuildInfo.DEBUG) && (!aw.aXj())) {
        break label268;
      }
      if (aw.aXo()) {
        i = 1;
      }
    }
    for (;;)
    {
      h localh = h.OAn;
      if (aw.j(paramConfiguration))
      {
        j = 1;
        label140:
        if (!aw.aXj()) {
          break label256;
        }
      }
      label256:
      for (int k = 1;; k = 0)
      {
        localh.b(18893, new Object[] { Integer.valueOf(2), Integer.valueOf(j), Integer.valueOf(2), Integer.valueOf(i), Integer.valueOf(k) });
        Log.i("MicroMsg.MMUIModeManager", "dark mode change kvReport logID:%s , action: %s, isDark:%s, mode:%s", new Object[] { Integer.valueOf(18893), Integer.valueOf(2), Boolean.valueOf(aw.j(paramConfiguration)), Integer.valueOf(i) });
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
  
  public static void iRO()
  {
    AppMethodBeat.i(162182);
    if (!GfH)
    {
      Log.i("MicroMsg.MMUIModeManager", "dark mode used: %s", new Object[] { Boolean.TRUE });
      MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).putBoolean("dark_mode_used", true);
      GfH = true;
    }
    AppMethodBeat.o(162182);
  }
  
  public static boolean iRP()
  {
    AppMethodBeat.i(233065);
    String str = Build.BRAND;
    if (!Util.isNullOrNil(str))
    {
      str = str.toLowerCase();
      if (((str.contains("meizu")) || (str.contains("smartisan"))) && (Build.VERSION.SDK_INT <= 25))
      {
        AppMethodBeat.o(233065);
        return true;
      }
      if ((aw.jlc()) && (aw.jkY()))
      {
        AppMethodBeat.o(233065);
        return true;
      }
    }
    AppMethodBeat.o(233065);
    return false;
  }
  
  public static boolean iRQ()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ce.e
 * JD-Core Version:    0.7.0.1
 */