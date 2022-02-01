package com.tencent.mm.plugin.appbrand.jsapi.video.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/GeneralErrorType;", "", "(Ljava/lang/String;I)V", "NETWORK", "EXTRACT", "EXTRACT_NOT_SUPPORT", "DECODE", "DECODE_NOT_SUPPORT", "RENDER", "ILLEGAL", "OTHER", "Companion", "luggage-commons-jsapi-video-ext_release"})
public enum c
{
  public static final c.a pzN;
  
  static
  {
    AppMethodBeat.i(230666);
    c localc1 = new c("NETWORK", 0);
    pzE = localc1;
    c localc2 = new c("EXTRACT", 1);
    pzF = localc2;
    c localc3 = new c("EXTRACT_NOT_SUPPORT", 2);
    pzG = localc3;
    c localc4 = new c("DECODE", 3);
    pzH = localc4;
    c localc5 = new c("DECODE_NOT_SUPPORT", 4);
    pzI = localc5;
    c localc6 = new c("RENDER", 5);
    pzJ = localc6;
    c localc7 = new c("ILLEGAL", 6);
    pzK = localc7;
    c localc8 = new c("OTHER", 7);
    pzL = localc8;
    pzM = new c[] { localc1, localc2, localc3, localc4, localc5, localc6, localc7, localc8 };
    pzN = new c.a((byte)0);
    AppMethodBeat.o(230666);
  }
  
  private c() {}
  
  public static final c eJ(int paramInt1, int paramInt2)
  {
    Object localObject = null;
    c localc = null;
    AppMethodBeat.i(230675);
    if (-4000 >= paramInt1) {
      switch (paramInt1)
      {
      }
    }
    for (;;)
    {
      localObject = localc;
      if (localc == null)
      {
        Log.e("MicroMsg.AppBrand.GeneralErrorType", "fromExoErrorInfo, errorType is null, errorWhat: " + paramInt1 + ", errorExtra: " + paramInt2);
        localObject = localc;
      }
      Log.i("MicroMsg.AppBrand.GeneralErrorType", "fromErrorInfo, errorWhat: " + paramInt1 + ", errorExtra: " + paramInt2 + ", errorType: " + localObject);
      AppMethodBeat.o(230675);
      return localObject;
      localc = pzE;
      continue;
      localc = pzF;
      continue;
      localc = pzG;
      continue;
      localc = pzH;
      continue;
      localc = pzJ;
      continue;
      localc = pzK;
      continue;
      localc = pzL;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e.c
 * JD-Core Version:    0.7.0.1
 */