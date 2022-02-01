package androidx.core.g.b;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  implements Interpolator
{
  private final float[] bvM;
  private final float[] bvN;
  
  public a()
  {
    this(localPath);
    AppMethodBeat.i(195648);
    AppMethodBeat.o(195648);
  }
  
  a(Path paramPath)
  {
    AppMethodBeat.i(195635);
    paramPath = new PathMeasure(paramPath, false);
    float f = paramPath.getLength();
    int j = (int)(f / 0.002F) + 1;
    this.bvM = new float[j];
    this.bvN = new float[j];
    float[] arrayOfFloat = new float[2];
    int i = 0;
    while (i < j)
    {
      paramPath.getPosTan(i * f / (j - 1), arrayOfFloat, null);
      this.bvM[i] = arrayOfFloat[0];
      this.bvN[i] = arrayOfFloat[1];
      i += 1;
    }
    AppMethodBeat.o(195635);
  }
  
  public final float getInterpolation(float paramFloat)
  {
    if (paramFloat <= 0.0F) {
      return 0.0F;
    }
    if (paramFloat >= 1.0F) {
      return 1.0F;
    }
    int j = this.bvM.length - 1;
    int i = 0;
    while (j - i > 1)
    {
      int k = (i + j) / 2;
      if (paramFloat < this.bvM[k]) {
        j = k;
      } else {
        i = k;
      }
    }
    float f = this.bvM[j] - this.bvM[i];
    if (f == 0.0F) {
      return this.bvN[i];
    }
    paramFloat = (paramFloat - this.bvM[i]) / f;
    f = this.bvN[i];
    return paramFloat * (this.bvN[j] - f) + f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.core.g.b.a
 * JD-Core Version:    0.7.0.1
 */