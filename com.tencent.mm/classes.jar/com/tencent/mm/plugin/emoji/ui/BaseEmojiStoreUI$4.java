package com.tencent.mm.plugin.emoji.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class BaseEmojiStoreUI$4
  implements DialogInterface.OnCancelListener
{
  BaseEmojiStoreUI$4(BaseEmojiStoreUI paramBaseEmojiStoreUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(53215);
    BaseEmojiStoreUI.bml();
    AppMethodBeat.o(53215);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI.4
 * JD-Core Version:    0.7.0.1
 */