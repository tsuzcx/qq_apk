package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.protocal.protobuf.cph;
import com.tencent.mm.protocal.protobuf.cpi;
import com.tencent.mm.protocal.protobuf.ru;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.wallet_core.c.r;

public final class m
  extends r
{
  private final String TAG;
  public cpi uRg;
  
  public m(String paramString)
  {
    AppMethodBeat.i(64636);
    this.TAG = "MicroMsg.NetSceneQryHoneyUserDetail";
    b.a locala = new b.a();
    locala.hQF = new cph();
    locala.hQG = new cpi();
    locala.funcId = getType();
    locala.uri = "/cgi-bin/mmpay-bin/qryhpusererdetail";
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDS();
    ((cph)this.rr.hQD.hQJ).GSy = paramString;
    ae.i("MicroMsg.NetSceneQryHoneyUserDetail", "card no: %s", new Object[] { paramString });
    AppMethodBeat.o(64636);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(64637);
    ae.i("MicroMsg.NetSceneQryHoneyUserDetail", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.uRg = ((cpi)((b)paramq).hQE.hQJ);
    ae.i("MicroMsg.NetSceneQryHoneyUserDetail", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.uRg.oGt), this.uRg.oGu });
    if (this.uRg.GSz != null) {
      c.o(this.uRg.GSz.dFs, this.uRg.GSz.Ggo, this.uRg.GSz.dEJ, null);
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(64637);
  }
  
  public final void e(q paramq)
  {
    paramq = (cpi)((b)paramq).hQE.hQJ;
    this.LVj = paramq.oGt;
    this.LVk = paramq.oGu;
  }
  
  public final int getType()
  {
    return 2613;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.a.m
 * JD-Core Version:    0.7.0.1
 */