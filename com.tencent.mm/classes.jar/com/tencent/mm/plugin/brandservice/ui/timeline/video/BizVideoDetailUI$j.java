package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import a.f.b.j;
import a.l;
import a.v;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "valueAnimator", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
final class BizVideoDetailUI$j
  implements ValueAnimator.AnimatorUpdateListener
{
  BizVideoDetailUI$j(BizVideoDetailUI paramBizVideoDetailUI) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(15151);
    j.p(paramValueAnimator, "valueAnimator");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(15151);
      throw paramValueAnimator;
    }
    int i = ((Integer)paramValueAnimator).intValue();
    BizVideoDetailUI.U((View)this.kgi.aYg(), i);
    paramValueAnimator = BizVideoDetailUI.b(this.kgi);
    j.p(paramValueAnimator, "animationLayout");
    BizVideoDetailUI.U(paramValueAnimator, i);
    AppMethodBeat.o(15151);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.BizVideoDetailUI.j
 * JD-Core Version:    0.7.0.1
 */