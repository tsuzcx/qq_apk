package android.support.design.internal;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.support.transition.Transition;
import android.support.transition.ah;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.Map;

public final class e
  extends Transition
{
  private static void c(ah paramah)
  {
    if ((paramah.view instanceof TextView))
    {
      TextView localTextView = (TextView)paramah.view;
      paramah.values.put("android:textscale:scale", Float.valueOf(localTextView.getScaleX()));
    }
  }
  
  public final Animator a(ViewGroup paramViewGroup, ah paramah1, ah paramah2)
  {
    float f2 = 1.0F;
    if ((paramah1 == null) || (paramah2 == null) || (!(paramah1.view instanceof TextView)) || (!(paramah2.view instanceof TextView))) {
      return null;
    }
    paramViewGroup = (TextView)paramah2.view;
    paramah1 = paramah1.values;
    paramah2 = paramah2.values;
    if (paramah1.get("android:textscale:scale") != null) {}
    for (float f1 = ((Float)paramah1.get("android:textscale:scale")).floatValue();; f1 = 1.0F)
    {
      if (paramah2.get("android:textscale:scale") != null) {
        f2 = ((Float)paramah2.get("android:textscale:scale")).floatValue();
      }
      if (f1 != f2) {
        break;
      }
      return null;
    }
    paramah1 = ValueAnimator.ofFloat(new float[] { f1, f2 });
    paramah1.addUpdateListener(new e.1(this, paramViewGroup));
    return paramah1;
  }
  
  public final void a(ah paramah)
  {
    c(paramah);
  }
  
  public final void b(ah paramah)
  {
    c(paramah);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.design.internal.e
 * JD-Core Version:    0.7.0.1
 */