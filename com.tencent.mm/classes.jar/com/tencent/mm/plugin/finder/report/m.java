package com.tencent.mm.plugin.finder.report;

import android.content.Context;
import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.bn;
import com.tencent.mm.g.b.a.gk;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ce;
import com.tencent.mm.plugin.finder.model.w;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.b;
import com.tencent.mm.protocal.protobuf.ajp;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.apa;
import com.tencent.mm.protocal.protobuf.bqs;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import d.a.j;
import d.g.b.k;
import d.o;
import d.v;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;
import org.json.JSONArray;
import org.json.JSONObject;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/report/FinderVideoPlayReporter;", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "setContextObj", "currentVideoReportMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/finder/report/FinderVideoPlayReporter$ReportData;", "Lkotlin/collections/HashMap;", "getCurrentVideoReportMap", "()Ljava/util/HashMap;", "setCurrentVideoReportMap", "(Ljava/util/HashMap;)V", "lazyReportDataList", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "getLazyReportDataList", "()Ljava/util/concurrent/ConcurrentLinkedDeque;", "setLazyReportDataList", "(Ljava/util/concurrent/ConcurrentLinkedDeque;)V", "checkVideoDataAvailable", "", "feedId", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "timestamp", "offset", "", "total", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "cloneSceneResult", "Lcom/tencent/mm/plugin/finder/report/FinderVideoPlayReporter$ReportSceneResult;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "cloneTaskInfo", "Lcom/tencent/mm/plugin/finder/report/FinderVideoPlayReporter$ReportTaskInfo;", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "onDownloadFinish", "ret", "onDownloadProgress", "onDownloadStart", "onDownloadStop", "taskInfo", "onFirstFrameUpdate", "onMoovReady", "onPause", "onPlayError", "errCode", "onPlayProgress", "onRelease", "onReplay", "onResume", "onSeek", "onStartPlay", "position", "pageIndex", "onStopPlay", "onTabChange", "onUserClickPause", "it", "onWaiting", "onWaitingEnd", "report17000", "reportData", "report19059", "Companion", "ReportData", "ReportSceneResult", "ReportTaskInfo", "plugin-finder_release"})
public final class m
{
  private static final LinkedList<ajp> rzc;
  public static final m.a rzd;
  private anm contextObj;
  ConcurrentLinkedDeque<m.b> rza;
  HashMap<Long, m.b> rzb;
  
  static
  {
    AppMethodBeat.i(166706);
    rzd = new m.a((byte)0);
    rzc = new LinkedList();
    AppMethodBeat.o(166706);
  }
  
  public m(anm paramanm)
  {
    AppMethodBeat.i(202826);
    this.contextObj = paramanm;
    this.rza = new ConcurrentLinkedDeque();
    this.rzb = new HashMap();
    AppMethodBeat.o(202826);
  }
  
  public static m.c b(com.tencent.mm.i.d paramd)
  {
    AppMethodBeat.i(202825);
    k.h(paramd, "sceneResult");
    String str = paramd.mediaId;
    Object localObject = str;
    if (str == null) {
      localObject = "";
    }
    localObject = new m.c((String)localObject);
    ((m.c)localObject).retCode = paramd.field_retCode;
    ((m.c)localObject).ixc = paramd.field_fileLength;
    ((m.c)localObject).recvedBytes = paramd.field_recvedBytes;
    ((m.c)localObject).endTime = paramd.field_endTime;
    ((m.c)localObject).startTime = paramd.field_startTime;
    ((m.c)localObject).enQueueTime = paramd.field_enQueueTime;
    ((m.c)localObject).moovRequestTimes = paramd.field_moovRequestTimes;
    ((m.c)localObject).moovCost = paramd.field_moovCost;
    ((m.c)localObject).moovSize = paramd.field_moovSize;
    ((m.c)localObject).moovCompleted = paramd.field_moovCompleted;
    ((m.c)localObject).moovFailReason = paramd.field_moovFailReason;
    ((m.c)localObject).firstConnectCost = paramd.field_firstConnectCost;
    ((m.c)localObject).firstRequestCost = paramd.field_firstRequestCost;
    ((m.c)localObject).firstRequestSize = paramd.field_firstRequestSize;
    ((m.c)localObject).firstRequestDownloadSize = paramd.field_firstRequestDownloadSize;
    ((m.c)localObject).firstRequestCompleted = paramd.field_firstRequestCompleted;
    ((m.c)localObject).averageSpeed = paramd.field_averageSpeed;
    ((m.c)localObject).averageConnectCost = paramd.field_averageConnectCost;
    ((m.c)localObject).netConnectTimes = paramd.field_netConnectTimes;
    str = paramd.Vy();
    if (str != null) {
      ((m.c)localObject).adQ(str);
    }
    str = paramd.field_clientIP;
    if (str != null) {
      ((m.c)localObject).adR(str);
    }
    ((m.c)localObject).rzV = paramd.field_isCrossNet;
    ((m.c)localObject).transportProtocol = paramd.transportProtocol;
    ((m.c)localObject).transportProtocolError = paramd.transportProtocolError;
    str = paramd.fqO;
    if (str != null) {
      ((m.c)localObject).adS(str);
    }
    ((m.c)localObject).rzX = paramd.lastSvrPort;
    ((m.c)localObject).netType = paramd.lastNetType;
    AppMethodBeat.o(202825);
    return localObject;
  }
  
