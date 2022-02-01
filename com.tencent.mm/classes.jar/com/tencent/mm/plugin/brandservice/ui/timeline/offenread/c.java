package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.d.c;
import com.tencent.mm.plugin.webview.core.i;
import com.tencent.mm.plugin.webview.core.i.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ao.a;

public final class c
{
  private static float uzw;
  private static int uzx;
  public static final int vPL;
  
  static
  {
    AppMethodBeat.i(302271);
    i.a locala = i.Wya;
    if (i.a.anH()) {}
    for (int i = 20;; i = 12)
    {
      vPL = i;
      uzw = 4.5F;
      uzx = 4;
      AppMethodBeat.o(302271);
      return;
    }
  }
  
  private static int c(Context paramContext, float paramFloat)
  {
    AppMethodBeat.i(6130);
    if (paramContext == null)
    {
      AppMethodBeat.o(6130);
      return 0;
    }
    int k = ft(paramContext);
    int m = fO(paramContext);
    int j = (int)(2.0F * (m - k * paramFloat) / (Math.floor(paramFloat) * 2.0D + 1.0D));
    int i = j;
    if (j < 0) {
      i = 0;
    }
    Log.i("MicroMsg.BizTimeLineHotViewConfig", "alvinluo getItemPadding itemWidth: %d, itemPadding: %d, viewWidth: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(m) });
    AppMethodBeat.o(6130);
    return i;
  }
  
  public static int fN(Context paramContext)
  {
    AppMethodBeat.i(6128);
    int i = c(paramContext, uzw);
    AppMethodBeat.o(6128);
    return i;
  }
  
  private static int fO(Context paramContext)
  {
    AppMethodBeat.i(6129);
    com.tencent.mm.plugin.bizui.a.a locala = com.tencent.mm.plugin.bizui.a.a.vtB;
    int i = com.tencent.mm.plugin.bizui.a.a.fK(paramContext);
    AppMethodBeat.o(6129);
    return i;
  }
  
  public static int fP(Context paramContext)
  {
    AppMethodBeat.i(302262);
    if (paramContext == null)
    {
      AppMethodBeat.o(302262);
      return 0;
    }
    int i = (int)((fO(paramContext) - com.tencent.mm.cd.a.fromDPToPix(paramContext, 12)) * 2 / (Math.floor(uzw) * 2.0D + 1.0D));
    AppMethodBeat.o(302262);
    return i;
  }
  
  public static int fQ(Context paramContext)
  {
    AppMethodBeat.i(6131);
    int i = (int)(com.tencent.mm.cd.a.bs(paramContext, d.c.biz_time_line_title_hot_view_icon_size) * getScaleSize(paramContext));
    AppMethodBeat.o(6131);
    return i;
  }
  
  public static int ft(Context paramContext)
  {
    AppMethodBeat.i(6127);
    if (paramContext == null)
    {
      AppMethodBeat.o(6127);
      return 0;
    }
    int i = (int)(com.tencent.mm.cd.a.bs(paramContext, d.c.biz_time_line_title_hot_view_item_width) * getScaleSize(paramContext));
    Log.d("MicroMsg.BizTimeLineHotViewConfig", "alvinluo itemWidth: %d", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(6127);
    return i;
  }
  
  public static int getCompletelyCountPerPage()
  {
    return uzx;
  }
  
  private static float getScaleSize(Context paramContext)
  {
    AppMethodBeat.i(6132);
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
    AppMethodBeat.o(6132);
    return f1;
  }
  
  public static float getShowCountPerPage()
  {
    return uzw;
  }
  
  public static void init(Context paramContext)
  {
    AppMethodBeat.i(6126);
    int i = fO(paramContext);
    int j = ao.mX(paramContext).height;
    if (i > j)
    {
      i = (int)((i - j) * 4.5F / j);
      Log.i("MicroMsg.BizTimeLineHotViewConfig", "init extraCount= %d", new Object[] { Integer.valueOf(i) });
    }
    for (;;)
    {
      if (c(paramContext, i + 4.5F) <= com.tencent.mm.cd.a.fromDPToPix(paramContext, 8))
      {
        uzw = 3.5F + i;
        uzx = i + 3;
        AppMethodBeat.o(6126);
        return;
      }
      uzw = i + 4.5F;
      uzx = i + 4;
      AppMethodBeat.o(6126);
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.c
 * JD-Core Version:    0.7.0.1
 */