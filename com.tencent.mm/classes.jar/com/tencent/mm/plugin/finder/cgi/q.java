package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.aiz;
import com.tencent.mm.protocal.protobuf.aja;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import d.l;
import d.v;
import d.y;
import java.util.Iterator;
import java.util.LinkedList;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetFollowList;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "(Lcom/tencent/mm/protobuf/ByteString;)V", "TAG", "", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getFollowContactList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "getRequestBuffer", "getResponseBuffer", "getType", "hasContinue", "", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class q
  extends n
  implements com.tencent.mm.network.k
{
  private final String TAG;
  private com.tencent.mm.al.g callback;
  private com.tencent.mm.al.b rr;
  
  public q(com.tencent.mm.bx.b paramb)
  {
    AppMethodBeat.i(165225);
    this.TAG = "Finder.NetSceneFinderGetFollowList";
    com.tencent.mm.al.b.a locala = new com.tencent.mm.al.b.a();
    locala.nB(getType());
    aiz localaiz = new aiz();
    localaiz.lastBuffer = paramb;
    paramb = am.KJy;
    localaiz.Dkw = am.fRS();
    locala.c((a)localaiz);
    locala.d((a)new aja());
    locala.wg("/cgi-bin/micromsg-bin/findergetfollowlist");
    paramb = locala.atI();
    d.g.b.k.g(paramb, "builder.buildInstance()");
    this.rr = paramb;
    ad.i(this.TAG, "NetSceneFinderGetFollowList init ");
    AppMethodBeat.o(165225);
  }
  
  public final LinkedList<FinderContact> ckI()
  {
    AppMethodBeat.i(165223);
    Object localObject = this.rr.auM();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFollowListResponse");
      AppMethodBeat.o(165223);
      throw ((Throwable)localObject);
    }
    localObject = ((aja)localObject).qMq;
    d.g.b.k.g(localObject, "(rr.responseProtoBuf as …ListResponse).contactList");
    AppMethodBeat.o(165223);
    return localObject;
  }
  
  public final com.tencent.mm.bx.b ckJ()
  {
    AppMethodBeat.i(165224);
    a locala = this.rr.auM();
    Object localObject = locala;
    if (!(locala instanceof aja)) {
      localObject = null;
    }
    localObject = (aja)localObject;
    if (localObject != null)
    {
      localObject = ((aja)localObject).lastBuffer;
      AppMethodBeat.o(165224);
      return localObject;
    }
    AppMethodBeat.o(165224);
    return null;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(165221);
    this.callback = paramg;
    int i = dispatch(parame, (com.tencent.mm.network.q)this.rr, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(165221);
    return i;
  }
  
  public final boolean fRW()
  {
    AppMethodBeat.i(197298);
    Object localObject = this.rr.auM();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFollowListResponse");
      AppMethodBeat.o(197298);
      throw ((Throwable)localObject);
    }
    if (((aja)localObject).continueFlag != 0)
    {
      AppMethodBeat.o(197298);
      return true;
    }
    AppMethodBeat.o(197298);
    return false;
  }
  
  public final com.tencent.mm.bx.b fRY()
  {
    AppMethodBeat.i(197299);
    a locala = this.rr.auL();
    Object localObject = locala;
    if (!(locala instanceof aiz)) {
      localObject = null;
    }
    localObject = (aiz)localObject;
    if (localObject != null)
    {
      localObject = ((aiz)localObject).lastBuffer;
      AppMethodBeat.o(197299);
      return localObject;
    }
    AppMethodBeat.o(197299);
    return null;
  }
  
  public final int getType()
  {
    return 713;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(165222);
    ad.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      com.tencent.mm.plugin.report.e.vIY.idkeyStat(1279L, 7L, 1L, false);
    }
    for (;;)
    {
      paramq = this.rr.auL();
      if (paramq != null) {
        break;
      }
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFollowListRequest");
      AppMethodBeat.o(165222);
      throw paramString;
      com.tencent.mm.plugin.report.e.vIY.idkeyStat(1279L, 8L, 1L, false);
    }
    if (((aiz)paramq).lastBuffer == null)
    {
      paramq = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(paramq, "MMKernel.storage()");
      paramq = paramq.afk();
      paramArrayOfByte = ae.a.FwW;
      localObject = this.rr.auM();
      if (localObject == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFollowListResponse");
        AppMethodBeat.o(165222);
        throw paramString;
      }
      paramq.set(paramArrayOfByte, Integer.valueOf(((aja)localObject).Dlr));
      paramq = y.JfV;
    }
    paramq = ckI();
    paramArrayOfByte = this.TAG;
    Object localObject = new StringBuilder("firstPage ");
    if (ckJ() == null) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i(paramArrayOfByte, bool + ", get " + paramq.size() + " follow contact ");
      paramq = ((Iterable)paramq).iterator();
      while (paramq.hasNext())
      {
        paramArrayOfByte = (FinderContact)paramq.next();
        localObject = com.tencent.mm.plugin.finder.api.b.qnX;
        com.tencent.mm.plugin.finder.api.b.a.a(paramArrayOfByte);
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
    AppMethodBeat.o(165222);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.q
 * JD-Core Version:    0.7.0.1
 */