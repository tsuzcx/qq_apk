package android.support.design.internal;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.support.transition.Transition;
import android.support.transition.v;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.Map;

public final class e
  extends Transition
{
  private static void c(v paramv)
  {
    if ((paramv.view instanceof TextView))
    {
      TextView localTextView = (TextView)paramv.view;
      paramv.values.put("android:textscale:scale", Float.valueOf(localTextView.getScaleX()));
    }
  }
  
  public final Animator a(final ViewGroup paramViewGroup, v paramv1, v paramv2)
  {
    float f2 = 1.0F;
    if ((paramv1 == null) || (paramv2 == null) || (!(paramv1.view instanceof TextView)) || (!(paramv2.view instanceof TextView))) {
      return null;
    }
    paramViewGroup = (TextView)paramv2.view;
    paramv1 = paramv1.values;
    paramv2 = paramv2.values;
    if (paramv1.get("android:textscale:scale") != null) {}
    for (float f1 = ((Float)paramv1.get("android:textscale:scale")).floatValue();; f1 = 1.0F)
    {
      if (paramv2.get("android:textscale:scale") != null) {
        f2 = ((Float)paramv2.get("android:textscale:scale")).floatValue();
      }
      if (f1 != f2) {
        break;
      }
      return null;
    }
    paramv1 = ValueAnimator.ofFloat(new float[] { f1, f2 });
    paramv1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        paramViewGroup.setScaleX(f);
        paramViewGroup.setScaleY(f);
      }
    });
    return paramv1;
  }
  
  public final void a(v paramv)
  {
    c(paramv);
  }
  
  public final void b(v paramv)
  {
    c(paramv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.design.internal.e
 * JD-Core Version:    0.7.0.1
 */