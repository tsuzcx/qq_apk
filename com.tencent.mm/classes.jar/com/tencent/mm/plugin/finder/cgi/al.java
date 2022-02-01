package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.api.c.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.aof;
import com.tencent.mm.protocal.protobuf.aog;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import d.g.b.p;
import d.l;
import d.z;
import java.util.Iterator;
import java.util.LinkedList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetFollowList;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "(Lcom/tencent/mm/protobuf/ByteString;)V", "TAG", "", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getFollowContactList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "getRequestBuffer", "getResponseBuffer", "getType", "hasContinue", "", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class al
  extends n
  implements k
{
  private final String TAG;
  private f callback;
  private com.tencent.mm.ak.b rr;
  
  public al(com.tencent.mm.bw.b paramb)
  {
    AppMethodBeat.i(165225);
    this.TAG = "Finder.NetSceneFinderGetFollowList";
    b.a locala = new b.a();
    locala.oS(getType());
    aof localaof = new aof();
    localaof.lastBuffer = paramb;
    paramb = v.rRb;
    localaof.GDR = v.czz();
    locala.c((a)localaof);
    locala.d((a)new aog());
    locala.DN("/cgi-bin/micromsg-bin/findergetfollowlist");
    paramb = locala.aDS();
    p.g(paramb, "builder.buildInstance()");
    this.rr = paramb;
    ae.i(this.TAG, "NetSceneFinderGetFollowList init ");
    AppMethodBeat.o(165225);
  }
  
  public final com.tencent.mm.bw.b czI()
  {
    AppMethodBeat.i(165224);
    a locala = this.rr.aEV();
    Object localObject = locala;
    if (!(locala instanceof aog)) {
      localObject = null;
    }
    localObject = (aog)localObject;
    if (localObject != null)
    {
      localObject = ((aog)localObject).lastBuffer;
      AppMethodBeat.o(165224);
      return localObject;
    }
    AppMethodBeat.o(165224);
    return null;
  }
  
  public final boolean czK()
  {
    AppMethodBeat.i(201546);
    Object localObject = this.rr.aEV();
    if (localObject == null)
    {
      localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFollowListResponse");
      AppMethodBeat.o(201546);
      throw ((Throwable)localObject);
    }
    if (((aog)localObject).continueFlag != 0)
    {
      AppMethodBeat.o(201546);
      return true;
    }
    AppMethodBeat.o(201546);
    return false;
  }
  
  public final LinkedList<FinderContact> czM()
  {
    AppMethodBeat.i(165223);
    Object localObject = this.rr.aEV();
    if (localObject == null)
    {
      localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFollowListResponse");
      AppMethodBeat.o(165223);
      throw ((Throwable)localObject);
    }
    localObject = ((aog)localObject).GFl;
    p.g(localObject, "(rr.responseProtoBuf as …ListResponse).contactList");
    AppMethodBeat.o(165223);
    return localObject;
  }
  
  public final com.tencent.mm.bw.b czN()
  {
    AppMethodBeat.i(201547);
    a locala = this.rr.aEU();
    Object localObject = locala;
    if (!(locala instanceof aof)) {
      localObject = null;
    }
    localObject = (aof)localObject;
    if (localObject != null)
    {
      localObject = ((aof)localObject).lastBuffer;
      AppMethodBeat.o(201547);
      return localObject;
    }
    AppMethodBeat.o(201547);
    return null;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(165221);
    this.callback = paramf;
    int i = dispatch(parame, (q)this.rr, (k)this);
    AppMethodBeat.o(165221);
    return i;
  }
  
  public final int getType()
  {
    return 713;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(165222);
    ae.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(1279L, 7L, 1L, false);
    }
    for (;;)
    {
      paramq = this.rr.aEU();
      if (paramq != null) {
        break;
      }
      paramString = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFollowListRequest");
      AppMethodBeat.o(165222);
      throw paramString;
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(1279L, 8L, 1L, false);
    }
    if (((aof)paramq).lastBuffer == null)
    {
      paramq = g.ajR();
      p.g(paramq, "MMKernel.storage()");
      paramq = paramq.ajA();
      paramArrayOfByte = am.a.Jcx;
      localObject = this.rr.aEV();
      if (localObject == null)
      {
        paramString = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFollowListResponse");
        AppMethodBeat.o(165222);
        throw paramString;
      }
      paramq.set(paramArrayOfByte, Integer.valueOf(((aog)localObject).GFM));
      paramq = z.Nhr;
    }
    paramq = czM();
    paramArrayOfByte = this.TAG;
    Object localObject = new StringBuilder("firstPage ");
    if (czI() == null) {}
    for (boolean bool = true;; bool = false)
    {
      ae.i(paramArrayOfByte, bool + ", get " + paramq.size() + " follow contact ");
      paramq = ((Iterable)paramq).iterator();
      while (paramq.hasNext())
      {
        paramArrayOfByte = (FinderContact)paramq.next();
        localObject = c.rPy;
        c.a.a(paramArrayOfByte);
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
    AppMethodBeat.o(165222);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.al
 * JD-Core Version:    0.7.0.1
 */