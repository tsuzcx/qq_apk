package com.tencent.mm.plugin.az;

import android.content.Context;
import android.net.Uri;
import android.webkit.ValueCallback;
import com.tencent.mapsdk.rastercore.tools.IO;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.q.a;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg.Info;
import com.tencent.mm.plugin.appbrand.n.g;
import com.tencent.mm.plugin.ay.c.b.a;
import com.tencent.mm.plugin.brandservice.api.h.c;
import com.tencent.mm.plugin.webview.jsapi.f;
import com.tencent.mm.protocal.protobuf.ccy;
import com.tencent.mm.protocal.protobuf.ccz;
import com.tencent.mm.protocal.protobuf.vn;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMKVSlotManager;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.vfs.y;
import com.tencent.smtt.sdk.MimeTypeMap;
import com.tencent.xweb.WebResourceResponse;
import java.io.Closeable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedDeque;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.a.ar;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webprefetcher/WebPrefetcherJsEngine;", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngine;", "()V", "TAG", "", "TAG$1", "contextMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getContextMap", "()Ljava/util/HashMap;", "engineReporter", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineReporter;", "getEngineReporter", "()Lcom/tencent/mm/plugin/webjsengine/WebJsEngineReporter;", "interceptors", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "Lcom/tencent/mm/plugin/webprefetcher/WebPrefetcherJsEngineInterceptor;", "getInterceptors", "()Ljava/util/concurrent/ConcurrentLinkedDeque;", "wxaPkg", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "getWxaPkg", "()Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "wxaPkg$delegate", "Lkotlin/Lazy;", "addInterceptor", "", "interceptor", "bizPkg", "appId", "hasAssets", "", "clearAll", "clearCache", "domain", "configWxPrefetcherClient", "jsRuntime", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;", "id", "create", "manifest", "Lcom/tencent/mm/plugin/webprefetcher/PrefetchManifest;", "onCompleted", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJSContext;", "createJsContext", "type", "url", "createPrefetcherJsContextInner", "pkg", "dispatchEvent", "event", "data", "forceRelease", "getClientConfig", "Lcom/tencent/mm/json/JSONObject;", "getClientInfo", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngine$ClientInfo;", "getEngineName", "inject", "script", "onCallback", "invoke", "func", "params", "", "", "(Lcom/tencent/mm/plugin/webprefetcher/PrefetchManifest;Ljava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callback", "onConfigClient", "onTransferMessage", "message", "targetOrigin", "Companion", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class c
  extends com.tencent.mm.plugin.ay.c
{
  private static final String TAG;
  public static final a WmU = new a((byte)0);
  private static final kotlin.j<Boolean> WmW = kotlin.k.cm((kotlin.g.a.a)b.Wnf);
  private static final b WmX = new b("wcf://WebPrefetchContent/");
  private static final b WmY = new b("wcf://WebPrefetchResource/");
  private static final b WmZ = new b("wcf://WebPrefetchManifest/");
  private static final Map<String, String> Wna = ak.e(new kotlin.r[] { kotlin.v.Y("js", "application/javascript"), kotlin.v.Y("json", "application/json") });
  private static final MMKVSlotManager vKT;
  private static final Set<String> vUV;
  private final kotlin.j Wku = kotlin.k.cm((kotlin.g.a.a)j.Wnk);
  public final ConcurrentLinkedDeque<d> WmV = new ConcurrentLinkedDeque();
  public final HashMap<String, Integer> Wmr;
  public final String mgf = "MicroMsg.WebPrefetcherJsEngine";
  private final com.tencent.mm.plugin.ay.e vVl = new com.tencent.mm.plugin.ay.e();
  
  static
  {
    TAG = "MicroMsg.WebPrefetcherJsEngine";
    vUV = ar.setOf("transfer-encoding");
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("__WebPrefetchLocalData__");
    s.s(localMultiProcessMMKV, "getMMKV(\"__WebPrefetchLocalData__\")");
    vKT = new MMKVSlotManager(localMultiProcessMMKV, 15552000L);
  }
  
  public c()
  {
    com.tencent.mm.plugin.ax.i locali = new com.tencent.mm.plugin.ax.i((com.tencent.mm.plugin.ax.c)this);
    g localg = czi();
    s.s(localg, "mainJsContext");
    locali.l((com.tencent.mm.plugin.appbrand.n.i)localg);
    com.tencent.mm.plugin.ay.c.a((com.tencent.mm.plugin.ay.c)this);
    new q.a()
    {
      private com.tencent.threadpool.i.d<?> Wnb;
      private transient boolean mUq;
      
      private static final void a(c paramAnonymousc, 1 paramAnonymous1)
      {
        AppMethodBeat.i(261010);
        s.u(paramAnonymousc, "this$0");
        s.u(paramAnonymous1, "this$1");
        Log.i(c.a(paramAnonymousc), s.X("onAppBackground delay run isBackground: %s, hashCode: ", Integer.valueOf(paramAnonymous1.hashCode())), new Object[] { Boolean.valueOf(paramAnonymous1.mUq) });
        if (paramAnonymous1.mUq) {
          paramAnonymousc.pause();
        }
        AppMethodBeat.o(261010);
      }
      
      private final void ipq()
      {
        AppMethodBeat.i(261002);
        com.tencent.threadpool.i.d locald = this.Wnb;
        if (locald != null) {
          locald.cancel(false);
        }
        this.Wnb = null;
        AppMethodBeat.o(261002);
      }
      
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(261023);
        s.u(paramAnonymousString, "activity");
        Log.i(c.a(this.Wnc), s.X("onAppBackground delay pause hashCode: ", Integer.valueOf(hashCode())));
        this.mUq = true;
        ipq();
        this.Wnb = com.tencent.threadpool.h.ahAA.p(new c.1..ExternalSyntheticLambda0(this.Wnc, this), 30000L);
        AppMethodBeat.o(261023);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(261018);
        s.u(paramAnonymousString, "activity");
        Log.i(c.a(this.Wnc), "jsEngine resume");
        this.mUq = false;
        ipq();
        this.Wnc.resume();
        AppMethodBeat.o(261018);
      }
    }.alive();
    this.Wmr = new HashMap();
  }
  
  private static final void a(c paramc, String paramString1, g paramg, String paramString2, String paramString3, kotlin.g.a.b paramb, String paramString4)
  {
    s.u(paramc, "this$0");
    s.u(paramString1, "$prefetchId");
    s.u(paramString3, "$path");
    ((Map)paramc.Wmr).put(paramString1, Integer.valueOf(paramg.czh()));
    Log.i(paramc.mgf, "createPrefetcherJsContext end prefetcherId: " + paramString1 + ", " + paramString2 + ", " + paramString3 + ", contextId: " + paramg.czh() + ", " + paramg.hashCode());
    if (paramb != null)
    {
      s.s(paramg, "this");
      paramb.invoke(paramg);
    }
  }
  
  private static final void a(c paramc, String paramString1, g paramg, String paramString2, kotlin.g.a.b paramb, String paramString3)
  {
    s.u(paramc, "this$0");
    s.u(paramString1, "$id");
    s.u(paramb, "$onCompleted");
    ((Map)paramc.Wmr).put(paramString1, Integer.valueOf(paramg.czh()));
    s.s(paramString2, "domain");
    paramc.aft(paramString2);
    s.s(paramg, "this@apply");
    paramb.invoke(paramg);
    Log.v(paramc.mgf, "create domain:" + paramString2 + '#' + paramString1 + " end");
  }
  
  private final void a(String paramString, a parama, kotlin.g.a.b<? super g, ah> paramb)
  {
    String str1 = parama.WmS.aamn;
    Object localObject1 = (CharSequence)parama.WmT.aamu;
    int i;
    Object localObject2;
    label91:
    String str2;
    if ((localObject1 == null) || (n.bp((CharSequence)localObject1)))
    {
      i = 1;
      if (i != 0) {
        break label434;
      }
      localObject1 = WmZ;
      localObject2 = parama.WmT.aamu;
      s.s(localObject2, "manifest.manifest.ManifestUrl");
      localObject1 = ((b)localObject1).bii(e.bim((String)localObject2));
      if (!((com.tencent.mm.vfs.u)localObject1).jKS()) {
        break label434;
      }
      localObject1 = com.tencent.mm.vfs.v.an((com.tencent.mm.vfs.u)localObject1);
      str2 = e.a(parama);
      Log.i(this.mgf, "create domain:" + str1 + '#' + paramString + ", appId: " + str2);
      localObject2 = null;
    }
    for (;;)
    {
      label434:
      Object localObject4;
      try
      {
        for (;;)
        {
          i = ((CharSequence)str2).length();
          Object localObject3;
          if (i > 0)
          {
            i = 1;
            localObject3 = localObject2;
            if (i == 0) {}
          }
          try
          {
            localObject3 = bij(str2);
            g localg = this.sSV.czj();
            s.s(localg, "this");
            b((com.tencent.mm.plugin.appbrand.n.i)localg, paramString, str2);
            localObject2 = (CharSequence)parama.WmT.oOI;
            if (localObject2 == null) {
              break label605;
            }
            if (((CharSequence)localObject2).length() == 0)
            {
              break label605;
              if (i != 0) {
                break label534;
              }
              localObject2 = parama.WmT.oOI;
              com.tencent.mm.plugin.ay.c localc = (com.tencent.mm.plugin.ay.c)this;
              String str3 = s.X("WebPrefetcherManifest#", paramString);
              s.s(localObject2, "reportId");
              com.tencent.mm.plugin.ay.c.a(localc, localg, str3, "manifest", null, new com.tencent.mm.plugin.ay.c.a((String)localObject2, 1630L), 8);
              localObject2 = localObject1;
              if (parama.debug)
              {
                if (localObject3 != null) {
                  break label557;
                }
                parama = "";
                localObject2 = s.X((String)localObject1, parama);
              }
              localg.evaluateJavascript((String)localObject2, new c..ExternalSyntheticLambda1(this, paramString, localg, str1, paramb));
              if (localObject3 == null) {
                break label582;
              }
              Log.v(this.mgf, "createPrefetcherJsContext :" + str2 + '#' + paramString);
              a((com.tencent.mm.plugin.appbrand.appcache.q)localObject3, str2, null);
              if (localObject3 != null)
              {
                if (!(localObject3 instanceof Closeable)) {
                  break label600;
                }
                parama = (Closeable)localObject3;
                IO.safeClose(parama);
              }
              return;
              i = 0;
              break;
              localObject1 = "";
              break label91;
              i = 0;
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              Log.e(this.mgf, "create bizPkg ex:" + str2 + '#' + paramString + ' ' + localException.getMessage());
              localObject4 = localObject2;
            }
          }
        }
        i = 0;
      }
      catch (Exception parama)
      {
        Log.printErrStackTrace(this.mgf, (Throwable)parama, s.X("create id=", paramString), new Object[0]);
        return;
      }
      continue;
      label534:
      localObject2 = (CharSequence)str1;
      if (localObject2 != null)
      {
        if (!n.bp((CharSequence)localObject2)) {
          break label626;
        }
        break label611;
        label557:
        localObject2 = com.tencent.mm.plugin.appbrand.appcache.r.b(localObject4, "/manifest.js");
        parama = (a)localObject2;
        if (localObject2 != null) {
          continue;
        }
        parama = "";
        continue;
        label582:
        Log.w(this.mgf, s.X("createPrefetcherJsContext pkg is null and ignore appId: ", str2));
        continue;
        label600:
        parama = null;
        continue;
        label605:
        i = 1;
        continue;
      }
      label611:
      label626:
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          break label632;
        }
        localObject2 = str1;
        break;
      }
      label632:
      localObject2 = "manifest";
    }
  }
  
  private final void b(com.tencent.mm.plugin.appbrand.n.i parami, String paramString1, final String paramString2)
  {
    new com.tencent.mm.plugin.ax.p((com.tencent.mm.plugin.ax.q)new d(paramString1, paramString2, this)).l(parami);
  }
  
  private final void c(com.tencent.mm.plugin.appbrand.n.i parami, String paramString1, final String paramString2)
  {
    b(parami, paramString1, paramString2);
    new com.tencent.mm.plugin.ax.j((com.tencent.mm.plugin.ax.k)new i(this, paramString2)).l(parami);
  }
  
  private com.tencent.mm.plugin.ay.c.a nP(String paramString1, String paramString2)
  {
    s.u(paramString1, "type");
    s.u(paramString2, "appId");
    return new com.tencent.mm.plugin.ay.c.a(paramString2, big(paramString1).getLong("idKey"));
  }
  
  public final Object a(a parama, String paramString, List<? extends Object> paramList, kotlin.d.d<? super String> paramd)
  {
    kotlin.d.h localh = new kotlin.d.h(kotlin.d.a.b.au(paramd));
    a(parama, paramString, paramList, (kotlin.g.a.b)new h((kotlin.d.d)localh));
    parama = localh.kli();
    if (parama == kotlin.d.a.a.aiwj) {
      s.u(paramd, "frame");
    }
    return parama;
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.appcache.q paramq, String paramString, kotlin.g.a.b<? super g, ah> paramb)
  {
    Object localObject1 = (CharSequence)paramString;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0))
    {
      i = 1;
      if (i == 0) {
        break label36;
      }
    }
    label36:
    Object localObject2;
    do
    {
      return;
      i = 0;
      break;
      localObject1 = e.bin(paramString);
      if (!this.Wmr.containsKey(localObject1)) {
        break label111;
      }
      localObject2 = this.Wmr.get(localObject1);
      s.checkNotNull(localObject2);
      s.s(localObject2, "contextMap[prefetchId]!!");
      localObject2 = BK(((Number)localObject2).intValue());
      if (localObject2 == null) {
        break label111;
      }
    } while (paramb == null);
    paramb.invoke(localObject2);
    return;
    label111:
    paramq = com.tencent.mm.plugin.appbrand.appcache.r.b(paramq, "/prefetcher.js");
    if (((CharSequence)paramq).length() > 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      localObject2 = this.sSV.czj();
      s.s(localObject2, "this");
      c((com.tencent.mm.plugin.appbrand.n.i)localObject2, (String)localObject1, paramString);
      com.tencent.mm.plugin.ay.c.a((com.tencent.mm.plugin.ay.c)this, (g)localObject2, s.X("WebPrefetcher#", paramString), "prefetcher", null, nP("prefetcher", paramString), 8);
      ((g)localObject2).evaluateJavascript(paramq, new c..ExternalSyntheticLambda0(this, (String)localObject1, (g)localObject2, paramString, "/prefetcher.js", paramb));
      return;
    }
    Log.w(this.mgf, s.X("createPrefetcherJsContext prefetcherJs is empty, appId: ", paramString));
  }
  
  public final void a(a parama, final String paramString, final List<? extends Object> paramList, final kotlin.g.a.b<? super String, ah> paramb)
  {
    s.u(parama, "manifest");
    s.u(paramString, "func");
    s.u(paramb, "callback");
    final String str = e.bim(e.a(parama) + '-' + parama.WmT.aamu);
    if (!this.Wmr.containsKey(str))
    {
      a(str, parama, (kotlin.g.a.b)new g(this, str, paramString, paramList, paramb));
      return;
    }
    a(str, paramString, paramList, paramb);
  }
  
  public final void a(a parama, String paramString, kotlin.g.a.b<? super String, ah> paramb)
  {
    s.u(parama, "manifest");
    s.u(paramString, "script");
    s.u(paramb, "onCallback");
    Iterator localIterator = ((Iterable)this.WmV).iterator();
    while ((localIterator.hasNext()) && (!((d)localIterator.next()).a(1, parama, paramString, paramb))) {}
  }
  
  public final void a(d paramd)
  {
    s.u(paramd, "interceptor");
    s.u(this, "jsEngine");
    Object localObject = (com.tencent.mm.plugin.ay.c)this;
    s.u(localObject, "<set-?>");
    paramd.Wnn = ((com.tencent.mm.plugin.ay.c)localObject);
    localObject = this.Wmr;
    s.u(localObject, "<set-?>");
    paramd.Wmr = ((HashMap)localObject);
    this.WmV.add(paramd);
  }
  
  public abstract void aft(String paramString);
  
  public final com.tencent.mm.plugin.ay.c.a bhQ(String paramString)
  {
    s.u(paramString, "type");
    return new com.tencent.mm.plugin.ay.c.a("wx97b7aebac2183fd2", big(paramString).getLong("idKey"));
  }
  
  public final com.tencent.mm.ad.i big(String paramString)
  {
    s.u(paramString, "type");
    paramString = ioE().Fs("client").Fs(paramString);
    s.s(paramString, "vmConfig.getJSONObject(\"…ent\").getJSONObject(type)");
    return paramString;
  }
  
  public final com.tencent.mm.plugin.appbrand.appcache.q bij(String paramString)
  {
    boolean bool = true;
    String str = "prefetcher/" + paramString + ".wspkg";
    com.tencent.mm.plugin.webcanvas.k localk = com.tencent.mm.plugin.webcanvas.k.WkZ;
    if (com.tencent.mm.plugin.webcanvas.k.hBF() == 1) {}
    for (;;)
    {
      return com.tencent.mm.plugin.ay.c.b.a(com.tencent.mm.plugin.ay.c.b.b(str, bool, com.tencent.mm.plugin.ay.c.b.bih(paramString), paramString), (kotlin.g.a.q)new c(this), null, false, 4);
      bool = false;
    }
  }
  
  public final String ddM()
  {
    return "WebPrefetcherJsEngine";
  }
  
  public final com.tencent.mm.plugin.ay.e iow()
  {
    return this.vVl;
  }
  
  public final com.tencent.mm.plugin.appbrand.appcache.q iox()
  {
    return (com.tencent.mm.plugin.appbrand.appcache.q)this.Wku.getValue();
  }
  
  public final void nI(String paramString1, String paramString2)
  {
    s.u(paramString1, "message");
    s.u(paramString2, "targetOrigin");
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webprefetcher/WebPrefetcherJsEngine$Companion;", "", "()V", "BACKGROUND_PAUSE_DELAY_MS", "", "HEADER_TRANSFER_ENCODING", "", "TAG", "WEB_PREFECHER_INVALID_HEADERS", "", "getWEB_PREFECHER_INVALID_HEADERS", "()Ljava/util/Set;", "kvSlot", "Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "getKvSlot", "()Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "manifestContent", "Lcom/tencent/mm/plugin/webprefetcher/WebPrefetcherFile;", "getManifestContent", "()Lcom/tencent/mm/plugin/webprefetcher/WebPrefetcherFile;", "mimeMap", "", "prefetchBasePkgAppId", "prefetchUsePkgOpen", "", "getPrefetchUsePkgOpen", "()Z", "prefetchUsePkgOpen$delegate", "Lkotlin/Lazy;", "resContent", "getResContent", "webContent", "getWebContent", "getMimeType", "uri", "Landroid/net/Uri;", "getMinPkgVersion", "", "appId", "match", "Lcom/tencent/mm/plugin/webprefetcher/PrefetchManifest;", "url", "settingManager", "matchDebugManifest", "host", "matchResource", "Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService$PrefetchWebResourceResponseWrapper;", "isForMainFrame", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService$PrefetchWebResourceResponseWrapper;", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static a a(String paramString, MMKVSlotManager paramMMKVSlotManager)
    {
      AppMethodBeat.i(260993);
      s.u(paramString, "url");
      s.u(paramMMKVSlotManager, "settingManager");
      Uri localUri = Uri.parse(paramString);
      Object localObject1 = bik(localUri.getHost());
      if (localObject1 != null)
      {
        Log.i(c.access$getTAG$cp(), s.X("matchDebug:", localUri));
        AppMethodBeat.o(260993);
        return localObject1;
      }
      localObject1 = e.bim(String.valueOf(localUri.getHost()));
      paramMMKVSlotManager = (MultiProcessMMKV)paramMMKVSlotManager.findSlot((String)localObject1);
      Object localObject2;
      if (paramMMKVSlotManager == null)
      {
        paramMMKVSlotManager = null;
        paramMMKVSlotManager = (ccy)paramMMKVSlotManager;
        if (paramMMKVSlotManager != null)
        {
          localObject2 = paramMMKVSlotManager.aams;
          s.s(localObject2, "ResInfos");
          localObject2 = ((Iterable)localObject2).iterator();
        }
      }
      else
      {
        for (;;)
        {
          if (!((Iterator)localObject2).hasNext()) {
            break label440;
          }
          ccz localccz = (ccz)((Iterator)localObject2).next();
          Object localObject3;
          String str;
          if (localUri != null)
          {
            localObject3 = localUri.getPath();
            if (localObject3 != null)
            {
              str = localccz.IcT;
              s.s(str, "res.Path");
              if (com.tencent.luggage.l.c.L((String)localObject3, str) != true) {}
            }
          }
          for (int i = 1;; i = 0)
          {
            if (i == 0) {
              break label398;
            }
            localObject3 = c.WmU;
            localObject3 = c.ipo();
            str = localccz.aamu;
            s.s(str, "res.ManifestUrl");
            if (!((b)localObject3).bii(e.bim(str)).jKS()) {
              break label400;
            }
            Log.v(c.access$getTAG$cp(), "match:#" + (String)localObject1 + ", " + localccz.IcT + ", " + paramString);
            s.s(localccz, "res");
            paramString = new a(paramMMKVSlotManager, localccz, false, 60);
            AppMethodBeat.o(260993);
            return paramString;
            if (paramMMKVSlotManager.containsKey((String)localObject1))
            {
              paramMMKVSlotManager = paramMMKVSlotManager.decodeBytes((String)localObject1);
              if (paramMMKVSlotManager != null)
              {
                if (paramMMKVSlotManager.length == 0)
                {
                  i = 1;
                  label326:
                  if (i != 0) {
                    break label367;
                  }
                }
                for (i = 1;; i = 0)
                {
                  for (;;)
                  {
                    if (i == 0) {
                      break label390;
                    }
                    try
                    {
                      localObject2 = ccy.class.newInstance();
                      ((com.tencent.mm.bx.a)localObject2).parseFrom(paramMMKVSlotManager);
                      paramMMKVSlotManager = (com.tencent.mm.bx.a)localObject2;
                    }
                    catch (Exception paramMMKVSlotManager)
                    {
                      label367:
                      Log.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", (Throwable)paramMMKVSlotManager, "decode ProtoBuffer", new Object[0]);
                    }
                  }
                  i = 0;
                  break label326;
                }
              }
            }
            label390:
            paramMMKVSlotManager = null;
            break;
          }
          label398:
          continue;
          label400:
          Log.w(c.access$getTAG$cp(), "manifest lost:#" + (String)localObject1 + ", " + localccz.IcT);
        }
      }
      label440:
      Log.v(c.access$getTAG$cp(), "not match:#" + (String)localObject1 + ", " + paramString);
      AppMethodBeat.o(260993);
      return null;
    }
    
    public static h.c a(String paramString1, String paramString2, Boolean paramBoolean)
    {
      AppMethodBeat.i(261026);
      s.u(paramString2, "url");
      if (!ipr())
      {
        AppMethodBeat.o(261026);
        return null;
      }
      Object localObject1 = (CharSequence)paramString1;
      if ((localObject1 == null) || (n.bp((CharSequence)localObject1))) {}
      for (int i = 1; i != 0; i = 0)
      {
        Log.d(c.access$getTAG$cp(), s.X("matchResource fail appId=", paramString1));
        AppMethodBeat.o(261026);
        return null;
      }
      Object localObject4 = Uri.parse(paramString2);
      localObject1 = com.tencent.mm.plugin.ay.c.Wmq;
      localObject1 = com.tencent.mm.plugin.ay.c.b.bih(paramString1);
      Object localObject2;
      Object localObject3;
      boolean bool;
      com.tencent.mm.plugin.appbrand.appcache.q localq;
      int j;
      try
      {
        localObject2 = com.tencent.mm.plugin.ay.c.Wmq;
        localObject2 = "prefetcher/" + paramString1 + ".wspkg";
        localObject3 = com.tencent.mm.plugin.webcanvas.k.WkZ;
        if (com.tencent.mm.plugin.webcanvas.k.hBF() != 1) {
          break label1171;
        }
        bool = true;
        localObject1 = com.tencent.mm.plugin.ay.c.b.b((String)localObject2, bool, (String)localObject1, paramString1);
        if (!y.ZC(((c.b.a)localObject1).eBX)) {
          break label696;
        }
        localObject2 = com.tencent.mm.plugin.ay.c.Wmq;
        localq = com.tencent.mm.plugin.ay.c.b.a((c.b.a)localObject1, (kotlin.g.a.q)b.Wne, null, false, 4);
        j = com.tencent.mm.plugin.webview.l.a.h(localq);
        i = bil(paramString1);
        if (j < i)
        {
          Log.i(c.access$getTAG$cp(), "matchResource fail, pkgVersion=" + j + ", minPkgVersion=" + i);
          AppMethodBeat.o(261026);
          return null;
        }
        localObject3 = localq.openReadPartialInfo("/resources/" + ((Uri)localObject4).getHost() + ((Uri)localObject4).getPath());
        if (localObject3 != null) {
          break label1168;
        }
        localObject1 = com.tencent.mm.plugin.ay.c.Wmq;
        s.u(localq, "pkg");
        localObject2 = (com.tencent.mm.ad.i)com.tencent.mm.plugin.ay.c.iph().ct(localq.cfJ());
        localObject1 = localObject2;
        if (localObject2 != null) {
          break label1177;
        }
        localObject1 = com.tencent.mm.plugin.webview.l.a.g(localq);
        com.tencent.mm.plugin.ay.c.iph().B(localq.cfJ(), localObject1);
      }
      catch (Exception paramString1)
      {
        label351:
        label366:
        Log.printErrStackTrace(c.access$getTAG$cp(), (Throwable)paramString1, "matchResource exception", new Object[0]);
        label405:
        label546:
        label622:
        AppMethodBeat.o(261026);
        label520:
        label696:
        return null;
      }
      if (((CharSequence)localObject1).length() > 0)
      {
        i = 1;
        if (i != 0)
        {
          localObject3 = localq.openReadPartialInfo("/resources/" + ((Uri)localObject4).getHost() + (String)localObject1);
          if (s.p(paramBoolean, Boolean.TRUE)) {
            Log.i(c.access$getTAG$cp(), "matchResource appId: " + paramString1 + ", isForMainFrame: " + paramBoolean + ", resInfo: " + localObject3 + ", pkgVersion: " + j + ", url: %s", new Object[] { paramString2 });
          }
          if (localObject3 != null)
          {
            localObject1 = c.WmU;
            s.s(localObject4, "uri");
            localObject1 = MimeTypeMap.getFileExtensionFromUrl(((Uri)localObject4).toString());
            if (localObject1 != null) {
              break label765;
            }
            localObject2 = null;
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              localObject1 = ((Uri)localObject4).getPath();
              if (localObject1 != null) {
                break label778;
              }
              localObject1 = "text/plain";
            }
          }
          for (;;)
          {
            localObject4 = new HashMap();
            Object localObject5 = localq.openReadPartialInfo(s.X(((WxaPkg.Info)localObject3).fileName, ".headers"));
            localObject2 = localObject1;
            if (localObject5 == null) {
              break label979;
            }
            localObject2 = ((WxaPkg.Info)localObject5).fileName;
            s.s(localObject2, "it.fileName");
            localObject5 = ((Iterable)n.bw((CharSequence)com.tencent.mm.plugin.appbrand.appcache.r.a(localq, (String)localObject2))).iterator();
            if (!((Iterator)localObject5).hasNext()) {
              break label1209;
            }
            localObject2 = (String)((Iterator)localObject5).next();
            str = n.rt((String)localObject2, ":");
            if (str != null) {
              break label829;
            }
            paramString1 = new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
            AppMethodBeat.o(261026);
            throw paramString1;
            label704:
            localObject1 = ((com.tencent.mm.ad.i)localObject1).Ft("file");
            break label1185;
            label717:
            localObject1 = ((com.tencent.mm.ad.i)localObject1).Ft(paramString2);
            if (localObject1 == null)
            {
              localObject1 = "";
              break;
            }
            localObject2 = ((com.tencent.mm.ad.i)localObject1).optString("path");
            localObject1 = localObject2;
            if (localObject2 != null) {
              break;
            }
            localObject1 = "";
            break;
            label765:
            localObject2 = MimeTypeMap.getSingleton().getMimeTypeFromExtension((String)localObject1);
            break label520;
            label778:
            localObject1 = n.rw((String)localObject1, ".");
            if (localObject1 == null)
            {
              localObject1 = "text/plain";
            }
            else
            {
              localObject1 = (String)c.ipp().get(localObject1);
              if (localObject1 != null) {
                break label1203;
              }
              localObject1 = "text/plain";
            }
          }
          label829:
          String str = n.bq((CharSequence)str).toString();
          if (str == null)
          {
            paramString1 = new NullPointerException("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(261026);
            throw paramString1;
          }
          str = str.toLowerCase();
          s.s(str, "(this as java.lang.String).toLowerCase()");
          localObject2 = n.rv((String)localObject2, ":");
          if (localObject2 == null)
          {
            paramString1 = new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
            AppMethodBeat.o(261026);
            throw paramString1;
          }
          localObject2 = n.bq((CharSequence)localObject2).toString();
          a locala = c.WmU;
          if (!c.ipj().contains(str)) {
            ((Map)localObject4).put(str, localObject2);
          }
          if (s.p(str, "content-type"))
          {
            localObject1 = localObject2;
            break label1206;
          }
        }
      }
      for (;;)
      {
        label979:
        s.p(paramBoolean, Boolean.TRUE);
        Log.v(c.access$getTAG$cp(), "matchResource appId: " + paramString1 + ", fileName: " + ((WxaPkg.Info)localObject3).fileName + ", pkgVersion: " + j + ", url: %s", new Object[] { paramString2 });
        paramString2 = new h.c();
        paramString2.pkgVersion = j;
        paramBoolean = com.tencent.mm.plugin.webcanvas.k.WkZ;
        paramString1 = com.tencent.mm.plugin.webcanvas.k.bic(paramString1);
        if (paramString1 == null)
        {
          paramString1 = null;
          paramString2.vBj = paramString1;
          paramBoolean = new WebResourceResponse((String)localObject2, null, 200, "OK", (Map)localObject4, localq.Va(((WxaPkg.Info)localObject3).fileName));
          if (!(localq instanceof Closeable)) {
            break label1160;
          }
        }
        label1160:
        for (paramString1 = (Closeable)localq;; paramString1 = null)
        {
          IO.safeClose(paramString1);
          paramString1 = ah.aiuX;
          paramString2.vBi = paramBoolean;
          AppMethodBeat.o(261026);
          return paramString2;
          paramString1 = paramString1.Zbk;
          break;
        }
        break label1206;
        label1168:
        break label405;
        label1171:
        bool = false;
        break;
        label1177:
        if (localObject1 != null) {
          break label704;
        }
        localObject1 = null;
        label1185:
        if (localObject1 != null) {
          break label717;
        }
        localObject1 = "";
        break label351;
        i = 0;
        break label366;
        label1203:
        break label546;
        label1206:
        break label622;
        label1209:
        localObject2 = localObject1;
      }
    }
    
    public static a bik(String paramString)
    {
      AppMethodBeat.i(261003);
      if ((!BuildInfo.DEBUG) && (!BuildInfo.IS_FLAVOR_RED) && (!WeChatEnvironment.hasDebugger()))
      {
        AppMethodBeat.o(261003);
        return null;
      }
      Object localObject1 = com.tencent.mm.plugin.ay.c.Wmq;
      localObject1 = com.tencent.mm.plugin.ay.c.b.b("prefetcher/" + paramString + ".wspkg", true, "", "matchDebugManifest");
      if (y.ZC(((c.b.a)localObject1).eBX))
      {
        Log.i(c.access$getTAG$cp(), "matchDebugManifest " + paramString + " path=" + ((c.b.a)localObject1).eBX);
        try
        {
          Object localObject2 = com.tencent.mm.plugin.ay.c.Wmq;
          localObject2 = new com.tencent.mm.ad.i(com.tencent.mm.plugin.appbrand.appcache.r.a(com.tencent.mm.plugin.ay.c.b.a((c.b.a)localObject1, (kotlin.g.a.q)a.Wnd, null, false, 4), "/config.json"));
          localObject1 = new ccy();
          ((ccy)localObject1).aamn = ((com.tencent.mm.ad.i)localObject2).optString("domain");
          Object localObject3 = ah.aiuX;
          localObject3 = new ccz();
          ((ccz)localObject3).IcT = ((com.tencent.mm.ad.i)localObject2).optString("path");
          ((ccz)localObject3).oOI = paramString;
          ((ccz)localObject3).aamu = ((com.tencent.mm.ad.i)localObject2).optString("manifest");
          paramString = ah.aiuX;
          paramString = new a((ccy)localObject1, (ccz)localObject3, true, 28);
          AppMethodBeat.o(261003);
          return paramString;
        }
        catch (Exception paramString)
        {
          Log.printErrStackTrace(c.access$getTAG$cp(), (Throwable)paramString, "matchDebugManifest", new Object[0]);
        }
      }
      AppMethodBeat.o(261003);
      return null;
    }
    
    private static int bil(String paramString)
    {
      AppMethodBeat.i(261009);
      try
      {
        i = c.ipk().decodeInt(s.X(paramString, "-MinBizPkgVersion"), 0);
        AppMethodBeat.o(261009);
        return i;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace(c.access$getTAG$cp(), (Throwable)localException, s.X("getMinPkgVersion:", paramString), new Object[0]);
          int i = 0;
        }
      }
    }
    
    public static boolean ipr()
    {
      AppMethodBeat.i(260977);
      boolean bool = ((Boolean)c.ipl().getValue()).booleanValue();
      AppMethodBeat.o(260977);
      return bool;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "<anonymous parameter 2>", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends kotlin.g.b.u
      implements kotlin.g.a.q<Integer, Integer, com.tencent.mm.plugin.appbrand.appcache.q, Boolean>
    {
      public static final a Wnd;
      
      static
      {
        AppMethodBeat.i(260968);
        Wnd = new a();
        AppMethodBeat.o(260968);
      }
      
      a()
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "<anonymous parameter 2>", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends kotlin.g.b.u
      implements kotlin.g.a.q<Integer, Integer, com.tencent.mm.plugin.appbrand.appcache.q, Boolean>
    {
      public static final b Wne;
      
      static
      {
        AppMethodBeat.i(260967);
        Wne = new b();
        AppMethodBeat.o(260967);
      }
      
      b()
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.g.b.u
    implements kotlin.g.a.a<Boolean>
  {
    public static final b Wnf;
    
    static
    {
      AppMethodBeat.i(260982);
      Wnf = new b();
      AppMethodBeat.o(260982);
    }
    
    b()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "assetsVersion", "", "resVersion", "resPkg", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.g.b.u
    implements kotlin.g.a.q<Integer, Integer, com.tencent.mm.plugin.appbrand.appcache.q, Boolean>
  {
    c(c paramc)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/webprefetcher/WebPrefetcherJsEngine$configWxPrefetcherClient$1", "Lcom/tencent/mm/plugin/webjsapi/WxPrefetcherClientContext;", "id", "", "getId", "()Ljava/lang/String;", "dispatch", "", "eventType", "event", "cb", "Landroid/webkit/ValueCallback;", "setMinBizPkgVersion", "version", "", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements com.tencent.mm.plugin.ax.q
  {
    private final String id;
    
    d(String paramString1, String paramString2, c paramc)
    {
      AppMethodBeat.i(260972);
      this.id = this.vQo;
      AppMethodBeat.o(260972);
    }
    
    public final void b(String paramString1, String paramString2, ValueCallback<String> paramValueCallback)
    {
      AppMethodBeat.i(260994);
      s.u(paramString1, "eventType");
      s.u(paramString2, "event");
      jdField_this.b(paramString1, paramString2, paramValueCallback);
      AppMethodBeat.o(260994);
    }
    
    public final String getId()
    {
      return this.id;
    }
    
    public final void setMinBizPkgVersion(int paramInt)
    {
      AppMethodBeat.i(260986);
      try
      {
        c.a locala = c.WmU;
        ((MultiProcessMMKV)c.ipk().getSlotForWrite()).encode(s.X(paramString2, "-MinBizPkgVersion"), paramInt);
        Log.d(c.a(jdField_this), "setMinBizPkgVersion:" + paramString2 + ", " + paramInt);
        AppMethodBeat.o(260986);
        return;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace(c.a(jdField_this), (Throwable)localException, "setMinBizPkgVersion:" + paramString2 + ", " + paramInt, new Object[0]);
        AppMethodBeat.o(260986);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJSContext;"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class e
    extends kotlin.g.b.u
    implements kotlin.g.a.b<g, ah>
  {
    public e(kotlin.g.a.b<? super String, ah> paramb, String paramString)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "prefetchId", ""}, k=3, mv={1, 5, 1}, xi=48)
  public static final class f
    extends kotlin.g.b.u
    implements kotlin.g.a.b<String, ah>
  {
    public f(String paramString1, c paramc, String paramString2)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "cxt", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJSContext;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends kotlin.g.b.u
    implements kotlin.g.a.b<g, ah>
  {
    g(c paramc, String paramString1, String paramString2, List<? extends Object> paramList, kotlin.g.a.b<? super String, ah> paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends kotlin.g.b.u
    implements kotlin.g.a.b<String, ah>
  {
    h(kotlin.d.d<? super String> paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/webprefetcher/WebPrefetcherJsEngine$onConfigClient$1", "Lcom/tencent/mm/plugin/webjsapi/WxJsEngineContextAPIContext;", "basePkgVersion", "", "getBasePkgVersion", "()I", "bizPkgVersion", "getBizPkgVersion", "jsApiHandler", "Lcom/tencent/mm/plugin/webview/jsapi/IWebCanvasJsApiHandler;", "getJsApiHandler", "()Lcom/tencent/mm/plugin/webview/jsapi/IWebCanvasJsApiHandler;", "dispatch", "", "eventType", "", "event", "cb", "Landroid/webkit/ValueCallback;", "getLocalData", "key", "onInvoke", "func", "message", "setLocalData", "data", "validCgi", "", "cmdId", "cgiUrl", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class i
    implements com.tencent.mm.plugin.ax.k
  {
    i(c paramc, String paramString) {}
    
    public final boolean aS(int paramInt, String paramString)
    {
      AppMethodBeat.i(260992);
      s.u(paramString, "cgiUrl");
      AppMethodBeat.o(260992);
      return false;
    }
    
    public final void b(String paramString1, String paramString2, ValueCallback<String> paramValueCallback)
    {
      AppMethodBeat.i(261019);
      s.u(paramString1, "eventType");
      s.u(paramString2, "event");
      this.Wnc.b(paramString1, paramString2, paramValueCallback);
      AppMethodBeat.o(261019);
    }
    
    public final f ddL()
    {
      AppMethodBeat.i(261012);
      f localf = (f)new a();
      AppMethodBeat.o(261012);
      return localf;
    }
    
    public final void fM(String paramString1, String paramString2)
    {
      AppMethodBeat.i(261016);
      s.u(paramString1, "func");
      s.u(paramString2, "message");
      AppMethodBeat.o(261016);
    }
    
    public final int getBasePkgVersion()
    {
      AppMethodBeat.i(260980);
      int i = com.tencent.mm.plugin.webview.l.a.h(this.Wnc.iox());
      AppMethodBeat.o(260980);
      return i;
    }
    
    public final int getBizPkgVersion()
    {
      AppMethodBeat.i(260987);
      Object localObject = c.a(this.Wnc, paramString2);
      int i = com.tencent.mm.plugin.webview.l.a.h((com.tencent.mm.plugin.appbrand.appcache.q)localObject);
      if ((localObject instanceof Closeable)) {}
      for (localObject = (Closeable)localObject;; localObject = null)
      {
        IO.safeClose((Closeable)localObject);
        AppMethodBeat.o(260987);
        return i;
      }
    }
    
    public final String getLocalData(String paramString)
    {
      AppMethodBeat.i(261006);
      s.u(paramString, "key");
      try
      {
        Object localObject = c.WmU;
        localObject = c.ipk().decodeString(paramString2 + '-' + paramString, "");
        Log.d(c.a(this.Wnc), "getLocalData:" + paramString + ", " + localObject);
        paramString = (String)localObject;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace(c.a(this.Wnc), (Throwable)localException, s.X("getLocalData:", paramString), new Object[0]);
          paramString = null;
        }
      }
      AppMethodBeat.o(261006);
      return paramString;
    }
    
    public final void setLocalData(String paramString1, String paramString2)
    {
      AppMethodBeat.i(260999);
      s.u(paramString1, "key");
      s.u(paramString2, "data");
      try
      {
        c.a locala = c.WmU;
        ((MultiProcessMMKV)c.ipk().getSlotForWrite()).encode(paramString2 + '-' + paramString1, paramString2);
        Log.d(c.a(this.Wnc), "setLocalData:" + paramString1 + ", " + paramString2);
        AppMethodBeat.o(260999);
        return;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace(c.a(this.Wnc), (Throwable)localException, "setLocalData:" + paramString1 + ", " + paramString2, new Object[0]);
        AppMethodBeat.o(260999);
      }
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/webprefetcher/WebPrefetcherJsEngine$onConfigClient$1$jsApiHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/IWebCanvasJsApiHandler;", "dealMsg", "", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "callbackHandler", "Lcom/tencent/mm/plugin/webview/jsapi/ICallbackHandler;", "setJsEngineContext", "ct", "Landroid/content/Context;", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements f
    {
      public final void a(com.tencent.mm.plugin.webview.jsapi.p paramp, com.tencent.mm.plugin.webview.jsapi.c paramc) {}
      
      public final void fR(Context paramContext) {}
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends kotlin.g.b.u
    implements kotlin.g.a.a<com.tencent.mm.plugin.appbrand.appcache.q>
  {
    public static final j Wnk;
    
    static
    {
      AppMethodBeat.i(260978);
      Wnk = new j();
      AppMethodBeat.o(260978);
    }
    
    j()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.az.c
 * JD-Core Version:    0.7.0.1
 */