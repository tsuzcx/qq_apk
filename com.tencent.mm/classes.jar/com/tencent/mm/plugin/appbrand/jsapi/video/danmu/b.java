package com.tencent.mm.plugin.appbrand.jsapi.video.danmu;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;

public final class b
{
  public static int sDN = 18;
  public static int sDO = 10;
  private static int sDP = 3;
  
  public static int W(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(370027);
    paramInt = a.fromDPToPix(paramContext, paramInt);
    AppMethodBeat.o(370027);
    return paramInt;
  }
  
  public static int cwi()
  {
    return sDP;
  }
  
  public static float eO(Context paramContext)
  {
    AppMethodBeat.i(137855);
    float f = a.fromDPToPix(paramContext, sDN);
    AppMethodBeat.o(137855);
    return f * 2.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.danmu.b
 * JD-Core Version:    0.7.0.1
 */