  private static d b(com.tencent.mm.i.h paramh)
  {
    AppMethodBeat.i(202824);
    k.h(paramh, "cloneTaskInfo");
    String str = paramh.field_mediaId;
    Object localObject = str;
    if (str == null) {
      localObject = "";
    }
    localObject = new d((String)localObject);
    ((d)localObject).requestVideoFormat = paramh.field_requestVideoFormat;
    ((d)localObject).frC = paramh.frC;
    AppMethodBeat.o(202824);
    return localObject;
  }
  
  public final void a(long paramLong, bqs parambqs, com.tencent.mm.i.h paramh, com.tencent.mm.i.d paramd, com.tencent.mm.plugin.finder.loader.l paraml)
  {
    AppMethodBeat.i(202822);
    k.h(parambqs, "media");
    Object localObject1 = new StringBuilder("onDownloadStop ").append(com.tencent.mm.ac.c.pb(paramLong)).append(' ');
    boolean bool;
    label68:
    Iterator localIterator;
    if (paraml != null)
    {
      parambqs = paraml.abW();
      parambqs = ((StringBuilder)localObject1).append(parambqs).append(' ');
      if (paramd == null) {
        break label270;
      }
      bool = true;
      ac.i("Finder.FinderVideoPlayReporter", bool);
      parambqs = (m.b)this.rzb.get(Long.valueOf(paramLong));
      if ((parambqs != null) && (parambqs.rzJ))
      {
        if ((paramh != null) && (parambqs.rzH == null)) {
          parambqs.rzH = b(paramh);
        }
        if ((paramd != null) && (parambqs.rzI == null)) {
          parambqs.rzI = b(paramd);
        }
        parambqs.rzJ = false;
      }
      parambqs = (Iterable)this.rza;
      localObject1 = (Collection)new ArrayList();
      localIterator = parambqs.iterator();
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
      parambqs = (m.b)localObject2;
      if (parambqs.rze == paramLong)
      {
        String str = parambqs.rzf;
        if (paraml != null)
        {
          parambqs = paraml.abW();
          label235:
          if (!k.g(str, parambqs)) {
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
        parambqs = null;
        break;
        bool = false;
        break label68;
        parambqs = null;
        break label235;
      }
    }
    label287:
    paraml = (Iterable)localObject1;
    parambqs = (Collection)new ArrayList(j.a(paraml, 10));
    paraml = paraml.iterator();
    while (paraml.hasNext())
    {
      localObject1 = (m.b)paraml.next();
      if ((paramh != null) && (((m.b)localObject1).rzH == null)) {
        ((m.b)localObject1).rzH = b(paramh);
      }
      if ((paramd != null) && (((m.b)localObject1).rzI == null)) {
        ((m.b)localObject1).rzI = b(paramd);
      }
      parambqs.add(localObject1);
    }
    parambqs = (List)parambqs;
    this.rza.removeAll((Collection)parambqs);
    ac.i("Finder.FinderVideoPlayReporter", "lazyReportDataList " + this.rza.size() + " reportList " + parambqs.size());
    parambqs = ((Iterable)parambqs).iterator();
    while (parambqs.hasNext())
    {
      paramh = (m.b)parambqs.next();
      a(paramh);
      b(paramh);
    }
    AppMethodBeat.o(202822);
  }
  
  final void a(m.b paramb)
  {
    long l2 = 0L;
    AppMethodBeat.i(166703);
    if (paramb != null)
    {
      if (paramb.rze == 0L)
      {
        AppMethodBeat.o(166703);
        return;
      }
      com.tencent.mm.plugin.finder.loader.l locall = paramb.rzg;
      if (locall != null)
      {
        bn localbn = new bn();
        localbn.QD();
        localbn.jy(locall.abW());
        localbn.gt(this.contextObj.rfR);
        localbn.fP(locall.rtl.videoDuration);
        localbn.fQ(paramb.rya);
        localbn.fR(paramb.rzo);
        localbn.fS(paramb.rzp);
        localbn.fT(locall.rtl.fileSize);
        Object localObject1 = com.tencent.mm.plugin.finder.storage.logic.c.rFo;
        if (locall != null)
        {
          localObject1 = locall.abW();
          localObject1 = com.tencent.mm.plugin.finder.storage.logic.c.aei((String)localObject1);
          if (localObject1 != null)
          {
            localbn.fT(((w)localObject1).field_totalSize);
            localObject1 = y.KTp;
          }
          localbn.fU(paramb.rzm);
          localbn.fV(paramb.rzn);
          localbn.fW(paramb.rzq);
          localObject1 = localbn.fX(paramb.rzr).fY(paramb.rzs).fZ(paramb.rzj).jz(paramb.rzt).jA(paramb.sessionId).ga(paramb.rzk).QF().gb(paramb.kVI).gc(paramb.rzv).gd(paramb.rzw);
          if (!com.tencent.mm.sdk.platformtools.h.DEBUG) {
            break label510;
          }
          l1 = 0L;
          label300:
          ((bn)localObject1).ge(l1).gf(paramb.hYu).gg(paramb.rzy).gh(paramb.rzz).gi(paramb.rxY).gj(paramb.rzB).jB(com.tencent.mm.ac.c.pb(paramb.rze)).gk(paramb.rzC).gl(paramb.rzF);
          localObject1 = paramb.rzI;
          if (localObject1 != null)
          {
            localbn.gn(((m.c)localObject1).averageSpeed);
            localbn.gq(((m.c)localObject1).averageConnectCost);
            localbn.jD(((m.c)localObject1).rzW);
            localbn.gr(((m.c)localObject1).rzX);
            localbn.tl(((m.c)localObject1).retCode);
            localObject1 = y.KTp;
          }
          localbn.vE(paramb.uGI);
          if (paramb.ryg == paramb.ryh) {
            break label517;
          }
        }
        label517:
        for (paramb.rzN = 1;; paramb.rzN = 0)
        {
          localObject1 = ai.getContext().getSystemService("audio");
          if (localObject1 != null) {
            break label525;
          }
          paramb = new v("null cannot be cast to non-null type android.media.AudioManager");
          AppMethodBeat.o(166703);
          throw paramb;
          localObject1 = null;
          break;
          label510:
          l1 = 42L;
          break label300;
        }
        label525:
        int i = ((AudioManager)localObject1).getStreamMaxVolume(3);
        localbn.jI(paramb.ryg * 100 / i + ';' + paramb.ryh * 100 / i + ';' + paramb.rzN);
        localObject1 = new JSONArray();
        Object localObject2 = ((Iterable)rzc).iterator();
        JSONObject localJSONObject;
        while (((Iterator)localObject2).hasNext())
        {
          ajp localajp = (ajp)((Iterator)localObject2).next();
          try
          {
            localJSONObject = new JSONObject();
            localJSONObject.put("pos", localajp.rzk);
            localJSONObject.put("spe", localajp.EEl);
            localJSONObject.put("loadCost", localajp.EEn);
            localJSONObject.put("fSize", localajp.EEi);
            ((JSONArray)localObject1).put(localJSONObject);
          }
          catch (Exception localException1) {}
        }
        localObject1 = ((JSONArray)localObject1).toString();
        k.g(localObject1, "historyInfoArray.toString()");
        localbn.jC(d.n.n.h((String)localObject1, ",", ";", false));
        localbn.gm(paramb.rzG);
        localbn.go(paramb.rzu);
        localbn.gp(paramb.rzK);
        localObject1 = g.ad(com.tencent.mm.plugin.thumbplayer.a.a.class);
        k.g(localObject1, "MMKernel.plugin(IPluginThumbPlayer::class.java)");
        long l1 = l2;
        if (((com.tencent.mm.plugin.thumbplayer.a.a)localObject1).isOpenTPPlayer()) {
          l1 = 1L;
        }
        localbn.gs(l1);
        localbn.gu(paramb.ryd);
        localbn.gv(paramb.ryc);
        localbn.jJ(paramb.rzR + ';' + paramb.rzP + ';' + paramb.rzO + ';' + paramb.rzQ + ';' + paramb.frameRate + ';' + paramb.rzS + ';' + paramb.rzT + ';');
        localObject2 = this.contextObj.qox;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localbn.jL((String)localObject1);
        localObject2 = this.contextObj.qom;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localbn.jK((String)localObject1);
        localObject1 = d.rxr;
        localbn.jM(d.G(paramb.rze, this.contextObj.rfR));
        localObject1 = b.rCU;
        localbn.gw(((Number)b.czd().first).intValue());
        localbn.jG(String.valueOf(paramb.rzi));
        localObject1 = d.rxr;
        localObject1 = d.ur(paramb.rze);
        if (localObject1 != null) {
          localbn.jF(((FinderItem)localObject1).getUserName());
        }
        for (localObject1 = y.KTp;; localObject1 = y.KTp)
        {
          localObject1 = new JSONArray();
          localObject2 = ((Iterable)paramb.rzL).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            apa localapa = (apa)((Iterator)localObject2).next();
            try
            {
              localJSONObject = new JSONObject();
              localJSONObject.put("waitMs", localapa.EHV);
              localJSONObject.put("percent", localapa.percent);
              localJSONObject.put("type", localapa.type);
              ((JSONArray)localObject1).put(localJSONObject);
            }
            catch (Exception localException2) {}
          }
          localbn.jF("");
        }
        localObject1 = ((JSONArray)localObject1).toString();
        k.g(localObject1, "waitingDetails.toString()");
        localbn.jE(d.n.n.h((String)localObject1, ",", ";", false));
        localObject1 = "";
        localObject2 = ((Iterable)paramb.rzM).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          i = ((Number)((Iterator)localObject2).next()).intValue();
          localObject1 = (String)localObject1 + i + ';';
        }
        localbn.jH((String)localObject1);
        localbn.dyF();
        localObject1 = d.rxr;
        d.a((com.tencent.mm.plugin.report.a)localbn);
        localObject1 = paramb.rzI;
        if (localObject1 != null)
        {
          localObject2 = new ajp();
          ((ajp)localObject2).dig = paramb.rze;
          ((ajp)localObject2).zkd = 0;
          ((ajp)localObject2).EEl = ((int)localbn.QI());
          ((ajp)localObject2).EEn = ((int)localbn.QH());
          ((ajp)localObject2).EEi = ((int)localbn.getFileSize());
          ((ajp)localObject2).EEh = d.h.a.cj((float)(localbn.getFileSize() * localbn.QE()) / 100.0F);
          ((ajp)localObject2).kRY = d.h.a.cj((float)(localbn.QG() * localbn.getFileSize()) / 100.0F);
          ((ajp)localObject2).scene = this.contextObj.rfR;
          ((ajp)localObject2).duration = locall.rtl.videoDuration;
          ((ajp)localObject2).rzk = ((int)localbn.getPosition());
          ((ajp)localObject2).EEm = ce.azK();
          ((ajp)localObject2).EEj = ((int)paramb.rya);
          ((ajp)localObject2).EEk = ((int)paramb.rzE);
          ((ajp)localObject2).rzL = paramb.rzL;
          ((ajp)localObject2).drn = paramb.rzO;
          ((ajp)localObject2).EEo = ((m.c)localObject1).averageConnectCost;
          ((ajp)localObject2).rzW = ((m.c)localObject1).rzW;
          ((ajp)localObject2).rzX = ((m.c)localObject1).rzX;
          ((ajp)localObject2).networkId = ((m.c)localObject1).netType;
          ((ajp)localObject2).rzi = paramb.rzi;
          if (rzc.size() > 2) {
            rzc.remove(0);
          }
          rzc.add(localObject2);
          ac.i("Finder.FinderVideoPlayReporter", "downloadInfoList " + rzc.size());
          paramb = y.KTp;
        }
      }
      paramb = y.KTp;
      AppMethodBeat.o(166703);
      return;
    }
    AppMethodBeat.o(166703);
  }
  
