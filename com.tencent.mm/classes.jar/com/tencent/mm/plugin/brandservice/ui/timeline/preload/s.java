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
import com.tencent.mm.protocal.protobuf.aob;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.protocal.protobuf.aod;
import com.tencent.mm.protocal.protobuf.aoe;
import com.tencent.mm.protocal.protobuf.aof;
import com.tencent.mm.protocal.protobuf.aog;
import com.tencent.mm.protocal.protobuf.aoh;
import com.tencent.mm.protocal.protobuf.dsp;
import com.tencent.mm.protocal.protobuf.dsq;
import com.tencent.mm.protocal.protobuf.dsr;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.by;
import com.tencent.mm.vfs.e;
import com.tencent.xweb.WebResourceResponse;
import d.a.ae;
import d.g.a.m;
import d.g.b.v.a;
import d.g.b.w;
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
import kotlinx.coroutines.ao;
import kotlinx.coroutines.at;
import kotlinx.coroutines.bc;
import kotlinx.coroutines.bj;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher;", "", "()V", "MIN_EXPIRE_SECONDS", "", "PRE_AUTH_EXPIRE_SECONDS", "REFRESH_BEFORE_EXPIRE_SECONDS", "value", "currentScene", "getCurrentScene", "()I", "setCurrentScene", "(I)V", "manifestContent", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcherFile;", "getManifestContent$plugin_brandservice_release", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcherFile;", "preauthRequestLimiter", "Lcom/tencent/mm/sdk/platformtools/MMCacheSlotManager;", "getPreauthRequestLimiter$plugin_brandservice_release", "()Lcom/tencent/mm/sdk/platformtools/MMCacheSlotManager;", "resContent", "getResContent$plugin_brandservice_release", "resHeadersManager", "Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "getResHeadersManager$plugin_brandservice_release", "()Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "settingManager", "getSettingManager$plugin_brandservice_release", "webContent", "getWebContent$plugin_brandservice_release", "webHeadersManager", "getWebHeadersManager$plugin_brandservice_release", "webIdToSceneManager", "getWebIdToSceneManager$plugin_brandservice_release", "clearPrefetchContent", "", "url", "", "debugPreloadWebInfo", "", "(Ljava/lang/String;)[[Ljava/lang/String;", "fetchContent", "Lcom/tencent/mm/network/MMHttpUrlCronetConnection;", "host", "target", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchTarget;", "deep", "fetchManifest", "", "manifest", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PrefetchManifest;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PrefetchManifest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchRes", "batchRes", "", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchRes;", "getPreAuthUrl", "getPrefetchContentResp", "Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService$PrefetchResponse;", "getPrefetchResResp", "referer", "getReportScene", "getUrlScene", "getValidPreloadWebInfo", "Lcom/tencent/mm/protocal/protobuf/WebPrefetchInfo;", "isDnsCached", "isInPreAuthWhiteList", "isUrlPreAuthed", "isWebUrlEqual", "rawUrl", "targetUrl", "isWebUrlStorageEqual", "matchManifest", "domains", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyLitePrefetchDomainInfo;", "needReauth", "preAuth", "appId", "title", "desc", "from", "scene", "preAuths", "auths", "Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService$PreAuthInfo;", "preDns", "urls", "prefetch", "prefetchUrl", "checkCacheOnly", "sendGetA8KeyLiteRequest", "preauths", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$BatchPreauth;", "setUrlToScene", "connect", "receiveHeader", "Lkotlin/Function1;", "targetFile", "Lcom/tencent/mm/vfs/VFSFile;", "onCompleted", "mockManifest", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyLiteResponse;", "prepare", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyLiteRequest;", "save", "saveDomainInfos", "saveManifest", "savePrefetch", "request", "BatchPreauth", "PrefetchAction", "PrefetchRes", "PrefetchTarget", "PrefetchType", "plugin-brandservice_release"})
public final class s
{
  private static final ar neI;
  private static final ar neJ;
  private static final ar neK;
  private static final u neL;
  private static final u neM;
  private static final u neN;
  private static final al neO;
  private static final ar neP;
  public static final s neQ;
  
  static
  {
    AppMethodBeat.i(6809);
    neQ = new s();
    neI = new ar(r.bDU(), 604800L);
    neJ = new ar(r.bDU(), 86400L);
    neK = new ar(r.bDU(), 604800L);
    neL = new u("wcf://WebPrefetchContent/");
    neM = new u("wcf://WebPrefetchResource/");
    neN = new u("wcf://WebPrefetchManifest/");
    neO = new al();
    neP = new ar(r.bDU(), 86400L);
    AppMethodBeat.o(6809);
  }
  
  private static dsr PJ(String paramString)
  {
    AppMethodBeat.i(193182);
    String str = b.Pu(paramString);
    Object localObject1 = j.ned;
    localObject1 = (ax)j.bDJ().aFe(str);
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
        Object localObject3 = dsr.class.newInstance();
        ((com.tencent.mm.bx.a)localObject3).parseFrom((byte[])localObject1);
        localObject1 = (com.tencent.mm.bx.a)localObject3;
        localObject1 = (dsr)localObject1;
        if (localObject1 == null) {
          break label280;
        }
        boolean bool = as.ad(((dsr)localObject1).hAg, 600);
        com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.WebPrefetcher", "[TRACE_PREFETCH] getValidPreloadWebInfo: webId#" + str + ", prefetch:" + ((dsr)localObject1).EHh + ", authorized:" + ((dsr)localObject1).EHg + ", antispam:" + ((dsr)localObject1).EHf + ", lastModify:" + ((dsr)localObject1).hAg + ", expire:" + bool + ", url:" + paramString);
        if (((!((dsr)localObject1).EHh) && (((dsr)localObject1).EHg)) || (((dsr)localObject1).EHf) || (bool)) {
          break label280;
        }
        AppMethodBeat.o(193182);
        return localObject1;
      }
      catch (Exception localException)
      {
        label247:
        com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", (Throwable)localException, "decode ProtoBuffer", new Object[0]);
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
    com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.WebPrefetcher", "[TRACE_PREFETCH] getVaildPreloadWebInfo: webId#" + str + ", not cached, url:" + paramString);
    AppMethodBeat.o(193182);
    return null;
  }
  
