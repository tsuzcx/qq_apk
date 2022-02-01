package com.tencent.mm.plugin.finder.report;

import android.content.Context;
import android.content.res.Resources;
import android.media.AudioManager;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.cc;
import com.tencent.mm.g.b.a.hn;
import com.tencent.mm.i.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cf;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.event.b.a;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.model.y;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.b;
import com.tencent.mm.protocal.protobuf.amk;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.protocal.protobuf.asv;
import com.tencent.mm.protocal.protobuf.bvf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.i;
import d.a.j;
import d.l;
import d.n.n;
import d.o;
import d.v;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;
import org.json.JSONArray;
import org.json.JSONObject;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/report/FinderVideoPlayReporter;", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "setContextObj", "currentVideoReportMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/finder/report/FinderVideoPlayReporter$ReportData;", "Lkotlin/collections/HashMap;", "getCurrentVideoReportMap", "()Ljava/util/HashMap;", "setCurrentVideoReportMap", "(Ljava/util/HashMap;)V", "lazyReportDataList", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "getLazyReportDataList", "()Ljava/util/concurrent/ConcurrentLinkedDeque;", "setLazyReportDataList", "(Ljava/util/concurrent/ConcurrentLinkedDeque;)V", "baseInfoLog", "", "eventName", "reportData", "checkVideoDataAvailable", "", "event", "Lcom/tencent/mm/plugin/finder/event/PlayEventSubscriber$PlayEvent;", "cloneSceneResult", "Lcom/tencent/mm/plugin/finder/report/FinderVideoPlayReporter$ReportSceneResult;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "cloneTaskInfo", "Lcom/tencent/mm/plugin/finder/report/FinderVideoPlayReporter$ReportTaskInfo;", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "onDownloadFinish", "onDownloadProgress", "onDownloadStart", "onDownloadStop", "onFirstFrameUpdate", "onMoovReady", "onPause", "onPlayError", "onPlayProgress", "onRelease", "onReplay", "onResume", "onSeek", "onStartPlay", "onStopPlay", "onTabChange", "onUserClickPause", "onWaiting", "onWaitingEnd", "report17000", "report19059", "Companion", "ReportData", "ReportSceneResult", "ReportTaskInfo", "plugin-finder_release"})
public final class r
{
  private static final LinkedList<amk> sqL;
  private static final LinkedList<amk> sqM;
  public static final a sqN;
  private aqy rIl;
  ConcurrentLinkedDeque<b> sqJ;
  HashMap<Long, b> sqK;
  
  static
  {
    AppMethodBeat.i(166706);
    sqN = new a((byte)0);
    sqL = new LinkedList();
    sqM = new LinkedList();
    AppMethodBeat.o(166706);
  }
  
  public r(aqy paramaqy)
  {
    AppMethodBeat.i(203378);
    this.rIl = paramaqy;
    this.sqJ = new ConcurrentLinkedDeque();
    this.sqK = new HashMap();
    AppMethodBeat.o(203378);
  }
  
  static String a(String paramString, b paramb)
  {
    AppMethodBeat.i(203373);
    paramString = paramString + " feedId:" + com.tencent.mm.ad.c.rc(paramb.sqO) + " mediaId:" + paramb.sqP + " position:" + paramb.sqT + " bgPreparedStatus:" + paramb.rQx;
    AppMethodBeat.o(203373);
    return paramString;
  }
  
  public static c b(d paramd)
  {
    AppMethodBeat.i(203377);
    d.g.b.p.h(paramd, "sceneResult");
    String str = paramd.mediaId;
    Object localObject = str;
    if (str == null) {
      localObject = "";
    }
    localObject = new c((String)localObject);
    ((c)localObject).retCode = paramd.field_retCode;
    ((c)localObject).iQl = paramd.field_fileLength;
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
    str = paramd.XP();
    if (str != null) {
      ((c)localObject).ahQ(str);
    }
    str = paramd.field_clientIP;
    if (str != null) {
      ((c)localObject).ahR(str);
    }
    ((c)localObject).srG = paramd.field_isCrossNet;
    ((c)localObject).transportProtocol = paramd.transportProtocol;
    ((c)localObject).transportProtocolError = paramd.transportProtocolError;
    str = paramd.fIV;
    if (str != null) {
      ((c)localObject).ahS(str);
    }
    ((c)localObject).srI = paramd.lastSvrPort;
    ((c)localObject).netType = paramd.lastNetType;
    AppMethodBeat.o(203377);
    return localObject;
  }
  
