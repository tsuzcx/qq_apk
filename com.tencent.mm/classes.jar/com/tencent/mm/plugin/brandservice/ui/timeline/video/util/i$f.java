package com.tencent.mm.plugin.brandservice.ui.timeline.video.util;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.a;
import d.g.b.k;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "valueAnimator", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
public final class i$f
  implements ValueAnimator.AnimatorUpdateListener
{
  public i$f(i parami, a parama) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(199166);
    i locali = this.nOy;
    k.g(paramValueAnimator, "valueAnimator");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(199166);
      throw paramValueAnimator;
    }
    locali.nOl = ((Integer)paramValueAnimator).intValue();
    if (this.nOy.nOl == this.nOy.nOo) {
      i.a(this.nOy);
    }
    this.nOA.invoke();
    AppMethodBeat.o(199166);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i.f
 * JD-Core Version:    0.7.0.1
 */