package com.tencent.mm.plugin.appbrand.dynamic.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.b.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONArray;
import org.json.JSONObject;

public final class j
  extends com.tencent.mm.plugin.appbrand.dynamic.d.a.a
{
  public j(int paramInt)
  {
    super("reportIDKey", paramInt);
  }
  
  public final void a(com.tencent.mm.aa.c.a parama, JSONObject paramJSONObject, b.a<JSONObject> parama1)
  {
    AppMethodBeat.i(121331);
    parama = paramJSONObject.optJSONArray("dataArray");
    if (parama == null)
    {
      parama1.bt(a(false, "dataArray is null", null));
      AppMethodBeat.o(121331);
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
          h.CyF.idkeyStat(j, k, m, false);
          i += 1;
        }
        catch (Exception paramJSONObject)
        {
          for (;;)
          {
            Log.e("MicroMsg.JsApiFunc_ReportIDKey", "parse json failed : %s", new Object[] { paramJSONObject.getMessage() });
          }
        }
      }
    }
    parama1.bt(a(true, "", null));
    AppMethodBeat.o(121331);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.j
 * JD-Core Version:    0.7.0.1
 */