package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.protobuf.aoe;
import com.tencent.mm.protocal.protobuf.aof;
import com.tencent.mm.protocal.protobuf.apu;
import com.tencent.mm.protocal.protobuf.apv;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import java.util.LinkedList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderSessionStatus;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "reqItems", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderMsgGetSessionReqItem;", "(Ljava/util/LinkedList;)V", "TAG", "", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResp", "Lcom/tencent/mm/protocal/protobuf/FinderMsgSessionInfo;", "sessionId", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class ba
  extends n
  implements k
{
  private final String TAG;
  private f callback;
  private b rr;
  
  public ba(LinkedList<apu> paramLinkedList)
  {
    AppMethodBeat.i(201165);
    this.TAG = "Finder.NetSceneFinderSessionStatus";
    b.a locala = new b.a();
    locala.oP(getType());
    aoe localaoe = new aoe();
    v localv = v.rIR;
    localaoe.Gle = v.cxY();
    localaoe.ozU = paramLinkedList;
    locala.c((a)localaoe);
    locala.d((a)new aof());
    locala.Dl("/cgi-bin/micromsg-bin/findergetmsgsession");
    paramLinkedList = locala.aDC();
    p.g(paramLinkedList, "builder.buildInstance()");
    this.rr = paramLinkedList;
    ad.i(this.TAG, "NetSceneFinderSessionStatus");
    AppMethodBeat.o(201165);
  }
  
  public final LinkedList<apv> cyL()
  {
    AppMethodBeat.i(201164);
    Object localObject = this.rr.aEF();
    if (localObject == null)
    {
      localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetMsgSessionProfileResponse");
      AppMethodBeat.o(201164);
      throw ((Throwable)localObject);
    }
    localObject = ((aof)localObject).GmT;
    AppMethodBeat.o(201164);
    return localObject;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(201162);
    this.callback = paramf;
    int i = dispatch(parame, (q)this.rr, (k)this);
    AppMethodBeat.o(201162);
    return i;
  }
  
  public final int getType()
  {
    return 6218;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(201163);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      g.yhR.f(20492, new Object[] { Long.valueOf(7L), paramInt2 + ',' + paramInt3 });
      g.yhR.n(1473L, 7L, 1L);
    }
    if (this.callback != null)
    {
      paramq = this.callback;
      if (paramq == null) {
        p.gfZ();
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
    }
    AppMethodBeat.o(201163);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ba
 * JD-Core Version:    0.7.0.1
 */