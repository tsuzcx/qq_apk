package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import android.net.Uri;
import com.tencent.mars.cdn.CronetLogic;
import com.tencent.mars.cdn.CronetLogic.CronetDownloadProgress;
import com.tencent.mars.cdn.CronetLogic.CronetTaskCallback;
import com.tencent.mars.cdn.CronetLogic.CronetTaskResult;
import com.tencent.mars.cdn.CronetLogic.ResponseHeader;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.network.z;
import com.tencent.mm.plugin.ad.c.a;
import com.tencent.mm.plugin.brandservice.a.e.a;
import com.tencent.mm.plugin.brandservice.a.e.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.webview.core.g.a;
import com.tencent.mm.protocal.protobuf.bhb;
import com.tencent.mm.protocal.protobuf.bhc;
import com.tencent.mm.protocal.protobuf.bhd;
import com.tencent.mm.protocal.protobuf.bhe;
import com.tencent.mm.protocal.protobuf.bhf;
import com.tencent.mm.protocal.protobuf.bhg;
import com.tencent.mm.protocal.protobuf.bhh;
import com.tencent.mm.protocal.protobuf.ccc;
import com.tencent.mm.protocal.protobuf.fai;
import com.tencent.mm.protocal.protobuf.faj;
import com.tencent.mm.protocal.protobuf.fak;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMCacheSlotManager;
import com.tencent.mm.sdk.platformtools.MMKVSlotManager;
import com.tencent.mm.sdk.platformtools.MMSlotKt;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.__BATCH_RUN_OBJ;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.xweb.WebResourceResponse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.List<+Lcom.tencent.mm.plugin.brandservice.a.e.a;>;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import kotlin.ResultKt;
import kotlin.a.ae;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z.a;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;
import kotlinx.coroutines.ai;
import kotlinx.coroutines.aj;
import kotlinx.coroutines.au;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.bn;
import kotlinx.coroutines.bu;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher;", "", "()V", "MIN_EXPIRE_SECONDS", "", "PRE_AUTH_EXPIRE_SECONDS", "REFRESH_BEFORE_EXPIRE_SECONDS", "value", "currentScene", "getCurrentScene", "()I", "setCurrentScene", "(I)V", "preauthRequestLimiter", "Lcom/tencent/mm/sdk/platformtools/MMCacheSlotManager;", "getPreauthRequestLimiter$plugin_brandservice_release", "()Lcom/tencent/mm/sdk/platformtools/MMCacheSlotManager;", "prefetchInfoManager", "Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "getPrefetchInfoManager$plugin_brandservice_release", "()Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "prefetchTestMode", "", "getPrefetchTestMode", "()Z", "prefetchTestMode$delegate", "Lkotlin/Lazy;", "resHeadersManager", "getResHeadersManager$plugin_brandservice_release", "sendingGetA8keyLiteQueue", "Ljava/util/concurrent/ConcurrentSkipListSet;", "", "settingManager", "getSettingManager$plugin_brandservice_release", "userAgentInfo", "Lcom/tencent/mm/plugin/webview/util/WebPrefetchUserAgentInfo;", "getUserAgentInfo", "()Lcom/tencent/mm/plugin/webview/util/WebPrefetchUserAgentInfo;", "userAgentInfo$delegate", "webHeadersManager", "getWebHeadersManager$plugin_brandservice_release", "webIdToSceneManager", "getWebIdToSceneManager$plugin_brandservice_release", "clearPrefetchContent", "", "url", "debugPreloadWebInfo", "", "(Ljava/lang/String;)[[Ljava/lang/String;", "fetchContent", "Lcom/tencent/mm/network/MMHttpUrlCronetConnection;", "host", "target", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchTarget;", "deep", "prefetchHeaders", "", "fetchManifest", "manifest", "Lcom/tencent/mm/plugin/webprefetcher/PrefetchManifest;", "(Lcom/tencent/mm/plugin/webprefetcher/PrefetchManifest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchRes", "batchRes", "", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchRes;", "getPreAuthUrl", "getPrefetchContentResp", "Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService$PrefetchResponse;", "getPrefetchResResp", "referer", "appId", "getReportScene", "getRespUrl", "getUrlCookie", "getUrlScene", "getValidPreloadWebInfo", "Lcom/tencent/mm/protocal/protobuf/WebPrefetchInfo;", "isDnsCached", "isInPreAuthWhiteList", "isUrlCache", "isUrlPreAuthed", "isWebUrlEqual", "rawUrl", "targetUrl", "isWebUrlStorageEqual", "matchManifest", "domains", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyLitePrefetchDomainInfo;", "needReauth", "preAuth", "title", "desc", "from", "scene", "preAuths", "auths", "Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService$PreAuthInfo;", "preDns", "urls", "prefetch", "prefetchUrl", "checkCacheOnly", "headers", "bizScene", "subBizScene", "sendGetA8KeyLiteRequest", "preauths", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$BatchPreauth;", "setUrlToScene", "connect", "receiveHeader", "Lkotlin/Function1;", "targetFile", "Lcom/tencent/mm/vfs/VFSFile;", "onCompleted", "mockManifest", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyLiteResponse;", "prepare", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyLiteRequest;", "save", "saveDomainInfos", "saveManifest", "localPrefetchDomainInfos", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protobuf/ByteString;", "savePrefetch", "request", "BatchPreauth", "PrefetchAction", "PrefetchRes", "PrefetchTarget", "PrefetchType", "plugin-brandservice_release"})
public final class v
{
  private static final MMKVSlotManager pDA;
  private static final ConcurrentSkipListSet<String> pDB;
  private static final kotlin.f pDC;
  private static final MMCacheSlotManager pDD;
  private static final kotlin.f pDE;
  private static final MMKVSlotManager pDF;
  public static final v pDG;
  private static final MMKVSlotManager pDx;
  private static final MMKVSlotManager pDy;
  private static final MMKVSlotManager pDz;
  
  static
  {
    AppMethodBeat.i(6809);
    pDG = new v();
    pDx = new MMKVSlotManager(x.coM(), 3600L);
    pDy = new MMKVSlotManager(x.coM(), 604800L);
    pDz = new MMKVSlotManager(x.coM(), 86400L);
    pDA = new MMKVSlotManager(x.coM(), 604800L);
    pDB = new ConcurrentSkipListSet();
    pDC = kotlin.g.ah((kotlin.g.a.a)v.s.pFa);
    pDD = new MMCacheSlotManager();
    pDE = kotlin.g.ah((kotlin.g.a.a)v.n.pEB);
    pDF = new MMKVSlotManager(u.coo(), 86400L);
    AppMethodBeat.o(6809);
  }
  
  public static void Dy(int paramInt)
  {
    AppMethodBeat.i(175491);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("WebPrefetcher.currentScene");
    if (localMultiProcessMMKV != null)
    {
      localMultiProcessMMKV.encode("currentScene", paramInt);
      AppMethodBeat.o(175491);
      return;
    }
    AppMethodBeat.o(175491);
  }
  
  public static e.b R(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(195727);
    p.h(paramString1, "referer");
    p.h(paramString2, "url");
    String str = c.ff(c.getHost(paramString1), paramString2);
    c.a locala = com.tencent.mm.plugin.ad.c.ICA;
    paramString1 = new d(paramString2, str, com.tencent.mm.plugin.ad.c.fXk(), pDA, c.getHost(paramString1), paramString3).coI();
    AppMethodBeat.o(195727);
    return paramString1;
  }
  
  public static final void a(String arg0, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt)
  {
    AppMethodBeat.i(195728);
    p.h(???, "url");
    p.h(paramString2, "appId");
    p.h(paramString3, "title");
    p.h(paramString4, "desc");
    p.h(paramString5, "from");
    Log.v("MicroMsg.WebPrefetcher", "preAuth: " + paramString3 + ' ' + ???);
    paramString2 = new a(???, paramString2, paramString3, paramString4, paramInt, 0, null, null, 224);
    paramString3 = pDG;
    paramString4 = a.class.getCanonicalName() + '_' + "addToPreload";
    synchronized (__BATCH_RUN_OBJ.INSTANCE)
    {
      paramString5 = (bu)__BATCH_RUN_OBJ.INSTANCE.getBatchJobs().get(paramString4);
      if (paramString5 != null) {
        paramString5.a(null);
      }
      paramString5 = __BATCH_RUN_OBJ.INSTANCE.getBatchData();
      if (!paramString5.containsKey(paramString4)) {
        ((Map)paramString5).put(paramString4, new LinkedList());
      }
      paramString5 = paramString5.get(paramString4);
      if (paramString5 == null)
      {
        paramString2 = new t("null cannot be cast to non-null type java.util.LinkedList<T>");
        AppMethodBeat.o(195728);
        throw paramString2;
      }
    }
    ((LinkedList)paramString5).add(paramString2);
    ((Map)__BATCH_RUN_OBJ.INSTANCE.getBatchJobs()).put(paramString4, kotlinx.coroutines.f.b((ai)bn.TUK, (kotlin.d.f)ba.hMW(), (kotlin.g.a.m)new k(1000L, paramString4, null, paramString3), 2));
    AppMethodBeat.o(195728);
  }
  
  private static void a(String arg0, final String paramString2, Map<String, String> paramMap, int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(195723);
    paramMap = new b(c.getHost(???), ???, paramString2, false, paramMap, (byte)0);
    String str = b.class.getCanonicalName() + '_' + "batch";
    Object localObject;
    synchronized (__BATCH_RUN_OBJ.INSTANCE)
    {
      localObject = (bu)__BATCH_RUN_OBJ.INSTANCE.getBatchJobs().get(str);
      if (localObject != null) {
        ((bu)localObject).a(null);
      }
      localObject = __BATCH_RUN_OBJ.INSTANCE.getBatchData();
      if (!((HashMap)localObject).containsKey(str)) {
        ((Map)localObject).put(str, new LinkedList());
      }
      localObject = ((HashMap)localObject).get(str);
      if (localObject == null)
      {
        paramString2 = new t("null cannot be cast to non-null type java.util.LinkedList<T>");
        AppMethodBeat.o(195723);
        throw paramString2;
      }
    }
    ((LinkedList)localObject).add(paramMap);
    ((Map)__BATCH_RUN_OBJ.INSTANCE.getBatchJobs()).put(str, kotlinx.coroutines.f.b((ai)bn.TUK, (kotlin.d.f)ba.hMW(), (kotlin.g.a.m)new m(50L, str, null, paramInt1, paramString2, paramInt2), 2));
    AppMethodBeat.o(195723);
  }
  
  public static boolean ahB(String paramString)
  {
    AppMethodBeat.i(195733);
    p.h(paramString, "url");
    if (aiq(paramString) != null)
    {
      AppMethodBeat.o(195733);
      return true;
    }
    AppMethodBeat.o(195733);
    return false;
  }
  
  public static int ahE(String paramString)
  {
    AppMethodBeat.i(175492);
    int i;
    switch (cov())
    {
    default: 
      i = cov();
      AppMethodBeat.o(175492);
      return i;
    }
    if (paramString != null)
    {
      ait(paramString);
      i = ait(paramString);
      AppMethodBeat.o(175492);
      return i;
    }
    AppMethodBeat.o(175492);
    return 0;
  }
  
  public static e.b ahF(String paramString)
  {
    AppMethodBeat.i(195726);
    p.h(paramString, "url");
    String str = c.ahY(paramString);
    c.a locala = com.tencent.mm.plugin.ad.c.ICA;
    paramString = new d(paramString, str, com.tencent.mm.plugin.ad.c.fXj(), pDz).coI();
    AppMethodBeat.o(195726);
    return paramString;
  }
  
