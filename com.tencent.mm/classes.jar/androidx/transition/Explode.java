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
  private static final TimeInterpolator cfb;
  private static final TimeInterpolator cfc;
  private int[] cfd;
  
  static
  {
    AppMethodBeat.i(201325);
    cfb = new DecelerateInterpolator();
    cfc = new AccelerateInterpolator();
    AppMethodBeat.o(201325);
  }
  
  public Explode()
  {
    AppMethodBeat.i(201239);
    this.cfd = new int[2];
    a(new b());
    AppMethodBeat.o(201239);
  }
  
  public Explode(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(201250);
    this.cfd = new int[2];
    a(new b());
    AppMethodBeat.o(201250);
  }
  
  private static float R(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(201311);
    paramFloat1 = (float)Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2);
    AppMethodBeat.o(201311);
    return paramFloat1;
  }
  
  private void a(View paramView, Rect paramRect, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(201286);
    paramView.getLocationOnScreen(this.cfd);
    int k = this.cfd[0];
    int m = this.cfd[1];
    Rect localRect = LX();
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
      f3 = R(f2, f1);
      f2 /= f3;
      f1 /= f3;
      f3 = j(paramView, i - k, j - m);
      paramArrayOfInt[0] = Math.round(f2 * f3);
      paramArrayOfInt[1] = Math.round(f3 * f1);
      AppMethodBeat.o(201286);
      return;
      i = localRect.centerX();
    }
  }
  
  private void a(w paramw)
  {
    AppMethodBeat.i(201266);
    View localView = paramw.view;
    localView.getLocationOnScreen(this.cfd);
    int i = this.cfd[0];
    int j = this.cfd[1];
    int k = localView.getWidth();
    int m = localView.getHeight();
    paramw.values.put("android:explode:screenBounds", new Rect(i, j, k + i, m + j));
    AppMethodBeat.o(201266);
  }
  
  private static float j(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(201299);
    paramInt1 = Math.max(paramInt1, paramView.getWidth() - paramInt1);
    paramInt2 = Math.max(paramInt2, paramView.getHeight() - paramInt2);
    float f = R(paramInt1, paramInt2);
    AppMethodBeat.o(201299);
    return f;
  }
  
  public final Animator a(ViewGroup paramViewGroup, View paramView, w paramw)
  {
    AppMethodBeat.i(201377);
    if (paramw == null)
    {
      AppMethodBeat.o(201377);
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
      a(paramViewGroup, localRect, this.cfd);
      paramViewGroup = y.a(paramView, paramw, i, j, f3, f4, f2 + this.cfd[0], f1 + this.cfd[1], cfc);
      AppMethodBeat.o(201377);
      return paramViewGroup;
      f1 = f4;
      f2 = f3;
    }
  }
  
  public final Animator a(ViewGroup paramViewGroup, View paramView, w paramw1, w paramw2)
  {
    AppMethodBeat.i(201365);
    if (paramw2 == null)
    {
      AppMethodBeat.o(201365);
      return null;
    }
    paramw1 = (Rect)paramw2.values.get("android:explode:screenBounds");
    float f1 = paramView.getTranslationX();
    float f2 = paramView.getTranslationY();
    a(paramViewGroup, paramw1, this.cfd);
    float f3 = this.cfd[0];
    float f4 = this.cfd[1];
    paramViewGroup = y.a(paramView, paramw2, paramw1.left, paramw1.top, f1 + f3, f2 + f4, f1, f2, cfb);
    AppMethodBeat.o(201365);
    return paramViewGroup;
  }
  
  public final void b(w paramw)
  {
    AppMethodBeat.i(201337);
    super.b(paramw);
    a(paramw);
    AppMethodBeat.o(201337);
  }
  
  public final void c(w paramw)
  {
    AppMethodBeat.i(201347);
    super.c(paramw);
    a(paramw);
    AppMethodBeat.o(201347);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.transition.Explode
 * JD-Core Version:    0.7.0.1
 */