package com.tencent.mm.cd;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.ui.al;

public final class c
{
  private static boolean sKx = false;
  
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
  
  public static void fhY()
  {
    AppMethodBeat.i(162182);
    if (!sKx)
    {
      ad.i("MicroMsg.MMUIModeManager", "dark mode used: %s", new Object[] { Boolean.TRUE });
      ax.aQz(aj.fkC()).putBoolean("dark_mode_used", true);
      sKx = true;
    }
    AppMethodBeat.o(162182);
  }
  
  public static boolean fhZ()
  {
    AppMethodBeat.i(186431);
    String str = Build.BRAND;
    if (!bt.isNullOrNil(str))
    {
      str = str.toLowerCase();
      if (((str.contains("meizu")) || (str.contains("smartisan"))) && (Build.VERSION.SDK_INT <= 25))
      {
        AppMethodBeat.o(186431);
        return true;
      }
    }
    AppMethodBeat.o(186431);
    return false;
  }
  
  public static boolean fia()
  {
    return false;
  }
  
  public static boolean h(Configuration paramConfiguration)
  {
    AppMethodBeat.i(162181);
    int i = ax.aQz(aj.fkC()).getInt("uimode_change", 0);
    int j = paramConfiguration.uiMode;
    if (i == 0) {
      ax.aQz(aj.fkC()).putInt("uimode_change", j);
    }
    ad.i("MicroMsg.MMUIModeManager", "dancy test uimode change, mUimode:%s,mCurrentUimode:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    if ((i != 0) && (i != j))
    {
      ad.i("MicroMsg.MMUIModeManager", "uiModeChange true !! reStart!!!");
      ax.aQz(aj.fkC()).putInt("uimode_change", j);
      if ((!i.IS_FLAVOR_RED) && (!i.IS_FLAVOR_PURPLE) && (!i.DEBUG) && (!al.fxT())) {
        break label268;
      }
      if (al.fxZ()) {
        i = 1;
      }
    }
    for (;;)
    {
      g localg = g.yhR;
      if (al.i(paramConfiguration))
      {
        j = 1;
        label140:
        if (!al.fxT()) {
          break label256;
        }
      }
      label256:
      for (int k = 1;; k = 0)
      {
        localg.f(18893, new Object[] { Integer.valueOf(2), Integer.valueOf(j), Integer.valueOf(2), Integer.valueOf(i), Integer.valueOf(k) });
        ad.i("MicroMsg.MMUIModeManager", "dark mode change kvReport logID:%s , action: %s, isDark:%s, mode:%s", new Object[] { Integer.valueOf(18893), Integer.valueOf(2), Boolean.valueOf(al.i(paramConfiguration)), Integer.valueOf(i) });
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
 * Qualified Name:     com.tencent.mm.cd.c
 * JD-Core Version:    0.7.0.1
 */