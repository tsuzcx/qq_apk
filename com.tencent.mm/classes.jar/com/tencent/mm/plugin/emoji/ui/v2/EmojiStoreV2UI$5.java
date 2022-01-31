package com.tencent.mm.plugin.emoji.ui.v2;

import android.os.MessageQueue.IdleHandler;
import com.tencent.mm.cl.b;
import com.tencent.mm.sdk.platformtools.y;

final class EmojiStoreV2UI$5
  implements MessageQueue.IdleHandler
{
  EmojiStoreV2UI$5(EmojiStoreV2UI paramEmojiStoreV2UI) {}
  
  public final boolean queueIdle()
  {
    y.i("MicroMsg.emoji.EmojiStoreV2UI", "now try to activity the tools process");
    b.afs("com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2UI.5
 * JD-Core Version:    0.7.0.1
 */