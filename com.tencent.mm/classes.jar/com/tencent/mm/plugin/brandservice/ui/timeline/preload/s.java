package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import android.content.Context;
import android.net.Uri;
import com.tencent.e.i;
import com.tencent.mars.cdn.CronetLogic;
import com.tencent.mars.cdn.CronetLogic.CronetDownloadProgress;
import com.tencent.mars.cdn.CronetLogic.CronetTaskCallback;
import com.tencent.mars.cdn.CronetLogic.CronetTaskResult;
import com.tencent.mars.cdn.CronetLogic.ResponseHeader;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.network.ai;
import com.tencent.mm.network.z;
import com.tencent.mm.plugin.appbrand.ac.p.a;
import com.tencent.mm.plugin.brandservice.a.f.a;
import com.tencent.mm.plugin.brandservice.a.f.b;
import com.tencent.mm.plugin.webview.core.g.a;
import com.tencent.mm.plugin.webview.i.e;
import com.tencent.mm.plugin.webview.k.h.a;
import com.tencent.mm.protocal.protobuf.bol;
import com.tencent.mm.protocal.protobuf.bom;
import com.tencent.mm.protocal.protobuf.bon;
import com.tencent.mm.protocal.protobuf.boo;
import com.tencent.mm.protocal.protobuf.bop;
import com.tencent.mm.protocal.protobuf.bor;
import com.tencent.mm.protocal.protobuf.fla;
import com.tencent.mm.protocal.protobuf.flb;
import com.tencent.mm.protocal.protobuf.flc;
import com.tencent.mm.protocal.protobuf.tw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMCacheSlotManager;
import com.tencent.mm.sdk.platformtools.MMKVSlotManager;
import com.tencent.mm.sdk.platformtools.MMSlotKt;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.__BATCH_RUN_OBJ;
import com.tencent.mm.vfs.u;
import com.tencent.xweb.WebResourceResponse;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.List<+Lcom.tencent.mm.plugin.brandservice.a.f.a;>;
import java.util.List<Ljava.lang.String;>;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import kotlin.ResultKt;
import kotlin.a.ae;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;
import kotlin.x;
import kotlinx.coroutines.ak;
import kotlinx.coroutines.al;
import kotlinx.coroutines.aw;
import kotlinx.coroutines.bc;
import kotlinx.coroutines.br;
import kotlinx.coroutines.by;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher;", "", "()V", "MIN_EXPIRE_SECONDS", "", "PRE_AUTH_EXPIRE_SECONDS", "REFRESH_BEFORE_EXPIRE_SECONDS", "value", "currentScene", "getCurrentScene", "()I", "setCurrentScene", "(I)V", "pkgUrlManager", "Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "getPkgUrlManager$plugin_brandservice_release", "()Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "preauthRequestLimiter", "Lcom/tencent/mm/sdk/platformtools/MMCacheSlotManager;", "getPreauthRequestLimiter$plugin_brandservice_release", "()Lcom/tencent/mm/sdk/platformtools/MMCacheSlotManager;", "prefetchInfoManager", "getPrefetchInfoManager$plugin_brandservice_release", "prefetchNewTestFirstMainControlSwitch", "getPrefetchNewTestFirstMainControlSwitch", "prefetchNewTestFirstMainControlSwitch$delegate", "Lkotlin/Lazy;", "prefetchNewTestManager", "prefetchNewTestSecondControlClose", "getPrefetchNewTestSecondControlClose", "prefetchNewTestSecondControlClose$delegate", "prefetchNewTestSecondControlScene", "getPrefetchNewTestSecondControlScene", "prefetchNewTestSecondControlScene$delegate", "prefetchTestMode", "", "getPrefetchTestMode", "()Z", "prefetchTestMode$delegate", "resHeadersManager", "getResHeadersManager$plugin_brandservice_release", "sendingGetA8keyLiteQueue", "Ljava/util/concurrent/ConcurrentSkipListSet;", "", "settingManager", "getSettingManager$plugin_brandservice_release", "userAgentInfo", "Lcom/tencent/mm/plugin/webview/util/WebPrefetchUserAgentInfo;", "getUserAgentInfo", "()Lcom/tencent/mm/plugin/webview/util/WebPrefetchUserAgentInfo;", "userAgentInfo$delegate", "webHeadersManager", "getWebHeadersManager$plugin_brandservice_release", "webIdToSceneManager", "getWebIdToSceneManager$plugin_brandservice_release", "clearPrefetchContent", "", "url", "debugPreloadWebInfo", "", "(Ljava/lang/String;)[[Ljava/lang/String;", "fetchBizPkg", "target", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchTarget;", "prefetchHeaders", "", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchTarget;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchContent", "host", "deep", "fetchManifest", "manifest", "Lcom/tencent/mm/plugin/webprefetcher/PrefetchManifest;", "(Lcom/tencent/mm/plugin/webprefetcher/PrefetchManifest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchRes", "batchRes", "", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchRes;", "documentUrl", "genCorsOrigin", "getPreAuthUrl", "getPrefetchContentResp", "Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService$PrefetchResponse;", "getPrefetchResResp", "referer", "appId", "getReportScene", "getRespUrl", "getUrlCookie", "getUrlScene", "getValidPreloadWebInfo", "Lcom/tencent/mm/protocal/protobuf/WebPrefetchInfo;", "isDnsCached", "isInPreAuthWhiteList", "isUrlCache", "isUrlCanPreAuth", "isUrlPreAuthed", "isWebUrlEqual", "rawUrl", "targetUrl", "isWebUrlStorageEqual", "matchManifest", "domains", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyLitePrefetchDomainInfo;", "needReauth", "preAuth", "title", "desc", "from", "scene", "delayTime", "", "preAuths", "auths", "Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService$PreAuthInfo;", "preDns", "urls", "prefetch", "prefetchUrl", "checkCacheOnly", "headers", "bizScene", "subBizScene", "needDownloadPkg", "sendGetA8KeyLiteRequest", "preauths", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$BatchPreauth;", "setUrlToScene", "connect", "Lcom/tencent/mm/network/MMHttpUrlCronetConnection;", "receiveHeader", "Lkotlin/Function1;", "targetFile", "Lcom/tencent/mm/vfs/VFSFile;", "onCompleted", "mockManifest", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyLiteResponse;", "prepare", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyLiteRequest;", "save", "saveDomainInfos", "saveManifest", "localPrefetchDomainInfos", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protobuf/ByteString;", "(Lcom/tencent/mm/protocal/protobuf/GetA8KeyLiteResponse;Ljava/util/LinkedList;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "savePrefetch", "request", "(Lcom/tencent/mm/protocal/protobuf/GetA8KeyLiteResponse;Lcom/tencent/mm/protocal/protobuf/GetA8KeyLiteRequest;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "BatchPreauth", "PrefetchAction", "PrefetchRes", "PrefetchTarget", "PrefetchType", "plugin-brandservice_release"})
public final class s
{
  private static final MMKVSlotManager sNJ;
  private static final MMKVSlotManager sNK;
  private static final MMKVSlotManager sNL;
  private static final MMKVSlotManager sNM;
  private static final MMKVSlotManager sNN;
  private static final MMKVSlotManager sNO;
  private static final ConcurrentSkipListSet<String> sNP;
  private static final kotlin.f sNQ;
  private static final kotlin.f sNR;
  private static final kotlin.f sNS;
  private static final kotlin.f sNT;
  private static final MMCacheSlotManager sNU;
  private static final kotlin.f sNV;
  private static final MMKVSlotManager sNW;
  public static final s sNX;
  
  static
  {
    AppMethodBeat.i(6809);
    sNX = new s();
    sNJ = new MMKVSlotManager(v.cDa(), 43200L);
    sNK = new MMKVSlotManager(v.cDa(), 604800L);
    sNL = new MMKVSlotManager(v.cDa(), 86400L);
    sNM = new MMKVSlotManager(v.cDa(), 604800L);
    sNN = new MMKVSlotManager(v.cDa(), 86400L);
    sNO = new MMKVSlotManager(v.cDb(), 25200L);
    sNP = new ConcurrentSkipListSet();
    sNQ = kotlin.g.ar((kotlin.g.a.a)r.sPg);
    sNR = kotlin.g.ar((kotlin.g.a.a)s.sPh);
    sNS = kotlin.g.ar((kotlin.g.a.a)t.sPi);
    sNT = kotlin.g.ar((kotlin.g.a.a)ab.sPH);
    sNU = new MMCacheSlotManager();
    sNV = kotlin.g.ar((kotlin.g.a.a)u.sPj);
    sNW = new MMKVSlotManager(q.cCt(), 172800L);
    AppMethodBeat.o(6809);
  }
  
  public static void Hh(int paramInt)
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
  
  public static f.b P(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(257162);
    kotlin.g.b.p.k(paramString1, "referer");
    kotlin.g.b.p.k(paramString2, "url");
    Log.d("MicroMsg.WebPrefetcher", "alvinluo getPrefetchResResp appId: " + paramString3 + ", url: %s", new Object[] { paramString2 });
    String str = c.ft(c.getHost(paramString1), paramString2);
    com.tencent.mm.plugin.ax.c.a locala = com.tencent.mm.plugin.ax.c.PwQ;
    paramString1 = new d(paramString2, str, com.tencent.mm.plugin.ax.c.gPX(), sNM, c.getHost(paramString1), paramString3, null, null, false, 448).cCW();
    AppMethodBeat.o(257162);
    return paramString1;
  }
  
  private static z a(z paramz, d paramd, com.tencent.mm.vfs.q paramq, kotlin.g.a.b<? super Integer, Boolean> paramb, kotlin.g.a.b<? super Boolean, x> paramb1)
  {
    AppMethodBeat.i(257153);
    if ((paramq == null) && (paramd.sOm == null))
    {
      Log.e("MicroMsg.WebPrefetcher", "invalid file");
      AppMethodBeat.o(257153);
      return paramz;
    }
    com.tencent.mm.vfs.q localq = paramq;
    if (paramq == null)
    {
      paramq = paramd.sOm;
      if (paramq == null) {
        kotlin.g.b.p.iCn();
      }
      localq = paramq.biA(paramd.cCK());
    }
    if (localq.ifE())
    {
      if (n.ba((CharSequence)paramd.cCS())) {
        break label148;
      }
      i = 1;
      label87:
      if (i != 0) {
        paramz.bP("x-wx-if-none-match", paramd.cCS());
      }
      if (n.ba((CharSequence)paramd.cCT())) {
        break label154;
      }
    }
    label148:
    label154:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        paramz.bP("if-none-match", paramd.cCT());
      }
      a(paramz, localq, paramb, paramb1);
      break;
      i = 0;
      break label87;
    }
  }
  
  private static z a(z paramz, final com.tencent.mm.vfs.q paramq, final kotlin.g.a.b<? super Integer, Boolean> paramb, final kotlin.g.a.b<? super Boolean, x> paramb1)
  {
    AppMethodBeat.i(257150);
    Object localObject1 = MMApplicationContext.getContext();
    Object localObject2 = com.tencent.mm.plugin.webview.k.h.QAa;
    localObject1 = com.tencent.mm.plugin.appbrand.ac.p.a((Context)localObject1, h.a.hcr(), (p.a)sNT.getValue());
    paramz.bP("User-Agent", (String)localObject1);
    paramz.bty();
    paramz.gM(false);
    paramz.Zu("GET");
    paramz.btA();
    localObject2 = u.n(paramq.getPath(), true);
    paramz.setSavePath((String)localObject2 + ".fd");
    Log.v("MicroMsg.WebPrefetcher", "connect targetPath: " + (String)localObject2 + ", prefetch UA: " + (String)localObject1);
    paramz.btz();
    paramz.a((CronetLogic.CronetTaskCallback)new f(paramz, (String)localObject2, paramq, paramb, paramb1));
    paramz.xA(10000);
    paramz.xz(3000);
    paramz.connect();
    AppMethodBeat.o(257150);
    return paramz;
  }
  
  private static void a(flc paramflc)
  {
    AppMethodBeat.i(257176);
    String str1 = paramflc.url;
    kotlin.g.b.p.j(str1, "url");
    str1 = c.apK(str1);
    String str2 = paramflc.pHq;
    kotlin.g.b.p.j(str2, "fullUrl");
    paramflc.fIZ = c.aL(str2, true);
    ((MultiProcessMMKV)sNJ.getSlotForWrite()).encode(str1, paramflc.toByteArray());
    Log.i("MicroMsg.WebPrefetcher", "save preauth webid:" + str1 + " bizId: " + paramflc.fIZ + " prefetch:" + paramflc.UJS + ", authorized:" + paramflc.UJR + ", antispam:" + paramflc.UJQ + ", lastModify:" + paramflc.mhP + ", appId: " + paramflc.appId + ", url: %s", new Object[] { paramflc.url });
    AppMethodBeat.o(257176);
  }
  
  public static final void a(String arg0, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, long paramLong)
  {
    AppMethodBeat.i(257167);
    kotlin.g.b.p.k(???, "url");
    kotlin.g.b.p.k(paramString2, "appId");
    kotlin.g.b.p.k(paramString3, "title");
    kotlin.g.b.p.k(paramString4, "desc");
    kotlin.g.b.p.k(paramString5, "from");
    Log.v("MicroMsg.WebPrefetcher", "preAuth: " + paramString3 + ' ' + ???);
    paramString2 = new a(???, paramString2, paramString3, paramString4, paramInt, 0, null, null, 224);
    paramString3 = sNX;
    paramString4 = a.class.getCanonicalName() + '_' + "addToPreload";
    synchronized (__BATCH_RUN_OBJ.INSTANCE)
    {
      paramString5 = (by)__BATCH_RUN_OBJ.INSTANCE.getBatchJobs().get(paramString4);
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
        AppMethodBeat.o(257167);
        throw paramString2;
      }
    }
    ((LinkedList)paramString5).add(paramString2);
    ((Map)__BATCH_RUN_OBJ.INSTANCE.getBatchJobs()).put(paramString4, kotlinx.coroutines.g.b((ak)br.abxo, (kotlin.d.f)bc.iRs(), (kotlin.g.a.m)new o(paramLong, paramString4, null, paramString3), 2));
    AppMethodBeat.o(257167);
  }
  
  private static void a(String arg0, final String paramString2, String paramString3, Map<String, String> paramMap, final int paramInt1, final int paramInt2, final com.tencent.mm.plugin.ax.a parama, final boolean paramBoolean)
  {
    AppMethodBeat.i(257156);
    paramMap = new b(c.getHost(???), ???, paramString2, false, paramMap, (byte)0);
    String str = b.class.getCanonicalName() + '_' + "batch";
    Object localObject;
    synchronized (__BATCH_RUN_OBJ.INSTANCE)
    {
      localObject = (by)__BATCH_RUN_OBJ.INSTANCE.getBatchJobs().get(str);
      if (localObject != null) {
        ((by)localObject).a(null);
      }
      localObject = __BATCH_RUN_OBJ.INSTANCE.getBatchData();
      if (!((HashMap)localObject).containsKey(str)) {
        ((Map)localObject).put(str, new LinkedList());
      }
      localObject = ((HashMap)localObject).get(str);
      if (localObject == null)
      {
        paramString2 = new t("null cannot be cast to non-null type java.util.LinkedList<T>");
        AppMethodBeat.o(257156);
        throw paramString2;
      }
    }
    ((LinkedList)localObject).add(paramMap);
    ((Map)__BATCH_RUN_OBJ.INSTANCE.getBatchJobs()).put(str, kotlinx.coroutines.g.b((ak)br.abxo, (kotlin.d.f)bc.iRs(), (kotlin.g.a.m)new q(50L, str, null, paramString3, parama, paramBoolean, paramInt1, paramString2, paramInt2), 2));
    AppMethodBeat.o(257156);
  }
  
  public static boolean apm(String paramString)
  {
    AppMethodBeat.i(257180);
    kotlin.g.b.p.k(paramString, "url");
    if (aqc(paramString) != null)
    {
      AppMethodBeat.o(257180);
      return true;
    }
    AppMethodBeat.o(257180);
    return false;
  }
  
  public static int app(String paramString)
  {
    AppMethodBeat.i(175492);
    int i;
    switch (cCG())
    {
    default: 
      i = cCG();
      AppMethodBeat.o(175492);
      return i;
    }
    if (paramString != null)
    {
      aqg(paramString);
      i = aqg(paramString);
      AppMethodBeat.o(175492);
      return i;
    }
    AppMethodBeat.o(175492);
    return 0;
  }
  
  public static f.b apq(String paramString)
  {
    AppMethodBeat.i(257160);
    kotlin.g.b.p.k(paramString, "url");
    String str = c.apK(paramString);
    com.tencent.mm.plugin.ax.c.a locala = com.tencent.mm.plugin.ax.c.PwQ;
    paramString = new d(paramString, str, com.tencent.mm.plugin.ax.c.gPW(), sNL, null, null, Boolean.TRUE, null, false, 432).cCW();
    AppMethodBeat.o(257160);
    return paramString;
  }
  
  public static void apr(String paramString)
  {
    AppMethodBeat.i(6803);
    kotlin.g.b.p.k(paramString, "url");
    Object localObject1 = c.apK(paramString);
    Object localObject2 = com.tencent.mm.plugin.ax.c.PwQ;
    localObject2 = com.tencent.mm.plugin.ax.c.gPW().biA((String)localObject1);
    if (((com.tencent.mm.vfs.q)localObject2).ifE()) {
      ((com.tencent.mm.vfs.q)localObject2).cFq();
    }
    localObject2 = (MultiProcessMMKV)sNL.findSlot((String)localObject1);
    if (localObject2 != null) {
      ((MultiProcessMMKV)localObject2).remove((String)localObject1);
    }
    localObject1 = (MultiProcessMMKV)sNJ.findSlot(c.apK(paramString));
    if (localObject1 != null)
    {
      ((MultiProcessMMKV)localObject1).removeValueForKey(c.apK(paramString));
      AppMethodBeat.o(6803);
      return;
    }
    AppMethodBeat.o(6803);
  }
  
  private static boolean aqa(String paramString)
  {
    AppMethodBeat.i(257159);
    kotlin.g.b.p.k(paramString, "url");
    String str = c.apK(paramString);
    com.tencent.mm.plugin.ax.c.a locala = com.tencent.mm.plugin.ax.c.PwQ;
    paramString = new d(paramString, str, com.tencent.mm.plugin.ax.c.gPW(), sNL, null, null, null, null, false, 496);
    boolean bool1 = paramString.cCU();
    boolean bool2 = paramString.isRedirect();
    if ((bool1) && (!bool2))
    {
      AppMethodBeat.o(257159);
      return true;
    }
    if (bool2)
    {
      if (((CharSequence)paramString.getLocation()).length() > 0) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label113;
        }
        paramString = paramString.getLocation();
        break;
      }
    }
    label113:
    AppMethodBeat.o(257159);
    return false;
  }
  
  public static flc aqc(String paramString)
  {
    AppMethodBeat.i(257179);
    String str = c.apK(paramString);
    Object localObject1 = (MultiProcessMMKV)sNJ.findSlot(str);
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
    flc localflc;
    for (;;)
    {
      try
      {
        Object localObject2 = flc.class.newInstance();
        ((com.tencent.mm.cd.a)localObject2).parseFrom((byte[])localObject1);
        localObject1 = (com.tencent.mm.cd.a)localObject2;
        localObject1 = (flc)localObject1;
        if (localObject1 == null) {
          break label319;
        }
        boolean bool = MMSlotKt.isExpire(((flc)localObject1).mhP, 600);
        Log.d("MicroMsg.WebPrefetcher", "[TRACE_PREFETCH] getValidPreloadWebInfo: webId#" + str + ", bizId: " + ((flc)localObject1).fIZ + "  prefetch:" + ((flc)localObject1).UJS + ", authorized:" + ((flc)localObject1).UJR + ", antispam:" + ((flc)localObject1).UJQ + ", lastModify:" + ((flc)localObject1).mhP + ", expire:" + bool + ", url:" + paramString);
        if ((!((flc)localObject1).UJQ) && (!bool)) {
          break label275;
        }
        AppMethodBeat.o(257179);
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
      localflc = null;
      continue;
      localflc = null;
    }
    label275:
    if (!localflc.UJR)
    {
      AppMethodBeat.o(257179);
      return localflc;
    }
    if ((localflc.UJS) && (localflc.UJR) && (aqa(paramString)))
    {
      AppMethodBeat.o(257179);
      return localflc;
    }
    label319:
    Log.v("MicroMsg.WebPrefetcher", "[TRACE_PREFETCH] getValidPreloadWebInfo: webId#" + str + ", not cached, url:" + paramString + ' ');
    AppMethodBeat.o(257179);
    return null;
  }
  
  private static boolean aqd(String paramString)
  {
    AppMethodBeat.i(6806);
    String str = c.apK(paramString);
    Object localObject1 = (MultiProcessMMKV)sNJ.findSlot(str);
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
        Object localObject3 = flc.class.newInstance();
        ((com.tencent.mm.cd.a)localObject3).parseFrom((byte[])localObject1);
        localObject1 = (com.tencent.mm.cd.a)localObject3;
        localObject1 = (flc)localObject1;
        if (localObject1 == null) {
          break label242;
        }
        bool2 = MMSlotKt.isExpire(((flc)localObject1).mhP, 540);
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
  
  private static boolean aqe(String paramString)
  {
    AppMethodBeat.i(257182);
    Object localObject1 = Uri.parse(UrlExKt.getWithProtocol(paramString));
    if (localObject1 != null)
    {
      localObject1 = ((Uri)localObject1).getHost();
      if (localObject1 != null)
      {
        kotlin.g.b.p.j(localObject1, "it");
        localObject1 = c.apM((String)localObject1);
        Object localObject3 = (MultiProcessMMKV)sNK.findSlot((String)localObject1);
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
            localObject3 = bol.class.newInstance();
            ((com.tencent.mm.cd.a)localObject3).parseFrom((byte[])localObject1);
            localObject1 = (com.tencent.mm.cd.a)localObject3;
            localObject1 = (bol)localObject1;
            if (localObject1 == null) {
              break label221;
            }
            if ((((bol)localObject1).SZu != 1) || (MMSlotKt.isExpire(((bol)localObject1).SZw, ((bol)localObject1).SZv))) {
              break label216;
            }
            bool = true;
            if (bool) {
              Log.v("MicroMsg.WebPrefetcher", "[TRACE_PREFETCH] preauth cancelled, in whiteList:".concat(String.valueOf(paramString)));
            }
            AppMethodBeat.o(257182);
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
    AppMethodBeat.o(257182);
    return false;
  }
  
  public static final boolean aqf(String paramString)
  {
    AppMethodBeat.i(257183);
    kotlin.g.b.p.k(paramString, "url");
    if ((!UrlExKt.isMpUrl(paramString)) || (UrlExKt.isMpAlbumUrl(paramString)))
    {
      AppMethodBeat.o(257183);
      return true;
    }
    AppMethodBeat.o(257183);
    return false;
  }
  
  private static int aqg(String paramString)
  {
    AppMethodBeat.i(175488);
    MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)sNW.findSlot(c.apK(paramString));
    if (localMultiProcessMMKV != null)
    {
      int i = localMultiProcessMMKV.getInt(c.apK(paramString), 0);
      AppMethodBeat.o(175488);
      return i;
    }
    AppMethodBeat.o(175488);
    return 0;
  }
  
  public static MMKVSlotManager cCA()
  {
    return sNN;
  }
  
  private static int cCB()
  {
    AppMethodBeat.i(257147);
    int i = ((Number)sNQ.getValue()).intValue();
    AppMethodBeat.o(257147);
    return i;
  }
  
  private static int cCC()
  {
    AppMethodBeat.i(257148);
    int i = ((Number)sNR.getValue()).intValue();
    AppMethodBeat.o(257148);
    return i;
  }
  
  private static int cCD()
  {
    AppMethodBeat.i(257149);
    int i = ((Number)sNS.getValue()).intValue();
    AppMethodBeat.o(257149);
    return i;
  }
  
  public static MMCacheSlotManager cCE()
  {
    return sNU;
  }
  
  public static boolean cCF()
  {
    AppMethodBeat.i(257173);
    boolean bool = ((Boolean)sNV.getValue()).booleanValue();
    AppMethodBeat.o(257173);
    return bool;
  }
  
  private static int cCG()
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
  
  public static MMKVSlotManager cCw()
  {
    return sNJ;
  }
  
  public static MMKVSlotManager cCx()
  {
    return sNK;
  }
  
  public static MMKVSlotManager cCy()
  {
    return sNL;
  }
  
  public static MMKVSlotManager cCz()
  {
    return sNM;
  }
  
  public static final void cD(List<? extends f.a> paramList)
  {
    AppMethodBeat.i(160497);
    kotlin.g.b.p.k(paramList, "auths");
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
      f.a locala = (f.a)localIterator.next();
      String str2 = locala.url;
      kotlin.g.b.p.j(str2, "info.url");
      Object localObject1 = locala.appId;
      paramList = (List<? extends f.a>)localObject1;
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
      localCollection.add(new a(str2, paramList, (String)localObject1, (String)localObject2, locala.svv, locala.svw, null, locala.extInfo, 64));
    }
    cE((List)localCollection);
    AppMethodBeat.o(160497);
  }
  
  private static void cE(List<a> paramList)
  {
    AppMethodBeat.i(257172);
    Log.v("MicroMsg.WebPrefetcher", "[TRACE_PREFETCH] preAuths size = %s", new Object[] { Integer.valueOf(paramList.size()) });
    bop localbop = new bop();
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
      if ((cCF()) || ((!sNU.contains(c.apI(((a)localObject3).url))) && (aqf(((a)localObject3).url)) && (!aqe(((a)localObject3).url)) && (aqd(((a)localObject3).url)) && (!sNP.contains(((a)localObject3).url)))) {}
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
      ((h)localObject3).SZD = ((a)localObject2).url;
      ((h)localObject3).lVG = ((a)localObject2).appId;
      ((h)localObject3).SZE = ((a)localObject2).title;
      ((h)localObject3).SZF = ((a)localObject2).desc;
      ((h)localObject3).Slv = i;
      ((h)localObject3).SZG = ((a)localObject2).sNY;
      ((h)localObject3).CPw = ((a)localObject2).scene;
      ((h)localObject3).svw = ((a)localObject2).svw;
      sNU.add(c.apI(((a)localObject2).url));
      ((h)localObject3).extInfo = ((a)localObject2).extInfo;
      ((h)localObject3).kqZ = ((a)localObject2).scene;
      paramList.add(localObject3);
      i += 1;
    }
    paramList = (List)paramList;
    localbop.SZJ.addAll((Collection)paramList);
    localbop.RPJ = localbop.SZJ.size();
    localbop.CPw = 0;
    localbop.RNa = 0;
    if (localbop.SZJ.isEmpty())
    {
      Log.v("MicroMsg.WebPrefetcher", "[TRACE_PREFETCH] preAuths: nothing to preauth");
      AppMethodBeat.o(257172);
      return;
    }
    if (cCB() > 0)
    {
      paramList = localbop.SZJ;
      kotlin.g.b.p.j(paramList, "req.ReqInfo");
      if (((boo)paramList.getFirst()).CPw == cCD()) {
        com.tencent.mm.ae.d.h((kotlin.g.a.a)new y(localbop));
      }
    }
    if ((cCB() > 0) && (cCC() == e.PZR.ordinal()))
    {
      i = cCD();
      paramList = localbop.SZJ;
      kotlin.g.b.p.j(paramList, "req.ReqInfo");
      if (i == ((boo)paramList.getFirst()).CPw)
      {
        Log.i("MicroMsg.WebPrefetcher", "ClosePrefetchAndA8key");
        AppMethodBeat.o(257172);
        return;
      }
    }
    try
    {
      paramList = sNP;
      localObject1 = localbop.SZJ;
      kotlin.g.b.p.j(localObject1, "req.ReqInfo");
      localObject2 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        ((Collection)localObject1).add(((boo)((Iterator)localObject2).next()).SZD);
        continue;
        paramList = com.tencent.mm.plugin.webview.core.g.PHD;
      }
    }
    catch (Exception paramList)
    {
      Log.e("MicroMsg.WebPrefetcher", "Concurrent Add Exception: " + paramList.getMessage());
    }
    for (;;)
    {
      if (g.a.gSI()) {
        CronetLogic.setUserCertVerify(true);
      }
      paramList = new StringBuilder("[TRACE_PREFETCH] sendGetA8KeyLiteRequest batch req: ");
      localObject1 = localbop.SZJ;
      kotlin.g.b.p.j(localObject1, "req.ReqInfo");
      Log.v("MicroMsg.WebPrefetcher", kotlin.a.j.a((Iterable)localObject1, (CharSequence)",", null, null, 0, null, (kotlin.g.a.b)z.sPD, 30));
      com.tencent.mm.ae.d.b("MicroMsg.WebPrefetcher", (kotlin.g.a.a)new aa(localbop));
      AppMethodBeat.o(257172);
      return;
      paramList.addAll((Collection)localObject1);
    }
  }
  
  private static void cF(List<String> paramList)
  {
    AppMethodBeat.i(6808);
    paramList = (Iterable)paramList;
    Object localObject2 = (Collection)new ArrayList(kotlin.a.j.a(paramList, 10));
    Object localObject3 = paramList.iterator();
    while (((Iterator)localObject3).hasNext())
    {
      paramList = Uri.parse((String)((Iterator)localObject3).next());
      kotlin.g.b.p.j(paramList, "Uri.parse(it)");
      localObject1 = paramList.getHost();
      paramList = (List<String>)localObject1;
      if (localObject1 == null) {
        paramList = "";
      }
      ((Collection)localObject2).add(paramList);
    }
    Object localObject1 = (Iterable)localObject2;
    paramList = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    label162:
    label204:
    label207:
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      localObject3 = (String)localObject2;
      kotlin.g.b.p.j(localObject3, "it");
      if (!n.ba((CharSequence)localObject3))
      {
        i = 1;
        if (i == 0) {
          break label204;
        }
        com.tencent.mm.plugin.brandservice.c.a locala = com.tencent.mm.plugin.brandservice.c.soD;
        if (com.tencent.mm.plugin.brandservice.c.cyN().contains((String)localObject3)) {
          break label204;
        }
      }
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label207;
        }
        paramList.add(localObject2);
        break;
        i = 0;
        break label162;
      }
    }
    paramList = kotlin.a.j.t((Iterable)paramList);
    localObject1 = (Collection)paramList;
    if ((localObject1 == null) || (((Collection)localObject1).isEmpty())) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(6808);
      return;
    }
    com.tencent.e.h.ZvG.bf((Runnable)new p(paramList));
    AppMethodBeat.o(6808);
  }
  
  public static boolean dg(String paramString, int paramInt)
  {
    AppMethodBeat.i(175489);
    kotlin.g.b.p.k(paramString, "url");
    boolean bool = ((MultiProcessMMKV)sNW.getSlotForWrite()).encode(c.apK(paramString), paramInt);
    AppMethodBeat.o(175489);
    return bool;
  }
  
  private static void e(List<c> paramList, final String paramString1, final String paramString2)
  {
    AppMethodBeat.i(257155);
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      final c localc = (c)paramList.next();
      String str = c.ft(paramString1, localc.url);
      com.tencent.mm.plugin.ax.c.a locala = com.tencent.mm.plugin.ax.c.PwQ;
      if (!com.tencent.mm.plugin.ax.c.gPX().contains(str)) {
        ai.a(new z(localc.url, 0), (kotlin.g.a.b)new n(str, localc, paramString1, paramString2));
      }
    }
    AppMethodBeat.o(257155);
  }
  
  public static boolean fw(String paramString1, String paramString2)
  {
    AppMethodBeat.i(257184);
    String str = c.apK(paramString1);
    com.tencent.mm.plugin.ax.c.a locala = com.tencent.mm.plugin.ax.c.PwQ;
    str = new d(paramString1, str, com.tencent.mm.plugin.ax.c.gPW(), sNL, null, null, null, null, false, 496).getLocation();
    if (!n.ba((CharSequence)str)) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramString1 = c.aL(str, true);
      Log.v("MicroMsg.WebPrefetcher", "isWebUrlStorageEqual: location:#" + paramString1 + ", " + str);
      paramString2 = c.aL(paramString2, true);
      Log.v("MicroMsg.WebPrefetcher", "isWebUrlStorageEqual: target:#".concat(String.valueOf(paramString2)));
      boolean bool = kotlin.g.b.p.h(paramString1, paramString2);
      AppMethodBeat.o(257184);
      return bool;
    }
    AppMethodBeat.o(257184);
    return false;
  }
  
  public static String fx(String paramString1, String paramString2)
  {
    AppMethodBeat.i(257185);
    kotlin.g.b.p.k(paramString1, "host");
    kotlin.g.b.p.k(paramString2, "documentUrl");
    if (n.M(paramString2, "https", false))
    {
      paramString1 = "https://".concat(String.valueOf(paramString1));
      AppMethodBeat.o(257185);
      return paramString1;
    }
    paramString1 = "http://".concat(String.valueOf(paramString1));
    AppMethodBeat.o(257185);
    return paramString1;
  }
  
  private static com.tencent.mm.plugin.ax.a n(String paramString, List<? extends bom> paramList)
  {
    AppMethodBeat.i(257175);
    paramString = Uri.parse(paramString);
    Object localObject1 = com.tencent.mm.plugin.ax.c.PwQ;
    kotlin.g.b.p.j(paramString, "respUri");
    localObject1 = com.tencent.mm.plugin.ax.c.a.biC(paramString.getHost());
    if (localObject1 != null)
    {
      Log.i("MicroMsg.WebPrefetcher", "matchManifest debug");
      AppMethodBeat.o(257175);
      return localObject1;
    }
    label123:
    bon localbon;
    String str1;
    String str2;
    do
    {
      do
      {
        do
        {
          paramList = ((Iterable)paramList).iterator();
          break label123;
          Object localObject2;
          while (!((Iterator)localObject2).hasNext())
          {
            do
            {
              if (!paramList.hasNext()) {
                break;
              }
              localObject1 = (bom)paramList.next();
              kotlin.g.b.p.j(paramString, "respUri");
            } while (!kotlin.g.b.p.h(paramString.getHost(), ((bom)localObject1).SZt));
            localObject2 = ((bom)localObject1).SZy;
            kotlin.g.b.p.j(localObject2, "domain.ResInfos");
            localObject2 = ((Iterable)localObject2).iterator();
          }
          localbon = (bon)((Iterator)localObject2).next();
        } while (paramString == null);
        str1 = paramString.getPath();
      } while (str1 == null);
      str2 = localbon.CqK;
      kotlin.g.b.p.j(str2, "resInfo.Path");
    } while (com.tencent.luggage.k.c.H(str1, str2) != true);
    kotlin.g.b.p.j(localbon, "resInfo");
    paramString = new com.tencent.mm.plugin.ax.a((bom)localObject1, localbon, false, 60);
    AppMethodBeat.o(257175);
    return paramString;
    AppMethodBeat.o(257175);
    return null;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$BatchPreauth;", "", "url", "", "appId", "title", "desc", "scene", "", "subBizScene", "refer", "extInfo", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getDesc", "getExtInfo", "getRefer", "getScene", "()I", "setScene", "(I)V", "getSubBizScene", "setSubBizScene", "getTitle", "getUrl", "checkScene", "", "plugin-brandservice_release"})
  static final class a
  {
    final String appId;
    final String desc;
    final String extInfo;
    final String sNY;
    int scene;
    int svw;
    final String title;
    final String url;
    
    private a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, String paramString5, String paramString6)
    {
      AppMethodBeat.i(265701);
      this.url = paramString1;
      this.appId = paramString2;
      this.title = paramString3;
      this.desc = paramString4;
      this.scene = paramInt1;
      this.svw = paramInt2;
      this.sNY = paramString5;
      this.extInfo = paramString6;
      if (UrlExKt.isMpAlbumUrl(this.url))
      {
        this.svw = this.scene;
        this.scene = 210;
      }
      AppMethodBeat.o(265701);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class aa
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    aa(bop parambop)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/webview/util/WebPrefetchUserAgentInfo;", "invoke"})
  static final class ab
    extends kotlin.g.b.q
    implements kotlin.g.a.a<com.tencent.mm.plugin.webview.k.h>
  {
    public static final ab sPH;
    
    static
    {
      AppMethodBeat.i(265728);
      sPH = new ab();
      AppMethodBeat.o(265728);
    }
    
    ab()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchAction;", "", "host", "", "rawUrl", "prefetchUrl", "checkCacheOnly", "", "prefetchHeader", "", "bizScene", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/util/Map;I)V", "getBizScene", "()I", "getCheckCacheOnly", "()Z", "getHost", "()Ljava/lang/String;", "getPrefetchHeader", "()Ljava/util/Map;", "getPrefetchUrl", "getRawUrl", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "plugin-brandservice_release"})
  static final class b
  {
    final String fXu;
    final String host;
    private final int kqZ;
    final String sNZ;
    final boolean sOa;
    final Map<String, String> sOb;
    
    private b(String paramString1, String paramString2, String paramString3, boolean paramBoolean, Map<String, String> paramMap)
    {
      AppMethodBeat.i(262057);
      this.host = paramString1;
      this.fXu = paramString2;
      this.sNZ = paramString3;
      this.sOa = paramBoolean;
      this.sOb = paramMap;
      this.kqZ = 0;
      AppMethodBeat.o(262057);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(262067);
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if ((!kotlin.g.b.p.h(this.host, paramObject.host)) || (!kotlin.g.b.p.h(this.fXu, paramObject.fXu)) || (!kotlin.g.b.p.h(this.sNZ, paramObject.sNZ)) || (this.sOa != paramObject.sOa) || (!kotlin.g.b.p.h(this.sOb, paramObject.sOb)) || (this.kqZ != paramObject.kqZ)) {}
        }
      }
      else
      {
        AppMethodBeat.o(262067);
        return true;
      }
      AppMethodBeat.o(262067);
      return false;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(262061);
      String str = "PrefetchAction(host=" + this.host + ", rawUrl=" + this.fXu + ", prefetchUrl=" + this.sNZ + ", checkCacheOnly=" + this.sOa + ", prefetchHeader=" + this.sOb + ", bizScene=" + this.kqZ + ")";
      AppMethodBeat.o(262061);
      return str;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchRes;", "", "url", "", "type", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchType;", "bizScene", "", "(Ljava/lang/String;Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchType;I)V", "getBizScene", "()I", "getType", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchType;", "getUrl", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "plugin-brandservice_release"})
  static final class c
  {
    private final int kqZ;
    final s.e sOc;
    final String url;
    
    public c(String paramString, s.e parame, int paramInt)
    {
      AppMethodBeat.i(264535);
      this.url = paramString;
      this.sOc = parame;
      this.kqZ = paramInt;
      AppMethodBeat.o(264535);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(264541);
      if (this != paramObject)
      {
        if ((paramObject instanceof c))
        {
          paramObject = (c)paramObject;
          if ((!kotlin.g.b.p.h(this.url, paramObject.url)) || (!kotlin.g.b.p.h(this.sOc, paramObject.sOc)) || (this.kqZ != paramObject.kqZ)) {}
        }
      }
      else
      {
        AppMethodBeat.o(264541);
        return true;
      }
      AppMethodBeat.o(264541);
      return false;
    }
    
    public final int hashCode()
    {
      int j = 0;
      AppMethodBeat.i(264539);
      Object localObject = this.url;
      if (localObject != null) {}
      for (int i = localObject.hashCode();; i = 0)
      {
        localObject = this.sOc;
        if (localObject != null) {
          j = localObject.hashCode();
        }
        int k = this.kqZ;
        AppMethodBeat.o(264539);
        return (i * 31 + j) * 31 + k;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(264537);
      String str = "PrefetchRes(url=" + this.url + ", type=" + this.sOc + ", bizScene=" + this.kqZ + ")";
      AppMethodBeat.o(264537);
      return str;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchTarget;", "", "url", "", "webId", "content", "Lcom/tencent/mm/plugin/webprefetcher/WebPrefetcherFile;", "headerSlot", "Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "referHost", "mainAppId", "isForMainFrame", "", "manifest", "Lcom/tencent/mm/plugin/webprefetcher/PrefetchManifest;", "needDownloadPkg", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/webprefetcher/WebPrefetcherFile;Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/tencent/mm/plugin/webprefetcher/PrefetchManifest;Z)V", "appId", "getAppId", "()Ljava/lang/String;", "appId$delegate", "Lkotlin/Lazy;", "bizId", "getBizId", "bizId$delegate", "bizScene", "", "getBizScene", "()I", "bizScene$delegate", "cacheTime", "", "getCacheTime", "()J", "getContent", "()Lcom/tencent/mm/plugin/webprefetcher/WebPrefetcherFile;", "eTag", "getETag", "fetchPkgUrl", "getFetchPkgUrl", "fullUrl", "getFullUrl", "fullUrl$delegate", "getHeaderSlot", "()Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "headers", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getHeaders", "()Ljava/util/HashMap;", "headers$delegate", "isCached", "()Z", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "isRedirect", "lazyWebPrefetchInfo", "Lcom/tencent/mm/protocal/protobuf/WebPrefetchInfo;", "getLazyWebPrefetchInfo", "()Lcom/tencent/mm/protocal/protobuf/WebPrefetchInfo;", "lazyWebPrefetchInfo$delegate", "location", "getLocation", "getMainAppId", "getManifest", "()Lcom/tencent/mm/plugin/webprefetcher/PrefetchManifest;", "maxCache", "getMaxCache", "mimeType", "getMimeType", "getNeedDownloadPkg", "prefetchHost", "getPrefetchHost", "prefetchUrl", "getPrefetchUrl", "getReferHost", "response", "Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService$PrefetchResponse;", "getResponse", "()Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService$PrefetchResponse;", "shouldFetchContent", "getShouldFetchContent", "shouldFetchContent$delegate", "subBizScene", "getSubBizScene", "subBizScene$delegate", "type", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchType;", "getType", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchType;", "getUrl", "version", "getVersion", "getWebId", "wxETag", "getWxETag", "createResponse", "refresh", "", "saveHeaders", "host", "plugin-brandservice_release"})
  public static final class d
  {
    private final com.tencent.mm.plugin.ax.a sKZ;
    private final kotlin.f sOd;
    private final kotlin.f sOe;
    private final kotlin.f sOf;
    private final kotlin.f sOg;
    private final kotlin.f sOh;
    private final kotlin.f sOi;
    private final kotlin.f sOj;
    private final kotlin.f sOk;
    public final String sOl;
    public final com.tencent.mm.plugin.ax.b sOm;
    final MMKVSlotManager sOn;
    private final String sOo;
    final String sOp;
    private final Boolean sOq;
    final boolean sOr;
    final String url;
    
    private d(String paramString1, String paramString2, com.tencent.mm.plugin.ax.b paramb, MMKVSlotManager paramMMKVSlotManager, String paramString3, String paramString4, Boolean paramBoolean, com.tencent.mm.plugin.ax.a parama, boolean paramBoolean1)
    {
      AppMethodBeat.i(258397);
      this.url = paramString1;
      this.sOl = paramString2;
      this.sOm = paramb;
      this.sOn = paramMMKVSlotManager;
      this.sOo = paramString3;
      this.sOp = paramString4;
      this.sOq = paramBoolean;
      this.sKZ = parama;
      this.sOr = paramBoolean1;
      this.sOd = kotlin.g.ar((kotlin.g.a.a)new g(this));
      this.sOe = kotlin.g.ar((kotlin.g.a.a)new b(this));
      this.sOf = kotlin.g.ar((kotlin.g.a.a)new a(this));
      this.sOg = kotlin.g.ar((kotlin.g.a.a)new e(this));
      this.sOh = kotlin.g.ar((kotlin.g.a.a)new c(this));
      this.sOi = kotlin.g.ar((kotlin.g.a.a)new i(this));
      this.sOj = kotlin.g.ar((kotlin.g.a.a)new h(this));
      this.sOk = kotlin.g.ar((kotlin.g.a.a)new f(this));
      AppMethodBeat.o(258397);
    }
    
    private void bfU()
    {
      AppMethodBeat.i(258390);
      if ((((Boolean)this.sOj.getValue()).booleanValue()) && (cCP() == s.e.sOw) && (cCR() > 0L) && (cCQ() > 0) && (MMSlotKt.isExpire(cCR(), Math.max(cCQ() - 60, 60))))
      {
        Object localObject = s.sNX;
        com.tencent.mm.plugin.webview.i.f.aog(s.app(this.url));
        localObject = s.sNX;
        String str2 = this.url;
        localObject = (List)cCO().get("x-wx-client-prefetch-url");
        if (localObject != null)
        {
          String str1 = (String)kotlin.a.j.lo((List)localObject);
          localObject = str1;
          if (str1 != null) {}
        }
        else
        {
          localObject = "";
        }
        s.Q(str2, (String)localObject, getAppId());
      }
      AppMethodBeat.o(258390);
    }
    
    private s.e cCP()
    {
      AppMethodBeat.i(258369);
      Object localObject = (List)cCO().get("x-wx-client-prefetch-type");
      if (localObject != null)
      {
        localObject = (String)kotlin.a.j.lo((List)localObject);
        if (localObject != null)
        {
          if (localObject == null)
          {
            localObject = new t("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(258369);
            throw ((Throwable)localObject);
          }
          localObject = ((String)localObject).toUpperCase();
          kotlin.g.b.p.j(localObject, "(this as java.lang.String).toUpperCase()");
          s.e locale = s.e.valueOf((String)localObject);
          localObject = locale;
          if (locale != null) {
            break label86;
          }
        }
      }
      localObject = s.e.sOw;
      label86:
      AppMethodBeat.o(258369);
      return localObject;
    }
    
    private final f.b cCX()
    {
      AppMethodBeat.i(258395);
      if (this.sOm == null)
      {
        AppMethodBeat.o(258395);
        return null;
      }
      int i = cCO().size();
      boolean bool = this.sOm.contains(cCK());
      if ((i == 0) || (!bool))
      {
        Log.e("MicroMsg.WebPrefetcher", "createResponse fail headerSize:" + i + ", containsFile:" + bool);
        AppMethodBeat.o(258395);
        return null;
      }
      f.b localb = new f.b();
      localb.url = cCL();
      localb.svy = cCP().toString();
      localb.svx = getVersion();
      localb.kqZ = cCM();
      localb.svw = cCN();
      localb.appId = getAppId();
      Object localObject1 = d.sOt;
      d.j(cCO());
      localObject1 = getMimeType();
      Object localObject2 = (Map)cCO();
      Map localMap = (Map)new LinkedHashMap(ae.aDD(((Map)localObject2).size()));
      localObject2 = ((Iterable)((Map)localObject2).entrySet()).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject4 = ((Iterator)localObject2).next();
        Object localObject3 = ((Map.Entry)localObject4).getKey();
        localObject4 = (Map.Entry)localObject4;
        ((Map.Entry)localObject4).getKey();
        localMap.put(localObject3, (String)kotlin.a.j.lo((List)((Map.Entry)localObject4).getValue()));
      }
      localb.svz = new WebResourceResponse((String)localObject1, "UTF-8", 200, "OK", localMap, u.al(this.sOm.biA(cCK())));
      AppMethodBeat.o(258395);
      return localb;
    }
    
    private String getAppId()
    {
      AppMethodBeat.i(258360);
      String str = (String)this.sOf.getValue();
      AppMethodBeat.o(258360);
      return str;
    }
    
    private final String getMimeType()
    {
      AppMethodBeat.i(258373);
      Object localObject = (List)cCO().get("content-type");
      if (localObject != null)
      {
        localObject = (String)kotlin.a.j.lo((List)localObject);
        if (localObject != null)
        {
          localObject = n.pv((String)localObject, ";");
          if (localObject != null)
          {
            if (localObject == null)
            {
              localObject = new t("null cannot be cast to non-null type kotlin.CharSequence");
              AppMethodBeat.o(258373);
              throw ((Throwable)localObject);
            }
            String str = n.bb((CharSequence)localObject).toString();
            localObject = str;
            if (str != null) {
              break label92;
            }
          }
        }
      }
      localObject = "text/html";
      label92:
      AppMethodBeat.o(258373);
      return localObject;
    }
    
    private long getVersion()
    {
      AppMethodBeat.i(258372);
      Object localObject = (List)cCO().get("x-wx-version");
      if (localObject != null)
      {
        localObject = (String)kotlin.a.j.lo((List)localObject);
        if (localObject != null)
        {
          long l = Long.parseLong((String)localObject);
          AppMethodBeat.o(258372);
          return l;
        }
      }
      AppMethodBeat.o(258372);
      return -1L;
    }
    
    public final void a(s.e parame, String paramString)
    {
      AppMethodBeat.i(258396);
      kotlin.g.b.p.k(parame, "type");
      kotlin.g.b.p.k(paramString, "host");
      ((Map)cCO()).put("x-wx-client-cache-time", kotlin.a.j.listOf(String.valueOf(MMSlotKt.now())));
      ((Map)cCO()).put("x-wx-client-prefetch-url", kotlin.a.j.listOf(this.url));
      if (!n.ba((CharSequence)paramString)) {}
      flb localflb;
      LinkedList localLinkedList;
      Collection localCollection;
      Object localObject;
      fla localfla;
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          ((Map)cCO()).put("x-wx-client-prefetch-host", kotlin.a.j.listOf(paramString));
        }
        ((Map)cCO()).put("x-wx-client-prefetch-type", kotlin.a.j.listOf(parame.toString()));
        localflb = new flb();
        localLinkedList = localflb.UJP;
        paramString = (Map)cCO();
        localCollection = (Collection)new ArrayList(paramString.size());
        Iterator localIterator = paramString.entrySet().iterator();
        if (!localIterator.hasNext()) {
          break label403;
        }
        localObject = (Map.Entry)localIterator.next();
        paramString = (String)((Map.Entry)localObject).getKey();
        localObject = (List)((Map.Entry)localObject).getValue();
        localfla = new fla();
        if (paramString != null) {
          break;
        }
        parame = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(258396);
        throw parame;
      }
      String str = paramString.toLowerCase();
      kotlin.g.b.p.j(str, "(this as java.lang.String).toLowerCase()");
      switch (str.hashCode())
      {
      }
      for (;;)
      {
        localfla.key = paramString;
        localfla.SWx.addAll((Collection)localObject);
        localCollection.add(localfla);
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
      ((MultiProcessMMKV)this.sOn.getSlotForWrite()).encode(cCK(), localflb.toByteArray());
      Log.v("MicroMsg.WebPrefetcher", "saveHeaders " + parame + " : webId:" + this.sOl + ", bizId:" + cCK() + ", header size:" + cCO().size());
      AppMethodBeat.o(258396);
    }
    
    public final String cCK()
    {
      AppMethodBeat.i(258358);
      String str = (String)this.sOe.getValue();
      AppMethodBeat.o(258358);
      return str;
    }
    
    public final String cCL()
    {
      AppMethodBeat.i(258362);
      String str = (String)this.sOg.getValue();
      AppMethodBeat.o(258362);
      return str;
    }
    
    public final int cCM()
    {
      AppMethodBeat.i(258364);
      int i = ((Number)this.sOh.getValue()).intValue();
      AppMethodBeat.o(258364);
      return i;
    }
    
    public final int cCN()
    {
      AppMethodBeat.i(258365);
      int i = ((Number)this.sOi.getValue()).intValue();
      AppMethodBeat.o(258365);
      return i;
    }
    
    public final HashMap<String, List<String>> cCO()
    {
      AppMethodBeat.i(258367);
      HashMap localHashMap = (HashMap)this.sOk.getValue();
      AppMethodBeat.o(258367);
      return localHashMap;
    }
    
    public final int cCQ()
    {
      AppMethodBeat.i(258375);
      Object localObject = (List)cCO().get("x-wx-max-cache");
      if (localObject != null)
      {
        localObject = (String)kotlin.a.j.lo((List)localObject);
        if (localObject != null) {
          localObject = Integer.valueOf(Integer.parseInt((String)localObject));
        }
      }
      while (localObject != null)
      {
        int i = ((Integer)localObject).intValue();
        AppMethodBeat.o(258375);
        return i;
        localObject = (List)cCO().get("max-age");
        if (localObject != null)
        {
          localObject = (String)kotlin.a.j.lo((List)localObject);
          if (localObject != null)
          {
            localObject = Integer.valueOf(Integer.parseInt((String)localObject));
            continue;
          }
        }
        localObject = null;
      }
      AppMethodBeat.o(258375);
      return 600;
    }
    
    public final long cCR()
    {
      AppMethodBeat.i(258376);
      Object localObject = (List)cCO().get("x-wx-client-cache-time");
      if (localObject != null)
      {
        localObject = (String)kotlin.a.j.lo((List)localObject);
        if (localObject != null)
        {
          long l = Long.parseLong((String)localObject);
          AppMethodBeat.o(258376);
          return l;
        }
      }
      AppMethodBeat.o(258376);
      return -1L;
    }
    
    public final String cCS()
    {
      AppMethodBeat.i(258379);
      Object localObject = (List)cCO().get("x-wx-etag");
      if (localObject != null)
      {
        String str = (String)kotlin.a.j.lo((List)localObject);
        localObject = str;
        if (str != null) {}
      }
      else
      {
        localObject = "";
      }
      AppMethodBeat.o(258379);
      return localObject;
    }
    
    public final String cCT()
    {
      AppMethodBeat.i(258380);
      Object localObject = (List)cCO().get("etag");
      if (localObject != null)
      {
        String str = (String)kotlin.a.j.lo((List)localObject);
        localObject = str;
        if (str != null) {}
      }
      else
      {
        localObject = "";
      }
      AppMethodBeat.o(258380);
      return localObject;
    }
    
    public final boolean cCU()
    {
      AppMethodBeat.i(258386);
      Object localObject = (List)cCO().get("status");
      boolean bool;
      if (localObject != null)
      {
        localObject = (String)kotlin.a.j.lp((List)localObject);
        if (localObject == null) {}
      }
      else
      {
        switch (((String)localObject).hashCode())
        {
        default: 
        case 49586: 
        case 50548: 
          do
          {
            do
            {
              AppMethodBeat.o(258386);
              return false;
              localObject = null;
              break;
            } while (!((String)localObject).equals("200"));
            localObject = this.sOm;
            if (localObject == null) {
              break label169;
            }
            bool = ((com.tencent.mm.plugin.ax.b)localObject).contains(cCK());
            AppMethodBeat.o(258386);
            return bool;
          } while (!((String)localObject).equals("301"));
        }
        for (;;)
        {
          if (n.ba((CharSequence)getLocation())) {
            break label177;
          }
          AppMethodBeat.o(258386);
          return true;
          if (!((String)localObject).equals("302")) {
            break;
          }
        }
        label169:
        AppMethodBeat.o(258386);
        return false;
        label177:
        AppMethodBeat.o(258386);
        return false;
      }
      localObject = this.sOm;
      if (localObject != null)
      {
        bool = ((com.tencent.mm.plugin.ax.b)localObject).contains(cCK());
        AppMethodBeat.o(258386);
        return bool;
      }
      AppMethodBeat.o(258386);
      return false;
    }
    
    public final String cCV()
    {
      AppMethodBeat.i(258389);
      Object localObject = (List)cCO().get("x-wx-prefetch-pkg-url");
      if (localObject != null)
      {
        String str = (String)kotlin.a.j.lo((List)localObject);
        localObject = str;
        if (str != null) {}
      }
      else
      {
        localObject = "";
      }
      AppMethodBeat.o(258389);
      return localObject;
    }
    
    public final f.b cCW()
    {
      AppMethodBeat.i(258394);
      Object localObject3;
      for (Object localObject1 = this;; localObject1 = new d((String)localObject2, (String)localObject1, (com.tencent.mm.plugin.ax.b)localObject3, s.cCy(), null, null, null, null, false, 496))
      {
        localObject2 = com.tencent.mm.plugin.ax.c.PwQ;
        localObject2 = com.tencent.mm.plugin.ax.c.a.a(((d)localObject1).getAppId(), ((d)localObject1).url, ((d)localObject1).sOq);
        if (localObject2 != null)
        {
          Log.i("MicroMsg.WebPrefetcher", "matchResource get response #" + ((d)localObject1).sOl + ", " + ((d)localObject1).getAppId() + ", " + ((d)localObject1).sOo + ", url: %s", new Object[] { ((d)localObject1).url });
          localObject3 = new f.b();
          ((f.b)localObject3).url = ((d)localObject1).cCL();
          ((f.b)localObject3).svy = ((d)localObject1).cCP().toString();
          ((f.b)localObject3).svx = ((d)localObject1).getVersion();
          ((f.b)localObject3).kqZ = ((d)localObject1).cCM();
          ((f.b)localObject3).svw = ((d)localObject1).cCN();
          ((f.b)localObject3).svz = ((WebResourceResponse)localObject2);
          ((f.b)localObject3).appId = ((d)localObject1).getAppId();
          AppMethodBeat.o(258394);
          return localObject3;
        }
        if (!((d)localObject1).cCU()) {
          break label568;
        }
        Log.i("MicroMsg.WebPrefetcher", "fetch cached: #" + ((d)localObject1).sOl + ", isForMainFrame: " + ((d)localObject1).sOq + ", " + ((d)localObject1).url);
        localObject2 = ((d)localObject1).cCP();
        switch (t.$EnumSwitchMapping$0[localObject2.ordinal()])
        {
        default: 
          localObject1 = ((d)localObject1).cCX();
          AppMethodBeat.o(258394);
          return localObject1;
        }
        if (!((d)localObject1).isRedirect()) {
          break;
        }
        Log.i("MicroMsg.WebPrefetcher", "HTML redirect, location:" + ((d)localObject1).getLocation());
        localObject2 = ((d)localObject1).getLocation();
        localObject1 = c.apK(((d)localObject1).getLocation());
        localObject3 = com.tencent.mm.plugin.ax.c.PwQ;
        localObject3 = com.tencent.mm.plugin.ax.c.gPW();
        s locals = s.sNX;
      }
      Object localObject2 = s.sNX;
      if (s.apm(((d)localObject1).url))
      {
        if (!MMSlotKt.isExpire(((d)localObject1).cCR(), ((d)localObject1).cCQ()))
        {
          localObject2 = (List)((d)localObject1).cCO().get("set-cookie");
          if (localObject2 != null)
          {
            localObject2 = ((Iterable)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = (String)((Iterator)localObject2).next();
              com.tencent.xweb.c.ivX().setCookie(((d)localObject1).url, (String)localObject3);
            }
          }
          localObject1 = ((d)localObject1).cCX();
          AppMethodBeat.o(258394);
          return localObject1;
        }
        Log.w("MicroMsg.WebPrefetcher", "getResponse doc expired refresh cached: #" + ((d)localObject1).sOl + ", " + ((d)localObject1).url);
        ((d)localObject1).bfU();
        AppMethodBeat.o(258394);
        return null;
      }
      Log.w("MicroMsg.WebPrefetcher", "getResponse preauth expired preauth: #" + ((d)localObject1).sOl + ", " + ((d)localObject1).url);
      s.aqb(((d)localObject1).url);
      AppMethodBeat.o(258394);
      return null;
      label568:
      AppMethodBeat.o(258394);
      return null;
    }
    
    public final String getLocation()
    {
      AppMethodBeat.i(258371);
      Object localObject = (List)cCO().get("location");
      if (localObject != null)
      {
        String str = (String)kotlin.a.j.lo((List)localObject);
        localObject = str;
        if (str != null) {}
      }
      else
      {
        localObject = "";
      }
      AppMethodBeat.o(258371);
      return localObject;
    }
    
    public final boolean isRedirect()
    {
      AppMethodBeat.i(258382);
      Object localObject = (List)cCO().get("status");
      if (localObject != null)
      {
        localObject = (String)kotlin.a.j.lo((List)localObject);
        if (localObject != null) {
          break label49;
        }
      }
      label49:
      do
      {
        for (;;)
        {
          AppMethodBeat.o(258382);
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
        AppMethodBeat.o(258382);
        return true;
        if (!((String)localObject).equals("302")) {
          break;
        }
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.a<String>
    {
      a(s.d paramd)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class b
      extends kotlin.g.b.q
      implements kotlin.g.a.a<String>
    {
      b(s.d paramd)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class c
      extends kotlin.g.b.q
      implements kotlin.g.a.a<Integer>
    {
      c(s.d paramd)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"removeInvalidHeaders", "", "headers", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "invoke"})
    static final class d
      extends kotlin.g.b.q
      implements kotlin.g.a.b<HashMap<String, List<? extends String>>, x>
    {
      public static final d sOt;
      
      static
      {
        AppMethodBeat.i(266261);
        sOt = new d();
        AppMethodBeat.o(266261);
      }
      
      d()
      {
        super();
      }
      
      public static void j(HashMap<String, List<String>> paramHashMap)
      {
        AppMethodBeat.i(266260);
        kotlin.g.b.p.k(paramHashMap, "headers");
        Object localObject1 = paramHashMap.keySet();
        kotlin.g.b.p.j(localObject1, "headers.keys");
        Object localObject2 = (Iterable)localObject1;
        localObject1 = (Collection)new ArrayList();
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Object localObject3 = ((Iterator)localObject2).next();
          String str = (String)localObject3;
          Set localSet = v.cDc();
          kotlin.g.b.p.j(str, "it");
          if (str == null)
          {
            paramHashMap = new t("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(266260);
            throw paramHashMap;
          }
          str = str.toLowerCase();
          kotlin.g.b.p.j(str, "(this as java.lang.String).toLowerCase()");
          if (localSet.contains(str)) {
            ((Collection)localObject1).add(localObject3);
          }
        }
        localObject1 = (List)localObject1;
        Log.i("MicroMsg.WebPrefetcher", "removeInvalidHeaders size: " + ((List)localObject1).size());
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext()) {
          paramHashMap.remove((String)((Iterator)localObject1).next());
        }
        AppMethodBeat.o(266260);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class e
      extends kotlin.g.b.q
      implements kotlin.g.a.a<String>
    {
      e(s.d paramd)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "invoke"})
    static final class f
      extends kotlin.g.b.q
      implements kotlin.g.a.a<HashMap<String, List<? extends String>>>
    {
      f(s.d paramd)
      {
        super();
      }
      
      private HashMap<String, List<String>> cCY()
      {
        AppMethodBeat.i(264771);
        Object localObject2 = this.sOs.sOn;
        Object localObject1 = this.sOs.cCK();
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
                  break label196;
                }
                i = 1;
                label65:
                if (i == 0) {
                  break label217;
                }
              }
            }
          }
        }
        Object localObject3;
        label196:
        label217:
        HashMap<String, List<String>> localHashMap;
        for (;;)
        {
          try
          {
            localObject2 = flb.class.newInstance();
            ((com.tencent.mm.cd.a)localObject2).parseFrom((byte[])localObject1);
            localObject1 = (com.tencent.mm.cd.a)localObject2;
            localObject2 = (flb)localObject1;
            localObject1 = new HashMap();
            if (localObject2 == null) {
              break label283;
            }
            localObject2 = ((flb)localObject2).UJP;
            kotlin.g.b.p.j(localObject2, "it.header");
            localObject3 = (Iterable)localObject2;
            localObject2 = (Collection)new ArrayList();
            localObject3 = ((Iterable)localObject3).iterator();
            if (!((Iterator)localObject3).hasNext()) {
              break label232;
            }
            Object localObject4 = ((Iterator)localObject3).next();
            if (((fla)localObject4).key == null) {
              break label227;
            }
            i = 1;
            if (i == 0) {
              continue;
            }
            ((Collection)localObject2).add(localObject4);
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
          continue;
          label227:
          i = 0;
        }
        label232:
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (fla)((Iterator)localObject2).next();
          localHashMap.put(((fla)localObject3).key, ((fla)localObject3).SWx);
        }
        label283:
        AppMethodBeat.o(264771);
        return localHashMap;
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/protocal/protobuf/WebPrefetchInfo;", "invoke"})
    static final class g
      extends kotlin.g.b.q
      implements kotlin.g.a.a<flc>
    {
      g(s.d paramd)
      {
        super();
      }
      
      private flc cCZ()
      {
        AppMethodBeat.i(257505);
        Object localObject1 = s.sNX;
        Object localObject3 = s.cCw();
        localObject1 = this.sOs.sOl;
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
            localObject3 = flc.class.newInstance();
            ((com.tencent.mm.cd.a)localObject3).parseFrom((byte[])localObject1);
            localObject1 = (com.tencent.mm.cd.a)localObject3;
            localObject1 = (flc)localObject1;
            AppMethodBeat.o(257505);
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
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class h
      extends kotlin.g.b.q
      implements kotlin.g.a.a<Boolean>
    {
      h(s.d paramd)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class i
      extends kotlin.g.b.q
      implements kotlin.g.a.a<Integer>
    {
      i(s.d paramd)
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchType;", "", "type", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "toString", "JS", "CSS", "HTML", "plugin-brandservice_release"})
  public static enum e
  {
    private final String type;
    
    static
    {
      AppMethodBeat.i(258678);
      e locale1 = new e("JS", 0, "JS");
      sOu = locale1;
      e locale2 = new e("CSS", 1, "CSS");
      sOv = locale2;
      e locale3 = new e("HTML", 2, "HTML");
      sOw = locale3;
      sOx = new e[] { locale1, locale2, locale3 };
      AppMethodBeat.o(258678);
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$connect$2$1", "Lcom/tencent/mars/cdn/CronetLogic$CronetTaskCallback;", "onCronetReceiveHeader", "", "header", "Lcom/tencent/mars/cdn/CronetLogic$ResponseHeader;", "status_code", "protocol", "", "onCronetTaskCompleted", "", "filekey", "result", "Lcom/tencent/mars/cdn/CronetLogic$CronetTaskResult;", "onDownloadProgressChanged", "progress", "Lcom/tencent/mars/cdn/CronetLogic$CronetDownloadProgress;", "plugin-brandservice_release"})
  public static final class f
    implements CronetLogic.CronetTaskCallback
  {
    f(z paramz, String paramString, com.tencent.mm.vfs.q paramq, kotlin.g.a.b paramb1, kotlin.g.a.b paramb2) {}
    
    public final int onCronetReceiveHeader(CronetLogic.ResponseHeader paramResponseHeader, int paramInt, String paramString)
    {
      AppMethodBeat.i(265446);
      kotlin.g.b.p.k(paramString, "protocol");
      Log.d("MicroMsg.WebPrefetcher", "connect onReceiveHeader statusCode: %s", new Object[] { Integer.valueOf(paramInt) });
      if (((Boolean)paramb.invoke(Integer.valueOf(paramInt))).booleanValue())
      {
        AppMethodBeat.o(265446);
        return 0;
      }
      paramResponseHeader = paramb1;
      if (paramResponseHeader != null) {
        paramResponseHeader.invoke(Boolean.FALSE);
      }
      AppMethodBeat.o(265446);
      return -99;
    }
    
    public final void onCronetTaskCompleted(String paramString1, CronetLogic.CronetTaskResult paramCronetTaskResult, String paramString2)
    {
      AppMethodBeat.i(265445);
      kotlin.g.b.p.k(paramString2, "protocol");
      if (paramCronetTaskResult != null)
      {
        paramString1 = Integer.valueOf(paramCronetTaskResult.statusCode);
        Log.d("MicroMsg.WebPrefetcher", "connect onCronetTaskCompleted statusCode: %s", new Object[] { paramString1 });
        if (paramCronetTaskResult != null) {
          switch (paramCronetTaskResult.statusCode)
          {
          }
        }
      }
      for (;;)
      {
        paramString1 = new com.tencent.mm.vfs.q(this.sOy.getSavePath());
        if (paramString1.ifE()) {
          paramString1.cFq();
        }
        paramString1 = paramb1;
        if (paramString1 == null) {
          break label268;
        }
        paramString1.invoke(Boolean.valueOf(u.agG(this.sOz)));
        AppMethodBeat.o(265445);
        return;
        paramString1 = null;
        break;
        if (u.oo(this.sOy.getSavePath(), this.sOz))
        {
          Log.i("MicroMsg.WebPrefetcher", "connect save file:" + this.sOy.btD() + " to " + this.sOz);
        }
        else
        {
          Log.e("MicroMsg.WebPrefetcher", "connect save conn failed:" + this.sOy.btD() + " to " + this.sOy.getSavePath());
          continue;
          paramb.invoke(Integer.valueOf(paramCronetTaskResult.statusCode));
        }
      }
      label268:
      AppMethodBeat.o(265445);
    }
    
    public final void onDownloadProgressChanged(String paramString, CronetLogic.CronetDownloadProgress paramCronetDownloadProgress) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke"})
  static final class g
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Integer, Boolean>
  {
    public static final g sOC;
    
    static
    {
      AppMethodBeat.i(266271);
      sOC = new g();
      AppMethodBeat.o(266271);
    }
    
    g()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/network/MMHttpUrlCronetConnection;", "conn", "invoke", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$fetchBizPkg$2$4"})
  static final class h
    extends kotlin.g.b.q
    implements kotlin.g.a.b<z, z>
  {
    h(String paramString, kotlin.d.d paramd, s.d paramd1, Map paramMap)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"getPkgFileId", "", "appId", "url", "invoke"})
  static final class i
    extends kotlin.g.b.q
    implements kotlin.g.a.m<String, String, String>
  {
    public static final i sOJ;
    
    static
    {
      AppMethodBeat.i(265618);
      sOJ = new i();
      AppMethodBeat.o(265618);
    }
    
    i()
    {
      super();
    }
    
    public static String fy(String paramString1, String paramString2)
    {
      AppMethodBeat.i(265616);
      kotlin.g.b.p.k(paramString1, "appId");
      kotlin.g.b.p.k(paramString2, "url");
      StringBuilder localStringBuilder = new StringBuilder();
      com.tencent.mm.plugin.webcanvas.m localm = com.tencent.mm.plugin.webcanvas.m.PuL;
      paramString1 = localStringBuilder.append(com.tencent.mm.plugin.webcanvas.m.bil(paramString1));
      paramString2 = Integer.toString(paramString2.hashCode(), kotlin.n.a.aFL(16));
      kotlin.g.b.p.j(paramString2, "java.lang.Integer.toStri…(this, checkRadix(radix))");
      paramString1 = paramString2;
      AppMethodBeat.o(265616);
      return paramString1;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"isPkgExist", "", "appId", "", "invoke"})
  static final class j
    extends kotlin.g.b.q
    implements kotlin.g.a.b<String, Boolean>
  {
    public static final j sOK;
    
    static
    {
      AppMethodBeat.i(265442);
      sOK = new j();
      AppMethodBeat.o(265442);
    }
    
    j()
    {
      super();
    }
    
    public static boolean alX(String paramString)
    {
      AppMethodBeat.i(265441);
      kotlin.g.b.p.k(paramString, "appId");
      com.tencent.mm.plugin.webcanvas.m localm = com.tencent.mm.plugin.webcanvas.m.PuL;
      paramString = com.tencent.mm.plugin.webcanvas.m.bis(paramString);
      if ((paramString != null) && (u.agG(paramString.path)))
      {
        AppMethodBeat.o(265441);
        return true;
      }
      AppMethodBeat.o(265441);
      return false;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"getPkgUrl", "", "appId", "invoke"})
  static final class k
    extends kotlin.g.b.q
    implements kotlin.g.a.b<String, String>
  {
    public static final k sOL;
    
    static
    {
      AppMethodBeat.i(259202);
      sOL = new k();
      AppMethodBeat.o(259202);
    }
    
    k()
    {
      super();
    }
    
    public static String invoke(String paramString)
    {
      AppMethodBeat.i(259199);
      kotlin.g.b.p.k(paramString, "appId");
      Object localObject = s.sNX;
      localObject = s.cCA().decodeString(paramString, "");
      paramString = (String)localObject;
      if (localObject == null) {
        paramString = "";
      }
      AppMethodBeat.o(259199);
      return paramString;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "conn", "Lcom/tencent/mm/network/MMHttpUrlCronetConnection;", "invoke"})
  static final class l
    extends kotlin.g.b.q
    implements kotlin.g.a.b<z, x>
  {
    l(Map paramMap, s.d paramd, String paramString1, String paramString2)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/network/MMHttpUrlCronetConnection;", "conn", "invoke", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$fetchManifest$2$1"})
  static final class m
    extends kotlin.g.b.q
    implements kotlin.g.a.b<z, z>
  {
    m(String paramString, kotlin.d.d paramd, com.tencent.mm.plugin.ax.a parama)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "conn", "Lcom/tencent/mm/network/MMHttpUrlCronetConnection;", "invoke", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$fetchRes$1$1"})
  static final class n
    extends kotlin.g.b.q
    implements kotlin.g.a.b<z, x>
  {
    n(String paramString1, s.c paramc, String paramString2, String paramString3)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/mm/sdk/platformtools/MMBatchRunKt$batchRun$2"})
  public static final class o
    extends kotlin.d.b.a.j
    implements kotlin.g.a.m<ak, kotlin.d.d<? super x>, Object>
  {
    Object L$0;
    int label;
    private ak p$;
    
    public o(long paramLong, String paramString, kotlin.d.d paramd, s params)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<x> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(6785);
      kotlin.g.b.p.k(paramd, "completion");
      paramd = new o(this.$delay, this.$key, paramd, this.sPa);
      paramd.p$ = ((ak)paramObject);
      AppMethodBeat.o(6785);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(6786);
      paramObject1 = ((o)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(x.aazN);
      AppMethodBeat.o(6786);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(6784);
      Object localObject = kotlin.d.a.a.aaAA;
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
        if (aw.a(l, this) == localObject)
        {
          AppMethodBeat.o(6784);
          return localObject;
        }
        break;
      case 1: 
        localObject = (ak)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        paramObject = localObject;
      }
      if (!al.a(paramObject))
      {
        paramObject = x.aazN;
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
          if (paramObject != null)
          {
            paramObject = (List)paramObject;
            s.a(this.sPa, paramObject);
          }
          __BATCH_RUN_OBJ.INSTANCE.getBatchJobs().remove(this.$key);
          paramObject = x.aazN;
          AppMethodBeat.o(6784);
          return paramObject;
        }
        paramObject = null;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class p
    implements Runnable
  {
    p(List paramList) {}
    
    public final void run()
    {
      AppMethodBeat.i(258557);
      LinkedList localLinkedList = new LinkedList();
      Iterator localIterator = ((Iterable)this.sPb).iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        try
        {
          Log.i("MicroMsg.WebPrefetcher", "pre dns:".concat(String.valueOf(InetAddress.getByName(str))));
          Object localObject = com.tencent.mm.plugin.brandservice.c.soD;
          localObject = com.tencent.mm.plugin.brandservice.c.cyN();
          kotlin.g.b.p.j(str, "host");
          ((MMCacheSlotManager)localObject).add(str);
          localLinkedList.add(str);
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.WebPrefetcher", "InetAddress Error, " + localException.getMessage());
        }
      }
      com.tencent.mm.plugin.webview.i.f.aoe(localLinkedList.size());
      AppMethodBeat.o(258557);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/mm/sdk/platformtools/MMBatchRunKt$batchRun$2"})
  public static final class q
    extends kotlin.d.b.a.j
    implements kotlin.g.a.m<ak, kotlin.d.d<? super x>, Object>
  {
    Object L$0;
    int label;
    private ak p$;
    
    public q(long paramLong, String paramString1, kotlin.d.d paramd, String paramString2, com.tencent.mm.plugin.ax.a parama, boolean paramBoolean, int paramInt1, String paramString3, int paramInt2)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<x> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(6796);
      kotlin.g.b.p.k(paramd, "completion");
      paramd = new q(this.$delay, this.$key, paramd, parama, paramBoolean, paramInt1, paramString2, paramInt2, this.sPf);
      paramd.p$ = ((ak)paramObject);
      AppMethodBeat.o(6796);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(6797);
      paramObject1 = ((q)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(x.aazN);
      AppMethodBeat.o(6797);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(6795);
      Object localObject1 = kotlin.d.a.a.aaAA;
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
        if (aw.a(l, this) == localObject1)
        {
          AppMethodBeat.o(6795);
          return localObject1;
        }
        break;
      case 1: 
        localObject1 = (ak)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        paramObject = localObject1;
      }
      if (!al.a(paramObject))
      {
        paramObject = x.aazN;
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
            localObject1 = (s.b)paramObject.next();
            ??? = ((s.b)localObject1).fXu;
            localObject3 = c.apK(((s.b)localObject1).fXu);
            Object localObject4 = com.tencent.mm.plugin.ax.c.PwQ;
            localObject4 = com.tencent.mm.plugin.ax.c.gPW();
            s locals = s.sNX;
            ??? = new s.d((String)???, (String)localObject3, (com.tencent.mm.plugin.ax.b)localObject4, s.cCy(), null, parama, null, paramBoolean, paramInt1, 80);
            if (!((s.d)???).cCU()) {
              break label551;
            }
            if (((s.b)localObject1).sOa) {
              continue;
            }
            int i = Math.max(((s.d)???).cCQ() - 60, 60);
            if ((((s.d)???).cCR() > 0L) && (MMSlotKt.isExpire(((s.d)???).cCR(), i)))
            {
              com.tencent.mm.plugin.report.service.h.IzE.a(21074, new Object[] { ((s.b)localObject1).host, Integer.valueOf(paramString2), Integer.valueOf(2), paramInt2, paramInt2, Integer.valueOf(2), Integer.valueOf(this.sPf) });
              localObject3 = s.sNX;
              s.a(((s.b)localObject1).sNZ, ((s.b)localObject1).host, (s.d)???, ((s.b)localObject1).sOb);
              continue;
            }
          }
          else
          {
            paramObject = null;
          }
        }
        com.tencent.mm.plugin.report.service.h.IzE.a(21074, new Object[] { ((s.b)localObject1).host, Integer.valueOf(paramString2), Integer.valueOf(2), paramInt2, paramInt2, Integer.valueOf(1), Integer.valueOf(this.sPf) });
        continue;
        label551:
        com.tencent.mm.plugin.report.service.h.IzE.a(21074, new Object[] { ((s.b)localObject1).host, Integer.valueOf(paramString2), Integer.valueOf(2), paramInt2, paramInt2, Integer.valueOf(3), Integer.valueOf(this.sPf) });
        Object localObject3 = s.sNX;
        s.a(((s.b)localObject1).sNZ, ((s.b)localObject1).host, (s.d)???, ((s.b)localObject1).sOb);
      }
      __BATCH_RUN_OBJ.INSTANCE.getBatchJobs().remove(this.$key);
      paramObject = x.aazN;
      AppMethodBeat.o(6795);
      return paramObject;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class r
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Integer>
  {
    public static final r sPg;
    
    static
    {
      AppMethodBeat.i(259080);
      sPg = new r();
      AppMethodBeat.o(259080);
    }
    
    r()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class s
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Integer>
  {
    public static final s sPh;
    
    static
    {
      AppMethodBeat.i(265457);
      sPh = new s();
      AppMethodBeat.o(265457);
    }
    
    s()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class t
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Integer>
  {
    public static final t sPi;
    
    static
    {
      AppMethodBeat.i(257971);
      sPi = new t();
      AppMethodBeat.o(257971);
    }
    
    t()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class u
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Boolean>
  {
    public static final u sPj;
    
    static
    {
      AppMethodBeat.i(265176);
      sPj = new u();
      AppMethodBeat.o(265176);
    }
    
    u()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"saveManifest", "", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyLiteResponse;", "localPrefetchDomainInfos", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protobuf/ByteString;", "continuation", "Lkotlin/coroutines/Continuation;", "", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyLitePrefetchDomainInfo;"})
  static final class v
    extends kotlin.d.b.a.d
  {
    Object L$0;
    int label;
    Object oDA;
    Object pGq;
    Object pGr;
    Object rdb;
    Object sPl;
    Object sPm;
    Object sPn;
    Object sPo;
    Object sPp;
    Object sPq;
    Object sPr;
    Object sPs;
    Object sPt;
    
    v(s params, kotlin.d.d paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(265852);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.sPk.a(null, null, this);
      AppMethodBeat.o(265852);
      return paramObject;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyLitePrefetchResInfo;", "kotlin.jvm.PlatformType", "invoke"})
  static final class w
    extends kotlin.g.b.q
    implements kotlin.g.a.b<bon, String>
  {
    public static final w sPu;
    
    static
    {
      AppMethodBeat.i(258413);
      sPu = new w();
      AppMethodBeat.o(258413);
    }
    
    w()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"savePrefetch", "", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyLiteResponse;", "request", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyLiteRequest;", "domains", "", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyLitePrefetchDomainInfo;", "continuation", "Lkotlin/coroutines/Continuation;", ""})
  static final class x
    extends kotlin.d.b.a.d
  {
    Object L$0;
    int label;
    Object oDA;
    Object pGq;
    Object pGr;
    boolean pdt;
    boolean pdu;
    Object rdb;
    int rdc;
    int rdd;
    int sPA;
    int sPB;
    Object sPl;
    Object sPm;
    Object sPn;
    Object sPo;
    Object sPp;
    Object sPq;
    Object sPr;
    Object sPs;
    Object sPt;
    Object sPv;
    Object sPw;
    Object sPx;
    Object sPy;
    Object sPz;
    
    x(s params, kotlin.d.d paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(266599);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.sPk.a(null, null, null, this);
      AppMethodBeat.o(266599);
      return paramObject;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class y
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    y(bop parambop)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "kotlin.jvm.PlatformType", "it", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyLiteReqInfo;", "invoke"})
  static final class z
    extends kotlin.g.b.q
    implements kotlin.g.a.b<boo, String>
  {
    public static final z sPD;
    
    static
    {
      AppMethodBeat.i(258586);
      sPD = new z();
      AppMethodBeat.o(258586);
    }
    
    z()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.s
 * JD-Core Version:    0.7.0.1
 */