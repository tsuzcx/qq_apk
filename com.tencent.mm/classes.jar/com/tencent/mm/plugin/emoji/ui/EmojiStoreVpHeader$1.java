package com.tencent.mm.plugin.emoji.ui;

import com.tencent.mm.plugin.emoji.a.i;

final class EmojiStoreVpHeader$1
  implements Runnable
{
  EmojiStoreVpHeader$1(EmojiStoreVpHeader paramEmojiStoreVpHeader) {}
  
  public final void run()
  {
    if ((EmojiStoreVpHeader.a(this.jfc) != null) && (EmojiStoreVpHeader.b(this.jfc) != null)) {
      EmojiStoreVpHeader.a(this.jfc).setData(EmojiStoreVpHeader.b(this.jfc));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiStoreVpHeader.1
 * JD-Core Version:    0.7.0.1
 */