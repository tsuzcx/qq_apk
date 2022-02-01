package com.tencent.mapsdk.internal;

import com.tencent.map.lib.models.GeoPoint;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ia
  extends hj
{
  private GeoPoint g;
  private GeoPoint h;
  private boolean i;
  
  private ia(GeoPoint paramGeoPoint1, GeoPoint paramGeoPoint2)
  {
    AppMethodBeat.i(226120);
    this.g = null;
    this.h = null;
    this.i = false;
    if (paramGeoPoint1 != null) {
      this.g = new GeoPoint(paramGeoPoint1.getLatitudeE6(), paramGeoPoint1.getLongitudeE6());
    }
    if (paramGeoPoint2 != null) {
      this.h = new GeoPoint(paramGeoPoint2.getLatitudeE6(), paramGeoPoint2.getLongitudeE6());
    }
    AppMethodBeat.o(226120);
  }
  
  protected final void a(float paramFloat)
  {
    AppMethodBeat.i(226129);
    if ((this.h == null) || (this.g == null))
    {
      AppMethodBeat.o(226129);
      return;
    }
    int n = this.h.getLatitudeE6();
    int i1 = this.g.getLatitudeE6();
    int k = this.h.getLongitudeE6();
    int m = this.g.getLongitudeE6();
    int j = this.g.getLatitudeE6();
    n = (int)((n - i1) * paramFloat);
    i1 = this.g.getLongitudeE6();
    k = (int)((k - m) * paramFloat);
    if (this.f != null) {
      new GeoPoint(n + j, k + i1);
    }
    AppMethodBeat.o(226129);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mapsdk.internal.ia
 * JD-Core Version:    0.7.0.1
 */