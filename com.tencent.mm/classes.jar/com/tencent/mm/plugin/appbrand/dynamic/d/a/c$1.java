package com.tencent.mm.plugin.appbrand.dynamic.d.a;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.h;
import com.tencent.mm.plugin.appbrand.dynamic.i.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONObject;

final class c$1
  extends ag<String, JSONObject>
{
  c$1(c paramc)
  {
    super(10);
  }
  
  private static JSONObject Hh(String paramString)
  {
    AppMethodBeat.i(121348);
    String str = paramString;
    try
    {
      if (bt.isNullOrNil(paramString)) {
        str = "{}";
      }
      long l = System.nanoTime();
      paramString = h.qE(str);
      b.g(System.nanoTime() - l, str.length());
      AppMethodBeat.o(121348);
      return paramString;
    }
    catch (Exception paramString)
    {
      ad.e("MicroMsg.DefaultJsApiExecutor", Log.getStackTraceString(paramString));
      AppMethodBeat.o(121348);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.a.c.1
 * JD-Core Version:    0.7.0.1
 */