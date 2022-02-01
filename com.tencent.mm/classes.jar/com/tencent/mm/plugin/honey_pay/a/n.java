package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dku;
import com.tencent.mm.protocal.protobuf.dkv;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.wallet_core.c.r;

public final class n
  extends r
{
  private final String TAG;
  public dkv tCL;
  
  public n(String paramString1, String paramString2)
  {
    AppMethodBeat.i(64638);
    this.TAG = "MicroMsg.NetSceneUnbindHoneyPayCard";
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new dku();
    ((b.a)localObject).hvu = new dkv();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/unbindhpcard";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (dku)this.rr.hvr.hvw;
    ((dku)localObject).EPH = paramString1;
    ((dku)localObject).Eua = paramString2;
    AppMethodBeat.o(64638);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(64639);
    ac.i("MicroMsg.NetSceneUnbindHoneyPayCard", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.tCL = ((dkv)((b)paramq).hvs.hvw);
    ac.i("MicroMsg.NetSceneUnbindHoneyPayCard", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.tCL.nWx), this.tCL.nWy });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(64639);
  }
  
  public final void e(q paramq)
  {
    paramq = (dkv)((b)paramq).hvs.hvw;
    this.JFq = paramq.nWx;
    this.JFr = paramq.nWy;
  }
  
  public final int getType()
  {
    return 2659;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.a.n
 * JD-Core Version:    0.7.0.1
 */