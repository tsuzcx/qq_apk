package com.tencent.mm.plugin.ax;

import com.tencent.mm.ad.i;
import com.tencent.mm.plugin.aw.c;
import com.tencent.mm.plugin.aw.c.a;
import java.util.HashMap;
import kotlin.g.a.b;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webprefetcher/WebPrefetcherJsEngineInterceptor;", "", "()V", "bizAppId", "", "getBizAppId", "()Ljava/lang/String;", "setBizAppId", "(Ljava/lang/String;)V", "contextMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getContextMap", "()Ljava/util/HashMap;", "setContextMap", "(Ljava/util/HashMap;)V", "jsEngine", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngine;", "getJsEngine", "()Lcom/tencent/mm/plugin/webjsengine/WebJsEngine;", "setJsEngine", "(Lcom/tencent/mm/plugin/webjsengine/WebJsEngine;)V", "attach", "", "Lcom/tencent/mm/plugin/webprefetcher/WebPrefetcherJsEngine;", "bizPkg", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "configPreFetcher", "id", "onCompleted", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJSContext;", "createBizJsContext", "", "type", "url", "dispatchEvent", "appId", "event", "data", "getClientInfo", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngine$ClientInfo;", "inject", "manifest", "Lcom/tencent/mm/plugin/webprefetcher/PrefetchManifest;", "script", "onCallback", "Companion", "webview-sdk_release"})
public abstract class d
{
  public static final a Pxh = new a((byte)0);
  public HashMap<String, Integer> Pwb;
  public c Pxg;
  private String mpE = "";
  
  public boolean a(int paramInt, a parama, String paramString, b<? super String, x> paramb)
  {
    kotlin.g.b.p.k(parama, "manifest");
    kotlin.g.b.p.k(paramString, "script");
    kotlin.g.b.p.k(paramb, "onCallback");
    return false;
  }
  
  public com.tencent.mm.plugin.appbrand.appcache.p cBu()
  {
    return null;
  }
  
  public boolean g(String paramString, b<? super Boolean, x> paramb)
  {
    kotlin.g.b.p.k(paramb, "onCompleted");
    return false;
  }
  
  public final c gQb()
  {
    c localc = this.Pxg;
    if (localc == null) {
      kotlin.g.b.p.bGy("jsEngine");
    }
    return localc;
  }
  
  public final HashMap<String, Integer> gQc()
  {
    HashMap localHashMap = this.Pwb;
    if (localHashMap == null) {
      kotlin.g.b.p.bGy("contextMap");
    }
    return localHashMap;
  }
  
  public final c.a md(String paramString1, String paramString2)
  {
    kotlin.g.b.p.k(paramString1, "type");
    kotlin.g.b.p.k(paramString2, "appId");
    c localc = this.Pxg;
    if (localc == null) {
      kotlin.g.b.p.bGy("jsEngine");
    }
    return new c.a(paramString2, localc.biy(paramString1).getLong("idKey"));
  }
  
  public boolean o(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    kotlin.g.b.p.k(paramString3, "event");
    return false;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webprefetcher/WebPrefetcherJsEngineInterceptor$Companion;", "", "()V", "typeGameCenter", "", "typeVideo", "webview-sdk_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ax.d
 * JD-Core Version:    0.7.0.1
 */