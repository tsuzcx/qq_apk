package android.support.transition;

import android.graphics.Rect;
import android.view.ViewGroup;

public final class b
  extends am
{
  private float AP = 3.0F;
  
  private static float e(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramFloat1 = paramFloat3 - paramFloat1;
    paramFloat2 = paramFloat4 - paramFloat2;
    return (float)Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2);
  }
  
  public final long a(ViewGroup paramViewGroup, Transition paramTransition, v paramv1, v paramv2)
  {
    if ((paramv1 == null) && (paramv2 == null)) {
      return 0L;
    }
    int i;
    int m;
    int n;
    int j;
    if ((paramv2 == null) || (e(paramv1) == 0))
    {
      i = -1;
      m = am.a(paramv1, 0);
      n = am.a(paramv1, 1);
      paramv1 = paramTransition.getEpicenter();
      if (paramv1 == null) {
        break label145;
      }
      j = paramv1.centerX();
    }
    for (int k = paramv1.centerY();; k = Math.round(paramv1[1] + paramViewGroup.getHeight() / 2 + paramViewGroup.getTranslationY()))
    {
      float f = e(m, n, j, k) / e(0.0F, 0.0F, paramViewGroup.getWidth(), paramViewGroup.getHeight());
      long l2 = paramTransition.mDuration;
      long l1 = l2;
      if (l2 < 0L) {
        l1 = 300L;
      }
      return Math.round((float)(l1 * i) / this.AP * f);
      i = 1;
      paramv1 = paramv2;
      break;
      label145:
      paramv1 = new int[2];
      paramViewGroup.getLocationOnScreen(paramv1);
      j = Math.round(paramv1[0] + paramViewGroup.getWidth() / 2 + paramViewGroup.getTranslationX());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.transition.b
 * JD-Core Version:    0.7.0.1
 */