package com.tencent.mm.plugin.finder.report;

import android.content.Context;
import android.content.res.Resources;
import android.media.AudioManager;
import android.util.DisplayMetrics;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.cc;
import com.tencent.mm.g.b.a.hp;
import com.tencent.mm.i.d;
import com.tencent.mm.model.ch;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.event.c.a;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.b;
import com.tencent.mm.protocal.protobuf.amw;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.protocal.protobuf.atl;
import com.tencent.mm.protocal.protobuf.bvz;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import d.l;
import d.n.n;
import d.o;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import org.json.JSONArray;
import org.json.JSONObject;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/report/FinderVideoPlayReporter;", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "IDKEY", "", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "setContextObj", "currentVideoReportMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/report/FinderVideoPlayReporter$ReportData;", "getCurrentVideoReportMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "setCurrentVideoReportMap", "(Ljava/util/concurrent/ConcurrentHashMap;)V", "lazyReportDataList", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "getLazyReportDataList", "()Ljava/util/concurrent/ConcurrentLinkedDeque;", "setLazyReportDataList", "(Ljava/util/concurrent/ConcurrentLinkedDeque;)V", "baseInfoLog", "", "eventName", "reportData", "checkVideoDataAvailable", "", "event", "Lcom/tencent/mm/plugin/finder/event/PlayEventSubscriber$PlayEvent;", "cloneSceneResult", "Lcom/tencent/mm/plugin/finder/report/FinderVideoPlayReporter$ReportSceneResult;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "cloneTaskInfo", "Lcom/tencent/mm/plugin/finder/report/FinderVideoPlayReporter$ReportTaskInfo;", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "onDownloadFinish", "onDownloadProgress", "onDownloadStart", "onDownloadStop", "onFirstFrameUpdate", "onMoovReady", "onPause", "onPlayError", "onPlayProgress", "onRelease", "onReplay", "onResume", "onSeek", "onStartPlay", "onStopPlay", "onTabChange", "onUserClickPause", "onWaiting", "onWaitingEnd", "report17000", "report19059", "reportIdkey", "struct", "Lcom/tencent/mm/autogen/mmdata/rpt/FinderVideoPlayStruct;", "Companion", "ReportData", "ReportSceneResult", "ReportTaskInfo", "plugin-finder_release"})
public final class s
{
  private static final LinkedList<amw> sAW;
  private static final LinkedList<amw> sAX;
  public static final a sAY;
  ConcurrentHashMap<Long, b> DQY;
  private arn rQw;
  ConcurrentLinkedDeque<b> sAT;
  private final int sAV;
  
  static
  {
    AppMethodBeat.i(166706);
    sAY = new a((byte)0);
    sAW = new LinkedList();
    sAX = new LinkedList();
    AppMethodBeat.o(166706);
  }
  
  public s(arn paramarn)
  {
    AppMethodBeat.i(203937);
    this.rQw = paramarn;
    this.sAT = new ConcurrentLinkedDeque();
    this.DQY = new ConcurrentHashMap();
    this.sAV = 1505;
    AppMethodBeat.o(203937);
  }
  
  static String a(String paramString, b paramb)
  {
    AppMethodBeat.i(203932);
    paramString = paramString + " feedId:" + com.tencent.mm.ac.c.rp(paramb.sAZ) + " mediaId:" + paramb.sBa + " position:" + paramb.sBe + " bgPreparedStatus:" + paramb.rYZ;
    AppMethodBeat.o(203932);
    return paramString;
  }
  
  public static c b(d paramd)
  {
    AppMethodBeat.i(203936);
    d.g.b.p.h(paramd, "sceneResult");
    String str = paramd.mediaId;
    Object localObject = str;
    if (str == null) {
      localObject = "";
    }
    localObject = new c((String)localObject);
    ((c)localObject).retCode = paramd.field_retCode;
    ((c)localObject).iTe = paramd.field_fileLength;
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
    str = paramd.XZ();
    if (str != null) {
      ((c)localObject).aiO(str);
    }
    str = paramd.field_clientIP;
    if (str != null) {
      ((c)localObject).aiP(str);
    }
    ((c)localObject).sBQ = paramd.field_isCrossNet;
    ((c)localObject).transportProtocol = paramd.transportProtocol;
    ((c)localObject).transportProtocolError = paramd.transportProtocolError;
    str = paramd.fKZ;
    if (str != null) {
      ((c)localObject).aiQ(str);
    }
    ((c)localObject).sBS = paramd.lastSvrPort;
    ((c)localObject).netType = paramd.lastNetType;
    AppMethodBeat.o(203936);
    return localObject;
  }
  
  private static d b(com.tencent.mm.i.h paramh)
  {
    AppMethodBeat.i(203935);
    d.g.b.p.h(paramh, "cloneTaskInfo");
    String str = paramh.field_mediaId;
    Object localObject = str;
    if (str == null) {
      localObject = "";
    }
    localObject = new d((String)localObject);
    ((d)localObject).requestVideoFormat = paramh.field_requestVideoFormat;
    ((d)localObject).fLO = paramh.fLO;
    AppMethodBeat.o(203935);
    return localObject;
  }
  
