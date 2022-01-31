package com.tencent.mm.plugin.appbrand.widget.e;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

final class a$3
  extends AnimatorListenerAdapter
{
  a$3(a parama) {}
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    a.b(this.hBQ);
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    this.hBQ.setVisibility(8);
    a.b(this.hBQ);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.e.a.3
 * JD-Core Version:    0.7.0.1
 */