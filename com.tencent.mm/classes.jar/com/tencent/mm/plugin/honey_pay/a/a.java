package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ym;
import com.tencent.mm.protocal.protobuf.yn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.r;

public final class a
  extends r
{
  private final String TAG;
  public yn yjx;
  
  public a()
  {
    AppMethodBeat.i(64612);
    this.TAG = "MicroMsg.NetSceneCheckHoneyPayer";
    d.a locala = new d.a();
    locala.iLN = new ym();
    locala.iLO = new yn();
    locala.funcId = getType();
    locala.uri = "/cgi-bin/mmpay-bin/checkhoneypayer";
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    AppMethodBeat.o(64612);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(64613);
    Log.i("MicroMsg.NetSceneCheckHoneyPayer", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.yjx = ((yn)((d)params).iLL.iLR);
    Log.i("MicroMsg.NetSceneCheckHoneyPayer", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.yjx.pTZ), this.yjx.pUa });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(64613);
  }
  
  public final void e(s params)
  {
    params = (yn)((d)params).iLL.iLR;
    this.RtZ = params.pTZ;
    this.Rua = params.pUa;
  }
  
  public final int getType()
  {
    return 2618;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.a.a
 * JD-Core Version:    0.7.0.1
 */