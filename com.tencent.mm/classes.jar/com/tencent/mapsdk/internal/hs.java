package com.tencent.mapsdk.internal;

import com.tencent.map.lib.models.GeoPoint;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class hs
  implements is<GeoPoint>
{
  private static GeoPoint a(float paramFloat, GeoPoint paramGeoPoint1, GeoPoint paramGeoPoint2)
  {
    AppMethodBeat.i(225912);
    int m = paramGeoPoint2.getLatitudeE6();
    int n = paramGeoPoint1.getLatitudeE6();
    int i = paramGeoPoint2.getLongitudeE6();
    int j = paramGeoPoint1.getLongitudeE6();
    int k = paramGeoPoint1.getLatitudeE6();
    m = (int)((m - n) * paramFloat);
    n = paramGeoPoint1.getLongitudeE6();
    paramGeoPoint1 = new GeoPoint(m + k, (int)((i - j) * paramFloat) + n);
    AppMethodBeat.o(225912);
    return paramGeoPoint1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mapsdk.internal.hs
 * JD-Core Version:    0.7.0.1
 */