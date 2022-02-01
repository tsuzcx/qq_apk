package com.tencent.mapsdk.internal;

import android.view.animation.Interpolator;

public final class ja
  implements Interpolator
{
  public final float getInterpolation(float paramFloat)
  {
    double d = paramFloat - 1.0D;
    d *= d;
    d *= d;
    return (float)(1.0D - d * d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mapsdk.internal.ja
 * JD-Core Version:    0.7.0.1
 */