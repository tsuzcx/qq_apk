package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.dyz;
import com.tencent.mm.protocal.protobuf.dza;
import com.tencent.mm.protocal.protobuf.dzp;
import com.tencent.mm.protocal.protobuf.dzq;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;
import d.v;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetRelatedList;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "tabType", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "relScene", "lng", "", "lat", "sectionInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(ILcom/tencent/mm/protobuf/ByteString;IFFLcom/tencent/mm/protocal/protobuf/FinderSectionInfo;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "category", "getCategory", "()Ljava/lang/String;", "setCategory", "(Ljava/lang/String;)V", "feedId", "", "getFeedId", "()J", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "getLat", "()F", "setLat", "(F)V", "getLng", "setLng", "nonceId", "getNonceId", "pullType", "getPullType", "()I", "setPullType", "(I)V", "getRelScene", "setRelScene", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getSectionInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "setSectionInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;)V", "getTabType", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getFeedRelList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getRequestBuffer", "getResponseBuffer", "getType", "hasContinue", "", "isFetchFeedCgi", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "realInit", "plugin-finder_release"})
public final class av
  extends ap
{
  private final int IoU;
  private int KJI;
  private dzq KJJ;
  private final String KJv;
  private final String TAG;
  private g callback;
  private String category;
  private final long feedId;
  private float heb;
  private float hec;
  private final com.tencent.mm.bx.b lastBuffer;
  public int pullType;
  public com.tencent.mm.al.b rr;
  
  public av(int paramInt, com.tencent.mm.bx.b paramb, float paramFloat1, float paramFloat2, dzq paramdzq, dzp paramdzp)
  {
    super(paramdzp);
    AppMethodBeat.i(197321);
    this.TAG = "Finder.NetSceneFinderGetRelatedList";
    this.KJv = "";
    this.category = "";
    this.KJI = -1;
    this.IoU = paramInt;
    this.lastBuffer = paramb;
    this.KJI = 2;
    this.hec = paramFloat1;
    this.heb = paramFloat2;
    this.KJJ = paramdzq;
    paramb = new b.a();
    paramb.nB(getType());
    paramdzq = new dyz();
    paramdzq.objectId = this.feedId;
    paramdzq.IoU = this.IoU;
    paramdzq.dqQ = this.hec;
    paramdzq.dpb = this.heb;
    paramdzq.lastBuffer = this.lastBuffer;
    paramdzp = am.KJy;
    paramdzq.DlF = am.a(this.contextObj);
    paramdzq.scene = this.KJI;
    paramdzq.KJJ = this.KJJ;
    paramb.c((a)paramdzq);
    paramb.d((a)new dza());
    paramb.wg("/cgi-bin/micromsg-bin/findergetrelatedlist");
    paramb = paramb.atI();
    d.g.b.k.g(paramb, "builder.buildInstance()");
    this.rr = paramb;
    ad.i(this.TAG, "NetSceneFinderGetRelatedList feedId " + this.feedId + " tabType " + this.IoU + " category " + this.category + " lastBuffer " + this.lastBuffer);
    AppMethodBeat.o(197321);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(197318);
    this.callback = paramg;
    paramg = this.rr;
    if (paramg == null) {
      d.g.b.k.aPZ("rr");
    }
    int i = dispatch(parame, (q)paramg, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(197318);
    return i;
  }
  
  public final boolean fRR()
  {
    return true;
  }
  
  public final LinkedList<FinderObject> fRV()
  {
    AppMethodBeat.i(197320);
    Object localObject = this.rr;
    if (localObject == null) {
      d.g.b.k.aPZ("rr");
    }
    localObject = ((com.tencent.mm.al.b)localObject).auM();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetRelatedListResp");
      AppMethodBeat.o(197320);
      throw ((Throwable)localObject);
    }
    LinkedList localLinkedList = ((dza)localObject).object;
    localObject = localLinkedList;
    if (localLinkedList == null) {
      localObject = new LinkedList();
    }
    AppMethodBeat.o(197320);
    return localObject;
  }
  
  public final int getType()
  {
    return 3688;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(197319);
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, paramq, paramArrayOfByte);
    ad.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = this.TAG;
      paramArrayOfByte = new StringBuilder("feedId ").append(this.feedId).append(" tabType=").append(this.IoU).append(", ");
      i locali = i.qoK;
      ad.i(paramq, i.du((List)fRV()));
      paramq = ((Iterable)fRV()).iterator();
      while (paramq.hasNext()) {
        k((FinderObject)paramq.next());
      }
    }
    if (this.callback != null)
    {
      paramq = this.callback;
      if (paramq == null) {
        d.g.b.k.fvU();
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
    }
    AppMethodBeat.o(197319);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.av
 * JD-Core Version:    0.7.0.1
 */