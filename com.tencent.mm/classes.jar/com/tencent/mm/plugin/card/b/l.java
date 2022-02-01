package com.tencent.mm.plugin.card.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.card.model.u;
import com.tencent.mm.sdk.platformtools.ac;

public final class l
  implements com.tencent.mm.ak.g
{
  public float fmX = -85.0F;
  public float fmY = -1000.0F;
  private long fto = 0L;
  
  public final void G(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(112701);
    if (System.currentTimeMillis() / 1000L - this.fto > 1800L)
    {
      this.fmX = -85.0F;
      this.fmY = -1000.0F;
      ac.i("MicroMsg.CardReportLBSManager", "checkDataValid time is out");
    }
    if (this.fmX == -85.0F) {
      ac.i("MicroMsg.CardReportLBSManager", "checkDataValid lbsLatitude ==  LocationGeo.INVALID_LAT");
    }
    if (this.fmY == -1000.0F) {
      ac.i("MicroMsg.CardReportLBSManager", "checkDataValid lbsLongitude ==  LocationGeo.INVALID_LNG");
    }
    com.tencent.mm.kernel.g.agQ().ghe.a(1253, this);
    paramString1 = new u(this.fmX, this.fmY, paramString1, paramString2, paramInt);
    com.tencent.mm.kernel.g.agQ().ghe.a(paramString1, 0);
    AppMethodBeat.o(112701);
  }
  
  public final void L(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(112700);
    this.fmX = paramFloat1;
    this.fmY = paramFloat2;
    this.fto = (System.currentTimeMillis() / 1000L);
    AppMethodBeat.o(112700);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(112702);
    ac.i("MicroMsg.CardReportLBSManager", "rplbs onGYNetEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    com.tencent.mm.kernel.g.agQ().ghe.b(1253, this);
    AppMethodBeat.o(112702);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.l
 * JD-Core Version:    0.7.0.1
 */