package com.tencent.mm.plugin.appbrand.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.jsapi.dh;
import com.tencent.mm.plugin.appbrand.jsapi.j;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.platform.window.c;
import com.tencent.mm.sdk.platformtools.Log;

public final class ak
{
  public static int[] f(j paramj)
  {
    AppMethodBeat.i(135384);
    paramj = g(paramj);
    Log.v("Luggage.WXA.UIUtil", "getScreenSize: [x,y] = [%d,%d]", new Object[] { Integer.valueOf(paramj[0]), Integer.valueOf(paramj[1]) });
    AppMethodBeat.o(135384);
    return paramj;
  }
  
  private static int[] g(j paramj)
  {
    AppMethodBeat.i(245979);
    c localc;
    if (paramj.getRuntime() != null)
    {
      localc = paramj.getRuntime().getWindowAndroid();
      if (localc == null) {
        break label74;
      }
      Log.v("Luggage.WXA.UIUtil", "getScreenSizeInner: V_DM");
    }
    for (paramj = localc.getVDisplayMetrics();; paramj = paramj.getContext().getResources().getDisplayMetrics())
    {
      int i = paramj.widthPixels;
      int j = paramj.heightPixels;
      AppMethodBeat.o(245979);
      return new int[] { i, j };
      localc = null;
      break;
      label74:
      Log.v("Luggage.WXA.UIUtil", "getScreenSizeInner: normal DM");
    }
  }
  
  public static View q(g paramg)
  {
    AppMethodBeat.i(135382);
    paramg = dh.k(paramg);
    if (paramg == null)
    {
      AppMethodBeat.o(135382);
      return null;
    }
    paramg = paramg.qpZ;
    AppMethodBeat.o(135382);
    return paramg;
  }
  
  public static int[] r(g paramg)
  {
    AppMethodBeat.i(135383);
    paramg = s(paramg);
    Log.v("Luggage.WXA.UIUtil", "getWindowWidthHeight: [x,y] = [%d,%d]", new Object[] { Integer.valueOf(paramg[0]), Integer.valueOf(paramg[1]) });
    AppMethodBeat.o(135383);
    return paramg;
  }
  
  private static int[] s(g paramg)
  {
    AppMethodBeat.i(245976);
    Object localObject = q(paramg);
    int i;
    int j;
    if ((localObject != null) && (((View)localObject).isLaidOut()))
    {
      Log.i("Luggage.WXA.UIUtil", "getWindowWidthHeight Method: normal");
      i = ((View)localObject).getWidth();
      j = ((View)localObject).getHeight();
      AppMethodBeat.o(245976);
      return new int[] { i, j };
    }
    if ((paramg.getContext() instanceof Activity))
    {
      Log.i("Luggage.WXA.UIUtil", "getWindowWidthHeight Method: windowAndroid");
      localObject = paramg.getWindowAndroid().getVDisplayMetrics();
      if (((DisplayMetrics)localObject).widthPixels <= 0)
      {
        Log.e("Luggage.WXA.UIUtil", "getWindowWidthHeight try Method(windowAndroid) but width<=0, use Method(Screen) instead");
        paramg = f(paramg);
        AppMethodBeat.o(245976);
        return paramg;
      }
      i = ((DisplayMetrics)localObject).widthPixels;
      j = ((DisplayMetrics)localObject).heightPixels;
      AppMethodBeat.o(245976);
      return new int[] { i, j };
    }
    Log.i("Luggage.WXA.UIUtil", "getWindowWidthHeight Method: Screen");
    paramg = f(paramg);
    AppMethodBeat.o(245976);
    return paramg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.ak
 * JD-Core Version:    0.7.0.1
 */