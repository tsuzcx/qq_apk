package com.tencent.mapsdk.internal;

import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ht
  extends hu
{
  private float i = 0.0F;
  private float j = 0.0F;
  
  public ht(float paramFloat1, float paramFloat2)
  {
    this.i = paramFloat1;
    this.j = paramFloat2;
  }
  
  protected final void a(float paramFloat, Interpolator paramInterpolator)
  {
    AppMethodBeat.i(225878);
    float f1 = this.j;
    float f2 = this.i;
    paramFloat = paramInterpolator.getInterpolation(paramFloat);
    float f3 = this.i;
    if (this.h != null) {
      this.h.a((f1 - f2) * paramFloat + f3);
    }
    AppMethodBeat.o(225878);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.ht
 * JD-Core Version:    0.7.0.1
 */