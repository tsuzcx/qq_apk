package com.tencent.mm.plugin.appbrand.jsapi.video.danmu;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;

public final class b
{
  public static int mAn = 18;
  public static int mAo = 10;
  private static int mAp = 3;
  
  public static int N(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(258649);
    paramInt = a.fromDPToPix(paramContext, paramInt);
    AppMethodBeat.o(258649);
    return paramInt;
  }
  
  public static int bKl()
  {
    return mAp;
  }
  
  public static float dW(Context paramContext)
  {
    AppMethodBeat.i(137855);
    float f = a.fromDPToPix(paramContext, mAn);
    AppMethodBeat.o(137855);
    return f * 2.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.danmu.b
 * JD-Core Version:    0.7.0.1
 */