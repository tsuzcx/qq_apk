package com.tencent.mm.plugin.appbrand.ac;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class o
{
  private static DisplayMetrics ogw;
  
  static
  {
    AppMethodBeat.i(146132);
    ogw = MMApplicationContext.getContext().getResources().getDisplayMetrics();
    AppMethodBeat.o(146132);
  }
  
  public static int zE(int paramInt)
  {
    if (ogw == null) {
      return paramInt;
    }
    return (int)(ogw.density * paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ac.o
 * JD-Core Version:    0.7.0.1
 */