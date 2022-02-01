package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.akr;
import com.tencent.mm.protocal.protobuf.aks;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import d.l;
import d.v;
import d.y;
import java.util.Iterator;
import java.util.LinkedList;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetFollowList;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "(Lcom/tencent/mm/protobuf/ByteString;)V", "TAG", "", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getFollowContactList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "getRequestBuffer", "getResponseBuffer", "getType", "hasContinue", "", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class ad
  extends n
  implements com.tencent.mm.network.k
{
  private final String TAG;
  private com.tencent.mm.ak.g callback;
  private com.tencent.mm.ak.b rr;
  
  public ad(com.tencent.mm.bw.b paramb)
  {
    AppMethodBeat.i(165225);
    this.TAG = "Finder.NetSceneFinderGetFollowList";
    com.tencent.mm.ak.b.a locala = new com.tencent.mm.ak.b.a();
    locala.op(getType());
    akr localakr = new akr();
    localakr.lastBuffer = paramb;
    paramb = q.qXH;
    localakr.EDL = q.csi();
    locala.c((a)localakr);
    locala.d((a)new aks());
    locala.Am("/cgi-bin/micromsg-bin/findergetfollowlist");
    paramb = locala.aAz();
    d.g.b.k.g(paramb, "builder.buildInstance()");
    this.rr = paramb;
    ac.i(this.TAG, "NetSceneFinderGetFollowList init ");
    AppMethodBeat.o(165225);
  }
  
  public final com.tencent.mm.bw.b csq()
  {
    AppMethodBeat.i(165224);
    a locala = this.rr.aBD();
    Object localObject = locala;
    if (!(locala instanceof aks)) {
      localObject = null;
    }
    localObject = (aks)localObject;
    if (localObject != null)
    {
      localObject = ((aks)localObject).lastBuffer;
      AppMethodBeat.o(165224);
      return localObject;
    }
    AppMethodBeat.o(165224);
    return null;
  }
  
  public final boolean css()
  {
    AppMethodBeat.i(201176);
    Object localObject = this.rr.aBD();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFollowListResponse");
      AppMethodBeat.o(201176);
      throw ((Throwable)localObject);
    }
    if (((aks)localObject).continueFlag != 0)
    {
      AppMethodBeat.o(201176);
      return true;
    }
    AppMethodBeat.o(201176);
    return false;
  }
  
  public final LinkedList<FinderContact> csu()
  {
    AppMethodBeat.i(165223);
    Object localObject = this.rr.aBD();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFollowListResponse");
      AppMethodBeat.o(165223);
      throw ((Throwable)localObject);
    }
    localObject = ((aks)localObject).rHC;
    d.g.b.k.g(localObject, "(rr.responseProtoBuf as …ListResponse).contactList");
    AppMethodBeat.o(165223);
    return localObject;
  }
  
  public final com.tencent.mm.bw.b csv()
  {
    AppMethodBeat.i(201177);
    a locala = this.rr.aBC();
    Object localObject = locala;
    if (!(locala instanceof akr)) {
      localObject = null;
    }
    localObject = (akr)localObject;
    if (localObject != null)
    {
      localObject = ((akr)localObject).lastBuffer;
      AppMethodBeat.o(201177);
      return localObject;
    }
    AppMethodBeat.o(201177);
    return null;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(165221);
    this.callback = paramg;
    int i = dispatch(parame, (com.tencent.mm.network.q)this.rr, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(165221);
    return i;
  }
  
  public final int getType()
  {
    return 713;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(165222);
    ac.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      com.tencent.mm.plugin.report.e.wTc.idkeyStat(1279L, 7L, 1L, false);
    }
    for (;;)
    {
      paramq = this.rr.aBC();
      if (paramq != null) {
        break;
      }
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFollowListRequest");
      AppMethodBeat.o(165222);
      throw paramString;
      com.tencent.mm.plugin.report.e.wTc.idkeyStat(1279L, 8L, 1L, false);
    }
    if (((akr)paramq).lastBuffer == null)
    {
      paramq = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(paramq, "MMKernel.storage()");
      paramq = paramq.agA();
      paramArrayOfByte = ah.a.GVm;
      localObject = this.rr.aBD();
      if (localObject == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFollowListResponse");
        AppMethodBeat.o(165222);
        throw paramString;
      }
      paramq.set(paramArrayOfByte, Integer.valueOf(((aks)localObject).EEH));
      paramq = y.KTp;
    }
    paramq = csu();
    paramArrayOfByte = this.TAG;
    Object localObject = new StringBuilder("firstPage ");
    if (csq() == null) {}
    for (boolean bool = true;; bool = false)
    {
      ac.i(paramArrayOfByte, bool + ", get " + paramq.size() + " follow contact ");
      paramq = ((Iterable)paramq).iterator();
      while (paramq.hasNext())
      {
        paramArrayOfByte = (FinderContact)paramq.next();
        localObject = com.tencent.mm.plugin.finder.api.b.qWt;
        com.tencent.mm.plugin.finder.api.b.a.a(paramArrayOfByte);
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
    AppMethodBeat.o(165222);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ad
 * JD-Core Version:    0.7.0.1
 */