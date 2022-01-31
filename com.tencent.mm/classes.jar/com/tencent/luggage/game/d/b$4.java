package com.tencent.luggage.game.d;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$4
  implements ValueAnimator.AnimatorUpdateListener
{
  int height;
  
  b$4(b paramb)
  {
    AppMethodBeat.i(140373);
    this.height = this.bAs.getDisplayHeight();
    AppMethodBeat.o(140373);
  }
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(140374);
    this.bAs.bAm.setTranslationY(((Float)paramValueAnimator.getAnimatedValue()).floatValue() * this.height);
    this.bAs.bAm.requestLayout();
    AppMethodBeat.o(140374);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.game.d.b.4
 * JD-Core Version:    0.7.0.1
 */