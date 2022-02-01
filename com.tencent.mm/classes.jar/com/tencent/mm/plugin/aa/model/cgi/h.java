package com.tencent.mm.plugin.aa.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.m;
import com.tencent.mm.sdk.platformtools.ac;

public final class h
  extends com.tencent.mm.ak.n
  implements k
{
  private g callback;
  private b gvE;
  private m iAk;
  public com.tencent.mm.protocal.protobuf.n iAl;
  
  public h()
  {
    AppMethodBeat.i(63385);
    b.a locala = new b.a();
    locala.hvt = new m();
    locala.hvu = new com.tencent.mm.protocal.protobuf.n();
    locala.funcId = 1698;
    locala.uri = "/cgi-bin/mmpay-bin/newaaoperation";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.gvE = locala.aAz();
    this.iAk = ((m)this.gvE.hvr.hvw);
    AppMethodBeat.o(63385);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(63386);
    this.callback = paramg;
    int i = dispatch(parame, this.gvE, this);
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
    ac.i("MicroMsg.NetSceneAAOperation", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.iAl = ((com.tencent.mm.protocal.protobuf.n)((b)paramq).hvs.hvw);
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      ac.i("MicroMsg.NetSceneAAOperation", "retCode: %s, retMsg: %s, max_payer_num: %s, max_receiver_num: %s, max_total_num: %s, max_total_amount: %s, max_per_amount: %s, notice: %s, notice_url: %s", new Object[] { Integer.valueOf(this.iAl.dae), this.iAl.oxf, Integer.valueOf(this.iAl.iAs), Integer.valueOf(this.iAl.iAt), Integer.valueOf(this.iAl.iAu), Long.valueOf(this.iAl.iAv), Long.valueOf(this.iAl.iAw), this.iAl.iAx, this.iAl.iAy });
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(63387);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.cgi.h
 * JD-Core Version:    0.7.0.1
 */