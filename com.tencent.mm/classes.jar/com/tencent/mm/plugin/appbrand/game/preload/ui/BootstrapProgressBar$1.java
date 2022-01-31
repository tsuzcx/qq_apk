package com.tencent.mm.plugin.appbrand.game.preload.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class BootstrapProgressBar$1
  implements ValueAnimator.AnimatorUpdateListener
{
  BootstrapProgressBar$1(BootstrapProgressBar paramBootstrapProgressBar) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(130309);
    this.huK.invalidate();
    AppMethodBeat.o(130309);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.preload.ui.BootstrapProgressBar.1
 * JD-Core Version:    0.7.0.1
 */