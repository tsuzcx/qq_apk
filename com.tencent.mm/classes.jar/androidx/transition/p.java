package androidx.transition;

import android.graphics.Rect;
import android.view.ViewGroup;
import androidx.core.g.z;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class p
  extends an
{
  int cfI = 80;
  private float cfa = 3.0F;
  
  public final long a(ViewGroup paramViewGroup, Transition paramTransition, w paramw1, w paramw2)
  {
    AppMethodBeat.i(201610);
    if ((paramw1 == null) && (paramw2 == null))
    {
      AppMethodBeat.o(201610);
      return 0L;
    }
    int j = 1;
    Rect localRect = paramTransition.LX();
    if ((paramw2 == null) || (e(paramw1) == 0))
    {
      j = -1;
      paramw2 = paramw1;
    }
    int n = f(paramw2);
    int i1 = g(paramw2);
    paramw1 = new int[2];
    paramViewGroup.getLocationOnScreen(paramw1);
    int i2 = paramw1[0] + Math.round(paramViewGroup.getTranslationX());
    int i3 = paramw1[1] + Math.round(paramViewGroup.getTranslationY());
    int i4 = i2 + paramViewGroup.getWidth();
    int i5 = i3 + paramViewGroup.getHeight();
    int k;
    int m;
    label154:
    label162:
    label211:
    float f;
    if (localRect != null)
    {
      k = localRect.centerX();
      m = localRect.centerY();
      if (this.cfI != 8388611) {
        break label362;
      }
      if (z.U(paramViewGroup) != 1) {
        break label350;
      }
      i = 1;
      if (i == 0) {
        break label356;
      }
      i = 5;
      switch (i)
      {
      default: 
        i = 0;
        f = i;
        switch (this.cfI)
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
      l1 = Math.round((float)(l1 * j) / this.cfa * f);
      AppMethodBeat.o(201610);
      return l1;
      k = (i2 + i4) / 2;
      m = (i3 + i5) / 2;
      break;
      label350:
      i = 0;
      break label154;
      label356:
      i = 3;
      break label162;
      label362:
      if (this.cfI == 8388613)
      {
        if (z.U(paramViewGroup) == 1)
        {
          i = 1;
          label382:
          if (i == 0) {
            break label399;
          }
        }
        for (i = 3;; i = 5)
        {
          break;
          i = 0;
          break label382;
        }
      }
      label399:
      i = this.cfI;
      break label162;
      i = i4 - n + Math.abs(m - i1);
      break label211;
      i = Math.abs(k - n) + (i5 - i1);
      break label211;
      i = n - i2 + Math.abs(m - i1);
      break label211;
      i = Math.abs(k - n) + (i1 - i3);
      break label211;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.transition.p
 * JD-Core Version:    0.7.0.1
 */