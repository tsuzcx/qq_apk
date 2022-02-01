package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.ai;

public final class d
{
  private static boolean lUj = false;
  
  private static int a(int paramInt, Context paramContext, float paramFloat)
  {
    AppMethodBeat.i(49559);
    if (paramContext == null)
    {
      AppMethodBeat.o(49559);
      return 0;
    }
    int k = dP(paramContext);
    int i;
    if (b.brC()) {
      i = (int)((paramInt - k * paramFloat) / Math.ceil(paramFloat));
    }
    for (;;)
    {
      int j = i;
      if (i < 0) {
        j = 0;
      }
      ad.d("MicroMsg.AppBrandDesktopSizeHelper", "alvinluo itemWidth: %d, itemPadding: %d, viewWidth: %d, countPerPage: %f, leftRightPaddingZero: %b", new Object[] { Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(paramInt), Float.valueOf(paramFloat), Boolean.valueOf(lUj) });
      AppMethodBeat.o(49559);
      return j;
      lUj = false;
      j = dR(paramContext);
      i = (paramInt - j * 2 - (int)paramFloat * k) / (((int)paramFloat - 1) * 2);
      if (i > j)
      {
        i = (paramInt - (int)paramFloat * k) / ((int)paramFloat * 2);
        lUj = true;
      }
      else
      {
        lUj = false;
      }
    }
  }
  
  public static int b(int paramInt, Context paramContext)
  {
    AppMethodBeat.i(49557);
    paramInt = a(paramInt, paramContext, b.getShowCountPerPage());
    AppMethodBeat.o(49557);
    return paramInt;
  }
  
  public static int c(Context paramContext, float paramFloat)
  {
    AppMethodBeat.i(49560);
    if (paramContext == null)
    {
      AppMethodBeat.o(49560);
      return 0;
    }
    int i = a(getScreenWidth(paramContext), paramContext, paramFloat);
    AppMethodBeat.o(49560);
    return i;
  }
  
  public static int dP(Context paramContext)
  {
    AppMethodBeat.i(49555);
    if (paramContext == null)
    {
      AppMethodBeat.o(49555);
      return 0;
    }
    int i = (int)(a.ap(paramContext, 2131165763) * dT(paramContext));
    AppMethodBeat.o(49555);
    return i;
  }
  
  public static int dQ(Context paramContext)
  {
    AppMethodBeat.i(49556);
    int i = c(paramContext, b.getShowCountPerPage());
    AppMethodBeat.o(49556);
    return i;
  }
  
  public static int dR(Context paramContext)
  {
    AppMethodBeat.i(49561);
    if (lUj)
    {
      AppMethodBeat.o(49561);
      return 0;
    }
    int j = paramContext.getResources().getDimensionPixelOffset(2131165764);
    float f = dT(paramContext);
    int i = j;
    if (f != a.hF(paramContext))
    {
      i = j;
      if (f != a.hE(paramContext)) {
        if ((f != a.hG(paramContext)) && (f != a.hH(paramContext)) && (f != a.hI(paramContext))) {
          break label117;
        }
      }
    }
    label117:
    for (i = paramContext.getResources().getDimensionPixelOffset(2131165480);; i = paramContext.getResources().getDimensionPixelOffset(2131165516))
    {
      ad.d("MicroMsg.AppBrandDesktopSizeHelper", "alvinluo getLeftRightPadding: %d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(49561);
      return i;
    }
  }
  
  public static float dS(Context paramContext)
  {
    AppMethodBeat.i(49562);
    float f = a.ap(paramContext, 2131165760) * dT(paramContext);
    ad.d("MicroMsg.AppBrandDesktopSizeHelper", "alvinluo iconSize: %f", new Object[] { Float.valueOf(f) });
    AppMethodBeat.o(49562);
    return f;
  }
  
  public static float dT(Context paramContext)
  {
    AppMethodBeat.i(49563);
    float f2 = a.dT(paramContext);
    float f1;
    if ((f2 != a.hJ(paramContext)) && (f2 != a.hK(paramContext)))
    {
      f1 = f2;
      if (f2 != a.hL(paramContext)) {}
    }
    else
    {
      f1 = a.hI(paramContext);
    }
    AppMethodBeat.o(49563);
    return f1;
  }
  
  private static int getScreenWidth(Context paramContext)
  {
    AppMethodBeat.i(49558);
    try
    {
      if ((paramContext.getResources().getConfiguration().orientation == 2) && (ai.aF(paramContext)))
      {
        i = ai.cf(paramContext).x;
        AppMethodBeat.o(49558);
        return i;
      }
      int i = paramContext.getResources().getDisplayMetrics().widthPixels;
      AppMethodBeat.o(49558);
      return i;
    }
    catch (Exception paramContext)
    {
      ad.printErrStackTrace("MicroMsg.AppBrandDesktopSizeHelper", paramContext, "alvinluo getScreenWidth exception", new Object[0]);
      AppMethodBeat.o(49558);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.d
 * JD-Core Version:    0.7.0.1
 */