package com.tencent.mm.plugin.mall.ui;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class e
{
  private static boolean KMy = false;
  
  public static void fZH()
  {
    KMy = true;
  }
  
  public static int fZI()
  {
    AppMethodBeat.i(66145);
    if (KMy)
    {
      i = MMApplicationContext.getContext().getResources().getColor(a.c.mall_index_new_bg_color);
      AppMethodBeat.o(66145);
      return i;
    }
    int i = MMApplicationContext.getContext().getResources().getColor(a.c.BW_93);
    AppMethodBeat.o(66145);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.e
 * JD-Core Version:    0.7.0.1
 */