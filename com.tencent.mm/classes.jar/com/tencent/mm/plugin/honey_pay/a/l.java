package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.protocal.protobuf.dhe;
import com.tencent.mm.protocal.protobuf.dhf;
import com.tencent.mm.protocal.protobuf.sx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.r;

public final class l
  extends r
{
  private final String TAG;
  public dhf yjJ;
  
  public l(String paramString)
  {
    AppMethodBeat.i(64634);
    this.TAG = "MicroMsg.NetSceneQryHoneyPayerDetail";
    d.a locala = new d.a();
    locala.iLN = new dhe();
    locala.iLO = new dhf();
    locala.funcId = getType();
    locala.uri = "/cgi-bin/mmpay-bin/qryhppayerdetail";
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    ((dhe)this.rr.iLK.iLR).LWD = paramString;
    Log.i("MicroMsg.NetSceneQryHoneyPayerDetail", "card no: %s", new Object[] { paramString });
    AppMethodBeat.o(64634);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(64635);
    Log.i("MicroMsg.NetSceneQryHoneyPayerDetail", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.yjJ = ((dhf)((d)params).iLL.iLR);
    Log.i("MicroMsg.NetSceneQryHoneyPayerDetail", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.yjJ.pTZ), this.yjJ.pUa });
    if (this.yjJ.LWE != null) {
      c.s(this.yjJ.LWE.dXf, this.yjJ.LWE.LaR, this.yjJ.LWE.dWw, null);
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(64635);
  }
  
  public final void e(s params)
  {
    params = (dhf)((d)params).iLL.iLR;
    this.RtZ = params.pTZ;
    this.Rua = params.pUa;
  }
  
  public final int getType()
  {
    return 2876;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.a.l
 * JD-Core Version:    0.7.0.1
 */