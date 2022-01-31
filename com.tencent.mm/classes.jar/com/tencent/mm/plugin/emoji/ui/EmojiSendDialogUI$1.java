package com.tencent.mm.plugin.emoji.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class EmojiSendDialogUI$1
  implements DialogInterface.OnDismissListener
{
  EmojiSendDialogUI$1(EmojiSendDialogUI paramEmojiSendDialogUI) {}
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(53400);
    this.lmj.setResult(0);
    this.lmj.finish();
    AppMethodBeat.o(53400);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiSendDialogUI.1
 * JD-Core Version:    0.7.0.1
 */