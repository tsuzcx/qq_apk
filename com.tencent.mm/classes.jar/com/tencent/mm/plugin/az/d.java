package com.tencent.mm.plugin.az;

import com.tencent.mm.ad.i;
import com.tencent.mm.plugin.appbrand.appcache.q;
import com.tencent.mm.plugin.ay.c;
import com.tencent.mm.plugin.ay.c.a;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webprefetcher/WebPrefetcherJsEngineInterceptor;", "", "()V", "bizAppId", "", "getBizAppId", "()Ljava/lang/String;", "setBizAppId", "(Ljava/lang/String;)V", "contextMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getContextMap", "()Ljava/util/HashMap;", "setContextMap", "(Ljava/util/HashMap;)V", "jsEngine", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngine;", "getJsEngine", "()Lcom/tencent/mm/plugin/webjsengine/WebJsEngine;", "setJsEngine", "(Lcom/tencent/mm/plugin/webjsengine/WebJsEngine;)V", "attach", "", "Lcom/tencent/mm/plugin/webprefetcher/WebPrefetcherJsEngine;", "bizPkg", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "configPreFetcher", "id", "onCompleted", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJSContext;", "createBizJsContext", "", "type", "url", "dispatchEvent", "appId", "event", "data", "getClientInfo", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngine$ClientInfo;", "inject", "manifest", "Lcom/tencent/mm/plugin/webprefetcher/PrefetchManifest;", "script", "onCallback", "Companion", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class d
{
  public static final a Wnm = new a((byte)0);
  public HashMap<String, Integer> Wmr;
  public c Wnn;
  private String pjl = "";
  
  public boolean a(int paramInt, a parama, String paramString, b<? super String, ah> paramb)
  {
    s.u(parama, "manifest");
    s.u(paramString, "script");
    s.u(paramb, "onCallback");
    return false;
  }
  
  public q deF()
  {
    return null;
  }
  
  public final c ips()
  {
    c localc = this.Wnn;
    if (localc != null) {
      return localc;
    }
    s.bIx("jsEngine");
    return null;
  }
  
  public final HashMap<String, Integer> ipt()
  {
    HashMap localHashMap = this.Wmr;
    if (localHashMap != null) {
      return localHashMap;
    }
    s.bIx("contextMap");
    return null;
  }
  
  public boolean l(String paramString, b<? super Boolean, ah> paramb)
  {
    s.u(paramb, "onCompleted");
    return false;
  }
  
  public final c.a nP(String paramString1, String paramString2)
  {
    s.u(paramString1, "type");
    s.u(paramString2, "appId");
    return new c.a(paramString2, ips().big(paramString1).getLong("idKey"));
  }
  
  public boolean o(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    s.u(paramString3, "event");
    return false;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webprefetcher/WebPrefetcherJsEngineInterceptor$Companion;", "", "()V", "typeGameCenter", "", "typeVideo", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.az.d
 * JD-Core Version:    0.7.0.1
 */