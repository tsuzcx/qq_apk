package com.tencent.kinda.framework.animate;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;

class KindaAnimatorViewProxy$5
  implements ValueAnimator.AnimatorUpdateListener
{
  KindaAnimatorViewProxy$5(KindaAnimatorViewProxy paramKindaAnimatorViewProxy, Method paramMethod) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(144271);
    double d = ((Double)paramValueAnimator.getAnimatedValue()).doubleValue();
    try
    {
      this.val$setter.invoke(KindaAnimatorViewProxy.access$000(this.this$0), new Object[] { Double.valueOf(d) });
      AppMethodBeat.o(144271);
      return;
    }
    catch (Exception paramValueAnimator)
    {
      AppMethodBeat.o(144271);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.framework.animate.KindaAnimatorViewProxy.5
 * JD-Core Version:    0.7.0.1
 */