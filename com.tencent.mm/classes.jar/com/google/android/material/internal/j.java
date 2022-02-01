package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.transition.Transition;
import androidx.transition.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class j
  extends Transition
{
  private static void a(w paramw)
  {
    AppMethodBeat.i(238280);
    if ((paramw.view instanceof TextView))
    {
      TextView localTextView = (TextView)paramw.view;
      paramw.values.put("android:textscale:scale", Float.valueOf(localTextView.getScaleX()));
    }
    AppMethodBeat.o(238280);
  }
  
  public final Animator a(final ViewGroup paramViewGroup, w paramw1, w paramw2)
  {
    float f2 = 1.0F;
    AppMethodBeat.i(238283);
    if ((paramw1 == null) || (paramw2 == null) || (!(paramw1.view instanceof TextView)) || (!(paramw2.view instanceof TextView)))
    {
      AppMethodBeat.o(238283);
      return null;
    }
    paramViewGroup = (TextView)paramw2.view;
    paramw1 = paramw1.values;
    paramw2 = paramw2.values;
    if (paramw1.get("android:textscale:scale") != null) {}
    for (float f1 = ((Float)paramw1.get("android:textscale:scale")).floatValue();; f1 = 1.0F)
    {
      if (paramw2.get("android:textscale:scale") != null) {
        f2 = ((Float)paramw2.get("android:textscale:scale")).floatValue();
      }
      if (f1 != f2) {
        break;
      }
      AppMethodBeat.o(238283);
      return null;
    }
    paramw1 = ValueAnimator.ofFloat(new float[] { f1, f2 });
    paramw1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(238230);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        paramViewGroup.setScaleX(f);
        paramViewGroup.setScaleY(f);
        AppMethodBeat.o(238230);
      }
    });
    AppMethodBeat.o(238283);
    return paramw1;
  }
  
  public final void b(w paramw)
  {
    AppMethodBeat.i(238275);
    a(paramw);
    AppMethodBeat.o(238275);
  }
  
  public final void c(w paramw)
  {
    AppMethodBeat.i(238277);
    a(paramw);
    AppMethodBeat.o(238277);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.material.internal.j
 * JD-Core Version:    0.7.0.1
 */