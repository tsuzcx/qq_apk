package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bqb;
import com.tencent.mm.protocal.protobuf.bqc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.r;

public final class g
  extends r
{
  private final String TAG;
  public bqc yjD;
  
  public g(String paramString, long paramLong)
  {
    AppMethodBeat.i(64624);
    this.TAG = "MicroMsg.NetSceneMCreditLineTokenSign";
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new bqb();
    ((d.a)localObject).iLO = new bqc();
    ((d.a)localObject).funcId = getType();
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/gmcreditlinetoken";
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (bqb)this.rr.iLK.iLR;
    ((bqb)localObject).LWD = paramString;
    ((bqb)localObject).LpD = paramLong;
    Log.i("MicroMsg.NetSceneMCreditLineTokenSign", "card_no: %s, credit_line: %s", new Object[] { paramString, Long.valueOf(paramLong) });
    AppMethodBeat.o(64624);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(64625);
    Log.i("MicroMsg.NetSceneMCreditLineTokenSign", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.yjD = ((bqc)((d)params).iLL.iLR);
    Log.i("MicroMsg.NetSceneMCreditLineTokenSign", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.yjD.pTZ), this.yjD.pUa });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(64625);
  }
  
  public final void e(s params)
  {
    params = (bqc)((d)params).iLL.iLR;
    this.RtZ = params.pTZ;
    this.Rua = params.pUa;
  }
  
  public final int getType()
  {
    return 2815;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.a.g
 * JD-Core Version:    0.7.0.1
 */