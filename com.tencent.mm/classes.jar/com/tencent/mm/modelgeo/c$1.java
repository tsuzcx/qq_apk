package com.tencent.mm.modelgeo;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

final class c$1
  extends e
{
  c$1(c paramc) {}
  
  public final void a(boolean paramBoolean, double paramDouble1, double paramDouble2, int paramInt1, double paramDouble3, double paramDouble4, double paramDouble5, String paramString1, String paramString2, int paramInt2)
  {
    c.a(this.elM, paramBoolean, paramDouble1, paramDouble2, paramDouble4, true);
    if (paramBoolean)
    {
      this.elM.elA = paramDouble1;
      this.elM.elB = paramDouble2;
      this.elM.elC = paramInt1;
      this.elM.elD = paramDouble3;
      this.elM.elE = paramDouble4;
      this.elM.aWH = paramDouble5;
      this.elM.elF = paramString1;
      this.elM.elG = paramString2;
      this.elM.elH = paramInt2;
      this.elM.elx = System.currentTimeMillis();
      this.elM.ely = true;
      this.elM.elz = false;
      c.a(this.elM, 67592);
    }
    y.d("MicroMsg.LocationGeo", "onGetLocation fLongitude: %f fLatitude:%f locType:%d %f:spped", new Object[] { Double.valueOf(paramDouble2), Double.valueOf(paramDouble1), Integer.valueOf(paramInt1), Double.valueOf(paramDouble3) });
    new ah(Looper.getMainLooper()).post(new c.1.1(this, paramBoolean, paramDouble1, paramDouble2, paramInt1, paramDouble3, paramDouble4, paramDouble5));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelgeo.c.1
 * JD-Core Version:    0.7.0.1
 */