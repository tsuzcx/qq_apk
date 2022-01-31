package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v.b;
import com.tencent.mm.plugin.appbrand.collector.c;
import com.tencent.mm.plugin.appbrand.dynamic.d.b.a.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.z.b.b.a;
import org.json.JSONObject;

public final class b
  extends com.tencent.mm.plugin.appbrand.dynamic.d.a.a
{
  public b(int paramInt)
  {
    super("drawCanvas", paramInt);
  }
  
  public final void a(com.tencent.mm.z.c.a parama, JSONObject paramJSONObject, Bundle paramBundle, b.a<JSONObject> parama1)
  {
    AppMethodBeat.i(10828);
    c.bH(com.tencent.mm.plugin.appbrand.dynamic.h.d.u(paramJSONObject), "before_jsapi_invoke");
    parama = parama.Qx();
    String str1 = parama.getString("__page_view_id", null);
    String str2 = parama.getString("__process_name", ah.getProcessName());
    int i = parama.getInt("__draw_strategy", 0);
    if (com.tencent.mm.plugin.appbrand.dynamic.d.azx().AU(str1) == null)
    {
      ab.w("MicroMsg.JsApiFunc_DrawCanvas", "get view by viewId(%s) return null.", new Object[] { str1 });
      parama1.aj(a(false, "got 'null' when get view by the given viewId", null));
      AppMethodBeat.o(10828);
      return;
    }
    com.tencent.mm.plugin.appbrand.dynamic.d.b.b localb = new com.tencent.mm.plugin.appbrand.dynamic.d.b.b();
    e locale = com.tencent.mm.plugin.appbrand.dynamic.d.b.a.bb(str1, i);
    if (paramBundle != null) {}
    for (parama = paramBundle.getString("rawJsapiData");; parama = System.currentTimeMillis())
    {
      localb.a(str2, str1, paramJSONObject, this, parama1, locale, parama);
      com.tencent.mm.plugin.appbrand.dynamic.d.b.a.bb(str1, i).a(localb);
      AppMethodBeat.o(10828);
      return;
    }
  }
  
  public final void a(com.tencent.mm.z.c.a parama, JSONObject paramJSONObject, b.a<JSONObject> parama1) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.b
 * JD-Core Version:    0.7.0.1
 */