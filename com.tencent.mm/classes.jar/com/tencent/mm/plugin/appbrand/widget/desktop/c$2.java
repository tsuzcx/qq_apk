package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.v7.widget.ar;
import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;

final class c$2
  extends AnimatorListenerAdapter
{
  c$2(c paramc, c.a parama, ViewPropertyAnimator paramViewPropertyAnimator, View paramView) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    this.abP.setListener(null);
    this.val$view.setAlpha(1.0F);
    this.val$view.setTranslationX(0.0F);
    this.val$view.setTranslationY(0.0F);
    this.hpW.l(this.hpX.abS);
    this.hpW.abF.remove(this.hpX.abS);
    this.hpW.gB();
  }
  
  public final void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.c.2
 * JD-Core Version:    0.7.0.1
 */