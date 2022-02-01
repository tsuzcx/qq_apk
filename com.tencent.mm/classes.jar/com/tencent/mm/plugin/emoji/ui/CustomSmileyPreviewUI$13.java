package com.tencent.mm.plugin.emoji.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.view.BaseEmojiView;
import com.tencent.mm.plugin.emoji.ui.widget.ScaleRelativeLayout;

final class CustomSmileyPreviewUI$13
  implements Runnable
{
  CustomSmileyPreviewUI$13(CustomSmileyPreviewUI paramCustomSmileyPreviewUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(108803);
    CustomSmileyPreviewUI.f(this.uIo).setScaleChild(CustomSmileyPreviewUI.e(this.uIo));
    ScaleRelativeLayout localScaleRelativeLayout = CustomSmileyPreviewUI.f(this.uIo);
    float f1 = CustomSmileyPreviewUI.e(this.uIo).getMeasuredWidth();
    float f2 = CustomSmileyPreviewUI.e(this.uIo).getMeasuredHeight();
    localScaleRelativeLayout.aGN = Math.min(Math.min(localScaleRelativeLayout.getMeasuredWidth() / f1, localScaleRelativeLayout.getMeasuredHeight() / f2), 3.0F);
    localScaleRelativeLayout.uQO = (localScaleRelativeLayout.aGN * 1.5F);
    AppMethodBeat.o(108803);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.CustomSmileyPreviewUI.13
 * JD-Core Version:    0.7.0.1
 */