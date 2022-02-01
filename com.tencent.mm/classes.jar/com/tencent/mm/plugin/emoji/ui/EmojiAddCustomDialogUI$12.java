package com.tencent.mm.plugin.emoji.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class EmojiAddCustomDialogUI$12
  implements DialogInterface.OnDismissListener
{
  EmojiAddCustomDialogUI$12(EmojiAddCustomDialogUI paramEmojiAddCustomDialogUI) {}
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(270434);
    this.xRw.setResult(3);
    this.xRw.finish();
    AppMethodBeat.o(270434);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiAddCustomDialogUI.12
 * JD-Core Version:    0.7.0.1
 */