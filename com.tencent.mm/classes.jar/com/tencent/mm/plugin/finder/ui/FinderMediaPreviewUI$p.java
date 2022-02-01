package com.tencent.mm.plugin.finder.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
final class FinderMediaPreviewUI$p
  implements ValueAnimator.AnimatorUpdateListener
{
  public static final p AsX;
  
  static
  {
    AppMethodBeat.i(167418);
    AsX = new p();
    AppMethodBeat.o(167418);
  }
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(167417);
    p.j(paramValueAnimator, "animation");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Float");
      AppMethodBeat.o(167417);
      throw paramValueAnimator;
    }
    ((Float)paramValueAnimator).floatValue();
    AppMethodBeat.o(167417);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderMediaPreviewUI.p
 * JD-Core Version:    0.7.0.1
 */