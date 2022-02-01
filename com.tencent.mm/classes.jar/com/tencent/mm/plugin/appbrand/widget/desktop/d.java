package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.al;

public final class d
{
  private static boolean nbW = false;
  
  private static int a(int paramInt, Context paramContext, float paramFloat)
  {
    AppMethodBeat.i(49559);
    if (paramContext == null)
    {
      AppMethodBeat.o(49559);
      return 0;
    }
    int k = eb(paramContext);
    int i;
    if (b.bDz()) {
      i = (int)((paramInt - k * paramFloat) / Math.ceil(paramFloat));
    }
    for (;;)
    {
      int j = i;
      if (i < 0) {
        j = 0;
      }
      ae.d("MicroMsg.AppBrandDesktopSizeHelper", "alvinluo itemWidth: %d, itemPadding: %d, viewWidth: %d, countPerPage: %f, leftRightPaddingZero: %b", new Object[] { Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(paramInt), Float.valueOf(paramFloat), Boolean.valueOf(nbW) });
      AppMethodBeat.o(49559);
      return j;
      nbW = false;
      j = ed(paramContext);
      i = (paramInt - j * 2 - (int)paramFloat * k) / (((int)paramFloat - 1) * 2);
      if (i > j)
      {
        i = (paramInt - (int)paramFloat * k) / ((int)paramFloat * 2);
        nbW = true;
      }
      else
      {
        nbW = false;
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
  
  public static int eb(Context paramContext)
  {
    AppMethodBeat.i(49555);
    if (paramContext == null)
    {
      AppMethodBeat.o(49555);
      return 0;
    }
    int i = (int)(a.ay(paramContext, 2131165763) * ef(paramContext));
    AppMethodBeat.o(49555);
    return i;
  }
  
  public static int ec(Context paramContext)
  {
    AppMethodBeat.i(49556);
    int i = c(paramContext, b.getShowCountPerPage());
    AppMethodBeat.o(49556);
    return i;
  }
  
  public static int ed(Context paramContext)
  {
    AppMethodBeat.i(49561);
    if (nbW)
    {
      AppMethodBeat.o(49561);
      return 0;
    }
    int j = paramContext.getResources().getDimensionPixelOffset(2131165764);
    float f = ef(paramContext);
    int i = j;
    if (f != a.ie(paramContext))
    {
      i = j;
      if (f != a.id(paramContext)) {
        if ((f != a.jdMethod_if(paramContext)) && (f != a.ig(paramContext)) && (f != a.ih(paramContext))) {
          break label117;
        }
      }
    }
    label117:
    for (i = paramContext.getResources().getDimensionPixelOffset(2131165480);; i = paramContext.getResources().getDimensionPixelOffset(2131165516))
    {
      ae.d("MicroMsg.AppBrandDesktopSizeHelper", "alvinluo getLeftRightPadding: %d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(49561);
      return i;
    }
  }
  
  public static float ee(Context paramContext)
  {
    AppMethodBeat.i(49562);
    float f = a.ay(paramContext, 2131165760) * ef(paramContext);
    ae.d("MicroMsg.AppBrandDesktopSizeHelper", "alvinluo iconSize: %f", new Object[] { Float.valueOf(f) });
    AppMethodBeat.o(49562);
    return f;
  }
  
  public static float ef(Context paramContext)
  {
    AppMethodBeat.i(49563);
    float f2 = a.ef(paramContext);
    float f1;
    if ((f2 != a.ii(paramContext)) && (f2 != a.ij(paramContext)))
    {
      f1 = f2;
      if (f2 != a.ik(paramContext)) {}
    }
    else
    {
      f1 = a.ih(paramContext);
    }
    AppMethodBeat.o(49563);
    return f1;
  }
  
  private static int getScreenWidth(Context paramContext)
  {
    AppMethodBeat.i(49558);
    try
    {
      if ((paramContext.getResources().getConfiguration().orientation == 2) && (al.aH(paramContext)))
      {
        i = al.ck(paramContext).x;
        AppMethodBeat.o(49558);
        return i;
      }
      int i = paramContext.getResources().getDisplayMetrics().widthPixels;
      AppMethodBeat.o(49558);
      return i;
    }
    catch (Exception paramContext)
    {
      ae.printErrStackTrace("MicroMsg.AppBrandDesktopSizeHelper", paramContext, "alvinluo getScreenWidth exception", new Object[0]);
      AppMethodBeat.o(49558);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.d
 * JD-Core Version:    0.7.0.1
 */