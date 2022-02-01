package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.bmb;
import com.tencent.mm.protocal.protobuf.bmc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.r;

public final class d
  extends r
{
  private final String TAG;
  public bmc yjA;
  
  public d(String paramString, long paramLong)
  {
    AppMethodBeat.i(64618);
    this.TAG = "MicroMsg.NetSceneGetCreateTokenSign";
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new bmb();
    ((d.a)localObject).iLO = new bmc();
    ((d.a)localObject).funcId = getType();
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/createhpcardtoken";
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (bmb)this.rr.iLK.iLR;
    ((bmb)localObject).LjH = paramString;
    ((bmb)localObject).LpD = paramLong;
    ((bmb)localObject).LUV = k.elk();
    Log.i("MicroMsg.NetSceneGetCreateTokenSign", "take_message: %s, credit_line: %s", new Object[] { paramString, Long.valueOf(paramLong) });
    AppMethodBeat.o(64618);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(64619);
    Log.i("MicroMsg.NetSceneGetCreateTokenSign", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.yjA = ((bmc)((com.tencent.mm.ak.d)params).iLL.iLR);
    Log.i("MicroMsg.NetSceneGetCreateTokenSign", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.yjA.pTZ), this.yjA.pUa });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(64619);
  }
  
  public final void e(s params)
  {
    params = (bmc)((com.tencent.mm.ak.d)params).iLL.iLR;
    this.RtZ = params.pTZ;
    this.Rua = params.pUa;
  }
  
  public final int getType()
  {
    return 2630;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.a.d
 * JD-Core Version:    0.7.0.1
 */