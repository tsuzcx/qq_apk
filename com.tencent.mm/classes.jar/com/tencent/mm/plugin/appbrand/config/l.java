package com.tencent.mm.plugin.appbrand.config;

import android.content.SharedPreferences.Editor;
import com.tencent.luggage.a.e;
import com.tencent.luggage.sdk.d.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.performance.a;
import com.tencent.mm.plugin.appbrand.permission.i;
import com.tencent.mm.sdk.platformtools.ay;

public final class l
{
  private static final ay cCf;
  
  static
  {
    AppMethodBeat.i(146993);
    cCf = ay.aRW("com.tencent.mm.plugin.appbrand.config.AppDebugInfoHelper");
    AppMethodBeat.o(146993);
  }
  
  public static void NQ(String paramString)
  {
    AppMethodBeat.i(146991);
    cCf.remove(paramString + "_AppDebugEnabled").commit();
    AppMethodBeat.o(146991);
  }
  
  public static boolean NU(String paramString)
  {
    AppMethodBeat.i(146990);
    boolean bool = cCf.getBoolean(paramString + "_AppDebugEnabled", false);
    AppMethodBeat.o(146990);
    return bool;
  }
  
  public static void NV(String paramString)
  {
    AppMethodBeat.i(220776);
    cCf.putString("V8DebugFlags", paramString);
    AppMethodBeat.o(220776);
  }
  
  public static boolean NW(String paramString)
  {
    AppMethodBeat.i(220779);
    boolean bool = ((i)e.K(i.class)).UA(paramString);
    AppMethodBeat.o(220779);
    return bool;
  }
  
  public static void al(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(146989);
    cCf.putBoolean(paramString + "_AppDebugEnabled", paramBoolean).commit();
    AppMethodBeat.o(146989);
  }
  
  public static String beL()
  {
    AppMethodBeat.i(220777);
    String str = cCf.getString("V8DebugFlags", "");
    AppMethodBeat.o(220777);
    return str;
  }
  
  public static void beM()
  {
    AppMethodBeat.i(220778);
    cCf.remove("V8DebugFlags");
    AppMethodBeat.o(220778);
  }
  
  public static boolean c(d paramd)
  {
    AppMethodBeat.i(146992);
    a locala = (a)paramd.c(a.class, false);
    if (locala == null)
    {
      AppMethodBeat.o(146992);
      return false;
    }
    if (paramd.Fj())
    {
      AppMethodBeat.o(146992);
      return false;
    }
    boolean bool = locala.mmb;
    AppMethodBeat.o(146992);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.l
 * JD-Core Version:    0.7.0.1
 */