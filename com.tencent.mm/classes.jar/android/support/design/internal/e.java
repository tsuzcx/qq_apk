package android.support.design.internal;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.support.transition.Transition;
import android.support.transition.u;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.Map;

public final class e
  extends Transition
{
  private static void c(u paramu)
  {
    if ((paramu.view instanceof TextView))
    {
      TextView localTextView = (TextView)paramu.view;
      paramu.values.put("android:textscale:scale", Float.valueOf(localTextView.getScaleX()));
    }
  }
  
  public final Animator a(final ViewGroup paramViewGroup, u paramu1, u paramu2)
  {
    float f2 = 1.0F;
    if ((paramu1 == null) || (paramu2 == null) || (!(paramu1.view instanceof TextView)) || (!(paramu2.view instanceof TextView))) {
      return null;
    }
    paramViewGroup = (TextView)paramu2.view;
    paramu1 = paramu1.values;
    paramu2 = paramu2.values;
    if (paramu1.get("android:textscale:scale") != null) {}
    for (float f1 = ((Float)paramu1.get("android:textscale:scale")).floatValue();; f1 = 1.0F)
    {
      if (paramu2.get("android:textscale:scale") != null) {
        f2 = ((Float)paramu2.get("android:textscale:scale")).floatValue();
      }
      if (f1 != f2) {
        break;
      }
      return null;
    }
    paramu1 = ValueAnimator.ofFloat(new float[] { f1, f2 });
    paramu1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        paramViewGroup.setScaleX(f);
        paramViewGroup.setScaleY(f);
      }
    });
    return paramu1;
  }
  
  public final void a(u paramu)
  {
    c(paramu);
  }
  
  public final void b(u paramu)
  {
    c(paramu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.design.internal.e
 * JD-Core Version:    0.7.0.1
 */