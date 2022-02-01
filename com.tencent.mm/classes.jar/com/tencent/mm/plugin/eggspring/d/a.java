package com.tencent.mm.plugin.eggspring.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dtj;
import com.tencent.mm.protocal.protobuf.dtk;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/eggspring/net/NetSceneAcceptCoupon;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "discountCouponParams", "Lcom/tencent/mm/protobuf/ByteString;", "(Lcom/tencent/mm/protobuf/ByteString;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "retCode", "", "getRetCode", "()Ljava/lang/Long;", "setRetCode", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "retMsg", "getRetMsg", "()Lcom/tencent/mm/protobuf/ByteString;", "setRetMsg", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-eggspring_release"})
public final class a
  extends q
  implements m
{
  public static final a qVi;
  private i callback;
  public Long qVg;
  public b qVh;
  private d rr;
  
  static
  {
    AppMethodBeat.i(108156);
    qVi = new a((byte)0);
    AppMethodBeat.o(108156);
  }
  
  public a(b paramb)
  {
    AppMethodBeat.i(108155);
    Object localObject = new d.a();
    ((d.a)localObject).c((com.tencent.mm.bw.a)new dtj());
    ((d.a)localObject).d((com.tencent.mm.bw.a)new dtk());
    ((d.a)localObject).MB("/cgi-bin/mmpay-bin/mktsendaward");
    ((d.a)localObject).sG(2812);
    ((d.a)localObject).sI(0);
    ((d.a)localObject).sJ(0);
    localObject = ((d.a)localObject).aXF();
    p.g(localObject, "builder.buildInstance()");
    this.rr = ((d)localObject);
    localObject = this.rr.aYJ();
    if (localObject == null)
    {
      paramb = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.SendAwardRequest");
      AppMethodBeat.o(108155);
      throw paramb;
    }
    ((dtj)localObject).MVz = paramb;
    AppMethodBeat.o(108155);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(108153);
    p.h(paramg, "dispatcher");
    p.h(parami, "callback");
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(108153);
    return i;
  }
  
  public final int getType()
  {
    return 2812;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(108154);
    Log.i("MicroMsg.NetSceneAcceptCoupon", "onGYNetEnd errType: %s, errCode: %s, errMsg: %s.", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramArrayOfByte = this.rr.aYK();
    params = paramArrayOfByte;
    if (!(paramArrayOfByte instanceof dtk)) {
      params = null;
    }
    dtk localdtk = (dtk)params;
    if (localdtk != null)
    {
      params = Long.valueOf(localdtk.LUH);
      if (localdtk == null) {
        break label196;
      }
      paramArrayOfByte = localdtk.MVA;
      label93:
      Log.d("MicroMsg.NetSceneAcceptCoupon", "ret[%s] msg[%s].", new Object[] { params, paramArrayOfByte });
      if (localdtk == null) {
        break label202;
      }
      params = Long.valueOf(localdtk.LUH);
      label129:
      this.qVg = params;
      if (localdtk == null) {
        break label208;
      }
    }
    label196:
    label202:
    label208:
    for (params = localdtk.MVA;; params = null)
    {
      this.qVh = params;
      params = this.callback;
      if (params == null) {
        p.btv("callback");
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(108154);
      return;
      params = null;
      break;
      paramArrayOfByte = null;
      break label93;
      params = null;
      break label129;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/eggspring/net/NetSceneAcceptCoupon$Companion;", "", "()V", "TAG", "", "plugin-eggspring_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.eggspring.d.a
 * JD-Core Version:    0.7.0.1
 */