  public static void ahG(String paramString)
  {
    AppMethodBeat.i(6803);
    p.h(paramString, "url");
    Object localObject1 = c.ahY(paramString);
    Object localObject2 = com.tencent.mm.plugin.ad.c.ICA;
    localObject2 = com.tencent.mm.plugin.ad.c.fXj().aWR((String)localObject1);
    if (((o)localObject2).exists()) {
      ((o)localObject2).delete();
    }
    localObject2 = (MultiProcessMMKV)pDz.findSlot((String)localObject1);
    if (localObject2 != null) {
      ((MultiProcessMMKV)localObject2).remove((String)localObject1);
    }
    localObject1 = (MultiProcessMMKV)pDx.findSlot(c.ahY(paramString));
    if (localObject1 != null)
    {
      ((MultiProcessMMKV)localObject1).removeValueForKey(c.ahY(paramString));
      AppMethodBeat.o(6803);
      return;
    }
    AppMethodBeat.o(6803);
  }
  
  private static boolean aio(String paramString)
  {
    AppMethodBeat.i(195725);
    p.h(paramString, "url");
    String str = c.ahY(paramString);
    c.a locala = com.tencent.mm.plugin.ad.c.ICA;
    paramString = new d(paramString, str, com.tencent.mm.plugin.ad.c.fXj(), pDz);
    boolean bool1 = paramString.coH();
    boolean bool2 = paramString.isRedirect();
    if ((bool1) && (!bool2))
    {
      AppMethodBeat.o(195725);
      return true;
    }
    if (bool2)
    {
      if (((CharSequence)paramString.getLocation()).length() > 0) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label105;
        }
        paramString = paramString.getLocation();
        break;
      }
    }
    label105:
    AppMethodBeat.o(195725);
    return false;
  }
  
  public static fak aiq(String paramString)
  {
    AppMethodBeat.i(195732);
    String str = c.ahY(paramString);
    Object localObject1 = (MultiProcessMMKV)pDx.findSlot(str);
    int i;
    if (localObject1 != null) {
      if (((MultiProcessMMKV)localObject1).containsKey(str))
      {
        localObject1 = ((MultiProcessMMKV)localObject1).decodeBytes(str);
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
    fak localfak;
    for (;;)
    {
      try
      {
        Object localObject2 = fak.class.newInstance();
        ((com.tencent.mm.bw.a)localObject2).parseFrom((byte[])localObject1);
        localObject1 = (com.tencent.mm.bw.a)localObject2;
        localObject1 = (fak)localObject1;
        if (localObject1 == null) {
          break label319;
        }
        boolean bool = MMSlotKt.isExpire(((fak)localObject1).jsm, 600);
        Log.v("MicroMsg.WebPrefetcher", "[TRACE_PREFETCH] getValidPreloadWebInfo: webId#" + str + ", bizId: " + ((fak)localObject1).dPJ + "  prefetch:" + ((fak)localObject1).NwF + ", authorized:" + ((fak)localObject1).NwE + ", antispam:" + ((fak)localObject1).NwD + ", lastModify:" + ((fak)localObject1).jsm + ", expire:" + bool + ", url:" + paramString);
        if ((!((fak)localObject1).NwD) && (!bool)) {
          break label275;
        }
        AppMethodBeat.o(195732);
        return null;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", (Throwable)localException, "decode ProtoBuffer", new Object[0]);
      }
      i = 0;
      break;
      i = 0;
      break label61;
      label265:
      localfak = null;
      continue;
      localfak = null;
    }
    label275:
    if (!localfak.NwE)
    {
      AppMethodBeat.o(195732);
      return localfak;
    }
    if ((localfak.NwF) && (localfak.NwE) && (aio(paramString)))
    {
      AppMethodBeat.o(195732);
      return localfak;
    }
    label319:
    Log.v("MicroMsg.WebPrefetcher", "[TRACE_PREFETCH] getVaildPreloadWebInfo: webId#" + str + ", not cached, url:" + paramString + ' ');
    AppMethodBeat.o(195732);
    return null;
  }
  
  private static boolean air(String paramString)
  {
    AppMethodBeat.i(6806);
    String str = c.ahY(paramString);
    Object localObject1 = (MultiProcessMMKV)pDx.findSlot(str);
    int i;
    if (localObject1 != null) {
      if (((MultiProcessMMKV)localObject1).containsKey(str))
      {
        localObject1 = ((MultiProcessMMKV)localObject1).decodeBytes(str);
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
        Object localObject3 = fak.class.newInstance();
        ((com.tencent.mm.bw.a)localObject3).parseFrom((byte[])localObject1);
        localObject1 = (com.tencent.mm.bw.a)localObject3;
        localObject1 = (fak)localObject1;
        if (localObject1 == null) {
          break label242;
        }
        bool2 = MMSlotKt.isExpire(((fak)localObject1).jsm, 540);
        bool1 = bool2;
        bool3 = true;
        Log.v("MicroMsg.WebPrefetcher", "[TRACE_PREFETCH] needReauth:" + bool1 + ", webId:" + str + ", cached:" + bool3 + ", expired:" + bool2 + ", url:" + paramString);
        AppMethodBeat.o(6806);
        return bool1;
      }
      catch (Exception localException)
      {
        label205:
        Log.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", (Throwable)localException, "decode ProtoBuffer", new Object[0]);
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
  
  private static boolean ais(String paramString)
  {
    AppMethodBeat.i(195734);
    Object localObject1 = Uri.parse(UrlExKt.getWithProtocol(paramString));
    if (localObject1 != null)
    {
      localObject1 = ((Uri)localObject1).getHost();
      if (localObject1 != null)
      {
        p.g(localObject1, "it");
        localObject1 = c.aia((String)localObject1);
        Object localObject3 = (MultiProcessMMKV)pDy.findSlot((String)localObject1);
        int i;
        if (localObject3 != null) {
          if (((MultiProcessMMKV)localObject3).containsKey((String)localObject1))
          {
            localObject1 = ((MultiProcessMMKV)localObject3).decodeBytes((String)localObject1);
            if (localObject1 != null) {
              if (localObject1.length == 0)
              {
                i = 1;
                if (i != 0) {
                  break label183;
                }
                i = 1;
                label89:
                if (i == 0) {
                  break label206;
                }
              }
            }
          }
        }
        for (;;)
        {
          try
          {
            localObject3 = bhb.class.newInstance();
            ((com.tencent.mm.bw.a)localObject3).parseFrom((byte[])localObject1);
            localObject1 = (com.tencent.mm.bw.a)localObject3;
            localObject1 = (bhb)localObject1;
            if (localObject1 == null) {
              break label221;
            }
            if ((((bhb)localObject1).LQQ != 1) || (MMSlotKt.isExpire(((bhb)localObject1).LQS, ((bhb)localObject1).LQR))) {
              break label216;
            }
            bool = true;
            if (bool) {
              Log.v("MicroMsg.WebPrefetcher", "[TRACE_PREFETCH] preauth cancelled, in whiteList:".concat(String.valueOf(paramString)));
            }
            AppMethodBeat.o(195734);
            return bool;
          }
          catch (Exception localException)
          {
            label183:
            Log.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", (Throwable)localException, "decode ProtoBuffer", new Object[0]);
          }
          i = 0;
          break;
          i = 0;
          break label89;
          label206:
          Object localObject2 = null;
          continue;
          localObject2 = null;
          continue;
          label216:
          boolean bool = false;
          continue;
          label221:
          bool = false;
        }
      }
    }
    AppMethodBeat.o(195734);
    return false;
  }
  
  private static int ait(String paramString)
  {
    AppMethodBeat.i(175488);
    MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)pDF.findSlot(c.ahY(paramString));
    if (localMultiProcessMMKV != null)
    {
      int i = localMultiProcessMMKV.getInt(c.ahY(paramString), 0);
      AppMethodBeat.o(175488);
      return i;
    }
    AppMethodBeat.o(175488);
    return 0;
  }
  
  public static final void cF(List<? extends e.a> paramList)
  {
    AppMethodBeat.i(160497);
    p.h(paramList, "auths");
    if (paramList.isEmpty())
    {
      AppMethodBeat.o(160497);
      return;
    }
    paramList = (Iterable)paramList;
    Collection localCollection = (Collection)new ArrayList(kotlin.a.j.a(paramList, 10));
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      e.a locala = (e.a)localIterator.next();
      String str2 = locala.url;
      p.g(str2, "info.url");
      Object localObject1 = locala.appId;
      paramList = (List<? extends e.a>)localObject1;
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
      localCollection.add(new a(str2, paramList, (String)localObject1, (String)localObject2, locala.pmM, locala.pmN, null, locala.extInfo, 64));
    }
    cG((List)localCollection);
    AppMethodBeat.o(160497);
  }
  
  private static void cG(List<a> paramList)
  {
    AppMethodBeat.i(195730);
    Log.v("MicroMsg.WebPrefetcher", "[TRACE_PREFETCH] preAuths size = %s", new Object[] { Integer.valueOf(paramList.size()) });
    bhf localbhf = new bhf();
    Object localObject1 = (Iterable)paramList;
    paramList = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    Object localObject2;
    Object localObject3;
    label177:
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      localObject3 = (a)localObject2;
      if ((cou()) || ((!pDD.contains(c.ahW(((a)localObject3).url))) && (!UrlExKt.isMpUrl(((a)localObject3).url)) && (!ais(((a)localObject3).url)) && (air(((a)localObject3).url)) && (!pDB.contains(((a)localObject3).url)))) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label177;
        }
        paramList.add(localObject2);
        break;
      }
    }
    localObject1 = (Iterable)paramList;
    paramList = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject1, 10));
    localObject1 = ((Iterable)localObject1).iterator();
    int i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (a)((Iterator)localObject1).next();
      localObject3 = new h();
      ((h)localObject3).LQZ = ((a)localObject2).url;
      ((h)localObject3).jfi = ((a)localObject2).appId;
      ((h)localObject3).LRa = ((a)localObject2).title;
      ((h)localObject3).LRb = ((a)localObject2).desc;
      ((h)localObject3).LQY = i;
      ((h)localObject3).LRc = ((a)localObject2).pDH;
      ((h)localObject3).Scene = ((a)localObject2).scene;
      ((h)localObject3).pmN = ((a)localObject2).pmN;
      pDD.add(c.ahW(((a)localObject2).url));
      ((h)localObject3).extInfo = ((a)localObject2).extInfo;
      ((h)localObject3).hDa = ((a)localObject2).scene;
      paramList.add(localObject3);
      i += 1;
    }
    paramList = (List)paramList;
    localbhf.LRf.addAll((Collection)paramList);
    localbhf.KOL = localbhf.LRf.size();
    localbhf.Scene = 0;
    localbhf.KMd = 0;
    if (localbhf.LRf.isEmpty())
    {
      Log.v("MicroMsg.WebPrefetcher", "[TRACE_PREFETCH] preAuths: nothing to preauth");
      AppMethodBeat.o(195730);
      return;
    }
    try
    {
      paramList = pDB;
      localObject1 = localbhf.LRf;
      p.g(localObject1, "req.ReqInfo");
      localObject2 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        ((Collection)localObject1).add(((bhe)((Iterator)localObject2).next()).LQZ);
        continue;
        paramList = com.tencent.mm.plugin.webview.core.g.ILB;
      }
    }
    catch (Exception paramList)
    {
      Log.e("MicroMsg.WebPrefetcher", "Concurrent Add Exception: " + paramList.getMessage());
    }
    for (;;)
    {
      if (g.a.fZP()) {
        CronetLogic.setUserCertVerify(true);
      }
      paramList = new StringBuilder("[TRACE_PREFETCH] sendGetA8KeyLiteRequest batch req: ");
      localObject1 = localbhf.LRf;
      p.g(localObject1, "req.ReqInfo");
      Log.v("MicroMsg.WebPrefetcher", kotlin.a.j.a((Iterable)localObject1, (CharSequence)",", null, null, 0, null, (kotlin.g.a.b)q.pEX, 30));
      com.tencent.mm.ac.d.b("MicroMsg.WebPrefetcher", (kotlin.g.a.a)new r(localbhf));
      AppMethodBeat.o(195730);
      return;
      paramList.addAll((Collection)localObject1);
    }
  }
  
  public static boolean cK(String paramString, int paramInt)
  {
    AppMethodBeat.i(175489);
    p.h(paramString, "url");
    boolean bool = ((MultiProcessMMKV)pDF.getSlot()).encode(c.ahY(paramString), paramInt);
    AppMethodBeat.o(175489);
    return bool;
  }
  
  public static MMKVSlotManager cop()
  {
    return pDx;
  }
  
  public static MMKVSlotManager coq()
  {
    return pDy;
  }
  
  public static MMKVSlotManager cor()
  {
    return pDz;
  }
  
  public static MMKVSlotManager cos()
  {
    return pDA;
  }
  
  public static MMCacheSlotManager cot()
  {
    return pDD;
  }
  
  public static boolean cou()
  {
    AppMethodBeat.i(195731);
    boolean bool = ((Boolean)pDE.getValue()).booleanValue();
    AppMethodBeat.o(195731);
    return bool;
  }
  
  private static int cov()
  {
    AppMethodBeat.i(175490);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("WebPrefetcher.currentScene");
    if (localMultiProcessMMKV != null)
    {
      int i = localMultiProcessMMKV.decodeInt("currentScene");
      AppMethodBeat.o(175490);
      return i;
    }
    AppMethodBeat.o(175490);
    return 0;
  }
  
  public static boolean fj(String paramString1, String paramString2)
  {
    AppMethodBeat.i(195735);
    String str = c.ahY(paramString1);
    c.a locala = com.tencent.mm.plugin.ad.c.ICA;
    str = new d(paramString1, str, com.tencent.mm.plugin.ad.c.fXj(), pDz).getLocation();
    if (!n.aL((CharSequence)str)) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramString1 = c.aJ(str, true);
      Log.v("MicroMsg.WebPrefetcher", "isWebUrlStorageEqual: location:#" + paramString1 + ", " + str);
      paramString2 = c.aJ(paramString2, true);
      Log.v("MicroMsg.WebPrefetcher", "isWebUrlStorageEqual: target:#".concat(String.valueOf(paramString2)));
      boolean bool = p.j(paramString1, paramString2);
      AppMethodBeat.o(195735);
      return bool;
    }
    AppMethodBeat.o(195735);
    return false;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$BatchPreauth;", "", "url", "", "appId", "title", "desc", "scene", "", "subBizScene", "refer", "extInfo", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getDesc", "getExtInfo", "getRefer", "getScene", "()I", "getSubBizScene", "getTitle", "getUrl", "plugin-brandservice_release"})
  static final class a
  {
    final String appId;
    final String desc;
    final String extInfo;
    final String pDH;
    final int pmN;
    final int scene;
    final String title;
    final String url;
    
    private a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, String paramString5, String paramString6)
    {
      AppMethodBeat.i(195646);
      this.url = paramString1;
      this.appId = paramString2;
      this.title = paramString3;
      this.desc = paramString4;
      this.scene = paramInt1;
      this.pmN = paramInt2;
      this.pDH = paramString5;
      this.extInfo = paramString6;
      AppMethodBeat.o(195646);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchAction;", "", "host", "", "rawUrl", "prefetchUrl", "checkCacheOnly", "", "prefetchHeader", "", "bizScene", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/util/Map;I)V", "getBizScene", "()I", "getCheckCacheOnly", "()Z", "getHost", "()Ljava/lang/String;", "getPrefetchHeader", "()Ljava/util/Map;", "getPrefetchUrl", "getRawUrl", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "plugin-brandservice_release"})
  static final class b
  {
    final String edo;
    private final int hDa;
    final String host;
    final String pDI;
    final boolean pDJ;
    final Map<String, String> pDK;
    
    private b(String paramString1, String paramString2, String paramString3, boolean paramBoolean, Map<String, String> paramMap)
    {
      AppMethodBeat.i(195648);
      this.host = paramString1;
      this.edo = paramString2;
      this.pDI = paramString3;
      this.pDJ = paramBoolean;
      this.pDK = paramMap;
      this.hDa = 0;
      AppMethodBeat.o(195648);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(195651);
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if ((!p.j(this.host, paramObject.host)) || (!p.j(this.edo, paramObject.edo)) || (!p.j(this.pDI, paramObject.pDI)) || (this.pDJ != paramObject.pDJ) || (!p.j(this.pDK, paramObject.pDK)) || (this.hDa != paramObject.hDa)) {}
        }
      }
      else
      {
        AppMethodBeat.o(195651);
        return true;
      }
      AppMethodBeat.o(195651);
      return false;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(195649);
      String str = "PrefetchAction(host=" + this.host + ", rawUrl=" + this.edo + ", prefetchUrl=" + this.pDI + ", checkCacheOnly=" + this.pDJ + ", prefetchHeader=" + this.pDK + ", bizScene=" + this.hDa + ")";
      AppMethodBeat.o(195649);
      return str;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchTarget;", "", "url", "", "webId", "content", "Lcom/tencent/mm/plugin/webprefetcher/WebPrefetcherFile;", "headerSlot", "Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "referHost", "mainAppId", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/webprefetcher/WebPrefetcherFile;Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;Ljava/lang/String;Ljava/lang/String;)V", "appId", "getAppId", "()Ljava/lang/String;", "appId$delegate", "Lkotlin/Lazy;", "bizId", "getBizId", "bizId$delegate", "bizScene", "", "getBizScene", "()I", "bizScene$delegate", "cacheTime", "", "getCacheTime", "()J", "getContent", "()Lcom/tencent/mm/plugin/webprefetcher/WebPrefetcherFile;", "eTag", "getETag", "fullUrl", "getFullUrl", "fullUrl$delegate", "getHeaderSlot", "()Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "headers", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getHeaders", "()Ljava/util/HashMap;", "headers$delegate", "isCached", "", "()Z", "isRedirect", "lazyWebPrefetchInfo", "Lcom/tencent/mm/protocal/protobuf/WebPrefetchInfo;", "getLazyWebPrefetchInfo", "()Lcom/tencent/mm/protocal/protobuf/WebPrefetchInfo;", "lazyWebPrefetchInfo$delegate", "location", "getLocation", "getMainAppId", "maxCache", "getMaxCache", "mimeType", "getMimeType", "prefetchHost", "getPrefetchHost", "prefetchUrl", "getPrefetchUrl", "getReferHost", "response", "Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService$PrefetchResponse;", "getResponse", "()Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService$PrefetchResponse;", "subBizScene", "getSubBizScene", "subBizScene$delegate", "type", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchType;", "getType", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchType;", "getUrl", "version", "getVersion", "getWebId", "wxETag", "getWxETag", "createResponse", "refresh", "", "saveHeaders", "host", "plugin-brandservice_release"})
  static final class d
  {
    private final kotlin.f pDM;
    private final kotlin.f pDN;
    private final kotlin.f pDO;
    private final kotlin.f pDP;
    private final kotlin.f pDQ;
    private final kotlin.f pDR;
    private final kotlin.f pDS;
    final String pDT;
    final com.tencent.mm.plugin.ad.b pDU;
    final MMKVSlotManager pDV;
    private final String pDW;
    final String pDX;
    final String url;
    
    public d(String paramString1, String paramString2, com.tencent.mm.plugin.ad.b paramb, MMKVSlotManager paramMMKVSlotManager, String paramString3, String paramString4)
    {
      AppMethodBeat.i(195689);
      this.url = paramString1;
      this.pDT = paramString2;
      this.pDU = paramb;
      this.pDV = paramMMKVSlotManager;
      this.pDW = paramString3;
      this.pDX = paramString4;
      this.pDM = kotlin.g.ah((kotlin.g.a.a)new g(this));
      this.pDN = kotlin.g.ah((kotlin.g.a.a)new b(this));
      this.pDO = kotlin.g.ah((kotlin.g.a.a)new a(this));
      this.pDP = kotlin.g.ah((kotlin.g.a.a)new e(this));
      this.pDQ = kotlin.g.ah((kotlin.g.a.a)new c(this));
      this.pDR = kotlin.g.ah((kotlin.g.a.a)new h(this));
      this.pDS = kotlin.g.ah((kotlin.g.a.a)new f(this));
      AppMethodBeat.o(195689);
    }
    
    private v.e coC()
    {
      AppMethodBeat.i(195675);
      Object localObject = (List)coB().get("x-wx-client-prefetch-type");
      if (localObject != null)
      {
        localObject = (String)kotlin.a.j.ks((List)localObject);
        if (localObject != null)
        {
          if (localObject == null)
          {
            localObject = new t("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(195675);
            throw ((Throwable)localObject);
          }
          localObject = ((String)localObject).toUpperCase();
          p.g(localObject, "(this as java.lang.String).toUpperCase()");
          v.e locale = v.e.valueOf((String)localObject);
          localObject = locale;
          if (locale != null) {
            break label81;
          }
        }
      }
      localObject = v.e.pEc;
      label81:
      AppMethodBeat.o(195675);
      return localObject;
    }
    
    private final e.b coJ()
    {
      AppMethodBeat.i(195687);
      int i = coB().size();
      boolean bool = this.pDU.contains(cox());
      if ((i == 0) || (!bool))
      {
        Log.e("MicroMsg.WebPrefetcher", "createResponse fail headerSize:" + i + ", containsFile:" + bool);
        AppMethodBeat.o(195687);
        return null;
      }
      e.b localb = new e.b();
      localb.url = coy();
      localb.pmP = coC().toString();
      localb.pmO = getVersion();
      localb.hDa = coz();
      localb.pmN = coA();
      Object localObject1 = v.d.d.pDZ;
      v.d.d.i(coB());
      localObject1 = getMimeType();
      Object localObject2 = (Map)coB();
      Map localMap = (Map)new LinkedHashMap(ae.atJ(((Map)localObject2).size()));
      localObject2 = ((Iterable)((Map)localObject2).entrySet()).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject4 = ((Iterator)localObject2).next();
        Object localObject3 = ((Map.Entry)localObject4).getKey();
        localObject4 = (Map.Entry)localObject4;
        ((Map.Entry)localObject4).getKey();
        localMap.put(localObject3, (String)kotlin.a.j.ks((List)((Map.Entry)localObject4).getValue()));
      }
      localb.pmQ = new WebResourceResponse((String)localObject1, "UTF-8", 200, "OK", localMap, s.ao(this.pDU.aWR(cox())));
      AppMethodBeat.o(195687);
      return localb;
    }
    
    private String coy()
    {
      AppMethodBeat.i(195671);
      String str = (String)this.pDP.getValue();
      AppMethodBeat.o(195671);
      return str;
    }
    
    private String getAppId()
    {
      AppMethodBeat.i(195670);
      String str = (String)this.pDO.getValue();
      AppMethodBeat.o(195670);
      return str;
    }
    
    private final String getMimeType()
    {
      AppMethodBeat.i(195678);
      Object localObject = (List)coB().get("content-type");
      if (localObject != null)
      {
        localObject = (String)kotlin.a.j.ks((List)localObject);
        if (localObject != null)
        {
          localObject = n.oz((String)localObject, ";");
          if (localObject != null)
          {
            if (localObject == null)
            {
              localObject = new t("null cannot be cast to non-null type kotlin.CharSequence");
              AppMethodBeat.o(195678);
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
      AppMethodBeat.o(195678);
      return localObject;
    }
    
    private long getVersion()
    {
      AppMethodBeat.i(195677);
      Object localObject = (List)coB().get("x-wx-version");
      if (localObject != null)
      {
        localObject = (String)kotlin.a.j.ks((List)localObject);
        if (localObject != null)
        {
          long l = Long.parseLong((String)localObject);
          AppMethodBeat.o(195677);
          return l;
        }
      }
      AppMethodBeat.o(195677);
      return -1L;
    }
    
    private void refresh()
    {
      AppMethodBeat.i(195685);
      if ((coC() == v.e.pEc) && (coE() > 0L) && (coD() > 0) && (MMSlotKt.isExpire(coE(), Math.max(coD() - 60, 60))))
      {
        Object localObject = v.pDG;
        com.tencent.mm.plugin.webview.i.b.agr(v.ahE(this.url));
        localObject = v.pDG;
        String str2 = this.url;
        localObject = (List)coB().get("x-wx-client-prefetch-url");
        if (localObject != null)
        {
          String str1 = (String)kotlin.a.j.ks((List)localObject);
          localObject = str1;
          if (str1 != null) {}
        }
        else
        {
          localObject = "";
        }
        v.fi(str2, (String)localObject);
      }
      AppMethodBeat.o(195685);
    }
    
    public final void a(v.e parame, String paramString)
    {
      AppMethodBeat.i(195688);
      p.h(parame, "type");
      p.h(paramString, "host");
      ((Map)coB()).put("x-wx-client-cache-time", kotlin.a.j.listOf(String.valueOf(MMSlotKt.now())));
      ((Map)coB()).put("x-wx-client-prefetch-url", kotlin.a.j.listOf(this.url));
      if (!n.aL((CharSequence)paramString)) {}
      faj localfaj;
      LinkedList localLinkedList;
      Collection localCollection;
      Object localObject;
      fai localfai;
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          ((Map)coB()).put("x-wx-client-prefetch-host", kotlin.a.j.listOf(paramString));
        }
        ((Map)coB()).put("x-wx-client-prefetch-type", kotlin.a.j.listOf(parame.toString()));
        localfaj = new faj();
        localLinkedList = localfaj.NwC;
        paramString = (Map)coB();
        localCollection = (Collection)new ArrayList(paramString.size());
        Iterator localIterator = paramString.entrySet().iterator();
        if (!localIterator.hasNext()) {
          break label403;
        }
        localObject = (Map.Entry)localIterator.next();
        paramString = (String)((Map.Entry)localObject).getKey();
        localObject = (List)((Map.Entry)localObject).getValue();
        localfai = new fai();
        if (paramString != null) {
          break;
        }
        parame = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(195688);
        throw parame;
      }
      String str = paramString.toLowerCase();
      p.g(str, "(this as java.lang.String).toLowerCase()");
      switch (str.hashCode())
      {
      }
      for (;;)
      {
        localfai.key = paramString;
        localfai.LOe.addAll((Collection)localObject);
        localCollection.add(localfai);
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
      ((MultiProcessMMKV)this.pDV.getSlot()).encode(cox(), localfaj.toByteArray());
      Log.v("MicroMsg.WebPrefetcher", "saveHeaders " + parame + " : webId:" + this.pDT + ", bizId:" + cox() + ", header size:" + coB().size());
      AppMethodBeat.o(195688);
    }
    
    public final int coA()
    {
      AppMethodBeat.i(195673);
      int i = ((Number)this.pDR.getValue()).intValue();
      AppMethodBeat.o(195673);
      return i;
    }
    
    public final HashMap<String, List<String>> coB()
    {
      AppMethodBeat.i(195674);
      HashMap localHashMap = (HashMap)this.pDS.getValue();
      AppMethodBeat.o(195674);
      return localHashMap;
    }
    
    public final int coD()
    {
      AppMethodBeat.i(195679);
      Object localObject = (List)coB().get("x-wx-max-cache");
      if (localObject != null)
      {
        localObject = (String)kotlin.a.j.ks((List)localObject);
        if (localObject != null) {
          localObject = Integer.valueOf(Integer.parseInt((String)localObject));
        }
      }
      while (localObject != null)
      {
        int i = ((Integer)localObject).intValue();
        AppMethodBeat.o(195679);
        return i;
        localObject = (List)coB().get("max-age");
        if (localObject != null)
        {
          localObject = (String)kotlin.a.j.ks((List)localObject);
          if (localObject != null)
          {
            localObject = Integer.valueOf(Integer.parseInt((String)localObject));
            continue;
          }
        }
        localObject = null;
      }
      AppMethodBeat.o(195679);
      return 600;
    }
    
    public final long coE()
    {
      AppMethodBeat.i(195680);
      Object localObject = (List)coB().get("x-wx-client-cache-time");
      if (localObject != null)
      {
        localObject = (String)kotlin.a.j.ks((List)localObject);
        if (localObject != null)
        {
          long l = Long.parseLong((String)localObject);
          AppMethodBeat.o(195680);
          return l;
        }
      }
      AppMethodBeat.o(195680);
      return -1L;
    }
    
    public final String coF()
    {
      AppMethodBeat.i(195681);
      Object localObject = (List)coB().get("x-wx-etag");
      if (localObject != null)
      {
        String str = (String)kotlin.a.j.ks((List)localObject);
        localObject = str;
        if (str != null) {}
      }
      else
      {
        localObject = "";
      }
      AppMethodBeat.o(195681);
      return localObject;
    }
    
    public final String coG()
    {
      AppMethodBeat.i(195682);
      Object localObject = (List)coB().get("etag");
      if (localObject != null)
      {
        String str = (String)kotlin.a.j.ks((List)localObject);
        localObject = str;
        if (str != null) {}
      }
      else
      {
        localObject = "";
      }
      AppMethodBeat.o(195682);
      return localObject;
    }
    
    public final boolean coH()
    {
      AppMethodBeat.i(195684);
      Object localObject = (List)coB().get("status");
      if (localObject != null)
      {
        localObject = (String)kotlin.a.j.ks((List)localObject);
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
            AppMethodBeat.o(195684);
            return false;
            localObject = null;
            break;
            switch (((String)localObject).hashCode())
            {
            }
          }
        } while (!((String)localObject).equals("200"));
        boolean bool = this.pDU.contains(cox());
        AppMethodBeat.o(195684);
        return bool;
      } while (!((String)localObject).equals("301"));
      for (;;)
      {
        if (n.aL((CharSequence)getLocation())) {
          break label165;
        }
        AppMethodBeat.o(195684);
        return true;
        if (!((String)localObject).equals("302")) {
          break;
        }
      }
      label165:
      AppMethodBeat.o(195684);
      return false;
    }
    
    public final e.b coI()
    {
      AppMethodBeat.i(195686);
      Object localObject3;
      for (Object localObject1 = this;; localObject1 = new d((String)localObject2, (String)localObject1, (com.tencent.mm.plugin.ad.b)localObject3, v.cor()))
      {
        Log.i("MicroMsg.WebPrefetcher", "get response #" + ((d)localObject1).pDT + ", " + ((d)localObject1).getAppId() + ", " + ((d)localObject1).pDW + ", " + ((d)localObject1).url);
        localObject2 = com.tencent.mm.plugin.ad.c.ICA;
        localObject2 = c.a.lD(((d)localObject1).getAppId(), ((d)localObject1).url);
        if (localObject2 != null)
        {
          localObject3 = new e.b();
          ((e.b)localObject3).url = ((d)localObject1).coy();
          ((e.b)localObject3).pmP = ((d)localObject1).coC().toString();
          ((e.b)localObject3).pmO = ((d)localObject1).getVersion();
          ((e.b)localObject3).hDa = ((d)localObject1).coz();
          ((e.b)localObject3).pmN = ((d)localObject1).coA();
          ((e.b)localObject3).pmQ = ((WebResourceResponse)localObject2);
          ((e.b)localObject3).appId = ((d)localObject1).getAppId();
          AppMethodBeat.o(195686);
          return localObject3;
        }
        if (!((d)localObject1).coH()) {
          break label540;
        }
        Log.i("MicroMsg.WebPrefetcher", "fetch cached: #" + ((d)localObject1).pDT + ", " + ((d)localObject1).url);
        localObject2 = ((d)localObject1).coC();
        switch (w.$EnumSwitchMapping$0[localObject2.ordinal()])
        {
        default: 
          localObject1 = ((d)localObject1).coJ();
          AppMethodBeat.o(195686);
          return localObject1;
        }
        if (!((d)localObject1).isRedirect()) {
          break;
        }
        Log.i("MicroMsg.WebPrefetcher", "HTML redirect, location:" + ((d)localObject1).getLocation());
        localObject2 = ((d)localObject1).getLocation();
        localObject1 = c.ahY(((d)localObject1).getLocation());
        localObject3 = com.tencent.mm.plugin.ad.c.ICA;
        localObject3 = com.tencent.mm.plugin.ad.c.fXj();
        v localv = v.pDG;
      }
      Object localObject2 = v.pDG;
      if (v.ahB(((d)localObject1).url))
      {
        if (!MMSlotKt.isExpire(((d)localObject1).coE(), ((d)localObject1).coD()))
        {
          localObject2 = (List)((d)localObject1).coB().get("set-cookie");
          if (localObject2 != null)
          {
            localObject2 = ((Iterable)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = (String)((Iterator)localObject2).next();
              com.tencent.xweb.c.hsp().setCookie(((d)localObject1).url, (String)localObject3);
            }
          }
          localObject1 = ((d)localObject1).coJ();
          AppMethodBeat.o(195686);
          return localObject1;
        }
        Log.w("MicroMsg.WebPrefetcher", "doc expired refresh cached: #" + ((d)localObject1).pDT + ", " + ((d)localObject1).url);
        ((d)localObject1).refresh();
        AppMethodBeat.o(195686);
        return null;
      }
      Log.w("MicroMsg.WebPrefetcher", "preauth expired preauth: #" + ((d)localObject1).pDT + ", " + ((d)localObject1).url);
      v.aip(((d)localObject1).url);
      AppMethodBeat.o(195686);
      return null;
      label540:
      AppMethodBeat.o(195686);
      return null;
    }
    
    public final String cox()
    {
      AppMethodBeat.i(195669);
      String str = (String)this.pDN.getValue();
      AppMethodBeat.o(195669);
      return str;
    }
    
    public final int coz()
    {
      AppMethodBeat.i(195672);
      int i = ((Number)this.pDQ.getValue()).intValue();
      AppMethodBeat.o(195672);
      return i;
    }
    
    public final String getLocation()
    {
      AppMethodBeat.i(195676);
      Object localObject = (List)coB().get("location");
      if (localObject != null)
      {
        String str = (String)kotlin.a.j.ks((List)localObject);
        localObject = str;
        if (str != null) {}
      }
      else
      {
        localObject = "";
      }
      AppMethodBeat.o(195676);
      return localObject;
    }
    
    public final boolean isRedirect()
    {
      AppMethodBeat.i(195683);
      Object localObject = (List)coB().get("status");
      if (localObject != null)
      {
        localObject = (String)kotlin.a.j.ks((List)localObject);
        if (localObject != null) {
          break label49;
        }
      }
      label49:
      do
      {
        for (;;)
        {
          AppMethodBeat.o(195683);
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
        AppMethodBeat.o(195683);
        return true;
        if (!((String)localObject).equals("302")) {
          break;
        }
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.a<String>
    {
      a(v.d paramd)
      {
        super();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class b
      extends q
      implements kotlin.g.a.a<String>
    {
      b(v.d paramd)
      {
        super();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class c
      extends q
      implements kotlin.g.a.a<Integer>
    {
      c(v.d paramd)
      {
        super();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class e
      extends q
      implements kotlin.g.a.a<String>
    {
      e(v.d paramd)
      {
        super();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "invoke"})
    static final class f
      extends q
      implements kotlin.g.a.a<HashMap<String, List<? extends String>>>
    {
      f(v.d paramd)
      {
        super();
      }
      
      private HashMap<String, List<String>> coK()
      {
        AppMethodBeat.i(195665);
        Object localObject2 = this.pDY.pDV;
        Object localObject1 = this.pDY.cox();
        localObject2 = (MultiProcessMMKV)((MMKVSlotManager)localObject2).findSlot((String)localObject1);
        int i;
        if (localObject2 != null) {
          if (((MultiProcessMMKV)localObject2).containsKey((String)localObject1))
          {
            localObject1 = ((MultiProcessMMKV)localObject2).decodeBytes((String)localObject1);
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
            localObject2 = faj.class.newInstance();
            ((com.tencent.mm.bw.a)localObject2).parseFrom((byte[])localObject1);
            localObject1 = (com.tencent.mm.bw.a)localObject2;
            localObject2 = (faj)localObject1;
            localObject1 = new HashMap();
            if (localObject2 == null) {
              break label201;
            }
            localObject2 = ((faj)localObject2).NwC;
            p.g(localObject2, "it.header");
            localObject2 = ((Iterable)localObject2).iterator();
            if (!((Iterator)localObject2).hasNext()) {
              break label201;
            }
            fai localfai = (fai)((Iterator)localObject2).next();
            ((HashMap)localObject1).put(localfai.key, localfai.LOe);
            continue;
            i = 0;
          }
          catch (Exception localException)
          {
            Log.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", (Throwable)localException, "decode ProtoBuffer", new Object[0]);
          }
          i = 0;
          break label65;
          localHashMap = null;
          continue;
          localHashMap = null;
        }
        label201:
        AppMethodBeat.o(195665);
        return localHashMap;
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/protocal/protobuf/WebPrefetchInfo;", "invoke"})
    static final class g
      extends q
      implements kotlin.g.a.a<fak>
    {
      g(v.d paramd)
      {
        super();
      }
      
      private fak coL()
      {
        AppMethodBeat.i(195667);
        Object localObject1 = v.pDG;
        Object localObject3 = v.cop();
        localObject1 = this.pDY.pDT;
        localObject3 = (MultiProcessMMKV)((MMKVSlotManager)localObject3).findSlot((String)localObject1);
        int i;
        if (localObject3 != null) {
          if (((MultiProcessMMKV)localObject3).containsKey((String)localObject1))
          {
            localObject1 = ((MultiProcessMMKV)localObject3).decodeBytes((String)localObject1);
            if (localObject1 != null) {
              if (localObject1.length == 0)
              {
                i = 1;
                if (i != 0) {
                  break label106;
                }
                i = 1;
                label65:
                if (i == 0) {
                  break label127;
                }
              }
            }
          }
        }
        for (;;)
        {
          try
          {
            localObject3 = fak.class.newInstance();
            ((com.tencent.mm.bw.a)localObject3).parseFrom((byte[])localObject1);
            localObject1 = (com.tencent.mm.bw.a)localObject3;
            localObject1 = (fak)localObject1;
            AppMethodBeat.o(195667);
            return localObject1;
          }
          catch (Exception localException)
          {
            label106:
            Log.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", (Throwable)localException, "decode ProtoBuffer", new Object[0]);
          }
          i = 0;
          break;
          i = 0;
          break label65;
          label127:
          Object localObject2 = null;
          continue;
          localObject2 = null;
        }
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class h
      extends q
      implements kotlin.g.a.a<Integer>
    {
      h(v.d paramd)
      {
        super();
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchType;", "", "type", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "toString", "JS", "CSS", "HTML", "plugin-brandservice_release"})
  static enum e
  {
    private final String type;
    
    static
    {
      AppMethodBeat.i(195691);
      e locale1 = new e("JS", 0, "JS");
      pEa = locale1;
      e locale2 = new e("CSS", 1, "CSS");
      pEb = locale2;
      e locale3 = new e("HTML", 2, "HTML");
      pEc = locale3;
      pEd = new e[] { locale1, locale2, locale3 };
      AppMethodBeat.o(195691);
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$connect$2$1", "Lcom/tencent/mars/cdn/CronetLogic$CronetTaskCallback;", "onCronetReceiveHeader", "", "header", "Lcom/tencent/mars/cdn/CronetLogic$ResponseHeader;", "status_code", "onCronetTaskCompleted", "", "filekey", "", "result", "Lcom/tencent/mars/cdn/CronetLogic$CronetTaskResult;", "onDownloadProgressChanged", "progress", "Lcom/tencent/mars/cdn/CronetLogic$CronetDownloadProgress;", "plugin-brandservice_release"})
  public static final class f
    implements CronetLogic.CronetTaskCallback
  {
    f(z paramz, String paramString, o paramo, kotlin.g.a.b paramb1, kotlin.g.a.b paramb2) {}
    
    public final int onCronetReceiveHeader(CronetLogic.ResponseHeader paramResponseHeader, int paramInt)
    {
      AppMethodBeat.i(195695);
      if (((Boolean)this.pEh.invoke(Integer.valueOf(paramInt))).booleanValue())
      {
        AppMethodBeat.o(195695);
        return 0;
      }
      paramResponseHeader = this.pAj;
      if (paramResponseHeader != null) {
        paramResponseHeader.invoke(Boolean.FALSE);
      }
      AppMethodBeat.o(195695);
      return -99;
    }
    
    public final void onCronetTaskCompleted(String paramString, CronetLogic.CronetTaskResult paramCronetTaskResult)
    {
      AppMethodBeat.i(195694);
      if (paramCronetTaskResult != null) {
        switch (paramCronetTaskResult.statusCode)
        {
        }
      }
      for (;;)
      {
        paramString = new o(this.pEe.getSavePath());
        if (paramString.exists()) {
          paramString.delete();
        }
        paramString = this.pAj;
        if (paramString == null) {
          break;
        }
        paramString.invoke(Boolean.valueOf(s.YS(this.pEf)));
        AppMethodBeat.o(195694);
        return;
        if (s.nx(this.pEe.getSavePath(), this.pEf))
        {
          Log.i("MicroMsg.WebPrefetcher", "save file:" + this.pEe.getURL() + " to " + this.pEf);
        }
        else
        {
          Log.e("MicroMsg.WebPrefetcher", "save conn failed:" + this.pEe.getURL() + " to " + this.pEe.getSavePath());
          continue;
          this.pEh.invoke(Integer.valueOf(paramCronetTaskResult.statusCode));
        }
      }
      AppMethodBeat.o(195694);
    }
    
    public final void onDownloadProgressChanged(String paramString, CronetLogic.CronetDownloadProgress paramCronetDownloadProgress) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/network/MMHttpUrlCronetConnection;", "conn", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.b<z, z>
  {
    h(Map paramMap, v.d paramd, String paramString1, String paramString2)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/network/MMHttpUrlCronetConnection;", "conn", "invoke", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$fetchManifest$2$1"})
  static final class i
    extends q
    implements kotlin.g.a.b<z, z>
  {
    i(String paramString, kotlin.d.d paramd, com.tencent.mm.plugin.ad.a parama)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/network/MMHttpUrlCronetConnection;", "conn", "invoke", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$fetchRes$1$1"})
  static final class j
    extends q
    implements kotlin.g.a.b<z, z>
  {
    j(String paramString1, v.c paramc, String paramString2)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/mm/sdk/platformtools/MMBatchRunKt$batchRun$2"})
  public static final class k
    extends kotlin.d.b.a.j
    implements kotlin.g.a.m<ai, kotlin.d.d<? super kotlin.x>, Object>
  {
    Object L$0;
    int label;
    private ai p$;
    
    public k(long paramLong, String paramString, kotlin.d.d paramd, v paramv)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<kotlin.x> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(6785);
      p.h(paramd, "completion");
      paramd = new k(this.$delay, this.$key, paramd, this.pEw);
      paramd.p$ = ((ai)paramObject);
      AppMethodBeat.o(6785);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(6786);
      paramObject1 = ((k)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(kotlin.x.SXb);
      AppMethodBeat.o(6786);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(6784);
      Object localObject = kotlin.d.a.a.SXO;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(6784);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.p$;
        long l = this.$delay;
        this.L$0 = paramObject;
        this.label = 1;
        if (au.a(l, this) == localObject)
        {
          AppMethodBeat.o(6784);
          return localObject;
        }
        break;
      case 1: 
        localObject = (ai)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        paramObject = localObject;
      }
      if (!aj.a(paramObject))
      {
        paramObject = kotlin.x.SXb;
        AppMethodBeat.o(6784);
        return paramObject;
      }
      synchronized (__BATCH_RUN_OBJ.INSTANCE)
      {
        localObject = __BATCH_RUN_OBJ.INSTANCE.getBatchData().get(this.$key);
        paramObject = localObject;
        if (!(localObject instanceof Queue)) {
          paramObject = null;
        }
        paramObject = (Queue)paramObject;
        if (paramObject != null)
        {
          __BATCH_RUN_OBJ.INSTANCE.getBatchData().remove(this.$key);
          paramObject = new ArrayList((Collection)paramObject);
          if (paramObject != null) {
            v.cH((List)paramObject);
          }
          __BATCH_RUN_OBJ.INSTANCE.getBatchJobs().remove(this.$key);
          paramObject = kotlin.x.SXb;
          AppMethodBeat.o(6784);
          return paramObject;
        }
        paramObject = null;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/mm/sdk/platformtools/MMBatchRunKt$batchRun$2"})
  public static final class m
    extends kotlin.d.b.a.j
    implements kotlin.g.a.m<ai, kotlin.d.d<? super kotlin.x>, Object>
  {
    Object L$0;
    int label;
    private ai p$;
    
    public m(long paramLong, String paramString1, kotlin.d.d paramd, int paramInt1, String paramString2, int paramInt2)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<kotlin.x> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(6796);
      p.h(paramd, "completion");
      paramd = new m(this.$delay, this.$key, paramd, paramString2, paramInt2, this.pEA);
      paramd.p$ = ((ai)paramObject);
      AppMethodBeat.o(6796);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(6797);
      paramObject1 = ((m)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(kotlin.x.SXb);
      AppMethodBeat.o(6797);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(6795);
      Object localObject1 = kotlin.d.a.a.SXO;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(6795);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.p$;
        long l = this.$delay;
        this.L$0 = paramObject;
        this.label = 1;
        if (au.a(l, this) == localObject1)
        {
          AppMethodBeat.o(6795);
          return localObject1;
        }
        break;
      case 1: 
        localObject1 = (ai)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        paramObject = localObject1;
      }
      if (!aj.a(paramObject))
      {
        paramObject = kotlin.x.SXb;
        AppMethodBeat.o(6795);
        return paramObject;
      }
      for (;;)
      {
        synchronized (__BATCH_RUN_OBJ.INSTANCE)
        {
          localObject1 = __BATCH_RUN_OBJ.INSTANCE.getBatchData().get(this.$key);
          paramObject = localObject1;
          if (!(localObject1 instanceof Queue)) {
            paramObject = null;
          }
          paramObject = (Queue)paramObject;
          if (paramObject != null)
          {
            __BATCH_RUN_OBJ.INSTANCE.getBatchData().remove(this.$key);
            paramObject = new ArrayList((Collection)paramObject);
            if (paramObject == null) {
              break;
            }
            paramObject = ((Iterable)paramObject).iterator();
            if (!paramObject.hasNext()) {
              break;
            }
            localObject1 = (v.b)paramObject.next();
            ??? = ((v.b)localObject1).edo;
            localObject3 = c.ahY(((v.b)localObject1).edo);
            Object localObject4 = com.tencent.mm.plugin.ad.c.ICA;
            localObject4 = com.tencent.mm.plugin.ad.c.fXj();
            v localv = v.pDG;
            ??? = new v.d((String)???, (String)localObject3, (com.tencent.mm.plugin.ad.b)localObject4, v.cor());
            if (!((v.d)???).coH()) {
              break label536;
            }
            if (((v.b)localObject1).pDJ) {
              continue;
            }
            int i = Math.max(((v.d)???).coD() - 60, 60);
            if ((((v.d)???).coE() > 0L) && (MMSlotKt.isExpire(((v.d)???).coE(), i)))
            {
              com.tencent.mm.plugin.report.service.h.CyF.a(21074, new Object[] { ((v.b)localObject1).host, Integer.valueOf(paramString2), Integer.valueOf(2), paramInt2, paramInt2, Integer.valueOf(2), Integer.valueOf(this.pEA) });
              localObject3 = v.pDG;
              v.a(((v.b)localObject1).pDI, ((v.b)localObject1).host, (v.d)???, ((v.b)localObject1).pDK);
              continue;
            }
          }
          else
          {
            paramObject = null;
          }
        }
        com.tencent.mm.plugin.report.service.h.CyF.a(21074, new Object[] { ((v.b)localObject1).host, Integer.valueOf(paramString2), Integer.valueOf(2), paramInt2, paramInt2, Integer.valueOf(1), Integer.valueOf(this.pEA) });
        continue;
        label536:
        com.tencent.mm.plugin.report.service.h.CyF.a(21074, new Object[] { ((v.b)localObject1).host, Integer.valueOf(paramString2), Integer.valueOf(2), paramInt2, paramInt2, Integer.valueOf(3), Integer.valueOf(this.pEA) });
        Object localObject3 = v.pDG;
        v.a(((v.b)localObject1).pDI, ((v.b)localObject1).host, (v.d)???, ((v.b)localObject1).pDK);
      }
      __BATCH_RUN_OBJ.INSTANCE.getBatchJobs().remove(this.$key);
      paramObject = kotlin.x.SXb;
      AppMethodBeat.o(6795);
      return paramObject;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyLitePrefetchResInfo;", "kotlin.jvm.PlatformType", "invoke"})
  static final class o
    extends q
    implements kotlin.g.a.b<bhd, String>
  {
    public static final o pEC;
    
    static
    {
      AppMethodBeat.i(195711);
      pEC = new o();
      AppMethodBeat.o(195711);
    }
    
    o()
    {
      super();
    }
  }
  
  @kotlin.d.b.a.f(c="com.tencent.mm.plugin.brandservice.ui.timeline.preload.WebPrefetcher$savePrefetch$1", f="WebPrefetcher.kt", hxM={975, 977, 980, 1003}, m="invokeSuspend")
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class p
    extends kotlin.d.b.a.j
    implements kotlin.g.a.m<ai, kotlin.d.d<? super kotlin.x>, Object>
  {
    Object L$0;
    int label;
    private ai p$;
    Object pED;
    Object pEE;
    Object pEF;
    Object pEG;
    Object pEH;
    Object pEI;
    Object pEJ;
    Object pEK;
    Object pEL;
    Object pEM;
    Object pEN;
    Object pEO;
    Object pEP;
    int pEQ;
    int pER;
    int pES;
    boolean pET;
    
    p(bhh parambhh, bhf parambhf, List paramList, kotlin.d.d paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<kotlin.x> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(195713);
      p.h(paramd, "completion");
      paramd = new p(this.pEU, this.pEV, this.pEW, paramd);
      paramd.p$ = ((ai)paramObject);
      AppMethodBeat.o(195713);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(195714);
      paramObject1 = ((p)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(kotlin.x.SXb);
      AppMethodBeat.o(195714);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(195712);
      kotlin.d.a.a locala = kotlin.d.a.a.SXO;
      Object localObject5;
      Object localObject6;
      Object localObject1;
      Object localObject3;
      Object localObject2;
      Object localObject4;
      int i;
      int j;
      Object localObject8;
      Object localObject11;
      Object localObject9;
      Object localObject12;
      boolean bool2;
      boolean bool1;
      label366:
      Object localObject10;
      label534:
      Object localObject13;
      int k;
      label603:
      label618:
      label624:
      int i1;
      label706:
      label836:
      int m;
      label786:
      label948:
      label1121:
      Object localObject14;
      label1054:
      Object localObject15;
      label1344:
      label1350:
      label1356:
      label1362:
      label1368:
      Object localObject16;
      label1532:
      Object localObject17;
      label1543:
      Object localObject18;
      Object localObject22;
      Object localObject19;
      Object localObject20;
      label2230:
      Object localObject23;
      Object localObject21;
      int n;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(195712);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        localObject5 = this.p$;
        localObject6 = new LinkedList();
        localObject1 = new z.a();
        ((z.a)localObject1).SYB = false;
        localObject3 = new z.a();
        ((z.a)localObject3).SYB = false;
        localObject2 = new HashMap();
        localObject4 = new HashMap();
        i = 0;
        j = this.pEU.KOL;
        if (i < j)
        {
          paramObject = new fak();
          ((z.a)localObject1).SYB = false;
          ((z.a)localObject3).SYB = false;
          paramObject.url = ((bhe)this.pEV.LRf.get(i)).LQZ;
          paramObject.pFJ = ((bhg)this.pEU.LRs.get(i)).LRh;
          localObject8 = paramObject.url;
          p.g(localObject8, "url");
          localObject11 = c.ahY((String)localObject8);
          localObject9 = this.pEV.LRf.get(i);
          localObject8 = localObject9;
          if (!(localObject9 instanceof h)) {
            localObject8 = null;
          }
          localObject8 = (h)localObject8;
          if (localObject8 != null)
          {
            paramObject.hDa = ((h)localObject8).hDa;
            paramObject.pmN = ((h)localObject8).pmN;
            localObject8 = kotlin.x.SXb;
          }
          localObject8 = paramObject.pFJ;
          p.g(localObject8, "fullUrl");
          if (!n.J((String)localObject8, "http", false)) {
            break label4548;
          }
          localObject12 = (Map)new LinkedHashMap();
          if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rTa, 1) == 1)
          {
            bool2 = true;
            localObject8 = com.tencent.mm.plugin.webview.core.g.ILB;
            if (!g.a.fZP()) {
              break label603;
            }
            bool1 = true;
            Log.i("MicroMsg.WebPrefetcher", "[TRACE_PREFETCH] useA8keyLiteHeader: " + bool2 + " mockUseA8keyLiteHeader: " + bool1);
            if (((!bool2) && (!bool1)) || (Util.isNullOrNil((List)((bhg)this.pEU.LRs.get(i)).LRq))) {
              break label706;
            }
            Log.i("MicroMsg.WebPrefetcher", "[TRACE_PREFETCH] response header size : " + ((bhg)this.pEU.LRs.get(i)).LRq.size());
            localObject8 = ((bhg)this.pEU.LRs.get(i)).LRq;
            p.g(localObject8, "RespInfo[i].HttpHeader");
            localObject9 = (Iterable)localObject8;
            localObject8 = (Collection)new ArrayList();
            localObject9 = ((Iterable)localObject9).iterator();
            if (!((Iterator)localObject9).hasNext()) {
              break label624;
            }
            localObject10 = ((Iterator)localObject9).next();
            localObject13 = (ccc)localObject10;
            if ((((ccc)localObject13).xMX != null) && (((ccc)localObject13).Cyk != null)) {
              break label618;
            }
          }
          for (k = 1;; k = 0)
          {
            if (k != 0) {
              break label534;
            }
            ((Collection)localObject8).add(localObject10);
            break label534;
            bool2 = false;
            break;
            bool1 = com.tencent.mm.plugin.webview.core.h.cdi().getBoolean("webview_use_a8key_lite_header", false);
            break label366;
          }
          localObject8 = ((Iterable)localObject8).iterator();
          while (((Iterator)localObject8).hasNext())
          {
            localObject10 = (ccc)((Iterator)localObject8).next();
            localObject9 = ((ccc)localObject10).xMX;
            p.g(localObject9, "it.Key");
            localObject10 = ((ccc)localObject10).Cyk;
            p.g(localObject10, "it.Value");
            ((Map)localObject12).put(localObject9, localObject10);
          }
          Log.i("MicroMsg.WebPrefetcher", "[TRACE_PREFETCH] useA8keyLiteHeader size : " + ((Map)localObject12).size() + " domains.size=" + this.pEW.size());
          paramObject.jsm = MMSlotKt.now();
          localObject8 = (Integer)this.pEU.LRr.get(i);
          if (localObject8 == null)
          {
            paramObject.NwD = true;
            if (!paramObject.NwD)
            {
              ((LinkedList)localObject6).add(paramObject.pFJ);
              ((z.a)localObject3).SYB = true;
            }
            localObject8 = (Collection)this.pEW;
            if ((localObject8 != null) && (!((Collection)localObject8).isEmpty())) {
              break label1344;
            }
            k = 1;
            if (k == 0) {
              com.tencent.mm.plugin.report.service.h.CyF.a(21075, new Object[] { Integer.valueOf(paramObject.hDa), paramObject.url, paramObject.pFJ, Integer.valueOf(1), Integer.valueOf(paramObject.pmN) });
            }
            localObject8 = v.pDG;
            localObject8 = paramObject.pFJ;
            p.g(localObject8, "fullUrl");
            localObject13 = v.n((String)localObject8, this.pEW);
            if (localObject13 == null) {
              break label1350;
            }
            localObject8 = ((com.tencent.mm.plugin.ad.a)localObject13).ICt;
            if (localObject8 == null) {
              break label1350;
            }
            localObject8 = ((bhd)localObject8).UserName;
            if (localObject13 == null) {
              break label3834;
            }
            com.tencent.mm.plugin.report.service.h.CyF.a(21075, new Object[] { Integer.valueOf(paramObject.hDa), paramObject.url, paramObject.pFJ, Integer.valueOf(2), Integer.valueOf(paramObject.pmN) });
            localObject10 = this.pEV.LRf.get(i);
            localObject9 = localObject10;
            if (!(localObject10 instanceof h)) {
              localObject9 = null;
            }
            localObject9 = (h)localObject9;
            if (localObject9 == null) {
              break label1356;
            }
            localObject9 = ((h)localObject9).extInfo;
            ((com.tencent.mm.plugin.ad.a)localObject13).extInfo = ((String)localObject9);
            ((com.tencent.mm.plugin.ad.a)localObject13).hDa = paramObject.hDa;
            ((com.tencent.mm.plugin.ad.a)localObject13).pmN = paramObject.pmN;
            Log.v("MicroMsg.WebPrefetcher", "match prefetch#".concat(String.valueOf(localObject11)));
            i1 = 0;
            m = 0;
            localObject10 = ((com.tencent.mm.plugin.ad.a)localObject13).ICt;
            if (localObject10 == null) {
              break label1362;
            }
            localObject10 = ((bhd)localObject10).jfi;
            localObject14 = (CharSequence)localObject10;
            if ((localObject14 != null) && (!n.aL((CharSequence)localObject14))) {
              break label1368;
            }
            k = 1;
          }
        }
        break;
      case 1: 
        for (;;)
        {
          if (k == 0)
          {
            localObject14 = com.tencent.mm.plugin.ad.c.ICA;
            if (c.a.fXn())
            {
              if (((com.tencent.mm.plugin.ad.a)localObject13).aXs) {
                break label4479;
              }
              localObject14 = com.tencent.mm.plugin.webcanvas.m.IAG;
              this.L$0 = localObject5;
              this.pED = localObject6;
              this.pEE = localObject1;
              this.pEF = localObject3;
              this.pEG = localObject2;
              this.pEH = localObject4;
              this.pEQ = i;
              this.pER = j;
              this.pEI = paramObject;
              this.pEJ = paramObject;
              this.pEK = localObject11;
              this.pEL = localObject12;
              this.pET = bool1;
              this.pEM = localObject13;
              this.pEN = localObject8;
              this.pEO = localObject9;
              this.pES = 1;
              this.pEP = localObject10;
              this.label = 1;
              localObject15 = com.tencent.mm.plugin.webcanvas.m.a((com.tencent.mm.plugin.ad.a)localObject13, (String)localObject10, (String)localObject8, this);
              if (localObject15 != locala) {
                break label4410;
              }
              AppMethodBeat.o(195712);
              return locala;
              if (((Integer)localObject8).intValue() != 0) {
                break;
              }
              if (((bhg)this.pEU.LRs.get(i)).LRm == 0) {
                break label786;
              }
              paramObject.NwE = true;
              break label786;
              k = 0;
              break label836;
              localObject8 = null;
              break label948;
              localObject9 = null;
              break label1054;
              localObject10 = null;
              break label1121;
              k = 0;
              continue;
              localObject4 = (String)this.pEP;
              i = this.pES;
              localObject5 = (String)this.pEO;
              localObject6 = (String)this.pEN;
              localObject9 = (com.tencent.mm.plugin.ad.a)this.pEM;
              bool1 = this.pET;
              localObject8 = (Map)this.pEL;
              localObject11 = (String)this.pEK;
              localObject10 = (fak)this.pEJ;
              localObject12 = (fak)this.pEI;
              j = this.pER;
              k = this.pEQ;
              localObject13 = (HashMap)this.pEH;
              localObject14 = (HashMap)this.pEG;
              localObject16 = (z.a)this.pEF;
              localObject1 = (z.a)this.pEE;
              localObject2 = (LinkedList)this.pED;
              localObject3 = (ai)this.L$0;
              ResultKt.throwOnFailure(paramObject);
              localObject15 = paramObject;
              paramObject = localObject16;
              if (((Boolean)localObject15).booleanValue())
              {
                bool2 = true;
                localObject15 = localObject4;
                m = i;
                localObject16 = localObject5;
                localObject17 = localObject6;
                localObject18 = localObject8;
                localObject4 = localObject11;
                localObject5 = localObject10;
                i = j;
                j = k;
                localObject6 = localObject13;
                localObject8 = localObject14;
                localObject14 = localObject12;
                localObject13 = localObject9;
                localObject12 = localObject18;
                localObject11 = localObject17;
                localObject10 = localObject16;
                k = m;
                localObject9 = localObject15;
              }
            }
          }
        }
      case 2: 
        for (;;)
        {
          Log.i("MicroMsg.WebPrefetcher", "savePrefetch appId=" + (String)localObject9 + " fetched=" + bool2);
          if (!bool2) {
            break;
          }
          localObject15 = y.pFf;
          localObject16 = ((fak)localObject5).pFJ;
          p.g(localObject16, "fullUrl");
          this.L$0 = localObject3;
          this.pED = localObject2;
          this.pEE = localObject1;
          this.pEF = paramObject;
          this.pEG = localObject8;
          this.pEH = localObject6;
          this.pEQ = j;
          this.pER = i;
          this.pEI = localObject14;
          this.pEJ = localObject5;
          this.pEK = localObject4;
          this.pEL = localObject12;
          this.pET = bool1;
          this.pEM = localObject13;
          this.pEN = localObject11;
          this.pEO = localObject10;
          this.pES = k;
          this.pEP = localObject9;
          this.label = 3;
          localObject22 = ((y)localObject15).a((com.tencent.mm.plugin.ad.a)localObject13, (String)localObject16, this);
          if (localObject22 != locala) {
            break label4574;
          }
          AppMethodBeat.o(195712);
          return locala;
          bool2 = false;
          localObject15 = localObject9;
          localObject16 = localObject11;
          localObject17 = localObject10;
          localObject18 = localObject12;
          m = k;
          localObject19 = localObject13;
          localObject20 = localObject14;
          localObject9 = localObject4;
          k = i;
          localObject10 = localObject5;
          localObject11 = localObject6;
          localObject12 = localObject8;
          localObject13 = localObject15;
          localObject4 = localObject16;
          localObject5 = localObject17;
          localObject14 = localObject18;
          i = j;
          j = m;
          localObject6 = localObject19;
          localObject8 = localObject20;
          continue;
          localObject14 = (CharSequence)((com.tencent.mm.plugin.ad.a)localObject13).ICt.LQV;
          if ((localObject14 == null) || (n.aL((CharSequence)localObject14))) {
            k = 1;
          }
          for (;;)
          {
            if (k == 0)
            {
              localObject14 = v.pDG;
              this.L$0 = localObject5;
              this.pED = localObject6;
              this.pEE = localObject1;
              this.pEF = localObject3;
              this.pEG = localObject2;
              this.pEH = localObject4;
              this.pEQ = i;
              this.pER = j;
              this.pEI = paramObject;
              this.pEJ = paramObject;
              this.pEK = localObject11;
              this.pEL = localObject12;
              this.pET = bool1;
              this.pEM = localObject13;
              this.pEN = localObject8;
              this.pEO = localObject9;
              this.pES = 0;
              this.pEP = localObject10;
              this.label = 2;
              Object localObject29 = v.a((com.tencent.mm.plugin.ad.a)localObject13, this);
              if (localObject29 != locala) {
                break label4342;
              }
              AppMethodBeat.o(195712);
              return locala;
              k = 0;
              continue;
              localObject14 = (String)this.pEP;
              k = this.pES;
              localObject13 = (String)this.pEO;
              localObject12 = (String)this.pEN;
              localObject9 = (com.tencent.mm.plugin.ad.a)this.pEM;
              bool1 = this.pET;
              localObject10 = (Map)this.pEL;
              localObject11 = (String)this.pEK;
              localObject8 = (fak)this.pEJ;
              localObject6 = (fak)this.pEI;
              j = this.pER;
              i = this.pEQ;
              localObject5 = (HashMap)this.pEH;
              localObject4 = (HashMap)this.pEG;
              localObject16 = (z.a)this.pEF;
              localObject1 = (z.a)this.pEE;
              localObject2 = (LinkedList)this.pED;
              localObject3 = (ai)this.L$0;
              ResultKt.throwOnFailure(paramObject);
              localObject15 = paramObject;
              paramObject = localObject16;
              localObject29 = localObject15;
              localObject28 = localObject14;
              i1 = k;
              localObject27 = localObject13;
              bool2 = bool1;
              localObject26 = localObject12;
              localObject25 = localObject10;
              localObject24 = localObject9;
              localObject23 = localObject11;
              localObject22 = localObject8;
              localObject21 = localObject6;
              n = j;
              m = i;
              localObject18 = paramObject;
              localObject17 = localObject1;
              localObject16 = localObject2;
              localObject15 = localObject3;
              localObject20 = localObject5;
              localObject19 = localObject4;
              if (!((Boolean)localObject29).booleanValue()) {
                break label2448;
              }
              bool2 = true;
              localObject15 = localObject10;
              localObject16 = localObject9;
              localObject17 = localObject11;
              m = i;
              localObject18 = localObject5;
              localObject19 = localObject4;
              localObject9 = localObject14;
              localObject10 = localObject13;
              localObject11 = localObject12;
              localObject12 = localObject15;
              localObject13 = localObject16;
              localObject4 = localObject17;
              localObject5 = localObject8;
              localObject14 = localObject6;
              i = j;
              j = m;
              localObject6 = localObject18;
              localObject8 = localObject19;
              break;
            }
          }
          localObject22 = paramObject;
          localObject19 = localObject2;
          localObject20 = localObject4;
          localObject15 = localObject5;
          localObject16 = localObject6;
          localObject17 = localObject1;
          localObject18 = localObject3;
          m = i;
          n = j;
          localObject21 = paramObject;
          localObject23 = localObject11;
          Object localObject24 = localObject13;
          Object localObject25 = localObject12;
          Object localObject26 = localObject8;
          bool2 = bool1;
          Object localObject27 = localObject9;
          Object localObject28 = localObject10;
          boolean bool3 = false;
          localObject9 = localObject28;
          k = i1;
          localObject10 = localObject27;
          bool1 = bool2;
          localObject11 = localObject26;
          localObject12 = localObject25;
          localObject13 = localObject24;
          localObject4 = localObject23;
          localObject5 = localObject22;
          localObject14 = localObject21;
          i = n;
          j = m;
          localObject6 = localObject20;
          localObject8 = localObject19;
          bool2 = bool3;
          paramObject = localObject18;
          localObject1 = localObject17;
          localObject2 = localObject16;
          localObject3 = localObject15;
        }
      case 3: 
        label2448:
        localObject10 = (String)this.pEP;
        n = this.pES;
        localObject18 = (String)this.pEO;
        localObject19 = (String)this.pEN;
        localObject9 = (com.tencent.mm.plugin.ad.a)this.pEM;
        bool1 = this.pET;
        localObject20 = (Map)this.pEL;
        localObject8 = (String)this.pEK;
        localObject6 = (fak)this.pEJ;
        localObject21 = (fak)this.pEI;
        j = this.pER;
        i = this.pEQ;
        localObject5 = (HashMap)this.pEH;
        localObject4 = (HashMap)this.pEG;
        localObject12 = (z.a)this.pEF;
        localObject1 = (z.a)this.pEE;
        localObject2 = (LinkedList)this.pED;
        localObject3 = (ai)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        localObject11 = paramObject;
        paramObject = localObject12;
        localObject22 = localObject11;
      }
      for (;;)
      {
        localObject23 = localObject8;
        localObject11 = localObject6;
        m = j;
        k = i;
        localObject17 = localObject5;
        localObject16 = localObject4;
        localObject15 = paramObject;
        localObject14 = localObject1;
        localObject13 = localObject2;
        localObject12 = localObject3;
        if (((Boolean)localObject22).booleanValue())
        {
          if (((com.tencent.mm.plugin.ad.a)localObject9).aXs)
          {
            localObject11 = Uri.parse(((fak)localObject6).pFJ);
            p.g(localObject11, "Uri.parse(fullUrl)");
          }
          for (localObject11 = ((Uri)localObject11).getHost();; localObject11 = localObject10)
          {
            ((fak)localObject6).appId = ((String)localObject11);
            ((fak)localObject6).pDI = ((fak)localObject6).pFJ;
            localObject11 = j.pCC;
            if (k.cdi().getBoolean("tencent_view_inews_prefix", false))
            {
              localObject11 = ((fak)localObject6).pDI;
              p.g(localObject11, "prefetchUrl");
              ((fak)localObject6).pDI = n.by((String)localObject11, "//view.inews.qq.com", "//ssr.view.inews.qq.com");
            }
            ((fak)localObject6).NwF = true;
            localObject11 = v.pDG;
            v.a((fak)localObject6);
            Log.i("MicroMsg.WebPrefetcher", "prefetch call, header size: " + ((Map)localObject20).size() + ", url: " + ((fak)localObject6).pDI);
            com.tencent.mm.plugin.report.service.h.CyF.a(21075, new Object[] { Integer.valueOf(((fak)localObject6).hDa), ((fak)localObject6).url, ((fak)localObject6).pFJ, Integer.valueOf(3), Integer.valueOf(((fak)localObject6).pmN) });
            if (n == 0)
            {
              localObject11 = v.pDG;
              localObject11 = ((fak)localObject6).url;
              p.g(localObject11, "url");
              localObject12 = ((fak)localObject6).pDI;
              p.g(localObject12, "prefetchUrl");
              v.b((String)localObject11, (String)localObject12, (Map)localObject20, ((fak)localObject6).hDa, ((fak)localObject6).pmN);
            }
            ((z.a)localObject1).SYB = true;
            localObject22 = localObject8;
            localObject14 = localObject6;
            m = j;
            k = i;
            localObject17 = localObject5;
            localObject16 = localObject4;
            localObject15 = paramObject;
            localObject13 = localObject1;
            localObject12 = localObject2;
            localObject11 = localObject3;
            if (n != 0) {
              break label3473;
            }
            localObject11 = y.pFf;
            this.L$0 = localObject3;
            this.pED = localObject2;
            this.pEE = localObject1;
            this.pEF = paramObject;
            this.pEG = localObject4;
            this.pEH = localObject5;
            this.pEQ = i;
            this.pER = j;
            this.pEI = localObject21;
            this.pEJ = localObject6;
            this.pEK = localObject8;
            this.pEL = localObject20;
            this.pET = bool1;
            this.pEM = localObject9;
            this.pEN = localObject19;
            this.pEO = localObject18;
            this.pEP = localObject10;
            this.label = 4;
            localObject12 = ((y)localObject11).b((com.tencent.mm.plugin.ad.a)localObject9, this);
            localObject11 = localObject12;
            localObject10 = localObject9;
            if (localObject12 != locala) {
              break;
            }
            AppMethodBeat.o(195712);
            return locala;
          }
          localObject10 = (com.tencent.mm.plugin.ad.a)this.pEM;
          localObject8 = (String)this.pEK;
          localObject6 = (fak)this.pEJ;
          j = this.pER;
          i = this.pEQ;
          localObject5 = (HashMap)this.pEH;
          localObject4 = (HashMap)this.pEG;
          localObject11 = (z.a)this.pEF;
          localObject1 = (z.a)this.pEE;
          localObject2 = (LinkedList)this.pED;
          localObject3 = (ai)this.L$0;
          ResultKt.throwOnFailure(paramObject);
          localObject9 = paramObject;
          paramObject = localObject11;
          localObject11 = localObject9;
          localObject11 = (Iterable)localObject11;
          localObject9 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject11, 10));
          localObject11 = ((Iterable)localObject11).iterator();
          while (((Iterator)localObject11).hasNext()) {
            ((Collection)localObject9).add(new v.c((String)((Iterator)localObject11).next(), v.e.pEa, ((fak)localObject6).hDa));
          }
          localObject9 = (List)localObject9;
          localObject11 = v.pDG;
          localObject10 = ((com.tencent.mm.plugin.ad.a)localObject10).ICs.LQP;
          p.g(localObject10, "manifest.domain.Domain");
          v.g((List)localObject9, (String)localObject10);
          localObject9 = kotlin.x.SXb;
          localObject11 = localObject3;
          localObject12 = localObject2;
          localObject13 = localObject1;
          localObject15 = paramObject;
          localObject16 = localObject4;
          localObject17 = localObject5;
          k = i;
          m = j;
          localObject14 = localObject6;
          localObject22 = localObject8;
          label3473:
          Log.v("MicroMsg.WebPrefetcher", "end prefetch #" + localObject22 + ' ' + ((fak)localObject14).pDI);
          j = m;
          i = k;
          localObject2 = localObject17;
          localObject4 = localObject16;
          localObject3 = localObject15;
          localObject1 = localObject13;
          paramObject = localObject12;
          localObject5 = localObject11;
          localObject11 = localObject14;
        }
        for (;;)
        {
          try
          {
            localObject6 = v.pDG;
            k = v.ahE(((fak)localObject11).url);
            localObject6 = (Integer)((HashMap)localObject2).get(Integer.valueOf(k));
            if (localObject6 != null) {
              continue;
            }
            ((Map)localObject2).put(Integer.valueOf(k), Integer.valueOf(1));
            localObject6 = ((fak)localObject11).url;
            p.g(localObject6, "url");
            com.tencent.mm.plugin.webview.i.b.a(0, (String)localObject6, false, false, true, ((z.a)localObject3).SYB, ((z.a)localObject1).SYB, true);
            localObject6 = (Integer)((HashMap)localObject4).get(Integer.valueOf(k));
            if (localObject6 != null) {
              continue;
            }
            ((Map)localObject4).put(Integer.valueOf(k), Integer.valueOf(1));
            k = j;
            localObject6 = paramObject;
            paramObject = localObject3;
            j = i;
            i = k;
          }
          catch (Exception localException)
          {
            label3834:
            Log.e("MicroMsg.WebPrefetcher", "Report Error");
            k = i;
            localObject7 = paramObject;
            i = j;
            j = k;
            paramObject = localObject3;
            continue;
            ((Map)localObject4).put(Integer.valueOf(k), Integer.valueOf(localObject7.intValue() + 1));
            k = i;
            localObject7 = paramObject;
            i = j;
            j = k;
            paramObject = localObject3;
            continue;
          }
          localObject3 = kotlin.x.SXb;
          k = j + 1;
          localObject3 = localObject2;
          localObject2 = localObject4;
          localObject4 = localObject3;
          j = i;
          i = k;
          localObject3 = paramObject;
          break;
          localObject12 = localObject3;
          localObject13 = localObject2;
          localObject14 = localObject1;
          localObject15 = paramObject;
          localObject16 = localObject8;
          localObject17 = localObject6;
          k = j;
          m = i;
          localObject11 = localObject5;
          localObject23 = localObject4;
          paramObject = v.pDG;
          v.a((fak)localObject11);
          Log.w("MicroMsg.WebPrefetcher", "fail to prefetch #" + localObject23 + ' ' + ((fak)localObject11).url);
          j = m;
          i = k;
          localObject2 = localObject17;
          localObject4 = localObject16;
          localObject3 = localObject15;
          localObject1 = localObject14;
          paramObject = localObject13;
          localObject5 = localObject12;
          continue;
          localObject8 = v.pDG;
          v.a(paramObject);
          localObject11 = paramObject;
          localObject8 = localObject2;
          paramObject = localObject6;
          localObject2 = localObject4;
          localObject4 = localObject8;
          continue;
          ((Map)localObject2).put(Integer.valueOf(k), Integer.valueOf(((Integer)localObject6).intValue() + 1));
          continue;
          if (!((Collection)localObject7).isEmpty()) {
            i = 1;
          }
          for (;;)
          {
            if (i != 0) {}
            try
            {
              paramObject = v.pDG;
              v.cI((List)localObject7);
              com.tencent.mm.plugin.webview.i.b.ago(this.pEU.KOL);
              localObject1 = (Map)localObject2;
              paramObject = (Collection)new ArrayList(((Map)localObject1).size());
              localObject1 = ((Map)localObject1).entrySet().iterator();
              while (((Iterator)localObject1).hasNext())
              {
                localObject3 = (Map.Entry)((Iterator)localObject1).next();
                i = ((Number)((Map.Entry)localObject3).getKey()).intValue();
                com.tencent.mm.plugin.webview.i.b.ki(((Number)((Map.Entry)localObject3).getValue()).intValue(), i);
                paramObject.add(kotlin.x.SXb);
                continue;
                i = 0;
              }
            }
            catch (Exception paramObject)
            {
              for (;;)
              {
                Log.e("MicroMsg.WebPrefetcher", "preDns ex " + paramObject.getMessage());
              }
              localObject1 = (Map)localObject4;
              paramObject = (Collection)new ArrayList(((Map)localObject1).size());
              localObject1 = ((Map)localObject1).entrySet().iterator();
              while (((Iterator)localObject1).hasNext())
              {
                localObject3 = (Map.Entry)((Iterator)localObject1).next();
                i = ((Number)((Map.Entry)localObject3).getKey()).intValue();
                j = ((Number)((Map.Entry)localObject3).getValue()).intValue();
                com.tencent.mm.plugin.webview.i.b.kj(j, i);
                if (((HashMap)localObject2).get(Integer.valueOf(i)) != null)
                {
                  localObject3 = ((HashMap)localObject2).get(Integer.valueOf(i));
                  if (localObject3 == null) {
                    p.hyc();
                  }
                  if (p.compare(((Number)localObject3).intValue(), j) > 0)
                  {
                    localObject3 = ((HashMap)localObject2).get(Integer.valueOf(i));
                    if (localObject3 == null) {
                      p.hyc();
                    }
                    com.tencent.mm.plugin.webview.i.b.kk(((Number)localObject3).intValue() - j, i);
                  }
                }
                paramObject.add(kotlin.x.SXb);
              }
              paramObject = kotlin.x.SXb;
              AppMethodBeat.o(195712);
              return paramObject;
            }
          }
          label4342:
          localObject16 = localObject8;
          localObject17 = localObject12;
          localObject18 = localObject13;
          localObject8 = paramObject;
          localObject15 = localObject2;
          localObject2 = localObject7;
          localObject14 = localObject10;
          k = m;
          localObject13 = localObject9;
          localObject12 = localObject16;
          localObject10 = localObject17;
          localObject9 = localObject18;
          localObject7 = paramObject;
          paramObject = localObject3;
          localObject3 = localObject5;
          localObject5 = localObject4;
          localObject4 = localObject15;
          break label2230;
          label4410:
          localObject16 = localObject10;
          m = 1;
          localObject17 = localObject13;
          localObject10 = paramObject;
          k = i;
          localObject13 = localObject4;
          localObject14 = localObject2;
          localObject2 = localObject7;
          localObject18 = localObject5;
          localObject4 = localObject16;
          i = m;
          localObject5 = localObject9;
          localObject7 = localObject8;
          localObject8 = localObject12;
          localObject9 = localObject17;
          localObject12 = paramObject;
          paramObject = localObject3;
          localObject3 = localObject18;
          break label1532;
          label4479:
          localObject15 = localObject10;
          m = 1;
          localObject16 = localObject13;
          localObject10 = paramObject;
          k = i;
          localObject13 = localObject4;
          localObject14 = localObject2;
          localObject2 = localObject7;
          localObject17 = localObject5;
          localObject4 = localObject15;
          i = m;
          localObject5 = localObject9;
          localObject7 = localObject8;
          localObject8 = localObject12;
          localObject9 = localObject16;
          localObject12 = paramObject;
          paramObject = localObject3;
          localObject3 = localObject17;
          break label1543;
          label4548:
          k = i;
          localObject8 = localObject2;
          paramObject = localObject3;
          i = j;
          j = k;
          localObject2 = localObject4;
          localObject4 = localObject8;
        }
        label4574:
        localObject18 = localObject10;
        m = j;
        localObject15 = localObject7;
        localObject16 = localObject8;
        localObject10 = localObject9;
        n = k;
        localObject19 = localObject11;
        localObject20 = localObject12;
        localObject9 = localObject13;
        localObject8 = localObject4;
        Object localObject7 = localObject5;
        localObject21 = localObject14;
        j = i;
        i = m;
        localObject5 = localObject15;
        localObject4 = localObject16;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "kotlin.jvm.PlatformType", "it", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyLiteReqInfo;", "invoke"})
  static final class q
    extends q
    implements kotlin.g.a.b<bhe, String>
  {
    public static final q pEX;
    
    static
    {
      AppMethodBeat.i(195716);
      pEX = new q();
      AppMethodBeat.o(195716);
    }
    
    q()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class r
    extends q
    implements kotlin.g.a.a<kotlin.x>
  {
    r(bhf parambhf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.v
 * JD-Core Version:    0.7.0.1
 */