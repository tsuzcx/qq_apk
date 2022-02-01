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
    AppMethodBeat.i(207455);
    this.peS.setResult(3);
    this.peS.finish();
    AppMethodBeat.o(207455);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiAddCustomDialogUI.12
 * JD-Core Version:    0.7.0.1
 */