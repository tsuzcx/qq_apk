package com.tencent.mm.bd;

import com.tencent.map.swlocation.api.LocationUpdateListener;
import com.tencent.mm.sdk.platformtools.y;

final class b$5
  implements LocationUpdateListener
{
  b$5(b paramb) {}
  
  public final void onLocationUpdate(double paramDouble1, double paramDouble2, int paramInt1, int paramInt2, long paramLong)
  {
    y.d("MicroMsg.SenseWhereHelper", "onLocationUpdate latitude[%f] longitude[%f] error[%d] floor[%d] buildingId[%d]", new Object[] { Double.valueOf(paramDouble1), Double.valueOf(paramDouble2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.bd.b.5
 * JD-Core Version:    0.7.0.1
 */