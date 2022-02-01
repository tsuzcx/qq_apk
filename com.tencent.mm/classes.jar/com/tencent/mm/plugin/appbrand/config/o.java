package com.tencent.mm.plugin.appbrand.config;

import android.content.SharedPreferences.Editor;
import com.tencent.luggage.a.e;
import com.tencent.luggage.sdk.e.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.performance.a;
import com.tencent.mm.plugin.appbrand.permission.i;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;

public final class o
{
  private static final MultiProcessMMKV eMf;
  
  static
  {
    AppMethodBeat.i(146993);
    eMf = MultiProcessMMKV.getMMKV("com.tencent.mm.plugin.appbrand.config.AppDebugInfoHelper");
    AppMethodBeat.o(146993);
  }
  
  public static boolean N(String paramString)
  {
    AppMethodBeat.i(146990);
    if ((eMf.getBoolean(paramString + "_AppDebugEnabled", false)) || (ckL()))
    {
      AppMethodBeat.o(146990);
      return true;
    }
    AppMethodBeat.o(146990);
    return false;
  }
  
  public static boolean Xr(String paramString)
  {
    AppMethodBeat.i(323384);
    boolean bool = eMf.contains(paramString + "_AppDebugEnabled");
    AppMethodBeat.o(323384);
    return bool;
  }
  
  public static void Xs(String paramString)
  {
    AppMethodBeat.i(323390);
    eMf.putString("V8DebugFlags", paramString);
    AppMethodBeat.o(323390);
  }
  
  public static boolean Xt(String paramString)
  {
    AppMethodBeat.i(323404);
    boolean bool = ((i)e.T(i.class)).afq(paramString);
    AppMethodBeat.o(323404);
    return bool;
  }
  
  public static void aw(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(146989);
    eMf.putBoolean(paramString + "_AppDebugEnabled", paramBoolean).commit();
    AppMethodBeat.o(146989);
  }
  
  public static boolean ckL()
  {
    AppMethodBeat.i(323377);
    boolean bool = eMf.getBoolean("ENABLE_ALL_APP_DEBUG", false);
    AppMethodBeat.o(323377);
    return bool;
  }
  
  public static String ckM()
  {
    AppMethodBeat.i(323393);
    String str = eMf.getString("V8DebugFlags", "");
    AppMethodBeat.o(323393);
    return str;
  }
  
  public static void ckN()
  {
    AppMethodBeat.i(323397);
    eMf.remove("V8DebugFlags");
    AppMethodBeat.o(323397);
  }
  
  public static void fe(String paramString)
  {
    AppMethodBeat.i(146991);
    eMf.remove(paramString + "_AppDebugEnabled").commit();
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
    if (paramd.arD())
    {
      AppMethodBeat.o(146992);
      return false;
    }
    boolean bool = locala.tDx;
    AppMethodBeat.o(146992);
    return bool;
  }
  
  public static void iw(boolean paramBoolean)
  {
    AppMethodBeat.i(323374);
    eMf.putBoolean("ENABLE_ALL_APP_DEBUG", paramBoolean).commit();
    AppMethodBeat.o(323374);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.o
 * JD-Core Version:    0.7.0.1
 */