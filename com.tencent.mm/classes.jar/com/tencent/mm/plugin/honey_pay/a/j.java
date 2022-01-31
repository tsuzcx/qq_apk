package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bez;
import com.tencent.mm.protocal.protobuf.bfa;
import com.tencent.mm.protocal.protobuf.bme;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.p;

public final class j
  extends p
{
  private final String TAG;
  public bfa nHl;
  
  public j(bme parambme, String paramString)
  {
    AppMethodBeat.i(41735);
    this.TAG = "MicroMsg.NetSceneModifyHoneyPayerPayWay";
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new bez();
    ((b.a)localObject).fsY = new bfa();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/modifyhppayerpayway";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (bez)this.rr.fsV.fta;
    ((bez)localObject).xkE = parambme;
    ((bez)localObject).xcf = paramString;
    ab.i("MicroMsg.NetSceneModifyHoneyPayerPayWay", "cardNo: %s, suffix: %s, bankType: %s", new Object[] { paramString, parambme.xAD, parambme.poq });
    AppMethodBeat.o(41735);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(41736);
    ab.i("MicroMsg.NetSceneModifyHoneyPayerPayWay", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.nHl = ((bfa)((b)paramq).fsW.fta);
    ab.i("MicroMsg.NetSceneModifyHoneyPayerPayWay", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.nHl.koj), this.nHl.kok });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(41736);
  }
  
  public final void e(q paramq)
  {
    paramq = (bfa)((b)paramq).fsW.fta;
    this.AXb = paramq.koj;
    this.AXc = paramq.kok;
  }
  
  public final int getType()
  {
    return 2941;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.a.j
 * JD-Core Version:    0.7.0.1
 */