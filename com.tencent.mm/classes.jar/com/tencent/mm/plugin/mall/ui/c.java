package com.tencent.mm.plugin.mall.ui;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;

public final class c
{
  private static boolean oAw = false;
  
  public static int bOP()
  {
    AppMethodBeat.i(43248);
    if (oAw)
    {
      i = ah.getContext().getResources().getColor(2131690265);
      AppMethodBeat.o(43248);
      return i;
    }
    int i = ah.getContext().getResources().getColor(2131689496);
    AppMethodBeat.o(43248);
    return i;
  }
  
  public static void jh(boolean paramBoolean)
  {
    oAw = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.c
 * JD-Core Version:    0.7.0.1
 */