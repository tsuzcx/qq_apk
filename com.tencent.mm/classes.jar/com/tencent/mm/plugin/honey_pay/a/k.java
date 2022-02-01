package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cpd;
import com.tencent.mm.protocal.protobuf.cpe;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.wallet_core.c.r;

public final class k
  extends r
{
  private final String TAG;
  public cpe uRe;
  
  public k(String paramString)
  {
    AppMethodBeat.i(64632);
    this.TAG = "MicroMsg.NetSceneQryHoneyPayCardDetail";
    b.a locala = new b.a();
    locala.hQF = new cpd();
    locala.hQG = new cpe();
    locala.funcId = getType();
    locala.uri = "/cgi-bin/mmpay-bin/qryhpcarddetail";
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDS();
    ((cpd)this.rr.hQD.hQJ).GSy = paramString;
    AppMethodBeat.o(64632);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(64633);
    ae.i("MicroMsg.NetSceneQryHoneyPayCardDetail", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.uRe = ((cpe)((b)paramq).hQE.hQJ);
    ae.i("MicroMsg.NetSceneQryHoneyPayCardDetail", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.uRe.oGt), this.uRe.oGu });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(64633);
  }
  
  public final void e(q paramq)
  {
    paramq = (cpe)((b)paramq).hQE.hQJ;
    this.LVj = paramq.oGt;
    this.LVk = paramq.oGu;
  }
  
  public final int getType()
  {
    return 2851;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.a.k
 * JD-Core Version:    0.7.0.1
 */