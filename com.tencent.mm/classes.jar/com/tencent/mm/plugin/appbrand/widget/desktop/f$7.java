package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.v7.widget.as;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

final class f$7
  extends AnimatorListenerAdapter
{
  f$7(f paramf, f.a parama, ViewPropertyAnimator paramViewPropertyAnimator, View paramView) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(133912);
    this.acA.setListener(null);
    this.val$view.setAlpha(1.0F);
    this.val$view.setTranslationX(0.0F);
    this.val$view.setTranslationY(0.0F);
    this.val$view.setScaleX(1.0F);
    this.val$view.setScaleY(1.0F);
    this.jfS.m(this.jfT.acD);
    this.jfS.acq.remove(this.jfT.acD);
    this.jfS.hB();
    AppMethodBeat.o(133912);
  }
  
  public final void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.f.7
 * JD-Core Version:    0.7.0.1
 */