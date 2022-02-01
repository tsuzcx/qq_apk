package com.tencent.mm.plugin.finder.report;

import android.content.Context;
import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.an;
import com.tencent.mm.g.b.a.eu;
import com.tencent.mm.i.d;
import com.tencent.mm.model.ce;
import com.tencent.mm.plugin.finder.model.r;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.i;
import com.tencent.mm.protocal.protobuf.aif;
import com.tencent.mm.protocal.protobuf.alx;
import com.tencent.mm.protocal.protobuf.bmd;
import com.tencent.mm.protocal.protobuf.dzp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import d.a.j;
import d.g.b.k;
import d.n.n;
import d.o;
import d.v;
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

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/report/FinderVideoPlayReporter;", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "setContextObj", "currentVideoReportMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/finder/report/FinderVideoPlayReporter$ReportData;", "Lkotlin/collections/HashMap;", "getCurrentVideoReportMap", "()Ljava/util/HashMap;", "setCurrentVideoReportMap", "(Ljava/util/HashMap;)V", "lazyReportDataList", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "getLazyReportDataList", "()Ljava/util/concurrent/ConcurrentLinkedDeque;", "setLazyReportDataList", "(Ljava/util/concurrent/ConcurrentLinkedDeque;)V", "checkVideoDataAvailable", "", "feedId", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "timestamp", "offset", "", "total", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "cloneSceneResult", "Lcom/tencent/mm/plugin/finder/report/FinderVideoPlayReporter$ReportSceneResult;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "cloneTaskInfo", "Lcom/tencent/mm/plugin/finder/report/FinderVideoPlayReporter$ReportTaskInfo;", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "onDownloadFinish", "ret", "onDownloadProgress", "onDownloadStart", "onDownloadStop", "taskInfo", "onFirstFrameUpdate", "onMoovReady", "onPause", "onPlayProgress", "onRelease", "onReplay", "onResume", "onSeek", "onStartPlay", "position", "pageIndex", "onStopPlay", "onTabChange", "onUserClickPause", "it", "onWaiting", "onWaitingEnd", "report17000", "reportData", "report19059", "Companion", "ReportData", "ReportSceneResult", "ReportTaskInfo", "plugin-finder_release"})
public final class g
{
  private static final LinkedList<aif> KVx;
  public static final g.a qGu;
  HashMap<Long, b> KVw;
  private dzp contextObj;
  ConcurrentLinkedDeque<b> qGr;
  
  static
  {
    AppMethodBeat.i(166706);
    qGu = new g.a((byte)0);
    KVx = new LinkedList();
    AppMethodBeat.o(166706);
  }
  
  public g(dzp paramdzp)
  {
    AppMethodBeat.i(198873);
    this.contextObj = paramdzp;
    this.qGr = new ConcurrentLinkedDeque();
    this.KVw = new HashMap();
    AppMethodBeat.o(198873);
  }
  
  private static g.d b(com.tencent.mm.i.h paramh)
  {
    AppMethodBeat.i(198871);
    k.h(paramh, "cloneTaskInfo");
    String str = paramh.field_mediaId;
    Object localObject = str;
    if (str == null) {
      localObject = "";
    }
    localObject = new g.d((String)localObject);
    ((g.d)localObject).requestVideoFormat = paramh.field_requestVideoFormat;
    ((g.d)localObject).foi = paramh.foi;
    AppMethodBeat.o(198871);
    return localObject;
  }
  
