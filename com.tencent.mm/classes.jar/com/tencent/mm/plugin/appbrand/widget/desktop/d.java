package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.appbrand.y.e;
import com.tencent.mm.sdk.platformtools.y;

public final class d
{
  public static int c(Context paramContext, float paramFloat)
  {
    if (paramContext == null) {
      return 0;
    }
    int k = cG(paramContext);
    int m = cH(paramContext);
    int j = (int)((m - k * paramFloat) / Math.ceil(paramFloat));
    int i = j;
    if (j < 0) {
      i = 0;
    }
    y.i("MicroMsg.AppBrandDesktopSizeHelper", "alvinluo itemWidth: %d, itemPadding: %d, viewWidth: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(m) });
    return i;
  }
  
  public static int cG(Context paramContext)
  {
    if (paramContext == null) {
      return 0;
    }
    int i = (int)(a.ab(paramContext, y.e.app_brand_desktop_half_view_item_width) * cJ(paramContext));
    y.i("MicroMsg.AppBrandDesktopSizeHelper", "alvinluo itemWidth: %d", new Object[] { Integer.valueOf(i) });
    return i;
  }
  
  private static int cH(Context paramContext)
  {
    try
    {
      int i = paramContext.getResources().getDisplayMetrics().widthPixels;
      return i;
    }
    catch (Exception paramContext)
    {
      y.printErrStackTrace("MicroMsg.AppBrandDesktopSizeHelper", paramContext, "alvinluo getViewWidth exception", new Object[0]);
    }
    return 0;
  }
  
  public static int cI(Context paramContext)
  {
    int i = (int)(a.ab(paramContext, y.e.app_brand_desktop_icon_size) * cJ(paramContext));
    y.i("MicroMsg.AppBrandDesktopSizeHelper", "alvinluo iconSize: %d", new Object[] { Integer.valueOf(i) });
    return i;
  }
  
  public static float cJ(Context paramContext)
  {
    float f2 = a.cJ(paramContext);
    float f1;
    if ((f2 != 1.625F) && (f2 != 1.875F))
    {
      f1 = f2;
      if (f2 != 2.025F) {}
    }
    else
    {
      f1 = 1.375F;
    }
    return f1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.d
 * JD-Core Version:    0.7.0.1
 */