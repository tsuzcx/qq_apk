package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.v7.widget.as;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

final class f$8
  extends AnimatorListenerAdapter
{
  f$8(f paramf, f.a parama, ViewPropertyAnimator paramViewPropertyAnimator, View paramView) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(133913);
    this.acB.setListener(null);
    this.acC.setAlpha(1.0F);
    this.acC.setTranslationX(0.0F);
    this.acC.setTranslationY(0.0F);
    this.jfS.m(this.jfT.acE);
    this.jfS.acq.remove(this.jfT.acE);
    this.jfS.hB();
    AppMethodBeat.o(133913);
  }
  
  public final void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.f.8
 * JD-Core Version:    0.7.0.1
 */