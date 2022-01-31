package com.tencent.mm.plugin.appbrand.dynamic.d;

import com.tencent.mm.aa.b.b.a;
import com.tencent.mm.model.u.b;
import com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetContext;
import com.tencent.mm.plugin.appbrand.dynamic.k.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONArray;
import org.json.JSONObject;

public final class k
  extends com.tencent.mm.plugin.appbrand.dynamic.d.a.a
{
  public k(int paramInt)
  {
    super("reportKeyValue", paramInt);
  }
  
  protected final void a(com.tencent.mm.aa.c.a parama, JSONObject paramJSONObject, b.a<JSONObject> parama1)
  {
    parama = com.tencent.mm.plugin.appbrand.dynamic.k.tb(parama.CD().getString("__page_view_id", null));
    if (parama == null)
    {
      parama1.ab(a(false, "JsApi Framework Context is null", null));
      return;
    }
    paramJSONObject = paramJSONObject.optJSONArray("dataArray");
    if (paramJSONObject == null)
    {
      parama1.ab(a(false, "dataArray is null", null));
      return;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramJSONObject.length()) {
        break label197;
      }
      try
      {
        Object localObject = paramJSONObject.getJSONObject(i);
        int j = ((JSONObject)localObject).optInt("key");
        localObject = ((JSONObject)localObject).optString("value");
        if ((j > 0) && (!bk.bl((String)localObject))) {
          h.nFQ.f(j, new Object[] { parama.getAppId(), Integer.valueOf(parama.afc()), Integer.valueOf(b.kK(parama.abp()) + 1), localObject });
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          y.e("MicroMsg.JsApiFunc_ReportKeyValue", "parse report value failed : %s", new Object[] { localException });
        }
      }
      i += 1;
    }
    label197:
    parama1.ab(a(true, "", null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.k
 * JD-Core Version:    0.7.0.1
 */