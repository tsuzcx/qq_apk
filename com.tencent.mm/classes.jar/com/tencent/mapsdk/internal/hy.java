package com.tencent.mapsdk.internal;

import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class hy
  extends hu
{
  private float i = 0.0F;
  private float j = 0.0F;
  private float k = 0.0F;
  private float l = 0.0F;
  
  public hy(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.i = paramFloat1;
    this.j = paramFloat2;
    this.k = paramFloat3;
    this.l = paramFloat4;
  }
  
  protected final void a(float paramFloat, Interpolator paramInterpolator)
  {
    AppMethodBeat.i(226187);
    if (paramFloat < 0.0F)
    {
      AppMethodBeat.o(226187);
      return;
    }
    float f1 = this.j;
    float f2 = this.i;
    float f3 = this.l;
    float f4 = this.k;
    paramFloat = paramInterpolator.getInterpolation(paramFloat);
    float f5 = this.i;
    float f6 = this.k;
    if (this.h != null) {
      this.h.a((f1 - f2) * paramFloat + f5, (f3 - f4) * paramFloat + f6);
    }
    AppMethodBeat.o(226187);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.hy
 * JD-Core Version:    0.7.0.1
 */