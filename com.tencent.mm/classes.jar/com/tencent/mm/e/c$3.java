package com.tencent.mm.e;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.y.a;

final class c$3
  implements ValueAnimator.AnimatorUpdateListener
{
  c$3(c paramc) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(116153);
    int i = ((Integer)paramValueAnimator.getAnimatedValue("bg_alpha")).intValue();
    int j = ((Integer)paramValueAnimator.getAnimatedValue("alpha")).intValue();
    c.a(this.cdH);
    a.jw(j);
    c.a(this.cdH);
    a.jx(i);
    this.cdH.CI();
    AppMethodBeat.o(116153);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.e.c.3
 * JD-Core Version:    0.7.0.1
 */