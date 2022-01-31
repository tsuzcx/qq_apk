package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.v7.widget.RecyclerView.v;
import android.support.v7.widget.as;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

final class c$11
  extends AnimatorListenerAdapter
{
  c$11(c paramc, RecyclerView.v paramv, int paramInt1, View paramView, int paramInt2, boolean paramBoolean, float paramFloat, ViewPropertyAnimator paramViewPropertyAnimator) {}
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    AppMethodBeat.i(133793);
    if (this.acx != 0) {
      this.val$view.setTranslationX(0.0F);
    }
    if (this.acy != 0) {
      this.val$view.setTranslationY(0.0F);
    }
    if (!this.jeg)
    {
      this.val$view.setAlpha(0.0F);
      AppMethodBeat.o(133793);
      return;
    }
    this.val$view.setAlpha(this.jef);
    AppMethodBeat.o(133793);
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(133794);
    this.acw.setListener(null);
    this.jed.C(this.acv);
    this.jed.aco.remove(this.acv);
    this.jed.hB();
    AppMethodBeat.o(133794);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(133792);
    this.jed.F(this.acv);
    AppMethodBeat.o(133792);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.c.11
 * JD-Core Version:    0.7.0.1
 */