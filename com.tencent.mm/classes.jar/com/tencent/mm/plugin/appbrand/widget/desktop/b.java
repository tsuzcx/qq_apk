package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ao;

public final class b
{
  private static boolean onb = false;
  
  private static int a(int paramInt, Context paramContext, float paramFloat)
  {
    AppMethodBeat.i(49559);
    if (paramContext == null)
    {
      AppMethodBeat.o(49559);
      return 0;
    }
    int k = ev(paramContext);
    int i;
    if (a.cak()) {
      i = (int)((paramInt - k * paramFloat) / Math.ceil(paramFloat));
    }
    for (;;)
    {
      int j = i;
      if (i < 0) {
        j = 0;
      }
      Log.d("MicroMsg.AppBrandDesktopSizeHelper", "alvinluo itemWidth: %d, itemPadding: %d, viewWidth: %d, countPerPage: %f, leftRightPaddingZero: %b", new Object[] { Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(paramInt), Float.valueOf(paramFloat), Boolean.valueOf(onb) });
      AppMethodBeat.o(49559);
      return j;
      onb = false;
      j = ex(paramContext);
      i = (paramInt - j * 2 - (int)paramFloat * k) / (((int)paramFloat - 1) * 2);
      if (i > j)
      {
        i = (paramInt - (int)paramFloat * k) / ((int)paramFloat * 2);
        onb = true;
      }
      else
      {
        onb = false;
      }
    }
  }
  
  public static int b(int paramInt, Context paramContext)
  {
    AppMethodBeat.i(49557);
    paramInt = a(paramInt, paramContext, a.getShowCountPerPage());
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
  
  public static int ev(Context paramContext)
  {
    AppMethodBeat.i(49555);
    if (paramContext == null)
    {
      AppMethodBeat.o(49555);
      return 0;
    }
    int i = (int)(com.tencent.mm.cb.a.aH(paramContext, 2131165786) * ez(paramContext));
    AppMethodBeat.o(49555);
    return i;
  }
  
  public static int ew(Context paramContext)
  {
    AppMethodBeat.i(49556);
    int i = c(paramContext, a.getShowCountPerPage());
    AppMethodBeat.o(49556);
    return i;
  }
  
  public static int ex(Context paramContext)
  {
    AppMethodBeat.i(49561);
    if (onb)
    {
      AppMethodBeat.o(49561);
      return 0;
    }
    int j = paramContext.getResources().getDimensionPixelOffset(2131165787);
    float f = ez(paramContext);
    int i = j;
    if (f != com.tencent.mm.cb.a.iX(paramContext))
    {
      i = j;
      if (f != com.tencent.mm.cb.a.iW(paramContext)) {
        if ((f != com.tencent.mm.cb.a.iY(paramContext)) && (f != com.tencent.mm.cb.a.iZ(paramContext)) && (f != com.tencent.mm.cb.a.ja(paramContext))) {
          break label117;
        }
      }
    }
    label117:
    for (i = paramContext.getResources().getDimensionPixelOffset(2131165498);; i = paramContext.getResources().getDimensionPixelOffset(2131165534))
    {
      Log.d("MicroMsg.AppBrandDesktopSizeHelper", "alvinluo getLeftRightPadding: %d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(49561);
      return i;
    }
  }
  
  public static float ey(Context paramContext)
  {
    AppMethodBeat.i(49562);
    float f = com.tencent.mm.cb.a.aH(paramContext, 2131165782) * ez(paramContext);
    Log.d("MicroMsg.AppBrandDesktopSizeHelper", "alvinluo iconSize: %f", new Object[] { Float.valueOf(f) });
    AppMethodBeat.o(49562);
    return f;
  }
  
  public static float ez(Context paramContext)
  {
    AppMethodBeat.i(49563);
    float f2 = com.tencent.mm.cb.a.ez(paramContext);
    float f1;
    if ((f2 != com.tencent.mm.cb.a.jb(paramContext)) && (f2 != com.tencent.mm.cb.a.jc(paramContext)))
    {
      f1 = f2;
      if (f2 != com.tencent.mm.cb.a.jd(paramContext)) {}
    }
    else
    {
      f1 = com.tencent.mm.cb.a.ja(paramContext);
    }
    AppMethodBeat.o(49563);
    return f1;
  }
  
  private static int getScreenWidth(Context paramContext)
  {
    AppMethodBeat.i(49558);
    try
    {
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
      if (paramContext.getResources().getConfiguration().orientation == 2)
      {
        if (ao.aQ(paramContext))
        {
          i = ao.az(paramContext).x;
          AppMethodBeat.o(49558);
          return i;
        }
        f1 = paramContext.getResources().getConfiguration().screenHeightDp;
        f2 = localDisplayMetrics.density;
        i = (int)(f1 * f2);
        AppMethodBeat.o(49558);
        return i;
      }
      float f1 = paramContext.getResources().getConfiguration().screenWidthDp;
      float f2 = localDisplayMetrics.density;
      int i = (int)(f1 * f2);
      AppMethodBeat.o(49558);
      return i;
    }
    catch (Exception paramContext)
    {
      Log.printErrStackTrace("MicroMsg.AppBrandDesktopSizeHelper", paramContext, "alvinluo getScreenWidth exception", new Object[0]);
      AppMethodBeat.o(49558);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.b
 * JD-Core Version:    0.7.0.1
 */