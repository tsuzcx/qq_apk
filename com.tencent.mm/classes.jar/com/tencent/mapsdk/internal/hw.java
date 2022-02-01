package com.tencent.mapsdk.internal;

import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

public final class hw
  extends hu
{
  public LatLng i = null;
  
  public hw(LatLng paramLatLng)
  {
    this.i = paramLatLng;
  }
  
  private LatLng c()
  {
    return this.i;
  }
  
  protected final void a(float paramFloat, Interpolator paramInterpolator)
  {
    AppMethodBeat.i(226223);
    paramFloat = paramInterpolator.getInterpolation(paramFloat);
    if (this.h != null) {
      this.h.b(paramFloat);
    }
    AppMethodBeat.o(226223);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.hw
 * JD-Core Version:    0.7.0.1
 */