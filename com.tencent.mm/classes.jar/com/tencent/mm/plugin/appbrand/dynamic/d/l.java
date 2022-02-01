package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.b.b.a;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.model.z.b;
import com.tencent.mm.modelappbrand.t;
import com.tencent.mm.plugin.appbrand.dynamic.widget.a.a;
import com.tencent.mm.sdk.platformtools.ak;
import org.json.JSONObject;

public final class l
  extends com.tencent.mm.plugin.appbrand.dynamic.d.a.a
{
  public l(int paramInt)
  {
    super("setWidgetSize", paramInt);
  }
  
  public final void a(com.tencent.mm.aa.c.a parama, JSONObject paramJSONObject, final b.a<JSONObject> parama1)
  {
    AppMethodBeat.i(121336);
    parama = parama.aiA();
    a.a locala = new a.a();
    locala.id = parama.getString("__page_view_id", "");
    locala.width = paramJSONObject.optInt("width", parama.getInt("__page_view_width", 0));
    locala.height = paramJSONObject.optInt("height", parama.getInt("__page_view_height", 0));
    XIPCInvoker.a(parama.getString("__process_name", ak.getProcessName()), locala, a.class, new d() {});
    AppMethodBeat.o(121336);
  }
  
  static class a
    implements b<a.a, Bundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.l
 * JD-Core Version:    0.7.0.1
 */