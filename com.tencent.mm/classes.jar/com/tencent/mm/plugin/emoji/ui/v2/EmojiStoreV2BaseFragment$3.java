package com.tencent.mm.plugin.emoji.ui.v2;

import android.support.v4.app.FragmentActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class EmojiStoreV2BaseFragment$3
  implements MenuItem.OnMenuItemClickListener
{
  EmojiStoreV2BaseFragment$3(EmojiStoreV2BaseFragment paramEmojiStoreV2BaseFragment) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(53574);
    this.loZ.thisActivity().finish();
    AppMethodBeat.o(53574);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2BaseFragment.3
 * JD-Core Version:    0.7.0.1
 */