package com.tencent.mm.plugin.emoji.ui.v2;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.contact.LabelContainerView;

final class EmojiStoreV2SingleProductUI$9
  implements MenuItem.OnMenuItemClickListener
{
  EmojiStoreV2SingleProductUI$9(EmojiStoreV2SingleProductUI paramEmojiStoreV2SingleProductUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(53753);
    boolean bool;
    if ((EmojiStoreV2SingleProductUI.f(this.lrz) != null) && (EmojiStoreV2SingleProductUI.f(this.lrz).getVisibility() == 0))
    {
      EmojiStoreV2SingleProductUI.f(this.lrz).setVisibility(8);
      paramMenuItem = this.lrz;
      if (EmojiStoreV2SingleProductUI.g(this.lrz))
      {
        bool = true;
        paramMenuItem.showOptionMenu(1001, bool);
        this.lrz.setMMTitle(2131299222);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(53753);
      return false;
      bool = false;
      break;
      this.lrz.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductUI.9
 * JD-Core Version:    0.7.0.1
 */