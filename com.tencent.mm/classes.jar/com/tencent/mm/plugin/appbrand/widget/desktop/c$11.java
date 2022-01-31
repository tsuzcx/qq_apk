package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.v7.widget.RecyclerView.v;
import android.support.v7.widget.ar;
import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;

final class c$11
  extends AnimatorListenerAdapter
{
  c$11(c paramc, RecyclerView.v paramv, int paramInt1, View paramView, int paramInt2, boolean paramBoolean, float paramFloat, ViewPropertyAnimator paramViewPropertyAnimator) {}
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    if (this.abM != 0) {
      this.val$view.setTranslationX(0.0F);
    }
    if (this.abN != 0) {
      this.val$view.setTranslationY(0.0F);
    }
    if (!this.hpZ)
    {
      this.val$view.setAlpha(0.0F);
      return;
    }
    this.val$view.setAlpha(this.hpY);
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    this.abL.setListener(null);
    this.hpW.x(this.abK);
    this.hpW.abD.remove(this.abK);
    this.hpW.gB();
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    this.hpW.A(this.abK);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.c.11
 * JD-Core Version:    0.7.0.1
 */