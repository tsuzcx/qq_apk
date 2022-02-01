package android.support.transition;

import android.graphics.Rect;
import android.view.ViewGroup;

public final class b
  extends al
{
  private float AJ = 3.0F;
  
  private static float e(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramFloat1 = paramFloat3 - paramFloat1;
    paramFloat2 = paramFloat4 - paramFloat2;
    return (float)Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2);
  }
  
  public final long a(ViewGroup paramViewGroup, Transition paramTransition, u paramu1, u paramu2)
  {
    if ((paramu1 == null) && (paramu2 == null)) {
      return 0L;
    }
    int i;
    int m;
    int n;
    int j;
    if ((paramu2 == null) || (e(paramu1) == 0))
    {
      i = -1;
      m = al.a(paramu1, 0);
      n = al.a(paramu1, 1);
      paramu1 = paramTransition.getEpicenter();
      if (paramu1 == null) {
        break label145;
      }
      j = paramu1.centerX();
    }
    for (int k = paramu1.centerY();; k = Math.round(paramu1[1] + paramViewGroup.getHeight() / 2 + paramViewGroup.getTranslationY()))
    {
      float f = e(m, n, j, k) / e(0.0F, 0.0F, paramViewGroup.getWidth(), paramViewGroup.getHeight());
      long l2 = paramTransition.mDuration;
      long l1 = l2;
      if (l2 < 0L) {
        l1 = 300L;
      }
      return Math.round((float)(l1 * i) / this.AJ * f);
      i = 1;
      paramu1 = paramu2;
      break;
      label145:
      paramu1 = new int[2];
      paramViewGroup.getLocationOnScreen(paramu1);
      j = Math.round(paramu1[0] + paramViewGroup.getWidth() / 2 + paramViewGroup.getTranslationX());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.transition.b
 * JD-Core Version:    0.7.0.1
 */