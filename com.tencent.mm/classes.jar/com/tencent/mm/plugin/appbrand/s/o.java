package com.tencent.mm.plugin.appbrand.s;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;

public final class o
{
  private static DisplayMetrics iXq;
  
  static
  {
    AppMethodBeat.i(57067);
    iXq = ah.getContext().getResources().getDisplayMetrics();
    AppMethodBeat.o(57067);
  }
  
  public static int aNT()
  {
    if (iXq == null) {
      return 16;
    }
    return (int)(iXq.density * 16.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.s.o
 * JD-Core Version:    0.7.0.1
 */