package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bex;
import com.tencent.mm.protocal.protobuf.bey;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.p;

public final class i
  extends p
{
  private final String TAG;
  public int bsY;
  private bey nHk;
  
  public i(int paramInt)
  {
    AppMethodBeat.i(41733);
    this.TAG = "MicroMsg.NetSceneModifyHoneyPayerNotify";
    b.a locala = new b.a();
    locala.fsX = new bex();
    locala.fsY = new bey();
    locala.funcId = getType();
    locala.uri = "/cgi-bin/mmpay-bin/modifyhppayernotify";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.ado();
    ((bex)this.rr.fsV.fta).tVm = paramInt;
    this.bsY = paramInt;
    ab.i("MicroMsg.NetSceneModifyHoneyPayerNotify", "notify flag: %s", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(41733);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(41734);
    ab.i("MicroMsg.NetSceneModifyHoneyPayerNotify", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.nHk = ((bey)((b)paramq).fsW.fta);
    ab.i("MicroMsg.NetSceneModifyHoneyPayerNotify", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.nHk.koj), this.nHk.kok });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(41734);
  }
  
  public final void e(q paramq)
  {
    paramq = (bey)((b)paramq).fsW.fta;
    this.AXb = paramq.koj;
    this.AXc = paramq.kok;
  }
  
  public final int getType()
  {
    return 2742;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.a.i
 * JD-Core Version:    0.7.0.1
 */