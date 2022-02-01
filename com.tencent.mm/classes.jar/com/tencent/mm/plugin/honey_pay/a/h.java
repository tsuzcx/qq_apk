package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bwf;
import com.tencent.mm.protocal.protobuf.bwg;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.wallet_core.c.r;

public final class h
  extends r
{
  private final String TAG;
  public bwg tCE;
  public long tCF;
  
  public h(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(64626);
    this.TAG = "MicroMsg.NetSceneModifyHoneyPayerCreditLine";
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new bwf();
    ((b.a)localObject).hvu = new bwg();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/modifyhppayercreditline";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (bwf)this.rr.hvr.hvw;
    ((bwf)localObject).Eub = paramLong;
    ((bwf)localObject).Eua = paramString1;
    ((bwf)localObject).EPH = paramString2;
    this.tCF = paramLong;
    ac.d("MicroMsg.NetSceneModifyHoneyPayerCreditLine", "cardNo: %s, authToken: %s", new Object[] { paramString2, paramString1 });
    ac.i("MicroMsg.NetSceneModifyHoneyPayerCreditLine", "credit line: %s", new Object[] { Long.valueOf(paramLong) });
    AppMethodBeat.o(64626);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(64627);
    ac.i("MicroMsg.NetSceneModifyHoneyPayerCreditLine", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.tCE = ((bwg)((b)paramq).hvs.hvw);
    ac.i("MicroMsg.NetSceneModifyHoneyPayerCreditLine", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.tCE.nWx), this.tCE.nWy });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(64627);
  }
  
  public final void e(q paramq)
  {
    paramq = (bwg)((b)paramq).hvs.hvw;
    this.JFq = paramq.nWx;
    this.JFr = paramq.nWy;
  }
  
  public final int getType()
  {
    return 2685;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.a.h
 * JD-Core Version:    0.7.0.1
 */