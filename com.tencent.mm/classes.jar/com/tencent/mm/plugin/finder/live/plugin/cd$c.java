package com.tencent.mm.plugin.finder.live.plugin;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveTitlePlugin$animatorBizHighLight$run$al$1", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveTitlePlugin$SampleAnimatorListener;", "onAnimationEnd", "", "p0", "Landroid/animation/Animator;", "onAnimationUpdate", "Landroid/animation/ValueAnimator;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class cd$c
  implements ce
{
  cd$c(TextView paramTextView, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {}
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    AppMethodBeat.i(355576);
    s.u(this, "this");
    AppMethodBeat.o(355576);
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(355560);
    this.AXx.setTextSize(0, this.DkI);
    this.AXx.setAlpha(this.DkJ);
    AppMethodBeat.o(355560);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator)
  {
    AppMethodBeat.i(355583);
    s.u(this, "this");
    AppMethodBeat.o(355583);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(355591);
    s.u(this, "this");
    AppMethodBeat.o(355591);
  }
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(355568);
    if (paramValueAnimator != null)
    {
      TextView localTextView = this.AXx;
      float f1 = this.DkK;
      float f2 = this.DkI;
      float f3 = this.DkL;
      float f4 = this.DkJ;
      Object localObject = paramValueAnimator.getAnimatedValue();
      if (localObject == null)
      {
        paramValueAnimator = new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(355568);
        throw paramValueAnimator;
      }
      localTextView.setTextSize(0, ((Float)localObject).floatValue() * (f2 - f1) + f1);
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(355568);
        throw paramValueAnimator;
      }
      localTextView.setAlpha(((Float)paramValueAnimator).floatValue() * (f4 - f3) + f3);
    }
    AppMethodBeat.o(355568);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.cd.c
 * JD-Core Version:    0.7.0.1
 */