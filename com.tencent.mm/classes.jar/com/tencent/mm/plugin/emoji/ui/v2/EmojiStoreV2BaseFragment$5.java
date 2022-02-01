package com.tencent.mm.plugin.emoji.ui.v2;

import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class EmojiStoreV2BaseFragment$5
  implements View.OnClickListener
{
  EmojiStoreV2BaseFragment$5(EmojiStoreV2BaseFragment paramEmojiStoreV2BaseFragment) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(109138);
    if (!this.piN.isScreenEnable())
    {
      AppMethodBeat.o(109138);
      return;
    }
    if (EmojiStoreV2BaseFragment.a(this.piN) != null) {
      EmojiStoreV2BaseFragment.a(this.piN).onMenuItemClick(null);
    }
    AppMethodBeat.o(109138);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2BaseFragment.5
 * JD-Core Version:    0.7.0.1
 */