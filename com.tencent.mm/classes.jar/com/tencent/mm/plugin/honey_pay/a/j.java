package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cbt;
import com.tencent.mm.protocal.protobuf.cbu;
import com.tencent.mm.protocal.protobuf.ckx;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.wallet_core.c.r;

public final class j
  extends r
{
  private final String TAG;
  public cbu uRd;
  
  public j(ckx paramckx, String paramString)
  {
    AppMethodBeat.i(64630);
    this.TAG = "MicroMsg.NetSceneModifyHoneyPayerPayWay";
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new cbt();
    ((b.a)localObject).hQG = new cbu();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/modifyhppayerpayway";
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (cbt)this.rr.hQD.hQJ;
    ((cbt)localObject).HcJ = paramckx;
    ((cbt)localObject).GSy = paramString;
    ae.i("MicroMsg.NetSceneModifyHoneyPayerPayWay", "cardNo: %s, suffix: %s, bankType: %s", new Object[] { paramString, paramckx.Hxk, paramckx.dlT });
    AppMethodBeat.o(64630);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(64631);
    ae.i("MicroMsg.NetSceneModifyHoneyPayerPayWay", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.uRd = ((cbu)((b)paramq).hQE.hQJ);
    ae.i("MicroMsg.NetSceneModifyHoneyPayerPayWay", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.uRd.oGt), this.uRd.oGu });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(64631);
  }
  
  public final void e(q paramq)
  {
    paramq = (cbu)((b)paramq).hQE.hQJ;
    this.LVj = paramq.oGt;
    this.LVk = paramq.oGu;
  }
  
  public final int getType()
  {
    return 2941;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.a.j
 * JD-Core Version:    0.7.0.1
 */