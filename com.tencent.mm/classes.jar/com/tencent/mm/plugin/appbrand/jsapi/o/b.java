package com.tencent.mm.plugin.appbrand.jsapi.o;

import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONArray;
import org.json.JSONObject;

public class b
  extends a
{
  private static final int CTRL_INDEX = 64;
  private static final String NAME = "reportIDKey";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    paramJSONObject = paramJSONObject.optJSONArray("dataArray");
    if (paramJSONObject == null)
    {
      paramc.C(paramInt, h("fail", null));
      return;
    }
    int i = 0;
    for (;;)
    {
      if (i < paramJSONObject.length()) {
        try
        {
          JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
          int j = localJSONObject.optInt("id");
          int k = localJSONObject.optInt("key");
          int m = localJSONObject.optInt("value");
          h.nFQ.a(j, k, m, false);
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            y.e("MicroMsg.JsApiReportIDKey", "parse json failed : %s", new Object[] { localException.getMessage() });
          }
        }
      }
    }
    paramc.C(paramInt, h("ok", null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.o.b
 * JD-Core Version:    0.7.0.1
 */