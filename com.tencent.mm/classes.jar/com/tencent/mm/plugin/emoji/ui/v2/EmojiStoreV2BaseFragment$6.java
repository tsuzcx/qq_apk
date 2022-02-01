package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.ui.EmojiMineUI;

final class EmojiStoreV2BaseFragment$6
  implements MenuItem.OnMenuItemClickListener
{
  EmojiStoreV2BaseFragment$6(EmojiStoreV2BaseFragment paramEmojiStoreV2BaseFragment) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(109139);
    Object localObject = new Intent();
    ((Intent)localObject).setClass(this.piN.thisActivity(), EmojiMineUI.class);
    paramMenuItem = this.piN;
    localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2BaseFragment$5", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramMenuItem, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2BaseFragment$5", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(109139);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2BaseFragment.6
 * JD-Core Version:    0.7.0.1
 */