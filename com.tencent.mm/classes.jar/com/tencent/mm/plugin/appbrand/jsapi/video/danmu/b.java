package com.tencent.mm.plugin.appbrand.jsapi.video.danmu;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;

public final class b
{
  public static int lpo = 18;
  public static int lpp = 10;
  private static int lpq = 3;
  
  public static int J(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(221584);
    paramInt = a.fromDPToPix(paramContext, paramInt);
    AppMethodBeat.o(221584);
    return paramInt;
  }
  
  public static int bnY()
  {
    return lpq;
  }
  
  public static float dx(Context paramContext)
  {
    AppMethodBeat.i(137855);
    float f = a.fromDPToPix(paramContext, lpo);
    AppMethodBeat.o(137855);
    return f * 2.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.danmu.b
 * JD-Core Version:    0.7.0.1
 */