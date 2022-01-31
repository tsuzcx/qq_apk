package android.support.v4.view.b;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.animation.Interpolator;

final class e
  implements Interpolator
{
  private final float[] mL;
  private final float[] mM;
  
  e(Path paramPath)
  {
    paramPath = new PathMeasure(paramPath, false);
    float f = paramPath.getLength();
    int j = (int)(f / 0.002F) + 1;
    this.mL = new float[j];
    this.mM = new float[j];
    float[] arrayOfFloat = new float[2];
    int i = 0;
    while (i < j)
    {
      paramPath.getPosTan(i * f / (j - 1), arrayOfFloat, null);
      this.mL[i] = arrayOfFloat[0];
      this.mM[i] = arrayOfFloat[1];
      i += 1;
    }
  }
  
  public final float getInterpolation(float paramFloat)
  {
    if (paramFloat <= 0.0F) {
      return 0.0F;
    }
    if (paramFloat >= 1.0F) {
      return 1.0F;
    }
    int j = this.mL.length - 1;
    int i = 0;
    while (j - i > 1)
    {
      int k = (i + j) / 2;
      if (paramFloat < this.mL[k]) {
        j = k;
      } else {
        i = k;
      }
    }
    float f = this.mL[j] - this.mL[i];
    if (f == 0.0F) {
      return this.mM[i];
    }
    paramFloat = (paramFloat - this.mL[i]) / f;
    f = this.mM[i];
    return paramFloat * (this.mM[j] - f) + f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.v4.view.b.e
 * JD-Core Version:    0.7.0.1
 */