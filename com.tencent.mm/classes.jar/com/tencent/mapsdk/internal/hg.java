package com.tencent.mapsdk.internal;

import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.model.IRotateAnimation;

public final class hg
  extends hd
  implements IRotateAnimation
{
  public hg(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    AppMethodBeat.i(226062);
    if (this.a == null) {
      this.a = new hx(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5);
    }
    AppMethodBeat.o(226062);
  }
  
  public final void setDuration(long paramLong)
  {
    AppMethodBeat.i(226073);
    if (this.a == null)
    {
      AppMethodBeat.o(226073);
      return;
    }
    this.a.a(paramLong);
    AppMethodBeat.o(226073);
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
 * Qualified Name:     com.tencent.mapsdk.internal.hg
 * JD-Core Version:    0.7.0.1
 */