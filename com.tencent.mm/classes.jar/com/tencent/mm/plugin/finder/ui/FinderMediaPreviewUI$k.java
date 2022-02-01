package com.tencent.mm.plugin.finder.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
final class FinderMediaPreviewUI$k
  implements ValueAnimator.AnimatorUpdateListener
{
  public static final k rJf;
  
  static
  {
    AppMethodBeat.i(167418);
    rJf = new k();
    AppMethodBeat.o(167418);
  }
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(167417);
    k.g(paramValueAnimator, "animation");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Float");
      AppMethodBeat.o(167417);
      throw paramValueAnimator;
    }
    ((Float)paramValueAnimator).floatValue();
    AppMethodBeat.o(167417);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderMediaPreviewUI.k
 * JD-Core Version:    0.7.0.1
 */