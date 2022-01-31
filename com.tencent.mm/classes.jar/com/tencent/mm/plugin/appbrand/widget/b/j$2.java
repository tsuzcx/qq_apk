package com.tencent.mm.plugin.appbrand.widget.b;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class j$2
  implements ValueAnimator.AnimatorUpdateListener
{
  j$2(j paramj) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(77421);
    if (this.jka.view != null) {
      this.jka.view.setBackgroundColor(((Integer)paramValueAnimator.getAnimatedValue()).intValue());
    }
    AppMethodBeat.o(77421);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.b.j.2
 * JD-Core Version:    0.7.0.1
 */