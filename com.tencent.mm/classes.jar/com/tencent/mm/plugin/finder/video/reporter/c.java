package com.tencent.mm.plugin.finder.video.reporter;

import android.content.Context;
import android.content.res.Resources;
import android.media.AudioManager;
import android.util.DisplayMetrics;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.hb;
import com.tencent.mm.autogen.mmdata.rpt.ru;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.loader.x;
import com.tencent.mm.plugin.finder.model.az;
import com.tencent.mm.plugin.finder.model.ca;
import com.tencent.mm.plugin.finder.preload.model.b;
import com.tencent.mm.plugin.finder.report.bd;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.e;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.plugin.finder.video.f;
import com.tencent.mm.plugin.vlog.model.o;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.akz;
import com.tencent.mm.protocal.protobuf.awn;
import com.tencent.mm.protocal.protobuf.boz;
import com.tencent.mm.protocal.protobuf.bra;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.bza;
import com.tencent.mm.protocal.protobuf.dji;
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
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.n.n;
import kotlin.r;
import kotlin.u;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/video/reporter/FinderVideoPlayReporter;", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "IDKEY", "", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "setContextObj", "currentVideoReportMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/video/reporter/FinderVideoPlayReporter$ReportData;", "getCurrentVideoReportMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "setCurrentVideoReportMap", "(Ljava/util/concurrent/ConcurrentHashMap;)V", "enableRendererSharpen", "getEnableRendererSharpen", "()I", "setEnableRendererSharpen", "(I)V", "firstFrameTimeConsumingStatistic", "Lcom/tencent/mm/plugin/finder/video/statistics/ConsumingStatistics;", "getFirstFrameTimeConsumingStatistic", "()Lcom/tencent/mm/plugin/finder/video/statistics/ConsumingStatistics;", "setFirstFrameTimeConsumingStatistic", "(Lcom/tencent/mm/plugin/finder/video/statistics/ConsumingStatistics;)V", "lazyReportDataList", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "getLazyReportDataList", "()Ljava/util/concurrent/ConcurrentLinkedDeque;", "setLazyReportDataList", "(Ljava/util/concurrent/ConcurrentLinkedDeque;)V", "baseInfoLog", "", "eventName", "reportData", "checkVideoDataAvailable", "", "event", "Lcom/tencent/mm/plugin/finder/event/PlayEventSubscriber$PlayEvent;", "cloneSceneResult", "Lcom/tencent/mm/plugin/finder/video/reporter/FinderVideoPlayReporter$ReportSceneResult;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "cloneTaskInfo", "Lcom/tencent/mm/plugin/finder/video/reporter/FinderVideoPlayReporter$ReportTaskInfo;", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "onDownloadFinish", "onDownloadProgress", "onDownloadStart", "onDownloadStop", "onFirstFrameUpdate", "onFirstVideoFrameRendered", "onMoovReady", "onPause", "onPlayError", "onPlayProgress", "onPlayerConfig", "onRelease", "onReplay", "onResume", "onSeek", "onStartPlay", "onStopPlay", "onTabChange", "onUserClickPause", "onWaiting", "onWaitingEnd", "report17000", "report19059", "reportIdkey", "struct", "Lcom/tencent/mm/autogen/mmdata/rpt/FinderVideoPlayStruct;", "Companion", "ReportData", "ReportSceneResult", "ReportTaskInfo", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final a Gtw;
  public bui Auc;
  public int Fla;
  private final int GtA;
  public ConcurrentLinkedDeque<b> Gtx;
  public ConcurrentHashMap<Long, b> Gty;
  public com.tencent.mm.plugin.finder.video.statistics.a Gtz;
  
  static
  {
    AppMethodBeat.i(335179);
    Gtw = new a((byte)0);
    AppMethodBeat.o(335179);
  }
  
  public c(bui parambui)
  {
    AppMethodBeat.i(335134);
    this.Auc = parambui;
    this.Gtx = new ConcurrentLinkedDeque();
    this.Gty = new ConcurrentHashMap();
    this.Gtz = new com.tencent.mm.plugin.finder.video.statistics.a("Finder.Stat.FirstFrame");
    this.GtA = 1505;
    AppMethodBeat.o(335134);
  }
  
  public static String a(String paramString, b paramb)
  {
    AppMethodBeat.i(335143);
    paramString = paramString + " feedId:" + com.tencent.mm.ae.d.hF(paramb.Eac) + " mediaId:" + paramb.GtB + " position:" + paramb.GtH + " bgPreparedStatus:" + paramb.ANM;
    AppMethodBeat.o(335143);
    return paramString;
  }
  
  public static c b(com.tencent.mm.g.d paramd)
  {
    AppMethodBeat.i(335172);
    s.u(paramd, "sceneResult");
    String str = paramd.mediaId;
    Object localObject = str;
    if (str == null) {
      localObject = "";
    }
    localObject = new c((String)localObject);
    ((c)localObject).retCode = paramd.field_retCode;
    ((c)localObject).fileLength = paramd.field_fileLength;
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
    str = paramd.aLH();
    if (str != null) {
      ((c)localObject).aCu(str);
    }
    str = paramd.field_clientIP;
    if (str != null) {
      ((c)localObject).aCv(str);
    }
    ((c)localObject).Guw = paramd.field_isCrossNet;
    ((c)localObject).transportProtocol = paramd.transportProtocol;
    ((c)localObject).transportProtocolError = paramd.transportProtocolError;
    str = paramd.lwz;
    if (str != null) {
      ((c)localObject).aCw(str);
    }
    ((c)localObject).Guy = paramd.lastSvrPort;
    ((c)localObject).netType = paramd.lastNetType;
    ((c)localObject).traceId = paramd.traceId;
    str = paramd.field_videoCdnMsg;
    s.s(str, "sceneResult.field_videoCdnMsg");
    ((c)localObject).aCx(str);
    str = paramd.field_videoFlag;
    s.s(str, "sceneResult.field_videoFlag");
    ((c)localObject).aCy(str);
    if (paramd.svrFallbackCount > 0) {}
    for (int i = 1;; i = 0)
    {
      ((c)localObject).Guz = i;
      str = paramd.profile;
      s.s(str, "sceneResult.profile");
      ((c)localObject).aCz(n.m(str, ",", ";", false));
      ((c)localObject).waitResponseCostTime = paramd.field_waitResponseCostTime;
      ((c)localObject).GuA = paramd.transportProtocol;
      ((c)localObject).receiveCostTime = paramd.field_receiveCostTime;
      Log.d("13570", "trace id  " + (((c)localObject).traceId & 0xFFFFFFFF) + " videoflag " + ((c)localObject).videoCdnMsg + ' ' + ((c)localObject).videoFlag + ' ' + ((c)localObject).Guz);
      AppMethodBeat.o(335172);
      return localObject;
    }
  }
  
  private static d f(com.tencent.mm.g.h paramh)
  {
    AppMethodBeat.i(335158);
    s.u(paramh, "cloneTaskInfo");
    Object localObject2 = paramh.field_mediaId;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    localObject1 = new d((String)localObject1);
    localObject2 = av.GiL;
    localObject2 = paramh.videoFlag;
    s.s(localObject2, "cloneTaskInfo.videoFlag");
    ((d)localObject1).requestVideoFormat = av.aBQ((String)localObject2);
    localObject2 = paramh.videoFlag;
    s.s(localObject2, "cloneTaskInfo.videoFlag");
    ((d)localObject1).aCA((String)localObject2);
    ((d)localObject1).lxo = paramh.lxo;
    AppMethodBeat.o(335158);
    return localObject1;
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(335250);
    if (paramb == null) {}
    for (Object localObject1 = null;; localObject1 = String.valueOf(a("report19059", paramb)))
    {
      Log.i("Finder.FinderVideoPlayReporter", (String)localObject1);
      if (paramb == null) {
        break label3898;
      }
      if (paramb.Eac != 0L) {
        break;
      }
      AppMethodBeat.o(335250);
      return;
    }
    x localx = paramb.GtE;
    hb localhb;
    long l1;
    label396:
    label756:
    label764:
    int i;
    label772:
    Object localObject2;
    if (localx != null)
    {
      localhb = new hb();
      localhb.iLU = 0L;
      localhb.ikG = localhb.F("MediaId", localx.aUt(), true);
      localhb.ipV = this.Auc.AJo;
      localhb.iCW = localx.eCF().videoDuration;
      localhb.iLV = paramb.Ftc;
      localhb.iLW = paramb.GtK;
      localhb.iLX = paramb.GtL;
      localhb.iIE = localx.eCF().fileSize;
      localObject1 = e.FNF;
      localObject1 = e.aAN(localx.aUt());
      if (localObject1 != null)
      {
        localhb.iIE = ((az)localObject1).field_totalSize;
        localObject1 = ah.aiuX;
        localObject1 = ah.aiuX;
      }
      localhb.iLY = paramb.GtJ;
      localhb.iLZ = paramb.Ggs;
      localhb.iMa = paramb.GtM;
      long l2;
      if (this.Auc.GSX)
      {
        localObject1 = z.FrZ;
        localObject1 = z.pH(paramb.Eac);
        if (localObject1 == null)
        {
          l1 = 0L;
          localhb.iMb = paramb.GtN;
          localhb.iMc = paramb.GtO;
          localhb.iMd = paramb.tpS;
          localhb.ijV = localhb.F("NetType", paramb.GtP, true);
          localhb.ijk = localhb.F("SessionId", paramb.sessionId, true);
          localhb.iMe = paramb.GtH;
          localhb.iMf = 0L;
          localhb.iMg = paramb.sIA;
          localhb.iMh = paramb.GtR;
          localhb.iMi = paramb.AVo;
          if (!BuildInfo.DEBUG) {
            break label756;
          }
          l2 = 0L;
          localhb.iwf = l2;
          localhb.iMj = paramb.oYt;
          localhb.iMk = paramb.GtT;
          localhb.iMl = paramb.GtU;
          localhb.iMm = paramb.Fta;
          localhb.iMn = paramb.Fqp;
          localhb.iMo = localhb.F("NewFeedId", com.tencent.mm.ae.d.hF(l1), true);
          localhb.iMp = paramb.GtW;
          localhb.iMq = paramb.GtZ;
          if (this.Auc.GSX) {
            localhb.izY = localhb.F("LongVideoId", com.tencent.mm.ae.d.hF(paramb.Eac), true);
          }
          localObject1 = paramb.Guc;
          if (localObject1 != null)
          {
            localhb.iMt = ((c)localObject1).averageSpeed;
            localhb.iMw = ((c)localObject1).averageConnectCost;
            localhb.iMx = localhb.F("SvrIp", ((c)localObject1).Gux, true);
            localhb.iMy = ((c)localObject1).Guy;
            localhb.ipK = ((c)localObject1).retCode;
            localhb.iMU = ((c)localObject1).traceId;
            localhb.iMV = localhb.F("VideoCdnMsg", ((c)localObject1).videoCdnMsg, true);
            localhb.iMX = localhb.F("NetConnInfo", ((c)localObject1).profile, true);
            localhb.iMW = ((c)localObject1).waitResponseCostTime;
            localhb.iNb = ((c)localObject1).GuA;
            localObject1 = ah.aiuX;
            localObject1 = ah.aiuX;
          }
          localhb.iMJ = paramb.GtY;
          localhb.iMI = paramb.Guo;
          if (paramb.Fti == paramb.Ftj) {
            break label764;
          }
        }
      }
      for (paramb.Guh = 1;; paramb.Guh = 0)
      {
        localObject1 = MMApplicationContext.getContext().getSystemService("audio");
        if (localObject1 != null) {
          break label772;
        }
        paramb = new NullPointerException("null cannot be cast to non-null type android.media.AudioManager");
        AppMethodBeat.o(335250);
        throw paramb;
        l1 = ((ca)localObject1).bZA();
        break;
        l1 = paramb.Eac;
        break;
        l2 = 62L;
        break label396;
      }
      i = ((AudioManager)localObject1).getStreamMaxVolume(3);
      localhb.iMD = localhb.F("VoiceInfo", paramb.Fti * 100 / i + ';' + paramb.Ftj * 100 / i + ';' + paramb.Guh, true);
      localObject1 = new JSONArray();
      localObject2 = f.Gog;
      localObject2 = ((Iterable)f.fiS()).iterator();
      Object localObject4;
      while (((Iterator)localObject2).hasNext())
      {
        awn localawn = (awn)((Iterator)localObject2).next();
        try
        {
          localObject4 = new JSONObject();
          ((JSONObject)localObject4).put("pos", localawn.GtH);
          ((JSONObject)localObject4).put("spe", localawn.ZHu);
          ((JSONObject)localObject4).put("loadCost", localawn.ZHw);
          ((JSONObject)localObject4).put("fSize", localawn.ZHr);
          ((JSONArray)localObject1).put(localObject4);
        }
        catch (Exception localException1) {}
      }
      localObject1 = ((JSONArray)localObject1).toString();
      s.s(localObject1, "historyInfoArray.toString()");
      localhb.iMr = localhb.F("HistoryPlayInfo", n.bV((String)localObject1, ",", ";"), true);
      localhb.iMs = paramb.Gua;
      localhb.iMu = paramb.GtQ;
      localhb.iMv = paramb.Gue;
      label1304:
      label1501:
      label1510:
      Object localObject3;
      if (((com.tencent.mm.plugin.thumbplayer.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.thumbplayer.a.a.class)).isOpenTPPlayer())
      {
        l1 = 1L;
        localhb.iMB = l1;
        localhb.iME = paramb.Ftf;
        localhb.iMF = paramb.Fte;
        localhb.iMG = localhb.F("PlayFormat", paramb.Gul + ';' + paramb.Guj + ';' + paramb.Gui + ';' + paramb.Guk + ';' + paramb.frameRate + ';' + paramb.Gum + ';' + paramb.Gun + ';', true);
        localObject2 = this.Auc.zIO;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localhb.ipT = localhb.F("ContextId", (String)localObject1, true);
        localObject2 = this.Auc.zIB;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localhb.ipU = localhb.F("ClickTabContextId", (String)localObject1, true);
        if (this.Auc.GSX) {
          break label2306;
        }
        localObject1 = z.FrZ;
        localObject1 = z.p(paramb.Eac, this.Auc.AJo);
        localhb.iqp = localhb.F("SessionBuffer", (String)localObject1, true);
        localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
        localhb.iMH = ((Number)com.tencent.mm.plugin.finder.storage.d.eRj().bsC).intValue();
        localhb.iMA = localhb.F("PreloadStrategyId", String.valueOf(paramb.GtG), true);
        localhb.iMK = paramb.Guj;
        localhb.iML = localhb.F("PlayCodeFormat", paramb.Gul, true);
        localhb.iMM = localhb.F("PlayFileFormat", paramb.Gui, true);
        localhb.iMN = paramb.Guk;
        localhb.iMO = paramb.frameRate;
        localhb.iMP = ((int)(paramb.Gum * paramb.Gun));
        localhb.iMZ = this.Fla;
        localhb.iAa = localhb.F("jump_id", this.Auc.DUN, true);
        localObject1 = z.FrZ;
        localObject1 = z.q(paramb.Eac, this.Auc.AJo);
        if (localObject1 != null) {
          break label2330;
        }
        localObject1 = null;
        if (localObject1 != null) {
          break label2340;
        }
        localObject1 = "";
        localhb.iAb = localhb.F("client_udf_kv", (String)localObject1, true);
        localObject3 = new JSONObject();
        ((JSONObject)localObject3).put("videoWidth", Float.valueOf(paramb.Gum));
        ((JSONObject)localObject3).put("videoHeight", Float.valueOf(paramb.Gun));
        ((JSONObject)localObject3).put("screenWidth", MMApplicationContext.getContext().getResources().getDisplayMetrics().widthPixels);
        ((JSONObject)localObject3).put("screenHeight", MMApplicationContext.getContext().getResources().getDisplayMetrics().heightPixels);
        localObject4 = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getMediaPreloadModel();
        ((JSONObject)localObject3).put("isMultiBitRate", ((b)localObject4).EVA);
        ((JSONObject)localObject3).put("isSecondPre", ((b)localObject4).EVB);
        ((JSONObject)localObject3).put("playLinkCnt", ((b)localObject4).EVp);
        ((JSONObject)localObject3).put("preLinkCnt", ((b)localObject4).EVo);
        ((JSONObject)localObject3).put("startPrePercent", ((b)localObject4).EVq);
        ((JSONObject)localObject3).put("startPreSec", ((b)localObject4).EVr);
        ((JSONObject)localObject3).put("preTaskCnt", ((b)localObject4).EVn);
        ((JSONObject)localObject3).put("maxPrePercent", ((b)localObject4).EVl);
        ((JSONObject)localObject3).put("maxPreBytes", ((b)localObject4).EVm);
        ((JSONObject)localObject3).put("prevCnt", ((b)localObject4).EVj);
        ((JSONObject)localObject3).put("nextCnt", ((b)localObject4).EVk);
        ((JSONObject)localObject3).put("maxPreBitRate", ((b)localObject4).EVs);
        localObject1 = (u)((b)localObject4).EVz.get(localhb.ikG);
        if (localObject1 != null) {
          break label2388;
        }
        localObject1 = "";
        label1818:
        ((JSONObject)localObject3).put("findSpecStep", localObject1);
        ((JSONObject)localObject3).put("megaVideoMaxBitrate", ((b)localObject4).EVu);
        ((JSONObject)localObject3).put("megaVideoPrevCount", ((b)localObject4).EVv);
        ((JSONObject)localObject3).put("megaVideoNextCount", ((b)localObject4).EVw);
        ((JSONObject)localObject3).put("hitPreloadBitrate", paramb.Guu);
        ((JSONObject)localObject3).put("playDecoderType", paramb.playDecoderType);
        ((JSONObject)localObject3).put("emcru", paramb.Gup);
        ((JSONObject)localObject3).put("mce", paramb.Guq);
        ((JSONObject)localObject3).put("mcru", paramb.Gur);
        ((JSONObject)localObject3).put("mcec", paramb.Gus);
        ((JSONObject)localObject3).put("mcid", paramb.Gut);
        ((JSONObject)localObject3).put("fvfrd", paramb.FpZ);
        ((JSONObject)localObject3).put("mpnn", paramb.GtC);
        ((JSONObject)localObject3).put("mpdp", paramb.GtD);
        localObject1 = paramb.ANP;
        if (localObject1 != null)
        {
          ((d)localObject1).a((JSONObject)localObject3, localhb);
          localObject1 = ah.aiuX;
        }
        localObject1 = ah.aiuX;
        localObject1 = ((JSONObject)localObject3).toString();
        s.s(localObject1, "JSONObject().apply {\n   …             }.toString()");
        localhb.iMQ = localhb.F("PlayFormatJson", n.bV((String)localObject1, ",", ";"), true);
        localObject1 = this.Auc.extraInfo;
        if (localObject1 != null) {
          break label2414;
        }
        localObject1 = "";
        label2089:
        localhb.iwJ = localhb.F("ExtraInfo", (String)localObject1, true);
        localObject1 = this.Auc.zIE;
        if (localObject1 != null) {
          break label2443;
        }
        localObject1 = "";
        label2123:
        localhb.iwK = localhb.F("enterSourceInfo", (String)localObject1, true);
        if (this.Auc.GSX) {
          break label2496;
        }
        localObject1 = z.FrZ;
        localObject1 = z.jm(paramb.Eac);
        if (localObject1 != null) {
          break label2472;
        }
        localObject1 = null;
        label2171:
        if (localObject1 == null)
        {
          localhb.rp("");
          localObject1 = ah.aiuX;
        }
      }
      label2306:
      label2330:
      label2340:
      label2388:
      label2414:
      do
      {
        localObject1 = new JSONArray();
        localObject2 = ((Iterable)paramb.Guf).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (bza)((Iterator)localObject2).next();
          try
          {
            localObject4 = new JSONObject();
            ((JSONObject)localObject4).put("waitMs", ((bza)localObject3).aaic);
            ((JSONObject)localObject4).put("percent", ((bza)localObject3).percent);
            ((JSONObject)localObject4).put("type", ((bza)localObject3).type);
            ((JSONArray)localObject1).put(localObject4);
          }
          catch (Exception localException2) {}
        }
        l1 = 0L;
        break;
        localObject1 = z.FrZ;
        localObject1 = z.p(paramb.Eac, this.Auc.AJo);
        break label1304;
        localObject1 = ((bd)localObject1).FuM;
        break label1501;
        localObject1 = ((bra)localObject1).ZZe;
        if (localObject1 == null)
        {
          localObject1 = "";
          break label1510;
        }
        localObject2 = n.bV((String)localObject1, ",", ";");
        localObject1 = localObject2;
        if (localObject2 != null) {
          break label1510;
        }
        localObject1 = "";
        break label1510;
        localObject2 = (String)((u)localObject1).bsD;
        localObject1 = localObject2;
        if (localObject2 != null) {
          break label1818;
        }
        localObject1 = "";
        break label1818;
        localObject2 = n.bV((String)localObject1, ",", ";");
        localObject1 = localObject2;
        if (localObject2 != null) {
          break label2089;
        }
        localObject1 = "";
        break label2089;
        localObject2 = n.bV((String)localObject1, ",", ";");
        localObject1 = localObject2;
        if (localObject2 != null) {
          break label2123;
        }
        localObject1 = "";
        break label2123;
        localhb.rp(((FinderItem)localObject1).getUserName());
        localObject1 = ah.aiuX;
        localObject1 = ah.aiuX;
        break label2171;
        localObject1 = z.FrZ;
        localObject1 = z.pH(paramb.Eac);
      } while (localObject1 == null);
      label2443:
      label2472:
      label2496:
      localObject1 = ((ca)localObject1).contact;
      if (localObject1 == null) {
        localObject1 = "";
      }
      for (;;)
      {
        localhb.rp((String)localObject1);
        localObject1 = ah.aiuX;
        localObject1 = ah.aiuX;
        break;
        localObject2 = ((FinderContact)localObject1).username;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
      }
      localObject1 = ((JSONArray)localObject1).toString();
      s.s(localObject1, "waitingDetails.toString()");
      localhb.iMz = localhb.F("WaitingDetails", n.bV((String)localObject1, ",", ";"), true);
      localObject1 = "";
      localObject2 = ((Iterable)paramb.Gug).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        i = ((Number)((Iterator)localObject2).next()).intValue();
        localObject1 = (String)localObject1 + i + ';';
      }
      localhb.iMC = localhb.F("PlayProgressInfo", (String)localObject1, true);
      localObject1 = o.TZr;
      localhb.iNe = localhb.F("hdrInfo", o.hQC(), true);
      localhb.gNE();
      localObject1 = new ArrayList(8);
      if (localhb.iMv > 0L)
      {
        localObject2 = new IDKey();
        ((IDKey)localObject2).SetID(this.GtA);
        ((IDKey)localObject2).SetKey(0);
        ((IDKey)localObject2).SetValue(localhb.iMv);
        ((ArrayList)localObject1).add(localObject2);
      }
      if ((localhb.iMh > 0L) && (localhb.iMv > 0L))
      {
        localObject2 = new IDKey();
        ((IDKey)localObject2).SetID(this.GtA);
        ((IDKey)localObject2).SetKey(1);
        ((IDKey)localObject2).SetValue(localhb.iMv);
        ((ArrayList)localObject1).add(localObject2);
      }
      if ((localhb.iMh > 0L) && (localhb.iLW > 0L))
      {
        localObject2 = new IDKey();
        ((IDKey)localObject2).SetID(this.GtA);
        ((IDKey)localObject2).SetKey(2);
        ((IDKey)localObject2).SetValue(1L);
        ((ArrayList)localObject1).add(localObject2);
      }
      if ((localhb.iMh > 0L) && (localhb.iMn > 0L))
      {
        localObject2 = new IDKey();
        ((IDKey)localObject2).SetID(this.GtA);
        ((IDKey)localObject2).SetKey(3);
        ((IDKey)localObject2).SetValue(localhb.iMn);
        ((ArrayList)localObject1).add(localObject2);
        if (localhb.iMn > 500L) {
          break label3905;
        }
        localObject2 = new IDKey();
        ((IDKey)localObject2).SetID(this.GtA);
        ((IDKey)localObject2).SetKey(5);
        ((IDKey)localObject2).SetValue(1L);
        ((ArrayList)localObject1).add(localObject2);
      }
      if ((localhb.iMh > 0L) && (localhb.iMJ > 0L))
      {
        localObject2 = new IDKey();
        ((IDKey)localObject2).SetID(this.GtA);
        ((IDKey)localObject2).SetKey(4);
        ((IDKey)localObject2).SetValue(localhb.iMJ);
        ((ArrayList)localObject1).add(localObject2);
      }
      if (localhb.iMB == 1L)
      {
        localObject2 = new IDKey();
        ((IDKey)localObject2).SetID(this.GtA);
        ((IDKey)localObject2).SetValue(1L);
        if (paramb.playDecoderType != 102) {
          break label4013;
        }
        ((IDKey)localObject2).SetKey(104);
        ((ArrayList)localObject1).add(localObject2);
      }
      label3145:
      localObject2 = new IDKey();
      ((IDKey)localObject2).SetID(this.GtA);
      ((IDKey)localObject2).SetKey(100);
      ((IDKey)localObject2).SetValue(1L);
      ((ArrayList)localObject1).add(localObject2);
      if (localhb.iMh > 0L)
      {
        localObject2 = new IDKey();
        ((IDKey)localObject2).SetID(this.GtA);
        ((IDKey)localObject2).SetKey(101);
        ((IDKey)localObject2).SetValue(1L);
        ((ArrayList)localObject1).add(localObject2);
      }
      if ((localhb.iMh > 0L) && (localhb.iMn > 0L))
      {
        localObject2 = new IDKey();
        ((IDKey)localObject2).SetID(this.GtA);
        ((IDKey)localObject2).SetKey(102);
        ((IDKey)localObject2).SetValue(1L);
        ((ArrayList)localObject1).add(localObject2);
      }
      if ((localhb.iMh > 0L) && (localhb.iMJ > 0L))
      {
        localObject2 = new IDKey();
        ((IDKey)localObject2).SetID(this.GtA);
        ((IDKey)localObject2).SetKey(103);
        ((IDKey)localObject2).SetValue(1L);
        ((ArrayList)localObject1).add(localObject2);
      }
      if (((Collection)localObject1).isEmpty()) {
        break label4040;
      }
      i = 1;
      label3366:
      if (i != 0) {
        com.tencent.mm.plugin.report.service.h.OAn.b((ArrayList)localObject1, false);
      }
      localObject1 = z.FrZ;
      z.a((com.tencent.mm.plugin.report.a)localhb);
      localObject1 = paramb.Guc;
      if (localObject1 != null)
      {
        localObject2 = new awn();
        ((awn)localObject2).feedId = paramb.Eac;
        ((awn)localObject2).ZHp = 0;
        ((awn)localObject2).ZHu = ((int)localhb.iMt);
        ((awn)localObject2).ZHw = ((int)localhb.iMn);
        ((awn)localObject2).ZHr = ((int)localhb.iIE);
        ((awn)localObject2).ZHq = kotlin.h.a.eH((float)(localhb.iIE * localhb.iLX) / 100.0F);
        ((awn)localObject2).sDa = kotlin.h.a.eH((float)(localhb.iMg * localhb.iIE) / 100.0F);
        ((awn)localObject2).scene = this.Auc.AJo;
        ((awn)localObject2).duration = localx.eCF().videoDuration;
        ((awn)localObject2).GtH = ((int)localhb.iMe);
        ((awn)localObject2).ZHv = cn.getSyncServerTimeSecond();
        ((awn)localObject2).ZHs = ((int)paramb.Ftc);
        ((awn)localObject2).ZHt = ((int)paramb.GtY);
        ((awn)localObject2).Guf = paramb.Guf;
        ((awn)localObject2).hVy = paramb.Gui;
        ((awn)localObject2).ZHx = ((c)localObject1).averageConnectCost;
        ((awn)localObject2).Gux = ((c)localObject1).Gux;
        ((awn)localObject2).Guy = ((c)localObject1).Guy;
        ((awn)localObject2).networkId = ((c)localObject1).netType;
        ((awn)localObject2).GtG = paramb.GtG;
        if (!this.Auc.GSX) {
          break label4045;
        }
        l1 = paramb.Eac;
        label3656:
        ((awn)localObject2).ZHy = l1;
        ((awn)localObject2).ZHz = paramb.AVo;
        paramb = new akz();
        paramb.Zsi = ((c)localObject1).recvedBytes;
        paramb.Rsc = ((c)localObject1).startTime;
        paramb.wwF = ((c)localObject1).endTime;
        paramb.Zsl = ((c)localObject1).Gux;
        paramb.Zsk = ((c)localObject1).clientIP;
        paramb.Zoz = ((c)localObject1).netType;
        paramb.mNd = 0;
        paramb.Zsj = ((c)localObject1).receiveCostTime;
        localObject1 = ah.aiuX;
        ((awn)localObject2).ZHA = paramb;
        paramb = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getMediaPreloadModel();
        localObject1 = (u)paramb.EVz.get(localhb.ikG);
        if (localObject1 != null) {
          break label4050;
        }
        i = 0;
        label3796:
        ((awn)localObject2).ZHB = i;
        paramb = (u)paramb.EVz.get(localhb.ikG);
        if (paramb != null) {
          break label4080;
        }
        paramb = "";
      }
    }
    for (;;)
    {
      ((awn)localObject2).ZHC = paramb;
      paramb = ah.aiuX;
      paramb = f.Gog;
      f.a((awn)localObject2);
      paramb = f.Gog;
      f.b((awn)localObject2);
      paramb = f.Gog;
      Log.i("Finder.FinderVideoPlayReporter", s.X("downloadInfoList ", Integer.valueOf(f.fiS().size())));
      paramb = ah.aiuX;
      paramb = ah.aiuX;
      paramb = ah.aiuX;
      paramb = ah.aiuX;
      paramb = ah.aiuX;
      label3898:
      AppMethodBeat.o(335250);
      return;
      label3905:
      if (localhb.iMn <= 1000L)
      {
        localObject2 = new IDKey();
        ((IDKey)localObject2).SetID(this.GtA);
        ((IDKey)localObject2).SetKey(6);
        ((IDKey)localObject2).SetValue(1L);
        ((ArrayList)localObject1).add(localObject2);
        break;
      }
      if (localhb.iMn <= 1000L) {
        break;
      }
      localObject2 = new IDKey();
      ((IDKey)localObject2).SetID(this.GtA);
      ((IDKey)localObject2).SetKey(7);
      ((IDKey)localObject2).SetValue(1L);
      ((ArrayList)localObject1).add(localObject2);
      break;
      label4013:
      if (paramb.playDecoderType != 101) {
        break label3145;
      }
      ((IDKey)localObject2).SetKey(105);
      ((ArrayList)localObject1).add(localObject2);
      break label3145;
      label4040:
      i = 0;
      break label3366;
      label4045:
      l1 = 0L;
      break label3656;
      label4050:
      localObject1 = (Long)((u)localObject1).aiuN;
      if (localObject1 == null)
      {
        i = 0;
        break label3796;
      }
      i = (int)((Long)localObject1).longValue();
      break label3796;
      label4080:
      paramb = (boz)paramb.bsC;
      if (paramb == null)
      {
        paramb = "";
      }
      else
      {
        localObject1 = paramb.hVy;
        paramb = (b)localObject1;
        if (localObject1 == null) {
          paramb = "";
        }
      }
    }
  }
  
  public final void b(b paramb)
  {
    AppMethodBeat.i(335267);
    Object localObject;
    ru localru;
    label97:
    long l1;
    if (paramb == null)
    {
      localObject = null;
      Log.i("Finder.FinderVideoPlayReporter", (String)localObject);
      if (paramb != null)
      {
        localObject = av.GiL;
        dji localdji = paramb.GtF;
        d locald = paramb.Gub;
        c localc = paramb.Guc;
        localObject = aw.Gjk;
        if ((localdji != null) && (locald != null) && (localc != null))
        {
          localru = new ru();
          localObject = e.FNF;
          localObject = paramb.GtE;
          if (localObject != null) {
            break label702;
          }
          localObject = "";
          localObject = e.aAN((String)localObject);
          long l2 = kotlin.h.a.ai((float)(paramb.GtL * ((az)localObject).field_totalSize) / 100.0F);
          localObject = localru.ys(com.tencent.mm.ae.d.hF(paramb.Eac));
          ((ru)localObject).jwd = (this.Auc.AJo + 100);
          ((ru)localObject).jwe = paramb.GtR;
          if (paramb.GtH != 0) {
            break label727;
          }
          l1 = 1L;
          label175:
          ((ru)localObject).jwf = l1;
          ((ru)localObject).irv = localdji.videoDuration;
          ((ru)localObject).jwg = kotlin.h.a.ai(localdji.videoDuration * paramb.Ggs / 100.0F);
          ((ru)localObject).iYV = paramb.Fqp;
          ((ru)localObject).iYW = paramb.GtN;
          ((ru)localObject).iRU = paramb.Gue;
          ((ru)localObject).jwh = 0L;
          ((ru)localObject).iZq = 0L;
          ((ru)localObject).jwi = localc.retCode;
          localObject = ((ru)localObject).yt("");
          ((ru)localObject).irw = paramb.Guj;
          localObject = ((ru)localObject).yu(String.valueOf(locald.requestVideoFormat)).yx(locald.requestVideoFlag);
          ((ru)localObject).iIE = localc.fileLength;
          ((ru)localObject).jwl = localc.recvedBytes;
          ((ru)localObject).iYZ = localc.startTime;
          ((ru)localObject).iZa = localc.endTime;
          ((ru)localObject).jwm = localc.retCode;
          ((ru)localObject).jwn = localc.enQueueTime;
          ((ru)localObject).jwo = localc.moovRequestTimes;
          ((ru)localObject).jwp = localc.moovCost;
          ((ru)localObject).iZn = localc.moovSize;
          if (!localc.moovCompleted) {
            break label732;
          }
          l1 = 1L;
          label412:
          ((ru)localObject).jwq = l1;
          ((ru)localObject).jwr = localc.moovFailReason;
          ((ru)localObject).jws = localc.firstConnectCost;
          ((ru)localObject).jwt = localc.firstRequestCost;
          ((ru)localObject).jwu = localc.firstRequestSize;
          ((ru)localObject).jwv = localc.firstRequestDownloadSize;
          if (!localc.firstRequestCompleted) {
            break label737;
          }
          l1 = 1L;
          label483:
          ((ru)localObject).jww = l1;
          ((ru)localObject).jwx = localc.averageSpeed;
          ((ru)localObject).jwy = localc.averageConnectCost;
          ((ru)localObject).iZk = localc.netConnectTimes;
          localObject = ((ru)localObject).yv(localc.Guv).yw(localc.clientIP);
          if (!localc.Guw) {
            break label742;
          }
          l1 = 1L;
          label552:
          ((ru)localObject).jwA = l1;
          ((ru)localObject).iZy = locald.lxo;
          ((ru)localObject).jwB = 0L;
          ((ru)localObject).itb = paramb.GtQ;
          ((ru)localObject).jwC = paramb.tpS;
          ((ru)localObject).irD = l2;
          ((ru)localObject).jwD = 0L;
          ((ru)localObject).iZz = localc.transportProtocol;
          ((ru)localObject).iZA = localc.transportProtocolError;
          if (!BuildInfo.DEBUG) {
            break label747;
          }
          l1 = 0L;
          label633:
          ((ru)localObject).iwf = l1;
          ((ru)localObject).iZB = localc.traceId;
          if (paramb.GtW != 0) {
            break label754;
          }
        }
      }
    }
    label702:
    label727:
    label732:
    label737:
    label742:
    label747:
    label754:
    for (localru.iRV = 0L;; localru.iRV = (paramb.GtY / paramb.GtW))
    {
      localru.bMH();
      paramb = z.FrZ;
      z.a((com.tencent.mm.plugin.report.a)localru);
      AppMethodBeat.o(335267);
      return;
      localObject = String.valueOf(a("report17000", paramb));
      break;
      String str = ((x)localObject).aUt();
      localObject = str;
      if (str != null) {
        break label97;
      }
      localObject = "";
      break label97;
      l1 = 0L;
      break label175;
      l1 = 0L;
      break label412;
      l1 = 0L;
      break label483;
      l1 = 0L;
      break label552;
      l1 = 62L;
      break label633;
    }
  }
  
  public final void c(com.tencent.mm.plugin.finder.event.c.a parama)
  {
    AppMethodBeat.i(335193);
    s.u(parama, "event");
    Object localObject1 = (b)this.Gty.get(Long.valueOf(parama.feedId));
    if ((localObject1 != null) && (((b)localObject1).Gud))
    {
      localObject2 = parama.oYO;
      if ((localObject2 != null) && (((b)localObject1).Gub == null)) {
        ((b)localObject1).Gub = f((com.tencent.mm.g.h)localObject2);
      }
      localObject2 = parama.mxU;
      if ((localObject2 != null) && (((b)localObject1).Guc == null)) {
        ((b)localObject1).Guc = b((com.tencent.mm.g.d)localObject2);
      }
      ((b)localObject1).Gud = false;
      Log.i("Finder.FinderVideoPlayReporter", String.valueOf(a("onDownloadStop", (b)localObject1)));
    }
    localObject1 = (Iterable)this.Gtx;
    Object localObject2 = (Collection)new ArrayList();
    Object localObject3 = ((Iterable)localObject1).iterator();
    Object localObject4;
    label199:
    label237:
    label240:
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = ((Iterator)localObject3).next();
      localObject1 = (b)localObject4;
      if (((b)localObject1).Eac == parama.feedId)
      {
        String str = ((b)localObject1).GtB;
        localObject1 = parama.ANK;
        if (localObject1 == null)
        {
          localObject1 = null;
          if (!s.p(str, localObject1)) {
            break label237;
          }
        }
      }
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label240;
        }
        ((Collection)localObject2).add(localObject4);
        break;
        localObject1 = ((x)localObject1).aUt();
        break label199;
      }
    }
    localObject2 = (Iterable)localObject2;
    localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (b)((Iterator)localObject2).next();
      localObject4 = parama.oYO;
      if ((localObject4 != null) && (((b)localObject3).Gub == null)) {
        ((b)localObject3).Gub = f((com.tencent.mm.g.h)localObject4);
      }
      localObject4 = parama.mxU;
      if ((localObject4 != null) && (((b)localObject3).Guc == null)) {
        ((b)localObject3).Guc = b((com.tencent.mm.g.d)localObject4);
      }
      ((Collection)localObject1).add(localObject3);
    }
    parama = (List)localObject1;
    this.Gtx.removeAll((Collection)parama);
    Log.i("Finder.FinderVideoPlayReporter", "lazyReportDataList " + this.Gtx.size() + " reportList " + parama.size());
    parama = ((Iterable)parama).iterator();
    while (parama.hasNext())
    {
      localObject1 = (b)parama.next();
      a((b)localObject1);
      b((b)localObject1);
    }
    AppMethodBeat.o(335193);
  }
  
  public final void f(bui parambui)
  {
    AppMethodBeat.i(335271);
    s.u(parambui, "contextObj");
    this.Auc = parambui;
    AppMethodBeat.o(335271);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/video/reporter/FinderVideoPlayReporter$Companion;", "", "()V", "INNER_VERSION", "", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/video/reporter/FinderVideoPlayReporter$ReportData;", "", "()V", "adjustVolume", "", "getAdjustVolume", "()I", "setAdjustVolume", "(I)V", "bgPreparedStatus", "getBgPreparedStatus", "setBgPreparedStatus", "currentFeedId", "", "getCurrentFeedId", "()J", "setCurrentFeedId", "(J)V", "currentMedia", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "getCurrentMedia", "()Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "setCurrentMedia", "(Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;)V", "currentMediaDescription", "", "getCurrentMediaDescription", "()Ljava/lang/String;", "setCurrentMediaDescription", "(Ljava/lang/String;)V", "currentMediaId", "getCurrentMediaId", "setCurrentMediaId", "currentMediaPosterNickName", "getCurrentMediaPosterNickName", "setCurrentMediaPosterNickName", "currentVideo", "Lcom/tencent/mm/plugin/finder/loader/IFinderMediaLoaderData;", "getCurrentVideo", "()Lcom/tencent/mm/plugin/finder/loader/IFinderMediaLoaderData;", "setCurrentVideo", "(Lcom/tencent/mm/plugin/finder/loader/IFinderMediaLoaderData;)V", "currentWaiting", "", "getCurrentWaiting", "()Z", "setCurrentWaiting", "(Z)V", "downloadFinishTime", "getDownloadFinishTime", "setDownloadFinishTime", "downloadPercent", "getDownloadPercent", "setDownloadPercent", "downloadSpeed", "getDownloadSpeed", "setDownloadSpeed", "enableMediaCodecReuse", "getEnableMediaCodecReuse", "setEnableMediaCodecReuse", "endVolume", "getEndVolume", "setEndVolume", "fetchTimestamp", "getFetchTimestamp", "setFetchTimestamp", "firstFrameTime", "getFirstFrameTime", "setFirstFrameTime", "firstLoadTime", "getFirstLoadTime", "setFirstLoadTime", "firstPlay", "getFirstPlay", "setFirstPlay", "firstRequestDataOffset", "getFirstRequestDataOffset", "setFirstRequestDataOffset", "firstVideoFrameRendered", "getFirstVideoFrameRendered", "setFirstVideoFrameRendered", "frameRate", "getFrameRate", "setFrameRate", "hitPreload", "getHitPreload", "setHitPreload", "hitPreloadBitrate", "getHitPreloadBitrate", "setHitPreloadBitrate", "hitPreloadPercent", "getHitPreloadPercent", "setHitPreloadPercent", "isPause", "setPause", "isSeek", "setSeek", "isStartDownload", "setStartDownload", "mediaCodecErrorCode", "getMediaCodecErrorCode", "setMediaCodecErrorCode", "mediaCodecInitDuration", "getMediaCodecInitDuration", "setMediaCodecInitDuration", "mediaCodecReuseEnabled", "getMediaCodecReuseEnabled", "setMediaCodecReuseEnabled", "mediaCodecReused", "getMediaCodecReused", "setMediaCodecReused", "mediaPath", "getMediaPath", "setMediaPath", "moovReadyOffset", "getMoovReadyOffset", "setMoovReadyOffset", "moovReadyTime", "getMoovReadyTime", "setMoovReadyTime", "netType", "getNetType", "setNetType", "netTypeInt", "getNetTypeInt", "setNetTypeInt", "onStopPlayData", "Lcom/tencent/mm/plugin/finder/video/reporter/OnStopPlayData;", "getOnStopPlayData", "()Lcom/tencent/mm/plugin/finder/video/reporter/OnStopPlayData;", "setOnStopPlayData", "(Lcom/tencent/mm/plugin/finder/video/reporter/OnStopPlayData;)V", "pauseTimestamp", "getPauseTimestamp", "setPauseTimestamp", "pauseTotalTime", "getPauseTotalTime", "setPauseTotalTime", "playAudioBitrate", "getPlayAudioBitrate", "setPlayAudioBitrate", "playCodeFormat", "getPlayCodeFormat", "setPlayCodeFormat", "playDecoderType", "getPlayDecoderType", "setPlayDecoderType", "playFileFormat", "getPlayFileFormat", "setPlayFileFormat", "playPageIndex", "getPlayPageIndex", "setPlayPageIndex", "playPercent", "getPlayPercent", "setPlayPercent", "playPercentSet", "Ljava/util/HashSet;", "getPlayPercentSet", "()Ljava/util/HashSet;", "setPlayPercentSet", "(Ljava/util/HashSet;)V", "playPosition", "getPlayPosition", "setPlayPosition", "playStatus", "getPlayStatus", "setPlayStatus", "playTime", "getPlayTime", "setPlayTime", "playVideoBitrate", "getPlayVideoBitrate", "setPlayVideoBitrate", "playWaitingCount", "getPlayWaitingCount", "setPlayWaitingCount", "playerErrCode", "getPlayerErrCode", "setPlayerErrCode", "playing", "getPlaying", "setPlaying", "preloadStrategyId", "getPreloadStrategyId", "setPreloadStrategyId", "realPlayTime", "getRealPlayTime", "setRealPlayTime", "realPlayTimestamp", "getRealPlayTimestamp", "setRealPlayTimestamp", "replayCount", "getReplayCount", "setReplayCount", "reportSceneResult", "Lcom/tencent/mm/plugin/finder/video/reporter/FinderVideoPlayReporter$ReportSceneResult;", "getReportSceneResult", "()Lcom/tencent/mm/plugin/finder/video/reporter/FinderVideoPlayReporter$ReportSceneResult;", "setReportSceneResult", "(Lcom/tencent/mm/plugin/finder/video/reporter/FinderVideoPlayReporter$ReportSceneResult;)V", "reportTaskInfo", "Lcom/tencent/mm/plugin/finder/video/reporter/FinderVideoPlayReporter$ReportTaskInfo;", "getReportTaskInfo", "()Lcom/tencent/mm/plugin/finder/video/reporter/FinderVideoPlayReporter$ReportTaskInfo;", "setReportTaskInfo", "(Lcom/tencent/mm/plugin/finder/video/reporter/FinderVideoPlayReporter$ReportTaskInfo;)V", "sessionId", "getSessionId", "setSessionId", "startTimestamp", "getStartTimestamp", "setStartTimestamp", "startVolume", "getStartVolume", "setStartVolume", "startWaitingTime", "getStartWaitingTime", "setStartWaitingTime", "totalWaitingTime", "getTotalWaitingTime", "setTotalWaitingTime", "videoHeight", "", "getVideoHeight", "()F", "setVideoHeight", "(F)V", "videoWidth", "getVideoWidth", "setVideoWidth", "waitDetails", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderWaitDetail;", "getWaitDetails", "()Ljava/util/LinkedList;", "setWaitDetails", "(Ljava/util/LinkedList;)V", "waitingCount", "getWaitingCount", "setWaitingCount", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    public int ANM;
    public d ANP;
    public int AVo;
    public long Eac;
    public long FpZ;
    public long Fqp;
    public long Fta;
    public long Ftb;
    public long Ftc;
    public int Fte;
    public int Ftf;
    public int Fti;
    public int Ftj;
    public int Ggs;
    public String GtB;
    public String GtC;
    public String GtD;
    public x GtE;
    public dji GtF;
    public long GtG;
    public int GtH;
    public int GtI;
    public long GtJ;
    public int GtK;
    public int GtL;
    public long GtM;
    public long GtN;
    public long GtO;
    public String GtP;
    public long GtQ;
    public int GtR;
    public boolean GtS;
    public int GtT;
    public long GtU;
    public long GtV;
    public int GtW;
    public long GtX;
    public long GtY;
    public long GtZ;
    public long Gua;
    c.d Gub;
    public c.c Guc;
    public boolean Gud;
    public long Gue;
    public LinkedList<bza> Guf;
    public HashSet<Integer> Gug;
    int Guh;
    String Gui;
    public int Guj;
    public int Guk;
    public String Gul;
    public float Gum;
    public float Gun;
    public int Guo;
    public int Gup;
    public int Guq;
    public int Gur;
    public String Gus;
    public int Gut;
    public int Guu;
    public boolean cJs;
    public int frameRate;
    public String mediaPath;
    public int oYt;
    public int playDecoderType;
    public int sIA;
    public String sessionId;
    public long tpS;
    
    public b()
    {
      AppMethodBeat.i(335181);
      this.sessionId = "";
      this.GtB = "";
      this.GtC = "";
      this.GtD = "";
      this.mediaPath = "";
      this.GtP = "";
      this.Guf = new LinkedList();
      this.Gug = new HashSet();
      this.Gui = "";
      this.Gul = "";
      this.Gup = -1;
      this.Guq = -1;
      this.Gur = -1;
      this.Gus = "0";
      this.Gut = -1;
      this.Guu = -1;
      AppMethodBeat.o(335181);
    }
    
    public final void aCt(String paramString)
    {
      AppMethodBeat.i(335191);
      s.u(paramString, "<set-?>");
      this.Gui = paramString;
      AppMethodBeat.o(335191);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/video/reporter/FinderVideoPlayReporter$ReportSceneResult;", "", "mediaId", "", "(Ljava/lang/String;)V", "averageConnectCost", "", "getAverageConnectCost", "()I", "setAverageConnectCost", "(I)V", "averageSpeed", "getAverageSpeed", "setAverageSpeed", "backSrcFlag", "getBackSrcFlag", "setBackSrcFlag", "clientIP", "getClientIP", "()Ljava/lang/String;", "setClientIP", "enQueueTime", "", "getEnQueueTime", "()J", "setEnQueueTime", "(J)V", "endTime", "getEndTime", "setEndTime", "fileLength", "getFileLength", "setFileLength", "firstConnectCost", "getFirstConnectCost", "setFirstConnectCost", "firstRequestCompleted", "", "getFirstRequestCompleted", "()Z", "setFirstRequestCompleted", "(Z)V", "firstRequestCost", "getFirstRequestCost", "setFirstRequestCost", "firstRequestDownloadSize", "getFirstRequestDownloadSize", "setFirstRequestDownloadSize", "firstRequestSize", "getFirstRequestSize", "setFirstRequestSize", "isCrossNet", "setCrossNet", "getMediaId", "moovCompleted", "getMoovCompleted", "setMoovCompleted", "moovCost", "getMoovCost", "setMoovCost", "moovFailReason", "getMoovFailReason", "setMoovFailReason", "moovRequestTimes", "getMoovRequestTimes", "setMoovRequestTimes", "moovSize", "getMoovSize", "setMoovSize", "netConnectTimes", "getNetConnectTimes", "setNetConnectTimes", "netType", "getNetType", "setNetType", "profile", "getProfile", "setProfile", "receiveCostTime", "getReceiveCostTime", "setReceiveCostTime", "recvedBytes", "getRecvedBytes", "setRecvedBytes", "retCode", "getRetCode", "setRetCode", "rptIpList", "getRptIpList", "setRptIpList", "startTime", "getStartTime", "setStartTime", "svrIp", "getSvrIp", "setSvrIp", "svrPort", "getSvrPort", "setSvrPort", "traceId", "getTraceId", "setTraceId", "transportProtocol", "getTransportProtocol", "setTransportProtocol", "transportProtocolError", "getTransportProtocolError", "setTransportProtocolError", "transport_protocol", "getTransport_protocol", "setTransport_protocol", "videoCdnMsg", "getVideoCdnMsg", "setVideoCdnMsg", "videoFlag", "getVideoFlag", "setVideoFlag", "waitResponseCostTime", "getWaitResponseCostTime", "setWaitResponseCostTime", "component1", "copy", "equals", "other", "hashCode", "toString", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
  {
    int GuA;
    String Guv;
    boolean Guw;
    String Gux;
    int Guy;
    int Guz;
    int averageConnectCost;
    int averageSpeed;
    String clientIP;
    long enQueueTime;
    long endTime;
    long fileLength;
    int firstConnectCost;
    boolean firstRequestCompleted;
    int firstRequestCost;
    int firstRequestDownloadSize;
    int firstRequestSize;
    private final String mediaId;
    boolean moovCompleted;
    int moovCost;
    int moovFailReason;
    int moovRequestTimes;
    int moovSize;
    int netConnectTimes;
    int netType;
    String profile;
    int receiveCostTime;
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
      AppMethodBeat.i(335119);
      this.mediaId = paramString;
      this.Guv = "";
      this.clientIP = "";
      this.Gux = "";
      this.videoCdnMsg = "";
      this.videoFlag = "";
      this.profile = "";
      this.GuA = -1;
      AppMethodBeat.o(335119);
    }
    
    public final void aCu(String paramString)
    {
      AppMethodBeat.i(335125);
      s.u(paramString, "<set-?>");
      this.Guv = paramString;
      AppMethodBeat.o(335125);
    }
    
    public final void aCv(String paramString)
    {
      AppMethodBeat.i(335131);
      s.u(paramString, "<set-?>");
      this.clientIP = paramString;
      AppMethodBeat.o(335131);
    }
    
    public final void aCw(String paramString)
    {
      AppMethodBeat.i(335137);
      s.u(paramString, "<set-?>");
      this.Gux = paramString;
      AppMethodBeat.o(335137);
    }
    
    public final void aCx(String paramString)
    {
      AppMethodBeat.i(335140);
      s.u(paramString, "<set-?>");
      this.videoCdnMsg = paramString;
      AppMethodBeat.o(335140);
    }
    
    public final void aCy(String paramString)
    {
      AppMethodBeat.i(335144);
      s.u(paramString, "<set-?>");
      this.videoFlag = paramString;
      AppMethodBeat.o(335144);
    }
    
    public final void aCz(String paramString)
    {
      AppMethodBeat.i(335151);
      s.u(paramString, "<set-?>");
      this.profile = paramString;
      AppMethodBeat.o(335151);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(335170);
      if (this == paramObject)
      {
        AppMethodBeat.o(335170);
        return true;
      }
      if (!(paramObject instanceof c))
      {
        AppMethodBeat.o(335170);
        return false;
      }
      paramObject = (c)paramObject;
      if (!s.p(this.mediaId, paramObject.mediaId))
      {
        AppMethodBeat.o(335170);
        return false;
      }
      AppMethodBeat.o(335170);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(335164);
      int i = this.mediaId.hashCode();
      AppMethodBeat.o(335164);
      return i;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(335160);
      String str = "ReportSceneResult(mediaId=" + this.mediaId + ')';
      AppMethodBeat.o(335160);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/video/reporter/FinderVideoPlayReporter$ReportTaskInfo;", "", "mediaId", "", "(Ljava/lang/String;)V", "getMediaId", "()Ljava/lang/String;", "moovPos", "", "getMoovPos", "()J", "setMoovPos", "(J)V", "requestVideoFlag", "getRequestVideoFlag", "setRequestVideoFlag", "requestVideoFormat", "", "getRequestVideoFormat", "()I", "setRequestVideoFormat", "(I)V", "component1", "copy", "equals", "", "other", "hashCode", "toString", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
  {
    long lxo;
    private final String mediaId;
    String requestVideoFlag;
    int requestVideoFormat;
    
    public d(String paramString)
    {
      AppMethodBeat.i(335106);
      this.mediaId = paramString;
      this.requestVideoFlag = "";
      AppMethodBeat.o(335106);
    }
    
    public final void aCA(String paramString)
    {
      AppMethodBeat.i(335111);
      s.u(paramString, "<set-?>");
      this.requestVideoFlag = paramString;
      AppMethodBeat.o(335111);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(335126);
      if (this == paramObject)
      {
        AppMethodBeat.o(335126);
        return true;
      }
      if (!(paramObject instanceof d))
      {
        AppMethodBeat.o(335126);
        return false;
      }
      paramObject = (d)paramObject;
      if (!s.p(this.mediaId, paramObject.mediaId))
      {
        AppMethodBeat.o(335126);
        return false;
      }
      AppMethodBeat.o(335126);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(335122);
      int i = this.mediaId.hashCode();
      AppMethodBeat.o(335122);
      return i;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(335115);
      String str = "ReportTaskInfo(mediaId=" + this.mediaId + ')';
      AppMethodBeat.o(335115);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.reporter.c
 * JD-Core Version:    0.7.0.1
 */