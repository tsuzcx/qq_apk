package com.tencent.mm.plugin.appbrand.widget.desktop.a;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.desktop.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;

public final class c
{
  private static boolean lWA;
  private static boolean lWy;
  private static boolean lWz;
  private static SharedPreferences sp;
  
  static
  {
    AppMethodBeat.i(49723);
    sp = aj.eFE();
    lWy = false;
    lWz = false;
    lWA = true;
    AppMethodBeat.o(49723);
  }
  
  public static void aaj()
  {
    AppMethodBeat.i(49718);
    ad.i("MicroMsg.DynamicBgCrashHelper", "alvinluo markWillCrash");
    if (sp == null) {
      sp = aj.eFE();
    }
    if (sp != null)
    {
      b.ht(false);
      sp.edit().putBoolean("dynamic_bg_will_crash", true).apply();
    }
    lWy = true;
    AppMethodBeat.o(49718);
  }
  
  public static boolean aam()
  {
    return lWz;
  }
  
  public static boolean aan()
  {
    return lWA;
  }
  
  public static void aao()
  {
    AppMethodBeat.i(49721);
    if (sp == null) {
      sp = aj.eFE();
    }
    if (sp != null)
    {
      int i = sp.getInt("dynamic_bg_draw_start_point_count", 0);
      ad.i("MicroMsg.DynamicBgCrashHelper", "alvinluo markDrawStartPoint current: %d", new Object[] { Integer.valueOf(i) });
      if (i > 2)
      {
        b.ht(false);
        sp.edit().putBoolean("dynamic_bg_will_crash", true).apply();
      }
      sp.edit().putInt("dynamic_bg_draw_start_point_count", i + 1).apply();
    }
    AppMethodBeat.o(49721);
  }
  
  public static void aap()
  {
    AppMethodBeat.i(49722);
    ad.i("MicroMsg.DynamicBgCrashHelper", "alvinluo markDrawEndPoint");
    sp.edit().putInt("dynamic_bg_draw_start_point_count", 0).apply();
    sp.edit().putBoolean("dynamic_bg_will_crash", false).apply();
    b.ht(true);
    lWA = false;
    AppMethodBeat.o(49722);
  }
  
  public static boolean bsi()
  {
    AppMethodBeat.i(49715);
    if (sp != null)
    {
      int i = sp.getInt("dynamic_bg_init_start_point_count", 0);
      int j = sp.getInt("dynamic_bg_draw_start_point_count", 0);
      boolean bool = sp.getBoolean("dynamic_bg_init_crash", false);
      lWz = bool;
      if ((bool) || (i >= 2) || (j >= 2))
      {
        lWy = true;
        sp.edit().putBoolean("dynamic_bg_will_crash", true).apply();
        AppMethodBeat.o(49715);
        return true;
      }
      lWy = false;
      AppMethodBeat.o(49715);
      return false;
    }
    AppMethodBeat.o(49715);
    return false;
  }
  
  public static void bsj()
  {
    AppMethodBeat.i(49716);
    if (sp != null)
    {
      SharedPreferences.Editor localEditor = sp.edit();
      if (localEditor != null)
      {
        localEditor.putInt("dynamic_bg_init_start_point_count", 0);
        localEditor.putInt("dynamic_bg_draw_start_point_count", 0);
        localEditor.putBoolean("dynamic_bg_init_crash", false);
        localEditor.putBoolean("dynamic_bg_will_crash", false);
        localEditor.apply();
      }
    }
    lWz = false;
    lWy = false;
    AppMethodBeat.o(49716);
  }
  
  public static void bsk()
  {
    AppMethodBeat.i(49717);
    ad.i("MicroMsg.DynamicBgCrashHelper", "alvinluo markInitCrash");
    b.ht(false);
    if (sp == null) {
      sp = aj.eFE();
    }
    if (sp != null) {
      sp.edit().putBoolean("dynamic_bg_init_crash", true).apply();
    }
    lWz = true;
    AppMethodBeat.o(49717);
  }
  
  public static void bsl()
  {
    AppMethodBeat.i(49719);
    if (sp == null) {
      sp = aj.eFE();
    }
    if (sp != null)
    {
      int i = sp.getInt("dynamic_bg_init_start_point_count", 0);
      ad.i("MicroMsg.DynamicBgCrashHelper", "alvinluo markInitStartPoint current: %d", new Object[] { Integer.valueOf(i) });
      if (i > 2)
      {
        b.ht(false);
        sp.edit().putBoolean("dynamic_bg_will_crash", true).apply();
      }
      sp.edit().putInt("dynamic_bg_init_start_point_count", i + 1).apply();
    }
    AppMethodBeat.o(49719);
  }
  
  public static void bsm()
  {
    AppMethodBeat.i(49720);
    ad.i("MicroMsg.DynamicBgCrashHelper", "alvinluo markInitEndPoint");
    sp.edit().putInt("dynamic_bg_init_start_point_count", 0).apply();
    sp.edit().putBoolean("dynamic_bg_will_crash", false).apply();
    sp.edit().putBoolean("dynamic_bg_init_crash", false).apply();
    lWy = false;
    lWz = false;
    b.ht(true);
    AppMethodBeat.o(49720);
  }
  
  public static boolean bsn()
  {
    return lWy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.a.c
 * JD-Core Version:    0.7.0.1
 */