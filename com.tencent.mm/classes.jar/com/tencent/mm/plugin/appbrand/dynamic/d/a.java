package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.os.Bundle;
import com.tencent.mm.aa.b.b.a;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.model.u.b;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONObject;

public final class a
  extends com.tencent.mm.plugin.appbrand.dynamic.d.a.a
{
  private static String fVa = "com.tencent.mm:tools";
  
  public a()
  {
    super("authorize", 419);
  }
  
  protected final void a(com.tencent.mm.aa.c.a parama, JSONObject paramJSONObject, b.a<JSONObject> parama1)
  {
    parama = parama.CD();
    Bundle localBundle = new Bundle();
    try
    {
      localBundle.putString("scope", paramJSONObject.getString("scope"));
      localBundle.putString("appId", parama.getString("__page_app_id", ""));
      localBundle.putString("widgetId", parama.getString("__page_view_id", ""));
      XIPCInvoker.a(parama.getString("__process_name", fVa), localBundle, a.b.class, new a.1(this, parama1));
      return;
    }
    catch (Exception parama)
    {
      y.e("MicroMsg.JsApiFunc_DoAuthroize", "JSON Exception[%s]", new Object[] { parama.getMessage() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.a
 * JD-Core Version:    0.7.0.1
 */