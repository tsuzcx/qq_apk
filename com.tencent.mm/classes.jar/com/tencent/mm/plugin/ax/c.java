package com.tencent.mm.plugin.ax;

import android.content.Context;
import android.net.Uri;
import android.webkit.ValueCallback;
import com.tencent.mapsdk.rastercore.tools.IO;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o.a;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg.Info;
import com.tencent.mm.plugin.av.j;
import com.tencent.mm.plugin.av.k;
import com.tencent.mm.plugin.aw.c.b.a;
import com.tencent.mm.plugin.webcanvas.m;
import com.tencent.mm.protocal.protobuf.bom;
import com.tencent.mm.protocal.protobuf.bon;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMKVSlotManager;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.vfs.r;
import com.tencent.mm.vfs.u;
import com.tencent.smtt.sdk.MimeTypeMap;
import com.tencent.xweb.WebResourceResponse;
import java.io.Closeable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedDeque;
import kotlin.a.ae;
import kotlin.a.ak;
import kotlin.d.h;
import kotlin.f;
import kotlin.g.b.aa.f;
import kotlin.l;
import kotlin.o;
import kotlin.s;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webprefetcher/WebPrefetcherJsEngine;", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngine;", "()V", "TAG", "", "TAG$1", "contextMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getContextMap", "()Ljava/util/HashMap;", "engineReporter", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineReporter;", "getEngineReporter", "()Lcom/tencent/mm/plugin/webjsengine/WebJsEngineReporter;", "interceptors", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "Lcom/tencent/mm/plugin/webprefetcher/WebPrefetcherJsEngineInterceptor;", "getInterceptors", "()Ljava/util/concurrent/ConcurrentLinkedDeque;", "wxaPkg", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "getWxaPkg", "()Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "wxaPkg$delegate", "Lkotlin/Lazy;", "addInterceptor", "", "interceptor", "bizPkg", "appId", "hasAssets", "", "clearAll", "clearCache", "domain", "configWxPrefetcherClient", "jsRuntime", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;", "id", "create", "manifest", "Lcom/tencent/mm/plugin/webprefetcher/PrefetchManifest;", "onCompleted", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJSContext;", "createJsContext", "type", "url", "createPrefetcherJsContextInner", "pkg", "dispatchEvent", "event", "data", "forceRelease", "getClientConfig", "Lcom/tencent/mm/json/JSONObject;", "getClientInfo", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngine$ClientInfo;", "getEngineName", "inject", "script", "onCallback", "invoke", "func", "params", "", "", "(Lcom/tencent/mm/plugin/webprefetcher/PrefetchManifest;Ljava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callback", "onConfigClient", "onTransferMessage", "message", "targetOrigin", "Companion", "webview-sdk_release"})
public abstract class c
  extends com.tencent.mm.plugin.aw.c
{
  private static final f PwL = kotlin.g.ar((kotlin.g.a.a)b.PwU);
  private static final b PwM = new b("wcf://WebPrefetchContent/");
  private static final b PwN = new b("wcf://WebPrefetchResource/");
  private static final b PwO = new b("wcf://WebPrefetchManifest/");
  private static final Map<String, String> PwP = ae.e(new o[] { s.M("js", "application/javascript"), s.M("json", "application/json") });
  public static final a PwQ = new a((byte)0);
  private static final String TAG = "MicroMsg.WebPrefetcherJsEngine";
  private static final MMKVSlotManager sFn;
  private static final Set<String> sPK = ak.setOf("transfer-encoding");
  private final f PtK = kotlin.g.ar((kotlin.g.a.a)l.Pxe);
  public final ConcurrentLinkedDeque<d> PwK = new ConcurrentLinkedDeque();
  public final HashMap<String, Integer> Pwb;
  public final String jGx = "MicroMsg.WebPrefetcherJsEngine";
  private final com.tencent.mm.plugin.aw.g sPV = new com.tencent.mm.plugin.aw.g();
  
  static
  {
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("__WebPrefetchLocalData__");
    kotlin.g.b.p.j(localMultiProcessMMKV, "MultiProcessMMKV.getMMKV…_WebPrefetchLocalData__\")");
    sFn = new MMKVSlotManager(localMultiProcessMMKV, 15552000L);
  }
  
  public c()
  {
    com.tencent.mm.plugin.av.i locali = new com.tencent.mm.plugin.av.i((com.tencent.mm.plugin.av.c)this);
    com.tencent.mm.plugin.appbrand.m.g localg = bYU();
    kotlin.g.b.p.j(localg, "mainJsContext");
    locali.h((com.tencent.mm.plugin.appbrand.m.i)localg);
    com.tencent.mm.plugin.aw.c.a(this);
    new o.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(205780);
        kotlin.g.b.p.k(paramAnonymousString, "activity");
        Log.i(c.a(this.PwR), "jsEngine pause");
        this.PwR.pause();
        AppMethodBeat.o(205780);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(205779);
        kotlin.g.b.p.k(paramAnonymousString, "activity");
        Log.i(c.a(this.PwR), "jsEngine resume");
        this.PwR.resume();
        AppMethodBeat.o(205779);
      }
    }.alive();
    this.Pwb = new HashMap();
  }
  
  private final void a(final String paramString, final a parama, final kotlin.g.a.b<? super com.tencent.mm.plugin.appbrand.m.g, x> paramb)
  {
    final String str1 = parama.PwI.SZt;
    final aa.f localf1 = new aa.f();
    Object localObject1 = (CharSequence)parama.PwJ.SZA;
    int i;
    if ((localObject1 == null) || (kotlin.n.n.ba((CharSequence)localObject1)))
    {
      i = 1;
      if (i == 0) {
        break label488;
      }
      localObject1 = "";
      localf1.aaBC = localObject1;
      Log.i(this.jGx, "create domain:" + str1 + '#' + paramString + ", appId: " + parama.PwJ.lVG);
    }
    for (;;)
    {
      final String str2;
      try
      {
        for (;;)
        {
          final aa.f localf2 = new aa.f();
          localf2.aaBC = null;
          str2 = parama.PwJ.lVG;
          localObject1 = (CharSequence)str2;
          if (localObject1 != null)
          {
            boolean bool = kotlin.n.n.ba((CharSequence)localObject1);
            if (!bool) {}
          }
          else
          {
            i = 1;
            if (i != 0) {}
          }
          try
          {
            localObject1 = parama.PwJ.lVG;
            kotlin.g.b.p.j(localObject1, "manifest.manifest.AppId");
            localf2.aaBC = biB((String)localObject1);
            com.tencent.mm.plugin.appbrand.m.g localg = bYV();
            kotlin.g.b.p.j(localg, "this");
            b((com.tencent.mm.plugin.appbrand.m.i)localg, paramString, str2);
            localObject1 = (CharSequence)str2;
            if (localObject1 == null) {
              break label675;
            }
            if (kotlin.n.n.ba((CharSequence)localObject1))
            {
              break label675;
              com.tencent.mm.plugin.aw.c.a(this, localg, "WebPrefetcherManifest#".concat(String.valueOf(paramString)), "manifest", null, new com.tencent.mm.plugin.aw.c.a((String)localObject1, 1630L), 8);
              if (parama.aGM)
              {
                localObject1 = (String)localf1.aaBC;
                StringBuilder localStringBuilder = new StringBuilder().append((String)localObject1);
                localObject1 = (com.tencent.mm.plugin.appbrand.appcache.p)localf2.aaBC;
                if (localObject1 == null) {
                  break label719;
                }
                localObject1 = com.tencent.mm.plugin.webview.l.a.b((com.tencent.mm.plugin.appbrand.appcache.p)localObject1, "/manifest.js");
                localf1.aaBC = ((String)localObject1);
              }
              localg.evaluateJavascript((String)localf1.aaBC, (ValueCallback)new e(localg, this, paramString, str2, str1, parama, localf1, localf2, paramb));
              if ((com.tencent.mm.plugin.appbrand.appcache.p)localf2.aaBC == null) {
                break label662;
              }
              Log.v(this.jGx, "createPrefetcherJsContext :" + str2 + '#' + paramString);
              a((com.tencent.mm.plugin.appbrand.appcache.p)localf2.aaBC, str2, null);
              paramb = (com.tencent.mm.plugin.appbrand.appcache.p)localf2.aaBC;
              if (paramb != null)
              {
                parama = paramb;
                if (!(paramb instanceof Closeable)) {
                  parama = null;
                }
                IO.safeClose((Closeable)parama);
              }
              return;
              i = 0;
              break;
              label488:
              localObject1 = PwO;
              str2 = parama.PwJ.SZA;
              kotlin.g.b.p.j(str2, "manifest.manifest.ManifestUrl");
              localObject1 = ((b)localObject1).biA(e.biE(str2));
              if (((com.tencent.mm.vfs.q)localObject1).ifE()) {}
              for (localObject1 = r.ak((com.tencent.mm.vfs.q)localObject1);; localObject1 = "") {
                break;
              }
              i = 0;
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              Log.e(this.jGx, "create bizPkg ex:" + str2 + '#' + paramString + ' ' + localException.getMessage());
            }
          }
        }
        i = 0;
      }
      catch (Exception parama)
      {
        Log.printErrStackTrace(this.jGx, (Throwable)parama, "create id=".concat(String.valueOf(paramString)), new Object[0]);
        return;
      }
      label662:
      label675:
      while (i != 0)
      {
        localObject2 = (CharSequence)str1;
        if (localObject2 == null) {
          break label690;
        }
        if (!kotlin.n.n.ba((CharSequence)localObject2)) {
          break label705;
        }
        break label690;
        Log.w(this.jGx, "createPrefetcherJsContext pkg is null and ignore");
        break;
        i = 1;
      }
      Object localObject2 = str2;
      continue;
      label690:
      label705:
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          break label711;
        }
        localObject2 = str1;
        break;
      }
      label711:
      localObject2 = "manifest";
      continue;
      label719:
      localObject2 = "";
    }
  }
  
  private final void b(com.tencent.mm.plugin.appbrand.m.i parami, final String paramString1, final String paramString2)
  {
    new com.tencent.mm.plugin.av.p((com.tencent.mm.plugin.av.q)new d(this, paramString2, paramString1)).h(parami);
  }
  
  private final void c(com.tencent.mm.plugin.appbrand.m.i parami, String paramString1, final String paramString2)
  {
    b(parami, paramString1, paramString2);
    new j((k)new k(this, paramString2)).h(parami);
  }
  
  private com.tencent.mm.plugin.aw.c.a md(String paramString1, String paramString2)
  {
    kotlin.g.b.p.k(paramString1, "type");
    kotlin.g.b.p.k(paramString2, "appId");
    return new com.tencent.mm.plugin.aw.c.a(paramString2, biy(paramString1).getLong("idKey"));
  }
  
  public final Object a(a parama, String paramString, List<? extends Object> paramList, kotlin.d.d<? super String> paramd)
  {
    h localh = new h(kotlin.d.a.b.k(paramd));
    a(parama, paramString, paramList, (kotlin.g.a.b)new j((kotlin.d.d)localh));
    parama = localh.iBS();
    if (parama == kotlin.d.a.a.aaAA) {
      kotlin.g.b.p.k(paramd, "frame");
    }
    return parama;
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.appcache.p paramp, final String paramString, final kotlin.g.a.b<? super com.tencent.mm.plugin.appbrand.m.g, x> paramb)
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
      localObject1 = e.biF(paramString);
      if (!this.Pwb.containsKey(localObject1)) {
        break label114;
      }
      localObject2 = this.Pwb.get(localObject1);
      if (localObject2 == null) {
        kotlin.g.b.p.iCn();
      }
      kotlin.g.b.p.j(localObject2, "contextMap[prefetchId]!!");
      localObject2 = Bx(((Number)localObject2).intValue());
      if (localObject2 == null) {
        break label114;
      }
    } while (paramb == null);
    paramb.invoke(localObject2);
    return;
    label114:
    paramp = com.tencent.mm.plugin.webview.l.a.b(paramp, "/prefetcher.js");
    if (((CharSequence)paramp).length() > 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      localObject2 = bYV();
      kotlin.g.b.p.j(localObject2, "this");
      c((com.tencent.mm.plugin.appbrand.m.i)localObject2, (String)localObject1, paramString);
      com.tencent.mm.plugin.aw.c.a(this, (com.tencent.mm.plugin.appbrand.m.g)localObject2, "WebPrefetcher#".concat(String.valueOf(paramString)), "prefetcher", null, md("prefetcher", paramString), 8);
      ((com.tencent.mm.plugin.appbrand.m.g)localObject2).evaluateJavascript(paramp, (ValueCallback)new f((com.tencent.mm.plugin.appbrand.m.g)localObject2, this, (String)localObject1, paramString, paramp, "/prefetcher.js", paramb));
      return;
    }
    Log.w(this.jGx, "createPrefetcherJsContext prefetcherJs is empty");
  }
  
  public final void a(a parama, final String paramString, final List<? extends Object> paramList, final kotlin.g.a.b<? super String, x> paramb)
  {
    kotlin.g.b.p.k(parama, "manifest");
    kotlin.g.b.p.k(paramString, "func");
    kotlin.g.b.p.k(paramb, "callback");
    final String str = e.biE(parama.PwJ.lVG + '-' + parama.PwJ.SZA);
    if (!this.Pwb.containsKey(str))
    {
      a(str, parama, (kotlin.g.a.b)new i(this, str, paramString, paramList, paramb));
      return;
    }
    a(str, paramString, paramList, paramb);
  }
  
  public final void a(a parama, String paramString, kotlin.g.a.b<? super String, x> paramb)
  {
    kotlin.g.b.p.k(parama, "manifest");
    kotlin.g.b.p.k(paramString, "script");
    kotlin.g.b.p.k(paramb, "onCallback");
    Iterator localIterator = ((Iterable)this.PwK).iterator();
    while ((localIterator.hasNext()) && (!((d)localIterator.next()).a(1, parama, paramString, paramb))) {}
  }
  
  public final void a(d paramd)
  {
    kotlin.g.b.p.k(paramd, "interceptor");
    kotlin.g.b.p.k(this, "jsEngine");
    paramd.Pxg = ((com.tencent.mm.plugin.aw.c)this);
    paramd.Pwb = this.Pwb;
    this.PwK.add(paramd);
  }
  
  public abstract void aml(String paramString);
  
  public final com.tencent.mm.plugin.appbrand.appcache.p biB(String paramString)
  {
    boolean bool = true;
    String str = "prefetcher/" + paramString + ".wspkg";
    m localm = m.PuL;
    if (m.gPr() == 1) {}
    for (;;)
    {
      return com.tencent.mm.plugin.aw.c.b.a(com.tencent.mm.plugin.aw.c.b.a(str, bool, com.tencent.mm.plugin.aw.c.b.biz(paramString), paramString), (kotlin.g.a.q)new c(this), null, false, 4);
      bool = false;
    }
  }
  
  public final com.tencent.mm.plugin.aw.c.a bie(String paramString)
  {
    kotlin.g.b.p.k(paramString, "type");
    return new com.tencent.mm.plugin.aw.c.a("wx97b7aebac2183fd2", biy(paramString).getLong("idKey"));
  }
  
  public final com.tencent.mm.ad.i biy(String paramString)
  {
    kotlin.g.b.p.k(paramString, "type");
    paramString = gPk().MJ("client").MJ(paramString);
    kotlin.g.b.p.j(paramString, "vmConfig.getJSONObject(\"…ent\").getJSONObject(type)");
    return paramString;
  }
  
  public final String cAJ()
  {
    return "WebPrefetcherJsEngine";
  }
  
  public final com.tencent.mm.plugin.aw.g gPh()
  {
    return this.sPV;
  }
  
  public final com.tencent.mm.plugin.appbrand.appcache.p gPi()
  {
    return (com.tencent.mm.plugin.appbrand.appcache.p)this.PtK.getValue();
  }
  
  public final void lW(String paramString1, String paramString2)
  {
    kotlin.g.b.p.k(paramString1, "message");
    kotlin.g.b.p.k(paramString2, "targetOrigin");
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webprefetcher/WebPrefetcherJsEngine$Companion;", "", "()V", "HEADER_TRANSFER_ENCODING", "", "TAG", "WEB_PREFECHER_INVALID_HEADERS", "", "getWEB_PREFECHER_INVALID_HEADERS", "()Ljava/util/Set;", "kvSlot", "Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "getKvSlot", "()Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "manifestContent", "Lcom/tencent/mm/plugin/webprefetcher/WebPrefetcherFile;", "getManifestContent", "()Lcom/tencent/mm/plugin/webprefetcher/WebPrefetcherFile;", "mimeMap", "", "prefetchBasePkgAppId", "prefetchUsePkgOpen", "", "getPrefetchUsePkgOpen", "()Z", "prefetchUsePkgOpen$delegate", "Lkotlin/Lazy;", "resContent", "getResContent", "webContent", "getWebContent", "getMimeType", "uri", "Landroid/net/Uri;", "getMinPkgVersion", "", "appId", "match", "Lcom/tencent/mm/plugin/webprefetcher/PrefetchManifest;", "url", "settingManager", "matchDebugManifest", "host", "matchResource", "Lcom/tencent/xweb/WebResourceResponse;", "isForMainFrame", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/tencent/xweb/WebResourceResponse;", "webview-sdk_release"})
  public static final class a
  {
    public static a a(String paramString, MMKVSlotManager paramMMKVSlotManager)
    {
      AppMethodBeat.i(210352);
      kotlin.g.b.p.k(paramString, "url");
      kotlin.g.b.p.k(paramMMKVSlotManager, "settingManager");
      Uri localUri = Uri.parse(paramString);
      kotlin.g.b.p.j(localUri, "uri");
      Object localObject1 = biC(localUri.getHost());
      if (localObject1 != null)
      {
        Log.i(c.access$getTAG$cp(), "matchDebug:".concat(String.valueOf(localUri)));
        AppMethodBeat.o(210352);
        return localObject1;
      }
      localObject1 = e.biE(String.valueOf(localUri.getHost()));
      paramMMKVSlotManager = (MultiProcessMMKV)paramMMKVSlotManager.findSlot((String)localObject1);
      int i;
      if (paramMMKVSlotManager != null) {
        if (paramMMKVSlotManager.containsKey((String)localObject1))
        {
          paramMMKVSlotManager = paramMMKVSlotManager.decodeBytes((String)localObject1);
          if (paramMMKVSlotManager != null) {
            if (paramMMKVSlotManager.length == 0)
            {
              i = 1;
              if (i != 0) {
                break label365;
              }
              i = 1;
              label124:
              if (i == 0) {
                break label386;
              }
            }
          }
        }
      }
      for (;;)
      {
        bon localbon;
        try
        {
          Object localObject2 = bom.class.newInstance();
          ((com.tencent.mm.cd.a)localObject2).parseFrom(paramMMKVSlotManager);
          paramMMKVSlotManager = (com.tencent.mm.cd.a)localObject2;
          paramMMKVSlotManager = (bom)paramMMKVSlotManager;
          if (paramMMKVSlotManager == null) {
            break label436;
          }
          localObject2 = paramMMKVSlotManager.SZy;
          kotlin.g.b.p.j(localObject2, "ResInfos");
          localObject2 = ((Iterable)localObject2).iterator();
          if (!((Iterator)localObject2).hasNext()) {
            break label436;
          }
          localbon = (bon)((Iterator)localObject2).next();
          if (localUri == null) {
            continue;
          }
          Object localObject3 = localUri.getPath();
          if (localObject3 == null) {
            continue;
          }
          String str = localbon.CqK;
          kotlin.g.b.p.j(str, "res.Path");
          if (com.tencent.luggage.k.c.H((String)localObject3, str) != true) {
            continue;
          }
          localObject3 = c.PwQ;
          localObject3 = c.gPY();
          str = localbon.SZA;
          kotlin.g.b.p.j(str, "res.ManifestUrl");
          if (!((b)localObject3).biA(e.biE(str)).ifE()) {
            break label396;
          }
          Log.v(c.access$getTAG$cp(), "match:#" + (String)localObject1 + ", " + localbon.CqK + ", " + paramString);
          kotlin.g.b.p.j(localbon, "res");
          paramString = new a(paramMMKVSlotManager, localbon, false, 60);
          AppMethodBeat.o(210352);
          return paramString;
        }
        catch (Exception paramMMKVSlotManager)
        {
          Log.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", (Throwable)paramMMKVSlotManager, "decode ProtoBuffer", new Object[0]);
        }
        i = 0;
        break;
        label365:
        i = 0;
        break label124;
        label386:
        paramMMKVSlotManager = null;
        continue;
        paramMMKVSlotManager = null;
        continue;
        label396:
        Log.w(c.access$getTAG$cp(), "manifest lost:#" + (String)localObject1 + ", " + localbon.CqK);
      }
      label436:
      Log.v(c.access$getTAG$cp(), "not match:#" + (String)localObject1 + ", " + paramString);
      AppMethodBeat.o(210352);
      return null;
    }
    
    public static WebResourceResponse a(String paramString1, String paramString2, Boolean paramBoolean)
    {
      AppMethodBeat.i(210361);
      kotlin.g.b.p.k(paramString2, "url");
      if (!gQa())
      {
        AppMethodBeat.o(210361);
        return null;
      }
      Object localObject1 = (CharSequence)paramString1;
      if ((localObject1 == null) || (kotlin.n.n.ba((CharSequence)localObject1))) {}
      for (int i = 1; i != 0; i = 0)
      {
        Log.d(c.access$getTAG$cp(), "matchResource fail appId=".concat(String.valueOf(paramString1)));
        AppMethodBeat.o(210361);
        return null;
      }
      Object localObject4 = Uri.parse(paramString2);
      localObject1 = com.tencent.mm.plugin.aw.c.Pwj;
      localObject1 = com.tencent.mm.plugin.aw.c.b.biz(paramString1);
      Log.i(c.access$getTAG$cp(), "matchResource appId=" + paramString1 + ", isForMainFrame=" + paramBoolean);
      Object localObject2;
      Object localObject3;
      boolean bool;
      for (;;)
      {
        try
        {
          localObject2 = com.tencent.mm.plugin.aw.c.Pwj;
          localObject2 = "prefetcher/" + paramString1 + ".wspkg";
          localObject3 = m.PuL;
          if (m.gPr() != 1) {
            break label1022;
          }
          bool = true;
          localObject1 = com.tencent.mm.plugin.aw.c.b.a((String)localObject2, bool, (String)localObject1, paramString1);
          if (!u.agG(((c.b.a)localObject1).cIr)) {
            continue;
          }
          localObject2 = com.tencent.mm.plugin.aw.c.Pwj;
          localObject2 = com.tencent.mm.plugin.aw.c.b.a((c.b.a)localObject1, (kotlin.g.a.q)b.PwT, null, false, 4);
          i = com.tencent.mm.plugin.webview.l.a.b((com.tencent.mm.plugin.appbrand.appcache.p)localObject2);
          int j = biD(paramString1);
          if (i < j)
          {
            Log.i(c.access$getTAG$cp(), "matchResource fail, pkgVersion=" + i + ", minPkgVersion=" + j);
            AppMethodBeat.o(210361);
            return null;
          }
          paramString1 = new StringBuilder("/resources/");
          kotlin.g.b.p.j(localObject4, "uri");
          localObject1 = ((com.tencent.mm.plugin.appbrand.appcache.p)localObject2).openReadPartialInfo(((Uri)localObject4).getHost() + ((Uri)localObject4).getPath());
          if (localObject1 != null) {
            break label1019;
          }
          paramString1 = com.tencent.mm.plugin.aw.c.Pwj;
          kotlin.g.b.p.k(localObject2, "pkg");
          localObject3 = (com.tencent.mm.ad.i)com.tencent.mm.plugin.aw.c.gPR().aX(((com.tencent.mm.plugin.appbrand.appcache.p)localObject2).bGk());
          paramString1 = (String)localObject3;
          if (localObject3 == null)
          {
            kotlin.g.b.p.k(localObject2, "$this$config");
            paramString1 = new com.tencent.mm.ad.i(com.tencent.mm.plugin.webview.l.a.a((com.tencent.mm.plugin.appbrand.appcache.p)localObject2, "/config.json"));
            com.tencent.mm.plugin.aw.c.gPR().q(((com.tencent.mm.plugin.appbrand.appcache.p)localObject2).bGk(), paramString1);
          }
          if (paramString1 == null) {
            break label787;
          }
          paramString1 = paramString1.MK("file");
          if (paramString1 == null) {
            break label1028;
          }
          paramString1 = paramString1.MK(paramString2);
          if (paramString1 == null) {
            break label1028;
          }
          localObject3 = paramString1.optString("path");
          paramString1 = (String)localObject3;
          if (localObject3 == null) {
            break label1028;
          }
          label453:
          if (((CharSequence)paramString1).length() <= 0) {
            break label792;
          }
          i = 1;
          if (i == 0) {
            break label1019;
          }
          localObject1 = ((com.tencent.mm.plugin.appbrand.appcache.p)localObject2).openReadPartialInfo("/resources/" + ((Uri)localObject4).getHost() + paramString1);
          label505:
          if (kotlin.g.b.p.h(paramBoolean, Boolean.TRUE)) {
            Log.i(c.access$getTAG$cp(), "matchResource resInfo: " + localObject1 + ", url: " + paramString2);
          }
          if (localObject1 == null) {
            continue;
          }
          paramString1 = c.PwQ;
          paramString1 = MimeTypeMap.getFileExtensionFromUrl(((Uri)localObject4).toString());
          if (paramString1 != null)
          {
            paramString1 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(paramString1);
            paramString2 = paramString1;
            if (paramString1 != null) {}
          }
          else
          {
            paramString1 = ((Uri)localObject4).getPath();
            if (paramString1 != null)
            {
              paramString1 = kotlin.n.n.pz(paramString1, ".");
              if (paramString1 != null) {
                paramString2 = (String)c.gPZ().get(paramString1);
              }
            }
          }
        }
        catch (Exception paramString1)
        {
          label623:
          Log.printErrStackTrace(c.access$getTAG$cp(), (Throwable)paramString1, "matchResource exception", new Object[0]);
          label707:
          AppMethodBeat.o(210361);
          return null;
        }
        localObject3 = new HashMap();
        localObject4 = ((com.tencent.mm.plugin.appbrand.appcache.p)localObject2).openReadPartialInfo(((WxaPkg.Info)localObject1).fileName + ".headers");
        paramString2 = paramString1;
        if (localObject4 == null) {
          break label944;
        }
        paramString2 = ((WxaPkg.Info)localObject4).fileName;
        kotlin.g.b.p.j(paramString2, "it.fileName");
        localObject4 = ((Iterable)kotlin.n.n.bh((CharSequence)com.tencent.mm.plugin.webview.l.a.a((com.tencent.mm.plugin.appbrand.appcache.p)localObject2, paramString2))).iterator();
        if (!((Iterator)localObject4).hasNext()) {
          break label1051;
        }
        paramString2 = (String)((Iterator)localObject4).next();
        str = kotlin.n.n.pv(paramString2, ":");
        if (str != null) {
          break label802;
        }
        paramString1 = new t("null cannot be cast to non-null type kotlin.CharSequence");
        AppMethodBeat.o(210361);
        throw paramString1;
        label787:
        paramString1 = null;
        continue;
        label792:
        i = 0;
      }
      paramString2 = null;
      break label1035;
      label802:
      String str = kotlin.n.n.bb((CharSequence)str).toString();
      if (str == null)
      {
        paramString1 = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(210361);
        throw paramString1;
      }
      str = str.toLowerCase();
      kotlin.g.b.p.j(str, "(this as java.lang.String).toLowerCase()");
      paramString2 = kotlin.n.n.px(paramString2, ":");
      if (paramString2 == null)
      {
        paramString1 = new t("null cannot be cast to non-null type kotlin.CharSequence");
        AppMethodBeat.o(210361);
        throw paramString1;
      }
      paramString2 = kotlin.n.n.bb((CharSequence)paramString2).toString();
      a locala = c.PwQ;
      if (!c.gPT().contains(str)) {
        ((Map)localObject3).put(str, paramString2);
      }
      if (kotlin.g.b.p.h(str, "content-type")) {
        paramString1 = paramString2;
      }
      for (;;)
      {
        label944:
        kotlin.g.b.p.h(paramBoolean, Boolean.TRUE);
        paramString2 = new WebResourceResponse(paramString2, null, 200, "OK", (Map)localObject3, ((com.tencent.mm.plugin.appbrand.appcache.p)localObject2).acB(((WxaPkg.Info)localObject1).fileName));
        if (!(localObject2 instanceof Closeable)) {}
        for (paramString1 = null;; paramString1 = (String)localObject2)
        {
          IO.safeClose((Closeable)paramString1);
          AppMethodBeat.o(210361);
          return paramString2;
        }
        break label1048;
        label1019:
        break label505;
        label1022:
        bool = false;
        break;
        label1028:
        paramString1 = "";
        break label453;
        label1035:
        paramString1 = paramString2;
        if (paramString2 != null) {
          break label623;
        }
        paramString1 = "text/plain";
        break label623;
        label1048:
        break label707;
        label1051:
        paramString2 = paramString1;
      }
    }
    
    public static a biC(String paramString)
    {
      AppMethodBeat.i(210354);
      if ((!BuildInfo.DEBUG) && (!BuildInfo.IS_FLAVOR_RED) && (!WeChatEnvironment.hasDebugger()))
      {
        AppMethodBeat.o(210354);
        return null;
      }
      Object localObject1 = com.tencent.mm.plugin.aw.c.Pwj;
      localObject1 = com.tencent.mm.plugin.aw.c.b.a("prefetcher/" + paramString + ".wspkg", true, "", "matchDebugManifest");
      if (u.agG(((c.b.a)localObject1).cIr))
      {
        Log.i(c.access$getTAG$cp(), "matchDebugManifest " + paramString + " path=" + ((c.b.a)localObject1).cIr);
        try
        {
          Object localObject2 = com.tencent.mm.plugin.aw.c.Pwj;
          localObject1 = new com.tencent.mm.ad.i(com.tencent.mm.plugin.webview.l.a.a(com.tencent.mm.plugin.aw.c.b.a((c.b.a)localObject1, (kotlin.g.a.q)a.PwS, null, false, 4), "/config.json"));
          localObject2 = new bom();
          ((bom)localObject2).SZt = ((com.tencent.mm.ad.i)localObject1).optString("domain");
          bon localbon = new bon();
          localbon.CqK = ((com.tencent.mm.ad.i)localObject1).optString("path");
          localbon.lVG = paramString;
          localbon.SZA = ((com.tencent.mm.ad.i)localObject1).optString("manifest");
          paramString = new a((bom)localObject2, localbon, true, 28);
          AppMethodBeat.o(210354);
          return paramString;
        }
        catch (Exception paramString)
        {
          Log.printErrStackTrace(c.access$getTAG$cp(), (Throwable)paramString, "matchDebugManifest", new Object[0]);
        }
      }
      AppMethodBeat.o(210354);
      return null;
    }
    
    private static int biD(String paramString)
    {
      AppMethodBeat.i(210356);
      try
      {
        i = c.gPU().decodeInt(paramString + "-MinBizPkgVersion", 0);
        AppMethodBeat.o(210356);
        return i;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace(c.access$getTAG$cp(), (Throwable)localException, "getMinPkgVersion:".concat(String.valueOf(paramString)), new Object[0]);
          int i = 0;
        }
      }
    }
    
    public static boolean gQa()
    {
      AppMethodBeat.i(210351);
      f localf = c.gPV();
      a locala = c.PwQ;
      boolean bool = ((Boolean)localf.getValue()).booleanValue();
      AppMethodBeat.o(210351);
      return bool;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "<anonymous parameter 2>", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.q<Integer, Integer, com.tencent.mm.plugin.appbrand.appcache.p, Boolean>
    {
      public static final a PwS;
      
      static
      {
        AppMethodBeat.i(206534);
        PwS = new a();
        AppMethodBeat.o(206534);
      }
      
      a()
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "<anonymous parameter 2>", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "invoke"})
    static final class b
      extends kotlin.g.b.q
      implements kotlin.g.a.q<Integer, Integer, com.tencent.mm.plugin.appbrand.appcache.p, Boolean>
    {
      public static final b PwT;
      
      static
      {
        AppMethodBeat.i(213669);
        PwT = new b();
        AppMethodBeat.o(213669);
      }
      
      b()
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Boolean>
  {
    public static final b PwU;
    
    static
    {
      AppMethodBeat.i(207142);
      PwU = new b();
      AppMethodBeat.o(207142);
    }
    
    b()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "assetsVersion", "", "resVersion", "resPkg", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.q<Integer, Integer, com.tencent.mm.plugin.appbrand.appcache.p, Boolean>
  {
    c(c paramc)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/webprefetcher/WebPrefetcherJsEngine$configWxPrefetcherClient$1", "Lcom/tencent/mm/plugin/webjsapi/WxPrefetcherClientContext;", "id", "", "getId", "()Ljava/lang/String;", "dispatch", "", "eventType", "event", "cb", "Landroid/webkit/ValueCallback;", "setMinBizPkgVersion", "version", "", "webview-sdk_release"})
  public static final class d
    implements com.tencent.mm.plugin.av.q
  {
    private final String id;
    
    d(String paramString1, String paramString2)
    {
      this.id = localObject;
    }
    
    public final void b(String paramString1, String paramString2, ValueCallback<String> paramValueCallback)
    {
      AppMethodBeat.i(216132);
      kotlin.g.b.p.k(paramString1, "eventType");
      kotlin.g.b.p.k(paramString2, "event");
      this.PwR.b(paramString1, paramString2, paramValueCallback);
      AppMethodBeat.o(216132);
    }
    
    public final String getId()
    {
      return this.id;
    }
    
    public final void setMinBizPkgVersion(int paramInt)
    {
      AppMethodBeat.i(216129);
      try
      {
        c.a locala = c.PwQ;
        ((MultiProcessMMKV)c.gPU().getSlotForWrite()).encode(paramString2 + "-MinBizPkgVersion", paramInt);
        Log.d(c.a(this.PwR), "setMinBizPkgVersion:" + paramString2 + ", " + paramInt);
        AppMethodBeat.o(216129);
        return;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace(c.a(this.PwR), (Throwable)localException, "setMinBizPkgVersion:" + paramString2 + ", " + paramInt, new Object[0]);
        AppMethodBeat.o(216129);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onReceiveValue", "com/tencent/mm/plugin/webprefetcher/WebPrefetcherJsEngine$create$1$1"})
  static final class e<T>
    implements ValueCallback<String>
  {
    e(com.tencent.mm.plugin.appbrand.m.g paramg, c paramc, String paramString1, String paramString2, String paramString3, a parama, aa.f paramf1, aa.f paramf2, kotlin.g.a.b paramb) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onReceiveValue", "com/tencent/mm/plugin/webprefetcher/WebPrefetcherJsEngine$createPrefetcherJsContextInner$1$1"})
  static final class f<T>
    implements ValueCallback<String>
  {
    f(com.tencent.mm.plugin.appbrand.m.g paramg, c paramc, String paramString1, String paramString2, String paramString3, String paramString4, kotlin.g.a.b paramb) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJSContext;", "invoke", "com/tencent/mm/plugin/webprefetcher/WebPrefetcherJsEngine$dispatchEvent$2$1"})
  public static final class g
    extends kotlin.g.b.q
    implements kotlin.g.a.b<com.tencent.mm.plugin.appbrand.m.g, x>
  {
    public g(String paramString1, c paramc, kotlin.g.a.b paramb, String paramString2)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "prefetchId", "", "invoke"})
  public static final class h
    extends kotlin.g.b.q
    implements kotlin.g.a.b<String, x>
  {
    public h(c paramc, String paramString1, String paramString2)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "cxt", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJSContext;", "invoke"})
  static final class i
    extends kotlin.g.b.q
    implements kotlin.g.a.b<com.tencent.mm.plugin.appbrand.m.g, x>
  {
    i(c paramc, String paramString1, String paramString2, List paramList, kotlin.g.a.b paramb)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke"})
  static final class j
    extends kotlin.g.b.q
    implements kotlin.g.a.b<String, x>
  {
    j(kotlin.d.d paramd)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/webprefetcher/WebPrefetcherJsEngine$onConfigClient$1", "Lcom/tencent/mm/plugin/webjsapi/WxJsEngineContextAPIContext;", "basePkgVersion", "", "getBasePkgVersion", "()I", "bizPkgVersion", "getBizPkgVersion", "jsApiHandler", "Lcom/tencent/mm/plugin/webview/jsapi/IWebCanvasJsApiHandler;", "getJsApiHandler", "()Lcom/tencent/mm/plugin/webview/jsapi/IWebCanvasJsApiHandler;", "dispatch", "", "eventType", "", "event", "cb", "Landroid/webkit/ValueCallback;", "getLocalData", "key", "onInvoke", "func", "message", "setLocalData", "data", "validCgi", "", "cmdId", "cgiUrl", "webview-sdk_release"})
  public static final class k
    implements k
  {
    k(String paramString) {}
    
    public final boolean aF(int paramInt, String paramString)
    {
      AppMethodBeat.i(205690);
      kotlin.g.b.p.k(paramString, "cgiUrl");
      AppMethodBeat.o(205690);
      return false;
    }
    
    public final void b(String paramString1, String paramString2, ValueCallback<String> paramValueCallback)
    {
      AppMethodBeat.i(205695);
      kotlin.g.b.p.k(paramString1, "eventType");
      kotlin.g.b.p.k(paramString2, "event");
      this.PwR.b(paramString1, paramString2, paramValueCallback);
      AppMethodBeat.o(205695);
    }
    
    public final com.tencent.mm.plugin.webview.d.d cAI()
    {
      AppMethodBeat.i(205693);
      com.tencent.mm.plugin.webview.d.d locald = (com.tencent.mm.plugin.webview.d.d)new a();
      AppMethodBeat.o(205693);
      return locald;
    }
    
    public final void fs(String paramString1, String paramString2)
    {
      AppMethodBeat.i(205694);
      kotlin.g.b.p.k(paramString1, "func");
      kotlin.g.b.p.k(paramString2, "message");
      AppMethodBeat.o(205694);
    }
    
    public final int getBasePkgVersion()
    {
      AppMethodBeat.i(205688);
      int i = com.tencent.mm.plugin.webview.l.a.b(this.PwR.gPi());
      AppMethodBeat.o(205688);
      return i;
    }
    
    public final int getBizPkgVersion()
    {
      AppMethodBeat.i(205689);
      com.tencent.mm.plugin.appbrand.appcache.p localp2 = c.a(this.PwR, paramString2);
      int i = com.tencent.mm.plugin.webview.l.a.b(localp2);
      com.tencent.mm.plugin.appbrand.appcache.p localp1 = localp2;
      if (!(localp2 instanceof Closeable)) {
        localp1 = null;
      }
      IO.safeClose((Closeable)localp1);
      AppMethodBeat.o(205689);
      return i;
    }
    
    public final String getLocalData(String paramString)
    {
      AppMethodBeat.i(205692);
      kotlin.g.b.p.k(paramString, "key");
      try
      {
        Object localObject = c.PwQ;
        localObject = c.gPU().decodeString(paramString2 + '-' + paramString, "");
        Log.d(c.a(this.PwR), "getLocalData:" + paramString + ", " + (String)localObject);
        paramString = (String)localObject;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace(c.a(this.PwR), (Throwable)localException, "getLocalData:".concat(String.valueOf(paramString)), new Object[0]);
          paramString = null;
        }
      }
      AppMethodBeat.o(205692);
      return paramString;
    }
    
    public final void setLocalData(String paramString1, String paramString2)
    {
      AppMethodBeat.i(205691);
      kotlin.g.b.p.k(paramString1, "key");
      kotlin.g.b.p.k(paramString2, "data");
      try
      {
        c.a locala = c.PwQ;
        ((MultiProcessMMKV)c.gPU().getSlotForWrite()).encode(paramString2 + '-' + paramString1, paramString2);
        Log.d(c.a(this.PwR), "setLocalData:" + paramString1 + ", " + paramString2);
        AppMethodBeat.o(205691);
        return;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace(c.a(this.PwR), (Throwable)localException, "setLocalData:" + paramString1 + ", " + paramString2, new Object[0]);
        AppMethodBeat.o(205691);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/webprefetcher/WebPrefetcherJsEngine$onConfigClient$1$jsApiHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/IWebCanvasJsApiHandler;", "dealMsg", "", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "callbackHandler", "Lcom/tencent/mm/plugin/webview/jsapi/ICallbackHandler;", "setJsEngineContext", "ct", "Landroid/content/Context;", "webview-sdk_release"})
    public static final class a
      implements com.tencent.mm.plugin.webview.d.d
    {
      public final void a(com.tencent.mm.plugin.webview.d.n paramn, com.tencent.mm.plugin.webview.d.b paramb) {}
      
      public final void eU(Context paramContext) {}
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "invoke"})
  static final class l
    extends kotlin.g.b.q
    implements kotlin.g.a.a<com.tencent.mm.plugin.appbrand.appcache.p>
  {
    public static final l Pxe;
    
    static
    {
      AppMethodBeat.i(214424);
      Pxe = new l();
      AppMethodBeat.o(214424);
    }
    
    l()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ax.c
 * JD-Core Version:    0.7.0.1
 */