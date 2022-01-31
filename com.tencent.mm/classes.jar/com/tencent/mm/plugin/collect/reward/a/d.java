package com.tencent.mm.plugin.collect.reward.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ni;
import com.tencent.mm.protocal.c.nj;
import com.tencent.mm.sdk.platformtools.y;

public final class d
  extends a
{
  private final String TAG = "MicroMsg.NetSceneQrRewardPayCheck";
  private b dmK;
  private f dmL;
  private nj iId;
  
  public d(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new ni();
    ((b.a)localObject).ecI = new nj();
    ((b.a)localObject).ecG = 1960;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/rewardqrcodepaycheck";
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (ni)this.dmK.ecE.ecN;
    ((ni)localObject).bOT = paramString1;
    ((ni)localObject).sKX = paramString2;
    ((ni)localObject).swd = paramString3;
    ((ni)localObject).amount = paramInt;
    ((ni)localObject).sKV = paramString4;
    ((ni)localObject).sKU = paramString5;
    y.i("MicroMsg.NetSceneQrRewardPayCheck", "rewardid: %s, amt: %s", new Object[] { paramString2, Integer.valueOf(paramInt) });
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    y.i("MicroMsg.NetSceneQrRewardPayCheck", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.iId = ((nj)((b)paramq).ecF.ecN);
    y.i("MicroMsg.NetSceneQrRewardPayCheck", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.iId.iHq), this.iId.iHr });
    if ((!this.iHX) && (this.iId.iHq != 0)) {
      this.iHY = true;
    }
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
  }
  
  public final int getType()
  {
    return 1960;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.a.d
 * JD-Core Version:    0.7.0.1
 */