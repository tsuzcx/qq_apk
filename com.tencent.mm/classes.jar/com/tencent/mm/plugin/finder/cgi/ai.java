package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.e;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.ale;
import com.tencent.mm.protocal.protobuf.alf;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.anu;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;
import d.v;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetRelatedList;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "tabType", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "relScene", "lng", "", "lat", "sectionInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(ILcom/tencent/mm/protobuf/ByteString;IFFLcom/tencent/mm/protocal/protobuf/FinderSectionInfo;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "category", "getCategory", "()Ljava/lang/String;", "setCategory", "(Ljava/lang/String;)V", "feedId", "", "getFeedId", "()J", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "getLat", "()F", "setLat", "(F)V", "getLng", "setLng", "nonceId", "getNonceId", "pullType", "getPullType", "()I", "setPullType", "(I)V", "getRelScene", "setRelScene", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getSectionInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "setSectionInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;)V", "getTabType", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getFeedRelList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getRequestBuffer", "getResponseBuffer", "getType", "hasContinue", "", "isFetchFeedCgi", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "realInit", "plugin-finder_release"})
public final class ai
  extends w
{
  private final String TAG;
  private g callback;
  private String category;
  private final long dig;
  private final int diw;
  private float hEE;
  private float hEF;
  private final com.tencent.mm.bw.b lastBuffer;
  public int pullType;
  private final String qXC;
  private int qYi;
  private anu qYj;
  public com.tencent.mm.ak.b rr;
  
  public ai(int paramInt, com.tencent.mm.bw.b paramb, float paramFloat1, float paramFloat2, anu paramanu, anm paramanm)
  {
    super(paramanm);
    AppMethodBeat.i(201199);
    this.TAG = "Finder.NetSceneFinderGetRelatedList";
    this.qXC = "";
    this.category = "";
    this.qYi = -1;
    this.diw = paramInt;
    this.lastBuffer = paramb;
    this.qYi = 2;
    this.hEF = paramFloat1;
    this.hEE = paramFloat2;
    this.qYj = paramanu;
    paramb = new b.a();
    paramb.op(getType());
    paramanu = new ale();
    paramanu.qXP = this.dig;
    paramanu.diw = this.diw;
    paramanu.doB = this.hEF;
    paramanu.dmL = this.hEE;
    paramanu.lastBuffer = this.lastBuffer;
    paramanm = q.qXH;
    paramanu.EDu = q.a(this.contextObj);
    paramanu.scene = this.qYi;
    paramanu.qYj = this.qYj;
    paramb.c((a)paramanu);
    paramb.d((a)new alf());
    paramb.Am("/cgi-bin/micromsg-bin/findergetrelatedlist");
    paramb = paramb.aAz();
    d.g.b.k.g(paramb, "builder.buildInstance()");
    this.rr = paramb;
    ac.i(this.TAG, "NetSceneFinderGetRelatedList feedId " + this.dig + " tabType " + this.diw + " category " + this.category + " lastBuffer " + this.lastBuffer);
    AppMethodBeat.o(201199);
  }
  
  public final boolean csf()
  {
    return true;
  }
  
  public final LinkedList<FinderObject> csr()
  {
    AppMethodBeat.i(201198);
    Object localObject = this.rr;
    if (localObject == null) {
      d.g.b.k.aVY("rr");
    }
    localObject = ((com.tencent.mm.ak.b)localObject).aBD();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetRelatedListResp");
      AppMethodBeat.o(201198);
      throw ((Throwable)localObject);
    }
    LinkedList localLinkedList = ((alf)localObject).object;
    localObject = localLinkedList;
    if (localLinkedList == null) {
      localObject = new LinkedList();
    }
    AppMethodBeat.o(201198);
    return localObject;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(201196);
    this.callback = paramg;
    paramg = this.rr;
    if (paramg == null) {
      d.g.b.k.aVY("rr");
    }
    int i = dispatch(parame, (com.tencent.mm.network.q)paramg, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(201196);
    return i;
  }
  
  public final int getType()
  {
    return 3688;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(201197);
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, paramq, paramArrayOfByte);
    ac.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = this.TAG;
      paramArrayOfByte = new StringBuilder("feedId ").append(this.dig).append(" tabType=").append(this.diw).append(", ");
      p localp = p.qXG;
      ac.i(paramq, p.dw((List)csr()));
      paramq = ((Iterable)csr()).iterator();
      while (paramq.hasNext()) {
        d((FinderObject)paramq.next());
      }
    }
    if (this.callback != null)
    {
      paramq = this.callback;
      if (paramq == null) {
        d.g.b.k.fOy();
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
    }
    AppMethodBeat.o(201197);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ai
 * JD-Core Version:    0.7.0.1
 */