  private static d b(com.tencent.mm.i.h paramh)
  {
    AppMethodBeat.i(203376);
    d.g.b.p.h(paramh, "cloneTaskInfo");
    String str = paramh.field_mediaId;
    Object localObject = str;
    if (str == null) {
      localObject = "";
    }
    localObject = new d((String)localObject);
    ((d)localObject).requestVideoFormat = paramh.field_requestVideoFormat;
    ((d)localObject).fJL = paramh.fJL;
    AppMethodBeat.o(203376);
    return localObject;
  }
  
  public final void a(b.a parama)
  {
    AppMethodBeat.i(203374);
    d.g.b.p.h(parama, "event");
    Object localObject1 = (b)this.sqK.get(Long.valueOf(parama.dtq));
    if ((localObject1 != null) && (((b)localObject1).srt))
    {
      localObject2 = parama.isl;
      if ((localObject2 != null) && (((b)localObject1).srr == null)) {
        ((b)localObject1).srr = b((com.tencent.mm.i.h)localObject2);
      }
      localObject2 = parama.gwW;
      if ((localObject2 != null) && (((b)localObject1).srs == null)) {
        ((b)localObject1).srs = b((d)localObject2);
      }
      ((b)localObject1).srt = false;
      d.g.b.p.g(localObject1, "this");
      ad.i("Finder.FinderVideoPlayReporter", String.valueOf(a("onDownloadStop", (b)localObject1)));
    }
    localObject1 = (Iterable)this.sqJ;
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
      if (((b)localObject1).sqO == parama.dtq)
      {
        String str = ((b)localObject1).sqP;
        localObject1 = parama.rQu;
        if (localObject1 != null)
        {
          localObject1 = ((m)localObject1).aeA();
          if (!d.g.b.p.i(str, localObject1)) {
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
      localObject4 = parama.isl;
      if ((localObject4 != null) && (((b)localObject3).srr == null)) {
        ((b)localObject3).srr = b((com.tencent.mm.i.h)localObject4);
      }
      localObject4 = parama.gwW;
      if ((localObject4 != null) && (((b)localObject3).srs == null)) {
        ((b)localObject3).srs = b((d)localObject4);
      }
      ((Collection)localObject1).add(localObject3);
    }
    parama = (List)localObject1;
    this.sqJ.removeAll((Collection)parama);
    ad.i("Finder.FinderVideoPlayReporter", "lazyReportDataList " + this.sqJ.size() + " reportList " + parama.size());
    parama = ((Iterable)parama).iterator();
    while (parama.hasNext())
    {
      localObject1 = (b)parama.next();
      a((b)localObject1);
      b((b)localObject1);
    }
    AppMethodBeat.o(203374);
  }
  
  final void a(b paramb)
  {
    long l2 = 0L;
    AppMethodBeat.i(166703);
    if (paramb != null)
    {
      if (paramb.sqO == 0L)
      {
        AppMethodBeat.o(166703);
        return;
      }
      m localm = paramb.sqQ;
      if (localm != null)
      {
        cc localcc = new cc();
        localcc.SH();
        localcc.lm(localm.aeA());
        localcc.hM(this.rIl.rTD);
        localcc.hi(localm.siC.videoDuration);
        localcc.hj(paramb.spv);
        localcc.hk(paramb.sqX);
        localcc.hl(paramb.sqY);
        localcc.hm(localm.siC.fileSize);
        Object localObject1 = com.tencent.mm.plugin.finder.storage.logic.c.sAv;
        if (localm != null)
        {
          localObject1 = localm.aeA();
          localObject1 = com.tencent.mm.plugin.finder.storage.logic.c.aiD((String)localObject1);
          if (localObject1 != null)
          {
            localcc.hm(((y)localObject1).field_totalSize);
            localObject1 = z.MKo;
          }
          localcc.hn(paramb.sqV);
          localcc.ho(paramb.sqW);
          localcc.hp(paramb.sqZ);
          localObject1 = localcc.hq(paramb.sra).hr(paramb.srb).hs(paramb.lXf).ln(paramb.srd).lo(paramb.sessionId).ht(paramb.sqT).SJ().hu(paramb.lsH).hv(paramb.srf).hw(paramb.srg);
          if (!i.DEBUG) {
            break label520;
          }
          l1 = 0L;
          label300:
          ((cc)localObject1).hx(l1).hy(paramb.irQ).hz(paramb.sri).hA(paramb.srj).hB(paramb.spt).hC(paramb.srl).lp(com.tencent.mm.ad.c.rc(paramb.sqO)).hD(paramb.srm).hE(paramb.srp);
          localObject1 = paramb.srs;
          if (localObject1 != null)
          {
            localcc.hG(((c)localObject1).averageSpeed);
            localcc.hJ(((c)localObject1).averageConnectCost);
            localcc.lr(((c)localObject1).srH);
            localcc.hK(((c)localObject1).srI);
            localcc.iw(((c)localObject1).retCode);
            localObject1 = z.MKo;
          }
          localcc.hQ(paramb.sro);
          localcc.ix(paramb.srE);
          if (paramb.spB == paramb.spC) {
            break label527;
          }
        }
        label520:
        label527:
        for (paramb.srx = 1;; paramb.srx = 0)
        {
          localObject1 = aj.getContext().getSystemService("audio");
          if (localObject1 != null) {
            break label535;
          }
          paramb = new v("null cannot be cast to non-null type android.media.AudioManager");
          AppMethodBeat.o(166703);
          throw paramb;
          localObject1 = null;
          break;
          l1 = 51L;
          break label300;
        }
        label535:
        int i = ((AudioManager)localObject1).getStreamMaxVolume(3);
        localcc.lw(paramb.spB * 100 / i + ';' + paramb.spC * 100 / i + ';' + paramb.srx);
        localObject1 = new JSONArray();
        Object localObject2 = ((Iterable)sqL).iterator();
        JSONObject localJSONObject;
        while (((Iterator)localObject2).hasNext())
        {
          amk localamk = (amk)((Iterator)localObject2).next();
          try
          {
            localJSONObject = new JSONObject();
            localJSONObject.put("pos", localamk.sqT);
            localJSONObject.put("spe", localamk.Gmb);
            localJSONObject.put("loadCost", localamk.Gmd);
            localJSONObject.put("fSize", localamk.GlY);
            ((JSONArray)localObject1).put(localJSONObject);
          }
          catch (Exception localException1) {}
        }
        localObject1 = ((JSONArray)localObject1).toString();
        d.g.b.p.g(localObject1, "historyInfoArray.toString()");
        localcc.lq(n.h((String)localObject1, ",", ";", false));
        localcc.hF(paramb.srq);
        localcc.hH(paramb.sre);
        localcc.hI(paramb.sru);
        localObject1 = g.ad(com.tencent.mm.plugin.thumbplayer.a.a.class);
        d.g.b.p.g(localObject1, "MMKernel.plugin(IPluginThumbPlayer::class.java)");
        long l1 = l2;
        if (((com.tencent.mm.plugin.thumbplayer.a.a)localObject1).isOpenTPPlayer()) {
          l1 = 1L;
        }
        localcc.hL(l1);
        localcc.hN(paramb.spy);
        localcc.hO(paramb.spx);
        localcc.lx(paramb.srB + ';' + paramb.srz + ';' + paramb.sry + ';' + paramb.srA + ';' + paramb.frameRate + ';' + paramb.srC + ';' + paramb.srD + ';');
        localObject2 = this.rIl.qXu;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localcc.lz((String)localObject1);
        localObject2 = this.rIl.qXj;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localcc.ly((String)localObject1);
        localObject1 = h.soM;
        localcc.lA(h.I(paramb.sqO, this.rIl.rTD));
        localObject1 = b.sxa;
        localcc.hP(((Number)b.cFY().first).intValue());
        localcc.lu(String.valueOf(paramb.sqS));
        localcc.iy(paramb.srz);
        localcc.lB(paramb.srB);
        localcc.lC(paramb.sry);
        localcc.iz(paramb.srA);
        localcc.iA(paramb.frameRate);
        localcc.iB((int)(paramb.srC * paramb.srD));
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("videoWidth", Float.valueOf(paramb.srC));
        ((JSONObject)localObject1).put("videoHeight", Float.valueOf(paramb.srD));
        localObject2 = aj.getContext();
        d.g.b.p.g(localObject2, "MMApplicationContext.getContext()");
        localObject2 = ((Context)localObject2).getResources();
        d.g.b.p.g(localObject2, "MMApplicationContext.getContext().resources");
        ((JSONObject)localObject1).put("screenWidth", ((Resources)localObject2).getDisplayMetrics().widthPixels);
        localObject2 = aj.getContext();
        d.g.b.p.g(localObject2, "MMApplicationContext.getContext()");
        localObject2 = ((Context)localObject2).getResources();
        d.g.b.p.g(localObject2, "MMApplicationContext.getContext().resources");
        ((JSONObject)localObject1).put("screenHeight", ((Resources)localObject2).getDisplayMetrics().heightPixels);
        localObject2 = ((PluginFinder)g.ad(PluginFinder.class)).getMediaPreloadModel();
        ((JSONObject)localObject1).put("isMultiBitRate", ((com.tencent.mm.plugin.finder.preload.model.a)localObject2).slr);
        ((JSONObject)localObject1).put("isSecondPre", ((com.tencent.mm.plugin.finder.preload.model.a)localObject2).sls);
        ((JSONObject)localObject1).put("playLinkCnt", ((com.tencent.mm.plugin.finder.preload.model.a)localObject2).sll);
        ((JSONObject)localObject1).put("preLinkCnt", ((com.tencent.mm.plugin.finder.preload.model.a)localObject2).slk);
        ((JSONObject)localObject1).put("startPrePercent", ((com.tencent.mm.plugin.finder.preload.model.a)localObject2).slm);
        ((JSONObject)localObject1).put("startPreSec", ((com.tencent.mm.plugin.finder.preload.model.a)localObject2).sln);
        ((JSONObject)localObject1).put("preTaskCnt", ((com.tencent.mm.plugin.finder.preload.model.a)localObject2).slj);
        ((JSONObject)localObject1).put("maxPrePercent", ((com.tencent.mm.plugin.finder.preload.model.a)localObject2).slh);
        ((JSONObject)localObject1).put("maxPreBytes", ((com.tencent.mm.plugin.finder.preload.model.a)localObject2).sli);
        ((JSONObject)localObject1).put("prevCnt", ((com.tencent.mm.plugin.finder.preload.model.a)localObject2).slf);
        ((JSONObject)localObject1).put("nextCnt", ((com.tencent.mm.plugin.finder.preload.model.a)localObject2).slg);
        localObject2 = z.MKo;
        localObject1 = ((JSONObject)localObject1).toString();
        d.g.b.p.g(localObject1, "JSONObject().apply {\n   …             }.toString()");
        localcc.lD(n.h((String)localObject1, ",", ";", false));
        localObject1 = h.soM;
        localObject1 = h.ws(paramb.sqO);
        if (localObject1 != null) {
          localcc.lt(((FinderItem)localObject1).getUserName());
        }
        for (localObject1 = z.MKo;; localObject1 = z.MKo)
        {
          localObject1 = new JSONArray();
          localObject2 = ((Iterable)paramb.srv).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            asv localasv = (asv)((Iterator)localObject2).next();
            try
            {
              localJSONObject = new JSONObject();
              localJSONObject.put("waitMs", localasv.GqO);
              localJSONObject.put("percent", localasv.percent);
              localJSONObject.put("type", localasv.type);
              ((JSONArray)localObject1).put(localJSONObject);
            }
            catch (Exception localException2) {}
          }
          localcc.lt("");
        }
        localObject1 = ((JSONArray)localObject1).toString();
        d.g.b.p.g(localObject1, "waitingDetails.toString()");
        localcc.ls(n.h((String)localObject1, ",", ";", false));
        localObject1 = "";
        localObject2 = ((Iterable)paramb.srw).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          i = ((Number)((Iterator)localObject2).next()).intValue();
          localObject1 = (String)localObject1 + i + ';';
        }
        localcc.lv((String)localObject1);
        localcc.dJX();
        localObject1 = h.soM;
        h.a((com.tencent.mm.plugin.report.a)localcc);
        localObject1 = paramb.srs;
        if (localObject1 != null)
        {
          localObject2 = new amk();
          ((amk)localObject2).dtq = paramb.sqO;
          ((amk)localObject2).GlW = 0;
          ((amk)localObject2).Gmb = ((int)localcc.SM());
          ((amk)localObject2).Gmd = ((int)localcc.SL());
          ((amk)localObject2).GlY = ((int)localcc.getFileSize());
          ((amk)localObject2).GlX = d.h.a.co((float)(localcc.getFileSize() * localcc.SI()) / 100.0F);
          ((amk)localObject2).loB = d.h.a.co((float)(localcc.SK() * localcc.getFileSize()) / 100.0F);
          ((amk)localObject2).scene = this.rIl.rTD;
          ((amk)localObject2).duration = localm.siC.videoDuration;
          ((amk)localObject2).sqT = ((int)localcc.getPosition());
          ((amk)localObject2).Gmc = cf.aCN();
          ((amk)localObject2).GlZ = ((int)paramb.spv);
          ((amk)localObject2).Gma = ((int)paramb.sro);
          ((amk)localObject2).srv = paramb.srv;
          ((amk)localObject2).dDf = paramb.sry;
          ((amk)localObject2).Gme = ((c)localObject1).averageConnectCost;
          ((amk)localObject2).srH = ((c)localObject1).srH;
          ((amk)localObject2).srI = ((c)localObject1).srI;
          ((amk)localObject2).networkId = ((c)localObject1).netType;
          ((amk)localObject2).sqS = paramb.sqS;
          if (sqL.size() > 2) {
            sqL.remove(0);
          }
          sqL.add(localObject2);
          sqM.add(localObject2);
          ad.i("Finder.FinderVideoPlayReporter", "downloadInfoList " + sqL.size());
          paramb = z.MKo;
        }
      }
      paramb = z.MKo;
      AppMethodBeat.o(166703);
      return;
    }
    AppMethodBeat.o(166703);
  }
  
