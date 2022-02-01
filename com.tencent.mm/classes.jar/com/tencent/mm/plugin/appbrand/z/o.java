package com.tencent.mm.plugin.appbrand.z;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aj;

public final class o
{
  private static DisplayMetrics mOp;
  
  static
  {
    AppMethodBeat.i(146132);
    mOp = aj.getContext().getResources().getDisplayMetrics();
    AppMethodBeat.o(146132);
  }
  
  public static int vK(int paramInt)
  {
    if (mOp == null) {
      return paramInt;
    }
    return (int)(mOp.density * paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.z.o
 * JD-Core Version:    0.7.0.1
 */