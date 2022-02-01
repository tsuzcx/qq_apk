package com.tencent.mapsdk.internal;

import android.view.animation.Interpolator;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.model.ITranslateAnimation;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

public final class hi
  extends hd
  implements ITranslateAnimation
{
  public hi(LatLng paramLatLng)
  {
    AppMethodBeat.i(226052);
    paramLatLng = GeoPoint.from(paramLatLng);
    if (this.a == null) {
      this.a = new hz(paramLatLng);
    }
    AppMethodBeat.o(226052);
  }
  
  public final void setDuration(long paramLong)
  {
    AppMethodBeat.i(226059);
    if (this.a == null)
    {
      AppMethodBeat.o(226059);
      return;
    }
    this.a.a(paramLong);
    AppMethodBeat.o(226059);
  }
  
  public final void setInterpolator(Interpolator paramInterpolator)
  {
    if (this.a == null) {}
    while (paramInterpolator == null) {
      return;
    }
    this.a.f = paramInterpolator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.hi
 * JD-Core Version:    0.7.0.1
 */