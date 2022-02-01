package com.tencent.mm.plugin.finder.cgi;

import android.arch.lifecycle.ViewModelProvider;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.modelcontrol.e;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.report.h;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aoz;
import com.tencent.mm.protocal.protobuf.apc;
import com.tencent.mm.protocal.protobuf.ato;
import com.tencent.mm.protocal.protobuf.atp;
import com.tencent.mm.protocal.protobuf.baw;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.blo;
import com.tencent.mm.protocal.protobuf.buj;
import com.tencent.mm.protocal.protobuf.ecq;
import com.tencent.mm.protocal.protobuf.efo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetFeedRelList;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "feedId", "", "nonceId", "", "tabType", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "category", "scene", "fromUserName", "toUserName", "sessionId", "sessionBuffer", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(JLjava/lang/String;ILcom/tencent/mm/protobuf/ByteString;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "stats", "Lcom/tencent/mm/protocal/protobuf/Stats;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListReq;", "(Lcom/tencent/mm/protocal/protobuf/Stats;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListReq;)V", "", "get_column_feed_info", "Lcom/tencent/mm/protocal/protobuf/GetColumnFeedInfo;", "(Lcom/tencent/mm/protobuf/ByteString;ILjava/util/List;Lcom/tencent/mm/protocal/protobuf/GetColumnFeedInfo;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getCategory", "()Ljava/lang/String;", "setCategory", "(Ljava/lang/String;)V", "getFeedId", "()J", "getFromUserName", "getNonceId", "pullType", "getPullType", "()I", "setPullType", "(I)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getScene", "setScene", "getSessionBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "getSessionId", "getTabType", "getToUserName", "buildStatsRequest", "", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getFeedRelList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getRequestBuffer", "getResponse", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListResp;", "getResponseBuffer", "getType", "getWording", "hasContinue", "", "onCgiEnd", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class bh
  extends ax
{
  private final String TAG;
  private i callback;
  private String category;
  private final String dJw;
  private final int dLS;
  private final String dYs;
  public final long feedId;
  private final String hwg;
  public int pullType;
  private com.tencent.mm.ak.d rr;
  private int scene;
  private final String sessionId;
  private final com.tencent.mm.bw.b tvj;
  
  private bh(long paramLong, String paramString1, int paramInt1, com.tencent.mm.bw.b paramb, String paramString2, int paramInt2, String paramString3, String paramString4, String paramString5, bbn parambbn)
  {
    super(parambbn);
    AppMethodBeat.i(242402);
    this.TAG = "Finder.NetSceneFinderGetFeedRelList";
    this.feedId = paramLong;
    this.hwg = paramString1;
    this.dLS = paramInt1;
    this.category = paramString2;
    this.scene = paramInt2;
    this.dYs = paramString3;
    this.dJw = paramString4;
    this.sessionId = paramString5;
    this.tvj = null;
    Object localObject1 = new d.a();
    ((d.a)localObject1).sG(getType());
    ato localato = new ato();
    localato.hFK = paramLong;
    localato.objectNonceId = paramString1;
    localato.dLS = paramInt1;
    Object localObject2 = com.tencent.mm.ui.component.a.PRN;
    com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class);
    localObject2 = FinderGlobalLocationVM.dHP();
    localato.dTj = ((Number)((o)localObject2).first).floatValue();
    localato.latitude = ((Number)((o)localObject2).second).floatValue();
    localato.lastBuffer = paramb;
    localObject2 = am.tuw;
    localato.LAI = am.a(parambbn);
    localObject2 = new aoz();
    ((aoz)localObject2).xjU = paramString2;
    localato.LEr = ((aoz)localObject2);
    localato.dkU = paramString3;
    localato.dkV = paramString4;
    localato.scene = paramInt2;
    localato.LEs = null;
    localato.LEt = paramString5;
    localato.LEu = null;
    a(localato);
    ((d.a)localObject1).c((com.tencent.mm.bw.a)localato);
    ((d.a)localObject1).d((com.tencent.mm.bw.a)new atp());
    ((d.a)localObject1).MB("/cgi-bin/micromsg-bin/findergetrelatedlist");
    localObject1 = ((d.a)localObject1).aXF();
    p.g(localObject1, "builder.buildInstance()");
    this.rr = ((com.tencent.mm.ak.d)localObject1);
    localObject1 = this.TAG;
    paramString3 = new StringBuilder("[init] fromUserName=").append(paramString3).append(",toUserName=").append(paramString4).append(" feedId=").append(com.tencent.mm.ac.d.zs(paramLong)).append(" tabType=").append(paramInt1).append(' ').append("commentScene=");
    if (parambbn != null) {}
    for (paramInt1 = parambbn.tCE;; paramInt1 = 0)
    {
      Log.i((String)localObject1, paramInt1 + " category=" + paramString2 + " nonceId=" + paramString1 + " lastBuffer=" + paramb + " scene=" + paramInt2 + " sessionId=" + paramString5 + " sessionBuffer=false");
      AppMethodBeat.o(242402);
      return;
    }
  }
  
  public bh(com.tencent.mm.bw.b paramb, int paramInt, List<? extends ecq> paramList, blo paramblo, bbn parambbn)
  {
    AppMethodBeat.i(242405);
    this.TAG = "Finder.NetSceneFinderGetFeedRelList";
    ato localato = new ato();
    this.feedId = localato.hFK;
    this.hwg = localato.objectNonceId;
    this.dLS = localato.dLS;
    Object localObject1 = localato.LEr;
    int i;
    if (localObject1 != null)
    {
      localObject1 = ((aoz)localObject1).xjU;
      this.category = ((String)localObject1);
      this.dYs = localato.dkU;
      this.dJw = localato.dkV;
      this.sessionId = localato.LEt;
      this.tvj = localato.LEu;
      this.scene = paramInt;
      localato.scene = paramInt;
      if (paramList != null) {
        localato.LEw.addAll((Collection)paramList);
      }
      localato.lastBuffer = paramb;
      localato.tVd = paramblo;
      paramList = com.tencent.mm.ui.component.a.PRN;
      com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class);
      paramList = FinderGlobalLocationVM.dHP();
      localato.dTj = ((Number)paramList.first).floatValue();
      paramblo = am.tuw;
      localato.LAI = am.a(parambbn);
      localato.latitude = ((Number)paramList.second).floatValue();
      a(localato);
      paramList = new d.a();
      paramList.sG(getType());
      paramList.c((com.tencent.mm.bw.a)localato);
      paramList.d((com.tencent.mm.bw.a)new atp());
      paramList.MB("/cgi-bin/micromsg-bin/findergetrelatedlist");
      paramList = paramList.aXF();
      p.g(paramList, "builder.buildInstance()");
      this.rr = paramList;
      paramblo = this.TAG;
      paramList = new StringBuilder("[init2] fromUserName=").append(this.dYs).append(", toUserName=").append(this.dJw).append(" feedId=").append(com.tencent.mm.ac.d.zs(this.feedId)).append(" tabType=").append(this.dLS).append(' ').append("commentScene=");
      if (parambbn == null) {
        break label632;
      }
      i = parambbn.tCE;
      label382:
      paramList = paramList.append(i).append(" category=").append(this.category).append(" nonceId=").append(this.hwg).append(' ').append("lastBuffer=").append(localato.lastBuffer).append(" scene=").append(paramInt).append(" sessionId=").append(this.sessionId).append(" sessionBuffer=");
      if (this.tvj != null) {
        bool = true;
      }
      parambbn = paramList.append(bool).append(' ').append("get_column_feed_info=");
      paramList = localato.tVd;
      if (paramList == null) {
        break label638;
      }
      paramList = Long.valueOf(paramList.id);
      label510:
      parambbn = parambbn.append(paramList).append(", switch_column_info=");
      paramList = localato.LEv;
      if (paramList == null) {
        break label643;
      }
    }
    label643:
    for (paramList = Long.valueOf(paramList.id);; paramList = null)
    {
      paramList = parambbn.append(paramList).append(" cardBuffer=").append(paramb).append("get_related_column_topic_info=");
      parambbn = localato.LEx;
      paramb = localObject2;
      if (parambbn != null) {
        paramb = Long.valueOf(parambbn.id);
      }
      Log.i(paramblo, paramb + " stats=" + localato.LEw.size());
      AppMethodBeat.o(242405);
      return;
      localObject1 = null;
      break;
      label632:
      i = 0;
      break label382;
      label638:
      paramList = null;
      break label510;
    }
  }
  
  public bh(ecq paramecq, bbn parambbn, ato paramato)
  {
    AppMethodBeat.i(242404);
    this.TAG = "Finder.NetSceneFinderGetFeedRelList";
    this.feedId = paramato.hFK;
    this.hwg = paramato.objectNonceId;
    this.dLS = paramato.dLS;
    Object localObject = paramato.LEr;
    int i;
    if (localObject != null)
    {
      localObject = ((aoz)localObject).xjU;
      this.category = ((String)localObject);
      this.scene = paramato.scene;
      this.dYs = paramato.dkU;
      this.dJw = paramato.dkV;
      this.sessionId = paramato.LEt;
      this.tvj = paramato.LEu;
      localObject = new ato();
      ((ato)localObject).lastBuffer = paramato.lastBuffer;
      ((ato)localObject).hFK = paramato.hFK;
      ((ato)localObject).dLS = paramato.dLS;
      ((ato)localObject).objectNonceId = paramato.objectNonceId;
      ((ato)localObject).LEp = paramato.LEp;
      ((ato)localObject).scene = paramato.scene;
      ((ato)localObject).LEq = paramato.LEq;
      ((ato)localObject).tvs = paramato.tvs;
      ((ato)localObject).LEr = paramato.LEr;
      ((ato)localObject).txf = paramato.txf;
      ((ato)localObject).dkU = paramato.dkU;
      ((ato)localObject).dkV = paramato.dkV;
      ((ato)localObject).LEs = paramato.LEs;
      ((ato)localObject).LEt = paramato.LEt;
      ((ato)localObject).LEu = paramato.LEu;
      ((ato)localObject).LEv = paramato.LEv;
      ((ato)localObject).tVd = paramato.tVd;
      ((ato)localObject).LEw = paramato.LEw;
      ((ato)localObject).LEx = paramato.LEx;
      paramato = com.tencent.mm.ui.component.a.PRN;
      com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class);
      paramato = FinderGlobalLocationVM.dHP();
      ((ato)localObject).dTj = ((Number)paramato.first).floatValue();
      am localam = am.tuw;
      ((ato)localObject).LAI = am.a(parambbn);
      ((ato)localObject).latitude = ((Number)paramato.second).floatValue();
      ((ato)localObject).LEw.add(paramecq);
      a((ato)localObject);
      paramecq = new d.a();
      paramecq.sG(getType());
      paramecq.c((com.tencent.mm.bw.a)localObject);
      paramecq.d((com.tencent.mm.bw.a)new atp());
      paramecq.MB("/cgi-bin/micromsg-bin/findergetrelatedlist");
      paramecq = paramecq.aXF();
      p.g(paramecq, "builder.buildInstance()");
      this.rr = paramecq;
      paramecq = this.TAG;
      paramato = new StringBuilder("[init1] fromUserName=").append(this.dYs).append(",toUserName=").append(this.dJw).append(" feedId=").append(com.tencent.mm.ac.d.zs(this.feedId)).append(" tabType=").append(this.dLS).append(' ').append("commentScene=");
      if (parambbn == null) {
        break label750;
      }
      i = parambbn.tCE;
      label525:
      parambbn = paramato.append(i).append(" category=").append(this.category).append(" nonceId=").append(this.hwg).append(" lastBuffer=").append(((ato)localObject).lastBuffer).append(" scene=").append(this.scene).append(" sessionId=").append(this.sessionId).append(" sessionBuffer=");
      if (this.tvj != null) {
        bool = true;
      }
      parambbn = parambbn.append(bool).append(' ').append("get_column_feed_info=");
      paramato = ((ato)localObject).tVd;
      if (paramato == null) {
        break label756;
      }
      l1 = paramato.id;
      label648:
      parambbn = parambbn.append(com.tencent.mm.ac.d.zs(l1)).append(", switch_column_info=");
      paramato = ((ato)localObject).LEv;
      if (paramato == null) {
        break label762;
      }
    }
    label750:
    label756:
    label762:
    for (long l1 = paramato.id;; l1 = 0L)
    {
      parambbn = parambbn.append(com.tencent.mm.ac.d.zs(l1)).append(' ').append("get_related_column_topic_info=");
      paramato = ((ato)localObject).LEx;
      l1 = l2;
      if (paramato != null) {
        l1 = paramato.id;
      }
      Log.i(paramecq, com.tencent.mm.ac.d.zs(l1));
      AppMethodBeat.o(242404);
      return;
      localObject = null;
      break;
      i = 0;
      break label525;
      l1 = 0L;
      break label648;
    }
  }
  
  private final void a(ato paramato)
  {
    AppMethodBeat.i(242394);
    apc localapc = new apc();
    localapc.osName = com.tencent.mm.protocal.d.KyL;
    localapc.osVersion = com.tencent.mm.protocal.d.KyM;
    localapc.deviceBrand = com.tencent.mm.protocal.d.KyI;
    localapc.deviceModel = com.tencent.mm.protocal.d.KyJ;
    localapc.LBe = NetStatusUtil.getNetTypeString(MMApplicationContext.getContext());
    Object localObject = k.vfA;
    localapc.netType = k.dod();
    localapc.LBf = CdnLogic.getRecentAverageSpeed(2);
    localObject = com.tencent.mm.plugin.finder.video.reporter.b.whK;
    localapc.LBg = com.tencent.mm.plugin.finder.video.reporter.b.dFY();
    localapc.LBh.add("h264");
    if (e.sX(4)) {
      localapc.LBh.add("h265");
    }
    paramato.LAv = localapc;
    paramato = h.veu;
    h.aq(this.dLS, true);
    AppMethodBeat.o(242394);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(242396);
    params = h.veu;
    h.aq(this.dLS, false);
    h.b(h.veu, this.dLS);
    Log.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = this.TAG;
      Object localObject1 = new StringBuilder("feedId ").append(this.feedId).append(" tabType=").append(this.dLS).append(", ");
      Object localObject2 = al.tuv;
      Log.i(params, al.dQ((List)cYr()));
      params = this.rr.aYK();
      if ((params instanceof atp))
      {
        localObject1 = com.tencent.mm.plugin.finder.preload.a.uTO;
        localObject1 = ((atp)params).preloadInfo;
        localObject2 = ((atp)params).object;
        p.g(localObject2, "resp.`object`");
        com.tencent.mm.plugin.finder.preload.a.a((baw)localObject1, (List)localObject2, 3688);
        localObject1 = h.veu;
        h.gd(this.dLS, ((atp)params).object.size());
      }
      params = ((Iterable)cYr()).iterator();
      while (params.hasNext()) {
        d((FinderObject)params.next());
      }
    }
    if (this.callback != null)
    {
      params = this.callback;
      if (params == null) {
        p.hyc();
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
    }
    AppMethodBeat.o(242396);
  }
  
  public final com.tencent.mm.bw.b cYm()
  {
    AppMethodBeat.i(242397);
    Object localObject = this.rr.aYK();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetRelatedListResp");
      AppMethodBeat.o(242397);
      throw ((Throwable)localObject);
    }
    localObject = ((atp)localObject).lastBuffer;
    AppMethodBeat.o(242397);
    return localObject;
  }
  
  public final boolean cYp()
  {
    AppMethodBeat.i(242401);
    Object localObject = this.rr.aYK();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetRelatedListResp");
      AppMethodBeat.o(242401);
      throw ((Throwable)localObject);
    }
    if (((atp)localObject).continueFlag != 0)
    {
      AppMethodBeat.o(242401);
      return true;
    }
    AppMethodBeat.o(242401);
    return false;
  }
  
  public final atp cYq()
  {
    AppMethodBeat.i(242398);
    Object localObject = this.rr.aYK();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetRelatedListResp");
      AppMethodBeat.o(242398);
      throw ((Throwable)localObject);
    }
    localObject = (atp)localObject;
    AppMethodBeat.o(242398);
    return localObject;
  }
  
  public final LinkedList<FinderObject> cYr()
  {
    AppMethodBeat.i(242400);
    Object localObject = this.rr.aYK();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetRelatedListResp");
      AppMethodBeat.o(242400);
      throw ((Throwable)localObject);
    }
    LinkedList localLinkedList = ((atp)localObject).object;
    localObject = localLinkedList;
    if (localLinkedList == null) {
      localObject = new LinkedList();
    }
    AppMethodBeat.o(242400);
    return localObject;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(242395);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(242395);
    return i;
  }
  
  public final int getType()
  {
    return 3688;
  }
  
  public final String getWording()
  {
    AppMethodBeat.i(242399);
    Object localObject = this.rr.aYK();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetRelatedListResp");
      AppMethodBeat.o(242399);
      throw ((Throwable)localObject);
    }
    localObject = ((atp)localObject).LAH;
    AppMethodBeat.o(242399);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.bh
 * JD-Core Version:    0.7.0.1
 */