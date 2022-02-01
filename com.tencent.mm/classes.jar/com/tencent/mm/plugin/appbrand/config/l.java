package com.tencent.mm.plugin.appbrand.config;

import android.content.SharedPreferences.Editor;
import com.tencent.luggage.sdk.d.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.performance.a;
import com.tencent.mm.sdk.platformtools.ax;

public final class l
{
  private static final ax cBy;
  
  static
  {
    AppMethodBeat.i(146993);
    cBy = ax.aQz("com.tencent.mm.plugin.appbrand.config.AppDebugInfoHelper");
    AppMethodBeat.o(146993);
  }
  
  public static void Nj(String paramString)
  {
    AppMethodBeat.i(146991);
    cBy.remove(paramString + "_AppDebugEnabled").commit();
    AppMethodBeat.o(146991);
  }
  
  public static boolean Nn(String paramString)
  {
    AppMethodBeat.i(146990);
    boolean bool = cBy.getBoolean(paramString + "_AppDebugEnabled", false);
    AppMethodBeat.o(146990);
    return bool;
  }
  
  public static void No(String paramString)
  {
    AppMethodBeat.i(192205);
    cBy.putString("V8DebugFlags", paramString);
    AppMethodBeat.o(192205);
  }
  
  public static void al(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(146989);
    cBy.putBoolean(paramString + "_AppDebugEnabled", paramBoolean).commit();
    AppMethodBeat.o(146989);
  }
  
  public static String bef()
  {
    AppMethodBeat.i(192206);
    String str = cBy.getString("V8DebugFlags", "");
    AppMethodBeat.o(192206);
    return str;
  }
  
  public static void beg()
  {
    AppMethodBeat.i(192207);
    cBy.remove("V8DebugFlags");
    AppMethodBeat.o(192207);
  }
  
  public static boolean c(c paramc)
  {
    AppMethodBeat.i(146992);
    a locala = (a)paramc.c(a.class, false);
    if (locala == null)
    {
      AppMethodBeat.o(146992);
      return false;
    }
    if (paramc.Fe())
    {
      AppMethodBeat.o(146992);
      return false;
    }
    boolean bool = locala.mhc;
    AppMethodBeat.o(146992);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.l
 * JD-Core Version:    0.7.0.1
 */