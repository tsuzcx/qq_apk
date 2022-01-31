package com.tencent.mm.plugin.emoji.ui.v2;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.b.c;

final class EmojiStoreV2SingleProductDialogUI$3
  implements View.OnClickListener
{
  EmojiStoreV2SingleProductDialogUI$3(EmojiStoreV2SingleProductDialogUI paramEmojiStoreV2SingleProductDialogUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(53732);
    EmojiStoreV2SingleProductDialogUI.g(this.lqW).setOnDismissListener(null);
    EmojiStoreV2SingleProductDialogUI.g(this.lqW).dismiss();
    this.lqW.setResult(0);
    this.lqW.finish();
    this.lqW.overridePendingTransition(2131034217, 2131034222);
    AppMethodBeat.o(53732);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductDialogUI.3
 * JD-Core Version:    0.7.0.1
 */