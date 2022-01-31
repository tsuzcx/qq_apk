package com.tencent.mm.plugin.appbrand.jsapi.l;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.v;

final class q$1$1
  implements ValueAnimator.AnimatorUpdateListener
{
  q$1$1(q.1 param1) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(141754);
    this.hVX.hVQ.nM(((Integer)paramValueAnimator.getAnimatedValue()).intValue());
    AppMethodBeat.o(141754);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.l.q.1.1
 * JD-Core Version:    0.7.0.1
 */