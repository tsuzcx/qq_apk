package com.tencent.mm.plugin.finder.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.NinePatchCropImageView;
import d.g.b.p;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
final class FinderShareFeedRelUI$q
  implements ValueAnimator.AnimatorUpdateListener
{
  FinderShareFeedRelUI$q(FinderShareFeedRelUI paramFinderShareFeedRelUI) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(204819);
    p.g(paramValueAnimator, "animation");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Float");
      AppMethodBeat.o(204819);
      throw paramValueAnimator;
    }
    if ((((Float)paramValueAnimator).floatValue() > 0.1F) && (FinderShareFeedRelUI.p(this.sTe).getAlpha() < 0.9F)) {
      FinderShareFeedRelUI.p(this.sTe).setAlpha(1.0F);
    }
    AppMethodBeat.o(204819);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderShareFeedRelUI.q
 * JD-Core Version:    0.7.0.1
 */