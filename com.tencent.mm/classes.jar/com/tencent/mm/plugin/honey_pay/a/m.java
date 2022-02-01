package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.protocal.protobuf.con;
import com.tencent.mm.protocal.protobuf.coo;
import com.tencent.mm.protocal.protobuf.rs;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.c.r;

public final class m
  extends r
{
  private final String TAG;
  public coo uFt;
  
  public m(String paramString)
  {
    AppMethodBeat.i(64636);
    this.TAG = "MicroMsg.NetSceneQryHoneyUserDetail";
    b.a locala = new b.a();
    locala.hNM = new con();
    locala.hNN = new coo();
    locala.funcId = getType();
    locala.uri = "/cgi-bin/mmpay-bin/qryhpusererdetail";
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDC();
    ((con)this.rr.hNK.hNQ).GyY = paramString;
    ad.i("MicroMsg.NetSceneQryHoneyUserDetail", "card no: %s", new Object[] { paramString });
    AppMethodBeat.o(64636);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(64637);
    ad.i("MicroMsg.NetSceneQryHoneyUserDetail", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.uFt = ((coo)((b)paramq).hNL.hNQ);
    ad.i("MicroMsg.NetSceneQryHoneyUserDetail", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.uFt.ozR), this.uFt.ozS });
    if (this.uFt.GyZ != null) {
      c.o(this.uFt.GyZ.dEn, this.uFt.GyZ.FNP, this.uFt.GyZ.dDE, null);
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(64637);
  }
  
  public final void e(q paramq)
  {
    paramq = (coo)((b)paramq).hNL.hNQ;
    this.Lyu = paramq.ozR;
    this.Lyv = paramq.ozS;
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