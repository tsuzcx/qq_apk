package com.tencent.mm.plugin.appbrand.aa;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aj;

public final class n
{
  private static DisplayMetrics lLQ;
  
  static
  {
    AppMethodBeat.i(146132);
    lLQ = aj.getContext().getResources().getDisplayMetrics();
    AppMethodBeat.o(146132);
  }
  
  public static int bqn()
  {
    if (lLQ == null) {
      return 16;
    }
    return (int)(lLQ.density * 16.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.aa.n
 * JD-Core Version:    0.7.0.1
 */