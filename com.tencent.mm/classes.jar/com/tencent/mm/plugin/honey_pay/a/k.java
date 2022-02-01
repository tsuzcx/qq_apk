package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dhc;
import com.tencent.mm.protocal.protobuf.dhd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.r;

public final class k
  extends r
{
  private final String TAG;
  public dhd yjI;
  
  public k(String paramString)
  {
    AppMethodBeat.i(64632);
    this.TAG = "MicroMsg.NetSceneQryHoneyPayCardDetail";
    d.a locala = new d.a();
    locala.iLN = new dhc();
    locala.iLO = new dhd();
    locala.funcId = getType();
    locala.uri = "/cgi-bin/mmpay-bin/qryhpcarddetail";
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    ((dhc)this.rr.iLK.iLR).LWD = paramString;
    AppMethodBeat.o(64632);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(64633);
    Log.i("MicroMsg.NetSceneQryHoneyPayCardDetail", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.yjI = ((dhd)((d)params).iLL.iLR);
    Log.i("MicroMsg.NetSceneQryHoneyPayCardDetail", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.yjI.pTZ), this.yjI.pUa });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(64633);
  }
  
  public final void e(s params)
  {
    params = (dhd)((d)params).iLL.iLR;
    this.RtZ = params.pTZ;
    this.Rua = params.pUa;
  }
  
  public final int getType()
  {
    return 2851;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.a.k
 * JD-Core Version:    0.7.0.1
 */