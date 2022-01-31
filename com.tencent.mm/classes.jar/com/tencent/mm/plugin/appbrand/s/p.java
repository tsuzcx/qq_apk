package com.tencent.mm.plugin.appbrand.s;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;

public final class p
{
  private static DisplayMetrics bTx;
  
  static
  {
    AppMethodBeat.i(57068);
    bTx = new DisplayMetrics();
    ((WindowManager)ah.getContext().getSystemService("window")).getDefaultDisplay().getRealMetrics(bTx);
    AppMethodBeat.o(57068);
  }
  
  public static int pP(int paramInt)
  {
    if (bTx == null) {
      return paramInt;
    }
    return (int)(paramInt / bTx.density);
  }
  
  public static int pQ(int paramInt)
  {
    if (bTx == null) {
      return paramInt;
    }
    return (int)(bTx.density * paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.s.p
 * JD-Core Version:    0.7.0.1
 */