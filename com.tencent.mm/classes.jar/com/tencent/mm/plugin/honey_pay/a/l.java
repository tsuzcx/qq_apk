package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.protocal.protobuf.cjm;
import com.tencent.mm.protocal.protobuf.qb;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.wallet_core.c.r;

public final class l
  extends r
{
  private final String TAG;
  public cjm tCJ;
  
  public l(String paramString)
  {
    AppMethodBeat.i(64634);
    this.TAG = "MicroMsg.NetSceneQryHoneyPayerDetail";
    b.a locala = new b.a();
    locala.hvt = new cjl();
    locala.hvu = new cjm();
    locala.funcId = getType();
    locala.uri = "/cgi-bin/mmpay-bin/qryhppayerdetail";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    ((cjl)this.rr.hvr.hvw).EPH = paramString;
    ac.i("MicroMsg.NetSceneQryHoneyPayerDetail", "card no: %s", new Object[] { paramString });
    AppMethodBeat.o(64634);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(64635);
    ac.i("MicroMsg.NetSceneQryHoneyPayerDetail", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.tCJ = ((cjm)((b)paramq).hvs.hvw);
    ac.i("MicroMsg.NetSceneQryHoneyPayerDetail", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.tCJ.nWx), this.tCJ.nWy });
    if (this.tCJ.EPI != null) {
      c.p(this.tCJ.EPI.dsu, this.tCJ.EPI.EgJ, this.tCJ.EPI.BZV, null);
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(64635);
  }
  
  public final void e(q paramq)
  {
    paramq = (cjm)((b)paramq).hvs.hvw;
    this.JFq = paramq.nWx;
    this.JFr = paramq.nWy;
  }
  
  public final int getType()
  {
    return 2876;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.a.l
 * JD-Core Version:    0.7.0.1
 */