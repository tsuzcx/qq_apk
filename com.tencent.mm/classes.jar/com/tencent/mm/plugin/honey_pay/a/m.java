package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.protocal.protobuf.dhg;
import com.tencent.mm.protocal.protobuf.dhh;
import com.tencent.mm.protocal.protobuf.sx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.r;

public final class m
  extends r
{
  private final String TAG;
  public dhh yjK;
  
  public m(String paramString)
  {
    AppMethodBeat.i(64636);
    this.TAG = "MicroMsg.NetSceneQryHoneyUserDetail";
    d.a locala = new d.a();
    locala.iLN = new dhg();
    locala.iLO = new dhh();
    locala.funcId = getType();
    locala.uri = "/cgi-bin/mmpay-bin/qryhpusererdetail";
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    ((dhg)this.rr.iLK.iLR).LWD = paramString;
    Log.i("MicroMsg.NetSceneQryHoneyUserDetail", "card no: %s", new Object[] { paramString });
    AppMethodBeat.o(64636);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(64637);
    Log.i("MicroMsg.NetSceneQryHoneyUserDetail", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.yjK = ((dhh)((d)params).iLL.iLR);
    Log.i("MicroMsg.NetSceneQryHoneyUserDetail", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.yjK.pTZ), this.yjK.pUa });
    if (this.yjK.LWE != null) {
      c.s(this.yjK.LWE.dXf, this.yjK.LWE.LaR, this.yjK.LWE.dWw, null);
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(64637);
  }
  
  public final void e(s params)
  {
    params = (dhh)((d)params).iLL.iLR;
    this.RtZ = params.pTZ;
    this.Rua = params.pUa;
  }
  
  public final int getType()
  {
    return 2613;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.a.m
 * JD-Core Version:    0.7.0.1
 */