  public final void a(c.a parama)
  {
    AppMethodBeat.i(203933);
    d.g.b.p.h(parama, "event");
    Object localObject1 = (b)this.DQY.get(Long.valueOf(parama.duw));
    if ((localObject1 != null) && (((b)localObject1).sBD))
    {
      localObject2 = parama.ivf;
      if ((localObject2 != null) && (((b)localObject1).sBB == null)) {
        ((b)localObject1).sBB = b((com.tencent.mm.i.h)localObject2);
      }
      localObject2 = parama.gzD;
      if ((localObject2 != null) && (((b)localObject1).sBC == null)) {
        ((b)localObject1).sBC = b((d)localObject2);
      }
      ((b)localObject1).sBD = false;
      d.g.b.p.g(localObject1, "this");
      ae.i("Finder.FinderVideoPlayReporter", String.valueOf(a("onDownloadStop", (b)localObject1)));
    }
    localObject1 = (Iterable)this.sAT;
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
      if (((b)localObject1).sAZ == parama.duw)
      {
        String str = ((b)localObject1).sBa;
        localObject1 = parama.rYW;
        if (localObject1 != null)
        {
          localObject1 = ((m)localObject1).aeM();
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
    localObject1 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (b)((Iterator)localObject2).next();
      localObject4 = parama.ivf;
      if ((localObject4 != null) && (((b)localObject3).sBB == null)) {
        ((b)localObject3).sBB = b((com.tencent.mm.i.h)localObject4);
      }
      localObject4 = parama.gzD;
      if ((localObject4 != null) && (((b)localObject3).sBC == null)) {
        ((b)localObject3).sBC = b((d)localObject4);
      }
      ((Collection)localObject1).add(localObject3);
    }
    parama = (List)localObject1;
    this.sAT.removeAll((Collection)parama);
    ae.i("Finder.FinderVideoPlayReporter", "lazyReportDataList " + this.sAT.size() + " reportList " + parama.size());
    parama = ((Iterable)parama).iterator();
    while (parama.hasNext())
    {
      localObject1 = (b)parama.next();
      a((b)localObject1);
      b((b)localObject1);
    }
    AppMethodBeat.o(203933);
  }
  
  final void a(b paramb)
  {
    AppMethodBeat.i(166703);
    label297:
    label3021:
    if (paramb != null)
    {
      if (paramb.sAZ == 0L)
      {
        AppMethodBeat.o(166703);
        return;
      }
      m localm = paramb.sBb;
      cc localcc;
      Object localObject1;
      Object localObject2;
      if (localm != null)
      {
        localcc = new cc();
        localcc.SG();
        localcc.lB(localm.aeM());
        localcc.hR(this.rQw.sch);
        localcc.hn(localm.srx.videoDuration);
        localcc.ho(paramb.szG);
        localcc.hp(paramb.sBi);
        localcc.hq(paramb.sBj);
        localcc.hr(localm.srx.fileSize);
        localObject1 = com.tencent.mm.plugin.finder.storage.logic.c.sLt;
        long l;
        if (localm != null)
        {
          localObject1 = localm.aeM();
          localObject1 = com.tencent.mm.plugin.finder.storage.logic.c.ajA((String)localObject1);
          if (localObject1 != null)
          {
            localcc.hr(((com.tencent.mm.plugin.finder.model.z)localObject1).field_totalSize);
            localObject1 = d.z.Nhr;
          }
          localcc.hs(paramb.sBg);
          localcc.ht(paramb.sBh);
          localcc.hu(paramb.sBk);
          localObject1 = localcc.hv(paramb.sBl).hw(paramb.sBm).hx(paramb.mbM).lC(paramb.sBn).lD(paramb.sessionId).hy(paramb.sBe).SJ().hz(paramb.lxg).hA(paramb.sBp).hB(paramb.sBq);
          if (!com.tencent.mm.sdk.platformtools.j.DEBUG) {
            break label517;
          }
          l = 0L;
          ((cc)localObject1).hC(l).hD(paramb.iuK).hE(paramb.sBs).hF(paramb.sBt).hG(paramb.szE).hH(paramb.sBv).lE(com.tencent.mm.ac.c.rp(paramb.sAZ)).hI(paramb.sBw).hJ(paramb.sBz);
          localObject1 = paramb.sBC;
          if (localObject1 != null)
          {
            localcc.hL(((c)localObject1).averageSpeed);
            localcc.hO(((c)localObject1).averageConnectCost);
            localcc.lG(((c)localObject1).sBR);
            localcc.hP(((c)localObject1).sBS);
            localcc.iy(((c)localObject1).retCode);
            localObject1 = d.z.Nhr;
          }
          localcc.hV(paramb.sBy);
          localcc.iz(paramb.sBO);
          if (paramb.szM == paramb.szN) {
            break label524;
          }
        }
        for (paramb.sBH = 1;; paramb.sBH = 0)
        {
          localObject1 = ak.getContext().getSystemService("audio");
          if (localObject1 != null) {
            break label532;
          }
          paramb = new v("null cannot be cast to non-null type android.media.AudioManager");
          AppMethodBeat.o(166703);
          throw paramb;
          localObject1 = null;
          break;
          l = 53L;
          break label297;
        }
        i = ((AudioManager)localObject1).getStreamMaxVolume(3);
        localcc.lL(paramb.szM * 100 / i + ';' + paramb.szN * 100 / i + ';' + paramb.sBH);
        localObject1 = new JSONArray();
        localObject2 = ((Iterable)sAW).iterator();
        JSONObject localJSONObject;
        while (((Iterator)localObject2).hasNext())
        {
          amw localamw = (amw)((Iterator)localObject2).next();
          try
          {
            localJSONObject = new JSONObject();
            localJSONObject.put("pos", localamw.sBe);
            localJSONObject.put("spe", localamw.GFd);
            localJSONObject.put("loadCost", localamw.GFf);
            localJSONObject.put("fSize", localamw.GFa);
            ((JSONArray)localObject1).put(localJSONObject);
          }
          catch (Exception localException1) {}
        }
        localObject1 = ((JSONArray)localObject1).toString();
        d.g.b.p.g(localObject1, "historyInfoArray.toString()");
        localcc.lF(n.h((String)localObject1, ",", ";", false));
        localcc.hK(paramb.sBA);
        localcc.hM(paramb.sBo);
        localcc.hN(paramb.sBE);
        localObject1 = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.thumbplayer.a.a.class);
        d.g.b.p.g(localObject1, "MMKernel.plugin(IPluginThumbPlayer::class.java)");
        Object localObject3;
        if (((com.tencent.mm.plugin.thumbplayer.a.a)localObject1).isOpenTPPlayer())
        {
          l = 1L;
          localcc.hQ(l);
          localcc.hS(paramb.szJ);
          localcc.hT(paramb.szI);
          localcc.lM(paramb.sBL + ';' + paramb.sBJ + ';' + paramb.sBI + ';' + paramb.sBK + ';' + paramb.frameRate + ';' + paramb.sBM + ';' + paramb.sBN + ';');
          localObject2 = this.rQw.rfA;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          localcc.lO((String)localObject1);
          localObject2 = this.rQw.rfo;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          localcc.lN((String)localObject1);
          localObject1 = i.syT;
          localcc.lP(i.I(paramb.sAZ, this.rQw.sch));
          localObject1 = b.sHP;
          localcc.hU(((Number)b.cHV().first).intValue());
          localcc.lJ(String.valueOf(paramb.sBd));
          localcc.iA(paramb.sBJ);
          localcc.lQ(paramb.sBL);
          localcc.lR(paramb.sBI);
          localcc.iB(paramb.sBK);
          localcc.iC(paramb.frameRate);
          localcc.iD((int)(paramb.sBM * paramb.sBN));
          localObject3 = new JSONObject();
          ((JSONObject)localObject3).put("videoWidth", Float.valueOf(paramb.sBM));
          ((JSONObject)localObject3).put("videoHeight", Float.valueOf(paramb.sBN));
          localObject1 = ak.getContext();
          d.g.b.p.g(localObject1, "MMApplicationContext.getContext()");
          localObject1 = ((Context)localObject1).getResources();
          d.g.b.p.g(localObject1, "MMApplicationContext.getContext().resources");
          ((JSONObject)localObject3).put("screenWidth", ((Resources)localObject1).getDisplayMetrics().widthPixels);
          localObject1 = ak.getContext();
          d.g.b.p.g(localObject1, "MMApplicationContext.getContext()");
          localObject1 = ((Context)localObject1).getResources();
          d.g.b.p.g(localObject1, "MMApplicationContext.getContext().resources");
          ((JSONObject)localObject3).put("screenHeight", ((Resources)localObject1).getDisplayMetrics().heightPixels);
          localObject1 = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getMediaPreloadModel();
          ((JSONObject)localObject3).put("isMultiBitRate", ((com.tencent.mm.plugin.finder.preload.model.a)localObject1).suq);
          ((JSONObject)localObject3).put("isSecondPre", ((com.tencent.mm.plugin.finder.preload.model.a)localObject1).sur);
          ((JSONObject)localObject3).put("playLinkCnt", ((com.tencent.mm.plugin.finder.preload.model.a)localObject1).sui);
          ((JSONObject)localObject3).put("preLinkCnt", ((com.tencent.mm.plugin.finder.preload.model.a)localObject1).suh);
          ((JSONObject)localObject3).put("startPrePercent", ((com.tencent.mm.plugin.finder.preload.model.a)localObject1).suj);
          ((JSONObject)localObject3).put("startPreSec", ((com.tencent.mm.plugin.finder.preload.model.a)localObject1).suk);
          ((JSONObject)localObject3).put("preTaskCnt", ((com.tencent.mm.plugin.finder.preload.model.a)localObject1).sug);
          ((JSONObject)localObject3).put("maxPrePercent", ((com.tencent.mm.plugin.finder.preload.model.a)localObject1).sue);
          ((JSONObject)localObject3).put("maxPreBytes", ((com.tencent.mm.plugin.finder.preload.model.a)localObject1).suf);
          ((JSONObject)localObject3).put("prevCnt", ((com.tencent.mm.plugin.finder.preload.model.a)localObject1).suc);
          ((JSONObject)localObject3).put("nextCnt", ((com.tencent.mm.plugin.finder.preload.model.a)localObject1).sud);
          ((JSONObject)localObject3).put("maxPreBitRate", ((com.tencent.mm.plugin.finder.preload.model.a)localObject1).sul);
          localObject2 = (String)((com.tencent.mm.plugin.finder.preload.model.a)localObject1).sup.get(localcc.getMediaId());
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          ((JSONObject)localObject3).put("findSpecStep", localObject1);
          ((JSONObject)localObject3).put("playDecoderType", paramb.playDecoderType);
          localObject1 = d.z.Nhr;
          localObject1 = ((JSONObject)localObject3).toString();
          d.g.b.p.g(localObject1, "JSONObject().apply {\n   …             }.toString()");
          localcc.lS(n.h((String)localObject1, ",", ";", false));
          localObject1 = this.rQw.extraInfo;
          if (localObject1 != null)
          {
            localObject2 = n.h((String)localObject1, ",", ";", false);
            localObject1 = localObject2;
            if (localObject2 != null) {}
          }
          else
          {
            localObject1 = "";
          }
          localcc.lT((String)localObject1);
          localObject1 = this.rQw.rfr;
          if (localObject1 != null)
          {
            localObject2 = n.h((String)localObject1, ",", ";", false);
            localObject1 = localObject2;
            if (localObject2 != null) {}
          }
          else
          {
            localObject1 = "";
          }
          localcc.lU((String)localObject1);
          localObject1 = i.syT;
          localObject1 = i.wJ(paramb.sAZ);
          if (localObject1 == null) {
            break label1791;
          }
          localcc.lI(((FinderItem)localObject1).getUserName());
        }
        for (localObject1 = d.z.Nhr;; localObject1 = d.z.Nhr)
        {
          localObject1 = new JSONArray();
          localObject2 = ((Iterable)paramb.sBF).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (atl)((Iterator)localObject2).next();
            try
            {
              localJSONObject = new JSONObject();
              localJSONObject.put("waitMs", ((atl)localObject3).GKm);
              localJSONObject.put("percent", ((atl)localObject3).percent);
              localJSONObject.put("type", ((atl)localObject3).type);
              ((JSONArray)localObject1).put(localJSONObject);
            }
            catch (Exception localException2) {}
          }
          l = 0L;
          break;
          label1791:
          localcc.lI("");
        }
        localObject1 = ((JSONArray)localObject1).toString();
        d.g.b.p.g(localObject1, "waitingDetails.toString()");
        localcc.lH(n.h((String)localObject1, ",", ";", false));
        localObject1 = "";
        localObject2 = ((Iterable)paramb.sBG).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          i = ((Number)((Iterator)localObject2).next()).intValue();
          localObject1 = (String)localObject1 + i + ';';
        }
        localcc.lK((String)localObject1);
        localcc.dNp();
        localObject1 = new ArrayList(8);
        if (localcc.SO() > 0L)
        {
          localObject2 = new IDKey();
          ((IDKey)localObject2).SetID(this.sAV);
          ((IDKey)localObject2).SetKey(0);
          ((IDKey)localObject2).SetValue(localcc.SO());
          ((ArrayList)localObject1).add(localObject2);
        }
        if ((localcc.SL() > 0L) && (localcc.SO() > 0L))
        {
          localObject2 = new IDKey();
          ((IDKey)localObject2).SetID(this.sAV);
          ((IDKey)localObject2).SetKey(1);
          ((IDKey)localObject2).SetValue(localcc.SO());
          ((ArrayList)localObject1).add(localObject2);
        }
        if ((localcc.SL() > 0L) && (localcc.SH() > 0L))
        {
          localObject2 = new IDKey();
          ((IDKey)localObject2).SetID(this.sAV);
          ((IDKey)localObject2).SetKey(2);
          ((IDKey)localObject2).SetValue(1L);
          ((ArrayList)localObject1).add(localObject2);
        }
        if ((localcc.SL() > 0L) && (localcc.SM() > 0L))
        {
          localObject2 = new IDKey();
          ((IDKey)localObject2).SetID(this.sAV);
          ((IDKey)localObject2).SetKey(3);
          ((IDKey)localObject2).SetValue(localcc.SM());
          ((ArrayList)localObject1).add(localObject2);
          if (localcc.SM() > 500L) {
            break label2913;
          }
          localObject2 = new IDKey();
          ((IDKey)localObject2).SetID(this.sAV);
          ((IDKey)localObject2).SetKey(5);
          ((IDKey)localObject2).SetValue(1L);
          ((ArrayList)localObject1).add(localObject2);
        }
        if ((localcc.SL() > 0L) && (localcc.SQ() > 0L))
        {
          localObject2 = new IDKey();
          ((IDKey)localObject2).SetID(this.sAV);
          ((IDKey)localObject2).SetKey(4);
          ((IDKey)localObject2).SetValue(localcc.SQ());
          ((ArrayList)localObject1).add(localObject2);
        }
        if (localcc.SP() == 1L)
        {
          localObject2 = new IDKey();
          ((IDKey)localObject2).SetID(this.sAV);
          ((IDKey)localObject2).SetValue(1L);
          if (paramb.playDecoderType != 102) {
            break label3021;
          }
          ((IDKey)localObject2).SetKey(104);
          ((ArrayList)localObject1).add(localObject2);
        }
        localObject2 = new IDKey();
        ((IDKey)localObject2).SetID(this.sAV);
        ((IDKey)localObject2).SetKey(100);
        ((IDKey)localObject2).SetValue(1L);
        ((ArrayList)localObject1).add(localObject2);
        if (localcc.SL() > 0L)
        {
          localObject2 = new IDKey();
          ((IDKey)localObject2).SetID(this.sAV);
          ((IDKey)localObject2).SetKey(101);
          ((IDKey)localObject2).SetValue(1L);
          ((ArrayList)localObject1).add(localObject2);
        }
        if ((localcc.SL() > 0L) && (localcc.SM() > 0L))
        {
          localObject2 = new IDKey();
          ((IDKey)localObject2).SetID(this.sAV);
          ((IDKey)localObject2).SetKey(102);
          ((IDKey)localObject2).SetValue(1L);
          ((ArrayList)localObject1).add(localObject2);
        }
        if ((localcc.SL() > 0L) && (localcc.SQ() > 0L))
        {
          localObject2 = new IDKey();
          ((IDKey)localObject2).SetID(this.sAV);
          ((IDKey)localObject2).SetKey(103);
          ((IDKey)localObject2).SetValue(1L);
          ((ArrayList)localObject1).add(localObject2);
        }
        if (((Collection)localObject1).isEmpty()) {
          break label3048;
        }
      }
      label2913:
      label3048:
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          com.tencent.mm.plugin.report.service.g.yxI.b((ArrayList)localObject1, false);
        }
        localObject1 = i.syT;
        i.a((com.tencent.mm.plugin.report.a)localcc);
        localObject1 = paramb.sBC;
        if (localObject1 != null)
        {
          localObject2 = new amw();
          ((amw)localObject2).duw = paramb.sAZ;
          ((amw)localObject2).GEY = 0;
          ((amw)localObject2).GFd = ((int)localcc.SN());
          ((amw)localObject2).GFf = ((int)localcc.SM());
          ((amw)localObject2).GFa = ((int)localcc.getFileSize());
          ((amw)localObject2).GEZ = d.h.a.cm((float)(localcc.getFileSize() * localcc.SI()) / 100.0F);
          ((amw)localObject2).lsY = d.h.a.cm((float)(localcc.SK() * localcc.getFileSize()) / 100.0F);
          ((amw)localObject2).scene = this.rQw.sch;
          ((amw)localObject2).duration = localm.srx.videoDuration;
          ((amw)localObject2).sBe = ((int)localcc.getPosition());
          ((amw)localObject2).GFe = ch.aDd();
          ((amw)localObject2).GFb = ((int)paramb.szG);
          ((amw)localObject2).GFc = ((int)paramb.sBy);
          ((amw)localObject2).sBF = paramb.sBF;
          ((amw)localObject2).dEk = paramb.sBI;
          ((amw)localObject2).GFg = ((c)localObject1).averageConnectCost;
          ((amw)localObject2).sBR = ((c)localObject1).sBR;
          ((amw)localObject2).sBS = ((c)localObject1).sBS;
          ((amw)localObject2).networkId = ((c)localObject1).netType;
          ((amw)localObject2).sBd = paramb.sBd;
          if (sAW.size() > 2) {
            sAW.remove(0);
          }
          sAW.add(localObject2);
          sAX.add(localObject2);
          ae.i("Finder.FinderVideoPlayReporter", "downloadInfoList " + sAW.size());
          paramb = d.z.Nhr;
        }
        paramb = d.z.Nhr;
        AppMethodBeat.o(166703);
        return;
        if (localcc.SM() <= 1000L)
        {
          localObject2 = new IDKey();
          ((IDKey)localObject2).SetID(this.sAV);
          ((IDKey)localObject2).SetKey(6);
          ((IDKey)localObject2).SetValue(1L);
          ((ArrayList)localObject1).add(localObject2);
          break;
        }
        if (localcc.SM() <= 1000L) {
          break;
        }
        localObject2 = new IDKey();
        ((IDKey)localObject2).SetID(this.sAV);
        ((IDKey)localObject2).SetKey(7);
        ((IDKey)localObject2).SetValue(1L);
        ((ArrayList)localObject1).add(localObject2);
        break;
        if (paramb.playDecoderType != 101) {
          break label2340;
        }
        ((IDKey)localObject2).SetKey(105);
        ((ArrayList)localObject1).add(localObject2);
        break label2340;
      }
    }
    label517:
    label524:
    label532:
    label2340:
    AppMethodBeat.o(166703);
  }
  
  final void b(b paramb)
  {
    AppMethodBeat.i(166704);
    if (paramb != null)
    {
      Object localObject = com.tencent.mm.plugin.finder.utils.p.sXz;
      bvz localbvz = paramb.sBc;
      d locald = paramb.sBB;
      c localc = paramb.sBC;
      hp localhp;
      long l1;
      if ((localbvz != null) && (locald != null) && (localc != null))
      {
        localhp = new hp();
        localObject = com.tencent.mm.plugin.finder.storage.logic.c.sLt;
        localObject = paramb.sBb;
        if (localObject != null)
        {
          String str = ((m)localObject).aeM();
          localObject = str;
          if (str != null) {}
        }
        else
        {
          localObject = "";
        }
        localObject = com.tencent.mm.plugin.finder.storage.logic.c.ajA((String)localObject);
        long l2 = d.h.a.K((float)(paramb.sBj * ((com.tencent.mm.plugin.finder.model.z)localObject).field_totalSize) / 100.0F);
        localObject = localhp.qy(com.tencent.mm.ac.c.rp(paramb.sAZ)).mz(this.rQw.sch + 100).mA(paramb.sBp);
        if (paramb.sBe != 0) {
          break label589;
        }
        l1 = 1L;
        localObject = ((hp)localObject).mB(l1).mC(localbvz.videoDuration).mD(d.h.a.K(localbvz.videoDuration * paramb.sBh / 100.0F)).mE(paramb.sBv).mF(paramb.sBl).mG(paramb.sBE).UG().mI(0L).mJ(localc.retCode).qz("").mK(paramb.sBJ).qA(String.valueOf(locald.requestVideoFormat)).mL(localc.iTe).mM(localc.recvedBytes).mN(localc.startTime).mO(localc.endTime).mP(localc.retCode).mQ(localc.enQueueTime).mR(localc.moovRequestTimes).mS(localc.moovCost).mT(localc.moovSize);
        if (!localc.moovCompleted) {
          break label594;
        }
        l1 = 1L;
        label353:
        localObject = ((hp)localObject).mU(l1).mV(localc.moovFailReason).mW(localc.firstConnectCost).mX(localc.firstRequestCost).mY(localc.firstRequestSize).mZ(localc.firstRequestDownloadSize);
        if (!localc.firstRequestCompleted) {
          break label599;
        }
        l1 = 1L;
        label416:
        localObject = ((hp)localObject).na(l1).nb(localc.averageSpeed).nc(localc.averageConnectCost).nd(localc.netConnectTimes).qB(localc.sBP).qC(localc.clientIP);
        if (!localc.sBQ) {
          break label604;
        }
        l1 = 1L;
        label477:
        localObject = ((hp)localObject).ne(l1).nf(locald.fLO).ng(0L).nh(paramb.sBo).ni(paramb.mbM).nj(l2).UI().iP(localc.transportProtocol).iQ(localc.transportProtocolError);
        if (!com.tencent.mm.sdk.platformtools.j.DEBUG) {
          break label609;
        }
        l1 = 0L;
        label543:
        ((hp)localObject).nk(l1);
        if (paramb.sBw != 0) {
          break label616;
        }
        localhp.mH(0L);
      }
      for (;;)
      {
        localhp.aLH();
        paramb = i.syT;
        i.a((com.tencent.mm.plugin.report.a)localhp);
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
        l1 = 53L;
        break label543;
        label616:
        localhp.mH(paramb.sBy / paramb.sBw);
      }
    }
    AppMethodBeat.o(166704);
  }
  
  public final void c(arn paramarn)
  {
    AppMethodBeat.i(203934);
    d.g.b.p.h(paramarn, "contextObj");
    this.rQw = paramarn;
    AppMethodBeat.o(203934);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/report/FinderVideoPlayReporter$Companion;", "", "()V", "INNER_VERSION", "", "TAG", "", "downloadInfoAllList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderDownloadInfo;", "getDownloadInfoAllList", "()Ljava/util/LinkedList;", "downloadInfoList", "getDownloadInfoList", "plugin-finder_release"})
  public static final class a {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/report/FinderVideoPlayReporter$ReportData;", "", "()V", "adjustVolume", "", "getAdjustVolume", "()I", "setAdjustVolume", "(I)V", "bgPreparedStatus", "getBgPreparedStatus", "setBgPreparedStatus", "currentFeedId", "", "getCurrentFeedId", "()J", "setCurrentFeedId", "(J)V", "currentMedia", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "getCurrentMedia", "()Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "setCurrentMedia", "(Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;)V", "currentMediaId", "", "getCurrentMediaId", "()Ljava/lang/String;", "setCurrentMediaId", "(Ljava/lang/String;)V", "currentVideo", "Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "getCurrentVideo", "()Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "setCurrentVideo", "(Lcom/tencent/mm/plugin/finder/loader/FinderVideo;)V", "currentWaiting", "", "getCurrentWaiting", "()Z", "setCurrentWaiting", "(Z)V", "downloadFinishTime", "getDownloadFinishTime", "setDownloadFinishTime", "downloadPercent", "getDownloadPercent", "setDownloadPercent", "downloadSpeed", "getDownloadSpeed", "setDownloadSpeed", "endVolume", "getEndVolume", "setEndVolume", "fetchTimestamp", "getFetchTimestamp", "setFetchTimestamp", "firstFrameTime", "getFirstFrameTime", "setFirstFrameTime", "firstLoadTime", "getFirstLoadTime", "setFirstLoadTime", "firstPlay", "getFirstPlay", "setFirstPlay", "firstRequestDataOffset", "getFirstRequestDataOffset", "setFirstRequestDataOffset", "frameRate", "getFrameRate", "setFrameRate", "hitPreload", "getHitPreload", "setHitPreload", "hitPreloadPercent", "getHitPreloadPercent", "setHitPreloadPercent", "isPause", "setPause", "isSeek", "setSeek", "isStartDownload", "setStartDownload", "mediaPath", "getMediaPath", "setMediaPath", "moovReadyOffset", "getMoovReadyOffset", "setMoovReadyOffset", "moovReadyTime", "getMoovReadyTime", "setMoovReadyTime", "netType", "getNetType", "setNetType", "netTypeInt", "getNetTypeInt", "setNetTypeInt", "pauseTimestamp", "getPauseTimestamp", "setPauseTimestamp", "pauseTotalTime", "getPauseTotalTime", "setPauseTotalTime", "playAudioBitrate", "getPlayAudioBitrate", "setPlayAudioBitrate", "playCodeFormat", "getPlayCodeFormat", "setPlayCodeFormat", "playDecoderType", "getPlayDecoderType", "setPlayDecoderType", "playFileFormat", "getPlayFileFormat", "setPlayFileFormat", "playPageIndex", "getPlayPageIndex", "setPlayPageIndex", "playPercent", "getPlayPercent", "setPlayPercent", "playPercentSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "getPlayPercentSet", "()Ljava/util/HashSet;", "setPlayPercentSet", "(Ljava/util/HashSet;)V", "playPosition", "getPlayPosition", "setPlayPosition", "playStatus", "getPlayStatus", "setPlayStatus", "playTime", "getPlayTime", "setPlayTime", "playVideoBitrate", "getPlayVideoBitrate", "setPlayVideoBitrate", "playWaitingCount", "getPlayWaitingCount", "setPlayWaitingCount", "playerErrCode", "getPlayerErrCode", "setPlayerErrCode", "playing", "getPlaying", "setPlaying", "preloadStrategyId", "getPreloadStrategyId", "setPreloadStrategyId", "realPlayTime", "getRealPlayTime", "setRealPlayTime", "realPlayTimestamp", "getRealPlayTimestamp", "setRealPlayTimestamp", "replayCount", "getReplayCount", "setReplayCount", "reportSceneResult", "Lcom/tencent/mm/plugin/finder/report/FinderVideoPlayReporter$ReportSceneResult;", "getReportSceneResult", "()Lcom/tencent/mm/plugin/finder/report/FinderVideoPlayReporter$ReportSceneResult;", "setReportSceneResult", "(Lcom/tencent/mm/plugin/finder/report/FinderVideoPlayReporter$ReportSceneResult;)V", "reportTaskInfo", "Lcom/tencent/mm/plugin/finder/report/FinderVideoPlayReporter$ReportTaskInfo;", "getReportTaskInfo", "()Lcom/tencent/mm/plugin/finder/report/FinderVideoPlayReporter$ReportTaskInfo;", "setReportTaskInfo", "(Lcom/tencent/mm/plugin/finder/report/FinderVideoPlayReporter$ReportTaskInfo;)V", "sessionId", "getSessionId", "setSessionId", "startTimestamp", "getStartTimestamp", "setStartTimestamp", "startVolume", "getStartVolume", "setStartVolume", "startWaitingTime", "getStartWaitingTime", "setStartWaitingTime", "totalWaitingTime", "getTotalWaitingTime", "setTotalWaitingTime", "videoHeight", "", "getVideoHeight", "()F", "setVideoHeight", "(F)V", "videoWidth", "getVideoWidth", "setVideoWidth", "waitDetails", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderWaitDetail;", "getWaitDetails", "()Ljava/util/LinkedList;", "setWaitDetails", "(Ljava/util/LinkedList;)V", "waitingCount", "getWaitingCount", "setWaitingCount", "plugin-finder_release"})
  public static final class b
  {
    boolean bfZ;
    int frameRate;
    int iuK;
    int lxg;
    long mbM;
    String mediaPath;
    int playDecoderType;
    int rYZ;
    long sAZ;
    long sBA;
    s.d sBB;
    s.c sBC;
    boolean sBD;
    long sBE;
    LinkedList<atl> sBF;
    HashSet<Integer> sBG;
    int sBH;
    String sBI;
    int sBJ;
    int sBK;
    String sBL;
    float sBM;
    float sBN;
    int sBO;
    String sBa;
    m sBb;
    bvz sBc;
    long sBd;
    int sBe;
    int sBf;
    long sBg;
    int sBh;
    int sBi;
    int sBj;
    long sBk;
    long sBl;
    long sBm;
    String sBn;
    long sBo;
    int sBp;
    int sBq;
    boolean sBr;
    int sBs;
    long sBt;
    long sBu;
    long sBv;
    int sBw;
    long sBx;
    long sBy;
    long sBz;
    String sessionId;
    long szE;
    long szF;
    long szG;
    int szI;
    int szJ;
    int szM;
    int szN;
    
    public b()
    {
      AppMethodBeat.i(178402);
      this.sessionId = "";
      this.sBa = "";
      this.mediaPath = "";
      this.sBn = "";
      this.sBF = new LinkedList();
      this.sBG = new HashSet();
      this.sBI = "";
      this.sBL = "";
      AppMethodBeat.o(178402);
    }
    
    public final void aiN(String paramString)
    {
      AppMethodBeat.i(203920);
      d.g.b.p.h(paramString, "<set-?>");
      this.sBI = paramString;
      AppMethodBeat.o(203920);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/report/FinderVideoPlayReporter$ReportSceneResult;", "", "mediaId", "", "(Ljava/lang/String;)V", "averageConnectCost", "", "getAverageConnectCost", "()I", "setAverageConnectCost", "(I)V", "averageSpeed", "getAverageSpeed", "setAverageSpeed", "clientIP", "getClientIP", "()Ljava/lang/String;", "setClientIP", "enQueueTime", "", "getEnQueueTime", "()J", "setEnQueueTime", "(J)V", "endTime", "getEndTime", "setEndTime", "fileLength", "getFileLength", "setFileLength", "firstConnectCost", "getFirstConnectCost", "setFirstConnectCost", "firstRequestCompleted", "", "getFirstRequestCompleted", "()Z", "setFirstRequestCompleted", "(Z)V", "firstRequestCost", "getFirstRequestCost", "setFirstRequestCost", "firstRequestDownloadSize", "getFirstRequestDownloadSize", "setFirstRequestDownloadSize", "firstRequestSize", "getFirstRequestSize", "setFirstRequestSize", "isCrossNet", "setCrossNet", "getMediaId", "moovCompleted", "getMoovCompleted", "setMoovCompleted", "moovCost", "getMoovCost", "setMoovCost", "moovFailReason", "getMoovFailReason", "setMoovFailReason", "moovRequestTimes", "getMoovRequestTimes", "setMoovRequestTimes", "moovSize", "getMoovSize", "setMoovSize", "netConnectTimes", "getNetConnectTimes", "setNetConnectTimes", "netType", "getNetType", "setNetType", "recvedBytes", "getRecvedBytes", "setRecvedBytes", "retCode", "getRetCode", "setRetCode", "rptIpList", "getRptIpList", "setRptIpList", "startTime", "getStartTime", "setStartTime", "svrIp", "getSvrIp", "setSvrIp", "svrPort", "getSvrPort", "setSvrPort", "transportProtocol", "getTransportProtocol", "setTransportProtocol", "transportProtocolError", "getTransportProtocolError", "setTransportProtocolError", "component1", "copy", "equals", "other", "hashCode", "toString", "plugin-finder_release"})
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
    long iTe;
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
    String sBP;
    boolean sBQ;
    String sBR;
    int sBS;
    long startTime;
    int transportProtocol;
    int transportProtocolError;
    
    public c(String paramString)
    {
      AppMethodBeat.i(203924);
      this.mediaId = paramString;
      this.sBP = "";
      this.clientIP = "";
      this.sBR = "";
      AppMethodBeat.o(203924);
    }
    
    public final void aiO(String paramString)
    {
      AppMethodBeat.i(203921);
      d.g.b.p.h(paramString, "<set-?>");
      this.sBP = paramString;
      AppMethodBeat.o(203921);
    }
    
    public final void aiP(String paramString)
    {
      AppMethodBeat.i(203922);
      d.g.b.p.h(paramString, "<set-?>");
      this.clientIP = paramString;
      AppMethodBeat.o(203922);
    }
    
    public final void aiQ(String paramString)
    {
      AppMethodBeat.i(203923);
      d.g.b.p.h(paramString, "<set-?>");
      this.sBR = paramString;
      AppMethodBeat.o(203923);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(203927);
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
        AppMethodBeat.o(203927);
        return true;
      }
      AppMethodBeat.o(203927);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(203926);
      String str = this.mediaId;
      if (str != null)
      {
        int i = str.hashCode();
        AppMethodBeat.o(203926);
        return i;
      }
      AppMethodBeat.o(203926);
      return 0;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(203925);
      String str = "ReportSceneResult(mediaId=" + this.mediaId + ")";
      AppMethodBeat.o(203925);
      return str;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/report/FinderVideoPlayReporter$ReportTaskInfo;", "", "mediaId", "", "(Ljava/lang/String;)V", "getMediaId", "()Ljava/lang/String;", "moovPos", "", "getMoovPos", "()J", "setMoovPos", "(J)V", "requestVideoFormat", "", "getRequestVideoFormat", "()I", "setRequestVideoFormat", "(I)V", "component1", "copy", "equals", "", "other", "hashCode", "toString", "plugin-finder_release"})
  public static final class d
  {
    long fLO;
    private final String mediaId;
    int requestVideoFormat;
    
    public d(String paramString)
    {
      AppMethodBeat.i(203928);
      this.mediaId = paramString;
      AppMethodBeat.o(203928);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(203931);
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
        AppMethodBeat.o(203931);
        return true;
      }
      AppMethodBeat.o(203931);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(203930);
      String str = this.mediaId;
      if (str != null)
      {
        int i = str.hashCode();
        AppMethodBeat.o(203930);
        return i;
      }
      AppMethodBeat.o(203930);
      return 0;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(203929);
      String str = "ReportTaskInfo(mediaId=" + this.mediaId + ")";
      AppMethodBeat.o(203929);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.s
 * JD-Core Version:    0.7.0.1
 */