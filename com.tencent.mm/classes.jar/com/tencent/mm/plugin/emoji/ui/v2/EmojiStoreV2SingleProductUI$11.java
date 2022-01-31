package com.tencent.mm.plugin.emoji.ui.v2;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.contact.LabelContainerView;
import com.tencent.mm.ui.contact.LabelContainerView.a;

final class EmojiStoreV2SingleProductUI$11
  implements LabelContainerView.a
{
  EmojiStoreV2SingleProductUI$11(EmojiStoreV2SingleProductUI paramEmojiStoreV2SingleProductUI) {}
  
  public final void bno()
  {
    AppMethodBeat.i(53755);
    if (EmojiStoreV2SingleProductUI.f(this.lrz) != null) {
      EmojiStoreV2SingleProductUI.f(this.lrz).clearFocus();
    }
    EmojiStoreV2SingleProductUI.f(this.lrz).requestFocus();
    EmojiStoreV2SingleProductUI.f(this.lrz).setVisibility(8);
    EmojiStoreV2SingleProductUI localEmojiStoreV2SingleProductUI = this.lrz;
    if (EmojiStoreV2SingleProductUI.g(this.lrz)) {}
    for (boolean bool = true;; bool = false)
    {
      localEmojiStoreV2SingleProductUI.showOptionMenu(1001, bool);
      this.lrz.setMMTitle(2131299222);
      AppMethodBeat.o(53755);
      return;
    }
  }
  
  public final void bnp()
  {
    AppMethodBeat.i(53756);
    this.lrz.hideVKB();
    AppMethodBeat.o(53756);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductUI.11
 * JD-Core Version:    0.7.0.1
 */