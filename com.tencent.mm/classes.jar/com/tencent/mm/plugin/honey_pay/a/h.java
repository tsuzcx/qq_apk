package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cbp;
import com.tencent.mm.protocal.protobuf.cbq;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.wallet_core.c.r;

public final class h
  extends r
{
  private final String TAG;
  public cbq uRa;
  public long uRb;
  
  public h(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(64626);
    this.TAG = "MicroMsg.NetSceneModifyHoneyPayerCreditLine";
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new cbp();
    ((b.a)localObject).hQG = new cbq();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/modifyhppayercreditline";
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (cbp)this.rr.hQD.hQJ;
    ((cbp)localObject).Gub = paramLong;
    ((cbp)localObject).Gua = paramString1;
    ((cbp)localObject).GSy = paramString2;
    this.uRb = paramLong;
    ae.d("MicroMsg.NetSceneModifyHoneyPayerCreditLine", "cardNo: %s, authToken: %s", new Object[] { paramString2, paramString1 });
    ae.i("MicroMsg.NetSceneModifyHoneyPayerCreditLine", "credit line: %s", new Object[] { Long.valueOf(paramLong) });
    AppMethodBeat.o(64626);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(64627);
    ae.i("MicroMsg.NetSceneModifyHoneyPayerCreditLine", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.uRa = ((cbq)((b)paramq).hQE.hQJ);
    ae.i("MicroMsg.NetSceneModifyHoneyPayerCreditLine", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.uRa.oGt), this.uRa.oGu });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(64627);
  }
  
  public final void e(q paramq)
  {
    paramq = (cbq)((b)paramq).hQE.hQJ;
    this.LVj = paramq.oGt;
    this.LVk = paramq.oGu;
  }
  
  public final int getType()
  {
    return 2685;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.a.h
 * JD-Core Version:    0.7.0.1
 */