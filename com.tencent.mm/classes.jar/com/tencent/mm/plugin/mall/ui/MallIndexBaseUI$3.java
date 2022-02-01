package com.tencent.mm.plugin.mall.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.ui.base.k.e;
import com.tencent.mm.wallet_core.a;

final class MallIndexBaseUI$3
  implements k.e
{
  MallIndexBaseUI$3(MallIndexBaseUI paramMallIndexBaseUI) {}
  
  public final void onClick(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(66066);
    switch (paramInt2)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(66066);
      return;
      h.OAn.b(11458, new Object[] { Integer.valueOf(2) });
      if (z.bBi())
      {
        a.b(this.KLg.getContext(), "PayURemittanceProcess", null);
        AppMethodBeat.o(66066);
        return;
      }
      a.b(this.KLg.getContext(), "RemittanceProcess", null);
      AppMethodBeat.o(66066);
      return;
      h.OAn.b(11458, new Object[] { Integer.valueOf(3) });
      f.bo(this.KLg, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexBaseUI.3
 * JD-Core Version:    0.7.0.1
 */