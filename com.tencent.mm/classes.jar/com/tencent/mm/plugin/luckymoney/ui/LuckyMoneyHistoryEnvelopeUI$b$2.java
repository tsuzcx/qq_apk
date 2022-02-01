package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.a.a.a;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.view.recyclerview.i;

final class LuckyMoneyHistoryEnvelopeUI$b$2
  implements a.a
{
  LuckyMoneyHistoryEnvelopeUI$b$2(LuckyMoneyHistoryEnvelopeUI.b paramb, i parami) {}
  
  public final void eG(final boolean paramBoolean)
  {
    AppMethodBeat.i(266939);
    Log.i("MicroMsg.LuckyMoneyHistoryEnvelopeUI", "load ok: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    Runnable local1 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(277913);
        LuckyMoneyHistoryEnvelopeUI.b.2.this.EEG.RD(a.f.lmpi_inline_cover_loading_pb).setVisibility(8);
        if (!paramBoolean)
        {
          LuckyMoneyHistoryEnvelopeUI.b.2.this.EEG.RD(a.f.lmpi_white_cover_view).setVisibility(0);
          LuckyMoneyHistoryEnvelopeUI.b.2.this.EEG.RD(a.f.lmpi_loading_iv).setVisibility(0);
          LuckyMoneyHistoryEnvelopeUI.b.2.this.EEG.RD(a.f.lmpi_anim_pb).setVisibility(8);
          LuckyMoneyHistoryEnvelopeUI.b.2.this.EEG.RD(a.f.lmpi_retry_tv).setVisibility(0);
          AppMethodBeat.o(277913);
          return;
        }
        LuckyMoneyHistoryEnvelopeUI.b.2.this.EEG.RD(a.f.lmpi_white_cover_view).setVisibility(8);
        AppMethodBeat.o(277913);
      }
    };
    if (MMHandlerThread.isMainThread())
    {
      local1.run();
      AppMethodBeat.o(266939);
      return;
    }
    this.EEG.RD(a.f.lmpi_white_cover_view).post(local1);
    AppMethodBeat.o(266939);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyHistoryEnvelopeUI.b.2
 * JD-Core Version:    0.7.0.1
 */