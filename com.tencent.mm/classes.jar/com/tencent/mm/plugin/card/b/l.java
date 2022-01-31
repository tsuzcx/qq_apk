package com.tencent.mm.plugin.card.b;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.model.u;
import com.tencent.mm.sdk.platformtools.y;

public final class l
  implements f
{
  public float dia = -85.0F;
  public float dib = -1000.0F;
  private long updateTime = 0L;
  
  public final void N(float paramFloat1, float paramFloat2)
  {
    this.dia = paramFloat1;
    this.dib = paramFloat2;
    this.updateTime = (System.currentTimeMillis() / 1000L);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.CardReportLBSManager", "rplbs onGYNetEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    g.DO().dJT.b(1253, this);
  }
  
  public final void r(String paramString1, String paramString2, int paramInt)
  {
    if (System.currentTimeMillis() / 1000L - this.updateTime > 1800L)
    {
      this.dia = -85.0F;
      this.dib = -1000.0F;
      y.i("MicroMsg.CardReportLBSManager", "checkDataValid time is out");
    }
    if (this.dia == -85.0F) {
      y.i("MicroMsg.CardReportLBSManager", "checkDataValid lbsLatitude ==  LocationGeo.INVALID_LAT");
    }
    if (this.dib == -1000.0F) {
      y.i("MicroMsg.CardReportLBSManager", "checkDataValid lbsLongitude ==  LocationGeo.INVALID_LNG");
    }
    g.DO().dJT.a(1253, this);
    paramString1 = new u(this.dia, this.dib, paramString1, paramString2, paramInt);
    g.DO().dJT.a(paramString1, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.l
 * JD-Core Version:    0.7.0.1
 */