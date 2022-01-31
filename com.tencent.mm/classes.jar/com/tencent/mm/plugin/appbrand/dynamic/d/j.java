package com.tencent.mm.plugin.appbrand.dynamic.d;

import com.tencent.mm.aa.b.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONArray;
import org.json.JSONObject;

public final class j
  extends com.tencent.mm.plugin.appbrand.dynamic.d.a.a
{
  public j(int paramInt)
  {
    super("reportIDKey", paramInt);
  }
  
  protected final void a(com.tencent.mm.aa.c.a parama, JSONObject paramJSONObject, b.a<JSONObject> parama1)
  {
    parama = paramJSONObject.optJSONArray("dataArray");
    if (parama == null)
    {
      parama1.ab(a(false, "dataArray is null", null));
      return;
    }
    int i = 0;
    for (;;)
    {
      if (i < parama.length()) {
        try
        {
          paramJSONObject = parama.getJSONObject(i);
          int j = paramJSONObject.optInt("id");
          int k = paramJSONObject.optInt("key");
          int m = paramJSONObject.optInt("value");
          h.nFQ.a(j, k, m, false);
          i += 1;
        }
        catch (Exception paramJSONObject)
        {
          for (;;)
          {
            y.e("MicroMsg.JsApiFunc_ReportIDKey", "parse json failed : %s", new Object[] { paramJSONObject.getMessage() });
          }
        }
      }
    }
    parama1.ab(a(true, "", null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.j
 * JD-Core Version:    0.7.0.1
 */