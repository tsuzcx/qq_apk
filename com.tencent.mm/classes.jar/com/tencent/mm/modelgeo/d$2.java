package com.tencent.mm.modelgeo;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

final class d$2
  extends g
{
  d$2(d paramd) {}
  
  public final void a(boolean paramBoolean, double paramDouble1, double paramDouble2, int paramInt1, double paramDouble3, double paramDouble4, double paramDouble5, String paramString1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(78128);
    d.a(this.fCe, paramBoolean, paramDouble1, paramDouble2, paramDouble4, false);
    if (paramBoolean)
    {
      this.fCe.fBS = paramDouble1;
      this.fCe.fBT = paramDouble2;
      this.fCe.fBU = paramInt1;
      this.fCe.fBV = paramDouble3;
      this.fCe.fBW = paramDouble4;
      this.fCe.bno = paramDouble5;
      this.fCe.fBX = paramString1;
      this.fCe.fBY = paramString2;
      this.fCe.fBZ = paramInt2;
      this.fCe.fBR = true;
      this.fCe.fBQ = false;
      this.fCe.fBP = System.currentTimeMillis();
      d.a(this.fCe, 67591);
    }
    ab.d("MicroMsg.LocationGeo", "onGetLocationWgs84 fLongitude: %f fLatitude:%f locType:%d %f:spped", new Object[] { Double.valueOf(paramDouble2), Double.valueOf(paramDouble1), Integer.valueOf(paramInt1), Double.valueOf(paramDouble3) });
    new ak(Looper.getMainLooper()).postDelayed(new d.2.1(this, paramBoolean, paramDouble1, paramDouble2, paramInt1, paramDouble3, paramDouble4, paramDouble5), 200L);
    AppMethodBeat.o(78128);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelgeo.d.2
 * JD-Core Version:    0.7.0.1
 */