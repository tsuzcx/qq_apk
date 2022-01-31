package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;

final class EmojiStoreV2SingleProductUI$3
  implements DialogInterface.OnCancelListener
{
  EmojiStoreV2SingleProductUI$3(EmojiStoreV2SingleProductUI paramEmojiStoreV2SingleProductUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(53746);
    if (EmojiStoreV2SingleProductUI.p(this.lrz) != null) {
      g.RK().eHt.a(EmojiStoreV2SingleProductUI.p(this.lrz));
    }
    AppMethodBeat.o(53746);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductUI.3
 * JD-Core Version:    0.7.0.1
 */