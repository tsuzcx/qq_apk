package com.tencent.mm.plugin.aa.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AAImagPreviewUI$10
  implements Animator.AnimatorListener
{
  AAImagPreviewUI$10(AAImagPreviewUI paramAAImagPreviewUI) {}
  
  public final void onAnimationCancel(Animator paramAnimator) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(206996);
    this.iBG.finish();
    this.iBG.overridePendingTransition(2130771986, 2130771986);
    AppMethodBeat.o(206996);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator) {}
  
  public final void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.AAImagPreviewUI.10
 * JD-Core Version:    0.7.0.1
 */