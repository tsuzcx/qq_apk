package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bdv;
import com.tencent.mm.protocal.protobuf.bdw;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.c.r;

public final class g
  extends r
{
  private final String TAG;
  public bdw uFm;
  
  public g(String paramString, long paramLong)
  {
    AppMethodBeat.i(64624);
    this.TAG = "MicroMsg.NetSceneMCreditLineTokenSign";
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new bdv();
    ((b.a)localObject).hNN = new bdw();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/gmcreditlinetoken";
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (bdv)this.rr.hNK.hNQ;
    ((bdv)localObject).GyY = paramString;
    ((bdv)localObject).Gbu = paramLong;
    ad.i("MicroMsg.NetSceneMCreditLineTokenSign", "card_no: %s, credit_line: %s", new Object[] { paramString, Long.valueOf(paramLong) });
    AppMethodBeat.o(64624);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(64625);
    ad.i("MicroMsg.NetSceneMCreditLineTokenSign", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.uFm = ((bdw)((b)paramq).hNL.hNQ);
    ad.i("MicroMsg.NetSceneMCreditLineTokenSign", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.uFm.ozR), this.uFm.ozS });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(64625);
  }
  
  public final void e(q paramq)
  {
    paramq = (bdw)((b)paramq).hNL.hNQ;
    this.Lyu = paramq.ozR;
    this.Lyv = paramq.ozS;
  }
  
  public final int getType()
  {
    return 2815;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.a.g
 * JD-Core Version:    0.7.0.1
 */