  final void b(m.b paramb)
  {
    AppMethodBeat.i(166704);
    if (paramb != null)
    {
      Object localObject = com.tencent.mm.plugin.finder.utils.n.rPN;
      bqs localbqs = paramb.rzh;
      d locald = paramb.rzH;
      m.c localc = paramb.rzI;
      gk localgk;
      long l1;
      if ((localbqs != null) && (locald != null) && (localc != null))
      {
        localgk = new gk();
        localObject = com.tencent.mm.plugin.finder.storage.logic.c.rFo;
        localObject = paramb.rzg;
        if (localObject != null)
        {
          String str = ((com.tencent.mm.plugin.finder.loader.l)localObject).abW();
          localObject = str;
          if (str != null) {}
        }
        else
        {
          localObject = "";
        }
        localObject = com.tencent.mm.plugin.finder.storage.logic.c.aei((String)localObject);
        long l2 = d.h.a.J((float)(paramb.rzp * ((w)localObject).field_totalSize) / 100.0F);
        localObject = localgk.nE(com.tencent.mm.ac.c.pb(paramb.rze)).kt(this.contextObj.rfR + 100).ku(paramb.rzv);
        if (paramb.rzk != 0) {
          break label589;
        }
        l1 = 1L;
        localObject = ((gk)localObject).kv(l1).kw(localbqs.videoDuration).kx(d.h.a.J(localbqs.videoDuration * paramb.rzn / 100.0F)).ky(paramb.rzB).kz(paramb.rzr).kA(paramb.rzK).Sm().kC(0L).kD(localc.retCode).nF("").kE(paramb.rzP).nG(String.valueOf(locald.requestVideoFormat)).kF(localc.ixc).kG(localc.recvedBytes).kH(localc.startTime).kI(localc.endTime).kJ(localc.retCode).kK(localc.enQueueTime).kL(localc.moovRequestTimes).kM(localc.moovCost).kN(localc.moovSize);
        if (!localc.moovCompleted) {
          break label594;
        }
        l1 = 1L;
        label353:
        localObject = ((gk)localObject).kO(l1).kP(localc.moovFailReason).kQ(localc.firstConnectCost).kR(localc.firstRequestCost).kS(localc.firstRequestSize).kT(localc.firstRequestDownloadSize);
        if (!localc.firstRequestCompleted) {
          break label599;
        }
        l1 = 1L;
        label416:
        localObject = ((gk)localObject).kU(l1).kV(localc.averageSpeed).kW(localc.averageConnectCost).kX(localc.netConnectTimes).nH(localc.rzU).nI(localc.clientIP);
        if (!localc.rzV) {
          break label604;
        }
        l1 = 1L;
        label477:
        localObject = ((gk)localObject).kY(l1).kZ(locald.frC).la(0L).lb(paramb.rzu).lc(paramb.rzj).ld(l2).So().iu(localc.transportProtocol).iv(localc.transportProtocolError);
        if (!com.tencent.mm.sdk.platformtools.h.DEBUG) {
          break label609;
        }
        l1 = 0L;
        label543:
        ((gk)localObject).le(l1);
        if (paramb.rzC != 0) {
          break label616;
        }
        localgk.kB(0L);
      }
      for (;;)
      {
        localgk.aHZ();
        paramb = d.rxr;
        d.a((com.tencent.mm.plugin.report.a)localgk);
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
        l1 = 42L;
        break label543;
        label616:
        localgk.kB(paramb.rzE / paramb.rzC);
      }
    }
    AppMethodBeat.o(166704);
  }
  
