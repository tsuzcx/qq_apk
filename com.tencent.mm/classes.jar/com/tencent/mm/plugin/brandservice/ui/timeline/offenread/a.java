package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

public final class a
{
  private static float naT = 4.5F;
  private static int naU = 4;
  
  private static int c(Context paramContext, float paramFloat)
  {
    AppMethodBeat.i(6130);
    if (paramContext == null)
    {
      AppMethodBeat.o(6130);
      return 0;
    }
    int k = eb(paramContext);
    int m = eu(paramContext);
    int j = (int)(2.0F * (m - k * paramFloat) / (Math.floor(paramFloat) * 2.0D + 1.0D));
    int i = j;
    if (j < 0) {
      i = 0;
    }
    ae.i("MicroMsg.BizTimeLineHotViewConfig", "alvinluo getItemPadding itemWidth: %d, itemPadding: %d, viewWidth: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(m) });
    AppMethodBeat.o(6130);
    return i;
  }
  
  public static int eb(Context paramContext)
  {
    AppMethodBeat.i(6127);
    if (paramContext == null)
    {
      AppMethodBeat.o(6127);
      return 0;
    }
    int i = (int)(com.tencent.mm.cb.a.ay(paramContext, 2131165907) * ef(paramContext));
    ae.d("MicroMsg.BizTimeLineHotViewConfig", "alvinluo itemWidth: %d", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(6127);
    return i;
  }
  
  public static int ec(Context paramContext)
  {
    AppMethodBeat.i(6128);
    int i = c(paramContext, naT);
    AppMethodBeat.o(6128);
    return i;
  }
  
  public static float ef(Context paramContext)
  {
    AppMethodBeat.i(6132);
    float f2 = com.tencent.mm.cb.a.ef(paramContext);
    float f1;
    if ((f2 != com.tencent.mm.cb.a.ii(paramContext)) && (f2 != com.tencent.mm.cb.a.ij(paramContext)))
    {
      f1 = f2;
      if (f2 != com.tencent.mm.cb.a.ik(paramContext)) {}
    }
    else
    {
      f1 = com.tencent.mm.cb.a.ih(paramContext);
    }
    AppMethodBeat.o(6132);
    return f1;
  }
  
  private static int eu(Context paramContext)
  {
    AppMethodBeat.i(6129);
    try
    {
      int i = paramContext.getResources().getDisplayMetrics().widthPixels;
      AppMethodBeat.o(6129);
      return i;
    }
    catch (Exception paramContext)
    {
      ae.printErrStackTrace("MicroMsg.BizTimeLineHotViewConfig", paramContext, "alvinluo getViewWidth exception", new Object[0]);
      AppMethodBeat.o(6129);
    }
    return 0;
  }
  
  public static int ev(Context paramContext)
  {
    AppMethodBeat.i(6131);
    int i = (int)(com.tencent.mm.cb.a.ay(paramContext, 2131165906) * ef(paramContext));
    AppMethodBeat.o(6131);
    return i;
  }
  
  public static int getCompletelyCountPerPage()
  {
    return naU;
  }
  
  public static float getShowCountPerPage()
  {
    return naT;
  }
  
  public static void init(Context paramContext)
  {
    AppMethodBeat.i(6126);
    if (c(paramContext, 4.5F) <= com.tencent.mm.cb.a.fromDPToPix(paramContext, 10))
    {
      naT = 3.5F;
      naU = 3;
      AppMethodBeat.o(6126);
      return;
    }
    naT = 4.5F;
    naU = 4;
    AppMethodBeat.o(6126);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.a
 * JD-Core Version:    0.7.0.1
 */