  private static boolean PK(String paramString)
  {
    AppMethodBeat.i(6806);
    String str = b.Pu(paramString);
    Object localObject1 = j.ned;
    localObject1 = (ax)j.bDJ().aFe(str);
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
        Object localObject3 = dsr.class.newInstance();
        ((com.tencent.mm.bx.a)localObject3).parseFrom((byte[])localObject1);
        localObject1 = (com.tencent.mm.bx.a)localObject3;
        localObject1 = (dsr)localObject1;
        if (localObject1 == null) {
          break label247;
        }
        bool2 = as.ad(((dsr)localObject1).hAg, 540);
        bool1 = bool2;
        bool3 = true;
        com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.WebPrefetcher", "[TRACE_PREFETCH] needReauth:" + bool1 + ", webId:" + str + ", cached:" + bool3 + ", expired:" + bool2 + ", url:" + paramString);
        AppMethodBeat.o(6806);
        return bool1;
      }
      catch (Exception localException)
      {
        label210:
        com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", (Throwable)localException, "decode ProtoBuffer", new Object[0]);
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
  
  private static boolean PL(String paramString)
  {
    AppMethodBeat.i(193184);
    Object localObject1 = Uri.parse(UrlExKt.getWithProtocol(paramString));
    if (localObject1 != null)
    {
      localObject1 = ((Uri)localObject1).getHost();
      if (localObject1 != null)
      {
        localObject1 = b.Pw((String)localObject1);
        Object localObject3 = (ax)neI.aFe((String)localObject1);
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
            localObject3 = aob.class.newInstance();
            ((com.tencent.mm.bx.a)localObject3).parseFrom((byte[])localObject1);
            localObject1 = (com.tencent.mm.bx.a)localObject3;
            localObject1 = (aob)localObject1;
            if (localObject1 == null) {
              break label214;
            }
            if ((((aob)localObject1).Dpk != 1) || (as.ad(((aob)localObject1).Dpm, ((aob)localObject1).Dpl))) {
              break label209;
            }
            bool = true;
            if (bool) {
              com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.WebPrefetcher", "[TRACE_PREFETCH] preauth cancelled, in whiteList:".concat(String.valueOf(paramString)));
            }
            AppMethodBeat.o(193184);
            return bool;
          }
          catch (Exception localException)
          {
            label176:
            com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", (Throwable)localException, "decode ProtoBuffer", new Object[0]);
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
    AppMethodBeat.o(193184);
    return false;
  }
  
  private static int PM(String paramString)
  {
    AppMethodBeat.i(175488);
    ax localax = (ax)neP.aFe(b.Pu(paramString));
    if (localax != null)
    {
      int i = localax.getInt(b.Pu(paramString), 0);
      AppMethodBeat.o(175488);
      return i;
    }
    AppMethodBeat.o(175488);
    return 0;
  }
  
  public static boolean Pc(String paramString)
  {
    AppMethodBeat.i(193183);
    d.g.b.k.h(paramString, "url");
    if (PJ(paramString) != null)
    {
      AppMethodBeat.o(193183);
      return true;
    }
    AppMethodBeat.o(193183);
    return false;
  }
  
  public static int Pe(String paramString)
  {
    AppMethodBeat.i(175492);
    int i;
    switch (bEc())
    {
    default: 
      i = bEc();
      AppMethodBeat.o(175492);
      return i;
    }
    if (paramString != null)
    {
      PM(paramString);
      i = PM(paramString);
      AppMethodBeat.o(175492);
      return i;
    }
    AppMethodBeat.o(175492);
    return 0;
  }
  
  public static d.b Pf(String paramString)
  {
    AppMethodBeat.i(193176);
    d.g.b.k.h(paramString, "url");
    paramString = new d(paramString, b.Pu(paramString), neL, neJ).bEl();
    AppMethodBeat.o(193176);
    return paramString;
  }
  
  public static void Pg(String paramString)
  {
    AppMethodBeat.i(6803);
    d.g.b.k.h(paramString, "url");
    Object localObject1 = b.Pu(paramString);
    Object localObject2 = neL.PN((String)localObject1);
    if (((e)localObject2).exists()) {
      ((e)localObject2).delete();
    }
    localObject2 = (ax)neJ.aFe((String)localObject1);
    if (localObject2 != null) {
      ((ax)localObject2).remove((String)localObject1);
    }
    localObject1 = j.ned;
    localObject1 = (ax)j.bDJ().aFe(b.Pu(paramString));
    if (localObject1 != null)
    {
      ((ax)localObject1).removeValueForKey(b.Pu(paramString));
      AppMethodBeat.o(6803);
      return;
    }
    AppMethodBeat.o(6803);
  }
  
  private static aof a(aof paramaof, List<a> paramList)
  {
    AppMethodBeat.i(160499);
    Object localObject1 = (Iterable)paramList;
    paramList = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    Object localObject2;
    Object localObject3;
    label124:
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      localObject3 = (a)localObject2;
      if ((!neO.contains(b.Ps(((a)localObject3).url))) && (!UrlExKt.isMpUrl(((a)localObject3).url)) && (!PL(((a)localObject3).url)) && (PK(((a)localObject3).url))) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label124;
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
      localObject3 = new aoe();
      ((aoe)localObject3).Dps = ((a)localObject2).url;
      ((aoe)localObject3).hnC = ((a)localObject2).appId;
      ((aoe)localObject3).Dpt = ((a)localObject2).title;
      ((aoe)localObject3).Dpu = ((a)localObject2).desc;
      ((aoe)localObject3).Dpr = i;
      ((aoe)localObject3).Dpv = ((a)localObject2).neR;
      ((aoe)localObject3).Scene = ((a)localObject2).scene;
      neO.xe(b.Ps(((a)localObject2).url));
      paramList.add(localObject3);
      i += 1;
    }
    paramList = (List)paramList;
    paramaof.Dpy.addAll((Collection)paramList);
    paramaof.CEJ = paramaof.Dpy.size();
    paramaof.Scene = 0;
    paramaof.CCe = 0;
    AppMethodBeat.o(160499);
    return paramaof;
  }
  
  private static List<aoc> a(aoh paramaoh)
  {
    AppMethodBeat.i(193181);
    paramaoh = paramaoh.Dpz;
    d.g.b.k.g(paramaoh, "PrefetchDomainInfos");
    paramaoh = (Iterable)paramaoh;
    Collection localCollection = (Collection)new ArrayList(d.a.j.a(paramaoh, 10));
    Iterator localIterator = paramaoh.iterator();
    if (localIterator.hasNext())
    {
      Object localObject1 = (com.tencent.mm.bx.b)localIterator.next();
      aoc localaoc = new aoc();
      localaoc.parseFrom(((com.tencent.mm.bx.b)localObject1).toByteArray());
      paramaoh = localaoc.Dpj;
      d.g.b.k.g(paramaoh, "Domain");
      String str1 = b.Px(paramaoh);
      int i3 = 0;
      int i2 = 0;
      int i4 = 0;
      int j = 0;
      int i5 = 0;
      int k = 0;
      paramaoh = localaoc.Dpo;
      d.g.b.k.g(paramaoh, "ResInfos");
      paramaoh = (Iterable)paramaoh;
      HashMap localHashMap = new HashMap();
      paramaoh = paramaoh.iterator();
      Object localObject2;
      Object localObject3;
      while (paramaoh.hasNext())
      {
        localObject2 = (aod)paramaoh.next();
        localObject3 = (Map)localHashMap;
        String str2 = ((aod)localObject2).sdZ;
        d.g.b.k.g(str2, "resInfo.Path");
        d.g.b.k.g(localObject2, "resInfo");
        ((Map)localObject3).put(str2, localObject2);
      }
      paramaoh = (ax)neI.aFe(str1);
      int i;
      if (paramaoh != null) {
        if (paramaoh.containsKey(str1))
        {
          paramaoh = paramaoh.decodeBytes(str1);
          if (paramaoh != null) {
            if (paramaoh.length == 0)
            {
              i = 1;
              if (i != 0) {
                break label518;
              }
              i = 1;
              label274:
              if (i == 0) {
                break label541;
              }
            }
          }
        }
      }
      int m;
      int n;
      int i1;
      for (;;)
      {
        try
        {
          localObject2 = aoc.class.newInstance();
          ((com.tencent.mm.bx.a)localObject2).parseFrom(paramaoh);
          paramaoh = (com.tencent.mm.bx.a)localObject2;
          paramaoh = (aoc)paramaoh;
          m = i5;
          n = i4;
          i1 = i3;
          if (paramaoh == null) {
            break label572;
          }
          paramaoh = paramaoh.Dpo;
          m = i5;
          n = i4;
          i1 = i3;
          if (paramaoh == null) {
            break label572;
          }
          paramaoh = ((Iterable)paramaoh).iterator();
          i = i2;
          m = k;
          n = j;
          i1 = i;
          if (!paramaoh.hasNext()) {
            break label572;
          }
          localObject2 = (aod)paramaoh.next();
          if (!((Map)localHashMap).containsKey(((aod)localObject2).sdZ)) {
            break label556;
          }
          localObject3 = localHashMap.get(((aod)localObject2).sdZ);
          if (localObject3 == null) {
            d.g.b.k.fvU();
          }
          d.g.b.k.g(localObject3, "respPathMap[storedResInfo.Path]!!");
          localObject3 = (aod)localObject3;
          if (!(d.g.b.k.g(((aod)localObject2).Dpp, ((aod)localObject3).Dpp) ^ true)) {
            break label551;
          }
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebPrefetcher", "update manifest:" + localaoc.Dpj + '#' + str1 + ", path:" + ((aod)localObject2).sdZ);
          j = 1;
          continue;
          i = 0;
        }
        catch (Exception paramaoh)
        {
          label518:
          com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", (Throwable)paramaoh, "decode ProtoBuffer", new Object[0]);
        }
        i = 0;
        break label274;
        label541:
        paramaoh = null;
        continue;
        paramaoh = null;
        continue;
        label551:
        i = 1;
        continue;
        label556:
        localaoc.Dpo.add(localObject2);
        k = 1;
      }
      label572:
      if ((i1 == 0) || (n != 0) || (m != 0))
      {
        ((ax)neI.eEX()).encode(str1, ((com.tencent.mm.bx.b)localObject1).toByteArray());
        paramaoh = new StringBuilder("save manifest:").append(localaoc.Dpj).append('#').append(str1).append(", [");
        localObject1 = localaoc.Dpo;
        d.g.b.k.g(localObject1, "ResInfos");
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebPrefetcher", d.a.j.a((Iterable)localObject1, (CharSequence)"\n", null, null, 0, null, (d.g.a.b)n.nfN, 30) + ']');
      }
      for (;;)
      {
        localCollection.add(localaoc);
        break;
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebPrefetcher", "resp manifest:" + localaoc.Dpj + '#' + str1 + ", nothing changed");
      }
    }
    paramaoh = (List)localCollection;
    AppMethodBeat.o(193181);
    return paramaoh;
  }
  
  public static final void a(String arg0, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt)
  {
    AppMethodBeat.i(193178);
    d.g.b.k.h(???, "url");
    d.g.b.k.h(paramString2, "appId");
    d.g.b.k.h(paramString3, "title");
    d.g.b.k.h(paramString4, "desc");
    d.g.b.k.h(paramString5, "from");
    com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.WebPrefetcher", "preAuth: " + paramString3 + ' ' + ???);
    paramString4 = new a(???, paramString2, paramString3, paramString4, paramInt, null, 32);
    paramString2 = neQ;
    paramString3 = a.class.getCanonicalName() + '_' + "addToPreload";
    synchronized (by.EXM)
    {
      paramString5 = by.EXM;
      paramString5 = (bj)by.eGX().get(paramString3);
      if (paramString5 != null) {
        paramString5.fLu();
      }
      paramString5 = by.EXM;
      paramString5 = by.eGY();
      if (!paramString5.containsKey(paramString3)) {
        ((Map)paramString5).put(paramString3, new LinkedList());
      }
      paramString5 = paramString5.get(paramString3);
      if (paramString5 == null)
      {
        paramString2 = new d.v("null cannot be cast to non-null type java.util.LinkedList<T>");
        AppMethodBeat.o(193178);
        throw paramString2;
      }
    }
    ((LinkedList)paramString5).add(paramString4);
    ??? = by.EXM;
    ((Map)by.eGX()).put(paramString3, kotlinx.coroutines.d.a((kotlinx.coroutines.ad)bc.Kem, (d.d.f)at.fLg(), (m)new k(1000L, paramString3, null, paramString2), 2));
    AppMethodBeat.o(193178);
  }
  
  public static ar bDV()
  {
    return neI;
  }
  
  public static ar bDW()
  {
    return neJ;
  }
  
  public static ar bDX()
  {
    return neK;
  }
  
  public static u bDY()
  {
    return neL;
  }
  
  public static u bDZ()
  {
    return neM;
  }
  
  public static u bEa()
  {
    return neN;
  }
  
  public static al bEb()
  {
    return neO;
  }
  
  private static int bEc()
  {
    AppMethodBeat.i(175490);
    ax localax = ax.aFC("WebPrefetcher.currentScene");
    if (localax != null)
    {
      int i = localax.decodeInt("currentScene");
      AppMethodBeat.o(175490);
      return i;
    }
    AppMethodBeat.o(175490);
    return 0;
  }
  
  public static final void cn(List<? extends d.a> paramList)
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
      localCollection.add(new a(str2, paramList, (String)localObject1, (String)localObject2, locala.mSu, null, 32));
    }
    co((List)localCollection);
    AppMethodBeat.o(160497);
  }
  
