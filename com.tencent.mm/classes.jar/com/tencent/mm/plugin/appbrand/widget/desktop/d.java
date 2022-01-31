package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.af;

public final class d
{
  private static boolean jej = false;
  
  private static int a(int paramInt, Context paramContext, float paramFloat)
  {
    AppMethodBeat.i(133816);
    if (paramContext == null)
    {
      AppMethodBeat.o(133816);
      return 0;
    }
    int k = dn(paramContext);
    int i;
    if (b.aPf()) {
      i = (int)((paramInt - k * paramFloat) / Math.ceil(paramFloat));
    }
    for (;;)
    {
      int j = i;
      if (i < 0) {
        j = 0;
      }
      ab.i("MicroMsg.AppBrandDesktopSizeHelper", "alvinluo itemWidth: %d, itemPadding: %d, viewWidth: %d, countPerPage: %f, leftRightPaddingZero: %b", new Object[] { Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(paramInt), Float.valueOf(paramFloat), Boolean.valueOf(jej) });
      AppMethodBeat.o(133816);
      return j;
      jej = false;
      j = dp(paramContext);
      i = (paramInt - j * 2 - (int)paramFloat * k) / (((int)paramFloat - 1) * 2);
      if (i > j)
      {
        i = (paramInt - (int)paramFloat * k) / ((int)paramFloat * 2);
        jej = true;
      }
      else
      {
        jej = false;
      }
    }
  }
  
  public static int c(int paramInt, Context paramContext)
  {
    AppMethodBeat.i(133814);
    paramInt = a(paramInt, paramContext, b.getShowCountPerPage());
    AppMethodBeat.o(133814);
    return paramInt;
  }
  
  public static int d(Context paramContext, float paramFloat)
  {
    AppMethodBeat.i(133817);
    if (paramContext == null)
    {
      AppMethodBeat.o(133817);
      return 0;
    }
    int i = a(getScreenWidth(paramContext), paramContext, paramFloat);
    AppMethodBeat.o(133817);
    return i;
  }
  
  public static int dn(Context paramContext)
  {
    AppMethodBeat.i(133812);
    if (paramContext == null)
    {
      AppMethodBeat.o(133812);
      return 0;
    }
    int i = (int)(a.ap(paramContext, 2131427992) * dr(paramContext));
    ab.i("MicroMsg.AppBrandDesktopSizeHelper", "alvinluo itemWidth: %d", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(133812);
    return i;
  }
  
  public static int jdMethod_do(Context paramContext)
  {
    AppMethodBeat.i(133813);
    int i = d(paramContext, b.getShowCountPerPage());
    AppMethodBeat.o(133813);
    return i;
  }
  
  public static int dp(Context paramContext)
  {
    AppMethodBeat.i(133818);
    if (jej)
    {
      AppMethodBeat.o(133818);
      return 0;
    }
    int j = paramContext.getResources().getDimensionPixelOffset(2131427993);
    float f = dr(paramContext);
    int i = j;
    if (f != a.gg(paramContext))
    {
      i = j;
      if (f != a.gf(paramContext)) {
        if ((f != a.gh(paramContext)) && (f != a.gi(paramContext)) && (f != a.gj(paramContext))) {
          break label117;
        }
      }
    }
    label117:
    for (i = paramContext.getResources().getDimensionPixelOffset(2131427772);; i = paramContext.getResources().getDimensionPixelOffset(2131427808))
    {
      ab.d("MicroMsg.AppBrandDesktopSizeHelper", "alvinluo getLeftRightPadding: %d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(133818);
      return i;
    }
  }
  
  public static float dq(Context paramContext)
  {
    AppMethodBeat.i(133819);
    float f = a.ap(paramContext, 2131427989) * dr(paramContext);
    ab.i("MicroMsg.AppBrandDesktopSizeHelper", "alvinluo iconSize: %f", new Object[] { Float.valueOf(f) });
    AppMethodBeat.o(133819);
    return f;
  }
  
  public static float dr(Context paramContext)
  {
    AppMethodBeat.i(133820);
    float f2 = a.dr(paramContext);
    float f1;
    if ((f2 != a.gk(paramContext)) && (f2 != a.gl(paramContext)))
    {
      f1 = f2;
      if (f2 != a.gm(paramContext)) {}
    }
    else
    {
      f1 = a.gj(paramContext);
    }
    AppMethodBeat.o(133820);
    return f1;
  }
  
  private static int getScreenWidth(Context paramContext)
  {
    AppMethodBeat.i(133815);
    try
    {
      if ((paramContext.getResources().getConfiguration().orientation == 2) && (af.hW(paramContext)))
      {
        i = af.hQ(paramContext).x;
        AppMethodBeat.o(133815);
        return i;
      }
      int i = paramContext.getResources().getDisplayMetrics().widthPixels;
      AppMethodBeat.o(133815);
      return i;
    }
    catch (Exception paramContext)
    {
      ab.printErrStackTrace("MicroMsg.AppBrandDesktopSizeHelper", paramContext, "alvinluo getScreenWidth exception", new Object[0]);
      AppMethodBeat.o(133815);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.d
 * JD-Core Version:    0.7.0.1
 */