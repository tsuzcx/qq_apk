package com.tencent.mm.live.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.buo;
import com.tencent.mm.protocal.protobuf.dbu;
import com.tencent.mm.protocal.protobuf.dbv;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveAnchorStatus;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "status", "Lcom/tencent/mm/protocal/protobuf/LiveAnchorStatus;", "(JLcom/tencent/mm/protocal/protobuf/LiveAnchorStatus;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/SetAnchorStatusRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/SetAnchorStatusResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class g
  extends n
  implements k
{
  public static final a gPM;
  private f callback;
  private dbu gPK;
  private dbv gPL;
  private com.tencent.mm.al.b gPp;
  
  static
  {
    AppMethodBeat.i(212192);
    gPM = new a((byte)0);
    AppMethodBeat.o(212192);
  }
  
  public g(long paramLong, buo parambuo)
  {
    AppMethodBeat.i(212191);
    Object localObject = new b.a();
    ((b.a)localObject).c((a)new dbu());
    ((b.a)localObject).d((a)new dbv());
    ((b.a)localObject).oP(3852);
    ((b.a)localObject).Dl("/cgi-bin/micromsg-bin/setanchorstatus");
    ((b.a)localObject).oR(0);
    ((b.a)localObject).oS(0);
    localObject = ((b.a)localObject).aDC();
    p.g(localObject, "builder.buildInstance()");
    this.gPp = ((com.tencent.mm.al.b)localObject);
    localObject = this.gPp.aEE();
    if (localObject == null)
    {
      parambuo = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.SetAnchorStatusRequest");
      AppMethodBeat.o(212191);
      throw parambuo;
    }
    this.gPK = ((dbu)localObject);
    this.gPK.Fsa = paramLong;
    this.gPK.GOD = com.tencent.mm.bx.b.cj(parambuo.toByteArray());
    ad.i("MicroMsg.LiveNetScene.NetSceneLiveAnchorStatus", "liveId:" + paramLong + " status:[" + parambuo.GOB + ", " + parambuo.GOC + ']');
    AppMethodBeat.o(212191);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(212189);
    this.callback = paramf;
    int i = dispatch(parame, (q)this.gPp, (k)this);
    AppMethodBeat.o(212189);
    return i;
  }
  
  public final int getType()
  {
    return 3800;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(212190);
    ad.i("MicroMsg.LiveNetScene.NetSceneLiveAnchorStatus", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(212190);
      throw paramString;
    }
    paramq = ((com.tencent.mm.al.b)paramq).aEF();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.SetAnchorStatusResponse");
      AppMethodBeat.o(212190);
      throw paramString;
    }
    this.gPL = ((dbv)paramq);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      ad.e("MicroMsg.LiveNetScene.NetSceneLiveAnchorStatus", "onGYNetEnd error");
    }
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(212190);
      return;
    }
    AppMethodBeat.o(212190);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveAnchorStatus$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.a.g
 * JD-Core Version:    0.7.0.1
 */