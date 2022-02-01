package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cqt;
import com.tencent.mm.protocal.protobuf.cqu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.r;

public final class i
  extends r
{
  private final String TAG;
  public int cSx;
  private cqu yjG;
  
  public i(int paramInt)
  {
    AppMethodBeat.i(64628);
    this.TAG = "MicroMsg.NetSceneModifyHoneyPayerNotify";
    d.a locala = new d.a();
    locala.iLN = new cqt();
    locala.iLO = new cqu();
    locala.funcId = getType();
    locala.uri = "/cgi-bin/mmpay-bin/modifyhppayernotify";
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    ((cqt)this.rr.iLK.iLR).HFB = paramInt;
    this.cSx = paramInt;
    Log.i("MicroMsg.NetSceneModifyHoneyPayerNotify", "notify flag: %s", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(64628);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(64629);
    Log.i("MicroMsg.NetSceneModifyHoneyPayerNotify", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.yjG = ((cqu)((d)params).iLL.iLR);
    Log.i("MicroMsg.NetSceneModifyHoneyPayerNotify", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.yjG.pTZ), this.yjG.pUa });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(64629);
  }
  
  public final void e(s params)
  {
    params = (cqu)((d)params).iLL.iLR;
    this.RtZ = params.pTZ;
    this.Rua = params.pUa;
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