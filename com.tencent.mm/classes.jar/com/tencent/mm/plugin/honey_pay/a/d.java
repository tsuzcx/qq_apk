package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.avy;
import com.tencent.mm.protocal.protobuf.avz;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.wallet_core.c.r;

public final class d
  extends r
{
  private final String TAG;
  public avz tCA;
  
  public d(String paramString, long paramLong)
  {
    AppMethodBeat.i(64618);
    this.TAG = "MicroMsg.NetSceneGetCreateTokenSign";
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new avy();
    ((b.a)localObject).hvu = new avz();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/createhpcardtoken";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (avy)this.rr.hvr.hvw;
    ((avy)localObject).Epl = paramString;
    ((avy)localObject).Eub = paramLong;
    ((avy)localObject).EOb = k.deU();
    ac.i("MicroMsg.NetSceneGetCreateTokenSign", "take_message: %s, credit_line: %s", new Object[] { paramString, Long.valueOf(paramLong) });
    AppMethodBeat.o(64618);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(64619);
    ac.i("MicroMsg.NetSceneGetCreateTokenSign", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.tCA = ((avz)((b)paramq).hvs.hvw);
    ac.i("MicroMsg.NetSceneGetCreateTokenSign", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.tCA.nWx), this.tCA.nWy });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(64619);
  }
  
  public final void e(q paramq)
  {
    paramq = (avz)((b)paramq).hvs.hvw;
    this.JFq = paramq.nWx;
    this.JFr = paramq.nWy;
  }
  
  public final int getType()
  {
    return 2630;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.a.d
 * JD-Core Version:    0.7.0.1
 */