package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.oy;
import com.tencent.mm.protocal.c.oz;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.n;

public final class b
  extends n
{
  private final String TAG = "MicroMsg.NetSceneCheckHoneyUser";
  public oz ljG;
  public String username;
  
  public b(String paramString, int paramInt)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new oy();
    ((b.a)localObject).ecI = new oz();
    ((b.a)localObject).ecG = 2926;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/checkhoneyuser";
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (oy)this.dmK.ecE.ecN;
    ((oy)localObject).sMy = paramString;
    ((oy)localObject).ilo = paramInt;
    this.username = paramString;
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    y.i("MicroMsg.NetSceneCheckHoneyUser", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.ljG = ((oz)((com.tencent.mm.ah.b)paramq).ecF.ecN);
    y.i("MicroMsg.NetSceneCheckHoneyUser", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.ljG.ino), this.ljG.inp });
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
  }
  
  protected final void f(q paramq)
  {
    paramq = (oz)((com.tencent.mm.ah.b)paramq).ecF.ecN;
    this.wAx = paramq.ino;
    this.wAy = paramq.inp;
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