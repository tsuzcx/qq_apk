package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.cla;
import com.tencent.mm.protocal.protobuf.clb;
import com.tencent.mm.protocal.protobuf.uj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.model.r;

public final class e
  extends r
{
  public clb JAz;
  private final String TAG;
  
  public e(String paramString)
  {
    AppMethodBeat.i(64620);
    this.TAG = "MicroMsg.NetSceneGetHoneyPayCard";
    Object localObject = new c.a();
    ((c.a)localObject).otE = new cla();
    ((c.a)localObject).otF = new clb();
    ((c.a)localObject).funcId = getType();
    ((c.a)localObject).uri = "/cgi-bin/mmpay-bin/gethpcard";
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (cla)c.b.b(this.rr.otB);
    ((cla)localObject).aatc = paramString;
    ((cla)localObject).aaqS = k.gdF();
    Log.i("MicroMsg.NetSceneGetHoneyPayCard", "card no: %s", new Object[] { paramString });
    AppMethodBeat.o(64620);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(64621);
    Log.i("MicroMsg.NetSceneGetHoneyPayCard", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.JAz = ((clb)c.c.b(((com.tencent.mm.am.c)params).otC));
    Log.i("MicroMsg.NetSceneGetHoneyPayCard", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.JAz.wuz), this.JAz.wuA });
    if (this.JAz.aatd != null) {
      com.tencent.mm.plugin.honey_pay.model.c.z(this.JAz.aatd.hWO, this.JAz.aatd.YZU, this.JAz.aatd.hVW, null);
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(64621);
  }
  
  public final void f(s params)
  {
    AppMethodBeat.i(267304);
    params = (clb)c.c.b(((com.tencent.mm.am.c)params).otC);
    this.agTs = params.wuz;
    this.agTt = params.wuA;
    AppMethodBeat.o(267304);
  }
  
  public final int getType()
  {
    return 1983;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.a.e
 * JD-Core Version:    0.7.0.1
 */