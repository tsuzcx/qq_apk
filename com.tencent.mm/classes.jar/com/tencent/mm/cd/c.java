package com.tencent.mm.cd;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.aj;

public final class c
{
  private static boolean GjZ = false;
  
  public static void a(Configuration paramConfiguration, Resources paramResources)
  {
    AppMethodBeat.i(162180);
    boolean bool = aj.j(paramResources);
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
      ac.i("MicroMsg.MMUIModeManager", "updateNightMode, isDarkMode:%s, uiMode:%s, resourcesMode:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(j), Integer.valueOf(i) });
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
  
  public static void eSF()
  {
    AppMethodBeat.i(162182);
    if (!GjZ)
    {
      ac.i("MicroMsg.MMUIModeManager", "dark mode used: %s", new Object[] { Boolean.TRUE });
      aw.aKT(ai.eUX()).putBoolean("dark_mode_used", true);
      GjZ = true;
    }
    AppMethodBeat.o(162182);
  }
  
  public static boolean eSG()
  {
    AppMethodBeat.i(197174);
    String str = Build.BRAND;
    if (!bs.isNullOrNil(str))
    {
      str = str.toLowerCase();
      if (((str.contains("meizu")) || (str.contains("smartisan"))) && (Build.VERSION.SDK_INT <= 25))
      {
        AppMethodBeat.o(197174);
        return true;
      }
    }
    AppMethodBeat.o(197174);
    return false;
  }
  
  public static boolean h(Configuration paramConfiguration)
  {
    AppMethodBeat.i(162181);
    int i = aw.aKT(ai.eUX()).getInt("uimode_change", 0);
    int j = paramConfiguration.uiMode;
    if (i == 0) {
      aw.aKT(ai.eUX()).putInt("uimode_change", j);
    }
    ac.i("MicroMsg.MMUIModeManager", "dancy test uimode change, mUimode:%s,mCurrentUimode:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    if ((i != 0) && (i != j))
    {
      ac.i("MicroMsg.MMUIModeManager", "uiModeChange true !! reStart!!!");
      aw.aKT(ai.eUX()).putInt("uimode_change", j);
      if ((!com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) && (!com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_PURPLE) && (!com.tencent.mm.sdk.platformtools.h.DEBUG) && (!aj.fhE())) {
        break label246;
      }
      if (aj.fhJ()) {
        i = 1;
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.wUl;
      if (aj.i(paramConfiguration)) {}
      for (j = 1;; j = 0)
      {
        localh.f(18893, new Object[] { Integer.valueOf(2), Integer.valueOf(j), Integer.valueOf(1), Integer.valueOf(i) });
        ac.i("MicroMsg.MMUIModeManager", "dark mode change kvReport logID:%s , action: %s, isDark:%s, mode:%s", new Object[] { Integer.valueOf(18893), Integer.valueOf(2), Boolean.valueOf(aj.i(paramConfiguration)), Integer.valueOf(i) });
        AppMethodBeat.o(162181);
        return true;
        i = 2;
        break;
      }
      AppMethodBeat.o(162181);
      return false;
      label246:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.cd.c
 * JD-Core Version:    0.7.0.1
 */