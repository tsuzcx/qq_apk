package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.res.Resources;
import android.widget.Button;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.view.EmojiStatusView;
import com.tencent.mm.emoji.view.EmojiStatusView.b;

final class EmojiStoreV2SingleProductDialogUI$5
  implements EmojiStatusView.b
{
  EmojiStoreV2SingleProductDialogUI$5(EmojiStoreV2SingleProductDialogUI paramEmojiStoreV2SingleProductDialogUI) {}
  
  public final void jj(int paramInt)
  {
    AppMethodBeat.i(53734);
    if (paramInt == 1)
    {
      EmojiStoreV2SingleProductDialogUI.h(this.lqW).setVisibility(0);
      EmojiStoreV2SingleProductDialogUI.i(this.lqW).setVisibility(8);
      EmojiStoreV2SingleProductDialogUI.j(this.lqW);
      EmojiStoreV2SingleProductDialogUI.k(this.lqW).setEnabled(true);
      EmojiStoreV2SingleProductDialogUI.k(this.lqW).setTextColor(this.lqW.getResources().getColor(2131689778));
    }
    AppMethodBeat.o(53734);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductDialogUI.5
 * JD-Core Version:    0.7.0.1
 */