package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.coj;
import com.tencent.mm.protocal.protobuf.cok;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.c.r;

public final class k
  extends r
{
  private final String TAG;
  public cok uFr;
  
  public k(String paramString)
  {
    AppMethodBeat.i(64632);
    this.TAG = "MicroMsg.NetSceneQryHoneyPayCardDetail";
    b.a locala = new b.a();
    locala.hNM = new coj();
    locala.hNN = new cok();
    locala.funcId = getType();
    locala.uri = "/cgi-bin/mmpay-bin/qryhpcarddetail";
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDC();
    ((coj)this.rr.hNK.hNQ).GyY = paramString;
    AppMethodBeat.o(64632);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(64633);
    ad.i("MicroMsg.NetSceneQryHoneyPayCardDetail", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.uFr = ((cok)((b)paramq).hNL.hNQ);
    ad.i("MicroMsg.NetSceneQryHoneyPayCardDetail", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.uFr.ozR), this.uFr.ozS });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(64633);
  }
  
  public final void e(q paramq)
  {
    paramq = (cok)((b)paramq).hNL.hNQ;
    this.Lyu = paramq.ozR;
    this.Lyv = paramq.ozS;
  }
  
  public final int getType()
  {
    return 2851;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.a.k
 * JD-Core Version:    0.7.0.1
 */