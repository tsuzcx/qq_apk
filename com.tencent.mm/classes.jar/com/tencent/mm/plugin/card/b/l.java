package com.tencent.mm.plugin.card.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.card.model.u;
import com.tencent.mm.sdk.platformtools.Log;

public final class l
  implements i
{
  private long coZ = 0L;
  public float iQD = -85.0F;
  public float iQE = -1000.0F;
  
  public final void K(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(112701);
    if (System.currentTimeMillis() / 1000L - this.coZ > 1800L)
    {
      this.iQD = -85.0F;
      this.iQE = -1000.0F;
      Log.i("MicroMsg.CardReportLBSManager", "checkDataValid time is out");
    }
    if (this.iQD == -85.0F) {
      Log.i("MicroMsg.CardReportLBSManager", "checkDataValid lbsLatitude ==  LocationGeo.INVALID_LAT");
    }
    if (this.iQE == -1000.0F) {
      Log.i("MicroMsg.CardReportLBSManager", "checkDataValid lbsLongitude ==  LocationGeo.INVALID_LNG");
    }
    h.aHF().kcd.a(1253, this);
    paramString1 = new u(this.iQD, this.iQE, paramString1, paramString2, paramInt);
    h.aHF().kcd.a(paramString1, 0);
    AppMethodBeat.o(112701);
  }
  
  public final void T(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(112700);
    this.iQD = paramFloat1;
    this.iQE = paramFloat2;
    this.coZ = (System.currentTimeMillis() / 1000L);
    AppMethodBeat.o(112700);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(112702);
    Log.i("MicroMsg.CardReportLBSManager", "rplbs onGYNetEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    h.aHF().kcd.b(1253, this);
    AppMethodBeat.o(112702);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.l
 * JD-Core Version:    0.7.0.1
 */