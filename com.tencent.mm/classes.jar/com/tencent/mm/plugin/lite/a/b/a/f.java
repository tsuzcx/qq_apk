package com.tencent.mm.plugin.lite.a.b.a;

import com.tencent.liteapp.jsapi.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/lite/jsapi/bridge/appbrand/LiteAppJsApiAppBrandJsApiPool;", "", "()V", "mServiceAppBrandJsApi", "Ljava/util/HashMap;", "", "Lcom/tencent/liteapp/jsapi/WxaLiteAppJsApi;", "Lkotlin/collections/HashMap;", "addToPagePool", "", "api", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;", "addToServicePool", "createAppBrandPageJsApiPool", "createAppBrandServiceJsApiPool", "getLiteAppBridgeAppBrandJsApiPool", "Companion", "luggage-lite-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  public static final a JZR;
  public HashMap<String, a> JZS;
  
  static
  {
    AppMethodBeat.i(271569);
    JZR = new a((byte)0);
    AppMethodBeat.o(271569);
  }
  
  public f()
  {
    AppMethodBeat.i(271564);
    this.JZS = new HashMap();
    long l = System.currentTimeMillis();
    p localp = (p)new JsApiGetABTestConfig();
    s.u(localp, "api");
    this.JZS.put(localp.getName(), new e(localp));
    localp = (p)new com.tencent.mm.plugin.appbrand.jsapi.s.f();
    s.u(localp, "api");
    this.JZS.put(localp.getName(), new e(localp));
    Log.i("WxaLiteApp.LiteAppJsApiAppBrandJsApiPool", "init AppBrandServiceJsApiPool takes %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(271564);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/lite/jsapi/bridge/appbrand/LiteAppJsApiAppBrandJsApiPool$Companion;", "", "()V", "TAG", "", "luggage-lite-app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.a.b.a.f
 * JD-Core Version:    0.7.0.1
 */