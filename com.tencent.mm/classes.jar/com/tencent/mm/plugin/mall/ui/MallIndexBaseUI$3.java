package com.tencent.mm.plugin.mall.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.r;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.wallet_core.a;

final class MallIndexBaseUI$3
  implements h.d
{
  MallIndexBaseUI$3(MallIndexBaseUI paramMallIndexBaseUI) {}
  
  public final void ca(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(43168);
    switch (paramInt2)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(43168);
      return;
      com.tencent.mm.plugin.report.service.h.qsU.e(11458, new Object[] { Integer.valueOf(2) });
      if (r.ZB())
      {
        a.b(this.ozC.getContext(), "PayURemittanceProcess", null);
        AppMethodBeat.o(43168);
        return;
      }
      a.b(this.ozC.getContext(), "RemittanceProcess", null);
      AppMethodBeat.o(43168);
      return;
      com.tencent.mm.plugin.report.service.h.qsU.e(11458, new Object[] { Integer.valueOf(3) });
      com.tencent.mm.pluginsdk.wallet.h.al(this.ozC, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexBaseUI.3
 * JD-Core Version:    0.7.0.1
 */