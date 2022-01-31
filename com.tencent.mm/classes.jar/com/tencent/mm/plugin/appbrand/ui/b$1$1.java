package com.tencent.mm.plugin.appbrand.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;
import android.view.ViewParent;

final class b$1$1
  extends AnimatorListenerAdapter
{
  b$1$1(b.1 param1, ViewParent paramViewParent) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    this.hcJ.hcH.post(new Runnable()
    {
      public final void run()
      {
        b.1.1.this.hcJ.hcH.setVisibility(8);
        ((ViewGroup)b.1.1.this.hcI).removeView(b.1.1.this.hcJ.hcH);
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.b.1.1
 * JD-Core Version:    0.7.0.1
 */