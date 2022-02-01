package com.tencent.mm.plugin.finder.view.animation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.v7.widget.RecyclerView.w;
import android.support.v7.widget.as;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

final class a$4
  extends AnimatorListenerAdapter
{
  a$4(a parama, RecyclerView.w paramw, ViewPropertyAnimator paramViewPropertyAnimator, View paramView) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(168653);
    this.akx.setListener(null);
    this.val$view.setAlpha(1.0F);
    this.sae.w(this.akw);
    this.sae.akq.remove(this.akw);
    this.sae.jf();
    AppMethodBeat.o(168653);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(168652);
    this.sae.A(this.akw);
    AppMethodBeat.o(168652);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.animation.a.4
 * JD-Core Version:    0.7.0.1
 */