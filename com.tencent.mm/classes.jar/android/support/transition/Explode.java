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
  private static final TimeInterpolator qx = new DecelerateInterpolator();
  private static final TimeInterpolator qy = new AccelerateInterpolator();
  private int[] qz = new int[2];
  
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
    paramView.getLocationOnScreen(this.qz);
    int m = this.qz[0];
    int k = this.qz[1];
    Rect localRect = getEpicenter();
    int j;
    if (localRect == null)
    {
      i = paramView.getWidth() / 2;
      j = Math.round(paramView.getTranslationX()) + (i + m);
    }
    for (int i = paramView.getHeight() / 2 + k + Math.round(paramView.getTranslationY());; i = localRect.centerY())
    {
      int n = paramRect.centerX();
      int i1 = paramRect.centerY();
      float f3 = n - j;
      float f4 = i1 - i;
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
      j -= m;
      i -= k;
      j = Math.max(j, paramView.getWidth() - j);
      i = Math.max(i, paramView.getHeight() - i);
      f3 = q(j, i);
      paramArrayOfInt[0] = Math.round(f2 * f3);
      paramArrayOfInt[1] = Math.round(f3 * f1);
      return;
      j = localRect.centerX();
    }
  }
  
  private void c(ai paramai)
  {
    View localView = paramai.view;
    localView.getLocationOnScreen(this.qz);
    int i = this.qz[0];
    int j = this.qz[1];
    int k = localView.getWidth();
    int m = localView.getHeight();
    paramai.values.put("android:explode:screenBounds", new Rect(i, j, k + i, m + j));
  }
  
  private static float q(float paramFloat1, float paramFloat2)
  {
    return (float)Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2);
  }
  
  public final Animator a(ViewGroup paramViewGroup, View paramView, ai paramai)
  {
    if (paramai == null) {
      return null;
    }
    Rect localRect = (Rect)paramai.values.get("android:explode:screenBounds");
    int i = localRect.left;
    int j = localRect.top;
    float f3 = paramView.getTranslationX();
    float f4 = paramView.getTranslationY();
    int[] arrayOfInt = (int[])paramai.view.getTag(z.a.transition_position);
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
      a(paramViewGroup, localRect, this.qz);
      return ak.a(paramView, paramai, i, j, f3, f4, f2 + this.qz[0], f1 + this.qz[1], qy);
      f1 = f4;
      f2 = f3;
    }
  }
  
  public final Animator a(ViewGroup paramViewGroup, View paramView, ai paramai1, ai paramai2)
  {
    if (paramai2 == null) {
      return null;
    }
    paramai1 = (Rect)paramai2.values.get("android:explode:screenBounds");
    float f1 = paramView.getTranslationX();
    float f2 = paramView.getTranslationY();
    a(paramViewGroup, paramai1, this.qz);
    float f3 = this.qz[0];
    float f4 = this.qz[1];
    return ak.a(paramView, paramai2, paramai1.left, paramai1.top, f1 + f3, f2 + f4, f1, f2, qx);
  }
  
  public final void a(ai paramai)
  {
    super.a(paramai);
    c(paramai);
  }
  
  public final void b(ai paramai)
  {
    super.b(paramai);
    c(paramai);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.transition.Explode
 * JD-Core Version:    0.7.0.1
 */