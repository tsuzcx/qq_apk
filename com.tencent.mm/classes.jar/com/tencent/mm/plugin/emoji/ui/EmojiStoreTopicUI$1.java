package com.tencent.mm.plugin.emoji.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class EmojiStoreTopicUI$1
  implements MenuItem.OnMenuItemClickListener
{
  EmojiStoreTopicUI$1(EmojiStoreTopicUI paramEmojiStoreTopicUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(53491);
    ab.d("MicroMsg.emoji.EmojiStoreTopicUI", "on shard click.");
    if ((!bo.isNullOrNil(EmojiStoreTopicUI.a(this.lnJ))) && (!bo.isNullOrNil(EmojiStoreTopicUI.b(this.lnJ)))) {
      EmojiStoreTopicUI.c(this.lnJ);
    }
    for (;;)
    {
      AppMethodBeat.o(53491);
      return true;
      ab.i("MicroMsg.emoji.EmojiStoreTopicUI", "name or url is null.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiStoreTopicUI.1
 * JD-Core Version:    0.7.0.1
 */