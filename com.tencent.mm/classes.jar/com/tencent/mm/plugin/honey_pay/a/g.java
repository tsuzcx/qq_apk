package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.azr;
import com.tencent.mm.protocal.protobuf.azs;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.wallet_core.c.r;

public final class g
  extends r
{
  private final String TAG;
  public azs tCD;
  
  public g(String paramString, long paramLong)
  {
    AppMethodBeat.i(64624);
    this.TAG = "MicroMsg.NetSceneMCreditLineTokenSign";
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new azr();
    ((b.a)localObject).hvu = new azs();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/gmcreditlinetoken";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (azr)this.rr.hvr.hvw;
    ((azr)localObject).EPH = paramString;
    ((azr)localObject).Eub = paramLong;
    ac.i("MicroMsg.NetSceneMCreditLineTokenSign", "card_no: %s, credit_line: %s", new Object[] { paramString, Long.valueOf(paramLong) });
    AppMethodBeat.o(64624);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(64625);
    ac.i("MicroMsg.NetSceneMCreditLineTokenSign", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.tCD = ((azs)((b)paramq).hvs.hvw);
    ac.i("MicroMsg.NetSceneMCreditLineTokenSign", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.tCD.nWx), this.tCD.nWy });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(64625);
  }
  
  public final void e(q paramq)
  {
    paramq = (azs)((b)paramq).hvs.hvw;
    this.JFq = paramq.nWx;
    this.JFr = paramq.nWy;
  }
  
  public final int getType()
  {
    return 2815;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.a.g
 * JD-Core Version:    0.7.0.1
 */