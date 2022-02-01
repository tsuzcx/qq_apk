package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dri;
import com.tencent.mm.protocal.protobuf.drj;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.wallet_core.c.r;

public final class n
  extends r
{
  private final String TAG;
  public drj uRh;
  
  public n(String paramString1, String paramString2)
  {
    AppMethodBeat.i(64638);
    this.TAG = "MicroMsg.NetSceneUnbindHoneyPayCard";
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new dri();
    ((b.a)localObject).hQG = new drj();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/unbindhpcard";
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (dri)this.rr.hQD.hQJ;
    ((dri)localObject).GSy = paramString1;
    ((dri)localObject).Gua = paramString2;
    AppMethodBeat.o(64638);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(64639);
    ae.i("MicroMsg.NetSceneUnbindHoneyPayCard", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.uRh = ((drj)((b)paramq).hQE.hQJ);
    ae.i("MicroMsg.NetSceneUnbindHoneyPayCard", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.uRh.oGt), this.uRh.oGu });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(64639);
  }
  
  public final void e(q paramq)
  {
    paramq = (drj)((b)paramq).hQE.hQJ;
    this.LVj = paramq.oGt;
    this.LVk = paramq.oGu;
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