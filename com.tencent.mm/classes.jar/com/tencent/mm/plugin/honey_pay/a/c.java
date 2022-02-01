package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.zu;
import com.tencent.mm.protocal.protobuf.zv;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.wallet_core.c.r;

public final class c
  extends r
{
  private final String TAG;
  public zv tCz;
  
  public c(String paramString1, long paramLong, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    AppMethodBeat.i(64616);
    this.TAG = "MicroMsg.NetSceneCreateHoneyPayCard";
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new zu();
    ((b.a)localObject).hvu = new zv();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/createhoneypaycard";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (zu)this.rr.hvr.hvw;
    ((zu)localObject).Eua = paramString1;
    ((zu)localObject).Eub = paramLong;
    ((zu)localObject).Eph = paramString2;
    ((zu)localObject).Epl = paramString3;
    ((zu)localObject).lRv = paramInt;
    ((zu)localObject).ugH = paramString4;
    ac.d("MicroMsg.NetSceneCreateHoneyPayCard", "token: %s, take message: %s, wishing: %s", new Object[] { paramString1, paramString3, paramString4 });
    ac.i("MicroMsg.NetSceneCreateHoneyPayCard", "username: %s, credit line: %s", new Object[] { paramString2, Long.valueOf(paramLong) });
    AppMethodBeat.o(64616);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(64617);
    ac.i("MicroMsg.NetSceneCreateHoneyPayCard", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.tCz = ((zv)((b)paramq).hvs.hvw);
    ac.i("MicroMsg.NetSceneCreateHoneyPayCard", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.tCz.nWx), this.tCz.nWy });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(64617);
  }
  
  public final void e(q paramq)
  {
    paramq = (zv)((b)paramq).hvs.hvw;
    this.JFq = paramq.nWx;
    this.JFr = paramq.nWy;
  }
  
  public final int getType()
  {
    return 2662;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.a.c
 * JD-Core Version:    0.7.0.1
 */