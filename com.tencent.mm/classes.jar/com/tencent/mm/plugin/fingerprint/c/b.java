package com.tencent.mm.plugin.fingerprint.c;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.soter.b.d;
import com.tencent.mm.protocal.c.bva;
import com.tencent.mm.protocal.c.bvb;
import com.tencent.mm.sdk.platformtools.y;
import com.tenpay.android.wechat.TenpayUtil;

public final class b
  extends d
  implements com.tencent.mm.network.k
{
  public final com.tencent.mm.ah.b dmK;
  private f dmL;
  private int type;
  
  public b(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new bva();
    ((b.a)localObject).ecI = new bvb();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/soteropenfppayment";
    ((b.a)localObject).ecG = 1638;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (bva)this.dmK.ecE.ecN;
    ((bva)localObject).txu = paramString1;
    ((bva)localObject).signature = paramString2;
    ((bva)localObject).tLv = paramString3;
    ((bva)localObject).bQm = TenpayUtil.signWith3Des("passwd=" + ((bva)localObject).tLv);
    this.type = paramInt;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void aTg()
  {
    y.i("MicroMsg.NetSceneSoterOpenTouchPay", "hy: authkey required");
    if (this.dmL != null) {
      this.dmL.onSceneEnd(4, -1, "", this);
    }
  }
  
  public final void d(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    y.i("MicroMsg.NetSceneSoterOpenTouchPay", "hy: errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      y.i("MicroMsg.NetSceneSoterOpenTouchPay", "open fingerprintpay success");
      if (this.type == 0)
      {
        ((com.tencent.mm.pluginsdk.k)g.r(com.tencent.mm.pluginsdk.k.class)).gf(true);
        ((com.tencent.mm.pluginsdk.k)g.r(com.tencent.mm.pluginsdk.k.class)).gg(false);
      }
    }
    for (;;)
    {
      this.dmL.onSceneEnd(paramInt1, paramInt2, "", this);
      return;
      ((com.tencent.mm.pluginsdk.k)g.r(com.tencent.mm.pluginsdk.k.class)).gg(true);
      ((com.tencent.mm.pluginsdk.k)g.r(com.tencent.mm.pluginsdk.k.class)).gf(false);
      continue;
      y.e("MicroMsg.NetSceneSoterOpenTouchPay", "open fingerprintpay failed");
    }
  }
  
  public final int getType()
  {
    return 1638;
  }
  
  public final void rl(int paramInt)
  {
    y.i("MicroMsg.NetSceneSoterOpenTouchPay", "hy: onError: errType: %d, errcode: %d", new Object[] { Integer.valueOf(3), Integer.valueOf(paramInt) });
    if (this.dmL != null) {
      this.dmL.onSceneEnd(4, -1, "", this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.c.b
 * JD-Core Version:    0.7.0.1
 */