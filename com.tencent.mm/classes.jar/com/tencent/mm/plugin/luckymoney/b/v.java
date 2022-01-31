package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aoe;
import com.tencent.mm.protocal.c.aof;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.n;

public final class v
  extends n
{
  public aof lRk;
  
  public v(String paramString1, String paramString2, String paramString3)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new aoe();
    ((b.a)localObject).ecI = new aof();
    ((b.a)localObject).ecG = 2929;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/ftfhb/businesscallbackwxhb";
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (aoe)this.dmK.ecE.ecN;
    ((aoe)localObject).lMg = paramString1;
    ((aoe)localObject).iGK = paramString2;
    ((aoe)localObject).lRH = paramString3;
    y.i("MicroMsg.NetSceneLuckyMoneyBusinessCallback", "sendId: %s, %s", new Object[] { paramString1, paramString3 });
  }
  
  protected final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    this.lRk = ((aof)((b)paramq).ecF.ecN);
    y.i("MicroMsg.NetSceneLuckyMoneyBusinessCallback", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.lRk.iHq), this.lRk.iHr });
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
  }
  
  protected final void f(q paramq)
  {
    paramq = (aof)((b)paramq).ecF.ecN;
    this.wAx = paramq.iHq;
    this.wAy = paramq.iHr;
  }
  
  public final int getType()
  {
    return 2929;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.b.v
 * JD-Core Version:    0.7.0.1
 */