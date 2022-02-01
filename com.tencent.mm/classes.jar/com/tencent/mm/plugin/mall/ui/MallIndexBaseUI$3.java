package com.tencent.mm.plugin.mall.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.wallet_core.a;

final class MallIndexBaseUI$3
  implements h.d
{
  MallIndexBaseUI$3(MallIndexBaseUI paramMallIndexBaseUI) {}
  
  public final void ct(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(66066);
    switch (paramInt2)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(66066);
      return;
      h.wUl.f(11458, new Object[] { Integer.valueOf(2) });
      if (u.axL())
      {
        a.b(this.uCv.getContext(), "PayURemittanceProcess", null);
        AppMethodBeat.o(66066);
        return;
      }
      a.b(this.uCv.getContext(), "RemittanceProcess", null);
      AppMethodBeat.o(66066);
      return;
      h.wUl.f(11458, new Object[] { Integer.valueOf(3) });
      f.ar(this.uCv, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexBaseUI.3
 * JD-Core Version:    0.7.0.1
 */