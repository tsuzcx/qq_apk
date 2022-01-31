package com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.desktop.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public final class d
{
  private static boolean jgR;
  private static boolean jgS;
  private static boolean jgT;
  private static SharedPreferences sp;
  
  static
  {
    AppMethodBeat.i(133973);
    sp = ah.dsQ();
    jgR = false;
    jgS = false;
    jgT = true;
    AppMethodBeat.o(133973);
  }
  
  public static boolean aPP()
  {
    return jgT;
  }
  
  public static boolean aPQ()
  {
    AppMethodBeat.i(133965);
    if (sp != null)
    {
      int i = sp.getInt("dynamic_bg_init_start_point_count", 0);
      int j = sp.getInt("dynamic_bg_draw_start_point_count", 0);
      boolean bool = sp.getBoolean("dynamic_bg_init_crash", false);
      jgS = bool;
      if ((bool) || (i >= 2) || (j >= 2))
      {
        jgR = true;
        sp.edit().putBoolean("dynamic_bg_will_crash", true).apply();
        AppMethodBeat.o(133965);
        return true;
      }
      jgR = false;
      AppMethodBeat.o(133965);
      return false;
    }
    AppMethodBeat.o(133965);
    return false;
  }
  
  public static void aPR()
  {
    AppMethodBeat.i(133966);
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
    jgS = false;
    jgR = false;
    AppMethodBeat.o(133966);
  }
  
  public static void aPS()
  {
    AppMethodBeat.i(133967);
    b.ff(false);
    if (sp == null) {
      sp = ah.dsQ();
    }
    if (sp != null) {
      sp.edit().putBoolean("dynamic_bg_init_crash", true).apply();
    }
    jgS = true;
    AppMethodBeat.o(133967);
  }
  
  public static void aPT()
  {
    AppMethodBeat.i(133968);
    if (sp == null) {
      sp = ah.dsQ();
    }
    if (sp != null)
    {
      b.ff(false);
      sp.edit().putBoolean("dynamic_bg_will_crash", true).apply();
    }
    jgR = true;
    AppMethodBeat.o(133968);
  }
  
  public static boolean aPU()
  {
    return jgS;
  }
  
  public static void aPV()
  {
    AppMethodBeat.i(133969);
    if (sp == null) {
      sp = ah.dsQ();
    }
    if (sp != null)
    {
      int i = sp.getInt("dynamic_bg_init_start_point_count", 0);
      ab.i("MicroMsg.DynamicBgCrashHelper", "alvinluo markInitStartPoint current: %d", new Object[] { Integer.valueOf(i) });
      if (i > 2)
      {
        b.ff(false);
        sp.edit().putBoolean("dynamic_bg_will_crash", true).apply();
      }
      sp.edit().putInt("dynamic_bg_init_start_point_count", i + 1).apply();
    }
    AppMethodBeat.o(133969);
  }
  
  public static void aPW()
  {
    AppMethodBeat.i(133970);
    ab.i("MicroMsg.DynamicBgCrashHelper", "alvinluo markInitEndPoint");
    sp.edit().putInt("dynamic_bg_init_start_point_count", 0).apply();
    sp.edit().putBoolean("dynamic_bg_will_crash", false).apply();
    sp.edit().putBoolean("dynamic_bg_init_crash", false).apply();
    jgR = false;
    jgS = false;
    b.ff(true);
    AppMethodBeat.o(133970);
  }
  
  public static void aPX()
  {
    AppMethodBeat.i(133971);
    if (sp == null) {
      sp = ah.dsQ();
    }
    if (sp != null)
    {
      int i = sp.getInt("dynamic_bg_draw_start_point_count", 0);
      ab.i("MicroMsg.DynamicBgCrashHelper", "alvinluo markDrawStartPoint current: %d", new Object[] { Integer.valueOf(i) });
      if (i > 2)
      {
        b.ff(false);
        sp.edit().putBoolean("dynamic_bg_will_crash", true).apply();
      }
      sp.edit().putInt("dynamic_bg_draw_start_point_count", i + 1).apply();
    }
    AppMethodBeat.o(133971);
  }
  
  public static void aPY()
  {
    AppMethodBeat.i(133972);
    ab.i("MicroMsg.DynamicBgCrashHelper", "alvinluo markDrawEndPoint");
    sp.edit().putInt("dynamic_bg_draw_start_point_count", 0).apply();
    sp.edit().putBoolean("dynamic_bg_will_crash", false).apply();
    b.ff(true);
    jgT = false;
    AppMethodBeat.o(133972);
  }
  
  public static boolean aPZ()
  {
    return jgR;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.d
 * JD-Core Version:    0.7.0.1
 */