package androidx.appcompat.b.a;

import android.animation.TimeInterpolator;
import android.graphics.drawable.AnimationDrawable;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$e
  implements TimeInterpolator
{
  private int[] iM;
  private int iN;
  int iO;
  
  a$e(AnimationDrawable paramAnimationDrawable, boolean paramBoolean)
  {
    AppMethodBeat.i(238658);
    a(paramAnimationDrawable, paramBoolean);
    AppMethodBeat.o(238658);
  }
  
  private int a(AnimationDrawable paramAnimationDrawable, boolean paramBoolean)
  {
    AppMethodBeat.i(238659);
    int m = paramAnimationDrawable.getNumberOfFrames();
    this.iN = m;
    if ((this.iM == null) || (this.iM.length < m)) {
      this.iM = new int[m];
    }
    int[] arrayOfInt = this.iM;
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
    this.iO = j;
    AppMethodBeat.o(238659);
    return j;
  }
  
  public final float getInterpolation(float paramFloat)
  {
    int j = (int)(this.iO * paramFloat + 0.5F);
    int k = this.iN;
    int[] arrayOfInt = this.iM;
    int i = 0;
    while ((i < k) && (j >= arrayOfInt[i]))
    {
      j -= arrayOfInt[i];
      i += 1;
    }
    if (i < k) {}
    for (paramFloat = j / this.iO;; paramFloat = 0.0F) {
      return paramFloat + i / k;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.appcompat.b.a.a.e
 * JD-Core Version:    0.7.0.1
 */