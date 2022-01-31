package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.d;
import com.tencent.mm.model.v.b;
import com.tencent.mm.z.b.b.a;
import org.json.JSONObject;

public final class m
  extends com.tencent.mm.plugin.appbrand.dynamic.d.a.a
{
  public m()
  {
    super("showDatePickerView", 457);
  }
  
  public final void a(com.tencent.mm.z.c.a parama, JSONObject paramJSONObject, b.a<JSONObject> parama1)
  {
    AppMethodBeat.i(10860);
    parama = parama.Qx();
    String str = parama.getString("__page_view_id", "");
    Bundle localBundle = new Bundle();
    localBundle.putString("id", str);
    localBundle.putString("data", paramJSONObject.toString());
    XIPCInvoker.a(parama.getString("__process_name", ((h)com.tencent.mm.kernel.g.RI().Rj()).mProcessName), localBundle, m.a.class, new m.1(this, parama1));
    AppMethodBeat.o(10860);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.m
 * JD-Core Version:    0.7.0.1
 */