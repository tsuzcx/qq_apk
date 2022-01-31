package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ahj;
import com.tencent.mm.protocal.c.ahk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.n;

public final class g
  extends n
{
  private final String TAG = "MicroMsg.NetSceneMCreditLineTokenSign";
  public ahk ljL;
  
  public g(String paramString, long paramLong)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new ahj();
    ((b.a)localObject).ecI = new ahk();
    ((b.a)localObject).ecG = 2815;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/gmcreditlinetoken";
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (ahj)this.dmK.ecE.ecN;
    ((ahj)localObject).tef = paramString;
    ((ahj)localObject).sQd = paramLong;
    y.i("MicroMsg.NetSceneMCreditLineTokenSign", "card_no: %s, credit_line: %s", new Object[] { paramString, Long.valueOf(paramLong) });
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    y.i("MicroMsg.NetSceneMCreditLineTokenSign", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.ljL = ((ahk)((b)paramq).ecF.ecN);
    y.i("MicroMsg.NetSceneMCreditLineTokenSign", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.ljL.ino), this.ljL.inp });
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
  }
  
  protected final void f(q paramq)
  {
    paramq = (ahk)((b)paramq).ecF.ecN;
    this.wAx = paramq.ino;
    this.wAy = paramq.inp;
  }
  
  public final int getType()
  {
    return 2815;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.a.g
 * JD-Core Version:    0.7.0.1
 */