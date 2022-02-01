package com.tencent.mm.plugin.finder.video.reporter;

import android.content.Context;
import android.content.res.Resources;
import android.media.AudioManager;
import android.util.DisplayMetrics;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.fl;
import com.tencent.mm.f.b.a.oc;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.event.c.a;
import com.tencent.mm.plugin.finder.loader.ac;
import com.tencent.mm.plugin.finder.model.av;
import com.tencent.mm.plugin.finder.model.bs;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.asb;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.bll;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;
import kotlin.t;
import kotlin.x;
import org.json.JSONArray;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/video/reporter/FinderVideoPlayReporter;", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "IDKEY", "", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "setContextObj", "currentVideoReportMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/video/reporter/FinderVideoPlayReporter$ReportData;", "getCurrentVideoReportMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "setCurrentVideoReportMap", "(Ljava/util/concurrent/ConcurrentHashMap;)V", "firstFrameTimeConsumingStatistic", "Lcom/tencent/mm/plugin/finder/video/statistics/ConsumingStatistics;", "getFirstFrameTimeConsumingStatistic", "()Lcom/tencent/mm/plugin/finder/video/statistics/ConsumingStatistics;", "setFirstFrameTimeConsumingStatistic", "(Lcom/tencent/mm/plugin/finder/video/statistics/ConsumingStatistics;)V", "lazyReportDataList", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "getLazyReportDataList", "()Ljava/util/concurrent/ConcurrentLinkedDeque;", "setLazyReportDataList", "(Ljava/util/concurrent/ConcurrentLinkedDeque;)V", "baseInfoLog", "", "eventName", "reportData", "checkVideoDataAvailable", "", "event", "Lcom/tencent/mm/plugin/finder/event/PlayEventSubscriber$PlayEvent;", "cloneSceneResult", "Lcom/tencent/mm/plugin/finder/video/reporter/FinderVideoPlayReporter$ReportSceneResult;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "cloneTaskInfo", "Lcom/tencent/mm/plugin/finder/video/reporter/FinderVideoPlayReporter$ReportTaskInfo;", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "onDownloadFinish", "onDownloadProgress", "onDownloadStart", "onDownloadStop", "onFirstFrameUpdate", "onFirstVideoFrameRendered", "onMoovReady", "onPause", "onPlayError", "onPlayProgress", "onPlayerConfig", "onRelease", "onReplay", "onResume", "onSeek", "onStartPlay", "onStopPlay", "onTabChange", "onUserClickPause", "onWaiting", "onWaitingEnd", "report17000", "report19059", "reportIdkey", "struct", "Lcom/tencent/mm/autogen/mmdata/rpt/FinderVideoPlayStruct;", "Companion", "ReportData", "ReportSceneResult", "ReportTaskInfo", "plugin-finder_release"})
public final class d
{
  public static final a ARA;
  private static final LinkedList<asb> ARy;
  private static final LinkedList<asb> ARz;
  public ConcurrentLinkedDeque<b> ARu;
  public ConcurrentHashMap<Long, b> ARv;
  public com.tencent.mm.plugin.finder.video.statistics.a ARw;
  private final int ARx;
  public bid xbu;
  
  static
  {
    AppMethodBeat.i(271428);
    ARA = new a((byte)0);
    ARy = new LinkedList();
    ARz = new LinkedList();
    AppMethodBeat.o(271428);
  }
  
  public d(bid parambid)
  {
    AppMethodBeat.i(271427);
    this.xbu = parambid;
    this.ARu = new ConcurrentLinkedDeque();
    this.ARv = new ConcurrentHashMap();
    this.ARw = new com.tencent.mm.plugin.finder.video.statistics.a("Finder.Stat.FirstFrame");
    this.ARx = 1505;
    AppMethodBeat.o(271427);
  }
  
  public static String a(String paramString, b paramb)
  {
    AppMethodBeat.i(271408);
    paramString = paramString + " feedId:" + com.tencent.mm.ae.d.Fw(paramb.ARB) + " mediaId:" + paramb.ARC + " position:" + paramb.ARI + " bgPreparedStatus:" + paramb.xqz;
    AppMethodBeat.o(271408);
    return paramString;
  }
  
  public static c b(com.tencent.mm.i.d paramd)
  {
    AppMethodBeat.i(271426);
    p.k(paramd, "sceneResult");
    String str = paramd.mediaId;
    Object localObject = str;
    if (str == null) {
      localObject = "";
    }
    localObject = new c((String)localObject);
    ((c)localObject).retCode = paramd.field_retCode;
    ((c)localObject).mHi = paramd.field_fileLength;
    ((c)localObject).recvedBytes = paramd.field_recvedBytes;
    ((c)localObject).endTime = paramd.field_endTime;
    ((c)localObject).startTime = paramd.field_startTime;
    ((c)localObject).enQueueTime = paramd.field_enQueueTime;
    ((c)localObject).moovRequestTimes = paramd.field_moovRequestTimes;
    ((c)localObject).moovCost = paramd.field_moovCost;
    ((c)localObject).moovSize = paramd.field_moovSize;
    ((c)localObject).moovCompleted = paramd.field_moovCompleted;
    ((c)localObject).moovFailReason = paramd.field_moovFailReason;
    ((c)localObject).firstConnectCost = paramd.field_firstConnectCost;
    ((c)localObject).firstRequestCost = paramd.field_firstRequestCost;
    ((c)localObject).firstRequestSize = paramd.field_firstRequestSize;
    ((c)localObject).firstRequestDownloadSize = paramd.field_firstRequestDownloadSize;
    ((c)localObject).firstRequestCompleted = paramd.field_firstRequestCompleted;
    ((c)localObject).averageSpeed = paramd.field_averageSpeed;
    ((c)localObject).averageConnectCost = paramd.field_averageConnectCost;
    ((c)localObject).netConnectTimes = paramd.field_netConnectTimes;
    str = paramd.arL();
    if (str != null) {
      ((c)localObject).aGn(str);
    }
    str = paramd.field_clientIP;
    if (str != null) {
      ((c)localObject).aGo(str);
    }
    ((c)localObject).ASy = paramd.field_isCrossNet;
    ((c)localObject).transportProtocol = paramd.transportProtocol;
    ((c)localObject).transportProtocolError = paramd.transportProtocolError;
    str = paramd.iUu;
    if (str != null) {
      ((c)localObject).aGp(str);
    }
    ((c)localObject).ASA = paramd.lastSvrPort;
    ((c)localObject).netType = paramd.lastNetType;
    ((c)localObject).traceId = paramd.traceId;
    str = paramd.field_videoCdnMsg;
    p.j(str, "sceneResult.field_videoCdnMsg");
    ((c)localObject).aGq(str);
    str = paramd.field_videoFlag;
    p.j(str, "sceneResult.field_videoFlag");
    ((c)localObject).aGr(str);
    if (paramd.svrFallbackCount > 0) {}
    for (int i = 1;; i = 0)
    {
      ((c)localObject).ASB = i;
      str = paramd.profile;
      p.j(str, "sceneResult.profile");
      ((c)localObject).aGs(kotlin.n.n.l(str, ",", ";", false));
      ((c)localObject).waitResponseCostTime = paramd.field_waitResponseCostTime;
      Log.d("13570", "trace id  " + (((c)localObject).traceId & 0xFFFFFFFF) + " videoflag " + ((c)localObject).videoCdnMsg + " " + ((c)localObject).videoFlag + " " + ((c)localObject).ASB);
      AppMethodBeat.o(271426);
      return localObject;
    }
  }
  
