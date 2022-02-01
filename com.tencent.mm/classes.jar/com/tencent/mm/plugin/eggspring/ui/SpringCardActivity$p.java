package com.tencent.mm.plugin.eggspring.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.eggspring.a;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/eggspring/ui/SpringCardActivity$playCardAnim$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-eggspring_release"})
public final class SpringCardActivity$p
  implements Animator.AnimatorListener
{
  public final void onAnimationCancel(Animator paramAnimator) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(108177);
    ad.d("MicroMsg.SpringCardActivity", "onAnimationEnd");
    SpringCardActivity.l(this.osQ).setVisibility(8);
    paramAnimator = a.orI;
    paramAnimator = a.bTM();
    long l1 = System.currentTimeMillis();
    long l2 = SpringCardActivity.s(this.osQ);
    h.vKh.f(18916, new Object[] { paramAnimator.orE, paramAnimator.orG, Integer.valueOf(15), Long.valueOf(l1 - l2) });
    AppMethodBeat.o(108177);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator) {}
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(108178);
    ad.d("MicroMsg.SpringCardActivity", "onAnimationStart");
    AppMethodBeat.o(108178);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.eggspring.ui.SpringCardActivity.p
 * JD-Core Version:    0.7.0.1
 */