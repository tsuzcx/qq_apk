package com.tencent.mm.plugin.mall.ui;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class e
{
  private static boolean zmH = false;
  
  public static void ehs()
  {
    zmH = true;
  }
  
  public static int eht()
  {
    AppMethodBeat.i(66145);
    if (zmH)
    {
      i = MMApplicationContext.getContext().getResources().getColor(2131100773);
      AppMethodBeat.o(66145);
      return i;
    }
    int i = MMApplicationContext.getContext().getResources().getColor(2131099689);
    AppMethodBeat.o(66145);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.e
 * JD-Core Version:    0.7.0.1
 */