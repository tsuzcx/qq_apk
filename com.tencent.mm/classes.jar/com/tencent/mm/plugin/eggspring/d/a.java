package com.tencent.mm.plugin.eggspring.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.ewz;
import com.tencent.mm.protocal.protobuf.exa;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/eggspring/net/NetSceneAcceptCoupon;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "discountCouponParams", "Lcom/tencent/mm/protobuf/ByteString;", "(Lcom/tencent/mm/protobuf/ByteString;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "retCode", "", "getRetCode", "()Ljava/lang/Long;", "setRetCode", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "retMsg", "getRetMsg", "()Lcom/tencent/mm/protobuf/ByteString;", "setRetMsg", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-eggspring_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends p
  implements m
{
  public static final a xEE;
  private h callback;
  private c rr;
  public Long xEF;
  public b xEG;
  
  static
  {
    AppMethodBeat.i(108156);
    xEE = new a((byte)0);
    AppMethodBeat.o(108156);
  }
  
  public a(b paramb)
  {
    AppMethodBeat.i(108155);
    Object localObject = new c.a();
    ((c.a)localObject).otE = ((com.tencent.mm.bx.a)new ewz());
    ((c.a)localObject).otF = ((com.tencent.mm.bx.a)new exa());
    ((c.a)localObject).uri = "/cgi-bin/mmpay-bin/mktsendaward";
    ((c.a)localObject).funcId = 2812;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    localObject = ((c.a)localObject).bEF();
    kotlin.g.b.s.s(localObject, "builder.buildInstance()");
    this.rr = ((c)localObject);
    localObject = c.b.b(this.rr.otB);
    if (localObject == null)
    {
      paramb = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.SendAwardRequest");
      AppMethodBeat.o(108155);
      throw paramb;
    }
    ((ewz)localObject).abzd = paramb;
    AppMethodBeat.o(108155);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(108153);
    kotlin.g.b.s.u(paramg, "dispatcher");
    kotlin.g.b.s.u(paramh, "callback");
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.rr, (m)this);
    AppMethodBeat.o(108153);
    return i;
  }
  
  public final int getType()
  {
    return 2812;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(108154);
    Log.i("MicroMsg.NetSceneAcceptCoupon", "onGYNetEnd errType: %s, errCode: %s, errMsg: %s.", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    params = c.c.b(this.rr.otC);
    label70:
    b localb;
    if ((params instanceof exa))
    {
      params = (exa)params;
      if (params != null) {
        break label177;
      }
      paramArrayOfByte = null;
      if (params != null) {
        break label190;
      }
      localb = null;
      label78:
      Log.d("MicroMsg.NetSceneAcceptCoupon", "ret[%s] msg[%s].", new Object[] { paramArrayOfByte, localb });
      if (params != null) {
        break label200;
      }
      paramArrayOfByte = null;
      label107:
      this.xEF = paramArrayOfByte;
      if (params != null) {
        break label213;
      }
    }
    label177:
    label190:
    label200:
    label213:
    for (params = null;; params = params.abze)
    {
      this.xEG = params;
      paramArrayOfByte = this.callback;
      params = paramArrayOfByte;
      if (paramArrayOfByte == null)
      {
        kotlin.g.b.s.bIx("callback");
        params = null;
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
      AppMethodBeat.o(108154);
      return;
      params = null;
      break;
      paramArrayOfByte = Long.valueOf(params.aaqE);
      break label70;
      localb = params.abze;
      break label78;
      paramArrayOfByte = Long.valueOf(params.aaqE);
      break label107;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/eggspring/net/NetSceneAcceptCoupon$Companion;", "", "()V", "TAG", "", "plugin-eggspring_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.eggspring.d.a
 * JD-Core Version:    0.7.0.1
 */