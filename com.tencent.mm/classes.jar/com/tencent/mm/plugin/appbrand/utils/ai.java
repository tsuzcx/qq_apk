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
import com.tencent.mm.plugin.appbrand.jsapi.df;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.platform.window.c;
import com.tencent.mm.sdk.platformtools.Log;

public final class ai
{
  public static boolean et(Context paramContext)
  {
    AppMethodBeat.i(219595);
    DisplayMetrics localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
    double d = Math.pow(localDisplayMetrics.widthPixels / localDisplayMetrics.xdpi, 2.0D);
    d = Math.sqrt(Math.pow(localDisplayMetrics.heightPixels / localDisplayMetrics.ydpi, 2.0D) + d);
    if (((paramContext.getResources().getConfiguration().screenLayout & 0xF) >= 3) && (d >= 7.0D))
    {
      AppMethodBeat.o(219595);
      return true;
    }
    AppMethodBeat.o(219595);
    return false;
  }
  
  public static int[] f(k paramk)
  {
    AppMethodBeat.i(135384);
    paramk = g(paramk);
    Log.v("Luggage.WXA.UIUtil", "getScreenSize: [x,y] = [%d,%d]", new Object[] { Integer.valueOf(paramk[0]), Integer.valueOf(paramk[1]) });
    AppMethodBeat.o(135384);
    return paramk;
  }
  
  private static int[] g(k paramk)
  {
    AppMethodBeat.i(219594);
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
      AppMethodBeat.o(219594);
      return new int[] { i, j };
      localc = null;
      break;
      label74:
      Log.v("Luggage.WXA.UIUtil", "getScreenSizeInner: normal DM");
    }
  }
  
  public static View m(d paramd)
  {
    AppMethodBeat.i(135382);
    paramd = df.i(paramd);
    if (paramd == null)
    {
      AppMethodBeat.o(135382);
      return null;
    }
    paramd = paramd.noq;
    AppMethodBeat.o(135382);
    return paramd;
  }
  
  public static int[] n(d paramd)
  {
    AppMethodBeat.i(135383);
    paramd = o(paramd);
    Log.v("Luggage.WXA.UIUtil", "getWindowWidthHeight: [x,y] = [%d,%d]", new Object[] { Integer.valueOf(paramd[0]), Integer.valueOf(paramd[1]) });
    AppMethodBeat.o(135383);
    return paramd;
  }
  
  private static int[] o(d paramd)
  {
    AppMethodBeat.i(219593);
    View localView = m(paramd);
    int i;
    int j;
    if ((localView != null) && (localView.isLaidOut()))
    {
      Log.i("Luggage.WXA.UIUtil", "getWindowWidthHeight Method: normal");
      i = localView.getWidth();
      j = localView.getHeight();
      AppMethodBeat.o(219593);
      return new int[] { i, j };
    }
    if ((paramd.getContext() instanceof Activity))
    {
      Log.i("Luggage.WXA.UIUtil", "getWindowWidthHeight Method: DecorView");
      localView = ((Activity)paramd.getContext()).getWindow().getDecorView();
      Rect localRect = new Rect();
      localView.getWindowVisibleDisplayFrame(localRect);
      if (localRect.width() <= 0)
      {
        Log.e("Luggage.WXA.UIUtil", "getWindowWidthHeight try Method(DecorView) but rect.width()<=0, use Method(Screen) instead");
        paramd = f(paramd);
        AppMethodBeat.o(219593);
        return paramd;
      }
      i = localRect.right;
      j = localRect.left;
      int k = localRect.bottom;
      int m = localRect.top;
      int n = paramd.getContext().getResources().getDimensionPixelSize(2131165254);
      AppMethodBeat.o(219593);
      return new int[] { i - j, k - m - n };
    }
    Log.i("Luggage.WXA.UIUtil", "getWindowWidthHeight Method: Screen");
    paramd = f(paramd);
    AppMethodBeat.o(219593);
    return paramd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.ai
 * JD-Core Version:    0.7.0.1
 */