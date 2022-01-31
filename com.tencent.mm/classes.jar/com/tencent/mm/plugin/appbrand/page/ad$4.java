package com.tencent.mm.plugin.appbrand.page;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ad$4
  implements ValueAnimator.AnimatorUpdateListener
{
  ad$4(ad paramad) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(132442);
    this.iys.getView().setScrollY(((Integer)paramValueAnimator.getAnimatedValue()).intValue());
    AppMethodBeat.o(132442);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ad.4
 * JD-Core Version:    0.7.0.1
 */