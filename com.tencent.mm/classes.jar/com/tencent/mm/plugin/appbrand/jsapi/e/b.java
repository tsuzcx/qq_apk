package com.tencent.mm.plugin.appbrand.jsapi.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.m.k;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Objects;
import org.json.JSONObject;

public final class b
  extends c<v>
{
  public static final int CTRL_INDEX = 861;
  public static final String NAME = "faceDetect";
  private static String oQU = "Thread.AppBrand.JsApiFaceDetect";
  
  public final ByteBuffer a(String paramString, k paramk, int paramInt)
  {
    AppMethodBeat.i(281440);
    if ("frameBuffer".equalsIgnoreCase(paramString))
    {
      paramString = paramk.P(paramInt, true);
      AppMethodBeat.o(281440);
      return paramString;
    }
    paramString = super.a(paramString, paramk, paramInt);
    AppMethodBeat.o(281440);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.e.b
 * JD-Core Version:    0.7.0.1
 */