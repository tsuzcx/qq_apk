package com.tencent.mm.plugin.emoji.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.view.BaseEmojiView;
import com.tencent.mm.sdk.platformtools.ab;

final class CustomSmileyPreviewUI$11
  implements View.OnClickListener
{
  CustomSmileyPreviewUI$11(CustomSmileyPreviewUI paramCustomSmileyPreviewUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(53235);
    ab.i("MicroMsg.emoji.CustomSmileyPreviewUI", "emoji is hevc %s", new Object[] { Boolean.valueOf(CustomSmileyPreviewUI.e(this.lkP).eyq) });
    AppMethodBeat.o(53235);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.CustomSmileyPreviewUI.11
 * JD-Core Version:    0.7.0.1
 */