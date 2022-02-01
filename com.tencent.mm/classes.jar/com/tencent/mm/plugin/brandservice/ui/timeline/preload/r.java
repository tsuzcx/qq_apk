package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import android.content.Context;
import android.net.Uri;
import com.tencent.mars.cdn.CronetLogic;
import com.tencent.mars.cdn.CronetLogic.ChunkedData;
import com.tencent.mars.cdn.CronetLogic.CronetDownloadProgress;
import com.tencent.mars.cdn.CronetLogic.CronetTaskCallback;
import com.tencent.mars.cdn.CronetLogic.CronetTaskResult;
import com.tencent.mars.cdn.CronetLogic.ResponseHeader;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.network.aa;
import com.tencent.mm.network.aj;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.brandservice.api.TransferRequestInfo;
import com.tencent.mm.plugin.brandservice.api.g.a;
import com.tencent.mm.plugin.brandservice.api.h.a;
import com.tencent.mm.plugin.brandservice.api.h.b;
import com.tencent.mm.plugin.brandservice.api.h.c;
import com.tencent.mm.plugin.webview.core.i.a;
import com.tencent.mm.plugin.webview.k.j.a;
import com.tencent.mm.protocal.protobuf.ccx;
import com.tencent.mm.protocal.protobuf.ccy;
import com.tencent.mm.protocal.protobuf.ccz;
import com.tencent.mm.protocal.protobuf.cda;
import com.tencent.mm.protocal.protobuf.cdb;
import com.tencent.mm.protocal.protobuf.cdc;
import com.tencent.mm.protocal.protobuf.cdd;
import com.tencent.mm.protocal.protobuf.czo;
import com.tencent.mm.protocal.protobuf.dam;
import com.tencent.mm.protocal.protobuf.dew;
import com.tencent.mm.protocal.protobuf.gho;
import com.tencent.mm.protocal.protobuf.ghp;
import com.tencent.mm.protocal.protobuf.ghq;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMCacheSlotManager;
import com.tencent.mm.sdk.platformtools.MMKVSlotManager;
import com.tencent.mm.sdk.platformtools.MMSlotKt;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.__BATCH_RUN_OBJ;
import com.tencent.mm.vfs.y;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.ao;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.List<+Lcom.tencent.mm.plugin.brandservice.api.h.a;>;
import java.util.List<+Lcom.tencent.mm.protocal.protobuf.ccy;>;
import java.util.List<Ljava.lang.String;>;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.a.ak;
import kotlin.a.p;
import kotlin.d.d<-Lkotlin.ah;>;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.ah.a;
import kotlin.g.b.ah.d;
import kotlin.g.b.s;
import kotlin.n.n;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.bb;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.bu;
import kotlinx.coroutines.cb;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher;", "", "()V", "MIN_EXPIRE_SECONDS", "", "PRE_AUTH_EXPIRE_SECONDS", "REFRESH_BEFORE_EXPIRE_SECONDS", "value", "currentScene", "getCurrentScene", "()I", "setCurrentScene", "(I)V", "preauthRequestLimiter", "Lcom/tencent/mm/sdk/platformtools/MMCacheSlotManager;", "getPreauthRequestLimiter$plugin_brandservice_release", "()Lcom/tencent/mm/sdk/platformtools/MMCacheSlotManager;", "prefetchInfoManager", "Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "getPrefetchInfoManager$plugin_brandservice_release", "()Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "prefetchNewTestFirstMainControlSwitch", "getPrefetchNewTestFirstMainControlSwitch", "prefetchNewTestFirstMainControlSwitch$delegate", "Lkotlin/Lazy;", "prefetchNewTestManager", "prefetchNewTestSecondControlClose", "getPrefetchNewTestSecondControlClose", "prefetchNewTestSecondControlClose$delegate", "prefetchNewTestSecondControlScene", "getPrefetchNewTestSecondControlScene", "prefetchNewTestSecondControlScene$delegate", "prefetchTestMode", "", "getPrefetchTestMode", "()Z", "prefetchTestMode$delegate", "resHeadersManager", "getResHeadersManager$plugin_brandservice_release", "sendingGetA8keyLiteQueue", "Ljava/util/concurrent/ConcurrentSkipListSet;", "", "settingManager", "getSettingManager$plugin_brandservice_release", "userAgentInfo", "Lcom/tencent/mm/plugin/webview/util/WebPrefetchUserAgentInfo;", "getUserAgentInfo", "()Lcom/tencent/mm/plugin/webview/util/WebPrefetchUserAgentInfo;", "userAgentInfo$delegate", "webHeadersManager", "getWebHeadersManager$plugin_brandservice_release", "webIdToSceneManager", "getWebIdToSceneManager$plugin_brandservice_release", "clearPrefetchContent", "", "url", "debugPreloadWebInfo", "", "(Ljava/lang/String;)[[Ljava/lang/String;", "fetchBizPkg", "target", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchTarget;", "prefetchHeaders", "", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchTarget;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchContent", "host", "deep", "fetchManifest", "manifest", "Lcom/tencent/mm/plugin/webprefetcher/PrefetchManifest;", "(Lcom/tencent/mm/plugin/webprefetcher/PrefetchManifest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchRes", "batchRes", "", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchRes;", "documentUrl", "genCorsOrigin", "getPreAuthUrl", "prefetchId", "getPrefetchContentResp", "Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService$PrefetchResponse;", "getPrefetchResResp", "referer", "appId", "pkgKey", "getReportScene", "getRespUrl", "getUrlCookie", "getUrlScene", "getValidPreloadWebInfo", "Lcom/tencent/mm/protocal/protobuf/WebPrefetchInfo;", "isDnsCached", "isInPreAuthWhiteList", "isUrlCache", "isUrlCacheInner", "webId", "isUrlCanPreAuth", "isUrlPreAuthed", "isWebUrlEqual", "rawUrl", "targetUrl", "isWebUrlStorageEqual", "matchManifest", "domains", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyLitePrefetchDomainInfo;", "needReauth", "preAuth", "title", "desc", "from", "scene", "delayTime", "", "preAuths", "auths", "Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService$PreAuthInfo;", "preDns", "urls", "prefetch", "prefetchUrl", "checkCacheOnly", "headers", "bizScene", "subBizScene", "needDownloadPkg", "forceFetchForDebug", "processFetchContentResult", "responseCode", "responseMessage", "checkHeaders", "Lkotlin/Function0;", "sendGetA8KeyLiteRequest", "preauths", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$BatchPreauth;", "setUrlToScene", "connect", "Lcom/tencent/mm/network/MMHttpUrlCronetConnection;", "receiveHeader", "Lkotlin/Function1;", "targetFile", "Lcom/tencent/mm/vfs/VFSFile;", "onCompleted", "mockManifest", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyLiteResponse;", "prepare", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyLiteRequest;", "save", "saveDomainInfos", "saveManifest", "localPrefetchDomainInfos", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protobuf/ByteString;", "(Lcom/tencent/mm/protocal/protobuf/GetA8KeyLiteResponse;Ljava/util/LinkedList;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "savePrefetch", "request", "(Lcom/tencent/mm/protocal/protobuf/GetA8KeyLiteResponse;Lcom/tencent/mm/protocal/protobuf/GetA8KeyLiteRequest;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "BatchPreauth", "PrefetchAction", "PrefetchRes", "PrefetchTarget", "PrefetchType", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class r
{
  public static final r vTf;
  private static final MMKVSlotManager vTg;
  private static final MMKVSlotManager vTh;
  private static final MMKVSlotManager vTi;
  private static final MMKVSlotManager vTj;
  private static final MMKVSlotManager vTk;
  private static final ConcurrentSkipListSet<String> vTl;
  private static final kotlin.j vTm;
  private static final kotlin.j vTn;
  private static final kotlin.j vTo;
  private static final kotlin.j vTp;
  private static final MMCacheSlotManager vTq;
  private static final kotlin.j vTr;
  private static final MMKVSlotManager vTs;
  
  static
  {
    AppMethodBeat.i(6809);
    vTf = new r();
    vTg = new MMKVSlotManager(u.dgw(), 43200L);
    vTh = new MMKVSlotManager(u.dgw(), 604800L);
    vTi = new MMKVSlotManager(u.dgw(), 86400L);
    vTj = new MMKVSlotManager(u.dgw(), 604800L);
    vTk = new MMKVSlotManager(u.dgx(), 25200L);
    vTl = new ConcurrentSkipListSet();
    vTm = kotlin.k.cm((kotlin.g.a.a)o.vUz);
    vTn = kotlin.k.cm((kotlin.g.a.a)p.vUA);
    vTo = kotlin.k.cm((kotlin.g.a.a)q.vUB);
    vTp = kotlin.k.cm((kotlin.g.a.a)x.vUP);
    vTq = new MMCacheSlotManager();
    vTr = kotlin.k.cm((kotlin.g.a.a)r.vUC);
    vTs = new MMKVSlotManager(q.dfF(), 172800L);
    AppMethodBeat.o(6809);
  }
  
  public static void HG(int paramInt)
  {
    AppMethodBeat.i(175491);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("WebPrefetcher.currentScene");
    if (localMultiProcessMMKV != null) {
      localMultiProcessMMKV.encode("currentScene", paramInt);
    }
    AppMethodBeat.o(175491);
  }
  
  private static aa a(aa paramaa, d paramd, com.tencent.mm.vfs.u paramu, kotlin.g.a.b<? super Integer, Boolean> paramb, kotlin.g.a.b<? super Boolean, kotlin.ah> paramb1)
  {
    AppMethodBeat.i(303316);
    if ((paramu == null) && (paramd.vTz == null))
    {
      Log.e("MicroMsg.WebPrefetcher", "invalid file");
      AppMethodBeat.o(303316);
      return paramaa;
    }
    com.tencent.mm.vfs.u localu = paramu;
    if (paramu == null)
    {
      paramu = paramd.vTz;
      s.checkNotNull(paramu);
      localu = paramu.bii(paramd.dfT());
    }
    if (localu.jKS())
    {
      if (n.bp((CharSequence)paramd.dgg())) {
        break label145;
      }
      i = 1;
      label84:
      if (i != 0) {
        paramaa.setRequestProperty("x-wx-if-none-match", paramd.dgg());
      }
      if (n.bp((CharSequence)paramd.dgh())) {
        break label151;
      }
    }
    label145:
    label151:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        paramaa.setRequestProperty("if-none-match", paramd.dgh());
      }
      a(paramaa, localu, paramb, paramb1);
      break;
      i = 0;
      break label84;
    }
  }
  
  private static aa a(aa paramaa, final com.tencent.mm.vfs.u paramu, final kotlin.g.a.b<? super Integer, Boolean> paramb, final kotlin.g.a.b<? super Boolean, kotlin.ah> paramb1)
  {
    AppMethodBeat.i(303307);
    long l = System.currentTimeMillis();
    Object localObject = MMApplicationContext.getContext();
    j.a locala = com.tencent.mm.plugin.webview.k.j.Xta;
    localObject = com.tencent.mm.plugin.appbrand.af.r.a((Context)localObject, j.a.iCS(), (com.tencent.mm.plugin.appbrand.af.r.a)vTp.getValue());
    paramaa.setRequestProperty("User-Agent", (String)localObject);
    paramaa.pph = false;
    paramaa.ppi = false;
    paramaa.eir = "GET";
    paramaa.ppj = true;
    paramaa.ppt = true;
    paramu = y.n(com.tencent.mm.vfs.ah.v(paramu.mUri), true);
    paramaa.mSavePath = s.X(paramu, ".fd");
    Log.v("MicroMsg.WebPrefetcher", "connect session: " + l + ", targetPath: " + paramu + ", prefetch UA: " + localObject);
    paramaa.ppm = 2;
    paramaa.ppl = ((CronetLogic.CronetTaskCallback)new g(l, paramaa, paramb1, paramu, paramb));
    paramaa.ppd = 10000;
    paramaa.ppc = 3000;
    paramaa.connect();
    AppMethodBeat.o(303307);
    return paramaa;
  }
  
  private static Object a(final com.tencent.mm.plugin.az.a parama, kotlin.d.d<? super Boolean> paramd)
  {
    AppMethodBeat.i(303325);
    kotlin.d.h localh = new kotlin.d.h(kotlin.d.a.b.au(paramd));
    final kotlin.d.d locald = (kotlin.d.d)localh;
    Object localObject1 = parama.WmT.aamu;
    s.s(localObject1, "manifest.manifest.ManifestUrl");
    Object localObject3 = com.tencent.mm.plugin.az.e.bim((String)localObject1);
    localObject1 = com.tencent.mm.plugin.az.c.WmU;
    Object localObject2;
    if (!com.tencent.mm.plugin.az.c.ipo().contains((String)localObject3))
    {
      localObject1 = com.tencent.mm.plugin.webview.core.i.Wya;
      if (i.a.gTR())
      {
        localObject1 = parama.WmT.aamu;
        s.s(localObject1, "manifest.manifest.ManifestUrl");
        if (n.U((String)localObject1, "file://", false))
        {
          localObject1 = parama.WmT.aamu;
          localObject2 = com.tencent.mm.plugin.az.c.WmU;
          long l = y.O((String)localObject1, com.tencent.mm.vfs.ah.v(com.tencent.mm.plugin.az.c.ipo().bii((String)localObject3).jKT()), false);
          localObject1 = parama.WmT.aamu;
          localObject2 = com.tencent.mm.plugin.az.c.WmU;
          Log.i("MicroMsg.WebPrefetcher", "fetchManifest from local file: %s, size: %d", new Object[] { localObject1, kotlin.d.b.a.b.BF(com.tencent.mm.plugin.az.c.ipo().bii((String)localObject3).length()) });
          if (l > 0L)
          {
            parama = Boolean.TRUE;
            localObject1 = Result.Companion;
            locald.resumeWith(Result.constructor-impl(parama));
          }
        }
      }
    }
    for (;;)
    {
      parama = localh.kli();
      if (parama == kotlin.d.a.a.aiwj) {
        s.u(paramd, "frame");
      }
      AppMethodBeat.o(303325);
      return parama;
      Object localObject4 = com.tencent.mm.plugin.report.service.h.OAn;
      ccy localccy = parama.WmS;
      int i = parama.mUU;
      localObject2 = parama.WmT.aamu;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      ((com.tencent.mm.plugin.report.service.h)localObject4).b(21074, new Object[] { localccy, Integer.valueOf(i), Integer.valueOf(1), "", localObject1, Integer.valueOf(3), Integer.valueOf(parama.mUU) });
      aj.a(new aa(parama.WmT.aamu, 0), (kotlin.g.a.b)new k((String)localObject3, parama, locald));
      continue;
      localObject3 = com.tencent.mm.plugin.report.service.h.OAn;
      localObject4 = parama.WmS;
      i = parama.mUU;
      localObject2 = parama.WmT.aamu;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      ((com.tencent.mm.plugin.report.service.h)localObject3).b(21074, new Object[] { localObject4, Integer.valueOf(i), Integer.valueOf(1), "", localObject1, Integer.valueOf(1), Integer.valueOf(parama.mUU) });
      parama = Boolean.TRUE;
      localObject1 = Result.Companion;
      locald.resumeWith(Result.constructor-impl(parama));
    }
  }
  
  private final Object a(cdd paramcdd, cdb paramcdb, List<? extends ccy> paramList, kotlin.d.d<? super kotlin.ah> paramd)
  {
    AppMethodBeat.i(303481);
    if ((paramd instanceof t))
    {
      localObject1 = (t)paramd;
      if ((((t)localObject1).label & 0x80000000) != 0) {
        ((t)localObject1).label += -2147483648;
      }
    }
    kotlin.d.a.a locala;
    for (paramd = (kotlin.d.d<? super kotlin.ah>)localObject1;; paramd = new t(this, paramd))
    {
      localObject1 = paramd.result;
      locala = kotlin.d.a.a.aiwj;
      switch (paramd.label)
      {
      default: 
        paramcdd = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(303481);
        throw paramcdd;
      }
    }
    ResultKt.throwOnFailure(localObject1);
    Object localObject2 = new LinkedList();
    Object localObject4 = new ah.a();
    Object localObject3 = new ah.a();
    Object localObject6 = new HashMap();
    Object localObject8 = new HashMap();
    Object localObject9 = new HashMap();
    Object localObject1 = ((Iterable)paramList).iterator();
    Object localObject5;
    Object localObject10;
    Object localObject11;
    while (((Iterator)localObject1).hasNext())
    {
      localObject5 = (ccy)((Iterator)localObject1).next();
      localObject10 = (Map)localObject9;
      localObject11 = ((ccy)localObject5).aamn;
      s.s(localObject11, "it.Domain");
      ((Map)localObject10).put(localObject11, localObject5);
    }
    int j = paramcdd.YMX;
    int k;
    int i;
    Object localObject12;
    Object localObject13;
    int m;
    label539:
    boolean bool1;
    label553:
    label573:
    label596:
    label732:
    Object localObject14;
    Object localObject15;
    if (j > 0)
    {
      k = 0;
      localObject5 = paramList;
      localObject1 = paramcdb;
      paramcdb = this;
      paramList = paramcdd;
      i = k + 1;
      paramcdd = new ghq();
      ((ah.a)localObject4).aiwY = false;
      ((ah.a)localObject3).aiwY = false;
      paramcdd.url = ((cda)((cdb)localObject1).aamG.get(k)).aamy;
      paramcdd.sMq = ((cdc)paramList.aamV.get(k)).aamI;
      paramcdd.acdZ = ((cdc)paramList.aamV.get(k)).aamT;
      localObject10 = paramcdd.url;
      s.s(localObject10, "url");
      localObject12 = c.ajl((String)localObject10);
      localObject10 = ((cdb)localObject1).aamG.get(k);
      boolean bool2;
      if ((localObject10 instanceof h))
      {
        localObject10 = (h)localObject10;
        if (localObject10 != null)
        {
          paramcdd.mUU = ((h)localObject10).mUU;
          paramcdd.vBa = ((h)localObject10).vBa;
          paramcdd.vAY = ((h)localObject10).vAY;
          localObject10 = kotlin.ah.aiuX;
        }
        localObject10 = paramcdd.sMq;
        s.s(localObject10, "fullUrl");
        if (!n.U((String)localObject10, "http", false)) {
          break label7896;
        }
        localObject13 = (Map)new LinkedHashMap();
        if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yNc, 1) != 1) {
          break label801;
        }
        m = 1;
        localObject10 = com.tencent.mm.plugin.webview.core.i.Wya;
        if (!i.a.gTR()) {
          break label807;
        }
        bool1 = true;
        localObject10 = new StringBuilder("[TRACE_PREFETCH] useA8keyLiteHeader: ");
        if (m == 0) {
          break label822;
        }
        bool2 = true;
        localObject10 = ((StringBuilder)localObject10).append(bool2).append(" mockUseA8keyLiteHeader: ");
        if (!bool1) {
          break label828;
        }
        bool2 = true;
        Log.i("MicroMsg.WebPrefetcher", bool2);
        if (((m == 0) && (!bool1)) || (Util.isNullOrNil((List)((cdc)paramList.aamV.get(k)).aamS))) {
          break label922;
        }
        Log.i("MicroMsg.WebPrefetcher", s.X("[TRACE_PREFETCH] response header size : ", Integer.valueOf(((cdc)paramList.aamV.get(k)).aamS.size())));
        localObject10 = ((cdc)paramList.aamV.get(k)).aamS;
        s.s(localObject10, "RespInfo[i].HttpHeader");
        localObject11 = (Iterable)localObject10;
        localObject10 = (Collection)new ArrayList();
        localObject11 = ((Iterable)localObject11).iterator();
        if (!((Iterator)localObject11).hasNext()) {
          break label840;
        }
        localObject14 = ((Iterator)localObject11).next();
        localObject15 = (dam)localObject14;
        if ((((dam)localObject15).ILw != null) && (((dam)localObject15).OzQ != null)) {
          break label834;
        }
      }
      label801:
      label807:
      label822:
      label828:
      label834:
      for (m = 1;; m = 0)
      {
        if (m != 0) {
          break label732;
        }
        ((Collection)localObject10).add(localObject14);
        break label732;
        localObject10 = null;
        break;
        m = 0;
        break label539;
        bool1 = com.tencent.mm.plugin.webview.core.j.cTb().getBoolean("webview_use_a8key_lite_header", false);
        break label553;
        bool2 = false;
        break label573;
        bool2 = false;
        break label596;
      }
      label840:
      localObject10 = ((Iterable)localObject10).iterator();
      while (((Iterator)localObject10).hasNext())
      {
        localObject14 = (dam)((Iterator)localObject10).next();
        localObject11 = ((dam)localObject14).ILw;
        s.s(localObject11, "it.Key");
        localObject14 = ((dam)localObject14).OzQ;
        s.s(localObject14, "it.Value");
        ((Map)localObject13).put(localObject11, localObject14);
      }
      label922:
      localObject11 = new StringBuilder("[TRACE_PREFETCH] useA8keyLiteHeader size : ").append(((Map)localObject13).size()).append(" domains.size=").append(((List)localObject5).size()).append(", controlBytes: ");
      localObject10 = ((cdc)paramList.aamV.get(k)).aamT;
      if (localObject10 == null)
      {
        localObject10 = null;
        Log.i("MicroMsg.WebPrefetcher", localObject10 + ", authBits: " + ((cdc)paramList.aamV.get(k)).aamO);
        paramcdd.pba = MMSlotKt.now();
        localObject10 = (Integer)paramList.aamU.get(k);
        if (localObject10 != null) {
          break label1396;
        }
        label1057:
        paramcdd.acdW = true;
        label1062:
        if (!paramcdd.acdW)
        {
          ((LinkedList)localObject2).add(paramcdd.sMq);
          ((ah.a)localObject3).aiwY = true;
        }
        localObject10 = (Collection)localObject5;
        if ((localObject10 != null) && (!((Collection)localObject10).isEmpty())) {
          break label1430;
        }
        m = 1;
        label1110:
        if (m == 0) {
          com.tencent.mm.plugin.report.service.h.OAn.b(21075, new Object[] { Integer.valueOf(paramcdd.mUU), paramcdd.url, paramcdd.sMq, Integer.valueOf(1), Integer.valueOf(paramcdd.vBa) });
        }
        if ((dfK() <= 0) || (dfL() != com.tencent.mm.plugin.webview.h.e.WQK.ordinal()) || (dfM() != paramcdd.mUU)) {
          break label1436;
        }
        Log.i("MicroMsg.WebPrefetcher", "ClosePrefetch but KeepA8key");
        a(paramcdd);
        localObject13 = localObject4;
        localObject12 = localObject3;
        localObject11 = localObject9;
        paramcdd = (cdd)localObject5;
        label1225:
        if (i < j) {
          break label7319;
        }
        paramcdb = (cdb)localObject6;
        paramcdd = paramList;
        paramList = (List<? extends ccy>)localObject8;
      }
    }
    for (;;)
    {
      if (!((Collection)localObject2).isEmpty())
      {
        i = 1;
        if (i == 0) {}
      }
      label1396:
      label3317:
      label6271:
      Object localObject7;
      for (;;)
      {
        label1430:
        label1436:
        label1601:
        label2407:
        int i3;
        try
        {
          for (;;)
          {
            ey((List)localObject2);
            com.tencent.mm.plugin.webview.h.h.atV(paramcdd.YMX);
            paramd = (Map)paramcdb;
            paramcdd = (Collection)new ArrayList(paramd.size());
            paramd = paramd.entrySet().iterator();
            while (paramd.hasNext())
            {
              localObject1 = (Map.Entry)paramd.next();
              i = ((Number)((Map.Entry)localObject1).getKey()).intValue();
              com.tencent.mm.plugin.webview.h.h.nl(((Number)((Map.Entry)localObject1).getValue()).intValue(), i);
              paramcdd.add(kotlin.ah.aiuX);
            }
            localObject10 = Integer.valueOf(((com.tencent.mm.bx.b)localObject10).Op.length);
            break;
            if (((Integer)localObject10).intValue() != 0) {
              break label1057;
            }
            if (((cdc)paramList.aamV.get(k)).aamO == 0) {
              break label1062;
            }
            paramcdd.rhq = true;
            break label1062;
            m = 0;
            break label1110;
            localObject10 = paramcdd.sMq;
            s.s(localObject10, "fullUrl");
            localObject14 = s((String)localObject10, (List)localObject5);
            if (localObject14 == null)
            {
              localObject10 = null;
              if (localObject14 == null) {
                break label6369;
              }
              com.tencent.mm.plugin.report.service.h.OAn.b(21075, new Object[] { Integer.valueOf(paramcdd.mUU), paramcdd.url, paramcdd.sMq, Integer.valueOf(2), Integer.valueOf(paramcdd.vBa) });
              localObject11 = ((cdb)localObject1).aamG.get(k);
              if (!(localObject11 instanceof h)) {
                break label1931;
              }
              localObject11 = (h)localObject11;
              label1553:
              if (localObject11 != null) {
                break label1937;
              }
              localObject11 = null;
              label1561:
              ((com.tencent.mm.plugin.az.a)localObject14).extInfo = ((String)localObject11);
              ((com.tencent.mm.plugin.az.a)localObject14).mUU = paramcdd.mUU;
              ((com.tencent.mm.plugin.az.a)localObject14).vBa = paramcdd.vBa;
              localObject11 = ((com.tencent.mm.plugin.az.a)localObject14).WmT;
              if (localObject11 != null) {
                break label1947;
              }
              localObject11 = null;
              localObject15 = ((com.tencent.mm.plugin.az.a)localObject14).WmT.aamu;
              Log.v("MicroMsg.WebPrefetcher", "match prefetch#" + (String)localObject12 + ", " + paramcdd.url + ", manifest: " + localObject15);
              localObject16 = (CharSequence)localObject11;
              if ((localObject16 != null) && (!n.bp((CharSequence)localObject16))) {
                break label1957;
              }
              k = 1;
              label1682:
              if (k != 0) {
                break label2725;
              }
              localObject16 = com.tencent.mm.plugin.az.c.WmU;
              if (!com.tencent.mm.plugin.az.c.a.ipr()) {
                break label2725;
              }
              m = 1;
              if (((com.tencent.mm.plugin.az.a)localObject14).debug) {
                break label7864;
              }
              localObject15 = (CharSequence)localObject15;
              if ((localObject15 != null) && (!n.bp((CharSequence)localObject15))) {
                break label1963;
              }
            }
            label1931:
            label1937:
            label1947:
            label1957:
            label1963:
            for (k = 1;; k = 0)
            {
              if (k != 0) {
                break label7864;
              }
              paramd.L$0 = paramcdb;
              paramd.Uf = paramList;
              paramd.VC = localObject1;
              paramd.VD = localObject5;
              paramd.Ze = localObject2;
              paramd.aqc = localObject4;
              paramd.bNS = localObject3;
              paramd.bNT = localObject6;
              paramd.bNU = localObject8;
              paramd.bNV = localObject9;
              paramd.bNW = paramcdd;
              paramd.vUE = paramcdd;
              paramd.vUF = localObject13;
              paramd.vUG = localObject12;
              paramd.vUH = localObject14;
              paramd.vUI = localObject10;
              paramd.vUJ = localObject11;
              paramd.aai = i;
              paramd.asI = j;
              paramd.nuz = 1;
              paramd.label = 1;
              localObject20 = a((com.tencent.mm.plugin.az.a)localObject14, paramd);
              if (localObject20 != locala) {
                break label7767;
              }
              AppMethodBeat.o(303481);
              return locala;
              localObject10 = ((com.tencent.mm.plugin.az.a)localObject14).WmT;
              if (localObject10 == null)
              {
                localObject10 = null;
                break;
              }
              localObject10 = ((ccz)localObject10).UserName;
              break;
              localObject11 = null;
              break label1553;
              localObject11 = ((h)localObject11).extInfo;
              break label1561;
              localObject11 = ((ccz)localObject11).oOI;
              break label1601;
              k = 0;
              break label1682;
            }
            k = paramd.nuz;
            i = paramd.asI;
            j = paramd.aai;
            localObject19 = (String)paramd.vUJ;
            localObject11 = (String)paramd.vUI;
            localObject13 = (com.tencent.mm.plugin.az.a)paramd.vUH;
            paramcdd = (String)paramd.vUG;
            localObject14 = (Map)paramd.vUF;
            localObject3 = (ghq)paramd.vUE;
            localObject15 = (ghq)paramd.bNW;
            localObject18 = (HashMap)paramd.bNV;
            localObject17 = (HashMap)paramd.bNU;
            localObject16 = (HashMap)paramd.bNT;
            localObject4 = (ah.a)paramd.bNS;
            localObject12 = (ah.a)paramd.aqc;
            localObject5 = (LinkedList)paramd.Ze;
            localObject6 = (List)paramd.VD;
            localObject8 = (cdb)paramd.VC;
            localObject9 = (cdd)paramd.Uf;
            localObject10 = (r)paramd.L$0;
            ResultKt.throwOnFailure(localObject1);
            localObject20 = localObject1;
            if (((Boolean)localObject20).booleanValue())
            {
              localObject20 = localObject13;
              localObject21 = paramcdd;
              localObject13 = localObject14;
              m = i;
              i = j;
              localObject14 = localObject16;
              localObject22 = localObject4;
              localObject4 = localObject12;
              localObject16 = localObject6;
              paramcdb = (cdb)localObject10;
              paramList = (List<? extends ccy>)localObject9;
              localObject1 = localObject8;
              localObject2 = localObject5;
              localObject12 = localObject3;
              paramcdd = paramd;
              localObject3 = localObject22;
              localObject6 = localObject14;
              localObject8 = localObject17;
              localObject9 = localObject18;
              j = m;
              localObject10 = localObject21;
              localObject14 = localObject20;
              localObject5 = localObject16;
              localObject16 = localObject19;
              n = 1;
              localObject17 = localObject16;
              localObject18 = localObject14;
              localObject16 = localObject10;
              m = j;
              paramd = (kotlin.d.d<? super kotlin.ah>)localObject9;
              localObject14 = localObject8;
              localObject20 = localObject6;
              localObject19 = localObject4;
              localObject10 = paramcdb;
              localObject9 = paramList;
              localObject8 = localObject1;
              localObject6 = localObject5;
              localObject5 = localObject2;
              localObject4 = localObject3;
              localObject3 = localObject20;
              localObject2 = localObject14;
              localObject1 = paramd;
              j = i;
              paramd = (kotlin.d.d<? super kotlin.ah>)localObject12;
              i = m;
              localObject14 = localObject13;
              localObject13 = localObject18;
              localObject12 = localObject17;
              paramList = paramcdd;
              paramcdb = (cdb)localObject19;
              m = n;
              paramcdd = (cdd)localObject16;
              localObject16 = new StringBuilder("savePrefetch appId=").append(localObject12).append(" fetched=");
              if (m == 0) {
                break label3390;
              }
              bool1 = true;
              localObject16 = ((StringBuilder)localObject16).append(bool1).append(" debug:").append(((com.tencent.mm.plugin.az.a)localObject13).debug).append(" usePkg=");
              if (k == 0) {
                break label3396;
              }
            }
            label2725:
            label3390:
            label3396:
            for (bool1 = true;; bool1 = false)
            {
              Log.i("MicroMsg.WebPrefetcher", bool1);
              localObject38 = paramcdd;
              localObject31 = paramcdb;
              localObject29 = paramList;
              i1 = i;
              localObject28 = paramd;
              n = j;
              localObject35 = localObject1;
              localObject34 = localObject2;
              localObject33 = localObject3;
              localObject32 = localObject4;
              localObject26 = localObject5;
              localObject30 = localObject6;
              localObject24 = localObject8;
              localObject22 = localObject9;
              localObject21 = localObject10;
              if (m == 0) {
                break label6271;
              }
              localObject16 = WebPrefetcherManifest.vUW;
              localObject17 = paramd.sMq;
              s.s(localObject17, "fullUrl");
              paramList.L$0 = localObject10;
              paramList.Uf = localObject9;
              paramList.VC = localObject8;
              paramList.VD = localObject6;
              paramList.Ze = localObject5;
              paramList.aqc = paramcdb;
              paramList.bNS = localObject4;
              paramList.bNT = localObject3;
              paramList.bNU = localObject2;
              paramList.bNV = localObject1;
              paramList.bNW = localObject15;
              paramList.vUE = paramd;
              paramList.vUF = localObject14;
              paramList.vUG = paramcdd;
              paramList.vUH = localObject13;
              paramList.vUI = localObject11;
              paramList.vUJ = localObject12;
              paramList.aai = j;
              paramList.asI = i;
              paramList.nuz = k;
              paramList.label = 3;
              localObject37 = ((WebPrefetcherManifest)localObject16).a((com.tencent.mm.plugin.az.a)localObject13, (String)localObject17, paramList);
              if (localObject37 != locala) {
                break label7593;
              }
              AppMethodBeat.o(303481);
              return locala;
              m = 0;
              paramcdb = (cdb)localObject12;
              paramList = paramd;
              localObject12 = localObject19;
              paramd = (kotlin.d.d<? super kotlin.ah>)localObject3;
              localObject1 = localObject18;
              localObject2 = localObject17;
              localObject3 = localObject16;
              break;
              localObject15 = (CharSequence)localObject15;
              if ((localObject15 == null) || (n.bp((CharSequence)localObject15))) {
                k = 1;
              }
              for (;;)
              {
                if (k == 0)
                {
                  paramd.L$0 = paramcdb;
                  paramd.Uf = paramList;
                  paramd.VC = localObject1;
                  paramd.VD = localObject5;
                  paramd.Ze = localObject2;
                  paramd.aqc = localObject4;
                  paramd.bNS = localObject3;
                  paramd.bNT = localObject6;
                  paramd.bNU = localObject8;
                  paramd.bNV = localObject9;
                  paramd.bNW = paramcdd;
                  paramd.vUE = paramcdd;
                  paramd.vUF = localObject13;
                  paramd.vUG = localObject12;
                  paramd.vUH = localObject14;
                  paramd.vUI = localObject10;
                  paramd.vUJ = localObject11;
                  paramd.aai = i;
                  paramd.asI = j;
                  paramd.nuz = 0;
                  paramd.label = 2;
                  localObject34 = a((com.tencent.mm.plugin.az.a)localObject14, paramd);
                  if (localObject34 != locala) {
                    break label7666;
                  }
                  AppMethodBeat.o(303481);
                  return locala;
                  k = 0;
                  continue;
                  k = paramd.nuz;
                  i = paramd.asI;
                  j = paramd.aai;
                  localObject12 = (String)paramd.vUJ;
                  localObject11 = (String)paramd.vUI;
                  localObject13 = (com.tencent.mm.plugin.az.a)paramd.vUH;
                  paramcdd = (String)paramd.vUG;
                  localObject14 = (Map)paramd.vUF;
                  localObject18 = (ghq)paramd.vUE;
                  localObject15 = (ghq)paramd.bNW;
                  localObject17 = (HashMap)paramd.bNV;
                  localObject16 = (HashMap)paramd.bNU;
                  localObject3 = (HashMap)paramd.bNT;
                  localObject4 = (ah.a)paramd.bNS;
                  localObject19 = (ah.a)paramd.aqc;
                  localObject5 = (LinkedList)paramd.Ze;
                  localObject6 = (List)paramd.VD;
                  localObject8 = (cdb)paramd.VC;
                  localObject9 = (cdd)paramd.Uf;
                  localObject10 = (r)paramd.L$0;
                  ResultKt.throwOnFailure(localObject1);
                  localObject34 = localObject1;
                  localObject33 = localObject11;
                  localObject32 = paramcdd;
                  paramcdb = (cdb)localObject19;
                  paramList = paramd;
                  localObject31 = localObject12;
                  i2 = k;
                  localObject30 = localObject13;
                  localObject29 = localObject14;
                  localObject28 = localObject15;
                  i1 = i;
                  localObject27 = localObject18;
                  n = j;
                  localObject1 = localObject17;
                  localObject2 = localObject16;
                  localObject26 = localObject3;
                  localObject25 = localObject4;
                  localObject24 = localObject5;
                  localObject23 = localObject6;
                  localObject22 = localObject8;
                  localObject21 = localObject9;
                  localObject20 = localObject10;
                  if (!((Boolean)localObject34).booleanValue()) {
                    break label3317;
                  }
                  m = 1;
                  paramcdb = (cdb)localObject19;
                  paramList = paramd;
                  paramd = (kotlin.d.d<? super kotlin.ah>)localObject18;
                  localObject1 = localObject17;
                  localObject2 = localObject16;
                  break;
                }
              }
              i2 = 0;
              localObject28 = paramcdd;
              localObject20 = paramcdb;
              localObject21 = paramList;
              localObject22 = localObject1;
              localObject23 = localObject5;
              localObject24 = localObject2;
              localObject25 = localObject3;
              localObject26 = localObject6;
              localObject2 = localObject8;
              localObject1 = localObject9;
              n = i;
              localObject27 = paramcdd;
              i1 = j;
              localObject29 = localObject13;
              localObject30 = localObject14;
              localObject31 = localObject11;
              paramList = paramd;
              paramcdb = (cdb)localObject4;
              localObject32 = localObject12;
              localObject33 = localObject10;
              m = 0;
              localObject11 = localObject33;
              paramcdd = (cdd)localObject32;
              localObject12 = localObject31;
              k = i2;
              localObject13 = localObject30;
              localObject14 = localObject29;
              localObject15 = localObject28;
              i = i1;
              paramd = (kotlin.d.d<? super kotlin.ah>)localObject27;
              j = n;
              localObject3 = localObject26;
              localObject4 = localObject25;
              localObject5 = localObject24;
              localObject6 = localObject23;
              localObject8 = localObject22;
              localObject9 = localObject21;
              localObject10 = localObject20;
              break;
              bool1 = false;
              break label2407;
            }
            k = paramd.nuz;
            m = paramd.asI;
            i = paramd.aai;
            localObject12 = (String)paramd.vUJ;
            localObject36 = (String)paramd.vUI;
            localObject27 = (com.tencent.mm.plugin.az.a)paramd.vUH;
            localObject20 = (String)paramd.vUG;
            localObject25 = (Map)paramd.vUF;
            localObject18 = (ghq)paramd.vUE;
            localObject23 = (ghq)paramd.bNW;
            localObject17 = (HashMap)paramd.bNV;
            localObject16 = (HashMap)paramd.bNU;
            localObject15 = (HashMap)paramd.bNT;
            localObject3 = (ah.a)paramd.bNS;
            localObject11 = (ah.a)paramd.aqc;
            localObject2 = (LinkedList)paramd.Ze;
            localObject14 = (List)paramd.VD;
            paramList = (cdb)paramd.VC;
            paramcdb = (cdd)paramd.Uf;
            paramcdd = (r)paramd.L$0;
            ResultKt.throwOnFailure(localObject1);
            localObject19 = paramd;
            Object localObject37 = localObject1;
            Object localObject38 = localObject20;
            Object localObject31 = localObject11;
            localObject29 = localObject19;
            i1 = m;
            localObject28 = localObject18;
            n = i;
            Object localObject35 = localObject17;
            Object localObject34 = localObject16;
            Object localObject33 = localObject15;
            Object localObject32 = localObject3;
            localObject26 = localObject2;
            localObject30 = localObject14;
            localObject24 = paramList;
            localObject22 = paramcdb;
            localObject21 = paramcdd;
            if (((Boolean)localObject37).booleanValue())
            {
              if (((com.tencent.mm.plugin.az.a)localObject27).debug) {}
              for (paramd = Uri.parse(((ghq)localObject18).sMq).getHost();; paramd = (kotlin.d.d<? super kotlin.ah>)localObject12)
              {
                ((ghq)localObject18).appId = paramd;
                paramd = WebPrefetcherManifest.vUW;
                localObject1 = ((ghq)localObject18).sMq;
                s.s(localObject1, "fullUrl");
                ((t)localObject19).L$0 = paramcdd;
                ((t)localObject19).Uf = paramcdb;
                ((t)localObject19).VC = paramList;
                ((t)localObject19).VD = localObject14;
                ((t)localObject19).Ze = localObject2;
                ((t)localObject19).aqc = localObject11;
                ((t)localObject19).bNS = localObject3;
                ((t)localObject19).bNT = localObject15;
                ((t)localObject19).bNU = localObject16;
                ((t)localObject19).bNV = localObject17;
                ((t)localObject19).bNW = localObject23;
                ((t)localObject19).vUE = localObject18;
                ((t)localObject19).vUF = localObject25;
                ((t)localObject19).vUG = localObject20;
                ((t)localObject19).vUH = localObject27;
                ((t)localObject19).vUI = localObject36;
                ((t)localObject19).vUJ = localObject12;
                ((t)localObject19).aai = i;
                ((t)localObject19).asI = m;
                ((t)localObject19).nuz = k;
                ((t)localObject19).label = 4;
                paramd = paramd.c((com.tencent.mm.plugin.az.a)localObject27, (String)localObject1, (kotlin.d.d)localObject19);
                if (paramd != locala) {
                  break;
                }
                AppMethodBeat.o(303481);
                return locala;
              }
              k = paramd.nuz;
              j = paramd.asI;
              i = paramd.aai;
              localObject24 = (String)paramd.vUJ;
              localObject12 = (com.tencent.mm.plugin.az.a)paramd.vUH;
              localObject13 = (String)paramd.vUG;
              localObject10 = (Map)paramd.vUF;
              localObject8 = (ghq)paramd.vUE;
              localObject9 = (ghq)paramd.bNW;
              localObject6 = (HashMap)paramd.bNV;
              localObject5 = (HashMap)paramd.bNU;
              localObject4 = (HashMap)paramd.bNT;
              localObject3 = (ah.a)paramd.bNS;
              localObject14 = (ah.a)paramd.aqc;
              localObject2 = (LinkedList)paramd.Ze;
              localObject15 = (List)paramd.VD;
              paramList = (cdb)paramd.VC;
              paramcdb = (cdd)paramd.Uf;
              paramcdd = (r)paramd.L$0;
              ResultKt.throwOnFailure(localObject1);
              localObject11 = localObject1;
              localObject1 = localObject15;
              localObject20 = localObject11;
              localObject11 = localObject14;
              i3 = ((Number)localObject20).intValue();
              i2 = i3;
              localObject29 = localObject13;
              localObject27 = localObject11;
              localObject26 = paramd;
              i1 = k;
              localObject30 = localObject12;
              localObject28 = localObject10;
              localObject25 = localObject9;
              n = j;
              localObject23 = localObject8;
              m = i;
              localObject22 = localObject6;
              localObject21 = localObject5;
              localObject20 = localObject4;
              localObject19 = localObject3;
              localObject18 = localObject2;
              localObject17 = localObject1;
              localObject16 = paramList;
              localObject15 = paramcdb;
              localObject14 = paramcdd;
              if (k != 0)
              {
                if (((com.tencent.mm.plugin.az.a)localObject12).debug) {
                  break label7531;
                }
                i2 = i3;
                localObject29 = localObject13;
                localObject27 = localObject11;
                localObject26 = paramd;
                i1 = k;
                localObject30 = localObject12;
                localObject28 = localObject10;
                localObject25 = localObject9;
                n = j;
                localObject23 = localObject8;
                m = i;
                localObject22 = localObject6;
                localObject21 = localObject5;
                localObject20 = localObject4;
                localObject19 = localObject3;
                localObject18 = localObject2;
                localObject17 = localObject1;
                localObject16 = paramList;
                localObject15 = paramcdb;
                localObject14 = paramcdd;
                if (i3 == 1)
                {
                  localObject14 = com.tencent.mm.plugin.webcanvas.k.WkZ;
                  s.s(localObject24, "manifestAppId");
                  paramd.L$0 = paramcdd;
                  paramd.Uf = paramcdb;
                  paramd.VC = paramList;
                  paramd.VD = localObject1;
                  paramd.Ze = localObject2;
                  paramd.aqc = localObject11;
                  paramd.bNS = localObject3;
                  paramd.bNT = localObject4;
                  paramd.bNU = localObject5;
                  paramd.bNV = localObject6;
                  paramd.bNW = localObject9;
                  paramd.vUE = localObject8;
                  paramd.vUF = localObject10;
                  paramd.vUG = localObject13;
                  paramd.vUH = localObject12;
                  paramd.vUI = localObject24;
                  paramd.vUJ = null;
                  paramd.aai = i;
                  paramd.asI = j;
                  paramd.nuz = k;
                  paramd.vUK = i3;
                  paramd.label = 5;
                  localObject14 = com.tencent.mm.plugin.webcanvas.k.d((com.tencent.mm.plugin.az.a)localObject12, (String)localObject24, paramd);
                  if (localObject14 != locala) {
                    break label7520;
                  }
                  AppMethodBeat.o(303481);
                  return locala;
                  k = paramd.vUK;
                  m = paramd.nuz;
                  j = paramd.asI;
                  i = paramd.aai;
                  localObject24 = (String)paramd.vUI;
                  localObject12 = (com.tencent.mm.plugin.az.a)paramd.vUH;
                  localObject13 = (String)paramd.vUG;
                  localObject10 = (Map)paramd.vUF;
                  localObject8 = (ghq)paramd.vUE;
                  localObject9 = (ghq)paramd.bNW;
                  localObject6 = (HashMap)paramd.bNV;
                  localObject5 = (HashMap)paramd.bNU;
                  localObject4 = (HashMap)paramd.bNT;
                  localObject3 = (ah.a)paramd.bNS;
                  localObject15 = (ah.a)paramd.aqc;
                  localObject2 = (LinkedList)paramd.Ze;
                  localObject14 = (List)paramd.VD;
                  paramList = (cdb)paramd.VC;
                  paramcdb = (cdd)paramd.Uf;
                  paramcdd = (r)paramd.L$0;
                  ResultKt.throwOnFailure(localObject1);
                  localObject11 = localObject1;
                  localObject1 = localObject14;
                  localObject14 = localObject11;
                  localObject11 = localObject15;
                  if (!((Boolean)localObject14).booleanValue()) {
                    break label7440;
                  }
                  n = m;
                  m = k;
                  k = n;
                  ((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).m((String)localObject24, ((ghq)localObject8).sMq, "itemExpose", null);
                  i2 = m;
                  localObject14 = paramcdd;
                  localObject15 = paramcdb;
                  localObject16 = paramList;
                  localObject17 = localObject1;
                  localObject18 = localObject2;
                  localObject19 = localObject3;
                  localObject20 = localObject4;
                  localObject21 = localObject5;
                  localObject22 = localObject6;
                  m = i;
                  localObject23 = localObject8;
                  n = j;
                  localObject25 = localObject9;
                  localObject28 = localObject10;
                  localObject30 = localObject12;
                  i1 = k;
                  localObject26 = paramd;
                  localObject27 = localObject11;
                  localObject29 = localObject13;
                }
              }
              ((ghq)localObject23).vTu = ((ghq)localObject23).sMq;
              paramcdd = j.vSB;
              if (k.cTb().getBoolean("tencent_view_inews_prefix", false))
              {
                paramcdd = ((ghq)localObject23).vTu;
                s.s(paramcdd, "prefetchUrl");
                ((ghq)localObject23).vTu = n.bW(paramcdd, "//view.inews.qq.com", "//ssr.view.inews.qq.com");
              }
              ((ghq)localObject23).acdX = true;
              ((ghq)localObject23).acdY = true;
              ((ghq)localObject23).vBf = com.tencent.mm.plugin.az.e.a(localObject30);
              ((ghq)localObject23).acea = localObject30.WmT.aamx;
              a((ghq)localObject23);
              Log.i("MicroMsg.WebPrefetcher", "prefetch call, header size: " + ((Map)localObject28).size() + ", url: " + ((ghq)localObject23).vTu + ", fetchPkgType: " + i2 + ", pkgFileKey: " + ((ghq)localObject23).vBf);
              com.tencent.mm.plugin.report.service.h.OAn.b(21075, new Object[] { Integer.valueOf(((ghq)localObject23).mUU), ((ghq)localObject23).url, ((ghq)localObject23).sMq, Integer.valueOf(3), Integer.valueOf(((ghq)localObject23).vBa) });
              paramcdd = WebPrefetcherManifest.vUW;
              paramcdb = ((ghq)localObject23).sMq;
              s.s(paramcdb, "fullUrl");
              ((t)localObject26).L$0 = localObject14;
              ((t)localObject26).Uf = localObject15;
              ((t)localObject26).VC = localObject16;
              ((t)localObject26).VD = localObject17;
              ((t)localObject26).Ze = localObject18;
              ((t)localObject26).aqc = localObject27;
              ((t)localObject26).bNS = localObject19;
              ((t)localObject26).bNT = localObject20;
              ((t)localObject26).bNU = localObject21;
              ((t)localObject26).bNV = localObject22;
              ((t)localObject26).bNW = localObject25;
              ((t)localObject26).vUE = localObject23;
              ((t)localObject26).vUF = localObject28;
              ((t)localObject26).vUG = localObject29;
              ((t)localObject26).vUH = localObject30;
              ((t)localObject26).vUI = null;
              ((t)localObject26).vUJ = null;
              ((t)localObject26).aai = m;
              ((t)localObject26).asI = n;
              ((t)localObject26).nuz = i1;
              ((t)localObject26).vUK = i2;
              ((t)localObject26).label = 6;
              localObject1 = paramcdd.b(localObject30, paramcdb, (kotlin.d.d)localObject26);
              if (localObject1 != locala) {
                break label7416;
              }
              AppMethodBeat.o(303481);
              return locala;
              i = paramd.vUK;
              i1 = paramd.nuz;
              n = paramd.asI;
              m = paramd.aai;
              paramList = (com.tencent.mm.plugin.az.a)paramd.vUH;
              paramcdd = (String)paramd.vUG;
              localObject2 = (Map)paramd.vUF;
              localObject23 = (ghq)paramd.vUE;
              localObject25 = (ghq)paramd.bNW;
              localObject22 = (HashMap)paramd.bNV;
              localObject21 = (HashMap)paramd.bNU;
              localObject20 = (HashMap)paramd.bNT;
              localObject19 = (ah.a)paramd.bNS;
              paramcdb = (ah.a)paramd.aqc;
              localObject18 = (LinkedList)paramd.Ze;
              localObject17 = (List)paramd.VD;
              localObject16 = (cdb)paramd.VC;
              localObject15 = (cdd)paramd.Uf;
              localObject14 = (r)paramd.L$0;
              ResultKt.throwOnFailure(localObject1);
              bool1 = ((Boolean)localObject1).booleanValue();
              if ((i1 == 0) || (bool1))
              {
                localObject1 = ((ghq)localObject23).url;
                s.s(localObject1, "url");
                localObject3 = ((ghq)localObject23).vTu;
                s.s(localObject3, "prefetchUrl");
                localObject4 = ((ghq)localObject23).appId;
                j = ((ghq)localObject23).mUU;
                k = ((ghq)localObject23).vBa;
                if ((!v.dgE()) || (i != 2)) {
                  break label5725;
                }
              }
              label5725:
              for (bool1 = true;; bool1 = false)
              {
                a((String)localObject1, (String)localObject3, (String)localObject4, (Map)localObject2, j, k, paramList, bool1, t.dgt());
                paramcdb.aiwY = true;
                localObject12 = paramcdb;
                localObject2 = paramd;
                j = n;
                localObject6 = localObject23;
                i = m;
                localObject13 = localObject22;
                localObject11 = localObject21;
                localObject8 = localObject20;
                localObject3 = localObject19;
                localObject24 = paramcdd;
                localObject4 = localObject18;
                localObject1 = localObject17;
                localObject5 = localObject16;
                localObject9 = localObject15;
                localObject10 = localObject14;
                if (i1 != 0) {
                  break;
                }
                localObject1 = WebPrefetcherManifest.vUW;
                paramd.L$0 = localObject14;
                paramd.Uf = localObject15;
                paramd.VC = localObject16;
                paramd.VD = localObject17;
                paramd.Ze = localObject18;
                paramd.aqc = paramcdb;
                paramd.bNS = localObject19;
                paramd.bNT = localObject20;
                paramd.bNU = localObject21;
                paramd.bNV = localObject22;
                paramd.bNW = localObject25;
                paramd.vUE = localObject23;
                paramd.vUF = paramcdd;
                paramd.vUG = paramList;
                paramd.vUH = null;
                paramd.aai = m;
                paramd.asI = n;
                paramd.label = 7;
                localObject2 = ((WebPrefetcherManifest)localObject1).b(paramList, paramd);
                if (localObject2 != locala) {
                  break label7385;
                }
                AppMethodBeat.o(303481);
                return locala;
              }
              j = paramd.asI;
              i = paramd.aai;
              paramList = (com.tencent.mm.plugin.az.a)paramd.vUG;
              paramcdd = (String)paramd.vUF;
              localObject23 = (ghq)paramd.vUE;
              localObject22 = (HashMap)paramd.bNV;
              localObject21 = (HashMap)paramd.bNU;
              localObject20 = (HashMap)paramd.bNT;
              localObject19 = (ah.a)paramd.bNS;
              localObject3 = (ah.a)paramd.aqc;
              localObject4 = (LinkedList)paramd.Ze;
              localObject2 = (List)paramd.VD;
              localObject5 = (cdb)paramd.VC;
              localObject9 = (cdd)paramd.Uf;
              localObject10 = (r)paramd.L$0;
              ResultKt.throwOnFailure(localObject1);
              paramcdb = (cdb)localObject1;
              localObject1 = localObject2;
              localObject2 = paramcdb;
              paramcdb = (cdb)localObject3;
              localObject3 = (Iterable)localObject2;
              localObject2 = (Collection)new ArrayList(p.a((Iterable)localObject3, 10));
              localObject3 = ((Iterable)localObject3).iterator();
              while (((Iterator)localObject3).hasNext()) {
                ((Collection)localObject2).add(new c((String)((Iterator)localObject3).next(), e.vTT, ((ghq)localObject23).mUU));
              }
              localObject2 = (List)localObject2;
              paramList = paramList.WmS.aamn;
              s.s(paramList, "manifest.domain.Domain");
              localObject3 = ((ghq)localObject23).vTu;
              s.s(localObject3, "prefetchUrl");
              d((List)localObject2, paramList, (String)localObject3);
              localObject24 = paramcdd;
              localObject3 = localObject19;
              localObject8 = localObject20;
              localObject11 = localObject21;
              localObject13 = localObject22;
              localObject6 = localObject23;
              localObject2 = paramd;
              localObject12 = paramcdb;
              Log.v("MicroMsg.WebPrefetcher", "end prefetch #" + (String)localObject24 + ' ' + ((ghq)localObject6).vTu);
              paramList = (List<? extends ccy>)localObject11;
              paramcdd = (cdd)localObject8;
              paramd = (kotlin.d.d<? super kotlin.ah>)localObject3;
              localObject3 = localObject12;
              paramcdb = (cdb)localObject1;
              localObject1 = localObject2;
              localObject2 = localObject13;
            }
            try
            {
              label6109:
              k = aiL(((ghq)localObject6).url);
              localObject8 = (Integer)paramList.get(Integer.valueOf(k));
              if (localObject8 == null) {
                ((Map)paramList).put(Integer.valueOf(k), Integer.valueOf(1));
              }
              for (;;)
              {
                localObject6 = ((ghq)localObject6).url;
                s.s(localObject6, "url");
                com.tencent.mm.plugin.webview.h.h.a(0, (String)localObject6, false, false, true, paramd.aiwY, ((ah.a)localObject3).aiwY, true);
                localObject6 = (Integer)paramcdd.get(Integer.valueOf(k));
                if (localObject6 != null) {
                  break label7028;
                }
                ((Map)paramcdd).put(Integer.valueOf(k), Integer.valueOf(1));
                localObject6 = paramcdd;
                paramcdd = paramcdb;
                localObject11 = localObject2;
                localObject8 = paramList;
                localObject12 = paramd;
                paramd = (kotlin.d.d<? super kotlin.ah>)localObject1;
                localObject13 = localObject3;
                localObject2 = localObject4;
                localObject1 = localObject5;
                paramList = (List<? extends ccy>)localObject9;
                paramcdb = (cdb)localObject10;
                break;
                a((ghq)localObject28);
                Log.w("MicroMsg.WebPrefetcher", "fail to prefetch #" + (String)localObject38 + ' ' + ((ghq)localObject28).url);
                j = i1;
                i = n;
                localObject2 = localObject35;
                paramList = localObject34;
                paramcdd = localObject33;
                paramd = (kotlin.d.d<? super kotlin.ah>)localObject32;
                localObject3 = localObject31;
                paramcdb = localObject30;
                localObject1 = localObject29;
                localObject6 = localObject28;
                localObject4 = localObject26;
                localObject5 = localObject24;
                localObject9 = localObject22;
                localObject10 = localObject21;
                break label6109;
                label6369:
                localObject10 = paramcdd.sMq;
                s.s(localObject10, "fullUrl");
                localObject11 = c.getHost((String)localObject10);
                localObject10 = (ccy)((HashMap)localObject9).get(localObject11);
                if (localObject10 == null)
                {
                  localObject10 = null;
                  label6410:
                  Log.d("MicroMsg.WebPrefetcher", "savePrefetch host: " + (String)localObject11 + ", openType: " + localObject10);
                  if (localObject10 != null) {
                    break label6536;
                  }
                  localObject14 = paramcdb;
                  localObject13 = paramList;
                  localObject12 = localObject1;
                  localObject11 = localObject2;
                  localObject10 = paramd;
                }
                for (;;)
                {
                  a(paramcdd);
                  localObject15 = paramcdd;
                  paramList = (List<? extends ccy>)localObject8;
                  paramcdd = (cdd)localObject6;
                  paramcdb = (cdb)localObject5;
                  localObject2 = localObject9;
                  paramd = (kotlin.d.d<? super kotlin.ah>)localObject3;
                  localObject1 = localObject10;
                  localObject6 = localObject15;
                  localObject3 = localObject4;
                  localObject4 = localObject11;
                  localObject5 = localObject12;
                  localObject9 = localObject13;
                  localObject10 = localObject14;
                  break;
                  localObject10 = Integer.valueOf(((ccy)localObject10).aamt);
                  break label6410;
                  label6536:
                  if (((Integer)localObject10).intValue() != 1) {
                    break label7364;
                  }
                  localObject10 = com.tencent.mm.plugin.brandservice.ui.timeline.preload.a.c.vVi;
                  if (!com.tencent.mm.plugin.brandservice.ui.timeline.preload.a.c.dgF()) {
                    break label7364;
                  }
                  paramcdd.acdX = true;
                  paramcdd.acdY = false;
                  localObject10 = WebPrefetcherManifest.vUW;
                  localObject10 = paramcdd.url;
                  s.s(localObject10, "url");
                  paramd.L$0 = paramcdb;
                  paramd.Uf = paramList;
                  paramd.VC = localObject1;
                  paramd.VD = localObject5;
                  paramd.Ze = localObject2;
                  paramd.aqc = localObject4;
                  paramd.bNS = localObject3;
                  paramd.bNT = localObject6;
                  paramd.bNU = localObject8;
                  paramd.bNV = localObject9;
                  paramd.bNW = paramcdd;
                  paramd.vUE = paramcdd;
                  paramd.vUF = null;
                  paramd.vUG = null;
                  paramd.vUH = null;
                  paramd.vUI = null;
                  paramd.vUJ = null;
                  paramd.aai = i;
                  paramd.asI = j;
                  paramd.label = 8;
                  localObject11 = WebPrefetcherManifest.j((String)localObject10, paramd);
                  if (localObject11 != locala) {
                    break label7341;
                  }
                  AppMethodBeat.o(303481);
                  return locala;
                  j = paramd.asI;
                  i = paramd.aai;
                  paramcdd = (ghq)paramd.vUE;
                  localObject9 = (HashMap)paramd.bNV;
                  localObject8 = (HashMap)paramd.bNU;
                  localObject6 = (HashMap)paramd.bNT;
                  localObject3 = (ah.a)paramd.bNS;
                  localObject5 = (ah.a)paramd.aqc;
                  localObject4 = (LinkedList)paramd.Ze;
                  localObject2 = (List)paramd.VD;
                  localObject11 = (cdb)paramd.VC;
                  paramList = (cdd)paramd.Uf;
                  paramcdb = (r)paramd.L$0;
                  ResultKt.throwOnFailure(localObject1);
                  localObject10 = localObject1;
                  localObject1 = localObject11;
                  if (((Boolean)localObject10).booleanValue()) {
                    ((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).m("", paramcdd.url, "urlExposed", null);
                  }
                  localObject11 = localObject5;
                  localObject12 = localObject4;
                  localObject5 = localObject2;
                  localObject10 = paramd;
                  localObject4 = localObject11;
                  localObject11 = localObject12;
                  localObject12 = localObject1;
                  localObject13 = paramList;
                  localObject14 = paramcdb;
                }
                ((Map)paramList).put(Integer.valueOf(k), Integer.valueOf(((Integer)localObject8).intValue() + 1));
              }
            }
            catch (Exception localException)
            {
              Log.e("MicroMsg.WebPrefetcher", "Report Error");
              localObject7 = paramcdd;
              paramcdd = paramcdb;
              localObject11 = localObject2;
              localObject8 = paramList;
              localObject12 = paramd;
              paramd = (kotlin.d.d<? super kotlin.ah>)localObject1;
              localObject13 = localObject3;
              localObject2 = localObject4;
              localObject1 = localObject5;
              paramList = (List<? extends ccy>)localObject9;
              paramcdb = (cdb)localObject10;
            }
          }
          label7028:
          ((Map)paramcdd).put(Integer.valueOf(k), Integer.valueOf(((Integer)localObject7).intValue() + 1));
          localObject7 = paramcdd;
          paramcdd = paramcdb;
          localObject11 = localObject2;
          localObject8 = paramList;
          localObject12 = paramd;
          paramd = (kotlin.d.d<? super kotlin.ah>)localObject1;
          localObject13 = localObject3;
          localObject2 = localObject4;
          localObject1 = localObject5;
          paramList = (List<? extends ccy>)localObject9;
          paramcdb = (cdb)localObject10;
          break label1225;
          i = 0;
        }
        catch (Exception paramd)
        {
          Log.e("MicroMsg.WebPrefetcher", s.X("preDns ex ", paramd.getMessage()));
          continue;
          paramList = (Map)paramList;
          paramcdd = (Collection)new ArrayList(paramList.size());
          paramList = paramList.entrySet().iterator();
          if (paramList.hasNext())
          {
            paramd = (Map.Entry)paramList.next();
            i = ((Number)paramd.getKey()).intValue();
            j = ((Number)paramd.getValue()).intValue();
            com.tencent.mm.plugin.webview.h.h.nm(j, i);
            if (paramcdb.get(Integer.valueOf(i)) != null)
            {
              paramd = paramcdb.get(Integer.valueOf(i));
              s.checkNotNull(paramd);
              s.s(paramd, "sceneCount[scene]!!");
              if (((Number)paramd).intValue() > j)
              {
                paramd = paramcdb.get(Integer.valueOf(i));
                s.checkNotNull(paramd);
                com.tencent.mm.plugin.webview.h.h.nn(((Number)paramd).intValue() - j, i);
              }
            }
            paramcdd.add(kotlin.ah.aiuX);
            continue;
          }
          paramcdd = kotlin.ah.aiuX;
          AppMethodBeat.o(303481);
          return paramcdd;
        }
        label7319:
        localObject5 = paramcdd;
        k = i;
        localObject9 = localObject11;
        localObject3 = localObject12;
        localObject4 = localObject13;
        break;
        label7341:
        localObject10 = localObject5;
        localObject5 = localObject4;
        localObject4 = localObject2;
        localObject2 = localObject10;
        localObject10 = localObject11;
        continue;
        label7364:
        localObject10 = paramd;
        localObject11 = localObject2;
        localObject12 = localObject1;
        localObject13 = paramList;
        localObject14 = paramcdb;
        continue;
        label7385:
        j = n;
        i = m;
        localObject4 = localObject18;
        localObject1 = localObject17;
        localObject5 = localObject16;
        localObject9 = localObject15;
        localObject10 = localObject14;
        continue;
        label7416:
        i = i2;
        paramList = localObject30;
        paramcdd = (cdd)localObject29;
        localObject2 = localObject28;
        paramcdb = (cdb)localObject27;
        paramd = (kotlin.d.d<? super kotlin.ah>)localObject26;
        continue;
        label7440:
        int i2 = k;
        Object localObject29 = localObject13;
        Object localObject27 = localObject11;
        Object localObject26 = paramd;
        int i1 = m;
        Object localObject30 = localObject12;
        Object localObject28 = localObject10;
        Object localObject25 = localObject9;
        int n = j;
        Object localObject23 = localObject8;
        m = i;
        Object localObject22 = localObject7;
        Object localObject21 = localObject5;
        Object localObject20 = localObject4;
        Object localObject19 = localObject3;
        Object localObject18 = localObject2;
        Object localObject17 = localObject1;
        Object localObject16 = paramList;
        localObject15 = paramcdb;
        localObject14 = paramcdd;
        continue;
        label7520:
        m = k;
        k = i3;
        continue;
        label7531:
        m = i3;
        continue;
        localObject13 = localObject20;
        localObject20 = paramd;
        paramd = (kotlin.d.d<? super kotlin.ah>)localObject19;
        Object localObject24 = localObject12;
        localObject12 = localObject27;
        localObject10 = localObject25;
        localObject9 = localObject23;
        j = m;
        localObject8 = localObject18;
        localObject7 = localObject17;
        localObject5 = localObject16;
        localObject4 = localObject15;
        localObject1 = localObject14;
        continue;
        label7593:
        Object localObject36 = localObject11;
        localObject20 = paramcdd;
        localObject11 = paramcdb;
        localObject19 = paramList;
        localObject27 = localObject13;
        localObject25 = localObject14;
        localObject23 = localObject15;
        m = i;
        localObject18 = paramd;
        i = j;
        localObject17 = localObject1;
        localObject16 = localObject2;
        localObject15 = localObject3;
        localObject3 = localObject4;
        localObject2 = localObject5;
        localObject14 = localObject7;
        paramList = (List<? extends ccy>)localObject8;
        paramcdb = (cdb)localObject9;
        paramcdd = (cdd)localObject10;
        continue;
        label7666:
        localObject15 = localObject11;
        k = 0;
        localObject11 = localObject10;
        localObject16 = localObject13;
        localObject10 = paramcdd;
        localObject18 = paramcdd;
        m = i;
        localObject20 = localObject3;
        localObject21 = localObject5;
        paramcdd = (cdd)localObject12;
        localObject19 = localObject4;
        localObject12 = localObject15;
        localObject13 = localObject14;
        localObject14 = localObject16;
        localObject15 = localObject10;
        i = j;
        j = m;
        localObject17 = localObject9;
        localObject16 = localObject8;
        localObject3 = localObject7;
        localObject4 = localObject20;
        localObject5 = localObject2;
        localObject7 = localObject21;
        localObject8 = localObject1;
        localObject9 = paramList;
        localObject10 = paramcdb;
        continue;
        label7767:
        localObject19 = localObject11;
        k = 1;
        localObject11 = localObject10;
        localObject16 = localObject13;
        localObject15 = paramcdd;
        localObject10 = paramcdd;
        m = i;
        localObject21 = localObject3;
        localObject22 = localObject5;
        paramcdd = (cdd)localObject12;
        localObject12 = localObject4;
        localObject13 = localObject14;
        localObject14 = localObject16;
        i = j;
        localObject3 = localObject10;
        j = m;
        localObject18 = localObject9;
        localObject17 = localObject8;
        localObject16 = localObject7;
        localObject4 = localObject21;
        localObject5 = localObject2;
        localObject7 = localObject22;
        localObject8 = localObject1;
        localObject9 = paramList;
        localObject10 = paramcdb;
        continue;
        label7864:
        localObject15 = paramcdd;
        localObject17 = paramcdd;
        localObject16 = localObject11;
        k = m;
        localObject11 = localObject10;
        localObject10 = localObject12;
        paramcdd = paramd;
        localObject12 = localObject17;
      }
      label7896:
      paramcdd = (cdd)localObject5;
      localObject11 = localObject9;
      localObject12 = localObject3;
      localObject13 = localObject4;
      break label1225;
      paramList = (List<? extends ccy>)localObject8;
      paramcdb = (cdb)localObject7;
    }
  }
  
  private static void a(ghq paramghq)
  {
    AppMethodBeat.i(303440);
    Object localObject1 = paramghq.url;
    s.s(localObject1, "url");
    localObject1 = c.ajl((String)localObject1);
    Object localObject2 = paramghq.sMq;
    s.s(localObject2, "fullUrl");
    paramghq.hOH = c.aX((String)localObject2, true);
    ((MultiProcessMMKV)vTg.getSlotForWrite()).encode((String)localObject1, paramghq.toByteArray());
    localObject2 = (CharSequence)paramghq.vAY;
    int i;
    if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0))
    {
      i = 1;
      if (i == 0) {
        ((MultiProcessMMKV)vTg.getSlotForWrite()).encode(paramghq.vAY, (String)localObject1);
      }
      localObject2 = new StringBuilder("save preauth webid:").append((String)localObject1).append(" bizId: ").append(paramghq.hOH).append(" prefetchId: ").append(paramghq.vAY).append(", prefetch:").append(paramghq.acdX).append(", authorized:").append(paramghq.rhq).append(", antispam:").append(paramghq.acdW).append(", lastModify:").append(paramghq.pba).append(", appId: ").append(paramghq.appId).append(", pkgFileKey: ").append(paramghq.vBf).append(", jsapiControlBytes: ");
      localObject1 = paramghq.acdZ;
      if (localObject1 != null) {
        break label286;
      }
    }
    label286:
    for (localObject1 = null;; localObject1 = Integer.valueOf(((com.tencent.mm.bx.b)localObject1).Op.length))
    {
      Log.i("MicroMsg.WebPrefetcher", localObject1 + ", url: %s", new Object[] { paramghq.url });
      AppMethodBeat.o(303440);
      return;
      i = 0;
      break;
    }
  }
  
  private static void a(String arg0, final String paramString2, String paramString3, Map<String, String> paramMap, final int paramInt1, final int paramInt2, final com.tencent.mm.plugin.az.a parama, final boolean paramBoolean1, final boolean paramBoolean2)
  {
    AppMethodBeat.i(303341);
    paramMap = new b(c.getHost(???), ???, paramString2, false, paramMap, (byte)0);
    String str = b.class.getCanonicalName() + '_' + "batch";
    Object localObject;
    synchronized (__BATCH_RUN_OBJ.INSTANCE)
    {
      localObject = (cb)__BATCH_RUN_OBJ.INSTANCE.getBatchJobs().get(str);
      if (localObject != null) {
        ((cb)localObject).a(null);
      }
      localObject = __BATCH_RUN_OBJ.INSTANCE.getBatchData();
      if (!((HashMap)localObject).containsKey(str)) {
        ((Map)localObject).put(str, new LinkedList());
      }
      localObject = ((HashMap)localObject).get(str);
      if (localObject == null)
      {
        paramString2 = new NullPointerException("null cannot be cast to non-null type java.util.LinkedList<T of com.tencent.mm.sdk.platformtools.MMBatchRunKt.batchRun$lambda-1$lambda-0>");
        AppMethodBeat.o(303341);
        throw paramString2;
      }
    }
    ((LinkedList)localObject).add(paramMap);
    ((Map)__BATCH_RUN_OBJ.INSTANCE.getBatchJobs()).put(str, kotlinx.coroutines.j.a((aq)bu.ajwo, (f)bg.kCi(), null, (m)new n(50L, str, null, paramString3, parama, paramBoolean1, paramBoolean2, paramInt1, paramString2, paramInt2), 2));
    AppMethodBeat.o(303341);
  }
  
  public static int aiL(String paramString)
  {
    AppMethodBeat.i(175492);
    int i;
    switch (dfP())
    {
    default: 
      i = dfP();
      AppMethodBeat.o(175492);
      return i;
    }
    if (paramString != null)
    {
      ajF(paramString);
      i = ajF(paramString);
      AppMethodBeat.o(175492);
      return i;
    }
    AppMethodBeat.o(175492);
    return 0;
  }
  
  public static void aiM(String paramString)
  {
    AppMethodBeat.i(6803);
    s.u(paramString, "url");
    Object localObject1 = c.ajl(paramString);
    Object localObject2 = com.tencent.mm.plugin.az.c.WmU;
    localObject2 = com.tencent.mm.plugin.az.c.ipm().bii((String)localObject1);
    if (((com.tencent.mm.vfs.u)localObject2).jKS()) {
      ((com.tencent.mm.vfs.u)localObject2).diJ();
    }
    localObject2 = (MultiProcessMMKV)vTi.findSlot((String)localObject1);
    if (localObject2 != null) {
      ((MultiProcessMMKV)localObject2).remove((String)localObject1);
    }
    localObject1 = (MultiProcessMMKV)vTg.findSlot(c.ajl(paramString));
    if (localObject1 != null) {
      ((MultiProcessMMKV)localObject1).removeValueForKey(c.ajl(paramString));
    }
    AppMethodBeat.o(6803);
  }
  
  private static boolean ajC(String paramString)
  {
    AppMethodBeat.i(6806);
    String str = c.ajl(paramString);
    Object localObject1 = (MultiProcessMMKV)vTg.findSlot(str);
    boolean bool1;
    boolean bool2;
    if (localObject1 == null)
    {
      localObject1 = null;
      localObject1 = (ghq)localObject1;
      if (localObject1 != null) {
        break label232;
      }
      bool1 = true;
      bool2 = false;
    }
    for (boolean bool3 = false;; bool3 = true)
    {
      Log.v("MicroMsg.WebPrefetcher", "[TRACE_PREFETCH] needReauth:" + bool1 + ", webId:" + str + ", cached:" + bool3 + ", expired:" + bool2 + ", url:" + paramString);
      AppMethodBeat.o(6806);
      return bool1;
      if (((MultiProcessMMKV)localObject1).containsKey(str))
      {
        localObject1 = ((MultiProcessMMKV)localObject1).decodeBytes(str);
        if (localObject1 != null)
        {
          if (localObject1.length == 0)
          {
            i = 1;
            label157:
            if (i != 0) {
              break label201;
            }
          }
          for (int i = 1;; i = 0)
          {
            for (;;)
            {
              if (i == 0) {
                break label226;
              }
              try
              {
                Object localObject3 = ghq.class.newInstance();
                ((com.tencent.mm.bx.a)localObject3).parseFrom((byte[])localObject1);
                localObject1 = (com.tencent.mm.bx.a)localObject3;
              }
              catch (Exception localException)
              {
                label201:
                Log.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", (Throwable)localException, "decode ProtoBuffer", new Object[0]);
              }
            }
            i = 0;
            break label157;
          }
        }
      }
      label226:
      Object localObject2 = null;
      break;
      label232:
      bool2 = MMSlotKt.isExpire(localObject2.pba, 540);
      bool1 = bool2;
    }
  }
  
  private static boolean ajD(String paramString)
  {
    AppMethodBeat.i(303505);
    Object localObject1 = Uri.parse(UrlExKt.getWithProtocol(paramString));
    if (localObject1 != null)
    {
      localObject1 = ((Uri)localObject1).getHost();
      if (localObject1 != null)
      {
        localObject1 = c.ajn((String)localObject1);
        Object localObject3 = (MultiProcessMMKV)vTh.findSlot((String)localObject1);
        if (localObject3 == null)
        {
          localObject1 = null;
          localObject1 = (ccx)localObject1;
          if ((localObject1 == null) || (((ccx)localObject1).aamo != 1) || (MMSlotKt.isExpire(((ccx)localObject1).aamq, ((ccx)localObject1).aamp))) {
            break label206;
          }
        }
        label136:
        label178:
        label201:
        label206:
        for (boolean bool = true;; bool = false)
        {
          if (bool) {
            Log.v("MicroMsg.WebPrefetcher", s.X("[TRACE_PREFETCH] preauth cancelled, in whiteList:", paramString));
          }
          AppMethodBeat.o(303505);
          return bool;
          if (((MultiProcessMMKV)localObject3).containsKey((String)localObject1))
          {
            localObject1 = ((MultiProcessMMKV)localObject3).decodeBytes((String)localObject1);
            if (localObject1 != null)
            {
              if (localObject1.length == 0)
              {
                i = 1;
                if (i != 0) {
                  break label178;
                }
              }
              for (int i = 1;; i = 0)
              {
                for (;;)
                {
                  if (i == 0) {
                    break label201;
                  }
                  try
                  {
                    localObject3 = ccx.class.newInstance();
                    ((com.tencent.mm.bx.a)localObject3).parseFrom((byte[])localObject1);
                    localObject1 = (com.tencent.mm.bx.a)localObject3;
                  }
                  catch (Exception localException)
                  {
                    Log.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", (Throwable)localException, "decode ProtoBuffer", new Object[0]);
                  }
                }
                i = 0;
                break label136;
              }
            }
          }
          Object localObject2 = null;
          break;
        }
      }
    }
    AppMethodBeat.o(303505);
    return false;
  }
  
  public static final boolean ajE(String paramString)
  {
    AppMethodBeat.i(303510);
    s.u(paramString, "url");
    if ((!UrlExKt.isMpUrl(paramString)) || (UrlExKt.isMpAlbumUrl(paramString)) || (UrlExKt.isMpRecWeb(paramString)) || (UrlExKt.isMpTpUrl(paramString)))
    {
      AppMethodBeat.o(303510);
      return true;
    }
    AppMethodBeat.o(303510);
    return false;
  }
  
  private static int ajF(String paramString)
  {
    AppMethodBeat.i(175488);
    MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)vTs.findSlot(c.ajl(paramString));
    if (localMultiProcessMMKV == null)
    {
      AppMethodBeat.o(175488);
      return 0;
    }
    int i = localMultiProcessMMKV.getInt(c.ajl(paramString), 0);
    AppMethodBeat.o(175488);
    return i;
  }
  
  private static void d(List<c> paramList, final String paramString1, final String paramString2)
  {
    AppMethodBeat.i(303331);
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      final c localc = (c)paramList.next();
      String str = c.fO(paramString1, localc.url);
      com.tencent.mm.plugin.az.c.a locala = com.tencent.mm.plugin.az.c.WmU;
      if (!com.tencent.mm.plugin.az.c.ipn().contains(str)) {
        aj.a(new aa(localc.url, 0), (kotlin.g.a.b)new l(str, paramString1, paramString2, localc));
      }
    }
    AppMethodBeat.o(303331);
  }
  
  public static boolean dI(String paramString, int paramInt)
  {
    AppMethodBeat.i(175489);
    s.u(paramString, "url");
    boolean bool = ((MultiProcessMMKV)vTs.getSlotForWrite()).encode(c.ajl(paramString), paramInt);
    AppMethodBeat.o(175489);
    return bool;
  }
  
  public static MMKVSlotManager dfG()
  {
    return vTg;
  }
  
  public static MMKVSlotManager dfH()
  {
    return vTh;
  }
  
  public static MMKVSlotManager dfI()
  {
    return vTi;
  }
  
  public static MMKVSlotManager dfJ()
  {
    return vTj;
  }
  
  private static int dfK()
  {
    AppMethodBeat.i(303277);
    int i = ((Number)vTm.getValue()).intValue();
    AppMethodBeat.o(303277);
    return i;
  }
  
  private static int dfL()
  {
    AppMethodBeat.i(303285);
    int i = ((Number)vTn.getValue()).intValue();
    AppMethodBeat.o(303285);
    return i;
  }
  
  private static int dfM()
  {
    AppMethodBeat.i(303294);
    int i = ((Number)vTo.getValue()).intValue();
    AppMethodBeat.o(303294);
    return i;
  }
  
  public static MMCacheSlotManager dfN()
  {
    return vTq;
  }
  
  public static boolean dfO()
  {
    AppMethodBeat.i(303422);
    boolean bool = ((Boolean)vTr.getValue()).booleanValue();
    AppMethodBeat.o(303422);
    return bool;
  }
  
  private static int dfP()
  {
    AppMethodBeat.i(175490);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("WebPrefetcher.currentScene");
    if (localMultiProcessMMKV == null)
    {
      AppMethodBeat.o(175490);
      return 0;
    }
    int i = localMultiProcessMMKV.decodeInt("currentScene");
    AppMethodBeat.o(175490);
    return i;
  }
  
  public static final void ew(List<? extends h.a> paramList)
  {
    AppMethodBeat.i(160497);
    s.u(paramList, "auths");
    if (paramList.isEmpty())
    {
      AppMethodBeat.o(160497);
      return;
    }
    paramList = (Iterable)paramList;
    Collection localCollection = (Collection)new ArrayList(p.a(paramList, 10));
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      h.a locala = (h.a)localIterator.next();
      String str2 = locala.url;
      s.s(str2, "info.url");
      Object localObject1 = locala.appId;
      paramList = (List<? extends h.a>)localObject1;
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
      localCollection.add(new a(str2, paramList, (String)localObject1, (String)localObject2, locala.vAZ, locala.vBa, null, locala.extInfo, locala.vAY, 64));
    }
    ex((List)localCollection);
    AppMethodBeat.o(160497);
  }
  
  private static void ex(List<a> paramList)
  {
    AppMethodBeat.i(303408);
    Log.v("MicroMsg.WebPrefetcher", "[TRACE_PREFETCH] preAuths size = %s", new Object[] { Integer.valueOf(paramList.size()) });
    cdb localcdb = new cdb();
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
      if ((dfO()) || ((!vTq.contains(c.ajj(((a)localObject3).url))) && (ajE(((a)localObject3).url)) && (!ajD(((a)localObject3).url)) && (ajC(((a)localObject3).url)) && (!vTl.contains(((a)localObject3).url)))) {}
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
    paramList = (Collection)new ArrayList(p.a((Iterable)localObject1, 10));
    localObject1 = ((Iterable)localObject1).iterator();
    int i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (a)((Iterator)localObject1).next();
      localObject3 = new h();
      ((h)localObject3).aamy = ((a)localObject2).url;
      ((h)localObject3).oOI = ((a)localObject2).appId;
      ((h)localObject3).aamz = ((a)localObject2).title;
      ((h)localObject3).aamA = ((a)localObject2).desc;
      ((h)localObject3).ZjF = i;
      ((h)localObject3).aamB = ((a)localObject2).vTt;
      ((h)localObject3).IJG = ((a)localObject2).scene;
      ((h)localObject3).vBa = ((a)localObject2).vBa;
      vTq.add(c.ajj(((a)localObject2).url));
      ((h)localObject3).extInfo = ((a)localObject2).extInfo;
      ((h)localObject3).mUU = ((a)localObject2).scene;
      ((h)localObject3).vAY = ((a)localObject2).vAY;
      paramList.add(localObject3);
      i += 1;
    }
    paramList = (List)paramList;
    localcdb.aamG.addAll((Collection)paramList);
    localcdb.YMX = localcdb.aamG.size();
    localcdb.IJG = 0;
    localcdb.YKo = 0;
    if (localcdb.aamG.isEmpty())
    {
      Log.v("MicroMsg.WebPrefetcher", "[TRACE_PREFETCH] preAuths: nothing to preauth");
      AppMethodBeat.o(303408);
      return;
    }
    if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED)) {}
    for (i = 1;; i = 0)
    {
      if (((dfK() > 0) && (((cda)localcdb.aamG.getFirst()).IJG == dfM())) || (i != 0)) {
        com.tencent.mm.ae.d.B((kotlin.g.a.a)new u(localcdb));
      }
      if ((dfK() <= 0) || (dfL() != com.tencent.mm.plugin.webview.h.e.WQL.ordinal()) || (dfM() != ((cda)localcdb.aamG.getFirst()).IJG)) {
        break;
      }
      Log.i("MicroMsg.WebPrefetcher", "ClosePrefetchAndA8key");
      AppMethodBeat.o(303408);
      return;
    }
    try
    {
      paramList = vTl;
      localObject1 = localcdb.aamG;
      s.s(localObject1, "req.ReqInfo");
      localObject2 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        ((Collection)localObject1).add(((cda)((Iterator)localObject2).next()).aamy);
        continue;
        paramList = com.tencent.mm.plugin.webview.core.i.Wya;
      }
    }
    catch (Exception paramList)
    {
      Log.e("MicroMsg.WebPrefetcher", s.X("Concurrent Add Exception: ", paramList.getMessage()));
    }
    for (;;)
    {
      if (i.a.gTR()) {
        CronetLogic.setUserCertVerify(true);
      }
      paramList = localcdb.aamG;
      s.s(paramList, "req.ReqInfo");
      Log.v("MicroMsg.WebPrefetcher", s.X("[TRACE_PREFETCH] sendGetA8KeyLiteRequest batch req: ", p.a((Iterable)paramList, (CharSequence)",", null, null, 0, null, (kotlin.g.a.b)v.vUN, 30)));
      com.tencent.mm.ae.d.d("MicroMsg.WebPrefetcher", (kotlin.g.a.a)new w(localcdb));
      AppMethodBeat.o(303408);
      return;
      paramList.addAll((Collection)localObject1);
    }
  }
  
  private static void ey(List<String> paramList)
  {
    AppMethodBeat.i(6808);
    paramList = (Iterable)paramList;
    Object localObject2 = (Collection)new ArrayList(p.a(paramList, 10));
    Object localObject3 = paramList.iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject1 = Uri.parse((String)((Iterator)localObject3).next()).getHost();
      paramList = (List<String>)localObject1;
      if (localObject1 == null) {
        paramList = "";
      }
      ((Collection)localObject2).add(paramList);
    }
    Object localObject1 = (Iterable)localObject2;
    paramList = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    label153:
    label195:
    label198:
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      localObject3 = (String)localObject2;
      s.s(localObject3, "it");
      if (!n.bp((CharSequence)localObject3))
      {
        i = 1;
        if (i == 0) {
          break label195;
        }
        com.tencent.mm.plugin.brandservice.c.a locala = com.tencent.mm.plugin.brandservice.c.vAt;
        if (com.tencent.mm.plugin.brandservice.c.dbL().contains((String)localObject3)) {
          break label195;
        }
      }
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label198;
        }
        paramList.add(localObject2);
        break;
        i = 0;
        break label153;
      }
    }
    paramList = p.t((Iterable)paramList);
    localObject1 = (Collection)paramList;
    if ((localObject1 == null) || (((Collection)localObject1).isEmpty())) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(6808);
      return;
    }
    com.tencent.threadpool.h.ahAA.bn(new r..ExternalSyntheticLambda0(paramList));
    AppMethodBeat.o(6808);
  }
  
  private static final void ez(List paramList)
  {
    AppMethodBeat.i(303539);
    s.u(paramList, "$hosts");
    LinkedList localLinkedList = new LinkedList();
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      try
      {
        Log.i("MicroMsg.WebPrefetcher", s.X("pre dns:", InetAddress.getByName(str)));
        Object localObject = com.tencent.mm.plugin.brandservice.c.vAt;
        localObject = com.tencent.mm.plugin.brandservice.c.dbL();
        s.s(str, "host");
        ((MMCacheSlotManager)localObject).add(str);
        localLinkedList.add(str);
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.WebPrefetcher", s.X("InetAddress Error, ", localException.getMessage()));
      }
    }
    com.tencent.mm.plugin.webview.h.h.atW(localLinkedList.size());
    AppMethodBeat.o(303539);
  }
  
  public static boolean fJ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(303495);
    s.u(paramString1, "url");
    if (fS(paramString1, paramString2) != null)
    {
      AppMethodBeat.o(303495);
      return true;
    }
    AppMethodBeat.o(303495);
    return false;
  }
  
  public static h.b fK(String paramString1, String paramString2)
  {
    AppMethodBeat.i(303361);
    s.u(paramString1, "url");
    Object localObject1 = c.ajl(paramString1);
    Object localObject2 = com.tencent.mm.plugin.az.c.WmU;
    localObject1 = new d(paramString1, (String)localObject1, com.tencent.mm.plugin.az.c.ipm(), vTi, null, null, Boolean.TRUE, null, false, null, 1968).dgm();
    if (localObject1 == null)
    {
      localObject2 = (CharSequence)paramString2;
      int i;
      if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0)) {
        i = 1;
      }
      while (i == 0)
      {
        localObject1 = vTg.decodeString(paramString2, "");
        paramString2 = (String)localObject1;
        if (localObject1 == null) {
          paramString2 = "";
        }
        localObject1 = com.tencent.mm.plugin.az.c.WmU;
        paramString2 = new d(paramString1, paramString2, com.tencent.mm.plugin.az.c.ipm(), vTi, null, null, Boolean.TRUE, null, false, null, 1968).dgm();
        if (paramString2 == null)
        {
          AppMethodBeat.o(303361);
          return null;
          i = 0;
        }
        else
        {
          paramString2.vBg = true;
          paramString2.url = paramString1;
          AppMethodBeat.o(303361);
          return paramString2;
        }
      }
    }
    AppMethodBeat.o(303361);
    return localObject1;
  }
  
  private static boolean fR(String paramString1, String paramString2)
  {
    AppMethodBeat.i(303353);
    com.tencent.mm.plugin.az.c.a locala = com.tencent.mm.plugin.az.c.WmU;
    paramString2 = new d(paramString1, paramString2, com.tencent.mm.plugin.az.c.ipm(), vTi, null, null, null, null, false, null, 2032);
    if ((paramString2.isCached()) && (!paramString2.dgl())) {}
    boolean bool;
    for (int i = 1;; i = 0)
    {
      bool = paramString2.isRedirect();
      if ((i == 0) || (bool)) {
        break;
      }
      AppMethodBeat.o(303353);
      return true;
    }
    if (bool)
    {
      if (((CharSequence)paramString2.dgd()).length() > 0) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label124;
        }
        paramString1 = paramString2.dgd();
        paramString2 = c.ajl(paramString2.dgd());
        break;
      }
    }
    label124:
    AppMethodBeat.o(303353);
    return false;
  }
  
  private static ghq fS(String paramString1, String paramString2)
  {
    int j = 1;
    AppMethodBeat.i(303487);
    String str = c.ajl(paramString1);
    Object localObject1;
    int i;
    if (!vTg.containsKey(str))
    {
      localObject1 = (CharSequence)paramString2;
      if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0))
      {
        i = 1;
        if (i != 0) {
          break label673;
        }
        localObject3 = vTg.decodeString(paramString2, "");
        localObject1 = localObject3;
        if (localObject3 == null) {
          localObject1 = "";
        }
      }
    }
    label543:
    label673:
    for (Object localObject3 = localObject1;; localObject3 = str)
    {
      if (BuildInfo.DEBUG) {
        Log.v("MicroMsg.WebPrefetcher", "getValidPreloadWebInfo id: " + str + ", prefetchId: " + paramString2 + ", realId: " + (String)localObject3 + ", url: %s", new Object[] { paramString1 });
      }
      localObject1 = (MultiProcessMMKV)vTg.findSlot((String)localObject3);
      if (localObject1 == null) {}
      Object localObject4;
      boolean bool;
      label377:
      Object localObject2;
      label421:
      label446:
      for (localObject1 = null;; localObject2 = null)
      {
        localObject4 = (ghq)localObject1;
        if (localObject4 == null) {
          break label615;
        }
        bool = MMSlotKt.isExpire(((ghq)localObject4).pba, 600);
        Log.d("MicroMsg.WebPrefetcher", "[TRACE_PREFETCH] getValidPreloadWebInfo: webId#" + str + ", realId: " + (String)localObject3 + ", bizId: " + ((ghq)localObject4).hOH + "  prefetch:" + ((ghq)localObject4).acdX + ", authorized:" + ((ghq)localObject4).rhq + ", antispam:" + ((ghq)localObject4).acdW + ", lastModify:" + ((ghq)localObject4).pba + ", expire:" + bool + ", url:" + paramString1);
        if ((!((ghq)localObject4).acdW) && (!bool)) {
          break label452;
        }
        AppMethodBeat.o(303487);
        return null;
        i = 0;
        break;
        if (((MultiProcessMMKV)localObject1).containsKey((String)localObject3))
        {
          localObject1 = ((MultiProcessMMKV)localObject1).decodeBytes((String)localObject3);
          if (localObject1 != null)
          {
            if (localObject1.length == 0)
            {
              i = 1;
              if (i != 0) {
                break label421;
              }
            }
            for (i = 1;; i = 0)
            {
              for (;;)
              {
                if (i == 0) {
                  break label446;
                }
                try
                {
                  localObject4 = ghq.class.newInstance();
                  ((com.tencent.mm.bx.a)localObject4).parseFrom((byte[])localObject1);
                  localObject1 = (com.tencent.mm.bx.a)localObject4;
                }
                catch (Exception localException)
                {
                  Log.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", (Throwable)localException, "decode ProtoBuffer", new Object[0]);
                }
              }
              i = 0;
              break label377;
            }
          }
        }
      }
      label452:
      if (!((ghq)localObject4).rhq)
      {
        AppMethodBeat.o(303487);
        return localObject4;
      }
      if ((((ghq)localObject4).acdX) && (((ghq)localObject4).rhq))
      {
        s.u(paramString1, "url");
        if (fR(paramString1, c.ajl(paramString1))) {
          bool = true;
        }
        while (bool)
        {
          AppMethodBeat.o(303487);
          return localObject4;
          localObject2 = (CharSequence)paramString2;
          if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0))
          {
            i = 1;
            if (i != 0) {
              break label609;
            }
            localObject2 = vTg.decodeString(paramString2, "");
            paramString2 = (String)localObject2;
            if (localObject2 == null) {
              paramString2 = "";
            }
            if (((CharSequence)paramString2).length() <= 0) {
              break label604;
            }
          }
          label604:
          for (i = j;; i = 0)
          {
            if (i == 0) {
              break label609;
            }
            bool = fR(paramString1, paramString2);
            break;
            i = 0;
            break label543;
          }
          label609:
          bool = false;
        }
      }
      label615:
      Log.v("MicroMsg.WebPrefetcher", "[TRACE_PREFETCH] getValidPreloadWebInfo: webId#" + str + ", realId: " + (String)localObject3 + ", not cached, url:" + paramString1 + ' ');
      AppMethodBeat.o(303487);
      return null;
    }
  }
  
  public static boolean fT(String paramString1, String paramString2)
  {
    AppMethodBeat.i(303532);
    Object localObject = c.ajl(paramString1);
    com.tencent.mm.plugin.az.c.a locala = com.tencent.mm.plugin.az.c.WmU;
    localObject = new d(paramString1, (String)localObject, com.tencent.mm.plugin.az.c.ipm(), vTi, null, null, null, null, false, null, 2032).dgd();
    if (!n.bp((CharSequence)localObject)) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramString1 = c.aX((String)localObject, true);
      Log.v("MicroMsg.WebPrefetcher", "isWebUrlStorageEqual: location:#" + paramString1 + ", " + (String)localObject);
      paramString2 = c.aX(paramString2, true);
      Log.v("MicroMsg.WebPrefetcher", s.X("isWebUrlStorageEqual: target:#", paramString2));
      localObject = kotlin.ah.aiuX;
      boolean bool = s.p(paramString1, paramString2);
      AppMethodBeat.o(303532);
      return bool;
    }
    AppMethodBeat.o(303532);
    return false;
  }
  
  public static String fU(String paramString1, String paramString2)
  {
    AppMethodBeat.i(303535);
    s.u(paramString1, "host");
    s.u(paramString2, "documentUrl");
    if (n.U(paramString2, "https", false))
    {
      paramString1 = s.X("https://", paramString1);
      AppMethodBeat.o(303535);
      return paramString1;
    }
    paramString1 = s.X("http://", paramString1);
    AppMethodBeat.o(303535);
    return paramString1;
  }
  
  public static h.b n(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(303368);
    s.u(paramString1, "referer");
    s.u(paramString2, "url");
    String str = c.fO(c.getHost(paramString1), paramString2);
    com.tencent.mm.plugin.az.c.a locala = com.tencent.mm.plugin.az.c.WmU;
    paramString1 = new d(paramString2, str, com.tencent.mm.plugin.az.c.ipn(), vTj, c.getHost(paramString1), paramString3, null, null, false, paramString4, 1472).dgm();
    AppMethodBeat.o(303368);
    return paramString1;
  }
  
  private static com.tencent.mm.plugin.az.a s(String paramString, List<? extends ccy> paramList)
  {
    AppMethodBeat.i(303426);
    paramString = Uri.parse(paramString);
    Object localObject1 = com.tencent.mm.plugin.az.c.WmU;
    localObject1 = com.tencent.mm.plugin.az.c.a.bik(paramString.getHost());
    if (localObject1 != null)
    {
      Log.i("MicroMsg.WebPrefetcher", "matchManifest debug");
      AppMethodBeat.o(303426);
      return localObject1;
    }
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      localObject1 = (ccy)paramList.next();
      if (s.p(paramString.getHost(), ((ccy)localObject1).aamn))
      {
        Object localObject2 = ((ccy)localObject1).aams;
        s.s(localObject2, "domain.ResInfos");
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          ccz localccz = (ccz)((Iterator)localObject2).next();
          if (paramString != null)
          {
            String str1 = paramString.getPath();
            if (str1 != null)
            {
              String str2 = localccz.IcT;
              s.s(str2, "resInfo.Path");
              if (com.tencent.luggage.l.c.L(str1, str2) != true) {}
            }
          }
          for (int i = 1; i != 0; i = 0)
          {
            s.s(localccz, "resInfo");
            paramString = new com.tencent.mm.plugin.az.a((ccy)localObject1, localccz, false, 60);
            AppMethodBeat.o(303426);
            return paramString;
          }
        }
      }
    }
    AppMethodBeat.o(303426);
    return null;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$BatchPreauth;", "", "url", "", "appId", "title", "desc", "scene", "", "subBizScene", "refer", "extInfo", "prefetchId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getDesc", "getExtInfo", "getPrefetchId", "getRefer", "getScene", "()I", "setScene", "(I)V", "getSubBizScene", "setSubBizScene", "getTitle", "getUrl", "checkScene", "", "urlToScene", "(Ljava/lang/String;)Ljava/lang/Integer;", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class a
  {
    final String appId;
    final String desc;
    final String extInfo;
    int scene;
    final String title;
    final String url;
    final String vAY;
    int vBa;
    final String vTt;
    
    private a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, String paramString5, String paramString6, String paramString7)
    {
      AppMethodBeat.i(302923);
      this.url = paramString1;
      this.appId = paramString2;
      this.title = paramString3;
      this.desc = paramString4;
      this.scene = paramInt1;
      this.vBa = paramInt2;
      this.vTt = paramString5;
      this.extInfo = paramString6;
      this.vAY = paramString7;
      paramString1 = this.url;
      if (UrlExKt.isMpAlbumUrl(paramString1))
      {
        paramString1 = Integer.valueOf(211);
        if (paramString1 != null)
        {
          paramInt1 = ((Number)paramString1).intValue();
          paramInt2 = this.scene;
          if (paramString1 != null) {
            break label222;
          }
        }
      }
      for (;;)
      {
        this.vBa = this.scene;
        this.scene = paramInt1;
        label222:
        do
        {
          Log.v("MicroMsg.WebPrefetcher", "checkScene scene: " + this.scene + ", subBizScene: " + this.vBa);
          AppMethodBeat.o(302923);
          return;
          if (UrlExKt.isMpRecWeb(paramString1))
          {
            paramString1 = Integer.valueOf(213);
            break;
          }
          if (UrlExKt.isMpTpUrl(paramString1))
          {
            paramString1 = Integer.valueOf(212);
            break;
          }
          paramString1 = null;
          break;
        } while (paramInt2 == paramString1.intValue());
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchAction;", "", "host", "", "rawUrl", "prefetchUrl", "checkCacheOnly", "", "prefetchHeader", "", "bizScene", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/util/Map;I)V", "getBizScene", "()I", "getCheckCacheOnly", "()Z", "getHost", "()Ljava/lang/String;", "getPrefetchHeader", "()Ljava/util/Map;", "getPrefetchUrl", "getRawUrl", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class b
  {
    final String host;
    final String idu;
    private final int mUU;
    final String vTu;
    final boolean vTv;
    final Map<String, String> vTw;
    
    private b(String paramString1, String paramString2, String paramString3, boolean paramBoolean, Map<String, String> paramMap)
    {
      AppMethodBeat.i(302914);
      this.host = paramString1;
      this.idu = paramString2;
      this.vTu = paramString3;
      this.vTv = paramBoolean;
      this.vTw = paramMap;
      this.mUU = 0;
      AppMethodBeat.o(302914);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(302934);
      if (this == paramObject)
      {
        AppMethodBeat.o(302934);
        return true;
      }
      if (!(paramObject instanceof b))
      {
        AppMethodBeat.o(302934);
        return false;
      }
      paramObject = (b)paramObject;
      if (!s.p(this.host, paramObject.host))
      {
        AppMethodBeat.o(302934);
        return false;
      }
      if (!s.p(this.idu, paramObject.idu))
      {
        AppMethodBeat.o(302934);
        return false;
      }
      if (!s.p(this.vTu, paramObject.vTu))
      {
        AppMethodBeat.o(302934);
        return false;
      }
      if (this.vTv != paramObject.vTv)
      {
        AppMethodBeat.o(302934);
        return false;
      }
      if (!s.p(this.vTw, paramObject.vTw))
      {
        AppMethodBeat.o(302934);
        return false;
      }
      if (this.mUU != paramObject.mUU)
      {
        AppMethodBeat.o(302934);
        return false;
      }
      AppMethodBeat.o(302934);
      return true;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(302927);
      String str = "PrefetchAction(host=" + this.host + ", rawUrl=" + this.idu + ", prefetchUrl=" + this.vTu + ", checkCacheOnly=" + this.vTv + ", prefetchHeader=" + this.vTw + ", bizScene=" + this.mUU + ')';
      AppMethodBeat.o(302927);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchRes;", "", "url", "", "type", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchType;", "bizScene", "", "(Ljava/lang/String;Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchType;I)V", "getBizScene", "()I", "getType", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchType;", "getUrl", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class c
  {
    private final int mUU;
    final String url;
    final r.e vTx;
    
    public c(String paramString, r.e parame, int paramInt)
    {
      AppMethodBeat.i(302866);
      this.url = paramString;
      this.vTx = parame;
      this.mUU = paramInt;
      AppMethodBeat.o(302866);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(302882);
      if (this == paramObject)
      {
        AppMethodBeat.o(302882);
        return true;
      }
      if (!(paramObject instanceof c))
      {
        AppMethodBeat.o(302882);
        return false;
      }
      paramObject = (c)paramObject;
      if (!s.p(this.url, paramObject.url))
      {
        AppMethodBeat.o(302882);
        return false;
      }
      if (this.vTx != paramObject.vTx)
      {
        AppMethodBeat.o(302882);
        return false;
      }
      if (this.mUU != paramObject.mUU)
      {
        AppMethodBeat.o(302882);
        return false;
      }
      AppMethodBeat.o(302882);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(302876);
      int i = this.url.hashCode();
      int j = this.vTx.hashCode();
      int k = this.mUU;
      AppMethodBeat.o(302876);
      return (i * 31 + j) * 31 + k;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(302872);
      String str = "PrefetchRes(url=" + this.url + ", type=" + this.vTx + ", bizScene=" + this.mUU + ')';
      AppMethodBeat.o(302872);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchTarget;", "", "url", "", "webId", "content", "Lcom/tencent/mm/plugin/webprefetcher/WebPrefetcherFile;", "headerSlot", "Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "referHost", "mainAppId", "isForMainFrame", "", "manifest", "Lcom/tencent/mm/plugin/webprefetcher/PrefetchManifest;", "needDownloadPkg", "pkgKey", "prefetchId", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/webprefetcher/WebPrefetcherFile;Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/tencent/mm/plugin/webprefetcher/PrefetchManifest;ZLjava/lang/String;Ljava/lang/String;)V", "appId", "getAppId", "()Ljava/lang/String;", "appId$delegate", "Lkotlin/Lazy;", "basePkgVersion", "getBasePkgVersion", "bizId", "getBizId", "bizId$delegate", "bizScene", "", "getBizScene", "()I", "bizScene$delegate", "businessData", "Lcom/tencent/mm/protobuf/ByteString;", "getBusinessData", "()Lcom/tencent/mm/protobuf/ByteString;", "businessData$delegate", "cacheTime", "", "getCacheTime", "()J", "getContent", "()Lcom/tencent/mm/plugin/webprefetcher/WebPrefetcherFile;", "eTag", "getETag", "fetchPkgUrl", "getFetchPkgUrl", "fullUrl", "getFullUrl", "fullUrl$delegate", "getHeaderSlot", "()Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "headers", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getHeaders", "()Ljava/util/HashMap;", "headers$delegate", "isCached", "()Z", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "isRedirect", "jsApiControlBytes", "getJsApiControlBytes", "jsApiControlBytes$delegate", "lazyWebPrefetchInfo", "Lcom/tencent/mm/protocal/protobuf/WebPrefetchInfo;", "getLazyWebPrefetchInfo", "()Lcom/tencent/mm/protocal/protobuf/WebPrefetchInfo;", "lazyWebPrefetchInfo$delegate", "location", "getLocation", "getMainAppId", "getManifest", "()Lcom/tencent/mm/plugin/webprefetcher/PrefetchManifest;", "maxCache", "getMaxCache", "mimeType", "getMimeType", "getNeedDownloadPkg", "pkgFileKey", "getPkgFileKey", "pkgFileKey$delegate", "getPkgKey", "pkgMd5", "getPkgMd5", "pkgVersion", "getPkgVersion", "prefetchHost", "getPrefetchHost", "getPrefetchId", "prefetchUrl", "getPrefetchUrl", "prefetcherId", "getPrefetcherId", "prefetcherId$delegate", "getReferHost", "response", "Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService$PrefetchResponse;", "getResponse", "()Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService$PrefetchResponse;", "shouldFetchContent", "getShouldFetchContent", "shouldFetchContent$delegate", "subBizScene", "getSubBizScene", "subBizScene$delegate", "type", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchType;", "getType", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchType;", "getUrl", "version", "getVersion", "getWebId", "wxETag", "getWxETag", "createResponse", "isExpire", "refresh", "", "saveHeaders", "host", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
  {
    final String url;
    final String vAY;
    final com.tencent.mm.plugin.az.a vQP;
    final MMKVSlotManager vTA;
    private final String vTB;
    final String vTC;
    private final Boolean vTD;
    final boolean vTE;
    final String vTF;
    private final kotlin.j vTG;
    private final kotlin.j vTH;
    private final kotlin.j vTI;
    private final kotlin.j vTJ;
    private final kotlin.j vTK;
    private final kotlin.j vTL;
    private final kotlin.j vTM;
    private final kotlin.j vTN;
    private final kotlin.j vTO;
    private final kotlin.j vTP;
    private final kotlin.j vTQ;
    private final kotlin.j vTR;
    public final String vTy;
    public final com.tencent.mm.plugin.az.b vTz;
    
    private d(String paramString1, String paramString2, com.tencent.mm.plugin.az.b paramb, MMKVSlotManager paramMMKVSlotManager, String paramString3, String paramString4, Boolean paramBoolean, com.tencent.mm.plugin.az.a parama, boolean paramBoolean1, String paramString5)
    {
      AppMethodBeat.i(302900);
      this.url = paramString1;
      this.vTy = paramString2;
      this.vTz = paramb;
      this.vTA = paramMMKVSlotManager;
      this.vTB = paramString3;
      this.vTC = paramString4;
      this.vTD = paramBoolean;
      this.vQP = parama;
      this.vTE = paramBoolean1;
      this.vTF = paramString5;
      this.vAY = null;
      this.vTG = kotlin.k.cm((kotlin.g.a.a)new i(this));
      this.vTH = kotlin.k.cm((kotlin.g.a.a)new c(this));
      this.vTI = kotlin.k.cm((kotlin.g.a.a)new b(this));
      this.vTJ = kotlin.k.cm((kotlin.g.a.a)new f(this));
      this.vTK = kotlin.k.cm((kotlin.g.a.a)new d(this));
      this.vTL = kotlin.k.cm((kotlin.g.a.a)new m(this));
      this.vTM = kotlin.k.cm((kotlin.g.a.a)new l(this));
      this.vTN = kotlin.k.cm((kotlin.g.a.a)new h(this));
      this.vTO = kotlin.k.cm((kotlin.g.a.a)new j(this));
      this.vTP = kotlin.k.cm((kotlin.g.a.a)new e(this));
      this.vTQ = kotlin.k.cm((kotlin.g.a.a)new k(this));
      this.vTR = kotlin.k.cm((kotlin.g.a.a)new g(this));
      AppMethodBeat.o(302900);
    }
    
    private void bDL()
    {
      AppMethodBeat.i(302967);
      Object localObject;
      String str2;
      if ((((Boolean)this.vTM.getValue()).booleanValue()) && (dgc() == r.e.vTV) && (dgf() > 0L) && (dge() > 0) && (MMSlotKt.isExpire(dgf(), Math.max(dge() - 60, 60))))
      {
        localObject = r.vTf;
        com.tencent.mm.plugin.webview.h.h.atY(r.aiL(this.url));
        localObject = r.vTf;
        str2 = this.url;
        localObject = (List)dgb().get("x-wx-client-prefetch-url");
        if (localObject != null) {
          break label133;
        }
        localObject = "";
      }
      for (;;)
      {
        r.T(str2, (String)localObject, getAppId());
        AppMethodBeat.o(302967);
        return;
        label133:
        String str1 = (String)p.oK((List)localObject);
        localObject = str1;
        if (str1 == null) {
          localObject = "";
        }
      }
    }
    
    private final String dga()
    {
      AppMethodBeat.i(302931);
      String str = (String)this.vTQ.getValue();
      AppMethodBeat.o(302931);
      return str;
    }
    
    private r.e dgc()
    {
      AppMethodBeat.i(302937);
      Object localObject = (List)dgb().get("x-wx-client-prefetch-type");
      if (localObject == null) {
        localObject = null;
      }
      while (localObject == null)
      {
        localObject = r.e.vTV;
        AppMethodBeat.o(302937);
        return localObject;
        localObject = (String)p.oK((List)localObject);
        if (localObject == null)
        {
          localObject = null;
        }
        else
        {
          localObject = ((String)localObject).toUpperCase();
          s.s(localObject, "(this as java.lang.String).toUpperCase()");
          localObject = r.e.valueOf((String)localObject);
        }
      }
      AppMethodBeat.o(302937);
      return localObject;
    }
    
    private final h.b dgn()
    {
      AppMethodBeat.i(302985);
      if (this.vTz == null)
      {
        AppMethodBeat.o(302985);
        return null;
      }
      int i = dgb().size();
      boolean bool = this.vTz.contains(dfT());
      if ((i == 0) || (!bool))
      {
        Log.e("MicroMsg.WebPrefetcher", "createResponse fail headerSize:" + i + ", containsFile:" + bool);
        AppMethodBeat.o(302985);
        return null;
      }
      h.b localb = new h.b();
      localb.url = dfU();
      localb.vBc = dgc().toString();
      localb.vBb = getVersion();
      localb.mUU = dfV();
      localb.vBa = dfW();
      localb.appId = getAppId();
      localb.vBe = dfX();
      localb.vBf = dfY();
      localb.vBh = w.a(dfZ());
      l(dgb());
      h.c localc = new h.c();
      Object localObject1 = getMimeType();
      Object localObject2 = (Map)dgb();
      Map localMap = (Map)new LinkedHashMap(ak.aKi(((Map)localObject2).size()));
      localObject2 = ((Iterable)((Map)localObject2).entrySet()).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject4 = ((Iterator)localObject2).next();
        Object localObject3 = ((Map.Entry)localObject4).getKey();
        localObject4 = (Map.Entry)localObject4;
        ((Map.Entry)localObject4).getKey();
        localMap.put(localObject3, (String)p.oK((List)((Map.Entry)localObject4).getValue()));
      }
      localObject2 = kotlin.ah.aiuX;
      localc.vBi = new WebResourceResponse((String)localObject1, "UTF-8", 200, "OK", localMap, y.ao(this.vTz.bii(dfT())));
      localObject1 = kotlin.ah.aiuX;
      localb.vBd = localc;
      AppMethodBeat.o(302985);
      return localb;
    }
    
    private String getAppId()
    {
      AppMethodBeat.i(302922);
      String str = (String)this.vTI.getValue();
      AppMethodBeat.o(302922);
      return str;
    }
    
    private final String getMimeType()
    {
      AppMethodBeat.i(302956);
      Object localObject = (List)dgb().get("content-type");
      if (localObject == null)
      {
        AppMethodBeat.o(302956);
        return "text/html";
      }
      localObject = (String)p.oK((List)localObject);
      if (localObject == null)
      {
        AppMethodBeat.o(302956);
        return "text/html";
      }
      localObject = n.rt((String)localObject, ";");
      if (localObject == null)
      {
        AppMethodBeat.o(302956);
        return "text/html";
      }
      localObject = n.bq((CharSequence)localObject).toString();
      if (localObject == null)
      {
        AppMethodBeat.o(302956);
        return "text/html";
      }
      AppMethodBeat.o(302956);
      return localObject;
    }
    
    private long getVersion()
    {
      AppMethodBeat.i(302946);
      Object localObject = (List)dgb().get("x-wx-version");
      if (localObject == null)
      {
        AppMethodBeat.o(302946);
        return -1L;
      }
      localObject = (String)p.oK((List)localObject);
      if (localObject == null)
      {
        AppMethodBeat.o(302946);
        return -1L;
      }
      long l = Long.parseLong((String)localObject);
      AppMethodBeat.o(302946);
      return l;
    }
    
    private static final void l(HashMap<String, List<String>> paramHashMap)
    {
      AppMethodBeat.i(302995);
      Object localObject1 = paramHashMap.keySet();
      s.s(localObject1, "headers.keys");
      Object localObject2 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = ((Iterator)localObject2).next();
        String str = (String)localObject3;
        Set localSet = u.dgy();
        s.s(str, "it");
        str = str.toLowerCase();
        s.s(str, "(this as java.lang.String).toLowerCase()");
        if (localSet.contains(str)) {
          ((Collection)localObject1).add(localObject3);
        }
      }
      localObject1 = (List)localObject1;
      Log.i("MicroMsg.WebPrefetcher", s.X("removeInvalidHeaders size: ", Integer.valueOf(((List)localObject1).size())));
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        paramHashMap.remove((String)((Iterator)localObject1).next());
      }
      AppMethodBeat.o(302995);
    }
    
    public final void a(r.e parame, String paramString)
    {
      AppMethodBeat.i(303150);
      s.u(parame, "type");
      s.u(paramString, "host");
      ((Map)dgb()).put("x-wx-client-cache-time", p.listOf(String.valueOf(MMSlotKt.now())));
      ((Map)dgb()).put("x-wx-client-prefetch-url", p.listOf(this.url));
      if (!n.bp((CharSequence)paramString)) {}
      ghp localghp;
      LinkedList localLinkedList;
      Collection localCollection;
      Object localObject;
      gho localgho;
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          ((Map)dgb()).put("x-wx-client-prefetch-host", p.listOf(paramString));
        }
        ((Map)dgb()).put("x-wx-client-prefetch-type", p.listOf(parame.toString()));
        localghp = new ghp();
        localLinkedList = localghp.aaKS;
        paramString = (Map)dgb();
        localCollection = (Collection)new ArrayList(paramString.size());
        Iterator localIterator = paramString.entrySet().iterator();
        if (!localIterator.hasNext()) {
          break label403;
        }
        localObject = (Map.Entry)localIterator.next();
        paramString = (String)((Map.Entry)localObject).getKey();
        localObject = (List)((Map.Entry)localObject).getValue();
        localgho = new gho();
        if (paramString != null) {
          break;
        }
        parame = new NullPointerException("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(303150);
        throw parame;
      }
      String str = paramString.toLowerCase();
      s.s(str, "(this as java.lang.String).toLowerCase()");
      switch (str.hashCode())
      {
      }
      for (;;)
      {
        localgho.key = paramString;
        localgho.aaib.addAll((Collection)localObject);
        localCollection.add(localgho);
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
      ((MultiProcessMMKV)this.vTA.getSlotForWrite()).encode(dfT(), localghp.toByteArray());
      Log.v("MicroMsg.WebPrefetcher", "saveHeaders " + parame + " : webId:" + this.vTy + ", bizId:" + dfT() + ", header size:" + dgb().size());
      AppMethodBeat.o(303150);
    }
    
    public final String dfT()
    {
      AppMethodBeat.i(303009);
      String str = (String)this.vTH.getValue();
      AppMethodBeat.o(303009);
      return str;
    }
    
    public final String dfU()
    {
      AppMethodBeat.i(303014);
      String str = (String)this.vTJ.getValue();
      AppMethodBeat.o(303014);
      return str;
    }
    
    public final int dfV()
    {
      AppMethodBeat.i(303017);
      int i = ((Number)this.vTK.getValue()).intValue();
      AppMethodBeat.o(303017);
      return i;
    }
    
    public final int dfW()
    {
      AppMethodBeat.i(303018);
      int i = ((Number)this.vTL.getValue()).intValue();
      AppMethodBeat.o(303018);
      return i;
    }
    
    public final com.tencent.mm.bx.b dfX()
    {
      AppMethodBeat.i(303020);
      com.tencent.mm.bx.b localb = (com.tencent.mm.bx.b)this.vTN.getValue();
      AppMethodBeat.o(303020);
      return localb;
    }
    
    public final String dfY()
    {
      AppMethodBeat.i(303022);
      String str = (String)this.vTO.getValue();
      AppMethodBeat.o(303022);
      return str;
    }
    
    public final com.tencent.mm.bx.b dfZ()
    {
      AppMethodBeat.i(303026);
      com.tencent.mm.bx.b localb = (com.tencent.mm.bx.b)this.vTP.getValue();
      AppMethodBeat.o(303026);
      return localb;
    }
    
    public final HashMap<String, List<String>> dgb()
    {
      AppMethodBeat.i(303031);
      HashMap localHashMap = (HashMap)this.vTR.getValue();
      AppMethodBeat.o(303031);
      return localHashMap;
    }
    
    public final String dgd()
    {
      AppMethodBeat.i(303032);
      Object localObject = (List)dgb().get("location");
      if (localObject == null)
      {
        AppMethodBeat.o(303032);
        return "";
      }
      localObject = (String)p.oK((List)localObject);
      if (localObject == null)
      {
        AppMethodBeat.o(303032);
        return "";
      }
      AppMethodBeat.o(303032);
      return localObject;
    }
    
    public final int dge()
    {
      AppMethodBeat.i(303037);
      Object localObject = (List)dgb().get("x-wx-max-cache");
      if (localObject == null) {
        localObject = null;
      }
      while (localObject == null)
      {
        localObject = (List)dgb().get("max-age");
        if (localObject == null)
        {
          AppMethodBeat.o(303037);
          return 600;
          localObject = (String)p.oK((List)localObject);
          if (localObject == null) {
            localObject = null;
          } else {
            localObject = Integer.valueOf(Integer.parseInt((String)localObject));
          }
        }
        else
        {
          localObject = (String)p.oK((List)localObject);
          if (localObject == null)
          {
            AppMethodBeat.o(303037);
            return 600;
          }
          i = Integer.parseInt((String)localObject);
          AppMethodBeat.o(303037);
          return i;
        }
      }
      int i = ((Integer)localObject).intValue();
      AppMethodBeat.o(303037);
      return i;
    }
    
    public final long dgf()
    {
      AppMethodBeat.i(303043);
      Object localObject = (List)dgb().get("x-wx-client-cache-time");
      if (localObject == null)
      {
        AppMethodBeat.o(303043);
        return -1L;
      }
      localObject = (String)p.oK((List)localObject);
      if (localObject == null)
      {
        AppMethodBeat.o(303043);
        return -1L;
      }
      long l = Long.parseLong((String)localObject);
      AppMethodBeat.o(303043);
      return l;
    }
    
    public final String dgg()
    {
      AppMethodBeat.i(303047);
      Object localObject = (List)dgb().get("x-wx-etag");
      if (localObject == null)
      {
        AppMethodBeat.o(303047);
        return "";
      }
      localObject = (String)p.oK((List)localObject);
      if (localObject == null)
      {
        AppMethodBeat.o(303047);
        return "";
      }
      AppMethodBeat.o(303047);
      return localObject;
    }
    
    public final String dgh()
    {
      AppMethodBeat.i(303052);
      Object localObject = (List)dgb().get("etag");
      if (localObject == null)
      {
        AppMethodBeat.o(303052);
        return "";
      }
      localObject = (String)p.oK((List)localObject);
      if (localObject == null)
      {
        AppMethodBeat.o(303052);
        return "";
      }
      AppMethodBeat.o(303052);
      return localObject;
    }
    
    public final String dgi()
    {
      AppMethodBeat.i(303079);
      if (t.dgt())
      {
        localObject = n.a((CharSequence)t.dgu(), new String[] { "," });
        if (localObject == null)
        {
          localObject = "";
          if (((CharSequence)localObject).length() <= 0) {
            break label105;
          }
        }
        label105:
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label110;
          }
          Log.v("MicroMsg.WebPrefetcher", "debugPatchUrl: %s", new Object[] { localObject });
          AppMethodBeat.o(303079);
          return localObject;
          localObject = (String)p.oL((List)localObject);
          if (localObject == null)
          {
            localObject = "";
            break;
          }
          break;
        }
      }
      label110:
      Object localObject = (List)dgb().get("x-wx-prefetch-pkg-url");
      if (localObject == null)
      {
        AppMethodBeat.o(303079);
        return "";
      }
      localObject = (String)p.oK((List)localObject);
      if (localObject == null)
      {
        AppMethodBeat.o(303079);
        return "";
      }
      AppMethodBeat.o(303079);
      return localObject;
    }
    
    public final String dgj()
    {
      AppMethodBeat.i(303089);
      Object localObject = (List)dgb().get("x-wx-prefetch-pkg-base-ver");
      if (localObject == null)
      {
        AppMethodBeat.o(303089);
        return "";
      }
      localObject = (String)p.oL((List)localObject);
      if (localObject == null)
      {
        AppMethodBeat.o(303089);
        return "";
      }
      AppMethodBeat.o(303089);
      return localObject;
    }
    
    public final String dgk()
    {
      AppMethodBeat.i(303100);
      if (t.dgt())
      {
        localObject = n.a((CharSequence)t.dgu(), new String[] { "," });
        if (localObject == null)
        {
          localObject = "";
          if (((CharSequence)localObject).length() <= 0) {
            break label105;
          }
        }
        label105:
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label110;
          }
          Log.v("MicroMsg.WebPrefetcher", "debugPatchPkgVersion: %s", new Object[] { localObject });
          AppMethodBeat.o(303100);
          return localObject;
          localObject = (String)p.oN((List)localObject);
          if (localObject == null)
          {
            localObject = "";
            break;
          }
          break;
        }
      }
      label110:
      Object localObject = (List)dgb().get("x-wx-prefetch-pkg-ver");
      if (localObject == null)
      {
        AppMethodBeat.o(303100);
        return "";
      }
      localObject = (String)p.oK((List)localObject);
      if (localObject == null)
      {
        AppMethodBeat.o(303100);
        return "";
      }
      AppMethodBeat.o(303100);
      return localObject;
    }
    
    public final boolean dgl()
    {
      AppMethodBeat.i(303110);
      if ((dgf() > 0L) && (dge() > 0) && (MMSlotKt.isExpire(dgf(), dge())))
      {
        AppMethodBeat.o(303110);
        return true;
      }
      AppMethodBeat.o(303110);
      return false;
    }
    
    public final h.b dgm()
    {
      AppMethodBeat.i(303133);
      Object localObject3;
      for (Object localObject1 = this;; localObject1 = new d((String)localObject2, (String)localObject1, (com.tencent.mm.plugin.az.b)localObject3, r.dfI(), null, null, null, null, false, null, 2032))
      {
        localObject2 = ((d)localObject1).dfY();
        localObject3 = com.tencent.mm.plugin.az.c.WmU;
        localObject3 = com.tencent.mm.plugin.az.c.a.a((String)localObject2, ((d)localObject1).url, ((d)localObject1).vTD);
        if (localObject3 != null)
        {
          Log.i("MicroMsg.WebPrefetcher", "matchResource get response #" + ((d)localObject1).vTy + ", appId: " + ((d)localObject1).getAppId() + ", pkgFileKey: " + (String)localObject2 + ", isForMainFrame: " + ((d)localObject1).vTD + ", " + ((d)localObject1).vTB + ", url: %s", new Object[] { ((d)localObject1).url });
          localObject2 = new h.b();
          ((h.b)localObject2).url = ((d)localObject1).dfU();
          ((h.b)localObject2).vBc = ((d)localObject1).dgc().toString();
          ((h.b)localObject2).vBb = ((d)localObject1).getVersion();
          ((h.b)localObject2).mUU = ((d)localObject1).dfV();
          ((h.b)localObject2).vBa = ((d)localObject1).dfW();
          ((h.b)localObject2).vBd = ((h.c)localObject3);
          ((h.b)localObject2).appId = ((d)localObject1).getAppId();
          ((h.b)localObject2).vBe = ((d)localObject1).dfX();
          ((h.b)localObject2).vBf = ((d)localObject1).dfY();
          ((h.b)localObject2).vBh = w.a(((d)localObject1).dfZ());
          AppMethodBeat.o(303133);
          return localObject2;
        }
        if (!((d)localObject1).isCached()) {
          break label602;
        }
        Log.i("MicroMsg.WebPrefetcher", "fetch cached: #" + ((d)localObject1).vTy + ", isForMainFrame: " + ((d)localObject1).vTD + ", " + ((d)localObject1).url);
        localObject2 = ((d)localObject1).dgc();
        if (a.$EnumSwitchMapping$0[localObject2.ordinal()] != 1) {
          break label589;
        }
        if (!((d)localObject1).isRedirect()) {
          break;
        }
        Log.i("MicroMsg.WebPrefetcher", s.X("HTML redirect, location:", ((d)localObject1).dgd()));
        localObject2 = ((d)localObject1).dgd();
        localObject1 = c.ajl(((d)localObject1).dgd());
        localObject3 = com.tencent.mm.plugin.az.c.WmU;
        localObject3 = com.tencent.mm.plugin.az.c.ipm();
        r localr = r.vTf;
      }
      Object localObject2 = r.vTf;
      if (r.fJ(((d)localObject1).url, ((d)localObject1).dga()))
      {
        if (!((d)localObject1).dgl())
        {
          localObject2 = (List)((d)localObject1).dgb().get("set-cookie");
          if (localObject2 != null)
          {
            localObject2 = ((Iterable)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = (String)((Iterator)localObject2).next();
              ao.setCookie(((d)localObject1).url, (String)localObject3);
            }
          }
          localObject1 = ((d)localObject1).dgn();
          AppMethodBeat.o(303133);
          return localObject1;
        }
        Log.w("MicroMsg.WebPrefetcher", "getResponse doc expired refresh cached: #" + ((d)localObject1).vTy + ", " + ((d)localObject1).url);
        ((d)localObject1).bDL();
        AppMethodBeat.o(303133);
        return null;
      }
      Log.w("MicroMsg.WebPrefetcher", "getResponse preauth expired preauth: #" + ((d)localObject1).vTy + ", " + ((d)localObject1).url);
      r.a(((d)localObject1).url, null, null, null, null, 0, 0L, ((d)localObject1).dga(), 126);
      AppMethodBeat.o(303133);
      return null;
      label589:
      localObject1 = ((d)localObject1).dgn();
      AppMethodBeat.o(303133);
      return localObject1;
      label602:
      AppMethodBeat.o(303133);
      return null;
    }
    
    public final boolean isCached()
    {
      AppMethodBeat.i(303069);
      Object localObject = (List)dgb().get("status");
      if (localObject == null)
      {
        localObject = null;
        if (localObject == null) {
          break label183;
        }
        switch (((String)localObject).hashCode())
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(303069);
        return false;
        localObject = (String)p.oL((List)localObject);
        break;
        if (((String)localObject).equals("200"))
        {
          localObject = this.vTz;
          if (localObject != null) {
            break label158;
          }
          AppMethodBeat.o(303069);
          return false;
          if (((String)localObject).equals("301")) {
            do
            {
              if (n.bp((CharSequence)dgd())) {
                break;
              }
              AppMethodBeat.o(303069);
              return true;
            } while (((String)localObject).equals("302"));
          }
        }
      }
      label158:
      boolean bool = ((com.tencent.mm.plugin.az.b)localObject).contains(dfT());
      AppMethodBeat.o(303069);
      return bool;
      AppMethodBeat.o(303069);
      return false;
      label183:
      localObject = this.vTz;
      if (localObject == null)
      {
        AppMethodBeat.o(303069);
        return false;
      }
      bool = ((com.tencent.mm.plugin.az.b)localObject).contains(dfT());
      AppMethodBeat.o(303069);
      return bool;
    }
    
    public final boolean isRedirect()
    {
      AppMethodBeat.i(303058);
      Object localObject = (List)dgb().get("status");
      if (localObject == null)
      {
        localObject = null;
        if (!s.p(localObject, "301")) {
          break label61;
        }
      }
      label61:
      for (boolean bool = true;; bool = s.p(localObject, "302"))
      {
        if (!bool) {
          break label72;
        }
        AppMethodBeat.o(303058);
        return true;
        localObject = (String)p.oK((List)localObject);
        break;
      }
      label72:
      AppMethodBeat.o(303058);
      return false;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends kotlin.g.b.u
      implements kotlin.g.a.a<String>
    {
      b(r.d paramd)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class c
      extends kotlin.g.b.u
      implements kotlin.g.a.a<String>
    {
      c(r.d paramd)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class d
      extends kotlin.g.b.u
      implements kotlin.g.a.a<Integer>
    {
      d(r.d paramd)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/protobuf/ByteString;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class e
      extends kotlin.g.b.u
      implements kotlin.g.a.a<com.tencent.mm.bx.b>
    {
      e(r.d paramd)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class f
      extends kotlin.g.b.u
      implements kotlin.g.a.a<String>
    {
      f(r.d paramd)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class g
      extends kotlin.g.b.u
      implements kotlin.g.a.a<HashMap<String, List<? extends String>>>
    {
      g(r.d paramd)
      {
        super();
      }
      
      private HashMap<String, List<String>> dgo()
      {
        AppMethodBeat.i(302943);
        Object localObject2 = this.vTS.vTA;
        Object localObject1 = this.vTS.dfT();
        localObject2 = (MultiProcessMMKV)((MMKVSlotManager)localObject2).findSlot((String)localObject1);
        Object localObject3;
        label90:
        label222:
        HashMap<String, List<String>> localHashMap;
        if (localObject2 == null)
        {
          localObject1 = null;
          localObject2 = (ghp)localObject1;
          localObject1 = new HashMap();
          if (localObject2 != null)
          {
            localObject2 = ((ghp)localObject2).aaKS;
            s.s(localObject2, "it.header");
            localObject3 = (Iterable)localObject2;
            localObject2 = (Collection)new ArrayList();
            localObject3 = ((Iterable)localObject3).iterator();
          }
        }
        else
        {
          label163:
          label201:
          label230:
          for (;;)
          {
            if (!((Iterator)localObject3).hasNext()) {
              break label232;
            }
            Object localObject4 = ((Iterator)localObject3).next();
            if (((gho)localObject4).key != null) {}
            for (int i = 1;; i = 0)
            {
              if (i == 0) {
                break label230;
              }
              ((Collection)localObject2).add(localObject4);
              break label90;
              if (((MultiProcessMMKV)localObject2).containsKey((String)localObject1))
              {
                localObject1 = ((MultiProcessMMKV)localObject2).decodeBytes((String)localObject1);
                if (localObject1 != null)
                {
                  if (localObject1.length == 0)
                  {
                    i = 1;
                    if (i != 0) {
                      break label201;
                    }
                  }
                  for (i = 1;; i = 0)
                  {
                    for (;;)
                    {
                      if (i == 0) {
                        break label222;
                      }
                      try
                      {
                        localObject2 = ghp.class.newInstance();
                        ((com.tencent.mm.bx.a)localObject2).parseFrom((byte[])localObject1);
                        localObject1 = (com.tencent.mm.bx.a)localObject2;
                      }
                      catch (Exception localException)
                      {
                        Log.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", (Throwable)localException, "decode ProtoBuffer", new Object[0]);
                      }
                    }
                    i = 0;
                    break label163;
                  }
                }
              }
              localHashMap = null;
              break;
            }
          }
          label232:
          localObject2 = ((Iterable)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (gho)((Iterator)localObject2).next();
            localHashMap.put(((gho)localObject3).key, ((gho)localObject3).aaib);
          }
        }
        AppMethodBeat.o(302943);
        return localHashMap;
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/protobuf/ByteString;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class h
      extends kotlin.g.b.u
      implements kotlin.g.a.a<com.tencent.mm.bx.b>
    {
      h(r.d paramd)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/protocal/protobuf/WebPrefetchInfo;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class i
      extends kotlin.g.b.u
      implements kotlin.g.a.a<ghq>
    {
      i(r.d paramd)
      {
        super();
      }
      
      private ghq dgp()
      {
        AppMethodBeat.i(302924);
        Object localObject1 = r.vTf;
        Object localObject3 = r.dfG();
        localObject1 = this.vTS.vTy;
        localObject3 = (MultiProcessMMKV)((MMKVSlotManager)localObject3).findSlot((String)localObject1);
        if (localObject3 == null) {}
        label73:
        label111:
        Object localObject2;
        label132:
        for (localObject1 = null;; localObject2 = null)
        {
          localObject1 = (ghq)localObject1;
          AppMethodBeat.o(302924);
          return localObject1;
          if (((MultiProcessMMKV)localObject3).containsKey((String)localObject1))
          {
            localObject1 = ((MultiProcessMMKV)localObject3).decodeBytes((String)localObject1);
            if (localObject1 != null)
            {
              if (localObject1.length == 0)
              {
                i = 1;
                if (i != 0) {
                  break label111;
                }
              }
              for (int i = 1;; i = 0)
              {
                for (;;)
                {
                  if (i == 0) {
                    break label132;
                  }
                  try
                  {
                    localObject3 = ghq.class.newInstance();
                    ((com.tencent.mm.bx.a)localObject3).parseFrom((byte[])localObject1);
                    localObject1 = (com.tencent.mm.bx.a)localObject3;
                  }
                  catch (Exception localException)
                  {
                    Log.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", (Throwable)localException, "decode ProtoBuffer", new Object[0]);
                  }
                }
                i = 0;
                break label73;
              }
            }
          }
        }
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class j
      extends kotlin.g.b.u
      implements kotlin.g.a.a<String>
    {
      j(r.d paramd)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class k
      extends kotlin.g.b.u
      implements kotlin.g.a.a<String>
    {
      k(r.d paramd)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class l
      extends kotlin.g.b.u
      implements kotlin.g.a.a<Boolean>
    {
      l(r.d paramd)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class m
      extends kotlin.g.b.u
      implements kotlin.g.a.a<Integer>
    {
      m(r.d paramd)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchType;", "", "type", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "toString", "JS", "CSS", "HTML", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum e
  {
    private final String type;
    
    static
    {
      AppMethodBeat.i(302880);
      vTT = new e("JS", 0, "JS");
      vTU = new e("CSS", 1, "CSS");
      vTV = new e("HTML", 2, "HTML");
      vTW = new e[] { vTT, vTU, vTV };
      AppMethodBeat.o(302880);
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
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends kotlin.g.b.u
    implements kotlin.g.a.b<Integer, Boolean>
  {
    public static final f vTX;
    
    static
    {
      AppMethodBeat.i(302864);
      vTX = new f();
      AppMethodBeat.o(302864);
    }
    
    f()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$connect$2$1", "Lcom/tencent/mars/cdn/CronetLogic$CronetTaskCallback;", "receiveHeaderCalled", "", "getReceiveHeaderCalled", "()Z", "setReceiveHeaderCalled", "(Z)V", "onCronetReceiveChunkedData", "", "data", "Lcom/tencent/mars/cdn/CronetLogic$ChunkedData;", "length", "", "onCronetReceiveHeader", "", "header", "Lcom/tencent/mars/cdn/CronetLogic$ResponseHeader;", "status_code", "protocol", "", "onCronetReceiveUploadProgress", "current", "total", "onCronetTaskCompleted", "filekey", "result", "Lcom/tencent/mars/cdn/CronetLogic$CronetTaskResult;", "onDownloadProgressChanged", "progress", "Lcom/tencent/mars/cdn/CronetLogic$CronetDownloadProgress;", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    implements CronetLogic.CronetTaskCallback
  {
    private boolean vTY;
    
    g(long paramLong, aa paramaa, kotlin.g.a.b<? super Boolean, kotlin.ah> paramb, String paramString, kotlin.g.a.b<? super Integer, Boolean> paramb1) {}
    
    public final void onCronetReceiveChunkedData(CronetLogic.ChunkedData paramChunkedData, long paramLong) {}
    
    public final int onCronetReceiveHeader(CronetLogic.ResponseHeader paramResponseHeader, int paramInt, String paramString)
    {
      AppMethodBeat.i(302921);
      s.u(paramString, "protocol");
      Log.d("MicroMsg.WebPrefetcher", "connect onReceiveHeader receiveHeaderCalled: " + this.vTY + ", statusCode: " + paramInt + ", session: " + this.vTZ);
      if (this.vTY)
      {
        AppMethodBeat.o(302921);
        return 0;
      }
      this.vTY = true;
      if (((Boolean)this.vUd.invoke(Integer.valueOf(paramInt))).booleanValue())
      {
        AppMethodBeat.o(302921);
        return 0;
      }
      paramResponseHeader = paramu;
      if (paramResponseHeader != null) {
        paramResponseHeader.invoke(Boolean.FALSE);
      }
      AppMethodBeat.o(302921);
      return -99;
    }
    
    public final void onCronetReceiveUploadProgress(long paramLong1, long paramLong2) {}
    
    public final void onCronetTaskCompleted(String paramString1, CronetLogic.CronetTaskResult paramCronetTaskResult, String paramString2)
    {
      AppMethodBeat.i(302899);
      s.u(paramString2, "protocol");
      kotlin.g.a.b localb;
      if (paramCronetTaskResult == null)
      {
        paramString1 = null;
        Log.d("MicroMsg.WebPrefetcher", "connect onCronetTaskCompleted statusCode: %s, session: %s", new Object[] { paramString1, Long.valueOf(this.vTZ) });
        if (paramCronetTaskResult != null)
        {
          paramString1 = paramb1;
          paramString2 = paramb;
          localb = this.vUd;
          switch (paramCronetTaskResult.statusCode)
          {
          }
        }
      }
      for (;;)
      {
        paramString1 = new com.tencent.mm.vfs.u(paramb1.mSavePath);
        if (paramString1.jKS()) {
          paramString1.diJ();
        }
        paramString1 = paramu;
        if (paramString1 != null) {
          paramString1.invoke(Boolean.valueOf(y.ZC(paramb)));
        }
        AppMethodBeat.o(302899);
        return;
        paramString1 = Integer.valueOf(paramCronetTaskResult.statusCode);
        break;
        if (y.qn(paramString1.mSavePath, paramString2))
        {
          Log.i("MicroMsg.WebPrefetcher", "connect save file:" + paramString1.mURL + " to " + paramString2);
        }
        else
        {
          Log.e("MicroMsg.WebPrefetcher", "connect save conn failed:" + paramString1.mURL + " to " + paramString1.mSavePath);
          continue;
          localb.invoke(Integer.valueOf(paramCronetTaskResult.statusCode));
        }
      }
    }
    
    public final void onDownloadProgressChanged(String paramString, CronetLogic.CronetDownloadProgress paramCronetDownloadProgress) {}
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "conn", "Lcom/tencent/mm/network/MMHttpUrlCronetConnection;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends kotlin.g.b.u
    implements kotlin.g.a.b<aa, kotlin.ah>
  {
    h(Map<String, String> paramMap, r.d paramd, String paramString1, String paramString2, kotlin.d.d<? super Boolean> paramd1)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$fetchContent$1$1", "Lcom/tencent/mm/plugin/brandservice/api/ITransferRequester$TransferRequestResultCallback;", "interceptRequest", "", "requestInfo", "Lcom/tencent/mm/plugin/brandservice/api/TransferRequestInfo;", "onResult", "", "errMsg", "", "response", "Lcom/tencent/mm/protocal/protobuf/JsApiResponse;", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class i
    implements g.a
  {
    i(String paramString1, r.d paramd, String paramString2, Map<String, String> paramMap) {}
    
    public final void a(String paramString, final dew paramdew)
    {
      AppMethodBeat.i(302884);
      Object localObject1 = new StringBuilder("fetchContentByWebTransfer onResult ret: ");
      if (paramdew == null)
      {
        paramString = null;
        localObject1 = ((StringBuilder)localObject1).append(paramString).append(", errMsg: ");
        if (paramdew != null) {
          break label102;
        }
        paramString = null;
        label41:
        localObject1 = ((StringBuilder)localObject1).append(paramString).append(", headers: ");
        if (paramdew != null) {
          break label110;
        }
        paramString = null;
      }
      for (;;)
      {
        Log.i("MicroMsg.WebPrefetcher", paramString);
        if (paramdew != null) {
          break label135;
        }
        Log.e("MicroMsg.WebPrefetcher", "fetchContentByWebTransfer response null");
        AppMethodBeat.o(302884);
        return;
        paramString = Integer.valueOf(paramdew.ret);
        break;
        label102:
        paramString = paramdew.error_msg;
        break label41;
        label110:
        paramString = paramdew.aaKS;
        if (paramString == null) {
          paramString = null;
        } else {
          paramString = Integer.valueOf(paramString.size());
        }
      }
      label135:
      paramString = paramdew.aaKS;
      if (paramString == null)
      {
        paramString = null;
        localObject1 = new ah.d();
        if (paramString != null) {
          break label403;
        }
        if (paramdew.ret != 0) {
          break label397;
        }
        i = 200;
        label170:
        ((ah.d)localObject1).aixb = i;
        paramString = r.vTf;
        if ((r.a(this.mrs, this.vUf, this.vUk, ((ah.d)localObject1).aixb, paramdew.error_msg, (kotlin.g.a.a)new b(this.vUf, (ah.d)localObject1, paramdew))) && (this.vUf.vTE)) {
          if (((CharSequence)this.vUf.dgi()).length() <= 0) {
            break label415;
          }
        }
      }
      label397:
      label403:
      label415:
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          kotlinx.coroutines.j.a((aq)bu.ajwo, null, null, (m)new a(this.vUf, this.vUe, null), 3);
        }
        AppMethodBeat.o(302884);
        return;
        paramString = (Iterable)paramString;
        localObject1 = (Collection)new ArrayList();
        Iterator localIterator = paramString.iterator();
        label380:
        while (localIterator.hasNext())
        {
          Object localObject2 = localIterator.next();
          paramString = (czo)localObject2;
          if (paramString == null) {}
          for (paramString = null;; paramString = paramString.key)
          {
            if (!s.p(paramString, "status")) {
              break label380;
            }
            ((Collection)localObject1).add(localObject2);
            break;
          }
        }
        paramString = (czo)p.oL((List)localObject1);
        break;
        i = -99;
        break label170;
        i = Util.getInt(paramString.value, -1);
        break label170;
      }
    }
    
    public final boolean a(TransferRequestInfo paramTransferRequestInfo)
    {
      return false;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends kotlin.d.b.a.k
      implements m<aq, kotlin.d.d<? super kotlin.ah>, Object>
    {
      int label;
      
      a(r.d paramd, Map<String, String> paramMap, kotlin.d.d<? super a> paramd1)
      {
        super(paramd1);
      }
      
      public final kotlin.d.d<kotlin.ah> create(Object paramObject, kotlin.d.d<?> paramd)
      {
        AppMethodBeat.i(303013);
        paramObject = (kotlin.d.d)new a(this.vUf, this.vUe, paramd);
        AppMethodBeat.o(303013);
        return paramObject;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(303012);
        kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(303012);
          throw paramObject;
        case 0: 
          ResultKt.throwOnFailure(paramObject);
          paramObject = r.vTf;
          paramObject = this.vUf.dgi();
          Object localObject1 = this.vUf.vTy;
          Object localObject2 = r.vTf;
          paramObject = new r.d(paramObject, (String)localObject1, null, r.dfI(), null, this.vUf.vTC, null, this.vUf.vQP, false, null, 1872);
          localObject1 = this.vUe;
          localObject2 = (kotlin.d.d)this;
          this.label = 1;
          localObject1 = r.a(paramObject, (Map)localObject1, (kotlin.d.d)localObject2);
          paramObject = localObject1;
          if (localObject1 == locala)
          {
            AppMethodBeat.o(303012);
            return locala;
          }
          break;
        case 1: 
          ResultKt.throwOnFailure(paramObject);
        }
        if (((Boolean)paramObject).booleanValue()) {
          ((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).m(this.vUf.dfY(), this.vUf.dfU(), "itemExpose", null);
        }
        paramObject = kotlin.ah.aiuX;
        AppMethodBeat.o(303012);
        return paramObject;
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends kotlin.g.b.u
      implements kotlin.g.a.a<Boolean>
    {
      b(r.d paramd, ah.d paramd1, dew paramdew)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "conn", "Lcom/tencent/mm/network/MMHttpUrlCronetConnection;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends kotlin.g.b.u
    implements kotlin.g.a.b<aa, kotlin.ah>
  {
    j(r.d paramd, Map<String, String> paramMap, String paramString1, String paramString2)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/network/MMHttpUrlCronetConnection;", "conn"}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends kotlin.g.b.u
    implements kotlin.g.a.b<aa, aa>
  {
    k(String paramString, com.tencent.mm.plugin.az.a parama, kotlin.d.d<? super Boolean> paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "conn", "Lcom/tencent/mm/network/MMHttpUrlCronetConnection;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class l
    extends kotlin.g.b.u
    implements kotlin.g.a.b<aa, kotlin.ah>
  {
    l(String paramString1, String paramString2, String paramString3, r.c paramc)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;", "com/tencent/mm/sdk/platformtools/MMBatchRunKt$batchRun$2"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class m
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super kotlin.ah>, Object>
  {
    int label;
    
    public m(long paramLong, String paramString, kotlin.d.d paramd, r paramr)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<kotlin.ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(6785);
      paramd = new m(this.$delay, this.$key, paramd, this.vUr);
      paramd.L$0 = paramObject;
      paramObject = (kotlin.d.d)paramd;
      AppMethodBeat.o(6785);
      return paramObject;
    }
    
    /* Error */
    public final Object invokeSuspend(Object paramObject)
    {
      // Byte code:
      //   0: sipush 6784
      //   3: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   6: getstatic 88	kotlin/d/a/a:aiwj	Lkotlin/d/a/a;
      //   9: astore 4
      //   11: aload_0
      //   12: getfield 90	com/tencent/mm/plugin/brandservice/ui/timeline/preload/r$m:label	I
      //   15: tableswitch	default:+21 -> 36, 0:+39->54, 1:+92->107
      //   37: nop
      //   38: dup2
      //   39: dup
      //   40: ldc 94
      //   42: invokespecial 97	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
      //   45: astore_1
      //   46: sipush 6784
      //   49: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   52: aload_1
      //   53: athrow
      //   54: aload_1
      //   55: invokestatic 103	kotlin/ResultKt:throwOnFailure	(Ljava/lang/Object;)V
      //   58: aload_0
      //   59: getfield 59	com/tencent/mm/plugin/brandservice/ui/timeline/preload/r$m:L$0	Ljava/lang/Object;
      //   62: checkcast 70	kotlinx/coroutines/aq
      //   65: astore_1
      //   66: aload_0
      //   67: getfield 39	com/tencent/mm/plugin/brandservice/ui/timeline/preload/r$m:$delay	J
      //   70: lstore_2
      //   71: aload_0
      //   72: checkcast 61	kotlin/d/d
      //   75: astore 5
      //   77: aload_0
      //   78: aload_1
      //   79: putfield 59	com/tencent/mm/plugin/brandservice/ui/timeline/preload/r$m:L$0	Ljava/lang/Object;
      //   82: aload_0
      //   83: iconst_1
      //   84: putfield 90	com/tencent/mm/plugin/brandservice/ui/timeline/preload/r$m:label	I
      //   87: lload_2
      //   88: aload 5
      //   90: invokestatic 109	kotlinx/coroutines/bb:e	(JLkotlin/d/d;)Ljava/lang/Object;
      //   93: aload 4
      //   95: if_acmpne +28 -> 123
      //   98: sipush 6784
      //   101: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   104: aload 4
      //   106: areturn
      //   107: aload_0
      //   108: getfield 59	com/tencent/mm/plugin/brandservice/ui/timeline/preload/r$m:L$0	Ljava/lang/Object;
      //   111: checkcast 70	kotlinx/coroutines/aq
      //   114: astore 4
      //   116: aload_1
      //   117: invokestatic 103	kotlin/ResultKt:throwOnFailure	(Ljava/lang/Object;)V
      //   120: aload 4
      //   122: astore_1
      //   123: aload_1
      //   124: invokestatic 115	kotlinx/coroutines/ar:a	(Lkotlinx/coroutines/aq;)Z
      //   127: ifne +15 -> 142
      //   130: getstatic 78	kotlin/ah:aiuX	Lkotlin/ah;
      //   133: astore_1
      //   134: sipush 6784
      //   137: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   140: aload_1
      //   141: areturn
      //   142: getstatic 121	com/tencent/mm/sdk/platformtools/__BATCH_RUN_OBJ:INSTANCE	Lcom/tencent/mm/sdk/platformtools/__BATCH_RUN_OBJ;
      //   145: astore 4
      //   147: aload_0
      //   148: getfield 41	com/tencent/mm/plugin/brandservice/ui/timeline/preload/r$m:$key	Ljava/lang/String;
      //   151: astore 5
      //   153: aload 4
      //   155: monitorenter
      //   156: getstatic 121	com/tencent/mm/sdk/platformtools/__BATCH_RUN_OBJ:INSTANCE	Lcom/tencent/mm/sdk/platformtools/__BATCH_RUN_OBJ;
      //   159: invokevirtual 125	com/tencent/mm/sdk/platformtools/__BATCH_RUN_OBJ:getBatchData	()Ljava/util/HashMap;
      //   162: aload 5
      //   164: invokevirtual 130	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
      //   167: astore_1
      //   168: aload_1
      //   169: instanceof 132
      //   172: ifeq +54 -> 226
      //   175: aload_1
      //   176: checkcast 132	java/util/Queue
      //   179: astore_1
      //   180: aload_1
      //   181: ifnonnull +50 -> 231
      //   184: aconst_null
      //   185: astore_1
      //   186: aload 4
      //   188: monitorexit
      //   189: aload_1
      //   190: ifnull +10 -> 200
      //   193: aload_1
      //   194: checkcast 134	java/util/List
      //   197: invokestatic 138	com/tencent/mm/plugin/brandservice/ui/timeline/preload/r:eA	(Ljava/util/List;)V
      //   200: getstatic 121	com/tencent/mm/sdk/platformtools/__BATCH_RUN_OBJ:INSTANCE	Lcom/tencent/mm/sdk/platformtools/__BATCH_RUN_OBJ;
      //   203: invokevirtual 141	com/tencent/mm/sdk/platformtools/__BATCH_RUN_OBJ:getBatchJobs	()Ljava/util/HashMap;
      //   206: aload_0
      //   207: getfield 41	com/tencent/mm/plugin/brandservice/ui/timeline/preload/r$m:$key	Ljava/lang/String;
      //   210: invokevirtual 144	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
      //   213: pop
      //   214: getstatic 78	kotlin/ah:aiuX	Lkotlin/ah;
      //   217: astore_1
      //   218: sipush 6784
      //   221: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   224: aload_1
      //   225: areturn
      //   226: aconst_null
      //   227: astore_1
      //   228: goto -48 -> 180
      //   231: getstatic 121	com/tencent/mm/sdk/platformtools/__BATCH_RUN_OBJ:INSTANCE	Lcom/tencent/mm/sdk/platformtools/__BATCH_RUN_OBJ;
      //   234: invokevirtual 125	com/tencent/mm/sdk/platformtools/__BATCH_RUN_OBJ:getBatchData	()Ljava/util/HashMap;
      //   237: aload 5
      //   239: invokevirtual 144	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
      //   242: pop
      //   243: new 146	java/util/ArrayList
      //   246: dup
      //   247: aload_1
      //   248: checkcast 148	java/util/Collection
      //   251: invokespecial 151	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
      //   254: astore_1
      //   255: goto -69 -> 186
      //   258: astore_1
      //   259: aload 4
      //   261: monitorexit
      //   262: sipush 6784
      //   265: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   268: aload_1
      //   269: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	270	0	this	m
      //   0	270	1	paramObject	Object
      //   70	18	2	l	long
      //   9	251	4	localObject1	Object
      //   75	163	5	localObject2	Object
      // Exception table:
      //   from	to	target	type
      //   156	180	258	finally
      //   231	255	258	finally
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;", "com/tencent/mm/sdk/platformtools/MMBatchRunKt$batchRun$2"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class n
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super kotlin.ah>, Object>
  {
    int label;
    
    public n(long paramLong, String paramString1, kotlin.d.d paramd, String paramString2, com.tencent.mm.plugin.az.a parama, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, String paramString3, int paramInt2)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<kotlin.ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(302873);
      paramd = new n(this.$delay, this.$key, paramd, parama, paramBoolean1, paramBoolean2, paramInt1, paramString2, paramInt2, this.vUy);
      paramd.L$0 = paramObject;
      paramObject = (kotlin.d.d)paramd;
      AppMethodBeat.o(302873);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(302868);
      Object localObject1 = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(302868);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = (aq)this.L$0;
        long l = this.$delay;
        localObject2 = (kotlin.d.d)this;
        this.L$0 = paramObject;
        this.label = 1;
        if (bb.e(l, (kotlin.d.d)localObject2) == localObject1)
        {
          AppMethodBeat.o(302868);
          return localObject1;
        }
        break;
      case 1: 
        localObject1 = (aq)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        paramObject = localObject1;
      }
      if (!ar.a(paramObject))
      {
        paramObject = kotlin.ah.aiuX;
        AppMethodBeat.o(302868);
        return paramObject;
      }
      localObject1 = __BATCH_RUN_OBJ.INSTANCE;
      Object localObject2 = this.$key;
      for (;;)
      {
        try
        {
          paramObject = __BATCH_RUN_OBJ.INSTANCE.getBatchData().get(localObject2);
          if ((paramObject instanceof Queue))
          {
            paramObject = (Queue)paramObject;
            if (paramObject == null)
            {
              paramObject = null;
              if (paramObject == null) {
                break;
              }
              localObject1 = ((Iterable)paramObject).iterator();
              if (!((Iterator)localObject1).hasNext()) {
                break;
              }
              localObject2 = (r.b)((Iterator)localObject1).next();
              localObject3 = ((r.b)localObject2).idu;
              String str1 = c.ajl(((r.b)localObject2).idu);
              paramObject = com.tencent.mm.plugin.az.c.WmU;
              com.tencent.mm.plugin.az.b localb = com.tencent.mm.plugin.az.c.ipm();
              paramObject = r.vTf;
              MMKVSlotManager localMMKVSlotManager = r.dfI();
              String str2 = parama;
              com.tencent.mm.plugin.az.a locala = paramBoolean1;
              boolean bool = paramBoolean2;
              paramObject = paramBoolean1;
              if (paramObject != null) {
                break label514;
              }
              paramObject = null;
              paramObject = new r.d((String)localObject3, str1, localb, localMMKVSlotManager, null, str2, null, locala, bool, paramObject, 1104);
              if (!paramObject.isCached()) {
                break label596;
              }
              if (((r.b)localObject2).vTv) {
                continue;
              }
              int i = Math.max(paramObject.dge() - 60, 60);
              if (((paramObject.dgf() <= 0L) || (!MMSlotKt.isExpire(paramObject.dgf(), i))) && (!paramInt1)) {
                break label522;
              }
              com.tencent.mm.plugin.report.service.h.OAn.b(21074, new Object[] { ((r.b)localObject2).host, Integer.valueOf(paramString2), Integer.valueOf(2), paramInt2, paramInt2, Integer.valueOf(2), Integer.valueOf(this.vUy) });
              localObject3 = r.vTf;
              r.a(((r.b)localObject2).vTu, ((r.b)localObject2).host, paramObject, ((r.b)localObject2).vTw);
              continue;
            }
          }
          else
          {
            paramObject = null;
            continue;
          }
          __BATCH_RUN_OBJ.INSTANCE.getBatchData().remove(localObject2);
          paramObject = new ArrayList((Collection)paramObject);
          continue;
          paramObject = com.tencent.mm.plugin.az.e.a(paramObject);
        }
        finally
        {
          AppMethodBeat.o(302868);
        }
        label514:
        continue;
        label522:
        com.tencent.mm.plugin.report.service.h.OAn.b(21074, new Object[] { ((r.b)localObject2).host, Integer.valueOf(paramString2), Integer.valueOf(2), paramInt2, paramInt2, Integer.valueOf(1), Integer.valueOf(this.vUy) });
        continue;
        label596:
        com.tencent.mm.plugin.report.service.h.OAn.b(21074, new Object[] { ((r.b)localObject2).host, Integer.valueOf(paramString2), Integer.valueOf(2), paramInt2, paramInt2, Integer.valueOf(3), Integer.valueOf(this.vUy) });
        Object localObject3 = r.vTf;
        r.a(((r.b)localObject2).vTu, ((r.b)localObject2).host, paramObject, ((r.b)localObject2).vTw);
      }
      __BATCH_RUN_OBJ.INSTANCE.getBatchJobs().remove(this.$key);
      paramObject = kotlin.ah.aiuX;
      AppMethodBeat.o(302868);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class o
    extends kotlin.g.b.u
    implements kotlin.g.a.a<Integer>
  {
    public static final o vUz;
    
    static
    {
      AppMethodBeat.i(302854);
      vUz = new o();
      AppMethodBeat.o(302854);
    }
    
    o()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class p
    extends kotlin.g.b.u
    implements kotlin.g.a.a<Integer>
  {
    public static final p vUA;
    
    static
    {
      AppMethodBeat.i(302863);
      vUA = new p();
      AppMethodBeat.o(302863);
    }
    
    p()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class q
    extends kotlin.g.b.u
    implements kotlin.g.a.a<Integer>
  {
    public static final q vUB;
    
    static
    {
      AppMethodBeat.i(302858);
      vUB = new q();
      AppMethodBeat.o(302858);
    }
    
    q()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class r
    extends kotlin.g.b.u
    implements kotlin.g.a.a<Boolean>
  {
    public static final r vUC;
    
    static
    {
      AppMethodBeat.i(302860);
      vUC = new r();
      AppMethodBeat.o(302860);
    }
    
    r()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyLitePrefetchResInfo;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class s
    extends kotlin.g.b.u
    implements kotlin.g.a.b<ccz, CharSequence>
  {
    public static final s vUD;
    
    static
    {
      AppMethodBeat.i(302862);
      vUD = new s();
      AppMethodBeat.o(302862);
    }
    
    s()
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class t
    extends kotlin.d.b.a.d
  {
    Object L$0;
    Object Uf;
    Object VC;
    Object VD;
    Object Ze;
    int aai;
    Object aqc;
    int asI;
    Object bNS;
    Object bNT;
    Object bNU;
    Object bNV;
    Object bNW;
    int label;
    int nuz;
    Object vUE;
    Object vUF;
    Object vUG;
    Object vUH;
    Object vUI;
    Object vUJ;
    int vUK;
    
    t(r paramr, kotlin.d.d<? super t> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(302893);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = r.a(this.vUL, null, null, null, (kotlin.d.d)this);
      AppMethodBeat.o(302893);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class u
    extends kotlin.g.b.u
    implements kotlin.g.a.a<kotlin.ah>
  {
    u(cdb paramcdb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyLiteReqInfo;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class v
    extends kotlin.g.b.u
    implements kotlin.g.a.b<cda, CharSequence>
  {
    public static final v vUN;
    
    static
    {
      AppMethodBeat.i(302892);
      vUN = new v();
      AppMethodBeat.o(302892);
    }
    
    v()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class w
    extends kotlin.g.b.u
    implements kotlin.g.a.a<kotlin.ah>
  {
    w(cdb paramcdb)
    {
      super();
    }
    
    private static final void a(final cdb paramcdb, int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.c paramc)
    {
      AppMethodBeat.i(302906);
      s.u(paramcdb, "$req");
      if ((paramInt1 == 0) || (paramInt2 == 0))
      {
        paramString = c.c.b(paramc.otC);
        if ((paramString instanceof cdd))
        {
          paramString = (cdd)paramString;
          if (paramString != null)
          {
            Log.i("MicroMsg.WebPrefetcher", s.X("GetA8KeyLiteResponse: ", Integer.valueOf(paramString.aamH.size())));
            paramc = r.vTf;
            r.a(paramString);
            kotlinx.coroutines.j.a((aq)bu.ajwo, null, null, (m)new a(paramString, paramcdb, null), 3);
          }
        }
      }
      for (;;)
      {
        try
        {
          paramString = r.dfS();
          paramcdb = paramcdb.aamG;
          s.s(paramcdb, "req.ReqInfo");
          paramc = (Iterable)paramcdb;
          paramcdb = (Collection)new ArrayList(p.a(paramc, 10));
          paramc = paramc.iterator();
          if (!paramc.hasNext()) {
            break label248;
          }
          paramcdb.add(((cda)paramc.next()).aamy);
          continue;
          paramString = null;
        }
        catch (Exception paramcdb)
        {
          Log.e("MicroMsg.WebPrefetcher", s.X("Concurrent Remove Exception: ", paramcdb.getMessage()));
          AppMethodBeat.o(302906);
          return;
        }
        break;
        Log.e("MicroMsg.WebPrefetcher", "sendGetA8KeyLiteRequest:" + paramInt1 + ", " + paramInt2 + ", " + paramString);
      }
      label248:
      paramString.removeAll((Collection)paramcdb);
      AppMethodBeat.o(302906);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends kotlin.d.b.a.k
      implements m<aq, kotlin.d.d<? super kotlin.ah>, Object>
    {
      Object L$0;
      Object Uf;
      Object VC;
      int label;
      
      a(cdd paramcdd, cdb paramcdb, kotlin.d.d<? super a> paramd)
      {
        super(paramd);
      }
      
      public final kotlin.d.d<kotlin.ah> create(Object paramObject, kotlin.d.d<?> paramd)
      {
        AppMethodBeat.i(302978);
        paramObject = (kotlin.d.d)new a(this.vUO, paramcdb, paramd);
        AppMethodBeat.o(302978);
        return paramObject;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(302974);
        kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
        cdd localcdd;
        cdb localcdb;
        Object localObject1;
        Object localObject2;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(302974);
          throw paramObject;
        case 0: 
          ResultKt.throwOnFailure(paramObject);
          paramObject = r.vTf;
          localcdd = this.vUO;
          localcdb = paramcdb;
          localObject1 = r.vTf;
          localObject1 = this.vUO;
          localObject2 = paramcdb.aamH;
          s.s(localObject2, "req.PrefetchDomainInfos");
          this.L$0 = paramObject;
          this.Uf = localcdd;
          this.VC = localcdb;
          this.label = 1;
          localObject1 = r.a((cdd)localObject1, (LinkedList)localObject2);
          if (localObject1 == locala)
          {
            AppMethodBeat.o(302974);
            return locala;
          }
          break;
        case 1: 
          localcdb = (cdb)this.VC;
          localcdd = (cdd)this.Uf;
          localObject2 = (r)this.L$0;
          ResultKt.throwOnFailure(paramObject);
          localObject1 = paramObject;
          paramObject = localObject2;
        }
        for (;;)
        {
          localObject1 = (List)localObject1;
          localObject2 = (kotlin.d.d)this;
          this.L$0 = null;
          this.Uf = null;
          this.VC = null;
          this.label = 2;
          if (r.a(paramObject, localcdd, localcdb, (List)localObject1, (kotlin.d.d)localObject2) == locala)
          {
            AppMethodBeat.o(302974);
            return locala;
            ResultKt.throwOnFailure(paramObject);
          }
          paramObject = kotlin.ah.aiuX;
          AppMethodBeat.o(302974);
          return paramObject;
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/webview/util/WebPrefetchUserAgentInfo;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class x
    extends kotlin.g.b.u
    implements kotlin.g.a.a<com.tencent.mm.plugin.webview.k.j>
  {
    public static final x vUP;
    
    static
    {
      AppMethodBeat.i(302894);
      vUP = new x();
      AppMethodBeat.o(302894);
    }
    
    x()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.r
 * JD-Core Version:    0.7.0.1
 */