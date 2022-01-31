package android.support.transition;

import android.graphics.Rect;
import android.view.ViewGroup;

public final class e
  extends bb
{
  private float rt = 3.0F;
  
  private static float b(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramFloat1 = paramFloat3 - paramFloat1;
    paramFloat2 = paramFloat4 - paramFloat2;
    return (float)Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2);
  }
  
  public final long a(ViewGroup paramViewGroup, Transition paramTransition, ah paramah1, ah paramah2)
  {
    if ((paramah1 == null) && (paramah2 == null)) {
      return 0L;
    }
    int i;
    int m;
    int n;
    int j;
    if ((paramah2 == null) || (e(paramah1) == 0))
    {
      i = -1;
      m = bb.a(paramah1, 0);
      n = bb.a(paramah1, 1);
      paramah1 = paramTransition.getEpicenter();
      if (paramah1 == null) {
        break label145;
      }
      j = paramah1.centerX();
    }
    for (int k = paramah1.centerY();; k = Math.round(paramah1[1] + paramViewGroup.getHeight() / 2 + paramViewGroup.getTranslationY()))
    {
      float f = b(m, n, j, k) / b(0.0F, 0.0F, paramViewGroup.getWidth(), paramViewGroup.getHeight());
      long l2 = paramTransition.mDuration;
      long l1 = l2;
      if (l2 < 0L) {
        l1 = 300L;
      }
      return Math.round((float)(l1 * i) / this.rt * f);
      i = 1;
      paramah1 = paramah2;
      break;
      label145:
      paramah1 = new int[2];
      paramViewGroup.getLocationOnScreen(paramah1);
      j = Math.round(paramah1[0] + paramViewGroup.getWidth() / 2 + paramViewGroup.getTranslationX());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.transition.e
 * JD-Core Version:    0.7.0.1
 */