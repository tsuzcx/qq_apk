package com.tencent.mm.plugin.emoji.ui;

import android.os.Message;
import android.view.View;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.emoji.sync.BKGLoaderManager;
import com.tencent.mm.plugin.emoji.sync.a;
import com.tencent.mm.plugin.emoji.sync.a.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

final class EmojiCustomUI$18
  extends ah
{
  EmojiCustomUI$18(EmojiCustomUI paramEmojiCustomUI) {}
  
  public final void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      y.e("MicroMsg.emoji.EmojiCustomUI", "unknow Msg");
    case 1001: 
    case 1002: 
      do
      {
        return;
        EmojiCustomUI.g(this.jcS);
        return;
        i.aHQ();
      } while (!BKGLoaderManager.aHa());
      if (i.aHQ().aIm() == a.a.jap)
      {
        EmojiCustomUI.a(this.jcS, true);
        return;
      }
      EmojiCustomUI.a(this.jcS, false);
      return;
    case 1003: 
      EmojiCustomUI.h(this.jcS).setVisibility(8);
      EmojiCustomUI.e(this.jcS).notifyDataSetChanged();
      return;
    }
    if (EmojiCustomUI.e(this.jcS) != null)
    {
      EmojiCustomUI.e(this.jcS).aJc();
      EmojiCustomUI.e(this.jcS).notifyDataSetChanged();
    }
    EmojiCustomUI.aJa();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiCustomUI.18
 * JD-Core Version:    0.7.0.1
 */