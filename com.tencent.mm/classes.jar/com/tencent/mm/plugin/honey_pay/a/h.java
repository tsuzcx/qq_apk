package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bev;
import com.tencent.mm.protocal.protobuf.bew;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.p;

public final class h
  extends p
{
  private final String TAG;
  public bew nHi;
  public long nHj;
  
  public h(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(41731);
    this.TAG = "MicroMsg.NetSceneModifyHoneyPayerCreditLine";
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new bev();
    ((b.a)localObject).fsY = new bew();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/modifyhppayercreditline";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (bev)this.rr.fsV.fta;
    ((bev)localObject).wOy = paramLong;
    ((bev)localObject).wOx = paramString1;
    ((bev)localObject).xcf = paramString2;
    this.nHj = paramLong;
    ab.d("MicroMsg.NetSceneModifyHoneyPayerCreditLine", "cardNo: %s, authToken: %s", new Object[] { paramString2, paramString1 });
    ab.i("MicroMsg.NetSceneModifyHoneyPayerCreditLine", "credit line: %s", new Object[] { Long.valueOf(paramLong) });
    AppMethodBeat.o(41731);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(41732);
    ab.i("MicroMsg.NetSceneModifyHoneyPayerCreditLine", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.nHi = ((bew)((b)paramq).fsW.fta);
    ab.i("MicroMsg.NetSceneModifyHoneyPayerCreditLine", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.nHi.koj), this.nHi.kok });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(41732);
  }
  
  public final void e(q paramq)
  {
    paramq = (bew)((b)paramq).fsW.fta;
    this.AXb = paramq.koj;
    this.AXc = paramq.kok;
  }
  
  public final int getType()
  {
    return 2685;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.a.h
 * JD-Core Version:    0.7.0.1
 */