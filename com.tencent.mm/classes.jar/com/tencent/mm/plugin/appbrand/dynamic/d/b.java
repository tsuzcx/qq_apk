package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.os.Bundle;
import com.tencent.mm.aa.b.b.a;
import com.tencent.mm.model.u.b;
import com.tencent.mm.plugin.appbrand.collector.c;
import com.tencent.mm.plugin.appbrand.dynamic.d.b.a.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONObject;

public final class b
  extends com.tencent.mm.plugin.appbrand.dynamic.d.a.a
{
  public b(int paramInt)
  {
    super("drawCanvas", paramInt);
  }
  
  protected final void a(com.tencent.mm.aa.c.a parama, JSONObject paramJSONObject, Bundle paramBundle, b.a<JSONObject> parama1)
  {
    c.bf(com.tencent.mm.plugin.appbrand.dynamic.h.d.n(paramJSONObject), "before_jsapi_invoke");
    u.b localb = parama.CD();
    String str1 = localb.getString("__page_view_id", null);
    String str2 = localb.getString("__process_name", ae.getProcessName());
    int i = localb.getInt("__draw_strategy", 2);
    if (com.tencent.mm.plugin.appbrand.dynamic.d.aeU().sT(str1) == null)
    {
      y.w("MicroMsg.JsApiFunc_DrawCanvas", "get view by viewId(%s) return null.", new Object[] { str1 });
      parama1.ab(a(false, "got 'null' when get view by the given viewId", null));
      return;
    }
    com.tencent.mm.plugin.appbrand.dynamic.d.b.b localb1 = new com.tencent.mm.plugin.appbrand.dynamic.d.b.b();
    e locale = com.tencent.mm.plugin.appbrand.dynamic.d.b.a.aJ(str1, i);
    if (paramBundle != null) {}
    for (parama = paramBundle.getString("rawJsapiData");; parama = System.currentTimeMillis())
    {
      localb1.process = str2;
      localb1.fVM = str1;
      localb1.fVN = paramJSONObject;
      localb1.fVO = this;
      localb1.fVP = parama1;
      localb1.fVQ = localb;
      localb1.fVR = locale;
      localb1.fVS = parama;
      localb1.fVT = System.currentTimeMillis();
      com.tencent.mm.plugin.appbrand.dynamic.d.b.a.aJ(str1, i).a(localb1);
      return;
    }
  }
  
  protected final void a(com.tencent.mm.aa.c.a parama, JSONObject paramJSONObject, b.a<JSONObject> parama1) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.b
 * JD-Core Version:    0.7.0.1
 */