package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.v7.widget.RecyclerView.v;
import android.support.v7.widget.as;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

final class f$4
  extends AnimatorListenerAdapter
{
  f$4(f paramf, RecyclerView.v paramv, ViewPropertyAnimator paramViewPropertyAnimator, View paramView) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(133906);
    this.acw.setListener(null);
    this.val$view.setAlpha(1.0F);
    this.jfS.B(this.acv);
    this.jfS.acp.remove(this.acv);
    this.jfS.hB();
    AppMethodBeat.o(133906);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(133905);
    this.jfS.D(this.acv);
    AppMethodBeat.o(133905);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.f.4
 * JD-Core Version:    0.7.0.1
 */