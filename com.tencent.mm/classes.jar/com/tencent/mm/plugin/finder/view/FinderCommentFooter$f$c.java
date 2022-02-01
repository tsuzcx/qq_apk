package com.tencent.mm.plugin.finder.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.h.a;
import d.l;
import d.v;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
final class FinderCommentFooter$f$c
  implements ValueAnimator.AnimatorUpdateListener
{
  FinderCommentFooter$f$c(FinderCommentFooter.f paramf) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(200068);
    if (paramValueAnimator != null) {}
    for (paramValueAnimator = paramValueAnimator.getAnimatedValue(); paramValueAnimator == null; paramValueAnimator = null)
    {
      paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(200068);
      throw paramValueAnimator;
    }
    float f = ((Integer)paramValueAnimator).intValue();
    paramValueAnimator = this.LeI.qWm.getReplyBtn().getLayoutParams();
    paramValueAnimator.width = a.bU(f);
    this.LeI.qWm.getReplyBtn().setLayoutParams(paramValueAnimator);
    this.LeI.qWm.getReplyBtn().setAlpha(f / this.LeI.qWm.getReplyBtnWidth());
    AppMethodBeat.o(200068);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderCommentFooter.f.c
 * JD-Core Version:    0.7.0.1
 */