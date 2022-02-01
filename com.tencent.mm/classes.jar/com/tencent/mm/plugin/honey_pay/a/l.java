package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.protocal.protobuf.col;
import com.tencent.mm.protocal.protobuf.com;
import com.tencent.mm.protocal.protobuf.rs;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.c.r;

public final class l
  extends r
{
  private final String TAG;
  public com uFs;
  
  public l(String paramString)
  {
    AppMethodBeat.i(64634);
    this.TAG = "MicroMsg.NetSceneQryHoneyPayerDetail";
    b.a locala = new b.a();
    locala.hNM = new col();
    locala.hNN = new com();
    locala.funcId = getType();
    locala.uri = "/cgi-bin/mmpay-bin/qryhppayerdetail";
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDC();
    ((col)this.rr.hNK.hNQ).GyY = paramString;
    ad.i("MicroMsg.NetSceneQryHoneyPayerDetail", "card no: %s", new Object[] { paramString });
    AppMethodBeat.o(64634);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(64635);
    ad.i("MicroMsg.NetSceneQryHoneyPayerDetail", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.uFs = ((com)((b)paramq).hNL.hNQ);
    ad.i("MicroMsg.NetSceneQryHoneyPayerDetail", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.uFs.ozR), this.uFs.ozS });
    if (this.uFs.GyZ != null) {
      c.o(this.uFs.GyZ.dEn, this.uFs.GyZ.FNP, this.uFs.GyZ.dDE, null);
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(64635);
  }
  
  public final void e(q paramq)
  {
    paramq = (com)((b)paramq).hNL.hNQ;
    this.Lyu = paramq.ozR;
    this.Lyv = paramq.ozS;
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