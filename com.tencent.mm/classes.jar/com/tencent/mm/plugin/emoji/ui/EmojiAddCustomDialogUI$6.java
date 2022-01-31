package com.tencent.mm.plugin.emoji.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class EmojiAddCustomDialogUI$6
  implements DialogInterface.OnDismissListener
{
  EmojiAddCustomDialogUI$6(EmojiAddCustomDialogUI paramEmojiAddCustomDialogUI) {}
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(53275);
    this.lld.setResult(3);
    this.lld.finish();
    AppMethodBeat.o(53275);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiAddCustomDialogUI.6
 * JD-Core Version:    0.7.0.1
 */