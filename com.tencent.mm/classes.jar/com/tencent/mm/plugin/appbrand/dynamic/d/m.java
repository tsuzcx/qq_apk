package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.b.b.a;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.model.y.b;
import com.tencent.mm.modelappbrand.t;
import org.json.JSONObject;

public final class m
  extends com.tencent.mm.plugin.appbrand.dynamic.d.a.a
{
  public m()
  {
    super("showDatePickerView", 457);
  }
  
  public final void a(com.tencent.mm.ab.c.a parama, JSONObject paramJSONObject, final b.a<JSONObject> parama1)
  {
    AppMethodBeat.i(121340);
    parama = parama.aej();
    String str = parama.getString("__page_view_id", "");
    Bundle localBundle = new Bundle();
    localBundle.putString("id", str);
    localBundle.putString("data", paramJSONObject.toString());
    XIPCInvoker.a(parama.getString("__process_name", ((h)com.tencent.mm.kernel.g.afy().aeZ()).mProcessName), localBundle, a.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(121340);
  }
  
  static class a
    implements b<Bundle, Bundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.m
 * JD-Core Version:    0.7.0.1
 */