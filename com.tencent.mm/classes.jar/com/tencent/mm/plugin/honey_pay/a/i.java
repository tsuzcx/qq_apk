package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bwh;
import com.tencent.mm.protocal.protobuf.bwi;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.wallet_core.c.r;

public final class i
  extends r
{
  private final String TAG;
  public int drx;
  private bwi tCG;
  
  public i(int paramInt)
  {
    AppMethodBeat.i(64628);
    this.TAG = "MicroMsg.NetSceneModifyHoneyPayerNotify";
    b.a locala = new b.a();
    locala.hvt = new bwh();
    locala.hvu = new bwi();
    locala.funcId = getType();
    locala.uri = "/cgi-bin/mmpay-bin/modifyhppayernotify";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    ((bwh)this.rr.hvr.hvw).BhT = paramInt;
    this.drx = paramInt;
    ac.i("MicroMsg.NetSceneModifyHoneyPayerNotify", "notify flag: %s", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(64628);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(64629);
    ac.i("MicroMsg.NetSceneModifyHoneyPayerNotify", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.tCG = ((bwi)((b)paramq).hvs.hvw);
    ac.i("MicroMsg.NetSceneModifyHoneyPayerNotify", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.tCG.nWx), this.tCG.nWy });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(64629);
  }
  
  public final void e(q paramq)
  {
    paramq = (bwi)((b)paramq).hvs.hvw;
    this.JFq = paramq.nWx;
    this.JFr = paramq.nWy;
  }
  
  public final int getType()
  {
    return 2742;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.a.i
 * JD-Core Version:    0.7.0.1
 */