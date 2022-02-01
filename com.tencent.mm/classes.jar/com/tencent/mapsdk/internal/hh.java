package com.tencent.mapsdk.internal;

import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.model.IScaleAnimation;

public final class hh
  extends hd
  implements IScaleAnimation
{
  public hh(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AppMethodBeat.i(226057);
    if (this.a == null) {
      this.a = new hy(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    }
    AppMethodBeat.o(226057);
  }
  
  public final void setDuration(long paramLong)
  {
    AppMethodBeat.i(226065);
    if (this.a == null)
    {
      AppMethodBeat.o(226065);
      return;
    }
    this.a.a(paramLong);
    AppMethodBeat.o(226065);
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
 * Qualified Name:     com.tencent.mapsdk.internal.hh
 * JD-Core Version:    0.7.0.1
 */