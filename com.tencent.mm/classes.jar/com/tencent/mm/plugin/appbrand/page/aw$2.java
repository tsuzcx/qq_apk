package com.tencent.mm.plugin.appbrand.page;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class aw$2
  implements ValueAnimator.AnimatorUpdateListener
{
  aw$2(aw paramaw) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(135252);
    this.ntf.getContentView().setScrollY(((Integer)paramValueAnimator.getAnimatedValue()).intValue());
    AppMethodBeat.o(135252);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.aw.2
 * JD-Core Version:    0.7.0.1
 */