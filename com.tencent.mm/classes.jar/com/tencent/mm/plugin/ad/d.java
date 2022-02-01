package com.tencent.mm.plugin.ad;

import com.tencent.mm.ab.i;
import com.tencent.mm.plugin.ac.c.a;
import java.util.HashMap;
import kotlin.g.a.b;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webprefetcher/WebPrefetcherJsEngineInterceptor;", "", "()V", "bizAppId", "", "getBizAppId", "()Ljava/lang/String;", "setBizAppId", "(Ljava/lang/String;)V", "contextMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getContextMap", "()Ljava/util/HashMap;", "setContextMap", "(Ljava/util/HashMap;)V", "jsEngine", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngine;", "getJsEngine", "()Lcom/tencent/mm/plugin/webjsengine/WebJsEngine;", "setJsEngine", "(Lcom/tencent/mm/plugin/webjsengine/WebJsEngine;)V", "attach", "", "Lcom/tencent/mm/plugin/webprefetcher/WebPrefetcherJsEngine;", "bizPkg", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "configPreFetcher", "id", "onCompleted", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJSContext;", "dispatchEvent", "", "appId", "url", "event", "data", "getClientInfo", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngine$ClientInfo;", "type", "inject", "manifest", "Lcom/tencent/mm/plugin/webprefetcher/PrefetchManifest;", "script", "onCallback", "Companion", "webview-sdk_release"})
public abstract class d
{
  public static final d.a ICR = new d.a((byte)0);
  public HashMap<String, Integer> IBO;
  public com.tencent.mm.plugin.ac.c ICQ;
  private String jzY = "";
  
  public boolean S(String paramString1, String paramString2, String paramString3)
  {
    kotlin.g.b.p.h(paramString2, "event");
    return false;
  }
  
  public boolean a(a parama, String paramString, b<? super String, x> paramb)
  {
    kotlin.g.b.p.h(parama, "manifest");
    kotlin.g.b.p.h(paramString, "script");
    kotlin.g.b.p.h(paramb, "onCallback");
    return false;
  }
  
  public final void b(c paramc)
  {
    kotlin.g.b.p.h(paramc, "jsEngine");
    this.ICQ = ((com.tencent.mm.plugin.ac.c)paramc);
    this.IBO = paramc.IBO;
  }
  
  public com.tencent.mm.plugin.appbrand.appcache.p cnt()
  {
    return null;
  }
  
  public final com.tencent.mm.plugin.ac.c fXo()
  {
    com.tencent.mm.plugin.ac.c localc = this.ICQ;
    if (localc == null) {
      kotlin.g.b.p.btv("jsEngine");
    }
    return localc;
  }
  
  public final HashMap<String, Integer> fXp()
  {
    HashMap localHashMap = this.IBO;
    if (localHashMap == null) {
      kotlin.g.b.p.btv("contextMap");
    }
    return localHashMap;
  }
  
  public final c.a lE(String paramString1, String paramString2)
  {
    kotlin.g.b.p.h(paramString1, "type");
    kotlin.g.b.p.h(paramString2, "appId");
    com.tencent.mm.plugin.ac.c localc = this.ICQ;
    if (localc == null) {
      kotlin.g.b.p.btv("jsEngine");
    }
    return new c.a(paramString2, localc.aWQ(paramString1).getLong("idKey"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ad.d
 * JD-Core Version:    0.7.0.1
 */