package com.tencent.mm.plugin.emoji.ui;

import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.emoji.sync.a;
import com.tencent.mm.plugin.emoji.sync.c.a;
import com.tencent.mm.sdk.platformtools.ah;

final class EmojiCustomUI$15
  extends c.a
{
  EmojiCustomUI$15(EmojiCustomUI paramEmojiCustomUI) {}
  
  public final void aIr()
  {
    EmojiCustomUI.a(this.jcS, i.aHQ().aIm());
    if (EmojiCustomUI.f(this.jcS) != null) {
      EmojiCustomUI.f(this.jcS).sendEmptyMessage(1001);
    }
  }
  
  public final void aIs()
  {
    if (EmojiCustomUI.f(this.jcS) != null) {
      EmojiCustomUI.f(this.jcS).sendEmptyMessage(1002);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiCustomUI.15
 * JD-Core Version:    0.7.0.1
 */