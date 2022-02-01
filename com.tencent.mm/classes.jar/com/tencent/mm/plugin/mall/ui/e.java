package com.tencent.mm.plugin.mall.ui;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

public final class e
{
  private static boolean vSB = false;
  
  public static void dnG()
  {
    vSB = true;
  }
  
  public static int dnH()
  {
    AppMethodBeat.i(66145);
    if (vSB)
    {
      i = ak.getContext().getResources().getColor(2131100605);
      AppMethodBeat.o(66145);
      return i;
    }
    int i = ak.getContext().getResources().getColor(2131099679);
    AppMethodBeat.o(66145);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.e
 * JD-Core Version:    0.7.0.1
 */