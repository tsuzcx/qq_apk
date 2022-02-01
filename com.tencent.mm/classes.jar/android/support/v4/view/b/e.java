package android.support.v4.view.b;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.animation.Interpolator;

public final class e
  implements Interpolator
{
  private final float[] xb;
  private final float[] xc;
  
  public e()
  {
    this(localPath);
  }
  
  e(Path paramPath)
  {
    paramPath = new PathMeasure(paramPath, false);
    float f = paramPath.getLength();
    int j = (int)(f / 0.002F) + 1;
    this.xb = new float[j];
    this.xc = new float[j];
    float[] arrayOfFloat = new float[2];
    int i = 0;
    while (i < j)
    {
      paramPath.getPosTan(i * f / (j - 1), arrayOfFloat, null);
      this.xb[i] = arrayOfFloat[0];
      this.xc[i] = arrayOfFloat[1];
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
    int j = this.xb.length - 1;
    int i = 0;
    while (j - i > 1)
    {
      int k = (i + j) / 2;
      if (paramFloat < this.xb[k]) {
        j = k;
      } else {
        i = k;
      }
    }
    float f = this.xb[j] - this.xb[i];
    if (f == 0.0F) {
      return this.xc[i];
    }
    paramFloat = (paramFloat - this.xb[i]) / f;
    f = this.xc[i];
    return paramFloat * (this.xc[j] - f) + f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v4.view.b.e
 * JD-Core Version:    0.7.0.1
 */