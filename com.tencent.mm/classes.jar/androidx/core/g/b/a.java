package androidx.core.g.b;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  implements Interpolator
{
  private final float[] Pu;
  private final float[] Pv;
  
  public a()
  {
    this(localPath);
    AppMethodBeat.i(252285);
    AppMethodBeat.o(252285);
  }
  
  a(Path paramPath)
  {
    AppMethodBeat.i(252284);
    paramPath = new PathMeasure(paramPath, false);
    float f = paramPath.getLength();
    int j = (int)(f / 0.002F) + 1;
    this.Pu = new float[j];
    this.Pv = new float[j];
    float[] arrayOfFloat = new float[2];
    int i = 0;
    while (i < j)
    {
      paramPath.getPosTan(i * f / (j - 1), arrayOfFloat, null);
      this.Pu[i] = arrayOfFloat[0];
      this.Pv[i] = arrayOfFloat[1];
      i += 1;
    }
    AppMethodBeat.o(252284);
  }
  
  public final float getInterpolation(float paramFloat)
  {
    if (paramFloat <= 0.0F) {
      return 0.0F;
    }
    if (paramFloat >= 1.0F) {
      return 1.0F;
    }
    int j = this.Pu.length - 1;
    int i = 0;
    while (j - i > 1)
    {
      int k = (i + j) / 2;
      if (paramFloat < this.Pu[k]) {
        j = k;
      } else {
        i = k;
      }
    }
    float f = this.Pu[j] - this.Pu[i];
    if (f == 0.0F) {
      return this.Pv[i];
    }
    paramFloat = (paramFloat - this.Pu[i]) / f;
    f = this.Pv[i];
    return paramFloat * (this.Pv[j] - f) + f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.core.g.b.a
 * JD-Core Version:    0.7.0.1
 */