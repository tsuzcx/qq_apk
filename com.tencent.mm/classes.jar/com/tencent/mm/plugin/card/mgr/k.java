package com.tencent.mm.plugin.card.mgr;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.c;
import com.tencent.mm.plugin.card.model.u;
import com.tencent.mm.sdk.platformtools.Log;

public final class k
  implements com.tencent.mm.am.h
{
  private long egK = 0L;
  public float lsA = -1000.0F;
  public float lsz = -85.0F;
  
  public final void R(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(112701);
    if (System.currentTimeMillis() / 1000L - this.egK > 1800L)
    {
      this.lsz = -85.0F;
      this.lsA = -1000.0F;
      Log.i("MicroMsg.CardReportLBSManager", "checkDataValid time is out");
    }
    if (this.lsz == -85.0F) {
      Log.i("MicroMsg.CardReportLBSManager", "checkDataValid lbsLatitude ==  LocationGeo.INVALID_LAT");
    }
    if (this.lsA == -1000.0F) {
      Log.i("MicroMsg.CardReportLBSManager", "checkDataValid lbsLongitude ==  LocationGeo.INVALID_LNG");
    }
    com.tencent.mm.kernel.h.baD().mCm.a(1253, this);
    paramString1 = new u(this.lsz, this.lsA, paramString1, paramString2, paramInt);
    com.tencent.mm.kernel.h.baD().mCm.a(paramString1, 0);
    AppMethodBeat.o(112701);
  }
  
  public final void aB(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(112700);
    this.lsz = paramFloat1;
    this.lsA = paramFloat2;
    this.egK = (System.currentTimeMillis() / 1000L);
    AppMethodBeat.o(112700);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(112702);
    Log.i("MicroMsg.CardReportLBSManager", "rplbs onGYNetEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    com.tencent.mm.kernel.h.baD().mCm.b(1253, this);
    AppMethodBeat.o(112702);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.mgr.k
 * JD-Core Version:    0.7.0.1
 */