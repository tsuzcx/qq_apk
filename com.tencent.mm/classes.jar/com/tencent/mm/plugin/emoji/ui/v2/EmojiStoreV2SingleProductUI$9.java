package com.tencent.mm.plugin.emoji.ui.v2;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.emoji.f.h;
import com.tencent.mm.ui.contact.LabelContainerView;

final class EmojiStoreV2SingleProductUI$9
  implements MenuItem.OnMenuItemClickListener
{
  EmojiStoreV2SingleProductUI$9(EmojiStoreV2SingleProductUI paramEmojiStoreV2SingleProductUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    if ((EmojiStoreV2SingleProductUI.f(this.jiI) != null) && (EmojiStoreV2SingleProductUI.f(this.jiI).getVisibility() == 0))
    {
      EmojiStoreV2SingleProductUI.f(this.jiI).setVisibility(8);
      paramMenuItem = this.jiI;
      if (EmojiStoreV2SingleProductUI.g(this.jiI)) {}
      for (boolean bool = true;; bool = false)
      {
        paramMenuItem.showOptionMenu(1001, bool);
        this.jiI.setMMTitle(f.h.emoji_store_product_title);
        return false;
      }
    }
    this.jiI.finish();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductUI.9
 * JD-Core Version:    0.7.0.1
 */