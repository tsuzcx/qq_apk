package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class j
{
  private int mBC;
  ValueAnimator rT;
  View view;
  
  public j(View paramView)
  {
    this.view = paramView;
  }
  
  final void c(int paramInt, final Runnable paramRunnable)
  {
    AppMethodBeat.i(131496);
    if (this.view == null)
    {
      AppMethodBeat.o(131496);
      return;
    }
    this.mBC = paramInt;
    if (((this.view.getBackground() instanceof ColorDrawable)) && (((ColorDrawable)this.view.getBackground()).getColor() == paramInt))
    {
      if (paramRunnable != null) {
        paramRunnable.run();
      }
      if (this.rT != null) {
        this.rT.cancel();
      }
      AppMethodBeat.o(131496);
      return;
    }
    paramRunnable = new AnimatorListenerAdapter()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        j.this.rT = null;
      }
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(131494);
        if (paramRunnable != null) {
          paramRunnable.run();
        }
        j.this.rT = null;
        AppMethodBeat.o(131494);
      }
    };
    if ((this.rT != null) && (this.rT.isStarted()) && (this.rT.isRunning()) && (this.mBC == paramInt))
    {
      this.rT.addListener(paramRunnable);
      AppMethodBeat.o(131496);
      return;
    }
    if (this.rT != null) {
      this.rT.cancel();
    }
    if ((this.view.getBackground() instanceof ColorDrawable)) {}
    for (paramInt = ((ColorDrawable)this.view.getBackground()).getColor();; paramInt = 0)
    {
      this.rT = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.mBC) });
      this.rT.addListener(paramRunnable);
      this.rT.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(131495);
          if (j.this.view != null) {
            j.this.view.setBackgroundColor(((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
          }
          AppMethodBeat.o(131495);
        }
      });
      this.rT.start();
      AppMethodBeat.o(131496);
      return;
    }
  }
  
  final void cancel()
  {
    AppMethodBeat.i(131497);
    if (this.rT != null) {
      this.rT.cancel();
    }
    AppMethodBeat.o(131497);
  }
  
  final boolean isRunning()
  {
    AppMethodBeat.i(131498);
    if ((this.rT != null) && (this.rT.isRunning()))
    {
      AppMethodBeat.o(131498);
      return true;
    }
    AppMethodBeat.o(131498);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.j
 * JD-Core Version:    0.7.0.1
 */