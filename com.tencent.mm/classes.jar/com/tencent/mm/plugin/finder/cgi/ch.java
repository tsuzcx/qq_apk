package com.tencent.mm.plugin.finder.cgi;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.modelcontrol.e;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.auj;
import com.tencent.mm.protocal.protobuf.aur;
import com.tencent.mm.protocal.protobuf.bav;
import com.tencent.mm.protocal.protobuf.baw;
import com.tencent.mm.protocal.protobuf.bft;
import com.tencent.mm.protocal.protobuf.bfu;
import com.tencent.mm.protocal.protobuf.btc;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.chq;
import com.tencent.mm.protocal.protobuf.crk;
import com.tencent.mm.protocal.protobuf.fhp;
import com.tencent.mm.protocal.protobuf.fkp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetFeedRelList;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "feedId", "", "nonceId", "", "tabType", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "category", "scene", "fromUserName", "toUserName", "sessionId", "sessionBuffer", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "poiLatitude", "", "poiLongitude", "(JLjava/lang/String;ILcom/tencent/mm/protobuf/ByteString;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;FF)V", "stats", "Lcom/tencent/mm/protocal/protobuf/Stats;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListReq;", "(Lcom/tencent/mm/protocal/protobuf/Stats;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListReq;)V", "", "get_column_feed_info", "Lcom/tencent/mm/protocal/protobuf/GetColumnFeedInfo;", "(Lcom/tencent/mm/protobuf/ByteString;ILjava/util/List;Lcom/tencent/mm/protocal/protobuf/GetColumnFeedInfo;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getCategory", "()Ljava/lang/String;", "setCategory", "(Ljava/lang/String;)V", "getFeedId", "()J", "getFromUserName", "getNonceId", "pullType", "getPullType", "()I", "setPullType", "(I)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getScene", "setScene", "getSessionBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "getSessionId", "getTabType", "getToUserName", "buildStatsRequest", "", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getFeedRelList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getFinderStreamCard", "Lcom/tencent/mm/protocal/protobuf/FinderStreamCard;", "getRequestBuffer", "getResponse", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListResp;", "getResponseBuffer", "getType", "getWording", "hasContinue", "", "onCgiEnd", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ch
  extends com.tencent.mm.plugin.findersdk.b.h
{
  private final com.tencent.mm.bx.b ACg;
  private final String TAG;
  private com.tencent.mm.am.h callback;
  public final long feedId;
  private final String hHa;
  private final int hJx;
  private final String hYg;
  private String kDf;
  private final String nonceId;
  public int pullType;
  public c rr;
  private int scene;
  private final String sessionId;
  
  private ch(long paramLong, String paramString1, int paramInt1, com.tencent.mm.bx.b paramb, String paramString2, int paramInt2, String paramString3, String paramString4, String paramString5, bui parambui, float paramFloat1, float paramFloat2)
  {
    super(parambui);
    AppMethodBeat.i(336712);
    this.TAG = "Finder.NetSceneFinderGetFeedRelList";
    this.feedId = paramLong;
    this.nonceId = paramString1;
    this.hJx = paramInt1;
    this.kDf = paramString2;
    this.scene = paramInt2;
    this.hYg = paramString3;
    this.hHa = paramString4;
    this.sessionId = paramString5;
    this.ACg = null;
    Object localObject1 = new c.a();
    ((c.a)localObject1).funcId = getType();
    bav localbav = new bav();
    localbav.hKN = paramLong;
    localbav.objectNonceId = paramString1;
    localbav.hJx = paramInt1;
    Object localObject2 = k.aeZF;
    localObject2 = ((com.tencent.mm.plugin.finder.viewmodel.b)k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.b.class)).dUh();
    localbav.longitude = ((Number)((r)localObject2).bsC).floatValue();
    localbav.latitude = ((Number)((r)localObject2).bsD).floatValue();
    int i;
    if (paramFloat2 == 0.0F)
    {
      i = 1;
      if (i == 0) {
        localbav.longitude = paramFloat2;
      }
      if (paramFloat1 != 0.0F) {
        break label589;
      }
      i = 1;
      label207:
      if (i == 0) {
        localbav.latitude = paramFloat1;
      }
      localbav.lastBuffer = paramb;
      localObject2 = bi.ABn;
      localbav.ZEc = bi.a(parambui);
      localObject2 = new auj();
      ((auj)localObject2).HIH = paramString2;
      ah localah = ah.aiuX;
      localbav.ZLD = ((auj)localObject2);
      localbav.hgk = paramString3;
      localbav.hgl = paramString4;
      localbav.scene = paramInt2;
      localbav.ZLE = null;
      localbav.ZLF = paramString5;
      localbav.ZLG = null;
      a(localbav);
      localObject2 = bi.ABn;
      bi.a(localbav.ZEc, kotlin.a.p.listOf(new r(Integer.valueOf(paramInt2), Long.valueOf(paramLong))));
      ((c.a)localObject1).otE = ((com.tencent.mm.bx.a)localbav);
      ((c.a)localObject1).otF = ((com.tencent.mm.bx.a)new baw());
      ((c.a)localObject1).uri = "/cgi-bin/micromsg-bin/findergetrelatedlist";
      localObject1 = ((c.a)localObject1).bEF();
      kotlin.g.b.s.s(localObject1, "builder.buildInstance()");
      this.rr = ((c)localObject1);
      localObject1 = this.TAG;
      localObject2 = new StringBuilder();
      paramString3 = ((StringBuilder)localObject2).append("[init] fromUserName=").append(paramString3).append(",toUserName=").append(paramString4).append(" feedId=").append(com.tencent.mm.ae.d.hF(paramLong)).append(" tabType=").append(paramInt1).append(" commentScene=");
      if (parambui != null) {
        break label595;
      }
      paramInt1 = 0;
      label480:
      paramString3.append(paramInt1).append(" category=").append(paramString2).append(" nonceId=").append(paramString1).append(" lastBuffer=").append(paramb).append(" scene=").append(paramInt2).append(" sessionId=").append(paramString5).append(" sessionBuffer=false,speed=");
      paramString1 = localbav.ZKH;
      if (paramString1 != null) {
        break label605;
      }
      paramString1 = null;
    }
    for (;;)
    {
      ((StringBuilder)localObject2).append(paramString1);
      Log.i((String)localObject1, ((StringBuilder)localObject2).toString());
      AppMethodBeat.o(336712);
      return;
      i = 0;
      break;
      label589:
      i = 0;
      break label207;
      label595:
      paramInt1 = parambui.AJo;
      break label480;
      label605:
      paramString1 = paramString1.ZPF;
      if (paramString1 == null) {
        paramString1 = null;
      } else {
        paramString1 = Integer.valueOf(paramString1.ZPE);
      }
    }
  }
  
  public ch(com.tencent.mm.bx.b paramb, int paramInt, List<? extends fhp> paramList, chq paramchq, bui parambui)
  {
    AppMethodBeat.i(336754);
    this.TAG = "Finder.NetSceneFinderGetFeedRelList";
    bav localbav = new bav();
    this.feedId = localbav.hKN;
    this.nonceId = localbav.objectNonceId;
    this.hJx = localbav.hJx;
    Object localObject1 = localbav.ZLD;
    int i;
    if (localObject1 == null)
    {
      localObject1 = null;
      this.kDf = ((String)localObject1);
      this.hYg = localbav.hgk;
      this.hHa = localbav.hgl;
      this.sessionId = localbav.ZLF;
      this.ACg = localbav.ZLG;
      this.scene = paramInt;
      localbav.scene = paramInt;
      if (paramList != null) {
        localbav.ZHE.addAll((Collection)paramList);
      }
      localbav.lastBuffer = paramb;
      localbav.BfT = paramchq;
      paramList = k.aeZF;
      paramList = ((com.tencent.mm.plugin.finder.viewmodel.b)k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.b.class)).dUh();
      localbav.longitude = ((Number)paramList.bsC).floatValue();
      paramchq = bi.ABn;
      localbav.ZEc = bi.a(parambui);
      localbav.latitude = ((Number)paramList.bsD).floatValue();
      a(localbav);
      paramList = bi.ABn;
      bi.a(localbav.ZEc, kotlin.a.p.listOf(new r(Integer.valueOf(paramInt), Long.valueOf(this.feedId))));
      paramList = new c.a();
      paramList.funcId = getType();
      paramList.otE = ((com.tencent.mm.bx.a)localbav);
      paramList.otF = ((com.tencent.mm.bx.a)new baw());
      paramList.uri = "/cgi-bin/micromsg-bin/findergetrelatedlist";
      paramList = paramList.bEF();
      kotlin.g.b.s.s(paramList, "builder.buildInstance()");
      this.rr = paramList;
      paramchq = this.TAG;
      localObject1 = new StringBuilder();
      paramList = ((StringBuilder)localObject1).append("[init2] fromUserName=").append(this.hYg).append(", toUserName=").append(this.hHa).append(" feedId=").append(com.tencent.mm.ae.d.hF(this.feedId)).append(" tabType=").append(this.hJx).append(" commentScene=");
      if (parambui != null) {
        break label658;
      }
      i = 0;
      label411:
      paramList = paramList.append(i).append(" category=").append(this.kDf).append(" nonceId=").append(this.nonceId).append(" lastBuffer=").append(localbav.lastBuffer).append(" scene=").append(paramInt).append(" sessionId=").append(this.sessionId).append(" sessionBuffer=");
      if (this.ACg != null) {
        bool = true;
      }
      paramList.append(bool).append(" get_column_feed_info=");
      paramList = localbav.BfT;
      if (paramList != null) {
        break label668;
      }
      paramList = null;
      label522:
      parambui = ((StringBuilder)localObject1).append(paramList).append(", switch_column_info=");
      paramList = localbav.ZLH;
      if (paramList != null) {
        break label679;
      }
      paramList = null;
      label548:
      paramList = parambui.append(paramList).append(" cardBuffer=").append(paramb).append("get_related_column_topic_info=");
      paramb = localbav.ZLI;
      if (paramb != null) {
        break label690;
      }
      paramb = null;
      label583:
      paramList = paramList.append(paramb).append(" stats=").append(localbav.ZHE.size()).append(",speed=");
      paramb = localbav.ZKH;
      if (paramb != null) {
        break label701;
      }
      paramb = localObject2;
    }
    for (;;)
    {
      paramList.append(paramb);
      Log.i(paramchq, ((StringBuilder)localObject1).toString());
      AppMethodBeat.o(336754);
      return;
      localObject1 = ((auj)localObject1).HIH;
      break;
      label658:
      i = parambui.AJo;
      break label411;
      label668:
      paramList = Long.valueOf(paramList.id);
      break label522;
      label679:
      paramList = Long.valueOf(paramList.id);
      break label548;
      label690:
      paramb = Long.valueOf(paramb.id);
      break label583;
      label701:
      parambui = paramb.ZPF;
      paramb = localObject2;
      if (parambui != null) {
        paramb = Integer.valueOf(parambui.ZPE);
      }
    }
  }
  
  public ch(fhp paramfhp, bui parambui, bav parambav)
  {
    AppMethodBeat.i(336742);
    this.TAG = "Finder.NetSceneFinderGetFeedRelList";
    this.feedId = parambav.hKN;
    this.nonceId = parambav.objectNonceId;
    this.hJx = parambav.hJx;
    Object localObject1 = parambav.ZLD;
    Object localObject2;
    int i;
    label557:
    boolean bool;
    label646:
    long l;
    if (localObject1 == null)
    {
      localObject1 = null;
      this.kDf = ((String)localObject1);
      this.scene = parambav.scene;
      this.hYg = parambav.hgk;
      this.hHa = parambav.hgl;
      this.sessionId = parambav.ZLF;
      this.ACg = parambav.ZLG;
      bav localbav = new bav();
      localbav.lastBuffer = parambav.lastBuffer;
      localbav.hKN = parambav.hKN;
      localbav.hJx = parambav.hJx;
      localbav.objectNonceId = parambav.objectNonceId;
      localbav.ZLB = parambav.ZLB;
      localbav.scene = parambav.scene;
      localbav.ZLC = parambav.ZLC;
      localbav.ACr = parambav.ACr;
      localbav.ZLD = parambav.ZLD;
      localbav.AEn = parambav.AEn;
      localbav.hgk = parambav.hgk;
      localbav.hgl = parambav.hgl;
      localbav.ZLE = parambav.ZLE;
      localbav.ZLF = parambav.ZLF;
      localbav.ZLG = parambav.ZLG;
      localbav.ZLH = parambav.ZLH;
      localbav.BfT = parambav.BfT;
      localbav.ZHE = parambav.ZHE;
      localbav.ZLI = parambav.ZLI;
      localObject1 = k.aeZF;
      localObject1 = ((com.tencent.mm.plugin.finder.viewmodel.b)k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.b.class)).dUh();
      localbav.longitude = ((Number)((r)localObject1).bsC).floatValue();
      localObject2 = bi.ABn;
      localbav.ZEc = bi.a(parambui);
      localObject2 = bi.ABn;
      bi.a(parambav.ZEc, kotlin.a.p.listOf(new r(Integer.valueOf(this.scene), Long.valueOf(this.feedId))));
      localbav.latitude = ((Number)((r)localObject1).bsD).floatValue();
      localbav.ZHE.add(paramfhp);
      a(localbav);
      paramfhp = new c.a();
      paramfhp.funcId = getType();
      paramfhp.otE = ((com.tencent.mm.bx.a)localbav);
      paramfhp.otF = ((com.tencent.mm.bx.a)new baw());
      paramfhp.uri = "/cgi-bin/micromsg-bin/findergetrelatedlist";
      paramfhp = paramfhp.bEF();
      kotlin.g.b.s.s(paramfhp, "builder.buildInstance()");
      this.rr = paramfhp;
      localObject1 = this.TAG;
      localObject2 = new StringBuilder();
      paramfhp = ((StringBuilder)localObject2).append("[init1] fromUserName=").append(this.hYg).append(",toUserName=").append(this.hHa).append(" feedId=").append(com.tencent.mm.ae.d.hF(this.feedId)).append(" tabType=").append(this.hJx).append(" commentScene=");
      if (parambui != null) {
        break label791;
      }
      i = 0;
      paramfhp = paramfhp.append(i).append(" category=").append(this.kDf).append(" nonceId=").append(this.nonceId).append(" lastBuffer=").append(localbav.lastBuffer).append(" scene=").append(this.scene).append(" sessionId=").append(this.sessionId).append(" sessionBuffer=");
      if (this.ACg == null) {
        break label800;
      }
      bool = true;
      paramfhp.append(bool).append(" get_column_feed_info=");
      paramfhp = localbav.BfT;
      if (paramfhp != null) {
        break label806;
      }
      l = 0L;
      label672:
      paramfhp = ((StringBuilder)localObject2).append(com.tencent.mm.ae.d.hF(l)).append(", switch_column_info=");
      parambui = localbav.ZLH;
      if (parambui != null) {
        break label815;
      }
      l = 0L;
      label702:
      paramfhp = paramfhp.append(com.tencent.mm.ae.d.hF(l)).append(" get_related_column_topic_info=");
      parambui = localbav.ZLI;
      if (parambui != null) {
        break label824;
      }
      l = 0L;
      label731:
      parambui = paramfhp.append(com.tencent.mm.ae.d.hF(l)).append(",speed=");
      paramfhp = parambav.ZKH;
      if (paramfhp != null) {
        break label833;
      }
      paramfhp = null;
    }
    for (;;)
    {
      parambui.append(paramfhp);
      Log.i((String)localObject1, ((StringBuilder)localObject2).toString());
      AppMethodBeat.o(336742);
      return;
      localObject1 = ((auj)localObject1).HIH;
      break;
      label791:
      i = parambui.AJo;
      break label557;
      label800:
      bool = false;
      break label646;
      label806:
      l = paramfhp.id;
      break label672;
      label815:
      l = parambui.id;
      break label702;
      label824:
      l = parambui.id;
      break label731;
      label833:
      paramfhp = paramfhp.ZPF;
      if (paramfhp == null) {
        paramfhp = null;
      } else {
        paramfhp = Integer.valueOf(paramfhp.ZPE);
      }
    }
  }
  
  private final void a(bav parambav)
  {
    AppMethodBeat.i(336760);
    Object localObject = new aur();
    ((aur)localObject).osName = com.tencent.mm.protocal.d.Yxd;
    ((aur)localObject).osVersion = com.tencent.mm.protocal.d.Yxe;
    ((aur)localObject).deviceBrand = com.tencent.mm.protocal.d.Yxa;
    ((aur)localObject).deviceModel = com.tencent.mm.protocal.d.Yxb;
    ((aur)localObject).ZEZ = NetStatusUtil.getNetTypeString(MMApplicationContext.getContext());
    z localz = z.FrZ;
    ((aur)localObject).netType = z.bUg();
    ((aur)localObject).ZFa = CdnLogic.getRecentAverageSpeed(2);
    ((aur)localObject).ZFb.addAll((Collection)((com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class)).bUa());
    ((aur)localObject).ZFc.add("h264");
    if (e.wb(4)) {
      ((aur)localObject).ZFc.add("h265");
    }
    parambav.ZDQ = ((aur)localObject);
    localObject = aw.Gjk;
    parambav.ZKH = aw.fgv();
    parambav = com.tencent.mm.plugin.finder.report.s.Fqv;
    com.tencent.mm.plugin.finder.report.s.aN(this.hJx, true);
    AppMethodBeat.o(336760);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params)
  {
    AppMethodBeat.i(336774);
    params = com.tencent.mm.plugin.finder.report.s.Fqv;
    com.tencent.mm.plugin.finder.report.s.aN(this.hJx, false);
    com.tencent.mm.plugin.finder.report.s.b(com.tencent.mm.plugin.finder.report.s.Fqv, this.hJx);
    Log.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = this.TAG;
      Object localObject1 = new StringBuilder("feedId ").append(this.feedId).append(" tabType=").append(this.hJx).append(", ");
      Object localObject2 = bg.ABl;
      Log.i(params, bg.fV((List)dVP()));
      params = c.c.b(this.rr.otC);
      if ((params instanceof baw))
      {
        localObject1 = com.tencent.mm.plugin.finder.preload.a.EUs;
        localObject1 = ((baw)params).preloadInfo;
        localObject2 = ((baw)params).object;
        kotlin.g.b.s.s(localObject2, "resp.`object`");
        com.tencent.mm.plugin.finder.preload.a.a((btc)localObject1, (List)localObject2, 3688);
        localObject1 = com.tencent.mm.plugin.finder.report.s.Fqv;
        com.tencent.mm.plugin.finder.report.s.jdMethod_if(this.hJx, ((baw)params).object.size());
      }
      params = ((Iterable)dVP()).iterator();
      while (params.hasNext())
      {
        localObject1 = (FinderObject)params.next();
        localObject2 = z.FrZ;
        z.a((FinderObject)localObject1, getContextObj());
      }
    }
    if (this.callback != null)
    {
      params = this.callback;
      kotlin.g.b.s.checkNotNull(params);
      params.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.am.p)this);
    }
    AppMethodBeat.o(336774);
  }
  
  public final com.tencent.mm.bx.b dVJ()
  {
    AppMethodBeat.i(336780);
    Object localObject = c.c.b(this.rr.otC);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetRelatedListResp");
      AppMethodBeat.o(336780);
      throw ((Throwable)localObject);
    }
    localObject = ((baw)localObject).lastBuffer;
    AppMethodBeat.o(336780);
    return localObject;
  }
  
  public final boolean dVN()
  {
    AppMethodBeat.i(336802);
    Object localObject = c.c.b(this.rr.otC);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetRelatedListResp");
      AppMethodBeat.o(336802);
      throw ((Throwable)localObject);
    }
    if (((baw)localObject).continueFlag != 0)
    {
      AppMethodBeat.o(336802);
      return true;
    }
    AppMethodBeat.o(336802);
    return false;
  }
  
  public final baw dVO()
  {
    AppMethodBeat.i(336786);
    Object localObject = c.c.b(this.rr.otC);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetRelatedListResp");
      AppMethodBeat.o(336786);
      throw ((Throwable)localObject);
    }
    localObject = (baw)localObject;
    AppMethodBeat.o(336786);
    return localObject;
  }
  
  public final LinkedList<FinderObject> dVP()
  {
    AppMethodBeat.i(336796);
    Object localObject = c.c.b(this.rr.otC);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetRelatedListResp");
      AppMethodBeat.o(336796);
      throw ((Throwable)localObject);
    }
    localObject = ((baw)localObject).object;
    if (localObject == null)
    {
      localObject = new LinkedList();
      AppMethodBeat.o(336796);
      return localObject;
    }
    AppMethodBeat.o(336796);
    return localObject;
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(336767);
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.rr, (m)this);
    AppMethodBeat.o(336767);
    return i;
  }
  
  public final int getType()
  {
    return 3688;
  }
  
  public final String getWording()
  {
    AppMethodBeat.i(336790);
    Object localObject = c.c.b(this.rr.otC);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetRelatedListResp");
      AppMethodBeat.o(336790);
      throw ((Throwable)localObject);
    }
    localObject = ((baw)localObject).ZEb;
    AppMethodBeat.o(336790);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ch
 * JD-Core Version:    0.7.0.1
 */