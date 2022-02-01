package com.tencent.mm.plugin.aa.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.o;
import com.tencent.mm.protocal.protobuf.p;
import com.tencent.mm.sdk.platformtools.Log;

public final class i
  extends q
  implements m
{
  private com.tencent.mm.ak.i callback;
  private d hJu;
  private o jTk;
  public p jTl;
  
  public i()
  {
    AppMethodBeat.i(63385);
    d.a locala = new d.a();
    locala.iLN = new o();
    locala.iLO = new p();
    locala.funcId = 1698;
    locala.uri = "/cgi-bin/mmpay-bin/newaaoperation";
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.hJu = locala.aXF();
    this.jTk = ((o)this.hJu.iLK.iLR);
    AppMethodBeat.o(63385);
  }
  
  public final int doScene(g paramg, com.tencent.mm.ak.i parami)
  {
    AppMethodBeat.i(63386);
    this.callback = parami;
    int i = dispatch(paramg, this.hJu, this);
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
    this.jTl = ((p)((d)params).iLL.iLR);
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      Log.i("MicroMsg.NetSceneAAOperation", "retCode: %s, retMsg: %s, max_payer_num: %s, max_receiver_num: %s, max_total_num: %s, max_total_amount: %s, max_per_amount: %s, notice: %s, notice_url: %s", new Object[] { Integer.valueOf(this.jTl.dDN), this.jTl.qwn, Integer.valueOf(this.jTl.jTs), Integer.valueOf(this.jTl.jTt), Integer.valueOf(this.jTl.jTu), Long.valueOf(this.jTl.jTv), Long.valueOf(this.jTl.jTw), this.jTl.jTx, this.jTl.jTy });
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(63387);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.cgi.i
 * JD-Core Version:    0.7.0.1
 */