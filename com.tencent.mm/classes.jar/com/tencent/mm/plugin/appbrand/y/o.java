package com.tencent.mm.plugin.appbrand.y;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

public final class o
{
  private static DisplayMetrics mTt;
  
  static
  {
    AppMethodBeat.i(146132);
    mTt = ak.getContext().getResources().getDisplayMetrics();
    AppMethodBeat.o(146132);
  }
  
  public static int vP(int paramInt)
  {
    if (mTt == null) {
      return paramInt;
    }
    return (int)(mTt.density * paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.y.o
 * JD-Core Version:    0.7.0.1
 */