  final void b(b paramb)
  {
    AppMethodBeat.i(166704);
    if (paramb != null)
    {
      Object localObject = com.tencent.mm.plugin.finder.utils.p.sMo;
      bvf localbvf = paramb.sqR;
      d locald = paramb.srr;
      c localc = paramb.srs;
      hn localhn;
      long l1;
      if ((localbvf != null) && (locald != null) && (localc != null))
      {
        localhn = new hn();
        localObject = com.tencent.mm.plugin.finder.storage.logic.c.sAv;
        localObject = paramb.sqQ;
        if (localObject != null)
        {
          String str = ((m)localObject).aeA();
          localObject = str;
          if (str != null) {}
        }
        else
        {
          localObject = "";
        }
        localObject = com.tencent.mm.plugin.finder.storage.logic.c.aiD((String)localObject);
        long l2 = d.h.a.K((float)(paramb.sqY * ((y)localObject).field_totalSize) / 100.0F);
        localObject = localhn.qd(com.tencent.mm.ad.c.rc(paramb.sqO)).mn(this.rIl.rTD + 100).mo(paramb.srf);
        if (paramb.sqT != 0) {
          break label589;
        }
        l1 = 1L;
        localObject = ((hn)localObject).mp(l1).mq(localbvf.videoDuration).mr(d.h.a.K(localbvf.videoDuration * paramb.sqW / 100.0F)).ms(paramb.srl).mt(paramb.sra).mu(paramb.sru).UA().mw(0L).mx(localc.retCode).qe("").my(paramb.srz).qf(String.valueOf(locald.requestVideoFormat)).mz(localc.iQl).mA(localc.recvedBytes).mB(localc.startTime).mC(localc.endTime).mD(localc.retCode).mE(localc.enQueueTime).mF(localc.moovRequestTimes).mG(localc.moovCost).mH(localc.moovSize);
        if (!localc.moovCompleted) {
          break label594;
        }
        l1 = 1L;
        label353:
        localObject = ((hn)localObject).mI(l1).mJ(localc.moovFailReason).mK(localc.firstConnectCost).mL(localc.firstRequestCost).mM(localc.firstRequestSize).mN(localc.firstRequestDownloadSize);
        if (!localc.firstRequestCompleted) {
          break label599;
        }
        l1 = 1L;
        label416:
        localObject = ((hn)localObject).mO(l1).mP(localc.averageSpeed).mQ(localc.averageConnectCost).mR(localc.netConnectTimes).qg(localc.srF).qh(localc.clientIP);
        if (!localc.srG) {
          break label604;
        }
        l1 = 1L;
        label477:
        localObject = ((hn)localObject).mS(l1).mT(locald.fJL).mU(0L).mV(paramb.sre).mW(paramb.lXf).mX(l2).UC().iN(localc.transportProtocol).iO(localc.transportProtocolError);
        if (!i.DEBUG) {
          break label609;
        }
        l1 = 0L;
        label543:
        ((hn)localObject).mY(l1);
        if (paramb.srm != 0) {
          break label616;
        }
        localhn.mv(0L);
      }
      for (;;)
      {
        localhn.aLk();
        paramb = h.soM;
        h.a((com.tencent.mm.plugin.report.a)localhn);
        AppMethodBeat.o(166704);
        return;
        label589:
        l1 = 0L;
        break;
        label594:
        l1 = 0L;
        break label353;
        label599:
        l1 = 0L;
        break label416;
        label604:
        l1 = 0L;
        break label477;
        label609:
        l1 = 51L;
        break label543;
        label616:
        localhn.mv(paramb.sro / paramb.srm);
      }
    }
    AppMethodBeat.o(166704);
  }
  
