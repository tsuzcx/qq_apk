package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.wz;
import com.tencent.mm.protocal.protobuf.xa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.c.r;

public final class a
  extends r
{
  private final String TAG;
  public xa uFg;
  
  public a()
  {
    AppMethodBeat.i(64612);
    this.TAG = "MicroMsg.NetSceneCheckHoneyPayer";
    b.a locala = new b.a();
    locala.hNM = new wz();
    locala.hNN = new xa();
    locala.funcId = getType();
    locala.uri = "/cgi-bin/mmpay-bin/checkhoneypayer";
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDC();
    AppMethodBeat.o(64612);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(64613);
    ad.i("MicroMsg.NetSceneCheckHoneyPayer", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.uFg = ((xa)((b)paramq).hNL.hNQ);
    ad.i("MicroMsg.NetSceneCheckHoneyPayer", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.uFg.ozR), this.uFg.ozS });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(64613);
  }
  
  public final void e(q paramq)
  {
    paramq = (xa)((b)paramq).hNL.hNQ;
    this.Lyu = paramq.ozR;
    this.Lyv = paramq.ozS;
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