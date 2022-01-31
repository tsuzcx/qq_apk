package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.avc;
import com.tencent.mm.protocal.protobuf.avd;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.p;

public final class f
  extends p
{
  private final String TAG;
  public avd nHg;
  
  public f()
  {
    AppMethodBeat.i(41727);
    this.TAG = "MicroMsg.NetSceneHoneyPayerList";
    b.a locala = new b.a();
    locala.fsX = new avc();
    locala.fsY = new avd();
    locala.funcId = getType();
    locala.uri = "/cgi-bin/mmpay-bin/honeypayerlist";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.ado();
    AppMethodBeat.o(41727);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(41728);
    ab.i("MicroMsg.NetSceneHoneyPayerList", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.nHg = ((avd)((b)paramq).fsW.fta);
    ab.i("MicroMsg.NetSceneHoneyPayerList", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.nHg.koj), this.nHg.kok });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(41728);
  }
  
  public final void e(q paramq)
  {
    paramq = (avd)((b)paramq).fsW.fta;
    this.AXb = paramq.koj;
    this.AXc = paramq.kok;
  }
  
  public final int getType()
  {
    return 2725;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.a.f
 * JD-Core Version:    0.7.0.1
 */