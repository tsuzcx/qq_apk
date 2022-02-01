package com.tencent.mm.plugin.appbrand.config;

import android.content.SharedPreferences.Editor;
import com.tencent.luggage.sdk.d.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.performance.a;
import com.tencent.mm.sdk.platformtools.aw;

public final class l
{
  private static final aw cqB;
  
  static
  {
    AppMethodBeat.i(146993);
    cqB = aw.aKT("com.tencent.mm.plugin.appbrand.config.AppDebugInfoHelper");
    AppMethodBeat.o(146993);
  }
  
  public static void JQ(String paramString)
  {
    AppMethodBeat.i(146991);
    cqB.remove(paramString + "_AppDebugEnabled").commit();
    AppMethodBeat.o(146991);
  }
  
  public static boolean JU(String paramString)
  {
    AppMethodBeat.i(146990);
    boolean bool = cqB.getBoolean(paramString + "_AppDebugEnabled", false);
    AppMethodBeat.o(146990);
    return bool;
  }
  
  public static void JV(String paramString)
  {
    AppMethodBeat.i(206130);
    cqB.putString("V8DebugFlags", paramString);
    AppMethodBeat.o(206130);
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
    if (paramc.DF())
    {
      AppMethodBeat.o(146992);
      return false;
    }
    boolean bool = locala.lHq;
    AppMethodBeat.o(146992);
    return bool;
  }
  
  public static void ak(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(146989);
    cqB.putBoolean(paramString + "_AppDebugEnabled", paramBoolean).commit();
    AppMethodBeat.o(146989);
  }
  
  public static String baF()
  {
    AppMethodBeat.i(206131);
    String str = cqB.getString("V8DebugFlags", "");
    AppMethodBeat.o(206131);
    return str;
  }
  
  public static void baG()
  {
    AppMethodBeat.i(206132);
    cqB.remove("V8DebugFlags");
    AppMethodBeat.o(206132);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.l
 * JD-Core Version:    0.7.0.1
 */