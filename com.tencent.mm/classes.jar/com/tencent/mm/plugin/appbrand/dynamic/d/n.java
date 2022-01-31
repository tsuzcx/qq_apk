package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.d;
import com.tencent.mm.model.v.b;
import com.tencent.mm.z.b.b.a;
import org.json.JSONObject;

public final class n
  extends com.tencent.mm.plugin.appbrand.dynamic.d.a.a
{
  public n()
  {
    super("showPickerView", 456);
  }
  
  public final void a(com.tencent.mm.z.c.a parama, JSONObject paramJSONObject, final b.a<JSONObject> parama1)
  {
    AppMethodBeat.i(10864);
    parama = parama.Qx();
    String str = parama.getString("__page_view_id", "");
    Bundle localBundle = new Bundle();
    localBundle.putString("id", str);
    localBundle.putString("data", paramJSONObject.toString());
    XIPCInvoker.a(parama.getString("__process_name", ((h)com.tencent.mm.kernel.g.RI().Rj()).mProcessName), localBundle, n.a.class, new c() {});
    AppMethodBeat.o(10864);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.n
 * JD-Core Version:    0.7.0.1
 */