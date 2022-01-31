package com.tencent.mm.plugin.emoji.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class EmojiAddCustomDialogUI$9
  implements DialogInterface.OnDismissListener
{
  EmojiAddCustomDialogUI$9(EmojiAddCustomDialogUI paramEmojiAddCustomDialogUI) {}
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(53277);
    this.lld.setResult(1);
    this.lld.finish();
    AppMethodBeat.o(53277);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiAddCustomDialogUI.9
 * JD-Core Version:    0.7.0.1
 */