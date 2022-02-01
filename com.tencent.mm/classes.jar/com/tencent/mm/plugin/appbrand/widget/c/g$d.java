package com.tencent.mm.plugin.appbrand.widget.c;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.d;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
final class g$d
  implements ValueAnimator.AnimatorUpdateListener
{
  g$d(g paramg) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(272687);
    Object localObject = g.a(this.rts);
    p.j(localObject, "container");
    localObject = ((d)localObject).getLayoutParams();
    p.j(paramValueAnimator, "animation");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(272687);
      throw paramValueAnimator;
    }
    ((ViewGroup.LayoutParams)localObject).height = ((Integer)paramValueAnimator).intValue();
    g.a(this.rts).requestLayout();
    AppMethodBeat.o(272687);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.c.g.d
 * JD-Core Version:    0.7.0.1
 */