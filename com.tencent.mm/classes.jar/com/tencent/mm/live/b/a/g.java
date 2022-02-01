package com.tencent.mm.live.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bvi;
import com.tencent.mm.protocal.protobuf.dco;
import com.tencent.mm.protocal.protobuf.dcp;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveAnchorStatus;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "status", "Lcom/tencent/mm/protocal/protobuf/LiveAnchorStatus;", "(JLcom/tencent/mm/protocal/protobuf/LiveAnchorStatus;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/SetAnchorStatusRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/SetAnchorStatusResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class g
  extends n
  implements k
{
  public static final a gSu;
  private f callback;
  private com.tencent.mm.ak.b gRX;
  private dco gSs;
  private dcp gSt;
  
  static
  {
    AppMethodBeat.i(215812);
    gSu = new a((byte)0);
    AppMethodBeat.o(215812);
  }
  
  public g(long paramLong, bvi parambvi)
  {
    AppMethodBeat.i(215811);
    Object localObject = new b.a();
    ((b.a)localObject).c((a)new dco());
    ((b.a)localObject).d((a)new dcp());
    ((b.a)localObject).oS(3852);
    ((b.a)localObject).DN("/cgi-bin/micromsg-bin/setanchorstatus");
    ((b.a)localObject).oU(0);
    ((b.a)localObject).oV(0);
    localObject = ((b.a)localObject).aDS();
    p.g(localObject, "builder.buildInstance()");
    this.gRX = ((com.tencent.mm.ak.b)localObject);
    localObject = this.gRX.aEU();
    if (localObject == null)
    {
      parambvi = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.SetAnchorStatusRequest");
      AppMethodBeat.o(215811);
      throw parambvi;
    }
    this.gSs = ((dco)localObject);
    this.gSs.FKy = paramLong;
    this.gSs.Hid = com.tencent.mm.bw.b.cm(parambvi.toByteArray());
    ae.i("MicroMsg.LiveNetScene.NetSceneLiveAnchorStatus", "liveId:" + paramLong + " status:[" + parambvi.Hib + ", " + parambvi.Hic + ']');
    AppMethodBeat.o(215811);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(215809);
    this.callback = paramf;
    int i = dispatch(parame, (q)this.gRX, (k)this);
    AppMethodBeat.o(215809);
    return i;
  }
  
  public final int getType()
  {
    return 3800;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(215810);
    ae.i("MicroMsg.LiveNetScene.NetSceneLiveAnchorStatus", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(215810);
      throw paramString;
    }
    paramq = ((com.tencent.mm.ak.b)paramq).aEV();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.SetAnchorStatusResponse");
      AppMethodBeat.o(215810);
      throw paramString;
    }
    this.gSt = ((dcp)paramq);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      ae.e("MicroMsg.LiveNetScene.NetSceneLiveAnchorStatus", "onGYNetEnd error");
    }
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(215810);
      return;
    }
    AppMethodBeat.o(215810);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveAnchorStatus$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.a.g
 * JD-Core Version:    0.7.0.1
 */