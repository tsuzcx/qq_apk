package com.tencent.mm.plugin.emoji.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class EmojiAddCustomDialogUI$5
  implements DialogInterface.OnClickListener
{
  EmojiAddCustomDialogUI$5(EmojiAddCustomDialogUI paramEmojiAddCustomDialogUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(53274);
    this.lld.setResult(3);
    this.lld.finish();
    AppMethodBeat.o(53274);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiAddCustomDialogUI.5
 * JD-Core Version:    0.7.0.1
 */