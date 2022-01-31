package com.tencent.mm.plugin.appbrand.dynamic.d.a;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.h;
import com.tencent.mm.plugin.appbrand.dynamic.i.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

final class c$1
  extends ae<String, JSONObject>
{
  c$1(c paramc)
  {
    super(10);
  }
  
  private static JSONObject Bj(String paramString)
  {
    AppMethodBeat.i(10868);
    String str = paramString;
    try
    {
      if (bo.isNullOrNil(paramString)) {
        str = "{}";
      }
      long l = System.nanoTime();
      paramString = h.mo(str);
      b.f(System.nanoTime() - l, str.length());
      AppMethodBeat.o(10868);
      return paramString;
    }
    catch (Exception paramString)
    {
      ab.e("MicroMsg.DefaultJsApiExecutor", Log.getStackTraceString(paramString));
      AppMethodBeat.o(10868);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.a.c.1
 * JD-Core Version:    0.7.0.1
 */