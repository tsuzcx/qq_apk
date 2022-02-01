package com.tencent.mm.plugin.ad;

import android.content.Context;
import android.net.Uri;
import android.webkit.ValueCallback;
import com.tencent.mapsdk.rastercore.tools.IO;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o.a;
import com.tencent.mm.plugin.ab.j;
import com.tencent.mm.plugin.ab.k;
import com.tencent.mm.plugin.ac.c.b.a;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg.Info;
import com.tencent.mm.plugin.webcanvas.m;
import com.tencent.mm.protocal.protobuf.bhc;
import com.tencent.mm.protocal.protobuf.bhd;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMKVSlotManager;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.smtt.sdk.MimeTypeMap;
import com.tencent.xweb.WebResourceResponse;
import java.io.Closeable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedDeque;
import kotlin.a.ae;
import kotlin.d.h;
import kotlin.f;
import kotlin.g.b.z.f;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webprefetcher/WebPrefetcherJsEngine;", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngine;", "()V", "TAG", "", "TAG$1", "contextMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getContextMap", "()Ljava/util/HashMap;", "engineReporter", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineReporter;", "getEngineReporter", "()Lcom/tencent/mm/plugin/webjsengine/WebJsEngineReporter;", "interceptors", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "Lcom/tencent/mm/plugin/webprefetcher/WebPrefetcherJsEngineInterceptor;", "getInterceptors", "()Ljava/util/concurrent/ConcurrentLinkedDeque;", "wxaPkg", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "getWxaPkg", "()Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "wxaPkg$delegate", "Lkotlin/Lazy;", "addInterceptor", "", "interceptor", "bizPkg", "appId", "clearAll", "clearCache", "domain", "create", "id", "manifest", "Lcom/tencent/mm/plugin/webprefetcher/PrefetchManifest;", "onCompleted", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJSContext;", "dispatchEvent", "url", "event", "data", "getClientConfig", "Lcom/tencent/mm/json/JSONObject;", "type", "getClientInfo", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngine$ClientInfo;", "getEngineName", "inject", "script", "onCallback", "invoke", "func", "params", "", "", "(Lcom/tencent/mm/plugin/webprefetcher/PrefetchManifest;Ljava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callback", "onConfigClient", "jsRuntime", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;", "onTransferMessage", "message", "targetOrigin", "Companion", "webview-sdk_release"})
public abstract class c
  extends com.tencent.mm.plugin.ac.c
{
  public static final a ICA = new a((byte)0);
  private static final f ICv = kotlin.g.ah((kotlin.g.a.a)c.b.ICG);
  private static final b ICw = new b("wcf://WebPrefetchContent/");
  private static final b ICx = new b("wcf://WebPrefetchResource/");
  private static final b ICy = new b("wcf://WebPrefetchManifest/");
  private static final Map<String, String> ICz = ae.e(new kotlin.o[] { kotlin.s.U("js", "application/javascript"), kotlin.s.U("json", "application/json") });
  private static final String TAG = "MicroMsg.WebPrefetcherJsEngine";
  private static final MMKVSlotManager pvV;
  public final HashMap<String, Integer> IBO;
  public final ConcurrentLinkedDeque<d> ICu = new ConcurrentLinkedDeque();
  private final com.tencent.mm.plugin.ac.g IzE = new com.tencent.mm.plugin.ac.g();
  private final f IzH = kotlin.g.ah((kotlin.g.a.a)l.ICN);
  private final String gVB = "MicroMsg.WebPrefetcherJsEngine";
  
  static
  {
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("__WebPrefetchLocalData__");
    kotlin.g.b.p.g(localMultiProcessMMKV, "MultiProcessMMKV.getMMKV…_WebPrefetchLocalData__\")");
    pvV = new MMKVSlotManager(localMultiProcessMMKV, 15552000L);
  }
  
  public c()
  {
    com.tencent.mm.plugin.ab.i locali = new com.tencent.mm.plugin.ab.i((com.tencent.mm.plugin.ab.c)this);
    com.tencent.mm.plugin.appbrand.m.g localg = bMD();
    kotlin.g.b.p.g(localg, "mainJsContext");
    locali.f((com.tencent.mm.plugin.appbrand.m.i)localg);
    com.tencent.mm.plugin.ac.c.a(this);
    new o.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(224914);
        kotlin.g.b.p.h(paramAnonymousString, "activity");
        Log.i(c.a(this.ICB), "jsEngine pause");
        this.ICB.pause();
        AppMethodBeat.o(224914);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(224913);
        kotlin.g.b.p.h(paramAnonymousString, "activity");
        Log.i(c.a(this.ICB), "jsEngine resume");
        this.ICB.resume();
        AppMethodBeat.o(224913);
      }
    }.alive();
    this.IBO = new HashMap();
  }
  
  private final com.tencent.mm.plugin.appbrand.appcache.p aWS(String paramString)
  {
    String str = "prefetcher/" + paramString + ".wspkg";
    Object localObject = m.IAG;
    boolean bool;
    if (m.fWJ() == 1)
    {
      bool = true;
      localObject = m.IAG;
      if (m.fWJ() != 1) {
        break label93;
      }
      localObject = m.IAG;
    }
    label93:
    for (localObject = m.aWI(paramString);; localObject = m.IAG.aWH(paramString))
    {
      return com.tencent.mm.plugin.ac.c.b.a(com.tencent.mm.plugin.ac.c.b.a(str, bool, (String)localObject, paramString), (kotlin.g.a.q)new c(this), (kotlin.g.a.q)c.d.ICH, true);
      bool = false;
      break;
    }
  }
  
  public final Object a(a parama, String paramString, List<? extends Object> paramList, kotlin.d.d<? super String> paramd)
  {
    h localh = new h(kotlin.d.a.b.e(paramd));
    a(parama, paramString, paramList, (kotlin.g.a.b)new c.i((kotlin.d.d)localh));
    parama = localh.hxK();
    if (parama == kotlin.d.a.a.SXO) {
      kotlin.g.b.p.h(paramd, "frame");
    }
    return parama;
  }
  
  public final void a(a parama, final String paramString, final List<? extends Object> paramList, final kotlin.g.a.b<? super String, x> paramb)
  {
    kotlin.g.b.p.h(parama, "manifest");
    kotlin.g.b.p.h(paramString, "func");
    kotlin.g.b.p.h(paramb, "callback");
    Object localObject2 = parama.ICt.jfi;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = parama.ICt.LQV;
      kotlin.g.b.p.g(localObject1, "manifest.manifest.ManifestUrl");
    }
    localObject1 = e.aWU((String)localObject1);
    if (!this.IBO.containsKey(localObject1))
    {
      paramList = (kotlin.g.a.b)new h(this, (String)localObject1, paramString, paramList, paramb);
      paramb = parama.ICs.LQP;
      localObject2 = new z.f();
      paramString = ICy.aWR((String)localObject1);
      if (paramString.exists())
      {
        paramString = com.tencent.mm.vfs.p.an(paramString);
        ((z.f)localObject2).SYG = paramString;
        Log.i(this.gVB, "create domain:" + paramb + '#' + (String)localObject1);
      }
    }
    for (;;)
    {
      try
      {
        for (;;)
        {
          paramString = new z.f();
          paramString.SYG = null;
          final String str = parama.ICt.jfi;
          Object localObject3 = (CharSequence)str;
          if (localObject3 != null)
          {
            boolean bool = kotlin.n.n.aL((CharSequence)localObject3);
            if (!bool) {}
          }
          else
          {
            i = 1;
            if (i != 0) {}
          }
          try
          {
            parama = parama.ICt.jfi;
            kotlin.g.b.p.g(parama, "manifest.manifest.AppId");
            paramString.SYG = aWS(parama);
            localObject3 = bME();
            parama = new com.tencent.mm.plugin.ab.p((com.tencent.mm.plugin.ab.q)new e(this, (String)localObject1, (z.f)localObject2, paramString, paramb, paramList));
            kotlin.g.b.p.g(localObject3, "this");
            parama.f((com.tencent.mm.plugin.appbrand.m.i)localObject3);
            com.tencent.mm.plugin.ac.c.a(this, (com.tencent.mm.plugin.appbrand.m.g)localObject3, "WebPrefetcherManifest#".concat(String.valueOf(localObject1)), "manifest", null, null, 24);
            parama = (String)((z.f)localObject2).SYG;
            StringBuilder localStringBuilder = new StringBuilder().append(parama);
            parama = (com.tencent.mm.plugin.appbrand.appcache.p)paramString.SYG;
            if (parama != null)
            {
              parama = com.tencent.mm.plugin.ac.c.b.b(parama, "/manifest.js");
              ((z.f)localObject2).SYG = parama;
              ((com.tencent.mm.plugin.appbrand.m.g)localObject3).evaluateJavascript((String)((z.f)localObject2).SYG, (ValueCallback)new f((com.tencent.mm.plugin.appbrand.m.g)localObject3, this, (String)localObject1, (z.f)localObject2, paramString, paramb, paramList));
              parama = (CharSequence)str;
              if (parama == null) {
                break label768;
              }
              if (!kotlin.n.n.aL(parama)) {
                break label751;
              }
              break label768;
              if ((i == 0) && ((com.tencent.mm.plugin.appbrand.appcache.p)paramString.SYG != null))
              {
                parama = bME();
                kotlin.g.b.p.g(parama, "this");
                paramList = (com.tencent.mm.plugin.appbrand.m.i)parama;
                new com.tencent.mm.plugin.ab.p((com.tencent.mm.plugin.ab.q)new j((String)localObject1)).f(paramList);
                new j((k)new k(this, str)).f(paramList);
                paramList = "WebPrefetcher#" + str + '#' + (String)localObject1;
                kotlin.g.b.p.h("prefetcher", "type");
                kotlin.g.b.p.h(str, "appId");
                com.tencent.mm.plugin.ac.c.a(this, parama, paramList, "prefetcher", null, new com.tencent.mm.plugin.ac.c.a(str, aWQ("prefetcher").getLong("idKey")), 8);
                Log.i(this.gVB, "configPreFetcher ".concat(String.valueOf("/prefetcher.js")));
                parama.evaluateJavascript(com.tencent.mm.plugin.ac.c.b.b((com.tencent.mm.plugin.appbrand.appcache.p)paramString.SYG, "/prefetcher.js"), (ValueCallback)new g(this, (String)localObject1, str, paramString));
              }
              return;
              paramString = "";
              break;
              i = 0;
            }
          }
          catch (Exception parama)
          {
            for (;;)
            {
              Log.e(this.gVB, "create bizPkg ex:" + str + '#' + (String)localObject1 + ' ' + parama.getMessage());
            }
          }
        }
        parama = "";
      }
      catch (Exception parama)
      {
        Log.printErrStackTrace(this.gVB, (Throwable)parama, "create id=".concat(String.valueOf(localObject1)), new Object[0]);
        return;
      }
      continue;
      label751:
      int i = 0;
      continue;
      a((String)localObject1, paramString, paramList, paramb);
      return;
      label768:
      i = 1;
    }
  }
  
  public final void a(d paramd)
  {
    kotlin.g.b.p.h(paramd, "interceptor");
    paramd.b(this);
    this.ICu.add(paramd);
  }
  
  public final com.tencent.mm.ab.i aWQ(String paramString)
  {
    kotlin.g.b.p.h(paramString, "type");
    paramString = fWB().FJ("client").FJ(paramString);
    kotlin.g.b.p.g(paramString, "vmConfig.getJSONObject(\"…ent\").getJSONObject(type)");
    return paramString;
  }
  
  public final com.tencent.mm.plugin.ac.c.a aWx(String paramString)
  {
    kotlin.g.b.p.h(paramString, "type");
    return new com.tencent.mm.plugin.ac.c.a("wx97b7aebac2183fd2", aWQ(paramString).getLong("idKey"));
  }
  
  public abstract void aer(String paramString);
  
  public final com.tencent.mm.plugin.ac.g fWy()
  {
    return this.IzE;
  }
  
  public final com.tencent.mm.plugin.appbrand.appcache.p fWz()
  {
    return (com.tencent.mm.plugin.appbrand.appcache.p)this.IzH.getValue();
  }
  
  public final String fXf()
  {
    return "WebPrefetcherJsEngine";
  }
  
  public final void ly(String paramString1, String paramString2)
  {
    kotlin.g.b.p.h(paramString1, "message");
    kotlin.g.b.p.h(paramString2, "targetOrigin");
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webprefetcher/WebPrefetcherJsEngine$Companion;", "", "()V", "TAG", "", "kvSlot", "Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "manifestContent", "Lcom/tencent/mm/plugin/webprefetcher/WebPrefetcherFile;", "getManifestContent", "()Lcom/tencent/mm/plugin/webprefetcher/WebPrefetcherFile;", "mimeMap", "", "prefetchBasePkgAppId", "prefetchUsePkgOpen", "", "getPrefetchUsePkgOpen", "()Z", "prefetchUsePkgOpen$delegate", "Lkotlin/Lazy;", "resContent", "getResContent", "webContent", "getWebContent", "getMimeType", "uri", "Landroid/net/Uri;", "match", "Lcom/tencent/mm/plugin/webprefetcher/PrefetchManifest;", "url", "settingManager", "matchDebugManifest", "host", "matchResource", "Lcom/tencent/xweb/WebResourceResponse;", "appId", "webview-sdk_release"})
  public static final class a
  {
    public static a a(String paramString, MMKVSlotManager paramMMKVSlotManager)
    {
      AppMethodBeat.i(224926);
      kotlin.g.b.p.h(paramString, "url");
      kotlin.g.b.p.h(paramMMKVSlotManager, "settingManager");
      Uri localUri = Uri.parse(paramString);
      kotlin.g.b.p.g(localUri, "uri");
      Object localObject1 = aWT(localUri.getHost());
      if (localObject1 != null)
      {
        Log.i(c.access$getTAG$cp(), "matchDebug:".concat(String.valueOf(localUri)));
        AppMethodBeat.o(224926);
        return localObject1;
      }
      localObject1 = e.aWU(String.valueOf(localUri.getHost()));
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
        bhd localbhd;
        try
        {
          Object localObject2 = bhc.class.newInstance();
          ((com.tencent.mm.bw.a)localObject2).parseFrom(paramMMKVSlotManager);
          paramMMKVSlotManager = (com.tencent.mm.bw.a)localObject2;
          paramMMKVSlotManager = (bhc)paramMMKVSlotManager;
          if (paramMMKVSlotManager == null) {
            break label435;
          }
          localObject2 = paramMMKVSlotManager.LQU;
          kotlin.g.b.p.g(localObject2, "ResInfos");
          localObject2 = ((Iterable)localObject2).iterator();
          if (!((Iterator)localObject2).hasNext()) {
            break label435;
          }
          localbhd = (bhd)((Iterator)localObject2).next();
          if (localUri == null) {
            continue;
          }
          Object localObject3 = localUri.getPath();
          if (localObject3 == null) {
            continue;
          }
          String str = localbhd.xut;
          kotlin.g.b.p.g(str, "res.Path");
          if (com.tencent.luggage.h.c.B((String)localObject3, str) != true) {
            continue;
          }
          localObject3 = c.ICA;
          localObject3 = c.fXl();
          str = localbhd.LQV;
          kotlin.g.b.p.g(str, "res.ManifestUrl");
          if (!((b)localObject3).aWR(e.aWU(str)).exists()) {
            break label396;
          }
          Log.v(c.access$getTAG$cp(), "match:#" + (String)localObject1 + ", " + localbhd.xut + ", " + paramString);
          kotlin.g.b.p.g(localbhd, "res");
          paramString = new a(paramMMKVSlotManager, localbhd, false, 60);
          AppMethodBeat.o(224926);
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
        Log.w(c.access$getTAG$cp(), "manifest lost:#" + (String)localObject1 + ", " + localbhd.xut);
      }
      label435:
      Log.v(c.access$getTAG$cp(), "not match:#" + (String)localObject1 + ", " + paramString);
      AppMethodBeat.o(224926);
      return null;
    }
    
    public static a aWT(String paramString)
    {
      AppMethodBeat.i(224927);
      if ((!BuildInfo.DEBUG) && (!BuildInfo.IS_FLAVOR_RED) && (!WeChatEnvironment.hasDebugger()))
      {
        AppMethodBeat.o(224927);
        return null;
      }
      Object localObject1 = com.tencent.mm.plugin.ac.c.IBU;
      localObject1 = com.tencent.mm.plugin.ac.c.b.a("prefetcher/" + paramString + ".wspkg", true, "", "matchDebugManifest");
      if (com.tencent.mm.vfs.s.YS(((c.b.a)localObject1).cHM))
      {
        Log.i(c.access$getTAG$cp(), "matchDebugManifest " + paramString + " path=" + ((c.b.a)localObject1).cHM);
        Object localObject2 = com.tencent.mm.plugin.ac.c.IBU;
        localObject1 = com.tencent.mm.plugin.ac.c.b.a((c.b.a)localObject1, (kotlin.g.a.q)c.a.a.ICC, (kotlin.g.a.q)c.a.b.ICD, false);
        localObject2 = com.tencent.mm.plugin.ac.c.IBU;
        localObject1 = new com.tencent.mm.ab.i(com.tencent.mm.plugin.ac.c.b.a((com.tencent.mm.plugin.appbrand.appcache.p)localObject1, "/config.json"));
        localObject2 = new bhc();
        ((bhc)localObject2).LQP = ((com.tencent.mm.ab.i)localObject1).optString("domain");
        bhd localbhd = new bhd();
        localbhd.xut = ((com.tencent.mm.ab.i)localObject1).optString("path");
        localbhd.jfi = paramString;
        localbhd.LQV = ((com.tencent.mm.ab.i)localObject1).optString("manifest");
        paramString = new a((bhc)localObject2, localbhd, true, 28);
        AppMethodBeat.o(224927);
        return paramString;
      }
      AppMethodBeat.o(224927);
      return null;
    }
    
    public static boolean fXn()
    {
      AppMethodBeat.i(224925);
      f localf = c.fXi();
      a locala = c.ICA;
      boolean bool = ((Boolean)localf.getValue()).booleanValue();
      AppMethodBeat.o(224925);
      return bool;
    }
    
    public static WebResourceResponse lD(String paramString1, String paramString2)
    {
      boolean bool = false;
      AppMethodBeat.i(224928);
      kotlin.g.b.p.h(paramString2, "url");
      if (!fXn())
      {
        AppMethodBeat.o(224928);
        return null;
      }
      Object localObject1 = (CharSequence)paramString1;
      if ((localObject1 == null) || (kotlin.n.n.aL((CharSequence)localObject1))) {}
      for (int i = 1; i != 0; i = 0)
      {
        Log.d(c.access$getTAG$cp(), "matchResource fail appId=".concat(String.valueOf(paramString1)));
        AppMethodBeat.o(224928);
        return null;
      }
      Object localObject2 = Uri.parse(paramString2);
      Log.i(c.access$getTAG$cp(), "matchResource appId=".concat(String.valueOf(paramString1)));
      WxaPkg.Info localInfo;
      for (;;)
      {
        try
        {
          paramString2 = com.tencent.mm.plugin.ac.c.IBU;
          localObject1 = "prefetcher/" + paramString1 + ".wspkg";
          paramString2 = m.IAG;
          if (m.fWJ() == 1) {
            bool = true;
          }
          paramString2 = m.IAG;
          if (m.fWJ() != 1) {
            break label506;
          }
          paramString2 = m.IAG;
          paramString2 = m.aWI(paramString1);
          paramString1 = com.tencent.mm.plugin.ac.c.b.a((String)localObject1, bool, paramString2, paramString1);
          if (!com.tencent.mm.vfs.s.YS(paramString1.cHM)) {
            continue;
          }
          paramString2 = com.tencent.mm.plugin.ac.c.IBU;
          localObject1 = com.tencent.mm.plugin.ac.c.b.a(paramString1, (kotlin.g.a.q)c.a.c.ICE, (kotlin.g.a.q)c.a.d.ICF, false);
          paramString1 = new StringBuilder("/resources/");
          kotlin.g.b.p.g(localObject2, "uri");
          localInfo = ((com.tencent.mm.plugin.appbrand.appcache.p)localObject1).openReadPartialInfo(((Uri)localObject2).getHost() + ((Uri)localObject2).getPath());
          if (localInfo == null) {
            continue;
          }
          paramString1 = c.ICA;
          paramString1 = MimeTypeMap.getFileExtensionFromUrl(((Uri)localObject2).toString());
          if (paramString1 != null)
          {
            paramString1 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(paramString1);
            paramString2 = paramString1;
            if (paramString1 != null) {}
          }
          else
          {
            paramString1 = ((Uri)localObject2).getPath();
            if (paramString1 == null) {
              break label743;
            }
            paramString1 = kotlin.n.n.oD(paramString1, ".");
            if (paramString1 == null) {
              break label743;
            }
            paramString2 = (String)c.fXm().get(paramString1);
          }
        }
        catch (Exception paramString1)
        {
          Object localObject3;
          label417:
          Log.e(c.access$getTAG$cp(), "matchResource ex " + paramString1.getMessage());
          AppMethodBeat.o(224928);
          return null;
        }
        localObject2 = new HashMap();
        localObject3 = ((com.tencent.mm.plugin.appbrand.appcache.p)localObject1).openReadPartialInfo(localInfo.fileName + ".headers");
        paramString2 = paramString1;
        if (localObject3 != null)
        {
          paramString2 = com.tencent.mm.plugin.ac.c.IBU;
          paramString2 = ((WxaPkg.Info)localObject3).fileName;
          kotlin.g.b.p.g(paramString2, "it.fileName");
          localObject3 = ((Iterable)kotlin.n.n.aR((CharSequence)com.tencent.mm.plugin.ac.c.b.a((com.tencent.mm.plugin.appbrand.appcache.p)localObject1, paramString2))).iterator();
          if (!((Iterator)localObject3).hasNext()) {
            break label751;
          }
          paramString2 = (String)((Iterator)localObject3).next();
          String str = kotlin.n.n.oz(paramString2, ":");
          if (str == null)
          {
            paramString1 = new t("null cannot be cast to non-null type kotlin.CharSequence");
            AppMethodBeat.o(224928);
            throw paramString1;
            label506:
            paramString2 = m.IAG.aWH(paramString1);
            continue;
          }
          str = kotlin.n.n.trim((CharSequence)str).toString();
          if (str == null)
          {
            paramString1 = new t("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(224928);
            throw paramString1;
          }
          str = str.toLowerCase();
          kotlin.g.b.p.g(str, "(this as java.lang.String).toLowerCase()");
          paramString2 = kotlin.n.n.oB(paramString2, ":");
          if (paramString2 == null)
          {
            paramString1 = new t("null cannot be cast to non-null type kotlin.CharSequence");
            AppMethodBeat.o(224928);
            throw paramString1;
          }
          paramString2 = kotlin.n.n.trim((CharSequence)paramString2).toString();
          ((Map)localObject2).put(str, paramString2);
          if (!kotlin.g.b.p.j(str, "content-type")) {
            break label727;
          }
          paramString1 = paramString2;
          break label748;
        }
      }
      for (;;)
      {
        ((Map)localObject2).put("content-length", String.valueOf(localInfo.kKK));
        paramString2 = new WebResourceResponse(paramString2, null, 200, "OK", (Map)localObject2, ((com.tencent.mm.plugin.appbrand.appcache.p)localObject1).UR(localInfo.fileName));
        if (!(localObject1 instanceof Closeable)) {}
        for (paramString1 = null;; paramString1 = (String)localObject1)
        {
          IO.safeClose((Closeable)paramString1);
          AppMethodBeat.o(224928);
          return paramString2;
        }
        label727:
        break label748;
        for (;;)
        {
          paramString1 = paramString2;
          if (paramString2 != null) {
            break;
          }
          paramString1 = "text/plain";
          break;
          label743:
          paramString2 = null;
        }
        label748:
        break label417;
        label751:
        paramString2 = paramString1;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "assetsVersion", "", "resVersion", "resPkg", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.q<Integer, Integer, com.tencent.mm.plugin.appbrand.appcache.p, Boolean>
  {
    c(c paramc)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/webprefetcher/WebPrefetcherJsEngine$create$1$1", "Lcom/tencent/mm/plugin/webjsapi/WxPrefetcherClientContext;", "id", "", "getId", "()Ljava/lang/String;", "webview-sdk_release"})
  public static final class e
    implements com.tencent.mm.plugin.ab.q
  {
    private final String id;
    
    e(c paramc, String paramString1, z.f paramf1, z.f paramf2, String paramString2, kotlin.g.a.b paramb)
    {
      AppMethodBeat.i(224932);
      this.id = this.pAg;
      AppMethodBeat.o(224932);
    }
    
    public final String getId()
    {
      return this.id;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onReceiveValue", "com/tencent/mm/plugin/webprefetcher/WebPrefetcherJsEngine$create$1$2"})
  static final class f<T>
    implements ValueCallback<String>
  {
    f(com.tencent.mm.plugin.appbrand.m.g paramg, c paramc, String paramString1, z.f paramf1, z.f paramf2, String paramString2, kotlin.g.a.b paramb) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onReceiveValue", "com/tencent/mm/plugin/webprefetcher/WebPrefetcherJsEngine$create$2$1"})
  static final class g<T>
    implements ValueCallback<String>
  {
    g(c paramc, String paramString1, String paramString2, z.f paramf) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "cxt", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJSContext;", "invoke"})
  static final class h
    extends kotlin.g.b.q
    implements kotlin.g.a.b<com.tencent.mm.plugin.appbrand.m.g, x>
  {
    h(c paramc, String paramString1, String paramString2, List paramList, kotlin.g.a.b paramb)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/webprefetcher/WebPrefetcherJsEngine$onConfigClient$1", "Lcom/tencent/mm/plugin/webjsapi/WxPrefetcherClientContext;", "id", "", "getId", "()Ljava/lang/String;", "webview-sdk_release"})
  public static final class j
    implements com.tencent.mm.plugin.ab.q
  {
    private final String id;
    
    j(String paramString)
    {
      this.id = paramString;
    }
    
    public final String getId()
    {
      return this.id;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/webprefetcher/WebPrefetcherJsEngine$onConfigClient$2", "Lcom/tencent/mm/plugin/webjsapi/WxJsEngineContextAPIContext;", "basePkgVersion", "", "getBasePkgVersion", "()I", "bizPkgVersion", "getBizPkgVersion", "jsApiHandler", "Lcom/tencent/mm/plugin/webview/jsapi/IWebCanvasJsApiHandler;", "getJsApiHandler", "()Lcom/tencent/mm/plugin/webview/jsapi/IWebCanvasJsApiHandler;", "dispatch", "", "eventType", "", "event", "cb", "Landroid/webkit/ValueCallback;", "getLocalData", "key", "onInvoke", "func", "message", "setLocalData", "data", "validCgi", "", "cmdId", "cgiUrl", "webview-sdk_release"})
  public static final class k
    implements k
  {
    k(String paramString) {}
    
    public final boolean aD(int paramInt, String paramString)
    {
      AppMethodBeat.i(224939);
      kotlin.g.b.p.h(paramString, "cgiUrl");
      AppMethodBeat.o(224939);
      return false;
    }
    
    public final void b(String paramString1, String paramString2, ValueCallback<String> paramValueCallback)
    {
      AppMethodBeat.i(224944);
      kotlin.g.b.p.h(paramString1, "eventType");
      kotlin.g.b.p.h(paramString2, "event");
      this.ICB.b(paramString1, paramString2, paramValueCallback);
      AppMethodBeat.o(224944);
    }
    
    public final com.tencent.mm.plugin.webview.d.d cna()
    {
      AppMethodBeat.i(224942);
      com.tencent.mm.plugin.webview.d.d locald = (com.tencent.mm.plugin.webview.d.d)new a();
      AppMethodBeat.o(224942);
      return locald;
    }
    
    public final void fe(String paramString1, String paramString2)
    {
      AppMethodBeat.i(224943);
      kotlin.g.b.p.h(paramString1, "func");
      kotlin.g.b.p.h(paramString2, "message");
      AppMethodBeat.o(224943);
    }
    
    public final int getBasePkgVersion()
    {
      AppMethodBeat.i(224937);
      int i = this.ICB.fWz().version();
      AppMethodBeat.o(224937);
      return i;
    }
    
    public final int getBizPkgVersion()
    {
      AppMethodBeat.i(224938);
      Object localObject = c.a(this.ICB, str);
      if (localObject != null) {}
      for (localObject = Integer.valueOf(((com.tencent.mm.plugin.appbrand.appcache.p)localObject).version());; localObject = null)
      {
        int i = ((Integer)localObject).intValue();
        AppMethodBeat.o(224938);
        return i;
      }
    }
    
    public final String getLocalData(String paramString)
    {
      AppMethodBeat.i(224941);
      kotlin.g.b.p.h(paramString, "key");
      try
      {
        String str = ((MultiProcessMMKV)c.fXh().getSlot()).decodeString(str + "-key", "");
        Log.d(c.a(this.ICB), "getLocalData:" + paramString + ", " + str);
        paramString = str;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace(c.a(this.ICB), (Throwable)localException, "getLocalData:".concat(String.valueOf(paramString)), new Object[0]);
          paramString = null;
        }
      }
      AppMethodBeat.o(224941);
      return paramString;
    }
    
    public final void setLocalData(String paramString1, String paramString2)
    {
      AppMethodBeat.i(224940);
      kotlin.g.b.p.h(paramString1, "key");
      kotlin.g.b.p.h(paramString2, "data");
      try
      {
        ((MultiProcessMMKV)c.fXh().getSlot()).encode(str + "-key", paramString2);
        Log.d(c.a(this.ICB), "setLocalData:" + paramString1 + ", " + paramString2);
        AppMethodBeat.o(224940);
        return;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace(c.a(this.ICB), (Throwable)localException, "setLocalData:" + paramString1 + ", " + paramString2, new Object[0]);
        AppMethodBeat.o(224940);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/webprefetcher/WebPrefetcherJsEngine$onConfigClient$2$jsApiHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/IWebCanvasJsApiHandler;", "dealMsg", "", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "callbackHandler", "Lcom/tencent/mm/plugin/webview/jsapi/ICallbackHandler;", "setJsEngineContext", "ct", "Landroid/content/Context;", "webview-sdk_release"})
    public static final class a
      implements com.tencent.mm.plugin.webview.d.d
    {
      public final void a(com.tencent.mm.plugin.webview.d.n paramn, com.tencent.mm.plugin.webview.d.b paramb) {}
      
      public final void eQ(Context paramContext) {}
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "invoke"})
  static final class l
    extends kotlin.g.b.q
    implements kotlin.g.a.a<com.tencent.mm.plugin.appbrand.appcache.p>
  {
    public static final l ICN;
    
    static
    {
      AppMethodBeat.i(224950);
      ICN = new l();
      AppMethodBeat.o(224950);
    }
    
    l()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ad.c
 * JD-Core Version:    0.7.0.1
 */