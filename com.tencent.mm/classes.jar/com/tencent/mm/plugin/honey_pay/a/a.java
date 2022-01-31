package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ow;
import com.tencent.mm.protocal.c.ox;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.n;

public final class a
  extends n
{
  private final String TAG = "MicroMsg.NetSceneCheckHoneyPayer";
  public ox ljF;
  
  public a()
  {
    b.a locala = new b.a();
    locala.ecH = new ow();
    locala.ecI = new ox();
    locala.ecG = 2618;
    locala.uri = "/cgi-bin/mmpay-bin/checkhoneypayer";
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    y.i("MicroMsg.NetSceneCheckHoneyPayer", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.ljF = ((ox)((b)paramq).ecF.ecN);
    y.i("MicroMsg.NetSceneCheckHoneyPayer", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.ljF.ino), this.ljF.inp });
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
  }
  
  protected final void f(q paramq)
  {
    paramq = (ox)((b)paramq).ecF.ecN;
    this.wAx = paramq.ino;
    this.wAy = paramq.inp;
  }
  
  public final int getType()
  {
    return 2618;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.a.a
 * JD-Core Version:    0.7.0.1
 */