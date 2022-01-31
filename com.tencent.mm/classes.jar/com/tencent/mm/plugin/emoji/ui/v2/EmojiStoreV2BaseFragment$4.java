package com.tencent.mm.plugin.emoji.ui.v2;

import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class EmojiStoreV2BaseFragment$4
  implements View.OnClickListener
{
  EmojiStoreV2BaseFragment$4(EmojiStoreV2BaseFragment paramEmojiStoreV2BaseFragment) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(53575);
    if (!this.loZ.isScreenEnable())
    {
      AppMethodBeat.o(53575);
      return;
    }
    if (EmojiStoreV2BaseFragment.a(this.loZ) != null) {
      EmojiStoreV2BaseFragment.a(this.loZ).onMenuItemClick(null);
    }
    AppMethodBeat.o(53575);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2BaseFragment.4
 * JD-Core Version:    0.7.0.1
 */