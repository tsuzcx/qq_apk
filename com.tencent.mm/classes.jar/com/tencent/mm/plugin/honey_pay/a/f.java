package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bpb;
import com.tencent.mm.protocal.protobuf.bpc;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.wallet_core.c.r;

public final class f
  extends r
{
  private final String TAG;
  public bpc uQY;
  
  public f()
  {
    AppMethodBeat.i(64622);
    this.TAG = "MicroMsg.NetSceneHoneyPayerList";
    b.a locala = new b.a();
    locala.hQF = new bpb();
    locala.hQG = new bpc();
    locala.funcId = getType();
    locala.uri = "/cgi-bin/mmpay-bin/honeypayerlist";
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDS();
    AppMethodBeat.o(64622);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(64623);
    ae.i("MicroMsg.NetSceneHoneyPayerList", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.uQY = ((bpc)((b)paramq).hQE.hQJ);
    ae.i("MicroMsg.NetSceneHoneyPayerList", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.uQY.oGt), this.uQY.oGu });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(64623);
  }
  
  public final void e(q paramq)
  {
    paramq = (bpc)((b)paramq).hQE.hQJ;
    this.LVj = paramq.oGt;
    this.LVk = paramq.oGu;
  }
  
  public final int getType()
  {
    return 2725;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.a.f
 * JD-Core Version:    0.7.0.1
 */