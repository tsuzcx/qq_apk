package com.tencent.mapsdk.internal;

import android.view.animation.Interpolator;

public final class iy
  implements Interpolator
{
  public final float getInterpolation(float paramFloat)
  {
    double d = paramFloat;
    d *= d;
    d *= d;
    return (float)(d * d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mapsdk.internal.iy
 * JD-Core Version:    0.7.0.1
 */