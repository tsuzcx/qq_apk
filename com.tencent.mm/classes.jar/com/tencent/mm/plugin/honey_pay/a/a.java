package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.va;
import com.tencent.mm.protocal.protobuf.vb;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.wallet_core.c.r;

public final class a
  extends r
{
  private final String TAG;
  public vb tCx;
  
  public a()
  {
    AppMethodBeat.i(64612);
    this.TAG = "MicroMsg.NetSceneCheckHoneyPayer";
    b.a locala = new b.a();
    locala.hvt = new va();
    locala.hvu = new vb();
    locala.funcId = getType();
    locala.uri = "/cgi-bin/mmpay-bin/checkhoneypayer";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    AppMethodBeat.o(64612);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(64613);
    ac.i("MicroMsg.NetSceneCheckHoneyPayer", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.tCx = ((vb)((b)paramq).hvs.hvw);
    ac.i("MicroMsg.NetSceneCheckHoneyPayer", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.tCx.nWx), this.tCx.nWy });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(64613);
  }
  
  public final void e(q paramq)
  {
    paramq = (vb)((b)paramq).hvs.hvw;
    this.JFq = paramq.nWx;
    this.JFr = paramq.nWy;
  }
  
  public final int getType()
  {
    return 2618;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.a.a
 * JD-Core Version:    0.7.0.1
 */