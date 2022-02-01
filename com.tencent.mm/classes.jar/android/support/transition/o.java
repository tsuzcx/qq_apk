package android.support.transition;

import android.graphics.Rect;
import android.support.v4.view.t;
import android.view.ViewGroup;

public final class o
  extends al
{
  private float xS = 3.0F;
  int yJ = 80;
  
  public final long a(ViewGroup paramViewGroup, Transition paramTransition, u paramu1, u paramu2)
  {
    if ((paramu1 == null) && (paramu2 == null)) {
      return 0L;
    }
    int j = 1;
    Rect localRect = paramTransition.getEpicenter();
    if ((paramu2 == null) || (e(paramu1) == 0))
    {
      j = -1;
      paramu2 = paramu1;
    }
    int n = al.a(paramu2, 0);
    int i1 = al.a(paramu2, 1);
    paramu1 = new int[2];
    paramViewGroup.getLocationOnScreen(paramu1);
    int i2 = paramu1[0] + Math.round(paramViewGroup.getTranslationX());
    int i3 = paramu1[1] + Math.round(paramViewGroup.getTranslationY());
    int i4 = i2 + paramViewGroup.getWidth();
    int i5 = i3 + paramViewGroup.getHeight();
    int k;
    int m;
    label146:
    label154:
    label203:
    float f;
    if (localRect != null)
    {
      k = localRect.centerX();
      m = localRect.centerY();
      if (this.yJ != 8388611) {
        break label345;
      }
      if (t.Y(paramViewGroup) != 1) {
        break label333;
      }
      i = 1;
      if (i == 0) {
        break label339;
      }
      i = 5;
      switch (i)
      {
      default: 
        i = 0;
        f = i;
        switch (this.yJ)
        {
        }
        break;
      }
    }
    for (int i = paramViewGroup.getHeight();; i = paramViewGroup.getWidth())
    {
      f /= i;
      long l2 = paramTransition.mDuration;
      long l1 = l2;
      if (l2 < 0L) {
        l1 = 300L;
      }
      return Math.round((float)(l1 * j) / this.xS * f);
      k = (i2 + i4) / 2;
      m = (i3 + i5) / 2;
      break;
      label333:
      i = 0;
      break label146;
      label339:
      i = 3;
      break label154;
      label345:
      if (this.yJ == 8388613)
      {
        if (t.Y(paramViewGroup) == 1)
        {
          i = 1;
          label365:
          if (i == 0) {
            break label382;
          }
        }
        label382:
        for (i = 3;; i = 5)
        {
          break;
          i = 0;
          break label365;
        }
      }
      i = this.yJ;
      break label154;
      i = i4 - n + Math.abs(m - i1);
      break label203;
      i = Math.abs(k - n) + (i5 - i1);
      break label203;
      i = n - i2 + Math.abs(m - i1);
      break label203;
      i = Math.abs(k - n) + (i1 - i3);
      break label203;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.transition.o
 * JD-Core Version:    0.7.0.1
 */