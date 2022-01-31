package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.v7.widget.ar;
import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;

final class c$3
  extends AnimatorListenerAdapter
{
  c$3(c paramc, c.a parama, ViewPropertyAnimator paramViewPropertyAnimator, View paramView, float paramFloat, boolean paramBoolean) {}
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    super.onAnimationCancel(paramAnimator);
    if (!this.hpZ)
    {
      this.abR.setAlpha(0.0F);
      return;
    }
    this.abR.setAlpha(1.0F);
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    this.abQ.setListener(null);
    this.abR.setAlpha(this.hpY);
    this.abR.setTranslationX(0.0F);
    this.abR.setTranslationY(0.0F);
    this.hpW.l(this.hpX.abT);
    this.hpW.abF.remove(this.hpX.abT);
    this.hpW.gB();
  }
  
  public final void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.c.3
 * JD-Core Version:    0.7.0.1
 */