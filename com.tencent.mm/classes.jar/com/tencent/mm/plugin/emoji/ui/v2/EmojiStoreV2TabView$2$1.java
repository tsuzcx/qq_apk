package com.tencent.mm.plugin.emoji.ui.v2;

import com.tencent.mm.plugin.emoji.f.h;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.at;
import com.tencent.mm.ui.MMTabView;

final class EmojiStoreV2TabView$2$1
  implements Runnable
{
  EmojiStoreV2TabView$2$1(EmojiStoreV2TabView.2 param2) {}
  
  public final void run()
  {
    try
    {
      if (EmojiStoreV2TabView.b(this.jje.jjd) != null)
      {
        if (i.getEmojiStorageMgr().cuS())
        {
          EmojiStoreV2TabView.b(this.jje.jjd).setText(f.h.emoji_store_main_tab_friends);
          return;
        }
        EmojiStoreV2TabView.b(this.jje.jjd).setText(f.h.emoji_store_main_tab);
        return;
      }
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.emoji.EmojiStoreV2TabView", localException, "event update error", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2TabView.2.1
 * JD-Core Version:    0.7.0.1
 */