package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.bci;
import com.tencent.mm.protocal.protobuf.bcj;
import com.tencent.mm.protocal.protobuf.rs;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.c.r;

public final class e
  extends r
{
  private final String TAG;
  public bcj uFk;
  
  public e(String paramString)
  {
    AppMethodBeat.i(64620);
    this.TAG = "MicroMsg.NetSceneGetHoneyPayCard";
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new bci();
    ((b.a)localObject).hNN = new bcj();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/gethpcard";
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (bci)this.rr.hNK.hNQ;
    ((bci)localObject).GyY = paramString;
    ((bci)localObject).Gxf = k.dos();
    ad.i("MicroMsg.NetSceneGetHoneyPayCard", "card no: %s", new Object[] { paramString });
    AppMethodBeat.o(64620);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(64621);
    ad.i("MicroMsg.NetSceneGetHoneyPayCard", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.uFk = ((bcj)((b)paramq).hNL.hNQ);
    ad.i("MicroMsg.NetSceneGetHoneyPayCard", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.uFk.ozR), this.uFk.ozS });
    if (this.uFk.GyZ != null) {
      c.o(this.uFk.GyZ.dEn, this.uFk.GyZ.FNP, this.uFk.GyZ.dDE, null);
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(64621);
  }
  
  public final void e(q paramq)
  {
    paramq = (bcj)((b)paramq).hNL.hNQ;
    this.Lyu = paramq.ozR;
    this.Lyv = paramq.ozS;
  }
  
  public final int getType()
  {
    return 1983;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.a.e
 * JD-Core Version:    0.7.0.1
 */