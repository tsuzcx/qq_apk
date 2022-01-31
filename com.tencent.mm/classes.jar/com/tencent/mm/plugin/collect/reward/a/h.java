package com.tencent.mm.plugin.collect.reward.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.no;
import com.tencent.mm.protocal.c.np;
import com.tencent.mm.sdk.platformtools.y;

public final class h
  extends a
{
  private final String TAG = "MicroMsg.NetSceneQrRewardSetPhotoWord";
  private b dmK;
  private f dmL;
  public np iIh;
  public String iet;
  
  public h(String paramString)
  {
    b.a locala = new b.a();
    locala.ecH = new no();
    locala.ecI = new np();
    locala.ecG = 1649;
    locala.uri = "/cgi-bin/mmpay-bin/setrewardqrcodephotoword";
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
    ((no)this.dmK.ecE.ecN).iet = paramString;
    this.iet = paramString;
    if ((paramString.length() > 0) && (paramString.length() <= 3)) {
      com.tencent.mm.plugin.report.service.h.nFQ.a(724L, 0L, 1L, false);
    }
    while (paramString.length() <= 3) {
      return;
    }
    com.tencent.mm.plugin.report.service.h.nFQ.a(724L, 1L, 1L, false);
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    y.i("MicroMsg.NetSceneQrRewardSetPhotoWord", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.iIh = ((np)((b)paramq).ecF.ecN);
    y.i("MicroMsg.NetSceneQrRewardSetPhotoWord", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.iIh.iHq), this.iIh.iHr });
    if ((!this.iHX) && (this.iIh.iHq != 0)) {
      this.iHY = true;
    }
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
  }
  
  public final int getType()
  {
    return 1649;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.a.h
 * JD-Core Version:    0.7.0.1
 */