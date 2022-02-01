package com.tencent.mm.plugin.finder.presenter.contract;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
final class FinderMsgContract$MsgViewCallback$playLoadingAnimation$1
  implements ValueAnimator.AnimatorUpdateListener
{
  FinderMsgContract$MsgViewCallback$playLoadingAnimation$1(FinderMsgContract.MsgViewCallback paramMsgViewCallback, int paramInt) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(166551);
    ViewGroup.LayoutParams localLayoutParams = FinderMsgContract.MsgViewCallback.i(this.rwP).getLayoutParams();
    float f = this.rwU;
    k.g(paramValueAnimator, "it");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Float");
      AppMethodBeat.o(166551);
      throw paramValueAnimator;
    }
    localLayoutParams.height = ((int)(((Float)paramValueAnimator).floatValue() * f));
    FinderMsgContract.MsgViewCallback.i(this.rwP).setLayoutParams(localLayoutParams);
    AppMethodBeat.o(166551);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.presenter.contract.FinderMsgContract.MsgViewCallback.playLoadingAnimation.1
 * JD-Core Version:    0.7.0.1
 */