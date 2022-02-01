package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.fqx;
import com.tencent.mm.protocal.protobuf.fqy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.model.r;

public final class n
  extends r
{
  public fqy JAJ;
  private final String TAG;
  
  public n(String paramString1, String paramString2)
  {
    AppMethodBeat.i(64638);
    this.TAG = "MicroMsg.NetSceneUnbindHoneyPayCard";
    Object localObject = new c.a();
    ((c.a)localObject).otE = new fqx();
    ((c.a)localObject).otF = new fqy();
    ((c.a)localObject).funcId = getType();
    ((c.a)localObject).uri = "/cgi-bin/mmpay-bin/unbindhpcard";
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (fqx)c.b.b(this.rr.otB);
    ((fqx)localObject).aatc = paramString1;
    ((fqx)localObject).ZpZ = paramString2;
    AppMethodBeat.o(64638);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(64639);
    Log.i("MicroMsg.NetSceneUnbindHoneyPayCard", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.JAJ = ((fqy)c.c.b(((c)params).otC));
    Log.i("MicroMsg.NetSceneUnbindHoneyPayCard", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.JAJ.wuz), this.JAJ.wuA });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(64639);
  }
  
  public final void f(s params)
  {
    AppMethodBeat.i(267294);
    params = (fqy)c.c.b(((c)params).otC);
    this.agTs = params.wuz;
    this.agTt = params.wuA;
    AppMethodBeat.o(267294);
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