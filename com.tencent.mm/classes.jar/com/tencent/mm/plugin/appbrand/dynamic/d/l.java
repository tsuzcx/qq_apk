package com.tencent.mm.plugin.appbrand.dynamic.d;

import com.tencent.mm.aa.b.b.a;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.model.u.b;
import com.tencent.mm.plugin.appbrand.dynamic.widget.a.a;
import com.tencent.mm.sdk.platformtools.ae;
import org.json.JSONObject;

public final class l
  extends com.tencent.mm.plugin.appbrand.dynamic.d.a.a
{
  public l(int paramInt)
  {
    super("setWidgetSize", paramInt);
  }
  
  protected final void a(com.tencent.mm.aa.c.a parama, JSONObject paramJSONObject, b.a<JSONObject> parama1)
  {
    parama = parama.CD();
    a.a locala = new a.a();
    locala.id = parama.getString("__page_view_id", "");
    locala.width = paramJSONObject.optInt("width", parama.getInt("__page_view_width", 0));
    locala.height = paramJSONObject.optInt("height", parama.getInt("__page_view_height", 0));
    XIPCInvoker.a(parama.getString("__process_name", ae.getProcessName()), locala, l.a.class, new l.1(this, parama1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.l
 * JD-Core Version:    0.7.0.1
 */