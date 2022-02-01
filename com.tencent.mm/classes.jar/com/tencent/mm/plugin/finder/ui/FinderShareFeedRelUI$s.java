package com.tencent.mm.plugin.finder.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.AnimationLayout;
import com.tencent.mm.view.NinePatchCropImageView;
import d.g.b.p;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
final class FinderShareFeedRelUI$s
  implements ValueAnimator.AnimatorUpdateListener
{
  FinderShareFeedRelUI$s(FinderShareFeedRelUI paramFinderShareFeedRelUI, AnimationLayout paramAnimationLayout) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(204825);
    p.g(paramValueAnimator, "animation");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Float");
      AppMethodBeat.o(204825);
      throw paramValueAnimator;
    }
    ((Float)paramValueAnimator).floatValue();
    FinderShareFeedRelUI.p(this.sTe).m(this.sTm.ClP);
    FinderShareFeedRelUI.p(this.sTe).invalidate();
    AppMethodBeat.o(204825);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderShareFeedRelUI.s
 * JD-Core Version:    0.7.0.1
 */