package com.tencent.mm.plugin.emoji.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class EmojiAddCustomDialogUI$3
  implements DialogInterface.OnDismissListener
{
  EmojiAddCustomDialogUI$3(EmojiAddCustomDialogUI paramEmojiAddCustomDialogUI) {}
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(207444);
    this.peS.setResult(1);
    this.peS.finish();
    AppMethodBeat.o(207444);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiAddCustomDialogUI.3
 * JD-Core Version:    0.7.0.1
 */