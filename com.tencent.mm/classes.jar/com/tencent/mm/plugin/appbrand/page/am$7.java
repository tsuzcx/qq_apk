package com.tencent.mm.plugin.appbrand.page;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class am$7
  implements ValueAnimator.AnimatorUpdateListener
{
  am$7(am paramam) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(227323);
    this.nsp.getView().setScrollY(((Integer)paramValueAnimator.getAnimatedValue()).intValue());
    AppMethodBeat.o(227323);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.am.7
 * JD-Core Version:    0.7.0.1
 */