package android.support.v4.view.b;

import android.view.animation.Interpolator;

abstract class d
  implements Interpolator
{
  private final float[] AC;
  private final float RQ;
  
  protected d(float[] paramArrayOfFloat)
  {
    this.AC = paramArrayOfFloat;
    this.RQ = (1.0F / (this.AC.length - 1));
  }
  
  public float getInterpolation(float paramFloat)
  {
    if (paramFloat >= 1.0F) {
      return 1.0F;
    }
    if (paramFloat <= 0.0F) {
      return 0.0F;
    }
    int i = Math.min((int)((this.AC.length - 1) * paramFloat), this.AC.length - 2);
    paramFloat = (paramFloat - i * this.RQ) / this.RQ;
    float f = this.AC[i];
    return (this.AC[(i + 1)] - this.AC[i]) * paramFloat + f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.view.b.d
 * JD-Core Version:    0.7.0.1
 */