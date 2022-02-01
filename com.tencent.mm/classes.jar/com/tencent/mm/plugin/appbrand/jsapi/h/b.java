package com.tencent.mm.plugin.appbrand.jsapi.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.n.i;
import com.tencent.mm.plugin.appbrand.n.k;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Objects;
import org.json.JSONObject;

public final class b
  extends c<y>
{
  public static final int CTRL_INDEX = 861;
  public static final String NAME = "faceDetect";
  private static String rWB = "Thread.AppBrand.JsApiFaceDetect";
  
  public final ByteBuffer a(String paramString, k paramk, int paramInt)
  {
    AppMethodBeat.i(326554);
    if ("frameBuffer".equalsIgnoreCase(paramString))
    {
      paramString = paramk.ae(paramInt, true);
      AppMethodBeat.o(326554);
      return paramString;
    }
    paramString = super.a(paramString, paramk, paramInt);
    AppMethodBeat.o(326554);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.h.b
 * JD-Core Version:    0.7.0.1
 */