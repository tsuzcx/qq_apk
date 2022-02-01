package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cqr;
import com.tencent.mm.protocal.protobuf.cqs;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.r;

public final class h
  extends r
{
  private final String TAG;
  public cqs yjE;
  public long yjF;
  
  public h(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(64626);
    this.TAG = "MicroMsg.NetSceneModifyHoneyPayerCreditLine";
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new cqr();
    ((d.a)localObject).iLO = new cqs();
    ((d.a)localObject).funcId = getType();
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/modifyhppayercreditline";
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (cqr)this.rr.iLK.iLR;
    ((cqr)localObject).LpD = paramLong;
    ((cqr)localObject).LpC = paramString1;
    ((cqr)localObject).LWD = paramString2;
    this.yjF = paramLong;
    Log.d("MicroMsg.NetSceneModifyHoneyPayerCreditLine", "cardNo: %s, authToken: %s", new Object[] { paramString2, paramString1 });
    Log.i("MicroMsg.NetSceneModifyHoneyPayerCreditLine", "credit line: %s", new Object[] { Long.valueOf(paramLong) });
    AppMethodBeat.o(64626);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(64627);
    Log.i("MicroMsg.NetSceneModifyHoneyPayerCreditLine", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.yjE = ((cqs)((d)params).iLL.iLR);
    Log.i("MicroMsg.NetSceneModifyHoneyPayerCreditLine", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.yjE.pTZ), this.yjE.pUa });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(64627);
  }
  
  public final void e(s params)
  {
    params = (cqs)((d)params).iLL.iLR;
    this.RtZ = params.pTZ;
    this.Rua = params.pUa;
  }
  
  public final int getType()
  {
    return 2685;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.a.h
 * JD-Core Version:    0.7.0.1
 */