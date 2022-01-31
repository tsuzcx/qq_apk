package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.model.i;
import com.tencent.mm.protocal.c.aen;
import com.tencent.mm.protocal.c.aeo;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.n;

public final class d
  extends n
{
  private final String TAG = "MicroMsg.NetSceneGetCreateTokenSign";
  public aeo ljI;
  
  public d(String paramString, long paramLong)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new aen();
    ((b.a)localObject).ecI = new aeo();
    ((b.a)localObject).ecG = 2630;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/createhpcardtoken";
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (aen)this.dmK.ecE.ecN;
    ((aen)localObject).sMC = paramString;
    ((aen)localObject).sQd = paramLong;
    ((aen)localObject).tcE = i.bkn();
    y.i("MicroMsg.NetSceneGetCreateTokenSign", "take_message: %s, credit_line: %s", new Object[] { paramString, Long.valueOf(paramLong) });
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    y.i("MicroMsg.NetSceneGetCreateTokenSign", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.ljI = ((aeo)((b)paramq).ecF.ecN);
    y.i("MicroMsg.NetSceneGetCreateTokenSign", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.ljI.ino), this.ljI.inp });
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
  }
  
  protected final void f(q paramq)
  {
    paramq = (aeo)((b)paramq).ecF.ecN;
    this.wAx = paramq.ino;
    this.wAy = paramq.inp;
  }
  
  public final int getType()
  {
    return 2630;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.a.d
 * JD-Core Version:    0.7.0.1
 */