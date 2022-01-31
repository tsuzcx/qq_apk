package com.tencent.mm.plugin.emoji.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;

final class EmojiStoreDetailUI$5
  implements DialogInterface.OnCancelListener
{
  EmojiStoreDetailUI$5(EmojiStoreDetailUI paramEmojiStoreDetailUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(53424);
    g.RK().eHt.a(EmojiStoreDetailUI.o(this.lnA));
    EmojiStoreDetailUI.p(this.lnA).setText(2131299205);
    EmojiStoreDetailUI.q(this.lnA);
    AppMethodBeat.o(53424);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI.5
 * JD-Core Version:    0.7.0.1
 */