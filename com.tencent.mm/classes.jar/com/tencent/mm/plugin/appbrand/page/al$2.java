package com.tencent.mm.plugin.appbrand.page;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class al$2
  implements ValueAnimator.AnimatorUpdateListener
{
  al$2(al paramal) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(87315);
    this.iyV.getContentView().setScrollY(((Integer)paramValueAnimator.getAnimatedValue()).intValue());
    AppMethodBeat.o(87315);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.al.2
 * JD-Core Version:    0.7.0.1
 */