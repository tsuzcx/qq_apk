package com.tencent.mm.plugin.appbrand.widget.desktop.a;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.desktop.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;

public final class c
{
  private static boolean nep;
  private static boolean neq;
  private static boolean ner;
  private static SharedPreferences sp;
  
  static
  {
    AppMethodBeat.i(49723);
    sp = ak.fox();
    nep = false;
    neq = false;
    ner = true;
    AppMethodBeat.o(49723);
  }
  
  public static void adY()
  {
    AppMethodBeat.i(49718);
    ae.i("MicroMsg.DynamicBgCrashHelper", "alvinluo markWillCrash");
    if (sp == null) {
      sp = ak.fox();
    }
    if (sp != null)
    {
      b.hZ(false);
      sp.edit().putBoolean("dynamic_bg_will_crash", true).apply();
    }
    nep = true;
    AppMethodBeat.o(49718);
  }
  
  public static boolean aeb()
  {
    return neq;
  }
  
  public static boolean aec()
  {
    return ner;
  }
  
  public static void aed()
  {
    AppMethodBeat.i(49721);
    if (sp == null) {
      sp = ak.fox();
    }
    if (sp != null)
    {
      int i = sp.getInt("dynamic_bg_draw_start_point_count", 0);
      ae.i("MicroMsg.DynamicBgCrashHelper", "alvinluo markDrawStartPoint current: %d", new Object[] { Integer.valueOf(i) });
      if (i > 2)
      {
        b.hZ(false);
        sp.edit().putBoolean("dynamic_bg_will_crash", true).apply();
      }
      sp.edit().putInt("dynamic_bg_draw_start_point_count", i + 1).apply();
    }
    AppMethodBeat.o(49721);
  }
  
  public static void aee()
  {
    AppMethodBeat.i(49722);
    ae.i("MicroMsg.DynamicBgCrashHelper", "alvinluo markDrawEndPoint");
    sp.edit().putInt("dynamic_bg_draw_start_point_count", 0).apply();
    sp.edit().putBoolean("dynamic_bg_will_crash", false).apply();
    b.hZ(true);
    ner = false;
    AppMethodBeat.o(49722);
  }
  
  public static boolean bEe()
  {
    AppMethodBeat.i(49715);
    if (sp != null)
    {
      int i = sp.getInt("dynamic_bg_init_start_point_count", 0);
      int j = sp.getInt("dynamic_bg_draw_start_point_count", 0);
      boolean bool = sp.getBoolean("dynamic_bg_init_crash", false);
      neq = bool;
      if ((bool) || (i >= 2) || (j >= 2))
      {
        nep = true;
        sp.edit().putBoolean("dynamic_bg_will_crash", true).apply();
        AppMethodBeat.o(49715);
        return true;
      }
      nep = false;
      AppMethodBeat.o(49715);
      return false;
    }
    AppMethodBeat.o(49715);
    return false;
  }
  
  public static void bEf()
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
    neq = false;
    nep = false;
    AppMethodBeat.o(49716);
  }
  
  public static void bEg()
  {
    AppMethodBeat.i(49717);
    ae.i("MicroMsg.DynamicBgCrashHelper", "alvinluo markInitCrash");
    b.hZ(false);
    if (sp == null) {
      sp = ak.fox();
    }
    if (sp != null) {
      sp.edit().putBoolean("dynamic_bg_init_crash", true).apply();
    }
    neq = true;
    AppMethodBeat.o(49717);
  }
  
  public static void bEh()
  {
    AppMethodBeat.i(49719);
    if (sp == null) {
      sp = ak.fox();
    }
    if (sp != null)
    {
      int i = sp.getInt("dynamic_bg_init_start_point_count", 0);
      ae.i("MicroMsg.DynamicBgCrashHelper", "alvinluo markInitStartPoint current: %d", new Object[] { Integer.valueOf(i) });
      if (i > 2)
      {
        b.hZ(false);
        sp.edit().putBoolean("dynamic_bg_will_crash", true).apply();
      }
      sp.edit().putInt("dynamic_bg_init_start_point_count", i + 1).apply();
    }
    AppMethodBeat.o(49719);
  }
  
  public static void bEi()
  {
    AppMethodBeat.i(49720);
    ae.i("MicroMsg.DynamicBgCrashHelper", "alvinluo markInitEndPoint");
    sp.edit().putInt("dynamic_bg_init_start_point_count", 0).apply();
    sp.edit().putBoolean("dynamic_bg_will_crash", false).apply();
    sp.edit().putBoolean("dynamic_bg_init_crash", false).apply();
    nep = false;
    neq = false;
    b.hZ(true);
    AppMethodBeat.o(49720);
  }
  
  public static boolean bEj()
  {
    return nep;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.a.c
 * JD-Core Version:    0.7.0.1
 */