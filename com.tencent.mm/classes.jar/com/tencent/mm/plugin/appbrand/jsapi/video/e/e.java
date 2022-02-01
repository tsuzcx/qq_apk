package com.tencent.mm.plugin.appbrand.jsapi.video.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/GeneralErrorType;", "", "(Ljava/lang/String;I)V", "NETWORK", "EXTRACT", "EXTRACT_NOT_SUPPORT", "DECODE", "DECODE_NOT_SUPPORT", "RENDER", "ILLEGAL", "OTHER", "Companion", "luggage-commons-jsapi-video-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum e
{
  public static final e.a sEL;
  
  static
  {
    AppMethodBeat.i(328687);
    sEM = new e("NETWORK", 0);
    sEN = new e("EXTRACT", 1);
    sEO = new e("EXTRACT_NOT_SUPPORT", 2);
    sEP = new e("DECODE", 3);
    sEQ = new e("DECODE_NOT_SUPPORT", 4);
    sER = new e("RENDER", 5);
    sES = new e("ILLEGAL", 6);
    sET = new e("OTHER", 7);
    sEU = new e[] { sEM, sEN, sEO, sEP, sEQ, sER, sES, sET };
    sEL = new e.a((byte)0);
    AppMethodBeat.o(328687);
  }
  
  private e() {}
  
  public static final e fD(int paramInt1, int paramInt2)
  {
    Object localObject = null;
    e locale = null;
    AppMethodBeat.i(328682);
    if (-4000 >= paramInt1) {
      switch (paramInt1)
      {
      }
    }
    for (;;)
    {
      localObject = locale;
      if (locale == null)
      {
        Log.e("MicroMsg.AppBrand.GeneralErrorType", "fromExoErrorInfo, errorType is null, errorWhat: " + paramInt1 + ", errorExtra: " + paramInt2);
        localObject = locale;
      }
      Log.i("MicroMsg.AppBrand.GeneralErrorType", "fromErrorInfo, errorWhat: " + paramInt1 + ", errorExtra: " + paramInt2 + ", errorType: " + localObject);
      AppMethodBeat.o(328682);
      return localObject;
      locale = sEM;
      continue;
      locale = sEN;
      continue;
      locale = sEO;
      continue;
      locale = sEP;
      continue;
      locale = sER;
      continue;
      locale = sES;
      continue;
      locale = sET;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e.e
 * JD-Core Version:    0.7.0.1
 */