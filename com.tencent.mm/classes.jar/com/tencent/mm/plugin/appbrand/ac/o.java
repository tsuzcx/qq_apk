package com.tencent.mm.plugin.appbrand.ac;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class o
{
  private static DisplayMetrics rii;
  
  static
  {
    AppMethodBeat.i(146132);
    rii = MMApplicationContext.getContext().getResources().getDisplayMetrics();
    AppMethodBeat.o(146132);
  }
  
  public static int Dj(int paramInt)
  {
    if (rii == null) {
      return paramInt;
    }
    return (int)(rii.density * paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ac.o
 * JD-Core Version:    0.7.0.1
 */