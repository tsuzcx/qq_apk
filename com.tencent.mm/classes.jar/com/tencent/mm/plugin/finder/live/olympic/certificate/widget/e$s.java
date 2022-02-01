package com.tencent.mm.plugin.finder.live.olympic.certificate.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/olympic/certificate/widget/CertificateLayout$setAlphaAnimate$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e$s
  extends AnimatorListenerAdapter
{
  e$s(View paramView, boolean paramBoolean, a<ah> parama) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(360862);
    this.$view.animate().setListener(null);
    if (!this.CQz) {
      this.$view.setVisibility(4);
    }
    this.$view.setAlpha(1.0F);
    paramAnimator = this.CPx;
    if (paramAnimator != null) {
      paramAnimator.invoke();
    }
    AppMethodBeat.o(360862);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.olympic.certificate.widget.e.s
 * JD-Core Version:    0.7.0.1
 */