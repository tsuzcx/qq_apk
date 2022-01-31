package com.tencent.mm.plugin.emoji.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.widget.TextView;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.f.h;

final class EmojiStoreDetailUI$5
  implements DialogInterface.OnCancelListener
{
  EmojiStoreDetailUI$5(EmojiStoreDetailUI paramEmojiStoreDetailUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    g.DO().dJT.c(EmojiStoreDetailUI.o(this.jeK));
    EmojiStoreDetailUI.p(this.jeK).setText(f.h.emoji_store_load_failed_network);
    EmojiStoreDetailUI.q(this.jeK);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI.5
 * JD-Core Version:    0.7.0.1
 */