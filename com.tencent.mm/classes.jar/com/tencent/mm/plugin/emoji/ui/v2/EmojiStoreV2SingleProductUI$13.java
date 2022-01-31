package com.tencent.mm.plugin.emoji.ui.v2;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.emoji.f.h;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.ui.base.MMTagPanel;
import com.tencent.mm.ui.contact.LabelContainerView;
import java.util.ArrayList;

final class EmojiStoreV2SingleProductUI$13
  implements MenuItem.OnMenuItemClickListener
{
  EmojiStoreV2SingleProductUI$13(EmojiStoreV2SingleProductUI paramEmojiStoreV2SingleProductUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    if (EmojiStoreV2SingleProductUI.f(this.jiI) != null)
    {
      EmojiStoreV2SingleProductUI.f(this.jiI).setVisibility(0);
      paramMenuItem = new ArrayList();
      paramMenuItem.add(EmojiStoreV2SingleProductUI.l(this.jiI));
      EmojiStoreV2SingleProductUI.m(this.jiI).a(paramMenuItem, EmojiStoreV2SingleProductUI.n(this.jiI));
      this.jiI.setMMTitle(f.h.emoji_store_seach_by_tag);
      this.jiI.showOptionMenu(1001, false);
      h.nFQ.aC(12788, "1");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductUI.13
 * JD-Core Version:    0.7.0.1
 */