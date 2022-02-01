package com.tencent.mm.plugin.card.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.card.model.u;
import com.tencent.mm.sdk.platformtools.ad;

public final class l
  implements com.tencent.mm.al.g
{
  public float fjD = -85.0F;
  public float fjE = -1000.0F;
  private long fpL = 0L;
  
  public final void F(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(112701);
    if (System.currentTimeMillis() / 1000L - this.fpL > 1800L)
    {
      this.fjD = -85.0F;
      this.fjE = -1000.0F;
      ad.i("MicroMsg.CardReportLBSManager", "checkDataValid time is out");
    }
    if (this.fjD == -85.0F) {
      ad.i("MicroMsg.CardReportLBSManager", "checkDataValid lbsLatitude ==  LocationGeo.INVALID_LAT");
    }
    if (this.fjE == -1000.0F) {
      ad.i("MicroMsg.CardReportLBSManager", "checkDataValid lbsLongitude ==  LocationGeo.INVALID_LNG");
    }
    com.tencent.mm.kernel.g.afA().gcy.a(1253, this);
    paramString1 = new u(this.fjD, this.fjE, paramString1, paramString2, paramInt);
    com.tencent.mm.kernel.g.afA().gcy.a(paramString1, 0);
    AppMethodBeat.o(112701);
  }
  
  public final void I(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(112700);
    this.fjD = paramFloat1;
    this.fjE = paramFloat2;
    this.fpL = (System.currentTimeMillis() / 1000L);
    AppMethodBeat.o(112700);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(112702);
    ad.i("MicroMsg.CardReportLBSManager", "rplbs onGYNetEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    com.tencent.mm.kernel.g.afA().gcy.b(1253, this);
    AppMethodBeat.o(112702);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.l
 * JD-Core Version:    0.7.0.1
 */