package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aoj;
import com.tencent.mm.protocal.protobuf.aok;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.protocal.protobuf.arg;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetRelatedList;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "tabType", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "relScene", "lng", "", "lat", "sectionInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(ILcom/tencent/mm/protobuf/ByteString;IFFLcom/tencent/mm/protocal/protobuf/FinderSectionInfo;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "category", "getCategory", "()Ljava/lang/String;", "setCategory", "(Ljava/lang/String;)V", "feedId", "", "getFeedId", "()J", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "getLat", "()F", "setLat", "(F)V", "getLng", "setLng", "nonceId", "getNonceId", "pullType", "getPullType", "()I", "setPullType", "(I)V", "getRelScene", "setRelScene", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getSectionInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "setSectionInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;)V", "getTabType", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getFeedRelList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getRequestBuffer", "getResponseBuffer", "getType", "hasContinue", "", "isFetchFeedCgi", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "realInit", "plugin-finder_release"})
public final class ap
  extends ac
{
  private final String TAG;
  private f callback;
  private String category;
  private final long dtq;
  private final int duh;
  private float hXj;
  private float hXk;
  private final com.tencent.mm.bx.b lastBuffer;
  public int pullType;
  private final String rHO;
  private int rJu;
  private arg rJv;
  public com.tencent.mm.al.b rr;
  
  public ap(int paramInt, com.tencent.mm.bx.b paramb, float paramFloat1, float paramFloat2, arg paramarg, aqy paramaqy)
  {
    super(paramaqy);
    AppMethodBeat.i(201147);
    this.TAG = "Finder.NetSceneFinderGetRelatedList";
    this.rHO = "";
    this.category = "";
    this.rJu = -1;
    this.duh = paramInt;
    this.lastBuffer = paramb;
    this.rJu = 2;
    this.hXk = paramFloat1;
    this.hXj = paramFloat2;
    this.rJv = paramarg;
    paramb = new b.a();
    paramb.oP(getType());
    paramarg = new aoj();
    paramarg.rIZ = this.dtq;
    paramarg.duh = this.duh;
    paramarg.dAp = this.hXk;
    paramarg.dyz = this.hXj;
    paramarg.lastBuffer = this.lastBuffer;
    paramaqy = v.rIR;
    paramarg.Gle = v.a(this.rIl);
    paramarg.scene = this.rJu;
    paramarg.rJv = this.rJv;
    paramb.c((com.tencent.mm.bx.a)paramarg);
    paramb.d((com.tencent.mm.bx.a)new aok());
    paramb.Dl("/cgi-bin/micromsg-bin/findergetrelatedlist");
    paramb = paramb.aDC();
    p.g(paramb, "builder.buildInstance()");
    this.rr = paramb;
    ad.i(this.TAG, "NetSceneFinderGetRelatedList feedId " + this.dtq + " tabType " + this.duh + " category " + this.category + " lastBuffer " + this.lastBuffer);
    AppMethodBeat.o(201147);
  }
  
  public final boolean cxU()
  {
    return true;
  }
  
  public final LinkedList<FinderObject> cyi()
  {
    AppMethodBeat.i(201146);
    Object localObject = this.rr;
    if (localObject == null) {
      p.bcb("rr");
    }
    localObject = ((com.tencent.mm.al.b)localObject).aEF();
    if (localObject == null)
    {
      localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetRelatedListResp");
      AppMethodBeat.o(201146);
      throw ((Throwable)localObject);
    }
    LinkedList localLinkedList = ((aok)localObject).object;
    localObject = localLinkedList;
    if (localLinkedList == null) {
      localObject = new LinkedList();
    }
    AppMethodBeat.o(201146);
    return localObject;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(201144);
    this.callback = paramf;
    paramf = this.rr;
    if (paramf == null) {
      p.bcb("rr");
    }
    int i = dispatch(parame, (q)paramf, (k)this);
    AppMethodBeat.o(201144);
    return i;
  }
  
  public final int getType()
  {
    return 3688;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(201145);
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, paramq, paramArrayOfByte);
    ad.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = this.TAG;
      paramArrayOfByte = new StringBuilder("feedId ").append(this.dtq).append(" tabType=").append(this.duh).append(", ");
      u localu = u.rIQ;
      ad.i(paramq, u.dy((List)cyi()));
      paramq = ((Iterable)cyi()).iterator();
      while (paramq.hasNext()) {
        d((FinderObject)paramq.next());
      }
      paramq = this.rr;
      if (paramq == null) {
        p.bcb("rr");
      }
      paramq = paramq.aEF();
      if ((paramq instanceof aok))
      {
        paramArrayOfByte = com.tencent.mm.plugin.finder.preload.a.skH;
        paramArrayOfByte = ((aok)paramq).saW;
        paramq = ((aok)paramq).object;
        p.g(paramq, "resp.`object`");
        com.tencent.mm.plugin.finder.preload.a.a(paramArrayOfByte, (List)paramq);
      }
    }
    if (this.callback != null)
    {
      paramq = this.callback;
      if (paramq == null) {
        p.gfZ();
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
    }
    AppMethodBeat.o(201145);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ap
 * JD-Core Version:    0.7.0.1
 */