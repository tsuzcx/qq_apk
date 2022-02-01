package com.tencent.mm.plugin.finder.presenter.contract;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/presenter/contract/FinderMsgContract$MsgViewCallback$playLoadingAnimation$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
public final class FinderMsgContract$MsgViewCallback$playLoadingAnimation$2
  implements Animator.AnimatorListener
{
  FinderMsgContract$MsgViewCallback$playLoadingAnimation$2(int paramInt) {}
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    AppMethodBeat.i(166553);
    FinderMsgContract.MsgViewCallback.k(this.rwP);
    FinderMsgContract.MsgViewCallback.i(this.rwP).getLayoutParams().height = this.rwU;
    FinderMsgContract.MsgViewCallback.i(this.rwP).setVisibility(8);
    AppMethodBeat.o(166553);
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(166552);
    FinderMsgContract.MsgViewCallback.k(this.rwP);
    FinderMsgContract.MsgViewCallback.i(this.rwP).getLayoutParams().height = this.rwU;
    FinderMsgContract.MsgViewCallback.i(this.rwP).setVisibility(8);
    AppMethodBeat.o(166552);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator) {}
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(166554);
    FinderMsgContract.MsgViewCallback.i(this.rwP).setVisibility(4);
    AppMethodBeat.o(166554);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.presenter.contract.FinderMsgContract.MsgViewCallback.playLoadingAnimation.2
 * JD-Core Version:    0.7.0.1
 */