package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.biq;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.wallet_core.c.r;

public final class ag
  extends r
{
  public biq unt;
  
  public ag(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(65283);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new bip();
    ((b.a)localObject).hvu = new biq();
    ((b.a)localObject).funcId = 2929;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/ftfhb/businesscallbackwxhb";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (bip)this.rr.hvr.hvw;
    ((bip)localObject).uhB = paramString1;
    ((bip)localObject).owt = paramString2;
    ((bip)localObject).unZ = paramString3;
    ac.i("MicroMsg.NetSceneLuckyMoneyBusinessCallback", "sendId: %s, %s", new Object[] { paramString1, paramString3 });
    AppMethodBeat.o(65283);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(65284);
    this.unt = ((biq)((b)paramq).hvs.hvw);
    ac.i("MicroMsg.NetSceneLuckyMoneyBusinessCallback", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.unt.dae), this.unt.oxf });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(65284);
  }
  
  public final void e(q paramq)
  {
    paramq = (biq)((b)paramq).hvs.hvw;
    this.JFq = paramq.dae;
    this.JFr = paramq.oxf;
  }
  
  public final int getType()
  {
    return 2929;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.ag
 * JD-Core Version:    0.7.0.1
 */