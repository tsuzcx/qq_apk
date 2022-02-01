package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.protobuf.aor;
import com.tencent.mm.protocal.protobuf.aos;
import com.tencent.mm.protocal.protobuf.aqh;
import com.tencent.mm.protocal.protobuf.aqi;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import java.util.LinkedList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderSessionStatus;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "reqItems", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderMsgGetSessionReqItem;", "(Ljava/util/LinkedList;)V", "TAG", "", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResp", "Lcom/tencent/mm/protocal/protobuf/FinderMsgSessionInfo;", "sessionId", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class bb
  extends n
  implements k
{
  private final String TAG;
  private f callback;
  private b rr;
  
  public bb(LinkedList<aqh> paramLinkedList)
  {
    AppMethodBeat.i(201587);
    this.TAG = "Finder.NetSceneFinderSessionStatus";
    b.a locala = new b.a();
    locala.oS(getType());
    aor localaor = new aor();
    v localv = v.rRb;
    localaor.GEg = v.czz();
    localaor.oGw = paramLinkedList;
    locala.c((a)localaor);
    locala.d((a)new aos());
    locala.DN("/cgi-bin/micromsg-bin/findergetmsgsession");
    paramLinkedList = locala.aDS();
    p.g(paramLinkedList, "builder.buildInstance()");
    this.rr = paramLinkedList;
    ae.i(this.TAG, "NetSceneFinderSessionStatus");
    AppMethodBeat.o(201587);
  }
  
  public final LinkedList<aqi> cAm()
  {
    AppMethodBeat.i(201586);
    Object localObject = this.rr.aEV();
    if (localObject == null)
    {
      localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetMsgSessionProfileResponse");
      AppMethodBeat.o(201586);
      throw ((Throwable)localObject);
    }
    localObject = ((aos)localObject).GGa;
    AppMethodBeat.o(201586);
    return localObject;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(201584);
    this.callback = paramf;
    int i = dispatch(parame, (q)this.rr, (k)this);
    AppMethodBeat.o(201584);
    return i;
  }
  
  public final int getType()
  {
    return 6218;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(201585);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      g.yxI.f(20492, new Object[] { Long.valueOf(7L), paramInt2 + ',' + paramInt3 });
      g.yxI.n(1473L, 7L, 1L);
    }
    if (this.callback != null)
    {
      paramq = this.callback;
      if (paramq == null) {
        p.gkB();
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
    }
    AppMethodBeat.o(201585);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.bb
 * JD-Core Version:    0.7.0.1
 */