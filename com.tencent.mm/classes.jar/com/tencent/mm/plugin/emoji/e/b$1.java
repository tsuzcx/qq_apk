package com.tencent.mm.plugin.emoji.e;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.emotion.EmojiInfo;

final class b$1
  implements Runnable
{
  b$1(b paramb, EmojiInfo paramEmojiInfo) {}
  
  public final void run()
  {
    if ((this.iWy != null) && (!this.iWy.cwK()))
    {
      y.i("MicroMsg.emoji.EmojiFileCheckerMgr", "chatting emoji broken. try to recover:%s", new Object[] { this.iWy.Wv() });
      b.a(this.iWy, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.b.1
 * JD-Core Version:    0.7.0.1
 */