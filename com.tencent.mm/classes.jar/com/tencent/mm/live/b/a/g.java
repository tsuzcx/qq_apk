package com.tencent.mm.live.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bqb;
import com.tencent.mm.protocal.protobuf.cwh;
import com.tencent.mm.protocal.protobuf.cwi;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveAnchorStatus;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "status", "Lcom/tencent/mm/protocal/protobuf/LiveAnchorStatus;", "(JLcom/tencent/mm/protocal/protobuf/LiveAnchorStatus;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/SetAnchorStatusRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/SetAnchorStatusResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class g
  extends n
  implements com.tencent.mm.network.k
{
  public static final a gwb;
  private com.tencent.mm.ak.g callback;
  private com.tencent.mm.ak.b gvE;
  private cwh gvZ;
  private cwi gwa;
  
  static
  {
    AppMethodBeat.i(189906);
    gwb = new a((byte)0);
    AppMethodBeat.o(189906);
  }
  
  public g(long paramLong, bqb parambqb)
  {
    AppMethodBeat.i(189905);
    Object localObject = new b.a();
    ((b.a)localObject).c((a)new cwh());
    ((b.a)localObject).d((a)new cwi());
    ((b.a)localObject).op(3852);
    ((b.a)localObject).Am("/cgi-bin/micromsg-bin/setanchorstatus");
    ((b.a)localObject).or(0);
    ((b.a)localObject).os(0);
    localObject = ((b.a)localObject).aAz();
    d.g.b.k.g(localObject, "builder.buildInstance()");
    this.gvE = ((com.tencent.mm.ak.b)localObject);
    localObject = this.gvE.aBC();
    if (localObject == null)
    {
      parambqb = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.SetAnchorStatusRequest");
      AppMethodBeat.o(189905);
      throw parambqb;
    }
    this.gvZ = ((cwh)localObject);
    this.gvZ.DMV = paramLong;
    this.gvZ.FeZ = com.tencent.mm.bw.b.cc(parambqb.toByteArray());
    ac.i("MicroMsg.LiveNetScene.NetSceneLiveAnchorStatus", "liveId:" + paramLong + " status:[" + parambqb.FeX + ", " + parambqb.FeY + ']');
    AppMethodBeat.o(189905);
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(189903);
    this.callback = paramg;
    int i = dispatch(parame, (q)this.gvE, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(189903);
    return i;
  }
  
  public final int getType()
  {
    return 3800;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(189904);
    ac.i("MicroMsg.LiveNetScene.NetSceneLiveAnchorStatus", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(189904);
      throw paramString;
    }
    paramq = ((com.tencent.mm.ak.b)paramq).aBD();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.SetAnchorStatusResponse");
      AppMethodBeat.o(189904);
      throw paramString;
    }
    this.gwa = ((cwi)paramq);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      ac.e("MicroMsg.LiveNetScene.NetSceneLiveAnchorStatus", "onGYNetEnd error");
    }
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(189904);
      return;
    }
    AppMethodBeat.o(189904);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveAnchorStatus$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.a.g
 * JD-Core Version:    0.7.0.1
 */