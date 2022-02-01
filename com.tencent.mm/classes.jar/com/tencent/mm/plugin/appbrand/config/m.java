package com.tencent.mm.plugin.appbrand.config;

import android.content.SharedPreferences.Editor;
import com.tencent.luggage.a.e;
import com.tencent.luggage.sdk.d.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.performance.a;
import com.tencent.mm.plugin.appbrand.permission.i;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;

public final class m
{
  private static final MultiProcessMMKV cQe;
  
  static
  {
    AppMethodBeat.i(146993);
    cQe = MultiProcessMMKV.getMMKV("com.tencent.mm.plugin.appbrand.config.AppDebugInfoHelper");
    AppMethodBeat.o(146993);
  }
  
  public static void WY(String paramString)
  {
    AppMethodBeat.i(146991);
    cQe.remove(paramString + "_AppDebugEnabled").commit();
    AppMethodBeat.o(146991);
  }
  
  public static boolean Xc(String paramString)
  {
    AppMethodBeat.i(146990);
    boolean bool = cQe.getBoolean(paramString + "_AppDebugEnabled", false);
    AppMethodBeat.o(146990);
    return bool;
  }
  
  public static boolean Xd(String paramString)
  {
    AppMethodBeat.i(229881);
    boolean bool = cQe.contains(paramString + "_AppDebugEnabled");
    AppMethodBeat.o(229881);
    return bool;
  }
  
  public static void Xe(String paramString)
  {
    AppMethodBeat.i(229882);
    cQe.putString("V8DebugFlags", paramString);
    AppMethodBeat.o(229882);
  }
  
  public static boolean Xf(String paramString)
  {
    AppMethodBeat.i(229885);
    boolean bool = ((i)e.M(i.class)).aeo(paramString);
    AppMethodBeat.o(229885);
    return bool;
  }
  
  public static void an(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(146989);
    cQe.putBoolean(paramString + "_AppDebugEnabled", paramBoolean).commit();
    AppMethodBeat.o(146989);
  }
  
  public static String bAc()
  {
    AppMethodBeat.i(229883);
    String str = cQe.getString("V8DebugFlags", "");
    AppMethodBeat.o(229883);
    return str;
  }
  
  public static void bAd()
  {
    AppMethodBeat.i(229884);
    cQe.remove("V8DebugFlags");
    AppMethodBeat.o(229884);
  }
  
  public static boolean c(d paramd)
  {
    AppMethodBeat.i(146992);
    a locala = (a)paramd.d(a.class, false);
    if (locala == null)
    {
      AppMethodBeat.o(146992);
      return false;
    }
    if (paramd.OQ())
    {
      AppMethodBeat.o(146992);
      return false;
    }
    boolean bool = locala.nwz;
    AppMethodBeat.o(146992);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.m
 * JD-Core Version:    0.7.0.1
 */