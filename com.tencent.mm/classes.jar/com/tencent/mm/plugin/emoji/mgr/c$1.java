package com.tencent.mm.plugin.emoji.mgr;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.emotion.EmojiInfo;

final class c$1
  implements Runnable
{
  c$1(c paramc, EmojiInfo paramEmojiInfo) {}
  
  public final void run()
  {
    AppMethodBeat.i(108412);
    if ((this.xKU != null) && (!this.xKU.kLZ()))
    {
      Log.i("MicroMsg.emoji.EmojiFileCheckerMgr", "chatting emoji broken. try to recover:%s", new Object[] { this.xKU.getMd5() });
      c.b(this.xKU, true);
    }
    AppMethodBeat.o(108412);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.mgr.c.1
 * JD-Core Version:    0.7.0.1
 */