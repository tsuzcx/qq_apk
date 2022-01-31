package com.tencent.mm.plugin.emoji.ui;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.emotion.EmojiInfo;

final class CustomSmileyPreviewUI$1
  implements Runnable
{
  CustomSmileyPreviewUI$1(CustomSmileyPreviewUI paramCustomSmileyPreviewUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(53220);
    if (CustomSmileyPreviewUI.a(this.lkP) != null) {
      CustomSmileyPreviewUI.a(this.lkP).setText(((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Kx(CustomSmileyPreviewUI.b(this.lkP).Al()));
    }
    AppMethodBeat.o(53220);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.CustomSmileyPreviewUI.1
 * JD-Core Version:    0.7.0.1
 */