  public final void c(aqy paramaqy)
  {
    AppMethodBeat.i(203375);
    d.g.b.p.h(paramaqy, "contextObj");
    this.rIl = paramaqy;
    AppMethodBeat.o(203375);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/report/FinderVideoPlayReporter$Companion;", "", "()V", "INNER_VERSION", "", "TAG", "", "downloadInfoAllList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderDownloadInfo;", "getDownloadInfoAllList", "()Ljava/util/LinkedList;", "downloadInfoList", "getDownloadInfoList", "plugin-finder_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/report/FinderVideoPlayReporter$ReportData;", "", "()V", "adjustVolume", "", "getAdjustVolume", "()I", "setAdjustVolume", "(I)V", "bgPreparedStatus", "getBgPreparedStatus", "setBgPreparedStatus", "currentFeedId", "", "getCurrentFeedId", "()J", "setCurrentFeedId", "(J)V", "currentMedia", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "getCurrentMedia", "()Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "setCurrentMedia", "(Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;)V", "currentMediaId", "", "getCurrentMediaId", "()Ljava/lang/String;", "setCurrentMediaId", "(Ljava/lang/String;)V", "currentVideo", "Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "getCurrentVideo", "()Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "setCurrentVideo", "(Lcom/tencent/mm/plugin/finder/loader/FinderVideo;)V", "currentWaiting", "", "getCurrentWaiting", "()Z", "setCurrentWaiting", "(Z)V", "downloadFinishTime", "getDownloadFinishTime", "setDownloadFinishTime", "downloadPercent", "getDownloadPercent", "setDownloadPercent", "downloadSpeed", "getDownloadSpeed", "setDownloadSpeed", "endVolume", "getEndVolume", "setEndVolume", "fetchTimestamp", "getFetchTimestamp", "setFetchTimestamp", "firstFrameTime", "getFirstFrameTime", "setFirstFrameTime", "firstLoadTime", "getFirstLoadTime", "setFirstLoadTime", "firstPlay", "getFirstPlay", "setFirstPlay", "firstRequestDataOffset", "getFirstRequestDataOffset", "setFirstRequestDataOffset", "frameRate", "getFrameRate", "setFrameRate", "hitPreload", "getHitPreload", "setHitPreload", "hitPreloadPercent", "getHitPreloadPercent", "setHitPreloadPercent", "isPause", "setPause", "isSeek", "setSeek", "isStartDownload", "setStartDownload", "mediaPath", "getMediaPath", "setMediaPath", "moovReadyOffset", "getMoovReadyOffset", "setMoovReadyOffset", "moovReadyTime", "getMoovReadyTime", "setMoovReadyTime", "netType", "getNetType", "setNetType", "netTypeInt", "getNetTypeInt", "setNetTypeInt", "pauseTimestamp", "getPauseTimestamp", "setPauseTimestamp", "pauseTotalTime", "getPauseTotalTime", "setPauseTotalTime", "playAudioBitrate", "getPlayAudioBitrate", "setPlayAudioBitrate", "playCodeFormat", "getPlayCodeFormat", "setPlayCodeFormat", "playFileFormat", "getPlayFileFormat", "setPlayFileFormat", "playPageIndex", "getPlayPageIndex", "setPlayPageIndex", "playPercent", "getPlayPercent", "setPlayPercent", "playPercentSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "getPlayPercentSet", "()Ljava/util/HashSet;", "setPlayPercentSet", "(Ljava/util/HashSet;)V", "playPosition", "getPlayPosition", "setPlayPosition", "playStatus", "getPlayStatus", "setPlayStatus", "playTime", "getPlayTime", "setPlayTime", "playVideoBitrate", "getPlayVideoBitrate", "setPlayVideoBitrate", "playWaitingCount", "getPlayWaitingCount", "setPlayWaitingCount", "playerErrCode", "getPlayerErrCode", "setPlayerErrCode", "playing", "getPlaying", "setPlaying", "preloadStrategyId", "getPreloadStrategyId", "setPreloadStrategyId", "realPlayTime", "getRealPlayTime", "setRealPlayTime", "realPlayTimestamp", "getRealPlayTimestamp", "setRealPlayTimestamp", "replayCount", "getReplayCount", "setReplayCount", "reportSceneResult", "Lcom/tencent/mm/plugin/finder/report/FinderVideoPlayReporter$ReportSceneResult;", "getReportSceneResult", "()Lcom/tencent/mm/plugin/finder/report/FinderVideoPlayReporter$ReportSceneResult;", "setReportSceneResult", "(Lcom/tencent/mm/plugin/finder/report/FinderVideoPlayReporter$ReportSceneResult;)V", "reportTaskInfo", "Lcom/tencent/mm/plugin/finder/report/FinderVideoPlayReporter$ReportTaskInfo;", "getReportTaskInfo", "()Lcom/tencent/mm/plugin/finder/report/FinderVideoPlayReporter$ReportTaskInfo;", "setReportTaskInfo", "(Lcom/tencent/mm/plugin/finder/report/FinderVideoPlayReporter$ReportTaskInfo;)V", "sessionId", "getSessionId", "setSessionId", "startTimestamp", "getStartTimestamp", "setStartTimestamp", "startVolume", "getStartVolume", "setStartVolume", "startWaitingTime", "getStartWaitingTime", "setStartWaitingTime", "totalWaitingTime", "getTotalWaitingTime", "setTotalWaitingTime", "videoHeight", "", "getVideoHeight", "()F", "setVideoHeight", "(F)V", "videoWidth", "getVideoWidth", "setVideoWidth", "waitDetails", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderWaitDetail;", "getWaitDetails", "()Ljava/util/LinkedList;", "setWaitDetails", "(Ljava/util/LinkedList;)V", "waitingCount", "getWaitingCount", "setWaitingCount", "plugin-finder_release"})
  public static final class b
  {
    boolean bfZ;
    int frameRate;
    int irQ;
    long lXf;
    int lsH;
    String mediaPath;
    int rQx;
    String sessionId;
    int spB;
    int spC;
    long spt;
    long spu;
    long spv;
    int spx;
    int spy;
    long sqO;
    String sqP;
    m sqQ;
    bvf sqR;
    long sqS;
    int sqT;
    int sqU;
    long sqV;
    int sqW;
    int sqX;
    int sqY;
    long sqZ;
    int srA;
    String srB;
    float srC;
    float srD;
    int srE;
    long sra;
    long srb;
    String srd;
    long sre;
    int srf;
    int srg;
    boolean srh;
    int sri;
    long srj;
    long srk;
    long srl;
    int srm;
    long srn;
    long sro;
    long srp;
    long srq;
    r.d srr;
    r.c srs;
    boolean srt;
    long sru;
    LinkedList<asv> srv;
    HashSet<Integer> srw;
    int srx;
    String sry;
    int srz;
    
    public b()
    {
      AppMethodBeat.i(178402);
      this.sessionId = "";
      this.sqP = "";
      this.mediaPath = "";
      this.srd = "";
      this.srv = new LinkedList();
      this.srw = new HashSet();
      this.sry = "";
      this.srB = "";
      AppMethodBeat.o(178402);
    }
    
    public final void ahP(String paramString)
    {
      AppMethodBeat.i(203361);
      d.g.b.p.h(paramString, "<set-?>");
      this.sry = paramString;
      AppMethodBeat.o(203361);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/report/FinderVideoPlayReporter$ReportSceneResult;", "", "mediaId", "", "(Ljava/lang/String;)V", "averageConnectCost", "", "getAverageConnectCost", "()I", "setAverageConnectCost", "(I)V", "averageSpeed", "getAverageSpeed", "setAverageSpeed", "clientIP", "getClientIP", "()Ljava/lang/String;", "setClientIP", "enQueueTime", "", "getEnQueueTime", "()J", "setEnQueueTime", "(J)V", "endTime", "getEndTime", "setEndTime", "fileLength", "getFileLength", "setFileLength", "firstConnectCost", "getFirstConnectCost", "setFirstConnectCost", "firstRequestCompleted", "", "getFirstRequestCompleted", "()Z", "setFirstRequestCompleted", "(Z)V", "firstRequestCost", "getFirstRequestCost", "setFirstRequestCost", "firstRequestDownloadSize", "getFirstRequestDownloadSize", "setFirstRequestDownloadSize", "firstRequestSize", "getFirstRequestSize", "setFirstRequestSize", "isCrossNet", "setCrossNet", "getMediaId", "moovCompleted", "getMoovCompleted", "setMoovCompleted", "moovCost", "getMoovCost", "setMoovCost", "moovFailReason", "getMoovFailReason", "setMoovFailReason", "moovRequestTimes", "getMoovRequestTimes", "setMoovRequestTimes", "moovSize", "getMoovSize", "setMoovSize", "netConnectTimes", "getNetConnectTimes", "setNetConnectTimes", "netType", "getNetType", "setNetType", "recvedBytes", "getRecvedBytes", "setRecvedBytes", "retCode", "getRetCode", "setRetCode", "rptIpList", "getRptIpList", "setRptIpList", "startTime", "getStartTime", "setStartTime", "svrIp", "getSvrIp", "setSvrIp", "svrPort", "getSvrPort", "setSvrPort", "transportProtocol", "getTransportProtocol", "setTransportProtocol", "transportProtocolError", "getTransportProtocolError", "setTransportProtocolError", "component1", "copy", "equals", "other", "hashCode", "toString", "plugin-finder_release"})
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
    long iQl;
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
    String srF;
    boolean srG;
    String srH;
    int srI;
    long startTime;
    int transportProtocol;
    int transportProtocolError;
    
    public c(String paramString)
    {
      AppMethodBeat.i(203365);
      this.mediaId = paramString;
      this.srF = "";
      this.clientIP = "";
      this.srH = "";
      AppMethodBeat.o(203365);
    }
    
    public final void ahQ(String paramString)
    {
      AppMethodBeat.i(203362);
      d.g.b.p.h(paramString, "<set-?>");
      this.srF = paramString;
      AppMethodBeat.o(203362);
    }
    
    public final void ahR(String paramString)
    {
      AppMethodBeat.i(203363);
      d.g.b.p.h(paramString, "<set-?>");
      this.clientIP = paramString;
      AppMethodBeat.o(203363);
    }
    
    public final void ahS(String paramString)
    {
      AppMethodBeat.i(203364);
      d.g.b.p.h(paramString, "<set-?>");
      this.srH = paramString;
      AppMethodBeat.o(203364);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(203368);
      if (this != paramObject)
      {
        if ((paramObject instanceof c))
        {
          paramObject = (c)paramObject;
          if (!d.g.b.p.i(this.mediaId, paramObject.mediaId)) {}
        }
      }
      else
      {
        AppMethodBeat.o(203368);
        return true;
      }
      AppMethodBeat.o(203368);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(203367);
      String str = this.mediaId;
      if (str != null)
      {
        int i = str.hashCode();
        AppMethodBeat.o(203367);
        return i;
      }
      AppMethodBeat.o(203367);
      return 0;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(203366);
      String str = "ReportSceneResult(mediaId=" + this.mediaId + ")";
      AppMethodBeat.o(203366);
      return str;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/report/FinderVideoPlayReporter$ReportTaskInfo;", "", "mediaId", "", "(Ljava/lang/String;)V", "getMediaId", "()Ljava/lang/String;", "moovPos", "", "getMoovPos", "()J", "setMoovPos", "(J)V", "requestVideoFormat", "", "getRequestVideoFormat", "()I", "setRequestVideoFormat", "(I)V", "component1", "copy", "equals", "", "other", "hashCode", "toString", "plugin-finder_release"})
  public static final class d
  {
    long fJL;
    private final String mediaId;
    int requestVideoFormat;
    
    public d(String paramString)
    {
      AppMethodBeat.i(203369);
      this.mediaId = paramString;
      AppMethodBeat.o(203369);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(203372);
      if (this != paramObject)
      {
        if ((paramObject instanceof d))
        {
          paramObject = (d)paramObject;
          if (!d.g.b.p.i(this.mediaId, paramObject.mediaId)) {}
        }
      }
      else
      {
        AppMethodBeat.o(203372);
        return true;
      }
      AppMethodBeat.o(203372);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(203371);
      String str = this.mediaId;
      if (str != null)
      {
        int i = str.hashCode();
        AppMethodBeat.o(203371);
        return i;
      }
      AppMethodBeat.o(203371);
      return 0;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(203370);
      String str = "ReportTaskInfo(mediaId=" + this.mediaId + ")";
      AppMethodBeat.o(203370);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.r
 * JD-Core Version:    0.7.0.1
 */