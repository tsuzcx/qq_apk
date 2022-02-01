package com.tencent.mm.plugin.appbrand.widget.desktop.a;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.desktop.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;

public final class c
{
  private static boolean mZi;
  private static boolean mZj;
  private static boolean mZk;
  private static SharedPreferences sp;
  
  static
  {
    AppMethodBeat.i(49723);
    sp = aj.fkD();
    mZi = false;
    mZj = false;
    mZk = true;
    AppMethodBeat.o(49723);
  }
  
  public static void adM()
  {
    AppMethodBeat.i(49718);
    ad.i("MicroMsg.DynamicBgCrashHelper", "alvinluo markWillCrash");
    if (sp == null) {
      sp = aj.fkD();
    }
    if (sp != null)
    {
      b.ib(false);
      sp.edit().putBoolean("dynamic_bg_will_crash", true).apply();
    }
    mZi = true;
    AppMethodBeat.o(49718);
  }
  
  public static boolean adP()
  {
    return mZj;
  }
  
  public static boolean adQ()
  {
    return mZk;
  }
  
  public static void adR()
  {
    AppMethodBeat.i(49721);
    if (sp == null) {
      sp = aj.fkD();
    }
    if (sp != null)
    {
      int i = sp.getInt("dynamic_bg_draw_start_point_count", 0);
      ad.i("MicroMsg.DynamicBgCrashHelper", "alvinluo markDrawStartPoint current: %d", new Object[] { Integer.valueOf(i) });
      if (i > 2)
      {
        b.ib(false);
        sp.edit().putBoolean("dynamic_bg_will_crash", true).apply();
      }
      sp.edit().putInt("dynamic_bg_draw_start_point_count", i + 1).apply();
    }
    AppMethodBeat.o(49721);
  }
  
  public static void adS()
  {
    AppMethodBeat.i(49722);
    ad.i("MicroMsg.DynamicBgCrashHelper", "alvinluo markDrawEndPoint");
    sp.edit().putInt("dynamic_bg_draw_start_point_count", 0).apply();
    sp.edit().putBoolean("dynamic_bg_will_crash", false).apply();
    b.ib(true);
    mZk = false;
    AppMethodBeat.o(49722);
  }
  
  public static boolean bDm()
  {
    AppMethodBeat.i(49715);
    if (sp != null)
    {
      int i = sp.getInt("dynamic_bg_init_start_point_count", 0);
      int j = sp.getInt("dynamic_bg_draw_start_point_count", 0);
      boolean bool = sp.getBoolean("dynamic_bg_init_crash", false);
      mZj = bool;
      if ((bool) || (i >= 2) || (j >= 2))
      {
        mZi = true;
        sp.edit().putBoolean("dynamic_bg_will_crash", true).apply();
        AppMethodBeat.o(49715);
        return true;
      }
      mZi = false;
      AppMethodBeat.o(49715);
      return false;
    }
    AppMethodBeat.o(49715);
    return false;
  }
  
  public static void bDn()
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
    mZj = false;
    mZi = false;
    AppMethodBeat.o(49716);
  }
  
  public static void bDo()
  {
    AppMethodBeat.i(49717);
    ad.i("MicroMsg.DynamicBgCrashHelper", "alvinluo markInitCrash");
    b.ib(false);
    if (sp == null) {
      sp = aj.fkD();
    }
    if (sp != null) {
      sp.edit().putBoolean("dynamic_bg_init_crash", true).apply();
    }
    mZj = true;
    AppMethodBeat.o(49717);
  }
  
  public static void bDp()
  {
    AppMethodBeat.i(49719);
    if (sp == null) {
      sp = aj.fkD();
    }
    if (sp != null)
    {
      int i = sp.getInt("dynamic_bg_init_start_point_count", 0);
      ad.i("MicroMsg.DynamicBgCrashHelper", "alvinluo markInitStartPoint current: %d", new Object[] { Integer.valueOf(i) });
      if (i > 2)
      {
        b.ib(false);
        sp.edit().putBoolean("dynamic_bg_will_crash", true).apply();
      }
      sp.edit().putInt("dynamic_bg_init_start_point_count", i + 1).apply();
    }
    AppMethodBeat.o(49719);
  }
  
  public static void bDq()
  {
    AppMethodBeat.i(49720);
    ad.i("MicroMsg.DynamicBgCrashHelper", "alvinluo markInitEndPoint");
    sp.edit().putInt("dynamic_bg_init_start_point_count", 0).apply();
    sp.edit().putBoolean("dynamic_bg_will_crash", false).apply();
    sp.edit().putBoolean("dynamic_bg_init_crash", false).apply();
    mZi = false;
    mZj = false;
    b.ib(true);
    AppMethodBeat.o(49720);
  }
  
  public static boolean bDr()
  {
    return mZi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.a.c
 * JD-Core Version:    0.7.0.1
 */