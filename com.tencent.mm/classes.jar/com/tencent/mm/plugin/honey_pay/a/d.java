package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.bam;
import com.tencent.mm.protocal.protobuf.ban;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.wallet_core.c.r;

public final class d
  extends r
{
  private final String TAG;
  public ban uQW;
  
  public d(String paramString, long paramLong)
  {
    AppMethodBeat.i(64618);
    this.TAG = "MicroMsg.NetSceneGetCreateTokenSign";
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new bam();
    ((b.a)localObject).hQG = new ban();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/createhpcardtoken";
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (bam)this.rr.hQD.hQJ;
    ((bam)localObject).GoW = paramString;
    ((bam)localObject).Gub = paramLong;
    ((bam)localObject).GQF = k.drq();
    ae.i("MicroMsg.NetSceneGetCreateTokenSign", "take_message: %s, credit_line: %s", new Object[] { paramString, Long.valueOf(paramLong) });
    AppMethodBeat.o(64618);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(64619);
    ae.i("MicroMsg.NetSceneGetCreateTokenSign", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.uQW = ((ban)((b)paramq).hQE.hQJ);
    ae.i("MicroMsg.NetSceneGetCreateTokenSign", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.uQW.oGt), this.uQW.oGu });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(64619);
  }
  
  public final void e(q paramq)
  {
    paramq = (ban)((b)paramq).hQE.hQJ;
    this.LVj = paramq.oGt;
    this.LVk = paramq.oGu;
  }
  
  public final int getType()
  {
    return 2630;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.a.d
 * JD-Core Version:    0.7.0.1
 */