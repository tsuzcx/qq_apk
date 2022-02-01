package com.tencent.mm.plugin.emoji.ui.v2;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.model.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
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
      if (EmojiStoreV2TabView.b(this.oIp.oIo) == null) {
        break label119;
      }
      if (!bt.isNullOrNil(d.bUR().owU))
      {
        EmojiStoreV2TabView.b(this.oIp.oIo).setText(d.bUR().owU);
        AppMethodBeat.o(109372);
        return;
      }
      if (d.bUR().owT)
      {
        EmojiStoreV2TabView.b(this.oIp.oIo).setText(2131758334);
        AppMethodBeat.o(109372);
        return;
      }
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.emoji.EmojiStoreV2TabView", localException, "event update error", new Object[0]);
      AppMethodBeat.o(109372);
      return;
    }
    EmojiStoreV2TabView.b(this.oIp.oIo).setText(2131758333);
    label119:
    AppMethodBeat.o(109372);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2TabView.2.1
 * JD-Core Version:    0.7.0.1
 */