package com.tencent.mm.plugin.collect.reward.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.nm;
import com.tencent.mm.protocal.c.nn;
import com.tencent.mm.sdk.platformtools.y;

public final class f
  extends a
{
  private final String TAG = "MicroMsg.NetSceneQrRewardScanCode";
  private b dmK;
  private com.tencent.mm.ah.f dmL;
  public nn iIf;
  
  public f(String paramString1, int paramInt, String paramString2)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new nm();
    ((b.a)localObject).ecI = new nn();
    ((b.a)localObject).ecG = 1516;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/scanrewardqrcode";
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (nm)this.dmK.ecE.ecN;
    ((nm)localObject).iHs = paramString1;
    ((nm)localObject).bUR = paramInt;
    ((nm)localObject).sLd = paramString2;
  }
  
  public final int a(e parame, com.tencent.mm.ah.f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  protected final boolean aED()
  {
    return false;
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    y.i("MicroMsg.NetSceneQrRewardScanCode", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.iIf = ((nn)((b)paramq).ecF.ecN);
    y.i("MicroMsg.NetSceneQrRewardScanCode", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.iIf.iHq), this.iIf.iHr });
    if ((!this.iHX) && (this.iIf.iHq != 0)) {
      this.iHY = true;
    }
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
  }
  
  public final int getType()
  {
    return 1516;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.a.f
 * JD-Core Version:    0.7.0.1
 */