  private static d f(com.tencent.mm.i.h paramh)
  {
    AppMethodBeat.i(271425);
    p.k(paramh, "cloneTaskInfo");
    Object localObject2 = paramh.field_mediaId;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    localObject1 = new d((String)localObject1);
    localObject2 = aj.AGc;
    localObject2 = paramh.videoFlag;
    p.j(localObject2, "cloneTaskInfo.videoFlag");
    ((d)localObject1).requestVideoFormat = aj.aFR((String)localObject2);
    localObject2 = paramh.videoFlag;
    p.j(localObject2, "cloneTaskInfo.videoFlag");
    ((d)localObject1).aGt((String)localObject2);
    ((d)localObject1).iVj = paramh.iVj;
    AppMethodBeat.o(271425);
    return localObject1;
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(271420);
    if (paramb != null) {}
    for (Object localObject1 = String.valueOf(a("report19059", paramb));; localObject1 = null)
    {
      Log.i("Finder.FinderVideoPlayReporter", (String)localObject1);
      if (paramb == null) {
        break label3495;
      }
      if (paramb.ARB != 0L) {
        break;
      }
      AppMethodBeat.o(271420);
      return;
    }
    ac localac = paramb.ARF;
    fl localfl;
    label288:
    label371:
    Object localObject2;
    if (localac != null)
    {
      localfl = new fl();
      localfl.akH();
      localfl.ut(localac.aBv());
      localfl.oa(this.xbu.xkX);
      localfl.nw(localac.dJw().videoDuration);
      localfl.nx(paramb.zXw);
      localfl.ny(paramb.ARM);
      localfl.nz(paramb.ARN);
      localfl.nA(localac.dJw().fileSize);
      localObject1 = com.tencent.mm.plugin.finder.storage.logic.d.AnN;
      long l1;
      long l2;
      if (localac != null)
      {
        localObject1 = localac.aBv();
        localObject1 = com.tencent.mm.plugin.finder.storage.logic.d.aEU((String)localObject1);
        if (localObject1 != null)
        {
          localfl.nA(((av)localObject1).field_totalSize);
          localObject1 = x.aazN;
        }
        localfl.nB(paramb.ARK);
        localfl.nC(paramb.ARL);
        localfl.nD(paramb.ARO);
        if (!this.xbu.BmT) {
          break label662;
        }
        localObject1 = com.tencent.mm.plugin.finder.report.n.zWF;
        localObject1 = com.tencent.mm.plugin.finder.report.n.Mm(paramb.ARB);
        if (localObject1 == null) {
          break label657;
        }
        l1 = ((bs)localObject1).mf();
        localObject1 = localfl.nE(paramb.ARP).nF(paramb.ARQ).nG(paramb.qkV).uu(paramb.ARR).uv(paramb.sessionId).nH(paramb.ARI).akK().nI(paramb.pDo).nJ(paramb.ART).nK(paramb.xyo);
        if (!BuildInfo.DEBUG) {
          break label670;
        }
        l2 = 0L;
        ((fl)localObject1).nL(l2).nM(paramb.mfx).nN(paramb.ARV).nO(paramb.ARW).nP(paramb.zXu).nQ(paramb.ARY).uw(com.tencent.mm.ae.d.Fw(l1)).nR(paramb.ARZ).nS(paramb.ASc);
        if (this.xbu.BmT) {
          localfl.uN(com.tencent.mm.ae.d.Fw(paramb.ARB));
        }
        localObject1 = paramb.ASf;
        if (localObject1 != null)
        {
          localfl.nU(((c)localObject1).averageSpeed);
          localfl.nX(((c)localObject1).averageConnectCost);
          localfl.uy(((c)localObject1).ASz);
          localfl.nY(((c)localObject1).ASA);
          localfl.mt(((c)localObject1).retCode);
          localfl.of(((c)localObject1).traceId);
          localfl.uO(((c)localObject1).videoCdnMsg);
          localfl.uP(((c)localObject1).profile);
          localfl.og(((c)localObject1).waitResponseCostTime);
          localObject1 = x.aazN;
        }
        localfl.oe(paramb.ASb);
        localfl.mu(paramb.ASr);
        if (paramb.zXC == paramb.zXD) {
          break label678;
        }
      }
      label657:
      label662:
      label670:
      label678:
      for (paramb.ASk = 1;; paramb.ASk = 0)
      {
        localObject1 = MMApplicationContext.getContext().getSystemService("audio");
        if (localObject1 != null) {
          break label686;
        }
        paramb = new t("null cannot be cast to non-null type android.media.AudioManager");
        AppMethodBeat.o(271420);
        throw paramb;
        localObject1 = null;
        break;
        l1 = 0L;
        break label288;
        l1 = paramb.ARB;
        break label288;
        l2 = 61L;
        break label371;
      }
      label686:
      i = ((AudioManager)localObject1).getStreamMaxVolume(3);
      localfl.uD(paramb.zXC * 100 / i + ';' + paramb.zXD * 100 / i + ';' + paramb.ASk);
      localObject1 = new JSONArray();
      localObject2 = ((Iterable)ARy).iterator();
      Object localObject4;
      while (((Iterator)localObject2).hasNext())
      {
        asb localasb = (asb)((Iterator)localObject2).next();
        try
        {
          localObject4 = new JSONObject();
          ((JSONObject)localObject4).put("pos", localasb.ARI);
          ((JSONObject)localObject4).put("spe", localasb.SFw);
          ((JSONObject)localObject4).put("loadCost", localasb.SFy);
          ((JSONObject)localObject4).put("fSize", localasb.SFt);
          ((JSONArray)localObject1).put(localObject4);
        }
        catch (Exception localException1) {}
      }
      localObject1 = ((JSONArray)localObject1).toString();
      p.j(localObject1, "historyInfoArray.toString()");
      localfl.ux(kotlin.n.n.l((String)localObject1, ",", ";", false));
      localfl.nT(paramb.ASd);
      localfl.nV(paramb.ARS);
      localfl.nW(paramb.ASh);
      localObject1 = com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.thumbplayer.a.a.class);
      p.j(localObject1, "MMKernel.plugin(IPluginThumbPlayer::class.java)");
      label1192:
      Object localObject3;
      if (((com.tencent.mm.plugin.thumbplayer.a.a)localObject1).isOpenTPPlayer())
      {
        l1 = 1L;
        localfl.nZ(l1);
        localfl.ob(paramb.zXz);
        localfl.oc(paramb.zXy);
        localfl.uE(paramb.ASo + ';' + paramb.ASm + ';' + paramb.ASl + ';' + paramb.ASn + ';' + paramb.frameRate + ';' + paramb.ASp + ';' + paramb.ASq + ';');
        localObject2 = this.xbu.wmL;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localfl.uG((String)localObject1);
        localObject2 = this.xbu.wmz;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localfl.uF((String)localObject1);
        if (this.xbu.BmT) {
          break label2140;
        }
        localObject1 = com.tencent.mm.plugin.finder.report.n.zWF;
        localObject1 = com.tencent.mm.plugin.finder.report.n.N(paramb.ARB, this.xbu.xkX);
        localfl.uH((String)localObject1);
        localObject1 = com.tencent.mm.plugin.finder.storage.d.AjH;
        localfl.od(((Number)com.tencent.mm.plugin.finder.storage.d.dSW().Mx).intValue());
        localfl.uB(String.valueOf(paramb.ARH));
        localfl.mv(paramb.ASm);
        localfl.uI(paramb.ASo);
        localfl.uJ(paramb.ASl);
        localfl.mw(paramb.ASn);
        localfl.mx(paramb.frameRate);
        localfl.my((int)(paramb.ASp * paramb.ASq));
        localObject3 = new JSONObject();
        ((JSONObject)localObject3).put("videoWidth", Float.valueOf(paramb.ASp));
        ((JSONObject)localObject3).put("videoHeight", Float.valueOf(paramb.ASq));
        localObject1 = MMApplicationContext.getContext();
        p.j(localObject1, "MMApplicationContext.getContext()");
        localObject1 = ((Context)localObject1).getResources();
        p.j(localObject1, "MMApplicationContext.getContext().resources");
        ((JSONObject)localObject3).put("screenWidth", ((Resources)localObject1).getDisplayMetrics().widthPixels);
        localObject1 = MMApplicationContext.getContext();
        p.j(localObject1, "MMApplicationContext.getContext()");
        localObject1 = ((Context)localObject1).getResources();
        p.j(localObject1, "MMApplicationContext.getContext().resources");
        ((JSONObject)localObject3).put("screenHeight", ((Resources)localObject1).getDisplayMetrics().heightPixels);
        localObject4 = ((PluginFinder)com.tencent.mm.kernel.h.ag(PluginFinder.class)).getMediaPreloadModel();
        ((JSONObject)localObject3).put("isMultiBitRate", ((com.tencent.mm.plugin.finder.preload.model.a)localObject4).zKT);
        ((JSONObject)localObject3).put("isSecondPre", ((com.tencent.mm.plugin.finder.preload.model.a)localObject4).zKU);
        ((JSONObject)localObject3).put("playLinkCnt", ((com.tencent.mm.plugin.finder.preload.model.a)localObject4).zKI);
        ((JSONObject)localObject3).put("preLinkCnt", ((com.tencent.mm.plugin.finder.preload.model.a)localObject4).zKH);
        ((JSONObject)localObject3).put("startPrePercent", ((com.tencent.mm.plugin.finder.preload.model.a)localObject4).zKJ);
        ((JSONObject)localObject3).put("startPreSec", ((com.tencent.mm.plugin.finder.preload.model.a)localObject4).zKK);
        ((JSONObject)localObject3).put("preTaskCnt", ((com.tencent.mm.plugin.finder.preload.model.a)localObject4).zKG);
        ((JSONObject)localObject3).put("maxPrePercent", ((com.tencent.mm.plugin.finder.preload.model.a)localObject4).zKE);
        ((JSONObject)localObject3).put("maxPreBytes", ((com.tencent.mm.plugin.finder.preload.model.a)localObject4).zKF);
        ((JSONObject)localObject3).put("prevCnt", ((com.tencent.mm.plugin.finder.preload.model.a)localObject4).zKC);
        ((JSONObject)localObject3).put("nextCnt", ((com.tencent.mm.plugin.finder.preload.model.a)localObject4).zKD);
        ((JSONObject)localObject3).put("maxPreBitRate", ((com.tencent.mm.plugin.finder.preload.model.a)localObject4).zKL);
        localObject2 = (String)((com.tencent.mm.plugin.finder.preload.model.a)localObject4).zKS.get(localfl.getMediaId());
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        ((JSONObject)localObject3).put("findSpecStep", localObject1);
        ((JSONObject)localObject3).put("megaVideoMaxBitrate", ((com.tencent.mm.plugin.finder.preload.model.a)localObject4).zKN);
        ((JSONObject)localObject3).put("megaVideoPrevCount", ((com.tencent.mm.plugin.finder.preload.model.a)localObject4).zKO);
        ((JSONObject)localObject3).put("megaVideoNextCount", ((com.tencent.mm.plugin.finder.preload.model.a)localObject4).zKP);
        ((JSONObject)localObject3).put("playDecoderType", paramb.playDecoderType);
        ((JSONObject)localObject3).put("emcru", paramb.ASs);
        ((JSONObject)localObject3).put("mce", paramb.ASt);
        ((JSONObject)localObject3).put("mcru", paramb.ASu);
        ((JSONObject)localObject3).put("mcec", paramb.ASv);
        ((JSONObject)localObject3).put("mcid", paramb.ASw);
        ((JSONObject)localObject3).put("fvfrd", paramb.zVj);
        ((JSONObject)localObject3).put("mpnn", paramb.ARD);
        ((JSONObject)localObject3).put("mpdp", paramb.ARE);
        localObject1 = paramb.xqC;
        if (localObject1 != null)
        {
          ((e)localObject1).a((JSONObject)localObject3, localfl);
          localObject1 = x.aazN;
        }
        localObject1 = x.aazN;
        localObject1 = ((JSONObject)localObject3).toString();
        p.j(localObject1, "JSONObject().apply {\n   …             }.toString()");
        localfl.uK(kotlin.n.n.l((String)localObject1, ",", ";", false));
        localObject1 = this.xbu.extraInfo;
        if (localObject1 != null)
        {
          localObject2 = kotlin.n.n.l((String)localObject1, ",", ";", false);
          localObject1 = localObject2;
          if (localObject2 != null) {}
        }
        else
        {
          localObject1 = "";
        }
        localfl.uL((String)localObject1);
        localObject1 = this.xbu.wmC;
        if (localObject1 != null)
        {
          localObject2 = kotlin.n.n.l((String)localObject1, ",", ";", false);
          localObject1 = localObject2;
          if (localObject2 != null) {}
        }
        else
        {
          localObject1 = "";
        }
        localfl.uM((String)localObject1);
        if (this.xbu.BmT) {
          break label2180;
        }
        localObject1 = com.tencent.mm.plugin.finder.report.n.zWF;
        localObject1 = com.tencent.mm.plugin.finder.report.n.Hc(paramb.ARB);
        if (localObject1 == null) {
          break label2164;
        }
        localfl.uA(((FinderItem)localObject1).getUserName());
        localObject1 = x.aazN;
      }
      for (;;)
      {
        localObject1 = new JSONArray();
        localObject2 = ((Iterable)paramb.ASi).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (bll)((Iterator)localObject2).next();
          try
          {
            localObject4 = new JSONObject();
            ((JSONObject)localObject4).put("waitMs", ((bll)localObject3).SWy);
            ((JSONObject)localObject4).put("percent", ((bll)localObject3).percent);
            ((JSONObject)localObject4).put("type", ((bll)localObject3).type);
            ((JSONArray)localObject1).put(localObject4);
          }
          catch (Exception localException2) {}
        }
        l1 = 0L;
        break;
        label2140:
        localObject1 = com.tencent.mm.plugin.finder.report.n.zWF;
        localObject1 = com.tencent.mm.plugin.finder.report.n.N(paramb.ARB, this.xbu.xkX);
        break label1192;
        label2164:
        localfl.uA("");
        localObject1 = x.aazN;
        continue;
        label2180:
        localObject1 = com.tencent.mm.plugin.finder.report.n.zWF;
        localObject1 = com.tencent.mm.plugin.finder.report.n.Mm(paramb.ARB);
        if (localObject1 != null)
        {
          localObject1 = ((bs)localObject1).contact;
          if (localObject1 != null)
          {
            localObject2 = ((FinderContact)localObject1).username;
            localObject1 = localObject2;
            if (localObject2 != null) {}
          }
          else
          {
            localObject1 = "";
          }
          localfl.uA((String)localObject1);
          localObject1 = x.aazN;
        }
      }
      localObject1 = ((JSONArray)localObject1).toString();
      p.j(localObject1, "waitingDetails.toString()");
      localfl.uz(kotlin.n.n.l((String)localObject1, ",", ";", false));
      localObject1 = "";
      localObject2 = ((Iterable)paramb.ASj).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        i = ((Number)((Iterator)localObject2).next()).intValue();
        localObject1 = (String)localObject1 + i + ';';
      }
      localfl.uC((String)localObject1);
      localfl.fBl();
      localObject1 = new ArrayList(8);
      if (localfl.akP() > 0L)
      {
        localObject2 = new IDKey();
        ((IDKey)localObject2).SetID(this.ARx);
        ((IDKey)localObject2).SetKey(0);
        ((IDKey)localObject2).SetValue(localfl.akP());
        ((ArrayList)localObject1).add(localObject2);
      }
      if ((localfl.akM() > 0L) && (localfl.akP() > 0L))
      {
        localObject2 = new IDKey();
        ((IDKey)localObject2).SetID(this.ARx);
        ((IDKey)localObject2).SetKey(1);
        ((IDKey)localObject2).SetValue(localfl.akP());
        ((ArrayList)localObject1).add(localObject2);
      }
      if ((localfl.akM() > 0L) && (localfl.akI() > 0L))
      {
        localObject2 = new IDKey();
        ((IDKey)localObject2).SetID(this.ARx);
        ((IDKey)localObject2).SetKey(2);
        ((IDKey)localObject2).SetValue(1L);
        ((ArrayList)localObject1).add(localObject2);
      }
      if ((localfl.akM() > 0L) && (localfl.akN() > 0L))
      {
        localObject2 = new IDKey();
        ((IDKey)localObject2).SetID(this.ARx);
        ((IDKey)localObject2).SetKey(3);
        ((IDKey)localObject2).SetValue(localfl.akN());
        ((ArrayList)localObject1).add(localObject2);
        if (localfl.akN() > 500L) {
          break label3355;
        }
        localObject2 = new IDKey();
        ((IDKey)localObject2).SetID(this.ARx);
        ((IDKey)localObject2).SetKey(5);
        ((IDKey)localObject2).SetValue(1L);
        ((ArrayList)localObject1).add(localObject2);
      }
      if ((localfl.akM() > 0L) && (localfl.akR() > 0L))
      {
        localObject2 = new IDKey();
        ((IDKey)localObject2).SetID(this.ARx);
        ((IDKey)localObject2).SetKey(4);
        ((IDKey)localObject2).SetValue(localfl.akR());
        ((ArrayList)localObject1).add(localObject2);
      }
      if (localfl.akQ() == 1L)
      {
        localObject2 = new IDKey();
        ((IDKey)localObject2).SetID(this.ARx);
        ((IDKey)localObject2).SetValue(1L);
        if (paramb.playDecoderType != 102) {
          break label3463;
        }
        ((IDKey)localObject2).SetKey(104);
        ((ArrayList)localObject1).add(localObject2);
      }
      label2780:
      localObject2 = new IDKey();
      ((IDKey)localObject2).SetID(this.ARx);
      ((IDKey)localObject2).SetKey(100);
      ((IDKey)localObject2).SetValue(1L);
      ((ArrayList)localObject1).add(localObject2);
      if (localfl.akM() > 0L)
      {
        localObject2 = new IDKey();
        ((IDKey)localObject2).SetID(this.ARx);
        ((IDKey)localObject2).SetKey(101);
        ((IDKey)localObject2).SetValue(1L);
        ((ArrayList)localObject1).add(localObject2);
      }
      if ((localfl.akM() > 0L) && (localfl.akN() > 0L))
      {
        localObject2 = new IDKey();
        ((IDKey)localObject2).SetID(this.ARx);
        ((IDKey)localObject2).SetKey(102);
        ((IDKey)localObject2).SetValue(1L);
        ((ArrayList)localObject1).add(localObject2);
      }
      if ((localfl.akM() > 0L) && (localfl.akR() > 0L))
      {
        localObject2 = new IDKey();
        ((IDKey)localObject2).SetID(this.ARx);
        ((IDKey)localObject2).SetKey(103);
        ((IDKey)localObject2).SetValue(1L);
        ((ArrayList)localObject1).add(localObject2);
      }
      if (((Collection)localObject1).isEmpty()) {
        break label3490;
      }
    }
    label3355:
    label3490:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        com.tencent.mm.plugin.report.service.h.IzE.b((ArrayList)localObject1, false);
      }
      localObject1 = com.tencent.mm.plugin.finder.report.n.zWF;
      com.tencent.mm.plugin.finder.report.n.a((com.tencent.mm.plugin.report.a)localfl);
      localObject1 = paramb.ASf;
      if (localObject1 != null)
      {
        localObject2 = new asb();
        ((asb)localObject2).feedId = paramb.ARB;
        ((asb)localObject2).SFr = 0;
        ((asb)localObject2).SFw = ((int)localfl.akO());
        ((asb)localObject2).SFy = ((int)localfl.akN());
        ((asb)localObject2).SFt = ((int)localfl.getFileSize());
        ((asb)localObject2).SFs = kotlin.h.a.dm((float)(localfl.getFileSize() * localfl.akJ()) / 100.0F);
        ((asb)localObject2).pxV = kotlin.h.a.dm((float)(localfl.akL() * localfl.getFileSize()) / 100.0F);
        ((asb)localObject2).scene = this.xbu.xkX;
        ((asb)localObject2).duration = localac.dJw().videoDuration;
        ((asb)localObject2).ARI = ((int)localfl.getPosition());
        ((asb)localObject2).SFx = cm.bfF();
        ((asb)localObject2).SFu = ((int)paramb.zXw);
        ((asb)localObject2).SFv = ((int)paramb.ASb);
        ((asb)localObject2).ASi = paramb.ASi;
        ((asb)localObject2).fPD = paramb.ASl;
        ((asb)localObject2).SFz = ((c)localObject1).averageConnectCost;
        ((asb)localObject2).ASz = ((c)localObject1).ASz;
        ((asb)localObject2).ASA = ((c)localObject1).ASA;
        ((asb)localObject2).networkId = ((c)localObject1).netType;
        ((asb)localObject2).ARH = paramb.ARH;
        if (ARy.size() > 2) {
          ARy.remove(0);
        }
        ARy.add(localObject2);
        ARz.add(localObject2);
        Log.i("Finder.FinderVideoPlayReporter", "downloadInfoList " + ARy.size());
        paramb = x.aazN;
      }
      paramb = x.aazN;
      AppMethodBeat.o(271420);
      return;
      if (localfl.akN() <= 1000L)
      {
        localObject2 = new IDKey();
        ((IDKey)localObject2).SetID(this.ARx);
        ((IDKey)localObject2).SetKey(6);
        ((IDKey)localObject2).SetValue(1L);
        ((ArrayList)localObject1).add(localObject2);
        break;
      }
      if (localfl.akN() <= 1000L) {
        break;
      }
      localObject2 = new IDKey();
      ((IDKey)localObject2).SetID(this.ARx);
      ((IDKey)localObject2).SetKey(7);
      ((IDKey)localObject2).SetValue(1L);
      ((ArrayList)localObject1).add(localObject2);
      break;
      if (paramb.playDecoderType != 101) {
        break label2780;
      }
      ((IDKey)localObject2).SetKey(105);
      ((ArrayList)localObject1).add(localObject2);
      break label2780;
    }
    label3463:
    label3495:
    AppMethodBeat.o(271420);
  }
  
  public final void b(b paramb)
  {
    AppMethodBeat.i(271423);
    Object localObject;
    oc localoc;
    long l1;
    if (paramb != null)
    {
      localObject = String.valueOf(a("report17000", paramb));
      Log.i("Finder.FinderVideoPlayReporter", (String)localObject);
      if (paramb == null) {
        break label683;
      }
      localObject = aj.AGc;
      csg localcsg = paramb.ARG;
      d locald = paramb.ASe;
      c localc = paramb.ASf;
      if ((localcsg != null) && (locald != null) && (localc != null))
      {
        localoc = new oc();
        localObject = com.tencent.mm.plugin.finder.storage.logic.d.AnN;
        localObject = paramb.ARF;
        if (localObject != null)
        {
          String str = ((ac)localObject).aBv();
          localObject = str;
          if (str != null) {}
        }
        else
        {
          localObject = "";
        }
        localObject = com.tencent.mm.plugin.finder.storage.logic.d.aEU((String)localObject);
        long l2 = kotlin.h.a.N((float)(paramb.ARN * ((av)localObject).field_totalSize) / 100.0F);
        localObject = localoc.EK(com.tencent.mm.ae.d.Fw(paramb.ARB)).zO(this.xbu.xkX + 100).zP(paramb.ART);
        if (paramb.ARI != 0) {
          break label637;
        }
        l1 = 1L;
        label193:
        localObject = ((oc)localObject).zQ(l1).zR(localcsg.videoDuration).zS(kotlin.h.a.N(localcsg.videoDuration * paramb.ARL / 100.0F)).zT(paramb.ARY).zU(paramb.ARP).zV(paramb.ASh).aoa().zX(0L).zY(localc.retCode).EL("").zZ(paramb.ASm).EM(String.valueOf(locald.requestVideoFormat)).EP(locald.requestVideoFlag).Aa(localc.mHi).Ab(localc.recvedBytes).Ac(localc.startTime).Ad(localc.endTime).Ae(localc.retCode).Af(localc.enQueueTime).Ag(localc.moovRequestTimes).Ah(localc.moovCost).Ai(localc.moovSize);
        if (!localc.moovCompleted) {
          break label642;
        }
        l1 = 1L;
        label387:
        localObject = ((oc)localObject).Aj(l1).Ak(localc.moovFailReason).Al(localc.firstConnectCost).Am(localc.firstRequestCost).An(localc.firstRequestSize).Ao(localc.firstRequestDownloadSize);
        if (!localc.firstRequestCompleted) {
          break label647;
        }
        l1 = 1L;
        label450:
        localObject = ((oc)localObject).Ap(l1).Aq(localc.averageSpeed).Ar(localc.averageConnectCost).As(localc.netConnectTimes).EN(localc.ASx).EO(localc.clientIP);
        if (!localc.ASy) {
          break label652;
        }
        l1 = 1L;
        label511:
        localObject = ((oc)localObject).At(l1).Au(locald.iVj).Av(0L).Aw(paramb.ARS).Ax(paramb.qkV).Ay(l2).aoc().oa(localc.transportProtocol).ob(localc.transportProtocolError);
        if (!BuildInfo.DEBUG) {
          break label657;
        }
        l1 = 0L;
        label577:
        ((oc)localObject).Az(l1).AA(localc.traceId);
        if (paramb.ARZ != 0) {
          break label664;
        }
        localoc.zW(0L);
      }
    }
    for (;;)
    {
      localoc.bpa();
      paramb = com.tencent.mm.plugin.finder.report.n.zWF;
      com.tencent.mm.plugin.finder.report.n.a((com.tencent.mm.plugin.report.a)localoc);
      AppMethodBeat.o(271423);
      return;
      localObject = null;
      break;
      label637:
      l1 = 0L;
      break label193;
      label642:
      l1 = 0L;
      break label387;
      label647:
      l1 = 0L;
      break label450;
      label652:
      l1 = 0L;
      break label511;
      label657:
      l1 = 61L;
      break label577;
      label664:
      localoc.zW(paramb.ASb / paramb.ARZ);
    }
    label683:
    AppMethodBeat.o(271423);
  }
  
  public final void c(c.a parama)
  {
    AppMethodBeat.i(271412);
    p.k(parama, "event");
    Object localObject1 = (b)this.ARv.get(Long.valueOf(parama.feedId));
    if ((localObject1 != null) && (((b)localObject1).ASg))
    {
      localObject2 = parama.mfS;
      if ((localObject2 != null) && (((b)localObject1).ASe == null)) {
        ((b)localObject1).ASe = f((com.tencent.mm.i.h)localObject2);
      }
      localObject2 = parama.jYa;
      if ((localObject2 != null) && (((b)localObject1).ASf == null)) {
        ((b)localObject1).ASf = b((com.tencent.mm.i.d)localObject2);
      }
      ((b)localObject1).ASg = false;
      p.j(localObject1, "this");
      Log.i("Finder.FinderVideoPlayReporter", String.valueOf(a("onDownloadStop", (b)localObject1)));
    }
    localObject1 = (Iterable)this.ARu;
    Object localObject2 = (Collection)new ArrayList();
    Object localObject3 = ((Iterable)localObject1).iterator();
    Object localObject4;
    label211:
    label244:
    label247:
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = ((Iterator)localObject3).next();
      localObject1 = (b)localObject4;
      if (((b)localObject1).ARB == parama.feedId)
      {
        String str = ((b)localObject1).ARC;
        localObject1 = parama.xqx;
        if (localObject1 != null)
        {
          localObject1 = ((ac)localObject1).aBv();
          if (!p.h(str, localObject1)) {
            break label244;
          }
        }
      }
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label247;
        }
        ((Collection)localObject2).add(localObject4);
        break;
        localObject1 = null;
        break label211;
      }
    }
    localObject2 = (Iterable)localObject2;
    localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (b)((Iterator)localObject2).next();
      localObject4 = parama.mfS;
      if ((localObject4 != null) && (((b)localObject3).ASe == null)) {
        ((b)localObject3).ASe = f((com.tencent.mm.i.h)localObject4);
      }
      localObject4 = parama.jYa;
      if ((localObject4 != null) && (((b)localObject3).ASf == null)) {
        ((b)localObject3).ASf = b((com.tencent.mm.i.d)localObject4);
      }
      ((Collection)localObject1).add(localObject3);
    }
    parama = (List)localObject1;
    this.ARu.removeAll((Collection)parama);
    Log.i("Finder.FinderVideoPlayReporter", "lazyReportDataList " + this.ARu.size() + " reportList " + parama.size());
    parama = ((Iterable)parama).iterator();
    while (parama.hasNext())
    {
      localObject1 = (b)parama.next();
      a((b)localObject1);
      b((b)localObject1);
    }
    AppMethodBeat.o(271412);
  }
  
  public final void f(bid parambid)
  {
    AppMethodBeat.i(271424);
    p.k(parambid, "contextObj");
    this.xbu = parambid;
    AppMethodBeat.o(271424);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/video/reporter/FinderVideoPlayReporter$Companion;", "", "()V", "INNER_VERSION", "", "TAG", "", "downloadInfoAllList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderDownloadInfo;", "getDownloadInfoAllList", "()Ljava/util/LinkedList;", "downloadInfoList", "getDownloadInfoList", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/video/reporter/FinderVideoPlayReporter$ReportData;", "", "()V", "adjustVolume", "", "getAdjustVolume", "()I", "setAdjustVolume", "(I)V", "bgPreparedStatus", "getBgPreparedStatus", "setBgPreparedStatus", "currentFeedId", "", "getCurrentFeedId", "()J", "setCurrentFeedId", "(J)V", "currentMedia", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "getCurrentMedia", "()Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "setCurrentMedia", "(Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;)V", "currentMediaDescription", "", "getCurrentMediaDescription", "()Ljava/lang/String;", "setCurrentMediaDescription", "(Ljava/lang/String;)V", "currentMediaId", "getCurrentMediaId", "setCurrentMediaId", "currentMediaPosterNickName", "getCurrentMediaPosterNickName", "setCurrentMediaPosterNickName", "currentVideo", "Lcom/tencent/mm/plugin/finder/loader/IFinderMediaLoaderData;", "getCurrentVideo", "()Lcom/tencent/mm/plugin/finder/loader/IFinderMediaLoaderData;", "setCurrentVideo", "(Lcom/tencent/mm/plugin/finder/loader/IFinderMediaLoaderData;)V", "currentWaiting", "", "getCurrentWaiting", "()Z", "setCurrentWaiting", "(Z)V", "downloadFinishTime", "getDownloadFinishTime", "setDownloadFinishTime", "downloadPercent", "getDownloadPercent", "setDownloadPercent", "downloadSpeed", "getDownloadSpeed", "setDownloadSpeed", "enableMediaCodecReuse", "getEnableMediaCodecReuse", "setEnableMediaCodecReuse", "endVolume", "getEndVolume", "setEndVolume", "fetchTimestamp", "getFetchTimestamp", "setFetchTimestamp", "firstFrameTime", "getFirstFrameTime", "setFirstFrameTime", "firstLoadTime", "getFirstLoadTime", "setFirstLoadTime", "firstPlay", "getFirstPlay", "setFirstPlay", "firstRequestDataOffset", "getFirstRequestDataOffset", "setFirstRequestDataOffset", "firstVideoFrameRendered", "getFirstVideoFrameRendered", "setFirstVideoFrameRendered", "frameRate", "getFrameRate", "setFrameRate", "hitPreload", "getHitPreload", "setHitPreload", "hitPreloadPercent", "getHitPreloadPercent", "setHitPreloadPercent", "isPause", "setPause", "isSeek", "setSeek", "isStartDownload", "setStartDownload", "mediaCodecErrorCode", "getMediaCodecErrorCode", "setMediaCodecErrorCode", "mediaCodecInitDuration", "getMediaCodecInitDuration", "setMediaCodecInitDuration", "mediaCodecReuseEnabled", "getMediaCodecReuseEnabled", "setMediaCodecReuseEnabled", "mediaCodecReused", "getMediaCodecReused", "setMediaCodecReused", "mediaPath", "getMediaPath", "setMediaPath", "moovReadyOffset", "getMoovReadyOffset", "setMoovReadyOffset", "moovReadyTime", "getMoovReadyTime", "setMoovReadyTime", "netType", "getNetType", "setNetType", "netTypeInt", "getNetTypeInt", "setNetTypeInt", "onStopPlayData", "Lcom/tencent/mm/plugin/finder/video/reporter/OnStopPlayData;", "getOnStopPlayData", "()Lcom/tencent/mm/plugin/finder/video/reporter/OnStopPlayData;", "setOnStopPlayData", "(Lcom/tencent/mm/plugin/finder/video/reporter/OnStopPlayData;)V", "pauseTimestamp", "getPauseTimestamp", "setPauseTimestamp", "pauseTotalTime", "getPauseTotalTime", "setPauseTotalTime", "playAudioBitrate", "getPlayAudioBitrate", "setPlayAudioBitrate", "playCodeFormat", "getPlayCodeFormat", "setPlayCodeFormat", "playDecoderType", "getPlayDecoderType", "setPlayDecoderType", "playFileFormat", "getPlayFileFormat", "setPlayFileFormat", "playPageIndex", "getPlayPageIndex", "setPlayPageIndex", "playPercent", "getPlayPercent", "setPlayPercent", "playPercentSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "getPlayPercentSet", "()Ljava/util/HashSet;", "setPlayPercentSet", "(Ljava/util/HashSet;)V", "playPosition", "getPlayPosition", "setPlayPosition", "playStatus", "getPlayStatus", "setPlayStatus", "playTime", "getPlayTime", "setPlayTime", "playVideoBitrate", "getPlayVideoBitrate", "setPlayVideoBitrate", "playWaitingCount", "getPlayWaitingCount", "setPlayWaitingCount", "playerErrCode", "getPlayerErrCode", "setPlayerErrCode", "playing", "getPlaying", "setPlaying", "preloadStrategyId", "getPreloadStrategyId", "setPreloadStrategyId", "realPlayTime", "getRealPlayTime", "setRealPlayTime", "realPlayTimestamp", "getRealPlayTimestamp", "setRealPlayTimestamp", "replayCount", "getReplayCount", "setReplayCount", "reportSceneResult", "Lcom/tencent/mm/plugin/finder/video/reporter/FinderVideoPlayReporter$ReportSceneResult;", "getReportSceneResult", "()Lcom/tencent/mm/plugin/finder/video/reporter/FinderVideoPlayReporter$ReportSceneResult;", "setReportSceneResult", "(Lcom/tencent/mm/plugin/finder/video/reporter/FinderVideoPlayReporter$ReportSceneResult;)V", "reportTaskInfo", "Lcom/tencent/mm/plugin/finder/video/reporter/FinderVideoPlayReporter$ReportTaskInfo;", "getReportTaskInfo", "()Lcom/tencent/mm/plugin/finder/video/reporter/FinderVideoPlayReporter$ReportTaskInfo;", "setReportTaskInfo", "(Lcom/tencent/mm/plugin/finder/video/reporter/FinderVideoPlayReporter$ReportTaskInfo;)V", "sessionId", "getSessionId", "setSessionId", "startTimestamp", "getStartTimestamp", "setStartTimestamp", "startVolume", "getStartVolume", "setStartVolume", "startWaitingTime", "getStartWaitingTime", "setStartWaitingTime", "totalWaitingTime", "getTotalWaitingTime", "setTotalWaitingTime", "videoHeight", "", "getVideoHeight", "()F", "setVideoHeight", "(F)V", "videoWidth", "getVideoWidth", "setVideoWidth", "waitDetails", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderWaitDetail;", "getWaitDetails", "()Ljava/util/LinkedList;", "setWaitDetails", "(Ljava/util/LinkedList;)V", "waitingCount", "getWaitingCount", "setWaitingCount", "plugin-finder_release"})
  public static final class b
  {
    public long ARB;
    public String ARC;
    public String ARD;
    public String ARE;
    public ac ARF;
    public csg ARG;
    public long ARH;
    public int ARI;
    public int ARJ;
    public long ARK;
    public int ARL;
    public int ARM;
    public int ARN;
    public long ARO;
    public long ARP;
    public long ARQ;
    public String ARR;
    public long ARS;
    public int ART;
    public boolean ARU;
    public int ARV;
    public long ARW;
    public long ARX;
    public long ARY;
    public int ARZ;
    public long ASa;
    public long ASb;
    public long ASc;
    public long ASd;
    d.d ASe;
    public d.c ASf;
    public boolean ASg;
    public long ASh;
    public LinkedList<bll> ASi;
    public HashSet<Integer> ASj;
    int ASk;
    String ASl;
    public int ASm;
    public int ASn;
    public String ASo;
    public float ASp;
    public float ASq;
    public int ASr;
    public int ASs;
    public int ASt;
    public int ASu;
    public String ASv;
    public int ASw;
    public boolean aPw;
    public int frameRate;
    public String mediaPath;
    public int mfx;
    public int pDo;
    public int playDecoderType;
    public long qkV;
    public String sessionId;
    public e xqC;
    public int xqz;
    public int xyo;
    public long zVj;
    public int zXC;
    public int zXD;
    public long zXu;
    public long zXv;
    public long zXw;
    public int zXy;
    public int zXz;
    
    public b()
    {
      AppMethodBeat.i(288382);
      this.sessionId = "";
      this.ARC = "";
      this.ARD = "";
      this.ARE = "";
      this.mediaPath = "";
      this.ARR = "";
      this.ASi = new LinkedList();
      this.ASj = new HashSet();
      this.ASl = "";
      this.ASo = "";
      this.ASs = -1;
      this.ASt = -1;
      this.ASu = -1;
      this.ASv = "0";
      this.ASw = -1;
      AppMethodBeat.o(288382);
    }
    
    public final void aGm(String paramString)
    {
      AppMethodBeat.i(288381);
      p.k(paramString, "<set-?>");
      this.ASl = paramString;
      AppMethodBeat.o(288381);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/video/reporter/FinderVideoPlayReporter$ReportSceneResult;", "", "mediaId", "", "(Ljava/lang/String;)V", "averageConnectCost", "", "getAverageConnectCost", "()I", "setAverageConnectCost", "(I)V", "averageSpeed", "getAverageSpeed", "setAverageSpeed", "backSrcFlag", "getBackSrcFlag", "setBackSrcFlag", "clientIP", "getClientIP", "()Ljava/lang/String;", "setClientIP", "enQueueTime", "", "getEnQueueTime", "()J", "setEnQueueTime", "(J)V", "endTime", "getEndTime", "setEndTime", "fileLength", "getFileLength", "setFileLength", "firstConnectCost", "getFirstConnectCost", "setFirstConnectCost", "firstRequestCompleted", "", "getFirstRequestCompleted", "()Z", "setFirstRequestCompleted", "(Z)V", "firstRequestCost", "getFirstRequestCost", "setFirstRequestCost", "firstRequestDownloadSize", "getFirstRequestDownloadSize", "setFirstRequestDownloadSize", "firstRequestSize", "getFirstRequestSize", "setFirstRequestSize", "isCrossNet", "setCrossNet", "getMediaId", "moovCompleted", "getMoovCompleted", "setMoovCompleted", "moovCost", "getMoovCost", "setMoovCost", "moovFailReason", "getMoovFailReason", "setMoovFailReason", "moovRequestTimes", "getMoovRequestTimes", "setMoovRequestTimes", "moovSize", "getMoovSize", "setMoovSize", "netConnectTimes", "getNetConnectTimes", "setNetConnectTimes", "netType", "getNetType", "setNetType", "profile", "getProfile", "setProfile", "recvedBytes", "getRecvedBytes", "setRecvedBytes", "retCode", "getRetCode", "setRetCode", "rptIpList", "getRptIpList", "setRptIpList", "startTime", "getStartTime", "setStartTime", "svrIp", "getSvrIp", "setSvrIp", "svrPort", "getSvrPort", "setSvrPort", "traceId", "getTraceId", "setTraceId", "transportProtocol", "getTransportProtocol", "setTransportProtocol", "transportProtocolError", "getTransportProtocolError", "setTransportProtocolError", "videoCdnMsg", "getVideoCdnMsg", "setVideoCdnMsg", "videoFlag", "getVideoFlag", "setVideoFlag", "waitResponseCostTime", "getWaitResponseCostTime", "setWaitResponseCostTime", "component1", "copy", "equals", "other", "hashCode", "toString", "plugin-finder_release"})
  public static final class c
  {
    int ASA;
    int ASB;
    String ASx;
    boolean ASy;
    String ASz;
    int averageConnectCost;
    int averageSpeed;
    String clientIP;
    long enQueueTime;
    long endTime;
    int firstConnectCost;
    boolean firstRequestCompleted;
    int firstRequestCost;
    int firstRequestDownloadSize;
    int firstRequestSize;
    long mHi;
    private final String mediaId;
    boolean moovCompleted;
    int moovCost;
    int moovFailReason;
    int moovRequestTimes;
    int moovSize;
    int netConnectTimes;
    int netType;
    String profile;
    long recvedBytes;
    int retCode;
    long startTime;
    long traceId;
    int transportProtocol;
    int transportProtocolError;
    String videoCdnMsg;
    String videoFlag;
    int waitResponseCostTime;
    
    public c(String paramString)
    {
      AppMethodBeat.i(253025);
      this.mediaId = paramString;
      this.ASx = "";
      this.clientIP = "";
      this.ASz = "";
      this.videoCdnMsg = "";
      this.videoFlag = "";
      this.profile = "";
      AppMethodBeat.o(253025);
    }
    
    public final void aGn(String paramString)
    {
      AppMethodBeat.i(253016);
      p.k(paramString, "<set-?>");
      this.ASx = paramString;
      AppMethodBeat.o(253016);
    }
    
    public final void aGo(String paramString)
    {
      AppMethodBeat.i(253018);
      p.k(paramString, "<set-?>");
      this.clientIP = paramString;
      AppMethodBeat.o(253018);
    }
    
    public final void aGp(String paramString)
    {
      AppMethodBeat.i(253020);
      p.k(paramString, "<set-?>");
      this.ASz = paramString;
      AppMethodBeat.o(253020);
    }
    
    public final void aGq(String paramString)
    {
      AppMethodBeat.i(253022);
      p.k(paramString, "<set-?>");
      this.videoCdnMsg = paramString;
      AppMethodBeat.o(253022);
    }
    
    public final void aGr(String paramString)
    {
      AppMethodBeat.i(253023);
      p.k(paramString, "<set-?>");
      this.videoFlag = paramString;
      AppMethodBeat.o(253023);
    }
    
    public final void aGs(String paramString)
    {
      AppMethodBeat.i(253024);
      p.k(paramString, "<set-?>");
      this.profile = paramString;
      AppMethodBeat.o(253024);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(253028);
      if (this != paramObject)
      {
        if ((paramObject instanceof c))
        {
          paramObject = (c)paramObject;
          if (!p.h(this.mediaId, paramObject.mediaId)) {}
        }
      }
      else
      {
        AppMethodBeat.o(253028);
        return true;
      }
      AppMethodBeat.o(253028);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(253027);
      String str = this.mediaId;
      if (str != null)
      {
        int i = str.hashCode();
        AppMethodBeat.o(253027);
        return i;
      }
      AppMethodBeat.o(253027);
      return 0;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(253026);
      String str = "ReportSceneResult(mediaId=" + this.mediaId + ")";
      AppMethodBeat.o(253026);
      return str;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/video/reporter/FinderVideoPlayReporter$ReportTaskInfo;", "", "mediaId", "", "(Ljava/lang/String;)V", "getMediaId", "()Ljava/lang/String;", "moovPos", "", "getMoovPos", "()J", "setMoovPos", "(J)V", "requestVideoFlag", "getRequestVideoFlag", "setRequestVideoFlag", "requestVideoFormat", "", "getRequestVideoFormat", "()I", "setRequestVideoFormat", "(I)V", "component1", "copy", "equals", "", "other", "hashCode", "toString", "plugin-finder_release"})
  public static final class d
  {
    long iVj;
    private final String mediaId;
    String requestVideoFlag;
    int requestVideoFormat;
    
    public d(String paramString)
    {
      AppMethodBeat.i(271274);
      this.mediaId = paramString;
      this.requestVideoFlag = "";
      AppMethodBeat.o(271274);
    }
    
    public final void aGt(String paramString)
    {
      AppMethodBeat.i(271273);
      p.k(paramString, "<set-?>");
      this.requestVideoFlag = paramString;
      AppMethodBeat.o(271273);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(271277);
      if (this != paramObject)
      {
        if ((paramObject instanceof d))
        {
          paramObject = (d)paramObject;
          if (!p.h(this.mediaId, paramObject.mediaId)) {}
        }
      }
      else
      {
        AppMethodBeat.o(271277);
        return true;
      }
      AppMethodBeat.o(271277);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(271276);
      String str = this.mediaId;
      if (str != null)
      {
        int i = str.hashCode();
        AppMethodBeat.o(271276);
        return i;
      }
      AppMethodBeat.o(271276);
      return 0;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(271275);
      String str = "ReportTaskInfo(mediaId=" + this.mediaId + ")";
      AppMethodBeat.o(271275);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.reporter.d
 * JD-Core Version:    0.7.0.1
 */