package com.tencent.mm.plugin.luckymoney.particles;

import android.view.animation.Interpolator;

final class e$1
  implements Interpolator
{
  public final float getInterpolation(float paramFloat)
  {
    float f = 1.0F;
    if (paramFloat >= 0.9F) {
      f = 1.0F - (paramFloat - 0.9F) * 10.0F;
    }
    return f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.particles.e.1
 * JD-Core Version:    0.7.0.1
 */