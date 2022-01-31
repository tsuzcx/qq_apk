package com.tencent.mm.plugin.emoji.ui.v2;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.at;
import com.tencent.mm.ui.MMTabView;

final class EmojiStoreV2TabView$2$1
  implements Runnable
{
  EmojiStoreV2TabView$2$1(EmojiStoreV2TabView.2 param2) {}
  
  public final void run()
  {
    AppMethodBeat.i(53799);
    try
    {
      if (EmojiStoreV2TabView.b(this.lrV.lrU) != null)
      {
        if (i.getEmojiStorageMgr().dxv())
        {
          EmojiStoreV2TabView.b(this.lrV.lrU).setText(2131299208);
          AppMethodBeat.o(53799);
          return;
        }
        EmojiStoreV2TabView.b(this.lrV.lrU).setText(2131299207);
      }
      AppMethodBeat.o(53799);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.emoji.EmojiStoreV2TabView", localException, "event update error", new Object[0]);
      AppMethodBeat.o(53799);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2TabView.2.1
 * JD-Core Version:    0.7.0.1
 */