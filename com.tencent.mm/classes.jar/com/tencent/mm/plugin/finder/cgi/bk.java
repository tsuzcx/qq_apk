package com.tencent.mm.plugin.finder.cgi;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelcontrol.e;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aqj;
import com.tencent.mm.protocal.protobuf.aqo;
import com.tencent.mm.protocal.protobuf.avr;
import com.tencent.mm.protocal.protobuf.avs;
import com.tencent.mm.protocal.protobuf.bhh;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.bsx;
import com.tencent.mm.protocal.protobuf.ccb;
import com.tencent.mm.protocal.protobuf.emr;
import com.tencent.mm.protocal.protobuf.epq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.ui.component.g.a;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetFeedRelList;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "feedId", "", "nonceId", "", "tabType", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "category", "scene", "fromUserName", "toUserName", "sessionId", "sessionBuffer", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "poiLatitude", "", "poiLongitude", "(JLjava/lang/String;ILcom/tencent/mm/protobuf/ByteString;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;FF)V", "stats", "Lcom/tencent/mm/protocal/protobuf/Stats;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListReq;", "(Lcom/tencent/mm/protocal/protobuf/Stats;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListReq;)V", "", "get_column_feed_info", "Lcom/tencent/mm/protocal/protobuf/GetColumnFeedInfo;", "(Lcom/tencent/mm/protobuf/ByteString;ILjava/util/List;Lcom/tencent/mm/protocal/protobuf/GetColumnFeedInfo;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getCategory", "()Ljava/lang/String;", "setCategory", "(Ljava/lang/String;)V", "getFeedId", "()J", "getFromUserName", "getNonceId", "pullType", "getPullType", "()I", "setPullType", "(I)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getScene", "setScene", "getSessionBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "getSessionId", "getTabType", "getToUserName", "buildStatsRequest", "", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getFeedRelList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getRequestBuffer", "getResponse", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListResp;", "getResponseBuffer", "getType", "getWording", "hasContinue", "", "onCgiEnd", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class bk
  extends com.tencent.mm.plugin.findersdk.b.g
{
  private final String TAG;
  private i callback;
  private final String fCl;
  private final int fEH;
  private final String fSj;
  public final long feedId;
  private String idV;
  private final String nonceId;
  public int pullType;
  private com.tencent.mm.an.d rr;
  private int scene;
  private final String sessionId;
  private final com.tencent.mm.cd.b xcQ;
  
  private bk(long paramLong, String paramString1, int paramInt1, com.tencent.mm.cd.b paramb, String paramString2, int paramInt2, String paramString3, String paramString4, String paramString5, bid parambid, float paramFloat1, float paramFloat2)
  {
    super(parambid);
    AppMethodBeat.i(249955);
    this.TAG = "Finder.NetSceneFinderGetFeedRelList";
    this.feedId = paramLong;
    this.nonceId = paramString1;
    this.fEH = paramInt1;
    this.idV = paramString2;
    this.scene = paramInt2;
    this.fSj = paramString3;
    this.fCl = paramString4;
    this.sessionId = paramString5;
    this.xcQ = null;
    Object localObject1 = new d.a();
    ((d.a)localObject1).vD(getType());
    avr localavr = new avr();
    localavr.xbk = paramLong;
    localavr.objectNonceId = paramString1;
    localavr.fEH = paramInt1;
    Object localObject2 = com.tencent.mm.ui.component.g.Xox;
    localObject2 = ((com.tencent.mm.plugin.finder.viewmodel.a)com.tencent.mm.ui.component.g.bD(PluginFinder.class).i(com.tencent.mm.plugin.finder.viewmodel.a.class)).dnl();
    localavr.longitude = ((Number)((o)localObject2).Mx).floatValue();
    localavr.latitude = ((Number)((o)localObject2).My).floatValue();
    if (paramFloat2 != 0.0F) {
      localavr.longitude = paramFloat2;
    }
    if (paramFloat1 != 0.0F) {
      localavr.latitude = paramFloat1;
    }
    localavr.lastBuffer = paramb;
    localObject2 = ao.xcj;
    localavr.SDi = ao.a(parambid);
    localObject2 = new aqj();
    ((aqj)localObject2).BWk = paramString2;
    localavr.SHZ = ((aqj)localObject2);
    localavr.fcC = paramString3;
    localavr.fcD = paramString4;
    localavr.scene = paramInt2;
    localavr.SIa = null;
    localavr.SIb = paramString5;
    localavr.SIc = null;
    a(localavr);
    localObject2 = ao.xcj;
    ao.a(localavr.SDi, kotlin.a.j.listOf(new o(Integer.valueOf(paramInt2), Long.valueOf(paramLong))));
    ((d.a)localObject1).c((com.tencent.mm.cd.a)localavr);
    ((d.a)localObject1).d((com.tencent.mm.cd.a)new avs());
    ((d.a)localObject1).TW("/cgi-bin/micromsg-bin/findergetrelatedlist");
    localObject1 = ((d.a)localObject1).bgN();
    p.j(localObject1, "builder.buildInstance()");
    this.rr = ((com.tencent.mm.an.d)localObject1);
    localObject1 = this.TAG;
    paramString3 = new StringBuilder("[init] fromUserName=").append(paramString3).append(",toUserName=").append(paramString4).append(" feedId=").append(com.tencent.mm.ae.d.Fw(paramLong)).append(" tabType=").append(paramInt1).append(' ').append("commentScene=");
    if (parambid != null) {}
    for (paramInt1 = parambid.xkX;; paramInt1 = 0)
    {
      Log.i((String)localObject1, paramInt1 + " category=" + paramString2 + " nonceId=" + paramString1 + " lastBuffer=" + paramb + " scene=" + paramInt2 + " sessionId=" + paramString5 + " sessionBuffer=false");
      AppMethodBeat.o(249955);
      return;
    }
  }
  
  public bk(com.tencent.mm.cd.b paramb, int paramInt, List<? extends emr> paramList, bsx parambsx, bid parambid)
  {
    AppMethodBeat.i(249959);
    this.TAG = "Finder.NetSceneFinderGetFeedRelList";
    avr localavr = new avr();
    this.feedId = localavr.xbk;
    this.nonceId = localavr.objectNonceId;
    this.fEH = localavr.fEH;
    Object localObject1 = localavr.SHZ;
    int i;
    if (localObject1 != null)
    {
      localObject1 = ((aqj)localObject1).BWk;
      this.idV = ((String)localObject1);
      this.fSj = localavr.fcC;
      this.fCl = localavr.fcD;
      this.sessionId = localavr.SIb;
      this.xcQ = localavr.SIc;
      this.scene = paramInt;
      localavr.scene = paramInt;
      if (paramList != null) {
        localavr.SFB.addAll((Collection)paramList);
      }
      localavr.lastBuffer = paramb;
      localavr.xGN = parambsx;
      paramList = com.tencent.mm.ui.component.g.Xox;
      paramList = ((com.tencent.mm.plugin.finder.viewmodel.a)com.tencent.mm.ui.component.g.bD(PluginFinder.class).i(com.tencent.mm.plugin.finder.viewmodel.a.class)).dnl();
      localavr.longitude = ((Number)paramList.Mx).floatValue();
      parambsx = ao.xcj;
      localavr.SDi = ao.a(parambid);
      localavr.latitude = ((Number)paramList.My).floatValue();
      a(localavr);
      paramList = ao.xcj;
      ao.a(localavr.SDi, kotlin.a.j.listOf(new o(Integer.valueOf(paramInt), Long.valueOf(this.feedId))));
      paramList = new d.a();
      paramList.vD(getType());
      paramList.c((com.tencent.mm.cd.a)localavr);
      paramList.d((com.tencent.mm.cd.a)new avs());
      paramList.TW("/cgi-bin/micromsg-bin/findergetrelatedlist");
      paramList = paramList.bgN();
      p.j(paramList, "builder.buildInstance()");
      this.rr = paramList;
      parambsx = this.TAG;
      paramList = new StringBuilder("[init2] fromUserName=").append(this.fSj).append(", toUserName=").append(this.fCl).append(" feedId=").append(com.tencent.mm.ae.d.Fw(this.feedId)).append(" tabType=").append(this.fEH).append(' ').append("commentScene=");
      if (parambid == null) {
        break label667;
      }
      i = parambid.xkX;
      label417:
      paramList = paramList.append(i).append(" category=").append(this.idV).append(" nonceId=").append(this.nonceId).append(' ').append("lastBuffer=").append(localavr.lastBuffer).append(" scene=").append(paramInt).append(" sessionId=").append(this.sessionId).append(" sessionBuffer=");
      if (this.xcQ != null) {
        bool = true;
      }
      parambid = paramList.append(bool).append(' ').append("get_column_feed_info=");
      paramList = localavr.xGN;
      if (paramList == null) {
        break label673;
      }
      paramList = Long.valueOf(paramList.id);
      label545:
      parambid = parambid.append(paramList).append(", switch_column_info=");
      paramList = localavr.SId;
      if (paramList == null) {
        break label678;
      }
    }
    label667:
    label673:
    label678:
    for (paramList = Long.valueOf(paramList.id);; paramList = null)
    {
      paramList = parambid.append(paramList).append(" cardBuffer=").append(paramb).append("get_related_column_topic_info=");
      parambid = localavr.SIe;
      paramb = localObject2;
      if (parambid != null) {
        paramb = Long.valueOf(parambid.id);
      }
      Log.i(parambsx, paramb + " stats=" + localavr.SFB.size());
      AppMethodBeat.o(249959);
      return;
      localObject1 = null;
      break;
      i = 0;
      break label417;
      paramList = null;
      break label545;
    }
  }
  
  public bk(emr paramemr, bid parambid, avr paramavr)
  {
    AppMethodBeat.i(249957);
    this.TAG = "Finder.NetSceneFinderGetFeedRelList";
    this.feedId = paramavr.xbk;
    this.nonceId = paramavr.objectNonceId;
    this.fEH = paramavr.fEH;
    Object localObject1 = paramavr.SHZ;
    int i;
    if (localObject1 != null)
    {
      localObject1 = ((aqj)localObject1).BWk;
      this.idV = ((String)localObject1);
      this.scene = paramavr.scene;
      this.fSj = paramavr.fcC;
      this.fCl = paramavr.fcD;
      this.sessionId = paramavr.SIb;
      this.xcQ = paramavr.SIc;
      localObject1 = new avr();
      ((avr)localObject1).lastBuffer = paramavr.lastBuffer;
      ((avr)localObject1).xbk = paramavr.xbk;
      ((avr)localObject1).fEH = paramavr.fEH;
      ((avr)localObject1).objectNonceId = paramavr.objectNonceId;
      ((avr)localObject1).SHX = paramavr.SHX;
      ((avr)localObject1).scene = paramavr.scene;
      ((avr)localObject1).SHY = paramavr.SHY;
      ((avr)localObject1).xcZ = paramavr.xcZ;
      ((avr)localObject1).SHZ = paramavr.SHZ;
      ((avr)localObject1).xff = paramavr.xff;
      ((avr)localObject1).fcC = paramavr.fcC;
      ((avr)localObject1).fcD = paramavr.fcD;
      ((avr)localObject1).SIa = paramavr.SIa;
      ((avr)localObject1).SIb = paramavr.SIb;
      ((avr)localObject1).SIc = paramavr.SIc;
      ((avr)localObject1).SId = paramavr.SId;
      ((avr)localObject1).xGN = paramavr.xGN;
      ((avr)localObject1).SFB = paramavr.SFB;
      ((avr)localObject1).SIe = paramavr.SIe;
      Object localObject2 = com.tencent.mm.ui.component.g.Xox;
      localObject2 = ((com.tencent.mm.plugin.finder.viewmodel.a)com.tencent.mm.ui.component.g.bD(PluginFinder.class).i(com.tencent.mm.plugin.finder.viewmodel.a.class)).dnl();
      ((avr)localObject1).longitude = ((Number)((o)localObject2).Mx).floatValue();
      ao localao = ao.xcj;
      ((avr)localObject1).SDi = ao.a(parambid);
      localao = ao.xcj;
      ao.a(paramavr.SDi, kotlin.a.j.listOf(new o(Integer.valueOf(this.scene), Long.valueOf(this.feedId))));
      ((avr)localObject1).latitude = ((Number)((o)localObject2).My).floatValue();
      ((avr)localObject1).SFB.add(paramemr);
      a((avr)localObject1);
      paramemr = new d.a();
      paramemr.vD(getType());
      paramemr.c((com.tencent.mm.cd.a)localObject1);
      paramemr.d((com.tencent.mm.cd.a)new avs());
      paramemr.TW("/cgi-bin/micromsg-bin/findergetrelatedlist");
      paramemr = paramemr.bgN();
      p.j(paramemr, "builder.buildInstance()");
      this.rr = paramemr;
      paramemr = this.TAG;
      paramavr = new StringBuilder("[init1] fromUserName=").append(this.fSj).append(",toUserName=").append(this.fCl).append(" feedId=").append(com.tencent.mm.ae.d.Fw(this.feedId)).append(" tabType=").append(this.fEH).append(' ').append("commentScene=");
      if (parambid == null) {
        break label792;
      }
      i = parambid.xkX;
      label567:
      parambid = paramavr.append(i).append(" category=").append(this.idV).append(" nonceId=").append(this.nonceId).append(" lastBuffer=").append(((avr)localObject1).lastBuffer).append(" scene=").append(this.scene).append(" sessionId=").append(this.sessionId).append(" sessionBuffer=");
      if (this.xcQ != null) {
        bool = true;
      }
      parambid = parambid.append(bool).append(' ').append("get_column_feed_info=");
      paramavr = ((avr)localObject1).xGN;
      if (paramavr == null) {
        break label798;
      }
      l1 = paramavr.id;
      label690:
      parambid = parambid.append(com.tencent.mm.ae.d.Fw(l1)).append(", switch_column_info=");
      paramavr = ((avr)localObject1).SId;
      if (paramavr == null) {
        break label804;
      }
    }
    label792:
    label798:
    label804:
    for (long l1 = paramavr.id;; l1 = 0L)
    {
      parambid = parambid.append(com.tencent.mm.ae.d.Fw(l1)).append(' ').append("get_related_column_topic_info=");
      paramavr = ((avr)localObject1).SIe;
      l1 = l2;
      if (paramavr != null) {
        l1 = paramavr.id;
      }
      Log.i(paramemr, com.tencent.mm.ae.d.Fw(l1));
      AppMethodBeat.o(249957);
      return;
      localObject1 = null;
      break;
      i = 0;
      break label567;
      l1 = 0L;
      break label690;
    }
  }
  
  private final void a(avr paramavr)
  {
    AppMethodBeat.i(249944);
    aqo localaqo = new aqo();
    localaqo.osName = com.tencent.mm.protocal.d.RAz;
    localaqo.osVersion = com.tencent.mm.protocal.d.RAA;
    localaqo.deviceBrand = com.tencent.mm.protocal.d.RAw;
    localaqo.deviceModel = com.tencent.mm.protocal.d.RAx;
    localaqo.SDN = NetStatusUtil.getNetTypeString(MMApplicationContext.getContext());
    n localn = n.zWF;
    localaqo.netType = n.bvR();
    localaqo.SDO = CdnLogic.getRecentAverageSpeed(2);
    localaqo.SDP = ((com.tencent.mm.plugin.b)h.ae(com.tencent.mm.plugin.b.class)).bvN();
    localaqo.SDQ.add("h264");
    if (e.vW(4)) {
      localaqo.SDQ.add("h265");
    }
    paramavr.SCW = localaqo;
    paramavr = com.tencent.mm.plugin.finder.report.j.zVy;
    com.tencent.mm.plugin.finder.report.j.at(this.fEH, true);
    AppMethodBeat.o(249944);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(249947);
    params = com.tencent.mm.plugin.finder.report.j.zVy;
    com.tencent.mm.plugin.finder.report.j.at(this.fEH, false);
    com.tencent.mm.plugin.finder.report.j.b(com.tencent.mm.plugin.finder.report.j.zVy, this.fEH);
    Log.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = this.TAG;
      Object localObject1 = new StringBuilder("feedId ").append(this.feedId).append(" tabType=").append(this.fEH).append(", ");
      Object localObject2 = am.xch;
      Log.i(params, am.dY((List)dof()));
      params = this.rr.bhY();
      if ((params instanceof avs))
      {
        localObject1 = com.tencent.mm.plugin.finder.preload.a.zKe;
        localObject1 = ((avs)params).preloadInfo;
        localObject2 = ((avs)params).object;
        p.j(localObject2, "resp.`object`");
        com.tencent.mm.plugin.finder.preload.a.a((bhh)localObject1, (List)localObject2, 3688);
        localObject1 = com.tencent.mm.plugin.finder.report.j.zVy;
        com.tencent.mm.plugin.finder.report.j.gP(this.fEH, ((avs)params).object.size());
      }
      params = ((Iterable)dof()).iterator();
      while (params.hasNext())
      {
        localObject1 = (FinderObject)params.next();
        localObject2 = n.zWF;
        n.c((FinderObject)localObject1, this.xbu);
      }
    }
    if (this.callback != null)
    {
      params = this.callback;
      if (params == null) {
        p.iCn();
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
    }
    AppMethodBeat.o(249947);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(249945);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(249945);
    return i;
  }
  
  public final com.tencent.mm.cd.b doa()
  {
    AppMethodBeat.i(249948);
    Object localObject = this.rr.bhY();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetRelatedListResp");
      AppMethodBeat.o(249948);
      throw ((Throwable)localObject);
    }
    localObject = ((avs)localObject).lastBuffer;
    AppMethodBeat.o(249948);
    return localObject;
  }
  
  public final boolean dod()
  {
    AppMethodBeat.i(249954);
    Object localObject = this.rr.bhY();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetRelatedListResp");
      AppMethodBeat.o(249954);
      throw ((Throwable)localObject);
    }
    if (((avs)localObject).continueFlag != 0)
    {
      AppMethodBeat.o(249954);
      return true;
    }
    AppMethodBeat.o(249954);
    return false;
  }
  
  public final avs doe()
  {
    AppMethodBeat.i(249949);
    Object localObject = this.rr.bhY();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetRelatedListResp");
      AppMethodBeat.o(249949);
      throw ((Throwable)localObject);
    }
    localObject = (avs)localObject;
    AppMethodBeat.o(249949);
    return localObject;
  }
  
  public final LinkedList<FinderObject> dof()
  {
    AppMethodBeat.i(249953);
    Object localObject = this.rr.bhY();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetRelatedListResp");
      AppMethodBeat.o(249953);
      throw ((Throwable)localObject);
    }
    LinkedList localLinkedList = ((avs)localObject).object;
    localObject = localLinkedList;
    if (localLinkedList == null) {
      localObject = new LinkedList();
    }
    AppMethodBeat.o(249953);
    return localObject;
  }
  
  public final int getType()
  {
    return 3688;
  }
  
  public final String getWording()
  {
    AppMethodBeat.i(249951);
    Object localObject = this.rr.bhY();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetRelatedListResp");
      AppMethodBeat.o(249951);
      throw ((Throwable)localObject);
    }
    localObject = ((avs)localObject).SDh;
    AppMethodBeat.o(249951);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.bk
 * JD-Core Version:    0.7.0.1
 */