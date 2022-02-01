package com.tencent.mm.plugin.appbrand.jsapi.video.danmu;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;

public final class b
{
  public static int pyI = 18;
  public static int pyJ = 10;
  private static int pyK = 3;
  
  public static int R(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(292958);
    paramInt = a.fromDPToPix(paramContext, paramInt);
    AppMethodBeat.o(292958);
    return paramInt;
  }
  
  public static int bVW()
  {
    return pyK;
  }
  
  public static float dU(Context paramContext)
  {
    AppMethodBeat.i(137855);
    float f = a.fromDPToPix(paramContext, pyI);
    AppMethodBeat.o(137855);
    return f * 2.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.danmu.b
 * JD-Core Version:    0.7.0.1
 */