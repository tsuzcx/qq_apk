package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import android.net.Uri;
import com.tencent.mars.cdn.CronetLogic;
import com.tencent.mars.cdn.CronetLogic.CronetDownloadProgress;
import com.tencent.mars.cdn.CronetLogic.CronetTaskCallback;
import com.tencent.mars.cdn.CronetLogic.CronetTaskResult;
import com.tencent.mars.cdn.CronetLogic.ResponseHeader;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.brandservice.a.d.a;
import com.tencent.mm.plugin.brandservice.a.d.b;
import com.tencent.mm.plugin.brandservice.c.a;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.webview.core.f.a;
import com.tencent.mm.plugin.webview.j.e;
import com.tencent.mm.protocal.protobuf.avr;
import com.tencent.mm.protocal.protobuf.avs;
import com.tencent.mm.protocal.protobuf.avt;
import com.tencent.mm.protocal.protobuf.avu;
import com.tencent.mm.protocal.protobuf.avv;
import com.tencent.mm.protocal.protobuf.avw;
import com.tencent.mm.protocal.protobuf.avx;
import com.tencent.mm.protocal.protobuf.bpk;
import com.tencent.mm.protocal.protobuf.efx;
import com.tencent.mm.protocal.protobuf.efy;
import com.tencent.mm.protocal.protobuf.efz;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bz;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import com.tencent.xweb.WebResourceResponse;
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
import kotlinx.coroutines.az;
import kotlinx.coroutines.bk;
import kotlinx.coroutines.br;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher;", "", "()V", "MIN_EXPIRE_SECONDS", "", "PRE_AUTH_EXPIRE_SECONDS", "REFRESH_BEFORE_EXPIRE_SECONDS", "value", "currentScene", "getCurrentScene", "()I", "setCurrentScene", "(I)V", "manifestContent", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcherFile;", "getManifestContent$plugin_brandservice_release", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcherFile;", "preauthRequestLimiter", "Lcom/tencent/mm/sdk/platformtools/MMCacheSlotManager;", "getPreauthRequestLimiter$plugin_brandservice_release", "()Lcom/tencent/mm/sdk/platformtools/MMCacheSlotManager;", "prefetchInfoManager", "Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "getPrefetchInfoManager$plugin_brandservice_release", "()Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "resContent", "getResContent$plugin_brandservice_release", "resHeadersManager", "getResHeadersManager$plugin_brandservice_release", "sendingGetA8keyLiteQueue", "Ljava/util/concurrent/ConcurrentSkipListSet;", "", "settingManager", "getSettingManager$plugin_brandservice_release", "userAgentInfo", "Lcom/tencent/mm/plugin/webview/util/WebPrefetchUserAgentInfo;", "getUserAgentInfo", "()Lcom/tencent/mm/plugin/webview/util/WebPrefetchUserAgentInfo;", "userAgentInfo$delegate", "Lkotlin/Lazy;", "webContent", "getWebContent$plugin_brandservice_release", "webHeadersManager", "getWebHeadersManager$plugin_brandservice_release", "webIdToSceneManager", "getWebIdToSceneManager$plugin_brandservice_release", "clearPrefetchContent", "", "url", "debugPreloadWebInfo", "", "(Ljava/lang/String;)[[Ljava/lang/String;", "fetchContent", "Lcom/tencent/mm/network/MMHttpUrlCronetConnection;", "host", "target", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchTarget;", "deep", "prefetchHeaders", "", "fetchManifest", "", "manifest", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PrefetchManifest;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PrefetchManifest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchRes", "batchRes", "", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchRes;", "getPreAuthUrl", "getPrefetchContentResp", "Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService$PrefetchResponse;", "getPrefetchResResp", "referer", "getReportScene", "getRespUrl", "getUrlCookie", "getUrlScene", "getValidPreloadWebInfo", "Lcom/tencent/mm/protocal/protobuf/WebPrefetchInfo;", "isDnsCached", "isInPreAuthWhiteList", "isUrlCache", "isUrlPreAuthed", "isWebUrlEqual", "rawUrl", "targetUrl", "isWebUrlStorageEqual", "matchManifest", "domains", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyLitePrefetchDomainInfo;", "needReauth", "preAuth", "appId", "title", "desc", "from", "scene", "preAuths", "auths", "Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService$PreAuthInfo;", "preDns", "urls", "prefetch", "prefetchUrl", "checkCacheOnly", "headers", "bizScene", "sendGetA8KeyLiteRequest", "preauths", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$BatchPreauth;", "setUrlToScene", "connect", "receiveHeader", "Lkotlin/Function1;", "targetFile", "Lcom/tencent/mm/vfs/VFSFile;", "onCompleted", "mockManifest", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyLiteResponse;", "prepare", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyLiteRequest;", "save", "saveDomainInfos", "saveManifest", "localPrefetchDomainInfos", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protobuf/ByteString;", "savePrefetch", "request", "BatchPreauth", "PrefetchAction", "PrefetchRes", "PrefetchTarget", "PrefetchType", "plugin-brandservice_release"})
public final class t
{
  private static final as opW;
  private static final as opX;
  private static final as opY;
  private static final as opZ;
  private static final v oqa;
  private static final v oqb;
  private static final v oqc;
  private static final ConcurrentSkipListSet<String> oqd;
  private static final d.f oqe;
  private static final am oqf;
  private static final as oqg;
  public static final t oqh;
  
  static
  {
    AppMethodBeat.i(6809);
    oqh = new t();
    opW = new as(w.bRc(), 3600L);
    opX = new as(w.bRc(), 604800L);
    opY = new as(w.bRc(), 86400L);
    opZ = new as(w.bRc(), 604800L);
    oqa = new v("wcf://WebPrefetchContent/");
    oqb = new v("wcf://WebPrefetchResource/");
    oqc = new v("wcf://WebPrefetchManifest/");
    oqd = new ConcurrentSkipListSet();
    oqe = d.g.O((d.g.a.a)r.orq);
    oqf = new am();
    oqg = new as(s.bQG(), 86400L);
    AppMethodBeat.o(6809);
  }
  
  public static boolean XE(String paramString)
  {
    AppMethodBeat.i(208918);
    p.h(paramString, "url");
    if (Yq(paramString) != null)
    {
      AppMethodBeat.o(208918);
      return true;
    }
    AppMethodBeat.o(208918);
    return false;
  }
  
  public static int XH(String paramString)
  {
    AppMethodBeat.i(175492);
    int i;
    switch (bQP())
    {
    default: 
      i = bQP();
      AppMethodBeat.o(175492);
      return i;
    }
    if (paramString != null)
    {
      Yt(paramString);
      i = Yt(paramString);
      AppMethodBeat.o(175492);
      return i;
    }
    AppMethodBeat.o(175492);
    return 0;
  }
  
  public static d.b XI(String paramString)
  {
    AppMethodBeat.i(208912);
    p.h(paramString, "url");
    paramString = new d(paramString, b.XZ(paramString), oqa, opY).bQZ();
    AppMethodBeat.o(208912);
    return paramString;
  }
  
  public static void XJ(String paramString)
  {
    AppMethodBeat.i(6803);
    p.h(paramString, "url");
    Object localObject1 = b.XZ(paramString);
    Object localObject2 = oqa.Yu((String)localObject1);
    if (((k)localObject2).exists()) {
      ((k)localObject2).delete();
    }
    localObject2 = (ay)opY.aRy((String)localObject1);
    if (localObject2 != null) {
      ((ay)localObject2).remove((String)localObject1);
    }
    localObject1 = (ay)opW.aRy(b.XZ(paramString));
    if (localObject1 != null)
    {
      ((ay)localObject1).removeValueForKey(b.XZ(paramString));
      AppMethodBeat.o(6803);
      return;
    }
    AppMethodBeat.o(6803);
  }
  
  private static boolean Yo(String paramString)
  {
    AppMethodBeat.i(208911);
    p.h(paramString, "url");
    paramString = new d(paramString, b.XZ(paramString), oqa, opY);
    boolean bool1 = paramString.bQY();
    boolean bool2 = paramString.isRedirect();
    if ((bool1) && (!bool2))
    {
      AppMethodBeat.o(208911);
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
    AppMethodBeat.o(208911);
    return false;
  }
  
  public static efz Yq(String paramString)
  {
    AppMethodBeat.i(208917);
    String str = b.XZ(paramString);
    Object localObject1 = (ay)opW.aRy(str);
    int i;
    if (localObject1 != null) {
      if (((ay)localObject1).containsKey(str))
      {
        localObject1 = ((ay)localObject1).decodeBytes(str);
        if (localObject1 != null) {
          if (localObject1.length == 0)
          {
            i = 1;
            if (i != 0) {
              break label242;
            }
            i = 1;
            label61:
            if (i == 0) {
              break label265;
            }
          }
        }
      }
    }
    label242:
    efz localefz;
    for (;;)
    {
      try
      {
        Object localObject2 = efz.class.newInstance();
        ((com.tencent.mm.bw.a)localObject2).parseFrom((byte[])localObject1);
        localObject1 = (com.tencent.mm.bw.a)localObject2;
        localObject1 = (efz)localObject1;
        if (localObject1 == null) {
          break label319;
        }
        boolean bool = com.tencent.mm.sdk.platformtools.at.al(((efz)localObject1).iwX, 600);
        com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.WebPrefetcher", "[TRACE_PREFETCH] getValidPreloadWebInfo: webId#" + str + ", bizId: " + ((efz)localObject1).dyc + "  prefetch:" + ((efz)localObject1).IjG + ", authorized:" + ((efz)localObject1).IjF + ", antispam:" + ((efz)localObject1).IjE + ", lastModify:" + ((efz)localObject1).iwX + ", expire:" + bool + ", url:" + paramString);
        if ((!((efz)localObject1).IjE) && (!bool)) {
          break label275;
        }
        AppMethodBeat.o(208917);
        return null;
      }
      catch (Exception localException)
      {
        com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", (Throwable)localException, "decode ProtoBuffer", new Object[0]);
      }
      i = 0;
      break;
      i = 0;
      break label61;
      label265:
      localefz = null;
      continue;
      localefz = null;
    }
    label275:
    if (!localefz.IjF)
    {
      AppMethodBeat.o(208917);
      return localefz;
    }
    if ((localefz.IjG) && (localefz.IjF) && (Yo(paramString)))
    {
      AppMethodBeat.o(208917);
      return localefz;
    }
    label319:
    com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.WebPrefetcher", "[TRACE_PREFETCH] getVaildPreloadWebInfo: webId#" + str + ", not cached, url:" + paramString + ' ');
    AppMethodBeat.o(208917);
    return null;
  }
  
  private static boolean Yr(String paramString)
  {
    AppMethodBeat.i(6806);
    String str = b.XZ(paramString);
    Object localObject1 = (ay)opW.aRy(str);
    int i;
    if (localObject1 != null) {
      if (((ay)localObject1).containsKey(str))
      {
        localObject1 = ((ay)localObject1).decodeBytes(str);
        if (localObject1 != null) {
          if (localObject1.length == 0)
          {
            i = 1;
            if (i != 0) {
              break label205;
            }
            i = 1;
            label68:
            if (i == 0) {
              break label230;
            }
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        Object localObject3 = efz.class.newInstance();
        ((com.tencent.mm.bw.a)localObject3).parseFrom((byte[])localObject1);
        localObject1 = (com.tencent.mm.bw.a)localObject3;
        localObject1 = (efz)localObject1;
        if (localObject1 == null) {
          break label242;
        }
        bool2 = com.tencent.mm.sdk.platformtools.at.al(((efz)localObject1).iwX, 540);
        bool1 = bool2;
        bool3 = true;
        com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.WebPrefetcher", "[TRACE_PREFETCH] needReauth:" + bool1 + ", webId:" + str + ", cached:" + bool3 + ", expired:" + bool2 + ", url:" + paramString);
        AppMethodBeat.o(6806);
        return bool1;
      }
      catch (Exception localException)
      {
        label205:
        com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", (Throwable)localException, "decode ProtoBuffer", new Object[0]);
      }
      i = 0;
      break;
      i = 0;
      break label68;
      label230:
      Object localObject2 = null;
      continue;
      localObject2 = null;
      continue;
      label242:
      boolean bool1 = true;
      boolean bool2 = false;
      boolean bool3 = false;
    }
  }
  
  private static boolean Ys(String paramString)
  {
    AppMethodBeat.i(208919);
    Object localObject1 = Uri.parse(UrlExKt.getWithProtocol(paramString));
    if (localObject1 != null)
    {
      localObject1 = ((Uri)localObject1).getHost();
      if (localObject1 != null)
      {
        localObject1 = b.Yb((String)localObject1);
        Object localObject3 = (ay)opX.aRy((String)localObject1);
        int i;
        if (localObject3 != null) {
          if (((ay)localObject3).containsKey((String)localObject1))
          {
            localObject1 = ((ay)localObject3).decodeBytes((String)localObject1);
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
            localObject3 = avr.class.newInstance();
            ((com.tencent.mm.bw.a)localObject3).parseFrom((byte[])localObject1);
            localObject1 = (com.tencent.mm.bw.a)localObject3;
            localObject1 = (avr)localObject1;
            if (localObject1 == null) {
              break label214;
            }
            if ((((avr)localObject1).GMK != 1) || (com.tencent.mm.sdk.platformtools.at.al(((avr)localObject1).GMM, ((avr)localObject1).GML))) {
              break label209;
            }
            bool = true;
            if (bool) {
              com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.WebPrefetcher", "[TRACE_PREFETCH] preauth cancelled, in whiteList:".concat(String.valueOf(paramString)));
            }
            AppMethodBeat.o(208919);
            return bool;
          }
          catch (Exception localException)
          {
            label176:
            com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", (Throwable)localException, "decode ProtoBuffer", new Object[0]);
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
    AppMethodBeat.o(208919);
    return false;
  }
  
  private static int Yt(String paramString)
  {
    AppMethodBeat.i(175488);
    ay localay = (ay)oqg.aRy(b.XZ(paramString));
    if (localay != null)
    {
      int i = localay.getInt(b.XZ(paramString), 0);
      AppMethodBeat.o(175488);
      return i;
    }
    AppMethodBeat.o(175488);
    return 0;
  }
  
  public static final void a(String arg0, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt)
  {
    AppMethodBeat.i(208914);
    p.h(???, "url");
    p.h(paramString2, "appId");
    p.h(paramString3, "title");
    p.h(paramString4, "desc");
    p.h(paramString5, "from");
    com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.WebPrefetcher", "preAuth: " + paramString3 + ' ' + ???);
    paramString4 = new a(???, paramString2, paramString3, paramString4, paramInt, null, null, 96);
    paramString2 = oqh;
    paramString3 = a.class.getCanonicalName() + '_' + "addToPreload";
    synchronized (bz.IBe)
    {
      paramString5 = bz.IBe;
      paramString5 = (br)bz.fpX().get(paramString3);
      if (paramString5 != null) {
        paramString5.gAf();
      }
      paramString5 = bz.IBe;
      paramString5 = bz.fpY();
      if (!paramString5.containsKey(paramString3)) {
        ((Map)paramString5).put(paramString3, new LinkedList());
      }
      paramString5 = paramString5.get(paramString3);
      if (paramString5 == null)
      {
        paramString2 = new d.v("null cannot be cast to non-null type java.util.LinkedList<T>");
        AppMethodBeat.o(208914);
        throw paramString2;
      }
    }
    ((LinkedList)paramString5).add(paramString4);
    ??? = bz.IBe;
    ((Map)bz.fpX()).put(paramString3, kotlinx.coroutines.f.b((ah)bk.OfO, (d.d.f)az.gzR(), (m)new k(1000L, paramString3, null, paramString2), 2));
    AppMethodBeat.o(208914);
  }
  
  private static void a(String arg0, final String paramString2, Map<String, String> paramMap, int paramInt)
  {
    AppMethodBeat.i(224143);
    b localb = new b(b.XY(???), ???, paramString2, paramMap, (byte)0);
    paramMap = b.class.getCanonicalName() + '_' + "batch";
    Object localObject;
    synchronized (bz.IBe)
    {
      localObject = bz.IBe;
      localObject = (br)bz.fpX().get(paramMap);
      if (localObject != null) {
        ((br)localObject).gAf();
      }
      localObject = bz.IBe;
      localObject = bz.fpY();
      if (!((HashMap)localObject).containsKey(paramMap)) {
        ((Map)localObject).put(paramMap, new LinkedList());
      }
      localObject = ((HashMap)localObject).get(paramMap);
      if (localObject == null)
      {
        paramString2 = new d.v("null cannot be cast to non-null type java.util.LinkedList<T>");
        AppMethodBeat.o(224143);
        throw paramString2;
      }
    }
    ((LinkedList)localObject).add(localb);
    ??? = bz.IBe;
    ((Map)bz.fpX()).put(paramMap, kotlinx.coroutines.f.b((ah)bk.OfO, (d.d.f)az.gzR(), (m)new m(50L, paramMap, null, paramInt, paramString2), 2));
    AppMethodBeat.o(224143);
  }
  
  public static as bQH()
  {
    return opW;
  }
  
  public static as bQI()
  {
    return opX;
  }
  
  public static as bQJ()
  {
    return opY;
  }
  
  public static as bQK()
  {
    return opZ;
  }
  
  public static v bQL()
  {
    return oqa;
  }
  
  public static v bQM()
  {
    return oqb;
  }
  
  public static v bQN()
  {
    return oqc;
  }
  
  public static am bQO()
  {
    return oqf;
  }
  
  private static int bQP()
  {
    AppMethodBeat.i(175490);
    ay localay = ay.aRW("WebPrefetcher.currentScene");
    if (localay != null)
    {
      int i = localay.decodeInt("currentScene");
      AppMethodBeat.o(175490);
      return i;
    }
    AppMethodBeat.o(175490);
    return 0;
  }
  
  public static boolean cE(String paramString, int paramInt)
  {
    AppMethodBeat.i(175489);
    p.h(paramString, "url");
    boolean bool = ((ay)oqg.fnP()).encode(b.XZ(paramString), paramInt);
    AppMethodBeat.o(175489);
    return bool;
  }
  
  public static final void cr(List<? extends d.a> paramList)
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
      localCollection.add(new a(str2, paramList, (String)localObject1, (String)localObject2, locala.obQ, null, locala.extInfo, 32));
    }
    cs((List)localCollection);
    AppMethodBeat.o(160497);
  }
  
  private static void cs(List<a> paramList)
  {
    AppMethodBeat.i(208916);
    com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.WebPrefetcher", "[TRACE_PREFETCH] preAuths size = %s", new Object[] { Integer.valueOf(paramList.size()) });
    avv localavv = new avv();
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
      if ((!oqf.contains(b.XX(((a)localObject3).url))) && (!UrlExKt.isMpUrl(((a)localObject3).url)) && (!Ys(((a)localObject3).url)) && (Yr(((a)localObject3).url)) && (!oqd.contains(((a)localObject3).url))) {}
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
      ((f)localObject3).GMU = ((a)localObject2).url;
      ((f)localObject3).ikm = ((a)localObject2).appId;
      ((f)localObject3).GMV = ((a)localObject2).title;
      ((f)localObject3).GMW = ((a)localObject2).desc;
      ((f)localObject3).GMS = i;
      ((f)localObject3).GMX = ((a)localObject2).oqi;
      ((f)localObject3).Scene = ((a)localObject2).scene;
      oqf.EL(b.XX(((a)localObject2).url));
      ((f)localObject3).extInfo = ((a)localObject2).extInfo;
      ((f)localObject3).nLC = ((a)localObject2).scene;
      paramList.add(localObject3);
      i += 1;
    }
    paramList = (List)paramList;
    localavv.GNa.addAll((Collection)paramList);
    localavv.FVa = localavv.GNa.size();
    localavv.Scene = 0;
    localavv.FSu = 0;
    if (localavv.GNa.isEmpty())
    {
      com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.WebPrefetcher", "[TRACE_PREFETCH] preAuths: nothing to preauth");
      AppMethodBeat.o(208916);
      return;
    }
    try
    {
      paramList = oqd;
      localObject1 = localavv.GNa;
      p.g(localObject1, "req.ReqInfo");
      localObject2 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        ((Collection)localObject1).add(((avu)((Iterator)localObject2).next()).GMU);
        continue;
        paramList = com.tencent.mm.plugin.webview.core.f.DZr;
      }
    }
    catch (Exception paramList)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.WebPrefetcher", "Concurrent Add Exception: " + paramList.getMessage());
    }
    for (;;)
    {
      if (f.a.eRk()) {
        CronetLogic.setUserCertVerify(true);
      }
      paramList = new StringBuilder("[TRACE_PREFETCH] sendGetA8KeyLiteRequest batch req: ");
      localObject1 = localavv.GNa;
      p.g(localObject1, "req.ReqInfo");
      com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.WebPrefetcher", d.a.j.a((Iterable)localObject1, (CharSequence)",", null, null, 0, null, (d.g.a.b)p.orn, 30));
      com.tencent.mm.ac.c.b("MicroMsg.WebPrefetcher", (d.g.a.a)new q(localavv));
      AppMethodBeat.o(208916);
      return;
      paramList.addAll((Collection)localObject1);
    }
  }
  
  public static d.b eM(String paramString1, String paramString2)
  {
    AppMethodBeat.i(208913);
    p.h(paramString1, "referer");
    p.h(paramString2, "url");
    paramString1 = new d(paramString2, b.eO(b.XY(paramString1), paramString2), oqb, opZ).bQZ();
    AppMethodBeat.o(208913);
    return paramString1;
  }
  
  public static boolean eS(String paramString1, String paramString2)
  {
    AppMethodBeat.i(208920);
    String str = new d(paramString1, b.XZ(paramString1), oqa, opY).getLocation();
    if (!n.aD((CharSequence)str)) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramString1 = b.aH(str, true);
      com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.WebPrefetcher", "isWebUrlStorageEqual: location:#" + paramString1 + ", " + str);
      paramString2 = b.aH(paramString2, true);
      com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.WebPrefetcher", "isWebUrlStorageEqual: target:#".concat(String.valueOf(paramString2)));
      boolean bool = p.i(paramString1, paramString2);
      AppMethodBeat.o(208920);
      return bool;
    }
    AppMethodBeat.o(208920);
    return false;
  }
  
  public static void zS(int paramInt)
  {
    AppMethodBeat.i(175491);
    ay localay = ay.aRW("WebPrefetcher.currentScene");
    if (localay != null)
    {
      localay.encode("currentScene", paramInt);
      AppMethodBeat.o(175491);
      return;
    }
    AppMethodBeat.o(175491);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$BatchPreauth;", "", "url", "", "appId", "title", "desc", "scene", "", "refer", "extInfo", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getDesc", "getExtInfo", "getRefer", "getScene", "()I", "getTitle", "getUrl", "plugin-brandservice_release"})
  static final class a
  {
    final String appId;
    final String desc;
    final String extInfo;
    final String oqi;
    final int scene;
    final String title;
    final String url;
    
    private a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5, String paramString6)
    {
      AppMethodBeat.i(208843);
      this.url = paramString1;
      this.appId = paramString2;
      this.title = paramString3;
      this.desc = paramString4;
      this.scene = paramInt;
      this.oqi = paramString5;
      this.extInfo = paramString6;
      AppMethodBeat.o(208843);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchAction;", "", "host", "", "rawUrl", "prefetchUrl", "checkCacheOnly", "", "prefetchHeader", "", "bizScene", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/util/Map;I)V", "getBizScene", "()I", "getCheckCacheOnly", "()Z", "getHost", "()Ljava/lang/String;", "getPrefetchHeader", "()Ljava/util/Map;", "getPrefetchUrl", "getRawUrl", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "plugin-brandservice_release"})
  static final class b
  {
    final String dLz;
    final String host;
    private final int nLC;
    final String oqj;
    final boolean oqk;
    final Map<String, String> oql;
    
    private b(String paramString1, String paramString2, String paramString3, Map<String, String> paramMap)
    {
      AppMethodBeat.i(208845);
      this.host = paramString1;
      this.dLz = paramString2;
      this.oqj = paramString3;
      this.oqk = false;
      this.oql = paramMap;
      this.nLC = 0;
      AppMethodBeat.o(208845);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(208848);
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if ((!p.i(this.host, paramObject.host)) || (!p.i(this.dLz, paramObject.dLz)) || (!p.i(this.oqj, paramObject.oqj)) || (this.oqk != paramObject.oqk) || (!p.i(this.oql, paramObject.oql)) || (this.nLC != paramObject.nLC)) {}
        }
      }
      else
      {
        AppMethodBeat.o(208848);
        return true;
      }
      AppMethodBeat.o(208848);
      return false;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(208846);
      String str = "PrefetchAction(host=" + this.host + ", rawUrl=" + this.dLz + ", prefetchUrl=" + this.oqj + ", checkCacheOnly=" + this.oqk + ", prefetchHeader=" + this.oql + ", bizScene=" + this.nLC + ")";
      AppMethodBeat.o(208846);
      return str;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchRes;", "", "url", "", "type", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchType;", "bizScene", "", "(Ljava/lang/String;Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchType;I)V", "getBizScene", "()I", "getType", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchType;", "getUrl", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "plugin-brandservice_release"})
  static final class c
  {
    final int nLC;
    final t.e oqm;
    final String url;
    
    public c(String paramString, t.e parame, int paramInt)
    {
      AppMethodBeat.i(224139);
      this.url = paramString;
      this.oqm = parame;
      this.nLC = paramInt;
      AppMethodBeat.o(224139);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(208852);
      if (this != paramObject)
      {
        if ((paramObject instanceof c))
        {
          paramObject = (c)paramObject;
          if ((!p.i(this.url, paramObject.url)) || (!p.i(this.oqm, paramObject.oqm)) || (this.nLC != paramObject.nLC)) {}
        }
      }
      else
      {
        AppMethodBeat.o(208852);
        return true;
      }
      AppMethodBeat.o(208852);
      return false;
    }
    
    public final int hashCode()
    {
      int j = 0;
      AppMethodBeat.i(208851);
      Object localObject = this.url;
      if (localObject != null) {}
      for (int i = localObject.hashCode();; i = 0)
      {
        localObject = this.oqm;
        if (localObject != null) {
          j = localObject.hashCode();
        }
        int k = this.nLC;
        AppMethodBeat.o(208851);
        return (i * 31 + j) * 31 + k;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(208850);
      String str = "PrefetchRes(url=" + this.url + ", type=" + this.oqm + ", bizScene=" + this.nLC + ")";
      AppMethodBeat.o(208850);
      return str;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchTarget;", "", "url", "", "webId", "content", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcherFile;", "headerSlot", "Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcherFile;Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;)V", "bizId", "getBizId", "()Ljava/lang/String;", "bizId$delegate", "Lkotlin/Lazy;", "bizScene", "", "getBizScene", "()I", "bizScene$delegate", "cacheTime", "", "getCacheTime", "()J", "getContent", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcherFile;", "eTag", "getETag", "fullUrl", "getFullUrl", "fullUrl$delegate", "getHeaderSlot", "()Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "headers", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getHeaders", "()Ljava/util/HashMap;", "headers$delegate", "isCached", "", "()Z", "isRedirect", "location", "getLocation", "maxCache", "getMaxCache", "mimeType", "getMimeType", "prefetchHost", "getPrefetchHost", "prefetchUrl", "getPrefetchUrl", "response", "Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService$PrefetchResponse;", "getResponse", "()Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService$PrefetchResponse;", "type", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchType;", "getType", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchType;", "getUrl", "version", "getVersion", "getWebId", "wxETag", "getWxETag", "createResponse", "refresh", "", "saveHeaders", "host", "plugin-brandservice_release"})
  static final class d
  {
    private final d.f oqn;
    private final d.f oqo;
    private final d.f oqp;
    final String oqq;
    final v oqr;
    final as oqs;
    private final d.f tRC;
    final String url;
    
    public d(String paramString1, String paramString2, v paramv, as paramas)
    {
      AppMethodBeat.i(208878);
      this.url = paramString1;
      this.oqq = paramString2;
      this.oqr = paramv;
      this.oqs = paramas;
      this.oqn = d.g.O((d.g.a.a)new a(this));
      this.oqo = d.g.O((d.g.a.a)new c(this));
      this.tRC = d.g.O((d.g.a.a)new t.d.e(this));
      this.oqp = d.g.O((d.g.a.a)new d(this));
      AppMethodBeat.o(208878);
    }
    
    private t.e bQT()
    {
      AppMethodBeat.i(208865);
      Object localObject = (List)bQS().get("x-wx-client-prefetch-type");
      if (localObject != null)
      {
        localObject = (String)d.a.j.jl((List)localObject);
        if (localObject != null)
        {
          if (localObject == null)
          {
            localObject = new d.v("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(208865);
            throw ((Throwable)localObject);
          }
          localObject = ((String)localObject).toUpperCase();
          p.g(localObject, "(this as java.lang.String).toUpperCase()");
          t.e locale = t.e.valueOf((String)localObject);
          localObject = locale;
          if (locale != null) {
            break label81;
          }
        }
      }
      localObject = t.e.oqx;
      label81:
      AppMethodBeat.o(208865);
      return localObject;
    }
    
    private final d.b bRa()
    {
      AppMethodBeat.i(208876);
      int i = bQS().size();
      boolean bool = this.oqr.contains(bQR());
      if ((i == 0) || (!bool))
      {
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.WebPrefetcher", "createResponse fail headerSize:" + i + ", containsFile:" + bool);
        AppMethodBeat.o(208876);
        return null;
      }
      d.b localb = new d.b();
      localb.url = ((String)this.oqo.getValue());
      localb.obS = bQT().toString();
      Object localObject1 = (List)bQS().get("x-wx-version");
      if (localObject1 != null)
      {
        localObject1 = (String)d.a.j.jl((List)localObject1);
        if (localObject1 == null) {}
      }
      Map localMap;
      for (long l = Long.parseLong((String)localObject1);; l = -1L)
      {
        localb.obR = l;
        localb.nLC = bLI();
        localObject1 = b.oqu;
        b.i(bQS());
        localObject1 = getMimeType();
        Object localObject2 = (Map)bQS();
        localMap = (Map)new LinkedHashMap(d.a.ae.ajS(((Map)localObject2).size()));
        localObject2 = ((Iterable)((Map)localObject2).entrySet()).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Object localObject4 = ((Iterator)localObject2).next();
          Object localObject3 = ((Map.Entry)localObject4).getKey();
          localObject4 = (Map.Entry)localObject4;
          ((Map.Entry)localObject4).getKey();
          localMap.put(localObject3, (String)d.a.j.jl((List)((Map.Entry)localObject4).getValue()));
        }
      }
      localb.obT = new WebResourceResponse((String)localObject1, "UTF-8", 200, "OK", localMap, o.ai(this.oqr.Yu(bQR())));
      AppMethodBeat.o(208876);
      return localb;
    }
    
    private final String getMimeType()
    {
      AppMethodBeat.i(208867);
      Object localObject = (List)bQS().get("content-type");
      if (localObject != null)
      {
        localObject = (String)d.a.j.jl((List)localObject);
        if (localObject != null)
        {
          localObject = n.nH((String)localObject, ";");
          if (localObject != null)
          {
            if (localObject == null)
            {
              localObject = new d.v("null cannot be cast to non-null type kotlin.CharSequence");
              AppMethodBeat.o(208867);
              throw ((Throwable)localObject);
            }
            String str = n.trim((CharSequence)localObject).toString();
            localObject = str;
            if (str != null) {
              break label92;
            }
          }
        }
      }
      localObject = "text/html";
      label92:
      AppMethodBeat.o(208867);
      return localObject;
    }
    
    private void refresh()
    {
      AppMethodBeat.i(208874);
      if ((bQT() == t.e.oqx) && (bQV() > 0L) && (bQU() > 0) && (com.tencent.mm.sdk.platformtools.at.al(bQV(), Math.max(bQU() - 60, 60))))
      {
        Object localObject = t.oqh;
        com.tencent.mm.plugin.webview.h.b.XJ(t.XH(this.url));
        localObject = t.oqh;
        String str2 = this.url;
        localObject = (List)bQS().get("x-wx-client-prefetch-url");
        if (localObject != null)
        {
          String str1 = (String)d.a.j.jl((List)localObject);
          localObject = str1;
          if (str1 != null) {}
        }
        else
        {
          localObject = "";
        }
        t.eR(str2, (String)localObject);
      }
      AppMethodBeat.o(208874);
    }
    
    public final void a(t.e parame, String paramString)
    {
      AppMethodBeat.i(208877);
      p.h(parame, "type");
      p.h(paramString, "host");
      ((Map)bQS()).put("x-wx-client-cache-time", d.a.j.listOf(String.valueOf(System.currentTimeMillis())));
      ((Map)bQS()).put("x-wx-client-prefetch-url", d.a.j.listOf(this.url));
      if (!n.aD((CharSequence)paramString)) {}
      efy localefy;
      LinkedList localLinkedList;
      Collection localCollection;
      Object localObject;
      efx localefx;
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          ((Map)bQS()).put("x-wx-client-prefetch-host", d.a.j.listOf(paramString));
        }
        ((Map)bQS()).put("x-wx-client-prefetch-type", d.a.j.listOf(parame.toString()));
        localefy = new efy();
        localLinkedList = localefy.IjD;
        paramString = (Map)bQS();
        localCollection = (Collection)new ArrayList(paramString.size());
        Iterator localIterator = paramString.entrySet().iterator();
        if (!localIterator.hasNext()) {
          break label403;
        }
        localObject = (Map.Entry)localIterator.next();
        paramString = (String)((Map.Entry)localObject).getKey();
        localObject = (List)((Map.Entry)localObject).getValue();
        localefx = new efx();
        if (paramString != null) {
          break;
        }
        parame = new d.v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(208877);
        throw parame;
      }
      String str = paramString.toLowerCase();
      p.g(str, "(this as java.lang.String).toLowerCase()");
      switch (str.hashCode())
      {
      }
      for (;;)
      {
        localefx.key = paramString;
        localefx.GKl.addAll((Collection)localObject);
        localCollection.add(localefx);
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
      ((ay)this.oqs.fnP()).encode(bQR(), localefy.toByteArray());
      com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.WebPrefetcher", "saveHeaders " + parame + " : webId:" + this.oqq + ", bizId:" + bQR() + ", header size:" + bQS().size());
      AppMethodBeat.o(208877);
    }
    
    public final int bLI()
    {
      AppMethodBeat.i(224142);
      int i = ((Number)this.tRC.getValue()).intValue();
      AppMethodBeat.o(224142);
      return i;
    }
    
    public final String bQR()
    {
      AppMethodBeat.i(208863);
      String str = (String)this.oqn.getValue();
      AppMethodBeat.o(208863);
      return str;
    }
    
    public final HashMap<String, List<String>> bQS()
    {
      AppMethodBeat.i(208864);
      HashMap localHashMap = (HashMap)this.oqp.getValue();
      AppMethodBeat.o(208864);
      return localHashMap;
    }
    
    public final int bQU()
    {
      AppMethodBeat.i(208868);
      Object localObject = (List)bQS().get("x-wx-max-cache");
      if (localObject != null)
      {
        localObject = (String)d.a.j.jl((List)localObject);
        if (localObject != null) {
          localObject = Integer.valueOf(Integer.parseInt((String)localObject));
        }
      }
      while (localObject != null)
      {
        int i = ((Integer)localObject).intValue();
        AppMethodBeat.o(208868);
        return i;
        localObject = (List)bQS().get("max-age");
        if (localObject != null)
        {
          localObject = (String)d.a.j.jl((List)localObject);
          if (localObject != null)
          {
            localObject = Integer.valueOf(Integer.parseInt((String)localObject));
            continue;
          }
        }
        localObject = null;
      }
      AppMethodBeat.o(208868);
      return 600;
    }
    
    public final long bQV()
    {
      AppMethodBeat.i(208869);
      Object localObject = (List)bQS().get("x-wx-client-cache-time");
      if (localObject != null)
      {
        localObject = (String)d.a.j.jl((List)localObject);
        if (localObject != null)
        {
          long l = Long.parseLong((String)localObject);
          AppMethodBeat.o(208869);
          return l;
        }
      }
      AppMethodBeat.o(208869);
      return -1L;
    }
    
    public final String bQW()
    {
      AppMethodBeat.i(208870);
      Object localObject = (List)bQS().get("x-wx-etag");
      if (localObject != null)
      {
        String str = (String)d.a.j.jl((List)localObject);
        localObject = str;
        if (str != null) {}
      }
      else
      {
        localObject = "";
      }
      AppMethodBeat.o(208870);
      return localObject;
    }
    
    public final String bQX()
    {
      AppMethodBeat.i(208871);
      Object localObject = (List)bQS().get("etag");
      if (localObject != null)
      {
        String str = (String)d.a.j.jl((List)localObject);
        localObject = str;
        if (str != null) {}
      }
      else
      {
        localObject = "";
      }
      AppMethodBeat.o(208871);
      return localObject;
    }
    
    public final boolean bQY()
    {
      AppMethodBeat.i(208873);
      Object localObject = (List)bQS().get("status");
      if (localObject != null)
      {
        localObject = (String)d.a.j.jl((List)localObject);
        if (localObject != null) {
          break label49;
        }
      }
      label49:
      do
      {
        do
        {
          for (;;)
          {
            AppMethodBeat.o(208873);
            return false;
            localObject = null;
            break;
            switch (((String)localObject).hashCode())
            {
            }
          }
        } while (!((String)localObject).equals("200"));
        boolean bool = this.oqr.contains(bQR());
        AppMethodBeat.o(208873);
        return bool;
      } while (!((String)localObject).equals("301"));
      for (;;)
      {
        if (n.aD((CharSequence)getLocation())) {
          break label165;
        }
        AppMethodBeat.o(208873);
        return true;
        if (!((String)localObject).equals("302")) {
          break;
        }
      }
      label165:
      AppMethodBeat.o(208873);
      return false;
    }
    
    public final d.b bQZ()
    {
      AppMethodBeat.i(208875);
      Object localObject1 = this;
      while (((d)localObject1).bQY())
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WebPrefetcher", "fetch cached: #" + ((d)localObject1).oqq + ", " + ((d)localObject1).url);
        Object localObject2 = ((d)localObject1).bQT();
        switch (u.cqt[localObject2.ordinal()])
        {
        default: 
          localObject1 = ((d)localObject1).bRa();
          AppMethodBeat.o(208875);
          return localObject1;
        }
        Object localObject3;
        if (((d)localObject1).isRedirect())
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WebPrefetcher", "HTML redirect, location:" + ((d)localObject1).getLocation());
          localObject2 = ((d)localObject1).getLocation();
          localObject1 = b.XZ(((d)localObject1).getLocation());
          localObject3 = t.oqh;
          localObject3 = t.bQL();
          t localt = t.oqh;
          localObject1 = new d((String)localObject2, (String)localObject1, (v)localObject3, t.bQJ());
        }
        else
        {
          localObject2 = t.oqh;
          if (t.XE(((d)localObject1).url))
          {
            if (!com.tencent.mm.sdk.platformtools.at.al(((d)localObject1).bQV(), ((d)localObject1).bQU()))
            {
              localObject2 = (List)((d)localObject1).bQS().get("set-cookie");
              if (localObject2 != null)
              {
                localObject2 = ((Iterable)localObject2).iterator();
                while (((Iterator)localObject2).hasNext())
                {
                  localObject3 = (String)((Iterator)localObject2).next();
                  com.tencent.xweb.c.geY().setCookie(((d)localObject1).url, (String)localObject3);
                }
              }
              localObject1 = ((d)localObject1).bRa();
              AppMethodBeat.o(208875);
              return localObject1;
            }
            com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.WebPrefetcher", "doc expired refresh cached: #" + ((d)localObject1).oqq + ", " + ((d)localObject1).url);
            ((d)localObject1).refresh();
            AppMethodBeat.o(208875);
            return null;
          }
          com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.WebPrefetcher", "preauth expired preauth: #" + ((d)localObject1).oqq + ", " + ((d)localObject1).url);
          t.Yp(((d)localObject1).url);
          AppMethodBeat.o(208875);
          return null;
        }
      }
      AppMethodBeat.o(208875);
      return null;
    }
    
    public final String getLocation()
    {
      AppMethodBeat.i(208866);
      Object localObject = (List)bQS().get("location");
      if (localObject != null)
      {
        String str = (String)d.a.j.jl((List)localObject);
        localObject = str;
        if (str != null) {}
      }
      else
      {
        localObject = "";
      }
      AppMethodBeat.o(208866);
      return localObject;
    }
    
    public final boolean isRedirect()
    {
      AppMethodBeat.i(208872);
      Object localObject = (List)bQS().get("status");
      if (localObject != null)
      {
        localObject = (String)d.a.j.jl((List)localObject);
        if (localObject != null) {
          break label49;
        }
      }
      label49:
      do
      {
        for (;;)
        {
          AppMethodBeat.o(208872);
          return false;
          localObject = null;
          break;
          switch (((String)localObject).hashCode())
          {
          }
        }
      } while (!((String)localObject).equals("301"));
      for (;;)
      {
        AppMethodBeat.o(208872);
        return true;
        if (!((String)localObject).equals("302")) {
          break;
        }
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements d.g.a.a<String>
    {
      a(t.d paramd)
      {
        super();
      }
      
      private String beJ()
      {
        AppMethodBeat.i(208855);
        Object localObject1 = t.oqh;
        Object localObject3 = t.bQH();
        localObject1 = this.oqt.oqq;
        localObject3 = (ay)((as)localObject3).aRy((String)localObject1);
        int i;
        if (localObject3 != null) {
          if (((ay)localObject3).containsKey((String)localObject1))
          {
            localObject1 = ((ay)localObject3).decodeBytes((String)localObject1);
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
            localObject3 = efz.class.newInstance();
            ((com.tencent.mm.bw.a)localObject3).parseFrom((byte[])localObject1);
            localObject1 = (com.tencent.mm.bw.a)localObject3;
            localObject1 = (efz)localObject1;
            if (localObject1 != null)
            {
              localObject3 = ((efz)localObject1).dyc;
              localObject1 = localObject3;
              if (localObject3 != null) {}
            }
            else
            {
              localObject1 = this.oqt.oqq;
            }
            AppMethodBeat.o(208855);
            return localObject1;
          }
          catch (Exception localException)
          {
            label129:
            com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", (Throwable)localException, "decode ProtoBuffer", new Object[0]);
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
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"removeInvalidHeaders", "", "headers", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "invoke"})
    static final class b
      extends q
      implements d.g.a.b<HashMap<String, List<? extends String>>, z>
    {
      public static final b oqu;
      
      static
      {
        AppMethodBeat.i(208858);
        oqu = new b();
        AppMethodBeat.o(208858);
      }
      
      b()
      {
        super();
      }
      
      public static void i(HashMap<String, List<String>> paramHashMap)
      {
        AppMethodBeat.i(208857);
        p.h(paramHashMap, "headers");
        Object localObject1 = paramHashMap.keySet();
        p.g(localObject1, "headers.keys");
        Object localObject2 = (Iterable)localObject1;
        localObject1 = (Collection)new ArrayList();
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Object localObject3 = ((Iterator)localObject2).next();
          String str = (String)localObject3;
          Set localSet = w.bRd();
          p.g(str, "it");
          if (str == null)
          {
            paramHashMap = new d.v("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(208857);
            throw paramHashMap;
          }
          str = str.toLowerCase();
          p.g(str, "(this as java.lang.String).toLowerCase()");
          if (localSet.contains(str)) {
            ((Collection)localObject1).add(localObject3);
          }
        }
        localObject1 = (List)localObject1;
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WebPrefetcher", "removeInvalidHeaders size: " + ((List)localObject1).size());
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext()) {
          paramHashMap.remove((String)((Iterator)localObject1).next());
        }
        AppMethodBeat.o(208857);
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
    static final class c
      extends q
      implements d.g.a.a<String>
    {
      c(t.d paramd)
      {
        super();
      }
      
      private String beJ()
      {
        AppMethodBeat.i(208860);
        Object localObject1 = t.oqh;
        Object localObject3 = t.bQH();
        localObject1 = this.oqt.oqq;
        localObject3 = (ay)((as)localObject3).aRy((String)localObject1);
        int i;
        if (localObject3 != null) {
          if (((ay)localObject3).containsKey((String)localObject1))
          {
            localObject1 = ((ay)localObject3).decodeBytes((String)localObject1);
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
            localObject3 = efz.class.newInstance();
            ((com.tencent.mm.bw.a)localObject3).parseFrom((byte[])localObject1);
            localObject1 = (com.tencent.mm.bw.a)localObject3;
            localObject1 = (efz)localObject1;
            if (localObject1 != null)
            {
              localObject3 = ((efz)localObject1).osm;
              localObject1 = localObject3;
              if (localObject3 != null) {}
            }
            else
            {
              localObject1 = this.oqt.url;
            }
            AppMethodBeat.o(208860);
            return localObject1;
          }
          catch (Exception localException)
          {
            label129:
            com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", (Throwable)localException, "decode ProtoBuffer", new Object[0]);
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
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "invoke"})
    static final class d
      extends q
      implements d.g.a.a<HashMap<String, List<? extends String>>>
    {
      d(t.d paramd)
      {
        super();
      }
      
      private HashMap<String, List<String>> bRb()
      {
        AppMethodBeat.i(208862);
        Object localObject2 = this.oqt.oqs;
        Object localObject1 = this.oqt.bQR();
        localObject2 = (ay)((as)localObject2).aRy((String)localObject1);
        int i;
        if (localObject2 != null) {
          if (((ay)localObject2).containsKey((String)localObject1))
          {
            localObject1 = ((ay)localObject2).decodeBytes((String)localObject1);
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
            localObject2 = efy.class.newInstance();
            ((com.tencent.mm.bw.a)localObject2).parseFrom((byte[])localObject1);
            localObject1 = (com.tencent.mm.bw.a)localObject2;
            localObject2 = (efy)localObject1;
            localObject1 = new HashMap();
            if (localObject2 == null) {
              break label201;
            }
            localObject2 = ((efy)localObject2).IjD;
            p.g(localObject2, "it.header");
            localObject2 = ((Iterable)localObject2).iterator();
            if (!((Iterator)localObject2).hasNext()) {
              break label201;
            }
            efx localefx = (efx)((Iterator)localObject2).next();
            ((HashMap)localObject1).put(localefx.key, localefx.GKl);
            continue;
            i = 0;
          }
          catch (Exception localException)
          {
            com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", (Throwable)localException, "decode ProtoBuffer", new Object[0]);
          }
          i = 0;
          break label65;
          localHashMap = null;
          continue;
          localHashMap = null;
        }
        label201:
        AppMethodBeat.o(208862);
        return localHashMap;
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchType;", "", "type", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "toString", "JS", "CSS", "HTML", "plugin-brandservice_release"})
  static enum e
  {
    private final String type;
    
    static
    {
      AppMethodBeat.i(208879);
      e locale1 = new e("JS", 0, "JS");
      oqv = locale1;
      e locale2 = new e("CSS", 1, "CSS");
      oqw = locale2;
      e locale3 = new e("HTML", 2, "HTML");
      oqx = locale3;
      oqy = new e[] { locale1, locale2, locale3 };
      AppMethodBeat.o(208879);
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
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$connect$2$1", "Lcom/tencent/mars/cdn/CronetLogic$CronetTaskCallback;", "onCronetReceiveHeader", "", "header", "Lcom/tencent/mars/cdn/CronetLogic$ResponseHeader;", "status_code", "onCronetTaskCompleted", "", "filekey", "", "result", "Lcom/tencent/mars/cdn/CronetLogic$CronetTaskResult;", "onDownloadProgressChanged", "progress", "Lcom/tencent/mars/cdn/CronetLogic$CronetDownloadProgress;", "plugin-brandservice_release"})
  public static final class f
    implements CronetLogic.CronetTaskCallback
  {
    f(com.tencent.mm.network.x paramx, String paramString, k paramk, d.g.a.b paramb1, d.g.a.b paramb2) {}
    
    public final int onCronetReceiveHeader(CronetLogic.ResponseHeader paramResponseHeader, int paramInt)
    {
      AppMethodBeat.i(208883);
      if (((Boolean)this.oqC.invoke(Integer.valueOf(paramInt))).booleanValue())
      {
        AppMethodBeat.o(208883);
        return 0;
      }
      paramResponseHeader = this.oqD;
      if (paramResponseHeader != null) {
        paramResponseHeader.invoke(Boolean.FALSE);
      }
      AppMethodBeat.o(208883);
      return -99;
    }
    
    public final void onCronetTaskCompleted(String paramString, CronetLogic.CronetTaskResult paramCronetTaskResult)
    {
      AppMethodBeat.i(208882);
      if (paramCronetTaskResult != null) {
        switch (paramCronetTaskResult.statusCode)
        {
        }
      }
      for (;;)
      {
        paramString = new k(this.oqz.getSavePath());
        if (paramString.exists()) {
          paramString.delete();
        }
        paramString = this.oqD;
        if (paramString == null) {
          break;
        }
        paramString.invoke(Boolean.valueOf(o.fB(this.oqA)));
        AppMethodBeat.o(208882);
        return;
        if (o.mG(this.oqz.getSavePath(), this.oqA))
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WebPrefetcher", "save file:" + this.oqz.getURL() + " to " + this.oqA);
        }
        else
        {
          com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.WebPrefetcher", "save conn failed:" + this.oqz.getURL() + " to " + this.oqz.getSavePath());
          continue;
          this.oqC.invoke(Integer.valueOf(paramCronetTaskResult.statusCode));
        }
      }
      AppMethodBeat.o(208882);
    }
    
    public final void onDownloadProgressChanged(String paramString, CronetLogic.CronetDownloadProgress paramCronetDownloadProgress) {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "", "invoke"})
  static final class g
    extends q
    implements d.g.a.b<Integer, Boolean>
  {
    public static final g oqE;
    
    static
    {
      AppMethodBeat.i(208885);
      oqE = new g();
      AppMethodBeat.o(208885);
    }
    
    g()
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/network/MMHttpUrlCronetConnection;", "conn", "invoke"})
  static final class h
    extends q
    implements d.g.a.b<com.tencent.mm.network.x, com.tencent.mm.network.x>
  {
    h(Map paramMap, t.d paramd, String paramString1, String paramString2)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/network/MMHttpUrlCronetConnection;", "conn", "invoke", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$fetchManifest$2$1"})
  static final class i
    extends q
    implements d.g.a.b<com.tencent.mm.network.x, com.tencent.mm.network.x>
  {
    i(String paramString, d paramd, j paramj)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/network/MMHttpUrlCronetConnection;", "conn", "invoke", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$fetchRes$1$1"})
  static final class j
    extends q
    implements d.g.a.b<com.tencent.mm.network.x, com.tencent.mm.network.x>
  {
    j(String paramString1, t.c paramc, String paramString2)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/mm/sdk/platformtools/MMBatchRunKt$batchRun$2"})
  public static final class k
    extends d.d.b.a.j
    implements m<ah, d<? super z>, Object>
  {
    int label;
    Object ocA;
    private ah ocz;
    
    public k(long paramLong, String paramString, d paramd, t paramt)
    {
      super();
    }
    
    public final d<z> a(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(6785);
      p.h(paramd, "completion");
      paramd = new k(this.opu, this.kAY, paramd, this.oqT);
      paramd.ocz = ((ah)paramObject);
      AppMethodBeat.o(6785);
      return paramd;
    }
    
    public final Object cR(Object paramObject)
    {
      AppMethodBeat.i(6784);
      Object localObject = d.d.a.a.Nif;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(6784);
        throw paramObject;
      case 0: 
        paramObject = this.ocz;
        long l = this.opu;
        this.ocA = paramObject;
        this.label = 1;
        if (kotlinx.coroutines.at.a(l, this) == localObject)
        {
          AppMethodBeat.o(6784);
          return localObject;
        }
        break;
      case 1: 
        paramObject = (ah)this.ocA;
      }
      if (!ai.a(paramObject))
      {
        paramObject = z.Nhr;
        AppMethodBeat.o(6784);
        return paramObject;
      }
      synchronized (bz.IBe)
      {
        paramObject = bz.IBe;
        localObject = bz.fpY().get(this.kAY);
        paramObject = localObject;
        if (!(localObject instanceof Queue)) {
          paramObject = null;
        }
        paramObject = (Queue)paramObject;
        if (paramObject != null)
        {
          localObject = bz.IBe;
          bz.fpY().remove(this.kAY);
          paramObject = new ArrayList((Collection)paramObject);
          if (paramObject != null) {
            t.ct((List)paramObject);
          }
          paramObject = bz.IBe;
          bz.fpX().remove(this.kAY);
          paramObject = z.Nhr;
          AppMethodBeat.o(6784);
          return paramObject;
        }
        paramObject = null;
      }
    }
    
    public final Object p(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(6786);
      paramObject1 = ((k)a(paramObject1, (d)paramObject2)).cR(z.Nhr);
      AppMethodBeat.o(6786);
      return paramObject1;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class l
    implements Runnable
  {
    l(List paramList) {}
    
    public final void run()
    {
      AppMethodBeat.i(208895);
      LinkedList localLinkedList = new LinkedList();
      Iterator localIterator = ((Iterable)this.oqU).iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        try
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WebPrefetcher", "pre dns:".concat(String.valueOf(InetAddress.getByName(str))));
          c.a locala = com.tencent.mm.plugin.brandservice.c.obp;
          com.tencent.mm.plugin.brandservice.c.bOn().EL(str);
          localLinkedList.add(str);
        }
        catch (Exception localException)
        {
          com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.WebPrefetcher", "InetAddress Error, " + localException.getMessage());
        }
      }
      com.tencent.mm.plugin.webview.h.b.XH(localLinkedList.size());
      AppMethodBeat.o(208895);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/mm/sdk/platformtools/MMBatchRunKt$batchRun$2"})
  public static final class m
    extends d.d.b.a.j
    implements m<ah, d<? super z>, Object>
  {
    int label;
    Object ocA;
    private ah ocz;
    
    public m(long paramLong, String paramString1, d paramd, int paramInt, String paramString2)
    {
      super();
    }
    
    public final d<z> a(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(6796);
      p.h(paramd, "completion");
      paramd = new m(this.opu, this.kAY, paramd, paramString2, this.tRF);
      paramd.ocz = ((ah)paramObject);
      AppMethodBeat.o(6796);
      return paramd;
    }
    
    public final Object cR(Object paramObject)
    {
      AppMethodBeat.i(6795);
      Object localObject1 = d.d.a.a.Nif;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(6795);
        throw paramObject;
      case 0: 
        paramObject = this.ocz;
        long l = this.opu;
        this.ocA = paramObject;
        this.label = 1;
        if (kotlinx.coroutines.at.a(l, this) == localObject1)
        {
          AppMethodBeat.o(6795);
          return localObject1;
        }
        break;
      case 1: 
        paramObject = (ah)this.ocA;
      }
      if (!ai.a(paramObject))
      {
        paramObject = z.Nhr;
        AppMethodBeat.o(6795);
        return paramObject;
      }
      for (;;)
      {
        synchronized (bz.IBe)
        {
          paramObject = bz.IBe;
          localObject1 = bz.fpY().get(this.kAY);
          paramObject = localObject1;
          if (!(localObject1 instanceof Queue)) {
            paramObject = null;
          }
          paramObject = (Queue)paramObject;
          if (paramObject != null)
          {
            localObject1 = bz.IBe;
            bz.fpY().remove(this.kAY);
            paramObject = new ArrayList((Collection)paramObject);
            if (paramObject == null) {
              break;
            }
            paramObject = ((Iterable)paramObject).iterator();
            if (!paramObject.hasNext()) {
              break;
            }
            localObject1 = (t.b)paramObject.next();
            ??? = ((t.b)localObject1).dLz;
            localObject3 = b.XZ(((t.b)localObject1).dLz);
            Object localObject4 = t.oqh;
            localObject4 = t.bQL();
            t localt = t.oqh;
            ??? = new t.d((String)???, (String)localObject3, (v)localObject4, t.bQJ());
            if (!((t.d)???).bQY()) {
              break label505;
            }
            if (((t.b)localObject1).oqk) {
              continue;
            }
            int i = Math.max(((t.d)???).bQU() - 60, 60);
            if ((((t.d)???).bQV() > 0L) && (com.tencent.mm.sdk.platformtools.at.al(((t.d)???).bQV(), i)))
            {
              com.tencent.mm.plugin.report.service.g.yxI.f(21074, new Object[] { ((t.b)localObject1).host, Integer.valueOf(paramString2), Integer.valueOf(2), this.tRF, this.tRF, Integer.valueOf(2) });
              localObject3 = t.oqh;
              t.a(((t.b)localObject1).oqj, ((t.b)localObject1).host, (t.d)???, ((t.b)localObject1).oql);
              continue;
            }
          }
          else
          {
            paramObject = null;
          }
        }
        com.tencent.mm.plugin.report.service.g.yxI.f(21074, new Object[] { ((t.b)localObject1).host, Integer.valueOf(paramString2), Integer.valueOf(2), this.tRF, this.tRF, Integer.valueOf(1) });
        continue;
        label505:
        com.tencent.mm.plugin.report.service.g.yxI.f(21074, new Object[] { ((t.b)localObject1).host, Integer.valueOf(paramString2), Integer.valueOf(2), this.tRF, this.tRF, Integer.valueOf(3) });
        Object localObject3 = t.oqh;
        t.a(((t.b)localObject1).oqj, ((t.b)localObject1).host, (t.d)???, ((t.b)localObject1).oql);
      }
      paramObject = bz.IBe;
      bz.fpX().remove(this.kAY);
      paramObject = z.Nhr;
      AppMethodBeat.o(6795);
      return paramObject;
    }
    
    public final Object p(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(6797);
      paramObject1 = ((m)a(paramObject1, (d)paramObject2)).cR(z.Nhr);
      AppMethodBeat.o(6797);
      return paramObject1;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyLitePrefetchResInfo;", "kotlin.jvm.PlatformType", "invoke"})
  static final class n
    extends q
    implements d.g.a.b<avt, String>
  {
    public static final n oqV;
    
    static
    {
      AppMethodBeat.i(208897);
      oqV = new n();
      AppMethodBeat.o(208897);
    }
    
    n()
    {
      super();
    }
  }
  
  @d.d.b.a.f(c="com.tencent.mm.plugin.brandservice.ui.timeline.preload.WebPrefetcher$savePrefetch$1", f="WebPrefetcher.kt", gkn={950, 950, 966}, m="invokeSuspend")
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class o
    extends d.d.b.a.j
    implements m<ah, d<? super z>, Object>
  {
    int label;
    Object ocA;
    private ah ocz;
    Object oqW;
    Object oqX;
    Object oqY;
    Object oqZ;
    Object ora;
    Object orb;
    Object orc;
    Object ord;
    Object ore;
    Object orf;
    Object org;
    int orh;
    int ori;
    boolean orj;
    
    o(avx paramavx, avv paramavv, List paramList, d paramd)
    {
      super();
    }
    
    public final d<z> a(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(208899);
      p.h(paramd, "completion");
      paramd = new o(this.ork, this.orl, this.orm, paramd);
      paramd.ocz = ((ah)paramObject);
      AppMethodBeat.o(208899);
      return paramd;
    }
    
    public final Object cR(Object paramObject)
    {
      AppMethodBeat.i(208898);
      d.d.a.a locala = d.d.a.a.Nif;
      Object localObject2;
      Object localObject6;
      Object localObject5;
      Object localObject4;
      Object localObject1;
      int i;
      int j;
      Object localObject7;
      Object localObject9;
      Object localObject18;
      Object localObject10;
      Object localObject14;
      boolean bool1;
      label353:
      Object localObject11;
      label517:
      Object localObject12;
      int k;
      label586:
      label601:
      label607:
      Object localObject15;
      label689:
      label834:
      Object localObject13;
      label782:
      label1205:
      label1211:
      label1351:
      Object localObject21;
      Object localObject19;
      Object localObject20;
      label1638:
      Object localObject17;
      Object localObject22;
      int m;
      Object localObject16;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(208898);
        throw paramObject;
      case 0: 
        localObject2 = this.ocz;
        localObject6 = new LinkedList();
        localObject5 = new y.a();
        ((y.a)localObject5).NiT = false;
        localObject4 = new y.a();
        ((y.a)localObject4).NiT = false;
        paramObject = new HashMap();
        localObject1 = new HashMap();
        i = 0;
        j = this.ork.FVa;
        if (i < j)
        {
          localObject7 = new efz();
          ((y.a)localObject5).NiT = false;
          ((y.a)localObject4).NiT = false;
          ((efz)localObject7).url = ((avu)this.orl.GNa.get(i)).GMU;
          ((efz)localObject7).osm = ((avw)this.ork.GNn.get(i)).GNc;
          localObject9 = ((efz)localObject7).url;
          p.g(localObject9, "url");
          localObject18 = b.XZ((String)localObject9);
          localObject10 = this.orl.GNa.get(i);
          localObject9 = localObject10;
          if (!(localObject10 instanceof f)) {
            localObject9 = null;
          }
          localObject9 = (f)localObject9;
          if (localObject9 != null)
          {
            ((efz)localObject7).nLC = ((f)localObject9).nLC;
            localObject9 = z.Nhr;
          }
          localObject9 = ((efz)localObject7).osm;
          p.g(localObject9, "fullUrl");
          if (!n.nF((String)localObject9, "http")) {
            break label3146;
          }
          localObject14 = (Map)new LinkedHashMap();
          boolean bool2;
          if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qAM, 1) == 1)
          {
            bool2 = true;
            localObject9 = com.tencent.mm.plugin.webview.core.f.DZr;
            if (!f.a.eRk()) {
              break label586;
            }
            bool1 = true;
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WebPrefetcher", "[TRACE_PREFETCH] useA8keyLiteHeader: " + bool2 + " mockUseA8keyLiteHeader: " + bool1);
            if (((!bool2) && (!bool1)) || (bu.ht((List)((avw)this.ork.GNn.get(i)).GNl))) {
              break label689;
            }
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WebPrefetcher", "[TRACE_PREFETCH] response header size : " + ((avw)this.ork.GNn.get(i)).GNl.size());
            localObject9 = ((avw)this.ork.GNn.get(i)).GNl;
            p.g(localObject9, "RespInfo[i].HttpHeader");
            localObject10 = (Iterable)localObject9;
            localObject9 = (Collection)new ArrayList();
            localObject10 = ((Iterable)localObject10).iterator();
            if (!((Iterator)localObject10).hasNext()) {
              break label607;
            }
            localObject11 = ((Iterator)localObject10).next();
            localObject12 = (bpk)localObject11;
            if ((((bpk)localObject12).uuW != null) && (((bpk)localObject12).yxn != null)) {
              break label601;
            }
          }
          for (k = 1;; k = 0)
          {
            if (k != 0) {
              break label517;
            }
            ((Collection)localObject9).add(localObject11);
            break label517;
            bool2 = false;
            break;
            bool1 = com.tencent.mm.plugin.webview.core.g.bGK().getBoolean("webview_use_a8key_lite_header", false);
            break label353;
          }
          localObject9 = ((Iterable)localObject9).iterator();
          while (((Iterator)localObject9).hasNext())
          {
            localObject11 = (bpk)((Iterator)localObject9).next();
            localObject10 = ((bpk)localObject11).uuW;
            p.g(localObject10, "it.Key");
            localObject11 = ((bpk)localObject11).yxn;
            p.g(localObject11, "it.Value");
            ((Map)localObject14).put(localObject10, localObject11);
          }
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WebPrefetcher", "[TRACE_PREFETCH] useA8keyLiteHeader size : " + ((Map)localObject14).size());
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WebPrefetcher", "savePrefetch domains size : " + this.orm.size());
          ((efz)localObject7).iwX = System.currentTimeMillis();
          localObject9 = (Integer)this.ork.GNm.get(i);
          if (localObject9 == null)
          {
            ((efz)localObject7).IjE = true;
            if (!((efz)localObject7).IjE)
            {
              ((LinkedList)localObject6).add(((efz)localObject7).osm);
              ((y.a)localObject4).NiT = true;
            }
            localObject9 = (Collection)this.orm;
            if ((localObject9 != null) && (!((Collection)localObject9).isEmpty())) {
              break label1205;
            }
            k = 1;
            if (k == 0) {
              com.tencent.mm.plugin.report.service.g.yxI.f(21075, new Object[] { Integer.valueOf(((efz)localObject7).nLC), ((efz)localObject7).url, ((efz)localObject7).osm, Integer.valueOf(1) });
            }
            localObject9 = t.oqh;
            localObject9 = ((efz)localObject7).osm;
            p.g(localObject9, "fullUrl");
            localObject12 = t.m((String)localObject9, this.orm);
            if (localObject12 == null) {
              break label2577;
            }
            com.tencent.mm.plugin.report.service.g.yxI.f(21075, new Object[] { Integer.valueOf(((efz)localObject7).nLC), ((efz)localObject7).url, ((efz)localObject7).osm, Integer.valueOf(2) });
            localObject10 = this.orl.GNa.get(i);
            localObject9 = localObject10;
            if (!(localObject10 instanceof f)) {
              localObject9 = null;
            }
            localObject9 = (f)localObject9;
            if (localObject9 == null) {
              break label1211;
            }
          }
          for (localObject9 = ((f)localObject9).extInfo;; localObject9 = null)
          {
            ((j)localObject12).extInfo = ((String)localObject9);
            ((j)localObject12).nLC = ((efz)localObject7).nLC;
            com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.WebPrefetcher", "match prefetch#".concat(String.valueOf(localObject18)));
            localObject10 = t.oqh;
            this.ocA = localObject2;
            this.oqW = localObject6;
            this.oqX = localObject5;
            this.oqY = localObject4;
            this.oqZ = paramObject;
            this.ora = localObject1;
            this.orh = i;
            this.ori = j;
            this.orb = localObject7;
            this.orc = localObject7;
            this.ord = localObject18;
            this.ore = localObject14;
            this.orj = bool1;
            this.orf = localObject12;
            this.org = localObject9;
            this.label = 1;
            localObject15 = t.a((j)localObject12, this);
            if (localObject15 != locala) {
              break label3097;
            }
            AppMethodBeat.o(208898);
            return locala;
            if (((Integer)localObject9).intValue() != 0) {
              break;
            }
            if (((avw)this.ork.GNn.get(i)).GNh == 0) {
              break label782;
            }
            ((efz)localObject7).IjF = true;
            break label782;
            k = 0;
            break label834;
          }
        }
        break;
      case 1: 
        localObject13 = (String)this.org;
        localObject12 = (j)this.orf;
        bool1 = this.orj;
        localObject14 = (Map)this.ore;
        localObject7 = (String)this.ord;
        localObject6 = (efz)this.orc;
        localObject11 = (efz)this.orb;
        j = this.ori;
        i = this.orh;
        localObject9 = (HashMap)this.ora;
        localObject5 = (HashMap)this.oqZ;
        localObject4 = (y.a)this.oqY;
        localObject10 = (y.a)this.oqX;
        localObject1 = (LinkedList)this.oqW;
        localObject15 = (ah)this.ocA;
        localObject2 = paramObject;
        paramObject = localObject15;
        localObject15 = localObject2;
        if (((Boolean)localObject15).booleanValue())
        {
          localObject2 = x.orv;
          localObject15 = ((efz)localObject6).osm;
          p.g(localObject15, "fullUrl");
          this.ocA = paramObject;
          this.oqW = localObject1;
          this.oqX = localObject10;
          this.oqY = localObject4;
          this.oqZ = localObject5;
          this.ora = localObject9;
          this.orh = i;
          this.ori = j;
          this.orb = localObject11;
          this.orc = localObject6;
          this.ord = localObject7;
          this.ore = localObject14;
          this.orj = bool1;
          this.orf = localObject12;
          this.org = localObject13;
          this.label = 2;
          localObject21 = ((x)localObject2).a((String)localObject15, (j)localObject12, this);
          if (localObject21 != locala) {
            break label3074;
          }
          AppMethodBeat.o(208898);
          return locala;
        }
        break;
      case 2: 
        localObject19 = (String)this.org;
        localObject10 = (j)this.orf;
        bool1 = this.orj;
        localObject18 = (Map)this.ore;
        localObject7 = (String)this.ord;
        localObject6 = (efz)this.orc;
        localObject20 = (efz)this.orb;
        j = this.ori;
        i = this.orh;
        localObject11 = (HashMap)this.ora;
        localObject5 = (HashMap)this.oqZ;
        localObject4 = (y.a)this.oqY;
        localObject2 = (y.a)this.oqX;
        localObject1 = (LinkedList)this.oqW;
        localObject12 = (ah)this.ocA;
        localObject9 = paramObject;
        paramObject = localObject12;
        localObject21 = localObject9;
        localObject9 = localObject11;
        localObject17 = localObject9;
        localObject22 = localObject7;
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
          ((efz)localObject6).oqj = ((efz)localObject6).osm;
          localObject11 = h.oph;
          if (i.bGK().getBoolean("tencent_view_inews_prefix", false))
          {
            localObject11 = ((efz)localObject6).oqj;
            p.g(localObject11, "prefetchUrl");
            ((efz)localObject6).oqj = n.bq((String)localObject11, "//view.inews.qq.com", "//ssr.view.inews.qq.com");
          }
          ((efz)localObject6).IjG = true;
          localObject11 = t.oqh;
          t.a((efz)localObject6);
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WebPrefetcher", "prefetch call, header size: " + ((Map)localObject18).size() + ", url: " + ((efz)localObject6).oqj);
          com.tencent.mm.plugin.report.service.g.yxI.f(21075, new Object[] { Integer.valueOf(((efz)localObject6).nLC), ((efz)localObject6).url, ((efz)localObject6).osm, Integer.valueOf(3) });
          localObject11 = t.oqh;
          localObject11 = ((efz)localObject6).url;
          p.g(localObject11, "url");
          localObject12 = ((efz)localObject6).oqj;
          p.g(localObject12, "prefetchUrl");
          t.b((String)localObject11, (String)localObject12, (Map)localObject18, ((efz)localObject6).nLC);
          ((y.a)localObject2).NiT = true;
          localObject11 = x.orv;
          this.ocA = paramObject;
          this.oqW = localObject1;
          this.oqX = localObject2;
          this.oqY = localObject4;
          this.oqZ = localObject5;
          this.ora = localObject9;
          this.orh = i;
          this.ori = j;
          this.orb = localObject20;
          this.orc = localObject6;
          this.ord = localObject7;
          this.ore = localObject18;
          this.orj = bool1;
          this.orf = localObject10;
          this.org = localObject19;
          this.label = 3;
          localObject12 = ((x)localObject11).b((j)localObject10, this);
          if (localObject12 != locala) {
            break label3055;
          }
          AppMethodBeat.o(208898);
          return locala;
        }
        break;
      case 3: 
        localObject9 = (j)this.orf;
        localObject10 = (String)this.ord;
        localObject6 = (efz)this.orc;
        j = this.ori;
        i = this.orh;
        localObject13 = (HashMap)this.ora;
        localObject7 = (HashMap)this.oqZ;
        localObject4 = (y.a)this.oqY;
        localObject5 = (y.a)this.oqX;
        localObject1 = (LinkedList)this.oqW;
        localObject11 = (ah)this.ocA;
        localObject2 = paramObject;
        paramObject = localObject11;
        localObject11 = localObject9;
        localObject12 = localObject2;
        localObject9 = localObject13;
        label2135:
        localObject12 = (Iterable)localObject12;
        localObject2 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject12, 10));
        localObject12 = ((Iterable)localObject12).iterator();
        while (((Iterator)localObject12).hasNext()) {
          ((Collection)localObject2).add(new t.c((String)((Iterator)localObject12).next(), t.e.oqv, ((efz)localObject6).nLC));
        }
        localObject2 = (List)localObject2;
        localObject12 = t.oqh;
        localObject11 = ((j)localObject11).opi.GMJ;
        p.g(localObject11, "manifest.domain.Domain");
        t.g((List)localObject2, (String)localObject11);
        localObject2 = z.Nhr;
        com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.WebPrefetcher", "end prefetch #" + (String)localObject10 + ' ' + ((efz)localObject6).oqj);
        localObject2 = paramObject;
        localObject14 = localObject6;
        paramObject = localObject1;
        localObject6 = localObject7;
        localObject1 = localObject9;
      }
      for (;;)
      {
        try
        {
          localObject7 = t.oqh;
          k = t.XH(((efz)localObject14).url);
          localObject7 = (Integer)((HashMap)localObject1).get(Integer.valueOf(k));
          if (localObject7 != null) {
            continue;
          }
          ((Map)localObject1).put(Integer.valueOf(k), Integer.valueOf(1));
          localObject7 = ((efz)localObject14).url;
          p.g(localObject7, "url");
          com.tencent.mm.plugin.webview.h.b.a(0, (String)localObject7, false, false, true, ((y.a)localObject4).NiT, ((y.a)localObject5).NiT, true);
          localObject7 = (Integer)((HashMap)localObject6).get(Integer.valueOf(k));
          if (localObject7 != null) {
            continue;
          }
          ((Map)localObject6).put(Integer.valueOf(k), Integer.valueOf(1));
        }
        catch (Exception localException2)
        {
          label2577:
          com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.WebPrefetcher", "Report Error");
          continue;
          ((Map)localObject6).put(Integer.valueOf(k), Integer.valueOf(localException2.intValue() + 1));
          continue;
        }
        localObject7 = z.Nhr;
        i += 1;
        localObject7 = localObject6;
        localObject6 = paramObject;
        paramObject = localObject7;
        break;
        localObject11 = paramObject;
        localObject15 = localObject1;
        localObject12 = localObject10;
        localObject13 = localObject4;
        localObject16 = localObject5;
        k = i;
        m = j;
        localObject14 = localObject6;
        localObject22 = localObject7;
        localObject17 = localObject9;
        paramObject = t.oqh;
        t.a((efz)localObject14);
        com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.WebPrefetcher", "fail to prefetch #" + localObject22 + ' ' + ((efz)localObject14).url);
        j = m;
        localObject1 = localObject17;
        localObject6 = localObject16;
        paramObject = localObject15;
        i = k;
        localObject4 = localObject13;
        localObject5 = localObject12;
        localObject2 = localObject11;
        continue;
        localObject9 = t.oqh;
        t.a((efz)localObject7);
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
            localObject2 = t.oqh;
            t.cu((List)localObject6);
            com.tencent.mm.plugin.webview.h.b.XG(this.ork.FVa);
            localObject4 = (Map)paramObject;
            localObject2 = (Collection)new ArrayList(((Map)localObject4).size());
            localObject4 = ((Map)localObject4).entrySet().iterator();
            while (((Iterator)localObject4).hasNext())
            {
              localObject5 = (Map.Entry)((Iterator)localObject4).next();
              i = ((Number)((Map.Entry)localObject5).getKey()).intValue();
              com.tencent.mm.plugin.webview.h.b.jb(((Number)((Map.Entry)localObject5).getValue()).intValue(), i);
              ((Collection)localObject2).add(z.Nhr);
              continue;
              i = 0;
            }
          }
          catch (Exception localException1)
          {
            for (;;)
            {
              com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.WebPrefetcher", "preDns ex " + localException1.getMessage());
            }
            localObject3 = (Map)localObject1;
            localObject1 = (Collection)new ArrayList(((Map)localObject3).size());
            localObject3 = ((Map)localObject3).entrySet().iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject4 = (Map.Entry)((Iterator)localObject3).next();
              i = ((Number)((Map.Entry)localObject4).getKey()).intValue();
              j = ((Number)((Map.Entry)localObject4).getValue()).intValue();
              com.tencent.mm.plugin.webview.h.b.jc(j, i);
              if (paramObject.get(Integer.valueOf(i)) != null)
              {
                localObject4 = paramObject.get(Integer.valueOf(i));
                if (localObject4 == null) {
                  p.gkB();
                }
                if (p.compare(((Number)localObject4).intValue(), j) > 0)
                {
                  localObject4 = paramObject.get(Integer.valueOf(i));
                  if (localObject4 == null) {
                    p.gkB();
                  }
                  com.tencent.mm.plugin.webview.h.b.jd(((Number)localObject4).intValue() - j, i);
                }
              }
              ((Collection)localObject1).add(z.Nhr);
            }
            paramObject = z.Nhr;
            AppMethodBeat.o(208898);
            return paramObject;
          }
        }
        label3055:
        localObject11 = localObject10;
        localObject10 = localException2;
        Object localObject8 = localObject5;
        localObject5 = localObject3;
        break label2135;
        label3074:
        Object localObject3 = localObject10;
        localObject18 = localObject14;
        localObject19 = localObject13;
        localObject10 = localObject12;
        localObject20 = localObject11;
        break label1638;
        label3097:
        localObject13 = localObject9;
        localObject11 = localObject8;
        localObject16 = localObject8;
        localObject17 = localObject6;
        localObject9 = localObject1;
        localObject10 = localObject5;
        localObject8 = localObject18;
        localObject6 = localObject11;
        localObject11 = localObject16;
        localObject5 = paramObject;
        localObject1 = localObject17;
        paramObject = localObject3;
        break label1351;
        label3146:
        localObject8 = paramObject;
        paramObject = localObject6;
        localObject6 = localObject8;
      }
    }
    
    public final Object p(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(208900);
      paramObject1 = ((o)a(paramObject1, (d)paramObject2)).cR(z.Nhr);
      AppMethodBeat.o(208900);
      return paramObject1;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "kotlin.jvm.PlatformType", "it", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyLiteReqInfo;", "invoke"})
  static final class p
    extends q
    implements d.g.a.b<avu, String>
  {
    public static final p orn;
    
    static
    {
      AppMethodBeat.i(208902);
      orn = new p();
      AppMethodBeat.o(208902);
    }
    
    p()
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class q
    extends q
    implements d.g.a.a<z>
  {
    q(avv paramavv)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/plugin/webview/util/WebPrefetchUserAgentInfo;", "invoke"})
  static final class r
    extends q
    implements d.g.a.a<e>
  {
    public static final r orq;
    
    static
    {
      AppMethodBeat.i(208906);
      orq = new r();
      AppMethodBeat.o(208906);
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