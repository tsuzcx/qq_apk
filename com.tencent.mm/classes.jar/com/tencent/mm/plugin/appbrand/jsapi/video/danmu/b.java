package com.tencent.mm.plugin.appbrand.jsapi.video.danmu;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;

public final class b
{
  public static int iet = 18;
  public static int ieu = 10;
  private static int iev = 3;
  
  public static int F(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(156831);
    paramInt = a.fromDPToPix(paramContext, paramInt);
    AppMethodBeat.o(156831);
    return paramInt;
  }
  
  public static int aFL()
  {
    return iev;
  }
  
  public static float cQ(Context paramContext)
  {
    AppMethodBeat.i(126597);
    float f = a.fromDPToPix(paramContext, iet);
    AppMethodBeat.o(126597);
    return f * 2.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.danmu.b
 * JD-Core Version:    0.7.0.1
 */