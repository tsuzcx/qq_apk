package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import android.net.Uri;
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
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.arg;
import com.tencent.mm.protocal.protobuf.arh;
import com.tencent.mm.protocal.protobuf.ari;
import com.tencent.mm.protocal.protobuf.arj;
import com.tencent.mm.protocal.protobuf.ark;
import com.tencent.mm.protocal.protobuf.arl;
import com.tencent.mm.protocal.protobuf.bki;
import com.tencent.mm.protocal.protobuf.dyg;
import com.tencent.mm.protocal.protobuf.dyh;
import com.tencent.mm.protocal.protobuf.dyi;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.xweb.WebResourceResponse;
import d.a.ae;
import d.d.d;
import d.g.a.m;
import d.g.b.u;
import d.g.b.v.a;
import d.n.n;
import d.y;
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
import kotlinx.coroutines.ag;
import kotlinx.coroutines.ah;
import kotlinx.coroutines.as;
import kotlinx.coroutines.ay;
import kotlinx.coroutines.bh;
import kotlinx.coroutines.bo;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher;", "", "()V", "MIN_EXPIRE_SECONDS", "", "PRE_AUTH_EXPIRE_SECONDS", "REFRESH_BEFORE_EXPIRE_SECONDS", "value", "currentScene", "getCurrentScene", "()I", "setCurrentScene", "(I)V", "manifestContent", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcherFile;", "getManifestContent$plugin_brandservice_release", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcherFile;", "preauthRequestLimiter", "Lcom/tencent/mm/sdk/platformtools/MMCacheSlotManager;", "getPreauthRequestLimiter$plugin_brandservice_release", "()Lcom/tencent/mm/sdk/platformtools/MMCacheSlotManager;", "resContent", "getResContent$plugin_brandservice_release", "resHeadersManager", "Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "getResHeadersManager$plugin_brandservice_release", "()Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "sendingGetA8keyLiteQueue", "Ljava/util/concurrent/ConcurrentSkipListSet;", "", "settingManager", "getSettingManager$plugin_brandservice_release", "webContent", "getWebContent$plugin_brandservice_release", "webHeadersManager", "getWebHeadersManager$plugin_brandservice_release", "webIdToSceneManager", "getWebIdToSceneManager$plugin_brandservice_release", "clearPrefetchContent", "", "url", "debugPreloadWebInfo", "", "(Ljava/lang/String;)[[Ljava/lang/String;", "fetchContent", "Lcom/tencent/mm/network/MMHttpUrlCronetConnection;", "host", "target", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchTarget;", "deep", "prefetchHeaders", "", "fetchManifest", "", "manifest", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PrefetchManifest;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PrefetchManifest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchRes", "batchRes", "", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchRes;", "getPreAuthUrl", "getPrefetchContentResp", "Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService$PrefetchResponse;", "getPrefetchResResp", "referer", "getReportScene", "getUrlScene", "getValidPreloadWebInfo", "Lcom/tencent/mm/protocal/protobuf/WebPrefetchInfo;", "isDnsCached", "isInPreAuthWhiteList", "isUrlPreAuthed", "isWebUrlEqual", "rawUrl", "targetUrl", "isWebUrlStorageEqual", "matchManifest", "domains", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyLitePrefetchDomainInfo;", "needReauth", "preAuth", "appId", "title", "desc", "from", "scene", "preAuths", "auths", "Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService$PreAuthInfo;", "preDns", "urls", "prefetch", "prefetchUrl", "checkCacheOnly", "headers", "sendGetA8KeyLiteRequest", "preauths", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$BatchPreauth;", "setUrlToScene", "connect", "receiveHeader", "Lkotlin/Function1;", "targetFile", "Lcom/tencent/mm/vfs/VFSFile;", "onCompleted", "mockManifest", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyLiteResponse;", "prepare", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyLiteRequest;", "save", "saveDomainInfos", "saveManifest", "localPrefetchDomainInfos", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protobuf/ByteString;", "savePrefetch", "request", "BatchPreauth", "PrefetchAction", "PrefetchRes", "PrefetchTarget", "PrefetchType", "plugin-brandservice_release"})
public final class t
{
  private static final ak nHA;
  private static final aq nHB;
  public static final t nHC;
  private static final aq nHt;
  private static final aq nHu;
  private static final aq nHv;
  private static final v nHw;
  private static final v nHx;
  private static final v nHy;
  private static final ConcurrentSkipListSet<String> nHz;
  
  static
  {
    AppMethodBeat.i(6809);
    nHC = new t();
    nHt = new aq(s.bLh(), 604800L);
    nHu = new aq(s.bLh(), 86400L);
    nHv = new aq(s.bLh(), 604800L);
    nHw = new v("wcf://WebPrefetchContent/");
    nHx = new v("wcf://WebPrefetchResource/");
    nHy = new v("wcf://WebPrefetchManifest/");
    nHz = new ConcurrentSkipListSet();
    nHA = new ak();
    nHB = new aq(s.bLh(), 86400L);
    AppMethodBeat.o(6809);
  }
  
  private static dyi TU(String paramString)
  {
    AppMethodBeat.i(198982);
    String str = b.TF(paramString);
    Object localObject1 = k.nGP;
    localObject1 = (aw)k.bKW().aKv(str);
    int i;
    if (localObject1 != null) {
      if (((aw)localObject1).containsKey(str))
      {
        localObject1 = ((aw)localObject1).decodeBytes(str);
        if (localObject1 != null) {
          if (localObject1.length == 0)
          {
            i = 1;
            if (i != 0) {
              break label247;
            }
            i = 1;
            label65:
            if (i == 0) {
              break label270;
            }
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        Object localObject3 = dyi.class.newInstance();
        ((com.tencent.mm.bw.a)localObject3).parseFrom((byte[])localObject1);
        localObject1 = (com.tencent.mm.bw.a)localObject3;
        localObject1 = (dyi)localObject1;
        if (localObject1 == null) {
          break label280;
        }
        boolean bool = ar.ag(((dyi)localObject1).iaH, 600);
        ac.v("MicroMsg.WebPrefetcher", "[TRACE_PREFETCH] getValidPreloadWebInfo: webId#" + str + ", prefetch:" + ((dyi)localObject1).Get + ", authorized:" + ((dyi)localObject1).Ges + ", antispam:" + ((dyi)localObject1).Ger + ", lastModify:" + ((dyi)localObject1).iaH + ", expire:" + bool + ", url:" + paramString);
        if (((!((dyi)localObject1).Get) && (((dyi)localObject1).Ges)) || (((dyi)localObject1).Ger) || (bool)) {
          break label280;
        }
        AppMethodBeat.o(198982);
        return localObject1;
      }
      catch (Exception localException)
      {
        label247:
        ac.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", (Throwable)localException, "decode ProtoBuffer", new Object[0]);
      }
      i = 0;
      break;
      i = 0;
      break label65;
      label270:
      Object localObject2 = null;
      continue;
      localObject2 = null;
    }
    label280:
    ac.v("MicroMsg.WebPrefetcher", "[TRACE_PREFETCH] getVaildPreloadWebInfo: webId#" + str + ", not cached, url:" + paramString);
    AppMethodBeat.o(198982);
    return null;
  }
  
  private static boolean TV(String paramString)
  {
    AppMethodBeat.i(6806);
    String str = b.TF(paramString);
    Object localObject1 = k.nGP;
    localObject1 = (aw)k.bKW().aKv(str);
    int i;
    if (localObject1 != null) {
      if (((aw)localObject1).containsKey(str))
      {
        localObject1 = ((aw)localObject1).decodeBytes(str);
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
        Object localObject3 = dyi.class.newInstance();
        ((com.tencent.mm.bw.a)localObject3).parseFrom((byte[])localObject1);
        localObject1 = (com.tencent.mm.bw.a)localObject3;
        localObject1 = (dyi)localObject1;
        if (localObject1 == null) {
          break label247;
        }
        bool2 = ar.ag(((dyi)localObject1).iaH, 540);
        bool1 = bool2;
        bool3 = true;
        ac.v("MicroMsg.WebPrefetcher", "[TRACE_PREFETCH] needReauth:" + bool1 + ", webId:" + str + ", cached:" + bool3 + ", expired:" + bool2 + ", url:" + paramString);
        AppMethodBeat.o(6806);
        return bool1;
      }
      catch (Exception localException)
      {
        label210:
        ac.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", (Throwable)localException, "decode ProtoBuffer", new Object[0]);
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
  
  private static boolean TW(String paramString)
  {
    AppMethodBeat.i(198984);
    Object localObject1 = Uri.parse(UrlExKt.getWithProtocol(paramString));
    if (localObject1 != null)
    {
      localObject1 = ((Uri)localObject1).getHost();
      if (localObject1 != null)
      {
        localObject1 = b.TH((String)localObject1);
        Object localObject3 = (aw)nHt.aKv((String)localObject1);
        int i;
        if (localObject3 != null) {
          if (((aw)localObject3).containsKey((String)localObject1))
          {
            localObject1 = ((aw)localObject3).decodeBytes((String)localObject1);
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
            localObject3 = arf.class.newInstance();
            ((com.tencent.mm.bw.a)localObject3).parseFrom((byte[])localObject1);
            localObject1 = (com.tencent.mm.bw.a)localObject3;
            localObject1 = (arf)localObject1;
            if (localObject1 == null) {
              break label214;
            }
            if ((((arf)localObject1).EKk != 1) || (ar.ag(((arf)localObject1).EKm, ((arf)localObject1).EKl))) {
              break label209;
            }
            bool = true;
            if (bool) {
              ac.v("MicroMsg.WebPrefetcher", "[TRACE_PREFETCH] preauth cancelled, in whiteList:".concat(String.valueOf(paramString)));
            }
            AppMethodBeat.o(198984);
            return bool;
          }
          catch (Exception localException)
          {
            label176:
            ac.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", (Throwable)localException, "decode ProtoBuffer", new Object[0]);
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
    AppMethodBeat.o(198984);
    return false;
  }
  
  private static int TX(String paramString)
  {
    AppMethodBeat.i(175488);
    aw localaw = (aw)nHB.aKv(b.TF(paramString));
    if (localaw != null)
    {
      int i = localaw.getInt(b.TF(paramString), 0);
      AppMethodBeat.o(175488);
      return i;
    }
    AppMethodBeat.o(175488);
    return 0;
  }
  
  public static boolean Tm(String paramString)
  {
    AppMethodBeat.i(198983);
    d.g.b.k.h(paramString, "url");
    if (TU(paramString) != null)
    {
      AppMethodBeat.o(198983);
      return true;
    }
    AppMethodBeat.o(198983);
    return false;
  }
  
  public static int To(String paramString)
  {
    AppMethodBeat.i(175492);
    int i;
    switch (bLp())
    {
    default: 
      i = bLp();
      AppMethodBeat.o(175492);
      return i;
    }
    if (paramString != null)
    {
      TX(paramString);
      i = TX(paramString);
      AppMethodBeat.o(175492);
      return i;
    }
    AppMethodBeat.o(175492);
    return 0;
  }
  
  public static d.b Tp(String paramString)
  {
    AppMethodBeat.i(198977);
    d.g.b.k.h(paramString, "url");
    paramString = new d(paramString, b.TF(paramString), nHw, nHu).bLz();
    if (paramString != null)
    {
      ac.i("MicroMsg.WebPrefetcher", "getPrefetchContentResp, prefetchType: " + paramString.nuL + ", prefetchVersion: " + paramString.nuK + ", url: " + paramString.url);
      AppMethodBeat.o(198977);
      return paramString;
    }
    AppMethodBeat.o(198977);
    return null;
  }
  
  public static void Tq(String paramString)
  {
    AppMethodBeat.i(6803);
    d.g.b.k.h(paramString, "url");
    Object localObject1 = b.TF(paramString);
    Object localObject2 = nHw.TY((String)localObject1);
    if (((com.tencent.mm.vfs.e)localObject2).exists()) {
      ((com.tencent.mm.vfs.e)localObject2).delete();
    }
    localObject2 = (aw)nHu.aKv((String)localObject1);
    if (localObject2 != null) {
      ((aw)localObject2).remove((String)localObject1);
    }
    localObject1 = k.nGP;
    localObject1 = (aw)k.bKW().aKv(b.TF(paramString));
    if (localObject1 != null)
    {
      ((aw)localObject1).removeValueForKey(b.TF(paramString));
      AppMethodBeat.o(6803);
      return;
    }
    AppMethodBeat.o(6803);
  }
  
  public static final void a(String arg0, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt)
  {
    AppMethodBeat.i(198979);
    d.g.b.k.h(???, "url");
    d.g.b.k.h(paramString2, "appId");
    d.g.b.k.h(paramString3, "title");
    d.g.b.k.h(paramString4, "desc");
    d.g.b.k.h(paramString5, "from");
    ac.v("MicroMsg.WebPrefetcher", "preAuth: " + paramString3 + ' ' + ???);
    paramString4 = new a(???, paramString2, paramString3, paramString4, paramInt, null, null, 96);
    paramString2 = nHC;
    paramString3 = a.class.getCanonicalName() + '_' + "addToPreload";
    synchronized (bx.GuY)
    {
      paramString5 = bx.GuY;
      paramString5 = (bo)bx.eWs().get(paramString3);
      if (paramString5 != null) {
        paramString5.ged();
      }
      paramString5 = bx.GuY;
      paramString5 = bx.eWt();
      if (!paramString5.containsKey(paramString3)) {
        ((Map)paramString5).put(paramString3, new LinkedList());
      }
      paramString5 = paramString5.get(paramString3);
      if (paramString5 == null)
      {
        paramString2 = new d.v("null cannot be cast to non-null type java.util.LinkedList<T>");
        AppMethodBeat.o(198979);
        throw paramString2;
      }
    }
    ((LinkedList)paramString5).add(paramString4);
    ??? = bx.GuY;
    ((Map)bx.eWs()).put(paramString3, kotlinx.coroutines.f.b((ag)bh.LRM, (d.d.f)ay.gdP(), (m)new k(1000L, paramString3, null, paramString2), 2));
    AppMethodBeat.o(198979);
  }
  
  private static void a(String arg0, String paramString2, Map<String, String> paramMap)
  {
    AppMethodBeat.i(198975);
    paramMap = new b(b.TE(???), ???, paramString2, paramMap);
    paramString2 = b.class.getCanonicalName() + '_' + "batch";
    Object localObject;
    synchronized (bx.GuY)
    {
      localObject = bx.GuY;
      localObject = (bo)bx.eWs().get(paramString2);
      if (localObject != null) {
        ((bo)localObject).ged();
      }
      localObject = bx.GuY;
      localObject = bx.eWt();
      if (!((HashMap)localObject).containsKey(paramString2)) {
        ((Map)localObject).put(paramString2, new LinkedList());
      }
      localObject = ((HashMap)localObject).get(paramString2);
      if (localObject == null)
      {
        paramString2 = new d.v("null cannot be cast to non-null type java.util.LinkedList<T>");
        AppMethodBeat.o(198975);
        throw paramString2;
      }
    }
    ((LinkedList)localObject).add(paramMap);
    ??? = bx.GuY;
    ((Map)bx.eWs()).put(paramString2, kotlinx.coroutines.f.b((ag)bh.LRM, (d.d.f)ay.gdP(), (m)new m(50L, paramString2, null), 2));
    AppMethodBeat.o(198975);
  }
  
  public static aq bLi()
  {
    return nHt;
  }
  
  public static aq bLj()
  {
    return nHu;
  }
  
  public static aq bLk()
  {
    return nHv;
  }
  
  public static v bLl()
  {
    return nHw;
  }
  
  public static v bLm()
  {
    return nHx;
  }
  
  public static v bLn()
  {
    return nHy;
  }
  
  public static ak bLo()
  {
    return nHA;
  }
  
  private static int bLp()
  {
    AppMethodBeat.i(175490);
    aw localaw = aw.aKT("WebPrefetcher.currentScene");
    if (localaw != null)
    {
      int i = localaw.decodeInt("currentScene");
      AppMethodBeat.o(175490);
      return i;
    }
    AppMethodBeat.o(175490);
    return 0;
  }
  
  public static final void cp(List<? extends d.a> paramList)
  {
    AppMethodBeat.i(160497);
    d.g.b.k.h(paramList, "auths");
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
      d.g.b.k.g(str2, "info.url");
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
      localCollection.add(new a(str2, paramList, (String)localObject1, (String)localObject2, locala.nuJ, null, locala.extInfo, 32));
    }
    cq((List)localCollection);
    AppMethodBeat.o(160497);
  }
  
  private static void cq(List<a> paramList)
  {
    AppMethodBeat.i(198981);
    ac.v("MicroMsg.WebPrefetcher", "[TRACE_PREFETCH] preAuths size = %s", new Object[] { Integer.valueOf(paramList.size()) });
    arj localarj = new arj();
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
      if ((!nHA.contains(b.TD(((a)localObject3).url))) && (!UrlExKt.isMpUrl(((a)localObject3).url)) && (!TW(((a)localObject3).url)) && (TV(((a)localObject3).url)) && (!nHz.contains(((a)localObject3).url))) {}
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
      ((f)localObject3).EKt = ((a)localObject2).url;
      ((f)localObject3).hOf = ((a)localObject2).appId;
      ((f)localObject3).EKu = ((a)localObject2).title;
      ((f)localObject3).EKv = ((a)localObject2).desc;
      ((f)localObject3).EKs = i;
      ((f)localObject3).EKw = ((a)localObject2).nHD;
      ((f)localObject3).Scene = ((a)localObject2).scene;
      nHA.Bk(b.TD(((a)localObject2).url));
      ((f)localObject3).extInfo = ((a)localObject2).extInfo;
      paramList.add(localObject3);
      i += 1;
    }
    paramList = (List)paramList;
    localarj.EKz.addAll((Collection)paramList);
    localarj.DXj = localarj.EKz.size();
    localarj.Scene = 0;
    localarj.DUB = 0;
    if (localarj.EKz.isEmpty())
    {
      ac.v("MicroMsg.WebPrefetcher", "[TRACE_PREFETCH] preAuths: nothing to preauth");
      AppMethodBeat.o(198981);
      return;
    }
    try
    {
      paramList = nHz;
      localObject1 = localarj.EKz;
      d.g.b.k.g(localObject1, "req.ReqInfo");
      localObject2 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        ((Collection)localObject1).add(((ari)((Iterator)localObject2).next()).EKt);
        continue;
        paramList = new StringBuilder("[TRACE_PREFETCH] sendGetA8KeyLiteRequest batch req: ");
      }
    }
    catch (Exception paramList)
    {
      ac.e("MicroMsg.WebPrefetcher", "Concurrent Add Exception: " + paramList.getMessage());
    }
    for (;;)
    {
      localObject1 = localarj.EKz;
      d.g.b.k.g(localObject1, "req.ReqInfo");
      ac.v("MicroMsg.WebPrefetcher", d.a.j.a((Iterable)localObject1, (CharSequence)",", null, null, 0, null, (d.g.a.b)p.nIS, 30));
      com.tencent.mm.ac.c.b("MicroMsg.WebPrefetcher", (d.g.a.a)new q(localarj));
      AppMethodBeat.o(198981);
      return;
      paramList.addAll((Collection)localObject1);
    }
  }
  
  public static boolean cx(String paramString, int paramInt)
  {
    AppMethodBeat.i(175489);
    d.g.b.k.h(paramString, "url");
    boolean bool = ((aw)nHB.eUr()).encode(b.TF(paramString), paramInt);
    AppMethodBeat.o(175489);
    return bool;
  }
  
  public static d.b eA(String paramString1, String paramString2)
  {
    AppMethodBeat.i(198978);
    d.g.b.k.h(paramString1, "referer");
    d.g.b.k.h(paramString2, "url");
    paramString1 = new d(paramString2, b.eB(b.TE(paramString1), paramString2), nHx, nHv).bLz();
    AppMethodBeat.o(198978);
    return paramString1;
  }
  
  public static boolean eF(String paramString1, String paramString2)
  {
    AppMethodBeat.i(198985);
    String str = new d(paramString1, b.TF(paramString1), nHw, nHu).getLocation();
    if (!n.aD((CharSequence)str)) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramString1 = b.aD(str, true);
      ac.v("MicroMsg.WebPrefetcher", "isWebUrlStorageEqual: location:#" + paramString1 + ", " + str);
      paramString2 = b.aD(paramString2, true);
      ac.v("MicroMsg.WebPrefetcher", "isWebUrlStorageEqual: target:#".concat(String.valueOf(paramString2)));
      boolean bool = d.g.b.k.g(paramString1, paramString2);
      AppMethodBeat.o(198985);
      return bool;
    }
    AppMethodBeat.o(198985);
    return false;
  }
  
  public static void yZ(int paramInt)
  {
    AppMethodBeat.i(175491);
    aw localaw = aw.aKT("WebPrefetcher.currentScene");
    if (localaw != null)
    {
      localaw.encode("currentScene", paramInt);
      AppMethodBeat.o(175491);
      return;
    }
    AppMethodBeat.o(175491);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$BatchPreauth;", "", "url", "", "appId", "title", "desc", "scene", "", "refer", "extInfo", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getDesc", "getExtInfo", "getRefer", "getScene", "()I", "getTitle", "getUrl", "plugin-brandservice_release"})
  static final class a
  {
    final String appId;
    final String desc;
    final String extInfo;
    final String nHD;
    final int scene;
    final String title;
    final String url;
    
    private a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5, String paramString6)
    {
      AppMethodBeat.i(198902);
      this.url = paramString1;
      this.appId = paramString2;
      this.title = paramString3;
      this.desc = paramString4;
      this.scene = paramInt;
      this.nHD = paramString5;
      this.extInfo = paramString6;
      AppMethodBeat.o(198902);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchAction;", "", "host", "", "rawUrl", "prefetchUrl", "checkCacheOnly", "", "prefetchHeader", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/util/Map;)V", "getCheckCacheOnly", "()Z", "getHost", "()Ljava/lang/String;", "getPrefetchHeader", "()Ljava/util/Map;", "getPrefetchUrl", "getRawUrl", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "plugin-brandservice_release"})
  static final class b
  {
    final String dxX;
    final String host;
    final String nHE;
    final boolean nHF;
    final Map<String, String> nHG;
    
    public b(String paramString1, String paramString2, String paramString3, Map<String, String> paramMap)
    {
      AppMethodBeat.i(198904);
      this.host = paramString1;
      this.dxX = paramString2;
      this.nHE = paramString3;
      this.nHF = false;
      this.nHG = paramMap;
      AppMethodBeat.o(198904);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(198907);
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if ((!d.g.b.k.g(this.host, paramObject.host)) || (!d.g.b.k.g(this.dxX, paramObject.dxX)) || (!d.g.b.k.g(this.nHE, paramObject.nHE)) || (this.nHF != paramObject.nHF) || (!d.g.b.k.g(this.nHG, paramObject.nHG))) {}
        }
      }
      else
      {
        AppMethodBeat.o(198907);
        return true;
      }
      AppMethodBeat.o(198907);
      return false;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(198905);
      String str = "PrefetchAction(host=" + this.host + ", rawUrl=" + this.dxX + ", prefetchUrl=" + this.nHE + ", checkCacheOnly=" + this.nHF + ", prefetchHeader=" + this.nHG + ")";
      AppMethodBeat.o(198905);
      return str;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchRes;", "", "url", "", "type", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchType;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchType;)V", "getType", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchType;", "getUrl", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-brandservice_release"})
  static final class c
  {
    final t.e nHH;
    final String url;
    
    public c(String paramString, t.e parame)
    {
      AppMethodBeat.i(198908);
      this.url = paramString;
      this.nHH = parame;
      AppMethodBeat.o(198908);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(198911);
      if (this != paramObject)
      {
        if ((paramObject instanceof c))
        {
          paramObject = (c)paramObject;
          if ((!d.g.b.k.g(this.url, paramObject.url)) || (!d.g.b.k.g(this.nHH, paramObject.nHH))) {}
        }
      }
      else
      {
        AppMethodBeat.o(198911);
        return true;
      }
      AppMethodBeat.o(198911);
      return false;
    }
    
    public final int hashCode()
    {
      int j = 0;
      AppMethodBeat.i(198910);
      Object localObject = this.url;
      if (localObject != null) {}
      for (int i = localObject.hashCode();; i = 0)
      {
        localObject = this.nHH;
        if (localObject != null) {
          j = localObject.hashCode();
        }
        AppMethodBeat.o(198910);
        return i * 31 + j;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(198909);
      String str = "PrefetchRes(url=" + this.url + ", type=" + this.nHH + ")";
      AppMethodBeat.o(198909);
      return str;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchTarget;", "", "url", "", "webId", "content", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcherFile;", "headerSlot", "Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcherFile;Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;)V", "bizId", "getBizId", "()Ljava/lang/String;", "bizId$delegate", "Lkotlin/Lazy;", "cacheTime", "", "getCacheTime", "()J", "cacheTime$delegate", "getContent", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcherFile;", "eTag", "getETag", "eTag$delegate", "fullUrl", "getFullUrl", "fullUrl$delegate", "getHeaderSlot", "()Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "headers", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getHeaders", "()Ljava/util/HashMap;", "headers$delegate", "isCached", "", "()Z", "isCached$delegate", "isRedirect", "isRedirect$delegate", "location", "getLocation", "location$delegate", "maxCache", "", "getMaxCache", "()I", "maxCache$delegate", "mimeType", "getMimeType", "mimeType$delegate", "prefetchHost", "getPrefetchHost", "prefetchHost$delegate", "prefetchUrl", "getPrefetchUrl", "prefetchUrl$delegate", "response", "Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService$PrefetchResponse;", "getResponse", "()Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService$PrefetchResponse;", "type", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchType;", "getType", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchType;", "type$delegate", "getUrl", "version", "getVersion", "version$delegate", "getWebId", "wxETag", "getWxETag", "wxETag$delegate", "createResponse", "refresh", "", "saveHeaders", "host", "plugin-brandservice_release"})
  static final class d
  {
    private final d.f nHI;
    private final d.f nHJ;
    private final d.f nHK;
    private final d.f nHL;
    private final d.f nHM;
    private final d.f nHN;
    private final d.f nHO;
    private final d.f nHP;
    private final d.f nHQ;
    private final d.f nHR;
    private final d.f nHS;
    private final d.f nHT;
    private final d.f nHU;
    private final d.f nHV;
    private final d.f nHW;
    final String nHX;
    final v nHY;
    final aq nHZ;
    final String url;
    
    static
    {
      AppMethodBeat.i(198931);
      $$delegatedProperties = new d.l.k[] { (d.l.k)d.g.b.w.a(new u(d.g.b.w.bn(d.class), "bizId", "getBizId()Ljava/lang/String;")), (d.l.k)d.g.b.w.a(new u(d.g.b.w.bn(d.class), "fullUrl", "getFullUrl()Ljava/lang/String;")), (d.l.k)d.g.b.w.a(new u(d.g.b.w.bn(d.class), "headers", "getHeaders()Ljava/util/HashMap;")), (d.l.k)d.g.b.w.a(new u(d.g.b.w.bn(d.class), "type", "getType()Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchType;")), (d.l.k)d.g.b.w.a(new u(d.g.b.w.bn(d.class), "location", "getLocation()Ljava/lang/String;")), (d.l.k)d.g.b.w.a(new u(d.g.b.w.bn(d.class), "version", "getVersion()J")), (d.l.k)d.g.b.w.a(new u(d.g.b.w.bn(d.class), "mimeType", "getMimeType()Ljava/lang/String;")), (d.l.k)d.g.b.w.a(new u(d.g.b.w.bn(d.class), "maxCache", "getMaxCache()I")), (d.l.k)d.g.b.w.a(new u(d.g.b.w.bn(d.class), "cacheTime", "getCacheTime()J")), (d.l.k)d.g.b.w.a(new u(d.g.b.w.bn(d.class), "wxETag", "getWxETag()Ljava/lang/String;")), (d.l.k)d.g.b.w.a(new u(d.g.b.w.bn(d.class), "eTag", "getETag()Ljava/lang/String;")), (d.l.k)d.g.b.w.a(new u(d.g.b.w.bn(d.class), "prefetchUrl", "getPrefetchUrl()Ljava/lang/String;")), (d.l.k)d.g.b.w.a(new u(d.g.b.w.bn(d.class), "prefetchHost", "getPrefetchHost()Ljava/lang/String;")), (d.l.k)d.g.b.w.a(new u(d.g.b.w.bn(d.class), "isRedirect", "isRedirect()Z")), (d.l.k)d.g.b.w.a(new u(d.g.b.w.bn(d.class), "isCached", "isCached()Z")) };
      AppMethodBeat.o(198931);
    }
    
    public d(String paramString1, String paramString2, v paramv, aq paramaq)
    {
      AppMethodBeat.i(198946);
      this.url = paramString1;
      this.nHX = paramString2;
      this.nHY = paramv;
      this.nHZ = paramaq;
      this.nHI = d.g.K((d.g.a.a)new a(this));
      this.nHJ = d.g.K((d.g.a.a)new d(this));
      this.nHK = d.g.K((d.g.a.a)new e(this));
      this.nHL = d.g.K((d.g.a.a)new m(this));
      this.nHM = d.g.K((d.g.a.a)new h(this));
      this.nHN = d.g.K((d.g.a.a)new n(this));
      this.nHO = d.g.K((d.g.a.a)new j(this));
      this.nHP = d.g.K((d.g.a.a)new i(this));
      this.nHQ = d.g.K((d.g.a.a)new b(this));
      this.nHR = d.g.K((d.g.a.a)new o(this));
      this.nHS = d.g.K((d.g.a.a)new c(this));
      this.nHT = d.g.K((d.g.a.a)new l(this));
      this.nHU = d.g.K((d.g.a.a)new k(this));
      this.nHV = d.g.K((d.g.a.a)new g(this));
      this.nHW = d.g.K((d.g.a.a)new f(this));
      AppMethodBeat.o(198946);
    }
    
    private final d.b bLA()
    {
      AppMethodBeat.i(198944);
      int i = bLs().size();
      boolean bool = this.nHY.contains(bLr());
      if ((i == 0) || (!bool))
      {
        ac.e("MicroMsg.WebPrefetcher", "createResponse fail headerSize:" + i + ", containsFile:" + bool);
        AppMethodBeat.o(198944);
        return null;
      }
      d.b localb = new d.b();
      localb.url = ((String)this.nHJ.getValue());
      localb.nuL = bLt().toString();
      localb.nuK = ((Number)this.nHN.getValue()).longValue();
      String str = (String)this.nHO.getValue();
      Object localObject1 = (Map)bLs();
      Map localMap = (Map)new LinkedHashMap(ae.agH(((Map)localObject1).size()));
      localObject1 = ((Iterable)((Map)localObject1).entrySet()).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject3 = ((Iterator)localObject1).next();
        Object localObject2 = ((Map.Entry)localObject3).getKey();
        localObject3 = (Map.Entry)localObject3;
        ((Map.Entry)localObject3).getKey();
        localMap.put(localObject2, (String)d.a.j.iO((List)((Map.Entry)localObject3).getValue()));
      }
      localb.nuM = new WebResourceResponse(str, "UTF-8", 200, "OK", localMap, com.tencent.mm.vfs.i.ag(this.nHY.TY(bLr())));
      AppMethodBeat.o(198944);
      return localb;
    }
    
    private t.e bLt()
    {
      AppMethodBeat.i(198934);
      t.e locale = (t.e)this.nHL.getValue();
      AppMethodBeat.o(198934);
      return locale;
    }
    
    private boolean isRedirect()
    {
      AppMethodBeat.i(198940);
      boolean bool = ((Boolean)this.nHV.getValue()).booleanValue();
      AppMethodBeat.o(198940);
      return bool;
    }
    
    private void refresh()
    {
      AppMethodBeat.i(198942);
      if ((bLt() == t.e.nId) && (bLv() > 0L) && (bLu() > 0) && (ar.ag(bLv(), Math.max(bLu() - 60, 60))))
      {
        t localt = t.nHC;
        com.tencent.mm.plugin.webview.h.b.Vn(t.To(this.url));
        localt = t.nHC;
        t.eE(this.url, (String)this.nHT.getValue());
      }
      AppMethodBeat.o(198942);
    }
    
    public final void a(t.e parame, String paramString)
    {
      AppMethodBeat.i(198945);
      d.g.b.k.h(parame, "type");
      d.g.b.k.h(paramString, "host");
      ((Map)bLs()).put("x-wx-client-cache-time", d.a.j.listOf(String.valueOf(System.currentTimeMillis())));
      ((Map)bLs()).put("x-wx-client-prefetch-url", d.a.j.listOf(this.url));
      if (!n.aD((CharSequence)paramString)) {}
      LinkedList localLinkedList;
      Collection localCollection;
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          ((Map)bLs()).put("x-wx-client-prefetch-host", d.a.j.listOf(paramString));
        }
        ((Map)bLs()).put("x-wx-client-prefetch-type", d.a.j.listOf(parame.toString()));
        paramString = new dyh();
        localLinkedList = paramString.Geq;
        Object localObject1 = (Map)bLs();
        localCollection = (Collection)new ArrayList(((Map)localObject1).size());
        localObject1 = ((Map)localObject1).entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
          String str = (String)((Map.Entry)localObject2).getKey();
          localObject2 = (List)((Map.Entry)localObject2).getValue();
          dyg localdyg = new dyg();
          localdyg.key = str;
          localdyg.EHU.addAll((Collection)localObject2);
          localCollection.add(localdyg);
        }
      }
      localLinkedList.addAll((Collection)localCollection);
      ((aw)this.nHZ.eUr()).encode(bLr(), paramString.toByteArray());
      ac.v("MicroMsg.WebPrefetcher", "saveHeaders " + parame + " : webId:" + this.nHX + ", bizId:" + bLr() + ", header size:" + bLs().size());
      AppMethodBeat.o(198945);
    }
    
    public final String bLr()
    {
      AppMethodBeat.i(198932);
      String str = (String)this.nHI.getValue();
      AppMethodBeat.o(198932);
      return str;
    }
    
    public final HashMap<String, List<String>> bLs()
    {
      AppMethodBeat.i(198933);
      HashMap localHashMap = (HashMap)this.nHK.getValue();
      AppMethodBeat.o(198933);
      return localHashMap;
    }
    
    public final int bLu()
    {
      AppMethodBeat.i(198936);
      int i = ((Number)this.nHP.getValue()).intValue();
      AppMethodBeat.o(198936);
      return i;
    }
    
    public final long bLv()
    {
      AppMethodBeat.i(198937);
      long l = ((Number)this.nHQ.getValue()).longValue();
      AppMethodBeat.o(198937);
      return l;
    }
    
    public final String bLw()
    {
      AppMethodBeat.i(198938);
      String str = (String)this.nHR.getValue();
      AppMethodBeat.o(198938);
      return str;
    }
    
    public final String bLx()
    {
      AppMethodBeat.i(198939);
      String str = (String)this.nHS.getValue();
      AppMethodBeat.o(198939);
      return str;
    }
    
    public final boolean bLy()
    {
      AppMethodBeat.i(198941);
      boolean bool = ((Boolean)this.nHW.getValue()).booleanValue();
      AppMethodBeat.o(198941);
      return bool;
    }
    
    public final d.b bLz()
    {
      AppMethodBeat.i(198943);
      Object localObject1 = this;
      while (((d)localObject1).bLy())
      {
        ac.i("MicroMsg.WebPrefetcher", "fetch cached: #" + ((d)localObject1).nHX + ", " + ((d)localObject1).url);
        Object localObject2 = ((d)localObject1).bLt();
        switch (u.cfA[localObject2.ordinal()])
        {
        default: 
          localObject1 = ((d)localObject1).bLA();
          AppMethodBeat.o(198943);
          return localObject1;
        }
        Object localObject3;
        Object localObject4;
        if (((d)localObject1).isRedirect())
        {
          localObject2 = ((d)localObject1).getLocation();
          localObject1 = b.TF(((d)localObject1).getLocation());
          localObject3 = t.nHC;
          localObject3 = t.bLl();
          localObject4 = t.nHC;
          localObject1 = new d((String)localObject2, (String)localObject1, (v)localObject3, t.bLj());
        }
        else
        {
          localObject2 = t.nHC;
          if (t.Tm(((d)localObject1).url))
          {
            if (!ar.ag(((d)localObject1).bLv(), ((d)localObject1).bLu()))
            {
              localObject2 = (List)((d)localObject1).bLs().get("set-cookie");
              if (localObject2 != null)
              {
                localObject3 = com.tencent.xweb.c.fJa();
                localObject4 = ((d)localObject1).url;
                d.g.b.k.g(localObject2, "it");
                ((com.tencent.xweb.c)localObject3).setCookie((String)localObject4, d.a.j.a((Iterable)localObject2, (CharSequence)";", null, null, 0, null, null, 62));
              }
              localObject1 = ((d)localObject1).bLA();
              AppMethodBeat.o(198943);
              return localObject1;
            }
            ac.w("MicroMsg.WebPrefetcher", "doc expired refresh cached: #" + ((d)localObject1).nHX + ", " + ((d)localObject1).url);
            ((d)localObject1).refresh();
            AppMethodBeat.o(198943);
            return null;
          }
          ac.w("MicroMsg.WebPrefetcher", "preauth expired preauth: #" + ((d)localObject1).nHX + ", " + ((d)localObject1).url);
          t.TT(((d)localObject1).url);
          AppMethodBeat.o(198943);
          return null;
        }
      }
      AppMethodBeat.o(198943);
      return null;
    }
    
    public final String getLocation()
    {
      AppMethodBeat.i(198935);
      String str = (String)this.nHM.getValue();
      AppMethodBeat.o(198935);
      return str;
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
    static final class a
      extends d.g.b.l
      implements d.g.a.a<String>
    {
      a(t.d paramd)
      {
        super();
      }
      
      private String baD()
      {
        AppMethodBeat.i(198914);
        Object localObject1 = k.nGP;
        Object localObject3 = k.bKW();
        localObject1 = this.nIa.nHX;
        localObject3 = (aw)((aq)localObject3).aKv((String)localObject1);
        int i;
        if (localObject3 != null) {
          if (((aw)localObject3).containsKey((String)localObject1))
          {
            localObject1 = ((aw)localObject3).decodeBytes((String)localObject1);
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
            localObject3 = dyi.class.newInstance();
            ((com.tencent.mm.bw.a)localObject3).parseFrom((byte[])localObject1);
            localObject1 = (com.tencent.mm.bw.a)localObject3;
            localObject1 = (dyi)localObject1;
            if (localObject1 != null)
            {
              localObject3 = ((dyi)localObject1).dlk;
              localObject1 = localObject3;
              if (localObject3 != null) {}
            }
            else
            {
              localObject1 = this.nIa.nHX;
            }
            AppMethodBeat.o(198914);
            return localObject1;
          }
          catch (Exception localException)
          {
            label129:
            ac.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", (Throwable)localException, "decode ProtoBuffer", new Object[0]);
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
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
    static final class b
      extends d.g.b.l
      implements d.g.a.a<Long>
    {
      b(t.d paramd)
      {
        super();
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
    static final class c
      extends d.g.b.l
      implements d.g.a.a<String>
    {
      c(t.d paramd)
      {
        super();
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
    static final class d
      extends d.g.b.l
      implements d.g.a.a<String>
    {
      d(t.d paramd)
      {
        super();
      }
      
      private String baD()
      {
        AppMethodBeat.i(198918);
        Object localObject1 = k.nGP;
        Object localObject3 = k.bKW();
        localObject1 = this.nIa.nHX;
        localObject3 = (aw)((aq)localObject3).aKv((String)localObject1);
        int i;
        if (localObject3 != null) {
          if (((aw)localObject3).containsKey((String)localObject1))
          {
            localObject1 = ((aw)localObject3).decodeBytes((String)localObject1);
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
            localObject3 = dyi.class.newInstance();
            ((com.tencent.mm.bw.a)localObject3).parseFrom((byte[])localObject1);
            localObject1 = (com.tencent.mm.bw.a)localObject3;
            localObject1 = (dyi)localObject1;
            if (localObject1 != null)
            {
              localObject3 = ((dyi)localObject1).nJQ;
              localObject1 = localObject3;
              if (localObject3 != null) {}
            }
            else
            {
              localObject1 = this.nIa.url;
            }
            AppMethodBeat.o(198918);
            return localObject1;
          }
          catch (Exception localException)
          {
            label129:
            ac.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", (Throwable)localException, "decode ProtoBuffer", new Object[0]);
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
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "invoke"})
    static final class e
      extends d.g.b.l
      implements d.g.a.a<HashMap<String, List<? extends String>>>
    {
      e(t.d paramd)
      {
        super();
      }
      
      private HashMap<String, List<String>> bLB()
      {
        AppMethodBeat.i(198920);
        Object localObject2 = this.nIa.nHZ;
        Object localObject1 = this.nIa.bLr();
        localObject2 = (aw)((aq)localObject2).aKv((String)localObject1);
        int i;
        if (localObject2 != null) {
          if (((aw)localObject2).containsKey((String)localObject1))
          {
            localObject1 = ((aw)localObject2).decodeBytes((String)localObject1);
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
            localObject2 = dyh.class.newInstance();
            ((com.tencent.mm.bw.a)localObject2).parseFrom((byte[])localObject1);
            localObject1 = (com.tencent.mm.bw.a)localObject2;
            localObject2 = (dyh)localObject1;
            localObject1 = new HashMap();
            if (localObject2 == null) {
              break label201;
            }
            localObject2 = ((dyh)localObject2).Geq;
            d.g.b.k.g(localObject2, "it.header");
            localObject2 = ((Iterable)localObject2).iterator();
            if (!((Iterator)localObject2).hasNext()) {
              break label201;
            }
            dyg localdyg = (dyg)((Iterator)localObject2).next();
            ((HashMap)localObject1).put(localdyg.key, localdyg.EHU);
            continue;
            i = 0;
          }
          catch (Exception localException)
          {
            ac.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", (Throwable)localException, "decode ProtoBuffer", new Object[0]);
          }
          i = 0;
          break label65;
          localHashMap = null;
          continue;
          localHashMap = null;
        }
        label201:
        AppMethodBeat.o(198920);
        return localHashMap;
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
    static final class f
      extends d.g.b.l
      implements d.g.a.a<Boolean>
    {
      f(t.d paramd)
      {
        super();
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
    static final class g
      extends d.g.b.l
      implements d.g.a.a<Boolean>
    {
      g(t.d paramd)
      {
        super();
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
    static final class h
      extends d.g.b.l
      implements d.g.a.a<String>
    {
      h(t.d paramd)
      {
        super();
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
    static final class i
      extends d.g.b.l
      implements d.g.a.a<Integer>
    {
      i(t.d paramd)
      {
        super();
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
    static final class j
      extends d.g.b.l
      implements d.g.a.a<String>
    {
      j(t.d paramd)
      {
        super();
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
    static final class k
      extends d.g.b.l
      implements d.g.a.a<String>
    {
      k(t.d paramd)
      {
        super();
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
    static final class l
      extends d.g.b.l
      implements d.g.a.a<String>
    {
      l(t.d paramd)
      {
        super();
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchType;", "invoke"})
    static final class m
      extends d.g.b.l
      implements d.g.a.a<t.e>
    {
      m(t.d paramd)
      {
        super();
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
    static final class n
      extends d.g.b.l
      implements d.g.a.a<Long>
    {
      n(t.d paramd)
      {
        super();
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
    static final class o
      extends d.g.b.l
      implements d.g.a.a<String>
    {
      o(t.d paramd)
      {
        super();
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchType;", "", "type", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "toString", "JS", "CSS", "HTML", "plugin-brandservice_release"})
  static enum e
  {
    private final String type;
    
    static
    {
      AppMethodBeat.i(198947);
      e locale1 = new e("JS", 0, "JS");
      nIb = locale1;
      e locale2 = new e("CSS", 1, "CSS");
      nIc = locale2;
      e locale3 = new e("HTML", 2, "HTML");
      nId = locale3;
      nIe = new e[] { locale1, locale2, locale3 };
      AppMethodBeat.o(198947);
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
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$connect$2$1", "Lcom/tencent/mars/cdn/CronetLogic$CronetTaskCallback;", "onCronetReceiveHeader", "", "header", "Lcom/tencent/mars/cdn/CronetLogic$ResponseHeader;", "status_code", "onCronetTaskCompleted", "", "filekey", "", "result", "Lcom/tencent/mars/cdn/CronetLogic$CronetTaskResult;", "onDownloadProgressChanged", "progress", "Lcom/tencent/mars/cdn/CronetLogic$CronetDownloadProgress;", "plugin-brandservice_release"})
  public static final class f
    implements CronetLogic.CronetTaskCallback
  {
    f(x paramx, String paramString, com.tencent.mm.vfs.e parame, d.g.a.b paramb1, d.g.a.b paramb2) {}
    
    public final int onCronetReceiveHeader(CronetLogic.ResponseHeader paramResponseHeader, int paramInt)
    {
      AppMethodBeat.i(198951);
      if (((Boolean)this.nIi.ay(Integer.valueOf(paramInt))).booleanValue())
      {
        AppMethodBeat.o(198951);
        return 0;
      }
      paramResponseHeader = this.nIj;
      if (paramResponseHeader != null) {
        paramResponseHeader.ay(Boolean.FALSE);
      }
      AppMethodBeat.o(198951);
      return -99;
    }
    
    public final void onCronetTaskCompleted(String paramString, CronetLogic.CronetTaskResult paramCronetTaskResult)
    {
      AppMethodBeat.i(198950);
      if (paramCronetTaskResult != null) {
        switch (paramCronetTaskResult.statusCode)
        {
        }
      }
      for (;;)
      {
        paramString = new com.tencent.mm.vfs.e(this.nIf.aLM());
        if (paramString.exists()) {
          paramString.delete();
        }
        paramString = this.nIj;
        if (paramString == null) {
          break;
        }
        paramString.ay(Boolean.valueOf(com.tencent.mm.vfs.i.eA(this.nIg)));
        AppMethodBeat.o(198950);
        return;
        if (com.tencent.mm.vfs.i.ma(this.nIf.aLM(), this.nIg))
        {
          ac.i("MicroMsg.WebPrefetcher", "save file:" + this.nIf.getURL() + " to " + this.nIg);
        }
        else
        {
          ac.e("MicroMsg.WebPrefetcher", "save conn failed:" + this.nIf.getURL() + " to " + this.nIf.aLM());
          continue;
          this.nIi.ay(Integer.valueOf(paramCronetTaskResult.statusCode));
        }
      }
      AppMethodBeat.o(198950);
    }
    
    public final void onDownloadProgressChanged(String paramString, CronetLogic.CronetDownloadProgress paramCronetDownloadProgress) {}
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "", "invoke"})
  static final class g
    extends d.g.b.l
    implements d.g.a.b<Integer, Boolean>
  {
    public static final g nIk;
    
    static
    {
      AppMethodBeat.i(198953);
      nIk = new g();
      AppMethodBeat.o(198953);
    }
    
    g()
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mm/network/MMHttpUrlCronetConnection;", "conn", "invoke"})
  static final class h
    extends d.g.b.l
    implements d.g.a.b<x, x>
  {
    h(Map paramMap, t.d paramd, String paramString1, String paramString2)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mm/network/MMHttpUrlCronetConnection;", "conn", "invoke", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$fetchManifest$2$1"})
  static final class i
    extends d.g.b.l
    implements d.g.a.b<x, x>
  {
    i(String paramString, d paramd, j paramj)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mm/network/MMHttpUrlCronetConnection;", "conn", "invoke", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$fetchRes$1$1"})
  static final class j
    extends d.g.b.l
    implements d.g.a.b<x, x>
  {
    j(String paramString1, t.c paramc, String paramString2)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/mm/sdk/platformtools/MMBatchRunKt$batchRun$2"})
  public static final class k
    extends d.d.b.a.i
    implements m<ag, d<? super y>, Object>
  {
    int label;
    private ag nvs;
    Object nvt;
    
    public k(long paramLong, String paramString, d paramd, t paramt)
    {
      super();
    }
    
    public final d<y> a(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(6785);
      d.g.b.k.h(paramd, "completion");
      paramd = new k(this.nGR, this.kdj, paramd, this.nIz);
      paramd.nvs = ((ag)paramObject);
      AppMethodBeat.o(6785);
      return paramd;
    }
    
    public final Object cO(Object paramObject)
    {
      AppMethodBeat.i(6784);
      Object localObject = d.d.a.a.KUd;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(6784);
        throw paramObject;
      case 0: 
        paramObject = this.nvs;
        long l = this.nGR;
        this.nvt = paramObject;
        this.label = 1;
        if (as.b(l, this) == localObject)
        {
          AppMethodBeat.o(6784);
          return localObject;
        }
        break;
      case 1: 
        paramObject = (ag)this.nvt;
      }
      if (!ah.a(paramObject))
      {
        paramObject = y.KTp;
        AppMethodBeat.o(6784);
        return paramObject;
      }
      synchronized (bx.GuY)
      {
        paramObject = bx.GuY;
        localObject = bx.eWt().get(this.kdj);
        paramObject = localObject;
        if (!(localObject instanceof Queue)) {
          paramObject = null;
        }
        paramObject = (Queue)paramObject;
        if (paramObject != null)
        {
          localObject = bx.GuY;
          bx.eWt().remove(this.kdj);
          paramObject = new ArrayList((Collection)paramObject);
          if (paramObject != null) {
            t.cr((List)paramObject);
          }
          paramObject = bx.GuY;
          bx.eWs().remove(this.kdj);
          paramObject = y.KTp;
          AppMethodBeat.o(6784);
          return paramObject;
        }
        paramObject = null;
      }
    }
    
    public final Object n(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(6786);
      paramObject1 = ((k)a(paramObject1, (d)paramObject2)).cO(y.KTp);
      AppMethodBeat.o(6786);
      return paramObject1;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class l
    implements Runnable
  {
    l(List paramList) {}
    
    public final void run()
    {
      AppMethodBeat.i(198963);
      LinkedList localLinkedList = new LinkedList();
      Iterator localIterator = ((Iterable)this.nIA).iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        try
        {
          ac.i("MicroMsg.WebPrefetcher", "pre dns:".concat(String.valueOf(InetAddress.getByName(str))));
          c.a locala = com.tencent.mm.plugin.brandservice.c.nup;
          com.tencent.mm.plugin.brandservice.c.bIW().Bk(str);
          localLinkedList.add(str);
        }
        catch (Exception localException)
        {
          ac.printErrStackTrace("MicroMsg.WebPrefetcher", (Throwable)localException, "pre dns err:".concat(String.valueOf(str)), new Object[0]);
        }
      }
      com.tencent.mm.plugin.webview.h.b.Vl(localLinkedList.size());
      AppMethodBeat.o(198963);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/mm/sdk/platformtools/MMBatchRunKt$batchRun$2"})
  public static final class m
    extends d.d.b.a.i
    implements m<ag, d<? super y>, Object>
  {
    int label;
    private ag nvs;
    Object nvt;
    
    public m(long paramLong, String paramString, d paramd)
    {
      super();
    }
    
    public final d<y> a(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(6796);
      d.g.b.k.h(paramd, "completion");
      paramd = new m(this.nGR, this.kdj, paramd);
      paramd.nvs = ((ag)paramObject);
      AppMethodBeat.o(6796);
      return paramd;
    }
    
    public final Object cO(Object paramObject)
    {
      AppMethodBeat.i(6795);
      Object localObject1 = d.d.a.a.KUd;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(6795);
        throw paramObject;
      case 0: 
        paramObject = this.nvs;
        long l = this.nGR;
        this.nvt = paramObject;
        this.label = 1;
        if (as.b(l, this) == localObject1)
        {
          AppMethodBeat.o(6795);
          return localObject1;
        }
        break;
      case 1: 
        paramObject = (ag)this.nvt;
      }
      if (!ah.a(paramObject))
      {
        paramObject = y.KTp;
        AppMethodBeat.o(6795);
        return paramObject;
      }
      for (;;)
      {
        synchronized (bx.GuY)
        {
          paramObject = bx.GuY;
          localObject1 = bx.eWt().get(this.kdj);
          paramObject = localObject1;
          if (!(localObject1 instanceof Queue)) {
            paramObject = null;
          }
          paramObject = (Queue)paramObject;
          if (paramObject != null)
          {
            localObject1 = bx.GuY;
            bx.eWt().remove(this.kdj);
            paramObject = new ArrayList((Collection)paramObject);
            if (paramObject == null) {
              break;
            }
            paramObject = ((Iterable)paramObject).iterator();
            if (!paramObject.hasNext()) {
              break;
            }
            localObject1 = (t.b)paramObject.next();
            ??? = ((t.b)localObject1).dxX;
            localObject3 = b.TF(((t.b)localObject1).dxX);
            Object localObject4 = t.nHC;
            localObject4 = t.bLl();
            t localt = t.nHC;
            ??? = new t.d((String)???, (String)localObject3, (v)localObject4, t.bLj());
            if (((t.d)???).bLy())
            {
              if (((t.b)localObject1).nHF) {
                continue;
              }
              int i = Math.max(((t.d)???).bLu() - 60, 60);
              if ((((t.d)???).bLv() <= 0L) || (!ar.ag(((t.d)???).bLv(), i))) {
                continue;
              }
              localObject3 = t.nHC;
              t.a(((t.b)localObject1).nHE, ((t.b)localObject1).host, (t.d)???, ((t.b)localObject1).nHG);
              continue;
            }
          }
          else
          {
            paramObject = null;
          }
        }
        Object localObject3 = t.nHC;
        t.a(((t.b)localObject1).nHE, ((t.b)localObject1).host, (t.d)???, ((t.b)localObject1).nHG);
      }
      paramObject = bx.GuY;
      bx.eWs().remove(this.kdj);
      paramObject = y.KTp;
      AppMethodBeat.o(6795);
      return paramObject;
    }
    
    public final Object n(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(6797);
      paramObject1 = ((m)a(paramObject1, (d)paramObject2)).cO(y.KTp);
      AppMethodBeat.o(6797);
      return paramObject1;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyLitePrefetchResInfo;", "kotlin.jvm.PlatformType", "invoke"})
  static final class n
    extends d.g.b.l
    implements d.g.a.b<arh, String>
  {
    public static final n nIB;
    
    static
    {
      AppMethodBeat.i(198965);
      nIB = new n();
      AppMethodBeat.o(198965);
    }
    
    n()
    {
      super();
    }
  }
  
  @d.d.b.a.e(c="com.tencent.mm.plugin.brandservice.ui.timeline.preload.WebPrefetcher$savePrefetch$1", f="WebPrefetcher.kt", l={842, 842, 857}, m="invokeSuspend")
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class o
    extends d.d.b.a.i
    implements m<ag, d<? super y>, Object>
  {
    int label;
    Object nIC;
    Object nID;
    Object nIE;
    Object nIF;
    Object nIG;
    Object nIH;
    Object nII;
    Object nIJ;
    Object nIK;
    Object nIL;
    Object nIM;
    int nIN;
    int nIO;
    private ag nvs;
    Object nvt;
    
    o(arl paramarl, arj paramarj, List paramList, d paramd)
    {
      super();
    }
    
    public final d<y> a(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(198967);
      d.g.b.k.h(paramd, "completion");
      paramd = new o(this.nIP, this.nIQ, this.nIR, paramd);
      paramd.nvs = ((ag)paramObject);
      AppMethodBeat.o(198967);
      return paramd;
    }
    
    public final Object cO(Object paramObject)
    {
      AppMethodBeat.i(198966);
      d.d.a.a locala = d.d.a.a.KUd;
      Object localObject2;
      Object localObject5;
      Object localObject4;
      Object localObject6;
      Object localObject1;
      int j;
      int i;
      Object localObject7;
      Object localObject9;
      Object localObject11;
      Object localObject12;
      Object localObject10;
      label425:
      Object localObject13;
      Object localObject14;
      int k;
      label494:
      label500:
      Object localObject17;
      label582:
      Object localObject15;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(198966);
        throw paramObject;
      case 0: 
        localObject2 = this.nvs;
        localObject5 = new LinkedList();
        localObject4 = new v.a();
        ((v.a)localObject4).KUL = false;
        localObject6 = new v.a();
        ((v.a)localObject6).KUL = false;
        paramObject = new HashMap();
        localObject1 = new HashMap();
        j = 0;
        i = this.nIP.DXj;
        if (j < i)
        {
          localObject7 = new dyi();
          ((v.a)localObject4).KUL = false;
          ((v.a)localObject6).KUL = false;
          ((dyi)localObject7).url = ((ari)this.nIQ.EKz.get(j)).EKt;
          ((dyi)localObject7).nJQ = ((ark)this.nIP.EKL.get(j)).EKB;
          localObject9 = ((dyi)localObject7).url;
          d.g.b.k.g(localObject9, "url");
          localObject11 = b.TF((String)localObject9);
          localObject9 = ((dyi)localObject7).nJQ;
          d.g.b.k.g(localObject9, "fullUrl");
          if (!n.nb((String)localObject9, "http")) {
            break label2781;
          }
          localObject12 = (Map)new LinkedHashMap();
          boolean bool;
          if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pPV, 0) == 1)
          {
            bool = true;
            ac.i("MicroMsg.WebPrefetcher", "[TRACE_PREFETCH] useA8keyLiteHeader ".concat(String.valueOf(bool)));
            if ((!bool) || (bs.gY((List)((ark)this.nIP.EKL.get(j)).EKJ))) {
              break label582;
            }
            ac.i("MicroMsg.WebPrefetcher", "[TRACE_PREFETCH] response header size : " + ((ark)this.nIP.EKL.get(j)).EKJ.size());
            localObject9 = ((ark)this.nIP.EKL.get(j)).EKJ;
            d.g.b.k.g(localObject9, "RespInfo[i].HttpHeader");
            localObject10 = (Iterable)localObject9;
            localObject9 = (Collection)new ArrayList();
            localObject10 = ((Iterable)localObject10).iterator();
            if (!((Iterator)localObject10).hasNext()) {
              break label500;
            }
            localObject13 = ((Iterator)localObject10).next();
            localObject14 = (bki)localObject13;
            if ((((bki)localObject14).tlp != null) && (((bki)localObject14).wTM != null)) {
              break label494;
            }
          }
          for (k = 1;; k = 0)
          {
            if (k != 0) {
              break label425;
            }
            ((Collection)localObject9).add(localObject13);
            break label425;
            bool = false;
            break;
          }
          localObject9 = ((Iterable)localObject9).iterator();
          while (((Iterator)localObject9).hasNext())
          {
            localObject13 = (bki)((Iterator)localObject9).next();
            localObject10 = ((bki)localObject13).tlp;
            d.g.b.k.g(localObject10, "it.Key");
            localObject13 = ((bki)localObject13).wTM;
            d.g.b.k.g(localObject13, "it.Value");
            ((Map)localObject12).put(localObject10, localObject13);
          }
          ac.i("MicroMsg.WebPrefetcher", "[TRACE_PREFETCH] useA8keyLiteHeader size : " + ((Map)localObject12).size());
          ac.i("MicroMsg.WebPrefetcher", "savePrefetch domains size : " + this.nIR.size());
          ((dyi)localObject7).iaH = System.currentTimeMillis();
          localObject9 = (Integer)this.nIP.EKK.get(j);
          if (localObject9 == null)
          {
            ((dyi)localObject7).Ger = true;
            if (!((dyi)localObject7).Ger)
            {
              ((LinkedList)localObject5).add(((dyi)localObject7).nJQ);
              ((v.a)localObject6).KUL = true;
            }
            localObject9 = t.nHC;
            localObject9 = ((dyi)localObject7).nJQ;
            d.g.b.k.g(localObject9, "fullUrl");
            localObject10 = t.l((String)localObject9, this.nIR);
            if (localObject10 == null) {
              break label2185;
            }
            localObject13 = this.nIQ.EKz.get(j);
            localObject9 = localObject13;
            if (!(localObject13 instanceof f)) {
              localObject9 = null;
            }
            localObject9 = (f)localObject9;
            if (localObject9 == null) {
              break label956;
            }
          }
          for (localObject9 = ((f)localObject9).extInfo;; localObject9 = null)
          {
            ((j)localObject10).extInfo = ((String)localObject9);
            ac.v("MicroMsg.WebPrefetcher", "match prefetch#".concat(String.valueOf(localObject11)));
            localObject13 = t.nHC;
            this.nvt = localObject2;
            this.nIC = localObject5;
            this.nID = localObject4;
            this.nIE = localObject6;
            this.nIF = paramObject;
            this.nIG = localObject1;
            this.nIN = j;
            this.nIO = i;
            this.nIH = localObject7;
            this.nII = localObject7;
            this.nIJ = localObject11;
            this.nIK = localObject12;
            this.nIL = localObject10;
            this.nIM = localObject9;
            this.label = 1;
            localObject17 = t.a((j)localObject10, this);
            if (localObject17 != locala) {
              break label2720;
            }
            AppMethodBeat.o(198966);
            return locala;
            if (((Integer)localObject9).intValue() != 0) {
              break;
            }
            if (((ark)this.nIP.EKL.get(j)).EKG == 0) {
              break label675;
            }
            ((dyi)localObject7).Ges = true;
            break label675;
          }
        }
        break;
      case 1: 
        localObject13 = (String)this.nIM;
        localObject10 = (j)this.nIL;
        localObject12 = (Map)this.nIK;
        localObject6 = (String)this.nIJ;
        localObject1 = (dyi)this.nII;
        localObject11 = (dyi)this.nIH;
        i = this.nIO;
        j = this.nIN;
        localObject7 = (HashMap)this.nIG;
        localObject4 = (HashMap)this.nIF;
        localObject9 = (v.a)this.nIE;
        localObject14 = (v.a)this.nID;
        localObject15 = (LinkedList)this.nIC;
        localObject2 = (ag)this.nvt;
        localObject5 = paramObject;
        paramObject = localObject15;
        localObject15 = localObject5;
        localObject5 = localObject14;
        if (((Boolean)localObject15).booleanValue())
        {
          localObject14 = w.nIY;
          localObject15 = ((dyi)localObject1).nJQ;
          d.g.b.k.g(localObject15, "fullUrl");
          this.nvt = localObject2;
          this.nIC = paramObject;
          this.nID = localObject5;
          this.nIE = localObject9;
          this.nIF = localObject4;
          this.nIG = localObject7;
          this.nIN = j;
          this.nIO = i;
          this.nIH = localObject11;
          this.nII = localObject1;
          this.nIJ = localObject6;
          this.nIK = localObject12;
          this.nIL = localObject10;
          this.nIM = localObject13;
          this.label = 2;
          localObject14 = ((w)localObject14).a((String)localObject15, (j)localObject10, this);
          if (localObject14 == locala)
          {
            AppMethodBeat.o(198966);
            return locala;
          }
        }
        break;
      case 2: 
        localObject13 = (String)this.nIM;
        localObject10 = (j)this.nIL;
        localObject12 = (Map)this.nIK;
        localObject15 = (String)this.nIJ;
        localObject1 = (dyi)this.nII;
        localObject11 = (dyi)this.nIH;
        i = this.nIO;
        j = this.nIN;
        localObject7 = (HashMap)this.nIG;
        localObject4 = (HashMap)this.nIF;
        localObject9 = (v.a)this.nIE;
        localObject5 = (v.a)this.nID;
        localObject14 = (LinkedList)this.nIC;
        localObject2 = (ag)this.nvt;
        localObject6 = paramObject;
        paramObject = localObject14;
        localObject14 = localObject6;
        localObject6 = localObject15;
        if (((Boolean)localObject14).booleanValue())
        {
          ((dyi)localObject1).nHE = ((dyi)localObject1).nJQ;
          localObject14 = h.nGE;
          if (i.bBL().getBoolean("tencent_view_inews_prefix", false))
          {
            localObject14 = ((dyi)localObject1).nHE;
            d.g.b.k.g(localObject14, "prefetchUrl");
            ((dyi)localObject1).nHE = n.bg((String)localObject14, "//view.inews.qq.com", "//ssr.view.inews.qq.com");
          }
          ((dyi)localObject1).Get = true;
          localObject14 = t.nHC;
          t.a((dyi)localObject1);
          ac.i("MicroMsg.WebPrefetcher", "prefetch call, header size: " + ((Map)localObject12).size() + ", url: " + ((dyi)localObject1).nHE);
          localObject14 = t.nHC;
          localObject14 = ((dyi)localObject1).url;
          d.g.b.k.g(localObject14, "url");
          localObject15 = ((dyi)localObject1).nHE;
          d.g.b.k.g(localObject15, "prefetchUrl");
          t.b((String)localObject14, (String)localObject15, (Map)localObject12);
          ((v.a)localObject5).KUL = true;
          localObject14 = w.nIY;
          this.nvt = localObject2;
          this.nIC = paramObject;
          this.nID = localObject5;
          this.nIE = localObject9;
          this.nIF = localObject4;
          this.nIG = localObject7;
          this.nIN = j;
          this.nIO = i;
          this.nIH = localObject11;
          this.nII = localObject1;
          this.nIJ = localObject6;
          this.nIK = localObject12;
          this.nIL = localObject10;
          this.nIM = localObject13;
          this.label = 3;
          localObject11 = ((w)localObject14).b((j)localObject10, this);
          if (localObject11 != locala) {
            break label2691;
          }
          AppMethodBeat.o(198966);
          return locala;
        }
        break;
      case 3: 
        label675:
        label956:
        label1094:
        label1369:
        localObject10 = (j)this.nIL;
        localObject9 = (String)this.nIJ;
        localObject1 = (dyi)this.nII;
        i = this.nIO;
        j = this.nIN;
        localObject7 = (HashMap)this.nIG;
        localObject4 = (HashMap)this.nIF;
        localObject12 = (v.a)this.nIE;
        localObject5 = (v.a)this.nID;
        localObject11 = (LinkedList)this.nIC;
        localObject2 = (ag)this.nvt;
        localObject6 = paramObject;
        paramObject = localObject11;
        localObject11 = localObject6;
        localObject6 = localObject12;
        label1767:
        localObject12 = (Iterable)localObject11;
        localObject11 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject12, 10));
        localObject12 = ((Iterable)localObject12).iterator();
        while (((Iterator)localObject12).hasNext()) {
          ((Collection)localObject11).add(new t.c((String)((Iterator)localObject12).next(), t.e.nIb));
        }
        localObject11 = (List)localObject11;
        localObject12 = t.nHC;
        localObject10 = ((j)localObject10).nGF.EKj;
        d.g.b.k.g(localObject10, "manifest.domain.Domain");
        t.g((List)localObject11, (String)localObject10);
        localObject10 = y.KTp;
        ac.v("MicroMsg.WebPrefetcher", "end prefetch #" + (String)localObject9 + ' ' + ((dyi)localObject1).nHE);
        localObject10 = localObject4;
        localObject4 = localObject5;
        localObject9 = localObject1;
        localObject1 = localObject6;
        localObject6 = localObject10;
        localObject5 = localObject7;
      }
      for (;;)
      {
        try
        {
          localObject7 = t.nHC;
          k = t.To(((dyi)localObject9).url);
          localObject7 = (Integer)((HashMap)localObject5).get(Integer.valueOf(k));
          if (localObject7 != null) {
            continue;
          }
          ((Map)localObject5).put(Integer.valueOf(k), Integer.valueOf(1));
          localObject7 = ((dyi)localObject9).url;
          d.g.b.k.g(localObject7, "url");
          com.tencent.mm.plugin.webview.h.b.a(0, (String)localObject7, false, false, true, ((v.a)localObject1).KUL, ((v.a)localObject4).KUL, true);
          localObject7 = (Integer)((HashMap)localObject6).get(Integer.valueOf(k));
          if (localObject7 != null) {
            continue;
          }
          ((Map)localObject6).put(Integer.valueOf(k), Integer.valueOf(1));
          localObject7 = localObject1;
          localObject1 = localObject6;
        }
        catch (Exception localException2)
        {
          label2185:
          ac.e("MicroMsg.WebPrefetcher", "Report Error");
          localObject8 = localObject1;
          localObject1 = localObject6;
          continue;
          ((Map)localObject6).put(Integer.valueOf(k), Integer.valueOf(localObject8.intValue() + 1));
          localObject8 = localObject1;
          localObject1 = localObject6;
          continue;
        }
        localObject6 = y.KTp;
        j += 1;
        localObject6 = localObject5;
        localObject5 = paramObject;
        paramObject = localObject1;
        localObject1 = localObject6;
        localObject6 = localObject7;
        break;
        localObject10 = localObject9;
        localObject9 = localObject1;
        localObject1 = t.nHC;
        t.a((dyi)localObject9);
        ac.w("MicroMsg.WebPrefetcher", "fail to prefetch #" + (String)localObject6 + ' ' + ((dyi)localObject9).url);
        localObject6 = localObject4;
        localObject1 = localObject10;
        localObject4 = localObject5;
        localObject5 = localObject7;
        continue;
        localObject9 = t.nHC;
        t.a((dyi)localObject7);
        localObject9 = localObject6;
        localObject10 = localObject5;
        localObject5 = localObject1;
        localObject6 = paramObject;
        localObject1 = localObject9;
        paramObject = localObject10;
        localObject9 = localObject7;
        continue;
        ((Map)localObject5).put(Integer.valueOf(k), Integer.valueOf(((Integer)localObject7).intValue() + 1));
        continue;
        if (!((Collection)localObject5).isEmpty()) {
          i = 1;
        }
        for (;;)
        {
          if (i != 0) {}
          try
          {
            localObject2 = t.nHC;
            t.cs((List)localObject5);
            com.tencent.mm.plugin.webview.h.b.Vk(this.nIP.DXj);
            localObject4 = (Map)paramObject;
            localObject2 = (Collection)new ArrayList(((Map)localObject4).size());
            localObject4 = ((Map)localObject4).entrySet().iterator();
            while (((Iterator)localObject4).hasNext())
            {
              localObject5 = (Map.Entry)((Iterator)localObject4).next();
              i = ((Number)((Map.Entry)localObject5).getKey()).intValue();
              com.tencent.mm.plugin.webview.h.b.iK(((Number)((Map.Entry)localObject5).getValue()).intValue(), i);
              ((Collection)localObject2).add(y.KTp);
              continue;
              i = 0;
            }
          }
          catch (Exception localException1)
          {
            for (;;)
            {
              ac.e("MicroMsg.WebPrefetcher", "preDns ex " + localException1.getMessage());
            }
            Object localObject3 = (Map)localObject1;
            localObject1 = (Collection)new ArrayList(((Map)localObject3).size());
            localObject3 = ((Map)localObject3).entrySet().iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject4 = (Map.Entry)((Iterator)localObject3).next();
              i = ((Number)((Map.Entry)localObject4).getKey()).intValue();
              j = ((Number)((Map.Entry)localObject4).getValue()).intValue();
              com.tencent.mm.plugin.webview.h.b.iL(j, i);
              if (paramObject.get(Integer.valueOf(i)) != null)
              {
                localObject4 = paramObject.get(Integer.valueOf(i));
                if (localObject4 == null) {
                  d.g.b.k.fOy();
                }
                if (d.g.b.k.compare(((Number)localObject4).intValue(), j) > 0)
                {
                  localObject4 = paramObject.get(Integer.valueOf(i));
                  if (localObject4 == null) {
                    d.g.b.k.fOy();
                  }
                  com.tencent.mm.plugin.webview.h.b.iM(((Number)localObject4).intValue() - j, i);
                }
              }
              ((Collection)localObject1).add(y.KTp);
            }
            paramObject = y.KTp;
            AppMethodBeat.o(198966);
            return paramObject;
          }
        }
        label2691:
        localObject12 = localObject6;
        localObject6 = localObject9;
        localObject9 = localObject12;
        break label1767;
        break label1369;
        localObject10 = localObject9;
        localObject9 = localObject1;
        continue;
        label2720:
        localObject13 = localObject9;
        localObject9 = localObject11;
        localObject11 = localObject8;
        localObject14 = localObject8;
        localObject15 = localObject6;
        Object localObject16 = localObject5;
        localObject6 = localObject9;
        Object localObject8 = localObject1;
        localObject9 = localObject15;
        localObject5 = localObject4;
        localObject15 = localObject17;
        localObject1 = localObject11;
        localObject11 = localObject14;
        localObject4 = paramObject;
        paramObject = localObject16;
        break label1094;
        label2781:
        localObject8 = paramObject;
        paramObject = localObject5;
        localObject5 = localObject1;
        localObject1 = localObject8;
        localObject8 = localObject6;
      }
    }
    
    public final Object n(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(198968);
      paramObject1 = ((o)a(paramObject1, (d)paramObject2)).cO(y.KTp);
      AppMethodBeat.o(198968);
      return paramObject1;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "kotlin.jvm.PlatformType", "it", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyLiteReqInfo;", "invoke"})
  static final class p
    extends d.g.b.l
    implements d.g.a.b<ari, String>
  {
    public static final p nIS;
    
    static
    {
      AppMethodBeat.i(198970);
      nIS = new p();
      AppMethodBeat.o(198970);
    }
    
    p()
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class q
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    q(arj paramarj)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.t
 * JD-Core Version:    0.7.0.1
 */