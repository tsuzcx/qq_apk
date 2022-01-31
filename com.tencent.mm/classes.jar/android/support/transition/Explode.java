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
  private static final TimeInterpolator ru = new DecelerateInterpolator();
  private static final TimeInterpolator rv = new AccelerateInterpolator();
  private int[] rw = new int[2];
  
  public Explode()
  {
    a(new e());
  }
  
  public Explode(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(new e());
  }
  
  private void a(View paramView, Rect paramRect, int[] paramArrayOfInt)
  {
    paramView.getLocationOnScreen(this.rw);
    int k = this.rw[0];
    int m = this.rw[1];
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
      f3 = q(f2, f1);
      f2 /= f3;
      f1 /= f3;
      f3 = g(paramView, i - k, j - m);
      paramArrayOfInt[0] = Math.round(f2 * f3);
      paramArrayOfInt[1] = Math.round(f3 * f1);
      return;
      i = localRect.centerX();
    }
  }
  
  private void c(ah paramah)
  {
    View localView = paramah.view;
    localView.getLocationOnScreen(this.rw);
    int i = this.rw[0];
    int j = this.rw[1];
    int k = localView.getWidth();
    int m = localView.getHeight();
    paramah.values.put("android:explode:screenBounds", new Rect(i, j, k + i, m + j));
  }
  
  private static float g(View paramView, int paramInt1, int paramInt2)
  {
    paramInt1 = Math.max(paramInt1, paramView.getWidth() - paramInt1);
    paramInt2 = Math.max(paramInt2, paramView.getHeight() - paramInt2);
    return q(paramInt1, paramInt2);
  }
  
  private static float q(float paramFloat1, float paramFloat2)
  {
    return (float)Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2);
  }
  
  public final Animator a(ViewGroup paramViewGroup, View paramView, ah paramah)
  {
    if (paramah == null) {
      return null;
    }
    Rect localRect = (Rect)paramah.values.get("android:explode:screenBounds");
    int i = localRect.left;
    int j = localRect.top;
    float f3 = paramView.getTranslationX();
    float f4 = paramView.getTranslationY();
    int[] arrayOfInt = (int[])paramah.view.getTag(2131820684);
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
      a(paramViewGroup, localRect, this.rw);
      return aj.a(paramView, paramah, i, j, f3, f4, f2 + this.rw[0], f1 + this.rw[1], rv);
      f1 = f4;
      f2 = f3;
    }
  }
  
  public final Animator a(ViewGroup paramViewGroup, View paramView, ah paramah1, ah paramah2)
  {
    if (paramah2 == null) {
      return null;
    }
    paramah1 = (Rect)paramah2.values.get("android:explode:screenBounds");
    float f1 = paramView.getTranslationX();
    float f2 = paramView.getTranslationY();
    a(paramViewGroup, paramah1, this.rw);
    float f3 = this.rw[0];
    float f4 = this.rw[1];
    return aj.a(paramView, paramah2, paramah1.left, paramah1.top, f1 + f3, f2 + f4, f1, f2, ru);
  }
  
  public final void a(ah paramah)
  {
    super.a(paramah);
    c(paramah);
  }
  
  public final void b(ah paramah)
  {
    super.b(paramah);
    c(paramah);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.transition.Explode
 * JD-Core Version:    0.7.0.1
 */