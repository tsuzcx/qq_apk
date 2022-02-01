package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dqt;
import com.tencent.mm.protocal.protobuf.dqu;
import com.tencent.mm.protocal.protobuf.edd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.model.r;

public final class j
  extends r
{
  public dqu JAF;
  private final String TAG;
  
  public j(edd paramedd, String paramString1, String paramString2)
  {
    AppMethodBeat.i(267293);
    this.TAG = "MicroMsg.NetSceneModifyHoneyPayerPayWay";
    Object localObject = new c.a();
    ((c.a)localObject).otE = new dqt();
    ((c.a)localObject).otF = new dqu();
    ((c.a)localObject).funcId = getType();
    ((c.a)localObject).uri = "/cgi-bin/mmpay-bin/modifyhppayerpayway";
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (dqt)c.b.b(this.rr.otB);
    ((dqt)localObject).aaFL = paramedd;
    ((dqt)localObject).aatc = paramString1;
    ((dqt)localObject).aaWY = paramString2;
    Log.i("MicroMsg.NetSceneModifyHoneyPayerPayWay", "cardNo: %s, suffix: %s, bankType: %s sessionId: %s", new Object[] { paramString1, paramedd.abiu, paramedd.hAk, paramString2 });
    AppMethodBeat.o(267293);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(64631);
    Log.i("MicroMsg.NetSceneModifyHoneyPayerPayWay", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.JAF = ((dqu)c.c.b(((c)params).otC));
    Log.i("MicroMsg.NetSceneModifyHoneyPayerPayWay", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.JAF.wuz), this.JAF.wuA });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(64631);
  }
  
  public final void f(s params)
  {
    AppMethodBeat.i(267299);
    params = (dqu)c.c.b(((c)params).otC);
    this.agTs = params.wuz;
    this.agTt = params.wuA;
    AppMethodBeat.o(267299);
  }
  
  public final int getType()
  {
    return 2941;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.a.j
 * JD-Core Version:    0.7.0.1
 */