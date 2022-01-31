package com.tencent.mm.plugin.appbrand.widget.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import java.util.LinkedList;

final class e$4
  extends AnimatorListenerAdapter
{
  e$4(e parame, View paramView, h paramh) {}
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    onAnimationEnd(paramAnimator);
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    this.hsC.setVisibility(8);
    e.b(this.hsA).remove(this.hsB);
    e.c(this.hsA);
    this.hsA.post(new e.4.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.b.e.4
 * JD-Core Version:    0.7.0.1
 */