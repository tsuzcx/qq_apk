package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.aj;

public final class d
{
  private static boolean mwl = false;
  
  private static int a(int paramInt, Context paramContext, float paramFloat)
  {
    AppMethodBeat.i(49559);
    if (paramContext == null)
    {
      AppMethodBeat.o(49559);
      return 0;
    }
    int k = dX(paramContext);
    int i;
    if (b.byC()) {
      i = (int)((paramInt - k * paramFloat) / Math.ceil(paramFloat));
    }
    for (;;)
    {
      int j = i;
      if (i < 0) {
        j = 0;
      }
      ac.d("MicroMsg.AppBrandDesktopSizeHelper", "alvinluo itemWidth: %d, itemPadding: %d, viewWidth: %d, countPerPage: %f, leftRightPaddingZero: %b", new Object[] { Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(paramInt), Float.valueOf(paramFloat), Boolean.valueOf(mwl) });
      AppMethodBeat.o(49559);
      return j;
      mwl = false;
      j = dZ(paramContext);
      i = (paramInt - j * 2 - (int)paramFloat * k) / (((int)paramFloat - 1) * 2);
      if (i > j)
      {
        i = (paramInt - (int)paramFloat * k) / ((int)paramFloat * 2);
        mwl = true;
      }
      else
      {
        mwl = false;
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
  
  public static int dX(Context paramContext)
  {
    AppMethodBeat.i(49555);
    if (paramContext == null)
    {
      AppMethodBeat.o(49555);
      return 0;
    }
    int i = (int)(a.av(paramContext, 2131165763) * eb(paramContext));
    AppMethodBeat.o(49555);
    return i;
  }
  
  public static int dY(Context paramContext)
  {
    AppMethodBeat.i(49556);
    int i = c(paramContext, b.getShowCountPerPage());
    AppMethodBeat.o(49556);
    return i;
  }
  
  public static int dZ(Context paramContext)
  {
    AppMethodBeat.i(49561);
    if (mwl)
    {
      AppMethodBeat.o(49561);
      return 0;
    }
    int j = paramContext.getResources().getDimensionPixelOffset(2131165764);
    float f = eb(paramContext);
    int i = j;
    if (f != a.hQ(paramContext))
    {
      i = j;
      if (f != a.hP(paramContext)) {
        if ((f != a.hR(paramContext)) && (f != a.hS(paramContext)) && (f != a.hT(paramContext))) {
          break label117;
        }
      }
    }
    label117:
    for (i = paramContext.getResources().getDimensionPixelOffset(2131165480);; i = paramContext.getResources().getDimensionPixelOffset(2131165516))
    {
      ac.d("MicroMsg.AppBrandDesktopSizeHelper", "alvinluo getLeftRightPadding: %d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(49561);
      return i;
    }
  }
  
  public static float ea(Context paramContext)
  {
    AppMethodBeat.i(49562);
    float f = a.av(paramContext, 2131165760) * eb(paramContext);
    ac.d("MicroMsg.AppBrandDesktopSizeHelper", "alvinluo iconSize: %f", new Object[] { Float.valueOf(f) });
    AppMethodBeat.o(49562);
    return f;
  }
  
  public static float eb(Context paramContext)
  {
    AppMethodBeat.i(49563);
    float f2 = a.eb(paramContext);
    float f1;
    if ((f2 != a.hU(paramContext)) && (f2 != a.hV(paramContext)))
    {
      f1 = f2;
      if (f2 != a.hW(paramContext)) {}
    }
    else
    {
      f1 = a.hT(paramContext);
    }
    AppMethodBeat.o(49563);
    return f1;
  }
  
  private static int getScreenWidth(Context paramContext)
  {
    AppMethodBeat.i(49558);
    try
    {
      if ((paramContext.getResources().getConfiguration().orientation == 2) && (aj.aG(paramContext)))
      {
        i = aj.cl(paramContext).x;
        AppMethodBeat.o(49558);
        return i;
      }
      int i = paramContext.getResources().getDisplayMetrics().widthPixels;
      AppMethodBeat.o(49558);
      return i;
    }
    catch (Exception paramContext)
    {
      ac.printErrStackTrace("MicroMsg.AppBrandDesktopSizeHelper", paramContext, "alvinluo getScreenWidth exception", new Object[0]);
      AppMethodBeat.o(49558);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.d
 * JD-Core Version:    0.7.0.1
 */