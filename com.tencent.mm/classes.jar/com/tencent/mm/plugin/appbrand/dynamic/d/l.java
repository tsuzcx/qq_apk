package com.tencent.mm.plugin.appbrand.dynamic.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.model.v.b;
import com.tencent.mm.plugin.appbrand.dynamic.widget.a.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.z.b.b.a;
import org.json.JSONObject;

public final class l
  extends com.tencent.mm.plugin.appbrand.dynamic.d.a.a
{
  public l(int paramInt)
  {
    super("setWidgetSize", paramInt);
  }
  
  public final void a(com.tencent.mm.z.c.a parama, JSONObject paramJSONObject, b.a<JSONObject> parama1)
  {
    AppMethodBeat.i(10856);
    parama = parama.Qx();
    a.a locala = new a.a();
    locala.id = parama.getString("__page_view_id", "");
    locala.width = paramJSONObject.optInt("width", parama.getInt("__page_view_width", 0));
    locala.height = paramJSONObject.optInt("height", parama.getInt("__page_view_height", 0));
    XIPCInvoker.a(parama.getString("__process_name", ah.getProcessName()), locala, l.a.class, new l.1(this, parama1));
    AppMethodBeat.o(10856);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.l
 * JD-Core Version:    0.7.0.1
 */