package android.support.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import java.util.Map;

public class Explode
  extends Visibility
{
  private static final TimeInterpolator AK = new DecelerateInterpolator();
  private static final TimeInterpolator AL = new AccelerateInterpolator();
  private int[] AM = new int[2];
  
  public Explode()
  {
    a(new b());
  }
  
  public Explode(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(new b());
  }
  
  private void a(View paramView, Rect paramRect, int[] paramArrayOfInt)
  {
    paramView.getLocationOnScreen(this.AM);
    int k = this.AM[0];
    int m = this.AM[1];
    Rect localRect = getEpicenter();
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
      f3 = g(f2, f1);
      f2 /= f3;
      f1 /= f3;
      f3 = f(paramView, i - k, j - m);
      paramArrayOfInt[0] = Math.round(f2 * f3);
      paramArrayOfInt[1] = Math.round(f3 * f1);
      return;
      i = localRect.centerX();
    }
  }
  
  private void c(u paramu)
  {
    View localView = paramu.view;
    localView.getLocationOnScreen(this.AM);
    int i = this.AM[0];
    int j = this.AM[1];
    int k = localView.getWidth();
    int m = localView.getHeight();
    paramu.values.put("android:explode:screenBounds", new Rect(i, j, k + i, m + j));
  }
  
  private static float f(View paramView, int paramInt1, int paramInt2)
  {
    paramInt1 = Math.max(paramInt1, paramView.getWidth() - paramInt1);
    paramInt2 = Math.max(paramInt2, paramView.getHeight() - paramInt2);
    return g(paramInt1, paramInt2);
  }
  
  private static float g(float paramFloat1, float paramFloat2)
  {
    return (float)Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2);
  }
  
  public final Animator a(ViewGroup paramViewGroup, View paramView, u paramu)
  {
    if (paramu == null) {
      return null;
    }
    Rect localRect = (Rect)paramu.values.get("android:explode:screenBounds");
    int i = localRect.left;
    int j = localRect.top;
    float f3 = paramView.getTranslationX();
    float f4 = paramView.getTranslationY();
    int[] arrayOfInt = (int[])paramu.view.getTag(2131306068);
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
      a(paramViewGroup, localRect, this.AM);
      return w.a(paramView, paramu, i, j, f3, f4, f2 + this.AM[0], f1 + this.AM[1], AL);
      f1 = f4;
      f2 = f3;
    }
  }
  
  public final Animator a(ViewGroup paramViewGroup, View paramView, u paramu1, u paramu2)
  {
    if (paramu2 == null) {
      return null;
    }
    paramu1 = (Rect)paramu2.values.get("android:explode:screenBounds");
    float f1 = paramView.getTranslationX();
    float f2 = paramView.getTranslationY();
    a(paramViewGroup, paramu1, this.AM);
    float f3 = this.AM[0];
    float f4 = this.AM[1];
    return w.a(paramView, paramu2, paramu1.left, paramu1.top, f1 + f3, f2 + f4, f1, f2, AK);
  }
  
  public final void a(u paramu)
  {
    super.a(paramu);
    c(paramu);
  }
  
  public final void b(u paramu)
  {
    super.b(paramu);
    c(paramu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.transition.Explode
 * JD-Core Version:    0.7.0.1
 */