  public static g.c c(d paramd)
  {
    AppMethodBeat.i(198872);
    k.h(paramd, "sceneResult");
    String str = paramd.mediaId;
    Object localObject = str;
    if (str == null) {
      localObject = "";
    }
    localObject = new g.c((String)localObject);
    ((g.c)localObject).retCode = paramd.field_retCode;
    ((g.c)localObject).hWY = paramd.field_fileLength;
    ((g.c)localObject).recvedBytes = paramd.field_recvedBytes;
    ((g.c)localObject).endTime = paramd.field_endTime;
    ((g.c)localObject).startTime = paramd.field_startTime;
    ((g.c)localObject).enQueueTime = paramd.field_enQueueTime;
    ((g.c)localObject).moovRequestTimes = paramd.field_moovRequestTimes;
    ((g.c)localObject).moovCost = paramd.field_moovCost;
    ((g.c)localObject).moovSize = paramd.field_moovSize;
    ((g.c)localObject).moovCompleted = paramd.field_moovCompleted;
    ((g.c)localObject).moovFailReason = paramd.field_moovFailReason;
    ((g.c)localObject).firstConnectCost = paramd.field_firstConnectCost;
    ((g.c)localObject).firstRequestCost = paramd.field_firstRequestCost;
    ((g.c)localObject).firstRequestSize = paramd.field_firstRequestSize;
    ((g.c)localObject).firstRequestDownloadSize = paramd.field_firstRequestDownloadSize;
    ((g.c)localObject).firstRequestCompleted = paramd.field_firstRequestCompleted;
    ((g.c)localObject).averageSpeed = paramd.field_averageSpeed;
    ((g.c)localObject).averageConnectCost = paramd.field_averageConnectCost;
    ((g.c)localObject).netConnectTimes = paramd.field_netConnectTimes;
    str = paramd.UD();
    if (str != null) {
      ((g.c)localObject).aVw(str);
    }
    str = paramd.field_clientIP;
    if (str != null) {
      ((g.c)localObject).aVx(str);
    }
    ((g.c)localObject).KVJ = paramd.field_isCrossNet;
    ((g.c)localObject).transportProtocol = paramd.transportProtocol;
    ((g.c)localObject).transportProtocolError = paramd.transportProtocolError;
    str = paramd.fnu;
    if (str != null) {
      ((g.c)localObject).aVy(str);
    }
    ((g.c)localObject).DkW = paramd.lastSvrPort;
    ((g.c)localObject).netType = paramd.lastNetType;
    AppMethodBeat.o(198872);
    return localObject;
  }
  