  private static void co(List<a> paramList)
  {
    AppMethodBeat.i(193180);
    com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.WebPrefetcher", "[TRACE_PREFETCH] preAuths size = %s", new Object[] { Integer.valueOf(paramList.size()) });
    paramList = a(new aof(), paramList);
    if (paramList.Dpy.isEmpty())
    {
      com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.WebPrefetcher", "[TRACE_PREFETCH] preAuths: nothing to preauth");
      AppMethodBeat.o(193180);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder("[TRACE_PREFETCH] sendGetA8KeyLiteRequest batch req: ");
    LinkedList localLinkedList = paramList.Dpy;
    d.g.b.k.g(localLinkedList, "req.ReqInfo");
    com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.WebPrefetcher", d.a.j.a((Iterable)localLinkedList, (CharSequence)",", null, null, 0, null, (d.g.a.b)p.ngc, 30));
    com.tencent.mm.ad.c.b("MicroMsg.WebPrefetcher", (d.g.a.a)new q(paramList));
    AppMethodBeat.o(193180);
  }
  
  public static boolean cs(String paramString, int paramInt)
  {
    AppMethodBeat.i(175489);
    d.g.b.k.h(paramString, "url");
    boolean bool = ((ax)neP.eEX()).encode(b.Pu(paramString), paramInt);
    AppMethodBeat.o(175489);
    return bool;
  }
  
  public static d.b eo(String paramString1, String paramString2)
  {
    AppMethodBeat.i(193177);
    d.g.b.k.h(paramString1, "referer");
    d.g.b.k.h(paramString2, "url");
    paramString1 = new d(paramString2, b.ep(b.Pt(paramString1), paramString2), neM, neK).bEl();
    AppMethodBeat.o(193177);
    return paramString1;
  }
  
  public static boolean et(String paramString1, String paramString2)
  {
    AppMethodBeat.i(193185);
    String str = new d(paramString1, b.Pu(paramString1), neL, neJ).getLocation();
    if (!n.aC((CharSequence)str)) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramString1 = b.aC(str, true);
      com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.WebPrefetcher", "isWebUrlStorageEqual: location:#" + paramString1 + ", " + str);
      paramString2 = b.aC(paramString2, true);
      com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.WebPrefetcher", "isWebUrlStorageEqual: target:#".concat(String.valueOf(paramString2)));
      boolean bool = d.g.b.k.g(paramString1, paramString2);
      AppMethodBeat.o(193185);
      return bool;
    }
    AppMethodBeat.o(193185);
    return false;
  }
  
