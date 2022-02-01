package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.aef;
import com.tencent.mm.protocal.protobuf.aeg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.r;

public final class c
  extends r
{
  private final String TAG;
  public aeg yjz;
  
  public c(String paramString1, long paramLong, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    AppMethodBeat.i(64616);
    this.TAG = "MicroMsg.NetSceneCreateHoneyPayCard";
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new aef();
    ((d.a)localObject).iLO = new aeg();
    ((d.a)localObject).funcId = getType();
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/createhoneypaycard";
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (aef)this.rr.iLK.iLR;
    ((aef)localObject).LpC = paramString1;
    ((aef)localObject).LpD = paramLong;
    ((aef)localObject).LjD = paramString2;
    ((aef)localObject).LjH = paramString3;
    ((aef)localObject).nHh = paramInt;
    ((aef)localObject).yPK = paramString4;
    Log.d("MicroMsg.NetSceneCreateHoneyPayCard", "token: %s, take message: %s, wishing: %s", new Object[] { paramString1, paramString3, paramString4 });
    Log.i("MicroMsg.NetSceneCreateHoneyPayCard", "username: %s, credit line: %s", new Object[] { paramString2, Long.valueOf(paramLong) });
    AppMethodBeat.o(64616);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(64617);
    Log.i("MicroMsg.NetSceneCreateHoneyPayCard", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.yjz = ((aeg)((d)params).iLL.iLR);
    Log.i("MicroMsg.NetSceneCreateHoneyPayCard", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.yjz.pTZ), this.yjz.pUa });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(64617);
  }
  
  public final void e(s params)
  {
    params = (aeg)((d)params).iLL.iLR;
    this.RtZ = params.pTZ;
    this.Rua = params.pUa;
  }
  
  public final int getType()
  {
    return 2662;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.a.c
 * JD-Core Version:    0.7.0.1
 */