package com.tencent.mm.plugin.emoji.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.sync.EmojiSyncManager.b;
import com.tencent.mm.emoji.sync.c;
import com.tencent.mm.sdk.platformtools.ak;

final class EmojiCustomUI$15
  implements c
{
  EmojiCustomUI$15(EmojiCustomUI paramEmojiCustomUI) {}
  
  public final void a(EmojiSyncManager.b paramb)
  {
    AppMethodBeat.i(53314);
    EmojiCustomUI.a(this.llF, paramb);
    if (EmojiCustomUI.g(this.llF) != null) {
      EmojiCustomUI.g(this.llF).sendEmptyMessage(1001);
    }
    AppMethodBeat.o(53314);
  }
  
  public final void ye()
  {
    AppMethodBeat.i(53313);
    if (EmojiCustomUI.g(this.llF) != null) {
      EmojiCustomUI.g(this.llF).sendEmptyMessage(1002);
    }
    AppMethodBeat.o(53313);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiCustomUI.15
 * JD-Core Version:    0.7.0.1
 */