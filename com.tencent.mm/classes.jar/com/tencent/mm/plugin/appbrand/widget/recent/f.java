package com.tencent.mm.plugin.appbrand.widget.recent;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.plugin.appbrand.au.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ar;

public final class f
{
  private static boolean rpF = false;
  
  public static int c(Context paramContext, float paramFloat)
  {
    AppMethodBeat.i(277188);
    if (paramContext == null)
    {
      AppMethodBeat.o(277188);
      return 0;
    }
    int m = getScreenWidth(paramContext);
    if (paramContext == null)
    {
      AppMethodBeat.o(277188);
      return 0;
    }
    int j;
    int i;
    if (paramContext == null)
    {
      j = 0;
      if (!d.cnk()) {
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
      Log.d("MicroMsg.AppBrandRecentSizeHelper", "alvinluo itemWidth: %d, itemPadding: %d, viewWidth: %d, countPerPage: %f, leftRightPaddingZero: %b", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Float.valueOf(paramFloat), Boolean.valueOf(rpF) });
      AppMethodBeat.o(277188);
      return k;
      j = (int)(a.aZ(paramContext, au.d.app_brand_desktop_view_item_width) * ez(paramContext));
      break;
      label152:
      rpF = false;
      if (rpF)
      {
        i = 0;
        k = (m - i * 2 - (int)paramFloat * j) / (((int)paramFloat - 1) * 2);
        if (k > i)
        {
          i = (m - (int)paramFloat * j) / ((int)paramFloat * 2);
          rpF = true;
        }
      }
      else
      {
        k = paramContext.getResources().getDimensionPixelOffset(au.d.app_brand_desktop_view_left_right_padding);
        float f = ez(paramContext);
        i = k;
        if (f != a.kb(paramContext))
        {
          i = k;
          if (f != a.ka(paramContext)) {
            if ((f != a.kc(paramContext)) && (f != a.kd(paramContext)) && (f != a.ke(paramContext))) {
              break label312;
            }
          }
        }
        label312:
        for (i = paramContext.getResources().getDimensionPixelOffset(au.d.LargePadding);; i = paramContext.getResources().getDimensionPixelOffset(au.d.NormalPadding))
        {
          Log.d("MicroMsg.AppBrandRecentSizeHelper", "alvinluo getLeftRightPadding: %d", new Object[] { Integer.valueOf(i) });
          break;
        }
      }
      rpF = false;
      i = k;
    }
  }
  
  public static float eE(Context paramContext)
  {
    AppMethodBeat.i(277191);
    float f1 = a.aZ(paramContext, au.d.app_brand_desktop_icon_wrap_width);
    float f2 = ez(paramContext);
    AppMethodBeat.o(277191);
    return f1 * f2;
  }
  
  public static float ey(Context paramContext)
  {
    AppMethodBeat.i(277189);
    float f = a.aZ(paramContext, au.d.app_brand_desktop_icon_size) * ez(paramContext);
    Log.d("MicroMsg.AppBrandRecentSizeHelper", "alvinluo iconSize: %f", new Object[] { Float.valueOf(f) });
    AppMethodBeat.o(277189);
    return f;
  }
  
  public static float ez(Context paramContext)
  {
    AppMethodBeat.i(277192);
    float f2 = a.ez(paramContext);
    float f1;
    if ((f2 != a.kf(paramContext)) && (f2 != a.kg(paramContext)))
    {
      f1 = f2;
      if (f2 != a.kh(paramContext)) {}
    }
    else
    {
      f1 = a.ke(paramContext);
    }
    AppMethodBeat.o(277192);
    return f1;
  }
  
  private static int getScreenWidth(Context paramContext)
  {
    AppMethodBeat.i(277187);
    try
    {
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
      if (paramContext.getResources().getConfiguration().orientation == 2)
      {
        if (ar.aN(paramContext))
        {
          i = ar.au(paramContext).x;
          AppMethodBeat.o(277187);
          return i;
        }
        f1 = paramContext.getResources().getConfiguration().screenHeightDp;
        f2 = localDisplayMetrics.density;
        i = (int)(f1 * f2);
        AppMethodBeat.o(277187);
        return i;
      }
      float f1 = paramContext.getResources().getConfiguration().screenWidthDp;
      float f2 = localDisplayMetrics.density;
      int i = (int)(f1 * f2);
      AppMethodBeat.o(277187);
      return i;
    }
    catch (Exception paramContext)
    {
      Log.printErrStackTrace("MicroMsg.AppBrandRecentSizeHelper", paramContext, "alvinluo getScreenWidth exception", new Object[0]);
      AppMethodBeat.o(277187);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recent.f
 * JD-Core Version:    0.7.0.1
 */