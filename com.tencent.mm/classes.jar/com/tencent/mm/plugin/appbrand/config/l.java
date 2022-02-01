package com.tencent.mm.plugin.appbrand.config;

import android.content.SharedPreferences.Editor;
import com.tencent.luggage.sdk.d.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.performance.a;
import com.tencent.mm.sdk.platformtools.ax;

public final class l
{
  private static final ax ctt;
  
  static
  {
    AppMethodBeat.i(146993);
    ctt = ax.aFC("com.tencent.mm.plugin.appbrand.config.AppDebugInfoHelper");
    AppMethodBeat.o(146993);
  }
  
  public static void FM(String paramString)
  {
    AppMethodBeat.i(146991);
    ctt.remove(paramString + "_AppDebugEnabled").commit();
    AppMethodBeat.o(146991);
  }
  
  public static boolean FQ(String paramString)
  {
    AppMethodBeat.i(146990);
    boolean bool = ctt.getBoolean(paramString + "_AppDebugEnabled", false);
    AppMethodBeat.o(146990);
    return bool;
  }
  
  public static void FR(String paramString)
  {
    AppMethodBeat.i(186878);
    ctt.putString("V8DebugFlags", paramString);
    AppMethodBeat.o(186878);
  }
  
  public static boolean a(c paramc)
  {
    AppMethodBeat.i(146992);
    a locala = (a)paramc.c(a.class, false);
    if (locala == null)
    {
      AppMethodBeat.o(146992);
      return false;
    }
    if (paramc.Ec())
    {
      AppMethodBeat.o(146992);
      return false;
    }
    boolean bool = locala.lhx;
    AppMethodBeat.o(146992);
    return bool;
  }
  
  public static String aTH()
  {
    AppMethodBeat.i(186879);
    String str = ctt.getString("V8DebugFlags", "");
    AppMethodBeat.o(186879);
    return str;
  }
  
  public static void aTI()
  {
    AppMethodBeat.i(186880);
    ctt.remove("V8DebugFlags");
    AppMethodBeat.o(186880);
  }
  
  public static void aj(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(146989);
    ctt.putBoolean(paramString + "_AppDebugEnabled", paramBoolean).commit();
    AppMethodBeat.o(146989);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.l
 * JD-Core Version:    0.7.0.1
 */