package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aov;
import com.tencent.mm.protocal.protobuf.asv;
import com.tencent.mm.protocal.protobuf.asw;
import com.tencent.mm.protocal.protobuf.bcc;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetLiveRelatedList;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "relScene", "", "lng", "", "lat", "sectionInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protobuf/ByteString;IFFLcom/tencent/mm/protocal/protobuf/FinderSectionInfo;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "objectId", "", "nonceId", "", "scene", "baseRequest", "Lcom/tencent/mm/protocal/protobuf/FinderBaseRequest;", "(JLjava/lang/String;Lcom/tencent/mm/protobuf/ByteString;IFFLcom/tencent/mm/protocal/protobuf/FinderBaseRequest;)V", "TAG", "getBaseRequest", "()Lcom/tencent/mm/protocal/protobuf/FinderBaseRequest;", "setBaseRequest", "(Lcom/tencent/mm/protocal/protobuf/FinderBaseRequest;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "category", "getCategory", "()Ljava/lang/String;", "setCategory", "(Ljava/lang/String;)V", "feedId", "getFeedId", "()J", "setFeedId", "(J)V", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "getLat", "()F", "setLat", "(F)V", "getLng", "setLng", "getNonceId", "setNonceId", "pullType", "getPullType", "()I", "setPullType", "(I)V", "getRelScene", "setRelScene", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getSectionInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "setSectionInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;)V", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getFeedRelList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getRequestBuffer", "getResponseBuffer", "getType", "hasContinue", "", "isFetchFeedCgi", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "realInit", "plugin-finder_release"})
public final class bn
  extends ax
{
  private final String TAG;
  private i callback;
  private String category;
  private long feedId;
  private String hwg;
  private float iUY;
  private float iUZ;
  private final b lastBuffer;
  public int pullType;
  public d rr;
  private int tvr;
  private bcc tvs;
  private aov tvt;
  
  public bn(long paramLong, String paramString, b paramb, int paramInt, float paramFloat1, float paramFloat2, aov paramaov)
  {
    AppMethodBeat.i(242437);
    this.TAG = "NetSceneFinderGetLiveRelatedList";
    this.hwg = "";
    this.category = "";
    this.tvr = -1;
    this.feedId = paramLong;
    this.hwg = paramString;
    this.lastBuffer = paramb;
    this.tvr = paramInt;
    this.iUZ = paramFloat1;
    this.iUY = paramFloat2;
    this.tvs = null;
    this.tvt = paramaov;
    paramaov = new d.a();
    paramaov.sG(getType());
    asv localasv = new asv();
    localasv.object_id = this.feedId;
    localasv.object_nonce_id = this.hwg;
    localasv.dTj = this.iUZ;
    localasv.latitude = this.iUY;
    localasv.LDs = this.lastBuffer;
    paramb = this.tvt;
    paramString = paramb;
    if (paramb == null)
    {
      paramString = am.tuw;
      paramString = am.a(this.ttO);
    }
    localasv.LBM = paramString;
    localasv.scene = this.tvr;
    paramaov.c((a)localasv);
    paramaov.d((a)new asw());
    paramaov.MB("/cgi-bin/micromsg-bin/findergetliverelatedlist");
    paramString = paramaov.aXF();
    p.g(paramString, "builder.buildInstance()");
    this.rr = paramString;
    Log.i(this.TAG, "feedId " + this.feedId + "  category " + this.category + " lastBuffer relScene:" + this.tvr + ' ' + this.lastBuffer);
    AppMethodBeat.o(242437);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(242435);
    Log.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder("feedId ").append(this.feedId).append(", ");
      al localal = al.tuv;
      Log.i(params, al.dQ((List)cYr()));
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
    AppMethodBeat.o(242435);
  }
  
  public final boolean cXQ()
  {
    return true;
  }
  
  public final LinkedList<FinderObject> cYr()
  {
    AppMethodBeat.i(242436);
    Object localObject = this.rr;
    if (localObject == null) {
      p.btv("rr");
    }
    localObject = ((d)localObject).aYK();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetLiveRelatedListResponse");
      AppMethodBeat.o(242436);
      throw ((Throwable)localObject);
    }
    LinkedList localLinkedList = ((asw)localObject).object;
    localObject = localLinkedList;
    if (localLinkedList == null) {
      localObject = new LinkedList();
    }
    AppMethodBeat.o(242436);
    return localObject;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(242434);
    this.callback = parami;
    parami = this.rr;
    if (parami == null) {
      p.btv("rr");
    }
    int i = dispatch(paramg, (s)parami, (m)this);
    AppMethodBeat.o(242434);
    return i;
  }
  
  public final int getType()
  {
    return 6479;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.bn
 * JD-Core Version:    0.7.0.1
 */