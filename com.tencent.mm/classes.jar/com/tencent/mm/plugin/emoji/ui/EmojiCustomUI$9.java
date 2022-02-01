package com.tencent.mm.plugin.emoji.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

final class EmojiCustomUI$9
  implements DialogInterface.OnClickListener
{
  EmojiCustomUI$9(EmojiCustomUI paramEmojiCustomUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(270342);
    h.OAn.b(11595, new Object[] { Integer.valueOf(1), Integer.valueOf(EmojiCustomUI.m(this.xRY)) });
    AppMethodBeat.o(270342);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiCustomUI.9
 * JD-Core Version:    0.7.0.1
 */