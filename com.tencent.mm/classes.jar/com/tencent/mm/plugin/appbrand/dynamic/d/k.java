package com.tencent.mm.plugin.appbrand.dynamic.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.b.b.a;
import com.tencent.mm.model.z.b;
import com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetContext;
import com.tencent.mm.plugin.appbrand.dynamic.k.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import org.json.JSONArray;
import org.json.JSONObject;

public final class k
  extends com.tencent.mm.plugin.appbrand.dynamic.d.a.a
{
  public k(int paramInt)
  {
    super("reportKeyValue", paramInt);
  }
  
  public final void a(com.tencent.mm.aa.c.a parama, JSONObject paramJSONObject, b.a<JSONObject> parama1)
  {
    AppMethodBeat.i(121332);
    parama = com.tencent.mm.plugin.appbrand.dynamic.k.Ph(parama.aiA().getString("__page_view_id", null));
    if (parama == null)
    {
      parama1.bk(a(false, "JsApi Framework Context is null", null));
      AppMethodBeat.o(121332);
      return;
    }
    paramJSONObject = paramJSONObject.optJSONArray("dataArray");
    if (paramJSONObject == null)
    {
      parama1.bk(a(false, "dataArray is null", null));
      AppMethodBeat.o(121332);
      return;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramJSONObject.length()) {
        break label212;
      }
      try
      {
        Object localObject = paramJSONObject.getJSONObject(i);
        int j = ((JSONObject)localObject).optInt("key");
        localObject = ((JSONObject)localObject).optString("value");
        if ((j > 0) && (!bu.isNullOrNil((String)localObject))) {
          g.yxI.f(j, new Object[] { parama.getAppId(), Integer.valueOf(parama.bgx()), Integer.valueOf(b.su(parama.aZQ()) + 1), localObject });
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ae.e("MicroMsg.JsApiFunc_ReportKeyValue", "parse report value failed : %s", new Object[] { localException });
        }
      }
      i += 1;
    }
    label212:
    parama1.bk(a(true, "", null));
    AppMethodBeat.o(121332);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.k
 * JD-Core Version:    0.7.0.1
 */