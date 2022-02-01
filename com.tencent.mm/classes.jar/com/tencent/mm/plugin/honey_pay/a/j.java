package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bwj;
import com.tencent.mm.protocal.protobuf.bwk;
import com.tencent.mm.protocal.protobuf.cfe;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.wallet_core.c.r;

public final class j
  extends r
{
  private final String TAG;
  public bwk tCH;
  
  public j(cfe paramcfe, String paramString)
  {
    AppMethodBeat.i(64630);
    this.TAG = "MicroMsg.NetSceneModifyHoneyPayerPayWay";
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new bwj();
    ((b.a)localObject).hvu = new bwk();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/modifyhppayerpayway";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (bwj)this.rr.hvr.hvw;
    ((bwj)localObject).EZJ = paramcfe;
    ((bwj)localObject).EPH = paramString;
    ac.i("MicroMsg.NetSceneModifyHoneyPayerPayWay", "cardNo: %s, suffix: %s, bankType: %s", new Object[] { paramString, paramcfe.FtE, paramcfe.cZz });
    AppMethodBeat.o(64630);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(64631);
    ac.i("MicroMsg.NetSceneModifyHoneyPayerPayWay", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.tCH = ((bwk)((b)paramq).hvs.hvw);
    ac.i("MicroMsg.NetSceneModifyHoneyPayerPayWay", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.tCH.nWx), this.tCH.nWy });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(64631);
  }
  
  public final void e(q paramq)
  {
    paramq = (bwk)((b)paramq).hvs.hvw;
    this.JFq = paramq.nWx;
    this.JFr = paramq.nWy;
  }
  
  public final int getType()
  {
    return 2941;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.a.j
 * JD-Core Version:    0.7.0.1
 */