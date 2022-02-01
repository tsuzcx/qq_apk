package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.xb;
import com.tencent.mm.protocal.protobuf.xc;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.c.r;

public final class b
  extends r
{
  private final String TAG;
  public xc uFh;
  public String username;
  
  public b(String paramString, int paramInt)
  {
    AppMethodBeat.i(64614);
    this.TAG = "MicroMsg.NetSceneCheckHoneyUser";
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new xb();
    ((b.a)localObject).hNN = new xc();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/checkhoneyuser";
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (xb)this.rr.hNK.hNQ;
    ((xb)localObject).FWt = paramString;
    ((xb)localObject).mrl = paramInt;
    this.username = paramString;
    AppMethodBeat.o(64614);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(64615);
    ad.i("MicroMsg.NetSceneCheckHoneyUser", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.uFh = ((xc)((com.tencent.mm.al.b)paramq).hNL.hNQ);
    ad.i("MicroMsg.NetSceneCheckHoneyUser", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.uFh.ozR), this.uFh.ozS });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(64615);
  }
  
  public final void e(q paramq)
  {
    paramq = (xc)((com.tencent.mm.al.b)paramq).hNL.hNQ;
    this.Lyu = paramq.ozR;
    this.Lyv = paramq.ozS;
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