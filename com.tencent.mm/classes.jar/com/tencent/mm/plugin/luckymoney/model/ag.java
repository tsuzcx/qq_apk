package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bnp;
import com.tencent.mm.protocal.protobuf.bnq;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.wallet_core.c.r;

public final class ag
  extends r
{
  public bnq vCe;
  
  public ag(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(65283);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new bnp();
    ((b.a)localObject).hQG = new bnq();
    ((b.a)localObject).funcId = 2929;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/ftfhb/businesscallbackwxhb";
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (bnp)this.rr.hQD.hQJ;
    ((bnp)localObject).vwq = paramString1;
    ((bnp)localObject).pgs = paramString2;
    ((bnp)localObject).vCI = paramString3;
    ae.i("MicroMsg.NetSceneLuckyMoneyBusinessCallback", "sendId: %s, %s", new Object[] { paramString1, paramString3 });
    AppMethodBeat.o(65283);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(65284);
    this.vCe = ((bnq)((b)paramq).hQE.hQJ);
    ae.i("MicroMsg.NetSceneLuckyMoneyBusinessCallback", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.vCe.dmy), this.vCe.phe });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(65284);
  }
  
  public final void e(q paramq)
  {
    paramq = (bnq)((b)paramq).hQE.hQJ;
    this.LVj = paramq.dmy;
    this.LVk = paramq.phe;
  }
  
  public final int getType()
  {
    return 2929;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.ag
 * JD-Core Version:    0.7.0.1
 */