  public static void yi(int paramInt)
  {
    AppMethodBeat.i(175491);
    ax localax = ax.aFC("WebPrefetcher.currentScene");
    if (localax != null)
    {
      localax.encode("currentScene", paramInt);
      AppMethodBeat.o(175491);
      return;
    }
    AppMethodBeat.o(175491);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$BatchPreauth;", "", "url", "", "appId", "title", "desc", "scene", "", "refer", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getDesc", "getRefer", "getScene", "()I", "getTitle", "getUrl", "plugin-brandservice_release"})
  static final class a
  {
    final String appId;
    final String desc;
    final String neR;
    final int scene;
    final String title;
    final String url;
    
    private a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5)
    {
      AppMethodBeat.i(193106);
      this.url = paramString1;
      this.appId = paramString2;
      this.title = paramString3;
      this.desc = paramString4;
      this.scene = paramInt;
      this.neR = paramString5;
      AppMethodBeat.o(193106);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchAction;", "", "host", "", "rawUrl", "prefetchUrl", "checkCacheOnly", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getCheckCacheOnly", "()Z", "getHost", "()Ljava/lang/String;", "getPrefetchUrl", "getRawUrl", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "plugin-brandservice_release"})
  static final class b
  {
    final String dAl;
    final String host;
    final String neS;
    final boolean neT;
    
    public b(String paramString1, String paramString2, String paramString3)
    {
      AppMethodBeat.i(6771);
      this.host = paramString1;
      this.dAl = paramString2;
      this.neS = paramString3;
      this.neT = false;
      AppMethodBeat.o(6771);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(193110);
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if ((!d.g.b.k.g(this.host, paramObject.host)) || (!d.g.b.k.g(this.dAl, paramObject.dAl)) || (!d.g.b.k.g(this.neS, paramObject.neS)) || (this.neT != paramObject.neT)) {}
        }
      }
      else
      {
        AppMethodBeat.o(193110);
        return true;
      }
      AppMethodBeat.o(193110);
      return false;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(193108);
      String str = "PrefetchAction(host=" + this.host + ", rawUrl=" + this.dAl + ", prefetchUrl=" + this.neS + ", checkCacheOnly=" + this.neT + ")";
      AppMethodBeat.o(193108);
      return str;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchRes;", "", "url", "", "type", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchType;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchType;)V", "getType", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchType;", "getUrl", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-brandservice_release"})
  static final class c
  {
    final s.e neU;
    final String url;
    
    public c(String paramString, s.e parame)
    {
      AppMethodBeat.i(193111);
      this.url = paramString;
      this.neU = parame;
      AppMethodBeat.o(193111);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(193114);
      if (this != paramObject)
      {
        if ((paramObject instanceof c))
        {
          paramObject = (c)paramObject;
          if ((!d.g.b.k.g(this.url, paramObject.url)) || (!d.g.b.k.g(this.neU, paramObject.neU))) {}
        }
      }
      else
      {
        AppMethodBeat.o(193114);
        return true;
      }
      AppMethodBeat.o(193114);
      return false;
    }
    
    public final int hashCode()
    {
      int j = 0;
      AppMethodBeat.i(193113);
      Object localObject = this.url;
      if (localObject != null) {}
      for (int i = localObject.hashCode();; i = 0)
      {
        localObject = this.neU;
        if (localObject != null) {
          j = localObject.hashCode();
        }
        AppMethodBeat.o(193113);
        return i * 31 + j;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(193112);
      String str = "PrefetchRes(url=" + this.url + ", type=" + this.neU + ")";
      AppMethodBeat.o(193112);
      return str;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchTarget;", "", "url", "", "webId", "content", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcherFile;", "headerSlot", "Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcherFile;Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;)V", "bizId", "getBizId", "()Ljava/lang/String;", "bizId$delegate", "Lkotlin/Lazy;", "cacheTime", "", "getCacheTime", "()J", "cacheTime$delegate", "getContent", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcherFile;", "eTag", "getETag", "eTag$delegate", "fullUrl", "getFullUrl", "fullUrl$delegate", "getHeaderSlot", "()Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "headers", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getHeaders", "()Ljava/util/HashMap;", "headers$delegate", "isCached", "", "()Z", "isCached$delegate", "isRedirect", "isRedirect$delegate", "location", "getLocation", "location$delegate", "maxCache", "", "getMaxCache", "()I", "maxCache$delegate", "mimeType", "getMimeType", "mimeType$delegate", "prefetchHost", "getPrefetchHost", "prefetchHost$delegate", "prefetchUrl", "getPrefetchUrl", "prefetchUrl$delegate", "response", "Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService$PrefetchResponse;", "getResponse", "()Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService$PrefetchResponse;", "type", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchType;", "getType", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchType;", "type$delegate", "getUrl", "version", "getVersion", "version$delegate", "getWebId", "wxETag", "getWxETag", "wxETag$delegate", "createResponse", "refresh", "", "saveHeaders", "host", "plugin-brandservice_release"})
  static final class d
  {
    private final d.f neV;
    private final d.f neW;
    private final d.f neX;
    private final d.f neY;
    private final d.f neZ;
    private final d.f nfa;
    private final d.f nfb;
    private final d.f nfc;
    private final d.f nfd;
    private final d.f nfe;
    private final d.f nff;
    private final d.f nfg;
    private final d.f nfh;
    private final d.f nfi;
    private final d.f nfj;
    final String nfk;
    final u nfl;
    final ar nfm;
    final String url;
    
    static
    {
      AppMethodBeat.i(193134);
      $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new d.g.b.u(w.bk(d.class), "bizId", "getBizId()Ljava/lang/String;")), (d.l.k)w.a(new d.g.b.u(w.bk(d.class), "fullUrl", "getFullUrl()Ljava/lang/String;")), (d.l.k)w.a(new d.g.b.u(w.bk(d.class), "headers", "getHeaders()Ljava/util/HashMap;")), (d.l.k)w.a(new d.g.b.u(w.bk(d.class), "type", "getType()Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchType;")), (d.l.k)w.a(new d.g.b.u(w.bk(d.class), "location", "getLocation()Ljava/lang/String;")), (d.l.k)w.a(new d.g.b.u(w.bk(d.class), "version", "getVersion()J")), (d.l.k)w.a(new d.g.b.u(w.bk(d.class), "mimeType", "getMimeType()Ljava/lang/String;")), (d.l.k)w.a(new d.g.b.u(w.bk(d.class), "maxCache", "getMaxCache()I")), (d.l.k)w.a(new d.g.b.u(w.bk(d.class), "cacheTime", "getCacheTime()J")), (d.l.k)w.a(new d.g.b.u(w.bk(d.class), "wxETag", "getWxETag()Ljava/lang/String;")), (d.l.k)w.a(new d.g.b.u(w.bk(d.class), "eTag", "getETag()Ljava/lang/String;")), (d.l.k)w.a(new d.g.b.u(w.bk(d.class), "prefetchUrl", "getPrefetchUrl()Ljava/lang/String;")), (d.l.k)w.a(new d.g.b.u(w.bk(d.class), "prefetchHost", "getPrefetchHost()Ljava/lang/String;")), (d.l.k)w.a(new d.g.b.u(w.bk(d.class), "isRedirect", "isRedirect()Z")), (d.l.k)w.a(new d.g.b.u(w.bk(d.class), "isCached", "isCached()Z")) };
      AppMethodBeat.o(193134);
    }
    
    public d(String paramString1, String paramString2, u paramu, ar paramar)
    {
      AppMethodBeat.i(193149);
      this.url = paramString1;
      this.nfk = paramString2;
      this.nfl = paramu;
      this.nfm = paramar;
      this.neV = d.g.E((d.g.a.a)new a(this));
      this.neW = d.g.E((d.g.a.a)new d(this));
      this.neX = d.g.E((d.g.a.a)new e(this));
      this.neY = d.g.E((d.g.a.a)new m(this));
      this.neZ = d.g.E((d.g.a.a)new h(this));
      this.nfa = d.g.E((d.g.a.a)new n(this));
      this.nfb = d.g.E((d.g.a.a)new j(this));
      this.nfc = d.g.E((d.g.a.a)new i(this));
      this.nfd = d.g.E((d.g.a.a)new b(this));
      this.nfe = d.g.E((d.g.a.a)new o(this));
      this.nff = d.g.E((d.g.a.a)new c(this));
      this.nfg = d.g.E((d.g.a.a)new l(this));
      this.nfh = d.g.E((d.g.a.a)new k(this));
      this.nfi = d.g.E((d.g.a.a)new g(this));
      this.nfj = d.g.E((d.g.a.a)new f(this));
      AppMethodBeat.o(193149);
    }
    
    private s.e bEf()
    {
      AppMethodBeat.i(193137);
      s.e locale = (s.e)this.neY.getValue();
      AppMethodBeat.o(193137);
      return locale;
    }
    
    private final d.b bEm()
    {
      AppMethodBeat.i(193147);
      int i = bEe().size();
      boolean bool = this.nfl.contains(bEd());
      if ((i == 0) || (!bool))
      {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.WebPrefetcher", "createResponse fail headerSize:" + i + ", containsFile:" + bool);
        AppMethodBeat.o(193147);
        return null;
      }
      d.b localb = new d.b();
      localb.url = ((String)this.neW.getValue());
      localb.mSw = bEf().toString();
      localb.mSv = ((Number)this.nfa.getValue()).longValue();
      String str = (String)this.nfb.getValue();
      Object localObject1 = (Map)bEe();
      Map localMap = (Map)new LinkedHashMap(ae.adL(((Map)localObject1).size()));
      localObject1 = ((Iterable)((Map)localObject1).entrySet()).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject3 = ((Iterator)localObject1).next();
        Object localObject2 = ((Map.Entry)localObject3).getKey();
        localObject3 = (Map.Entry)localObject3;
        ((Map.Entry)localObject3).getKey();
        localMap.put(localObject2, (String)d.a.j.iy((List)((Map.Entry)localObject3).getValue()));
      }
      localb.mSx = new WebResourceResponse(str, "UTF-8", 200, "OK", localMap, com.tencent.mm.vfs.i.ah(this.nfl.PN(bEd())));
      AppMethodBeat.o(193147);
      return localb;
    }
    
    private boolean isRedirect()
    {
      AppMethodBeat.i(193143);
      boolean bool = ((Boolean)this.nfi.getValue()).booleanValue();
      AppMethodBeat.o(193143);
      return bool;
    }
    
    private void refresh()
    {
      AppMethodBeat.i(193145);
      if ((bEf() == s.e.nfq) && (bEh() > 0L) && (bEg() > 0) && (as.ad(bEh(), Math.max(bEg() - 60, 60))))
      {
        s locals = s.neQ;
        com.tencent.mm.plugin.webview.h.b.Tf(s.Pe(this.url));
        locals = s.neQ;
        s.es(this.url, (String)this.nfg.getValue());
      }
      AppMethodBeat.o(193145);
    }
    
    public final void a(s.e parame, String paramString)
    {
      AppMethodBeat.i(193148);
      d.g.b.k.h(parame, "type");
      d.g.b.k.h(paramString, "host");
      ((Map)bEe()).put("x-wx-client-cache-time", d.a.j.listOf(String.valueOf(System.currentTimeMillis())));
      ((Map)bEe()).put("x-wx-client-prefetch-url", d.a.j.listOf(this.url));
      if (!n.aC((CharSequence)paramString)) {}
      LinkedList localLinkedList;
      Collection localCollection;
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          ((Map)bEe()).put("x-wx-client-prefetch-host", d.a.j.listOf(paramString));
        }
        ((Map)bEe()).put("x-wx-client-prefetch-type", d.a.j.listOf(parame.toString()));
        paramString = new dsq();
        localLinkedList = paramString.EHe;
        Object localObject1 = (Map)bEe();
        localCollection = (Collection)new ArrayList(((Map)localObject1).size());
        localObject1 = ((Map)localObject1).entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
          String str = (String)((Map.Entry)localObject2).getKey();
          localObject2 = (List)((Map.Entry)localObject2).getValue();
          dsp localdsp = new dsp();
          localdsp.key = str;
          localdsp.DmV.addAll((Collection)localObject2);
          localCollection.add(localdsp);
        }
      }
      localLinkedList.addAll((Collection)localCollection);
      ((ax)this.nfm.eEX()).encode(bEd(), paramString.toByteArray());
      com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.WebPrefetcher", "saveHeaders @" + bEd() + ' ' + parame + ' ' + this.url);
      AppMethodBeat.o(193148);
    }
    
    public final String bEd()
    {
      AppMethodBeat.i(193135);
      String str = (String)this.neV.getValue();
      AppMethodBeat.o(193135);
      return str;
    }
    
    public final HashMap<String, List<String>> bEe()
    {
      AppMethodBeat.i(193136);
      HashMap localHashMap = (HashMap)this.neX.getValue();
      AppMethodBeat.o(193136);
      return localHashMap;
    }
    
    public final int bEg()
    {
      AppMethodBeat.i(193139);
      int i = ((Number)this.nfc.getValue()).intValue();
      AppMethodBeat.o(193139);
      return i;
    }
    
    public final long bEh()
    {
      AppMethodBeat.i(193140);
      long l = ((Number)this.nfd.getValue()).longValue();
      AppMethodBeat.o(193140);
      return l;
    }
    
    public final String bEi()
    {
      AppMethodBeat.i(193141);
      String str = (String)this.nfe.getValue();
      AppMethodBeat.o(193141);
      return str;
    }
    
    public final String bEj()
    {
      AppMethodBeat.i(193142);
      String str = (String)this.nff.getValue();
      AppMethodBeat.o(193142);
      return str;
    }
    
    public final boolean bEk()
    {
      AppMethodBeat.i(193144);
      boolean bool = ((Boolean)this.nfj.getValue()).booleanValue();
      AppMethodBeat.o(193144);
      return bool;
    }
    
    public final d.b bEl()
    {
      AppMethodBeat.i(193146);
      Object localObject1 = this;
      while (((d)localObject1).bEk())
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebPrefetcher", "fetch cached: #" + ((d)localObject1).nfk + ", " + ((d)localObject1).url);
        Object localObject2 = ((d)localObject1).bEf();
        switch (t.ciE[localObject2.ordinal()])
        {
        default: 
          localObject1 = ((d)localObject1).bEm();
          AppMethodBeat.o(193146);
          return localObject1;
        }
        Object localObject3;
        Object localObject4;
        if (((d)localObject1).isRedirect())
        {
          localObject2 = ((d)localObject1).getLocation();
          localObject1 = b.Pu(((d)localObject1).getLocation());
          localObject3 = s.neQ;
          localObject3 = s.bDY();
          localObject4 = s.neQ;
          localObject1 = new d((String)localObject2, (String)localObject1, (u)localObject3, s.bDW());
        }
        else
        {
          localObject2 = s.neQ;
          if (s.Pc(((d)localObject1).url))
          {
            if (!as.ad(((d)localObject1).bEh(), ((d)localObject1).bEg()))
            {
              localObject2 = (List)((d)localObject1).bEe().get("set-cookie");
              if (localObject2 != null)
              {
                localObject3 = com.tencent.xweb.c.fqC();
                localObject4 = ((d)localObject1).url;
                d.g.b.k.g(localObject2, "it");
                ((com.tencent.xweb.c)localObject3).setCookie((String)localObject4, d.a.j.a((Iterable)localObject2, (CharSequence)";", null, null, 0, null, null, 62));
              }
              localObject1 = ((d)localObject1).bEm();
              AppMethodBeat.o(193146);
              return localObject1;
            }
            com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.WebPrefetcher", "doc expired refresh cached: #" + ((d)localObject1).nfk + ", " + ((d)localObject1).url);
            ((d)localObject1).refresh();
            AppMethodBeat.o(193146);
            return null;
          }
          com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.WebPrefetcher", "preauth expired preauth: #" + ((d)localObject1).nfk + ", " + ((d)localObject1).url);
          s.PI(((d)localObject1).url);
          AppMethodBeat.o(193146);
          return null;
        }
      }
      AppMethodBeat.o(193146);
      return null;
    }
    
    public final String getLocation()
    {
      AppMethodBeat.i(193138);
      String str = (String)this.neZ.getValue();
      AppMethodBeat.o(193138);
      return str;
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
    static final class a
      extends d.g.b.l
      implements d.g.a.a<String>
    {
      a(s.d paramd)
      {
        super();
      }
      
      private String aTF()
      {
        AppMethodBeat.i(193117);
        Object localObject1 = j.ned;
        Object localObject3 = j.bDJ();
        localObject1 = this.nfn.nfk;
        localObject3 = (ax)((ar)localObject3).aFe((String)localObject1);
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
            localObject3 = dsr.class.newInstance();
            ((com.tencent.mm.bx.a)localObject3).parseFrom((byte[])localObject1);
            localObject1 = (com.tencent.mm.bx.a)localObject3;
            localObject1 = (dsr)localObject1;
            if (localObject1 != null)
            {
              localObject3 = ((dsr)localObject1).dnC;
              localObject1 = localObject3;
              if (localObject3 != null) {}
            }
            else
            {
              localObject1 = this.nfn.nfk;
            }
            AppMethodBeat.o(193117);
            return localObject1;
          }
          catch (Exception localException)
          {
            label129:
            com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", (Throwable)localException, "decode ProtoBuffer", new Object[0]);
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
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
    static final class b
      extends d.g.b.l
      implements d.g.a.a<Long>
    {
      b(s.d paramd)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
    static final class c
      extends d.g.b.l
      implements d.g.a.a<String>
    {
      c(s.d paramd)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
    static final class d
      extends d.g.b.l
      implements d.g.a.a<String>
    {
      d(s.d paramd)
      {
        super();
      }
      
      private String aTF()
      {
        AppMethodBeat.i(193121);
        Object localObject1 = j.ned;
        Object localObject3 = j.bDJ();
        localObject1 = this.nfn.nfk;
        localObject3 = (ax)((ar)localObject3).aFe((String)localObject1);
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
            localObject3 = dsr.class.newInstance();
            ((com.tencent.mm.bx.a)localObject3).parseFrom((byte[])localObject1);
            localObject1 = (com.tencent.mm.bx.a)localObject3;
            localObject1 = (dsr)localObject1;
            if (localObject1 != null)
            {
              localObject3 = ((dsr)localObject1).nha;
              localObject1 = localObject3;
              if (localObject3 != null) {}
            }
            else
            {
              localObject1 = this.nfn.url;
            }
            AppMethodBeat.o(193121);
            return localObject1;
          }
          catch (Exception localException)
          {
            label129:
            com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", (Throwable)localException, "decode ProtoBuffer", new Object[0]);
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
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "invoke"})
    static final class e
      extends d.g.b.l
      implements d.g.a.a<HashMap<String, List<? extends String>>>
    {
      e(s.d paramd)
      {
        super();
      }
      
      private HashMap<String, List<String>> bEn()
      {
        AppMethodBeat.i(193123);
        Object localObject2 = this.nfn.nfm;
        Object localObject1 = this.nfn.bEd();
        localObject2 = (ax)((ar)localObject2).aFe((String)localObject1);
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
            localObject2 = dsq.class.newInstance();
            ((com.tencent.mm.bx.a)localObject2).parseFrom((byte[])localObject1);
            localObject1 = (com.tencent.mm.bx.a)localObject2;
            localObject2 = (dsq)localObject1;
            localObject1 = new HashMap();
            if (localObject2 == null) {
              break label201;
            }
            localObject2 = ((dsq)localObject2).EHe;
            d.g.b.k.g(localObject2, "it.header");
            localObject2 = ((Iterable)localObject2).iterator();
            if (!((Iterator)localObject2).hasNext()) {
              break label201;
            }
            dsp localdsp = (dsp)((Iterator)localObject2).next();
            ((HashMap)localObject1).put(localdsp.key, localdsp.DmV);
            continue;
            i = 0;
          }
          catch (Exception localException)
          {
            com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", (Throwable)localException, "decode ProtoBuffer", new Object[0]);
          }
          i = 0;
          break label65;
          localHashMap = null;
          continue;
          localHashMap = null;
        }
        label201:
        AppMethodBeat.o(193123);
        return localHashMap;
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
    static final class f
      extends d.g.b.l
      implements d.g.a.a<Boolean>
    {
      f(s.d paramd)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
    static final class g
      extends d.g.b.l
      implements d.g.a.a<Boolean>
    {
      g(s.d paramd)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
    static final class h
      extends d.g.b.l
      implements d.g.a.a<String>
    {
      h(s.d paramd)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
    static final class i
      extends d.g.b.l
      implements d.g.a.a<Integer>
    {
      i(s.d paramd)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
    static final class j
      extends d.g.b.l
      implements d.g.a.a<String>
    {
      j(s.d paramd)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
    static final class k
      extends d.g.b.l
      implements d.g.a.a<String>
    {
      k(s.d paramd)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
    static final class l
      extends d.g.b.l
      implements d.g.a.a<String>
    {
      l(s.d paramd)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchType;", "invoke"})
    static final class m
      extends d.g.b.l
      implements d.g.a.a<s.e>
    {
      m(s.d paramd)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
    static final class n
      extends d.g.b.l
      implements d.g.a.a<Long>
    {
      n(s.d paramd)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
    static final class o
      extends d.g.b.l
      implements d.g.a.a<String>
    {
      o(s.d paramd)
      {
        super();
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchType;", "", "type", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "toString", "JS", "CSS", "HTML", "plugin-brandservice_release"})
  static enum e
  {
    private final String type;
    
    static
    {
      AppMethodBeat.i(193150);
      e locale1 = new e("JS", 0, "JS");
      nfo = locale1;
      e locale2 = new e("CSS", 1, "CSS");
      nfp = locale2;
      e locale3 = new e("HTML", 2, "HTML");
      nfq = locale3;
      nfr = new e[] { locale1, locale2, locale3 };
      AppMethodBeat.o(193150);
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
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$connect$2$1", "Lcom/tencent/mars/cdn/CronetLogic$CronetTaskCallback;", "onCronetReceiveHeader", "", "header", "Lcom/tencent/mars/cdn/CronetLogic$ResponseHeader;", "status_code", "onCronetTaskCompleted", "", "filekey", "", "result", "Lcom/tencent/mars/cdn/CronetLogic$CronetTaskResult;", "onDownloadProgressChanged", "progress", "Lcom/tencent/mars/cdn/CronetLogic$CronetDownloadProgress;", "plugin-brandservice_release"})
  public static final class f
    implements CronetLogic.CronetTaskCallback
  {
    f(x paramx, String paramString, e parame, d.g.a.b paramb1, d.g.a.b paramb2) {}
    
    public final int onCronetReceiveHeader(CronetLogic.ResponseHeader paramResponseHeader, int paramInt)
    {
      AppMethodBeat.i(193154);
      if (((Boolean)this.nfv.aA(Integer.valueOf(paramInt))).booleanValue())
      {
        AppMethodBeat.o(193154);
        return 0;
      }
      paramResponseHeader = this.nfw;
      if (paramResponseHeader != null) {
        paramResponseHeader.aA(Boolean.FALSE);
      }
      AppMethodBeat.o(193154);
      return -99;
    }
    
    public final void onCronetTaskCompleted(String paramString, CronetLogic.CronetTaskResult paramCronetTaskResult)
    {
      AppMethodBeat.i(193153);
      if (paramCronetTaskResult != null) {
        switch (paramCronetTaskResult.statusCode)
        {
        }
      }
      for (;;)
      {
        paramString = new e(this.nfs.aEV());
        if (paramString.exists()) {
          paramString.delete();
        }
        paramString = this.nfw;
        if (paramString == null) {
          break;
        }
        paramString.aA(Boolean.valueOf(com.tencent.mm.vfs.i.eK(this.nft)));
        AppMethodBeat.o(193153);
        return;
        if (com.tencent.mm.vfs.i.lD(this.nfs.aEV(), this.nft))
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebPrefetcher", "save file:" + this.nfs.getURL() + " to " + this.nft);
        }
        else
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.WebPrefetcher", "save conn failed:" + this.nfs.getURL() + " to " + this.nfs.aEV());
          continue;
          this.nfv.aA(Integer.valueOf(paramCronetTaskResult.statusCode));
        }
      }
      AppMethodBeat.o(193153);
    }
    
    public final void onDownloadProgressChanged(String paramString, CronetLogic.CronetDownloadProgress paramCronetDownloadProgress) {}
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "", "invoke"})
  static final class g
    extends d.g.b.l
    implements d.g.a.b<Integer, Boolean>
  {
    public static final g nfx;
    
    static
    {
      AppMethodBeat.i(193156);
      nfx = new g();
      AppMethodBeat.o(193156);
    }
    
    g()
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/network/MMHttpUrlCronetConnection;", "conn", "invoke"})
  static final class h
    extends d.g.b.l
    implements d.g.a.b<x, x>
  {
    h(s.d paramd, String paramString1, String paramString2)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/network/MMHttpUrlCronetConnection;", "conn", "invoke", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$fetchManifest$2$1"})
  static final class i
    extends d.g.b.l
    implements d.g.a.b<x, x>
  {
    i(String paramString, d.d.d paramd, i parami)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/network/MMHttpUrlCronetConnection;", "conn", "invoke", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$fetchRes$1$1"})
  static final class j
    extends d.g.b.l
    implements d.g.a.b<x, x>
  {
    j(String paramString1, s.c paramc, String paramString2)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/mm/sdk/platformtools/MMBatchRunKt$batchRun$2"})
  public static final class k
    extends d.d.b.a.j
    implements m<kotlinx.coroutines.ad, d.d.d<? super y>, Object>
  {
    int label;
    private kotlinx.coroutines.ad mTa;
    Object mTb;
    
    public k(long paramLong, String paramString, d.d.d paramd, s params)
    {
      super();
    }
    
    public final d.d.d<y> a(Object paramObject, d.d.d<?> paramd)
    {
      AppMethodBeat.i(6785);
      d.g.b.k.h(paramd, "completion");
      paramd = new k(this.nef, this.jCN, paramd, this.nfL);
      paramd.mTa = ((kotlinx.coroutines.ad)paramObject);
      AppMethodBeat.o(6785);
      return paramd;
    }
    
    public final Object cP(Object paramObject)
    {
      AppMethodBeat.i(6784);
      paramObject = d.d.a.a.JgJ;
      Object localObject;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(6784);
        throw paramObject;
      case 0: 
        localObject = this.mTa;
        long l = this.nef;
        this.mTb = localObject;
        this.label = 1;
        if (ao.a(l, this) == paramObject)
        {
          AppMethodBeat.o(6784);
          return paramObject;
        }
        break;
      }
      synchronized (by.EXM)
      {
        paramObject = by.EXM;
        localObject = by.eGY().get(this.jCN);
        paramObject = localObject;
        if (!(localObject instanceof Queue)) {
          paramObject = null;
        }
        paramObject = (Queue)paramObject;
        if (paramObject != null)
        {
          localObject = by.EXM;
          by.eGY().remove(this.jCN);
          paramObject = new ArrayList((Collection)paramObject);
          if (paramObject != null) {
            s.cp((List)paramObject);
          }
          paramObject = by.EXM;
          by.eGX().remove(this.jCN);
          paramObject = y.JfV;
          AppMethodBeat.o(6784);
          return paramObject;
        }
        paramObject = null;
      }
    }
    
    public final Object n(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(6786);
      paramObject1 = ((k)a(paramObject1, (d.d.d)paramObject2)).cP(y.JfV);
      AppMethodBeat.o(6786);
      return paramObject1;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class l
    implements Runnable
  {
    l(List paramList) {}
    
    public final void run()
    {
      AppMethodBeat.i(193166);
      LinkedList localLinkedList = new LinkedList();
      Iterator localIterator = ((Iterable)this.nfM).iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        try
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebPrefetcher", "pre dns:".concat(String.valueOf(InetAddress.getByName(str))));
          c.a locala = com.tencent.mm.plugin.brandservice.c.mRZ;
          com.tencent.mm.plugin.brandservice.c.bBY().xe(str);
          localLinkedList.add(str);
        }
        catch (Exception localException)
        {
          com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.WebPrefetcher", (Throwable)localException, "pre dns err:".concat(String.valueOf(str)), new Object[0]);
        }
      }
      com.tencent.mm.plugin.webview.h.b.Td(localLinkedList.size());
      AppMethodBeat.o(193166);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/mm/sdk/platformtools/MMBatchRunKt$batchRun$2"})
  public static final class m
    extends d.d.b.a.j
    implements m<kotlinx.coroutines.ad, d.d.d<? super y>, Object>
  {
    int label;
    private kotlinx.coroutines.ad mTa;
    Object mTb;
    
    public m(long paramLong, String paramString, d.d.d paramd)
    {
      super();
    }
    
    public final d.d.d<y> a(Object paramObject, d.d.d<?> paramd)
    {
      AppMethodBeat.i(6796);
      d.g.b.k.h(paramd, "completion");
      paramd = new m(this.nef, this.jCN, paramd);
      paramd.mTa = ((kotlinx.coroutines.ad)paramObject);
      AppMethodBeat.o(6796);
      return paramd;
    }
    
    public final Object cP(Object paramObject)
    {
      AppMethodBeat.i(6795);
      paramObject = d.d.a.a.JgJ;
      Object localObject1;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(6795);
        throw paramObject;
      case 0: 
        localObject1 = this.mTa;
        long l = this.nef;
        this.mTb = localObject1;
        this.label = 1;
        if (ao.a(l, this) == paramObject)
        {
          AppMethodBeat.o(6795);
          return paramObject;
        }
        break;
      }
      for (;;)
      {
        synchronized (by.EXM)
        {
          paramObject = by.EXM;
          localObject1 = by.eGY().get(this.jCN);
          paramObject = localObject1;
          if (!(localObject1 instanceof Queue)) {
            paramObject = null;
          }
          paramObject = (Queue)paramObject;
          if (paramObject != null)
          {
            localObject1 = by.EXM;
            by.eGY().remove(this.jCN);
            paramObject = new ArrayList((Collection)paramObject);
            if (paramObject == null) {
              break;
            }
            paramObject = ((Iterable)paramObject).iterator();
            if (!paramObject.hasNext()) {
              break;
            }
            localObject1 = (s.b)paramObject.next();
            ??? = ((s.b)localObject1).dAl;
            localObject3 = b.Pu(((s.b)localObject1).dAl);
            Object localObject4 = s.neQ;
            localObject4 = s.bDY();
            s locals = s.neQ;
            ??? = new s.d((String)???, (String)localObject3, (u)localObject4, s.bDW());
            if (((s.d)???).bEk())
            {
              if (((s.b)localObject1).neT) {
                continue;
              }
              int i = Math.max(((s.d)???).bEg() - 60, 60);
              if ((((s.d)???).bEh() <= 0L) || (!as.ad(((s.d)???).bEh(), i))) {
                continue;
              }
              localObject3 = s.neQ;
              s.a(((s.b)localObject1).neS, ((s.b)localObject1).host, (s.d)???);
              continue;
            }
          }
          else
          {
            paramObject = null;
          }
        }
        Object localObject3 = s.neQ;
        s.a(((s.b)localObject1).neS, ((s.b)localObject1).host, (s.d)???);
      }
      paramObject = by.EXM;
      by.eGX().remove(this.jCN);
      paramObject = y.JfV;
      AppMethodBeat.o(6795);
      return paramObject;
    }
    
    public final Object n(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(6797);
      paramObject1 = ((m)a(paramObject1, (d.d.d)paramObject2)).cP(y.JfV);
      AppMethodBeat.o(6797);
      return paramObject1;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyLitePrefetchResInfo;", "kotlin.jvm.PlatformType", "invoke"})
  static final class n
    extends d.g.b.l
    implements d.g.a.b<aod, String>
  {
    public static final n nfN;
    
    static
    {
      AppMethodBeat.i(193168);
      nfN = new n();
      AppMethodBeat.o(193168);
    }
    
    n()
    {
      super();
    }
  }
  
  @d.d.b.a.f(c="com.tencent.mm.plugin.brandservice.ui.timeline.preload.WebPrefetcher$savePrefetch$1", f="WebPrefetcher.kt", l={724, 724, 738}, m="invokeSuspend")
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class o
    extends d.d.b.a.j
    implements m<kotlinx.coroutines.ad, d.d.d<? super y>, Object>
  {
    int label;
    private kotlinx.coroutines.ad mTa;
    Object mTb;
    Object nfO;
    Object nfP;
    Object nfQ;
    Object nfR;
    Object nfS;
    Object nfT;
    Object nfU;
    Object nfV;
    Object nfW;
    int nfX;
    int nfY;
    
    o(aoh paramaoh, aof paramaof, List paramList, d.d.d paramd)
    {
      super();
    }
    
    public final d.d.d<y> a(Object paramObject, d.d.d<?> paramd)
    {
      AppMethodBeat.i(193170);
      d.g.b.k.h(paramd, "completion");
      paramd = new o(this.nfZ, this.nga, this.ngb, paramd);
      paramd.mTa = ((kotlinx.coroutines.ad)paramObject);
      AppMethodBeat.o(193170);
      return paramd;
    }
    
    public final Object cP(Object paramObject)
    {
      AppMethodBeat.i(193169);
      d.d.a.a locala = d.d.a.a.JgJ;
      Object localObject5;
      Object localObject2;
      Object localObject3;
      Object localObject4;
      Object localObject1;
      int i;
      int j;
      Object localObject6;
      Object localObject7;
      String str;
      Object localObject8;
      Object localObject10;
      Object localObject9;
      Object localObject11;
      label611:
      int k;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(193169);
        throw paramObject;
      case 0: 
        localObject5 = this.mTa;
        localObject2 = new LinkedList();
        localObject3 = new v.a();
        ((v.a)localObject3).Jhs = false;
        localObject4 = new v.a();
        ((v.a)localObject4).Jhs = false;
        paramObject = new HashMap();
        localObject1 = new HashMap();
        i = 0;
        j = this.nfZ.CEJ;
        if (i < j)
        {
          localObject6 = new dsr();
          ((v.a)localObject3).Jhs = false;
          ((v.a)localObject4).Jhs = false;
          ((dsr)localObject6).url = ((aoe)this.nga.Dpy.get(i)).Dps;
          ((dsr)localObject6).nha = ((aog)this.nfZ.DpI.get(i)).DpA;
          localObject7 = ((dsr)localObject6).url;
          d.g.b.k.g(localObject7, "url");
          str = b.Pu((String)localObject7);
          localObject7 = ((dsr)localObject6).nha;
          d.g.b.k.g(localObject7, "fullUrl");
          if (!n.mA((String)localObject7, "http")) {
            break label2252;
          }
          ((dsr)localObject6).hAg = System.currentTimeMillis();
          localObject7 = (Integer)this.nfZ.DpH.get(i);
          if (localObject7 == null) {
            ((dsr)localObject6).EHf = true;
          }
          for (;;)
          {
            if (!((dsr)localObject6).EHf)
            {
              ((LinkedList)localObject2).add(((dsr)localObject6).nha);
              ((v.a)localObject4).Jhs = true;
            }
            localObject7 = s.neQ;
            localObject7 = ((dsr)localObject6).nha;
            d.g.b.k.g(localObject7, "fullUrl");
            localObject8 = s.n((String)localObject7, this.ngb);
            if (localObject8 == null) {
              break label1634;
            }
            com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.WebPrefetcher", "match prefetch#".concat(String.valueOf(str)));
            localObject7 = s.neQ;
            this.mTb = localObject5;
            this.nfO = localObject2;
            this.nfP = localObject3;
            this.nfQ = localObject4;
            this.nfR = paramObject;
            this.nfS = localObject1;
            this.nfX = i;
            this.nfY = j;
            this.nfT = localObject6;
            this.nfU = localObject6;
            this.nfV = str;
            this.nfW = localObject8;
            this.label = 1;
            localObject10 = s.a((i)localObject8, this);
            if (localObject10 != locala) {
              break label2215;
            }
            AppMethodBeat.o(193169);
            return locala;
            if (((Integer)localObject7).intValue() != 0) {
              break;
            }
            if (((aog)this.nfZ.DpI.get(i)).DpF != 0) {
              ((dsr)localObject6).EHg = true;
            }
          }
        }
        break;
      case 1: 
        localObject8 = (i)this.nfW;
        localObject10 = (String)this.nfV;
        localObject1 = (dsr)this.nfU;
        localObject9 = (dsr)this.nfT;
        j = this.nfY;
        i = this.nfX;
        localObject6 = (HashMap)this.nfS;
        localObject2 = (HashMap)this.nfR;
        localObject4 = (v.a)this.nfQ;
        localObject3 = (v.a)this.nfP;
        localObject7 = (LinkedList)this.nfO;
        localObject11 = (kotlinx.coroutines.ad)this.mTb;
        localObject5 = paramObject;
        paramObject = localObject10;
        localObject10 = localObject5;
        localObject5 = localObject11;
        if (((Boolean)localObject10).booleanValue())
        {
          localObject10 = v.ngi;
          localObject11 = ((dsr)localObject1).nha;
          d.g.b.k.g(localObject11, "fullUrl");
          this.mTb = localObject5;
          this.nfO = localObject7;
          this.nfP = localObject3;
          this.nfQ = localObject4;
          this.nfR = localObject2;
          this.nfS = localObject6;
          this.nfX = i;
          this.nfY = j;
          this.nfT = localObject9;
          this.nfU = localObject1;
          this.nfV = paramObject;
          this.nfW = localObject8;
          this.label = 2;
          localObject10 = ((v)localObject10).a((String)localObject11, (i)localObject8, this);
          if (localObject10 == locala)
          {
            AppMethodBeat.o(193169);
            return locala;
          }
        }
        break;
      case 2: 
        localObject8 = (i)this.nfW;
        localObject10 = (String)this.nfV;
        localObject1 = (dsr)this.nfU;
        localObject9 = (dsr)this.nfT;
        j = this.nfY;
        i = this.nfX;
        localObject11 = (HashMap)this.nfS;
        localObject2 = (HashMap)this.nfR;
        localObject4 = (v.a)this.nfQ;
        localObject3 = (v.a)this.nfP;
        localObject7 = (LinkedList)this.nfO;
        localObject5 = (kotlinx.coroutines.ad)this.mTb;
        localObject6 = paramObject;
        paramObject = localObject10;
        localObject10 = localObject6;
        localObject6 = localObject11;
        if (((Boolean)localObject10).booleanValue())
        {
          ((dsr)localObject1).neS = ((dsr)localObject1).nha;
          localObject10 = g.ndS;
          if (h.buO().getBoolean("tencent_view_inews_prefix", false))
          {
            localObject10 = ((dsr)localObject1).neS;
            d.g.b.k.g(localObject10, "prefetchUrl");
            ((dsr)localObject1).neS = n.bb((String)localObject10, "//view.inews.qq.com", "//ssr.view.inews.qq.com");
          }
          ((dsr)localObject1).EHh = true;
          localObject10 = s.neQ;
          s.a((dsr)localObject1);
          localObject10 = s.neQ;
          localObject10 = ((dsr)localObject1).url;
          d.g.b.k.g(localObject10, "url");
          localObject11 = ((dsr)localObject1).neS;
          d.g.b.k.g(localObject11, "prefetchUrl");
          s.es((String)localObject10, (String)localObject11);
          ((v.a)localObject3).Jhs = true;
          localObject10 = v.ngi;
          this.mTb = localObject5;
          this.nfO = localObject7;
          this.nfP = localObject3;
          this.nfQ = localObject4;
          this.nfR = localObject2;
          this.nfS = localObject6;
          this.nfX = i;
          this.nfY = j;
          this.nfT = localObject9;
          this.nfU = localObject1;
          this.nfV = paramObject;
          this.nfW = localObject8;
          this.label = 3;
          localObject10 = ((v)localObject10).b((i)localObject8, this);
          if (localObject10 != locala) {
            break label2176;
          }
          AppMethodBeat.o(193169);
          return locala;
        }
        break;
      case 3: 
        localObject8 = (i)this.nfW;
        localObject9 = (String)this.nfV;
        localObject1 = (dsr)this.nfU;
        k = this.nfY;
        i = this.nfX;
        localObject7 = (HashMap)this.nfS;
        localObject2 = (HashMap)this.nfR;
        localObject4 = (v.a)this.nfQ;
        localObject3 = (v.a)this.nfP;
        localObject10 = (LinkedList)this.nfO;
        localObject5 = (kotlinx.coroutines.ad)this.mTb;
        localObject6 = paramObject;
        paramObject = localObject9;
        localObject9 = localObject6;
        localObject6 = localObject10;
        label1199:
        localObject10 = (Iterable)localObject9;
        localObject9 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject10, 10));
        localObject10 = ((Iterable)localObject10).iterator();
        while (((Iterator)localObject10).hasNext()) {
          ((Collection)localObject9).add(new s.c((String)((Iterator)localObject10).next(), s.e.nfo));
        }
        localObject9 = (List)localObject9;
        localObject10 = s.neQ;
        localObject8 = ((i)localObject8).ndT.Dpj;
        d.g.b.k.g(localObject8, "manifest.domain.Domain");
        s.g((List)localObject9, (String)localObject8);
        com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.WebPrefetcher", "end prefetch #" + paramObject + ' ' + ((dsr)localObject1).neS);
        paramObject = localObject7;
        localObject7 = localObject2;
        localObject2 = localObject6;
        j = i;
        i = k;
        localObject6 = localObject1;
        localObject1 = localObject7;
        label1371:
        localObject7 = s.neQ;
        if ((Integer)paramObject.get(Integer.valueOf(s.Pe(((dsr)localObject6).url))) == null)
        {
          localObject7 = (Map)paramObject;
          localObject8 = s.neQ;
          ((Map)localObject7).put(Integer.valueOf(s.Pe(((dsr)localObject6).url)), Integer.valueOf(1));
          label1431:
          localObject7 = ((dsr)localObject6).url;
          d.g.b.k.g(localObject7, "url");
          com.tencent.mm.plugin.webview.h.b.a(0, (String)localObject7, false, false, true, ((v.a)localObject4).Jhs, ((v.a)localObject3).Jhs, true);
          localObject7 = s.neQ;
          if ((Integer)((HashMap)localObject1).get(Integer.valueOf(s.Pe(((dsr)localObject6).url))) != null) {
            break label1745;
          }
          localObject7 = (Map)localObject1;
          localObject8 = s.neQ;
          ((Map)localObject7).put(Integer.valueOf(s.Pe(((dsr)localObject6).url)), Integer.valueOf(1));
        }
        break;
      }
      for (;;)
      {
        label1527:
        localObject6 = y.JfV;
        k = j + 1;
        localObject6 = paramObject;
        paramObject = localObject1;
        localObject1 = localObject6;
        j = i;
        i = k;
        break;
        localObject8 = localObject7;
        k = i;
        localObject7 = localObject1;
        for (;;)
        {
          localObject1 = s.neQ;
          s.a((dsr)localObject7);
          com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.WebPrefetcher", "fail to prefetch #" + paramObject + ' ' + ((dsr)localObject7).url);
          paramObject = localObject6;
          localObject1 = localObject2;
          localObject2 = localObject8;
          localObject6 = localObject7;
          i = j;
          j = k;
          break label1371;
          label1634:
          localObject7 = s.neQ;
          s.a((dsr)localObject6);
          k = i;
          localObject7 = paramObject;
          paramObject = localObject1;
          localObject1 = localObject7;
          i = j;
          j = k;
          break label1371;
          localObject7 = (Map)paramObject;
          localObject8 = s.neQ;
          k = s.Pe(((dsr)localObject6).url);
          localObject8 = s.neQ;
          localObject8 = paramObject.get(Integer.valueOf(s.Pe(((dsr)localObject6).url)));
          if (localObject8 == null) {
            d.g.b.k.fvU();
          }
          ((Map)localObject7).put(Integer.valueOf(k), Integer.valueOf(((Number)localObject8).intValue() + 1));
          break label1431;
          label1745:
          localObject7 = (Map)localObject1;
          localObject8 = s.neQ;
          k = s.Pe(((dsr)localObject6).url);
          localObject8 = s.neQ;
          localObject6 = ((HashMap)localObject1).get(Integer.valueOf(s.Pe(((dsr)localObject6).url)));
          if (localObject6 == null) {
            d.g.b.k.fvU();
          }
          ((Map)localObject7).put(Integer.valueOf(k), Integer.valueOf(((Number)localObject6).intValue() + 1));
          break label1527;
          if (!((Collection)localObject2).isEmpty()) {}
          for (i = 1;; i = 0)
          {
            if (i != 0)
            {
              localObject3 = s.neQ;
              s.cq((List)localObject2);
            }
            com.tencent.mm.plugin.webview.h.b.Tc(this.nfZ.CEJ);
            localObject3 = (Map)paramObject;
            localObject2 = (Collection)new ArrayList(((Map)localObject3).size());
            localObject3 = ((Map)localObject3).entrySet().iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject4 = (Map.Entry)((Iterator)localObject3).next();
              i = ((Number)((Map.Entry)localObject4).getKey()).intValue();
              com.tencent.mm.plugin.webview.h.b.iw(((Number)((Map.Entry)localObject4).getValue()).intValue(), i);
              ((Collection)localObject2).add(y.JfV);
            }
          }
          localObject2 = (Map)localObject1;
          localObject1 = (Collection)new ArrayList(((Map)localObject2).size());
          localObject2 = ((Map)localObject2).entrySet().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (Map.Entry)((Iterator)localObject2).next();
            i = ((Number)((Map.Entry)localObject3).getKey()).intValue();
            j = ((Number)((Map.Entry)localObject3).getValue()).intValue();
            com.tencent.mm.plugin.webview.h.b.ix(j, i);
            if (paramObject.get(Integer.valueOf(i)) != null)
            {
              localObject3 = paramObject.get(Integer.valueOf(i));
              if (localObject3 == null) {
                d.g.b.k.fvU();
              }
              if (d.g.b.k.compare(((Number)localObject3).intValue(), j) > 0)
              {
                localObject3 = paramObject.get(Integer.valueOf(i));
                if (localObject3 == null) {
                  d.g.b.k.fvU();
                }
                com.tencent.mm.plugin.webview.h.b.iy(((Number)localObject3).intValue() - j, i);
              }
            }
            ((Collection)localObject1).add(y.JfV);
          }
          paramObject = y.JfV;
          AppMethodBeat.o(193169);
          return paramObject;
          label2176:
          localObject9 = localObject7;
          localObject7 = localObject6;
          localObject6 = localObject9;
          localObject9 = localObject10;
          k = j;
          break label1199;
          break;
          localObject8 = localObject7;
          localObject7 = localObject1;
          k = i;
        }
        label2215:
        localObject9 = localObject6;
        localObject11 = localObject6;
        Object localObject12 = paramObject;
        localObject6 = localObject1;
        localObject7 = localObject2;
        paramObject = str;
        localObject1 = localObject9;
        localObject9 = localObject11;
        localObject2 = localObject12;
        break label611;
        label2252:
        k = i;
        localObject6 = paramObject;
        paramObject = localObject1;
        localObject1 = localObject6;
        i = j;
        j = k;
      }
    }
    
    public final Object n(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(193171);
      paramObject1 = ((o)a(paramObject1, (d.d.d)paramObject2)).cP(y.JfV);
      AppMethodBeat.o(193171);
      return paramObject1;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "kotlin.jvm.PlatformType", "it", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyLiteReqInfo;", "invoke"})
  static final class p
    extends d.g.b.l
    implements d.g.a.b<aoe, String>
  {
    public static final p ngc;
    
    static
    {
      AppMethodBeat.i(160493);
      ngc = new p();
      AppMethodBeat.o(160493);
    }
    
    p()
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class q
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    q(aof paramaof)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.s
 * JD-Core Version:    0.7.0.1
 */