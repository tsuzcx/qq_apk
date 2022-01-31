package com.tencent.mm.plugin.appbrand.widget.b;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class j
{
  ValueAnimator ggX;
  private int jjZ;
  View view;
  
  public j(View paramView)
  {
    this.view = paramView;
  }
  
  final void c(int paramInt, Runnable paramRunnable)
  {
    AppMethodBeat.i(77422);
    if (this.view == null)
    {
      AppMethodBeat.o(77422);
      return;
    }
    this.jjZ = paramInt;
    if (((this.view.getBackground() instanceof ColorDrawable)) && (((ColorDrawable)this.view.getBackground()).getColor() == paramInt))
    {
      if (paramRunnable != null) {
        paramRunnable.run();
      }
      if (this.ggX != null) {
        this.ggX.cancel();
      }
      AppMethodBeat.o(77422);
      return;
    }
    paramRunnable = new j.1(this, paramRunnable);
    if ((this.ggX != null) && (this.ggX.isStarted()) && (this.ggX.isRunning()) && (this.jjZ == paramInt))
    {
      this.ggX.addListener(paramRunnable);
      AppMethodBeat.o(77422);
      return;
    }
    if (this.ggX != null) {
      this.ggX.cancel();
    }
    if ((this.view.getBackground() instanceof ColorDrawable)) {}
    for (paramInt = ((ColorDrawable)this.view.getBackground()).getColor();; paramInt = 0)
    {
      this.ggX = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.jjZ) });
      this.ggX.addListener(paramRunnable);
      this.ggX.addUpdateListener(new j.2(this));
      this.ggX.start();
      AppMethodBeat.o(77422);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.b.j
 * JD-Core Version:    0.7.0.1
 */