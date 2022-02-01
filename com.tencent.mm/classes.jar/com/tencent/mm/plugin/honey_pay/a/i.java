package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cbr;
import com.tencent.mm.protocal.protobuf.cbs;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.wallet_core.c.r;

public final class i
  extends r
{
  private final String TAG;
  public int dEu;
  private cbs uRc;
  
  public i(int paramInt)
  {
    AppMethodBeat.i(64628);
    this.TAG = "MicroMsg.NetSceneModifyHoneyPayerNotify";
    b.a locala = new b.a();
    locala.hQF = new cbr();
    locala.hQG = new cbs();
    locala.funcId = getType();
    locala.uri = "/cgi-bin/mmpay-bin/modifyhppayernotify";
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDS();
    ((cbr)this.rr.hQD.hQJ).CZN = paramInt;
    this.dEu = paramInt;
    ae.i("MicroMsg.NetSceneModifyHoneyPayerNotify", "notify flag: %s", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(64628);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(64629);
    ae.i("MicroMsg.NetSceneModifyHoneyPayerNotify", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.uRc = ((cbs)((b)paramq).hQE.hQJ);
    ae.i("MicroMsg.NetSceneModifyHoneyPayerNotify", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.uRc.oGt), this.uRc.oGu });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(64629);
  }
  
  public final void e(q paramq)
  {
    paramq = (cbs)((b)paramq).hQE.hQJ;
    this.LVj = paramq.oGt;
    this.LVk = paramq.oGu;
  }
  
  public final int getType()
  {
    return 2742;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.a.i
 * JD-Core Version:    0.7.0.1
 */