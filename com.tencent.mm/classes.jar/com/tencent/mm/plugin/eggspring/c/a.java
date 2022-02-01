package com.tencent.mm.plugin.eggspring.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cub;
import com.tencent.mm.protocal.protobuf.cuc;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/eggspring/net/NetSceneAcceptCoupon;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "discountCouponParams", "Lcom/tencent/mm/protobuf/ByteString;", "(Lcom/tencent/mm/protobuf/ByteString;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "retCode", "", "getRetCode", "()Ljava/lang/Long;", "setRetCode", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "retMsg", "getRetMsg", "()Lcom/tencent/mm/protobuf/ByteString;", "setRetMsg", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-eggspring_release"})
public final class a
  extends n
  implements com.tencent.mm.network.k
{
  public static final a oVC;
  private g callback;
  public Long oVA;
  public com.tencent.mm.bw.b oVB;
  private com.tencent.mm.ak.b rr;
  
  static
  {
    AppMethodBeat.i(108156);
    oVC = new a((byte)0);
    AppMethodBeat.o(108156);
  }
  
  public a(com.tencent.mm.bw.b paramb)
  {
    AppMethodBeat.i(108155);
    Object localObject = new b.a();
    ((b.a)localObject).c((com.tencent.mm.bw.a)new cub());
    ((b.a)localObject).d((com.tencent.mm.bw.a)new cuc());
    ((b.a)localObject).Am("/cgi-bin/mmpay-bin/mktsendaward");
    ((b.a)localObject).op(2812);
    ((b.a)localObject).or(0);
    ((b.a)localObject).os(0);
    localObject = ((b.a)localObject).aAz();
    d.g.b.k.g(localObject, "builder.buildInstance()");
    this.rr = ((com.tencent.mm.ak.b)localObject);
    localObject = this.rr.aBC();
    if (localObject == null)
    {
      paramb = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.SendAwardRequest");
      AppMethodBeat.o(108155);
      throw paramb;
    }
    ((cub)localObject).FFL = paramb;
    AppMethodBeat.o(108155);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(108153);
    d.g.b.k.h(parame, "dispatcher");
    d.g.b.k.h(paramg, "callback");
    this.callback = paramg;
    int i = dispatch(parame, (q)this.rr, (com.tencent.mm.network.k)this);
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
    ac.i("MicroMsg.NetSceneAcceptCoupon", "onGYNetEnd errType: %s, errCode: %s, errMsg: %s.", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramArrayOfByte = this.rr.aBD();
    paramq = paramArrayOfByte;
    if (!(paramArrayOfByte instanceof cuc)) {
      paramq = null;
    }
    cuc localcuc = (cuc)paramq;
    if (localcuc != null)
    {
      paramq = Long.valueOf(localcuc.FFM);
      if (localcuc == null) {
        break label196;
      }
      paramArrayOfByte = localcuc.FFN;
      label93:
      ac.d("MicroMsg.NetSceneAcceptCoupon", "ret[%s] msg[%s].", new Object[] { paramq, paramArrayOfByte });
      if (localcuc == null) {
        break label202;
      }
      paramq = Long.valueOf(localcuc.FFM);
      label129:
      this.oVA = paramq;
      if (localcuc == null) {
        break label208;
      }
    }
    label196:
    label202:
    label208:
    for (paramq = localcuc.FFN;; paramq = null)
    {
      this.oVB = paramq;
      paramq = this.callback;
      if (paramq == null) {
        d.g.b.k.aVY("callback");
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
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/eggspring/net/NetSceneAcceptCoupon$Companion;", "", "()V", "TAG", "", "plugin-eggspring_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.eggspring.c.a
 * JD-Core Version:    0.7.0.1
 */