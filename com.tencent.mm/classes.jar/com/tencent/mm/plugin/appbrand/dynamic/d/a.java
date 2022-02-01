package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.b.b.a;
import com.tencent.mm.an.d.c;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.modelappbrand.t;
import com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView;
import com.tencent.mm.plugin.webview.ui.tools.widget.p;
import com.tencent.mm.plugin.webview.ui.tools.widget.p.a;
import com.tencent.mm.protocal.protobuf.cmt;
import com.tencent.mm.protocal.protobuf.cnh;
import com.tencent.mm.protocal.protobuf.cnj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.LinkedList;
import org.json.JSONObject;

public final class a
  extends com.tencent.mm.plugin.appbrand.dynamic.d.a.a
{
  private static final String ohS;
  
  static
  {
    AppMethodBeat.i(247278);
    ohS = MMApplicationContext.getPackageName() + ":tools";
    AppMethodBeat.o(247278);
  }
  
  public a()
  {
    super("authorize", 419);
  }
  
  public final void a(com.tencent.mm.ac.c.a parama, JSONObject paramJSONObject, final b.a<JSONObject> parama1)
  {
    AppMethodBeat.i(121307);
    parama = parama.aGj();
    Bundle localBundle = new Bundle();
    try
    {
      localBundle.putString("scope", paramJSONObject.getString("scope"));
      localBundle.putString("appId", parama.getString("__page_app_id", ""));
      localBundle.putString("widgetId", parama.getString("__page_view_id", ""));
      XIPCInvoker.a(parama.getString("__process_name", ohS), localBundle, b.class, new f() {});
      AppMethodBeat.o(121307);
      return;
    }
    catch (Exception parama)
    {
      Log.e("MicroMsg.JsApiFunc_DoAuthroize", "JSON Exception[%s]", new Object[] { parama.getMessage() });
      AppMethodBeat.o(121307);
    }
  }
  
  static abstract interface a
  {
    public abstract void C(Bundle paramBundle);
  }
  
  static class b
    implements com.tencent.mm.ipcinvoker.d<Bundle, Bundle>
  {
    private static final String[] ohV = { "scope.userLocation" };
    
    private static void a(f<Bundle> paramf, boolean paramBoolean, String paramString)
    {
      AppMethodBeat.i(121301);
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("ret", paramBoolean);
      localBundle.putString("reason", paramString);
      paramf.aH(localBundle);
      AppMethodBeat.o(121301);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.a
 * JD-Core Version:    0.7.0.1
 */