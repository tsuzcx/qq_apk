package com.tencent.mm.plugin.appbrand.menu;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

final class c$1$1
  extends AnimatorListenerAdapter
{
  c$1$1(c.1 param1) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    this.gOO.gOM.post(new c.1.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.c.1.1
 * JD-Core Version:    0.7.0.1
 */