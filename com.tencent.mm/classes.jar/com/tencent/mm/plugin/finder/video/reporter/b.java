package com.tencent.mm.plugin.finder.video.reporter;

import android.content.Context;
import android.content.res.Resources;
import android.media.AudioManager;
import android.util.DisplayMetrics;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.en;
import com.tencent.mm.g.b.a.lg;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.event.c.a;
import com.tencent.mm.plugin.finder.loader.s;
import com.tencent.mm.plugin.finder.model.at;
import com.tencent.mm.plugin.finder.model.bm;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.aqj;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bek;
import com.tencent.mm.protocal.protobuf.cjl;
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
import kotlin.n.n;
import kotlin.o;
import kotlin.t;
import kotlin.x;
import org.json.JSONArray;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/video/reporter/FinderVideoPlayReporter;", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "IDKEY", "", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "setContextObj", "currentVideoReportMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/video/reporter/FinderVideoPlayReporter$ReportData;", "getCurrentVideoReportMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "setCurrentVideoReportMap", "(Ljava/util/concurrent/ConcurrentHashMap;)V", "firstFrameTimeConsumingStatistic", "Lcom/tencent/mm/plugin/finder/video/statistics/ConsumingStatistics;", "getFirstFrameTimeConsumingStatistic", "()Lcom/tencent/mm/plugin/finder/video/statistics/ConsumingStatistics;", "setFirstFrameTimeConsumingStatistic", "(Lcom/tencent/mm/plugin/finder/video/statistics/ConsumingStatistics;)V", "lazyReportDataList", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "getLazyReportDataList", "()Ljava/util/concurrent/ConcurrentLinkedDeque;", "setLazyReportDataList", "(Ljava/util/concurrent/ConcurrentLinkedDeque;)V", "baseInfoLog", "", "eventName", "reportData", "checkVideoDataAvailable", "", "event", "Lcom/tencent/mm/plugin/finder/event/PlayEventSubscriber$PlayEvent;", "cloneSceneResult", "Lcom/tencent/mm/plugin/finder/video/reporter/FinderVideoPlayReporter$ReportSceneResult;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "cloneTaskInfo", "Lcom/tencent/mm/plugin/finder/video/reporter/FinderVideoPlayReporter$ReportTaskInfo;", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "onDownloadFinish", "onDownloadProgress", "onDownloadStart", "onDownloadStop", "onFirstFrameUpdate", "onFirstVideoFrameRendered", "onMoovReady", "onPause", "onPlayError", "onPlayProgress", "onPlayerConfig", "onRelease", "onReplay", "onResume", "onSeek", "onStartPlay", "onStopPlay", "onTabChange", "onUserClickPause", "onWaiting", "onWaitingEnd", "report17000", "report19059", "reportIdkey", "struct", "Lcom/tencent/mm/autogen/mmdata/rpt/FinderVideoPlayStruct;", "Companion", "ReportData", "ReportSceneResult", "ReportTaskInfo", "plugin-finder_release"})
public final class b
{
  private static final LinkedList<aqj> whI;
  private static final LinkedList<aqj> whJ;
  public static final a whK;
  public bbn ttO;
  public ConcurrentLinkedDeque<b> whE;
  public ConcurrentHashMap<Long, b> whF;
  public com.tencent.mm.plugin.finder.video.statistics.a whG;
  private final int whH;
  
  static
  {
    AppMethodBeat.i(254543);
    whK = new a((byte)0);
    whI = new LinkedList();
    whJ = new LinkedList();
    AppMethodBeat.o(254543);
  }
  
  public b(bbn parambbn)
  {
    AppMethodBeat.i(254542);
    this.ttO = parambbn;
    this.whE = new ConcurrentLinkedDeque();
    this.whF = new ConcurrentHashMap();
    this.whG = new com.tencent.mm.plugin.finder.video.statistics.a("Finder.Stat.FirstFrame");
    this.whH = 1505;
    AppMethodBeat.o(254542);
  }
  
  public static String a(String paramString, b paramb)
  {
    AppMethodBeat.i(254535);
    paramString = paramString + " feedId:" + com.tencent.mm.ac.d.zs(paramb.whL) + " mediaId:" + paramb.whM + " position:" + paramb.whS + " bgPreparedStatus:" + paramb.tHQ;
    AppMethodBeat.o(254535);
    return paramString;
  }
  
  public static c b(com.tencent.mm.i.d paramd)
  {
    AppMethodBeat.i(254541);
    p.h(paramd, "sceneResult");
    String str = paramd.mediaId;
    Object localObject = str;
    if (str == null) {
      localObject = "";
    }
    localObject = new c((String)localObject);
    ((c)localObject).retCode = paramd.field_retCode;
    ((c)localObject).jPY = paramd.field_fileLength;
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
    str = paramd.alM();
    if (str != null) {
      ((c)localObject).awL(str);
    }
    str = paramd.field_clientIP;
    if (str != null) {
      ((c)localObject).awM(str);
    }
    ((c)localObject).wiJ = paramd.field_isCrossNet;
    ((c)localObject).transportProtocol = paramd.transportProtocol;
    ((c)localObject).transportProtocolError = paramd.transportProtocolError;
    str = paramd.gqm;
    if (str != null) {
      ((c)localObject).awN(str);
    }
    ((c)localObject).wiL = paramd.lastSvrPort;
    ((c)localObject).netType = paramd.lastNetType;
    ((c)localObject).traceId = paramd.traceId;
    AppMethodBeat.o(254541);
    return localObject;
  }
  
  private static d f(com.tencent.mm.i.h paramh)
  {
    AppMethodBeat.i(254540);
    p.h(paramh, "cloneTaskInfo");
    String str = paramh.field_mediaId;
    Object localObject = str;
    if (str == null) {
      localObject = "";
    }
    localObject = new d((String)localObject);
    ((d)localObject).requestVideoFormat = paramh.field_requestVideoFormat;
    ((d)localObject).gra = paramh.gra;
    AppMethodBeat.o(254540);
    return localObject;
  }
  
