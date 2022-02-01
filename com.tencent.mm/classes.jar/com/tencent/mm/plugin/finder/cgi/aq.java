package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aow;
import com.tencent.mm.protocal.protobuf.aox;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetRelatedList;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "tabType", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "relScene", "lng", "", "lat", "sectionInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(ILcom/tencent/mm/protobuf/ByteString;IFFLcom/tencent/mm/protocal/protobuf/FinderSectionInfo;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "category", "getCategory", "()Ljava/lang/String;", "setCategory", "(Ljava/lang/String;)V", "feedId", "", "getFeedId", "()J", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "getLat", "()F", "setLat", "(F)V", "getLng", "setLng", "nonceId", "getNonceId", "pullType", "getPullType", "()I", "setPullType", "(I)V", "getRelScene", "setRelScene", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getSectionInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "setSectionInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;)V", "getTabType", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getFeedRelList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getRequestBuffer", "getResponseBuffer", "getType", "hasContinue", "", "isFetchFeedCgi", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "realInit", "plugin-finder_release"})
public final class aq
  extends ad
{
  private final String TAG;
  private f callback;
  private String category;
  private final long duw;
  private final int dvm;
  private float iab;
  private float iac;
  private final com.tencent.mm.bw.b lastBuffer;
  public int pullType;
  private final String rPZ;
  private int rRI;
  private arv rRJ;
  public com.tencent.mm.ak.b rr;
  
  public aq(int paramInt, com.tencent.mm.bw.b paramb, float paramFloat1, float paramFloat2, arv paramarv, arn paramarn)
  {
    super(paramarn);
    AppMethodBeat.i(201569);
    this.TAG = "Finder.NetSceneFinderGetRelatedList";
    this.rPZ = "";
    this.category = "";
    this.rRI = -1;
    this.dvm = paramInt;
    this.lastBuffer = paramb;
    this.rRI = 2;
    this.iac = paramFloat1;
    this.iab = paramFloat2;
    this.rRJ = paramarv;
    paramb = new b.a();
    paramb.oS(getType());
    paramarv = new aow();
    paramarv.rRn = this.duw;
    paramarv.dvm = this.dvm;
    paramarv.dBu = this.iac;
    paramarv.dzE = this.iab;
    paramarv.lastBuffer = this.lastBuffer;
    paramarn = v.rRb;
    paramarv.GEg = v.a(this.rQw);
    paramarv.scene = this.rRI;
    paramarv.rRJ = this.rRJ;
    paramb.c((com.tencent.mm.bw.a)paramarv);
    paramb.d((com.tencent.mm.bw.a)new aox());
    paramb.DN("/cgi-bin/micromsg-bin/findergetrelatedlist");
    paramb = paramb.aDS();
    p.g(paramb, "builder.buildInstance()");
    this.rr = paramb;
    ae.i(this.TAG, "NetSceneFinderGetRelatedList feedId " + this.duw + " tabType " + this.dvm + " category " + this.category + " lastBuffer " + this.lastBuffer);
    AppMethodBeat.o(201569);
  }
  
  public final LinkedList<FinderObject> czJ()
  {
    AppMethodBeat.i(201568);
    Object localObject = this.rr;
    if (localObject == null) {
      p.bdF("rr");
    }
    localObject = ((com.tencent.mm.ak.b)localObject).aEV();
    if (localObject == null)
    {
      localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetRelatedListResp");
      AppMethodBeat.o(201568);
      throw ((Throwable)localObject);
    }
    LinkedList localLinkedList = ((aox)localObject).object;
    localObject = localLinkedList;
    if (localLinkedList == null) {
      localObject = new LinkedList();
    }
    AppMethodBeat.o(201568);
    return localObject;
  }
  
  public final boolean czv()
  {
    return true;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(201566);
    this.callback = paramf;
    paramf = this.rr;
    if (paramf == null) {
      p.bdF("rr");
    }
    int i = dispatch(parame, (q)paramf, (k)this);
    AppMethodBeat.o(201566);
    return i;
  }
  
  public final int getType()
  {
    return 3688;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(201567);
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, paramq, paramArrayOfByte);
    ae.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = this.TAG;
      paramArrayOfByte = new StringBuilder("feedId ").append(this.duw).append(" tabType=").append(this.dvm).append(", ");
      u localu = u.rRa;
      ae.i(paramq, u.dB((List)czJ()));
      paramq = ((Iterable)czJ()).iterator();
      while (paramq.hasNext()) {
        d((FinderObject)paramq.next());
      }
      paramq = this.rr;
      if (paramq == null) {
        p.bdF("rr");
      }
      paramq = paramq.aEV();
      if ((paramq instanceof aox))
      {
        paramArrayOfByte = com.tencent.mm.plugin.finder.preload.a.stE;
        paramArrayOfByte = ((aox)paramq).preloadInfo;
        paramq = ((aox)paramq).object;
        p.g(paramq, "resp.`object`");
        com.tencent.mm.plugin.finder.preload.a.a(paramArrayOfByte, (List)paramq, 3688);
      }
    }
    if (this.callback != null)
    {
      paramq = this.callback;
      if (paramq == null) {
        p.gkB();
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
    }
    AppMethodBeat.o(201567);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.aq
 * JD-Core Version:    0.7.0.1
 */