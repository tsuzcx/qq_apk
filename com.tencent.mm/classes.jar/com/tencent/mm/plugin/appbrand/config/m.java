package com.tencent.mm.plugin.appbrand.config;

import android.content.SharedPreferences.Editor;
import com.tencent.luggage.a.e;
import com.tencent.luggage.sdk.e.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.performance.a;
import com.tencent.mm.plugin.appbrand.permission.i;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;

public final class m
{
  private static final MultiProcessMMKV cQO;
  
  static
  {
    AppMethodBeat.i(146993);
    cQO = MultiProcessMMKV.getMMKV("com.tencent.mm.plugin.appbrand.config.AppDebugInfoHelper");
    AppMethodBeat.o(146993);
  }
  
  public static boolean aeO(String paramString)
  {
    AppMethodBeat.i(146990);
    boolean bool = cQO.getBoolean(paramString + "_AppDebugEnabled", false);
    AppMethodBeat.o(146990);
    return bool;
  }
  
  public static boolean aeP(String paramString)
  {
    AppMethodBeat.i(234372);
    boolean bool = cQO.contains(paramString + "_AppDebugEnabled");
    AppMethodBeat.o(234372);
    return bool;
  }
  
  public static void aeQ(String paramString)
  {
    AppMethodBeat.i(234376);
    cQO.putString("V8DebugFlags", paramString);
    AppMethodBeat.o(234376);
  }
  
  public static boolean aeR(String paramString)
  {
    AppMethodBeat.i(234382);
    boolean bool = ((i)e.K(i.class)).ami(paramString);
    AppMethodBeat.o(234382);
    return bool;
  }
  
  public static void ao(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(146989);
    cQO.putBoolean(paramString + "_AppDebugEnabled", paramBoolean).commit();
    AppMethodBeat.o(146989);
  }
  
  public static String bLr()
  {
    AppMethodBeat.i(234378);
    String str = cQO.getString("V8DebugFlags", "");
    AppMethodBeat.o(234378);
    return str;
  }
  
  public static void bLs()
  {
    AppMethodBeat.i(234380);
    cQO.remove("V8DebugFlags");
    AppMethodBeat.o(234380);
  }
  
  public static void dU(String paramString)
  {
    AppMethodBeat.i(146991);
    cQO.remove(paramString + "_AppDebugEnabled").commit();
    AppMethodBeat.o(146991);
  }
  
  public static boolean i(d paramd)
  {
    AppMethodBeat.i(146992);
    a locala = (a)paramd.d(a.class, false);
    if (locala == null)
    {
      AppMethodBeat.o(146992);
      return false;
    }
    if (paramd.Rp())
    {
      AppMethodBeat.o(146992);
      return false;
    }
    boolean bool = locala.qyC;
    AppMethodBeat.o(146992);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.m
 * JD-Core Version:    0.7.0.1
 */