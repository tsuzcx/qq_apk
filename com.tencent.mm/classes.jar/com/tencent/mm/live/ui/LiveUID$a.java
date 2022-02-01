package com.tencent.mm.live.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/live/ui/LiveUID$hideRangePanel$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-logic_release"})
public final class LiveUID$a
  extends AnimatorListenerAdapter
{
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(203269);
    paramAnimator = LiveUID.l(this.KyL);
    if (paramAnimator != null)
    {
      paramAnimator.setVisibility(8);
      AppMethodBeat.o(203269);
      return;
    }
    AppMethodBeat.o(203269);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.ui.LiveUID.a
 * JD-Core Version:    0.7.0.1
 */