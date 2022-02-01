package com.tencent.mm.plugin.appbrand.dynamic.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.h;
import com.tencent.mm.plugin.appbrand.dynamic.i.b;
import com.tencent.mm.sdk.platformtools.LruCache;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

final class c$1
  extends LruCache<String, JSONObject>
{
  c$1(c paramc)
  {
    super(10);
  }
  
  private static JSONObject agm(String paramString)
  {
    AppMethodBeat.i(121348);
    String str = paramString;
    try
    {
      if (Util.isNullOrNil(paramString)) {
        str = "{}";
      }
      long l = System.nanoTime();
      paramString = h.ME(str);
      b.k(System.nanoTime() - l, str.length());
      AppMethodBeat.o(121348);
      return paramString;
    }
    catch (Exception paramString)
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.DefaultJsApiExecutor", android.util.Log.getStackTraceString(paramString));
      AppMethodBeat.o(121348);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.a.c.1
 * JD-Core Version:    0.7.0.1
 */