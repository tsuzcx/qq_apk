package com.tencent.mm.plugin.appbrand.dynamic.d;

import com.tencent.mm.aa.b.b.a;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.model.u.b;
import com.tencent.mm.sdk.platformtools.ae;
import org.json.JSONObject;

public final class g
  extends com.tencent.mm.plugin.appbrand.dynamic.d.a.a
{
  public g()
  {
    super("makePhoneCall", 327);
  }
  
  protected final void a(com.tencent.mm.aa.c.a parama, JSONObject paramJSONObject, b.a<JSONObject> parama1)
  {
    parama = parama.CD();
    g.a locala = new g.a((byte)0);
    locala.id = parama.getString("__page_view_id", "");
    locala.caM = paramJSONObject.optString("phoneNumber", "");
    XIPCInvoker.a(parama.getString("__process_name", ae.getProcessName()), locala, g.b.class, new g.1(this, parama1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.g
 * JD-Core Version:    0.7.0.1
 */