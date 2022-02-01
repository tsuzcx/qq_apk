package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bjz;
import com.tencent.mm.protocal.protobuf.bka;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.wallet_core.c.r;

public final class f
  extends r
{
  private final String TAG;
  public bka tCC;
  
  public f()
  {
    AppMethodBeat.i(64622);
    this.TAG = "MicroMsg.NetSceneHoneyPayerList";
    b.a locala = new b.a();
    locala.hvt = new bjz();
    locala.hvu = new bka();
    locala.funcId = getType();
    locala.uri = "/cgi-bin/mmpay-bin/honeypayerlist";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    AppMethodBeat.o(64622);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(64623);
    ac.i("MicroMsg.NetSceneHoneyPayerList", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.tCC = ((bka)((b)paramq).hvs.hvw);
    ac.i("MicroMsg.NetSceneHoneyPayerList", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.tCC.nWx), this.tCC.nWy });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(64623);
  }
  
  public final void e(q paramq)
  {
    paramq = (bka)((b)paramq).hvs.hvw;
    this.JFq = paramq.nWx;
    this.JFr = paramq.nWy;
  }
  
  public final int getType()
  {
    return 2725;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.a.f
 * JD-Core Version:    0.7.0.1
 */