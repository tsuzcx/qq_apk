package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.xc;
import com.tencent.mm.protocal.protobuf.xd;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.wallet_core.c.r;

public final class a
  extends r
{
  private final String TAG;
  public xd uQT;
  
  public a()
  {
    AppMethodBeat.i(64612);
    this.TAG = "MicroMsg.NetSceneCheckHoneyPayer";
    b.a locala = new b.a();
    locala.hQF = new xc();
    locala.hQG = new xd();
    locala.funcId = getType();
    locala.uri = "/cgi-bin/mmpay-bin/checkhoneypayer";
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDS();
    AppMethodBeat.o(64612);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(64613);
    ae.i("MicroMsg.NetSceneCheckHoneyPayer", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.uQT = ((xd)((b)paramq).hQE.hQJ);
    ae.i("MicroMsg.NetSceneCheckHoneyPayer", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.uQT.oGt), this.uQT.oGu });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(64613);
  }
  
  public final void e(q paramq)
  {
    paramq = (xd)((b)paramq).hQE.hQJ;
    this.LVj = paramq.oGt;
    this.LVk = paramq.oGu;
  }
  
  public final int getType()
  {
    return 2618;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.a.a
 * JD-Core Version:    0.7.0.1
 */