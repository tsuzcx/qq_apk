package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.cid;
import com.tencent.mm.protocal.protobuf.cie;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.model.r;

public final class d
  extends r
{
  public cie JAy;
  private final String TAG;
  
  public d(String paramString, long paramLong)
  {
    AppMethodBeat.i(64618);
    this.TAG = "MicroMsg.NetSceneGetCreateTokenSign";
    Object localObject = new c.a();
    ((c.a)localObject).otE = new cid();
    ((c.a)localObject).otF = new cie();
    ((c.a)localObject).funcId = getType();
    ((c.a)localObject).uri = "/cgi-bin/mmpay-bin/createhpcardtoken";
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (cid)c.b.b(this.rr.otB);
    ((cid)localObject).Zji = paramString;
    ((cid)localObject).Zqa = paramLong;
    ((cid)localObject).aaqS = k.gdF();
    Log.i("MicroMsg.NetSceneGetCreateTokenSign", "take_message: %s, credit_line: %s", new Object[] { paramString, Long.valueOf(paramLong) });
    AppMethodBeat.o(64618);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(64619);
    Log.i("MicroMsg.NetSceneGetCreateTokenSign", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.JAy = ((cie)c.c.b(((c)params).otC));
    Log.i("MicroMsg.NetSceneGetCreateTokenSign", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.JAy.wuz), this.JAy.wuA });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(64619);
  }
  
  public final void f(s params)
  {
    AppMethodBeat.i(267305);
    params = (cie)c.c.b(((c)params).otC);
    this.agTs = params.wuz;
    this.agTt = params.wuA;
    AppMethodBeat.o(267305);
  }
  
  public final int getType()
  {
    return 2630;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.a.d
 * JD-Core Version:    0.7.0.1
 */