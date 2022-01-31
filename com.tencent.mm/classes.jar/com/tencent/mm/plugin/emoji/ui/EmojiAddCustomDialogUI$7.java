package com.tencent.mm.plugin.emoji.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class EmojiAddCustomDialogUI$7
  implements DialogInterface.OnClickListener
{
  EmojiAddCustomDialogUI$7(EmojiAddCustomDialogUI paramEmojiAddCustomDialogUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(53276);
    this.lld.setResult(2);
    this.lld.finish();
    AppMethodBeat.o(53276);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiAddCustomDialogUI.7
 * JD-Core Version:    0.7.0.1
 */