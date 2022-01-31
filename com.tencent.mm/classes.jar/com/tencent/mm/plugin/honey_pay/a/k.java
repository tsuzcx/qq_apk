package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bhd;
import com.tencent.mm.protocal.c.bhe;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.n;

public final class k
  extends n
{
  private final String TAG = "MicroMsg.NetSceneQryHoneyPayCardDetail";
  public bhe ljQ;
  
  public k(String paramString)
  {
    b.a locala = new b.a();
    locala.ecH = new bhd();
    locala.ecI = new bhe();
    locala.ecG = 2851;
    locala.uri = "/cgi-bin/mmpay-bin/qryhpcarddetail";
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
    ((bhd)this.dmK.ecE.ecN).tef = paramString;
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    y.i("MicroMsg.NetSceneQryHoneyPayCardDetail", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.ljQ = ((bhe)((b)paramq).ecF.ecN);
    y.i("MicroMsg.NetSceneQryHoneyPayCardDetail", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.ljQ.ino), this.ljQ.inp });
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
  }
  
  protected final void f(q paramq)
  {
    paramq = (bhe)((b)paramq).ecF.ecN;
    this.wAx = paramq.ino;
    this.wAy = paramq.inp;
  }
  
  public final int getType()
  {
    return 2851;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.a.k
 * JD-Core Version:    0.7.0.1
 */