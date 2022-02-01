package androidx.g.a.a;

import android.view.animation.Interpolator;

abstract class d
  implements Interpolator
{
  private final float[] bGM;
  private final float bGN;
  
  protected d(float[] paramArrayOfFloat)
  {
    this.bGM = paramArrayOfFloat;
    this.bGN = (1.0F / (this.bGM.length - 1));
  }
  
  public float getInterpolation(float paramFloat)
  {
    if (paramFloat >= 1.0F) {
      return 1.0F;
    }
    if (paramFloat <= 0.0F) {
      return 0.0F;
    }
    int i = Math.min((int)((this.bGM.length - 1) * paramFloat), this.bGM.length - 2);
    paramFloat = (paramFloat - i * this.bGN) / this.bGN;
    float f = this.bGM[i];
    return (this.bGM[(i + 1)] - this.bGM[i]) * paramFloat + f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.g.a.a.d
 * JD-Core Version:    0.7.0.1
 */