package com.tencent.kinda.framework.animate;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;

class KindaAnimatorViewProxy$1
  implements ValueAnimator.AnimatorUpdateListener
{
  KindaAnimatorViewProxy$1(KindaAnimatorViewProxy paramKindaAnimatorViewProxy, Method paramMethod) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(144267);
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    try
    {
      this.val$setter.invoke(KindaAnimatorViewProxy.access$000(this.this$0), new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(144267);
      return;
    }
    catch (Exception paramValueAnimator)
    {
      AppMethodBeat.o(144267);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.kinda.framework.animate.KindaAnimatorViewProxy.1
 * JD-Core Version:    0.7.0.1
 */