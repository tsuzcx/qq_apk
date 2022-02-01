package com.tencent.mm.plugin.aa.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.m;
import com.tencent.mm.sdk.platformtools.ae;

public final class h
  extends com.tencent.mm.ak.n
  implements k
{
  private f callback;
  private b gRX;
  private m iWn;
  public com.tencent.mm.protocal.protobuf.n iWo;
  
  public h()
  {
    AppMethodBeat.i(63385);
    b.a locala = new b.a();
    locala.hQF = new m();
    locala.hQG = new com.tencent.mm.protocal.protobuf.n();
    locala.funcId = 1698;
    locala.uri = "/cgi-bin/mmpay-bin/newaaoperation";
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.gRX = locala.aDS();
    this.iWn = ((m)this.gRX.hQD.hQJ);
    AppMethodBeat.o(63385);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(63386);
    this.callback = paramf;
    int i = dispatch(parame, this.gRX, this);
    AppMethodBeat.o(63386);
    return i;
  }
  
  public final int getType()
  {
    return 1698;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(63387);
    ae.i("MicroMsg.NetSceneAAOperation", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.iWo = ((com.tencent.mm.protocal.protobuf.n)((b)paramq).hQE.hQJ);
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      ae.i("MicroMsg.NetSceneAAOperation", "retCode: %s, retMsg: %s, max_payer_num: %s, max_receiver_num: %s, max_total_num: %s, max_total_amount: %s, max_per_amount: %s, notice: %s, notice_url: %s", new Object[] { Integer.valueOf(this.iWo.dmy), this.iWo.phe, Integer.valueOf(this.iWo.iWv), Integer.valueOf(this.iWo.iWw), Integer.valueOf(this.iWo.iWx), Long.valueOf(this.iWo.iWy), Long.valueOf(this.iWo.iWz), this.iWo.iWA, this.iWo.iWB });
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(63387);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.cgi.h
 * JD-Core Version:    0.7.0.1
 */