package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.asu;
import com.tencent.mm.protocal.protobuf.asv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.c.r;

public final class d
  extends r
{
  private final String TAG;
  public asv suL;
  
  public d(String paramString, long paramLong)
  {
    AppMethodBeat.i(64618);
    this.TAG = "MicroMsg.NetSceneGetCreateTokenSign";
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new asu();
    ((b.a)localObject).gUV = new asv();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/createhpcardtoken";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (asu)this.rr.gUS.gUX;
    ((asu)localObject).CWC = paramString;
    ((asu)localObject).Dbe = paramLong;
    ((asu)localObject).DsX = k.cRk();
    ad.i("MicroMsg.NetSceneGetCreateTokenSign", "take_message: %s, credit_line: %s", new Object[] { paramString, Long.valueOf(paramLong) });
    AppMethodBeat.o(64618);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(64619);
    ad.i("MicroMsg.NetSceneGetCreateTokenSign", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.suL = ((asv)((b)paramq).gUT.gUX);
    ad.i("MicroMsg.NetSceneGetCreateTokenSign", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.suL.ntx), this.suL.nty });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(64619);
  }
  
  public final void e(q paramq)
  {
    paramq = (asv)((b)paramq).gUT.gUX;
    this.IdO = paramq.ntx;
    this.IdP = paramq.nty;
  }
  
  public final int getType()
  {
    return 2630;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.a.d
 * JD-Core Version:    0.7.0.1
 */