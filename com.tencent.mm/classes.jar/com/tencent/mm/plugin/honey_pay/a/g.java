package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cmy;
import com.tencent.mm.protocal.protobuf.cmz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.model.r;

public final class g
  extends r
{
  public cmz JAB;
  private final String TAG;
  
  public g(String paramString, long paramLong)
  {
    AppMethodBeat.i(64624);
    this.TAG = "MicroMsg.NetSceneMCreditLineTokenSign";
    Object localObject = new c.a();
    ((c.a)localObject).otE = new cmy();
    ((c.a)localObject).otF = new cmz();
    ((c.a)localObject).funcId = getType();
    ((c.a)localObject).uri = "/cgi-bin/mmpay-bin/gmcreditlinetoken";
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (cmy)c.b.b(this.rr.otB);
    ((cmy)localObject).aatc = paramString;
    ((cmy)localObject).Zqa = paramLong;
    Log.i("MicroMsg.NetSceneMCreditLineTokenSign", "card_no: %s, credit_line: %s", new Object[] { paramString, Long.valueOf(paramLong) });
    AppMethodBeat.o(64624);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(64625);
    Log.i("MicroMsg.NetSceneMCreditLineTokenSign", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.JAB = ((cmz)c.c.b(((c)params).otC));
    Log.i("MicroMsg.NetSceneMCreditLineTokenSign", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.JAB.wuz), this.JAB.wuA });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(64625);
  }
  
  public final void f(s params)
  {
    AppMethodBeat.i(267303);
    params = (cmz)c.c.b(((c)params).otC);
    this.agTs = params.wuz;
    this.agTt = params.wuA;
    AppMethodBeat.o(267303);
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