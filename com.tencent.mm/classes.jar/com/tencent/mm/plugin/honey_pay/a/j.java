package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cqv;
import com.tencent.mm.protocal.protobuf.cqw;
import com.tencent.mm.protocal.protobuf.dbf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.r;

public final class j
  extends r
{
  private final String TAG;
  public cqw yjH;
  
  public j(dbf paramdbf, String paramString)
  {
    AppMethodBeat.i(64630);
    this.TAG = "MicroMsg.NetSceneModifyHoneyPayerPayWay";
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new cqv();
    ((d.a)localObject).iLO = new cqw();
    ((d.a)localObject).funcId = getType();
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/modifyhppayerpayway";
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (cqv)this.rr.iLK.iLR;
    ((cqv)localObject).MhM = paramdbf;
    ((cqv)localObject).LWD = paramString;
    Log.i("MicroMsg.NetSceneModifyHoneyPayerPayWay", "cardNo: %s, suffix: %s, bankType: %s", new Object[] { paramString, paramdbf.MGk, paramdbf.dDj });
    AppMethodBeat.o(64630);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(64631);
    Log.i("MicroMsg.NetSceneModifyHoneyPayerPayWay", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.yjH = ((cqw)((d)params).iLL.iLR);
    Log.i("MicroMsg.NetSceneModifyHoneyPayerPayWay", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.yjH.pTZ), this.yjH.pUa });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(64631);
  }
  
  public final void e(s params)
  {
    params = (cqw)((d)params).iLL.iLR;
    this.RtZ = params.pTZ;
    this.Rua = params.pUa;
  }
  
  public final int getType()
  {
    return 2941;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.a.j
 * JD-Core Version:    0.7.0.1
 */