package com.tencent.mm.plugin.appbrand.widget.b;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.graphics.drawable.ColorDrawable;
import android.view.View;

final class g
{
  private int hsE;
  ValueAnimator hsF;
  View view;
  
  public g(View paramView)
  {
    this.view = paramView;
  }
  
  final void c(int paramInt, Runnable paramRunnable)
  {
    if (this.view == null) {}
    do
    {
      return;
      this.hsE = paramInt;
      if ((!(this.view.getBackground() instanceof ColorDrawable)) || (((ColorDrawable)this.view.getBackground()).getColor() != paramInt)) {
        break;
      }
      if (paramRunnable != null) {
        paramRunnable.run();
      }
    } while (this.hsF == null);
    this.hsF.cancel();
    return;
    paramRunnable = new g.1(this, paramRunnable);
    if ((this.hsF != null) && (this.hsF.isStarted()) && (this.hsF.isRunning()) && (this.hsE == paramInt))
    {
      this.hsF.addListener(paramRunnable);
      return;
    }
    if (this.hsF != null) {
      this.hsF.cancel();
    }
    if ((this.view.getBackground() instanceof ColorDrawable)) {}
    for (paramInt = ((ColorDrawable)this.view.getBackground()).getColor();; paramInt = 0)
    {
      this.hsF = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.hsE) });
      this.hsF.addListener(paramRunnable);
      this.hsF.addUpdateListener(new g.2(this));
      this.hsF.start();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.b.g
 * JD-Core Version:    0.7.0.1
 */