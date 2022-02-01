package com.tencent.mapsdk.internal;

import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class hx
  extends hu
{
  private float i = 0.0F;
  private float j = 0.0F;
  private float k = 0.0F;
  private float l = 0.0F;
  private float m = 0.0F;
  
  public hx(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    this.i = paramFloat1;
    this.j = paramFloat2;
    this.k = paramFloat3;
    this.l = paramFloat4;
    this.m = paramFloat5;
  }
  
  protected final void a(float paramFloat, Interpolator paramInterpolator)
  {
    AppMethodBeat.i(226201);
    float f1 = this.j;
    float f2 = this.i;
    paramFloat = paramInterpolator.getInterpolation(paramFloat);
    float f3 = this.i;
    if (this.h != null) {
      this.h.a((f1 - f2) * paramFloat + f3, this.k, this.l, this.m);
    }
    AppMethodBeat.o(226201);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.hx
 * JD-Core Version:    0.7.0.1
 */