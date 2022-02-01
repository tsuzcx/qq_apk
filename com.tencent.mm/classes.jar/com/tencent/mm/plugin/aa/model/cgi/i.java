package com.tencent.mm.plugin.aa.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.p;
import com.tencent.mm.sdk.platformtools.Log;

public final class i
  extends com.tencent.mm.an.q
  implements m
{
  private com.tencent.mm.an.i callback;
  private d kwO;
  private p mKy;
  public com.tencent.mm.protocal.protobuf.q mKz;
  
  public i()
  {
    AppMethodBeat.i(63385);
    d.a locala = new d.a();
    locala.lBU = new p();
    locala.lBV = new com.tencent.mm.protocal.protobuf.q();
    locala.funcId = 1698;
    locala.uri = "/cgi-bin/mmpay-bin/newaaoperation";
    locala.lBW = 0;
    locala.respCmdId = 0;
    this.kwO = locala.bgN();
    this.mKy = ((p)d.b.b(this.kwO.lBR));
    AppMethodBeat.o(63385);
  }
  
  public final int doScene(g paramg, com.tencent.mm.an.i parami)
  {
    AppMethodBeat.i(63386);
    this.callback = parami;
    int i = dispatch(paramg, this.kwO, this);
    AppMethodBeat.o(63386);
    return i;
  }
  
  public final int getType()
  {
    return 1698;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(63387);
    Log.i("MicroMsg.NetSceneAAOperation", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.mKz = ((com.tencent.mm.protocal.protobuf.q)d.c.b(((d)params).lBS));
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      Log.i("MicroMsg.NetSceneAAOperation", "retCode: %s, retMsg: %s, max_payer_num: %s, max_receiver_num: %s, max_total_num: %s, max_total_amount: %s, max_per_amount: %s, notice: %s, notice_url: %s", new Object[] { Integer.valueOf(this.mKz.fwx), this.mKz.tVo, Integer.valueOf(this.mKz.mKG), Integer.valueOf(this.mKz.mKH), Integer.valueOf(this.mKz.mKI), Long.valueOf(this.mKz.mKJ), Long.valueOf(this.mKz.mKK), this.mKz.mKL, this.mKz.mKM });
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(63387);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.cgi.i
 * JD-Core Version:    0.7.0.1
 */