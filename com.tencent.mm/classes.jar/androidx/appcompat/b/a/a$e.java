package androidx.appcompat.b.a;

import android.animation.TimeInterpolator;
import android.graphics.drawable.AnimationDrawable;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$e
  implements TimeInterpolator
{
  private int[] jH;
  private int jI;
  int jJ;
  
  a$e(AnimationDrawable paramAnimationDrawable, boolean paramBoolean)
  {
    AppMethodBeat.i(199268);
    a(paramAnimationDrawable, paramBoolean);
    AppMethodBeat.o(199268);
  }
  
  private int a(AnimationDrawable paramAnimationDrawable, boolean paramBoolean)
  {
    AppMethodBeat.i(199274);
    int m = paramAnimationDrawable.getNumberOfFrames();
    this.jI = m;
    if ((this.jH == null) || (this.jH.length < m)) {
      this.jH = new int[m];
    }
    int[] arrayOfInt = this.jH;
    int i = 0;
    int j = 0;
    if (i < m)
    {
      if (paramBoolean) {}
      for (int k = m - i - 1;; k = i)
      {
        k = paramAnimationDrawable.getDuration(k);
        arrayOfInt[i] = k;
        i += 1;
        j = k + j;
        break;
      }
    }
    this.jJ = j;
    AppMethodBeat.o(199274);
    return j;
  }
  
  public final float getInterpolation(float paramFloat)
  {
    int j = (int)(this.jJ * paramFloat + 0.5F);
    int k = this.jI;
    int[] arrayOfInt = this.jH;
    int i = 0;
    while ((i < k) && (j >= arrayOfInt[i]))
    {
      j -= arrayOfInt[i];
      i += 1;
    }
    if (i < k) {}
    for (paramFloat = j / this.jJ;; paramFloat = 0.0F) {
      return paramFloat + i / k;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.appcompat.b.a.a.e
 * JD-Core Version:    0.7.0.1
 */