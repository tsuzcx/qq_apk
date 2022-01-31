package com.tencent.mm.plugin.emoji.ui.v2;

import com.tencent.mm.plugin.emoji.f.h;
import com.tencent.mm.ui.contact.LabelContainerView;
import com.tencent.mm.ui.contact.LabelContainerView.a;

final class EmojiStoreV2SingleProductUI$11
  implements LabelContainerView.a
{
  EmojiStoreV2SingleProductUI$11(EmojiStoreV2SingleProductUI paramEmojiStoreV2SingleProductUI) {}
  
  public final void aJG()
  {
    if (EmojiStoreV2SingleProductUI.f(this.jiI) != null) {
      EmojiStoreV2SingleProductUI.f(this.jiI).clearFocus();
    }
    EmojiStoreV2SingleProductUI.f(this.jiI).requestFocus();
    EmojiStoreV2SingleProductUI.f(this.jiI).setVisibility(8);
    EmojiStoreV2SingleProductUI localEmojiStoreV2SingleProductUI = this.jiI;
    if (EmojiStoreV2SingleProductUI.g(this.jiI)) {}
    for (boolean bool = true;; bool = false)
    {
      localEmojiStoreV2SingleProductUI.showOptionMenu(1001, bool);
      this.jiI.setMMTitle(f.h.emoji_store_product_title);
      return;
    }
  }
  
  public final void aJH()
  {
    this.jiI.XM();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductUI.11
 * JD-Core Version:    0.7.0.1
 */