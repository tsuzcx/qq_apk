package com.tencent.mm.plugin.mall.ui;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aj;

public final class c
{
  private static boolean tve = false;
  
  public static void cNF()
  {
    tve = true;
  }
  
  public static int cNG()
  {
    AppMethodBeat.i(66145);
    if (tve)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.c
 * JD-Core Version:    0.7.0.1
 */