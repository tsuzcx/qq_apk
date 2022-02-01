package com.tencent.mm.plugin.card.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.model.u;
import com.tencent.mm.sdk.platformtools.ad;

public final class l
  implements f
{
  public float fFf = -85.0F;
  public float fFg = -1000.0F;
  private long fMf = 0L;
  
  public final void H(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(112701);
    if (System.currentTimeMillis() / 1000L - this.fMf > 1800L)
    {
      this.fFf = -85.0F;
      this.fFg = -1000.0F;
      ad.i("MicroMsg.CardReportLBSManager", "checkDataValid time is out");
    }
    if (this.fFf == -85.0F) {
      ad.i("MicroMsg.CardReportLBSManager", "checkDataValid lbsLatitude ==  LocationGeo.INVALID_LAT");
    }
    if (this.fFg == -1000.0F) {
      ad.i("MicroMsg.CardReportLBSManager", "checkDataValid lbsLongitude ==  LocationGeo.INVALID_LNG");
    }
    g.ajB().gAO.a(1253, this);
    paramString1 = new u(this.fFf, this.fFg, paramString1, paramString2, paramInt);
    g.ajB().gAO.a(paramString1, 0);
    AppMethodBeat.o(112701);
  }
  
  public final void N(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(112700);
    this.fFf = paramFloat1;
    this.fFg = paramFloat2;
    this.fMf = (System.currentTimeMillis() / 1000L);
    AppMethodBeat.o(112700);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(112702);
    ad.i("MicroMsg.CardReportLBSManager", "rplbs onGYNetEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    g.ajB().gAO.b(1253, this);
    AppMethodBeat.o(112702);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.l
 * JD-Core Version:    0.7.0.1
 */