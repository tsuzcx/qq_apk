package com.tencent.mm.plugin.appbrand.dynamic.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.model.v.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.z.b.b.a;
import org.json.JSONObject;

public final class h
  extends com.tencent.mm.plugin.appbrand.dynamic.d.a.a
{
  public h()
  {
    super("onTapCallback", 327);
  }
  
  public final void a(com.tencent.mm.z.c.a parama, JSONObject paramJSONObject, b.a<JSONObject> parama1)
  {
    AppMethodBeat.i(10844);
    parama = parama.Qx();
    h.b localb = new h.b();
    localb.id = parama.getString("__page_view_id", "");
    localb.cJG = paramJSONObject.optString("eventId", "");
    localb.hoT = paramJSONObject.optBoolean("hasHandler");
    localb.hoU = paramJSONObject.optBoolean("res");
    XIPCInvoker.a(parama.getString("__process_name", ah.getProcessName()), localb, h.a.class, new h.1(this, parama1));
    AppMethodBeat.o(10844);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.h
 * JD-Core Version:    0.7.0.1
 */