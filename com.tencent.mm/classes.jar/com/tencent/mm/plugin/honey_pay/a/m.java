package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.protocal.protobuf.cjn;
import com.tencent.mm.protocal.protobuf.cjo;
import com.tencent.mm.protocal.protobuf.qb;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.wallet_core.c.r;

public final class m
  extends r
{
  private final String TAG;
  public cjo tCK;
  
  public m(String paramString)
  {
    AppMethodBeat.i(64636);
    this.TAG = "MicroMsg.NetSceneQryHoneyUserDetail";
    b.a locala = new b.a();
    locala.hvt = new cjn();
    locala.hvu = new cjo();
    locala.funcId = getType();
    locala.uri = "/cgi-bin/mmpay-bin/qryhpusererdetail";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    ((cjn)this.rr.hvr.hvw).EPH = paramString;
    ac.i("MicroMsg.NetSceneQryHoneyUserDetail", "card no: %s", new Object[] { paramString });
    AppMethodBeat.o(64636);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(64637);
    ac.i("MicroMsg.NetSceneQryHoneyUserDetail", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.tCK = ((cjo)((b)paramq).hvs.hvw);
    ac.i("MicroMsg.NetSceneQryHoneyUserDetail", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.tCK.nWx), this.tCK.nWy });
    if (this.tCK.EPI != null) {
      c.p(this.tCK.EPI.dsu, this.tCK.EPI.EgJ, this.tCK.EPI.BZV, null);
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(64637);
  }
  
  public final void e(q paramq)
  {
    paramq = (cjo)((b)paramq).hvs.hvw;
    this.JFq = paramq.nWx;
    this.JFr = paramq.nWy;
  }
  
  public final int getType()
  {
    return 2613;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.a.m
 * JD-Core Version:    0.7.0.1
 */