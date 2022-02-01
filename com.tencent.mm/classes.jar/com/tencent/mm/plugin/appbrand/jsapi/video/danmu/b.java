package com.tencent.mm.plugin.appbrand.jsapi.video.danmu;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;

public final class b
{
  public static int kSL = 18;
  public static int kSM = 10;
  private static int kSN = 3;
  
  public static int I(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(210402);
    paramInt = a.fromDPToPix(paramContext, paramInt);
    AppMethodBeat.o(210402);
    return paramInt;
  }
  
  public static int bkn()
  {
    return kSN;
  }
  
  public static float dz(Context paramContext)
  {
    AppMethodBeat.i(137855);
    float f = a.fromDPToPix(paramContext, kSL);
    AppMethodBeat.o(137855);
    return f * 2.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.danmu.b
 * JD-Core Version:    0.7.0.1
 */