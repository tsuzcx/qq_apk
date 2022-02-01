package android.support.v4.view.b;

import android.view.animation.Interpolator;

abstract class d
  implements Interpolator
{
  private final float[] AI;
  private final float Sd;
  
  protected d(float[] paramArrayOfFloat)
  {
    this.AI = paramArrayOfFloat;
    this.Sd = (1.0F / (this.AI.length - 1));
  }
  
  public float getInterpolation(float paramFloat)
  {
    if (paramFloat >= 1.0F) {
      return 1.0F;
    }
    if (paramFloat <= 0.0F) {
      return 0.0F;
    }
    int i = Math.min((int)((this.AI.length - 1) * paramFloat), this.AI.length - 2);
    paramFloat = (paramFloat - i * this.Sd) / this.Sd;
    float f = this.AI[i];
    return (this.AI[(i + 1)] - this.AI[i]) * paramFloat + f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.view.b.d
 * JD-Core Version:    0.7.0.1
 */