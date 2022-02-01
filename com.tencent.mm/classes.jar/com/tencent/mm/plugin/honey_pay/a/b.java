package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.us;
import com.tencent.mm.protocal.protobuf.ut;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.c.r;

public final class b
  extends r
{
  private final String TAG;
  public ut suJ;
  public String username;
  
  public b(String paramString, int paramInt)
  {
    AppMethodBeat.i(64614);
    this.TAG = "MicroMsg.NetSceneCheckHoneyUser";
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new us();
    ((b.a)localObject).gUV = new ut();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/checkhoneyuser";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (us)this.rr.gUS.gUX;
    ((us)localObject).CWy = paramString;
    ((us)localObject).lpz = paramInt;
    this.username = paramString;
    AppMethodBeat.o(64614);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(64615);
    ad.i("MicroMsg.NetSceneCheckHoneyUser", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.suJ = ((ut)((com.tencent.mm.al.b)paramq).gUT.gUX);
    ad.i("MicroMsg.NetSceneCheckHoneyUser", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.suJ.ntx), this.suJ.nty });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(64615);
  }
  
  public final void e(q paramq)
  {
    paramq = (ut)((com.tencent.mm.al.b)paramq).gUT.gUX;
    this.IdO = paramq.ntx;
    this.IdP = paramq.nty;
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