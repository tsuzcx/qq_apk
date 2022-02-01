package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.caz;
import com.tencent.mm.protocal.protobuf.cba;
import com.tencent.mm.protocal.protobuf.ckd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.c.r;

public final class j
  extends r
{
  private final String TAG;
  public cba uFq;
  
  public j(ckd paramckd, String paramString)
  {
    AppMethodBeat.i(64630);
    this.TAG = "MicroMsg.NetSceneModifyHoneyPayerPayWay";
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new caz();
    ((b.a)localObject).hNN = new cba();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/modifyhppayerpayway";
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (caz)this.rr.hNK.hNQ;
    ((caz)localObject).GJi = paramckd;
    ((caz)localObject).GyY = paramString;
    ad.i("MicroMsg.NetSceneModifyHoneyPayerPayWay", "cardNo: %s, suffix: %s, bankType: %s", new Object[] { paramString, paramckd.HdK, paramckd.dkR });
    AppMethodBeat.o(64630);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(64631);
    ad.i("MicroMsg.NetSceneModifyHoneyPayerPayWay", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.uFq = ((cba)((b)paramq).hNL.hNQ);
    ad.i("MicroMsg.NetSceneModifyHoneyPayerPayWay", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.uFq.ozR), this.uFq.ozS });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(64631);
  }
  
  public final void e(q paramq)
  {
    paramq = (cba)((b)paramq).hNL.hNQ;
    this.Lyu = paramq.ozR;
    this.Lyv = paramq.ozS;
  }
  
  public final int getType()
  {
    return 2941;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.a.j
 * JD-Core Version:    0.7.0.1
 */