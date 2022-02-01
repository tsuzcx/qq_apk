package com.tencent.mm.plugin.appbrand.jsapi.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.m.k;
import com.tencent.mm.plugin.appbrand.s;
import java.nio.ByteBuffer;

public final class b
  extends d<s>
{
  public static final int CTRL_INDEX = 861;
  public static final String NAME = "faceDetect";
  private static String lUa = "Thread.AppBrand.JsApiFaceDetect";
  
  public final ByteBuffer a(String paramString, k paramk, int paramInt)
  {
    AppMethodBeat.i(226764);
    if ("frameBuffer".equalsIgnoreCase(paramString))
    {
      paramString = paramk.N(paramInt, true);
      AppMethodBeat.o(226764);
      return paramString;
    }
    paramString = super.a(paramString, paramk, paramInt);
    AppMethodBeat.o(226764);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.e.b
 * JD-Core Version:    0.7.0.1
 */