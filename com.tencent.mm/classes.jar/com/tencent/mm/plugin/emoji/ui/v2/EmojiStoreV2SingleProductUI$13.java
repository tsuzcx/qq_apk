package com.tencent.mm.plugin.emoji.ui.v2;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
    AppMethodBeat.i(53759);
    if (EmojiStoreV2SingleProductUI.f(this.lrz) != null)
    {
      EmojiStoreV2SingleProductUI.f(this.lrz).setVisibility(0);
      paramMenuItem = new ArrayList();
      paramMenuItem.add(EmojiStoreV2SingleProductUI.l(this.lrz));
      EmojiStoreV2SingleProductUI.m(this.lrz).a(paramMenuItem, EmojiStoreV2SingleProductUI.n(this.lrz));
      this.lrz.setMMTitle(2131299246);
      this.lrz.showOptionMenu(1001, false);
      h.qsU.kvStat(12788, "1");
    }
    AppMethodBeat.o(53759);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductUI.13
 * JD-Core Version:    0.7.0.1
 */