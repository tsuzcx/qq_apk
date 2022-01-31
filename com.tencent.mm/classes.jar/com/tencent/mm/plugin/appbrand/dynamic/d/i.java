package com.tencent.mm.plugin.appbrand.dynamic.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.model.v.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.z.b.b.a;
import org.json.JSONObject;

public final class i
  extends com.tencent.mm.plugin.appbrand.dynamic.d.a.a
{
  public i()
  {
    super("openApp", 326);
  }
  
  public final void a(com.tencent.mm.z.c.a parama, JSONObject paramJSONObject, b.a<JSONObject> parama1)
  {
    AppMethodBeat.i(10850);
    parama = parama.Qx();
    i.b localb = new i.b();
    localb.id = parama.getString("__page_view_id", "");
    localb.url = paramJSONObject.optString("url", "");
    XIPCInvoker.a(parama.getString("__process_name", ah.getProcessName()), localb, i.a.class, new i.1(this, parama1));
    AppMethodBeat.o(10850);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.i
 * JD-Core Version:    0.7.0.1
 */