package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.bx.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.xq;
import com.tencent.mm.protocal.protobuf.xr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.model.w;

public final class h
  extends w
{
  private com.tencent.mm.am.h callback;
  public long delay;
  public String hCI;
  private c nao;
  public int source;
  public xr wYA;
  public long wYB;
  private long wYC;
  
  public h(int paramInt1, b paramb, String paramString, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(63819);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new xq();
    ((c.a)localObject).otF = new xr();
    ((c.a)localObject).funcId = 1384;
    ((c.a)localObject).uri = "/cgi-bin/mmpay-bin/getf2frcvvoice";
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.nao = ((c.a)localObject).bEF();
    localObject = (xq)c.b.b(this.nao.otB);
    ((xq)localObject).amount = paramInt1;
    ((xq)localObject).Zae = 0;
    ((xq)localObject).wZg = paramString;
    ((xq)localObject).Zgv = null;
    ((xq)localObject).Zgw = paramb;
    this.hCI = paramString;
    this.source = paramInt2;
    this.delay = paramLong;
    this.wYC = System.currentTimeMillis();
    Log.i("MicroMsg.NetSceneF2FRcvVoice", "amount: %d, outtradeno: %s", new Object[] { Integer.valueOf(paramInt1), paramString });
    AppMethodBeat.o(63819);
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(63820);
    this.callback = paramh;
    int i = dispatch(paramg, this.nao, this);
    AppMethodBeat.o(63820);
    return i;
  }
  
  public final int getType()
  {
    return 1384;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(293542);
    Log.i("MicroMsg.NetSceneF2FRcvVoice", "errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.wYA = ((xr)c.c.b(((c)params).otC));
    Log.i("MicroMsg.NetSceneF2FRcvVoice", "ret_code: %d, ret_msg: %s，voice_type: %d", new Object[] { Integer.valueOf(this.wYA.hAV), this.wYA.wYI, Integer.valueOf(this.wYA.Zae) });
    this.wYB = (System.currentTimeMillis() - this.wYC);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(293542);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.h
 * JD-Core Version:    0.7.0.1
 */