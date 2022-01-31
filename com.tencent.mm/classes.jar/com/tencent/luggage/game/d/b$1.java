package com.tencent.luggage.game.d;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$1
  implements View.OnClickListener
{
  b$1(b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(140367);
    paramView = this.bAs;
    if (paramView.bAo)
    {
      localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      localValueAnimator.addUpdateListener(new b.3(paramView));
      localValueAnimator.start();
      paramView.bAo = false;
      AppMethodBeat.o(140367);
      return;
    }
    paramView.bAm.setTranslationY(paramView.getDisplayHeight());
    paramView.bAm.setVisibility(0);
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    localValueAnimator.addUpdateListener(new b.4(paramView));
    localValueAnimator.start();
    paramView.bAo = true;
    AppMethodBeat.o(140367);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.game.d.b.1
 * JD-Core Version:    0.7.0.1
 */