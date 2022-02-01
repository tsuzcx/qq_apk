package androidx.transition;

import android.graphics.Rect;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends an
{
  private float aqs = 3.0F;
  
  private static float d(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AppMethodBeat.i(192044);
    paramFloat1 = paramFloat3 - paramFloat1;
    paramFloat2 = paramFloat4 - paramFloat2;
    paramFloat1 = (float)Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2);
    AppMethodBeat.o(192044);
    return paramFloat1;
  }
  
  public final long a(ViewGroup paramViewGroup, Transition paramTransition, w paramw1, w paramw2)
  {
    AppMethodBeat.i(192040);
    if ((paramw1 == null) && (paramw2 == null))
    {
      AppMethodBeat.o(192040);
      return 0L;
    }
    int i;
    int m;
    int n;
    int j;
    if ((paramw2 == null) || (e(paramw1) == 0))
    {
      i = -1;
      m = f(paramw1);
      n = g(paramw1);
      paramw1 = paramTransition.nu();
      if (paramw1 == null) {
        break label162;
      }
      j = paramw1.centerX();
    }
    for (int k = paramw1.centerY();; k = Math.round(paramw1[1] + paramViewGroup.getHeight() / 2 + paramViewGroup.getTranslationY()))
    {
      float f = d(m, n, j, k) / d(0.0F, 0.0F, paramViewGroup.getWidth(), paramViewGroup.getHeight());
      long l2 = paramTransition.mDuration;
      long l1 = l2;
      if (l2 < 0L) {
        l1 = 300L;
      }
      l1 = Math.round((float)(l1 * i) / this.aqs * f);
      AppMethodBeat.o(192040);
      return l1;
      i = 1;
      paramw1 = paramw2;
      break;
      label162:
      paramw1 = new int[2];
      paramViewGroup.getLocationOnScreen(paramw1);
      j = Math.round(paramw1[0] + paramViewGroup.getWidth() / 2 + paramViewGroup.getTranslationX());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.transition.b
 * JD-Core Version:    0.7.0.1
 */