package com.tencent.mm.plugin.appbrand.jsapi.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsruntime.k;
import com.tencent.mm.plugin.appbrand.r;
import java.nio.ByteBuffer;

public final class b
  extends a<r>
{
  public static final int CTRL_INDEX = 861;
  public static final String NAME = "faceDetect";
  private static String kPc = "Thread.AppBrand.JsApiFaceDetect";
  
  public final ByteBuffer a(String paramString, k paramk, int paramInt)
  {
    AppMethodBeat.i(222460);
    if ("frameBuffer".equalsIgnoreCase(paramString))
    {
      paramString = paramk.J(paramInt, true);
      AppMethodBeat.o(222460);
      return paramString;
    }
    paramString = super.a(paramString, paramk, paramInt);
    AppMethodBeat.o(222460);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.d.b
 * JD-Core Version:    0.7.0.1
 */