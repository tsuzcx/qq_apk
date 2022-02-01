package com.tencent.mm.plugin.card.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.model.u;
import com.tencent.mm.sdk.platformtools.Log;

public final class l
  implements i
{
  private long crj = 0L;
  public float gmu = -85.0F;
  public float gmv = -1000.0F;
  
  public final void G(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(112701);
    if (System.currentTimeMillis() / 1000L - this.crj > 1800L)
    {
      this.gmu = -85.0F;
      this.gmv = -1000.0F;
      Log.i("MicroMsg.CardReportLBSManager", "checkDataValid time is out");
    }
    if (this.gmu == -85.0F) {
      Log.i("MicroMsg.CardReportLBSManager", "checkDataValid lbsLatitude ==  LocationGeo.INVALID_LAT");
    }
    if (this.gmv == -1000.0F) {
      Log.i("MicroMsg.CardReportLBSManager", "checkDataValid lbsLongitude ==  LocationGeo.INVALID_LNG");
    }
    g.aAg().hqi.a(1253, this);
    paramString1 = new u(this.gmu, this.gmv, paramString1, paramString2, paramInt);
    g.aAg().hqi.a(paramString1, 0);
    AppMethodBeat.o(112701);
  }
  
  public final void R(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(112700);
    this.gmu = paramFloat1;
    this.gmv = paramFloat2;
    this.crj = (System.currentTimeMillis() / 1000L);
    AppMethodBeat.o(112700);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(112702);
    Log.i("MicroMsg.CardReportLBSManager", "rplbs onGYNetEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    g.aAg().hqi.b(1253, this);
    AppMethodBeat.o(112702);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.l
 * JD-Core Version:    0.7.0.1
 */