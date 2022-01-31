package android.support.v4.view.b;

import android.view.animation.Interpolator;

abstract class d
  implements Interpolator
{
  private final float Ig;
  private final float[] rl;
  
  protected d(float[] paramArrayOfFloat)
  {
    this.rl = paramArrayOfFloat;
    this.Ig = (1.0F / (this.rl.length - 1));
  }
  
  public float getInterpolation(float paramFloat)
  {
    if (paramFloat >= 1.0F) {
      return 1.0F;
    }
    if (paramFloat <= 0.0F) {
      return 0.0F;
    }
    int i = Math.min((int)((this.rl.length - 1) * paramFloat), this.rl.length - 2);
    paramFloat = (paramFloat - i * this.Ig) / this.Ig;
    float f = this.rl[i];
    return (this.rl[(i + 1)] - this.rl[i]) * paramFloat + f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.view.b.d
 * JD-Core Version:    0.7.0.1
 */