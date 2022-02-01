package com.tencent.mm.plugin.emoji.ui.v2;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.h.h;
import com.tencent.mm.plugin.emoji.model.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMTabView;

final class EmojiStoreV2TabView$2$1
  implements Runnable
{
  EmojiStoreV2TabView$2$1(EmojiStoreV2TabView.2 param2) {}
  
  public final void run()
  {
    AppMethodBeat.i(109372);
    try
    {
      if (EmojiStoreV2TabView.b(this.xYQ.xYP) == null) {
        break label121;
      }
      if (!Util.isNullOrNil(j.dzN().xMJ))
      {
        EmojiStoreV2TabView.b(this.xYQ.xYP).setText(j.dzN().xMJ);
        AppMethodBeat.o(109372);
        return;
      }
      if (j.dzN().xMI)
      {
        EmojiStoreV2TabView.b(this.xYQ.xYP).setText(h.h.emoji_store_main_tab_friends);
        AppMethodBeat.o(109372);
        return;
      }
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.emoji.EmojiStoreV2TabView", localException, "event update error", new Object[0]);
      AppMethodBeat.o(109372);
      return;
    }
    EmojiStoreV2TabView.b(this.xYQ.xYP).setText(h.h.emoji_store_main_tab);
    label121:
    AppMethodBeat.o(109372);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2TabView.2.1
 * JD-Core Version:    0.7.0.1
 */