package com.tencent.mm.plugin.appbrand.widget.desktop.a;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.desktop.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;

public final class c
{
  private static boolean myA;
  private static boolean myB;
  private static boolean myC;
  private static SharedPreferences sp;
  
  static
  {
    AppMethodBeat.i(49723);
    sp = ai.eUY();
    myA = false;
    myB = false;
    myC = true;
    AppMethodBeat.o(49723);
  }
  
  public static void abi()
  {
    AppMethodBeat.i(49718);
    ac.i("MicroMsg.DynamicBgCrashHelper", "alvinluo markWillCrash");
    if (sp == null) {
      sp = ai.eUY();
    }
    if (sp != null)
    {
      b.hR(false);
      sp.edit().putBoolean("dynamic_bg_will_crash", true).apply();
    }
    myA = true;
    AppMethodBeat.o(49718);
  }
  
  public static boolean abl()
  {
    return myB;
  }
  
  public static boolean abm()
  {
    return myC;
  }
  
  public static void abn()
  {
    AppMethodBeat.i(49721);
    if (sp == null) {
      sp = ai.eUY();
    }
    if (sp != null)
    {
      int i = sp.getInt("dynamic_bg_draw_start_point_count", 0);
      ac.i("MicroMsg.DynamicBgCrashHelper", "alvinluo markDrawStartPoint current: %d", new Object[] { Integer.valueOf(i) });
      if (i > 2)
      {
        b.hR(false);
        sp.edit().putBoolean("dynamic_bg_will_crash", true).apply();
      }
      sp.edit().putInt("dynamic_bg_draw_start_point_count", i + 1).apply();
    }
    AppMethodBeat.o(49721);
  }
  
  public static void abo()
  {
    AppMethodBeat.i(49722);
    ac.i("MicroMsg.DynamicBgCrashHelper", "alvinluo markDrawEndPoint");
    sp.edit().putInt("dynamic_bg_draw_start_point_count", 0).apply();
    sp.edit().putBoolean("dynamic_bg_will_crash", false).apply();
    b.hR(true);
    myC = false;
    AppMethodBeat.o(49722);
  }
  
  public static boolean bzi()
  {
    AppMethodBeat.i(49715);
    if (sp != null)
    {
      int i = sp.getInt("dynamic_bg_init_start_point_count", 0);
      int j = sp.getInt("dynamic_bg_draw_start_point_count", 0);
      boolean bool = sp.getBoolean("dynamic_bg_init_crash", false);
      myB = bool;
      if ((bool) || (i >= 2) || (j >= 2))
      {
        myA = true;
        sp.edit().putBoolean("dynamic_bg_will_crash", true).apply();
        AppMethodBeat.o(49715);
        return true;
      }
      myA = false;
      AppMethodBeat.o(49715);
      return false;
    }
    AppMethodBeat.o(49715);
    return false;
  }
  
  public static void bzj()
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
    myB = false;
    myA = false;
    AppMethodBeat.o(49716);
  }
  
  public static void bzk()
  {
    AppMethodBeat.i(49717);
    ac.i("MicroMsg.DynamicBgCrashHelper", "alvinluo markInitCrash");
    b.hR(false);
    if (sp == null) {
      sp = ai.eUY();
    }
    if (sp != null) {
      sp.edit().putBoolean("dynamic_bg_init_crash", true).apply();
    }
    myB = true;
    AppMethodBeat.o(49717);
  }
  
  public static void bzl()
  {
    AppMethodBeat.i(49719);
    if (sp == null) {
      sp = ai.eUY();
    }
    if (sp != null)
    {
      int i = sp.getInt("dynamic_bg_init_start_point_count", 0);
      ac.i("MicroMsg.DynamicBgCrashHelper", "alvinluo markInitStartPoint current: %d", new Object[] { Integer.valueOf(i) });
      if (i > 2)
      {
        b.hR(false);
        sp.edit().putBoolean("dynamic_bg_will_crash", true).apply();
      }
      sp.edit().putInt("dynamic_bg_init_start_point_count", i + 1).apply();
    }
    AppMethodBeat.o(49719);
  }
  
  public static void bzm()
  {
    AppMethodBeat.i(49720);
    ac.i("MicroMsg.DynamicBgCrashHelper", "alvinluo markInitEndPoint");
    sp.edit().putInt("dynamic_bg_init_start_point_count", 0).apply();
    sp.edit().putBoolean("dynamic_bg_will_crash", false).apply();
    sp.edit().putBoolean("dynamic_bg_init_crash", false).apply();
    myA = false;
    myB = false;
    b.hR(true);
    AppMethodBeat.o(49720);
  }
  
  public static boolean bzn()
  {
    return myA;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.a.c
 * JD-Core Version:    0.7.0.1
 */