package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.a;
import com.tencent.mm.cd.b;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aqe;
import com.tencent.mm.protocal.protobuf.auy;
import com.tencent.mm.protocal.protobuf.auz;
import com.tencent.mm.protocal.protobuf.awq;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.biv;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetLiveRelatedList;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "relScene", "", "lng", "", "lat", "sectionInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protobuf/ByteString;IFFLcom/tencent/mm/protocal/protobuf/FinderSectionInfo;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "objectId", "", "nonceId", "", "sessionBuffer", "scene", "baseRequest", "Lcom/tencent/mm/protocal/protobuf/FinderBaseRequest;", "lbsTabTipsInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLbsTabTipsInfo;", "(JLjava/lang/String;Ljava/lang/String;Lcom/tencent/mm/protobuf/ByteString;IFFLcom/tencent/mm/protocal/protobuf/FinderBaseRequest;Lcom/tencent/mm/protocal/protobuf/FinderLbsTabTipsInfo;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "getBaseRequest", "()Lcom/tencent/mm/protocal/protobuf/FinderBaseRequest;", "setBaseRequest", "(Lcom/tencent/mm/protocal/protobuf/FinderBaseRequest;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "category", "getCategory", "()Ljava/lang/String;", "setCategory", "(Ljava/lang/String;)V", "feedId", "getFeedId", "()J", "setFeedId", "(J)V", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "getLat", "()F", "setLat", "(F)V", "getLbsTabTipsInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLbsTabTipsInfo;", "setLbsTabTipsInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLbsTabTipsInfo;)V", "getLng", "setLng", "getNonceId", "setNonceId", "pullType", "getPullType", "()I", "setPullType", "(I)V", "getRelScene", "setRelScene", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getSectionInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "setSectionInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;)V", "getSessionBuffer", "setSessionBuffer", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getFeedRelList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getRequestBuffer", "getResponseBuffer", "getType", "hasContinue", "", "isFetchFeedCgi", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "realInit", "plugin-finder_release"})
public final class bq
  extends com.tencent.mm.plugin.findersdk.b.g
{
  private final String TAG;
  private i callback;
  private long feedId;
  private String idV;
  private float lLr;
  private float lLs;
  private final b lastBuffer;
  private String nonceId;
  public int pullType;
  public d rr;
  private String sessionBuffer;
  private int xcY;
  private biv xcZ;
  private aqe xda;
  private awq xdb;
  
  public bq(long paramLong, String paramString1, String paramString2, b paramb, int paramInt, float paramFloat1, float paramFloat2, aqe paramaqe, awq paramawq, bid parambid)
  {
    super(parambid);
    AppMethodBeat.i(244469);
    this.TAG = "NetSceneFinderGetLiveRelatedList";
    this.nonceId = "";
    this.sessionBuffer = "";
    this.idV = "";
    this.xcY = -1;
    this.feedId = paramLong;
    this.nonceId = paramString1;
    this.sessionBuffer = paramString2;
    this.lastBuffer = paramb;
    this.xcY = paramInt;
    this.lLs = paramFloat1;
    this.lLr = paramFloat2;
    this.xcZ = null;
    this.xda = paramaqe;
    this.xdb = paramawq;
    paramb = new d.a();
    paramb.vD(getType());
    paramaqe = new auy();
    paramaqe.object_id = this.feedId;
    paramaqe.object_nonce_id = this.nonceId;
    paramaqe.longitude = this.lLs;
    paramaqe.latitude = this.lLr;
    paramaqe.SDI = this.lastBuffer;
    paramaqe.SHp = this.sessionBuffer;
    paramString2 = this.xda;
    paramString1 = paramString2;
    if (paramString2 == null)
    {
      paramString1 = ao.xcj;
      paramString1 = ao.a(this.xbu);
    }
    paramaqe.RLM = paramString1;
    paramaqe.scene = this.xcY;
    paramaqe.SHq = this.xdb;
    paramb.c((a)paramaqe);
    paramb.d((a)new auz());
    paramb.TW("/cgi-bin/micromsg-bin/findergetliverelatedlist");
    paramString1 = paramb.bgN();
    p.j(paramString1, "builder.buildInstance()");
    this.rr = paramString1;
    paramString2 = this.TAG;
    paramb = new StringBuilder("realInit feedId ").append(this.feedId).append("  category ").append(this.idV).append(" lastBuffer relScene:").append(this.xcY).append(' ').append(this.lastBuffer).append(" tab_tips_path=");
    paramString1 = this.xdb;
    label419:
    boolean bool;
    if (paramString1 != null)
    {
      paramString1 = paramString1.SJn;
      paramb = paramb.append(paramString1).append(' ').append(" tabTipsByPassInfo=");
      paramString1 = this.xdb;
      if (paramString1 == null) {
        break label488;
      }
      paramString1 = paramString1.SJd;
      if (paramString1 == null) {
        break label493;
      }
      bool = true;
      label426:
      paramb = paramb.append(bool).append(' ').append("objectId=");
      paramString1 = this.xdb;
      if (paramString1 == null) {
        break label499;
      }
    }
    label488:
    label493:
    label499:
    for (paramString1 = Long.valueOf(paramString1.SJc);; paramString1 = null)
    {
      Log.i(paramString2, paramString1);
      AppMethodBeat.o(244469);
      return;
      paramString1 = null;
      break;
      paramString1 = null;
      break label419;
      bool = false;
      break label426;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(244464);
    Log.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = this.TAG;
      Object localObject1 = new StringBuilder("feedId ").append(this.feedId).append(", ");
      Object localObject2 = am.xch;
      Log.i(params, am.dY((List)dof()));
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
    AppMethodBeat.o(244464);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(244462);
    this.callback = parami;
    parami = this.rr;
    if (parami == null) {
      p.bGy("rr");
    }
    int i = dispatch(paramg, (s)parami, (m)this);
    AppMethodBeat.o(244462);
    return i;
  }
  
  public final LinkedList<FinderObject> dof()
  {
    AppMethodBeat.i(244465);
    Object localObject = this.rr;
    if (localObject == null) {
      p.bGy("rr");
    }
    localObject = ((d)localObject).bhY();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetLiveRelatedListResponse");
      AppMethodBeat.o(244465);
      throw ((Throwable)localObject);
    }
    LinkedList localLinkedList = ((auz)localObject).object;
    localObject = localLinkedList;
    if (localLinkedList == null) {
      localObject = new LinkedList();
    }
    AppMethodBeat.o(244465);
    return localObject;
  }
  
  public final int getType()
  {
    return 6479;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.bq
 * JD-Core Version:    0.7.0.1
 */