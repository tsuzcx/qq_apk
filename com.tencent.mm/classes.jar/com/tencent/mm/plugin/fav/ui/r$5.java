package com.tencent.mm.plugin.fav.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class r$5
  implements ValueAnimator.AnimatorUpdateListener
{
  r$5(r paramr, int paramInt) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(107072);
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if (f <= 0.1F) {
      this.wNl.wNf.setAlpha(f * 10.0F);
    }
    for (;;)
    {
      this.wNl.wNf.setTranslationY(f * (this.wBy - this.wNl.wNf.getHeight()));
      AppMethodBeat.o(107072);
      return;
      if (f >= 0.9F) {
        this.wNl.wNf.setAlpha((1.0F - f) * 10.0F);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.r.5
 * JD-Core Version:    0.7.0.1
 */