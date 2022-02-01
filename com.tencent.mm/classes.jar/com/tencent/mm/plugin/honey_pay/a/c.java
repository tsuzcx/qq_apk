package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.abu;
import com.tencent.mm.protocal.protobuf.abv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.c.r;

public final class c
  extends r
{
  private final String TAG;
  public abv uFi;
  
  public c(String paramString1, long paramLong, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    AppMethodBeat.i(64616);
    this.TAG = "MicroMsg.NetSceneCreateHoneyPayCard";
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new abu();
    ((b.a)localObject).hNN = new abv();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/createhoneypaycard";
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (abu)this.rr.hNK.hNQ;
    ((abu)localObject).Gbt = paramString1;
    ((abu)localObject).Gbu = paramLong;
    ((abu)localObject).FWt = paramString2;
    ((abu)localObject).FWx = paramString3;
    ((abu)localObject).mrl = paramInt;
    ((abu)localObject).vjr = paramString4;
    ad.d("MicroMsg.NetSceneCreateHoneyPayCard", "token: %s, take message: %s, wishing: %s", new Object[] { paramString1, paramString3, paramString4 });
    ad.i("MicroMsg.NetSceneCreateHoneyPayCard", "username: %s, credit line: %s", new Object[] { paramString2, Long.valueOf(paramLong) });
    AppMethodBeat.o(64616);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(64617);
    ad.i("MicroMsg.NetSceneCreateHoneyPayCard", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.uFi = ((abv)((b)paramq).hNL.hNQ);
    ad.i("MicroMsg.NetSceneCreateHoneyPayCard", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.uFi.ozR), this.uFi.ozS });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(64617);
  }
  
  public final void e(q paramq)
  {
    paramq = (abv)((b)paramq).hNL.hNQ;
    this.Lyu = paramq.ozR;
    this.Lyv = paramq.ozS;
  }
  
  public final int getType()
  {
    return 2662;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.a.c
 * JD-Core Version:    0.7.0.1
 */