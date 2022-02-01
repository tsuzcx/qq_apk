package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ele;
import com.tencent.mm.protocal.protobuf.elf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.r;

public final class n
  extends r
{
  private final String TAG;
  public elf yjL;
  
  public n(String paramString1, String paramString2)
  {
    AppMethodBeat.i(64638);
    this.TAG = "MicroMsg.NetSceneUnbindHoneyPayCard";
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new ele();
    ((d.a)localObject).iLO = new elf();
    ((d.a)localObject).funcId = getType();
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/unbindhpcard";
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (ele)this.rr.iLK.iLR;
    ((ele)localObject).LWD = paramString1;
    ((ele)localObject).LpC = paramString2;
    AppMethodBeat.o(64638);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(64639);
    Log.i("MicroMsg.NetSceneUnbindHoneyPayCard", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.yjL = ((elf)((d)params).iLL.iLR);
    Log.i("MicroMsg.NetSceneUnbindHoneyPayCard", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.yjL.pTZ), this.yjL.pUa });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(64639);
  }
  
  public final void e(s params)
  {
    params = (elf)((d)params).iLL.iLR;
    this.RtZ = params.pTZ;
    this.Rua = params.pUa;
  }
  
  public final int getType()
  {
    return 2659;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.a.n
 * JD-Core Version:    0.7.0.1
 */