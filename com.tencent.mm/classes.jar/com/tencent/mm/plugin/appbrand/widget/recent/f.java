package com.tencent.mm.plugin.appbrand.widget.recent;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.appbrand.ba.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aw;

public final class f
{
  private static boolean uzR = false;
  
  public static int c(Context paramContext, float paramFloat)
  {
    AppMethodBeat.i(324044);
    if (paramContext == null)
    {
      AppMethodBeat.o(324044);
      return 0;
    }
    int m = getScreenWidth(paramContext);
    if (paramContext == null)
    {
      AppMethodBeat.o(324044);
      return 0;
    }
    int j;
    int i;
    if (paramContext == null)
    {
      j = 0;
      if (!d.cPg()) {
        break label152;
      }
      i = (int)((m - j * paramFloat) / Math.ceil(paramFloat));
    }
    for (;;)
    {
      int k = i;
      if (i < 0) {
        k = 0;
      }
      Log.d("MicroMsg.AppBrandRecentSizeHelper", "alvinluo itemWidth: %d, itemPadding: %d, viewWidth: %d, countPerPage: %f, leftRightPaddingZero: %b", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Float.valueOf(paramFloat), Boolean.valueOf(uzR) });
      AppMethodBeat.o(324044);
      return k;
      j = (int)(a.bs(paramContext, ba.d.app_brand_desktop_view_item_width) * getScaleSize(paramContext));
      break;
      label152:
      uzR = false;
      if (uzR)
      {
        i = 0;
        k = (m - i * 2 - (int)paramFloat * j) / (((int)paramFloat - 1) * 2);
        if (k > i)
        {
          i = (m - (int)paramFloat * j) / ((int)paramFloat * 2);
          uzR = true;
        }
      }
      else
      {
        k = paramContext.getResources().getDimensionPixelOffset(ba.d.app_brand_desktop_view_left_right_padding);
        float f = getScaleSize(paramContext);
        i = k;
        if (f != a.md(paramContext))
        {
          i = k;
          if (f != a.mc(paramContext)) {
            if ((f != a.me(paramContext)) && (f != a.mf(paramContext)) && (f != a.mg(paramContext))) {
              break label312;
            }
          }
        }
        label312:
        for (i = paramContext.getResources().getDimensionPixelOffset(ba.d.LargePadding);; i = paramContext.getResources().getDimensionPixelOffset(ba.d.NormalPadding))
        {
          Log.d("MicroMsg.AppBrandRecentSizeHelper", "alvinluo getLeftRightPadding: %d", new Object[] { Integer.valueOf(i) });
          break;
        }
      }
      uzR = false;
      i = k;
    }
  }
  
  public static float fu(Context paramContext)
  {
    AppMethodBeat.i(324048);
    float f = a.bs(paramContext, ba.d.app_brand_desktop_icon_size) * getScaleSize(paramContext);
    Log.d("MicroMsg.AppBrandRecentSizeHelper", "alvinluo iconSize: %f", new Object[] { Float.valueOf(f) });
    AppMethodBeat.o(324048);
    return f;
  }
  
  public static float fz(Context paramContext)
  {
    AppMethodBeat.i(324054);
    float f1 = a.bs(paramContext, ba.d.app_brand_desktop_icon_wrap_width);
    float f2 = getScaleSize(paramContext);
    AppMethodBeat.o(324054);
    return f1 * f2;
  }
  
  public static float getScaleSize(Context paramContext)
  {
    AppMethodBeat.i(324059);
    float f2 = a.getScaleSize(paramContext);
    float f1;
    if ((f2 != a.mh(paramContext)) && (f2 != a.mi(paramContext)))
    {
      f1 = f2;
      if (f2 != a.mj(paramContext)) {}
    }
    else
    {
      f1 = a.mg(paramContext);
    }
    AppMethodBeat.o(324059);
    return f1;
  }
  
  private static int getScreenWidth(Context paramContext)
  {
    AppMethodBeat.i(324033);
    try
    {
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
      if (paramContext.getResources().getConfiguration().orientation == 2)
      {
        if (aw.bx(paramContext))
        {
          i = aw.bf(paramContext).x;
          AppMethodBeat.o(324033);
          return i;
        }
        f1 = paramContext.getResources().getConfiguration().screenHeightDp;
        f2 = localDisplayMetrics.density;
        i = (int)(f1 * f2);
        AppMethodBeat.o(324033);
        return i;
      }
      float f1 = paramContext.getResources().getConfiguration().screenWidthDp;
      float f2 = localDisplayMetrics.density;
      int i = (int)(f1 * f2);
      AppMethodBeat.o(324033);
      return i;
    }
    catch (Exception paramContext)
    {
      Log.printErrStackTrace("MicroMsg.AppBrandRecentSizeHelper", paramContext, "alvinluo getScreenWidth exception", new Object[0]);
      AppMethodBeat.o(324033);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recent.f
 * JD-Core Version:    0.7.0.1
 */