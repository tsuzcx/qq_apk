package com.tencent.mapsdk.internal;

import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.model.IEmergeAnimation;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

public final class hf
  extends hd
  implements IEmergeAnimation
{
  private LatLng c;
  
  public hf(LatLng paramLatLng)
  {
    AppMethodBeat.i(226072);
    this.c = null;
    if (this.a == null) {
      this.a = new hw(paramLatLng);
    }
    this.c = paramLatLng;
    AppMethodBeat.o(226072);
  }
  
  private LatLng a()
  {
    return this.c;
  }
  
  public final void setDuration(long paramLong)
  {
    AppMethodBeat.i(226083);
    if (this.a == null)
    {
      AppMethodBeat.o(226083);
      return;
    }
    this.a.a(paramLong);
    AppMethodBeat.o(226083);
  }
  
  public final void setInterpolator(Interpolator paramInterpolator)
  {
    if ((this.a == null) || (paramInterpolator == null)) {
      return;
    }
    this.a.f = paramInterpolator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.hf
 * JD-Core Version:    0.7.0.1
 */