package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bel;
import com.tencent.mm.protocal.protobuf.bem;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.wallet_core.c.r;

public final class g
  extends r
{
  private final String TAG;
  public bem uQZ;
  
  public g(String paramString, long paramLong)
  {
    AppMethodBeat.i(64624);
    this.TAG = "MicroMsg.NetSceneMCreditLineTokenSign";
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new bel();
    ((b.a)localObject).hQG = new bem();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/gmcreditlinetoken";
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (bel)this.rr.hQD.hQJ;
    ((bel)localObject).GSy = paramString;
    ((bel)localObject).Gub = paramLong;
    ae.i("MicroMsg.NetSceneMCreditLineTokenSign", "card_no: %s, credit_line: %s", new Object[] { paramString, Long.valueOf(paramLong) });
    AppMethodBeat.o(64624);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(64625);
    ae.i("MicroMsg.NetSceneMCreditLineTokenSign", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.uQZ = ((bem)((b)paramq).hQE.hQJ);
    ae.i("MicroMsg.NetSceneMCreditLineTokenSign", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.uQZ.oGt), this.uQZ.oGu });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(64625);
  }
  
  public final void e(q paramq)
  {
    paramq = (bem)((b)paramq).hQE.hQJ;
    this.LVj = paramq.oGt;
    this.LVk = paramq.oGu;
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