package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.protocal.c.bhh;
import com.tencent.mm.protocal.c.bhi;
import com.tencent.mm.protocal.c.lb;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.n;

public final class m
  extends n
{
  private final String TAG = "MicroMsg.NetSceneQryHoneyUserDetail";
  public bhi ljS;
  
  public m(String paramString)
  {
    b.a locala = new b.a();
    locala.ecH = new bhh();
    locala.ecI = new bhi();
    locala.ecG = 2613;
    locala.uri = "/cgi-bin/mmpay-bin/qryhpusererdetail";
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
    ((bhh)this.dmK.ecE.ecN).tef = paramString;
    y.i("MicroMsg.NetSceneQryHoneyUserDetail", "card no: %s", new Object[] { paramString });
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    y.i("MicroMsg.NetSceneQryHoneyUserDetail", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.ljS = ((bhi)((b)paramq).ecF.ecN);
    y.i("MicroMsg.NetSceneQryHoneyUserDetail", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.ljS.ino), this.ljS.inp });
    if (this.ljS.teg != null) {
      c.P(this.ljS.teg.bWt, this.ljS.teg.sGi, this.ljS.teg.qVr);
    }
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
  }
  
  protected final void f(q paramq)
  {
    paramq = (bhi)((b)paramq).ecF.ecN;
    this.wAx = paramq.ino;
    this.wAy = paramq.inp;
  }
  
  public final int getType()
  {
    return 2613;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.a.m
 * JD-Core Version:    0.7.0.1
 */