package com.tencent.mapsdk.internal;

import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.model.IAlphaAnimation;

public final class hc
  extends hd
  implements IAlphaAnimation
{
  public hc(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(225597);
    if (this.a == null) {
      this.a = new ht(paramFloat1, paramFloat2);
    }
    AppMethodBeat.o(225597);
  }
  
  public final void setDuration(long paramLong)
  {
    AppMethodBeat.i(225605);
    if (this.a == null)
    {
      AppMethodBeat.o(225605);
      return;
    }
    this.a.a(paramLong);
    AppMethodBeat.o(225605);
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
 * Qualified Name:     com.tencent.mapsdk.internal.hc
 * JD-Core Version:    0.7.0.1
 */