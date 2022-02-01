package android.support.v4.view.b;

import android.view.animation.Interpolator;

abstract class d
  implements Interpolator
{
  private final float Qb;
  private final float[] yJ;
  
  protected d(float[] paramArrayOfFloat)
  {
    this.yJ = paramArrayOfFloat;
    this.Qb = (1.0F / (this.yJ.length - 1));
  }
  
  public float getInterpolation(float paramFloat)
  {
    if (paramFloat >= 1.0F) {
      return 1.0F;
    }
    if (paramFloat <= 0.0F) {
      return 0.0F;
    }
    int i = Math.min((int)((this.yJ.length - 1) * paramFloat), this.yJ.length - 2);
    paramFloat = (paramFloat - i * this.Qb) / this.Qb;
    float f = this.yJ[i];
    return (this.yJ[(i + 1)] - this.yJ[i]) * paramFloat + f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.view.b.d
 * JD-Core Version:    0.7.0.1
 */