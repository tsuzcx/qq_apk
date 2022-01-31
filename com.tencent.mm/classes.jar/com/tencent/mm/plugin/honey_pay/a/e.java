package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.plugin.wallet_core.model.i;
import com.tencent.mm.protocal.c.agn;
import com.tencent.mm.protocal.c.ago;
import com.tencent.mm.protocal.c.lb;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.n;

public final class e
  extends n
{
  private final String TAG = "MicroMsg.NetSceneGetHoneyPayCard";
  public ago ljJ;
  
  public e(String paramString)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new agn();
    ((b.a)localObject).ecI = new ago();
    ((b.a)localObject).ecG = 1983;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/gethpcard";
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (agn)this.dmK.ecE.ecN;
    ((agn)localObject).tef = paramString;
    ((agn)localObject).tcE = i.bkn();
    y.i("MicroMsg.NetSceneGetHoneyPayCard", "card no: %s", new Object[] { paramString });
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    y.i("MicroMsg.NetSceneGetHoneyPayCard", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.ljJ = ((ago)((b)paramq).ecF.ecN);
    y.i("MicroMsg.NetSceneGetHoneyPayCard", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.ljJ.ino), this.ljJ.inp });
    if (this.ljJ.teg != null) {
      c.P(this.ljJ.teg.bWt, this.ljJ.teg.sGi, this.ljJ.teg.qVr);
    }
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
  }
  
  protected final void f(q paramq)
  {
    paramq = (ago)((b)paramq).ecF.ecN;
    this.wAx = paramq.ino;
    this.wAy = paramq.inp;
  }
  
  public final int getType()
  {
    return 1983;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.a.e
 * JD-Core Version:    0.7.0.1
 */