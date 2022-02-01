package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import android.net.Uri;
import com.tencent.mars.cdn.CronetLogic;
import com.tencent.mars.cdn.CronetLogic.CronetDownloadProgress;
import com.tencent.mars.cdn.CronetLogic.CronetTaskCallback;
import com.tencent.mars.cdn.CronetLogic.CronetTaskResult;
import com.tencent.mars.cdn.CronetLogic.ResponseHeader;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.network.x;
import com.tencent.mm.plugin.brandservice.a.d.a;
import com.tencent.mm.plugin.brandservice.a.d.b;
import com.tencent.mm.plugin.brandservice.c.a;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.webview.core.f.a;
import com.tencent.mm.protocal.protobuf.avb;
import com.tencent.mm.protocal.protobuf.avc;
import com.tencent.mm.protocal.protobuf.avd;
import com.tencent.mm.protocal.protobuf.ave;
import com.tencent.mm.protocal.protobuf.avf;
import com.tencent.mm.protocal.protobuf.avg;
import com.tencent.mm.protocal.protobuf.avh;
import com.tencent.mm.protocal.protobuf.bos;
import com.tencent.mm.protocal.protobuf.eeg;
import com.tencent.mm.protocal.protobuf.eeh;
import com.tencent.mm.protocal.protobuf.eei;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.by;
import com.tencent.xweb.WebResourceResponse;
import d.a.ae;
import d.d.d;
import d.g.a.m;
import d.g.b.p;
import d.g.b.q;
import d.g.b.y.a;
import d.l;
import d.n.n;
import d.z;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.List<+Lcom.tencent.mm.plugin.brandservice.a.d.a;>;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import kotlinx.coroutines.ah;
import kotlinx.coroutines.ai;
import kotlinx.coroutines.at;
import kotlinx.coroutines.az;
import kotlinx.coroutines.bk;
import kotlinx.coroutines.br;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher;", "", "()V", "MIN_EXPIRE_SECONDS", "", "PRE_AUTH_EXPIRE_SECONDS", "REFRESH_BEFORE_EXPIRE_SECONDS", "value", "currentScene", "getCurrentScene", "()I", "setCurrentScene", "(I)V", "manifestContent", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcherFile;", "getManifestContent$plugin_brandservice_release", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcherFile;", "preauthRequestLimiter", "Lcom/tencent/mm/sdk/platformtools/MMCacheSlotManager;", "getPreauthRequestLimiter$plugin_brandservice_release", "()Lcom/tencent/mm/sdk/platformtools/MMCacheSlotManager;", "resContent", "getResContent$plugin_brandservice_release", "resHeadersManager", "Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "getResHeadersManager$plugin_brandservice_release", "()Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "sendingGetA8keyLiteQueue", "Ljava/util/concurrent/ConcurrentSkipListSet;", "", "settingManager", "getSettingManager$plugin_brandservice_release", "userAgentInfo", "Lcom/tencent/mm/plugin/webview/util/WebPrefetchUserAgentInfo;", "getUserAgentInfo", "()Lcom/tencent/mm/plugin/webview/util/WebPrefetchUserAgentInfo;", "userAgentInfo$delegate", "Lkotlin/Lazy;", "webContent", "getWebContent$plugin_brandservice_release", "webHeadersManager", "getWebHeadersManager$plugin_brandservice_release", "webIdToSceneManager", "getWebIdToSceneManager$plugin_brandservice_release", "clearPrefetchContent", "", "url", "debugPreloadWebInfo", "", "(Ljava/lang/String;)[[Ljava/lang/String;", "fetchContent", "Lcom/tencent/mm/network/MMHttpUrlCronetConnection;", "host", "target", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchTarget;", "deep", "prefetchHeaders", "", "fetchManifest", "", "manifest", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PrefetchManifest;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PrefetchManifest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchRes", "batchRes", "", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchRes;", "getPreAuthUrl", "getPrefetchContentResp", "Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService$PrefetchResponse;", "getPrefetchResResp", "referer", "getReportScene", "getRespUrl", "getUrlCookie", "getUrlScene", "getValidPreloadWebInfo", "Lcom/tencent/mm/protocal/protobuf/WebPrefetchInfo;", "isDnsCached", "isInPreAuthWhiteList", "isUrlCache", "isUrlPreAuthed", "isWebUrlEqual", "rawUrl", "targetUrl", "isWebUrlStorageEqual", "matchManifest", "domains", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyLitePrefetchDomainInfo;", "needReauth", "preAuth", "appId", "title", "desc", "from", "scene", "preAuths", "auths", "Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService$PreAuthInfo;", "preDns", "urls", "prefetch", "prefetchUrl", "checkCacheOnly", "headers", "sendGetA8KeyLiteRequest", "preauths", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$BatchPreauth;", "setUrlToScene", "connect", "receiveHeader", "Lkotlin/Function1;", "targetFile", "Lcom/tencent/mm/vfs/VFSFile;", "onCompleted", "mockManifest", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyLiteResponse;", "prepare", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyLiteRequest;", "save", "saveDomainInfos", "saveManifest", "localPrefetchDomainInfos", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protobuf/ByteString;", "savePrefetch", "request", "BatchPreauth", "PrefetchAction", "PrefetchRes", "PrefetchTarget", "PrefetchType", "plugin-brandservice_release"})
public final class t
{
  private static final ar ojW;
  private static final ar ojX;
  private static final ar ojY;
  private static final v ojZ;
  private static final v oka;
  private static final v okb;
  private static final ConcurrentSkipListSet<String> okc;
  private static final d.f okd;
  private static final al oke;
  private static final ar okf;
  public static final t okg;
  
  static
  {
    AppMethodBeat.i(6809);
    okg = new t();
    ojW = new ar(s.bPI(), 604800L);
    ojX = new ar(s.bPI(), 86400L);
    ojY = new ar(s.bPI(), 604800L);
    ojZ = new v("wcf://WebPrefetchContent/");
    oka = new v("wcf://WebPrefetchResource/");
    okb = new v("wcf://WebPrefetchManifest/");
    okc = new ConcurrentSkipListSet();
    okd = d.g.O((d.g.a.a)r.olA);
    oke = new al();
    okf = new ar(s.bPI(), 86400L);
    AppMethodBeat.o(6809);
  }
  
  public static boolean WS(String paramString)
  {
    AppMethodBeat.i(209931);
    p.h(paramString, "url");
    if (XD(paramString) != null)
    {
      AppMethodBeat.o(209931);
      return true;
    }
    AppMethodBeat.o(209931);
    return false;
  }
  
  public static int WV(String paramString)
  {
    AppMethodBeat.i(175492);
    int i;
    switch (bPQ())
    {
    default: 
      i = bPQ();
      AppMethodBeat.o(175492);
      return i;
    }
    if (paramString != null)
    {
      XG(paramString);
      i = XG(paramString);
      AppMethodBeat.o(175492);
      return i;
    }
    AppMethodBeat.o(175492);
    return 0;
  }
  
  public static d.b WW(String paramString)
  {
    AppMethodBeat.i(209925);
    p.h(paramString, "url");
    paramString = new d(paramString, b.Xn(paramString), ojZ, ojX).bQa();
    AppMethodBeat.o(209925);
    return paramString;
  }
  
  public static void WX(String paramString)
  {
    AppMethodBeat.i(6803);
    p.h(paramString, "url");
    Object localObject1 = b.Xn(paramString);
    Object localObject2 = ojZ.XH((String)localObject1);
    if (((com.tencent.mm.vfs.e)localObject2).exists()) {
      ((com.tencent.mm.vfs.e)localObject2).delete();
    }
    localObject2 = (ax)ojX.aQb((String)localObject1);
    if (localObject2 != null) {
      ((ax)localObject2).remove((String)localObject1);
    }
    localObject1 = k.ojs;
    localObject1 = (ax)k.bPx().aQb(b.Xn(paramString));
    if (localObject1 != null)
    {
      ((ax)localObject1).removeValueForKey(b.Xn(paramString));
      AppMethodBeat.o(6803);
      return;
    }
    AppMethodBeat.o(6803);
  }
  
  private static boolean XB(String paramString)
  {
    AppMethodBeat.i(209924);
    p.h(paramString, "url");
    paramString = new d(paramString, b.Xn(paramString), ojZ, ojX);
    boolean bool1 = paramString.bPZ();
    boolean bool2 = paramString.isRedirect();
    if ((bool1) && (!bool2))
    {
      AppMethodBeat.o(209924);
      return true;
    }
    if (bool2)
    {
      if (((CharSequence)paramString.getLocation()).length() > 0) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label96;
        }
        paramString = paramString.getLocation();
        break;
      }
    }
    label96:
    AppMethodBeat.o(209924);
    return false;
  }
  
  public static eei XD(String paramString)
  {
    AppMethodBeat.i(209930);
    String str = b.Xn(paramString);
    Object localObject1 = k.ojs;
    localObject1 = (ax)k.bPx().aQb(str);
    int i;
    if (localObject1 != null) {
      if (((ax)localObject1).containsKey(str))
      {
        localObject1 = ((ax)localObject1).decodeBytes(str);
        if (localObject1 != null) {
          if (localObject1.length == 0)
          {
            i = 1;
            if (i != 0) {
              break label246;
            }
            i = 1;
            label65:
            if (i == 0) {
              break label269;
            }
          }
        }
      }
    }
    label246:
    eei localeei;
    for (;;)
    {
      try
      {
        Object localObject2 = eei.class.newInstance();
        ((com.tencent.mm.bx.a)localObject2).parseFrom((byte[])localObject1);
        localObject1 = (com.tencent.mm.bx.a)localObject2;
        localObject1 = (eei)localObject1;
        if (localObject1 == null) {
          break label323;
        }
        boolean bool = as.al(((eei)localObject1).iud, 600);
        ad.v("MicroMsg.WebPrefetcher", "[TRACE_PREFETCH] getValidPreloadWebInfo: webId#" + str + ", bizId: " + ((eei)localObject1).dwX + "  prefetch:" + ((eei)localObject1).HPz + ", authorized:" + ((eei)localObject1).HPy + ", antispam:" + ((eei)localObject1).HPx + ", lastModify:" + ((eei)localObject1).iud + ", expire:" + bool + ", url:" + paramString);
        if ((!((eei)localObject1).HPx) && (!bool)) {
          break label279;
        }
        AppMethodBeat.o(209930);
        return null;
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", (Throwable)localException, "decode ProtoBuffer", new Object[0]);
      }
      i = 0;
      break;
      i = 0;
      break label65;
      label269:
      localeei = null;
      continue;
      localeei = null;
    }
    label279:
    if (!localeei.HPy)
    {
      AppMethodBeat.o(209930);
      return localeei;
    }
    if ((localeei.HPz) && (localeei.HPy) && (XB(paramString)))
    {
      AppMethodBeat.o(209930);
      return localeei;
    }
    label323:
    ad.v("MicroMsg.WebPrefetcher", "[TRACE_PREFETCH] getVaildPreloadWebInfo: webId#" + str + ", not cached, url:" + paramString + ' ');
    AppMethodBeat.o(209930);
    return null;
  }
  
  private static boolean XE(String paramString)
  {
    AppMethodBeat.i(6806);
    String str = b.Xn(paramString);
    Object localObject1 = k.ojs;
    localObject1 = (ax)k.bPx().aQb(str);
    int i;
    if (localObject1 != null) {
      if (((ax)localObject1).containsKey(str))
      {
        localObject1 = ((ax)localObject1).decodeBytes(str);
        if (localObject1 != null) {
          if (localObject1.length == 0)
          {
            i = 1;
            if (i != 0) {
              break label210;
            }
            i = 1;
            label73:
            if (i == 0) {
              break label235;
            }
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        Object localObject3 = eei.class.newInstance();
        ((com.tencent.mm.bx.a)localObject3).parseFrom((byte[])localObject1);
        localObject1 = (com.tencent.mm.bx.a)localObject3;
        localObject1 = (eei)localObject1;
        if (localObject1 == null) {
          break label247;
        }
        bool2 = as.al(((eei)localObject1).iud, 540);
        bool1 = bool2;
        bool3 = true;
        ad.v("MicroMsg.WebPrefetcher", "[TRACE_PREFETCH] needReauth:" + bool1 + ", webId:" + str + ", cached:" + bool3 + ", expired:" + bool2 + ", url:" + paramString);
        AppMethodBeat.o(6806);
        return bool1;
      }
      catch (Exception localException)
      {
        label210:
        ad.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", (Throwable)localException, "decode ProtoBuffer", new Object[0]);
      }
      i = 0;
      break;
      i = 0;
      break label73;
      label235:
      Object localObject2 = null;
      continue;
      localObject2 = null;
      continue;
      label247:
      boolean bool1 = true;
      boolean bool2 = false;
      boolean bool3 = false;
    }
  }
  
  private static boolean XF(String paramString)
  {
    AppMethodBeat.i(209932);
    Object localObject1 = Uri.parse(UrlExKt.getWithProtocol(paramString));
    if (localObject1 != null)
    {
      localObject1 = ((Uri)localObject1).getHost();
      if (localObject1 != null)
      {
        localObject1 = b.Xp((String)localObject1);
        Object localObject3 = (ax)ojW.aQb((String)localObject1);
        int i;
        if (localObject3 != null) {
          if (((ax)localObject3).containsKey((String)localObject1))
          {
            localObject1 = ((ax)localObject3).decodeBytes((String)localObject1);
            if (localObject1 != null) {
              if (localObject1.length == 0)
              {
                i = 1;
                if (i != 0) {
                  break label176;
                }
                i = 1;
                label82:
                if (i == 0) {
                  break label199;
                }
              }
            }
          }
        }
        for (;;)
        {
          try
          {
            localObject3 = avb.class.newInstance();
            ((com.tencent.mm.bx.a)localObject3).parseFrom((byte[])localObject1);
            localObject1 = (com.tencent.mm.bx.a)localObject3;
            localObject1 = (avb)localObject1;
            if (localObject1 == null) {
              break label214;
            }
            if ((((avb)localObject1).Gtm != 1) || (as.al(((avb)localObject1).Gto, ((avb)localObject1).Gtn))) {
              break label209;
            }
            bool = true;
            if (bool) {
              ad.v("MicroMsg.WebPrefetcher", "[TRACE_PREFETCH] preauth cancelled, in whiteList:".concat(String.valueOf(paramString)));
            }
            AppMethodBeat.o(209932);
            return bool;
          }
          catch (Exception localException)
          {
            label176:
            ad.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", (Throwable)localException, "decode ProtoBuffer", new Object[0]);
          }
          i = 0;
          break;
          i = 0;
          break label82;
          label199:
          Object localObject2 = null;
          continue;
          localObject2 = null;
          continue;
          label209:
          boolean bool = false;
          continue;
          label214:
          bool = false;
        }
      }
    }
    AppMethodBeat.o(209932);
    return false;
  }
  
  private static int XG(String paramString)
  {
    AppMethodBeat.i(175488);
    ax localax = (ax)okf.aQb(b.Xn(paramString));
    if (localax != null)
    {
      int i = localax.getInt(b.Xn(paramString), 0);
      AppMethodBeat.o(175488);
      return i;
    }
    AppMethodBeat.o(175488);
    return 0;
  }
  
  public static final void a(String arg0, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt)
  {
    AppMethodBeat.i(209927);
    p.h(???, "url");
    p.h(paramString2, "appId");
    p.h(paramString3, "title");
    p.h(paramString4, "desc");
    p.h(paramString5, "from");
    ad.v("MicroMsg.WebPrefetcher", "preAuth: " + paramString3 + ' ' + ???);
    paramString4 = new a(???, paramString2, paramString3, paramString4, paramInt, null, null, 96);
    paramString2 = okg;
    paramString3 = a.class.getCanonicalName() + '_' + "addToPreload";
    synchronized (by.IgT)
    {
      paramString5 = by.IgT;
      paramString5 = (br)by.fmc().get(paramString3);
      if (paramString5 != null) {
        paramString5.gvD();
      }
      paramString5 = by.IgT;
      paramString5 = by.fmd();
      if (!paramString5.containsKey(paramString3)) {
        ((Map)paramString5).put(paramString3, new LinkedList());
      }
      paramString5 = paramString5.get(paramString3);
      if (paramString5 == null)
      {
        paramString2 = new d.v("null cannot be cast to non-null type java.util.LinkedList<T>");
        AppMethodBeat.o(209927);
        throw paramString2;
      }
    }
    ((LinkedList)paramString5).add(paramString4);
    ??? = by.IgT;
    ((Map)by.fmc()).put(paramString3, kotlinx.coroutines.f.b((ah)bk.NII, (d.d.f)az.gvp(), (m)new k(1000L, paramString3, null, paramString2), 2));
    AppMethodBeat.o(209927);
  }
  
  private static void a(String arg0, String paramString2, Map<String, String> paramMap)
  {
    AppMethodBeat.i(209922);
    paramMap = new b(b.Xm(???), ???, paramString2, paramMap);
    paramString2 = b.class.getCanonicalName() + '_' + "batch";
    Object localObject;
    synchronized (by.IgT)
    {
      localObject = by.IgT;
      localObject = (br)by.fmc().get(paramString2);
      if (localObject != null) {
        ((br)localObject).gvD();
      }
      localObject = by.IgT;
      localObject = by.fmd();
      if (!((HashMap)localObject).containsKey(paramString2)) {
        ((Map)localObject).put(paramString2, new LinkedList());
      }
      localObject = ((HashMap)localObject).get(paramString2);
      if (localObject == null)
      {
        paramString2 = new d.v("null cannot be cast to non-null type java.util.LinkedList<T>");
        AppMethodBeat.o(209922);
        throw paramString2;
      }
    }
    ((LinkedList)localObject).add(paramMap);
    ??? = by.IgT;
    ((Map)by.fmc()).put(paramString2, kotlinx.coroutines.f.b((ah)bk.NII, (d.d.f)az.gvp(), (m)new m(50L, paramString2, null), 2));
    AppMethodBeat.o(209922);
  }
  
  public static ar bPJ()
  {
    return ojW;
  }
  
  public static ar bPK()
  {
    return ojX;
  }
  
  public static ar bPL()
  {
    return ojY;
  }
  
  public static v bPM()
  {
    return ojZ;
  }
  
  public static v bPN()
  {
    return oka;
  }
  
  public static v bPO()
  {
    return okb;
  }
  
  public static al bPP()
  {
    return oke;
  }
  
  private static int bPQ()
  {
    AppMethodBeat.i(175490);
    ax localax = ax.aQz("WebPrefetcher.currentScene");
    if (localax != null)
    {
      int i = localax.decodeInt("currentScene");
      AppMethodBeat.o(175490);
      return i;
    }
    AppMethodBeat.o(175490);
    return 0;
  }
  
  public static boolean cA(String paramString, int paramInt)
  {
    AppMethodBeat.i(175489);
    p.h(paramString, "url");
    boolean bool = ((ax)okf.fjV()).encode(b.Xn(paramString), paramInt);
    AppMethodBeat.o(175489);
    return bool;
  }
  
  public static final void cp(List<? extends d.a> paramList)
  {
    AppMethodBeat.i(160497);
    p.h(paramList, "auths");
    if (paramList.isEmpty())
    {
      AppMethodBeat.o(160497);
      return;
    }
    paramList = (Iterable)paramList;
    Collection localCollection = (Collection)new ArrayList(d.a.j.a(paramList, 10));
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      d.a locala = (d.a)localIterator.next();
      String str2 = locala.url;
      p.g(str2, "info.url");
      Object localObject1 = locala.appId;
      paramList = (List<? extends d.a>)localObject1;
      if (localObject1 == null) {
        paramList = "";
      }
      Object localObject2 = locala.title;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      String str1 = locala.desc;
      localObject2 = str1;
      if (str1 == null) {
        localObject2 = "";
      }
      localCollection.add(new a(str2, paramList, (String)localObject1, (String)localObject2, locala.nWh, null, locala.extInfo, 32));
    }
    cq((List)localCollection);
    AppMethodBeat.o(160497);
  }
  
  private static void cq(List<a> paramList)
  {
    AppMethodBeat.i(209929);
    ad.v("MicroMsg.WebPrefetcher", "[TRACE_PREFETCH] preAuths size = %s", new Object[] { Integer.valueOf(paramList.size()) });
    avf localavf = new avf();
    Object localObject1 = (Iterable)paramList;
    paramList = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    Object localObject2;
    Object localObject3;
    label171:
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      localObject3 = (a)localObject2;
      if ((!oke.contains(b.Xl(((a)localObject3).url))) && (!UrlExKt.isMpUrl(((a)localObject3).url)) && (!XF(((a)localObject3).url)) && (XE(((a)localObject3).url)) && (!okc.contains(((a)localObject3).url))) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label171;
        }
        paramList.add(localObject2);
        break;
      }
    }
    localObject1 = (Iterable)paramList;
    paramList = (Collection)new ArrayList(d.a.j.a((Iterable)localObject1, 10));
    localObject1 = ((Iterable)localObject1).iterator();
    int i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (a)((Iterator)localObject1).next();
      localObject3 = new f();
      ((f)localObject3).Gtv = ((a)localObject2).url;
      ((f)localObject3).iht = ((a)localObject2).appId;
      ((f)localObject3).Gtw = ((a)localObject2).title;
      ((f)localObject3).Gtx = ((a)localObject2).desc;
      ((f)localObject3).Gtu = i;
      ((f)localObject3).Gty = ((a)localObject2).okh;
      ((f)localObject3).Scene = ((a)localObject2).scene;
      oke.Ej(b.Xl(((a)localObject2).url));
      ((f)localObject3).extInfo = ((a)localObject2).extInfo;
      paramList.add(localObject3);
      i += 1;
    }
    paramList = (List)paramList;
    localavf.GtB.addAll((Collection)paramList);
    localavf.FCF = localavf.GtB.size();
    localavf.Scene = 0;
    localavf.FzW = 0;
    if (localavf.GtB.isEmpty())
    {
      ad.v("MicroMsg.WebPrefetcher", "[TRACE_PREFETCH] preAuths: nothing to preauth");
      AppMethodBeat.o(209929);
      return;
    }
    try
    {
      paramList = okc;
      localObject1 = localavf.GtB;
      p.g(localObject1, "req.ReqInfo");
      localObject2 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        ((Collection)localObject1).add(((ave)((Iterator)localObject2).next()).Gtv);
        continue;
        paramList = com.tencent.mm.plugin.webview.core.f.DHt;
      }
    }
    catch (Exception paramList)
    {
      ad.e("MicroMsg.WebPrefetcher", "Concurrent Add Exception: " + paramList.getMessage());
    }
    for (;;)
    {
      if (f.a.eNz()) {
        CronetLogic.setUserCertVerify(true);
      }
      paramList = new StringBuilder("[TRACE_PREFETCH] sendGetA8KeyLiteRequest batch req: ");
      localObject1 = localavf.GtB;
      p.g(localObject1, "req.ReqInfo");
      ad.v("MicroMsg.WebPrefetcher", d.a.j.a((Iterable)localObject1, (CharSequence)",", null, null, 0, null, (d.g.a.b)p.olx, 30));
      com.tencent.mm.ad.c.b("MicroMsg.WebPrefetcher", (d.g.a.a)new q(localavf));
      AppMethodBeat.o(209929);
      return;
      paramList.addAll((Collection)localObject1);
    }
  }
  
  public static d.b eJ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(209926);
    p.h(paramString1, "referer");
    p.h(paramString2, "url");
    paramString1 = new d(paramString2, b.eL(b.Xm(paramString1), paramString2), oka, ojY).bQa();
    AppMethodBeat.o(209926);
    return paramString1;
  }
  
  public static boolean eP(String paramString1, String paramString2)
  {
    AppMethodBeat.i(209933);
    String str = new d(paramString1, b.Xn(paramString1), ojZ, ojX).getLocation();
    if (!n.aE((CharSequence)str)) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramString1 = b.aF(str, true);
      ad.v("MicroMsg.WebPrefetcher", "isWebUrlStorageEqual: location:#" + paramString1 + ", " + str);
      paramString2 = b.aF(paramString2, true);
      ad.v("MicroMsg.WebPrefetcher", "isWebUrlStorageEqual: target:#".concat(String.valueOf(paramString2)));
      boolean bool = p.i(paramString1, paramString2);
      AppMethodBeat.o(209933);
      return bool;
    }
    AppMethodBeat.o(209933);
    return false;
  }
  
  public static void zJ(int paramInt)
  {
    AppMethodBeat.i(175491);
    ax localax = ax.aQz("WebPrefetcher.currentScene");
    if (localax != null)
    {
      localax.encode("currentScene", paramInt);
      AppMethodBeat.o(175491);
      return;
    }
    AppMethodBeat.o(175491);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$BatchPreauth;", "", "url", "", "appId", "title", "desc", "scene", "", "refer", "extInfo", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getDesc", "getExtInfo", "getRefer", "getScene", "()I", "getTitle", "getUrl", "plugin-brandservice_release"})
  static final class a
  {
    final String appId;
    final String desc;
    final String extInfo;
    final String okh;
    final int scene;
    final String title;
    final String url;
    
    private a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5, String paramString6)
    {
      AppMethodBeat.i(209848);
      this.url = paramString1;
      this.appId = paramString2;
      this.title = paramString3;
      this.desc = paramString4;
      this.scene = paramInt;
      this.okh = paramString5;
      this.extInfo = paramString6;
      AppMethodBeat.o(209848);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchAction;", "", "host", "", "rawUrl", "prefetchUrl", "checkCacheOnly", "", "prefetchHeader", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/util/Map;)V", "getCheckCacheOnly", "()Z", "getHost", "()Ljava/lang/String;", "getPrefetchHeader", "()Ljava/util/Map;", "getPrefetchUrl", "getRawUrl", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "plugin-brandservice_release"})
  static final class b
  {
    final String dKk;
    final String host;
    final String oki;
    final boolean okj;
    final Map<String, String> okk;
    
    public b(String paramString1, String paramString2, String paramString3, Map<String, String> paramMap)
    {
      AppMethodBeat.i(209850);
      this.host = paramString1;
      this.dKk = paramString2;
      this.oki = paramString3;
      this.okj = false;
      this.okk = paramMap;
      AppMethodBeat.o(209850);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(209853);
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if ((!p.i(this.host, paramObject.host)) || (!p.i(this.dKk, paramObject.dKk)) || (!p.i(this.oki, paramObject.oki)) || (this.okj != paramObject.okj) || (!p.i(this.okk, paramObject.okk))) {}
        }
      }
      else
      {
        AppMethodBeat.o(209853);
        return true;
      }
      AppMethodBeat.o(209853);
      return false;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(209851);
      String str = "PrefetchAction(host=" + this.host + ", rawUrl=" + this.dKk + ", prefetchUrl=" + this.oki + ", checkCacheOnly=" + this.okj + ", prefetchHeader=" + this.okk + ")";
      AppMethodBeat.o(209851);
      return str;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchRes;", "", "url", "", "type", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchType;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchType;)V", "getType", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchType;", "getUrl", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-brandservice_release"})
  static final class c
  {
    final t.e okl;
    final String url;
    
    public c(String paramString, t.e parame)
    {
      AppMethodBeat.i(209854);
      this.url = paramString;
      this.okl = parame;
      AppMethodBeat.o(209854);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(209857);
      if (this != paramObject)
      {
        if ((paramObject instanceof c))
        {
          paramObject = (c)paramObject;
          if ((!p.i(this.url, paramObject.url)) || (!p.i(this.okl, paramObject.okl))) {}
        }
      }
      else
      {
        AppMethodBeat.o(209857);
        return true;
      }
      AppMethodBeat.o(209857);
      return false;
    }
    
    public final int hashCode()
    {
      int j = 0;
      AppMethodBeat.i(209856);
      Object localObject = this.url;
      if (localObject != null) {}
      for (int i = localObject.hashCode();; i = 0)
      {
        localObject = this.okl;
        if (localObject != null) {
          j = localObject.hashCode();
        }
        AppMethodBeat.o(209856);
        return i * 31 + j;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(209855);
      String str = "PrefetchRes(url=" + this.url + ", type=" + this.okl + ")";
      AppMethodBeat.o(209855);
      return str;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchTarget;", "", "url", "", "webId", "content", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcherFile;", "headerSlot", "Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcherFile;Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;)V", "bizId", "getBizId", "()Ljava/lang/String;", "bizId$delegate", "Lkotlin/Lazy;", "cacheTime", "", "getCacheTime", "()J", "cacheTime$delegate", "getContent", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcherFile;", "eTag", "getETag", "eTag$delegate", "fullUrl", "getFullUrl", "fullUrl$delegate", "getHeaderSlot", "()Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "headers", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getHeaders", "()Ljava/util/HashMap;", "headers$delegate", "isCached", "", "()Z", "isCached$delegate", "isRedirect", "isRedirect$delegate", "location", "getLocation", "location$delegate", "maxCache", "", "getMaxCache", "()I", "maxCache$delegate", "mimeType", "getMimeType", "mimeType$delegate", "prefetchHost", "getPrefetchHost", "prefetchHost$delegate", "prefetchUrl", "getPrefetchUrl", "prefetchUrl$delegate", "response", "Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService$PrefetchResponse;", "getResponse", "()Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService$PrefetchResponse;", "type", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchType;", "getType", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchType;", "type$delegate", "getUrl", "version", "getVersion", "version$delegate", "getWebId", "wxETag", "getWxETag", "wxETag$delegate", "createResponse", "refresh", "", "saveHeaders", "host", "plugin-brandservice_release"})
  static final class d
  {
    private final d.f okA;
    final String okB;
    final v okC;
    final ar okD;
    private final d.f okm;
    private final d.f okn;
    private final d.f oko;
    private final d.f okp;
    private final d.f okq;
    private final d.f okr;
    private final d.f oks;
    private final d.f okt;
    private final d.f oku;
    private final d.f okv;
    private final d.f okw;
    private final d.f okx;
    private final d.f oky;
    private final d.f okz;
    final String url;
    
    public d(String paramString1, String paramString2, v paramv, ar paramar)
    {
      AppMethodBeat.i(209891);
      this.url = paramString1;
      this.okB = paramString2;
      this.okC = paramv;
      this.okD = paramar;
      this.okm = d.g.O((d.g.a.a)new a(this));
      this.okn = d.g.O((d.g.a.a)new d(this));
      this.oko = d.g.O((d.g.a.a)new e(this));
      this.okp = d.g.O((d.g.a.a)new m(this));
      this.okq = d.g.O((d.g.a.a)new h(this));
      this.okr = d.g.O((d.g.a.a)new n(this));
      this.oks = d.g.O((d.g.a.a)new j(this));
      this.okt = d.g.O((d.g.a.a)new i(this));
      this.oku = d.g.O((d.g.a.a)new b(this));
      this.okv = d.g.O((d.g.a.a)new o(this));
      this.okw = d.g.O((d.g.a.a)new c(this));
      this.okx = d.g.O((d.g.a.a)new l(this));
      this.oky = d.g.O((d.g.a.a)new k(this));
      this.okz = d.g.O((d.g.a.a)new g(this));
      this.okA = d.g.O((d.g.a.a)new f(this));
      AppMethodBeat.o(209891);
    }
    
    private t.e bPU()
    {
      AppMethodBeat.i(209879);
      t.e locale = (t.e)this.okp.getValue();
      AppMethodBeat.o(209879);
      return locale;
    }
    
    private final d.b bQb()
    {
      AppMethodBeat.i(209889);
      int i = bPT().size();
      boolean bool = this.okC.contains(bPS());
      if ((i == 0) || (!bool))
      {
        ad.e("MicroMsg.WebPrefetcher", "createResponse fail headerSize:" + i + ", containsFile:" + bool);
        AppMethodBeat.o(209889);
        return null;
      }
      d.b localb = new d.b();
      localb.url = ((String)this.okn.getValue());
      localb.nWj = bPU().toString();
      localb.nWi = ((Number)this.okr.getValue()).longValue();
      String str = (String)this.oks.getValue();
      Object localObject1 = (Map)bPT();
      Map localMap = (Map)new LinkedHashMap(ae.aji(((Map)localObject1).size()));
      localObject1 = ((Iterable)((Map)localObject1).entrySet()).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject3 = ((Iterator)localObject1).next();
        Object localObject2 = ((Map.Entry)localObject3).getKey();
        localObject3 = (Map.Entry)localObject3;
        ((Map.Entry)localObject3).getKey();
        localMap.put(localObject2, (String)d.a.j.jc((List)((Map.Entry)localObject3).getValue()));
      }
      localb.nWk = new WebResourceResponse(str, "UTF-8", 200, "OK", localMap, com.tencent.mm.vfs.i.ai(this.okC.XH(bPS())));
      AppMethodBeat.o(209889);
      return localb;
    }
    
    private void refresh()
    {
      AppMethodBeat.i(209887);
      if ((bPU() == t.e.okH) && (bPW() > 0L) && (bPV() > 0) && (as.al(bPW(), Math.max(bPV() - 60, 60))))
      {
        t localt = t.okg;
        com.tencent.mm.plugin.webview.h.b.Xd(t.WV(this.url));
        localt = t.okg;
        t.eO(this.url, (String)this.okx.getValue());
      }
      AppMethodBeat.o(209887);
    }
    
    public final void a(t.e parame, String paramString)
    {
      AppMethodBeat.i(209890);
      p.h(parame, "type");
      p.h(paramString, "host");
      ((Map)bPT()).put("x-wx-client-cache-time", d.a.j.listOf(String.valueOf(System.currentTimeMillis())));
      ((Map)bPT()).put("x-wx-client-prefetch-url", d.a.j.listOf(this.url));
      if (!n.aE((CharSequence)paramString)) {}
      eeh localeeh;
      LinkedList localLinkedList;
      Collection localCollection;
      Object localObject;
      eeg localeeg;
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          ((Map)bPT()).put("x-wx-client-prefetch-host", d.a.j.listOf(paramString));
        }
        ((Map)bPT()).put("x-wx-client-prefetch-type", d.a.j.listOf(parame.toString()));
        localeeh = new eeh();
        localLinkedList = localeeh.HPw;
        paramString = (Map)bPT();
        localCollection = (Collection)new ArrayList(paramString.size());
        Iterator localIterator = paramString.entrySet().iterator();
        if (!localIterator.hasNext()) {
          break label403;
        }
        localObject = (Map.Entry)localIterator.next();
        paramString = (String)((Map.Entry)localObject).getKey();
        localObject = (List)((Map.Entry)localObject).getValue();
        localeeg = new eeg();
        if (paramString != null) {
          break;
        }
        parame = new d.v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(209890);
        throw parame;
      }
      String str = paramString.toLowerCase();
      p.g(str, "(this as java.lang.String).toLowerCase()");
      switch (str.hashCode())
      {
      }
      for (;;)
      {
        localeeg.key = paramString;
        localeeg.GqN.addAll((Collection)localObject);
        localCollection.add(localeeg);
        break;
        if (str.equals("set-cookie"))
        {
          paramString = "set-cookie";
          continue;
          if (str.equals("location"))
          {
            paramString = "location";
            continue;
            if (str.equals("content-type")) {
              paramString = "content-type";
            }
          }
        }
      }
      label403:
      localLinkedList.addAll((Collection)localCollection);
      ((ax)this.okD.fjV()).encode(bPS(), localeeh.toByteArray());
      ad.v("MicroMsg.WebPrefetcher", "saveHeaders " + parame + " : webId:" + this.okB + ", bizId:" + bPS() + ", header size:" + bPT().size());
      AppMethodBeat.o(209890);
    }
    
    public final String bPS()
    {
      AppMethodBeat.i(209877);
      String str = (String)this.okm.getValue();
      AppMethodBeat.o(209877);
      return str;
    }
    
    public final HashMap<String, List<String>> bPT()
    {
      AppMethodBeat.i(209878);
      HashMap localHashMap = (HashMap)this.oko.getValue();
      AppMethodBeat.o(209878);
      return localHashMap;
    }
    
    public final int bPV()
    {
      AppMethodBeat.i(209881);
      int i = ((Number)this.okt.getValue()).intValue();
      AppMethodBeat.o(209881);
      return i;
    }
    
    public final long bPW()
    {
      AppMethodBeat.i(209882);
      long l = ((Number)this.oku.getValue()).longValue();
      AppMethodBeat.o(209882);
      return l;
    }
    
    public final String bPX()
    {
      AppMethodBeat.i(209883);
      String str = (String)this.okv.getValue();
      AppMethodBeat.o(209883);
      return str;
    }
    
    public final String bPY()
    {
      AppMethodBeat.i(209884);
      String str = (String)this.okw.getValue();
      AppMethodBeat.o(209884);
      return str;
    }
    
    public final boolean bPZ()
    {
      AppMethodBeat.i(209886);
      boolean bool = ((Boolean)this.okA.getValue()).booleanValue();
      AppMethodBeat.o(209886);
      return bool;
    }
    
    public final d.b bQa()
    {
      AppMethodBeat.i(209888);
      Object localObject1 = this;
      while (((d)localObject1).bPZ())
      {
        ad.i("MicroMsg.WebPrefetcher", "fetch cached: #" + ((d)localObject1).okB + ", " + ((d)localObject1).url);
        Object localObject2 = ((d)localObject1).bPU();
        switch (u.cpQ[localObject2.ordinal()])
        {
        default: 
          localObject1 = ((d)localObject1).bQb();
          AppMethodBeat.o(209888);
          return localObject1;
        }
        Object localObject3;
        if (((d)localObject1).isRedirect())
        {
          ad.i("MicroMsg.WebPrefetcher", "HTML redirect, location:" + ((d)localObject1).getLocation());
          localObject2 = ((d)localObject1).getLocation();
          localObject1 = b.Xn(((d)localObject1).getLocation());
          localObject3 = t.okg;
          localObject3 = t.bPM();
          t localt = t.okg;
          localObject1 = new d((String)localObject2, (String)localObject1, (v)localObject3, t.bPK());
        }
        else
        {
          localObject2 = t.okg;
          if (t.WS(((d)localObject1).url))
          {
            if (!as.al(((d)localObject1).bPW(), ((d)localObject1).bPV()))
            {
              localObject2 = (List)((d)localObject1).bPT().get("set-cookie");
              if (localObject2 != null)
              {
                localObject2 = ((Iterable)localObject2).iterator();
                while (((Iterator)localObject2).hasNext())
                {
                  localObject3 = (String)((Iterator)localObject2).next();
                  com.tencent.xweb.c.gaw().setCookie(((d)localObject1).url, (String)localObject3);
                }
              }
              localObject1 = ((d)localObject1).bQb();
              AppMethodBeat.o(209888);
              return localObject1;
            }
            ad.w("MicroMsg.WebPrefetcher", "doc expired refresh cached: #" + ((d)localObject1).okB + ", " + ((d)localObject1).url);
            ((d)localObject1).refresh();
            AppMethodBeat.o(209888);
            return null;
          }
          ad.w("MicroMsg.WebPrefetcher", "preauth expired preauth: #" + ((d)localObject1).okB + ", " + ((d)localObject1).url);
          t.XC(((d)localObject1).url);
          AppMethodBeat.o(209888);
          return null;
        }
      }
      AppMethodBeat.o(209888);
      return null;
    }
    
    public final String getLocation()
    {
      AppMethodBeat.i(209880);
      String str = (String)this.okq.getValue();
      AppMethodBeat.o(209880);
      return str;
    }
    
    public final boolean isRedirect()
    {
      AppMethodBeat.i(209885);
      boolean bool = ((Boolean)this.okz.getValue()).booleanValue();
      AppMethodBeat.o(209885);
      return bool;
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements d.g.a.a<String>
    {
      a(t.d paramd)
      {
        super();
      }
      
      private String bed()
      {
        AppMethodBeat.i(209860);
        Object localObject1 = k.ojs;
        Object localObject3 = k.bPx();
        localObject1 = this.okE.okB;
        localObject3 = (ax)((ar)localObject3).aQb((String)localObject1);
        int i;
        if (localObject3 != null) {
          if (((ax)localObject3).containsKey((String)localObject1))
          {
            localObject1 = ((ax)localObject3).decodeBytes((String)localObject1);
            if (localObject1 != null) {
              if (localObject1.length == 0)
              {
                i = 1;
                if (i != 0) {
                  break label129;
                }
                i = 1;
                label65:
                if (i == 0) {
                  break label150;
                }
              }
            }
          }
        }
        for (;;)
        {
          try
          {
            localObject3 = eei.class.newInstance();
            ((com.tencent.mm.bx.a)localObject3).parseFrom((byte[])localObject1);
            localObject1 = (com.tencent.mm.bx.a)localObject3;
            localObject1 = (eei)localObject1;
            if (localObject1 != null)
            {
              localObject3 = ((eei)localObject1).dwX;
              localObject1 = localObject3;
              if (localObject3 != null) {}
            }
            else
            {
              localObject1 = this.okE.okB;
            }
            AppMethodBeat.o(209860);
            return localObject1;
          }
          catch (Exception localException)
          {
            label129:
            ad.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", (Throwable)localException, "decode ProtoBuffer", new Object[0]);
          }
          i = 0;
          break;
          i = 0;
          break label65;
          label150:
          Object localObject2 = null;
          continue;
          localObject2 = null;
        }
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
    static final class b
      extends q
      implements d.g.a.a<Long>
    {
      b(t.d paramd)
      {
        super();
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
    static final class c
      extends q
      implements d.g.a.a<String>
    {
      c(t.d paramd)
      {
        super();
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
    static final class d
      extends q
      implements d.g.a.a<String>
    {
      d(t.d paramd)
      {
        super();
      }
      
      private String bed()
      {
        AppMethodBeat.i(209864);
        Object localObject1 = k.ojs;
        Object localObject3 = k.bPx();
        localObject1 = this.okE.okB;
        localObject3 = (ax)((ar)localObject3).aQb((String)localObject1);
        int i;
        if (localObject3 != null) {
          if (((ax)localObject3).containsKey((String)localObject1))
          {
            localObject1 = ((ax)localObject3).decodeBytes((String)localObject1);
            if (localObject1 != null) {
              if (localObject1.length == 0)
              {
                i = 1;
                if (i != 0) {
                  break label129;
                }
                i = 1;
                label65:
                if (i == 0) {
                  break label150;
                }
              }
            }
          }
        }
        for (;;)
        {
          try
          {
            localObject3 = eei.class.newInstance();
            ((com.tencent.mm.bx.a)localObject3).parseFrom((byte[])localObject1);
            localObject1 = (com.tencent.mm.bx.a)localObject3;
            localObject1 = (eei)localObject1;
            if (localObject1 != null)
            {
              localObject3 = ((eei)localObject1).omw;
              localObject1 = localObject3;
              if (localObject3 != null) {}
            }
            else
            {
              localObject1 = this.okE.url;
            }
            AppMethodBeat.o(209864);
            return localObject1;
          }
          catch (Exception localException)
          {
            label129:
            ad.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", (Throwable)localException, "decode ProtoBuffer", new Object[0]);
          }
          i = 0;
          break;
          i = 0;
          break label65;
          label150:
          Object localObject2 = null;
          continue;
          localObject2 = null;
        }
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "invoke"})
    static final class e
      extends q
      implements d.g.a.a<HashMap<String, List<? extends String>>>
    {
      e(t.d paramd)
      {
        super();
      }
      
      private HashMap<String, List<String>> bQc()
      {
        AppMethodBeat.i(209866);
        Object localObject2 = this.okE.okD;
        Object localObject1 = this.okE.bPS();
        localObject2 = (ax)((ar)localObject2).aQb((String)localObject1);
        int i;
        if (localObject2 != null) {
          if (((ax)localObject2).containsKey((String)localObject1))
          {
            localObject1 = ((ax)localObject2).decodeBytes((String)localObject1);
            if (localObject1 != null) {
              if (localObject1.length == 0)
              {
                i = 1;
                if (i != 0) {
                  break label170;
                }
                i = 1;
                label65:
                if (i == 0) {
                  break label191;
                }
              }
            }
          }
        }
        label170:
        label191:
        HashMap<String, List<String>> localHashMap;
        for (;;)
        {
          try
          {
            localObject2 = eeh.class.newInstance();
            ((com.tencent.mm.bx.a)localObject2).parseFrom((byte[])localObject1);
            localObject1 = (com.tencent.mm.bx.a)localObject2;
            localObject2 = (eeh)localObject1;
            localObject1 = new HashMap();
            if (localObject2 == null) {
              break label201;
            }
            localObject2 = ((eeh)localObject2).HPw;
            p.g(localObject2, "it.header");
            localObject2 = ((Iterable)localObject2).iterator();
            if (!((Iterator)localObject2).hasNext()) {
              break label201;
            }
            eeg localeeg = (eeg)((Iterator)localObject2).next();
            ((HashMap)localObject1).put(localeeg.key, localeeg.GqN);
            continue;
            i = 0;
          }
          catch (Exception localException)
          {
            ad.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", (Throwable)localException, "decode ProtoBuffer", new Object[0]);
          }
          i = 0;
          break label65;
          localHashMap = null;
          continue;
          localHashMap = null;
        }
        label201:
        AppMethodBeat.o(209866);
        return localHashMap;
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
    static final class f
      extends q
      implements d.g.a.a<Boolean>
    {
      f(t.d paramd)
      {
        super();
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
    static final class g
      extends q
      implements d.g.a.a<Boolean>
    {
      g(t.d paramd)
      {
        super();
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
    static final class h
      extends q
      implements d.g.a.a<String>
    {
      h(t.d paramd)
      {
        super();
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
    static final class i
      extends q
      implements d.g.a.a<Integer>
    {
      i(t.d paramd)
      {
        super();
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
    static final class j
      extends q
      implements d.g.a.a<String>
    {
      j(t.d paramd)
      {
        super();
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
    static final class k
      extends q
      implements d.g.a.a<String>
    {
      k(t.d paramd)
      {
        super();
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
    static final class l
      extends q
      implements d.g.a.a<String>
    {
      l(t.d paramd)
      {
        super();
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchType;", "invoke"})
    static final class m
      extends q
      implements d.g.a.a<t.e>
    {
      m(t.d paramd)
      {
        super();
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
    static final class n
      extends q
      implements d.g.a.a<Long>
    {
      n(t.d paramd)
      {
        super();
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
    static final class o
      extends q
      implements d.g.a.a<String>
    {
      o(t.d paramd)
      {
        super();
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchType;", "", "type", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "toString", "JS", "CSS", "HTML", "plugin-brandservice_release"})
  static enum e
  {
    private final String type;
    
    static
    {
      AppMethodBeat.i(209892);
      e locale1 = new e("JS", 0, "JS");
      okF = locale1;
      e locale2 = new e("CSS", 1, "CSS");
      okG = locale2;
      e locale3 = new e("HTML", 2, "HTML");
      okH = locale3;
      okI = new e[] { locale1, locale2, locale3 };
      AppMethodBeat.o(209892);
    }
    
    private e(String paramString)
    {
      this.type = paramString;
    }
    
    public final String toString()
    {
      return this.type;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$connect$2$1", "Lcom/tencent/mars/cdn/CronetLogic$CronetTaskCallback;", "onCronetReceiveHeader", "", "header", "Lcom/tencent/mars/cdn/CronetLogic$ResponseHeader;", "status_code", "onCronetTaskCompleted", "", "filekey", "", "result", "Lcom/tencent/mars/cdn/CronetLogic$CronetTaskResult;", "onDownloadProgressChanged", "progress", "Lcom/tencent/mars/cdn/CronetLogic$CronetDownloadProgress;", "plugin-brandservice_release"})
  public static final class f
    implements CronetLogic.CronetTaskCallback
  {
    f(x paramx, String paramString, com.tencent.mm.vfs.e parame, d.g.a.b paramb1, d.g.a.b paramb2) {}
    
    public final int onCronetReceiveHeader(CronetLogic.ResponseHeader paramResponseHeader, int paramInt)
    {
      AppMethodBeat.i(209896);
      if (((Boolean)this.okM.invoke(Integer.valueOf(paramInt))).booleanValue())
      {
        AppMethodBeat.o(209896);
        return 0;
      }
      paramResponseHeader = this.okN;
      if (paramResponseHeader != null) {
        paramResponseHeader.invoke(Boolean.FALSE);
      }
      AppMethodBeat.o(209896);
      return -99;
    }
    
    public final void onCronetTaskCompleted(String paramString, CronetLogic.CronetTaskResult paramCronetTaskResult)
    {
      AppMethodBeat.i(209895);
      if (paramCronetTaskResult != null) {
        switch (paramCronetTaskResult.statusCode)
        {
        }
      }
      for (;;)
      {
        paramString = new com.tencent.mm.vfs.e(this.okJ.getSavePath());
        if (paramString.exists()) {
          paramString.delete();
        }
        paramString = this.okN;
        if (paramString == null) {
          break;
        }
        paramString.invoke(Boolean.valueOf(com.tencent.mm.vfs.i.fv(this.okK)));
        AppMethodBeat.o(209895);
        return;
        if (com.tencent.mm.vfs.i.mA(this.okJ.getSavePath(), this.okK))
        {
          ad.i("MicroMsg.WebPrefetcher", "save file:" + this.okJ.getURL() + " to " + this.okK);
        }
        else
        {
          ad.e("MicroMsg.WebPrefetcher", "save conn failed:" + this.okJ.getURL() + " to " + this.okJ.getSavePath());
          continue;
          this.okM.invoke(Integer.valueOf(paramCronetTaskResult.statusCode));
        }
      }
      AppMethodBeat.o(209895);
    }
    
    public final void onDownloadProgressChanged(String paramString, CronetLogic.CronetDownloadProgress paramCronetDownloadProgress) {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "", "invoke"})
  static final class g
    extends q
    implements d.g.a.b<Integer, Boolean>
  {
    public static final g okO;
    
    static
    {
      AppMethodBeat.i(209898);
      okO = new g();
      AppMethodBeat.o(209898);
    }
    
    g()
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/network/MMHttpUrlCronetConnection;", "conn", "invoke"})
  static final class h
    extends q
    implements d.g.a.b<x, x>
  {
    h(Map paramMap, t.d paramd, String paramString1, String paramString2)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/network/MMHttpUrlCronetConnection;", "conn", "invoke", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$fetchManifest$2$1"})
  static final class i
    extends q
    implements d.g.a.b<x, x>
  {
    i(String paramString, d paramd, j paramj)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/network/MMHttpUrlCronetConnection;", "conn", "invoke", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$fetchRes$1$1"})
  static final class j
    extends q
    implements d.g.a.b<x, x>
  {
    j(String paramString1, t.c paramc, String paramString2)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/mm/sdk/platformtools/MMBatchRunKt$batchRun$2"})
  public static final class k
    extends d.d.b.a.j
    implements m<ah, d<? super z>, Object>
  {
    int label;
    private ah nWQ;
    Object nWR;
    
    public k(long paramLong, String paramString, d paramd, t paramt)
    {
      super();
    }
    
    public final d<z> a(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(6785);
      p.h(paramd, "completion");
      paramd = new k(this.oju, this.kxJ, paramd, this.old);
      paramd.nWQ = ((ah)paramObject);
      AppMethodBeat.o(6785);
      return paramd;
    }
    
    public final Object cQ(Object paramObject)
    {
      AppMethodBeat.i(6784);
      Object localObject = d.d.a.a.MLc;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(6784);
        throw paramObject;
      case 0: 
        paramObject = this.nWQ;
        long l = this.oju;
        this.nWR = paramObject;
        this.label = 1;
        if (at.a(l, this) == localObject)
        {
          AppMethodBeat.o(6784);
          return localObject;
        }
        break;
      case 1: 
        paramObject = (ah)this.nWR;
      }
      if (!ai.a(paramObject))
      {
        paramObject = z.MKo;
        AppMethodBeat.o(6784);
        return paramObject;
      }
      synchronized (by.IgT)
      {
        paramObject = by.IgT;
        localObject = by.fmd().get(this.kxJ);
        paramObject = localObject;
        if (!(localObject instanceof Queue)) {
          paramObject = null;
        }
        paramObject = (Queue)paramObject;
        if (paramObject != null)
        {
          localObject = by.IgT;
          by.fmd().remove(this.kxJ);
          paramObject = new ArrayList((Collection)paramObject);
          if (paramObject != null) {
            t.cr((List)paramObject);
          }
          paramObject = by.IgT;
          by.fmc().remove(this.kxJ);
          paramObject = z.MKo;
          AppMethodBeat.o(6784);
          return paramObject;
        }
        paramObject = null;
      }
    }
    
    public final Object p(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(6786);
      paramObject1 = ((k)a(paramObject1, (d)paramObject2)).cQ(z.MKo);
      AppMethodBeat.o(6786);
      return paramObject1;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class l
    implements Runnable
  {
    l(List paramList) {}
    
    public final void run()
    {
      AppMethodBeat.i(209908);
      LinkedList localLinkedList = new LinkedList();
      Iterator localIterator = ((Iterable)this.ole).iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        try
        {
          ad.i("MicroMsg.WebPrefetcher", "pre dns:".concat(String.valueOf(InetAddress.getByName(str))));
          c.a locala = com.tencent.mm.plugin.brandservice.c.nVH;
          com.tencent.mm.plugin.brandservice.c.bNp().Ej(str);
          localLinkedList.add(str);
        }
        catch (Exception localException)
        {
          ad.printErrStackTrace("MicroMsg.WebPrefetcher", (Throwable)localException, "pre dns err:".concat(String.valueOf(str)), new Object[0]);
        }
      }
      com.tencent.mm.plugin.webview.h.b.Xb(localLinkedList.size());
      AppMethodBeat.o(209908);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/mm/sdk/platformtools/MMBatchRunKt$batchRun$2"})
  public static final class m
    extends d.d.b.a.j
    implements m<ah, d<? super z>, Object>
  {
    int label;
    private ah nWQ;
    Object nWR;
    
    public m(long paramLong, String paramString, d paramd)
    {
      super();
    }
    
    public final d<z> a(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(6796);
      p.h(paramd, "completion");
      paramd = new m(this.oju, this.kxJ, paramd);
      paramd.nWQ = ((ah)paramObject);
      AppMethodBeat.o(6796);
      return paramd;
    }
    
    public final Object cQ(Object paramObject)
    {
      AppMethodBeat.i(6795);
      Object localObject1 = d.d.a.a.MLc;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(6795);
        throw paramObject;
      case 0: 
        paramObject = this.nWQ;
        long l = this.oju;
        this.nWR = paramObject;
        this.label = 1;
        if (at.a(l, this) == localObject1)
        {
          AppMethodBeat.o(6795);
          return localObject1;
        }
        break;
      case 1: 
        paramObject = (ah)this.nWR;
      }
      if (!ai.a(paramObject))
      {
        paramObject = z.MKo;
        AppMethodBeat.o(6795);
        return paramObject;
      }
      for (;;)
      {
        synchronized (by.IgT)
        {
          paramObject = by.IgT;
          localObject1 = by.fmd().get(this.kxJ);
          paramObject = localObject1;
          if (!(localObject1 instanceof Queue)) {
            paramObject = null;
          }
          paramObject = (Queue)paramObject;
          if (paramObject != null)
          {
            localObject1 = by.IgT;
            by.fmd().remove(this.kxJ);
            paramObject = new ArrayList((Collection)paramObject);
            if (paramObject == null) {
              break;
            }
            paramObject = ((Iterable)paramObject).iterator();
            if (!paramObject.hasNext()) {
              break;
            }
            localObject1 = (t.b)paramObject.next();
            ??? = ((t.b)localObject1).dKk;
            localObject3 = b.Xn(((t.b)localObject1).dKk);
            Object localObject4 = t.okg;
            localObject4 = t.bPM();
            t localt = t.okg;
            ??? = new t.d((String)???, (String)localObject3, (v)localObject4, t.bPK());
            if (((t.d)???).bPZ())
            {
              if (((t.b)localObject1).okj) {
                continue;
              }
              int i = Math.max(((t.d)???).bPV() - 60, 60);
              if ((((t.d)???).bPW() <= 0L) || (!as.al(((t.d)???).bPW(), i))) {
                continue;
              }
              localObject3 = t.okg;
              t.a(((t.b)localObject1).oki, ((t.b)localObject1).host, (t.d)???, ((t.b)localObject1).okk);
              continue;
            }
          }
          else
          {
            paramObject = null;
          }
        }
        Object localObject3 = t.okg;
        t.a(((t.b)localObject1).oki, ((t.b)localObject1).host, (t.d)???, ((t.b)localObject1).okk);
      }
      paramObject = by.IgT;
      by.fmc().remove(this.kxJ);
      paramObject = z.MKo;
      AppMethodBeat.o(6795);
      return paramObject;
    }
    
    public final Object p(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(6797);
      paramObject1 = ((m)a(paramObject1, (d)paramObject2)).cQ(z.MKo);
      AppMethodBeat.o(6797);
      return paramObject1;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyLitePrefetchResInfo;", "kotlin.jvm.PlatformType", "invoke"})
  static final class n
    extends q
    implements d.g.a.b<avd, String>
  {
    public static final n olf;
    
    static
    {
      AppMethodBeat.i(209910);
      olf = new n();
      AppMethodBeat.o(209910);
    }
    
    n()
    {
      super();
    }
  }
  
  @d.d.b.a.f(c="com.tencent.mm.plugin.brandservice.ui.timeline.preload.WebPrefetcher$savePrefetch$1", f="WebPrefetcher.kt", gfL={895, 895, 910}, m="invokeSuspend")
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class o
    extends d.d.b.a.j
    implements m<ah, d<? super z>, Object>
  {
    int label;
    private ah nWQ;
    Object nWR;
    Object olg;
    Object olh;
    Object oli;
    Object olj;
    Object olk;
    Object oll;
    Object olm;
    Object oln;
    Object olo;
    Object olp;
    Object olq;
    int olr;
    int ols;
    boolean olt;
    
    o(avh paramavh, avf paramavf, List paramList, d paramd)
    {
      super();
    }
    
    public final d<z> a(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(209912);
      p.h(paramd, "completion");
      paramd = new o(this.olu, this.olv, this.olw, paramd);
      paramd.nWQ = ((ah)paramObject);
      AppMethodBeat.o(209912);
      return paramd;
    }
    
    public final Object cQ(Object paramObject)
    {
      AppMethodBeat.i(209911);
      d.d.a.a locala = d.d.a.a.MLc;
      Object localObject2;
      Object localObject6;
      Object localObject5;
      Object localObject4;
      Object localObject1;
      int j;
      int i;
      Object localObject7;
      Object localObject9;
      Object localObject10;
      Object localObject12;
      boolean bool1;
      label298:
      Object localObject11;
      label462:
      Object localObject13;
      Object localObject14;
      int k;
      label531:
      label546:
      label552:
      label634:
      Object localObject15;
      label727:
      label1014:
      Object localObject21;
      label1155:
      Object localObject18;
      Object localObject19;
      Object localObject20;
      label1443:
      Object localObject22;
      Object localObject17;
      int m;
      Object localObject16;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(209911);
        throw paramObject;
      case 0: 
        localObject2 = this.nWQ;
        localObject6 = new LinkedList();
        localObject5 = new y.a();
        ((y.a)localObject5).MLQ = false;
        localObject4 = new y.a();
        ((y.a)localObject4).MLQ = false;
        paramObject = new HashMap();
        localObject1 = new HashMap();
        j = 0;
        i = this.olu.FCF;
        if (j < i)
        {
          localObject7 = new eei();
          ((y.a)localObject5).MLQ = false;
          ((y.a)localObject4).MLQ = false;
          ((eei)localObject7).url = ((ave)this.olv.GtB.get(j)).Gtv;
          ((eei)localObject7).omw = ((avg)this.olu.GtO.get(j)).GtD;
          localObject9 = ((eei)localObject7).url;
          p.g(localObject9, "url");
          localObject10 = b.Xn((String)localObject9);
          localObject9 = ((eei)localObject7).omw;
          p.g(localObject9, "fullUrl");
          if (!n.nz((String)localObject9, "http")) {
            break label2907;
          }
          localObject12 = (Map)new LinkedHashMap();
          boolean bool2;
          if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qtY, 1) == 1)
          {
            bool2 = true;
            localObject9 = com.tencent.mm.plugin.webview.core.f.DHt;
            if (!f.a.eNz()) {
              break label531;
            }
            bool1 = true;
            ad.i("MicroMsg.WebPrefetcher", "[TRACE_PREFETCH] useA8keyLiteHeader: " + bool2 + " mockUseA8keyLiteHeader: " + bool1);
            if (((!bool2) && (!bool1)) || (bt.hj((List)((avg)this.olu.GtO.get(j)).GtM))) {
              break label634;
            }
            ad.i("MicroMsg.WebPrefetcher", "[TRACE_PREFETCH] response header size : " + ((avg)this.olu.GtO.get(j)).GtM.size());
            localObject9 = ((avg)this.olu.GtO.get(j)).GtM;
            p.g(localObject9, "RespInfo[i].HttpHeader");
            localObject11 = (Iterable)localObject9;
            localObject9 = (Collection)new ArrayList();
            localObject11 = ((Iterable)localObject11).iterator();
            if (!((Iterator)localObject11).hasNext()) {
              break label552;
            }
            localObject13 = ((Iterator)localObject11).next();
            localObject14 = (bos)localObject13;
            if ((((bos)localObject14).ujy != null) && (((bos)localObject14).yhw != null)) {
              break label546;
            }
          }
          for (k = 1;; k = 0)
          {
            if (k != 0) {
              break label462;
            }
            ((Collection)localObject9).add(localObject13);
            break label462;
            bool2 = false;
            break;
            bool1 = com.tencent.mm.plugin.webview.core.g.bFO().getBoolean("webview_use_a8key_lite_header", false);
            break label298;
          }
          localObject9 = ((Iterable)localObject9).iterator();
          while (((Iterator)localObject9).hasNext())
          {
            localObject13 = (bos)((Iterator)localObject9).next();
            localObject11 = ((bos)localObject13).ujy;
            p.g(localObject11, "it.Key");
            localObject13 = ((bos)localObject13).yhw;
            p.g(localObject13, "it.Value");
            ((Map)localObject12).put(localObject11, localObject13);
          }
          ad.i("MicroMsg.WebPrefetcher", "[TRACE_PREFETCH] useA8keyLiteHeader size : " + ((Map)localObject12).size());
          ad.i("MicroMsg.WebPrefetcher", "savePrefetch domains size : " + this.olw.size());
          ((eei)localObject7).iud = System.currentTimeMillis();
          localObject9 = (Integer)this.olu.GtN.get(j);
          if (localObject9 == null)
          {
            ((eei)localObject7).HPx = true;
            if (!((eei)localObject7).HPx)
            {
              ((LinkedList)localObject6).add(((eei)localObject7).omw);
              ((y.a)localObject4).MLQ = true;
            }
            localObject9 = t.okg;
            localObject9 = ((eei)localObject7).omw;
            p.g(localObject9, "fullUrl");
            localObject13 = t.m((String)localObject9, this.olw);
            if (localObject13 == null) {
              break label2330;
            }
            localObject11 = this.olv.GtB.get(j);
            localObject9 = localObject11;
            if (!(localObject11 instanceof f)) {
              localObject9 = null;
            }
            localObject9 = (f)localObject9;
            if (localObject9 == null) {
              break label1014;
            }
          }
          for (localObject9 = ((f)localObject9).extInfo;; localObject9 = null)
          {
            ((j)localObject13).extInfo = ((String)localObject9);
            ad.v("MicroMsg.WebPrefetcher", "match prefetch#".concat(String.valueOf(localObject10)));
            localObject11 = t.okg;
            this.nWR = localObject2;
            this.olg = localObject6;
            this.olh = localObject5;
            this.oli = localObject4;
            this.olj = paramObject;
            this.olk = localObject1;
            this.olr = j;
            this.ols = i;
            this.oll = localObject7;
            this.olm = localObject7;
            this.oln = localObject10;
            this.olo = localObject12;
            this.olt = bool1;
            this.olp = localObject13;
            this.olq = localObject9;
            this.label = 1;
            localObject15 = t.a((j)localObject13, this);
            if (localObject15 != locala) {
              break label2855;
            }
            AppMethodBeat.o(209911);
            return locala;
            if (((Integer)localObject9).intValue() != 0) {
              break;
            }
            if (((avg)this.olu.GtO.get(j)).GtI == 0) {
              break label727;
            }
            ((eei)localObject7).HPy = true;
            break label727;
          }
        }
        break;
      case 1: 
        localObject14 = (String)this.olq;
        localObject13 = (j)this.olp;
        bool1 = this.olt;
        localObject12 = (Map)this.olo;
        localObject9 = (String)this.oln;
        localObject6 = (eei)this.olm;
        localObject11 = (eei)this.oll;
        i = this.ols;
        k = this.olr;
        localObject7 = (HashMap)this.olk;
        localObject5 = (HashMap)this.olj;
        localObject4 = (y.a)this.oli;
        localObject10 = (y.a)this.olh;
        localObject1 = (LinkedList)this.olg;
        localObject15 = (ah)this.nWR;
        localObject2 = paramObject;
        paramObject = localObject15;
        localObject15 = localObject2;
        if (((Boolean)localObject15).booleanValue())
        {
          localObject2 = w.olE;
          localObject15 = ((eei)localObject6).omw;
          p.g(localObject15, "fullUrl");
          this.nWR = paramObject;
          this.olg = localObject1;
          this.olh = localObject10;
          this.oli = localObject4;
          this.olj = localObject5;
          this.olk = localObject7;
          this.olr = k;
          this.ols = i;
          this.oll = localObject11;
          this.olm = localObject6;
          this.oln = localObject9;
          this.olo = localObject12;
          this.olt = bool1;
          this.olp = localObject13;
          this.olq = localObject14;
          this.label = 2;
          localObject21 = ((w)localObject2).a((String)localObject15, (j)localObject13, this);
          if (localObject21 != locala) {
            break label2827;
          }
          AppMethodBeat.o(209911);
          return locala;
        }
        break;
      case 2: 
        localObject18 = (String)this.olq;
        localObject10 = (j)this.olp;
        bool1 = this.olt;
        localObject19 = (Map)this.olo;
        localObject9 = (String)this.oln;
        localObject6 = (eei)this.olm;
        localObject20 = (eei)this.oll;
        j = this.ols;
        i = this.olr;
        localObject11 = (HashMap)this.olk;
        localObject5 = (HashMap)this.olj;
        localObject4 = (y.a)this.oli;
        localObject2 = (y.a)this.olh;
        localObject1 = (LinkedList)this.olg;
        localObject12 = (ah)this.nWR;
        localObject7 = paramObject;
        paramObject = localObject12;
        localObject21 = localObject7;
        localObject7 = localObject11;
        localObject22 = localObject9;
        localObject17 = localObject7;
        localObject14 = localObject6;
        m = j;
        k = i;
        localObject16 = localObject5;
        localObject13 = localObject4;
        localObject12 = localObject2;
        localObject15 = localObject1;
        localObject11 = paramObject;
        if (((Boolean)localObject21).booleanValue())
        {
          ((eei)localObject6).oki = ((eei)localObject6).omw;
          localObject11 = h.ojh;
          if (i.bFO().getBoolean("tencent_view_inews_prefix", false))
          {
            localObject11 = ((eei)localObject6).oki;
            p.g(localObject11, "prefetchUrl");
            ((eei)localObject6).oki = n.bp((String)localObject11, "//view.inews.qq.com", "//ssr.view.inews.qq.com");
          }
          ((eei)localObject6).HPz = true;
          localObject11 = t.okg;
          t.a((eei)localObject6);
          ad.i("MicroMsg.WebPrefetcher", "prefetch call, header size: " + ((Map)localObject19).size() + ", url: " + ((eei)localObject6).oki);
          localObject11 = t.okg;
          localObject11 = ((eei)localObject6).url;
          p.g(localObject11, "url");
          localObject12 = ((eei)localObject6).oki;
          p.g(localObject12, "prefetchUrl");
          t.b((String)localObject11, (String)localObject12, (Map)localObject19);
          ((y.a)localObject2).MLQ = true;
          localObject11 = w.olE;
          this.nWR = paramObject;
          this.olg = localObject1;
          this.olh = localObject2;
          this.oli = localObject4;
          this.olj = localObject5;
          this.olk = localObject7;
          this.olr = i;
          this.ols = j;
          this.oll = localObject20;
          this.olm = localObject6;
          this.oln = localObject9;
          this.olo = localObject19;
          this.olt = bool1;
          this.olp = localObject10;
          this.olq = localObject18;
          this.label = 3;
          localObject12 = ((w)localObject11).b((j)localObject10, this);
          if (localObject12 != locala) {
            break label2808;
          }
          AppMethodBeat.o(209911);
          return locala;
        }
        break;
      case 3: 
        localObject9 = (j)this.olp;
        localObject11 = (String)this.oln;
        localObject6 = (eei)this.olm;
        j = this.ols;
        i = this.olr;
        localObject12 = (HashMap)this.olk;
        localObject7 = (HashMap)this.olj;
        localObject4 = (y.a)this.oli;
        localObject5 = (y.a)this.olh;
        localObject1 = (LinkedList)this.olg;
        localObject10 = (ah)this.nWR;
        localObject2 = paramObject;
        paramObject = localObject10;
        localObject10 = localObject9;
        localObject9 = localObject12;
        localObject12 = localObject2;
        label1888:
        localObject12 = (Iterable)localObject12;
        localObject2 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject12, 10));
        localObject12 = ((Iterable)localObject12).iterator();
        while (((Iterator)localObject12).hasNext()) {
          ((Collection)localObject2).add(new t.c((String)((Iterator)localObject12).next(), t.e.okF));
        }
        localObject2 = (List)localObject2;
        localObject12 = t.okg;
        localObject10 = ((j)localObject10).oji.Gtl;
        p.g(localObject10, "manifest.domain.Domain");
        t.g((List)localObject2, (String)localObject10);
        localObject2 = z.MKo;
        ad.v("MicroMsg.WebPrefetcher", "end prefetch #" + (String)localObject11 + ' ' + ((eei)localObject6).oki);
        k = j;
        localObject2 = paramObject;
        j = i;
        localObject14 = localObject6;
        paramObject = localObject1;
        i = k;
        localObject6 = localObject7;
        localObject1 = localObject9;
      }
      for (;;)
      {
        try
        {
          localObject7 = t.okg;
          k = t.WV(((eei)localObject14).url);
          localObject7 = (Integer)((HashMap)localObject1).get(Integer.valueOf(k));
          if (localObject7 != null) {
            continue;
          }
          ((Map)localObject1).put(Integer.valueOf(k), Integer.valueOf(1));
          localObject7 = ((eei)localObject14).url;
          p.g(localObject7, "url");
          com.tencent.mm.plugin.webview.h.b.a(0, (String)localObject7, false, false, true, ((y.a)localObject4).MLQ, ((y.a)localObject5).MLQ, true);
          localObject7 = (Integer)((HashMap)localObject6).get(Integer.valueOf(k));
          if (localObject7 != null) {
            continue;
          }
          ((Map)localObject6).put(Integer.valueOf(k), Integer.valueOf(1));
        }
        catch (Exception localException2)
        {
          label2330:
          ad.e("MicroMsg.WebPrefetcher", "Report Error");
          continue;
          ((Map)localObject6).put(Integer.valueOf(k), Integer.valueOf(localException2.intValue() + 1));
          continue;
        }
        localObject7 = z.MKo;
        j += 1;
        localObject7 = localObject6;
        localObject6 = paramObject;
        paramObject = localObject7;
        break;
        localObject11 = paramObject;
        localObject15 = localObject1;
        localObject12 = localObject10;
        localObject13 = localObject4;
        localObject16 = localObject5;
        m = i;
        localObject14 = localObject6;
        localObject17 = localObject7;
        localObject22 = localObject9;
        paramObject = t.okg;
        t.a((eei)localObject14);
        ad.w("MicroMsg.WebPrefetcher", "fail to prefetch #" + localObject22 + ' ' + ((eei)localObject14).url);
        i = m;
        localObject1 = localObject17;
        localObject6 = localObject16;
        paramObject = localObject15;
        j = k;
        localObject4 = localObject13;
        localObject5 = localObject12;
        localObject2 = localObject11;
        continue;
        localObject9 = t.okg;
        t.a((eei)localObject7);
        localObject9 = localObject6;
        localObject6 = paramObject;
        paramObject = localObject9;
        localObject14 = localObject7;
        continue;
        ((Map)localObject1).put(Integer.valueOf(k), Integer.valueOf(((Integer)localObject7).intValue() + 1));
        continue;
        if (!((Collection)localObject6).isEmpty()) {
          i = 1;
        }
        for (;;)
        {
          if (i != 0) {}
          try
          {
            localObject2 = t.okg;
            t.cs((List)localObject6);
            com.tencent.mm.plugin.webview.h.b.Xa(this.olu.FCF);
            localObject4 = (Map)paramObject;
            localObject2 = (Collection)new ArrayList(((Map)localObject4).size());
            localObject4 = ((Map)localObject4).entrySet().iterator();
            while (((Iterator)localObject4).hasNext())
            {
              localObject5 = (Map.Entry)((Iterator)localObject4).next();
              i = ((Number)((Map.Entry)localObject5).getKey()).intValue();
              com.tencent.mm.plugin.webview.h.b.iX(((Number)((Map.Entry)localObject5).getValue()).intValue(), i);
              ((Collection)localObject2).add(z.MKo);
              continue;
              i = 0;
            }
          }
          catch (Exception localException1)
          {
            for (;;)
            {
              ad.e("MicroMsg.WebPrefetcher", "preDns ex " + localException1.getMessage());
            }
            localObject3 = (Map)localObject1;
            localObject1 = (Collection)new ArrayList(((Map)localObject3).size());
            localObject3 = ((Map)localObject3).entrySet().iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject4 = (Map.Entry)((Iterator)localObject3).next();
              i = ((Number)((Map.Entry)localObject4).getKey()).intValue();
              j = ((Number)((Map.Entry)localObject4).getValue()).intValue();
              com.tencent.mm.plugin.webview.h.b.iY(j, i);
              if (paramObject.get(Integer.valueOf(i)) != null)
              {
                localObject4 = paramObject.get(Integer.valueOf(i));
                if (localObject4 == null) {
                  p.gfZ();
                }
                if (p.compare(((Number)localObject4).intValue(), j) > 0)
                {
                  localObject4 = paramObject.get(Integer.valueOf(i));
                  if (localObject4 == null) {
                    p.gfZ();
                  }
                  com.tencent.mm.plugin.webview.h.b.iZ(((Number)localObject4).intValue() - j, i);
                }
              }
              ((Collection)localObject1).add(z.MKo);
            }
            paramObject = z.MKo;
            AppMethodBeat.o(209911);
            return paramObject;
          }
        }
        label2808:
        localObject11 = localObject9;
        localObject9 = localException2;
        Object localObject8 = localObject5;
        localObject5 = localObject3;
        break label1888;
        label2827:
        Object localObject3 = localObject10;
        localObject18 = localObject14;
        localObject10 = localObject13;
        localObject19 = localObject12;
        localObject20 = localObject11;
        j = i;
        i = k;
        break label1443;
        label2855:
        localObject14 = localObject9;
        localObject9 = localObject10;
        localObject11 = localObject8;
        localObject16 = localObject8;
        localObject17 = localObject6;
        localObject8 = localObject1;
        localObject10 = localObject5;
        localObject6 = localObject11;
        localObject11 = localObject16;
        k = j;
        localObject5 = paramObject;
        localObject1 = localObject17;
        paramObject = localObject3;
        break label1155;
        label2907:
        localObject8 = paramObject;
        paramObject = localObject6;
        localObject6 = localObject8;
      }
    }
    
    public final Object p(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(209913);
      paramObject1 = ((o)a(paramObject1, (d)paramObject2)).cQ(z.MKo);
      AppMethodBeat.o(209913);
      return paramObject1;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "kotlin.jvm.PlatformType", "it", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyLiteReqInfo;", "invoke"})
  static final class p
    extends q
    implements d.g.a.b<ave, String>
  {
    public static final p olx;
    
    static
    {
      AppMethodBeat.i(209915);
      olx = new p();
      AppMethodBeat.o(209915);
    }
    
    p()
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class q
    extends q
    implements d.g.a.a<z>
  {
    q(avf paramavf)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/webview/util/WebPrefetchUserAgentInfo;", "invoke"})
  static final class r
    extends q
    implements d.g.a.a<com.tencent.mm.plugin.webview.j.e>
  {
    public static final r olA;
    
    static
    {
      AppMethodBeat.i(209919);
      olA = new r();
      AppMethodBeat.o(209919);
    }
    
    r()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.t
 * JD-Core Version:    0.7.0.1
 */