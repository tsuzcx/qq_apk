package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.v7.widget.RecyclerView.v;
import android.support.v7.widget.as;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

final class f$6
  extends AnimatorListenerAdapter
{
  f$6(f paramf, RecyclerView.v paramv, int paramInt1, View paramView, int paramInt2, ViewPropertyAnimator paramViewPropertyAnimator) {}
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    AppMethodBeat.i(133910);
    if (this.acx != 0) {
      this.val$view.setTranslationX(0.0F);
    }
    if (this.acy != 0) {
      this.val$view.setTranslationY(0.0F);
    }
    AppMethodBeat.o(133910);
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(133911);
    this.acw.setListener(null);
    this.jfS.C(this.acv);
    this.jfS.aco.remove(this.acv);
    this.jfS.hB();
    AppMethodBeat.o(133911);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(133909);
    this.jfS.F(this.acv);
    AppMethodBeat.o(133909);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.f.6
 * JD-Core Version:    0.7.0.1
 */