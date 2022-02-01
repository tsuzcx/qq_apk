package com.tencent.mm.plugin.appbrand.z;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ai;

public final class n
{
  private static DisplayMetrics mnN;
  
  static
  {
    AppMethodBeat.i(146132);
    mnN = ai.getContext().getResources().getDisplayMetrics();
    AppMethodBeat.o(146132);
  }
  
  public static int bxk()
  {
    if (mnN == null) {
      return 16;
    }
    return (int)(mnN.density * 16.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.z.n
 * JD-Core Version:    0.7.0.1
 */