package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.os.Bundle;
import com.tencent.mm.aa.b.b.a;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.d;
import com.tencent.mm.model.u.b;
import org.json.JSONObject;

public final class m
  extends com.tencent.mm.plugin.appbrand.dynamic.d.a.a
{
  public m()
  {
    super("showDatePickerView", 457);
  }
  
  protected final void a(com.tencent.mm.aa.c.a parama, JSONObject paramJSONObject, b.a<JSONObject> parama1)
  {
    parama = parama.CD();
    String str = parama.getString("__page_view_id", "");
    Bundle localBundle = new Bundle();
    localBundle.putString("id", str);
    localBundle.putString("data", paramJSONObject.toString());
    XIPCInvoker.a(parama.getString("__process_name", ((h)com.tencent.mm.kernel.g.DM().Dr()).dIA), localBundle, m.a.class, new m.1(this, parama1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.m
 * JD-Core Version:    0.7.0.1
 */