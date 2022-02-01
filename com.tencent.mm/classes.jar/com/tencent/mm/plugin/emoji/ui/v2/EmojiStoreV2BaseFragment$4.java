package com.tencent.mm.plugin.emoji.ui.v2;

import android.support.v4.app.FragmentActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class EmojiStoreV2BaseFragment$4
  implements MenuItem.OnMenuItemClickListener
{
  EmojiStoreV2BaseFragment$4(EmojiStoreV2BaseFragment paramEmojiStoreV2BaseFragment) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(109137);
    this.pSS.thisActivity().finish();
    AppMethodBeat.o(109137);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2BaseFragment.4
 * JD-Core Version:    0.7.0.1
 */