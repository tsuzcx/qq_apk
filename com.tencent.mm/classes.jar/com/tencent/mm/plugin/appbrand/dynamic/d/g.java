package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.model.v.b;
import com.tencent.mm.modelappbrand.t;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.z.b.b.a;
import org.json.JSONObject;

public final class g
  extends com.tencent.mm.plugin.appbrand.dynamic.d.a.a
{
  public g()
  {
    super("makePhoneCall", 327);
  }
  
  public final void a(com.tencent.mm.z.c.a parama, JSONObject paramJSONObject, b.a<JSONObject> parama1)
  {
    AppMethodBeat.i(10838);
    parama = parama.Qx();
    g.a locala = new g.a((byte)0);
    locala.id = parama.getString("__page_view_id", "");
    locala.cHB = paramJSONObject.optString("phoneNumber", "");
    XIPCInvoker.a(parama.getString("__process_name", ah.getProcessName()), locala, g.b.class, new g.1(this, parama1));
    AppMethodBeat.o(10838);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.g
 * JD-Core Version:    0.7.0.1
 */