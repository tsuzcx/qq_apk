package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class EmojiStoreV2SingleProductDialogUI$4
  implements DialogInterface.OnDismissListener
{
  EmojiStoreV2SingleProductDialogUI$4(EmojiStoreV2SingleProductDialogUI paramEmojiStoreV2SingleProductDialogUI) {}
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(53733);
    this.lqW.setResult(0);
    this.lqW.finish();
    AppMethodBeat.o(53733);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductDialogUI.4
 * JD-Core Version:    0.7.0.1
 */