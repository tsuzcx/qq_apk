package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dql;
import com.tencent.mm.protocal.protobuf.dqm;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.c.r;

public final class n
  extends r
{
  private final String TAG;
  public dqm uFu;
  
  public n(String paramString1, String paramString2)
  {
    AppMethodBeat.i(64638);
    this.TAG = "MicroMsg.NetSceneUnbindHoneyPayCard";
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new dql();
    ((b.a)localObject).hNN = new dqm();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/unbindhpcard";
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (dql)this.rr.hNK.hNQ;
    ((dql)localObject).GyY = paramString1;
    ((dql)localObject).Gbt = paramString2;
    AppMethodBeat.o(64638);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(64639);
    ad.i("MicroMsg.NetSceneUnbindHoneyPayCard", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.uFu = ((dqm)((b)paramq).hNL.hNQ);
    ad.i("MicroMsg.NetSceneUnbindHoneyPayCard", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.uFu.ozR), this.uFu.ozS });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(64639);
  }
  
  public final void e(q paramq)
  {
    paramq = (dqm)((b)paramq).hNL.hNQ;
    this.Lyu = paramq.ozR;
    this.Lyv = paramq.ozS;
  }
  
  public final int getType()
  {
    return 2659;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.a.n
 * JD-Core Version:    0.7.0.1
 */