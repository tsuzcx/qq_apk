package com.tencent.mm.plugin.emoji.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.view.BaseEmojiView;
import com.tencent.mm.plugin.emoji.ui.widget.ScaleRelativeLayout;

final class CustomSmileyPreviewUI$12
  implements Runnable
{
  CustomSmileyPreviewUI$12(CustomSmileyPreviewUI paramCustomSmileyPreviewUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(53236);
    ScaleRelativeLayout localScaleRelativeLayout = CustomSmileyPreviewUI.f(this.lkP);
    float f1 = CustomSmileyPreviewUI.e(this.lkP).getMeasuredWidth();
    float f2 = CustomSmileyPreviewUI.e(this.lkP).getMeasuredHeight();
    localScaleRelativeLayout.arJ = Math.min(Math.min(localScaleRelativeLayout.getMeasuredWidth() / f1, localScaleRelativeLayout.getMeasuredHeight() / f2), 3.0F);
    localScaleRelativeLayout.lsC = (localScaleRelativeLayout.arJ * 1.5F);
    AppMethodBeat.o(53236);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.CustomSmileyPreviewUI.12
 * JD-Core Version:    0.7.0.1
 */