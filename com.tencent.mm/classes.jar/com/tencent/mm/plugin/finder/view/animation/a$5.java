package com.tencent.mm.plugin.finder.view.animation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.v7.widget.RecyclerView.w;
import android.support.v7.widget.as;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

final class a$5
  extends AnimatorListenerAdapter
{
  a$5(a parama, RecyclerView.w paramw, View paramView, ViewPropertyAnimator paramViewPropertyAnimator) {}
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    AppMethodBeat.i(168654);
    this.val$view.setAlpha(1.0F);
    AppMethodBeat.o(168654);
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(168655);
    this.akx.setListener(null);
    this.sae.n(this.akw);
    this.sae.ako.remove(this.akw);
    this.sae.jf();
    AppMethodBeat.o(168655);
  }
  
  public final void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.animation.a.5
 * JD-Core Version:    0.7.0.1
 */