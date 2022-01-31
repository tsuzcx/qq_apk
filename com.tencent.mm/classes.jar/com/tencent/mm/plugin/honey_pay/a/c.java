package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.vv;
import com.tencent.mm.protocal.protobuf.vw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.p;

public final class c
  extends p
{
  private final String TAG;
  public vw nHd;
  
  public c(String paramString1, long paramLong, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    AppMethodBeat.i(41721);
    this.TAG = "MicroMsg.NetSceneCreateHoneyPayCard";
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new vv();
    ((b.a)localObject).fsY = new vw();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/createhoneypaycard";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (vv)this.rr.fsV.fta;
    ((vv)localObject).wOx = paramString1;
    ((vv)localObject).wOy = paramLong;
    ((vv)localObject).wKl = paramString2;
    ((vv)localObject).wKp = paramString3;
    ((vv)localObject).iFL = paramInt;
    ((vv)localObject).oiG = paramString4;
    ab.d("MicroMsg.NetSceneCreateHoneyPayCard", "token: %s, take message: %s, wishing: %s", new Object[] { paramString1, paramString3, paramString4 });
    ab.i("MicroMsg.NetSceneCreateHoneyPayCard", "username: %s, credit line: %s", new Object[] { paramString2, Long.valueOf(paramLong) });
    AppMethodBeat.o(41721);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(41722);
    ab.i("MicroMsg.NetSceneCreateHoneyPayCard", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.nHd = ((vw)((b)paramq).fsW.fta);
    ab.i("MicroMsg.NetSceneCreateHoneyPayCard", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.nHd.koj), this.nHd.kok });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(41722);
  }
  
  public final void e(q paramq)
  {
    paramq = (vw)((b)paramq).fsW.fta;
    this.AXb = paramq.koj;
    this.AXc = paramq.kok;
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