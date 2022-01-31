package com.tencent.mm.plugin.appbrand.jsapi.l;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.v;

final class q$1$3
  implements ValueAnimator.AnimatorUpdateListener
{
  q$1$3(q.1 param1) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(141756);
    double d = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.hVX.hVQ.t(d);
    AppMethodBeat.o(141756);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.l.q.1.3
 * JD-Core Version:    0.7.0.1
 */