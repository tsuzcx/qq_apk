package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.protocal.c.bhf;
import com.tencent.mm.protocal.c.bhg;
import com.tencent.mm.protocal.c.lb;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.n;

public final class l
  extends n
{
  private final String TAG = "MicroMsg.NetSceneQryHoneyPayerDetail";
  public bhg ljR;
  
  public l(String paramString)
  {
    b.a locala = new b.a();
    locala.ecH = new bhf();
    locala.ecI = new bhg();
    locala.ecG = 2876;
    locala.uri = "/cgi-bin/mmpay-bin/qryhppayerdetail";
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
    ((bhf)this.dmK.ecE.ecN).tef = paramString;
    y.i("MicroMsg.NetSceneQryHoneyPayerDetail", "card no: %s", new Object[] { paramString });
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    y.i("MicroMsg.NetSceneQryHoneyPayerDetail", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.ljR = ((bhg)((b)paramq).ecF.ecN);
    y.i("MicroMsg.NetSceneQryHoneyPayerDetail", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.ljR.ino), this.ljR.inp });
    if (this.ljR.teg != null) {
      c.P(this.ljR.teg.bWt, this.ljR.teg.sGi, this.ljR.teg.qVr);
    }
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
  }
  
  protected final void f(q paramq)
  {
    paramq = (bhg)((b)paramq).ecF.ecN;
    this.wAx = paramq.ino;
    this.wAy = paramq.inp;
  }
  
  public final int getType()
  {
    return 2876;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.a.l
 * JD-Core Version:    0.7.0.1
 */