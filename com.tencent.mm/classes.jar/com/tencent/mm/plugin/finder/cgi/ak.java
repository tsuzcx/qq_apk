package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.api.c.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.ans;
import com.tencent.mm.protocal.protobuf.ant;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import d.g.b.p;
import d.l;
import d.z;
import java.util.Iterator;
import java.util.LinkedList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetFollowList;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "(Lcom/tencent/mm/protobuf/ByteString;)V", "TAG", "", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getFollowContactList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "getRequestBuffer", "getResponseBuffer", "getType", "hasContinue", "", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class ak
  extends n
  implements k
{
  private final String TAG;
  private f callback;
  private com.tencent.mm.al.b rr;
  
  public ak(com.tencent.mm.bx.b paramb)
  {
    AppMethodBeat.i(165225);
    this.TAG = "Finder.NetSceneFinderGetFollowList";
    b.a locala = new b.a();
    locala.oP(getType());
    ans localans = new ans();
    localans.lastBuffer = paramb;
    paramb = v.rIR;
    localans.Glv = v.cxY();
    locala.c((a)localans);
    locala.d((a)new ant());
    locala.Dl("/cgi-bin/micromsg-bin/findergetfollowlist");
    paramb = locala.aDC();
    p.g(paramb, "builder.buildInstance()");
    this.rr = paramb;
    ad.i(this.TAG, "NetSceneFinderGetFollowList init ");
    AppMethodBeat.o(165225);
  }
  
  public final com.tencent.mm.bx.b cyh()
  {
    AppMethodBeat.i(165224);
    a locala = this.rr.aEF();
    Object localObject = locala;
    if (!(locala instanceof ant)) {
      localObject = null;
    }
    localObject = (ant)localObject;
    if (localObject != null)
    {
      localObject = ((ant)localObject).lastBuffer;
      AppMethodBeat.o(165224);
      return localObject;
    }
    AppMethodBeat.o(165224);
    return null;
  }
  
  public final boolean cyj()
  {
    AppMethodBeat.i(201124);
    Object localObject = this.rr.aEF();
    if (localObject == null)
    {
      localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFollowListResponse");
      AppMethodBeat.o(201124);
      throw ((Throwable)localObject);
    }
    if (((ant)localObject).continueFlag != 0)
    {
      AppMethodBeat.o(201124);
      return true;
    }
    AppMethodBeat.o(201124);
    return false;
  }
  
  public final LinkedList<FinderContact> cyl()
  {
    AppMethodBeat.i(165223);
    Object localObject = this.rr.aEF();
    if (localObject == null)
    {
      localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFollowListResponse");
      AppMethodBeat.o(165223);
      throw ((Throwable)localObject);
    }
    localObject = ((ant)localObject).Gmj;
    p.g(localObject, "(rr.responseProtoBuf as …ListResponse).contactList");
    AppMethodBeat.o(165223);
    return localObject;
  }
  
  public final com.tencent.mm.bx.b cym()
  {
    AppMethodBeat.i(201125);
    a locala = this.rr.aEE();
    Object localObject = locala;
    if (!(locala instanceof ans)) {
      localObject = null;
    }
    localObject = (ans)localObject;
    if (localObject != null)
    {
      localObject = ((ans)localObject).lastBuffer;
      AppMethodBeat.o(201125);
      return localObject;
    }
    AppMethodBeat.o(201125);
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
    ad.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(1279L, 7L, 1L, false);
    }
    for (;;)
    {
      paramq = this.rr.aEE();
      if (paramq != null) {
        break;
      }
      paramString = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFollowListRequest");
      AppMethodBeat.o(165222);
      throw paramString;
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(1279L, 8L, 1L, false);
    }
    if (((ans)paramq).lastBuffer == null)
    {
      paramq = g.ajC();
      p.g(paramq, "MMKernel.storage()");
      paramq = paramq.ajl();
      paramArrayOfByte = al.a.IHU;
      localObject = this.rr.aEF();
      if (localObject == null)
      {
        paramString = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFollowListResponse");
        AppMethodBeat.o(165222);
        throw paramString;
      }
      paramq.set(paramArrayOfByte, Integer.valueOf(((ant)localObject).GmF));
      paramq = z.MKo;
    }
    paramq = cyl();
    paramArrayOfByte = this.TAG;
    Object localObject = new StringBuilder("firstPage ");
    if (cyh() == null) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i(paramArrayOfByte, bool + ", get " + paramq.size() + " follow contact ");
      paramq = ((Iterable)paramq).iterator();
      while (paramq.hasNext())
      {
        paramArrayOfByte = (FinderContact)paramq.next();
        localObject = c.rHn;
        c.a.a(paramArrayOfByte);
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
    AppMethodBeat.o(165222);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ak
 * JD-Core Version:    0.7.0.1
 */