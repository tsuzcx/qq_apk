package com.tencent.mm.ce;

import android.content.res.Configuration;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.ui.ai;

public final class c
{
  private static boolean EMN = false;
  
  public static void a(Configuration paramConfiguration, Resources paramResources)
  {
    AppMethodBeat.i(162180);
    boolean bool = ai.j(paramResources);
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
      ad.i("MicroMsg.MMUIModeManager", "updateNightMode, isDarkMode:%s, uiMode:%s, resourcesMode:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(j), Integer.valueOf(i) });
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
  
  public static void eDl()
  {
    AppMethodBeat.i(162182);
    if (!EMN)
    {
      ad.i("MicroMsg.MMUIModeManager", "dark mode used: %s", new Object[] { Boolean.TRUE });
      ax.aFC(aj.eFD()).putBoolean("dark_mode_used", true);
      EMN = true;
    }
    AppMethodBeat.o(162182);
  }
  
  public static boolean g(Configuration paramConfiguration)
  {
    AppMethodBeat.i(162181);
    int i = ax.aFC(aj.eFD()).getInt("uimode_change", 0);
    int j = paramConfiguration.uiMode;
    if (i == 0) {
      ax.aFC(aj.eFD()).putInt("uimode_change", j);
    }
    ad.i("MicroMsg.MMUIModeManager", "dancy test uimode change, mUimode:%s,mCurrentUimode:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    if ((i != 0) && (i != j))
    {
      ad.i("MicroMsg.MMUIModeManager", "uiModeChange true !! reStart!!!");
      ax.aFC(aj.eFD()).putInt("uimode_change", j);
      if ((!com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) && (!com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_PURPLE) && (!com.tencent.mm.sdk.platformtools.h.DEBUG) && (!ai.eRU())) {
        break label246;
      }
      if (ai.eRZ()) {
        i = 1;
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.vKh;
      if (ai.h(paramConfiguration)) {}
      for (j = 1;; j = 0)
      {
        localh.f(18893, new Object[] { Integer.valueOf(2), Integer.valueOf(j), Integer.valueOf(1), Integer.valueOf(i) });
        ad.i("MicroMsg.MMUIModeManager", "dark mode change kvReport logID:%s , action: %s, isDark:%s, mode:%s", new Object[] { Integer.valueOf(18893), Integer.valueOf(2), Boolean.valueOf(ai.h(paramConfiguration)), Integer.valueOf(i) });
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
 * Qualified Name:     com.tencent.mm.ce.c
 * JD-Core Version:    0.7.0.1
 */