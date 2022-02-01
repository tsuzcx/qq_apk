package com.tencent.mapsdk.internal;

import android.view.animation.Interpolator;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class hz
  extends hu
{
  private GeoPoint i;
  private GeoPoint j;
  private boolean k;
  
  public hz(GeoPoint paramGeoPoint)
  {
    AppMethodBeat.i(226177);
    this.i = null;
    this.j = null;
    this.k = false;
    if (paramGeoPoint != null)
    {
      this.j = new GeoPoint(paramGeoPoint.getLatitudeE6(), paramGeoPoint.getLongitudeE6());
      this.k = true;
    }
    AppMethodBeat.o(226177);
  }
  
  protected final void a(float paramFloat, Interpolator paramInterpolator)
  {
    AppMethodBeat.i(226184);
    if ((this.j == null) || (this.i == null))
    {
      AppMethodBeat.o(226184);
      return;
    }
    int m = this.j.getLatitudeE6();
    int i2 = this.i.getLatitudeE6();
    int n = this.j.getLongitudeE6();
    int i1 = this.i.getLongitudeE6();
    float f = paramInterpolator.getInterpolation(paramFloat);
    int i3 = this.i.getLatitudeE6();
    m = (int)((m - i2) * f) + i3;
    i2 = this.i.getLongitudeE6();
    n = (int)((n - i1) * f) + i2;
    if (1.0F - paramFloat < 0.0001D)
    {
      m = this.j.getLatitudeE6();
      n = this.j.getLongitudeE6();
    }
    if (this.h != null) {
      this.h.a(m, n);
    }
    AppMethodBeat.o(226184);
  }
  
  public final boolean a(GeoPoint paramGeoPoint1, GeoPoint paramGeoPoint2)
  {
    AppMethodBeat.i(226190);
    if (!super.a(null, null))
    {
      AppMethodBeat.o(226190);
      return false;
    }
    if (paramGeoPoint1 != null) {
      this.i = new GeoPoint(paramGeoPoint1.getLatitudeE6(), paramGeoPoint1.getLongitudeE6());
    }
    if ((!this.k) && (paramGeoPoint2 != null)) {
      this.j = new GeoPoint(paramGeoPoint2.getLatitudeE6(), paramGeoPoint2.getLongitudeE6());
    }
    AppMethodBeat.o(226190);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.hz
 * JD-Core Version:    0.7.0.1
 */