package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.f;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.api.c.a;
import com.tencent.mm.plugin.finder.api.g;
import com.tencent.mm.protocal.protobuf.als;
import com.tencent.mm.protocal.protobuf.alt;
import com.tencent.mm.protocal.protobuf.alw;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneAdFeedList;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "req_username", "", "feedId", "", "encryptedFeedId", "maxId", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "pullType", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;JLjava/lang/String;JLcom/tencent/mm/protobuf/ByteString;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "continueFlag", "", "getContinueFlag", "()Z", "setContinueFlag", "(Z)V", "getEncryptedFeedId", "()Ljava/lang/String;", "getFeedId", "()J", "objectList", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getObjectList", "()Ljava/util/List;", "setObjectList", "(Ljava/util/List;)V", "getPullType", "()I", "setPullType", "(I)V", "getReq_username", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getAdFeedList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getPrivateLock", "getResponseBuffer", "getType", "getWording", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class y
  extends ad
  implements k
{
  public static final a rRj;
  private f callback;
  private final long duw;
  public int pullType;
  public boolean rRg;
  private final String rRh;
  private final String rRi;
  public com.tencent.mm.ak.b rr;
  
  static
  {
    AppMethodBeat.i(201517);
    rRj = new a((byte)0);
    AppMethodBeat.o(201517);
  }
  
  public y(String paramString1, long paramLong1, String paramString2, long paramLong2, com.tencent.mm.bw.b paramb, int paramInt, arn paramarn)
  {
    super(paramarn);
    AppMethodBeat.i(201516);
    this.rRh = paramString1;
    this.duw = paramLong1;
    this.rRi = paramString2;
    this.rRg = true;
    paramString1 = c.rPy;
    paramString1 = c.a.ahT(this.rRh);
    if (paramString1 != null)
    {
      paramString1 = paramString1.field_firstPageMD5;
      if (paramString1 != null) {}
    }
    else
    {
      paramString1 = "";
    }
    for (;;)
    {
      paramString2 = new b.a();
      paramString2.DN("/cgi-bin/micromsg-bin/finderaduserpage");
      paramString2.oS(getType());
      als localals = new als();
      localals.username = this.rRh;
      localals.zxX = paramLong2;
      localals.firstPageMD5 = paramString1;
      Object localObject = v.rRb;
      localals.GDS = v.cXN();
      localals.GDP = com.tencent.mm.model.v.aAK();
      localObject = v.rRb;
      localals.GDR = v.a(paramarn);
      localObject = localals.GDR;
      if (localObject != null) {
        if (paramarn == null) {
          break label362;
        }
      }
      label362:
      for (int i = paramarn.tnf;; i = 0)
      {
        ((alw)localObject).scene = i;
        if (d.n.n.H(localals.username, localals.GDP, false)) {
          localals.GDQ = 1;
        }
        localals.GDT = this.duw;
        localals.sef = this.rRi;
        localals.lastBuffer = paramb;
        paramb = new alt();
        paramString2.c((a)localals);
        paramString2.d((a)paramb);
        paramString2 = paramString2.aDS();
        p.g(paramString2, "builder.buildInstance()");
        this.rr = paramString2;
        this.pullType = paramInt;
        ae.i("Finder.NetSceneAdFeedListval", "NetSceneFinderUserPage init maxId " + paramLong2 + " username " + this.rRh + " pullType " + paramInt + " fpMD5 " + paramString1);
        AppMethodBeat.o(201516);
        return;
      }
    }
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(201514);
    this.callback = paramf;
    int i = dispatch(parame, (q)this.rr, (k)this);
    AppMethodBeat.o(201514);
    return i;
  }
  
  public final int getType()
  {
    return 6692;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(201515);
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, paramq, paramArrayOfByte);
    ae.i("Finder.NetSceneAdFeedListval", "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = this.rr.aEV();
      if (paramq == null)
      {
        paramString = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderAdUserPageResponse");
        AppMethodBeat.o(201515);
        throw paramString;
      }
      if (((alt)paramq).continueFlag != 1) {
        break label169;
      }
    }
    label169:
    for (boolean bool = true;; bool = false)
    {
      this.rRg = bool;
      if (this.callback != null)
      {
        paramq = this.callback;
        if (paramq == null) {
          p.gkB();
        }
        paramq.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.ak.n)this);
      }
      AppMethodBeat.o(201515);
      return;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneAdFeedList$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.y
 * JD-Core Version:    0.7.0.1
 */