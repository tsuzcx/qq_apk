package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.xe;
import com.tencent.mm.protocal.protobuf.xf;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.wallet_core.c.r;

public final class b
  extends r
{
  private final String TAG;
  public xf uQU;
  public String username;
  
  public b(String paramString, int paramInt)
  {
    AppMethodBeat.i(64614);
    this.TAG = "MicroMsg.NetSceneCheckHoneyUser";
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new xe();
    ((b.a)localObject).hQG = new xf();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/checkhoneyuser";
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (xe)this.rr.hQD.hQJ;
    ((xe)localObject).GoS = paramString;
    ((xe)localObject).mwj = paramInt;
    this.username = paramString;
    AppMethodBeat.o(64614);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(64615);
    ae.i("MicroMsg.NetSceneCheckHoneyUser", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.uQU = ((xf)((com.tencent.mm.ak.b)paramq).hQE.hQJ);
    ae.i("MicroMsg.NetSceneCheckHoneyUser", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.uQU.oGt), this.uQU.oGu });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(64615);
  }
  
  public final void e(q paramq)
  {
    paramq = (xf)((com.tencent.mm.ak.b)paramq).hQE.hQJ;
    this.LVj = paramq.oGt;
    this.LVk = paramq.oGu;
  }
  
  public final int getType()
  {
    return 2926;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.a.b
 * JD-Core Version:    0.7.0.1
 */