package com.tencent.mm.plugin.appbrand.af;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class q
{
  private static DisplayMetrics uqe;
  
  static
  {
    AppMethodBeat.i(146132);
    uqe = MMApplicationContext.getContext().getResources().getDisplayMetrics();
    AppMethodBeat.o(146132);
  }
  
  public static int DD(int paramInt)
  {
    if (uqe == null) {
      return paramInt;
    }
    return (int)(uqe.density * paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.af.q
 * JD-Core Version:    0.7.0.1
 */