package com.tencent.mm.plugin.emoji.ui.v2;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.emoji.f.a;

final class EmojiStoreV2SingleProductDialogUI$3
  implements View.OnClickListener
{
  EmojiStoreV2SingleProductDialogUI$3(EmojiStoreV2SingleProductDialogUI paramEmojiStoreV2SingleProductDialogUI) {}
  
  public final void onClick(View paramView)
  {
    this.jif.setResult(0);
    this.jif.finish();
    this.jif.overridePendingTransition(f.a.pop_in, f.a.pop_out);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductDialogUI.3
 * JD-Core Version:    0.7.0.1
 */