  public final void a(long paramLong, bmd parambmd, com.tencent.mm.i.h paramh, d paramd, com.tencent.mm.plugin.finder.loader.l paraml)
  {
    AppMethodBeat.i(198869);
    k.h(parambmd, "media");
    Object localObject1 = new StringBuilder("onDownloadStop ").append(com.tencent.mm.ad.c.ly(paramLong)).append(' ');
    boolean bool;
    label68:
    Iterator localIterator;
    if (paraml != null)
    {
      parambmd = paraml.aaX();
      parambmd = ((StringBuilder)localObject1).append(parambmd).append(' ');
      if (paramd == null) {
        break label270;
      }
      bool = true;
      ad.i("Finder.FinderVideoPlayReporter", bool);
      parambmd = (b)this.KVw.get(Long.valueOf(paramLong));
      if ((parambmd != null) && (parambmd.qHa))
      {
        if ((paramh != null) && (parambmd.KVA == null)) {
          parambmd.KVA = b(paramh);
        }
        if ((paramd != null) && (parambmd.KVB == null)) {
          parambmd.KVB = c(paramd);
        }
        parambmd.qHa = false;
      }
      parambmd = (Iterable)this.qGr;
      localObject1 = (Collection)new ArrayList();
      localIterator = parambmd.iterator();
    }
    label270:
    label281:
    label285:
    for (;;)
    {
      label184:
      if (!localIterator.hasNext()) {
        break label287;
      }
      Object localObject2 = localIterator.next();
      parambmd = (b)localObject2;
      if (parambmd.qGv == paramLong)
      {
        String str = parambmd.qGw;
        if (paraml != null)
        {
          parambmd = paraml.aaX();
          label235:
          if (!k.g(str, parambmd)) {
            break label281;
          }
        }
      }
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label285;
        }
        ((Collection)localObject1).add(localObject2);
        break label184;
        parambmd = null;
        break;
        bool = false;
        break label68;
        parambmd = null;
        break label235;
      }
    }
    label287:
    paraml = (Iterable)localObject1;
    parambmd = (Collection)new ArrayList(j.a(paraml, 10));
    paraml = paraml.iterator();
    while (paraml.hasNext())
    {
      localObject1 = (b)paraml.next();
      if ((paramh != null) && (((b)localObject1).KVA == null)) {
        ((b)localObject1).KVA = b(paramh);
      }
      if ((paramd != null) && (((b)localObject1).KVB == null)) {
        ((b)localObject1).KVB = c(paramd);
      }
      parambmd.add(localObject1);
    }
    parambmd = (List)parambmd;
    this.qGr.removeAll((Collection)parambmd);
    ad.i("Finder.FinderVideoPlayReporter", "lazyReportDataList " + this.qGr.size() + " reportList " + parambmd.size());
    parambmd = ((Iterable)parambmd).iterator();
    while (parambmd.hasNext())
    {
      paramh = (b)parambmd.next();
      a(paramh);
      b(paramh);
    }
    AppMethodBeat.o(198869);
  }
  
  final void a(b paramb)
  {
    long l = 0L;
    AppMethodBeat.i(166703);
    if (paramb != null)
    {
      if (paramb.qGv == 0L)
      {
        AppMethodBeat.o(166703);
        return;
      }
      com.tencent.mm.plugin.finder.loader.l locall = paramb.KVy;
      if (locall != null)
      {
        an localan = new an();
        localan.Qf();
        localan.hB(locall.aaX());
        localan.zC(this.contextObj.qqE);
        localan.dV(locall.qCj.videoDuration);
        localan.dW(paramb.qGD);
        localan.dX(paramb.qGF);
        localan.dY(paramb.qGG);
        localan.dZ(locall.qCj.fileSize);
        Object localObject1 = com.tencent.mm.plugin.finder.storage.logic.c.KXF;
        if (locall != null)
        {
          localObject1 = locall.aaX();
          localObject1 = com.tencent.mm.plugin.finder.storage.logic.c.aVA((String)localObject1);
          if (localObject1 != null) {
            localan.dZ(((r)localObject1).field_totalSize);
          }
          localan.ea(paramb.qGC);
          localan.eb(paramb.qGE);
          localan.ec(paramb.qGH);
          localObject1 = localan.ed(paramb.qGI).ee(paramb.qGJ).ef(paramb.qGz).hC(paramb.qGK).hD(paramb.sessionId).eg(paramb.qGA).Qh().eh(paramb.kut).ei(paramb.qEr).ej(paramb.qGM);
          if (!com.tencent.mm.sdk.platformtools.h.DEBUG) {
            break label476;
          }
          label292:
          ((an)localObject1).ek(l).el(paramb.hxT).em(paramb.qGO).en(paramb.qGP).eo(paramb.qGR).ep(paramb.qGS).hE(com.tencent.mm.ad.c.ly(paramb.qGv)).eq(paramb.qGT).er(paramb.qGW);
          localObject1 = paramb.KVB;
          if (localObject1 != null)
          {
            localan.et(((g.c)localObject1).averageSpeed);
            localan.zB(((g.c)localObject1).averageConnectCost);
            localan.hG(((g.c)localObject1).DkV);
            localan.ex(((g.c)localObject1).DkW);
          }
          if (paramb.KVp == paramb.KVq) {
            break label483;
          }
        }
        label476:
        label483:
        for (paramb.KVD = 1;; paramb.KVD = 0)
        {
          localObject1 = aj.getContext().getSystemService("audio");
          if (localObject1 != null) {
            break label491;
          }
          paramb = new v("null cannot be cast to non-null type android.media.AudioManager");
          AppMethodBeat.o(166703);
          throw paramb;
          localObject1 = null;
          break;
          l = 38L;
          break label292;
        }
        label491:
        int i = ((AudioManager)localObject1).getStreamMaxVolume(3);
        localan.aSO(paramb.KVp * 100 / i + ';' + paramb.KVq * 100 / i + ';' + paramb.KVD);
        localObject1 = new JSONArray();
        Object localObject2 = ((Iterable)KVx).iterator();
        JSONObject localJSONObject;
        while (((Iterator)localObject2).hasNext())
        {
          aif localaif = (aif)((Iterator)localObject2).next();
          try
          {
            localJSONObject = new JSONObject();
            localJSONObject.put("pos", localaif.qGA);
            localJSONObject.put("spe", localaif.DkP);
            localJSONObject.put("loadCost", localaif.DkR);
            localJSONObject.put("fSize", localaif.DkM);
            ((JSONArray)localObject1).put(localJSONObject);
          }
          catch (Exception localException1) {}
        }
        localObject1 = ((JSONArray)localObject1).toString();
        k.g(localObject1, "historyInfoArray.toString()");
        localan.hF(n.h((String)localObject1, ",", ";", false));
        localan.es(paramb.qGX);
        localan.eu(paramb.qGL);
        localan.ev(paramb.qHb);
        localan.zD(paramb.KVm);
        localan.zE(paramb.KVl);
        localan.aSP(paramb.KVH + ';' + paramb.KVE + ';' + paramb.KVF + ';' + paramb.KVG);
        localObject2 = this.contextObj.qwV;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localan.aSR((String)localObject1);
        localObject2 = this.contextObj.KHW;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localan.aSQ((String)localObject1);
        localObject1 = b.qFq;
        localan.aSS(b.am(paramb.qGv, this.contextObj.qqE));
        localObject1 = com.tencent.mm.plugin.finder.storage.b.qJA;
        localan.zF(((Number)com.tencent.mm.plugin.finder.storage.b.fUe().first).intValue());
        localan.aSM(String.valueOf(paramb.KVz));
        localObject1 = b.qFq;
        localObject1 = b.qh(paramb.qGv);
        if (localObject1 != null) {
          localan.hI(((FinderItem)localObject1).getUserName());
        }
        for (;;)
        {
          localObject1 = new JSONArray();
          localObject2 = ((Iterable)paramb.qHc).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            alx localalx = (alx)((Iterator)localObject2).next();
            try
            {
              localJSONObject = new JSONObject();
              localJSONObject.put("waitMs", localalx.DmW);
              localJSONObject.put("percent", localalx.percent);
              localJSONObject.put("type", localalx.type);
              ((JSONArray)localObject1).put(localJSONObject);
            }
            catch (Exception localException2) {}
          }
          localan.hI("");
        }
        localObject1 = ((JSONArray)localObject1).toString();
        k.g(localObject1, "waitingDetails.toString()");
        localan.hH(n.h((String)localObject1, ",", ";", false));
        localObject1 = "";
        localObject2 = ((Iterable)paramb.KVC).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          i = ((Number)((Iterator)localObject2).next()).intValue();
          localObject1 = (String)localObject1 + i + ';';
        }
        localan.aSN((String)localObject1);
        localan.fYy();
        localObject1 = b.qFq;
        b.a((com.tencent.mm.plugin.report.a)localan);
        localObject1 = paramb.KVB;
        if (localObject1 != null)
        {
          localObject2 = new aif();
          ((aif)localObject2).feedId = paramb.qGv;
          ((aif)localObject2).xXi = 0;
          ((aif)localObject2).DkP = ((int)localan.Qk());
          ((aif)localObject2).DkR = ((int)localan.Qj());
          ((aif)localObject2).DkM = ((int)localan.getFileSize());
          ((aif)localObject2).DkL = d.h.a.bU((float)(localan.getFileSize() * localan.Qg()) / 100.0F);
          ((aif)localObject2).kqF = d.h.a.bU((float)(localan.Qi() * localan.getFileSize()) / 100.0F);
          ((aif)localObject2).scene = this.contextObj.qqE;
          ((aif)localObject2).duration = locall.qCj.videoDuration;
          ((aif)localObject2).qGA = ((int)localan.getPosition());
          ((aif)localObject2).DkQ = ce.asT();
          ((aif)localObject2).DkN = ((int)paramb.qGD);
          ((aif)localObject2).DkO = ((int)paramb.qGV);
          ((aif)localObject2).qHc = paramb.qHc;
          ((aif)localObject2).DkS = paramb.KVE;
          ((aif)localObject2).DkU = ((g.c)localObject1).averageConnectCost;
          ((aif)localObject2).DkV = ((g.c)localObject1).DkV;
          ((aif)localObject2).DkW = ((g.c)localObject1).DkW;
          ((aif)localObject2).networkId = ((g.c)localObject1).netType;
          ((aif)localObject2).KVz = paramb.KVz;
          if (KVx.size() > 2) {
            KVx.remove(0);
          }
          KVx.add(localObject2);
          ad.i("Finder.FinderVideoPlayReporter", "downloadInfoList " + KVx.size());
          AppMethodBeat.o(166703);
          return;
        }
        AppMethodBeat.o(166703);
        return;
      }
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
      Object localObject = i.qTa;
      bmd localbmd = paramb.qGx;
      g.d locald = paramb.KVA;
      g.c localc = paramb.KVB;
      eu localeu;
      long l1;
      if ((localbmd != null) && (locald != null) && (localc != null))
      {
        localeu = new eu();
        localObject = com.tencent.mm.plugin.finder.storage.logic.c.KXF;
        localObject = paramb.KVy;
        if (localObject != null)
        {
          String str = ((com.tencent.mm.plugin.finder.loader.l)localObject).aaX();
          localObject = str;
          if (str != null) {}
        }
        else
        {
          localObject = "";
        }
        localObject = com.tencent.mm.plugin.finder.storage.logic.c.aVA((String)localObject);
        long l2 = d.h.a.J((float)(paramb.qGG * ((r)localObject).field_totalSize) / 100.0F);
        localObject = localeu.kM(com.tencent.mm.ad.c.ly(paramb.qGv)).gY(this.contextObj.qqE + 100).gZ(paramb.qEr);
        if (paramb.qGA != 0) {
          break label589;
        }
        l1 = 1L;
        localObject = ((eu)localObject).ha(l1).hb(localbmd.videoDuration).hc(d.h.a.J(localbmd.videoDuration * paramb.qGE / 100.0F)).hd(paramb.qGS).he(paramb.qGI).hf(paramb.qHb).RK().hh(0L).hi(localc.retCode).kN("").hj(paramb.KVF).kO(String.valueOf(locald.requestVideoFormat)).hk(localc.hWY).hl(localc.recvedBytes).hm(localc.startTime).hn(localc.endTime).ho(localc.retCode).hp(localc.enQueueTime).hq(localc.moovRequestTimes).hr(localc.moovCost).hs(localc.moovSize);
        if (!localc.moovCompleted) {
          break label594;
        }
        l1 = 1L;
        label353:
        localObject = ((eu)localObject).ht(l1).hu(localc.moovFailReason).hv(localc.firstConnectCost).hw(localc.firstRequestCost).hx(localc.firstRequestSize).hy(localc.firstRequestDownloadSize);
        if (!localc.firstRequestCompleted) {
          break label599;
        }
        l1 = 1L;
        label416:
        localObject = ((eu)localObject).hz(l1).hA(localc.averageSpeed).hB(localc.averageConnectCost).hC(localc.netConnectTimes).kP(localc.KVI).kQ(localc.clientIP);
        if (!localc.KVJ) {
          break label604;
        }
        l1 = 1L;
        label477:
        localObject = ((eu)localObject).hD(l1).hE(locald.foi).hF(0L).hG(paramb.qGL).hH(paramb.qGz).hI(l2).RM().iE(localc.transportProtocol).iF(localc.transportProtocolError);
        if (!com.tencent.mm.sdk.platformtools.h.DEBUG) {
          break label609;
        }
        l1 = 0L;
        label543:
        ((eu)localObject).AU(l1);
        if (paramb.qGT != 0) {
          break label616;
        }
        localeu.hg(0L);
      }
      for (;;)
      {
        localeu.aBj();
        paramb = b.qFq;
        b.a((com.tencent.mm.plugin.report.a)localeu);
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
        l1 = 38L;
        break label543;
        label616:
        localeu.hg(paramb.qGV / paramb.qGT);
      }
    }
    AppMethodBeat.o(166704);
  }
  
  public final void b(dzp paramdzp)
  {
    AppMethodBeat.i(198870);
    k.h(paramdzp, "contextObj");
    this.contextObj = paramdzp;
    AppMethodBeat.o(198870);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/report/FinderVideoPlayReporter$ReportData;", "", "()V", "adjustVolume", "", "getAdjustVolume", "()I", "setAdjustVolume", "(I)V", "currentFeedId", "", "getCurrentFeedId", "()J", "setCurrentFeedId", "(J)V", "currentMedia", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "getCurrentMedia", "()Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "setCurrentMedia", "(Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;)V", "currentMediaId", "", "getCurrentMediaId", "()Ljava/lang/String;", "setCurrentMediaId", "(Ljava/lang/String;)V", "currentVideo", "Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "getCurrentVideo", "()Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "setCurrentVideo", "(Lcom/tencent/mm/plugin/finder/loader/FinderVideo;)V", "currentWaiting", "", "getCurrentWaiting", "()Z", "setCurrentWaiting", "(Z)V", "downloadFinishTime", "getDownloadFinishTime", "setDownloadFinishTime", "downloadPercent", "getDownloadPercent", "setDownloadPercent", "downloadSpeed", "getDownloadSpeed", "setDownloadSpeed", "endVolume", "getEndVolume", "setEndVolume", "fetchTimestamp", "getFetchTimestamp", "setFetchTimestamp", "firstFrameTime", "getFirstFrameTime", "setFirstFrameTime", "firstLoadTime", "getFirstLoadTime", "setFirstLoadTime", "firstPlay", "getFirstPlay", "setFirstPlay", "firstRequestDataOffset", "getFirstRequestDataOffset", "setFirstRequestDataOffset", "hitPreload", "getHitPreload", "setHitPreload", "hitPreloadPercent", "getHitPreloadPercent", "setHitPreloadPercent", "isPause", "setPause", "isSeek", "setSeek", "isStartDownload", "setStartDownload", "moovReadyOffset", "getMoovReadyOffset", "setMoovReadyOffset", "moovReadyTime", "getMoovReadyTime", "setMoovReadyTime", "netType", "getNetType", "setNetType", "netTypeInt", "getNetTypeInt", "setNetTypeInt", "pauseTimestamp", "getPauseTimestamp", "setPauseTimestamp", "pauseTotalTime", "getPauseTotalTime", "setPauseTotalTime", "playAudioBitrate", "getPlayAudioBitrate", "setPlayAudioBitrate", "playCodeFormat", "getPlayCodeFormat", "setPlayCodeFormat", "playFileFormat", "getPlayFileFormat", "setPlayFileFormat", "playPageIndex", "getPlayPageIndex", "setPlayPageIndex", "playPercent", "getPlayPercent", "setPlayPercent", "playPercentSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "getPlayPercentSet", "()Ljava/util/HashSet;", "setPlayPercentSet", "(Ljava/util/HashSet;)V", "playPosition", "getPlayPosition", "setPlayPosition", "playStatus", "getPlayStatus", "setPlayStatus", "playTime", "getPlayTime", "setPlayTime", "playVideoBitrate", "getPlayVideoBitrate", "setPlayVideoBitrate", "playWaitingCount", "getPlayWaitingCount", "setPlayWaitingCount", "playing", "getPlaying", "setPlaying", "preloadStrategyId", "getPreloadStrategyId", "setPreloadStrategyId", "realPlayTime", "getRealPlayTime", "setRealPlayTime", "realPlayTimestamp", "getRealPlayTimestamp", "setRealPlayTimestamp", "replayCount", "getReplayCount", "setReplayCount", "reportSceneResult", "Lcom/tencent/mm/plugin/finder/report/FinderVideoPlayReporter$ReportSceneResult;", "getReportSceneResult", "()Lcom/tencent/mm/plugin/finder/report/FinderVideoPlayReporter$ReportSceneResult;", "setReportSceneResult", "(Lcom/tencent/mm/plugin/finder/report/FinderVideoPlayReporter$ReportSceneResult;)V", "reportTaskInfo", "Lcom/tencent/mm/plugin/finder/report/FinderVideoPlayReporter$ReportTaskInfo;", "getReportTaskInfo", "()Lcom/tencent/mm/plugin/finder/report/FinderVideoPlayReporter$ReportTaskInfo;", "setReportTaskInfo", "(Lcom/tencent/mm/plugin/finder/report/FinderVideoPlayReporter$ReportTaskInfo;)V", "sessionId", "getSessionId", "setSessionId", "startTimestamp", "getStartTimestamp", "setStartTimestamp", "startVolume", "getStartVolume", "setStartVolume", "startWaitingTime", "getStartWaitingTime", "setStartWaitingTime", "totalWaitingTime", "getTotalWaitingTime", "setTotalWaitingTime", "waitDetails", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderWaitDetail;", "getWaitDetails", "()Ljava/util/LinkedList;", "setWaitDetails", "(Ljava/util/LinkedList;)V", "waitingCount", "getWaitingCount", "setWaitingCount", "plugin-finder_release"})
  public static final class b
  {
    g.d KVA;
    g.c KVB;
    HashSet<Integer> KVC;
    int KVD;
    String KVE;
    int KVF;
    int KVG;
    String KVH;
    long KVj;
    int KVl;
    int KVm;
    int KVp;
    int KVq;
    com.tencent.mm.plugin.finder.loader.l KVy;
    long KVz;
    boolean aUR;
    int hxT;
    int kut;
    int qEr;
    int qGA;
    int qGB;
    long qGC;
    long qGD;
    int qGE;
    int qGF;
    int qGG;
    long qGH;
    long qGI;
    long qGJ;
    String qGK;
    long qGL;
    int qGM;
    boolean qGN;
    int qGO;
    long qGP;
    long qGQ;
    long qGR;
    long qGS;
    int qGT;
    long qGU;
    long qGV;
    long qGW;
    long qGX;
    long qGv;
    String qGw;
    bmd qGx;
    long qGz;
    boolean qHa;
    long qHb;
    LinkedList<alx> qHc;
    String sessionId;
    
    public b()
    {
      AppMethodBeat.i(178402);
      this.sessionId = "";
      this.qGw = "";
      this.qGK = "";
      this.qHc = new LinkedList();
      this.KVC = new HashSet();
      this.KVE = "";
      this.KVH = "";
      AppMethodBeat.o(178402);
    }
    
    public final void aVv(String paramString)
    {
      AppMethodBeat.i(198857);
      k.h(paramString, "<set-?>");
      this.KVE = paramString;
      AppMethodBeat.o(198857);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.g
 * JD-Core Version:    0.7.0.1
 */