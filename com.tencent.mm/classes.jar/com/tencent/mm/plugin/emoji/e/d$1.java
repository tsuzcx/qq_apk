package com.tencent.mm.plugin.emoji.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.emotion.EmojiInfo;

final class d$1
  implements Runnable
{
  d$1(d paramd, EmojiInfo paramEmojiInfo) {}
  
  public final void run()
  {
    AppMethodBeat.i(52849);
    if ((this.lfG != null) && (!this.lfG.dzn()))
    {
      ab.i("MicroMsg.emoji.EmojiFileCheckerMgr", "chatting emoji broken. try to recover:%s", new Object[] { this.lfG.Al() });
      d.a(this.lfG, true);
    }
    AppMethodBeat.o(52849);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.d.1
 * JD-Core Version:    0.7.0.1
 */