package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.mm.plugin.brandservice.b.b;
import com.tencent.mm.sdk.platformtools.y;

public final class a
{
  private static float hpG = 4.5F;
  private static int hpH = 4;
  
  private static int c(Context paramContext, float paramFloat)
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
    y.d("MicroMsg.BizTimeLineHotViewConfig", "alvinluo itemWidth: %d, itemPadding: %d, viewWidth: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(m) });
    return i;
  }
  
  public static int cG(Context paramContext)
  {
    if (paramContext == null) {
      return 0;
    }
    int i = (int)(com.tencent.mm.cb.a.ab(paramContext, b.b.biz_time_line_title_hot_view_item_width) * cJ(paramContext));
    y.d("MicroMsg.BizTimeLineHotViewConfig", "alvinluo itemWidth: %d", new Object[] { Integer.valueOf(i) });
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
      y.printErrStackTrace("MicroMsg.BizTimeLineHotViewConfig", paramContext, "alvinluo getViewWidth exception", new Object[0]);
    }
    return 0;
  }
  
  public static int cI(Context paramContext)
  {
    return (int)(com.tencent.mm.cb.a.ab(paramContext, b.b.biz_time_line_title_hot_view_icon_size) * cJ(paramContext));
  }
  
  private static float cJ(Context paramContext)
  {
    float f2 = com.tencent.mm.cb.a.cJ(paramContext);
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
  
  public static int cQ(Context paramContext)
  {
    return c(paramContext, hpG);
  }
  
  public static int getCompletelyCountPerPage()
  {
    return hpH;
  }
  
  public static float getShowCountPerPage()
  {
    return hpG;
  }
  
  public static void init(Context paramContext)
  {
    if (c(paramContext, 4.5F) <= com.tencent.mm.cb.a.fromDPToPix(paramContext, 10))
    {
      hpG = 3.5F;
      hpH = 3;
      return;
    }
    hpG = 4.5F;
    hpH = 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.a
 * JD-Core Version:    0.7.0.1
 */