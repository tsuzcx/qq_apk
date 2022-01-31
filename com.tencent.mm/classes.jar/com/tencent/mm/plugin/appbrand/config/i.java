package com.tencent.mm.plugin.appbrand.config;

import android.content.SharedPreferences.Editor;
import com.tencent.luggage.sdk.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.performance.a;
import com.tencent.mmkv.MMKV;

public final class i
{
  private static final MMKV hjd;
  
  static
  {
    AppMethodBeat.i(140819);
    hjd = MMKV.mmkvWithID("com.tencent.mm.plugin.appbrand.config.AppDebugInfoHelper", 2);
    AppMethodBeat.o(140819);
  }
  
  public static boolean Ab(String paramString)
  {
    AppMethodBeat.i(140816);
    boolean bool = hjd.getBoolean(paramString + "_AppDebugEnabled", false);
    AppMethodBeat.o(140816);
    return bool;
  }
  
  public static boolean a(b paramb)
  {
    AppMethodBeat.i(140818);
    a locala = (a)paramb.d(a.class, false);
    if (locala == null)
    {
      AppMethodBeat.o(140818);
      return false;
    }
    if (paramb.wV())
    {
      AppMethodBeat.o(140818);
      return false;
    }
    boolean bool = locala.iAF;
    AppMethodBeat.o(140818);
    return bool;
  }
  
  public static void ab(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(140815);
    hjd.putBoolean(paramString + "_AppDebugEnabled", paramBoolean).commit();
    AppMethodBeat.o(140815);
  }
  
  public static void zY(String paramString)
  {
    AppMethodBeat.i(140817);
    hjd.remove(paramString + "_AppDebugEnabled").commit();
    AppMethodBeat.o(140817);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.i
 * JD-Core Version:    0.7.0.1
 */