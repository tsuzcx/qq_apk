package com.tencent.mm.plugin.mall.ui;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ai;

public final class c
{
  private static boolean uDx = false;
  
  public static void dbm()
  {
    uDx = true;
  }
  
  public static int dbn()
  {
    AppMethodBeat.i(66145);
    if (uDx)
    {
      i = ai.getContext().getResources().getColor(2131100605);
      AppMethodBeat.o(66145);
      return i;
    }
    int i = ai.getContext().getResources().getColor(2131099679);
    AppMethodBeat.o(66145);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.c
 * JD-Core Version:    0.7.0.1
 */