package com.tencent.mm.plugin.emoji.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.sync.EmojiSyncManager;
import com.tencent.mm.plugin.report.service.h;

final class EmojiCustomUI$8
  implements DialogInterface.OnClickListener
{
  EmojiCustomUI$8(EmojiCustomUI paramEmojiCustomUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(53307);
    EmojiCustomUI.c(this.llF).start(true);
    h.qsU.e(11595, new Object[] { Integer.valueOf(1), Integer.valueOf(EmojiCustomUI.l(this.llF)) });
    AppMethodBeat.o(53307);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiCustomUI.8
 * JD-Core Version:    0.7.0.1
 */