package com.tencent.mm.plugin.appbrand.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.jsapi.dp;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.platform.window.c;
import com.tencent.mm.sdk.platformtools.Log;

public final class aq
{
  public static int[] d(k paramk)
  {
    AppMethodBeat.i(135384);
    paramk = e(paramk);
    Log.v("Luggage.WXA.UIUtil", "getScreenSize: [x,y] = [%d,%d]", new Object[] { Integer.valueOf(paramk[0]), Integer.valueOf(paramk[1]) });
    AppMethodBeat.o(135384);
    return paramk;
  }
  
  private static int[] e(k paramk)
  {
    AppMethodBeat.i(317413);
    c localc;
    if (paramk.getRuntime() != null)
    {
      localc = paramk.getRuntime().getWindowAndroid();
      if (localc == null) {
        break label74;
      }
      Log.v("Luggage.WXA.UIUtil", "getScreenSizeInner: V_DM");
    }
    for (paramk = localc.getVDisplayMetrics();; paramk = paramk.getContext().getResources().getDisplayMetrics())
    {
      int i = paramk.widthPixels;
      int j = paramk.heightPixels;
      AppMethodBeat.o(317413);
      return new int[] { i, j };
      localc = null;
      break;
      label74:
      Log.v("Luggage.WXA.UIUtil", "getScreenSizeInner: normal DM");
    }
  }
  
  public static int f(k paramk)
  {
    AppMethodBeat.i(317423);
    int[] arrayOfInt = new int[2];
    if ((paramk instanceof g))
    {
      paramk = m((g)paramk);
      if (paramk != null) {
        paramk.getLocationOnScreen(arrayOfInt);
      }
    }
    for (int i = arrayOfInt[1];; i = 0)
    {
      Log.v("Luggage.WXA.UIUtil", "getScreenTop: [%d]", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(317423);
      return i;
    }
  }
  
  private static View m(g paramg)
  {
    AppMethodBeat.i(135382);
    paramg = dp.j(paramg);
    if (paramg == null)
    {
      AppMethodBeat.o(135382);
      return null;
    }
    paramg = paramg.tuD;
    AppMethodBeat.o(135382);
    return paramg;
  }
  
  public static int[] n(g paramg)
  {
    AppMethodBeat.i(135383);
    paramg = o(paramg);
    Log.v("Luggage.WXA.UIUtil", "getWindowWidthHeight: [x,y] = [%d,%d]", new Object[] { Integer.valueOf(paramg[0]), Integer.valueOf(paramg[1]) });
    AppMethodBeat.o(135383);
    return paramg;
  }
  
  private static int[] o(g paramg)
  {
    AppMethodBeat.i(317392);
    Object localObject = m(paramg);
    int i;
    int j;
    if ((localObject != null) && (((View)localObject).isLaidOut()))
    {
      Log.i("Luggage.WXA.UIUtil", "getWindowWidthHeight Method: normal");
      i = ((View)localObject).getWidth();
      j = ((View)localObject).getHeight();
      AppMethodBeat.o(317392);
      return new int[] { i, j };
    }
    if ((paramg.getContext() instanceof Activity))
    {
      Log.i("Luggage.WXA.UIUtil", "getWindowWidthHeight Method: windowAndroid");
      localObject = paramg.getWindowAndroid().getVDisplayMetrics();
      if (((DisplayMetrics)localObject).widthPixels <= 0)
      {
        Log.e("Luggage.WXA.UIUtil", "getWindowWidthHeight try Method(windowAndroid) but width<=0, use Method(Screen) instead");
        paramg = d(paramg);
        AppMethodBeat.o(317392);
        return paramg;
      }
      i = ((DisplayMetrics)localObject).widthPixels;
      j = ((DisplayMetrics)localObject).heightPixels;
      AppMethodBeat.o(317392);
      return new int[] { i, j };
    }
    Log.i("Luggage.WXA.UIUtil", "getWindowWidthHeight Method: Screen");
    paramg = d(paramg);
    AppMethodBeat.o(317392);
    return paramg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.aq
 * JD-Core Version:    0.7.0.1
 */