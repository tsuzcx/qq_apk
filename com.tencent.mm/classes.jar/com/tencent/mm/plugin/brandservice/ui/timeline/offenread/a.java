package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public final class a
{
  private static float mVN = 4.5F;
  private static int mVO = 4;
  
  private static int c(Context paramContext, float paramFloat)
  {
    AppMethodBeat.i(6130);
    if (paramContext == null)
    {
      AppMethodBeat.o(6130);
      return 0;
    }
    int k = dX(paramContext);
    int m = eq(paramContext);
    int j = (int)(2.0F * (m - k * paramFloat) / (Math.floor(paramFloat) * 2.0D + 1.0D));
    int i = j;
    if (j < 0) {
      i = 0;
    }
    ad.i("MicroMsg.BizTimeLineHotViewConfig", "alvinluo getItemPadding itemWidth: %d, itemPadding: %d, viewWidth: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(m) });
    AppMethodBeat.o(6130);
    return i;
  }
  
  public static int dX(Context paramContext)
  {
    AppMethodBeat.i(6127);
    if (paramContext == null)
    {
      AppMethodBeat.o(6127);
      return 0;
    }
    int i = (int)(com.tencent.mm.cc.a.ay(paramContext, 2131165907) * eb(paramContext));
    ad.d("MicroMsg.BizTimeLineHotViewConfig", "alvinluo itemWidth: %d", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(6127);
    return i;
  }
  
  public static int dY(Context paramContext)
  {
    AppMethodBeat.i(6128);
    int i = c(paramContext, mVN);
    AppMethodBeat.o(6128);
    return i;
  }
  
  public static float eb(Context paramContext)
  {
    AppMethodBeat.i(6132);
    float f2 = com.tencent.mm.cc.a.eb(paramContext);
    float f1;
    if ((f2 != com.tencent.mm.cc.a.id(paramContext)) && (f2 != com.tencent.mm.cc.a.ie(paramContext)))
    {
      f1 = f2;
      if (f2 != com.tencent.mm.cc.a.jdMethod_if(paramContext)) {}
    }
    else
    {
      f1 = com.tencent.mm.cc.a.ic(paramContext);
    }
    AppMethodBeat.o(6132);
    return f1;
  }
  
  private static int eq(Context paramContext)
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
      ad.printErrStackTrace("MicroMsg.BizTimeLineHotViewConfig", paramContext, "alvinluo getViewWidth exception", new Object[0]);
      AppMethodBeat.o(6129);
    }
    return 0;
  }
  
  public static int er(Context paramContext)
  {
    AppMethodBeat.i(6131);
    int i = (int)(com.tencent.mm.cc.a.ay(paramContext, 2131165906) * eb(paramContext));
    AppMethodBeat.o(6131);
    return i;
  }
  
  public static int getCompletelyCountPerPage()
  {
    return mVO;
  }
  
  public static float getShowCountPerPage()
  {
    return mVN;
  }
  
  public static void init(Context paramContext)
  {
    AppMethodBeat.i(6126);
    if (c(paramContext, 4.5F) <= com.tencent.mm.cc.a.fromDPToPix(paramContext, 10))
    {
      mVN = 3.5F;
      mVO = 3;
      AppMethodBeat.o(6126);
      return;
    }
    mVN = 4.5F;
    mVO = 4;
    AppMethodBeat.o(6126);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.a
 * JD-Core Version:    0.7.0.1
 */