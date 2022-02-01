package com.tencent.mm.plugin.emoji.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class EmojiAddCustomDialogUI$13
  implements DialogInterface.OnClickListener
{
  EmojiAddCustomDialogUI$13(EmojiAddCustomDialogUI paramEmojiAddCustomDialogUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(207456);
    this.peS.setResult(2);
    this.peS.finish();
    AppMethodBeat.o(207456);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiAddCustomDialogUI.13
 * JD-Core Version:    0.7.0.1
 */