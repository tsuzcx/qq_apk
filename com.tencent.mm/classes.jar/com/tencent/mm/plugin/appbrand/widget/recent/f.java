package com.tencent.mm.plugin.appbrand.widget.recent;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ao;

public final class f
{
  private static boolean onb = false;
  
  private static int a(int paramInt, Context paramContext, float paramFloat)
  {
    AppMethodBeat.i(227788);
    if (paramContext == null)
    {
      AppMethodBeat.o(227788);
      return 0;
    }
    int k = ev(paramContext);
    int i;
    if (d.cak()) {
      i = (int)((paramInt - k * paramFloat) / Math.ceil(paramFloat));
    }
    for (;;)
    {
      int j = i;
      if (i < 0) {
        j = 0;
      }
      Log.d("MicroMsg.AppBrandRecentSizeHelper", "alvinluo itemWidth: %d, itemPadding: %d, viewWidth: %d, countPerPage: %f, leftRightPaddingZero: %b", new Object[] { Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(paramInt), Float.valueOf(paramFloat), Boolean.valueOf(onb) });
      AppMethodBeat.o(227788);
      return j;
      onb = false;
      j = paramContext.getResources().getDimensionPixelOffset(2131165787);
      float f = ez(paramContext);
      i = j;
      if (f != a.iX(paramContext))
      {
        i = j;
        if (f != a.iW(paramContext)) {
          if ((f != a.iY(paramContext)) && (f != a.iZ(paramContext)) && (f != a.ja(paramContext))) {
            break label268;
          }
        }
      }
      label268:
      for (i = paramContext.getResources().getDimensionPixelOffset(2131165498);; i = paramContext.getResources().getDimensionPixelOffset(2131165534))
      {
        Log.d("MicroMsg.AppBrandRecentSizeHelper", "alvinluo getLeftRightPadding: %d", new Object[] { Integer.valueOf(i) });
        j = (paramInt - i * 2 - (int)paramFloat * k) / (((int)paramFloat - 1) * 2);
        if (j <= i) {
          break label282;
        }
        i = (paramInt - (int)paramFloat * k) / ((int)paramFloat * 2);
        onb = true;
        break;
      }
      label282:
      onb = false;
      i = j;
    }
  }
  
  public static int c(Context paramContext, float paramFloat)
  {
    AppMethodBeat.i(227789);
    if (paramContext == null)
    {
      AppMethodBeat.o(227789);
      return 0;
    }
    int i = a(getScreenWidth(paramContext), paramContext, paramFloat);
    AppMethodBeat.o(227789);
    return i;
  }
  
  public static int ev(Context paramContext)
  {
    AppMethodBeat.i(227785);
    if (paramContext == null)
    {
      AppMethodBeat.o(227785);
      return 0;
    }
    int i = (int)(a.aH(paramContext, 2131165786) * ez(paramContext));
    AppMethodBeat.o(227785);
    return i;
  }
  
  public static int ew(Context paramContext)
  {
    AppMethodBeat.i(227786);
    int i = c(paramContext, d.getShowCountPerPage());
    AppMethodBeat.o(227786);
    return i;
  }
  
  public static float ey(Context paramContext)
  {
    AppMethodBeat.i(227790);
    float f = a.aH(paramContext, 2131165782) * ez(paramContext);
    Log.d("MicroMsg.AppBrandRecentSizeHelper", "alvinluo iconSize: %f", new Object[] { Float.valueOf(f) });
    AppMethodBeat.o(227790);
    return f;
  }
  
  public static float ez(Context paramContext)
  {
    AppMethodBeat.i(227791);
    float f2 = a.ez(paramContext);
    float f1;
    if ((f2 != a.jb(paramContext)) && (f2 != a.jc(paramContext)))
    {
      f1 = f2;
      if (f2 != a.jd(paramContext)) {}
    }
    else
    {
      f1 = a.ja(paramContext);
    }
    AppMethodBeat.o(227791);
    return f1;
  }
  
  private static int getScreenWidth(Context paramContext)
  {
    AppMethodBeat.i(227787);
    try
    {
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
      if (paramContext.getResources().getConfiguration().orientation == 2)
      {
        if (ao.aQ(paramContext))
        {
          i = ao.az(paramContext).x;
          AppMethodBeat.o(227787);
          return i;
        }
        f1 = paramContext.getResources().getConfiguration().screenHeightDp;
        f2 = localDisplayMetrics.density;
        i = (int)(f1 * f2);
        AppMethodBeat.o(227787);
        return i;
      }
      float f1 = paramContext.getResources().getConfiguration().screenWidthDp;
      float f2 = localDisplayMetrics.density;
      int i = (int)(f1 * f2);
      AppMethodBeat.o(227787);
      return i;
    }
    catch (Exception paramContext)
    {
      Log.printErrStackTrace("MicroMsg.AppBrandRecentSizeHelper", paramContext, "alvinluo getScreenWidth exception", new Object[0]);
      AppMethodBeat.o(227787);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recent.f
 * JD-Core Version:    0.7.0.1
 */