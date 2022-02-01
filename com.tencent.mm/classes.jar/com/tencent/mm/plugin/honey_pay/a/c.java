package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.acd;
import com.tencent.mm.protocal.protobuf.ace;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.wallet_core.c.r;

public final class c
  extends r
{
  private final String TAG;
  public ace uQV;
  
  public c(String paramString1, long paramLong, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    AppMethodBeat.i(64616);
    this.TAG = "MicroMsg.NetSceneCreateHoneyPayCard";
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new acd();
    ((b.a)localObject).hQG = new ace();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/createhoneypaycard";
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (acd)this.rr.hQD.hQJ;
    ((acd)localObject).Gua = paramString1;
    ((acd)localObject).Gub = paramLong;
    ((acd)localObject).GoS = paramString2;
    ((acd)localObject).GoW = paramString3;
    ((acd)localObject).mwj = paramInt;
    ((acd)localObject).vvw = paramString4;
    ae.d("MicroMsg.NetSceneCreateHoneyPayCard", "token: %s, take message: %s, wishing: %s", new Object[] { paramString1, paramString3, paramString4 });
    ae.i("MicroMsg.NetSceneCreateHoneyPayCard", "username: %s, credit line: %s", new Object[] { paramString2, Long.valueOf(paramLong) });
    AppMethodBeat.o(64616);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(64617);
    ae.i("MicroMsg.NetSceneCreateHoneyPayCard", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.uQV = ((ace)((b)paramq).hQE.hQJ);
    ae.i("MicroMsg.NetSceneCreateHoneyPayCard", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.uQV.oGt), this.uQV.oGu });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(64617);
  }
  
  public final void e(q paramq)
  {
    paramq = (ace)((b)paramq).hQE.hQJ;
    this.LVj = paramq.oGt;
    this.LVk = paramq.oGu;
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