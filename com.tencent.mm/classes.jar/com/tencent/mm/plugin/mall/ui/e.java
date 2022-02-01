package com.tencent.mm.plugin.mall.ui;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aj;

public final class e
{
  private static boolean vGx = false;
  
  public static void dkG()
  {
    vGx = true;
  }
  
  public static int dkH()
  {
    AppMethodBeat.i(66145);
    if (vGx)
    {
      i = aj.getContext().getResources().getColor(2131100605);
      AppMethodBeat.o(66145);
      return i;
    }
    int i = aj.getContext().getResources().getColor(2131099679);
    AppMethodBeat.o(66145);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.e
 * JD-Core Version:    0.7.0.1
 */