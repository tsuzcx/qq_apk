package android.support.v4.view.b;

import android.view.animation.Interpolator;

abstract class d
  implements Interpolator
{
  private final float Pg;
  private final float[] xL;
  
  protected d(float[] paramArrayOfFloat)
  {
    this.xL = paramArrayOfFloat;
    this.Pg = (1.0F / (this.xL.length - 1));
  }
  
  public float getInterpolation(float paramFloat)
  {
    if (paramFloat >= 1.0F) {
      return 1.0F;
    }
    if (paramFloat <= 0.0F) {
      return 0.0F;
    }
    int i = Math.min((int)((this.xL.length - 1) * paramFloat), this.xL.length - 2);
    paramFloat = (paramFloat - i * this.Pg) / this.Pg;
    float f = this.xL[i];
    return (this.xL[(i + 1)] - this.xL[i]) * paramFloat + f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.view.b.d
 * JD-Core Version:    0.7.0.1
 */