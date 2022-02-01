package com.tencent.mm.plugin.emoji.ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.h.h;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.k;

final class EmojiAddCustomDialogUI$6
  implements Runnable
{
  EmojiAddCustomDialogUI$6(EmojiAddCustomDialogUI paramEmojiAddCustomDialogUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(270335);
    k.cZ(EmojiAddCustomDialogUI.a(this.xRw), MMApplicationContext.getContext().getString(h.h.emoji_add_failed));
    AppMethodBeat.o(270335);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiAddCustomDialogUI.6
 * JD-Core Version:    0.7.0.1
 */