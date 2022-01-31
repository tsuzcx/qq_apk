package com.tencent.kinda.framework.animate;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;

class KindaAnimatorViewProxy$4
  implements ValueAnimator.AnimatorUpdateListener
{
  KindaAnimatorViewProxy$4(KindaAnimatorViewProxy paramKindaAnimatorViewProxy, Method paramMethod) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(144270);
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    try
    {
      this.val$setter.invoke(KindaAnimatorViewProxy.access$000(this.this$0), new Object[] { Float.valueOf(f) });
      AppMethodBeat.o(144270);
      return;
    }
    catch (Exception paramValueAnimator)
    {
      AppMethodBeat.o(144270);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.kinda.framework.animate.KindaAnimatorViewProxy.4
 * JD-Core Version:    0.7.0.1
 */