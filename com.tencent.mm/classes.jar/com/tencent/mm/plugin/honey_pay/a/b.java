package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.vc;
import com.tencent.mm.protocal.protobuf.vd;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.wallet_core.c.r;

public final class b
  extends r
{
  private final String TAG;
  public vd tCy;
  public String username;
  
  public b(String paramString, int paramInt)
  {
    AppMethodBeat.i(64614);
    this.TAG = "MicroMsg.NetSceneCheckHoneyUser";
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new vc();
    ((b.a)localObject).hvu = new vd();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/checkhoneyuser";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (vc)this.rr.hvr.hvw;
    ((vc)localObject).Eph = paramString;
    ((vc)localObject).lRv = paramInt;
    this.username = paramString;
    AppMethodBeat.o(64614);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(64615);
    ac.i("MicroMsg.NetSceneCheckHoneyUser", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.tCy = ((vd)((com.tencent.mm.ak.b)paramq).hvs.hvw);
    ac.i("MicroMsg.NetSceneCheckHoneyUser", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.tCy.nWx), this.tCy.nWy });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(64615);
  }
  
  public final void e(q paramq)
  {
    paramq = (vd)((com.tencent.mm.ak.b)paramq).hvs.hvw;
    this.JFq = paramq.nWx;
    this.JFr = paramq.nWy;
  }
  
  public final int getType()
  {
    return 2926;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.a.b
 * JD-Core Version:    0.7.0.1
 */