package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cax;
import com.tencent.mm.protocal.protobuf.cay;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.c.r;

public final class i
  extends r
{
  private final String TAG;
  public int dDp;
  private cay uFp;
  
  public i(int paramInt)
  {
    AppMethodBeat.i(64628);
    this.TAG = "MicroMsg.NetSceneModifyHoneyPayerNotify";
    b.a locala = new b.a();
    locala.hNM = new cax();
    locala.hNN = new cay();
    locala.funcId = getType();
    locala.uri = "/cgi-bin/mmpay-bin/modifyhppayernotify";
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDC();
    ((cax)this.rr.hNK.hNQ).CIh = paramInt;
    this.dDp = paramInt;
    ad.i("MicroMsg.NetSceneModifyHoneyPayerNotify", "notify flag: %s", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(64628);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(64629);
    ad.i("MicroMsg.NetSceneModifyHoneyPayerNotify", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.uFp = ((cay)((b)paramq).hNL.hNQ);
    ad.i("MicroMsg.NetSceneModifyHoneyPayerNotify", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.uFp.ozR), this.uFp.ozS });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(64629);
  }
  
  public final void e(q paramq)
  {
    paramq = (cay)((b)paramq).hNL.hNQ;
    this.Lyu = paramq.ozR;
    this.Lyv = paramq.ozS;
  }
  
  public final int getType()
  {
    return 2742;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.a.i
 * JD-Core Version:    0.7.0.1
 */