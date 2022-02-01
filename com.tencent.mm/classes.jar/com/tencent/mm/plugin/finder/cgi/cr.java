package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.bx.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.atz;
import com.tencent.mm.protocal.protobuf.bav;
import com.tencent.mm.protocal.protobuf.baw;
import com.tencent.mm.protocal.protobuf.btc;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.bve;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetRelatedList;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "tabType", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "relScene", "lng", "", "lat", "sectionInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(ILcom/tencent/mm/protobuf/ByteString;IFFLcom/tencent/mm/protocal/protobuf/FinderSectionInfo;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "objectId", "", "nonceId", "", "scene", "baseRequest", "Lcom/tencent/mm/protocal/protobuf/FinderBaseRequest;", "(IJLjava/lang/String;Lcom/tencent/mm/protobuf/ByteString;IFFLcom/tencent/mm/protocal/protobuf/FinderBaseRequest;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "getBaseRequest", "()Lcom/tencent/mm/protocal/protobuf/FinderBaseRequest;", "setBaseRequest", "(Lcom/tencent/mm/protocal/protobuf/FinderBaseRequest;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "category", "getCategory", "()Ljava/lang/String;", "setCategory", "(Ljava/lang/String;)V", "feedId", "getFeedId", "()J", "setFeedId", "(J)V", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "getLat", "()F", "setLat", "(F)V", "getLng", "setLng", "getNonceId", "setNonceId", "pullType", "getPullType", "()I", "setPullType", "(I)V", "getRelScene", "setRelScene", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getSectionInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "setSectionInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;)V", "getTabType", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getFeedRelList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getRequestBuffer", "getResponseBuffer", "getType", "hasContinue", "", "isFetchFeedCgi", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "realInit", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class cr
  extends com.tencent.mm.plugin.findersdk.b.h
{
  private int ACq;
  private bve ACr;
  private atz ACs;
  private final String TAG;
  private com.tencent.mm.am.h callback;
  private long feedId;
  private final int hJx;
  private String kDf;
  private final b lastBuffer;
  private String nonceId;
  private float oDT;
  private float oDU;
  public int pullType;
  public c rr;
  
  public cr(int paramInt, b paramb, float paramFloat1, float paramFloat2, bve parambve, bui parambui)
  {
    super(parambui);
    AppMethodBeat.i(336646);
    this.TAG = "Finder.NetSceneFinderGetRelatedList";
    this.nonceId = "";
    this.kDf = "";
    this.ACq = -1;
    this.hJx = paramInt;
    this.lastBuffer = paramb;
    this.ACq = 2;
    this.oDU = paramFloat1;
    this.oDT = paramFloat2;
    this.ACr = parambve;
    parambui = new c.a();
    parambui.funcId = getType();
    bav localbav = new bav();
    localbav.hKN = this.feedId;
    localbav.objectNonceId = this.nonceId;
    localbav.hJx = this.hJx;
    localbav.longitude = this.oDU;
    localbav.latitude = this.oDT;
    localbav.lastBuffer = this.lastBuffer;
    parambve = this.ACs;
    paramb = parambve;
    if (parambve == null)
    {
      paramb = bi.ABn;
      paramb = bi.a(getContextObj());
    }
    localbav.ZEc = paramb;
    localbav.scene = this.ACq;
    localbav.ACr = this.ACr;
    paramb = bi.ABn;
    bi.a(localbav.ZEc, kotlin.a.p.listOf(new r(Integer.valueOf(this.ACq), Long.valueOf(this.feedId))));
    parambui.otE = ((com.tencent.mm.bx.a)localbav);
    parambui.otF = ((com.tencent.mm.bx.a)new baw());
    parambui.uri = "/cgi-bin/micromsg-bin/findergetrelatedlist";
    paramb = parambui.bEF();
    kotlin.g.b.s.s(paramb, "builder.buildInstance()");
    this.rr = paramb;
    Log.i(this.TAG, "NetSceneFinderGetRelatedList feedId " + this.feedId + " tabType " + this.hJx + " category " + this.kDf + " lastBuffer " + this.lastBuffer);
    AppMethodBeat.o(336646);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params)
  {
    AppMethodBeat.i(336663);
    Log.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = this.TAG;
      Object localObject1 = new StringBuilder("feedId ").append(this.feedId).append(" tabType=").append(this.hJx).append(", ");
      Object localObject2 = bg.ABl;
      Log.i(params, bg.fV((List)dVP()));
      params = ((Iterable)dVP()).iterator();
      while (params.hasNext())
      {
        localObject1 = (FinderObject)params.next();
        localObject2 = z.FrZ;
        z.a((FinderObject)localObject1, getContextObj());
      }
      localObject1 = this.rr;
      params = (com.tencent.mm.network.s)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("rr");
        params = null;
      }
      params = c.c.b(params.otC);
      if ((params instanceof baw))
      {
        localObject1 = com.tencent.mm.plugin.finder.preload.a.EUs;
        localObject1 = ((baw)params).preloadInfo;
        params = ((baw)params).object;
        kotlin.g.b.s.s(params, "resp.`object`");
        com.tencent.mm.plugin.finder.preload.a.a((btc)localObject1, (List)params, 3688);
      }
    }
    if (this.callback != null)
    {
      params = this.callback;
      kotlin.g.b.s.checkNotNull(params);
      params.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.am.p)this);
    }
    AppMethodBeat.o(336663);
  }
  
  public final LinkedList<FinderObject> dVP()
  {
    AppMethodBeat.i(336672);
    c localc = this.rr;
    Object localObject = localc;
    if (localc == null)
    {
      kotlin.g.b.s.bIx("rr");
      localObject = null;
    }
    localObject = c.c.b(((c)localObject).otC);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetRelatedListResp");
      AppMethodBeat.o(336672);
      throw ((Throwable)localObject);
    }
    localObject = ((baw)localObject).object;
    if (localObject == null)
    {
      localObject = new LinkedList();
      AppMethodBeat.o(336672);
      return localObject;
    }
    AppMethodBeat.o(336672);
    return localObject;
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(336657);
    this.callback = paramh;
    c localc = this.rr;
    paramh = localc;
    if (localc == null)
    {
      kotlin.g.b.s.bIx("rr");
      paramh = null;
    }
    int i = dispatch(paramg, (com.tencent.mm.network.s)paramh, (m)this);
    AppMethodBeat.o(336657);
    return i;
  }
  
  public final int getType()
  {
    return 3688;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.cr
 * JD-Core Version:    0.7.0.1
 */