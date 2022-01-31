package com.tencent.mm.plugin.appbrand.dynamic.d;

import com.tencent.mm.aa.b.b.a;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.model.u.b;
import com.tencent.mm.sdk.platformtools.ae;
import org.json.JSONObject;

public final class h
  extends com.tencent.mm.plugin.appbrand.dynamic.d.a.a
{
  public h()
  {
    super("onTapCallback", 327);
  }
  
  protected final void a(com.tencent.mm.aa.c.a parama, JSONObject paramJSONObject, b.a<JSONObject> parama1)
  {
    parama = parama.CD();
    h.b localb = new h.b();
    localb.id = parama.getString("__page_view_id", "");
    localb.cbd = paramJSONObject.optString("eventId", "");
    localb.fVr = paramJSONObject.optBoolean("hasHandler");
    localb.fVs = paramJSONObject.optBoolean("res");
    XIPCInvoker.a(parama.getString("__process_name", ae.getProcessName()), localb, h.a.class, new h.1(this, parama1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.h
 * JD-Core Version:    0.7.0.1
 */