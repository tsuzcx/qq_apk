package com.tencent.mm.plugin.appbrand.jsapi.g;

import android.content.Context;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.au.i;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.webview.luggage.c.c;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class a
{
  private static int lZJ = -1;
  private static int lZO = 0;
  private static boolean nwq = false;
  public static int[] oTR = { au.i.appbrand_handoffFail_NotSupported, au.i.appbrand_handoffFail_NotSupported, au.i.appbrand_handoffFail_InvalidLogin, au.i.appbrand_handoffFail_LowVersion, au.i.appbrand_handoffFail_NotSupported };
  
  public static void ab(Context paramContext, String paramString)
  {
    AppMethodBeat.i(275491);
    com.tencent.e.h.ZvG.bc(new a.2(paramContext, paramString));
    AppMethodBeat.o(275491);
  }
  
  public static void dP(Context paramContext)
  {
    AppMethodBeat.i(275490);
    com.tencent.e.h.ZvG.bc(new a.1(paramContext));
    AppMethodBeat.o(275490);
  }
  
  public static int l(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(275489);
    lZJ = s.abW(paramString2).lZJ;
    lZO = s.abW(paramString2).lZO;
    boolean bool = s.abW(paramString2).nwq;
    nwq = bool;
    if ((!bool) || (lZJ == -1) || (lZO == 0))
    {
      Log.i(paramString1, "invalid login,isWXOnline: %b , iconType : %d ,clientVersion: %d", new Object[] { Boolean.valueOf(nwq), Integer.valueOf(lZJ), Integer.valueOf(lZO) });
      AppMethodBeat.o(275489);
      return 2;
    }
    if ((lZJ == 1) || (lZJ == 2))
    {
      JSONObject localJSONObject = c.agO(((b)com.tencent.mm.kernel.h.ae(b.class)).a(b.a.vYJ, ""));
      if (lZJ == 2) {}
      String str;
      for (paramString2 = "mac_appbrand";; paramString2 = "windows_appbrand")
      {
        str = paramString2;
        if (paramBoolean) {
          str = paramString2 + "_game";
        }
        paramString2 = str + "_version";
        if ((localJSONObject != null) && (localJSONObject.has(str)) && (localJSONObject.has(paramString2))) {
          break;
        }
        Log.i(paramString1, "xclient data format wrong ,jsonObject:".concat(String.valueOf(localJSONObject)));
        AppMethodBeat.o(275489);
        return 4;
      }
      int i = localJSONObject.optInt(str, 0);
      int j = localJSONObject.optInt(paramString2, 0);
      if ((1 != i) || (j == 0))
      {
        Log.i(paramString1, "pc not supported ,iconType: %d ,isGame :%b", new Object[] { Integer.valueOf(lZJ), Boolean.valueOf(paramBoolean) });
        AppMethodBeat.o(275489);
        return 4;
      }
      if (lZO < j)
      {
        Log.i(paramString1, "version is old,clientVersion: %d ,isGame :%b", new Object[] { Integer.valueOf(lZO), Boolean.valueOf(paramBoolean) });
        AppMethodBeat.o(275489);
        return 3;
      }
    }
    else
    {
      Log.i(paramString1, "invalid login,iconType:" + lZJ);
      AppMethodBeat.o(275489);
      return 2;
    }
    AppMethodBeat.o(275489);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.a
 * JD-Core Version:    0.7.0.1
 */