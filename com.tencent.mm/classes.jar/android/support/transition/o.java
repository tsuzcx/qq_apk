package android.support.transition;

import android.graphics.Rect;
import android.support.v4.view.u;
import android.view.ViewGroup;

public final class o
  extends am
{
  private float AP = 3.0F;
  int BH = 80;
  
  public final long a(ViewGroup paramViewGroup, Transition paramTransition, v paramv1, v paramv2)
  {
    if ((paramv1 == null) && (paramv2 == null)) {
      return 0L;
    }
    int j = 1;
    Rect localRect = paramTransition.getEpicenter();
    if ((paramv2 == null) || (e(paramv1) == 0))
    {
      j = -1;
      paramv2 = paramv1;
    }
    int n = am.a(paramv2, 0);
    int i1 = am.a(paramv2, 1);
    paramv1 = new int[2];
    paramViewGroup.getLocationOnScreen(paramv1);
    int i2 = paramv1[0] + Math.round(paramViewGroup.getTranslationX());
    int i3 = paramv1[1] + Math.round(paramViewGroup.getTranslationY());
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
      if (this.BH != 8388611) {
        break label345;
      }
      if (u.Z(paramViewGroup) != 1) {
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
        switch (this.BH)
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
      return Math.round((float)(l1 * j) / this.AP * f);
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
      if (this.BH == 8388613)
      {
        if (u.Z(paramViewGroup) == 1)
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
      i = this.BH;
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