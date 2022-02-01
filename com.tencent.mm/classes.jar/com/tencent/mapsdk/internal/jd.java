package com.tencent.mapsdk.internal;

import android.view.animation.Interpolator;

public final class jd
  implements Interpolator
{
  public final float getInterpolation(float paramFloat)
  {
    return (2.0F - paramFloat) * paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mapsdk.internal.jd
 * JD-Core Version:    0.7.0.1
 */