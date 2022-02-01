package com.tencent.mm.plugin.finder.live.olympic.certificate.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/olympic/certificate/widget/BaseCertificateWidget$setAlphaAnimate$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a$b
  extends AnimatorListenerAdapter
{
  a$b(View paramView, boolean paramBoolean, a<ah> parama) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(360890);
    this.$view.animate().setListener(null);
    this.$view.setAlpha(1.0F);
    if (this.CPw) {
      this.$view.setVisibility(8);
    }
    paramAnimator = this.CPx;
    if (paramAnimator != null) {
      paramAnimator.invoke();
    }
    AppMethodBeat.o(360890);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.olympic.certificate.widget.a.b
 * JD-Core Version:    0.7.0.1
 */