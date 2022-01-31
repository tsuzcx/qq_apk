package com.tencent.kinda.framework.animate;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;

class KindaAnimatorViewProxy$3
  implements ValueAnimator.AnimatorUpdateListener
{
  KindaAnimatorViewProxy$3(KindaAnimatorViewProxy paramKindaAnimatorViewProxy, Method paramMethod) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(144269);
    long l = ((Long)paramValueAnimator.getAnimatedValue()).longValue();
    try
    {
      this.val$setter.invoke(KindaAnimatorViewProxy.access$000(this.this$0), new Object[] { Long.valueOf(l) });
      AppMethodBeat.o(144269);
      return;
    }
    catch (Exception paramValueAnimator)
    {
      AppMethodBeat.o(144269);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.kinda.framework.animate.KindaAnimatorViewProxy.3
 * JD-Core Version:    0.7.0.1
 */