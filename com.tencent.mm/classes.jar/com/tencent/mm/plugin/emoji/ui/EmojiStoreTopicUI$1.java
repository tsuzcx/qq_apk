package com.tencent.mm.plugin.emoji.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class EmojiStoreTopicUI$1
  implements MenuItem.OnMenuItemClickListener
{
  EmojiStoreTopicUI$1(EmojiStoreTopicUI paramEmojiStoreTopicUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    y.d("MicroMsg.emoji.EmojiStoreTopicUI", "on shard click.");
    if ((!bk.bl(EmojiStoreTopicUI.a(this.jeT))) && (!bk.bl(EmojiStoreTopicUI.b(this.jeT)))) {
      EmojiStoreTopicUI.c(this.jeT);
    }
    for (;;)
    {
      return true;
      y.i("MicroMsg.emoji.EmojiStoreTopicUI", "name or url is null.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiStoreTopicUI.1
 * JD-Core Version:    0.7.0.1
 */