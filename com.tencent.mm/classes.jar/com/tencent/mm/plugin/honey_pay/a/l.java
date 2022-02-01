package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.protocal.protobuf.cpf;
import com.tencent.mm.protocal.protobuf.cpg;
import com.tencent.mm.protocal.protobuf.ru;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.wallet_core.c.r;

public final class l
  extends r
{
  private final String TAG;
  public cpg uRf;
  
  public l(String paramString)
  {
    AppMethodBeat.i(64634);
    this.TAG = "MicroMsg.NetSceneQryHoneyPayerDetail";
    b.a locala = new b.a();
    locala.hQF = new cpf();
    locala.hQG = new cpg();
    locala.funcId = getType();
    locala.uri = "/cgi-bin/mmpay-bin/qryhppayerdetail";
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDS();
    ((cpf)this.rr.hQD.hQJ).GSy = paramString;
    ae.i("MicroMsg.NetSceneQryHoneyPayerDetail", "card no: %s", new Object[] { paramString });
    AppMethodBeat.o(64634);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(64635);
    ae.i("MicroMsg.NetSceneQryHoneyPayerDetail", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.uRf = ((cpg)((b)paramq).hQE.hQJ);
    ae.i("MicroMsg.NetSceneQryHoneyPayerDetail", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.uRf.oGt), this.uRf.oGu });
    if (this.uRf.GSz != null) {
      c.o(this.uRf.GSz.dFs, this.uRf.GSz.Ggo, this.uRf.GSz.dEJ, null);
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(64635);
  }
  
  public final void e(q paramq)
  {
    paramq = (cpg)((b)paramq).hQE.hQJ;
    this.LVj = paramq.oGt;
    this.LVk = paramq.oGu;
  }
  
  public final int getType()
  {
    return 2876;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.a.l
 * JD-Core Version:    0.7.0.1
 */