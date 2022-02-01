package com.tencent.mm.plugin.aa.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.p;
import com.tencent.mm.protocal.protobuf.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.model.w;

public final class i
  extends w
{
  private h callback;
  private c nao;
  private p pHg;
  public q pHh;
  
  public i()
  {
    AppMethodBeat.i(63385);
    c.a locala = new c.a();
    locala.otE = new p();
    locala.otF = new q();
    locala.funcId = 1698;
    locala.uri = "/cgi-bin/mmpay-bin/newaaoperation";
    locala.otG = 0;
    locala.respCmdId = 0;
    this.nao = locala.bEF();
    this.pHg = ((p)c.b.b(this.nao.otB));
    AppMethodBeat.o(63385);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(63386);
    this.callback = paramh;
    int i = dispatch(paramg, this.nao, this);
    AppMethodBeat.o(63386);
    return i;
  }
  
  public final int getType()
  {
    return 1698;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(268411);
    Log.i("MicroMsg.NetSceneAAOperation", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.pHh = ((q)c.c.b(((c)params).otC));
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      Log.i("MicroMsg.NetSceneAAOperation", "retCode: %s, retMsg: %s, max_payer_num: %s, max_receiver_num: %s, max_total_num: %s, max_total_amount: %s, max_per_amount: %s, notice: %s, notice_url: %s", new Object[] { Integer.valueOf(this.pHh.hAV), this.pHh.wYI, Integer.valueOf(this.pHh.pHo), Integer.valueOf(this.pHh.pHp), Integer.valueOf(this.pHh.pHq), Long.valueOf(this.pHh.pHr), Long.valueOf(this.pHh.pHs), this.pHh.pHt, this.pHh.pHu });
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(268411);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.cgi.i
 * JD-Core Version:    0.7.0.1
 */