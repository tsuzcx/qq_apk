package com.tencent.mm.plugin.emoji.ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.h.h;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.k;

final class EmojiAddCustomDialogUI$7
  implements Runnable
{
  EmojiAddCustomDialogUI$7(EmojiAddCustomDialogUI paramEmojiAddCustomDialogUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(270337);
    k.cZ(EmojiAddCustomDialogUI.a(this.xRw), MMApplicationContext.getContext().getString(h.h.app_added));
    AppMethodBeat.o(270337);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiAddCustomDialogUI.7
 * JD-Core Version:    0.7.0.1
 */