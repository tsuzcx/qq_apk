package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.aye;
import com.tencent.mm.protocal.protobuf.ayf;
import com.tencent.mm.protocal.protobuf.qb;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.wallet_core.c.r;

public final class e
  extends r
{
  private final String TAG;
  public ayf tCB;
  
  public e(String paramString)
  {
    AppMethodBeat.i(64620);
    this.TAG = "MicroMsg.NetSceneGetHoneyPayCard";
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new aye();
    ((b.a)localObject).hvu = new ayf();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/gethpcard";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (aye)this.rr.hvr.hvw;
    ((aye)localObject).EPH = paramString;
    ((aye)localObject).EOb = k.deU();
    ac.i("MicroMsg.NetSceneGetHoneyPayCard", "card no: %s", new Object[] { paramString });
    AppMethodBeat.o(64620);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(64621);
    ac.i("MicroMsg.NetSceneGetHoneyPayCard", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.tCB = ((ayf)((b)paramq).hvs.hvw);
    ac.i("MicroMsg.NetSceneGetHoneyPayCard", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.tCB.nWx), this.tCB.nWy });
    if (this.tCB.EPI != null) {
      c.p(this.tCB.EPI.dsu, this.tCB.EPI.EgJ, this.tCB.EPI.BZV, null);
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(64621);
  }
  
  public final void e(q paramq)
  {
    paramq = (ayf)((b)paramq).hvs.hvw;
    this.JFq = paramq.nWx;
    this.JFr = paramq.nWy;
  }
  
  public final int getType()
  {
    return 1983;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.a.e
 * JD-Core Version:    0.7.0.1
 */