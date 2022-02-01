package com.tencent.mm.plugin.appbrand.jsapi.video.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/GeneralErrorType;", "", "(Ljava/lang/String;I)V", "NETWORK", "EXTRACT", "EXTRACT_NOT_SUPPORT", "DECODE", "DECODE_NOT_SUPPORT", "RENDER", "ILLEGAL", "OTHER", "Companion", "luggage-commons-jsapi-video-ext_release"})
public enum b
{
  public static final b.a mBp;
  
  static
  {
    AppMethodBeat.i(235219);
    b localb1 = new b("NETWORK", 0);
    mBg = localb1;
    b localb2 = new b("EXTRACT", 1);
    mBh = localb2;
    b localb3 = new b("EXTRACT_NOT_SUPPORT", 2);
    mBi = localb3;
    b localb4 = new b("DECODE", 3);
    mBj = localb4;
    b localb5 = new b("DECODE_NOT_SUPPORT", 4);
    mBk = localb5;
    b localb6 = new b("RENDER", 5);
    mBl = localb6;
    b localb7 = new b("ILLEGAL", 6);
    mBm = localb7;
    b localb8 = new b("OTHER", 7);
    mBn = localb8;
    mBo = new b[] { localb1, localb2, localb3, localb4, localb5, localb6, localb7, localb8 };
    mBp = new b.a((byte)0);
    AppMethodBeat.o(235219);
  }
  
  private b() {}
  
  public static final b el(int paramInt1, int paramInt2)
  {
    Object localObject = null;
    b localb = null;
    AppMethodBeat.i(235222);
    if (-4000 >= paramInt1) {
      switch (paramInt1)
      {
      }
    }
    for (;;)
    {
      localObject = localb;
      if (localb == null)
      {
        Log.e("MicroMsg.AppBrand.GeneralErrorType", "fromExoErrorInfo, errorType is null, errorWhat: " + paramInt1 + ", errorExtra: " + paramInt2);
        localObject = localb;
      }
      Log.i("MicroMsg.AppBrand.GeneralErrorType", "fromErrorInfo, errorWhat: " + paramInt1 + ", errorExtra: " + paramInt2 + ", errorType: " + localObject);
      AppMethodBeat.o(235222);
      return localObject;
      localb = mBg;
      continue;
      localb = mBh;
      continue;
      localb = mBi;
      continue;
      localb = mBj;
      continue;
      localb = mBl;
      continue;
      localb = mBm;
      continue;
      localb = mBn;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e.b
 * JD-Core Version:    0.7.0.1
 */