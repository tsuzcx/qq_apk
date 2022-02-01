package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.b.b.a;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import org.json.JSONObject;

public final class a
  extends com.tencent.mm.plugin.appbrand.dynamic.d.a.a
{
  private static final String lnh;
  
  static
  {
    AppMethodBeat.i(192519);
    lnh = MMApplicationContext.getPackageName() + ":tools";
    AppMethodBeat.o(192519);
  }
  
  public a()
  {
    super("authorize", 419);
  }
  
  public final void a(com.tencent.mm.aa.c.a parama, JSONObject paramJSONObject, final b.a<JSONObject> parama1)
  {
    AppMethodBeat.i(121307);
    parama = parama.ayQ();
    Bundle localBundle = new Bundle();
    try
    {
      localBundle.putString("scope", paramJSONObject.getString("scope"));
      localBundle.putString("appId", parama.getString("__page_app_id", ""));
      localBundle.putString("widgetId", parama.getString("__page_view_id", ""));
      XIPCInvoker.a(parama.getString("__process_name", lnh), localBundle, a.b.class, new d() {});
      AppMethodBeat.o(121307);
      return;
    }
    catch (Exception parama)
    {
      Log.e("MicroMsg.JsApiFunc_DoAuthroize", "JSON Exception[%s]", new Object[] { parama.getMessage() });
      AppMethodBeat.o(121307);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.a
 * JD-Core Version:    0.7.0.1
 */