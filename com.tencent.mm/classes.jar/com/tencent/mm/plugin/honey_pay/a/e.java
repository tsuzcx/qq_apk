package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.bcy;
import com.tencent.mm.protocal.protobuf.bcz;
import com.tencent.mm.protocal.protobuf.ru;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.wallet_core.c.r;

public final class e
  extends r
{
  private final String TAG;
  public bcz uQX;
  
  public e(String paramString)
  {
    AppMethodBeat.i(64620);
    this.TAG = "MicroMsg.NetSceneGetHoneyPayCard";
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new bcy();
    ((b.a)localObject).hQG = new bcz();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/gethpcard";
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (bcy)this.rr.hQD.hQJ;
    ((bcy)localObject).GSy = paramString;
    ((bcy)localObject).GQF = k.drq();
    ae.i("MicroMsg.NetSceneGetHoneyPayCard", "card no: %s", new Object[] { paramString });
    AppMethodBeat.o(64620);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(64621);
    ae.i("MicroMsg.NetSceneGetHoneyPayCard", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.uQX = ((bcz)((b)paramq).hQE.hQJ);
    ae.i("MicroMsg.NetSceneGetHoneyPayCard", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.uQX.oGt), this.uQX.oGu });
    if (this.uQX.GSz != null) {
      c.o(this.uQX.GSz.dFs, this.uQX.GSz.Ggo, this.uQX.GSz.dEJ, null);
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(64621);
  }
  
  public final void e(q paramq)
  {
    paramq = (bcz)((b)paramq).hQE.hQJ;
    this.LVj = paramq.oGt;
    this.LVk = paramq.oGu;
  }
  
  public final int getType()
  {
    return 1983;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.a.e
 * JD-Core Version:    0.7.0.1
 */