package android.support.v4.view.b;

import android.view.animation.Interpolator;

abstract class d
  implements Interpolator
{
  private final float Iv;
  private final float[] qo;
  
  protected d(float[] paramArrayOfFloat)
  {
    this.qo = paramArrayOfFloat;
    this.Iv = (1.0F / (this.qo.length - 1));
  }
  
  public float getInterpolation(float paramFloat)
  {
    if (paramFloat >= 1.0F) {
      return 1.0F;
    }
    if (paramFloat <= 0.0F) {
      return 0.0F;
    }
    int i = Math.min((int)((this.qo.length - 1) * paramFloat), this.qo.length - 2);
    paramFloat = (paramFloat - i * this.Iv) / this.Iv;
    float f = this.qo[i];
    return (this.qo[(i + 1)] - this.qo[i]) * paramFloat + f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.view.b.d
 * JD-Core Version:    0.7.0.1
 */