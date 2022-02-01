package com.tencent.mm.plugin.appbrand.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.jsapi.co;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.r.a.c;
import com.tencent.mm.sdk.platformtools.ad;

public final class af
{
  public static boolean dS(Context paramContext)
  {
    AppMethodBeat.i(197450);
    DisplayMetrics localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
    double d = Math.pow(localDisplayMetrics.widthPixels / localDisplayMetrics.xdpi, 2.0D);
    d = Math.sqrt(Math.pow(localDisplayMetrics.heightPixels / localDisplayMetrics.ydpi, 2.0D) + d);
    if (((paramContext.getResources().getConfiguration().screenLayout & 0xF) >= 3) && (d >= 7.0D))
    {
      AppMethodBeat.o(197450);
      return true;
    }
    AppMethodBeat.o(197450);
    return false;
  }
  
  public static int[] f(h paramh)
  {
    AppMethodBeat.i(135384);
    paramh = g(paramh);
    ad.v("Luggage.WXA.UIUtil", "getScreenSize: [x,y] = [%d,%d]", new Object[] { Integer.valueOf(paramh[0]), Integer.valueOf(paramh[1]) });
    AppMethodBeat.o(135384);
    return paramh;
  }
  
  private static int[] g(h paramh)
  {
    AppMethodBeat.i(197449);
    c localc;
    if (paramh.getRuntime() != null)
    {
      localc = paramh.getRuntime().getWindowAndroid();
      if (localc == null) {
        break label74;
      }
      ad.v("Luggage.WXA.UIUtil", "getScreenSizeInner: V_DM");
    }
    for (paramh = localc.getVDisplayMetrics();; paramh = paramh.getContext().getResources().getDisplayMetrics())
    {
      int i = paramh.widthPixels;
      int j = paramh.heightPixels;
      AppMethodBeat.o(197449);
      return new int[] { i, j };
      localc = null;
      break;
      label74:
      ad.v("Luggage.WXA.UIUtil", "getScreenSizeInner: normal DM");
    }
  }
  
  public static View k(d paramd)
  {
    AppMethodBeat.i(135382);
    paramd = co.i(paramd);
    if (paramd == null)
    {
      AppMethodBeat.o(135382);
      return null;
    }
    paramd = paramd.lZG;
    AppMethodBeat.o(135382);
    return paramd;
  }
  
  public static int[] l(d paramd)
  {
    AppMethodBeat.i(135383);
    paramd = m(paramd);
    ad.v("Luggage.WXA.UIUtil", "getWindowWidthHeight: [x,y] = [%d,%d]", new Object[] { Integer.valueOf(paramd[0]), Integer.valueOf(paramd[1]) });
    AppMethodBeat.o(135383);
    return paramd;
  }
  
  private static int[] m(d paramd)
  {
    AppMethodBeat.i(197448);
    View localView = k(paramd);
    int i;
    int j;
    if ((localView != null) && (localView.isLaidOut()))
    {
      ad.i("Luggage.WXA.UIUtil", "getWindowWidthHeight Method: normal");
      i = localView.getWidth();
      j = localView.getHeight();
      AppMethodBeat.o(197448);
      return new int[] { i, j };
    }
    if ((paramd.getContext() instanceof Activity))
    {
      ad.i("Luggage.WXA.UIUtil", "getWindowWidthHeight Method: DecorView");
      localView = ((Activity)paramd.getContext()).getWindow().getDecorView();
      Rect localRect = new Rect();
      localView.getWindowVisibleDisplayFrame(localRect);
      if (localRect.width() <= 0)
      {
        ad.e("Luggage.WXA.UIUtil", "getWindowWidthHeight try Method(DecorView) but rect.width()<=0, use Method(Screen) instead");
        paramd = f(paramd);
        AppMethodBeat.o(197448);
        return paramd;
      }
      i = localRect.right;
      j = localRect.left;
      int k = localRect.bottom;
      int m = localRect.top;
      int n = paramd.getContext().getResources().getDimensionPixelSize(2131165250);
      AppMethodBeat.o(197448);
      return new int[] { i - j, k - m - n };
    }
    ad.i("Luggage.WXA.UIUtil", "getWindowWidthHeight Method: Screen");
    paramd = f(paramd);
    AppMethodBeat.o(197448);
    return paramd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.af
 * JD-Core Version:    0.7.0.1
 */