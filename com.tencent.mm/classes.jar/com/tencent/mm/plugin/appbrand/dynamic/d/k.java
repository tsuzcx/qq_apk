package com.tencent.mm.plugin.appbrand.dynamic.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.b.b.a;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetContext;
import com.tencent.mm.plugin.appbrand.dynamic.k.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONArray;
import org.json.JSONObject;

public final class k
  extends com.tencent.mm.plugin.appbrand.dynamic.d.a.a
{
  public k(int paramInt)
  {
    super("reportKeyValue", paramInt);
  }
  
  public final void a(com.tencent.mm.ac.c.a parama, JSONObject paramJSONObject, b.a<JSONObject> parama1)
  {
    AppMethodBeat.i(121332);
    parama = com.tencent.mm.plugin.appbrand.dynamic.k.agg(parama.aGj().getString("__page_view_id", null));
    if (parama == null)
    {
      parama1.bt(i(false, "JsApi Framework Context is null"));
      AppMethodBeat.o(121332);
      return;
    }
    paramJSONObject = paramJSONObject.optJSONArray("dataArray");
    if (paramJSONObject == null)
    {
      parama1.bt(i(false, "dataArray is null"));
      AppMethodBeat.o(121332);
      return;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramJSONObject.length()) {
        break label210;
      }
      try
      {
        Object localObject = paramJSONObject.getJSONObject(i);
        int j = ((JSONObject)localObject).optInt("key");
        localObject = ((JSONObject)localObject).optString("value");
        if ((j > 0) && (!Util.isNullOrNil((String)localObject))) {
          h.IzE.a(j, new Object[] { parama.getAppId(), Integer.valueOf(parama.bNm()), Integer.valueOf(b.zD(parama.bGn()) + 1), localObject });
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e("MicroMsg.JsApiFunc_ReportKeyValue", "parse report value failed : %s", new Object[] { localException });
        }
      }
      i += 1;
    }
    label210:
    parama1.bt(i(true, ""));
    AppMethodBeat.o(121332);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.k
 * JD-Core Version:    0.7.0.1
 */