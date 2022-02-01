package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.b;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aqe;
import com.tencent.mm.protocal.protobuf.avr;
import com.tencent.mm.protocal.protobuf.avs;
import com.tencent.mm.protocal.protobuf.bhh;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.biv;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetRelatedList;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "tabType", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "relScene", "lng", "", "lat", "sectionInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(ILcom/tencent/mm/protobuf/ByteString;IFFLcom/tencent/mm/protocal/protobuf/FinderSectionInfo;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "objectId", "", "nonceId", "", "scene", "baseRequest", "Lcom/tencent/mm/protocal/protobuf/FinderBaseRequest;", "(IJLjava/lang/String;Lcom/tencent/mm/protobuf/ByteString;IFFLcom/tencent/mm/protocal/protobuf/FinderBaseRequest;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "getBaseRequest", "()Lcom/tencent/mm/protocal/protobuf/FinderBaseRequest;", "setBaseRequest", "(Lcom/tencent/mm/protocal/protobuf/FinderBaseRequest;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "category", "getCategory", "()Ljava/lang/String;", "setCategory", "(Ljava/lang/String;)V", "feedId", "getFeedId", "()J", "setFeedId", "(J)V", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "getLat", "()F", "setLat", "(F)V", "getLng", "setLng", "getNonceId", "setNonceId", "pullType", "getPullType", "()I", "setPullType", "(I)V", "getRelScene", "setRelScene", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getSectionInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "setSectionInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;)V", "getTabType", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getFeedRelList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getRequestBuffer", "getResponseBuffer", "getType", "hasContinue", "", "isFetchFeedCgi", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "realInit", "plugin-finder_release"})
public final class bt
  extends com.tencent.mm.plugin.findersdk.b.g
{
  private final String TAG;
  private i callback;
  private final int fEH;
  private long feedId;
  private String idV;
  private float lLr;
  private float lLs;
  private final b lastBuffer;
  private String nonceId;
  public int pullType;
  public d rr;
  private int xcY;
  private biv xcZ;
  private aqe xda;
  
  public bt(int paramInt, b paramb, float paramFloat1, float paramFloat2, biv parambiv, bid parambid)
  {
    super(parambid);
    AppMethodBeat.i(278416);
    this.TAG = "Finder.NetSceneFinderGetRelatedList";
    this.nonceId = "";
    this.idV = "";
    this.xcY = -1;
    this.fEH = paramInt;
    this.lastBuffer = paramb;
    this.xcY = 2;
    this.lLs = paramFloat1;
    this.lLr = paramFloat2;
    this.xcZ = parambiv;
    parambid = new d.a();
    parambid.vD(getType());
    avr localavr = new avr();
    localavr.xbk = this.feedId;
    localavr.objectNonceId = this.nonceId;
    localavr.fEH = this.fEH;
    localavr.longitude = this.lLs;
    localavr.latitude = this.lLr;
    localavr.lastBuffer = this.lastBuffer;
    parambiv = this.xda;
    paramb = parambiv;
    if (parambiv == null)
    {
      paramb = ao.xcj;
      paramb = ao.a(this.xbu);
    }
    localavr.SDi = paramb;
    localavr.scene = this.xcY;
    localavr.xcZ = this.xcZ;
    paramb = ao.xcj;
    ao.a(localavr.SDi, j.listOf(new o(Integer.valueOf(this.xcY), Long.valueOf(this.feedId))));
    parambid.c((com.tencent.mm.cd.a)localavr);
    parambid.d((com.tencent.mm.cd.a)new avs());
    parambid.TW("/cgi-bin/micromsg-bin/findergetrelatedlist");
    paramb = parambid.bgN();
    p.j(paramb, "builder.buildInstance()");
    this.rr = paramb;
    Log.i(this.TAG, "NetSceneFinderGetRelatedList feedId " + this.feedId + " tabType " + this.fEH + " category " + this.idV + " lastBuffer " + this.lastBuffer);
    AppMethodBeat.o(278416);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(278414);
    Log.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = this.TAG;
      Object localObject1 = new StringBuilder("feedId ").append(this.feedId).append(" tabType=").append(this.fEH).append(", ");
      Object localObject2 = am.xch;
      Log.i(params, am.dY((List)dof()));
      params = ((Iterable)dof()).iterator();
      while (params.hasNext())
      {
        localObject1 = (FinderObject)params.next();
        localObject2 = n.zWF;
        n.c((FinderObject)localObject1, this.xbu);
      }
      params = this.rr;
      if (params == null) {
        p.bGy("rr");
      }
      params = params.bhY();
      if ((params instanceof avs))
      {
        localObject1 = com.tencent.mm.plugin.finder.preload.a.zKe;
        localObject1 = ((avs)params).preloadInfo;
        params = ((avs)params).object;
        p.j(params, "resp.`object`");
        com.tencent.mm.plugin.finder.preload.a.a((bhh)localObject1, (List)params, 3688);
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
    AppMethodBeat.o(278414);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(278413);
    this.callback = parami;
    parami = this.rr;
    if (parami == null) {
      p.bGy("rr");
    }
    int i = dispatch(paramg, (s)parami, (m)this);
    AppMethodBeat.o(278413);
    return i;
  }
  
  public final LinkedList<FinderObject> dof()
  {
    AppMethodBeat.i(278415);
    Object localObject = this.rr;
    if (localObject == null) {
      p.bGy("rr");
    }
    localObject = ((d)localObject).bhY();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetRelatedListResp");
      AppMethodBeat.o(278415);
      throw ((Throwable)localObject);
    }
    LinkedList localLinkedList = ((avs)localObject).object;
    localObject = localLinkedList;
    if (localLinkedList == null) {
      localObject = new LinkedList();
    }
    AppMethodBeat.o(278415);
    return localObject;
  }
  
  public final int getType()
  {
    return 3688;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.bt
 * JD-Core Version:    0.7.0.1
 */