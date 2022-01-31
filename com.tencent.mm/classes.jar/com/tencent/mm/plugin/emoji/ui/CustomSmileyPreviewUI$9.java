package com.tencent.mm.plugin.emoji.ui;

import com.tencent.mm.plugin.emoji.ui.widget.ScaleRelativeLayout;
import com.tencent.mm.pluginsdk.ui.emoji.MMEmojiView;

final class CustomSmileyPreviewUI$9
  implements Runnable
{
  CustomSmileyPreviewUI$9(CustomSmileyPreviewUI paramCustomSmileyPreviewUI) {}
  
  public final void run()
  {
    ScaleRelativeLayout localScaleRelativeLayout = CustomSmileyPreviewUI.g(this.jcf);
    float f1 = CustomSmileyPreviewUI.f(this.jcf).getMeasuredWidth();
    float f2 = CustomSmileyPreviewUI.f(this.jcf).getMeasuredHeight();
    localScaleRelativeLayout.apq = Math.min(Math.min(localScaleRelativeLayout.getMeasuredWidth() / f1, localScaleRelativeLayout.getMeasuredHeight() / f2), 3.0F);
    localScaleRelativeLayout.jjK = (localScaleRelativeLayout.apq * 1.5F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.CustomSmileyPreviewUI.9
 * JD-Core Version:    0.7.0.1
 */