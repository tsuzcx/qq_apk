package com.tencent.mm.plugin.collect.reward.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.nk;
import com.tencent.mm.protocal.c.nl;
import com.tencent.mm.sdk.platformtools.y;

public final class e
  extends a
{
  private final String TAG = "MicroMsg.NetSceneQrRewardPlaceOrder";
  private b dmK;
  private f dmL;
  public nl iIe;
  
  public e(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, int paramInt3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt4)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new nk();
    ((b.a)localObject).ecI = new nl();
    ((b.a)localObject).ecG = 1336;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/rewardqrcodeplaceorder";
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (nk)this.dmK.ecE.ecN;
    ((nk)localObject).amount = paramInt1;
    ((nk)localObject).sLa = paramInt2;
    ((nk)localObject).sKY = paramString1;
    ((nk)localObject).sKZ = paramString2;
    ((nk)localObject).nzf = paramString3;
    ((nk)localObject).bUR = paramInt3;
    ((nk)localObject).sLb = paramString4;
    ((nk)localObject).sKV = paramString5;
    ((nk)localObject).sLd = paramString6;
    ((nk)localObject).sLe = paramString7;
    ((nk)localObject).sLf = paramString8;
    ((nk)localObject).sLg = paramInt4;
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    y.i("MicroMsg.NetSceneQrRewardPlaceOrder", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.iIe = ((nl)((b)paramq).ecF.ecN);
    y.i("MicroMsg.NetSceneQrRewardPlaceOrder", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.iIe.iHq), this.iIe.iHr });
    if ((!this.iHX) && (this.iIe.iHq != 0)) {
      this.iHY = true;
    }
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
  }
  
  public final int getType()
  {
    return 1336;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.a.e
 * JD-Core Version:    0.7.0.1
 */