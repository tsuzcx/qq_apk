package com.tencent.mm.plugin.emoji.ui.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ScaleRelativeLayout$1
  implements ValueAnimator.AnimatorUpdateListener
{
  ScaleRelativeLayout$1(ScaleRelativeLayout paramScaleRelativeLayout) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(53859);
    ScaleRelativeLayout.a(this.lsG, ((Float)paramValueAnimator.getAnimatedValue()).floatValue());
    int i = 0;
    while (i < this.lsG.getChildCount())
    {
      paramValueAnimator = this.lsG.getChildAt(i);
      paramValueAnimator.setScaleX(ScaleRelativeLayout.a(this.lsG));
      paramValueAnimator.setScaleY(ScaleRelativeLayout.a(this.lsG));
      i += 1;
    }
    AppMethodBeat.o(53859);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.widget.ScaleRelativeLayout.1
 * JD-Core Version:    0.7.0.1
 */