  public final void b(anm paramanm)
  {
    AppMethodBeat.i(202823);
    k.h(paramanm, "contextObj");
    this.contextObj = paramanm;
    AppMethodBeat.o(202823);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/report/FinderVideoPlayReporter$ReportTaskInfo;", "", "mediaId", "", "(Ljava/lang/String;)V", "getMediaId", "()Ljava/lang/String;", "moovPos", "", "getMoovPos", "()J", "setMoovPos", "(J)V", "requestVideoFormat", "", "getRequestVideoFormat", "()I", "setRequestVideoFormat", "(I)V", "component1", "copy", "equals", "", "other", "hashCode", "toString", "plugin-finder_release"})
  public static final class d
  {
    long frC;
    private final String mediaId;
    int requestVideoFormat;
    
    public d(String paramString)
    {
      AppMethodBeat.i(202818);
      this.mediaId = paramString;
      AppMethodBeat.o(202818);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(202821);
      if (this != paramObject)
      {
        if ((paramObject instanceof d))
        {
          paramObject = (d)paramObject;
          if (!k.g(this.mediaId, paramObject.mediaId)) {}
        }
      }
      else
      {
        AppMethodBeat.o(202821);
        return true;
      }
      AppMethodBeat.o(202821);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(202820);
      String str = this.mediaId;
      if (str != null)
      {
        int i = str.hashCode();
        AppMethodBeat.o(202820);
        return i;
      }
      AppMethodBeat.o(202820);
      return 0;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(202819);
      String str = "ReportTaskInfo(mediaId=" + this.mediaId + ")";
      AppMethodBeat.o(202819);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.m
 * JD-Core Version:    0.7.0.1
 */