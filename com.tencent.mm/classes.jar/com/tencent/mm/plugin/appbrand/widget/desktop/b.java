package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ba.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aw;

public final class b
{
  private static boolean uzR = false;
  
  public static int c(Context paramContext, float paramFloat)
  {
    AppMethodBeat.i(49560);
    if (paramContext == null)
    {
      AppMethodBeat.o(49560);
      return 0;
    }
    int k = getScreenWidth(paramContext);
    if (paramContext == null)
    {
      AppMethodBeat.o(49560);
      return 0;
    }
    int m = ft(paramContext);
    int i;
    if (a.cPg()) {
      i = (int)((k - m * paramFloat) / Math.ceil(paramFloat));
    }
    for (;;)
    {
      int j = i;
      if (i < 0) {
        j = 0;
      }
      Log.d("MicroMsg.AppBrandDesktopSizeHelper", "alvinluo itemWidth: %d, itemPadding: %d, viewWidth: %d, countPerPage: %f, leftRightPaddingZero: %b", new Object[] { Integer.valueOf(m), Integer.valueOf(j), Integer.valueOf(k), Float.valueOf(paramFloat), Boolean.valueOf(uzR) });
      AppMethodBeat.o(49560);
      return j;
      uzR = false;
      j = paramContext.getResources().getDimensionPixelOffset(ba.d.app_brand_desktop_view_left_right_padding);
      float f = getScaleSize(paramContext);
      i = j;
      if (f != com.tencent.mm.cd.a.md(paramContext))
      {
        i = j;
        if (f != com.tencent.mm.cd.a.mc(paramContext)) {
          if ((f != com.tencent.mm.cd.a.me(paramContext)) && (f != com.tencent.mm.cd.a.mf(paramContext)) && (f != com.tencent.mm.cd.a.mg(paramContext))) {
            break label281;
          }
        }
      }
      label281:
      for (i = paramContext.getResources().getDimensionPixelOffset(ba.d.LargePadding);; i = paramContext.getResources().getDimensionPixelOffset(ba.d.NormalPadding))
      {
        Log.d("MicroMsg.AppBrandDesktopSizeHelper", "alvinluo getLeftRightPadding: %d", new Object[] { Integer.valueOf(i) });
        j = (k - i * 2 - (int)paramFloat * m) / (((int)paramFloat - 1) * 2);
        if (j <= i) {
          break label295;
        }
        i = (k - (int)paramFloat * m) / ((int)paramFloat * 2);
        uzR = true;
        break;
      }
      label295:
      uzR = false;
      i = j;
    }
  }
  
  public static int ft(Context paramContext)
  {
    AppMethodBeat.i(49555);
    if (paramContext == null)
    {
      AppMethodBeat.o(49555);
      return 0;
    }
    int i = (int)(com.tencent.mm.cd.a.bs(paramContext, ba.d.app_brand_desktop_view_item_width) * getScaleSize(paramContext));
    AppMethodBeat.o(49555);
    return i;
  }
  
  public static float fu(Context paramContext)
  {
    AppMethodBeat.i(49562);
    float f = com.tencent.mm.cd.a.bs(paramContext, ba.d.app_brand_desktop_icon_size) * getScaleSize(paramContext);
    Log.d("MicroMsg.AppBrandDesktopSizeHelper", "alvinluo iconSize: %f", new Object[] { Float.valueOf(f) });
    AppMethodBeat.o(49562);
    return f;
  }
  
  public static float getScaleSize(Context paramContext)
  {
    AppMethodBeat.i(49563);
    float f2 = com.tencent.mm.cd.a.getScaleSize(paramContext);
    float f1;
    if ((f2 != com.tencent.mm.cd.a.mh(paramContext)) && (f2 != com.tencent.mm.cd.a.mi(paramContext)))
    {
      f1 = f2;
      if (f2 != com.tencent.mm.cd.a.mj(paramContext)) {}
    }
    else
    {
      f1 = com.tencent.mm.cd.a.mg(paramContext);
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
        if (aw.bx(paramContext))
        {
          i = aw.bf(paramContext).x;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.b
 * JD-Core Version:    0.7.0.1
 */