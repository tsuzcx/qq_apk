package androidx.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public class Explode
  extends Visibility
{
  private static final TimeInterpolator aqt;
  private static final TimeInterpolator aqu;
  private int[] aqv;
  
  static
  {
    AppMethodBeat.i(192092);
    aqt = new DecelerateInterpolator();
    aqu = new AccelerateInterpolator();
    AppMethodBeat.o(192092);
  }
  
  public Explode()
  {
    AppMethodBeat.i(192051);
    this.aqv = new int[2];
    a(new b());
    AppMethodBeat.o(192051);
  }
  
  public Explode(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(192055);
    this.aqv = new int[2];
    a(new b());
    AppMethodBeat.o(192055);
  }
  
  private void a(View paramView, Rect paramRect, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(192082);
    paramView.getLocationOnScreen(this.aqv);
    int k = this.aqv[0];
    int m = this.aqv[1];
    Rect localRect = nu();
    int i;
    if (localRect == null) {
      i = paramView.getWidth() / 2 + k + Math.round(paramView.getTranslationX());
    }
    for (int j = paramView.getHeight() / 2 + m + Math.round(paramView.getTranslationY());; j = localRect.centerY())
    {
      int n = paramRect.centerX();
      int i1 = paramRect.centerY();
      float f3 = n - i;
      float f4 = i1 - j;
      float f2 = f3;
      float f1 = f4;
      if (f3 == 0.0F)
      {
        f2 = f3;
        f1 = f4;
        if (f4 == 0.0F)
        {
          f2 = (float)(Math.random() * 2.0D) - 1.0F;
          f1 = (float)(Math.random() * 2.0D) - 1.0F;
        }
      }
      f3 = i(f2, f1);
      f2 /= f3;
      f1 /= f3;
      f3 = j(paramView, i - k, j - m);
      paramArrayOfInt[0] = Math.round(f2 * f3);
      paramArrayOfInt[1] = Math.round(f3 * f1);
      AppMethodBeat.o(192082);
      return;
      i = localRect.centerX();
    }
  }
  
  private void a(w paramw)
  {
    AppMethodBeat.i(192061);
    View localView = paramw.view;
    localView.getLocationOnScreen(this.aqv);
    int i = this.aqv[0];
    int j = this.aqv[1];
    int k = localView.getWidth();
    int m = localView.getHeight();
    paramw.values.put("android:explode:screenBounds", new Rect(i, j, k + i, m + j));
    AppMethodBeat.o(192061);
  }
  
  private static float i(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(192089);
    paramFloat1 = (float)Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2);
    AppMethodBeat.o(192089);
    return paramFloat1;
  }
  
  private static float j(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(192084);
    paramInt1 = Math.max(paramInt1, paramView.getWidth() - paramInt1);
    paramInt2 = Math.max(paramInt2, paramView.getHeight() - paramInt2);
    float f = i(paramInt1, paramInt2);
    AppMethodBeat.o(192084);
    return f;
  }
  
  public final Animator a(ViewGroup paramViewGroup, View paramView, w paramw)
  {
    AppMethodBeat.i(192075);
    if (paramw == null)
    {
      AppMethodBeat.o(192075);
      return null;
    }
    Rect localRect = (Rect)paramw.values.get("android:explode:screenBounds");
    int i = localRect.left;
    int j = localRect.top;
    float f3 = paramView.getTranslationX();
    float f4 = paramView.getTranslationY();
    int[] arrayOfInt = (int[])paramw.view.getTag(m.a.transition_position);
    float f2;
    float f1;
    if (arrayOfInt != null)
    {
      f2 = f3 + (arrayOfInt[0] - localRect.left);
      f1 = arrayOfInt[1] - localRect.top;
      localRect.offsetTo(arrayOfInt[0], arrayOfInt[1]);
      f1 += f4;
    }
    for (;;)
    {
      a(paramViewGroup, localRect, this.aqv);
      paramViewGroup = y.a(paramView, paramw, i, j, f3, f4, f2 + this.aqv[0], f1 + this.aqv[1], aqu);
      AppMethodBeat.o(192075);
      return paramViewGroup;
      f1 = f4;
      f2 = f3;
    }
  }
  
  public final Animator a(ViewGroup paramViewGroup, View paramView, w paramw1, w paramw2)
  {
    AppMethodBeat.i(192068);
    if (paramw2 == null)
    {
      AppMethodBeat.o(192068);
      return null;
    }
    paramw1 = (Rect)paramw2.values.get("android:explode:screenBounds");
    float f1 = paramView.getTranslationX();
    float f2 = paramView.getTranslationY();
    a(paramViewGroup, paramw1, this.aqv);
    float f3 = this.aqv[0];
    float f4 = this.aqv[1];
    paramViewGroup = y.a(paramView, paramw2, paramw1.left, paramw1.top, f1 + f3, f2 + f4, f1, f2, aqt);
    AppMethodBeat.o(192068);
    return paramViewGroup;
  }
  
  public final void b(w paramw)
  {
    AppMethodBeat.i(192062);
    super.b(paramw);
    a(paramw);
    AppMethodBeat.o(192062);
  }
  
  public final void c(w paramw)
  {
    AppMethodBeat.i(192065);
    super.c(paramw);
    a(paramw);
    AppMethodBeat.o(192065);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.transition.Explode
 * JD-Core Version:    0.7.0.1
 */