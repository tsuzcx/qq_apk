package com.tencent.mm.plugin.appbrand.dynamic.d.a;

import android.util.Log;
import com.tencent.mm.ab.h;
import com.tencent.mm.plugin.appbrand.dynamic.i.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONObject;

final class c$1
  extends ab<String, JSONObject>
{
  c$1(c paramc)
  {
    super(10);
  }
  
  private static JSONObject th(String paramString)
  {
    String str = paramString;
    try
    {
      if (bk.bl(paramString)) {
        str = "{}";
      }
      long l = System.nanoTime();
      paramString = h.fU(str);
      b.e(System.nanoTime() - l, str.length());
      return paramString;
    }
    catch (Exception paramString)
    {
      y.e("MicroMsg.DefaultJsApiExecutor", Log.getStackTraceString(paramString));
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.a.c.1
 * JD-Core Version:    0.7.0.1
 */