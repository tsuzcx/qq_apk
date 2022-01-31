package com.tencent.mm.plugin.emoji.ui.v2;

import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cn.d;
import com.tencent.mm.sdk.platformtools.ab;

final class EmojiStoreV2UI$4
  implements MessageQueue.IdleHandler
{
  EmojiStoreV2UI$4(EmojiStoreV2UI paramEmojiStoreV2UI) {}
  
  public final boolean queueIdle()
  {
    AppMethodBeat.i(53819);
    ab.i("MicroMsg.emoji.EmojiStoreV2UI", "now try to activity the tools process");
    d.aNX();
    AppMethodBeat.o(53819);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2UI.4
 * JD-Core Version:    0.7.0.1
 */