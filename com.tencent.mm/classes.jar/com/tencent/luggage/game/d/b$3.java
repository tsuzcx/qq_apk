package com.tencent.luggage.game.d;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$3
  implements ValueAnimator.AnimatorUpdateListener
{
  int height;
  
  b$3(b paramb)
  {
    AppMethodBeat.i(140371);
    this.height = this.bAs.getDisplayHeight();
    AppMethodBeat.o(140371);
  }
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(140372);
    if (((Float)paramValueAnimator.getAnimatedValue()).floatValue() == 1.0F)
    {
      this.bAs.bAm.setVisibility(8);
      AppMethodBeat.o(140372);
      return;
    }
    this.bAs.bAm.setTranslationY(((Float)paramValueAnimator.getAnimatedValue()).floatValue() * this.height);
    this.bAs.bAm.requestLayout();
    AppMethodBeat.o(140372);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.game.d.b.3
 * JD-Core Version:    0.7.0.1
 */