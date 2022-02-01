package com.tencent.mm.plugin.aa.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AAImagPreviewUI$2
  implements ValueAnimator.AnimatorUpdateListener
{
  AAImagPreviewUI$2(AAImagPreviewUI paramAAImagPreviewUI) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(206991);
    ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    AppMethodBeat.o(206991);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.AAImagPreviewUI.2
 * JD-Core Version:    0.7.0.1
 */