package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.b.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.model.y.b;
import com.tencent.mm.modelappbrand.t;
import com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView;
import com.tencent.mm.plugin.webview.ui.tools.widget.r;
import com.tencent.mm.plugin.webview.ui.tools.widget.r.a;
import com.tencent.mm.protocal.protobuf.bij;
import com.tencent.mm.protocal.protobuf.bix;
import com.tencent.mm.protocal.protobuf.biz;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;
import org.json.JSONObject;

public final class a
  extends com.tencent.mm.plugin.appbrand.dynamic.d.a.a
{
  private static String jlK = "com.tencent.mm:tools";
  
  public a()
  {
    super("authorize", 419);
  }
  
  public final void a(com.tencent.mm.ab.c.a parama, JSONObject paramJSONObject, final b.a<JSONObject> parama1)
  {
    AppMethodBeat.i(121307);
    parama = parama.aej();
    Bundle localBundle = new Bundle();
    try
    {
      localBundle.putString("scope", paramJSONObject.getString("scope"));
      localBundle.putString("appId", parama.getString("__page_app_id", ""));
      localBundle.putString("widgetId", parama.getString("__page_view_id", ""));
      XIPCInvoker.a(parama.getString("__process_name", jlK), localBundle, b.class, new d() {});
      AppMethodBeat.o(121307);
      return;
    }
    catch (Exception parama)
    {
      ad.e("MicroMsg.JsApiFunc_DoAuthroize", "JSON Exception[%s]", new Object[] { parama.getMessage() });
      AppMethodBeat.o(121307);
    }
  }
  
  static abstract interface a
  {
    public abstract void q(Bundle paramBundle);
  }
  
  static class b
    implements com.tencent.mm.ipcinvoker.b<Bundle, Bundle>
  {
    private static final String[] jlN = { "scope.userLocation" };
    
    private static void a(d<Bundle> paramd, boolean paramBoolean, String paramString)
    {
      AppMethodBeat.i(121301);
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("ret", paramBoolean);
      localBundle.putString("reason", paramString);
      paramd.bf(localBundle);
      AppMethodBeat.o(121301);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.a
 * JD-Core Version:    0.7.0.1
 */