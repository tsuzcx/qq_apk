package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aov;
import com.tencent.mm.protocal.protobuf.ato;
import com.tencent.mm.protocal.protobuf.atp;
import com.tencent.mm.protocal.protobuf.baw;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bcc;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetRelatedList;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "tabType", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "relScene", "lng", "", "lat", "sectionInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(ILcom/tencent/mm/protobuf/ByteString;IFFLcom/tencent/mm/protocal/protobuf/FinderSectionInfo;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "objectId", "", "nonceId", "", "scene", "baseRequest", "Lcom/tencent/mm/protocal/protobuf/FinderBaseRequest;", "(IJLjava/lang/String;Lcom/tencent/mm/protobuf/ByteString;IFFLcom/tencent/mm/protocal/protobuf/FinderBaseRequest;)V", "TAG", "getBaseRequest", "()Lcom/tencent/mm/protocal/protobuf/FinderBaseRequest;", "setBaseRequest", "(Lcom/tencent/mm/protocal/protobuf/FinderBaseRequest;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "category", "getCategory", "()Ljava/lang/String;", "setCategory", "(Ljava/lang/String;)V", "feedId", "getFeedId", "()J", "setFeedId", "(J)V", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "getLat", "()F", "setLat", "(F)V", "getLng", "setLng", "getNonceId", "setNonceId", "pullType", "getPullType", "()I", "setPullType", "(I)V", "getRelScene", "setRelScene", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getSectionInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "setSectionInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;)V", "getTabType", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getFeedRelList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getRequestBuffer", "getResponseBuffer", "getType", "hasContinue", "", "isFetchFeedCgi", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "realInit", "plugin-finder_release"})
public final class bq
  extends ax
{
  private final String TAG;
  private i callback;
  private String category;
  private final int dLS;
  private long feedId;
  private String hwg;
  private float iUY;
  private float iUZ;
  private final b lastBuffer;
  public int pullType;
  private d rr;
  private int tvr;
  private bcc tvs;
  private aov tvt;
  
  public bq(int paramInt1, long paramLong, String paramString, b paramb, int paramInt2, float paramFloat1, float paramFloat2, aov paramaov)
  {
    AppMethodBeat.i(242451);
    this.TAG = "Finder.NetSceneFinderGetRelatedList";
    this.hwg = "";
    this.category = "";
    this.tvr = -1;
    this.dLS = paramInt1;
    this.feedId = paramLong;
    this.hwg = paramString;
    this.lastBuffer = paramb;
    this.tvr = paramInt2;
    this.iUZ = paramFloat1;
    this.iUY = paramFloat2;
    this.tvs = null;
    this.tvt = paramaov;
    cYE();
    AppMethodBeat.o(242451);
  }
  
  public bq(int paramInt, b paramb, float paramFloat1, float paramFloat2, bcc parambcc, bbn parambbn)
  {
    super(parambbn);
    AppMethodBeat.i(242450);
    this.TAG = "Finder.NetSceneFinderGetRelatedList";
    this.hwg = "";
    this.category = "";
    this.tvr = -1;
    this.dLS = paramInt;
    this.lastBuffer = paramb;
    this.tvr = 2;
    this.iUZ = paramFloat1;
    this.iUY = paramFloat2;
    this.tvs = parambcc;
    cYE();
    AppMethodBeat.o(242450);
  }
  
  private final void cYE()
  {
    AppMethodBeat.i(242444);
    d.a locala = new d.a();
    locala.sG(getType());
    ato localato = new ato();
    localato.hFK = this.feedId;
    localato.objectNonceId = this.hwg;
    localato.dLS = this.dLS;
    localato.dTj = this.iUZ;
    localato.latitude = this.iUY;
    localato.lastBuffer = this.lastBuffer;
    aov localaov = this.tvt;
    Object localObject = localaov;
    if (localaov == null)
    {
      localObject = am.tuw;
      localObject = am.a(this.ttO);
    }
    localato.LAI = ((aov)localObject);
    localato.scene = this.tvr;
    localato.tvs = this.tvs;
    locala.c((com.tencent.mm.bw.a)localato);
    locala.d((com.tencent.mm.bw.a)new atp());
    locala.MB("/cgi-bin/micromsg-bin/findergetrelatedlist");
    localObject = locala.aXF();
    p.g(localObject, "builder.buildInstance()");
    this.rr = ((d)localObject);
    Log.i(this.TAG, "NetSceneFinderGetRelatedList feedId " + this.feedId + " tabType " + this.dLS + " category " + this.category + " lastBuffer " + this.lastBuffer);
    AppMethodBeat.o(242444);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(242446);
    Log.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = this.TAG;
      Object localObject = new StringBuilder("feedId ").append(this.feedId).append(" tabType=").append(this.dLS).append(", ");
      al localal = al.tuv;
      Log.i(params, al.dQ((List)cYr()));
      params = ((Iterable)cYr()).iterator();
      while (params.hasNext()) {
        d((FinderObject)params.next());
      }
      params = this.rr;
      if (params == null) {
        p.btv("rr");
      }
      params = params.aYK();
      if ((params instanceof atp))
      {
        localObject = com.tencent.mm.plugin.finder.preload.a.uTO;
        localObject = ((atp)params).preloadInfo;
        params = ((atp)params).object;
        p.g(params, "resp.`object`");
        com.tencent.mm.plugin.finder.preload.a.a((baw)localObject, (List)params, 3688);
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
    AppMethodBeat.o(242446);
  }
  
  public final boolean cXQ()
  {
    return true;
  }
  
  public final b cYm()
  {
    AppMethodBeat.i(242447);
    Object localObject = this.rr;
    if (localObject == null) {
      p.btv("rr");
    }
    localObject = ((d)localObject).aYK();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetRelatedListResp");
      AppMethodBeat.o(242447);
      throw ((Throwable)localObject);
    }
    localObject = ((atp)localObject).lastBuffer;
    AppMethodBeat.o(242447);
    return localObject;
  }
  
  public final boolean cYp()
  {
    AppMethodBeat.i(242449);
    Object localObject = this.rr;
    if (localObject == null) {
      p.btv("rr");
    }
    localObject = ((d)localObject).aYK();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetRelatedListResp");
      AppMethodBeat.o(242449);
      throw ((Throwable)localObject);
    }
    if (((atp)localObject).continueFlag != 0)
    {
      AppMethodBeat.o(242449);
      return true;
    }
    AppMethodBeat.o(242449);
    return false;
  }
  
  public final LinkedList<FinderObject> cYr()
  {
    AppMethodBeat.i(242448);
    Object localObject = this.rr;
    if (localObject == null) {
      p.btv("rr");
    }
    localObject = ((d)localObject).aYK();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetRelatedListResp");
      AppMethodBeat.o(242448);
      throw ((Throwable)localObject);
    }
    LinkedList localLinkedList = ((atp)localObject).object;
    localObject = localLinkedList;
    if (localLinkedList == null) {
      localObject = new LinkedList();
    }
    AppMethodBeat.o(242448);
    return localObject;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(242445);
    this.callback = parami;
    parami = this.rr;
    if (parami == null) {
      p.btv("rr");
    }
    int i = dispatch(paramg, (s)parami, (m)this);
    AppMethodBeat.o(242445);
    return i;
  }
  
  public final int getType()
  {
    return 3688;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.bq
 * JD-Core Version:    0.7.0.1
 */