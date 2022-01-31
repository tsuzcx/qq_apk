package com.tencent.mm.plugin.emoji.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class BaseEmojiStoreUI$3
  implements DialogInterface.OnCancelListener
{
  BaseEmojiStoreUI$3(BaseEmojiStoreUI paramBaseEmojiStoreUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(53214);
    this.lku.bme();
    BaseEmojiStoreUI.bml();
    AppMethodBeat.o(53214);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI.3
 * JD-Core Version:    0.7.0.1
 */