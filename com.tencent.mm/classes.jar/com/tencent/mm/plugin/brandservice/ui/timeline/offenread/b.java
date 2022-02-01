package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.d.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;

public final class b
{
  private static float rpl;
  private static int rpm;
  public static final int sJR;
  
  static
  {
    AppMethodBeat.i(257276);
    if (WeChatEnvironment.hasDebugger()) {}
    for (int i = 20;; i = 12)
    {
      sJR = i;
      rpl = 4.5F;
      rpm = 4;
      AppMethodBeat.o(257276);
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
    int k = ex(paramContext);
    int m = eR(paramContext);
    int j = (int)(2.0F * (m - k * paramFloat) / (Math.floor(paramFloat) * 2.0D + 1.0D));
    int i = j;
    if (j < 0) {
      i = 0;
    }
    Log.i("MicroMsg.BizTimeLineHotViewConfig", "alvinluo getItemPadding itemWidth: %d, itemPadding: %d, viewWidth: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(m) });
    AppMethodBeat.o(6130);
    return i;
  }
  
  public static int eQ(Context paramContext)
  {
    AppMethodBeat.i(6128);
    int i = c(paramContext, rpl);
    AppMethodBeat.o(6128);
    return i;
  }
  
  private static int eR(Context paramContext)
  {
    AppMethodBeat.i(6129);
    com.tencent.mm.plugin.bizui.a.a locala = com.tencent.mm.plugin.bizui.a.a.shG;
    int i = com.tencent.mm.plugin.bizui.a.a.eO(paramContext);
    AppMethodBeat.o(6129);
    return i;
  }
  
  public static int eS(Context paramContext)
  {
    AppMethodBeat.i(257275);
    if (paramContext == null)
    {
      AppMethodBeat.o(257275);
      return 0;
    }
    int i = (int)(eR(paramContext) * 2 / (Math.floor(rpl) * 2.0D + 1.0D));
    AppMethodBeat.o(257275);
    return i;
  }
  
  public static int eT(Context paramContext)
  {
    AppMethodBeat.i(6131);
    int i = (int)(com.tencent.mm.ci.a.aZ(paramContext, d.c.spi) * ez(paramContext));
    AppMethodBeat.o(6131);
    return i;
  }
  
  public static int ex(Context paramContext)
  {
    AppMethodBeat.i(6127);
    if (paramContext == null)
    {
      AppMethodBeat.o(6127);
      return 0;
    }
    int i = (int)(com.tencent.mm.ci.a.aZ(paramContext, d.c.spj) * ez(paramContext));
    Log.d("MicroMsg.BizTimeLineHotViewConfig", "alvinluo itemWidth: %d", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(6127);
    return i;
  }
  
  private static float ez(Context paramContext)
  {
    AppMethodBeat.i(6132);
    float f2 = com.tencent.mm.ci.a.ez(paramContext);
    float f1;
    if ((f2 != com.tencent.mm.ci.a.kf(paramContext)) && (f2 != com.tencent.mm.ci.a.kg(paramContext)))
    {
      f1 = f2;
      if (f2 != com.tencent.mm.ci.a.kh(paramContext)) {}
    }
    else
    {
      f1 = com.tencent.mm.ci.a.ke(paramContext);
    }
    AppMethodBeat.o(6132);
    return f1;
  }
  
  public static int getCompletelyCountPerPage()
  {
    return rpm;
  }
  
  public static float getShowCountPerPage()
  {
    return rpl;
  }
  
  public static void init(Context paramContext)
  {
    AppMethodBeat.i(6126);
    if (c(paramContext, 4.5F) <= com.tencent.mm.ci.a.fromDPToPix(paramContext, 8))
    {
      rpl = 3.5F;
      rpm = 3;
      AppMethodBeat.o(6126);
      return;
    }
    rpl = 4.5F;
    rpm = 4;
    AppMethodBeat.o(6126);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.b
 * JD-Core Version:    0.7.0.1
 */