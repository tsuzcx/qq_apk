package com.tencent.mm.plugin.aa.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AAImagPreviewUI$11
  implements ValueAnimator.AnimatorUpdateListener
{
  AAImagPreviewUI$11(AAImagPreviewUI paramAAImagPreviewUI) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(224225);
    ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    AppMethodBeat.o(224225);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.AAImagPreviewUI.11
 * JD-Core Version:    0.7.0.1
 */