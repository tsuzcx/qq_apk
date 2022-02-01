package com.tencent.mm.live.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.eaq;
import com.tencent.mm.protocal.protobuf.ebr;
import com.tencent.mm.protocal.protobuf.ebs;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;
import d.v;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveAnchorStatus;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "status", "Lcom/tencent/mm/protocal/protobuf/LiveAnchorStatus;", "(JLcom/tencent/mm/protocal/protobuf/LiveAnchorStatus;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/SetAnchorStatusRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/SetAnchorStatusResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class f
  extends n
  implements com.tencent.mm.network.k
{
  public static final a zbA;
  private g callback;
  private com.tencent.mm.al.b iaa;
  private ebr zbl;
  private ebs zbm;
  
  static
  {
    AppMethodBeat.i(202711);
    zbA = new a((byte)0);
    AppMethodBeat.o(202711);
  }
  
  public f(long paramLong, eaq parameaq)
  {
    AppMethodBeat.i(202710);
    Object localObject = new b.a();
    ((b.a)localObject).c((a)new ebr());
    ((b.a)localObject).d((a)new ebs());
    ((b.a)localObject).nB(3852);
    ((b.a)localObject).wg("/cgi-bin/micromsg-bin/setanchorstatus");
    ((b.a)localObject).nD(0);
    ((b.a)localObject).nE(0);
    localObject = ((b.a)localObject).atI();
    d.g.b.k.g(localObject, "builder.buildInstance()");
    this.iaa = ((com.tencent.mm.al.b)localObject);
    localObject = this.iaa.auL();
    if (localObject == null)
    {
      parameaq = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.SetAnchorStatusRequest");
      AppMethodBeat.o(202710);
      throw parameaq;
    }
    this.zbl = ((ebr)localObject);
    this.zbl.LwA = paramLong;
    this.zbl.LyZ = com.tencent.mm.bx.b.cd(parameaq.toByteArray());
    ad.i("MicroMsg.LiveNetScene.NetSceneLiveAnchorStatus", "liveId:" + paramLong + " status:[" + parameaq.LyX + ", " + parameaq.LyY + ']');
    AppMethodBeat.o(202710);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(202708);
    this.callback = paramg;
    int i = dispatch(parame, (q)this.iaa, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(202708);
    return i;
  }
  
  public final int getType()
  {
    return 3800;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(202709);
    ad.i("MicroMsg.LiveNetScene.NetSceneLiveAnchorStatus", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(202709);
      throw paramString;
    }
    paramq = ((com.tencent.mm.al.b)paramq).auM();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.SetAnchorStatusResponse");
      AppMethodBeat.o(202709);
      throw paramString;
    }
    this.zbm = ((ebs)paramq);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      ad.e("MicroMsg.LiveNetScene.NetSceneLiveAnchorStatus", "onGYNetEnd error");
    }
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(202709);
      return;
    }
    AppMethodBeat.o(202709);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveAnchorStatus$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.b.a.f
 * JD-Core Version:    0.7.0.1
 */