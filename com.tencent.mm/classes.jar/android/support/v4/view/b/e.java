package android.support.v4.view.b;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.animation.Interpolator;

public final class e
  implements Interpolator
{
  private final float[] uj;
  private final float[] uk;
  
  public e()
  {
    this(localPath);
  }
  
  e(Path paramPath)
  {
    paramPath = new PathMeasure(paramPath, false);
    float f = paramPath.getLength();
    int j = (int)(f / 0.002F) + 1;
    this.uj = new float[j];
    this.uk = new float[j];
    float[] arrayOfFloat = new float[2];
    int i = 0;
    while (i < j)
    {
      paramPath.getPosTan(i * f / (j - 1), arrayOfFloat, null);
      this.uj[i] = arrayOfFloat[0];
      this.uk[i] = arrayOfFloat[1];
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
    int j = this.uj.length - 1;
    int i = 0;
    while (j - i > 1)
    {
      int k = (i + j) / 2;
      if (paramFloat < this.uj[k]) {
        j = k;
      } else {
        i = k;
      }
    }
    float f = this.uj[j] - this.uj[i];
    if (f == 0.0F) {
      return this.uk[i];
    }
    paramFloat = (paramFloat - this.uj[i]) / f;
    f = this.uk[i];
    return paramFloat * (this.uk[j] - f) + f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v4.view.b.e
 * JD-Core Version:    0.7.0.1
 */