  public final void a(c.a parama)
  {
    AppMethodBeat.i(254536);
    p.h(parama, "event");
    Object localObject1 = (b)this.whF.get(Long.valueOf(parama.feedId));
    if ((localObject1 != null) && (((b)localObject1).wir))
    {
      localObject2 = parama.jqr;
      if ((localObject2 != null) && (((b)localObject1).wip == null)) {
        ((b)localObject1).wip = f((com.tencent.mm.i.h)localObject2);
      }
      localObject2 = parama.hmq;
      if ((localObject2 != null) && (((b)localObject1).wiq == null)) {
        ((b)localObject1).wiq = b((com.tencent.mm.i.d)localObject2);
      }
      ((b)localObject1).wir = false;
      p.g(localObject1, "this");
      Log.i("Finder.FinderVideoPlayReporter", String.valueOf(a("onDownloadStop", (b)localObject1)));
    }
    localObject1 = (Iterable)this.whE;
    Object localObject2 = (Collection)new ArrayList();
    Object localObject3 = ((Iterable)localObject1).iterator();
    Object localObject4;
    label209:
    label242:
    label245:
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = ((Iterator)localObject3).next();
      localObject1 = (b)localObject4;
      if (((b)localObject1).whL == parama.feedId)
      {
        String str = ((b)localObject1).whM;
        localObject1 = parama.tHN;
        if (localObject1 != null)
        {
          localObject1 = ((s)localObject1).auA();
          if (!p.j(str, localObject1)) {
            break label242;
          }
        }
      }
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label245;
        }
        ((Collection)localObject2).add(localObject4);
        break;
        localObject1 = null;
        break label209;
      }
    }
    localObject2 = (Iterable)localObject2;
    localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (b)((Iterator)localObject2).next();
      localObject4 = parama.jqr;
      if ((localObject4 != null) && (((b)localObject3).wip == null)) {
        ((b)localObject3).wip = f((com.tencent.mm.i.h)localObject4);
      }
      localObject4 = parama.hmq;
      if ((localObject4 != null) && (((b)localObject3).wiq == null)) {
        ((b)localObject3).wiq = b((com.tencent.mm.i.d)localObject4);
      }
      ((Collection)localObject1).add(localObject3);
    }
    parama = (List)localObject1;
    this.whE.removeAll((Collection)parama);
    Log.i("Finder.FinderVideoPlayReporter", "lazyReportDataList " + this.whE.size() + " reportList " + parama.size());
    parama = ((Iterable)parama).iterator();
    while (parama.hasNext())
    {
      localObject1 = (b)parama.next();
      a((b)localObject1);
      b((b)localObject1);
    }
    AppMethodBeat.o(254536);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(254537);
    if (paramb != null) {}
    for (Object localObject1 = String.valueOf(a("report19059", paramb));; localObject1 = null)
    {
      Log.i("Finder.FinderVideoPlayReporter", (String)localObject1);
      if (paramb == null) {
        break label3415;
      }
      if (paramb.whL != 0L) {
        break;
      }
      AppMethodBeat.o(254537);
      return;
    }
    s locals = paramb.whP;
    en localen;
    label280:
    label363:
    label625:
    label633:
    Object localObject2;
    if (locals != null)
    {
      localen = new en();
      localen.afI();
      localen.rp(locals.auA());
      localen.mN(this.ttO.tCE);
      localen.mj(locals.uIw.videoDuration);
      localen.mk(paramb.vgo);
      localen.ml(paramb.whW);
      localen.mm(paramb.whX);
      localen.mn(locals.uIw.fileSize);
      localObject1 = com.tencent.mm.plugin.finder.storage.logic.d.vGR;
      long l1;
      long l2;
      if (locals != null)
      {
        localObject1 = locals.auA();
        localObject1 = com.tencent.mm.plugin.finder.storage.logic.d.avH((String)localObject1);
        if (localObject1 != null)
        {
          localen.mn(((at)localObject1).field_totalSize);
          localObject1 = x.SXb;
        }
        localen.mo(paramb.whU);
        localen.mp(paramb.whV);
        localen.mq(paramb.whY);
        if (!this.ttO.wzb) {
          break label609;
        }
        localObject1 = k.vfA;
        localObject1 = k.Fd(paramb.whL);
        if (localObject1 == null) {
          break label604;
        }
        l1 = ((bm)localObject1).lT();
        localObject1 = localen.mr(paramb.whZ).ms(paramb.wia).mt(paramb.njx).rq(paramb.wib).rr(paramb.sessionId).mu(paramb.whS).afL().mv(paramb.mEd).mw(paramb.wid).mx(paramb.wie);
        if (!BuildInfo.DEBUG) {
          break label617;
        }
        l2 = 0L;
        ((en)localObject1).my(l2).mz(paramb.jpW).mA(paramb.wig).mB(paramb.wih).mC(paramb.vgm).mD(paramb.wij).rs(com.tencent.mm.ac.d.zs(l1)).mE(paramb.wik).mF(paramb.win);
        if (this.ttO.wzb) {
          localen.rJ(com.tencent.mm.ac.d.zs(paramb.whL));
        }
        localObject1 = paramb.wiq;
        if (localObject1 != null)
        {
          localen.mH(((c)localObject1).averageSpeed);
          localen.mK(((c)localObject1).averageConnectCost);
          localen.ru(((c)localObject1).wiK);
          localen.mL(((c)localObject1).wiL);
          localen.lf(((c)localObject1).retCode);
          localObject1 = x.SXb;
        }
        localen.mR(paramb.wim);
        localen.lg(paramb.wiC);
        if (paramb.vgu == paramb.vgv) {
          break label625;
        }
      }
      for (paramb.wiv = 1;; paramb.wiv = 0)
      {
        localObject1 = MMApplicationContext.getContext().getSystemService("audio");
        if (localObject1 != null) {
          break label633;
        }
        paramb = new t("null cannot be cast to non-null type android.media.AudioManager");
        AppMethodBeat.o(254537);
        throw paramb;
        localObject1 = null;
        break;
        label604:
        l1 = 0L;
        break label280;
        label609:
        l1 = paramb.whL;
        break label280;
        label617:
        l2 = 59L;
        break label363;
      }
      i = ((AudioManager)localObject1).getStreamMaxVolume(3);
      localen.rz(paramb.vgu * 100 / i + ';' + paramb.vgv * 100 / i + ';' + paramb.wiv);
      localObject1 = new JSONArray();
      localObject2 = ((Iterable)whI).iterator();
      Object localObject4;
      while (((Iterator)localObject2).hasNext())
      {
        aqj localaqj = (aqj)((Iterator)localObject2).next();
        try
        {
          localObject4 = new JSONObject();
          ((JSONObject)localObject4).put("pos", localaqj.whS);
          ((JSONObject)localObject4).put("spe", localaqj.LCu);
          ((JSONObject)localObject4).put("loadCost", localaqj.LCw);
          ((JSONObject)localObject4).put("fSize", localaqj.LCr);
          ((JSONArray)localObject1).put(localObject4);
        }
        catch (Exception localException1) {}
      }
      localObject1 = ((JSONArray)localObject1).toString();
      p.g(localObject1, "historyInfoArray.toString()");
      localen.rt(n.j((String)localObject1, ",", ";", false));
      localen.mG(paramb.wio);
      localen.mI(paramb.wic);
      localen.mJ(paramb.wis);
      localObject1 = g.ah(com.tencent.mm.plugin.thumbplayer.a.a.class);
      p.g(localObject1, "MMKernel.plugin(IPluginThumbPlayer::class.java)");
      label1139:
      Object localObject3;
      if (((com.tencent.mm.plugin.thumbplayer.a.a)localObject1).isOpenTPPlayer())
      {
        l1 = 1L;
        localen.mM(l1);
        localen.mO(paramb.vgr);
        localen.mP(paramb.vgq);
        localen.rA(paramb.wiz + ';' + paramb.wix + ';' + paramb.wiw + ';' + paramb.wiy + ';' + paramb.frameRate + ';' + paramb.wiA + ';' + paramb.wiB + ';');
        localObject2 = this.ttO.sGQ;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localen.rC((String)localObject1);
        localObject2 = this.ttO.sGE;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localen.rB((String)localObject1);
        if (this.ttO.wzb) {
          break label2062;
        }
        localObject1 = k.vfA;
        localObject1 = k.G(paramb.whL, this.ttO.tCE);
        localen.rD((String)localObject1);
        localObject1 = c.vCb;
        localen.mQ(((Number)c.drF().first).intValue());
        localen.rx(String.valueOf(paramb.whR));
        localen.lh(paramb.wix);
        localen.rE(paramb.wiz);
        localen.rF(paramb.wiw);
        localen.li(paramb.wiy);
        localen.lj(paramb.frameRate);
        localen.lk((int)(paramb.wiA * paramb.wiB));
        localObject3 = new JSONObject();
        ((JSONObject)localObject3).put("videoWidth", Float.valueOf(paramb.wiA));
        ((JSONObject)localObject3).put("videoHeight", Float.valueOf(paramb.wiB));
        localObject1 = MMApplicationContext.getContext();
        p.g(localObject1, "MMApplicationContext.getContext()");
        localObject1 = ((Context)localObject1).getResources();
        p.g(localObject1, "MMApplicationContext.getContext().resources");
        ((JSONObject)localObject3).put("screenWidth", ((Resources)localObject1).getDisplayMetrics().widthPixels);
        localObject1 = MMApplicationContext.getContext();
        p.g(localObject1, "MMApplicationContext.getContext()");
        localObject1 = ((Context)localObject1).getResources();
        p.g(localObject1, "MMApplicationContext.getContext().resources");
        ((JSONObject)localObject3).put("screenHeight", ((Resources)localObject1).getDisplayMetrics().heightPixels);
        localObject4 = ((PluginFinder)g.ah(PluginFinder.class)).getMediaPreloadModel();
        ((JSONObject)localObject3).put("isMultiBitRate", ((com.tencent.mm.plugin.finder.preload.model.a)localObject4).uUD);
        ((JSONObject)localObject3).put("isSecondPre", ((com.tencent.mm.plugin.finder.preload.model.a)localObject4).uUE);
        ((JSONObject)localObject3).put("playLinkCnt", ((com.tencent.mm.plugin.finder.preload.model.a)localObject4).uUs);
        ((JSONObject)localObject3).put("preLinkCnt", ((com.tencent.mm.plugin.finder.preload.model.a)localObject4).uUr);
        ((JSONObject)localObject3).put("startPrePercent", ((com.tencent.mm.plugin.finder.preload.model.a)localObject4).uUt);
        ((JSONObject)localObject3).put("startPreSec", ((com.tencent.mm.plugin.finder.preload.model.a)localObject4).uUu);
        ((JSONObject)localObject3).put("preTaskCnt", ((com.tencent.mm.plugin.finder.preload.model.a)localObject4).uUq);
        ((JSONObject)localObject3).put("maxPrePercent", ((com.tencent.mm.plugin.finder.preload.model.a)localObject4).uUo);
        ((JSONObject)localObject3).put("maxPreBytes", ((com.tencent.mm.plugin.finder.preload.model.a)localObject4).uUp);
        ((JSONObject)localObject3).put("prevCnt", ((com.tencent.mm.plugin.finder.preload.model.a)localObject4).uUm);
        ((JSONObject)localObject3).put("nextCnt", ((com.tencent.mm.plugin.finder.preload.model.a)localObject4).uUn);
        ((JSONObject)localObject3).put("maxPreBitRate", ((com.tencent.mm.plugin.finder.preload.model.a)localObject4).uUv);
        localObject2 = (String)((com.tencent.mm.plugin.finder.preload.model.a)localObject4).uUC.get(localen.getMediaId());
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        ((JSONObject)localObject3).put("findSpecStep", localObject1);
        ((JSONObject)localObject3).put("megaVideoMaxBitrate", ((com.tencent.mm.plugin.finder.preload.model.a)localObject4).uUx);
        ((JSONObject)localObject3).put("megaVideoPrevCount", ((com.tencent.mm.plugin.finder.preload.model.a)localObject4).uUy);
        ((JSONObject)localObject3).put("megaVideoNextCount", ((com.tencent.mm.plugin.finder.preload.model.a)localObject4).uUz);
        ((JSONObject)localObject3).put("playDecoderType", paramb.playDecoderType);
        ((JSONObject)localObject3).put("emcru", paramb.wiD);
        ((JSONObject)localObject3).put("mce", paramb.wiE);
        ((JSONObject)localObject3).put("mcru", paramb.wiF);
        ((JSONObject)localObject3).put("mcec", paramb.wiG);
        ((JSONObject)localObject3).put("mcid", paramb.wiH);
        ((JSONObject)localObject3).put("fvfrd", paramb.veh);
        ((JSONObject)localObject3).put("mpnn", paramb.whN);
        ((JSONObject)localObject3).put("mpdp", paramb.whO);
        localObject1 = x.SXb;
        localObject1 = ((JSONObject)localObject3).toString();
        p.g(localObject1, "JSONObject().apply {\n   …             }.toString()");
        localen.rG(n.j((String)localObject1, ",", ";", false));
        localObject1 = this.ttO.extraInfo;
        if (localObject1 != null)
        {
          localObject2 = n.j((String)localObject1, ",", ";", false);
          localObject1 = localObject2;
          if (localObject2 != null) {}
        }
        else
        {
          localObject1 = "";
        }
        localen.rH((String)localObject1);
        localObject1 = this.ttO.sGH;
        if (localObject1 != null)
        {
          localObject2 = n.j((String)localObject1, ",", ";", false);
          localObject1 = localObject2;
          if (localObject2 != null) {}
        }
        else
        {
          localObject1 = "";
        }
        localen.rI((String)localObject1);
        if (this.ttO.wzb) {
          break label2102;
        }
        localObject1 = k.vfA;
        localObject1 = k.Fc(paramb.whL);
        if (localObject1 == null) {
          break label2086;
        }
        localen.rw(((FinderItem)localObject1).getUserName());
        localObject1 = x.SXb;
      }
      for (;;)
      {
        localObject1 = new JSONArray();
        localObject2 = ((Iterable)paramb.wit).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (bek)((Iterator)localObject2).next();
          try
          {
            localObject4 = new JSONObject();
            ((JSONObject)localObject4).put("waitMs", ((bek)localObject3).LOf);
            ((JSONObject)localObject4).put("percent", ((bek)localObject3).percent);
            ((JSONObject)localObject4).put("type", ((bek)localObject3).type);
            ((JSONArray)localObject1).put(localObject4);
          }
          catch (Exception localException2) {}
        }
        l1 = 0L;
        break;
        label2062:
        localObject1 = k.vfA;
        localObject1 = k.H(paramb.whL, this.ttO.tCE);
        break label1139;
        label2086:
        localen.rw("");
        localObject1 = x.SXb;
        continue;
        label2102:
        localObject1 = k.vfA;
        localObject1 = k.Fd(paramb.whL);
        if (localObject1 != null)
        {
          localObject1 = ((bm)localObject1).contact;
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
          localen.rw((String)localObject1);
          localObject1 = x.SXb;
        }
      }
      localObject1 = ((JSONArray)localObject1).toString();
      p.g(localObject1, "waitingDetails.toString()");
      localen.rv(n.j((String)localObject1, ",", ";", false));
      localObject1 = "";
      localObject2 = ((Iterable)paramb.wiu).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        i = ((Number)((Iterator)localObject2).next()).intValue();
        localObject1 = (String)localObject1 + i + ';';
      }
      localen.ry((String)localObject1);
      localen.eOp();
      localObject1 = new ArrayList(8);
      if (localen.afQ() > 0L)
      {
        localObject2 = new IDKey();
        ((IDKey)localObject2).SetID(this.whH);
        ((IDKey)localObject2).SetKey(0);
        ((IDKey)localObject2).SetValue(localen.afQ());
        ((ArrayList)localObject1).add(localObject2);
      }
      if ((localen.afN() > 0L) && (localen.afQ() > 0L))
      {
        localObject2 = new IDKey();
        ((IDKey)localObject2).SetID(this.whH);
        ((IDKey)localObject2).SetKey(1);
        ((IDKey)localObject2).SetValue(localen.afQ());
        ((ArrayList)localObject1).add(localObject2);
      }
      if ((localen.afN() > 0L) && (localen.afJ() > 0L))
      {
        localObject2 = new IDKey();
        ((IDKey)localObject2).SetID(this.whH);
        ((IDKey)localObject2).SetKey(2);
        ((IDKey)localObject2).SetValue(1L);
        ((ArrayList)localObject1).add(localObject2);
      }
      if ((localen.afN() > 0L) && (localen.afO() > 0L))
      {
        localObject2 = new IDKey();
        ((IDKey)localObject2).SetID(this.whH);
        ((IDKey)localObject2).SetKey(3);
        ((IDKey)localObject2).SetValue(localen.afO());
        ((ArrayList)localObject1).add(localObject2);
        if (localen.afO() > 500L) {
          break label3275;
        }
        localObject2 = new IDKey();
        ((IDKey)localObject2).SetID(this.whH);
        ((IDKey)localObject2).SetKey(5);
        ((IDKey)localObject2).SetValue(1L);
        ((ArrayList)localObject1).add(localObject2);
      }
      if ((localen.afN() > 0L) && (localen.afS() > 0L))
      {
        localObject2 = new IDKey();
        ((IDKey)localObject2).SetID(this.whH);
        ((IDKey)localObject2).SetKey(4);
        ((IDKey)localObject2).SetValue(localen.afS());
        ((ArrayList)localObject1).add(localObject2);
      }
      if (localen.afR() == 1L)
      {
        localObject2 = new IDKey();
        ((IDKey)localObject2).SetID(this.whH);
        ((IDKey)localObject2).SetValue(1L);
        if (paramb.playDecoderType != 102) {
          break label3383;
        }
        ((IDKey)localObject2).SetKey(104);
        ((ArrayList)localObject1).add(localObject2);
      }
      label2702:
      localObject2 = new IDKey();
      ((IDKey)localObject2).SetID(this.whH);
      ((IDKey)localObject2).SetKey(100);
      ((IDKey)localObject2).SetValue(1L);
      ((ArrayList)localObject1).add(localObject2);
      if (localen.afN() > 0L)
      {
        localObject2 = new IDKey();
        ((IDKey)localObject2).SetID(this.whH);
        ((IDKey)localObject2).SetKey(101);
        ((IDKey)localObject2).SetValue(1L);
        ((ArrayList)localObject1).add(localObject2);
      }
      if ((localen.afN() > 0L) && (localen.afO() > 0L))
      {
        localObject2 = new IDKey();
        ((IDKey)localObject2).SetID(this.whH);
        ((IDKey)localObject2).SetKey(102);
        ((IDKey)localObject2).SetValue(1L);
        ((ArrayList)localObject1).add(localObject2);
      }
      if ((localen.afN() > 0L) && (localen.afS() > 0L))
      {
        localObject2 = new IDKey();
        ((IDKey)localObject2).SetID(this.whH);
        ((IDKey)localObject2).SetKey(103);
        ((IDKey)localObject2).SetValue(1L);
        ((ArrayList)localObject1).add(localObject2);
      }
      if (((Collection)localObject1).isEmpty()) {
        break label3410;
      }
    }
    label3275:
    label3410:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        com.tencent.mm.plugin.report.service.h.CyF.b((ArrayList)localObject1, false);
      }
      localObject1 = k.vfA;
      k.a((com.tencent.mm.plugin.report.a)localen);
      localObject1 = paramb.wiq;
      if (localObject1 != null)
      {
        localObject2 = new aqj();
        ((aqj)localObject2).feedId = paramb.whL;
        ((aqj)localObject2).LCp = 0;
        ((aqj)localObject2).LCu = ((int)localen.afP());
        ((aqj)localObject2).LCw = ((int)localen.afO());
        ((aqj)localObject2).LCr = ((int)localen.getFileSize());
        ((aqj)localObject2).LCq = kotlin.h.a.cR((float)(localen.getFileSize() * localen.afK()) / 100.0F);
        ((aqj)localObject2).mzA = kotlin.h.a.cR((float)(localen.afM() * localen.getFileSize()) / 100.0F);
        ((aqj)localObject2).scene = this.ttO.tCE;
        ((aqj)localObject2).duration = locals.uIw.videoDuration;
        ((aqj)localObject2).whS = ((int)localen.getPosition());
        ((aqj)localObject2).LCv = cl.aWB();
        ((aqj)localObject2).LCs = ((int)paramb.vgo);
        ((aqj)localObject2).LCt = ((int)paramb.wim);
        ((aqj)localObject2).wit = paramb.wit;
        ((aqj)localObject2).dVY = paramb.wiw;
        ((aqj)localObject2).LCx = ((c)localObject1).averageConnectCost;
        ((aqj)localObject2).wiK = ((c)localObject1).wiK;
        ((aqj)localObject2).wiL = ((c)localObject1).wiL;
        ((aqj)localObject2).networkId = ((c)localObject1).netType;
        ((aqj)localObject2).whR = paramb.whR;
        if (whI.size() > 2) {
          whI.remove(0);
        }
        whI.add(localObject2);
        whJ.add(localObject2);
        Log.i("Finder.FinderVideoPlayReporter", "downloadInfoList " + whI.size());
        paramb = x.SXb;
      }
      paramb = x.SXb;
      AppMethodBeat.o(254537);
      return;
      if (localen.afO() <= 1000L)
      {
        localObject2 = new IDKey();
        ((IDKey)localObject2).SetID(this.whH);
        ((IDKey)localObject2).SetKey(6);
        ((IDKey)localObject2).SetValue(1L);
        ((ArrayList)localObject1).add(localObject2);
        break;
      }
      if (localen.afO() <= 1000L) {
        break;
      }
      localObject2 = new IDKey();
      ((IDKey)localObject2).SetID(this.whH);
      ((IDKey)localObject2).SetKey(7);
      ((IDKey)localObject2).SetValue(1L);
      ((ArrayList)localObject1).add(localObject2);
      break;
      if (paramb.playDecoderType != 101) {
        break label2702;
      }
      ((IDKey)localObject2).SetKey(105);
      ((ArrayList)localObject1).add(localObject2);
      break label2702;
    }
    label3383:
    label3415:
    AppMethodBeat.o(254537);
  }
  
  public final void b(b paramb)
  {
    AppMethodBeat.i(254538);
    Object localObject;
    lg locallg;
    long l1;
    if (paramb != null)
    {
      localObject = String.valueOf(a("report17000", paramb));
      Log.i("Finder.FinderVideoPlayReporter", (String)localObject);
      if (paramb == null) {
        break label673;
      }
      localObject = y.vXH;
      cjl localcjl = paramb.whQ;
      d locald = paramb.wip;
      c localc = paramb.wiq;
      if ((localcjl != null) && (locald != null) && (localc != null))
      {
        locallg = new lg();
        localObject = com.tencent.mm.plugin.finder.storage.logic.d.vGR;
        localObject = paramb.whP;
        if (localObject != null)
        {
          String str = ((s)localObject).auA();
          localObject = str;
          if (str != null) {}
        }
        else
        {
          localObject = "";
        }
        localObject = com.tencent.mm.plugin.finder.storage.logic.d.avH((String)localObject);
        long l2 = kotlin.h.a.L((float)(paramb.whX * ((at)localObject).field_totalSize) / 100.0F);
        localObject = locallg.ys(com.tencent.mm.ac.d.zs(paramb.whL)).tZ(this.ttO.tCE + 100).ua(paramb.wid);
        if (paramb.whS != 0) {
          break label627;
        }
        l1 = 1L;
        label191:
        localObject = ((lg)localObject).ub(l1).uc(localcjl.videoDuration).ud(kotlin.h.a.L(localcjl.videoDuration * paramb.whV / 100.0F)).ue(paramb.wij).uf(paramb.whZ).ug(paramb.wis).aix().ui(0L).uj(localc.retCode).yt("").uk(paramb.wix).yu(String.valueOf(locald.requestVideoFormat)).ul(localc.jPY).um(localc.recvedBytes).un(localc.startTime).uo(localc.endTime).up(localc.retCode).uq(localc.enQueueTime).ur(localc.moovRequestTimes).us(localc.moovCost).ut(localc.moovSize);
        if (!localc.moovCompleted) {
          break label632;
        }
        l1 = 1L;
        label377:
        localObject = ((lg)localObject).uu(l1).uv(localc.moovFailReason).uw(localc.firstConnectCost).ux(localc.firstRequestCost).uy(localc.firstRequestSize).uz(localc.firstRequestDownloadSize);
        if (!localc.firstRequestCompleted) {
          break label637;
        }
        l1 = 1L;
        label440:
        localObject = ((lg)localObject).uA(l1).uB(localc.averageSpeed).uC(localc.averageConnectCost).uD(localc.netConnectTimes).yv(localc.wiI).yw(localc.clientIP);
        if (!localc.wiJ) {
          break label642;
        }
        l1 = 1L;
        label501:
        localObject = ((lg)localObject).uE(l1).uF(locald.gra).uG(0L).uH(paramb.wic).uI(paramb.njx).uJ(l2).aiz().lR(localc.transportProtocol).lS(localc.transportProtocolError);
        if (!BuildInfo.DEBUG) {
          break label647;
        }
        l1 = 0L;
        label567:
        ((lg)localObject).uK(l1).uL(localc.traceId);
        if (paramb.wik != 0) {
          break label654;
        }
        locallg.uh(0L);
      }
    }
    for (;;)
    {
      locallg.bfK();
      paramb = k.vfA;
      k.a((com.tencent.mm.plugin.report.a)locallg);
      AppMethodBeat.o(254538);
      return;
      localObject = null;
      break;
      label627:
      l1 = 0L;
      break label191;
      label632:
      l1 = 0L;
      break label377;
      label637:
      l1 = 0L;
      break label440;
      label642:
      l1 = 0L;
      break label501;
      label647:
      l1 = 59L;
      break label567;
      label654:
      locallg.uh(paramb.wim / paramb.wik);
    }
    label673:
    AppMethodBeat.o(254538);
  }
  
  public final void d(bbn parambbn)
  {
    AppMethodBeat.i(254539);
    p.h(parambbn, "contextObj");
    this.ttO = parambbn;
    AppMethodBeat.o(254539);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/video/reporter/FinderVideoPlayReporter$Companion;", "", "()V", "INNER_VERSION", "", "TAG", "", "downloadInfoAllList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderDownloadInfo;", "getDownloadInfoAllList", "()Ljava/util/LinkedList;", "downloadInfoList", "getDownloadInfoList", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/video/reporter/FinderVideoPlayReporter$ReportData;", "", "()V", "adjustVolume", "", "getAdjustVolume", "()I", "setAdjustVolume", "(I)V", "bgPreparedStatus", "getBgPreparedStatus", "setBgPreparedStatus", "currentFeedId", "", "getCurrentFeedId", "()J", "setCurrentFeedId", "(J)V", "currentMedia", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "getCurrentMedia", "()Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "setCurrentMedia", "(Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;)V", "currentMediaDescription", "", "getCurrentMediaDescription", "()Ljava/lang/String;", "setCurrentMediaDescription", "(Ljava/lang/String;)V", "currentMediaId", "getCurrentMediaId", "setCurrentMediaId", "currentMediaPosterNickName", "getCurrentMediaPosterNickName", "setCurrentMediaPosterNickName", "currentVideo", "Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "getCurrentVideo", "()Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "setCurrentVideo", "(Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;)V", "currentWaiting", "", "getCurrentWaiting", "()Z", "setCurrentWaiting", "(Z)V", "downloadFinishTime", "getDownloadFinishTime", "setDownloadFinishTime", "downloadPercent", "getDownloadPercent", "setDownloadPercent", "downloadSpeed", "getDownloadSpeed", "setDownloadSpeed", "enableMediaCodecReuse", "getEnableMediaCodecReuse", "setEnableMediaCodecReuse", "endVolume", "getEndVolume", "setEndVolume", "fetchTimestamp", "getFetchTimestamp", "setFetchTimestamp", "firstFrameTime", "getFirstFrameTime", "setFirstFrameTime", "firstLoadTime", "getFirstLoadTime", "setFirstLoadTime", "firstPlay", "getFirstPlay", "setFirstPlay", "firstRequestDataOffset", "getFirstRequestDataOffset", "setFirstRequestDataOffset", "firstVideoFrameRendered", "getFirstVideoFrameRendered", "setFirstVideoFrameRendered", "frameRate", "getFrameRate", "setFrameRate", "hitPreload", "getHitPreload", "setHitPreload", "hitPreloadPercent", "getHitPreloadPercent", "setHitPreloadPercent", "isPause", "setPause", "isSeek", "setSeek", "isStartDownload", "setStartDownload", "mediaCodecErrorCode", "getMediaCodecErrorCode", "setMediaCodecErrorCode", "mediaCodecInitDuration", "getMediaCodecInitDuration", "setMediaCodecInitDuration", "mediaCodecReuseEnabled", "getMediaCodecReuseEnabled", "setMediaCodecReuseEnabled", "mediaCodecReused", "getMediaCodecReused", "setMediaCodecReused", "mediaPath", "getMediaPath", "setMediaPath", "moovReadyOffset", "getMoovReadyOffset", "setMoovReadyOffset", "moovReadyTime", "getMoovReadyTime", "setMoovReadyTime", "netType", "getNetType", "setNetType", "netTypeInt", "getNetTypeInt", "setNetTypeInt", "pauseTimestamp", "getPauseTimestamp", "setPauseTimestamp", "pauseTotalTime", "getPauseTotalTime", "setPauseTotalTime", "playAudioBitrate", "getPlayAudioBitrate", "setPlayAudioBitrate", "playCodeFormat", "getPlayCodeFormat", "setPlayCodeFormat", "playDecoderType", "getPlayDecoderType", "setPlayDecoderType", "playFileFormat", "getPlayFileFormat", "setPlayFileFormat", "playPageIndex", "getPlayPageIndex", "setPlayPageIndex", "playPercent", "getPlayPercent", "setPlayPercent", "playPercentSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "getPlayPercentSet", "()Ljava/util/HashSet;", "setPlayPercentSet", "(Ljava/util/HashSet;)V", "playPosition", "getPlayPosition", "setPlayPosition", "playStatus", "getPlayStatus", "setPlayStatus", "playTime", "getPlayTime", "setPlayTime", "playVideoBitrate", "getPlayVideoBitrate", "setPlayVideoBitrate", "playWaitingCount", "getPlayWaitingCount", "setPlayWaitingCount", "playerErrCode", "getPlayerErrCode", "setPlayerErrCode", "playing", "getPlaying", "setPlaying", "preloadStrategyId", "getPreloadStrategyId", "setPreloadStrategyId", "realPlayTime", "getRealPlayTime", "setRealPlayTime", "realPlayTimestamp", "getRealPlayTimestamp", "setRealPlayTimestamp", "replayCount", "getReplayCount", "setReplayCount", "reportSceneResult", "Lcom/tencent/mm/plugin/finder/video/reporter/FinderVideoPlayReporter$ReportSceneResult;", "getReportSceneResult", "()Lcom/tencent/mm/plugin/finder/video/reporter/FinderVideoPlayReporter$ReportSceneResult;", "setReportSceneResult", "(Lcom/tencent/mm/plugin/finder/video/reporter/FinderVideoPlayReporter$ReportSceneResult;)V", "reportTaskInfo", "Lcom/tencent/mm/plugin/finder/video/reporter/FinderVideoPlayReporter$ReportTaskInfo;", "getReportTaskInfo", "()Lcom/tencent/mm/plugin/finder/video/reporter/FinderVideoPlayReporter$ReportTaskInfo;", "setReportTaskInfo", "(Lcom/tencent/mm/plugin/finder/video/reporter/FinderVideoPlayReporter$ReportTaskInfo;)V", "sessionId", "getSessionId", "setSessionId", "startTimestamp", "getStartTimestamp", "setStartTimestamp", "startVolume", "getStartVolume", "setStartVolume", "startWaitingTime", "getStartWaitingTime", "setStartWaitingTime", "totalWaitingTime", "getTotalWaitingTime", "setTotalWaitingTime", "videoHeight", "", "getVideoHeight", "()F", "setVideoHeight", "(F)V", "videoWidth", "getVideoWidth", "setVideoWidth", "waitDetails", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderWaitDetail;", "getWaitDetails", "()Ljava/util/LinkedList;", "setWaitDetails", "(Ljava/util/LinkedList;)V", "waitingCount", "getWaitingCount", "setWaitingCount", "plugin-finder_release"})
  public static final class b
  {
    public boolean bfW;
    public int frameRate;
    public int jpW;
    public int mEd;
    public String mediaPath;
    public long njx;
    public int playDecoderType;
    public String sessionId;
    public int tHQ;
    public long veh;
    public long vgm;
    public long vgn;
    public long vgo;
    public int vgq;
    public int vgr;
    public int vgu;
    public int vgv;
    public long whL;
    public String whM;
    public String whN;
    public String whO;
    public s whP;
    public cjl whQ;
    public long whR;
    public int whS;
    public int whT;
    public long whU;
    public int whV;
    public int whW;
    public int whX;
    public long whY;
    public long whZ;
    public float wiA;
    public float wiB;
    public int wiC;
    public int wiD;
    public int wiE;
    public int wiF;
    public String wiG;
    public int wiH;
    public long wia;
    public String wib;
    public long wic;
    public int wid;
    public int wie;
    public boolean wif;
    public int wig;
    public long wih;
    public long wii;
    public long wij;
    public int wik;
    public long wil;
    public long wim;
    public long win;
    public long wio;
    b.d wip;
    public b.c wiq;
    public boolean wir;
    public long wis;
    public LinkedList<bek> wit;
    public HashSet<Integer> wiu;
    int wiv;
    String wiw;
    public int wix;
    public int wiy;
    public String wiz;
    
    public b()
    {
      AppMethodBeat.i(254523);
      this.sessionId = "";
      this.whM = "";
      this.whN = "";
      this.whO = "";
      this.mediaPath = "";
      this.wib = "";
      this.wit = new LinkedList();
      this.wiu = new HashSet();
      this.wiw = "";
      this.wiz = "";
      this.wiD = -1;
      this.wiE = -1;
      this.wiF = -1;
      this.wiG = "0";
      this.wiH = -1;
      AppMethodBeat.o(254523);
    }
    
    public final void awK(String paramString)
    {
      AppMethodBeat.i(254522);
      p.h(paramString, "<set-?>");
      this.wiw = paramString;
      AppMethodBeat.o(254522);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/video/reporter/FinderVideoPlayReporter$ReportSceneResult;", "", "mediaId", "", "(Ljava/lang/String;)V", "averageConnectCost", "", "getAverageConnectCost", "()I", "setAverageConnectCost", "(I)V", "averageSpeed", "getAverageSpeed", "setAverageSpeed", "clientIP", "getClientIP", "()Ljava/lang/String;", "setClientIP", "enQueueTime", "", "getEnQueueTime", "()J", "setEnQueueTime", "(J)V", "endTime", "getEndTime", "setEndTime", "fileLength", "getFileLength", "setFileLength", "firstConnectCost", "getFirstConnectCost", "setFirstConnectCost", "firstRequestCompleted", "", "getFirstRequestCompleted", "()Z", "setFirstRequestCompleted", "(Z)V", "firstRequestCost", "getFirstRequestCost", "setFirstRequestCost", "firstRequestDownloadSize", "getFirstRequestDownloadSize", "setFirstRequestDownloadSize", "firstRequestSize", "getFirstRequestSize", "setFirstRequestSize", "isCrossNet", "setCrossNet", "getMediaId", "moovCompleted", "getMoovCompleted", "setMoovCompleted", "moovCost", "getMoovCost", "setMoovCost", "moovFailReason", "getMoovFailReason", "setMoovFailReason", "moovRequestTimes", "getMoovRequestTimes", "setMoovRequestTimes", "moovSize", "getMoovSize", "setMoovSize", "netConnectTimes", "getNetConnectTimes", "setNetConnectTimes", "netType", "getNetType", "setNetType", "recvedBytes", "getRecvedBytes", "setRecvedBytes", "retCode", "getRetCode", "setRetCode", "rptIpList", "getRptIpList", "setRptIpList", "startTime", "getStartTime", "setStartTime", "svrIp", "getSvrIp", "setSvrIp", "svrPort", "getSvrPort", "setSvrPort", "traceId", "getTraceId", "setTraceId", "transportProtocol", "getTransportProtocol", "setTransportProtocol", "transportProtocolError", "getTransportProtocolError", "setTransportProtocolError", "component1", "copy", "equals", "other", "hashCode", "toString", "plugin-finder_release"})
  public static final class c
  {
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
    long jPY;
    private final String mediaId;
    boolean moovCompleted;
    int moovCost;
    int moovFailReason;
    int moovRequestTimes;
    int moovSize;
    int netConnectTimes;
    int netType;
    long recvedBytes;
    int retCode;
    long startTime;
    long traceId;
    int transportProtocol;
    int transportProtocolError;
    String wiI;
    boolean wiJ;
    String wiK;
    int wiL;
    
    public c(String paramString)
    {
      AppMethodBeat.i(254527);
      this.mediaId = paramString;
      this.wiI = "";
      this.clientIP = "";
      this.wiK = "";
      AppMethodBeat.o(254527);
    }
    
    public final void awL(String paramString)
    {
      AppMethodBeat.i(254524);
      p.h(paramString, "<set-?>");
      this.wiI = paramString;
      AppMethodBeat.o(254524);
    }
    
    public final void awM(String paramString)
    {
      AppMethodBeat.i(254525);
      p.h(paramString, "<set-?>");
      this.clientIP = paramString;
      AppMethodBeat.o(254525);
    }
    
    public final void awN(String paramString)
    {
      AppMethodBeat.i(254526);
      p.h(paramString, "<set-?>");
      this.wiK = paramString;
      AppMethodBeat.o(254526);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(254530);
      if (this != paramObject)
      {
        if ((paramObject instanceof c))
        {
          paramObject = (c)paramObject;
          if (!p.j(this.mediaId, paramObject.mediaId)) {}
        }
      }
      else
      {
        AppMethodBeat.o(254530);
        return true;
      }
      AppMethodBeat.o(254530);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(254529);
      String str = this.mediaId;
      if (str != null)
      {
        int i = str.hashCode();
        AppMethodBeat.o(254529);
        return i;
      }
      AppMethodBeat.o(254529);
      return 0;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(254528);
      String str = "ReportSceneResult(mediaId=" + this.mediaId + ")";
      AppMethodBeat.o(254528);
      return str;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/video/reporter/FinderVideoPlayReporter$ReportTaskInfo;", "", "mediaId", "", "(Ljava/lang/String;)V", "getMediaId", "()Ljava/lang/String;", "moovPos", "", "getMoovPos", "()J", "setMoovPos", "(J)V", "requestVideoFormat", "", "getRequestVideoFormat", "()I", "setRequestVideoFormat", "(I)V", "component1", "copy", "equals", "", "other", "hashCode", "toString", "plugin-finder_release"})
  public static final class d
  {
    long gra;
    private final String mediaId;
    int requestVideoFormat;
    
    public d(String paramString)
    {
      AppMethodBeat.i(254531);
      this.mediaId = paramString;
      AppMethodBeat.o(254531);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(254534);
      if (this != paramObject)
      {
        if ((paramObject instanceof d))
        {
          paramObject = (d)paramObject;
          if (!p.j(this.mediaId, paramObject.mediaId)) {}
        }
      }
      else
      {
        AppMethodBeat.o(254534);
        return true;
      }
      AppMethodBeat.o(254534);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(254533);
      String str = this.mediaId;
      if (str != null)
      {
        int i = str.hashCode();
        AppMethodBeat.o(254533);
        return i;
      }
      AppMethodBeat.o(254533);
      return 0;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(254532);
      String str = "ReportTaskInfo(mediaId=" + this.mediaId + ")";
      AppMethodBeat.o(254532);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.reporter.b
 * JD-Core Version:    0.7.0.1
 */