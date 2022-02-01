package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.b.b.a;
import com.tencent.mm.model.z.b;
import com.tencent.mm.plugin.appbrand.collector.c;
import com.tencent.mm.plugin.appbrand.dynamic.d.b.a.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import org.json.JSONObject;

public final class b
  extends com.tencent.mm.plugin.appbrand.dynamic.d.a.a
{
  public b(int paramInt)
  {
    super("drawCanvas", paramInt);
  }
  
  public final void a(com.tencent.mm.aa.c.a parama, JSONObject paramJSONObject, Bundle paramBundle, b.a<JSONObject> parama1)
  {
    AppMethodBeat.i(121308);
    c.cB(com.tencent.mm.plugin.appbrand.dynamic.h.d.z(paramJSONObject), "before_jsapi_invoke");
    parama = parama.aiA();
    String str1 = parama.getString("__page_view_id", null);
    String str2 = parama.getString("__process_name", ak.getProcessName());
    int i = parama.getInt("__draw_strategy", 0);
    if (com.tencent.mm.plugin.appbrand.dynamic.d.bgo().OX(str1) == null)
    {
      ae.w("MicroMsg.JsApiFunc_DrawCanvas", "get view by viewId(%s) return null.", new Object[] { str1 });
      parama1.bk(a(false, "got 'null' when get view by the given viewId", null));
      AppMethodBeat.o(121308);
      return;
    }
    com.tencent.mm.plugin.appbrand.dynamic.d.b.b localb = new com.tencent.mm.plugin.appbrand.dynamic.d.b.b();
    e locale = com.tencent.mm.plugin.appbrand.dynamic.d.b.a.bC(str1, i);
    if (paramBundle != null) {}
    for (parama = paramBundle.getString("rawJsapiData");; parama = System.currentTimeMillis())
    {
      localb.a(str2, str1, paramJSONObject, this, parama1, locale, parama);
      com.tencent.mm.plugin.appbrand.dynamic.d.b.a.bC(str1, i).a(localb);
      AppMethodBeat.o(121308);
      return;
    }
  }
  
  public final void a(com.tencent.mm.aa.c.a parama, JSONObject paramJSONObject, b.a<JSONObject> parama1) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.b
 * JD-Core Version:    0.7.0.1
 */