package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.v7.widget.RecyclerView.v;
import android.support.v7.widget.as;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

final class f$5
  extends AnimatorListenerAdapter
{
  f$5(f paramf, RecyclerView.v paramv, View paramView, ViewPropertyAnimator paramViewPropertyAnimator) {}
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    AppMethodBeat.i(133907);
    this.val$view.setScaleX(1.0F);
    this.val$view.setScaleY(1.0F);
    AppMethodBeat.o(133907);
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(133908);
    this.acw.setListener(null);
    this.jfS.m(this.acv);
    this.jfS.acn.remove(this.acv);
    this.jfS.hB();
    AppMethodBeat.o(133908);
  }
  
  public final void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.f.5
 * JD-Core Version:    0.7.0.1
 */