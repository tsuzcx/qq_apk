package com.tencent.mm.plugin.eggspring.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.daf;
import com.tencent.mm.protocal.protobuf.dag;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/eggspring/net/NetSceneAcceptCoupon;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "discountCouponParams", "Lcom/tencent/mm/protobuf/ByteString;", "(Lcom/tencent/mm/protobuf/ByteString;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "retCode", "", "getRetCode", "()Ljava/lang/Long;", "setRetCode", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "retMsg", "getRetMsg", "()Lcom/tencent/mm/protobuf/ByteString;", "setRetMsg", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-eggspring_release"})
public final class a
  extends n
  implements k
{
  public static final a pFQ;
  private f callback;
  public Long pFO;
  public com.tencent.mm.bw.b pFP;
  private com.tencent.mm.ak.b rr;
  
  static
  {
    AppMethodBeat.i(108156);
    pFQ = new a((byte)0);
    AppMethodBeat.o(108156);
  }
  
  public a(com.tencent.mm.bw.b paramb)
  {
    AppMethodBeat.i(108155);
    Object localObject = new b.a();
    ((b.a)localObject).c((com.tencent.mm.bw.a)new daf());
    ((b.a)localObject).d((com.tencent.mm.bw.a)new dag());
    ((b.a)localObject).DN("/cgi-bin/mmpay-bin/mktsendaward");
    ((b.a)localObject).oS(2812);
    ((b.a)localObject).oU(0);
    ((b.a)localObject).oV(0);
    localObject = ((b.a)localObject).aDS();
    p.g(localObject, "builder.buildInstance()");
    this.rr = ((com.tencent.mm.ak.b)localObject);
    localObject = this.rr.aEU();
    if (localObject == null)
    {
      paramb = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.SendAwardRequest");
      AppMethodBeat.o(108155);
      throw paramb;
    }
    ((daf)localObject).HJM = paramb;
    AppMethodBeat.o(108155);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(108153);
    p.h(parame, "dispatcher");
    p.h(paramf, "callback");
    this.callback = paramf;
    int i = dispatch(parame, (q)this.rr, (k)this);
    AppMethodBeat.o(108153);
    return i;
  }
  
  public final int getType()
  {
    return 2812;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(108154);
    ae.i("MicroMsg.NetSceneAcceptCoupon", "onGYNetEnd errType: %s, errCode: %s, errMsg: %s.", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramArrayOfByte = this.rr.aEV();
    paramq = paramArrayOfByte;
    if (!(paramArrayOfByte instanceof dag)) {
      paramq = null;
    }
    dag localdag = (dag)paramq;
    if (localdag != null)
    {
      paramq = Long.valueOf(localdag.HJN);
      if (localdag == null) {
        break label196;
      }
      paramArrayOfByte = localdag.HJO;
      label93:
      ae.d("MicroMsg.NetSceneAcceptCoupon", "ret[%s] msg[%s].", new Object[] { paramq, paramArrayOfByte });
      if (localdag == null) {
        break label202;
      }
      paramq = Long.valueOf(localdag.HJN);
      label129:
      this.pFO = paramq;
      if (localdag == null) {
        break label208;
      }
    }
    label196:
    label202:
    label208:
    for (paramq = localdag.HJO;; paramq = null)
    {
      this.pFP = paramq;
      paramq = this.callback;
      if (paramq == null) {
        p.bdF("callback");
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(108154);
      return;
      paramq = null;
      break;
      paramArrayOfByte = null;
      break label93;
      paramq = null;
      break label129;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/eggspring/net/NetSceneAcceptCoupon$Companion;", "", "()V", "TAG", "", "plugin-eggspring_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.eggspring.c.a
 * JD-Core Version:    0.7.0.1
 */