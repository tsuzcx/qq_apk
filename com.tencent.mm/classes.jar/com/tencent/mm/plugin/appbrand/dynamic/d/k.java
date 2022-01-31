package com.tencent.mm.plugin.appbrand.dynamic.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v.b;
import com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetContext;
import com.tencent.mm.plugin.appbrand.dynamic.k.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.z.b.b.a;
import org.json.JSONArray;
import org.json.JSONObject;

public final class k
  extends com.tencent.mm.plugin.appbrand.dynamic.d.a.a
{
  public k(int paramInt)
  {
    super("reportKeyValue", paramInt);
  }
  
  public final void a(com.tencent.mm.z.c.a parama, JSONObject paramJSONObject, b.a<JSONObject> parama1)
  {
    AppMethodBeat.i(10852);
    parama = com.tencent.mm.plugin.appbrand.dynamic.k.Bd(parama.Qx().getString("__page_view_id", null));
    if (parama == null)
    {
      parama1.aj(a(false, "JsApi Framework Context is null", null));
      AppMethodBeat.o(10852);
      return;
    }
    paramJSONObject = paramJSONObject.optJSONArray("dataArray");
    if (paramJSONObject == null)
    {
      parama1.aj(a(false, "dataArray is null", null));
      AppMethodBeat.o(10852);
      return;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramJSONObject.length()) {
        break label215;
      }
      try
      {
        Object localObject = paramJSONObject.getJSONObject(i);
        int j = ((JSONObject)localObject).optInt("key");
        localObject = ((JSONObject)localObject).optString("value");
        if ((j > 0) && (!bo.isNullOrNil((String)localObject))) {
          h.qsU.e(j, new Object[] { parama.getAppId(), Integer.valueOf(parama.azG()), Integer.valueOf(b.nI(parama.avf()) + 1), localObject });
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ab.e("MicroMsg.JsApiFunc_ReportKeyValue", "parse report value failed : %s", new Object[] { localException });
        }
      }
      i += 1;
    }
    label215:
    parama1.aj(a(true, "", null));
    AppMethodBeat.o(10852);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.k
 * JD-Core Version:    0.7.0.1
 */