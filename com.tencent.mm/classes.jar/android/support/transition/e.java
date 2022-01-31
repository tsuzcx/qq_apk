package android.support.transition;

import android.graphics.Rect;
import android.view.ViewGroup;

public final class e
  extends bc
{
  private float qw = 3.0F;
  
  private static float a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramFloat1 = paramFloat3 - paramFloat1;
    paramFloat2 = paramFloat4 - paramFloat2;
    return (float)Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2);
  }
  
  public final long a(ViewGroup paramViewGroup, Transition paramTransition, ai paramai1, ai paramai2)
  {
    if ((paramai1 == null) && (paramai2 == null)) {
      return 0L;
    }
    int i;
    int m;
    int n;
    int j;
    if ((paramai2 == null) || (e(paramai1) == 0))
    {
      i = -1;
      m = bc.a(paramai1, 0);
      n = bc.a(paramai1, 1);
      paramai1 = paramTransition.getEpicenter();
      if (paramai1 == null) {
        break label145;
      }
      j = paramai1.centerX();
    }
    for (int k = paramai1.centerY();; k = Math.round(paramai1[1] + paramViewGroup.getHeight() / 2 + paramViewGroup.getTranslationY()))
    {
      float f = a(m, n, j, k) / a(0.0F, 0.0F, paramViewGroup.getWidth(), paramViewGroup.getHeight());
      long l2 = paramTransition.mDuration;
      long l1 = l2;
      if (l2 < 0L) {
        l1 = 300L;
      }
      return Math.round((float)(l1 * i) / this.qw * f);
      i = 1;
      paramai1 = paramai2;
      break;
      label145:
      paramai1 = new int[2];
      paramViewGroup.getLocationOnScreen(paramai1);
      j = Math.round(paramai1[0] + paramViewGroup.getWidth() / 2 + paramViewGroup.getTranslationX());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.transition.e
 * JD-Core Version:    0.7.0.1
 */