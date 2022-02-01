package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.boj;
import com.tencent.mm.protocal.protobuf.bok;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.c.r;

public final class f
  extends r
{
  private final String TAG;
  public bok uFl;
  
  public f()
  {
    AppMethodBeat.i(64622);
    this.TAG = "MicroMsg.NetSceneHoneyPayerList";
    b.a locala = new b.a();
    locala.hNM = new boj();
    locala.hNN = new bok();
    locala.funcId = getType();
    locala.uri = "/cgi-bin/mmpay-bin/honeypayerlist";
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDC();
    AppMethodBeat.o(64622);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(64623);
    ad.i("MicroMsg.NetSceneHoneyPayerList", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.uFl = ((bok)((b)paramq).hNL.hNQ);
    ad.i("MicroMsg.NetSceneHoneyPayerList", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.uFl.ozR), this.uFl.ozS });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(64623);
  }
  
  public final void e(q paramq)
  {
    paramq = (bok)((b)paramq).hNL.hNQ;
    this.Lyu = paramq.ozR;
    this.Lyv = paramq.ozS;
  }
  
  public final int getType()
  {
    return 2725;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.a.f
 * JD-Core Version:    0.7.0.1
 */