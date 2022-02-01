package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cbt;
import com.tencent.mm.protocal.protobuf.cbu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.r;

public final class f
  extends r
{
  private final String TAG;
  public cbu yjC;
  
  public f()
  {
    AppMethodBeat.i(64622);
    this.TAG = "MicroMsg.NetSceneHoneyPayerList";
    d.a locala = new d.a();
    locala.iLN = new cbt();
    locala.iLO = new cbu();
    locala.funcId = getType();
    locala.uri = "/cgi-bin/mmpay-bin/honeypayerlist";
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    AppMethodBeat.o(64622);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(64623);
    Log.i("MicroMsg.NetSceneHoneyPayerList", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.yjC = ((cbu)((d)params).iLL.iLR);
    Log.i("MicroMsg.NetSceneHoneyPayerList", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.yjC.pTZ), this.yjC.pUa });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(64623);
  }
  
  public final void e(s params)
  {
    params = (cbu)((d)params).iLL.iLR;
    this.RtZ = params.pTZ;
    this.Rua = params.pUa;
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