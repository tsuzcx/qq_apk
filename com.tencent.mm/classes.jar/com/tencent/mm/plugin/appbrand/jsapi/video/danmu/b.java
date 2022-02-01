package com.tencent.mm.plugin.appbrand.jsapi.video.danmu;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;

public final class b
{
  public static int krs = 18;
  public static int krt = 10;
  private static int kru = 3;
  
  public static int F(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(205911);
    paramInt = a.fromDPToPix(paramContext, paramInt);
    AppMethodBeat.o(205911);
    return paramInt;
  }
  
  public static int bds()
  {
    return kru;
  }
  
  public static float dq(Context paramContext)
  {
    AppMethodBeat.i(137855);
    float f = a.fromDPToPix(paramContext, krs);
    AppMethodBeat.o(137855);
    return f * 2.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.danmu.b
 * JD-Core Version:    0.7.0.1
 */