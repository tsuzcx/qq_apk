package com.tencent.mm.plugin.appbrand.jsapi.video.danmu;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;

public final class b
{
  public static int ltL = 18;
  public static int ltM = 10;
  private static int ltN = 3;
  
  public static int J(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(224439);
    paramInt = a.fromDPToPix(paramContext, paramInt);
    AppMethodBeat.o(224439);
    return paramInt;
  }
  
  public static int boI()
  {
    return ltN;
  }
  
  public static float dB(Context paramContext)
  {
    AppMethodBeat.i(137855);
    float f = a.fromDPToPix(paramContext, ltL);
    AppMethodBeat.o(137855);
    return f * 2.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.danmu.b
 * JD-Core Version:    0.7.0.1
 */